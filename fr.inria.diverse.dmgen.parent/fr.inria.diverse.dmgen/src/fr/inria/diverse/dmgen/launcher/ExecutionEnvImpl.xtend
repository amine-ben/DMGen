package fr.inria.diverse.dmgen.launcher

import com.google.inject.Injector
import fr.inria.diverse.dmgen.DMGenStandaloneSetupGenerated

import org.eclipse.core.runtime.CoreException
import org.eclipse.xtext.resource.XtextResourceSet
import java.io.IOException

abstract class ExecutionEnvImpl implements ExecutionEnv {

	// Injecting the DMgen metamodel and setting up the resourceset	
	protected val Injector injector = new DMGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration

	protected val XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet)

	// runtime arguments	
	protected var String metamodelURL
	protected var String dmgenURL
	
	//protected var boolean isLocal
	protected var String ePackageImpl
	protected var String persistenceScheme
	// application arguments 
	
	def getPresistenceScheme() {
		persistenceScheme
	}
	
	def setPersistenceScheme (String scheme) {
		persistenceScheme = scheme
	}
	
	def getMetamodelURL() {
		metamodelURL
	}

	def setMetamodelURL(String url) {
		metamodelURL = url
	}

	def setEPackageImpl(String pck) {
		ePackageImpl = pck
	}

	def getDmgenURL() {
		dmgenURL
	}

	def setDmgenURL(String dmgen) {
		dmgenURL = dmgen
	}

	/**
	 * Default constructor
	 */
	 
	new() {
		super()
	}

	/**
	 * Creates a new {@link ExecutionEnv} instance using 
	 * @param {@link String} <code>metamodelURL</code>
	 * @param {@link String} <code>dmgenURL</code>
	 * @param {@link String} <code>ePackage</code>
	 * @param {@link Boolean} <code>isLocal</code>
	 */
	new(String dmgenURL, String metamodelURL, String ePackage) {
		this.dmgenURL = dmgenURL
		this.metamodelURL = metamodelURL
		this.ePackageImpl = ePackage		
	}

	abstract override launch() throws CoreException

	abstract override setupEnv() throws IOException, CoreException

} // End Execution Environment
