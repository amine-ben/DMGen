package fr.inria.diverse.dmgen.ui.tests

import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.util.ParseHelper
import com.google.inject.Inject
import fr.inria.diverse.dmgen.dMGen.GenConfig
import org.junit.BeforeClass

@RunWith (XtextRunner)
@InjectWith (typeof (DMGenUiInjectorProvider))
class SparkLocalTest {
	
	@Inject extension ParseHelper<GenConfig> parseHelper
	
	var GenConfig genConfig
	
	@BeforeClass
	def	initEnv() {
 		// Parsing genConfig example
 		genConfig = '''
			 		// adding a validation rule to check if the model exists!
			 		
			 		// the metamodel in question 
			 		import Class file:///home/amine/eclipse/workspaces/runtime-EclipseApplication/test.plugin/model/simplegt.ecore
			 		
			 		// the package implementation NeoEMF compatible
			 		package fr.inria.diverse.dag.DagImpl 
			 		
			 		// HDFS host address and port
			 		fs-master hdfs://dmhadoop:8020
			 		
			 		// adding deploy mode
			 		deploy-mode cluster [8] 
			 		// a first generator 
			 		generate 1 with size 1000 prefix 'randomgt' { 
			 			density 8;
			 			deviation 0.1;
			 			
			 		 	Module [1..1] depth 8 { 
			 		 		classes [5..8]
			 		 	};
			 		 	
			 		 	InPattern [800..1000] {
			 		 		attributes  [5..8]
			 		 	}	 	
			 		 }
		'''
 		.parse
 		  
    }
}