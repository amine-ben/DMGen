package fr.inria.diverse.dmgen.ui.handlers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	
	private static final String BUNDLE_NAME = "fr.inria.diverse.dmgen.ui.handlers.messages"; //$NON-NLS-1$

	public static String RunGenerationHandlerError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		
	}
}
