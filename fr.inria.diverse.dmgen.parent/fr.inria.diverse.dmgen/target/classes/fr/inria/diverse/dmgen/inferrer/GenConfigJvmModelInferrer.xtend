package fr.inria.diverse.dmgen.inferrer

import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import javax.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import fr.inria.diverse.dmgen.dMGen.GenConfig

class GenConfigJvmModelInferrer extends AbstractModelInferrer {
	
	@Inject extension JvmTypesBuilder
 
  def dispatch void infer(GenConfig generator, 
                          IJvmDeclaredTypeAcceptor acceptor, 
                          boolean isPreIndexingPhase) {
    val className = generator.eResource.URI.trimFileExtension.lastSegment
   	acceptor.accept(generator.toClass(className))[
	      // the class gets one main method
	      	members += generator.toMethod('main', typeRef(Void.TYPE)) [
	   	    parameters += generator.toParameter("args",  typeRef(String).addArrayTypeDimension)
	   	    static = true
	        varArgs = true
	        // Associate the script as the body of the main method
	        //body = generator
      ]	
    ]
  }
}

