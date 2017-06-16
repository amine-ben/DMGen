package fr.inria.diverse.dmgen.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Injector;

import fr.inria.diverse.dmgen.DMGenStandaloneSetupGenerated;
import fr.inria.diverse.dmgen.ui.handlers.Messages;

public class RunGenerationHandler extends AbstractHandler {

	private static final Logger LOG = Logger
			.getLogger(RunGenerationHandler.class);
	
	protected Injector injector = new DMGenStandaloneSetupGenerated()
            .createInjectorAndDoEMFRegistration();
    
	protected XtextResourceSet resourceSet = injector
    		.getInstance(XtextResourceSet.class);
	
	public RunGenerationHandler() {
		super();
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try{
			
			XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			
			if (editor != null) {
				
				final IFile file  =  ((FileEditorInput) editor.getEditorInput()).getFile();
				String outUri = exportXMI(file.getFullPath().toOSString());
				
				
			}
		} catch (IOException e) {
				LOG.error(Messages.RunGenerationHandlerError, e);
		}
		 catch (Exception e) {
			LOG.error(Messages.RunGenerationHandlerError, e);
		}
				
		return null;
	}
	/**
	 * Exporting the DSL to an XMI file 
	 * @param osInPath
	 * @return the URI of the output XMI resource
	 * @throws IOException
	 */
	private String exportXMI(String osInPath) throws IOException{
	    // change MyLanguage with your language name
	   
	    // .ext ist the extension of the model file
		
	    String osOutPath = osInPath.concat(".xmi");
	    URI inURI = URI.createURI(osInPath);
	    Resource xtextResource = resourceSet.getResource(inURI, true);
	    URI outURI = URI.createURI(osOutPath);
	    EcoreUtil.resolveAll(xtextResource);

	    Resource xmiResource = resourceSet
	            .createResource(outURI);
	    xmiResource.getContents().add(xtextResource.getContents().get(0));
	 
	    xmiResource.save(null);
	    
	    return osOutPath;
	   
	}

}
