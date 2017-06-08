package fr.inria.diverse.spark_generator;

import static com.google.common.collect.Iterables.get;
import static com.google.common.primitives.Primitives.isWrapperType;
import static com.google.common.primitives.Primitives.unwrap;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.diverse.spark_generator.specimen.ISpecimenConfiguration;
import fr.inria.diverse.spark_generator.util.EPackagesData;
import scala.Tuple2;

public class VerticesGenToPair implements FlatMapFunction<Iterator<Long>, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9182626593341469021L;
	private static final long seed = 265933L;
	
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger("Generator");
	
	private static ISpecimenConfiguration _conf;
	private static EPackagesData ePackagesData;
	private static Resource _resource;
	private static HazelcastInstance hcInstance;
	
	private Random generator;
	
	private int currentDepth = 0;
	private int currentMaxDepth = 0;
	private long currentObjectCount = 0;

	private long averageSize;
		
    public VerticesGenToPair(ISpecimenConfiguration conf, long averageSize, Resource resource) {
		
    	_conf = conf;
		this.generator = new Random(seed);
		ePackagesData = new EPackagesData(conf.ePackages()
									, conf.ignoredEClasses());
		this.averageSize = averageSize;
		_resource = resource;
		hcInstance = Hazelcast.newHazelcastInstance();
	

	}
    
	@Override
	public Iterator<String> call(Iterator<Long> key) throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		ImmutableSet<EClass> possibleRootEClasses = _conf.possibleRootEClasses();
		MultiMap<String, String> indexByName = hcInstance.getMultiMap("indexed-elements");
 		while (currentObjectCount < averageSize) {
			EClass eClass = _conf.getNextRootEClass(possibleRootEClasses);
			currentMaxDepth = _conf.getDepthDistributionFor(eClass).sample();
			Optional<EObject> generateEObject = generateEObject(eClass, result, indexByName);
			if (generateEObject.isPresent()) {
				_resource.getContents().add(generateEObject.get());
			}
 		}
		return result.iterator();
	}

	private Optional<EObject> generateEObject(EClass eClass, ArrayList<String> result,MultiMap<String,String> indexByName) {
		final EObject eObject;
		currentObjectCount++;
		LOGGER.info(MessageFormat.format("Generating EObject {0} / ~{1} (EClass={2})", 
				currentObjectCount, averageSize, eClass.getName()));
		eObject = createEObject(eClass, result,indexByName);
		generateEAttributes(eObject, eClass);
		generateEContainmentReferences(eObject, eClass, result, indexByName);
		return Optional.fromNullable(eObject);
	}

	protected EObject createEObject(EClass eClass, ArrayList<String> result, MultiMap<String, String> indexByName) {
		EObject eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);

		result.add(((PersistentEObject)eObject).id().toString());
		indexByName.put(((PersistentEObject)eObject).id().toString(), eClass.getName());
		for (EClass eSuperType : eClass.getEAllSuperTypes()) {
			indexByName.put(((PersistentEObject)eObject).id().toString(), eSuperType.getName());
		}
		return eObject;
	}
	
	protected void generateEAttributes(EObject eObject, EClass eClass) {
		for (EAttribute eAttribute : ePackagesData.eAllAttributes(eClass)) {
			generateAttributes(eObject, eAttribute);
		}
	}
	protected void generateAttributes(EObject eObject, EAttribute eAttribute) {
		IntegerDistribution distribution = _conf.getDistributionFor(eAttribute);
		EDataType eAttributeType = eAttribute.getEAttributeType();
		Class<?> instanceClass = eAttributeType.getInstanceClass();
		if (eAttribute.isMany()) {
			generateManyAttribute(eObject, eAttribute, distribution, instanceClass);
		} else {
			generateSingleAttribute(eObject, eAttribute, distribution, instanceClass);
		}
	}

	protected void generateSingleAttribute(EObject eObject, EAttribute eAttribute, IntegerDistribution distribution,
			Class<?> instanceClass) {
		if (eAttribute.isRequired() || booleanInDistribution(distribution)) {
			final Object value;
			EDataType eAttributeType = eAttribute.getEAttributeType();
			if (eAttributeType instanceof EEnum) {
				assert instanceClass == null;
				EEnum eEnum = (EEnum) eAttributeType;
				instanceClass = int.class;
				int randomValue = Math.abs((Integer) nextValue(instanceClass));
				int size = eEnum.getELiterals().size();
				value = eEnum.getELiterals().get(randomValue % size); 
			} else {
				value = nextValue(instanceClass);
			}
			eObject.eSet(eAttribute, value);
		}
	}

	protected void generateManyAttribute(EObject eObject, EAttribute eAttribute, IntegerDistribution distribution,
			Class<?> instanceClass) {
		@SuppressWarnings("unchecked")
		List<Object> values = (List<Object>) eObject.eGet(eAttribute);
		for (int i = distribution.getSupportLowerBound(); i < distribution.sample(); i++) {
			final Object value;
			EDataType eAttributeType = eAttribute.getEAttributeType();
			if (eAttributeType instanceof EEnum) {
				assert instanceClass == null;
				EEnum eEnum = (EEnum) eAttributeType;
				instanceClass = int.class;
				int randomValue = Math.abs((Integer) nextValue(instanceClass));
				int size = eEnum.getELiterals().size();
				value = eEnum.getELiterals().get(randomValue % size); 
			} else {
				value = nextValue(instanceClass);
			}
			values.add(value);
		}
	}

	protected Object nextValue(Class<?> instanceClass) {
		final Object value;
		if (instanceClass.isPrimitive() || isWrapperType(instanceClass)) {
			value = nextPrimitive(unwrap(instanceClass));
		} else {
			value = nextObject(instanceClass);
		}
		return value;
	}

	/**
	 * @param instanceClass
	 */
	protected Object nextObject(Class<?> instanceClass) {
		if (instanceClass == String.class) {
			return RandomStringUtils.random(
					_conf.getValueDistributionFor(instanceClass).sample(), 
					0, 0, true, true, null, generator);
		} else {
			LOGGER.warn(
					MessageFormat.format("Do not know how to randomly generate ''{0}'' object",
					instanceClass.getName()));
		}
		return null;
	}

	/**
	 * @param eObject
	 * @param eAttribute
	 * @param instanceClass
	 */
	protected Object nextPrimitive(Class<?> instanceClass) {
		if (instanceClass == boolean.class) {
			return generator.nextBoolean();
		} else if (instanceClass == byte.class) {
			byte[] buff = new byte[1];
			generator.nextBytes(buff);
			return buff[0];
		} else if (instanceClass == char.class) {
			char nextChar = (char) generator.nextInt();
			return nextChar;
		} else if (instanceClass == double.class) {
			return generator.nextDouble();
		} else if (instanceClass == float.class) {
			return generator.nextFloat();
		} else if (instanceClass == int.class) {
			return generator.nextInt();
		} else if (instanceClass == long.class) {
			return generator.nextLong();
		} else if (instanceClass == short.class) {
			short nextShort = (short) generator.nextInt();
			return nextShort;
		} else {
			throw new IllegalArgumentException();
		}
	}

	protected boolean booleanInDistribution(IntegerDistribution distribution) {
		int sample = distribution.sample();
		return sample <= distribution.getNumericalMean();
	}

	/**
	 * @param eObject
	 * @param eClass
	 * @param indexByKind
	 */
	protected void generateEContainmentReferences(EObject eObject, EClass eClass,
			 ArrayList<String> result, MultiMap<String, String> indexByName) {
		for (EReference eReference : ePackagesData.eAllContainment(eClass)) {
			if (eReference.isRequired() || (currentObjectCount < averageSize && currentDepth <= currentMaxDepth)) {
				generateEContainmentReference(eObject, eReference, result,indexByName);
			}
		}

	}

	/**
	 * @param eObject
	 * @param eReference
	 * @param indexByKind
	 */
	protected void generateEContainmentReference(EObject eObject, EReference eReference,
			 ArrayList<String> result, MultiMap<String, String> indexByName) {
		currentDepth++;

		ImmutableList<EClass> eAllConcreteSubTypeOrSelf = ePackagesData.eAllConcreteSubTypeOrSelf(eReference);
		ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf = getEReferenceTypesWithWeight(eReference,
				eAllConcreteSubTypeOrSelf);

		if (!eAllConcreteSubTypesOrSelf.isEmpty()) {
			if (eReference.isMany()) {
				generateManyContainmentReference(eObject, eReference, result, indexByName,eAllConcreteSubTypesOrSelf);
			} else {
				generateSingleContainmentReference(eObject, eReference, result, indexByName, eAllConcreteSubTypesOrSelf);
			}
		}
		currentDepth--;
	}

	protected void generateSingleContainmentReference(EObject eObject, EReference eReference,
			 ArrayList<String> result, MultiMap<String, String> indexByName, ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
		IntegerDistribution distribution = _conf.getDistributionFor(eReference);
		if (eReference.isRequired() || booleanInDistribution(distribution)) {
			LOGGER.info(MessageFormat.format("Generating EReference ''{0}'' in EObject {1}", eReference.getName(), eObject.toString()));
			int idx = generator.nextInt(eAllConcreteSubTypesOrSelf.size());
			final Optional<EObject> nextEObject = generateEObject(get(eAllConcreteSubTypesOrSelf, idx), result, indexByName);
			if (nextEObject.isPresent()) {
				eObject.eSet(eReference, nextEObject.get());
			}
		}
	}

	protected void generateManyContainmentReference(EObject eObject, EReference eReference,
			 ArrayList<String> result, MultiMap<String, String> indexByName, ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
		IntegerDistribution distribution = _conf.getDistributionFor(eReference);
		@SuppressWarnings("unchecked")
		List<EObject> values = (List<EObject>) eObject.eGet(eReference);
		int sample = distribution.sample();
		LOGGER.info(MessageFormat.format("Generating {0} values for EReference ''{1}'' in EObject {2}", sample, eReference.getName(), eObject.toString()));
		for (int i = 0; i < sample; i++) {
			int idx = generator.nextInt(eAllConcreteSubTypesOrSelf.size());
			final Optional<EObject> nextEObject = generateEObject(get(eAllConcreteSubTypesOrSelf, idx), result, indexByName);
			if (nextEObject.isPresent()) {
				values.add(nextEObject.get());
			}
		}
	}

	protected ImmutableMultiset<EClass> getEReferenceTypesWithWeight(EReference eReference,
			ImmutableList<EClass> eAllSubTypesOrSelf) {
		ImmutableMultiset.Builder<EClass> eAllSubTypesOrSelfWithWeights = ImmutableMultiset.builder();
		for (EClass eClass : eAllSubTypesOrSelf) {
			eAllSubTypesOrSelfWithWeights.addCopies(eClass, _conf.getWeightFor(eReference, eClass));
		}
		return eAllSubTypesOrSelfWithWeights.build();
	}

}
