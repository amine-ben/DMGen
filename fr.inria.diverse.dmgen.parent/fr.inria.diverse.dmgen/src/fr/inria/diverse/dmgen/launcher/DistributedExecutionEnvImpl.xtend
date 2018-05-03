package fr.inria.diverse.dmgen.launcher

import java.io.IOException
import java.net.URL
import java.nio.file.Files
import java.util.Collections
import java.util.concurrent.CountDownLatch
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.LocalFileSystem
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hdfs.DistributedFileSystem
import org.apache.spark.launcher.SparkAppHandle
import org.apache.spark.launcher.SparkLauncher
import org.eclipse.core.internal.runtime.Activator
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.FileLocator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl

class DistributedExecutionEnvImpl extends ExecutionEnvImpl {
	// application arguments     
	var String sparkMaster

	var String fsMaster

	// spark configuration variables
	// var String sparkDeployMode = "cluster"
	var sparkHomePath = "resources/spark"
	var yarnConfPath = "resource/spark/yarnConf"

	// HFDS configuration Env
	var Configuration fsConfiguration


	
	def setSparkMaster(String sparkMaster) {
		this.sparkMaster = sparkMaster
	}

	def setFsMaster(String fsMaster) {
		this.fsMaster = fsMaster
	}
	/**
	 * Creates a {@link SparkLauncher} and launches the generation  
	 */
	override launch() throws CoreException {
		// setting up the execution environment the execution environment after setting up 
		setupEnv
		// creating a sparkLauncher using the environment variables from 
		val sparkLauncher = new SparkLauncher(#{DMGenConstants.YARN_CONF_DIR -> yarnConfPath})

		// add application arguments to spark launcher
		sparkLauncher.addAppArgs(
			#[HDFS_MASTER, fsMaster, 
				METAMODEL_URL, metamodelURL, 
				DMGEN_URL, dmgenURL, 
				E_PACKAGE_CLASS, ePackageImpl,
				HBASE_MASTER, basePath ])

		val handle = sparkLauncher.setAppResource(DMGenConstants.SPARK_APP_RESOURCE)
								  .setMainClass(DMGenConstants.SPARK_MAIN_CLASS)
								  .setMaster(sparkMaster)// .setDeployMode(sparkDeployMode)
								  .setSparkHome(sparkHomePath)
								  .setVerbose(true)
								  .setConf(SparkLauncher.EXECUTOR_CORES, executors)
								  .startApplication

		val countDownLatch = new CountDownLatch(1)
		handle.addListener(new SparkAppHandle.Listener {
			override void stateChanged(SparkAppHandle handle) {
				if (handle.state.isFinal) {
					countDownLatch.countDown
				}
			}

			override void infoChanged(SparkAppHandle handle) {
				LOG.info(handle.state)
			}
		})

		countDownLatch.await

		System.out.println(handle.appId + " ended in state " + handle.state)
	}

	/**
	 * Creates application arguments 
	 */
	protected def String[] createAppArgs() {
		return #[HDFS_MASTER, fsMaster, 
					METAMODEL_URL, metamodelURL, 
					DMGEN_URL, dmgenURL, 
					E_PACKAGE_CLASS, ePackageImpl, 
					HBASE_MASTER, basePath]
	}

	override setupEnv() throws IOException, CoreException {

		// copying the metamodel file together with the sparkApp into HDFS	
		// configuring HDFS
		fsConfiguration = new Configuration()
		fsConfiguration.set("fs.defaultFS", fsMaster)
		fsConfiguration.set("fs.hdfs.impl", DistributedFileSystem.name)
		fsConfiguration.set("fs.file.impl", LocalFileSystem.name)
		fsConfiguration.set("dfs.permissions.enabled", "false")

		val fs = FileSystem.get(fsConfiguration)
		// fetching and copying sparkApp
		// val sparkApp = new org.eclipse.core.runtime.Path("/resources/"+DMGenConstants.SPARK_APP_RESOURCE) as IPath
		val sparkAppFile = FileLocator.toFileURL(
			new URL(Activator.^default.getBundle("fr.inria.diverse.dmgen.ui").getEntry("/resources"),
				DMGenConstants.SPARK_APP_RESOURCE))

		fs.copyFromLocalFile(false, true, new Path(sparkAppFile.toString),
			new Path(SPARK_TEMP_DIRECTORY + "/" + DMGenConstants.SPARK_APP_RESOURCE))

		// fetching and copying the metamodel file 
		val metamodelURI = URI.createURI(metamodelURL)
		val tmpMetamodelURI = copyMetamodelInTmpFile(metamodelURI)
		metamodelURL = "hdfs://" + SPARK_TEMP_DIRECTORY + "/" + "metamodel.ecore"
		fs.copyFromLocalFile(false, true, new Path(tmpMetamodelURI.toFileString),
			new Path(SPARK_TEMP_DIRECTORY + "/" + "metamodel.ecore"))

		val dmgenURI = URI.createURI(dmgenURL)
		dmgenURL = "hdfs://" + SPARK_TEMP_DIRECTORY + "/" + "module.xmi"
		fs.copyFromLocalFile(false, true, new Path(dmgenURI.toString),
			new Path(SPARK_TEMP_DIRECTORY + "/" + "module.xmi"))
	}

	/**
	 * @param <code>metamodelURI</code> 
	 * 		  The {@link URI} of the metamodel to copy in HDFS
	 */
	def URI copyMetamodelInTmpFile(URI metamodelURI) throws IOException {

		// Instantiating source and target URIs		
		val tempfolder = Files.createTempDirectory("sparkGen")
		// val tempFile = new File(tempfolder.toAbsolutePath+"/"+metamodelURI.lastSegment)
		val metamodelTmpURI = URI.createFileURI(tempfolder.toAbsolutePath + "/" + metamodelURI.lastSegment)

		// creating the resources 		
		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put("ecore", new EcoreResourceFactoryImpl)

		// loading the original resource
		val metamodelResource = resourceSet.getResource(metamodelURI, true)
		metamodelResource.load(Collections.EMPTY_MAP)

		// creating and loading the tempResource 
		val tempResource = resourceSet.createResource(metamodelTmpURI)

		// copying All content and saving the resource 
		tempResource.contents.addAll(metamodelResource.contents)
		tempResource.save(Collections.EMPTY_MAP)

		return metamodelTmpURI
	}
	

}
