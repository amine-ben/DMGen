package fr.inria.diverse.generator;

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
import fr.inria.diverse.dmgen.Generator;
import fr.inria.diverse.generator.spark.IGenerator;
import fr.inria.diverse.generator.specimen.ISpecimenConfiguration;
import fr.inria.diverse.generator.util.EPackagesData;
import java.text.MessageFormat;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.Range;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.log4j.Logger;
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
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:abel.gomez-llana@inria.fr">Abel Gomez</a>
 * @author <a href="mailto:amine.benelallam@inria.fr">Amine Benelallam</a>
 */
@Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
@SuppressWarnings("all")
public class LocalGenerator implements IGenerator {
  protected final static Logger LOGGER = Logger.getLogger(LocalGenerator.class.getName());
  
  protected ISpecimenConfiguration configuration;
  
  protected EPackagesData ePackagesData;
  
  protected Generator generator;
  
  protected Random random;
  
  /**
   * inner Variable state
   */
  protected int currentDepth;
  
  protected int currentMaxDepth;
  
  protected int currentObjectCount;
  
  protected int goalObjects;
  
  private MultiMap<String, String> indexByName;
  
  private HazelcastInstance hcInstance;
  
  @Override
  public ISpecimenConfiguration getConfig() {
    return this.configuration;
  }
  
  public LocalGenerator(final ISpecimenConfiguration configuration) {
    this.configuration = configuration;
    long _seed = configuration.getSeed();
    Random _random = new Random(_seed);
    this.random = _random;
    HazelcastInstance _newHazelcastInstance = Hazelcast.newHazelcastInstance();
    this.hcInstance = _newHazelcastInstance;
    MultiMap<String, String> _multiMap = this.hcInstance.<String, String>getMultiMap("indexed-elements");
    this.indexByName = _multiMap;
    ImmutableSet<EPackage> _ePackages = configuration.ePackages();
    ImmutableSet<EClass> _ignoredEClasses = configuration.ignoredEClasses();
    EPackagesData _ePackagesData = new EPackagesData(_ePackages, _ignoredEClasses);
    this.ePackagesData = _ePackagesData;
  }
  
  public LocalGenerator(final ISpecimenConfiguration configuration, final long seed, final Generator generator) {
    this(configuration);
    this.generator = generator;
  }
  
  /**
   * Core method for generating models elements
   */
  @Override
  public void generate(final Resource resource) {
    int _number = this.generator.getNumber();
    String _xifexpression = null;
    int _number_1 = this.generator.getNumber();
    boolean _greaterThan = (_number_1 > 1);
    if (_greaterThan) {
      _xifexpression = "s";
    } else {
      _xifexpression = "";
    }
    String _format = MessageFormat.format("Creating {0} model{1} using as generator {2}", Integer.valueOf(_number), _xifexpression, 
      "Spark Model Generator");
    LocalGenerator.LOGGER.info(_format);
    ISpecimenConfiguration _config = this.getConfig();
    long _seed = _config.getSeed();
    String _format_1 = MessageFormat.format("Generator seed is \'\'{0}\'\'", Long.valueOf(_seed));
    LocalGenerator.LOGGER.info(_format_1);
    ISpecimenConfiguration _config_1 = this.getConfig();
    Range<Integer> _elementsRange = _config_1.getElementsRange();
    Integer _minimum = _elementsRange.getMinimum();
    ISpecimenConfiguration _config_2 = this.getConfig();
    Range<Integer> _elementsRange_1 = _config_2.getElementsRange();
    Integer _maximum = _elementsRange_1.getMaximum();
    String _format_2 = MessageFormat.format("Config parameters: range for models size is [{0}, {1}]", _minimum, _maximum);
    LocalGenerator.LOGGER.info(_format_2);
    ISpecimenConfiguration _config_3 = this.getConfig();
    Range<Integer> _propertiesRange = _config_3.getPropertiesRange();
    Integer _minimum_1 = _propertiesRange.getMinimum();
    ISpecimenConfiguration _config_4 = this.getConfig();
    Range<Integer> _propertiesRange_1 = _config_4.getPropertiesRange();
    Integer _maximum_1 = _propertiesRange_1.getMaximum();
    String _format_3 = MessageFormat.format("Config parameters: range for properties number is [{0}, {1}]", _minimum_1, _maximum_1);
    LocalGenerator.LOGGER.info(_format_3);
    ISpecimenConfiguration _config_5 = this.getConfig();
    Range<Integer> _referencesRange = _config_5.getReferencesRange();
    Integer _minimum_2 = _referencesRange.getMinimum();
    ISpecimenConfiguration _config_6 = this.getConfig();
    Range<Integer> _referencesRange_1 = _config_6.getReferencesRange();
    Integer _maximum_2 = _referencesRange_1.getMaximum();
    String _format_4 = MessageFormat.format("Config parameters: range for references number is [{0}, {1}]", _minimum_2, _maximum_2);
    LocalGenerator.LOGGER.info(_format_4);
    ISpecimenConfiguration _config_7 = this.getConfig();
    Range<Integer> _valuesRange = _config_7.getValuesRange();
    Integer _minimum_3 = _valuesRange.getMinimum();
    ISpecimenConfiguration _config_8 = this.getConfig();
    Range<Integer> _valuesRange_1 = _config_8.getValuesRange();
    Integer _maximum_3 = _valuesRange_1.getMaximum();
    String _format_5 = MessageFormat.format("Config parameters: range for values length is [{0}, {1}]", _minimum_3, _maximum_3);
    LocalGenerator.LOGGER.info(_format_5);
    final ImmutableSet<EClass> possibleRootEClasses = this.configuration.possibleRootEClasses();
    this.currentDepth = 0;
    this.currentMaxDepth = 0;
    this.currentObjectCount = 0;
    int _size = this.generator.getSize();
    this.goalObjects = _size;
    while ((this.currentObjectCount < this.goalObjects)) {
      {
        final EClass eClass = this.configuration.getNextRootEClass(possibleRootEClasses);
        IntegerDistribution _depthDistributionFor = this.configuration.getDepthDistributionFor(eClass);
        int _sample = _depthDistributionFor.sample();
        this.currentMaxDepth = _sample;
        final Optional<EObject> generateEObject = this.generateEObject(eClass, this.indexByName);
        boolean _isPresent = generateEObject.isPresent();
        if (_isPresent) {
          EList<EObject> _contents = resource.getContents();
          EObject _get = generateEObject.get();
          _contents.add(_get);
        }
      }
    }
    LocalGenerator.LOGGER.info("Generating cross-references");
  }
  
  private Optional<EObject> generateEObject(final EClass eClass, final MultiMap<String, String> indexByName) {
    this.currentObjectCount++;
    final EObject eObject = this.createEObject(eClass, indexByName);
    this.generateEAttributes(eObject, eClass);
    this.generateEContainmentReferences(eObject, eClass, indexByName);
    return Optional.<EObject>fromNullable(eObject);
  }
  
  protected EObject createEObject(final EClass eClass, final MultiMap<String, String> indexByName) {
    EPackage _ePackage = eClass.getEPackage();
    EFactory _eFactoryInstance = _ePackage.getEFactoryInstance();
    final EObject eObject = _eFactoryInstance.create(eClass);
    Id _id = ((PersistentEObject) eObject).id();
    String _string = _id.toString();
    String _name = eClass.getName();
    indexByName.put(_string, _name);
    EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
    for (final EClass eSuperType : _eAllSuperTypes) {
      Id _id_1 = ((PersistentEObject) eObject).id();
      String _string_1 = _id_1.toString();
      String _name_1 = eSuperType.getName();
      indexByName.put(_string_1, _name_1);
    }
    return eObject;
  }
  
  protected void generateEAttributes(final EObject eObject, final EClass eClass) {
    ImmutableList<EAttribute> _eAllAttributes = this.ePackagesData.eAllAttributes(eClass);
    for (final EAttribute eAttribute : _eAllAttributes) {
      this.generateAttributes(eObject, eAttribute);
    }
  }
  
  protected void generateAttributes(final EObject eObject, final EAttribute eAttribute) {
    final IntegerDistribution distribution = this.configuration.getDistributionFor(eAttribute);
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
  
  public void generateSingleAttribute(final EObject eObject, final EAttribute eAttribute, final IntegerDistribution distribution, final Class<?> instanceClass) {
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
      IntegerDistribution _valueDistributionFor = this.configuration.getValueDistributionFor(instanceClass);
      int _sample = _valueDistributionFor.sample();
      return RandomStringUtils.random(_sample, 
        0, 0, true, true, null, this.random);
    } else {
      String _name = instanceClass.getName();
      String _format = MessageFormat.format("Do not know how to randomly generate \'\'{0}\'\' object", _name);
      LocalGenerator.LOGGER.warn(_format);
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
      return Boolean.valueOf(this.random.nextBoolean());
    } else {
      boolean _equals_1 = Objects.equal(instanceClass, byte.class);
      if (_equals_1) {
        byte[] buff = new byte[1];
        this.random.nextBytes(buff);
        return Byte.valueOf(buff[0]);
      } else {
        boolean _equals_2 = Objects.equal(instanceClass, char.class);
        if (_equals_2) {
          int _nextInt = this.random.nextInt();
          final char nextChar = ((char) _nextInt);
          return Character.valueOf(nextChar);
        } else {
          boolean _equals_3 = Objects.equal(instanceClass, double.class);
          if (_equals_3) {
            return Double.valueOf(this.random.nextDouble());
          } else {
            boolean _equals_4 = Objects.equal(instanceClass, float.class);
            if (_equals_4) {
              return Float.valueOf(this.random.nextFloat());
            } else {
              boolean _equals_5 = Objects.equal(instanceClass, int.class);
              if (_equals_5) {
                return Integer.valueOf(this.random.nextInt());
              } else {
                boolean _equals_6 = Objects.equal(instanceClass, long.class);
                if (_equals_6) {
                  return Long.valueOf(this.random.nextLong());
                } else {
                  boolean _equals_7 = Objects.equal(instanceClass, short.class);
                  if (_equals_7) {
                    int _nextInt_1 = this.random.nextInt();
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
  protected void generateEContainmentReferences(final EObject eObject, final EClass eClass, final MultiMap<String, String> indexByName) {
    Iterable<EReference> _eAllContainment = this.ePackagesData.eAllContainment(eClass);
    for (final EReference eReference : _eAllContainment) {
      if ((eReference.isRequired() || ((this.currentObjectCount < this.goalObjects) && (this.currentDepth <= this.currentMaxDepth)))) {
        this.generateEContainmentReference(eObject, eReference, indexByName);
      }
    }
  }
  
  /**
   * @param eObject
   * @param eReference
   * @param indexByKind
   */
  protected int generateEContainmentReference(final EObject eObject, final EReference eReference, final MultiMap<String, String> indexByName) {
    int _xblockexpression = (int) 0;
    {
      this.currentDepth++;
      final ImmutableList<EClass> eAllConcreteSubTypeOrSelf = this.ePackagesData.eAllConcreteSubTypeOrSelf(eReference);
      final ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf = this.getEReferenceTypesWithWeight(eReference, eAllConcreteSubTypeOrSelf);
      boolean _isEmpty = eAllConcreteSubTypesOrSelf.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        boolean _isMany = eReference.isMany();
        if (_isMany) {
          this.generateManyContainmentReference(eObject, eReference, indexByName, eAllConcreteSubTypesOrSelf);
        } else {
          this.generateSingleContainmentReference(eObject, eReference, indexByName, eAllConcreteSubTypesOrSelf);
        }
      }
      _xblockexpression = this.currentDepth--;
    }
    return _xblockexpression;
  }
  
  protected void generateSingleContainmentReference(final EObject eObject, final EReference eReference, final MultiMap<String, String> indexByName, final ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
    final IntegerDistribution distribution = this.configuration.getDistributionFor(eReference);
    if ((eReference.isRequired() || this.booleanInDistribution(distribution))) {
      String _name = eReference.getName();
      String _string = eObject.toString();
      String _format = MessageFormat.format("Generating EReference \'\'{0}\'\' in EObject {1}", _name, _string);
      LocalGenerator.LOGGER.info(_format);
      int _size = eAllConcreteSubTypesOrSelf.size();
      final int idx = this.random.nextInt(_size);
      EClass _get = Iterables.<EClass>get(eAllConcreteSubTypesOrSelf, idx);
      final Optional<EObject> nextEObject = this.generateEObject(_get, indexByName);
      boolean _isPresent = nextEObject.isPresent();
      if (_isPresent) {
        EObject _get_1 = nextEObject.get();
        eObject.eSet(eReference, _get_1);
      }
    }
  }
  
  protected void generateManyContainmentReference(final EObject eObject, final EReference eReference, final MultiMap<String, String> indexByName, final ImmutableMultiset<EClass> eAllConcreteSubTypesOrSelf) {
    final IntegerDistribution distribution = this.configuration.getDistributionFor(eReference);
    Object _eGet = eObject.eGet(eReference);
    final List<EObject> values = ((List<EObject>) _eGet);
    final int sample = distribution.sample();
    String _name = eReference.getName();
    String _string = eObject.toString();
    String _format = MessageFormat.format("Generating {0} values for EReference \'\'{1}\'\' in EObject {2}", Integer.valueOf(sample), _name, _string);
    LocalGenerator.LOGGER.info(_format);
    for (int i = 0; (i < sample); i++) {
      {
        int _size = eAllConcreteSubTypesOrSelf.size();
        final int idx = this.random.nextInt(_size);
        EClass _get = Iterables.<EClass>get(eAllConcreteSubTypesOrSelf, idx);
        final Optional<EObject> nextEObject = this.generateEObject(_get, indexByName);
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
      int _weightFor = this.configuration.getWeightFor(eReference, eClass);
      eAllSubTypesOrSelfWithWeights.addCopies(eClass, _weightFor);
    }
    return eAllSubTypesOrSelfWithWeights.build();
  }
  
  @Pure
  public ISpecimenConfiguration getConfiguration() {
    return this.configuration;
  }
  
  protected void setConfiguration(final ISpecimenConfiguration configuration) {
    this.configuration = configuration;
  }
  
  @Pure
  public EPackagesData getEPackagesData() {
    return this.ePackagesData;
  }
  
  protected void setEPackagesData(final EPackagesData ePackagesData) {
    this.ePackagesData = ePackagesData;
  }
  
  @Pure
  public Generator getGenerator() {
    return this.generator;
  }
  
  protected void setGenerator(final Generator generator) {
    this.generator = generator;
  }
  
  @Pure
  public Random getRandom() {
    return this.random;
  }
  
  protected void setRandom(final Random random) {
    this.random = random;
  }
  
  @Pure
  public int getCurrentDepth() {
    return this.currentDepth;
  }
  
  protected void setCurrentDepth(final int currentDepth) {
    this.currentDepth = currentDepth;
  }
  
  @Pure
  public int getCurrentMaxDepth() {
    return this.currentMaxDepth;
  }
  
  protected void setCurrentMaxDepth(final int currentMaxDepth) {
    this.currentMaxDepth = currentMaxDepth;
  }
  
  @Pure
  public int getCurrentObjectCount() {
    return this.currentObjectCount;
  }
  
  protected void setCurrentObjectCount(final int currentObjectCount) {
    this.currentObjectCount = currentObjectCount;
  }
  
  @Pure
  public int getGoalObjects() {
    return this.goalObjects;
  }
  
  protected void setGoalObjects(final int goalObjects) {
    this.goalObjects = goalObjects;
  }
  
  @Pure
  public MultiMap<String, String> getIndexByName() {
    return this.indexByName;
  }
  
  protected void setIndexByName(final MultiMap<String, String> indexByName) {
    this.indexByName = indexByName;
  }
  
  @Pure
  public HazelcastInstance getHcInstance() {
    return this.hcInstance;
  }
  
  protected void setHcInstance(final HazelcastInstance hcInstance) {
    this.hcInstance = hcInstance;
  }
}
