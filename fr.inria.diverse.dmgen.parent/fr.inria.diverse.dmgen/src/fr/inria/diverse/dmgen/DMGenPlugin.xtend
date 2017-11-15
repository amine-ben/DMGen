package fr.inria.diverse.dmgen

import com.google.common.collect.Maps
import com.google.inject.Injector
import java.util.Collections
import java.util.Map
import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext

class DMGenPlugin implements BundleActivator {
	
	//static val FR_INRIA_DIVERSE_DMGEN_ = "fr.inria.diverse.dmgen"
	
	//static val LOGGER = Logger.getLogger(typeof(DMGenPlugin))
	
	private static DMGenPlugin INSTANCE
	
	private Map<String, Injector> injectors = Collections.synchronizedMap(Maps.<String, Injector> newHashMapWithExpectedSize(1))
	
	override start(BundleContext context) throws Exception {
		//.start(context)
		INSTANCE = this
	}
	
	override stop(BundleContext context) throws Exception {
		injectors.clear()
		INSTANCE = null
		//super.stop(context)
	}
	
	def static DMGenPlugin getInstance() {
		return INSTANCE
	}
	
}