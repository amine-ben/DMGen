package fr.inria.diverse.generator.util
import com.google.common.base.Optional
import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.MultiMap
import fr.inria.atlanmod.neoemf.core.PersistentEObject
import fr.inria.diverse.generator.specimen.ISpecimenConfiguration
import fr.inria.diverse.generator.util.EPackagesData
import java.text.MessageFormat
import java.util.ArrayList
import java.util.Iterator
import java.util.List
import java.util.Random
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.math3.distribution.IntegerDistribution
import org.apache.log4j.LogManager
import org.apache.log4j.Logger
import org.apache.spark.api.java.function.FlatMapFunction
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource

import static com.google.common.primitives.Primitives.isWrapperType
import static com.google.common.primitives.Primitives.unwrap
import static com.google.common.collect.Iterables.get

import com.google.common.collect.ImmutableMultiset
import com.google.common.collect.ImmutableList


class VerticesGenToPair implements FlatMapFunction<Iterator<Long>, String> {
	
	//static val serialVersionUID = 9182626593341469021L
	
	static val seed = 265933L
	
	static val Logger LOGGER = LogManager.getLogger("Generator")
	
	static var ISpecimenConfiguration _conf
	static var EPackagesData ePackagesData
	static var Resource _resource
	static var HazelcastInstance hcInstance
	
	var Random _generator
	
	var currentDepth = 0
	var currentMaxDepth = 0
	var currentObjectCount = 0

	var long averageSize
	
	/**
	 * 
	 */
	new (ISpecimenConfiguration conf, long averageSize, Resource resource) {
		
    	_conf = conf
		_generator = new Random(seed)
		ePackagesData = new EPackagesData(conf.ePackages, 
											conf.ignoredEClasses)
		this.averageSize = averageSize
		_resource = resource
		hcInstance = Hazelcast.newHazelcastInstance 
	}
	
	/**
	 * 
	 */
	 override Iterator<String> call(Iterator<Long> key) throws Exception {
	 	
		val result = new ArrayList<String> 
		val possibleRootEClasses = _conf.possibleRootEClasses 
		val MultiMap<String, String> indexByName = hcInstance.getMultiMap("indexed-elements")
 		while (currentObjectCount < averageSize) {
			var eClass = _conf.getNextRootEClass(possibleRootEClasses)
			currentMaxDepth = _conf.getDepthDistributionFor(eClass).sample 
			val Optional<EObject> generateEObject = generateEObject(eClass, result, indexByName)
			if (generateEObject.isPresent) {
				_resource.contents.add(generateEObject.get)
			}
 		}
		return result.iterator 
	}
	
	private def Optional<EObject> generateEObject(EClass eClass, ArrayList<String> result,MultiMap<String,String> indexByName) {
		
		currentObjectCount++
		LOGGER.info(MessageFormat.format("Generating EObject {0} / ~{1} (EClass={2})", 
				currentObjectCount, averageSize, eClass.name))
		val eObject = createEObject(eClass, result,indexByName)
		generateEAttributes(eObject, eClass)
		generateEContainmentReferences(eObject, eClass, result, indexByName)
		return Optional.fromNullable(eObject)
	}

	protected def EObject createEObject(EClass eClass, ArrayList<String> result, MultiMap<String, String> indexByName) {
		val eObject = eClass.EPackage.EFactoryInstance.create(eClass)

		result.add((eObject as PersistentEObject).id.toString)
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
		val distribution = _conf.getDistributionFor(eAttribute)
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
	
	protected def void generateSingleAttribute(EObject eObject, EAttribute eAttribute, IntegerDistribution distribution,
			Class<?> instanceClass) {
		if (eAttribute.isRequired.operator_or(booleanInDistribution(distribution))) {
			var intermediateInstance = instanceClass 
			var Object value
			val eAttributeType = eAttribute.EAttributeType 
			if (eAttributeType instanceof EEnum) {
				//assert instanceClass == null
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
				//assert instanceClass == null
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
					_conf.getValueDistributionFor(instanceClass).sample, 
					0, 0, true, true, null, _generator)
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
			return _generator.nextBoolean 
		} else if (instanceClass == byte) {
			var byte[] buff = newByteArrayOfSize(1)
			_generator.nextBytes(buff)
			return buff.get(0)
		} else if (instanceClass == char) {
			val nextChar =  _generator.nextInt as char 
			return nextChar
		} else if (instanceClass == double) {
			return _generator.nextDouble 
		} else if (instanceClass == float) {
			return _generator.nextFloat 
		} else if (instanceClass == int) {
			return _generator.nextInt 
		} else if (instanceClass == long) {
			return _generator.nextLong 
		} else if (instanceClass == short) {
			val nextShort =  _generator.nextInt as short
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
	protected def generateEContainmentReferences(EObject eObject, EClass eClass,
			 ArrayList<String> result, MultiMap<String, String> indexByName) {
		for (EReference eReference : ePackagesData.eAllContainment(eClass)) {
			if (eReference.isRequired || 
					(currentObjectCount < averageSize && currentDepth <= currentMaxDepth)) {
				generateEContainmentReference(eObject, eReference, result,indexByName)
			}
		}

	}

	/**
	 * @param eObject
	 * @param eReference
	 * @param indexByKind
	 */
	protected def generateEContainmentReference(EObject eObject, EReference eReference,
			 ArrayList<String> result, MultiMap<String, String> indexByName) {
		currentDepth++

		val eAllConcreteSubTypeOrSelf = ePackagesData.eAllConcreteSubTypeOrSelf(eReference)
		val eAllConcreteSubTypesOrSelf = getEReferenceTypesWithWeight(eReference,
				eAllConcreteSubTypeOrSelf)

		if (!eAllConcreteSubTypesOrSelf.isEmpty) {
			if (eReference.isMany) {
				generateManyContainmentReference(eObject, eReference, result, indexByName,eAllConcreteSubTypesOrSelf)
			} else {
				generateSingleContainmentReference(eObject, eReference, result, indexByName, eAllConcreteSubTypesOrSelf)
			}
		}
		currentDepth--
	}

	protected def generateSingleContainmentReference(EObject eObject, 
														EReference eReference, 
														ArrayList<String> result, 
														MultiMap<String, String> indexByName, 
														ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
															
		val distribution = _conf.getDistributionFor(eReference)
		if (eReference.isRequired || booleanInDistribution(distribution)) {
			LOGGER.info(MessageFormat.format("Generating EReference ''{0}'' in EObject {1}", eReference.name, eObject.toString))
			val idx = _generator.nextInt(eAllConcreteSubTypesOrSelf.size)
			val Optional<EObject> nextEObject = generateEObject(get(eAllConcreteSubTypesOrSelf, idx), result, indexByName)
			if (nextEObject.isPresent) {
				eObject.eSet(eReference, nextEObject.get)
			}
		}
	}

	protected def generateManyContainmentReference(EObject eObject, 
													  EReference eReference,
													  ArrayList<String> result, 
													  MultiMap<String, String> indexByName, 
													  ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
		val distribution = _conf.getDistributionFor(eReference)
		val values =  eObject.eGet(eReference) as List<EObject>
		val sample = distribution.sample 
		LOGGER.info(MessageFormat.format("Generating {0} values for EReference ''{1}'' in EObject {2}", sample, eReference.name, eObject.toString))
		for (var i = 0; i < sample;  i++) {
			val idx = _generator.nextInt(eAllConcreteSubTypesOrSelf.size)
			val Optional<EObject> nextEObject = generateEObject(get(eAllConcreteSubTypesOrSelf, idx), result, indexByName)
			if (nextEObject.isPresent) {
				values.add(nextEObject.get)
			}
		}
	}

	def ImmutableMultiset<EClass> getEReferenceTypesWithWeight(EReference eReference,
																  ImmutableList<EClass> eAllSubTypesOrSelf) {
		val ImmutableMultiset.Builder<EClass> eAllSubTypesOrSelfWithWeights = ImmutableMultiset.builder  
		for (EClass eClass : eAllSubTypesOrSelf) {
			eAllSubTypesOrSelfWithWeights.addCopies(eClass, _conf.getWeightFor(eReference, eClass))
		}
		return eAllSubTypesOrSelfWithWeights.build 
	}

}
		
