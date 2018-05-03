package fr.inria.diverse.dmgen.launcher

import com.google.inject.Injector
import fr.inria.diverse.dmgen.DMGenStandaloneSetupGenerated

import org.eclipse.core.runtime.CoreException
import java.io.IOException
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.ResourceSet

abstract class ExecutionEnvImpl implements ExecutionEnv {

	// Injecting the DMgen metamodel and setting up the resourceset	
	protected val Injector injector = new DMGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration

	protected val ResourceSet resourceSet = new ResourceSetImpl
	
	// runtime arguments	
	protected var String metamodelURL
	protected var String dmgenURL
	
	//protected var boolean isLocal
	protected var String ePackageImpl
	protected var String persistenceScheme
	protected var String basePath
	//
	
	//protected var String hbaseMaster
	protected var String executors
	
	
	// FIXME Active annotation (@Accessors) not working
	// Implementing Class accessors manually for now
	
	def setBasePath(String master) {
		basePath = master
	}

	def setExecutors(String nodes) {
		executors = nodes
	}
	//application arguments 
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
