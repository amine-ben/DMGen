package fr.inria.diverse.generator.util;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Primitives;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;
import fr.inria.atlanmod.neoemf.core.Id;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.diverse.generator.specimen.ISpecimenConfiguration;
import fr.inria.diverse.generator.util.EPackagesData;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public class VerticesGenToPair implements FlatMapFunction<Iterator<Long>, String> {
  private final static long seed = 265933L;
  
  private final static Logger LOGGER = LogManager.getLogger("Generator");
  
  private static ISpecimenConfiguration _conf;
  
  private static EPackagesData ePackagesData;
  
  private static Resource _resource;
  
  private static HazelcastInstance hcInstance;
  
  private Random _generator;
  
  private int currentDepth = 0;
  
  private int currentMaxDepth = 0;
  
  private int currentObjectCount = 0;
  
  private long averageSize;
  
  public VerticesGenToPair(final ISpecimenConfiguration conf, final long averageSize, final Resource resource) {
    VerticesGenToPair._conf = conf;
    Random _random = new Random(VerticesGenToPair.seed);
    this._generator = _random;
    ImmutableSet<EPackage> _ePackages = conf.ePackages();
    ImmutableSet<EClass> _ignoredEClasses = conf.ignoredEClasses();
    EPackagesData _ePackagesData = new EPackagesData(_ePackages, _ignoredEClasses);
    VerticesGenToPair.ePackagesData = _ePackagesData;
    this.averageSize = averageSize;
    VerticesGenToPair._resource = resource;
    HazelcastInstance _newHazelcastInstance = Hazelcast.newHazelcastInstance();
    VerticesGenToPair.hcInstance = _newHazelcastInstance;
  }
  
  @Override
  public Iterator<String> call(final Iterator<Long> key) throws Exception {
    final ArrayList<String> result = new ArrayList<String>();
    final ImmutableSet<EClass> possibleRootEClasses = VerticesGenToPair._conf.possibleRootEClasses();
    final MultiMap<String, String> indexByName = VerticesGenToPair.hcInstance.<String, String>getMultiMap("indexed-elements");
    while ((this.currentObjectCount < this.averageSize)) {
      {
        EClass eClass = VerticesGenToPair._conf.getNextRootEClass(possibleRootEClasses);
        IntegerDistribution _depthDistributionFor = VerticesGenToPair._conf.getDepthDistributionFor(eClass);
        int _sample = _depthDistributionFor.sample();
        this.currentMaxDepth = _sample;
        final Optional<EObject> generateEObject = this.generateEObject(eClass, result, indexByName);
        boolean _isPresent = generateEObject.isPresent();
        if (_isPresent) {
          EList<EObject> _contents = VerticesGenToPair._resource.getContents();
          EObject _get = generateEObject.get();
          _contents.add(_get);
        }
      }
    }
    return result.iterator();
  }
  
  private Optional<EObject> generateEObject(final EClass eClass, final ArrayList<String> result, final MultiMap<String, String> indexByName) {
    this.currentObjectCount++;
    String _name = eClass.getName();
    String _format = MessageFormat.format("Generating EObject {0} / ~{1} (EClass={2})", 
      Integer.valueOf(this.currentObjectCount), Long.valueOf(this.averageSize), _name);
    VerticesGenToPair.LOGGER.info(_format);
    final EObject eObject = this.createEObject(eClass, result, indexByName);
    this.generateEAttributes(eObject, eClass);
    this.generateEContainmentReferences(eObject, eClass, result, indexByName);
    return Optional.<EObject>fromNullable(eObject);
  }
  
  protected EObject createEObject(final EClass eClass, final ArrayList<String> result, final MultiMap<String, String> indexByName) {
    EPackage _ePackage = eClass.getEPackage();
    EFactory _eFactoryInstance = _ePackage.getEFactoryInstance();
    final EObject eObject = _eFactoryInstance.create(eClass);
    Id _id = ((PersistentEObject) eObject).id();
    String _string = _id.toString();
    result.add(_string);
    Id _id_1 = ((PersistentEObject) eObject).id();
    String _string_1 = _id_1.toString();
    String _name = eClass.getName();
    indexByName.put(_string_1, _name);
    EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
    for (final EClass eSuperType : _eAllSuperTypes) {
      Id _id_2 = ((PersistentEObject) eObject).id();
      String _string_2 = _id_2.toString();
      String _name_1 = eSuperType.getName();
      indexByName.put(_string_2, _name_1);
    }
    return eObject;
  }
  
  protected void generateEAttributes(final EObject eObject, final EClass eClass) {
    ImmutableList<EAttribute> _eAllAttributes = VerticesGenToPair.ePackagesData.eAllAttributes(eClass);
    for (final EAttribute eAttribute : _eAllAttributes) {
      this.generateAttributes(eObject, eAttribute);
    }
  }
  
  protected void generateAttributes(final EObject eObject, final EAttribute eAttribute) {
    final IntegerDistribution distribution = VerticesGenToPair._conf.getDistributionFor(eAttribute);
    final EDataType eAttributeType = eAttribute.getEAttributeType();
    final Class<?> instanceClass = eAttributeType.getInstanceClass();
    boolean _isMany = eAttribute.isMany();
    if (_isMany) {
      this.generateManyAttribute(eObject, eAttribute, distribution, instanceClass);
    } else {
      this.generateSingleAttribute(eObject, eAttribute, distribution, instanceClass);
    }
  }
  
  protected boolean booleanInDistribution(final IntegerDistribution distribution) {
    final int sample = distribution.sample();
    double _numericalMean = distribution.getNumericalMean();
    return (sample <= _numericalMean);
  }
  
  protected void generateSingleAttribute(final EObject eObject, final EAttribute eAttribute, final IntegerDistribution distribution, final Class<?> instanceClass) {
    boolean _isRequired = eAttribute.isRequired();
    boolean _booleanInDistribution = this.booleanInDistribution(distribution);
    boolean _or = (_isRequired || _booleanInDistribution);
    if (_or) {
      Class<?> intermediateInstance = instanceClass;
      Object value = null;
      final EDataType eAttributeType = eAttribute.getEAttributeType();
      if ((eAttributeType instanceof EEnum)) {
        final EEnum eEnum = ((EEnum) eAttributeType);
        intermediateInstance = int.class;
        Object _nextValue = this.nextValue(intermediateInstance);
        final int randomValue = Math.abs((((Integer) _nextValue)).intValue());
        EList<EEnumLiteral> _eLiterals = eEnum.getELiterals();
        final int size = _eLiterals.size();
        EList<EEnumLiteral> _eLiterals_1 = eEnum.getELiterals();
        EEnumLiteral _get = _eLiterals_1.get((randomValue % size));
        value = _get;
      } else {
        Object _nextValue_1 = this.nextValue(instanceClass);
        value = _nextValue_1;
      }
      eObject.eSet(eAttribute, value);
    }
  }
  
  public Object nextValue(final Class<?> instanceClass) {
    Object value = null;
    if ((instanceClass.isPrimitive() || Primitives.isWrapperType(instanceClass))) {
      Class<?> _unwrap = Primitives.unwrap(instanceClass);
      Object _nextPrimitive = this.nextPrimitive(_unwrap);
      value = _nextPrimitive;
    } else {
      Object _nextObject = this.nextObject(instanceClass);
      value = _nextObject;
    }
    return value;
  }
  
  protected void generateManyAttribute(final EObject eObject, final EAttribute eAttribute, final IntegerDistribution distribution, final Class<?> instanceClass) {
    Object _eGet = eObject.eGet(eAttribute);
    final List<Object> values = ((List<Object>) _eGet);
    Class<?> intermediateInstance = instanceClass;
    for (int i = distribution.getSupportLowerBound(); (i < distribution.sample()); i++) {
      {
        Object value = null;
        final EDataType eAttributeType = eAttribute.getEAttributeType();
        if ((eAttributeType instanceof EEnum)) {
          final EEnum eEnum = ((EEnum) eAttributeType);
          intermediateInstance = int.class;
          Object _nextValue = this.nextValue(instanceClass);
          final int randomValue = Math.abs((((Integer) _nextValue)).intValue());
          EList<EEnumLiteral> _eLiterals = eEnum.getELiterals();
          final int size = _eLiterals.size();
          EList<EEnumLiteral> _eLiterals_1 = eEnum.getELiterals();
          EEnumLiteral _get = _eLiterals_1.get((randomValue % size));
          value = _get;
        } else {
          Object _nextValue_1 = this.nextValue(instanceClass);
          value = _nextValue_1;
        }
        values.add(value);
      }
    }
  }
  
  /**
   * @param instanceClass
   */
  protected Object nextObject(final Class<?> instanceClass) {
    boolean _equals = Objects.equal(instanceClass, String.class);
    if (_equals) {
      IntegerDistribution _valueDistributionFor = VerticesGenToPair._conf.getValueDistributionFor(instanceClass);
      int _sample = _valueDistributionFor.sample();
      return RandomStringUtils.random(_sample, 
        0, 0, true, true, null, this._generator);
    } else {
      String _name = instanceClass.getName();
      String _format = MessageFormat.format("Do not know how to randomly generate \'\'{0}\'\' object", _name);
      VerticesGenToPair.LOGGER.warn(_format);
    }
    return null;
  }
  
  /**
   * @param eObject
   * @param eAttribute
   * @param instanceClass
   */
  protected Object nextPrimitive(final Class<?> instanceClass) {
    boolean _equals = Objects.equal(instanceClass, boolean.class);
    if (_equals) {
      return Boolean.valueOf(this._generator.nextBoolean());
    } else {
      boolean _equals_1 = Objects.equal(instanceClass, byte.class);
      if (_equals_1) {
        byte[] buff = new byte[1];
        this._generator.nextBytes(buff);
        return Byte.valueOf(buff[0]);
      } else {
        boolean _equals_2 = Objects.equal(instanceClass, char.class);
        if (_equals_2) {
          int _nextInt = this._generator.nextInt();
          final char nextChar = ((char) _nextInt);
          return Character.valueOf(nextChar);
        } else {
          boolean _equals_3 = Objects.equal(instanceClass, double.class);
          if (_equals_3) {
            return Double.valueOf(this._generator.nextDouble());
          } else {
            boolean _equals_4 = Objects.equal(instanceClass, float.class);
            if (_equals_4) {
              return Float.valueOf(this._generator.nextFloat());
            } else {
              boolean _equals_5 = Objects.equal(instanceClass, int.class);
              if (_equals_5) {
                return Integer.valueOf(this._generator.nextInt());
              } else {
                boolean _equals_6 = Objects.equal(instanceClass, long.class);
                if (_equals_6) {
                  return Long.valueOf(this._generator.nextLong());
                } else {
                  boolean _equals_7 = Objects.equal(instanceClass, short.class);
                  if (_equals_7) {
                    int _nextInt_1 = this._generator.nextInt();
                    final short nextShort = ((short) _nextInt_1);
                    return Short.valueOf(nextShort);
                  } else {
                    throw new IllegalArgumentException();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  /**
   * @param eObject
   * @param eClass
   * @param indexByKind
   */
  protected void generateEContainmentReferences(final EObject eObject, final EClass eClass, final ArrayList<String> result, final MultiMap<String, String> indexByName) {
    Iterable<EReference> _eAllContainment = VerticesGenToPair.ePackagesData.eAllContainment(eClass);
    for (final EReference eReference : _eAllContainment) {
      if ((eReference.isRequired() || ((this.currentObjectCount < this.averageSize) && (this.currentDepth <= this.currentMaxDepth)))) {
        this.generateEContainmentReference(eObject, eReference, result, indexByName);
      }
    }
  }
  
  /**
   * @param eObject
   * @param eReference
   * @param indexByKind
   */
  protected int generateEContainmentReference(final EObject eObject, final EReference eReference, final ArrayList<String> result, final MultiMap<String, String> indexByName) {
    int _xblockexpression = (int) 0;
    {
      this.currentDepth++;
      final ImmutableList<EClass> eAllConcreteSubTypeOrSelf = VerticesGenToPair.ePackagesData.eAllConcreteSubTypeOrSelf(eReference);
      final ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf = this.getEReferenceTypesWithWeight(eReference, eAllConcreteSubTypeOrSelf);
      boolean _isEmpty = eAllConcreteSubTypesOrSelf.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        boolean _isMany = eReference.isMany();
        if (_isMany) {
          this.generateManyContainmentReference(eObject, eReference, result, indexByName, eAllConcreteSubTypesOrSelf);
        } else {
          this.generateSingleContainmentReference(eObject, eReference, result, indexByName, eAllConcreteSubTypesOrSelf);
        }
      }
      _xblockexpression = this.currentDepth--;
    }
    return _xblockexpression;
  }
  
  protected void generateSingleContainmentReference(final EObject eObject, final EReference eReference, final ArrayList<String> result, final MultiMap<String, String> indexByName, final ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
    final IntegerDistribution distribution = VerticesGenToPair._conf.getDistributionFor(eReference);
    if ((eReference.isRequired() || this.booleanInDistribution(distribution))) {
      String _name = eReference.getName();
      String _string = eObject.toString();
      String _format = MessageFormat.format("Generating EReference \'\'{0}\'\' in EObject {1}", _name, _string);
      VerticesGenToPair.LOGGER.info(_format);
      int _size = eAllConcreteSubTypesOrSelf.size();
      final int idx = this._generator.nextInt(_size);
      EClass _get = Iterables.<EClass>get(eAllConcreteSubTypesOrSelf, idx);
      final Optional<EObject> nextEObject = this.generateEObject(_get, result, indexByName);
      boolean _isPresent = nextEObject.isPresent();
      if (_isPresent) {
        EObject _get_1 = nextEObject.get();
        eObject.eSet(eReference, _get_1);
      }
    }
  }
  
  protected void generateManyContainmentReference(final EObject eObject, final EReference eReference, final ArrayList<String> result, final MultiMap<String, String> indexByName, final ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
    final IntegerDistribution distribution = VerticesGenToPair._conf.getDistributionFor(eReference);
    Object _eGet = eObject.eGet(eReference);
    final List<EObject> values = ((List<EObject>) _eGet);
    final int sample = distribution.sample();
    String _name = eReference.getName();
    String _string = eObject.toString();
    String _format = MessageFormat.format("Generating {0} values for EReference \'\'{1}\'\' in EObject {2}", Integer.valueOf(sample), _name, _string);
    VerticesGenToPair.LOGGER.info(_format);
    for (int i = 0; (i < sample); i++) {
      {
        int _size = eAllConcreteSubTypesOrSelf.size();
        final int idx = this._generator.nextInt(_size);
        EClass _get = Iterables.<EClass>get(eAllConcreteSubTypesOrSelf, idx);
        final Optional<EObject> nextEObject = this.generateEObject(_get, result, indexByName);
        boolean _isPresent = nextEObject.isPresent();
        if (_isPresent) {
          EObject _get_1 = nextEObject.get();
          values.add(_get_1);
        }
      }
    }
  }
  
  public ImmutableMultiset<EClass> getEReferenceTypesWithWeight(final EReference eReference, final ImmutableList<EClass> eAllSubTypesOrSelf) {
    final ImmutableMultiset.Builder<EClass> eAllSubTypesOrSelfWithWeights = ImmutableMultiset.<EClass>builder();
    for (final EClass eClass : eAllSubTypesOrSelf) {
      int _weightFor = VerticesGenToPair._conf.getWeightFor(eReference, eClass);
      eAllSubTypesOrSelfWithWeights.addCopies(eClass, _weightFor);
    }
    return eAllSubTypesOrSelfWithWeights.build();
  }
}
