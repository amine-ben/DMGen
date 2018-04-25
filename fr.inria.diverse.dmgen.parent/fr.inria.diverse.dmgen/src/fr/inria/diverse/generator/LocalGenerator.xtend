package fr.inria.diverse.generator

import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.MultiMap
import fr.inria.diverse.generator.spark.IGenerator
import fr.inria.diverse.generator.specimen.ISpecimenConfiguration
import fr.inria.diverse.generator.util.EPackagesData
import java.text.MessageFormat
import java.util.Random
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import com.google.common.base.Optional
import fr.inria.atlanmod.neoemf.core.PersistentEObject
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EEnum
import org.apache.commons.math3.distribution.IntegerDistribution
import org.apache.commons.lang3.RandomStringUtils
import org.eclipse.emf.ecore.EReference
import com.google.common.collect.ImmutableMultiset
import java.util.List
import com.google.common.collect.ImmutableList

import static com.google.common.primitives.Primitives.isWrapperType
import static com.google.common.primitives.Primitives.unwrap
import static com.google.common.collect.Iterables.get
import fr.inria.diverse.dmgen.dMGen.Generator

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:abel.gomez-llana@inria.fr">Abel Gomez</a>
 * @author <a href="mailto:amine.benelallam@inria.fr">Amine Benelallam</a>
 */

 
//@Accessors (PUBLIC_GETTER, PROTECTED_SETTER) 
class LocalGenerator implements IGenerator {
	
	static protected val Logger LOGGER = Logger.getLogger(LocalGenerator.name)
	
	protected var ISpecimenConfiguration configuration
	protected var EPackagesData ePackagesData
	protected Generator generator;
	protected Random random
	/* inner Variable state */
	protected var int currentDepth
	protected var int currentMaxDepth
	protected var int currentObjectCount
	protected var int goalObjects
	
	var MultiMap<String, String> indexByName
    var HazelcastInstance hcInstance
  
  
  	/**
  	 * 
  	 */
	override getConfig() {
		configuration
	}
	/**
	 * TODO replace/adapt to GEnerator configuration  with 
	 * @param {@link ISpeciman} <code>configuration</code>
	 */
	new (ISpecimenConfiguration configuration) {
		this.configuration = configuration
		random = new Random(configuration.seed)
		hcInstance = Hazelcast.newHazelcastInstance
		indexByName = hcInstance.getMultiMap("indexed-elements")
		ePackagesData = new EPackagesData(configuration.ePackages,
			 configuration.ignoredEClasses)	
	}
	/**
	 * 
	 */
	new (ISpecimenConfiguration configuration, long seed, Generator generator) {
		this(configuration)
		this.generator = generator
	}
   /**
     * Core method for generating models elements
     */
	override generate(Resource resource) {
			LOGGER.info(MessageFormat.format("Creating {0} model{1} using as generator {2}", 
								  generator.number, if (generator.number > 1 ) 's' else "" , 
								  "Spark Model Generator"))
			
			LOGGER.info(MessageFormat.format("Generator seed is ''{0}''", config.getSeed()))
			LOGGER.info(MessageFormat.format("Config parameters: range for models size is [{0}, {1}]", 
					config.getElementsRange().getMinimum(), config.getElementsRange().getMaximum())) 
			LOGGER.info(MessageFormat.format("Config parameters: range for properties number is [{0}, {1}]", 
					config.getPropertiesRange().getMinimum(), config.getPropertiesRange().getMaximum())) 
			LOGGER.info(MessageFormat.format("Config parameters: range for references number is [{0}, {1}]", 
					config.getReferencesRange().getMinimum(), config.getReferencesRange().getMaximum())) 
			LOGGER.info(MessageFormat.format("Config parameters: range for values length is [{0}, {1}]", 
					config.getValuesRange().getMinimum(), config.getValuesRange().getMaximum())) 
					
	
		val  possibleRootEClasses = configuration.possibleRootEClasses()

		currentDepth = 0
		currentMaxDepth = 0
		currentObjectCount = 0
		goalObjects = generator.size

		while (currentObjectCount < goalObjects) {
			val eClass = configuration.getNextRootEClass(possibleRootEClasses);
			currentMaxDepth = configuration.getDepthDistributionFor(eClass).sample();
			val generateEObject = generateEObject(eClass, indexByName);
			if (generateEObject.isPresent()) {
				resource.contents.add(generateEObject.get());
			}
		}

		LOGGER.info("Generating cross-references");
	
	}
	
	private def Optional<EObject> generateEObject(EClass eClass, MultiMap<String,String> indexByName) {
		
		currentObjectCount++
		val eObject = createEObject(eClass, indexByName)
		generateEAttributes(eObject, eClass)
		generateEContainmentReferences(eObject, eClass, indexByName)
		return Optional.fromNullable(eObject)
	}
	
	protected def EObject createEObject(EClass eClass, MultiMap<String, String> indexByName) {
		val eObject = eClass.EPackage.EFactoryInstance.create(eClass)

		indexByName.put((eObject as PersistentEObject).id.toString, eClass.name)
		for (EClass eSuperType : eClass.EAllSuperTypes) {
			indexByName.put((eObject as PersistentEObject).id.toString, eSuperType.name)
		}
		return eObject
	}
	
	protected def void generateEAttributes(EObject eObject, EClass eClass) {
		for (EAttribute eAttribute : ePackagesData.eAllAttributes(eClass)) {
			generateAttributes(eObject, eAttribute)
		}
	}
	
	protected def void generateAttributes(EObject eObject, EAttribute eAttribute) {
		val distribution = configuration.getDistributionFor(eAttribute)
		val eAttributeType = eAttribute.EAttributeType 
		val instanceClass = eAttributeType.instanceClass 
		if (eAttribute.isMany) {
			generateManyAttribute(eObject, eAttribute, distribution, instanceClass)
		} else {
			generateSingleAttribute(eObject, eAttribute, distribution, instanceClass)
		}
	}
	
	protected def boolean booleanInDistribution(IntegerDistribution distribution) {
		val sample = distribution.sample
		return sample <= distribution.numericalMean 
	}	
	 def void generateSingleAttribute(EObject eObject, EAttribute eAttribute, IntegerDistribution distribution,
			Class<?> instanceClass) {
		if (eAttribute.isRequired.operator_or(booleanInDistribution(distribution))) {
			var intermediateInstance = instanceClass 
			var Object value
			val eAttributeType = eAttribute.EAttributeType 
			if (eAttributeType instanceof EEnum) {
				val eEnum =  eAttributeType as EEnum
				intermediateInstance = int
				val randomValue = Math.abs(nextValue(intermediateInstance) as Integer)
				val size = eEnum.ELiterals.size 
				value = eEnum.ELiterals.get(randomValue % size) 
			} else {
				value = nextValue(instanceClass)
			}
			eObject.eSet(eAttribute, value)
		}
	}
	
	def nextValue(Class<?> instanceClass) {
		var Object value
		if (instanceClass.isPrimitive || isWrapperType(instanceClass)) {
			value = nextPrimitive(unwrap(instanceClass))
		} else {
			value = nextObject(instanceClass)
		}
		return value	
	}

	protected def void generateManyAttribute(EObject eObject, 
											EAttribute eAttribute, 
											IntegerDistribution distribution,
											Class<?> instanceClass) {
		
		val values =  eObject.eGet(eAttribute) as  List<Object>
		var intermediateInstance = instanceClass
		for (var i = distribution.supportLowerBound; i < distribution.sample;  i++) {
			var Object value
			val eAttributeType = eAttribute.EAttributeType 
			if (eAttributeType instanceof EEnum) {
				val eEnum = eAttributeType as EEnum
				intermediateInstance = int
				val randomValue = Math.abs( nextValue(instanceClass) as Integer)
				val size = eEnum.ELiterals.size 
				value = eEnum.ELiterals.get(randomValue % size) 
			} else {
				value = nextValue(instanceClass)
			}
			values.add(value)
		}
	}



	/**
	 * @param instanceClass
	 */
	protected def Object nextObject(Class<?> instanceClass) {
		if (instanceClass == String) {
			return RandomStringUtils.random(
					configuration.getValueDistributionFor(instanceClass).sample, 
					0, 0, true, true, null, random)
		} else {
			LOGGER.warn(
					MessageFormat.format("Do not know how to randomly generate ''{0}'' object",
					instanceClass.name))
		}
		return null
	}

	/**
	 * @param eObject
	 * @param eAttribute
	 * @param instanceClass
	 */
	protected def Object nextPrimitive(Class<?> instanceClass) {
		if (instanceClass == boolean) {
			return random.nextBoolean 
		} else if (instanceClass == byte) {
			var byte[] buff = newByteArrayOfSize(1)
			random.nextBytes(buff)
			return buff.get(0)
		} else if (instanceClass == char) {
			val nextChar =  random.nextInt as char 
			return nextChar
		} else if (instanceClass == double) {
			return random.nextDouble 
		} else if (instanceClass == float) {
			return random.nextFloat 
		} else if (instanceClass == int) {
			return random.nextInt 
		} else if (instanceClass == long) {
			return random.nextLong 
		} else if (instanceClass == short) {
			val nextShort =  random.nextInt as short
			return nextShort
		} else {
			throw new IllegalArgumentException 
		}
	}
	
		/**
	 * @param eObject
	 * @param eClass
	 * @param indexByKind
	 */
	protected def generateEContainmentReferences(EObject eObject, EClass eClass,  MultiMap<String, String> indexByName) {
		for (EReference eReference : ePackagesData.eAllContainment(eClass)) {
			if (eReference.isRequired || 
					(currentObjectCount < goalObjects && currentDepth <= currentMaxDepth)) {
				generateEContainmentReference(eObject, eReference, indexByName)
			}
		}

	}
	
	/**
	 * @param eObject
	 * @param eReference
	 * @param indexByKind
	 */
	protected def generateEContainmentReference(EObject eObject, EReference eReference,
			 MultiMap<String, String> indexByName) {
		currentDepth++

		val eAllConcreteSubTypeOrSelf = ePackagesData.eAllConcreteSubTypeOrSelf(eReference)
		val eAllConcreteSubTypesOrSelf = getEReferenceTypesWithWeight(eReference,
				eAllConcreteSubTypeOrSelf)

		if (!eAllConcreteSubTypesOrSelf.isEmpty) {
			if (eReference.isMany) {
				generateManyContainmentReference(eObject, eReference, indexByName,eAllConcreteSubTypesOrSelf)
			} else {
				generateSingleContainmentReference(eObject, eReference, indexByName, eAllConcreteSubTypesOrSelf)
			}
		}
		currentDepth--
	}

	protected def generateSingleContainmentReference(EObject eObject, 
														EReference eReference, 
														MultiMap<String, String> indexByName, 
														ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {														
		val distribution = configuration.getDistributionFor(eReference)
		if (eReference.isRequired || booleanInDistribution(distribution)) {
			LOGGER.info(MessageFormat.format("Generating EReference ''{0}'' in EObject {1}", eReference.name, eObject.toString))
			val idx = random.nextInt(eAllConcreteSubTypesOrSelf.size)
			val Optional<EObject> nextEObject = generateEObject(get(eAllConcreteSubTypesOrSelf, idx), indexByName)
			if (nextEObject.isPresent) {
				eObject.eSet(eReference, nextEObject.get)
			}
		}
	}

	protected def generateManyContainmentReference(EObject eObject, 
													  EReference eReference,
													  MultiMap<String, String> indexByName, 
													  ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
		val distribution = configuration.getDistributionFor(eReference)
		val values =  eObject.eGet(eReference) as List<EObject>
		val sample = distribution.sample 
		LOGGER.info(MessageFormat.format("Generating {0} values for EReference ''{1}'' in EObject {2}", sample, eReference.name, eObject.toString))
		for (var i = 0; i < sample;  i++) {
			val idx = random.nextInt(eAllConcreteSubTypesOrSelf.size)
			val Optional<EObject> nextEObject = generateEObject(get(eAllConcreteSubTypesOrSelf, idx),  indexByName)
			if (nextEObject.isPresent) {
				values.add(nextEObject.get)
			}
		}
	}

	def ImmutableMultiset<EClass> getEReferenceTypesWithWeight(EReference eReference,
																  ImmutableList<EClass> eAllSubTypesOrSelf) {
		val ImmutableMultiset.Builder<EClass> eAllSubTypesOrSelfWithWeights = ImmutableMultiset.builder  
		for (EClass eClass : eAllSubTypesOrSelf) {
			eAllSubTypesOrSelfWithWeights.addCopies(eClass, configuration.getWeightFor(eReference, eClass))
		}
		return eAllSubTypesOrSelfWithWeights.build 
	}
	
}