package fr.inria.diverse.dmgen.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.apache.log4j.Logger;

import com.google.inject.Inject;

import fr.inria.diverse.dmgen.ui.handlers.Messages;

public class RunGenerationHandler extends AbstractHandler {

	@Inject
	protected EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	protected IGlobalServiceProvider globalServiceProvider;

	private static final Logger LOG = Logger.getLogger(RunGenerationHandler.class);
	
	public RunGenerationHandler() {
		super();
	}
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try{
			
			XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			
			if (editor != null) {
				
				final IFile file  =  ((FileEditorInput) editor.getEditorInput()).getFile();
				IPath path = file.getFullPath();
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				editor.getDocument().priorityReadOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						EObject target = eObjectAtOffsetHelper.resolveElementAt(state, selection.getOffset());
						//findReferences(target);
					}
				});
			}
		} catch (Exception e) {
				LOG.error(Messages.RunGenerationHandlerError, e);
			}
		return null;
	}
	
}
