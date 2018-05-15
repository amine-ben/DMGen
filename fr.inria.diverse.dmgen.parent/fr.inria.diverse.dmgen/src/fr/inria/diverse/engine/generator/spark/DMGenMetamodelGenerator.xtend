package fr.inria.diverse.engine.generator.spark

import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseResourceUtil
import fr.inria.diverse.dmgen.dMGen.Generator
import fr.inria.diverse.engine.generator.IGenerator
import fr.inria.diverse.engine.generator.specimen.ISpecimenConfiguration
import fr.inria.diverse.engine.generator.util.EdgesGen
import fr.inria.diverse.engine.generator.util.GenerationException
import fr.inria.diverse.engine.generator.util.VerticesGenToPair
import java.io.File
import java.io.IOException
import java.text.MessageFormat
import java.util.Collections
import java.util.Random
import java.util.stream.Collectors
import java.util.stream.LongStream
import org.apache.commons.lang3.Range
import org.apache.log4j.LogManager
import org.apache.spark.sql.Encoders
import org.apache.spark.sql.SparkSession
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet

class DMGenMetamodelGenerator implements IGenerator{
	
	
	static val LOGGER = LogManager.getLogger("Generator") 
	
	//var protected SparkConf sc = new SparkConf().setAppName("Spark EMF models generator")
	
	//var protected JavaSparkContext jsc = new JavaSparkContext(sc)
	
	val static int OK = 0
	val static int KO = 1
	var protected SparkSession spark
	 
	var URI baseURI
	
	var Generator generator	
	
	var Resource metamodel
	
	var ISpecimenConfiguration config
	
	var boolean local
	//var String prefix
	
	var int numberOfNodes
	
	new(Generator generator, 
			URI baseURI, 
			Resource metamodel, 
			int numberOfNodes,
			boolean local) {
				
				super()
				this.generator = generator
				this.baseURI = baseURI
				this.metamodel = metamodel
				this.numberOfNodes = numberOfNodes
				this.local = local
				config = new DMGenGenerationConfig (metamodel, 
													generator,
													Range.between(0,DEFAULT_PROPERTIES_RANGE),
													seed)
				// TODO add support for non local environment setup
				this.spark = SparkSession.builder
										 .appName("Spark EMF models generator")
										 .master("local")
										 .getOrCreate		   
	}
	// TODO add seed to the language definition in DMGen
	def long seed() {
//		if (generator.seed!=0L)
//			generator.seed
//		else  
			new Random().nextLong
	}
	/**
	 * @param rs 
	 */
	def launch (ResourceSet rs) {
		for (var i = 0 ; i < generator.number ; i++) {
			 val uri = formatURI(i, baseURI.toString)
			 val resource = rs.createResource(uri)
			 generate(resource)
		}
	}
	
	def URI formatURI(int index, String prefixe) {
		val builder = new StringBuilder(prefixe) 
		
		builder.append(File.separator) 
		builder.append(generator.prefix) 
		builder.append(File.separator) 
		builder.append("model") 
		builder.append(generator.size) 
		builder.append(File.separator) 
		builder.append("gen") 
		builder.append(generator.size) 
		builder.append("_") 
		builder.append(index) 

		return URI.createURI(builder.toString()) 
	}
	
	override generate(Resource resource) {
		try {

			SparkSession.builder
			LOGGER.info(MessageFormat.format("Creating {0} model{1} using as generator {2}", 
								  generator.number, if (generator.number > 1 ) 's' else "" , 
								  "Spark Model Generator"))
			
			LOGGER.info(MessageFormat.format("Generator seed is ''{0}''", config.getSeed()))
			LOGGER.info(MessageFormat.format("Config parameters: range for models size is [{0}, {1}]", 
					config.getElementsRange().getMinimum(), config.getElementsRange().getMaximum())) 
			LOGGER.info(MessageFormat.format("Config parameters: range for properties number is [{0}, {1}]", 
					config.getPropertiesRange().getMinimum(), config.getPropertiesRange().getMaximum())) 
			LOGGER.info(MessageFormat.format("Config parameters: range for references number is [{0}, {1}]", 
					config.getReferencesRange().getMinimum(), config.getReferencesRange().getMaximum())) 
			LOGGER.info(MessageFormat.format("Config parameters: range for values length is [{0}, {1}]", 
					config.getValuesRange().getMinimum(), config.getValuesRange().getMaximum())) 
			
				// deleting the resource if exists 
				HBaseResourceUtil.getInstance().deleteResourceIfExists(resource.URI) 
				// creating the resource
				LOGGER.info(MessageFormat.format("Creating model with URI {0} ", resource.URI.toString())) 
				//Resource resource = resourceSet.createResource(resource.URI) 
				resource.load(Collections.EMPTY_MAP) 		
				LOGGER.info(MessageFormat.format("Start generation of resource {0} with an average size of {1} elements", 
						resource.getURI(), generator.size)) 			
				
				
				val vertices = spark.createDataset(LongStream
													.rangeClosed(1, numberOfNodes)
													.boxed()
													.collect(Collectors.toList()), Encoders.LONG())
									.rdd.toJavaRDD
				
//				val vertices = spark.sparkContext.parallelize(LongStream
//						.rangeClosed(1, numberOfNodes)
//						.boxed()
//						.collect(Collectors.toList()), numberOfNodes, null)
//				
//				
//				parallelize() as JavaRDD<Long>
//				vertices = spark.sparkContext.parallelize(vertices.to)
//				val exitCode = if (vertices.) OK
//							   else KO
				val exitCode = if (vertices.mapPartitions(
													new VerticesGenToPair (config,
																			generator.size/numberOfNodes,  
																			resource
																		  ) 
														 )
										   .mapPartitions(new EdgesGen(config, resource))
										   .count() > 1) OK
							   else KO								
				LOGGER.info(MessageFormat.format("Saving resource {0}", resource.getURI())) 
				resource.save(Collections.emptyMap()) 
				
			LOGGER.info("All resources have been saved") 
			
		} catch (IOException e) {
			LOGGER.error(e.getLocalizedMessage()) 
			throw new GenerationException(e) 
			
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage()) 
		}
		finally {
			// stopping the spark session 
			spark.stop
		}
	}
	
	override getConfig() {	config	}
	
}