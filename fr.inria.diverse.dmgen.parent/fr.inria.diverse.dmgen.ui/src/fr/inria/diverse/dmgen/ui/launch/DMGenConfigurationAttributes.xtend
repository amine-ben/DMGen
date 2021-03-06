package fr.inria.diverse.dmgen.ui.launch

interface DMGenConfigurationAttributes {
	
	
	val String TAB_GENARATION_NAME = "Main"
	
	val String SELECT_FILE = "Select File"
	
	val String PERSISTENCE_SCHEME = "persistence.scheme"
	
	val String MODULE_GROUP_NAME = "DMGen module"
	val String MODULE_NAME = "module.name"
	val String MODULE_PATH = "module.path"
	
	val String METAMODEL_GROUP_NAME = "Metamodel"
	val String METAMODEL_NAME = "metamodel.uri"
	
	val String SPARK_GROUP_NAME = "Spark host"
	val String SPARK_HOST_NAME = "spark.host"
	
	val String EXECUTORS = "spark.nodes"
	val String SPARK_NODES_NUMBER_DEFAULT = "*"
	
	val String HBASE_GROUP_NAME = "HBase Base Path"
	
	val String XMI_GROUP_NAME = "Local Base Path"
	val String BASE_PATH = "path.base"
	
	val String FS_HOST_NAME = "fs.name"	
	val String DEFAULT_EXTENSION = "dmgen"
	
	val String PATH_ICON="resources/icons/plug-icon-16.png"
	
	val String DMGEN_CONFIG_TYPE = "fr.inria.diverse.dmgen.ui.DMGenLaunchConfigurationType"
	val String DMGEN_FILE_NAME = "dmgen.file.name"
	
	val String[] SPARK_MASTER_ARRAY = #["yarn-cluster", 
										"local"]
										
	val String[] NEOEMF_HBASE_SCHEMES = #["neo-hbase"]
	
	val String[] NEOEMF_STANDALONE_SCHEMES = #["neo-berkeleydb",
											   "neo-blueprints",
											   "neo-mapdb", 
											   "neo-hbase", 
											   "xmi"]
	
	
	
}