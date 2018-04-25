package fr.inria.diverse.generator.spark

import fr.inria.diverse.dmgen.dMGen.Clazz
import fr.inria.diverse.dmgen.dMGen.Property
import fr.inria.diverse.dmgen.dMGen.Generator
import fr.inria.diverse.generator.specimen.ISpecimenConfiguration
import java.util.HashMap
import java.util.Map
import java.util.Random
import javax.validation.constraints.NotNull
import org.apache.commons.lang3.Range
import org.apache.commons.math3.distribution.UniformIntegerDistribution
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource

/**
 * @author <A href="mailto:amine.benelallam@inria.fr">Amine Benelallam</a>
 *
 */
class DMGenGenerationConfig extends GenericMetamodelConfig implements DMGenConfiguration {
	
	
	//@Accessors 
	protected var Generator generator
	
	//@Accessors (PUBLIC_GETTER, PROTECTED_SETTER) 
	protected var Map<String, Range<Integer>> classDepthRange
	
	//@Accessors (PUBLIC_GETTER, PROTECTED_SETTER) 
	protected var Map<String, Map<String,Range<Integer>>> perClassReferencesRange
	
	//@Accessors (PUBLIC_GETTER, PROTECTED_SETTER) 
	protected var Map<String, Map<String,Range<Integer>>> perClassValuesRange
	
	//@Accessors protected var float globalVariation
	
	//@Accessors protected var int globalDensity
	
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
	 * @paral generator 
	 * 			  the generator containing the configuration 
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
	new (Resource metamodelResource, Generator generator, Range<Integer> elementsRange, long seed ) {
		
		this (metamodelResource, elementsRange, seed)
		this.generator = generator
		
		// Initializing the range maps from the generator
		classDepthRange = new HashMap<String, Range<Integer>> 
		perClassValuesRange = new HashMap<String, Map<String,Range<Integer>>> 
		perClassReferencesRange = new HashMap<String, Map<String,Range<Integer>>> 
		
		generator.classes.forEach[updateMapValues]
		
	}
	
	/**
	 * @param metamodelResource
	 *            The resource containing the metamodel for which the
	 *            {@link SpecimenGenerator} will create instances
	 * @param generator 
	 * 			  the generator containing the configuration 
	 */
	new(Resource resource, Generator generator) {
		this (resource, 
				generator, 
				Range.between(0,IGenerator.DEFAULT_PROPERTIES_RANGE), 
				new Random().nextLong )
	}
	
	
	private def void updateMapValues (Clazz clazz) {
		
		classDepthRange.put(clazz.name, Range.between(Math.round(clazz.depth * (1 - generator.globalDeviation)),
														Math.round(clazz.depth * (1 + generator.globalDeviation))))
		perClassReferencesRange.put(clazz.name, new HashMap<String, Range<Integer>>)
		perClassValuesRange.put(clazz.name, new HashMap<String, Range<Integer>>)
		
		clazz.properties.forEach[updateMapValues(clazz.name)]
	}
	
	def int depth(Clazz clazz) {
		IGenerator.DEFAULT_CLASS_DEPTH
	}
	
	private def void updateMapValues (Property prop, String clazzName) {
		if (!prop.isAttribute(clazzName))
			perClassReferencesRange.get(clazzName).put(prop.name, prop.referenceRange)
		else 
			perClassValuesRange.get(clazzName).put(prop.name, prop.valueRange)
		
	}
	
	private def boolean isAttribute(Property property, String clazzName ) {
		
		val myClass = ePackages.map[ePck | ePck.EClassifiers]
							   .flatten
							   .findFirst[clz | clz.name == clazzName] as EClass
							   
		return myClass.EAllAttributes.findFirst[prop | prop.name == property.name] != null
	}
	
	private def Range<Integer> getValueRange(Property property) { 
		if (property.range != null)
			 Range.between(property.range.lower, property.range.upper)
		else Range.between(Math.round(generator.globalDensity * (1 - generator.globalDeviation)), 
					Math.round(generator.globalDensity * (1 + generator.globalDeviation)))
	}
	
	private def Range<Integer> getReferenceRange(Property property) {
		if (property.range != null)
			 Range.between(property.range.lower, property.range.upper)
		else Range.between(Math.round(generator.globalDensity * (1 - generator.globalDeviation)), 
					Math.round(generator.globalDensity * (1 + generator.globalDeviation)))
	}
	@NotNull
	override getRangeFor(EClass eCLass) {
		classDepthRange.get(eCLass.name)
	}
	@NotNull
	override getRangeFor(EAttribute eAttribute) {
		perClassValuesRange.get(eAttribute.eClass.name).get(eAttribute.name) ?: propertiesRange
	}
	@NotNull
	override getRangeFor(EReference eReference) {
		perClassReferencesRange.get(eReference.eClass.name).get(eReference.name)
	}
	@NotNull
	override getDistributionFor(EAttribute eAttribute) {
		
		var distribution = distributions.get(eAttribute)
		
		if (distribution == null) {
			if (!eAttribute.isMany) {
				 distribution = new UniformIntegerDistribution(eAttribute.rangeFor.minimum, 
				 											   eAttribute.rangeFor.maximum)
				 distribution.reseedRandomGenerator(random.nextLong)
			} else {
				val upperBound = if (eAttribute.upperBound == EAttribute.UNBOUNDED_MULTIPLICITY)  
									Integer.MAX_VALUE 
								else 
									eAttribute.upperBound
				
				val lowerBound = if (upperBound == eAttribute.lowerBound) 
									0 
								else eAttribute.lowerBound		
				val min = Math.max(Math.min(eAttribute.rangeFor.minimum, upperBound), lowerBound)
				val max = Math.min(eAttribute.rangeFor.maximum, upperBound)
				if (min == max ) {
					return new MonoValuedIntegerDistribution(min)
			} else {	
				distribution = new UniformIntegerDistribution(
					min, 
					max)
				distribution.reseedRandomGenerator(random.nextLong())
				}
			}
			distributions.put(eAttribute, distribution)
		}
		return distribution
	}
	
	@NotNull
	override getDistributionFor(EReference eReference) {
		var distribution = distributions.get(eReference)
		
		if (distribution == null) {
			if (! eReference.isMany) {
				 distribution = new UniformIntegerDistribution(eReference.rangeFor.minimum, eReference.rangeFor.maximum)
				 distribution.reseedRandomGenerator(random.nextLong)
			} else {
			val upperBound = if ( eReference.upperBound == EAttribute.UNBOUNDED_MULTIPLICITY ) 
								 Integer.MAX_VALUE 
						     else 
						     	   eReference.upperBound
			val lowerBound = if (upperBound == eReference.lowerBound)
							 	0 
							 else 
							 	eReference.lowerBound
							 	
			val min = Math.max(Math.min(eReference.rangeFor.minimum, upperBound), lowerBound)
			val max = Math.min(eReference.rangeFor.maximum , upperBound)
			if (min == max ) {
				distribution = new MonoValuedIntegerDistribution (min)
			} else {	
			distribution = new UniformIntegerDistribution(
					min, 
					max);
			distribution.reseedRandomGenerator(random.nextLong())
				}
			}
			distributions.put(eReference, distribution)
		}
		return distribution;
	}
	@NotNull
	override getDepthDistributionFor(EClass eClass) {
		var distribution = distributions.get(eClass);
		if (distribution == null) {
			distribution = new UniformIntegerDistribution(eClass.rangeFor.minimum, eClass.rangeFor.maximum);
			distribution.reseedRandomGenerator(random.nextLong);
			distributions.put(eClass, distribution);
		}
		return distribution
	}
	
}
