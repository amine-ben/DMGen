package fr.inria.diverse.dmgen.ui.launch

import org.eclipse.debug.core.model.LaunchConfigurationDelegate
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunch
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.CoreException

class DMGenLaunchConfiguration extends LaunchConfigurationDelegate {
	
	override launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		val attribute = configuration.getAttribute(DMGenConfigurationAttributes.SPARK_HOST, DMGenConfigurationAttributes.SPARK_HOST_DEFAULT)
		println(attribute)
	}
	
}