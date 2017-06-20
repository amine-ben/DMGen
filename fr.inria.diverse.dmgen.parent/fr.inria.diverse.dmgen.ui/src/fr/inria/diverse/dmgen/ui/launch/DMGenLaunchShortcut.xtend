package fr.inria.diverse.dmgen.ui.launch

import org.eclipse.core.resources.IFile
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.debug.core.ILaunchManager
import org.eclipse.debug.ui.ILaunchShortcut
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.IFileEditorInput
import org.eclipse.debug.ui.DebugUITools
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import fr.inria.diverse.dmgen.ui.internal.DmgenActivator
import org.eclipse.core.runtime.Status
import org.eclipse.jface.window.Window
import org.eclipse.jface.dialogs.MessageDialog

class DMGenLaunchShortcut implements ILaunchShortcut {
	
	var IFile file 
	
	override launch(ISelection selection, String mode) {
		val structuredSelection = selection as IStructuredSelection
		file = structuredSelection.firstElement as IFile
		
		launch(file, mode)
	}
	
	override launch(IEditorPart editor, String mode) {
		file = (editor.editorInput as IFileEditorInput).file
		launch (file, mode) 
	}
	
	protected def launch (IFile file, String mode) {
		
		val moduleName = file.fullPath.lastSegment
		try {
			val availablesConfs = launchManager.getLaunchConfigurations(getDMGenConfigurationType())
											   .filter[ config | config.getAttribute(DMGenConfigurationAttributes.DMGEN_FILE_NAME, "")
																		.equals(file.fullPath.toOSString)]
			if (! availablesConfs.isEmpty) {
				DebugUITools.launch(availablesConfs.get(0), mode)
			} else {
				val configuration = createConfiguration
				val launchGrp = DebugUITools.getLaunchGroup(configuration, mode)
				if (DebugUITools.openLaunchConfigurationDialog(DmgenActivator.instance.shell,
						configuration, launchGrp.identifier, Status.OK_STATUS) != Window.CANCEL)
					configuration.doSave
			}		
		} catch (Exception e) {
			System.err.println(e.message)
			MessageDialog.openError(DmgenActivator.instance.shell, "Launching error", e.getMessage()); //$NON-NLS-1$
		}
	}
	
	def ILaunchConfigurationWorkingCopy createConfiguration() {
		val moduleName =  file.fullPath.lastSegment
		val confName = launchManager.generateLaunchConfigurationName(moduleName)
		
		val result = DMGenConfigurationType.newInstance(null, confName)
		result.setAttribute(DMGenConfigurationAttributes.DMGEN_FILE_NAME, file.fullPath.toOSString)
		result.setAttribute(DMGenConfigurationAttributes.MODULE_NAME, moduleName.substring(0, moduleName.lastIndexOf('.')))
		result.setAttribute(DMGenConfigurationAttributes.MODULE_PATH, file.fullPath.removeLastSegments(1).toOSString)		
		return result	
	}
	
	def getDMGenConfigurationType() {
		launchManager.getLaunchConfigurationType(DMGenConfigurationAttributes.DMGEN_CONFIG_TYPE)
	}
	
	def ILaunchManager getLaunchManager() {
		DebugPlugin.^default.launchManager
	}
	
}