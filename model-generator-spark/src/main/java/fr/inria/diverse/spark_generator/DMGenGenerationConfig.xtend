package fr.inria.diverse.spark_generator

import fr.inria.diverse.dmgen.Generator
import fr.inria.diverse.spark_generator.specimen.ISpecimenConfiguration
import java.util.HashMap
import java.util.Map
import java.util.Random
import org.apache.commons.lang3.Range
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author <a href="mailto:abel.gomez-llana@inria.fr">Abel Gomez</a>
 * @author <A href="mailto:amine.benelallam@inria.fr">Amine Benelallam</a>
 *
 */
class DMGenGenerationConfig extends GenericMetamodelConfig implements DMGenConfiguration {
	
	
	@Accessors protected var Generator dmgenModule
	
	@Accessors (PUBLIC_GETTER, PROTECTED_SETTER) protected var Map<String, Map<String,Range<Integer>>> perClassPropertiesRange
	
	@Accessors (PUBLIC_GETTER, PROTECTED_SETTER) protected var Map<String, Map<String,Range<Integer>>> perClassReferencesRange
	
	@Accessors (PUBLIC_GETTER, PROTECTED_SETTER) protected var Map<String, Map<String,Range<Integer>>> perClassValuesRange
	
	@Accessors protected var float globalVariation
	
	@Accessors protected var int globalDensity
	
	/**
	 * Creates a new {@link GenericMetamodelConfig}
	 * 
	 * @param metamodelResource
	 *            The resource containing the metamodel for which the
	 *            {@link SpecimenGenerator} will create instances
	 * 
	 * @param elementsRange
	 *            The minimum and maximum size allowed for resources created
	 *            using this {@link ISpecimenConfiguration}
	 * @param seed
	 *            The <code>seed</code> for the generator of {@link Random}
	 *            numbers. Useful to create models in a deterministic way.
	 */
	 
	new (Resource metamodelResource, Range<Integer> elementsRange, long seed) {
		super(metamodelResource, elementsRange, seed)
	}
	/**
	 * Creates a new {@link GenericMetamodelConfig}
	 * 
	 * @param metamodelResource
	 *            The resource containing the metamodel for which the
	 *            {@link SpecimenGenerator} will create instances
	 * 
	 * @param elementsRange
	 *            The minimum and maximum size allowed for resources created
	 *            using this {@link ISpecimenConfiguration}
	 * @param seed
	 *            The <code>seed</code> for the generator of {@link Random}
	 *            numbers. Useful to create models in a deterministic way.
	 * @param dmgen
	 * 			  The <code>dmgen</code> module responsible for generating the models
	 */
	new (Resource metamodelResource, Resource dmgen, Range<Integer> elementsRange, long seed ) {
		this (metamodelResource, elementsRange, seed)
		//dmgenModule = dmgen
		perClassPropertiesRange = new HashMap<String, Map<String,Range<Integer>>> 
		perClassValuesRange = new HashMap<String, Map<String,Range<Integer>>> 
		perClassReferencesRange = new HashMap<String, Map<String,Range<Integer>>> 
		
		initConfig
		
	}
	
	def initConfig() {
//		val genConfig = dmgenModule.contents.get(0) as GenConfig
		
//		globalDensity = if (genConfig.density != 0 )
//							genConfig.density 
//						else DEFAULT_AVERAGE_REFERENCES_SIZE
//						
//		globalVariation = if (genConfig.globalVariation != 0 )
//							genConfig.globalVariation 
//						 else DEFAULT_AVERAGE_REFERENCES_SIZE
//						 
//		val bundle = genConfig.generators.get(0)
					
	}
	
	override getRangeFor(EClass eCLass) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getRangeFor(EAttribute eAttribute) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getRangeFor(EReference eReference) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getDistributionFor(EAttribute eAttribute) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	override getDistributionFor(EReference eReference) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	override getDepthDistributionFor(EClass eClass) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")		
	}
}
