package fr.inria.diverse.dmgen.ui.launch

import com.google.inject.Injector
import fr.inria.diverse.dmgen.DMGenStandaloneSetupGenerated
import fr.inria.diverse.dmgen.Launcher.DMGenConstants
import fr.inria.diverse.dmgen.Launcher.ExecutionEnv
import fr.inria.diverse.dmgen.util.DMGenUtil
import java.io.IOException
import java.util.Collections
import java.util.Map.Entry
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
	
	// Initializing variables for Spark Context & launching the model generation
	new ExecutionEnv().initializeFromConfiguration(configuration).launch 
 }
	/**
	 * Initializes the execution environment from the executor 
	 * @param {@link ExecutionEnv} <code>executionEnv</code>
	 * @param {@link IConfiguration} <code>configuration</code>
	 */	
	def ExecutionEnv initializeFromConfiguration(ExecutionEnv executionEnv, 
														ILaunchConfiguration configuration) 
														throws IOException {
		
		// fetching attributes from the launch configuration
		executionEnv.sparkMaster = configuration.getAttribute(DMGenConfigurationAttributes.SPARK_HOST_NAME,
													DMGenConstants.SPARK_HOST_NAME_DEFAULT)
		executionEnv.hbaseMaster = configuration.getAttribute(DMGenConfigurationAttributes.HBASE_HOST_NAME, 
													DMGenConstants.HBASE_HOST_NAME_DEFAULT)
		executionEnv.metamodelURL = configuration.getAttribute(DMGenConfigurationAttributes.METAMODEL_NAME, 
												    StringUtils.EMPTY)
		executionEnv.fsMaster = configuration.getAttribute(DMGenConfigurationAttributes.FS_HOST_NAME,
															DMGenConstants.FS_HOST_NAME_DEFAULT)
		executionEnv.executors = configuration.getAttribute(DMGenConfigurationAttributes.SPARK_NODES_NUMBER, 
												  DMGenConfigurationAttributes.SPARK_NODES_NUMBER_DEFAULT)
		
		val editor = EditorUtils.getActiveXtextEditor()
			
		if (editor != null) {		
			val genFile  =  (editor.getEditorInput() as FileEditorInput).getFile();
			try{
				executionEnv.dmgenURL =  DMGenUtil.exportXMI(genFile.fullPath.toOSString, resourceSet).toFileString				
			}catch (IOException e) {
				LOG.error(String.format("The file {0} is not found", genFile.fullPath.toOSString()), e)
				throw e
			}catch (Exception e) {
				LOG.error(e.message, e);
			}
		}  else {
			val dmgenFileName = configuration.getAttribute(DMGenConfigurationAttributes.DMGEN_FILE_NAME, StringUtils.EMPTY)
			if ( dmgenFileName != StringUtils.EMPTY) {
				 executionEnv.dmgenURL = DMGenUtil.exportXMI(dmgenFileName, resourceSet).toFileString					 
			} else {
				throw new IOException("Unable to find active DMGen file")	
			}
			
		}

		val envMap = configuration.getAttribute("org.eclipse.debug.core.environmentVariables", Collections.EMPTY_MAP)
		
		for (Entry<String, String> entry : envMap.entrySet) {
			if (entry.key == "SPARK_HOME") executionEnv.sparkHomePath  = entry.value as String
			else if (entry.key == "HADOOP_CONF_DIR") executionEnv.yarnConfPath = entry.value as String
		}

		return executionEnv
	}
					
}
