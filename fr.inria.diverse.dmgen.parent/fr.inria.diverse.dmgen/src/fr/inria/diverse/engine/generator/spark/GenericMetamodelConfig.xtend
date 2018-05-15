package fr.inria.diverse.engine.generator.spark

import java.util.Collections
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedHashSet
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.Random
import java.util.Set

import org.apache.commons.lang3.Range
import org.apache.commons.math3.distribution.AbstractIntegerDistribution
import org.apache.commons.math3.distribution.IntegerDistribution
import org.apache.commons.math3.distribution.UniformIntegerDistribution
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource

import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableSet

import fr.inria.diverse.engine.generator.specimen.ISpecimenConfiguration
import org.eclipse.emf.ecore.EReference

/**
 * @author <a href="mailto:abel.gomez-llana@inria.fr">Abel Gomez</a>
 * @author <A href="mailto:amine.benelallam@inria.fr">Amine Benelallam</a>
 *
 */
class GenericMetamodelConfig implements ISpecimenConfiguration {
	
	private static final long serialVersionUID = -6376362254387173636L

	public static final int DEFAULT_AVERAGE_PROPERTIES_SIZE = 8

	public static final int DEFAULT_AVERAGE_REFERENCES_SIZE = 8
	
	public static final int DEFAULT_AVERAGE_VALUES_LENGTH = 24 // minimal size encouraged by HBase
	
	public static final float DEFAULT_PROPERTIES_DEVIATION = 0.1f
	
	public static final float DEFAULT_REFERENCES_DEVIATION = 0.1f
	
	public static final float DEFAULT_VALUES_DEVIATION = 0.1f
	
	protected final Random random

	protected final long seed

	protected final Resource metamodelResource

	protected final Range<Integer> elementsRange
	
	protected Range<Integer> propertiesRange = Range.between(
			Math.round(DEFAULT_AVERAGE_PROPERTIES_SIZE * (1 - DEFAULT_PROPERTIES_DEVIATION)), 
			Math.round(DEFAULT_AVERAGE_PROPERTIES_SIZE * (1 + DEFAULT_PROPERTIES_DEVIATION)));
	
	protected Range<Integer> referencesRange = Range.between(
			Math.round(DEFAULT_AVERAGE_REFERENCES_SIZE * (1 - DEFAULT_REFERENCES_DEVIATION)), 
			Math.round(DEFAULT_AVERAGE_REFERENCES_SIZE * (1 + DEFAULT_REFERENCES_DEVIATION)));
	
	protected Range<Integer> valuesRange = Range.between(
			Math.round(DEFAULT_AVERAGE_VALUES_LENGTH * (1 - DEFAULT_VALUES_DEVIATION)), 
			Math.round(DEFAULT_AVERAGE_VALUES_LENGTH * (1 + DEFAULT_VALUES_DEVIATION)));
	
	protected Map<Object, IntegerDistribution> distributions = new HashMap<Object, IntegerDistribution>();

	
	
	
	
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
		super();
		this.metamodelResource = metamodelResource;
		this.elementsRange = elementsRange;
		this.seed = seed;
		this.random = new Random(seed);
	}

	/**
	 * Creates a new {@link GenericMetamodelConfig} using
	 * {@link System#currentTimeMillis()} as the <code>seed</code>
	 * 
	 * @param resource
	 *            The resource containing the metamodel for which the
	 *            {@link SpecimenGenerator} will create instances
	 */
	new (Resource resource, Range<Integer> elementsRange) {
		this(resource, elementsRange, System.currentTimeMillis());
	}
	
	

	/**
	 * Return the {@link Resource} of the metamodel for which this
	 * {@link ISpecimenConfiguration} will be used
	 * 
	 * @return the metamodel {@link Resource}
	 */
	override Resource getMetamodelResource() {
		return metamodelResource;
	}
	
	/**
	 * Returns the seed used for the {@link Random} generator
	 * 
	 * @return the seed
	 */
	override long getSeed() {
		return seed;
	}
	
	/**
	 * Returns the minimum and maximum size allowed for resources created using
	 * this {@link ISpecimenConfiguration}
	 * 
	 * @return The {@link Range}
	 */
	override Range<Integer> getElementsRange() {
		return elementsRange;
	}

	/**
	 * Returns the minimum and maximum number of properties allowed for
	 * {@link EObject}s created using this {@link ISpecimenConfiguration}
	 * 
	 * @return The {@link Range}
	 */
	override Range<Integer> getPropertiesRange() {
		return propertiesRange;
	}

	/**
	 * Sets the minimum and maximum number of properties allowed for
	 * {@link EObject}s created using this {@link ISpecimenConfiguration}
	 * 
	 * @param valuesRange
	 *            The {@link Range} with minimum and maximum values
	 */
	def void setPropertiesRange(Range<Integer> propertiesRange) {
		this.propertiesRange = propertiesRange;
	}

	/**
	 * Sets the minimum and maximum number of properties allowed for
	 * {@link EObject}s created using this {@link ISpecimenConfiguration}
	 * 
	 * @param min
	 *            The minimum
	 * @param max
	 *            The maximum
	 */
	override void setPropertiesRange(int min, int max) {
		this.propertiesRange = Range.between(min, max);
	}

	/**
	 * Returns the minimum and maximum number of references allowed for
	 * {@link EObject}s created using this {@link ISpecimenConfiguration}
	 * 
	 * @return The {@link Range}
	 */
	override Range<Integer> getReferencesRange() {
		return referencesRange;
	}

	/**
	 * Sets the minimum and maximum number of references allowed for
	 * {@link EObject}s created using this {@link ISpecimenConfiguration}
	 * 
	 * @param valuesRange
	 *            The {@link Range} with minimum and maximum values
	 */
	def void setReferencesRange(Range<Integer> referencesRange) {
		this.referencesRange = referencesRange;
	}

	/**
	 * Sets the minimum and maximum number of references allowed for
	 * {@link EObject}s created using this {@link ISpecimenConfiguration}
	 * 
	 * @param min
	 *            The minimum
	 * @param max
	 *            The maximum
	 */
	override void setReferencesRange(int min, int max) {
		this.referencesRange = Range.between(min, max);
	}
	
	/**
	 * Returns the minimum and maximum length of non-fixed-sized properties (e.g.,
	 * {@link String}s, arrays, etc).

	 * @return The {@link Range}
	 */
	override Range<Integer> getValuesRange() {
		return valuesRange;
	}

	/**
	 * Sets the minimum and maximum length of non-fixed-sized properties (e.g.,
	 * {@link String}s, arrays, etc).
	 * 
	 * @param valuesRange
	 *            The {@link Range} with minimum and maximum values
	 */
	def void setValuesRange(Range<Integer> valuesRange) {
		this.valuesRange = valuesRange;
	}

	/**
	 * Sets the minimum and maximum length of non-fixed-sized properties (e.g.,
	 * {@link String}s, arrays, etc).
	 * 
	 * @param min
	 *            The minimum
	 * @param max
	 *            The maximum
	 */
	override void setValuesRange(int min, int max) {
		this.valuesRange = Range.between(min, max);
	}
	
	override ImmutableSet<EPackage> ePackages() {
		var Set <EPackage> ePackages = new HashSet<EPackage>();
		for (var it = metamodelResource.getAllContents(); it.hasNext();) {
			val EObject eObject =  it.next() as EObject;
			if (eObject instanceof EPackage) {
				ePackages.add(eObject);
			}
		}
		return ImmutableSet.copyOf(ePackages);
	}

	def Set<EClass> eSubtypesClosure(Map<EClass, Set<EClass>> eSubtypesMap, EClass eType) {
		val result = new LinkedHashSet<EClass> ();
			if (!eSubtypesMap.containsKey(eType)) {
				return Collections.EMPTY_SET;
			} else {
				result.addAll(eSubtypesMap.get(eType));
				for (EClass eSubType : eSubtypesMap.get(eType)) {
					if (! eSubType.equals(eType)) 
						result.addAll(eSubtypesClosure(eSubtypesMap, eSubType));
				}
			}
		return result;
	}


	def Map<EClass, Set <EClass>> computeSubtypesMap() {
		val  result = new HashMap<EClass, Set<EClass>> (); 
		val iter = metamodelResource.getAllContents();
		
		 for (var EObject ecls = null ;  iter.hasNext(); ) {
			 ecls = iter.next();
			 if (ecls instanceof EClass) {
				 val clazz = ecls as  EClass
				 for (EClass cls : clazz.getEAllSuperTypes()) {
					 if (result.containsKey(cls)) {
						 result.get(cls).add(clazz);
					 } else {
						 val list = new HashSet<EClass>();
						 list.add(cls);
						 list.add(clazz);
						 result.put(cls, list);
					 }
				 }
			 }
		 }
			 
		return result;
	}


	override ImmutableSet<EClass> possibleRootEClasses() {
		val List<EClass> eClasses = new LinkedList<EClass>();
		// creating a subtypes map
		val Map<EClass,Set<EClass>> eSubtypesMap = computeSubtypesMap();
		
		// Eclasses.filter( instance of EClass && not abstract && not interface) 
		for (val it = metamodelResource.getAllContents(); it.hasNext();) {
			val eObject = it.next() as EObject
			if (eObject instanceof EClass) {
				val eClass =  eObject as EClass
				if (!eClass.isAbstract() && !eClass.isInterface()) {
					eClasses.add(eClass)
					}
			}
		}
		
		//copying the list of eClasses 
		val result = new LinkedList<EClass>(eClasses);
		
		// iterating eClasses and removing elements (along with subtypes) being 
			eClasses.forEach[cls | 
					cls.EAllContainments.forEach[cnt| 
						val Set<EClass> list = eSubtypesClosure(eSubtypesMap, cnt.EType as EClass)
						if (list.empty) {
							result.remove(cnt.EType as EClass)
						} else {
							result.removeAll(list)
						}
					]
			]
		
		return ImmutableSet.copyOf(result);
	}
	/**
	 * Returns whether instances of this {@link EClass} need a container, i.e.,
	 * they have a <code>required</code> <code>container</code>
	 * {@link EReference} (see {@link EReference#isRequired()} and
	 * {@link EReference#isContainer()})
	 * 
	 * @param eClass
	 *            The {@link EClass}
	 * @return Whether the {@link EClass} needs a <code>container</code>
	 */
	def needsContainer(EClass eClass) {
		eClass.EAllReferences
			  .findFirst[eReference | 
					eReference.isContainer() && eReference.isRequired()]
			  != null
		
	}

	override ImmutableSet<EClass> ignoredEClasses() {
		val eClasses = new HashSet<EClass>();
		for (val it = metamodelResource.allContents; it.hasNext();) {
			val eObject = it.next() as EObject;
			if (eObject instanceof EClass) {
				val eClass =  eObject as EClass
				if (eClass.abstract || eClass.interface) {
					// Abstract EClasses and Interfaces can't be instantiated
					eClasses.add(eClass);
				}
			}
		}
		return ImmutableSet.copyOf(eClasses);
	}

	override IntegerDistribution getResourceSizeDistribution() {
		var IntegerDistribution distribution = distributions.get(metamodelResource);
		if (distribution == null) {
			distribution = new UniformIntegerDistribution(elementsRange.getMinimum(), elementsRange.getMaximum());
			distribution.reseedRandomGenerator(random.nextLong());
			distributions.put(metamodelResource, distribution);
		}
		return distribution;
	}

	override int getWeightFor(EReference eReference, EClass eClass) {
		return 1;
	}

	override  IntegerDistribution getDistributionFor(EAttribute eAttribute) {
		var distribution = distributions.get(eAttribute);
		
		if (distribution == null) {
			if (! eAttribute.isMany()) {
				 distribution = new UniformIntegerDistribution(propertiesRange.getMinimum(), propertiesRange.getMaximum());
				 distribution.reseedRandomGenerator(random.nextLong());
			} else {
			val upperBound = if (eAttribute.upperBound == EAttribute.UNBOUNDED_MULTIPLICITY) 
								Integer.MAX_VALUE 
							else eAttribute.upperBound
			// TODO fix lowerBound when it is equal to 
			val lowerBound = if (upperBound == eAttribute.getLowerBound()) 
								0 
							else eAttribute.lowerBound
							
			val min = Math.max(Math.min(propertiesRange.getMinimum(), upperBound), lowerBound);
			val max = Math.min(propertiesRange.getMaximum(), upperBound);
			if (min == max ) {
				return new MonoValuedIntegerDistribution (min);
			} else {	
			distribution = new UniformIntegerDistribution(
					min, 
					max);
			distribution.reseedRandomGenerator(random.nextLong());
				}
			}
			distributions.put(eAttribute, distribution);
		}
		return distribution;
	}

	override IntegerDistribution getValueDistributionFor(Class<?> clazz) {
		var distribution = distributions.get(clazz);
		if (distribution == null) {
			distribution = new UniformIntegerDistribution(valuesRange.getMinimum(), valuesRange.getMaximum());
			distribution.reseedRandomGenerator(random.nextLong());
			distributions.put(clazz, distribution);
		}
		return distribution;
	}

	override IntegerDistribution getDistributionFor(EReference eReference) {
		var distribution = distributions.get(eReference);
		
		if (distribution == null) {
			if (! eReference.isMany()) {
				 distribution = new UniformIntegerDistribution(propertiesRange.getMinimum(), propertiesRange.getMaximum());
				 distribution.reseedRandomGenerator(random.nextLong());
			} else {
			val upperBound = if (eReference.upperBound == EAttribute.UNBOUNDED_MULTIPLICITY) 
								   Integer.MAX_VALUE
						     else eReference.upperBound
			// TODO fix lowerBound when it is equal to 
			val lowerBound = if(upperBound == eReference.getLowerBound()) 0 else eReference.getLowerBound();
			val min = Math.max(Math.min(propertiesRange.getMinimum(), upperBound), lowerBound);
			val max = Math.min(propertiesRange.getMaximum(), upperBound);
			if (min == max ) {
				return new MonoValuedIntegerDistribution (min);
			} else {	
			distribution = new UniformIntegerDistribution(min,max);
			distribution.reseedRandomGenerator(random.nextLong());
				}
			}
			distributions.put(eReference, distribution);
		}
		return distribution;
	}

	override  IntegerDistribution getDepthDistributionFor(EClass eClass) {
		var distribution = distributions.get(eClass);
		if (distribution == null) {
			distribution = new UniformIntegerDistribution(referencesRange.getMinimum(), referencesRange.getMaximum());
			distribution.reseedRandomGenerator(random.nextLong());
			distributions.put(eClass, distribution);
		}
		return distribution;
	}

	override EClass getNextRootEClass(ImmutableSet<EClass> rootEClasses) {
		if (rootEClasses.size() == 1) 
			return rootEClasses.asList().get(0);
		
		var distribution = distributions.get(rootEClasses);
		if (distribution == null) {
			distribution = new UniformIntegerDistribution(0, rootEClasses.size() - 1);
			distribution.reseedRandomGenerator(random.nextLong());
			distributions.put(rootEClasses, distribution);
		}
		
		return rootEClasses.asList().get(distribution.sample());
	}
	override ImmutableList <String> getAllClassNames () {
		ImmutableList.copyOf(metamodelResource.allContents.filter[element | element instanceof EClass].map[eCls | (eCls as EClass).name])
		
	}

	public static class MonoValuedIntegerDistribution extends AbstractIntegerDistribution {

			private int value; 
			
			new (int value) {
				this.value = value;
			}
			override double probability(int x) {

				throw new UnsupportedOperationException();
			}

			override double cumulativeProbability(int x) {
				throw new UnsupportedOperationException();
			}

			override double getNumericalMean() {
				throw new UnsupportedOperationException();
			}

			override  double getNumericalVariance() {
				throw new UnsupportedOperationException();
			}

			override  int getSupportLowerBound() {
				// TODO Auto-generated method stub
				return value;
			}

			override  int getSupportUpperBound() {
				// TODO Auto-generated method stub
				return value;
			}

			override  boolean isSupportConnected() {
				throw new UnsupportedOperationException();
			}
			
	}
}