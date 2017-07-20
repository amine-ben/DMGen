package fr.inria.diverse.spark_generator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;
import fr.inria.diverse.spark_generator.specimen.ISpecimenConfiguration;
import fr.inria.diverse.spark_generator.util.EPackagesData;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public class EdgesGen implements FlatMapFunction<Iterator<String>, Boolean> {
  private static Resource _resource;
  
  private static ISpecimenConfiguration _conf;
  
  private static EPackagesData ePackagesData;
  
  private static MultiMap<String, String> indexByName;
  
  private static HazelcastInstance hcInstance;
  
  private final static Logger LOGGER = LogManager.getLogger("Generator");
  
  private static Random generator;
  
  public EdgesGen(final ISpecimenConfiguration configuration, final Resource resource) {
    EdgesGen._resource = resource;
    EdgesGen._conf = configuration;
    HazelcastInstance _newHazelcastInstance = Hazelcast.newHazelcastInstance();
    EdgesGen.hcInstance = _newHazelcastInstance;
    MultiMap<String, String> _multiMap = EdgesGen.hcInstance.<String, String>getMultiMap("indexed-elements");
    EdgesGen.indexByName = _multiMap;
    long _seed = configuration.getSeed();
    Random _random = new Random(_seed);
    EdgesGen.generator = _random;
    ImmutableSet<EPackage> _ePackages = configuration.ePackages();
    ImmutableSet<EClass> _ignoredEClasses = configuration.ignoredEClasses();
    EPackagesData _ePackagesData = new EPackagesData(_ePackages, _ignoredEClasses);
    EdgesGen.ePackagesData = _ePackagesData;
  }
  
  @Override
  public Iterator<Boolean> call(final Iterator<String> iterator) throws Exception {
    final List<Boolean> result = new LinkedList<Boolean>();
    while (iterator.hasNext()) {
      String _next = iterator.next();
      EObject _eObject = EdgesGen._resource.getEObject(_next);
      this.generateCrossReferences(_eObject);
    }
    return result.iterator();
  }
  
  protected void generateCrossReferences(final EObject eObject) {
    EClass _eClass = eObject.eClass();
    final ImmutableList<EReference> eAllNonContainment = EdgesGen.ePackagesData.eAllNonContainment(_eClass);
    for (final EReference eReference : eAllNonContainment) {
      {
        final EClass eReferenceType = eReference.getEReferenceType();
        final IntegerDistribution distribution = EdgesGen._conf.getDistributionFor(eReference);
        boolean _isMany = eReference.isMany();
        if (_isMany) {
          Object _eGet = eObject.eGet(eReference);
          final List<Object> values = ((List<Object>) _eGet);
          final int sample = distribution.sample();
          String _name = eReference.getName();
          String _string = eObject.toString();
          String _format = MessageFormat.format("Generating {0} values for EReference \'\'{1}\'\' in EObject {2}", Integer.valueOf(sample), _name, _string);
          EdgesGen.LOGGER.info(_format);
          for (int i = 0; (i < sample); i++) {
            {
              Resource _eResource = eObject.eResource();
              final List<EObject> possibleValues = this.resolveObjectsOfType(eReferenceType, _eResource);
              boolean _isEmpty = possibleValues.isEmpty();
              boolean _not = (!_isEmpty);
              if (_not) {
                int _size = possibleValues.size();
                int _nextInt = EdgesGen.generator.nextInt(_size);
                final EObject nextEObject = possibleValues.get(_nextInt);
                values.add(nextEObject);
              }
            }
          }
        } else {
          if ((eReference.isRequired() || this.booleanInDistribution(distribution))) {
            String _name_1 = eReference.getName();
            String _string_1 = eObject.toString();
            String _format_1 = MessageFormat.format("Generating EReference \'\'{0}\'\' in EObject {1}", _name_1, _string_1);
            EdgesGen.LOGGER.info(_format_1);
            Resource _eResource = eObject.eResource();
            final List<EObject> possibleValues = this.resolveObjectsOfType(eReferenceType, _eResource);
            boolean _isEmpty = possibleValues.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              int _size = possibleValues.size();
              int _nextInt = EdgesGen.generator.nextInt(_size);
              final EObject nextEObject = possibleValues.get(_nextInt);
              eObject.eSet(eReference, nextEObject);
            }
          }
        }
      }
    }
  }
  
  protected List<EObject> resolveObjectsOfType(final EClass eReferenceType, final Resource resource) {
    LinkedList<EObject> _xblockexpression = null;
    {
      final LinkedList<EObject> possibleValues = new LinkedList<EObject>();
      String _name = eReferenceType.getName();
      Collection<String> _get = EdgesGen.indexByName.get(_name);
      for (final String uriFrag : _get) {
        EObject _eObject = resource.getEObject(uriFrag);
        possibleValues.add(_eObject);
      }
      _xblockexpression = possibleValues;
    }
    return _xblockexpression;
  }
  
  protected boolean booleanInDistribution(final IntegerDistribution distribution) {
    int _sample = distribution.sample();
    double _numericalMean = distribution.getNumericalMean();
    return (_sample <= _numericalMean);
  }
}
