package fr.inria.diverse.dmgen.ui.launch

import fr.inria.diverse.dmgen.DMGenStandaloneSetup
import fr.inria.diverse.dmgen.dMGen.GenConfig
import fr.inria.diverse.dmgen.ui.internal.DmgenActivator
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.Path
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.jface.dialogs.Dialog
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.ScrolledComposite
import org.eclipse.swt.events.FocusEvent
import org.eclipse.swt.events.FocusListener
import org.eclipse.swt.events.ModifyEvent
import org.eclipse.swt.events.ModifyListener
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.PlatformUI
import javax.annotation.Nonnull
import java.util.Set

/**
 * Derived from EMFTVM Launcher @link 
 */
class DMGenMainTab extends AbstractLaunchConfigurationTab {
	
	
	var boolean moduleChanged
	
	var GenConfig genConfig
	
	// launch configuration attributes  
	var String moduleName
	
	var String modulePath
	
	var String metamodel
	
	var String sparkHost
	
	var String basePath
	
	var String moduleFileName
	
	var String numberOfNodes
	
	var String persistenceScheme
	
	// launch configuration UI
	
	var IFile moduleFile
	
	var Text moduleNameText
	
	var Text modulePathText
	
	var Text metamodelFileText
	
	var Combo sparkMasterCombo
	
	var Combo localBackendCombo
	
	var Combo distributedBackendCombo
	
	var Text distBasePathText
	
	var Text localBasePathText
	
	var Text sparkNodesText
	
	var Group distGrp
	
	var Group localGrp
	//EMF-Related variables
	
	val ResourceSet rs = new ResourceSetImpl
	
	/**
	 * {@inheritDoc}
	 */
	override createControl(Composite parent) {
		
		
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
		
		var moduleFileLabel = new Label(moduleGrp, SWT.LEFT)
		moduleFileLabel.setLayoutData(new GridData(SWT.LEFT))
		moduleFileLabel.setText("Module:")

		moduleNameText = new Text(moduleGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		moduleNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		
		// Adding a focus listener to text field
		moduleNameText.addFocusListener(new FocusListener() {
			
			override focusGained(FocusEvent e) {
				// Do nothing
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
				if ((moduleName != moduleNameText.text).operator_or(modulePath != modulePathText.text))
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
			
				val extensions =  {DMGenConfigurationAttributes.DEFAULT_EXTENSION}
				val dialog = new WorkspaceFileDialog(shell, extensions)
				
				val result = if (dialog.open ==  Dialog.OK )
							 	dialog.firstResult 
							 else  null
				if ((result != null) && (result instanceof IFile)) {
					{
					moduleFile = result as IFile 
					val path = moduleFile.fullPath
					moduleNameText.text = path.lastSegment.substring(0, path.lastSegment.lastIndexOf('.'))
					modulePathText.text = path.removeLastSegments(1).toOSString
					moduleFileName = path.toOSString
					
					val uri = URI.createPlatformResourceURI(moduleFileName, true)
						try {		
							val resource = rs.getResource(uri, true)
						
							if (resource == null)
								throw new Exception()
							genConfig = resource.contents.findFirst[elem|elem instanceof GenConfig] as GenConfig
							
						} catch (Exception exception) {
							errorMessage =  exception.message
							System.err.println(exception.message)
						}
									rebuild
					
					}
				}
			}
			
		})
		
		var modulePathLabel = new Label(moduleGrp, SWT.LEFT)
		modulePathLabel.setLayoutData(new GridData(SWT.LEFT))
		modulePathLabel.setText("Path:") 
		
		modulePathText = new Text(moduleGrp, SWT.SINGLE.bitwiseOr( SWT.BORDER))
		val modulePathData = new GridData(GridData.FILL_HORIZONTAL) 
		modulePathData.horizontalSpan = 2 
		modulePathText.layoutData = modulePathData 
		modulePathText.addFocusListener(new FocusListener() {
			override focusLost(FocusEvent e) {
				if (moduleChanged) {
					rebuild
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
							rebuild 
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

		metamodelFileText = new Text(metamodelGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		metamodelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)) 
		metamodelFileText.layoutData = modulePathData 
		
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
					metamodelFileText.text = "platform:/resource" + path
					updateLaunchConfigurationDialog
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
					metamodelFileText.text = "file:/" + fileName
					updateLaunchConfigurationDialog
				}
			}
		}) 
		
		val browseEMFRegistry = new Button(metamodelGrp, SWT.RIGHT) 
		browseEMFRegistry.setText("EMF registry...") 
		browseEMFRegistry.addSelectionListener(new SelectionAdapter() {
			override widgetSelected(SelectionEvent evt) {
				val dialog = new RegisteredPackageDialog(shell) 
				if (dialog.open() == Dialog.OK) {
					metamodelFileText.text = dialog.getResultAsString() 
					updateLaunchConfigurationDialog
				}
			}
		}) 
			
		val sparkGrp = new Group(rootCont, SWT.NULL)
		sparkGrp.text = DMGenConfigurationAttributes.SPARK_GROUP_NAME
		sparkGrp.layoutData = new GridData(GridData.FILL_HORIZONTAL)
		sparkGrp.layout = new GridLayout (4, false)
		
		val sparkHostLabel = new Label(sparkGrp, SWT.NULL)
		sparkHostLabel.setLayoutData(new GridData(SWT.NULL))
		sparkHostLabel.setText("Deploy mode:")
		
		sparkMasterCombo = new Combo(sparkGrp, SWT.READ_ONLY)
		sparkMasterCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		sparkMasterCombo.items = DMGenConfigurationAttributes.SPARK_MASTER_ARRAY
		sparkMasterCombo.addSelectionListener(new SelectionListener() {	

				override widgetDefaultSelected(SelectionEvent e) {
					sparkHost = sparkMasterCombo.text
					updateLaunchConfigurationDialog
					hidePathContent
				}
				
				override widgetSelected(SelectionEvent e) {
					sparkHost = sparkMasterCombo.text
					updateLaunchConfigurationDialog
					hidePathContent
				}
				
		})
		
		val sparkNodesLabel = new Label(sparkGrp, SWT.NULL)
		sparkNodesLabel.text = "Nodes:"
		sparkNodesLabel.layoutData = new GridData(SWT.NULL)
		
		sparkNodesText = new Text(sparkGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		
		
		distGrp = new Group(rootCont, SWT.NULL)
		distGrp.text = DMGenConfigurationAttributes.HBASE_GROUP_NAME
		distGrp.layoutData = new GridData(GridData.FILL_HORIZONTAL)
		distGrp.layout = new GridLayout (3, false)
		
		val hbaseHostLabel = new Label(distGrp, SWT.LEFT)
		hbaseHostLabel.setLayoutData(new GridData(SWT.LEFT))
		hbaseHostLabel.setText("Distributed backend:")

		distributedBackendCombo = new Combo(distGrp, SWT.READ_ONLY)
		distributedBackendCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		distributedBackendCombo.items = DMGenConfigurationAttributes.NEOEMF_HBASE_SCHEMES
		distributedBackendCombo.addSelectionListener(new SelectionListener() {	

				override widgetDefaultSelected(SelectionEvent e) {
					persistenceScheme = distributedBackendCombo.text
					updateLaunchConfigurationDialog
					hidePathContent
				}
				
				override widgetSelected(SelectionEvent e) {
					persistenceScheme = distributedBackendCombo.text
					updateLaunchConfigurationDialog
					hidePathContent
				}
		})
		distBasePathText = new Text(distGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		distBasePathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		distBasePathText.addModifyListener(new ModifyListener() {	
			override modifyText(ModifyEvent e) {
				basePath = distBasePathText.text
				updateLaunchConfigurationDialog
				}
		})
		
	
		localGrp = new Group(rootCont, SWT.NULL)
		localGrp.text = DMGenConfigurationAttributes.XMI_GROUP_NAME
		localGrp.layoutData = new GridData(GridData.HORIZONTAL_ALIGN_FILL)
		localGrp.layout = new GridLayout (3, false)
		
		val xmiLabel = new Label(localGrp, SWT.LEFT)
		xmiLabel.setLayoutData(new GridData(SWT.LEFT))
		xmiLabel.setText("Local backend:")

		localBackendCombo = new Combo(localGrp, SWT.READ_ONLY)
		localBackendCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		localBackendCombo.items = DMGenConfigurationAttributes.NEOEMF_STANDALONE_SCHEMES
		
		localBackendCombo.addSelectionListener(new SelectionListener() {	

				override widgetDefaultSelected(SelectionEvent e) {
					persistenceScheme = localBackendCombo.text
					updateLaunchConfigurationDialog
					hidePathContent
				}
				
				override widgetSelected(SelectionEvent e) {
					persistenceScheme = localBackendCombo.text
					updateLaunchConfigurationDialog
					hidePathContent
				}
				
		})
		
		localBasePathText = new Text(localGrp, SWT.SINGLE.bitwiseOr(SWT.BORDER))
		localBasePathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		localBasePathText.addModifyListener(new ModifyListener() {	
			override modifyText(ModifyEvent e) {
				if (localBasePathText.text != null ) {
				basePath = localBasePathText.text
				updateLaunchConfigurationDialog
				}				
			}
		})
		control = scCont
	}
	/*
	 * 
	 */
	def hidePathContent() {
		if (sparkMasterCombo.text.equals(DMGenConfigurationAttributes.SPARK_MASTER_ARRAY.get(0))) {
			localGrp.visible = false
			distGrp.visible = true
	 	} else {
	 		localGrp.visible = true
			distGrp.visible = false
	 	} 
	}
	/**
	 * {@inheritDoc}
	 */
	override getName() {
		DMGenConfigurationAttributes.TAB_GENARATION_NAME
	}
	/**
	 * {@inheritDoc}
	 */
	override initializeFrom(ILaunchConfiguration conf) {

		// if newly created configuration --> do nothing 
		if (conf != null) { 
		
			// load values from configuration   
			moduleName = conf.getAttribute(DMGenConfigurationAttributes.MODULE_NAME, "")
			moduleNameText.text = moduleName
			
			moduleFileName = conf.getAttribute(DMGenConfigurationAttributes.DMGEN_FILE_NAME, "")
			
			// loading the genConf & initiliazing the hbase
			if (moduleFileName != null && moduleFileName != "") {
				loadGenConfig(moduleFileName)
			}
				
			modulePath = conf.getAttribute(DMGenConfigurationAttributes.MODULE_PATH, "")
			modulePathText.text = modulePath
			
			metamodel = conf.getAttribute(DMGenConfigurationAttributes.METAMODEL_NAME, "")
			metamodelFileText.text =  metamodel
			
			sparkHost = conf.getAttribute(DMGenConfigurationAttributes.SPARK_HOST_NAME, "")
			sparkMasterCombo.text = sparkHost
			persistenceScheme = conf.getAttribute(DMGenConfigurationAttributes.PERSISTENCE_SCHEME, "")
			val schemeIndex = DMGenConfigurationAttributes.NEOEMF_HBASE_SCHEMES.indexOf(persistenceScheme)
			if (sparkHost == DMGenConfigurationAttributes.SPARK_MASTER_ARRAY.get(0)) {
				basePath = conf.getAttribute(DMGenConfigurationAttributes.BASE_PATH, "")
				distBasePathText.text = basePath	
				if (schemeIndex > -1) 
					distributedBackendCombo.text = DMGenConfigurationAttributes.NEOEMF_HBASE_SCHEMES.get(schemeIndex)
											
			} else {
				basePath = conf.getAttribute(DMGenConfigurationAttributes.BASE_PATH, "")
				localBasePathText.text = basePath
				if (schemeIndex > -1)
					localBackendCombo.text = DMGenConfigurationAttributes.NEOEMF_STANDALONE_SCHEMES.get(schemeIndex)
			}
			
			numberOfNodes = conf.getAttribute(DMGenConfigurationAttributes.EXECUTORS, "8")
			sparkNodesText.text = numberOfNodes
			
			hidePathContent
			
			//update configuration values 
		}
	}
	
	def loadGenConfig(@Nonnull String module) {
		new DMGenStandaloneSetup().createInjectorAndDoEMFRegistration()
		val resource = rs.getResource(URI.createURI(module),true)
		genConfig = resource.contents.head as GenConfig
		
		
 		
	}
	
	/**
	 * {@inheritDoc}
	 *FIXME
	 * 
	 */
	override performApply(ILaunchConfigurationWorkingCopy conf) {
		// load values from configuration   
		conf.setAttribute(DMGenConfigurationAttributes.MODULE_NAME, moduleNameText.text)
		conf.setAttribute(DMGenConfigurationAttributes.MODULE_PATH, modulePathText.text)
		conf.setAttribute(DMGenConfigurationAttributes.METAMODEL_NAME, metamodelFileText.text)
		conf.setAttribute(DMGenConfigurationAttributes.SPARK_HOST_NAME, sparkMasterCombo.text)
		conf.setAttribute(DMGenConfigurationAttributes.PERSISTENCE_SCHEME,persistenceScheme)
		conf.setAttribute(DMGenConfigurationAttributes.FS_HOST_NAME, genConfig.hdfsMaster.uriToString)
		if (sparkMasterCombo.text ==
				DMGenConfigurationAttributes.SPARK_MASTER_ARRAY.get(0)) 
			conf.setAttribute(DMGenConfigurationAttributes.BASE_PATH, distBasePathText.text)
		else 
			conf.setAttribute(DMGenConfigurationAttributes.BASE_PATH, localBasePathText.text)
		conf.setAttribute(DMGenConfigurationAttributes.DMGEN_FILE_NAME, moduleFileName)
		conf.setAttribute(DMGenConfigurationAttributes.EXECUTORS, sparkNodesText.text)
	}
	
		/**
	 * {@inheritDoc}
	 */
	override setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	 override boolean isValid(ILaunchConfiguration conf) {
	 	
	 	// TODO this a very basic valid Check should be elaborated
	 	errorMessage = null
	 	
	 	if(moduleNameText.text.empty) {
	 		errorMessage =  "No dmgen module is given"
	 		return false 
	 	}
	 	if(modulePathText.text.empty) {
	 		errorMessage =  "No path is provided"
	 		return false 
	 	} 
	 	if (metamodelFileText.text.empty) {
	 		errorMessage =  "No metamodel is provided"
	 		return false 
	 	} 
	 	if (sparkMasterCombo.text.empty) {
	 		errorMessage =  "No spark host is provided"
	 		return false 
	 	} 
	 	if (sparkMasterCombo.text == DMGenConfigurationAttributes.SPARK_MASTER_ARRAY.get(0)
	 		&& distBasePathText.text.empty) {
	 		errorMessage =  "No hbase host is provided"
	 		return false 
	 	} if (sparkMasterCombo.text == DMGenConfigurationAttributes.SPARK_MASTER_ARRAY.get(1)
	 		&& localBasePathText.text.empty) {
	 		errorMessage =  "No XMI base path is provided"
	 		return false }
	 	return super.isValid(conf)
	 } 
	 
	 /**
	  * {@inheritDoc} 
	  */
	  override Image getImage() {
	  	val path =  DMGenConfigurationAttributes.PATH_ICON
	  	val url = FileLocator.find(DmgenActivator.instance.bundle, new Path(path), null)
	  	ImageDescriptor.createFromURL(url).createImage
	   }
	  	
	  
	/**
	 * Rebuilding UI and updating Label values 
	 */
	 
	def private rebuild() {		
		resetAll
		build		
	}
	                 
	def private build() {
		
		metamodelFileText.text = genConfig.metamodel.uri.toPrettyString ?: metamodel
		sparkMasterCombo.text = genConfig.deployMode 

	    if (genConfig.numberOfNodes != null)
	    	sparkNodesText.text = genConfig.numberOfNodes.toString ?: numberOfNodes
									
		if (genConfig.hbaseMaster != null)
			distBasePathText.text = genConfig.hbaseMaster.toPrettyString ?: basePath
			
	}
		
	def String toPrettyString(fr.inria.diverse.dmgen.dMGen.URI uri) {
		val StringBuilder builder = new StringBuilder(uri.scheme)
		for ( frag : uri.fragments) {
			builder.append(frag)
			builder.append('/')
		}
		builder.toString
	}
	
	def String uriToString(fr.inria.diverse.dmgen.dMGen.URI uri) {
		val StringBuilder builder = new StringBuilder(uri.scheme)
		for ( frag : uri.fragments) {
			builder.append(frag)
			builder.append('/')
		}
		builder.toString
	}
	
	
	def boolean assertNotNull(Object object) {
		if (object == null)
			throw new RuntimeException (object.toString + " is null")
	}
	
	def resetAll() {
		moduleChanged = false
		moduleName = moduleNameText.text
		modulePath = modulePathText.text
		sparkHost = sparkMasterCombo.text
		basePath = distBasePathText.text
		numberOfNodes = sparkNodesText.text	
		hidePathContent
	}
	
}