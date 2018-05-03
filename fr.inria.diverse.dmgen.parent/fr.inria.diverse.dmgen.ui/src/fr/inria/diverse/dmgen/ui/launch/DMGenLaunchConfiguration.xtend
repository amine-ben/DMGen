package fr.inria.diverse.dmgen.ui.launch

import com.google.inject.Injector
import fr.inria.diverse.dmgen.DMGenStandaloneSetupGenerated
import fr.inria.diverse.dmgen.launcher.DistributedExecutionEnvImpl
import fr.inria.diverse.dmgen.launcher.ExecutionEnv
import fr.inria.diverse.dmgen.launcher.ExecutionEnvImpl
import fr.inria.diverse.dmgen.util.DMGenUtil
import java.io.IOException
import org.apache.commons.lang3.StringUtils
import org.apache.log4j.Logger
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.debug.core.ILaunch
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.model.LaunchConfigurationDelegate
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import fr.inria.diverse.dmgen.launcher.LocalExecutionEnvImpl

class DMGenLaunchConfiguration extends LaunchConfigurationDelegate {
	
// The logger of the instance
	static val LOG = Logger.getLogger(DMGenLaunchConfiguration)

// RessourceSet	
	val Injector injector = new DMGenStandaloneSetupGenerated()
            .createInjectorAndDoEMFRegistration();
    
	val  XtextResourceSet resourceSet = injector
    		.getInstance(XtextResourceSet);
	
	override launch(ILaunchConfiguration configuration, 
						String mode, 
						ILaunch launch, 
						IProgressMonitor monitor
	) throws CoreException {
		var isLocal = configuration.getAttribute(DMGenConfigurationAttributes.SPARK_HOST_NAME,"")
								   .equals(DMGenConfigurationAttributes.SPARK_MASTER_ARRAY.get(1))
		 ExecutionEnvFactory.create(isLocal)
							.initializeFromConfiguration(configuration)
							.launch
 }
	/**
	 * Initializes the execution environment from the executor 
	 * @param {@link ExecutionEnv} <code>executionEnv</code>
	 * @param {@link IConfiguration} <code>configuration</code>
	 */	
	def ExecutionEnv initializeFromConfiguration(ExecutionEnv executionEnv, 
													ILaunchConfiguration configuration) 
													throws IOException {
		
	
		val editor = EditorUtils.getActiveXtextEditor()
		val execEnvImpl = executionEnv as ExecutionEnvImpl	
			
		if (editor != null) {		
			val genFile  =  (editor.getEditorInput() as FileEditorInput).getFile();
			try{
				execEnvImpl.dmgenURL = DMGenUtil.exportDMgentoXMI(genFile.fullPath.toOSString, resourceSet).toFileString
			} catch (IOException e) {
				LOG.error(String.format("The file {0} is not found", genFile.fullPath.toOSString()), e)
				throw e
			} 
		} else {
			val dmgenFileName = configuration.getAttribute(DMGenConfigurationAttributes.DMGEN_FILE_NAME, StringUtils.EMPTY)
			
			if ( !dmgenFileName.equals(StringUtils.EMPTY)) {
				execEnvImpl.dmgenURL = DMGenUtil.exportDMgentoXMI(dmgenFileName, resourceSet).toFileString					 
			} else {
				throw new IOException("Unable to find active DMGen file")	
			}
		}	
		
		execEnvImpl.persistenceScheme = configuration.getAttribute(DMGenConfigurationAttributes.PERSISTENCE_SCHEME, "")
		execEnvImpl.metamodelURL = configuration.getAttribute(DMGenConfigurationAttributes.METAMODEL_NAME, "")
		
		// distribution specific parameters 
		//if (execEnvImpl instanceof DistributedExecutionEnvImpl) {
		execEnvImpl.basePath = configuration.getAttribute(DMGenConfigurationAttributes.BASE_PATH, StringUtils.EMPTY)
		execEnvImpl.executors = configuration.getAttribute(DMGenConfigurationAttributes.EXECUTORS, StringUtils.EMPTY)
			//distExec.hbaseMaster = configuration.getAttribute(DMGenConfigurationAttributes., StringUtils.EMPTY)
		//}
		return execEnvImpl
	}
					
}
