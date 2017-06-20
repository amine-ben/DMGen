package fr.inria.diverse.dmgen.ui.launch

import org.eclipse.debug.core.model.LaunchConfigurationDelegate
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunch
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.CoreException
import org.apache.spark.launcher.SparkLauncher
import java.util.concurrent.CountDownLatch
import org.apache.spark.launcher.SparkAppHandle
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.Platform
import fr.inria.diverse.dmgen.ui.internal.DmgenActivator

class DMGenLaunchConfiguration extends LaunchConfigurationDelegate {
	
	var String sparkMaster
	var String hbaseMaster
	var String hdfsMaster="hdfs://dmhadoop:8020"
	var String metamodel
	var String sparkAppId
	
	var Configuration fsConfiguration
	
	val SPARK_TEMP_DIRECTORY = "/temp/spark/generator/resources"
	
	
	
	
	override launch(ILaunchConfiguration configuration, 
						String mode, 
						ILaunch launch, 
						IProgressMonitor monitor
	) throws CoreException {
	
	initializeFromConfiguration(configuration)
		
	val sparkLauncher = new SparkLauncher()
	val  handle = sparkLauncher
    .setAppResource(DMGenConfigurationAttributes.SPARK_APP_RESOURCE)
    .setMainClass(DMGenConfigurationAttributes.SPARK_MAIN_CLASS)
    .setMaster(sparkMaster)
    .setConf(DMGenConfigurationAttributes.HBASE_HOST_NAME, hbaseMaster)
    .setConf(DMGenConfigurationAttributes.METAMODEL_NAME, metamodel)
    .setConf("fs.defaultFS", hdfsMaster)
    //.addAppArgs(planFileOnHdfs)
    .startApplication();
 
 	
 
	val countDownLatch = new CountDownLatch(1);
	handle.addListener(new SparkAppHandle.Listener() {
	    override void stateChanged(SparkAppHandle handle) {
	        if (handle.getState().isFinal()) {
	            countDownLatch.countDown();
	        }
	    }
	    override void infoChanged(SparkAppHandle handle) {
   	 }
	})
		countDownLatch.await()
		 
		System.out.println(handle.getAppId() + " ended in state " + handle.getState())
		
		val attribute = configuration.getAttribute(DMGenConfigurationAttributes.SPARK_HOST_NAME, DMGenConfigurationAttributes.SPARK_HOST_DEFAULT)
		println(attribute)
		
	}
	
	def initializeFromConfiguration(ILaunchConfiguration configuration) {
		
		fsConfiguration = new Configuration();
		fsConfiguration.set("fs.defaultFS", hdfsMaster);
		val fs = FileSystem.get(fsConfiguration);
		
		val sparkApp = new org.eclipse.core.runtime.Path("resources/"+DMGenConfigurationAttributes.SPARK_APP_RESOURCE) as IPath
		val fileURL = FileLocator.find(DmgenActivator.instance.bundle, sparkApp, null);
		sparkAppId =  new java.io.File(FileLocator.toFileURL(fileURL).toURI()).getAbsolutePath();
		
		fs.copyFromLocalFile(false, 
								true,
								#{new Path(sparkAppId)}, 
								new Path(SPARK_TEMP_DIRECTORY))		
		
	}
	
}
