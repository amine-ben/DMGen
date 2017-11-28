package fr.inria.diverse.dmgen.ui.launch

import fr.inria.diverse.dmgen.launcher.DistributedExecutionEnvImpl
import fr.inria.diverse.dmgen.launcher.ExecutionEnv
import fr.inria.diverse.dmgen.launcher.LocalExecutionEnvImpl

class ExecutionEnvFactory {
	/**
	 * @param <code>isLocal</code>
	 *  A {@link Boolean} determining the execution mode of the generator
	 */
	static def ExecutionEnv create(boolean isLocal) {
		if(isLocal)	
			new LocalExecutionEnvImpl
		else 
			new DistributedExecutionEnvImpl
	} 
	
}