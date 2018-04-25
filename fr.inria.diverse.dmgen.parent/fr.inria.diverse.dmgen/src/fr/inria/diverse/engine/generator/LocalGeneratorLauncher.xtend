package fr.inria.diverse.engine.generator

import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet

class LocalGeneratorLauncher {
	
	static val LOGGER = Logger.getLogger(LocalGeneratorLauncher)
	
	var Resource dmgenResource
	var Resource metamodelResource
	var String ePackage
	
	val ResourceSet rst = new ResourceSetImpl
	 
	new (URI dmgenURI, URI metamodelURI, String epckImpl) {
		
	}
	def launch() {
		
		val resourceSet = new ResourceSetImpl()
		 // initializing the registry
		resourceSet.resourceFactoryRegistry
				   .protocolToFactoryMap
				   .put(HBaseURI.SCHEME, PersistentResourceFactory.instance)				
		
		resourceSet.resourceFactoryRegistry
				   .protocolToFactoryMap
				   .put(BlueprintsURI.SCHEME, PersistentResourceFactory.instance)
				   			   
	}
		
}