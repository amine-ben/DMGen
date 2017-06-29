package fr.inria.diverse.spark_generator

import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory
import fr.inria.diverse.spark_generator.util.HadoopURIConverterImpl
import org.apache.hadoop.conf.Configuration
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl

import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware

class Launcher {
	
	// The logger of the instance
	static val Logger LOGGER = Logger.getLogger(Launcher)
	
	// Application arguments 
	static val String HDFS_MASTER = "hdfs-master"
	static val String METAMODEL_URL = "metamodel-url"
	static val String DMGEN_URL = "dmgen-url"
	static val String E_PACKAGE_CLASS = "package"
	static val String HBASE_MASTER = "hbase-master"
	
	// HDFS file system configuration 
	var Configuration conf

		
	def main (String... args) {
		
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
									return new HadoopURIConverterImpl(conf);
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
									return new HadoopURIConverterImpl(conf)
								}
								
							}
							
						}
					});
					
			resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(
					HBaseURI.SCHEME, PersistentResourceFactory.getInstance());				
		}
		
		try {
			// loading the metamodel from hdfs 
			
			
			
		} catch (ClassNotFoundException e) {
			LOGGER.error(e.message, e)
		}
	}
	
}