package fr.inria.diverse.generator.spark

import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory
import fr.inria.diverse.dmgen.dMGen.GenConfig
import fr.inria.diverse.dmgen.dMGen.impl.DMGenPackageImpl
import fr.inria.diverse.generator.util.HadoopURIConverterImpl
import java.text.MessageFormat
import java.util.Comparator
import org.apache.commons.cli.GnuParser
import org.apache.commons.cli.Option
import org.apache.commons.cli.OptionBuilder
import org.apache.commons.cli.Options
import org.apache.commons.cli.ParseException
import org.apache.hadoop.conf.Configuration
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
import org.apache.hadoop.hdfs.DistributedFileSystem
import org.apache.hadoop.fs.LocalFileSystem

class SparkGeneratorLauncher {
	
	// The logger of the instance
	static val Logger LOGGER = Logger.getLogger(SparkGeneratorLauncher)
	
	// Application arguments
	static val String HDFS_MASTER = "h"
	static val String METAMODEL_URL = "m"
	static val String DMGEN_URL = "g"
	static val String E_PACKAGE_CLASS = "p"
	static val String HBASE_MASTER = "b"
	 
	static val String HDFS_MASTER_LONG = "hdfs-master"
	static val String METAMODEL_URL_LONG = "metamodel-url"
	static val String DMGEN_URL_LONG = "dmgen-url"
	static val String E_PACKAGE_CLASS_LONG = "package"
	static val String HBASE_MASTER_LONG = "hbase-master"
	
	// Variables corresponding to application arguments 
	var String ePackage
	var Resource dmgenResource
	var Resource metamodelResource

	var String hbaseMaster
	var String hdfsMaster
	
	// HDFS file system configuration 
	var Configuration fsConfiguration

	private static class OptionComparator<T extends Option> implements Comparator<T> {
		val OPTS_ORDER = "hmgpd"
		override compare(T o1, T o2) {
			OPTS_ORDER.indexOf(o1.opt) - OPTS_ORDER.indexOf(o2.opt) 
		}
		
	}	
	/**
	 * main method
	 */
	def main (String... args) {
		// Setting up the parser
		val options = configureOptions 
			val parser = new GnuParser
			val  commandLine = parser.parse(options, args)
			
		// Setting up HDFS configuration
		hdfsMaster = commandLine.getOptionValue(HDFS_MASTER)	
		
		if (!hdfsMaster.contains("hdfs"))
				throw new ParseException (MessageFormat.format("Malformed URL {0}", hdfsMaster))
		
		fsConfiguration = new Configuration() 
			fsConfiguration.set("fs.defaultFS", hdfsMaster) 
			fsConfiguration.set("fs.hdfs.impl", DistributedFileSystem.name)
	   		fsConfiguration.set("fs.file.impl",LocalFileSystem.name)
	   		fsConfiguration.set("dfs.permissions.enabled","false")		
		
		val resourceSet = new ResourceSetImpl();
		{ // initializing the registry
			
			resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put(
					EcorePackage.eNS_PREFIX, new EcoreResourceFactoryImpl() {
						override Resource createResource (URI uri) {
							val result =  new XMIResourceImpl(uri) {
								override boolean useIDs() {
									return eObjectToIDMap != null || idToEObjectMap != null;
								}
								override URIConverter getURIConverter() {
									return new HadoopURIConverterImpl(fsConfiguration);
								}
							}
							result.setEncoding("UTF-8")
							result.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
							result.getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, 80);
							result.getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new PlatformSchemeAware());
							return result
						}
					})
						
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
					Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl() {
						override Resource createResource (URI uri) {
							return new XMIResourceImpl(uri) {
								override getURIConverter() {
									return new HadoopURIConverterImpl(fsConfiguration)
								}
								
							}
							
						}
					});
					
			resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(
					HBaseURI.SCHEME, PersistentResourceFactory.getInstance());				
		}
		
		
			ePackage = commandLine.getOptionValue(E_PACKAGE_CLASS)
			var metamodelUrl = commandLine.getOptionValue(METAMODEL_URL)
			// loading the metamodel from hdfs 
			LOGGER.info("Start loading the packages")
			if (ePackage != null && !ePackage.isEmpty) {
				val clazz = SparkGeneratorLauncher.classLoader.loadClass(ePackage)
				clazz.getMethod("init").invoke(null)
			}
			
			if (metamodelUrl != null && !metamodelUrl.isEmpty) {
				metamodelResource = resourceSet.getResource(URI.createURI(metamodelUrl), true)
			}
			
			LOGGER.info("Finish loading the packages")
			
			
			hbaseMaster = commandLine.getOptionValue(HBASE_MASTER)
			
			var dmgenUrl = commandLine.getOptionValue(DMGEN_URL)
			
			if (dmgenUrl != null && !dmgenUrl.isEmpty) {
				DMGenPackageImpl.init
				dmgenResource = resourceSet.getResource(URI.createURI(dmgenUrl), true)
			}
			
			val generators = (dmgenResource.contents.get(0) as GenConfig).generators
			val numberOfNodes = 0
			// generating models  
			generators.forEach[gen | new DMGenMeatamodelGenerator(gen, 
										hbaseMaster,
										metamodelResource,
										numberOfNodes
										).launch(resourceSet)
			]
			
	}
	/**
	 * Configures the program options
	 * returns {@link Options} the CLI options 
	 */
	def Options configureOptions () {
		val options = new Options
		
		val metamodel = OptionBuilder.create(METAMODEL_URL)
		metamodel.longOpt = METAMODEL_URL_LONG
		metamodel.argName = "the URL of the imported metamodel"
		metamodel.description = "The metamodel should be stored in HDFS (hdfs://)"
		metamodel.args = 1
		metamodel.required = true
		
		val hbase = OptionBuilder.create(HBASE_MASTER)
		hbase.longOpt = HBASE_MASTER_LONG
		hbase.argName = "the base url of the Zookeeper in HBase. Used to Read/write from NeoEMF/Hbase"
		hbase.description = "the base url of Zookeeper. Comes in the form hostname:port"
		hbase.args = 1
		hbase.required = true
		
		val hdfs = OptionBuilder.create(HDFS_MASTER)
		hdfs.longOpt = HDFS_MASTER_LONG
		hdfs.argName = "the hostname and port number of HDFS Namenode"
		hdfs.description = "Comes in the form (hdfs://hostname:port)"
		hdfs.args = 1
		hdfs.required = true
		
		val dmgen = OptionBuilder.create(DMGEN_URL)
		dmgen.longOpt = DMGEN_URL_LONG
		dmgen.argName = "The URL of the dmgen module."
		dmgen.description = "The metamodel should be stored in HDFS (hdfs://) on beforehand"
		dmgen.args = 1
		dmgen.required = true
		
		val package = OptionBuilder.create(E_PACKAGE_CLASS)
		package.longOpt = E_PACKAGE_CLASS_LONG
		package.argName = "The package implementation corresponding to the imported metamodel"
		package.description = "com.exmple.ecore.packageImpl"
		package.args = 1
		package.required = true
		
		options.addOption(package)
		options.addOption(dmgen)
		options.addOption(hdfs)
		options.addOption(hbase)
		options.addOption(metamodel)
		
		return options

	}
	
}