/*
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen.ui

import fr.inria.diverse.dmgen.ui.handlers.RunGenerationHandler
import fr.inria.diverse.dmgen.ui.launch.DMGenLaunchConfiguration
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.debug.core.model.LaunchConfigurationDelegate
import org.eclipse.ui.plugin.AbstractUIPlugin

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
class DMGenUiModule extends AbstractDMGenUiModule {

	new(AbstractUIPlugin plugin) {
		super(plugin)
	}
	
	def Class<? extends AbstractHandler> bindAbstractHandler() {
		return RunGenerationHandler 
	}
	
	def Class<? extends LaunchConfigurationDelegate > bindLaunchConfigurationDelagate () {
		return DMGenLaunchConfiguration
	}
}
