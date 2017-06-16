package fr.inria.diverse.dmgen.ui.launch

import org.eclipse.ui.dialogs.ElementTreeSelectionDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.model.WorkbenchLabelProvider
import org.eclipse.ui.model.WorkbenchContentProvider
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.jface.viewers.ViewerFilter
import org.eclipse.jface.viewers.Viewer
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile

class WorkspaceFileDialog extends ElementTreeSelectionDialog {
	
		new(Shell parent, String... extensions) {
		super(parent, new WorkbenchLabelProvider(), new WorkbenchContentProvider())
		input = ResourcesPlugin.workspace.root
		message = DMGenConfigurationAttributes.SELECT_FILE
		title = DMGenConfigurationAttributes.SELECT_FILE
		allowMultiple = false
		doubleClickSelects = true
		
		addFilter( new ViewerFilter () {
			
			override select (Viewer viewer, Object parentElement, Object element) {
				var result = false
				
				try {
					result = isResourceAvailable(element as IResource , extensions)
				} catch (CoreException e) { 
						throw new RuntimeException(e);
				}
				return result; 
			}
				
		})
	}	
	
		def boolean isResourceAvailable(IResource resource, String[] extensions) throws CoreException {
				if (resource instanceof IContainer) {
					if ((resource as IContainer).isAccessible()) {
						if ( (resource as IContainer).members().exists[member | isResourceAvailable(member, extensions)] == true) 
							return true			
					}
				} else if (resource instanceof IFile) {
					val currentFile = resource as IFile;
					if (extensions == null || extensions.length == 0) {
						return true;
					} else if (currentFile.fileExtension != null) {
						if (extensions.exists[ext | ext.toLowerCase().equals(currentFile.fileExtension.toLowerCase)])
							return true
					}
				}
				return false;
			}
	}