package fr.inria.diverse.dmgen.Launcher

interface DMGenConstants {
	
	val String SPARK_APP_RESOURCE = "graphx-generator-0.0.1-SNAPSHOT.jar"
	val String SPARK_MAIN_CLASS = "fr.inria.diverse.spark_generator.Launcher"
	
	val String SPARK_HOST_NAME_DEFAULT = "local[*]"
	val String HBASE_HOST_NAME_DEFAULT = "localhost:2181"
	val String FS_HOST_NAME_DEFAULT = "hdfs://dmhadoop:8020"
	
	val String HADOOP_CONF_DIR = "HADOOP_CONF_DIR"
	val String YARN_CONF_DIR = "YARN_CONF_DIR"
	
}