package fr.inria.diverse.dmgen.ui.launch

import com.google.inject.Injector
import fr.inria.diverse.dmgen.DMGenStandaloneSetupGenerated
import fr.inria.diverse.dmgen.ui.internal.DmgenActivator
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.util.Collections
import java.util.Map.Entry
import java.util.concurrent.CountDownLatch
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.LocalFileSystem
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hdfs.DistributedFileSystem
import org.apache.spark.launcher.SparkAppHandle
import org.apache.spark.launcher.SparkLauncher
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.debug.core.ILaunch
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.model.LaunchConfigurationDelegate
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.apache.log4j.Logger
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.emf.ecore.util.EcoreUtil

class DMGenLaunchConfiguration extends LaunchConfigurationDelegate {
	
	
	val LOG = Logger.getLogger(DMGenLaunchConfiguration)
	
	val Injector injector = new DMGenStandaloneSetupGenerated()
            .createInjectorAndDoEMFRegistration();
    
	val  XtextResourceSet resourceSet = injector
    		.getInstance(XtextResourceSet);
    
    
	var String sparkMaster
	var String hbaseMaster
	var String hdfsMaster = "hdfs://dmhadoop:8020"
	var String metamodel
	var String sparkAppId
	var String sparkDeployMode = "cluster"

//	
	var Configuration fsConfiguration
//	
	val SPARK_TEMP_DIRECTORY = "/temp/spark/generator/resource/"
	var sparkHome = "resources/spark"
	var yarnConf = ""
//	
	
	override launch(ILaunchConfiguration configuration, 
						String mode, 
						ILaunch launch, 
						IProgressMonitor monitor
	) throws CoreException {
	
	// Initialiazing variables for Spark Context
	initializeFromConfiguration(configuration)
	// 		
		
	val sparkLauncher = new SparkLauncher()
	val  handle = sparkLauncher.setAppResource(DMGenConfigurationAttributes.SPARK_APP_RESOURCE)
							    .setMainClass(DMGenConfigurationAttributes.SPARK_MAIN_CLASS)
							    .setMaster(sparkMaster)
							    .setDeployMode(sparkDeployMode)
							    .setSparkHome(sparkHome)
							    .startApplication()	
 
	val countDownLatch = new CountDownLatch(1) 
	handle.addListener(new SparkAppHandle.Listener() {
		    override void stateChanged(SparkAppHandle handle) {
		        if (handle.getState().isFinal()) {
		            countDownLatch.countDown()
		        }
		    }
		    override void infoChanged(SparkAppHandle handle) {}
		})
	countDownLatch.await()
		 
	System.out.println(handle.getAppId() + " ended in state " + handle.getState())
		
	val attribute = configuration.getAttribute(DMGenConfigurationAttributes.SPARK_HOST_NAME, DMGenConfigurationAttributes.SPARK_HOST_DEFAULT)
	println(attribute)
		
	}
	
	def initializeFromConfiguration(ILaunchConfiguration configuration) throws IOException, CoreException {
		
		// fetching attributes from the launch configuration
		sparkMaster = configuration.getAttribute(DMGenConfigurationAttributes.SPARK_HOST_NAME,DMGenConfigurationAttributes.SPARK_HOST_DEFAULT)
		hbaseMaster = configuration.getAttribute(DMGenConfigurationAttributes.HBASE_HOST_NAME, DMGenConfigurationAttributes.HBASE_HOST_NAME_DEFAULT)	
		metamodel = configuration.getAttribute(DMGenConfigurationAttributes.METAMODEL_NAME, "")
		val envMap = configuration.getAttribute("org.eclipse.debug.core.environmentVariables", Collections.EMPTY_MAP)
		
		for (Entry<String, String> entry : envMap.entrySet) {
			if (entry.key == "SPARK_HOME") sparkHome = entry.value as String
			else if (entry.key == "HADOOP_CONF_DIR") yarnConf = entry.value as String
		}

		// copying the metamodel file together with the sparkApp into HDFS
		
		// configuring HDFS
		fsConfiguration = new Configuration() 
			fsConfiguration.set("fs.defaultFS", hdfsMaster) 
			fsConfiguration.set("fs.hdfs.impl", DistributedFileSystem.name)
	   		fsConfiguration.set("fs.file.impl",LocalFileSystem.name)
	   		fsConfiguration.set("dfs.permissions.enabled","false")
	   		
		val fs = FileSystem.get(fsConfiguration) 
		
		// fetching and copying sparkApp
		val sparkApp = new org.eclipse.core.runtime.Path("resources/"+DMGenConfigurationAttributes.SPARK_APP_RESOURCE) as IPath
		val sparkAppURL = FileLocator.find(DmgenActivator.instance.bundle, sparkApp, null) 
		sparkAppId =  new File(FileLocator.toFileURL(sparkAppURL).toURI()).getAbsolutePath() 
		var localPath = new Path(sparkAppId)
		var remotePath = new Path(SPARK_TEMP_DIRECTORY+"/"+DMGenConfigurationAttributes.SPARK_APP_RESOURCE)
		fs.copyFromLocalFile(false, true, localPath, remotePath)	
		
								
		// fetching and copying the metamodel file 
		val metamodelURI = URI.createURI(metamodel)
		val tmpMetamodelURI = copyMetamodelInTmpFile(metamodelURI)
		localPath =  new Path(tmpMetamodelURI.toFileString)
		remotePath = new Path(SPARK_TEMP_DIRECTORY+"/"+"metamodel.ecore")
		fs.copyFromLocalFile(false, true, localPath, remotePath)
		
		val editor = EditorUtils.getActiveXtextEditor()
			
		if (editor != null) {
				
			val file  =  ( editor.getEditorInput() as FileEditorInput).getFile();
			try{
				val outUri = exportXMI(file.fullPath.toOSString)
				localPath = new Path(outUri.toFileString)
				remotePath = new Path(SPARK_TEMP_DIRECTORY+"/"+"module.xmi")
				fs.copyFromLocalFile(false, true, localPath, remotePath)
			} catch (IOException e) {
					LOG.error(String.format("The file {0} is not found", file.fullPath.toOSString()), e)
			}
			 catch (Exception e) {
				LOG.error(e.message, e);
			}
		}
	}
	
	def URI copyMetamodelInTmpFile(URI metamodelURI) throws IOException{
		
		// Instantitating source and target URIs		
		val tempfolder = Files.createTempDirectory("sparkGen")
		//val tempFile = new File(tempfolder.toAbsolutePath+"/"+metamodelURI.lastSegment)
		val metamodelTmpURI = URI.createFileURI(tempfolder.toAbsolutePath+"/"+metamodelURI.lastSegment)
		
		// creating the resources 
		
		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put("ecore", new EcoreResourceFactoryImpl)
		
		// loading the original resource
		val metamodelResource = resourceSet.getResource(metamodelURI, true)
		metamodelResource.load(Collections.EMPTY_MAP)
		
		//creating and loading the tempResource 
		val tempResource = resourceSet.createResource(metamodelTmpURI)
		
		//copying All content and saving the resource 
		tempResource.contents.addAll(metamodelResource.contents)
		tempResource.save(Collections.EMPTY_MAP)
		
		return metamodelTmpURI
	}
	
	def URI exportXMI(String osInPath) throws IOException {
		// loading the dmgen resource
	    val inURI = URI.createURI(osInPath);
	    val xtextResource = resourceSet.getResource(inURI, true);
	    
	    val tempfolder = Files.createTempDirectory("sparkGen")
		//val tempFile = new File(tempfolder.toAbsolutePath+"/"+metamodelURI.lastSegment)
		val outURI = URI.createFileURI(tempfolder.toAbsolutePath+"/"+"module.xmi")
		
	    EcoreUtil.resolveAll(xtextResource);
		// converting the resource to standard xmi format
	    val xmiResource = resourceSet
	            .createResource(outURI);
	    xmiResource.getContents().addAll(xtextResource.contents);
	 
	    xmiResource.save(null);
	    
	    return outURI;
	}
									
}
