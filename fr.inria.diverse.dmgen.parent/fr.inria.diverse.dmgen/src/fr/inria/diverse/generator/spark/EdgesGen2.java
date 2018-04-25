package fr.inria.diverse.generator.spark;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;

import fr.inria.diverse.generator.specimen.ISpecimenConfiguration;
import fr.inria.diverse.generator.util.EPackagesData;

public class EdgesGen2 implements  FlatMapFunction<Iterator<String>, Boolean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9015079956041306600L;
	private static Resource _resource;
	private static ISpecimenConfiguration _conf;
	private static EPackagesData ePackagesData;
	private static MultiMap<String, String> indexByName;
	private static HazelcastInstance hcInstance;
	
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger("Generator");

	private static Random generator;
	
	public EdgesGen2(ISpecimenConfiguration configuration, Resource resource) {
		_resource = resource;
		_conf = configuration;
		hcInstance = Hazelcast.newHazelcastInstance();
		indexByName = hcInstance.getMultiMap("indexed-elements");
		generator = new Random(configuration.getSeed());
//		ePackagesData = new EPackagesData(configuration.ePackages()
//				, configuration.ignoredEClasses());
	}
	@Override
	public Iterator<Boolean> call(Iterator<String> iterator) throws Exception {
		List<Boolean> result= new LinkedList<Boolean>();
		while (iterator.hasNext()) {
			generateCrossReferences(_resource.getEObject(iterator.next()));
		}
		return result.iterator();
	}
	
	protected void generateCrossReferences(EObject eObject) {
		Iterable<EReference> eAllNonContainment = ePackagesData.eAllNonContainment(eObject.eClass());
		for (EReference eReference : eAllNonContainment) {
			EClass eReferenceType = eReference.getEReferenceType();
			IntegerDistribution distribution = _conf.getDistributionFor(eReference);

			if (eReference.isMany()) {
				@SuppressWarnings("unchecked")
				List<Object> values = (List<Object>) eObject.eGet(eReference);
				int sample = distribution.sample();
				LOGGER.info(MessageFormat.format("Generating {0} values for EReference ''{1}'' in EObject {2}", 
																sample, eReference.getName(), eObject.toString()));
				for (int i = 0; i < sample; i++) {
					List<EObject> possibleValues = resolveObjectsOfType(eReferenceType, eObject.eResource());
					if (!possibleValues.isEmpty()) {
						final EObject nextEObject = possibleValues.get(generator.nextInt(possibleValues.size()));
						values.add(nextEObject);
					}
				}
			} else {
				if (eReference.isRequired() || booleanInDistribution(distribution)) {
					LOGGER.info(MessageFormat.format("Generating EReference ''{0}'' in EObject {1}", eReference.getName(), eObject.toString()));
					List<EObject> possibleValues = resolveObjectsOfType(eReferenceType, eObject.eResource());
					if (!possibleValues.isEmpty()) {
						final EObject nextEObject = possibleValues.get(generator.nextInt(possibleValues.size()));
						eObject.eSet(eReference, nextEObject);
					}
				}
			}
		}
	}
	
	protected List<EObject> resolveObjectsOfType(EClass eReferenceType, Resource resource) {
		List<EObject> possibleValues = new LinkedList<EObject>();
		for (String uriFrag : indexByName.get(eReferenceType.getName())) {
			possibleValues.add(resource.getEObject(uriFrag));
		}
		return possibleValues;
	}
	
	protected boolean booleanInDistribution(IntegerDistribution distribution) {
		int sample = distribution.sample();
		return sample <= distribution.getNumericalMean();
	}


	
	
}
