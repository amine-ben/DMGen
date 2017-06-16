package fr.inria.diverse.dmgen.ui.handlers

import org.eclipse.osgi.util.NLS

class Messages extends NLS {
	
	public static val String BUNDLE_NAME = "fr.inria.diverse.dmgen.ui.handlers.messages"; //$NON-NLS-1$

	public static var String RunGenerationHandlerError;
	
	public static var String RunGenerationXMIEroor; 

	
		// initialize resource bundle
	static val isInit = try {
							 NLS.initializeMessages(BUNDLE_NAME, Messages)
							  true
						 } catch (Exception e) {
						 	
						 }
							  

}