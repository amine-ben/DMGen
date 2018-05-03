package fr.inria.diverse.dmgen.util

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import java.nio.file.Files
import org.eclipse.emf.common.util.URI
import java.io.IOException
import org.apache.commons.lang.RandomStringUtils
import fr.inria.diverse.dmgen.DMGenStandaloneSetup

class DMGenUtil {
	
	/**
	 * Exports <code>.dmgen</code> file in a temporary folder 
	 * @param {@link String} <code>osInPath</code>  
	 * 				The path of the XMI file to be imported
	 * @param {@link  String} <code>moduleName</code>
	 * 				The desired module name
	 * @param {@link ResourceSet} <code>resourceSet</code>
	 * 				A resourceSetImpl 
	 */
	def static URI exportDMgentoXMI(String osInPath, String moduleName, ResourceSet resourceSet) throws IOException {
		// loading the dmgen resource
		new DMGenStandaloneSetup().createInjectorAndDoEMFRegistration
	    val inURI = URI.createPlatformResourceURI(osInPath, true)
	    val xtextResource = resourceSet.getResource(inURI, true);
	    EcoreUtil.resolveAll(xtextResource);
	   
	    val tempfolder = Files.createTempDirectory("sparkGen")
		val outURI = URI.createFileURI(tempfolder.toAbsolutePath+"/"+moduleName+".xmi")
		// converting the resource to standard xmi format
	    val xmiResource = resourceSet.createResource(outURI);
	    xmiResource.getContents().addAll(xtextResource.contents);
	 
	    xmiResource.save(null);
	    
	    return outURI;
	}
	
	/**
	 * Exports <code>.dmgen</code> file in a temporary folder 
	 * This method generates a random fileName
	 * @see  DMGenUtil#exportXMI(String, String, ResourceSet)
	 * @param {@link String} <code>osInPath</code>  
	 * 				The path of the XMI file to be imported
	 * @param {@link ResourceSet} <code>resourceSet</code>
	 * 				A resourceSetImpl 
	 */
	def static URI exportDMgentoXMI(String osInPath, ResourceSet resourceSet) throws IOException {
		exportDMgentoXMI(osInPath, RandomStringUtils.randomAlphabetic(10), resourceSet)
	}	
}