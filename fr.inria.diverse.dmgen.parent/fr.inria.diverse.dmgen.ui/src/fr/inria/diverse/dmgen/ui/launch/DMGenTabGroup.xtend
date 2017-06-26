package fr.inria.diverse.dmgen.ui.launch

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup
import org.eclipse.debug.ui.ILaunchConfigurationDialog
import org.eclipse.debug.ui.CommonTab
import org.eclipse.debug.ui.EnvironmentTab

class DMGenTabGroup extends AbstractLaunchConfigurationTabGroup {
	
	override createTabs(ILaunchConfigurationDialog dialog, String mode) {
		tabs = #{ new DMGenMainTab, new CommonTab, new EnvironmentTab}
	}	
}