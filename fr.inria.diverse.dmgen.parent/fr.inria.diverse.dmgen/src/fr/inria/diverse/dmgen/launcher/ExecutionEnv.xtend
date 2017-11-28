package fr.inria.diverse.dmgen.launcher

import org.apache.log4j.Logger
import org.eclipse.core.runtime.CoreException
import java.io.IOException

interface ExecutionEnv {
	
	// The logger of the instance
		static val LOG = Logger.getLogger(ExecutionEnv)
		
	// Application arguments. Used to setup and launch the SparkLauncher 
		static val  HDFS_MASTER = "--hdfs-master"
		static val  METAMODEL_URL = "--metamodel-url"
		static val  DMGEN_URL = "--dmgen-url"
		static val  E_PACKAGE_CLASS = "--package"
		static val  HBASE_MASTER = "--hbase-master"
	
	// Spark temp directory. Used to share 
		static val  SPARK_TEMP_DIRECTORY = "/temp/spark/generator/resources/"
		
	/**
	 * Launching the generation 
	 */	
	def void launch() throws CoreException
	/**
	 * setting up the execution environment
	 */
	def void setupEnv() throws IOException, CoreException
}