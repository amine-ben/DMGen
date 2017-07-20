package fr.inria.diverse.spark_generator

import java.text.MessageFormat
import java.util.Iterator
import java.util.LinkedList
import java.util.List
import java.util.Random

import org.apache.commons.math3.distribution.IntegerDistribution
import org.apache.spark.api.java.function.FlatMapFunction
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource

import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.MultiMap

import fr.inria.diverse.spark_generator.specimen.ISpecimenConfiguration
import fr.inria.diverse.spark_generator.util.EPackagesData

class EdgesGen  implements  FlatMapFunction<Iterator<String>, Boolean>  {
	
	static var Resource _resource
	static var ISpecimenConfiguration _conf
	static var EPackagesData ePackagesData
	static var MultiMap<String, String> indexByName
	static var HazelcastInstance hcInstance
	
	static val org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger("Generator")

	static var Random generator
	
	new (ISpecimenConfiguration configuration, Resource resource) {
		_resource = resource
		_conf = configuration
		hcInstance = Hazelcast.newHazelcastInstance
		indexByName = hcInstance.getMultiMap("indexed-elements")
		generator = new Random(configuration.seed)
		ePackagesData = new EPackagesData(configuration.ePackages,
			 configuration.ignoredEClasses)
	} 
	override call(Iterator<String> iterator) throws Exception {
		val List<Boolean> result= new LinkedList<Boolean>
		while (iterator.hasNext) {
			generateCrossReferences(_resource.getEObject(iterator.next))
		}
		return result.iterator
	}
	
	protected def generateCrossReferences(EObject eObject) {
		val eAllNonContainment = ePackagesData.eAllNonContainment(eObject.eClass)
		for (EReference eReference : eAllNonContainment) {
			val eReferenceType = eReference.EReferenceType
			val distribution = _conf.getDistributionFor(eReference)

			if (eReference.isMany) {
				val  values =  eObject.eGet(eReference) as List<Object>
				val sample = distribution.sample
				LOGGER.info(MessageFormat.format("Generating {0} values for EReference ''{1}'' in EObject {2}", 
																sample, eReference.name, eObject.toString))
				for (var i = 0; i < sample; i++) {
					val possibleValues = resolveObjectsOfType(eReferenceType, eObject.eResource)
					if (!possibleValues.isEmpty) {
						val EObject nextEObject = possibleValues.get(generator.nextInt(possibleValues.size))
						values.add(nextEObject)
					}
				}
			} else {
				if (eReference.isRequired || booleanInDistribution(distribution)) {
					LOGGER.info(MessageFormat.format("Generating EReference ''{0}'' in EObject {1}", eReference.name, eObject.toString))
					val possibleValues = resolveObjectsOfType(eReferenceType, eObject.eResource)
					if (!possibleValues.isEmpty) {
						val EObject nextEObject = possibleValues.get(generator.nextInt(possibleValues.size))
						eObject.eSet(eReference, nextEObject)
					}
				}
			}
		}
	}
	
	protected def List<EObject> resolveObjectsOfType(EClass eReferenceType, Resource resource) {
		val possibleValues = new LinkedList<EObject>
		for (String uriFrag : indexByName.get(eReferenceType.name)) {
			possibleValues.add(resource.getEObject(uriFrag))
		}
		possibleValues
	}
	
	protected def boolean booleanInDistribution(IntegerDistribution distribution) {
		distribution.sample <= distribution.numericalMean
	}

	
}