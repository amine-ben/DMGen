package fr.inria.diverse.dmgen.ui.handlers

import com.google.inject.Injector
import fr.inria.diverse.dmgen.DMGenStandaloneSetupGenerated
import java.io.IOException
import org.apache.log4j.Logger
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.utils.EditorUtils

class RunGenerationHandler extends AbstractHandler {
	
	val LOG = Logger.getLogger(RunGenerationHandler)
	
	val Injector injector = new DMGenStandaloneSetupGenerated()
            .createInjectorAndDoEMFRegistration();
    
	val  XtextResourceSet resourceSet = injector
    		.getInstance(XtextResourceSet);
    
    new() {
    	super()
    }	
    	
	override execute(ExecutionEvent event) throws ExecutionException {
		try{
			
			val editor = EditorUtils.getActiveXtextEditor(event);
			
			if (editor != null) {
				
				val file  =  ( editor.getEditorInput() as FileEditorInput).getFile();
				val outUri = exportXMI(file.getFullPath().toOSString());
				
			}
		} catch (IOException e) {
				LOG.error(Messages.RunGenerationHandlerError, e);
		}
		 catch (Exception e) {
			LOG.error(Messages.RunGenerationHandlerError, e);
		}
				
		return null
	}
	
	def String exportXMI(String osInPath) throws IOException {
		
		val osOutPath = osInPath.concat(".xmi");
	    val inURI = URI.createURI(osInPath);
	    val xtextResource = resourceSet.getResource(inURI, true);
	    val outURI = URI.createURI(osOutPath);
	    EcoreUtil.resolveAll(xtextResource);

	    val xmiResource = resourceSet
	            .createResource(outURI);
	    xmiResource.getContents().add(xtextResource.getContents().get(0));
	 
	    xmiResource.save(null);
	    
	    return osOutPath;
	}
	
}