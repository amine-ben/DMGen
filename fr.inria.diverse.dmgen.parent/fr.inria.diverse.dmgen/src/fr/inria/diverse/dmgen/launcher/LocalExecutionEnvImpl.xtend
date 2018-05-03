package fr.inria.diverse.dmgen.launcher

import fr.inria.atlanmod.neoemf.data.berkeleydb.util.BerkeleyDbURI
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI
import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI
import fr.inria.atlanmod.neoemf.data.mapdb.util.MapDbURI
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory
import fr.inria.diverse.dmgen.dMGen.GenConfig
import fr.inria.diverse.dmgen.dMGen.impl.DMGenPackageImpl
import fr.inria.diverse.engine.generator.spark.DMGenMetamodelGenerator
import java.io.IOException
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.LocalFileSystem
import org.apache.hadoop.hdfs.DistributedFileSystem
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource

class LocalExecutionEnvImpl extends ExecutionEnvImpl {
	
	// HDFS file system configuration 
	var Configuration fsConfiguration
	var Resource metamodelResource
	
	var Resource dmgenResource
	var URI baseURI
	
	override launch() throws CoreException {
		
		// setting up the environment 
		setupEnv
		val genConfig = dmgenResource.contents.head as GenConfig
			
			// generating models  
			genConfig.generators.forEach[gen | 
				// TODO remove executors from the constructor
				val myGen = new DMGenMetamodelGenerator(gen, 
											baseURI,
											metamodelResource,
											Integer.parseInt(executors),
											true)
				//myGen.sparkConf.master = "local["+executors+"]"	
				
				myGen.launch(resourceSet)
			]
	}
	
	override setupEnv() throws IOException, CoreException {
					
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(
					HBaseURI.SCHEME, PersistentResourceFactory.getInstance());
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(
					BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(
					BerkeleyDbURI.SCHEME, PersistentResourceFactory.getInstance());
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(
					MapDbURI.SCHEME, PersistentResourceFactory.getInstance());			
					
		fsConfiguration = new Configuration() 
			//fsConfiguration.set("fs.defaultFS", hdfsMaster) 
			fsConfiguration.set("fs.hdfs.impl", DistributedFileSystem.name)
	   		fsConfiguration.set("fs.file.impl",LocalFileSystem.name)
	   		fsConfiguration.set("dfs.permissions.enabled","false")
	
			if (ePackageImpl != null && !ePackageImpl.isEmpty) {
				val clazz = LocalExecutionEnvImpl.classLoader.loadClass(ePackageImpl)
				clazz.getMethod("init").invoke(null)
			}
			
			if (metamodelURL != null && !metamodelURL.isEmpty) {
				//val mmURI = createWellFormatedURI(metamodelURL)
				val mmURI = URI.createURI(metamodelURL)
				metamodelResource = resourceSet.getResource(mmURI, true)
			}
			
			if (dmgenURL != null && !dmgenURL.isEmpty) {
				DMGenPackageImpl.init
				dmgenResource = resourceSet.getResource(URI.createFileURI(dmgenURL), true)
			}
			
			baseURI = formatBaseURI(persistenceScheme, basePath)
			
	}
	
	def createWellFormatedURI(String uri) {
		var URI myURI
		switch uri {
			case uri.contains("platform:/resource") : myURI = URI.createPlatformResourceURI(uri, true)
			case uri.contains("platform:/plugin") : myURI = URI.createPlatformPluginURI(uri, true)
			case uri.contains("file:/") : myURI = URI.createFileURI(uri)
			default : myURI = URI.createURI(uri)
		}
		return myURI
	}
	
	// the choice of the URI classes is to simplify the update to NeoEMF 2.0:
	def formatBaseURI(String scheme, String path) {
		var URI myURI
		switch scheme {
			case scheme.equals(BlueprintsURI.SCHEME) : myURI = BlueprintsURI.createURI(BlueprintsURI.SCHEME.append("://").append(path))
			case scheme.equals(BerkeleyDbURI.SCHEME) : myURI = BerkeleyDbURI.createURI(BerkeleyDbURI.SCHEME.append("://").append(path))
			case scheme.equals(MapDbURI.SCHEME) : myURI = MapDbURI.createURI(MapDbURI.SCHEME.append("://").append(path))
			case scheme.equals(HBaseURI.SCHEME) : myURI = HBaseURI.createURI(HBaseURI.SCHEME.append("://").append(path))
 		}
	}
	
	def append(String str1, String str2) {
		return str1 + str2 	
	}
	
}