package fr.inria.diverse.dmgen.ui.launch

import fr.inria.diverse.dmgen.dMGen.Generator
import org.eclipse.core.resources.IFile
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab
import org.eclipse.emf.common.util.URI
import org.eclipse.jface.dialogs.Dialog
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.ScrolledComposite
import org.eclipse.swt.events.FocusEvent
import org.eclipse.swt.events.FocusListener
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.events.ModifyListener
import org.eclipse.swt.events.ModifyEvent
import org.eclipse.ui.PlatformUI
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import java.io.FileNotFoundException
import fr.inria.diverse.dmgen.dMGen.GenConfig

/**
 * Derived from EMFTVM Launcher @link 
 */
class DMGenMainTab extends AbstractLaunchConfigurationTab {
	
	boolean moduleChanged
	
	override createControl(Composite parent) {
		
		
		// Main composite
		val scCont = new ScrolledComposite(parent, SWT.V_SCROLL.bitwiseOr(SWT.H_SCROLL))
		scCont.expandHorizontal = true
		scCont.expandVertical = true
	
		// The Root composite 
		val rootCont = new Composite(scCont, SWT.NULL)
		rootCont.layout = new GridLayout
		scCont.content = rootCont 
	
		// 
		val moduleGrp = new Group(rootCont, SWT.BORDER) 
		moduleGrp.layoutData = new GridData(GridData.FILL_HORIZONTAL)
		moduleGrp.layout = new GridLayout(3, false)
		moduleGrp.text = DMGenConfigurationAttributes.MODULE_GROUP_NAME
		
		val moduleFileLabel = new Label(moduleGrp, SWT.LEFT)
		moduleFileLabel.setLayoutData(new GridData(SWT.LEFT))
		moduleFileLabel.setText("Module:")

		val moduleNameText = new Text(moduleGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		moduleNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		
		// Adding a focus listener to text field
		moduleNameText.addFocusListener(new FocusListener() {
			
			override focusGained(FocusEvent e) {
			}
			
			override focusLost(FocusEvent e) {
				if (moduleChanged) {
					rebuild
				}
					
			}		
		})
		// Adding a modify listener to text field	
		moduleNameText.addModifyListener( new ModifyListener() {
			
			override modifyText(ModifyEvent e) {
				if (!moduleChanged) {
					moduleChanged = true 
					PlatformUI.workbench.display.asyncExec(new Runnable() {
						override run() {
							rebuild
						}						
					}) 
				}
			}
			
		})
		
		var browseWorkspace = new Button(moduleGrp, SWT.RIGHT)
		browseWorkspace.setText("Workspace...")
		browseWorkspace.addSelectionListener( new SelectionAdapter () {
			
			override widgetSelected	(SelectionEvent e) {
			
				val extensions =  {"dmgen"}
				val dialog = new WorkspaceFileDialog(shell, extensions)
				
				val result = if (dialog.open ==  Dialog.OK )
							 	dialog.firstResult 
							 else  null
				if ((result != null) && (result instanceof IFile)) {

					val currentFile = result as IFile 
					val path = currentFile.fullPath 
					val uri = URI.createPlatformResourceURI(path.toString, true) 
					val genConfig = findGenerator(uri)

					rebuild() 
				}
			}
			
		})
		
		val modulePathLabel = new Label(moduleGrp, SWT.LEFT)
		modulePathLabel.setLayoutData(new GridData(SWT.LEFT))
		modulePathLabel.setText("Path:") 

		val modulePathText = new Text(moduleGrp, SWT.SINGLE.bitwiseOr( SWT.BORDER))
		val modulePathData = new GridData(GridData.FILL_HORIZONTAL) 
		modulePathData.horizontalSpan = 2 
		modulePathText.layoutData = modulePathData 
		modulePathText.addFocusListener(new FocusListener() {
			override focusLost(FocusEvent e) {
				if (moduleChanged) {
					rebuild() 
				}
			}
			override focusGained(FocusEvent e) {
			}
		}) 
		
		modulePathText.addModifyListener(new ModifyListener() {
			override modifyText(ModifyEvent e) {
				if (!moduleChanged) {
					moduleChanged = true 
					PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
						override run() {
							rebuild() 
						}
					}) 
				}
			}
		}) 
		
		val metamodelGrp = new Group(rootCont, SWT.NULL)
		metamodelGrp.text = DMGenConfigurationAttributes.METAMODEL_GROUP_NAME
		metamodelGrp.layoutData = new GridData(GridData.FILL_HORIZONTAL)
		metamodelGrp.layout = new GridLayout (3, false)
		
		val metamodelFileLabel = new Label(metamodelGrp, SWT.LEFT)
		metamodelFileLabel.setLayoutData(new GridData(SWT.LEFT))
		metamodelFileLabel.setText("Metamodel:")

		val metamodelLocationText = new Text(metamodelGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		metamodelLocationText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)) 
		metamodelLocationText.layoutData = modulePathData 
		
		val browseWSButt = new Button (metamodelGrp, SWT.LEFT)
		browseWSButt.text = "Workspace..."
		browseWSButt.addSelectionListener(new SelectionAdapter() {
			override widgetSelected (SelectionEvent e) {
				val extensions =  {"ecore"}
				val dialog = new WorkspaceFileDialog (shell, extensions)
				
				val result = if (dialog.open ==  Dialog.OK )
							 	dialog.firstResult 
							 else  null
				if ((result != null) && (result instanceof IFile)) {
					val currentFile = result as IFile 
					val path = currentFile.getFullPath().toString() 
					metamodelLocationText.text = "platform:/resource" + path
				}
			}
		})
		
		val browseFilesystem = new Button(metamodelGrp, SWT.NULL)
			browseFilesystem.setText("File system...")
		browseFilesystem.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent evt) {
				val fileDialog = new FileDialog(getShell(), SWT.OPEN)
				fileDialog.setFilterExtensions(#['ecore']) //$NON-NLS-1$
				val fileName = fileDialog.open() 
				if (fileName != null) {
					metamodelLocationText.text = "file:/" + fileName
				}
			}
		}) 
		
		val browseEMFRegistry = new Button(metamodelGrp, SWT.RIGHT) 
		browseEMFRegistry.setText("EMF registry...") 
		browseEMFRegistry.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent evt) {
				val dialog = new RegisteredPackageDialog(shell) 
				if (dialog.open() == Dialog.OK) {
					metamodelLocationText.text = dialog.getResultAsString() 
				}
			}
		}) 
			
		val sparkGrp = new Group(rootCont, SWT.NULL)
		sparkGrp.text = DMGenConfigurationAttributes.SPARK_GROUP_NAME
		sparkGrp.layoutData = new GridData(GridData.FILL_HORIZONTAL)
		sparkGrp.layout = new GridLayout (2, false)
		
		val sparkHostLabel = new Label(sparkGrp, SWT.LEFT)
		sparkHostLabel.setLayoutData(new GridData(SWT.LEFT))
		sparkHostLabel.setText("Host:")

		val sparkHostText = new Text(sparkGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		sparkHostText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		
		val hbaseGrp = new Group(rootCont, SWT.NULL)
		hbaseGrp.text = DMGenConfigurationAttributes.HBASE_GROUP_NAME
		hbaseGrp.layoutData = new GridData(GridData.FILL_HORIZONTAL)
		hbaseGrp.layout = new GridLayout (2, false)
		
		val hbaseHostLabel = new Label(hbaseGrp, SWT.LEFT)
		hbaseHostLabel.setLayoutData(new GridData(SWT.LEFT))
		hbaseHostLabel.setText("Host:")

		val hbaseHostText = new Text(hbaseGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		hbaseHostText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
	
		control = scCont
	}
	
	override getName() {
		DMGenConfigurationAttributes.TAB_GENARATION_NAME
	}
	
	override initializeFrom(ILaunchConfiguration configuration) {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override performApply(ILaunchConfigurationWorkingCopy configuration) {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def private rebuild() {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def private GenConfig findGenerator(URI uri) throws FileNotFoundException {
		val rs = new ResourceSetImpl
		val resource = rs.getResource(uri, true)
		try {
			
			if (resource == null)
				throw new Exception()
			resource.contents.findFirst[e|e instanceof GenConfig] as GenConfig
		} catch (Exception e) {
			throw new FileNotFoundException("Resource not found with URI: "+URI.toString)
		}
		
		null
		
	}

}