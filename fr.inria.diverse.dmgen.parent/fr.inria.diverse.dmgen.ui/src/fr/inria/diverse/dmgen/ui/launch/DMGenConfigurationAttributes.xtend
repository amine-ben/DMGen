package fr.inria.diverse.dmgen.ui.launch

interface DMGenConfigurationAttributes {
	
	
	val String SPARK_HOST_DEFAULT = "local[*]"
	val String HBASE_HOST_NAME_DEFAULT = "localhost:2181"
	val String TAB_GENARATION_NAME = "Main"
	
	val String SELECT_FILE = "Select File"
	
	val String MODULE_GROUP_NAME = "DMGen module"
	val String MODULE_NAME = "module.name"
	val String MODULE_PATH = "module.path"
	
	val String METAMODEL_GROUP_NAME = "Metamodel"
	val String METAMODEL_NAME = "metamodel.uri"
	
	val String SPARK_GROUP_NAME = "Spark host"
	val String SPARK_HOST_NAME = "spark.host"
	
	val String HBASE_GROUP_NAME = "HBase host"
	val String HBASE_HOST_NAME = "hbase.host"
		
	val String DEFAULT_EXTENSION = "dmgen"
	
	val String PATH_ICON="resources/icons/plug-icon-16.png"
	
	val String DMGEN_CONFIG_TYPE = "fr.inria.diverse.dmgen.ui.DMGenLaunchConfigurationType"
	val String DMGEN_FILE_NAME = "dmgen file name"
	
	val String SPARK_APP_RESOURCE = "graphx-generator-0.0.1-SNAPSHOT.jar"
	val String SPARK_MAIN_CLASS = "fr.inria.diverse.spark_generator.Launcher.java"
	
}