/*
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen.ui

import fr.inria.diverse.dmgen.ui.launch.DMGenLaunchConfiguration
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.debug.core.model.LaunchConfigurationDelegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import fr.inria.diverse.dmgen.ui.handlers.RunGenerationHandler

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class DMGenUiModule extends AbstractDMGenUiModule {

	def Class<? extends AbstractHandler> bindAbstractHandler() {
		return RunGenerationHandler 
	}
	
	def Class<? extends LaunchConfigurationDelegate > bindLaunchConfigurationDelagate () {
		return DMGenLaunchConfiguration
	}
}
