package fr.inria.diverse.dmgen.ui.launch


import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.dialogs.ElementListSelectionDialog
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin
import org.eclipse.emf.ecore.plugin.EcorePlugin
import java.util.Arrays
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import java.util.ArrayList
import java.util.List

/**
 * Derived from org.eclipse.m2m.atl.adt.ui.common.RegisteredPackageDialog 
 */
class RegisteredPackageDialog extends ElementListSelectionDialog{
	
//	boolean isDevelopmentTimeVersion
//	boolean isRuntimeOnly =false
	new(Shell parent) {
		super(parent, new LabelProvider)
		setMultipleSelection(false) 
		setMessage("selecting the imported package")  //$NON-NLS-1$
		setFilter("*")  //$NON-NLS-1$
		setTitle("EPackage Registry")  //$NON-NLS-1$
	}

	override Control createDialogArea (Composite parent) {
		val result = super.createDialogArea(parent) as Composite 
//		val buttonGroup = new Composite(result, SWT.NONE) 
//		val layout = new GridLayout() 
//		layout.numColumns = 2 
//		buttonGroup.setLayout(layout) 
//		val developmentTimeVersionButton = new Button(buttonGroup, SWT.RADIO) 
//		developmentTimeVersionButton.selection = true
//		
//		developmentTimeVersionButton.addSelectionListener(new SelectionAdapter() {
//	
//			override widgetSelected(SelectionEvent event) {
//				isDevelopmentTimeVersion = developmentTimeVersionButton.getSelection() 
//				updateElements
//			}
//	
//		}) 
//		developmentTimeVersionButton.setText(EcoreEditorPlugin.INSTANCE
//				.getString("_UI_DevelopmentTimeVersion_label"))  //$NON-NLS-1$
////		val runtimeTimeVersionButton = new Button(buttonGroup, SWT.RADIO)
////		runtimeTimeVersionButton.setText(EcoreEditorPlugin.INSTANCE.getString("_UI_RuntimeVersion_label"))  //$NON-NLS-1$
////		runtimeTimeVersionButton.enabled = false

		updateElements

		return result 
	}
	
	def public String getResultAsString() {
		var results = getResult() as Object[] 
		
		if (results != null && results.length == 1) {
			val nsURI = result.get(0) 
				val resourceSet = new ResourceSetImpl()
				resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap())
				val ePackageNsURItoGenModelLocationMap = EcorePlugin
						.getEPackageNsURIToGenModelLocationMap()

				val location = ePackageNsURItoGenModelLocationMap.get(nsURI)
				val resource = resourceSet.getResource(location, true)
				EcoreUtil.resolveAll(resource)
	
				val rscResult  = resourceSet.resources.map[rs | rs.allPackages].flatten.findFirst[pck | nsURI.equals(pck.nsURI)].eResource
				
				return if (rscResult == null) 
							nsURI.toString
					   else 
					   		rscResult.URI.toString			
				
		}
		return null 
	}
	
	def private updateElements() {
 
			val result =EPackage.Registry.INSTANCE.keySet()
							.toArray(newArrayOfSize(EPackage.Registry.INSTANCE.size()))
		
			Arrays.sort(result) 
			setListElements(result) 
		}	
	
	
	def private List<EPackage> allPackages(Resource resource) {
		val result = new ArrayList<EPackage>
		resource.allContents.forEach[elm | if (elm instanceof EPackage) result.add(elm as EPackage)] 
		return result
	} 
}