package fr.inria.diverse.dmgen.ui.launch

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup
import org.eclipse.debug.ui.ILaunchConfigurationDialog
import org.eclipse.debug.ui.CommonTab

class DMGenTabGroup extends AbstractLaunchConfigurationTabGroup {
	
	override createTabs(ILaunchConfigurationDialog dialog, String mode) {
		tabs = #{ new CommonTab , 
					new DMGenMainTab
				}
	}	
}