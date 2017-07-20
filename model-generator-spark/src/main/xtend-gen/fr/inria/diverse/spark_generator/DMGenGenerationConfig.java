package fr.inria.diverse.spark_generator;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import fr.inria.diverse.dmgen.Clazz;
import fr.inria.diverse.dmgen.Generator;
import fr.inria.diverse.dmgen.Property;
import fr.inria.diverse.spark_generator.DMGenConfiguration;
import fr.inria.diverse.spark_generator.GenericMetamodelConfig;
import fr.inria.diverse.spark_generator.IGenerator;
import fr.inria.diverse.spark_generator.specimen.ISpecimenConfiguration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.Range;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author <A href="mailto:amine.benelallam@inria.fr">Amine Benelallam</a>
 */
@SuppressWarnings("all")
public class DMGenGenerationConfig extends GenericMetamodelConfig implements DMGenConfiguration {
  @Accessors
  protected Generator generator;
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
  protected Map<String, Range<Integer>> classDepthRange;
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
  protected Map<String, Map<String, Range<Integer>>> perClassReferencesRange;
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
  protected Map<String, Map<String, Range<Integer>>> perClassValuesRange;
  
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
  public DMGenGenerationConfig(final Resource metamodelResource, final Range<Integer> elementsRange, final long seed) {
    super(metamodelResource, elementsRange, seed);
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
  public DMGenGenerationConfig(final Resource metamodelResource, final Generator generator, final Range<Integer> elementsRange, final long seed) {
    this(metamodelResource, elementsRange, seed);
    this.generator = generator;
    HashMap<String, Range<Integer>> _hashMap = new HashMap<String, Range<Integer>>();
    this.classDepthRange = _hashMap;
    HashMap<String, Map<String, Range<Integer>>> _hashMap_1 = new HashMap<String, Map<String, Range<Integer>>>();
    this.perClassValuesRange = _hashMap_1;
    HashMap<String, Map<String, Range<Integer>>> _hashMap_2 = new HashMap<String, Map<String, Range<Integer>>>();
    this.perClassReferencesRange = _hashMap_2;
    EList<Clazz> _classes = generator.getClasses();
    final Consumer<Clazz> _function = (Clazz it) -> {
      this.updateMapValues(it);
    };
    _classes.forEach(_function);
  }
  
  /**
   * @param metamodelResource
   *            The resource containing the metamodel for which the
   *            {@link SpecimenGenerator} will create instances
   * @paral generator
   * 			  the generator containing the configuration
   */
  public DMGenGenerationConfig(final Resource resource, final Generator generator) {
    this(resource, generator, 
      Range.<Integer>between(Integer.valueOf(0), Integer.valueOf(IGenerator.DEFAULT_PROPERTIES_RANGE)), 
      new Random().nextLong());
  }
  
  private void updateMapValues(final Clazz clazz) {
    String _name = clazz.getName();
    int _depth = clazz.getDepth();
    float _globalDeviation = this.generator.getGlobalDeviation();
    float _minus = (1 - _globalDeviation);
    float _multiply = (_depth * _minus);
    int _round = Math.round(_multiply);
    int _depth_1 = clazz.getDepth();
    float _globalDeviation_1 = this.generator.getGlobalDeviation();
    float _plus = (1 + _globalDeviation_1);
    float _multiply_1 = (_depth_1 * _plus);
    int _round_1 = Math.round(_multiply_1);
    Range<Integer> _between = Range.<Integer>between(Integer.valueOf(_round), Integer.valueOf(_round_1));
    this.classDepthRange.put(_name, _between);
    String _name_1 = clazz.getName();
    HashMap<String, Range<Integer>> _hashMap = new HashMap<String, Range<Integer>>();
    this.perClassReferencesRange.put(_name_1, _hashMap);
    String _name_2 = clazz.getName();
    HashMap<String, Range<Integer>> _hashMap_1 = new HashMap<String, Range<Integer>>();
    this.perClassValuesRange.put(_name_2, _hashMap_1);
    EList<Property> _properties = clazz.getProperties();
    final Consumer<Property> _function = (Property it) -> {
      String _name_3 = clazz.getName();
      this.updateMapValues(it, _name_3);
    };
    _properties.forEach(_function);
  }
  
  public int depth(final Clazz clazz) {
    return IGenerator.DEFAULT_CLASS_DEPTH;
  }
  
  private void updateMapValues(final Property prop, final String clazzName) {
    boolean _isAttribute = this.isAttribute(prop, clazzName);
    boolean _not = (!_isAttribute);
    if (_not) {
      Map<String, Range<Integer>> _get = this.perClassReferencesRange.get(clazzName);
      String _name = prop.getName();
      Range<Integer> _referenceRange = this.getReferenceRange(prop);
      _get.put(_name, _referenceRange);
    } else {
      Map<String, Range<Integer>> _get_1 = this.perClassValuesRange.get(clazzName);
      String _name_1 = prop.getName();
      Range<Integer> _valueRange = this.getValueRange(prop);
      _get_1.put(_name_1, _valueRange);
    }
  }
  
  private boolean isAttribute(final Property property, final String clazzName) {
    ImmutableSet<EPackage> _ePackages = this.ePackages();
    final Function1<EPackage, EList<EClassifier>> _function = (EPackage ePck) -> {
      return ePck.getEClassifiers();
    };
    Iterable<EList<EClassifier>> _map = IterableExtensions.<EPackage, EList<EClassifier>>map(_ePackages, _function);
    Iterable<EClassifier> _flatten = Iterables.<EClassifier>concat(_map);
    final Function1<EClassifier, Boolean> _function_1 = (EClassifier clz) -> {
      String _name = clz.getName();
      return Boolean.valueOf(Objects.equal(_name, clazzName));
    };
    EClassifier _findFirst = IterableExtensions.<EClassifier>findFirst(_flatten, _function_1);
    final EClass myClass = ((EClass) _findFirst);
    EList<EAttribute> _eAllAttributes = myClass.getEAllAttributes();
    final Function1<EAttribute, Boolean> _function_2 = (EAttribute prop) -> {
      String _name = prop.getName();
      String _name_1 = property.getName();
      return Boolean.valueOf(Objects.equal(_name, _name_1));
    };
    EAttribute _findFirst_1 = IterableExtensions.<EAttribute>findFirst(_eAllAttributes, _function_2);
    return (!Objects.equal(_findFirst_1, null));
  }
  
  private Range<Integer> getValueRange(final Property property) {
    Range<Integer> _xifexpression = null;
    fr.inria.diverse.dmgen.Range _range = property.getRange();
    boolean _notEquals = (!Objects.equal(_range, null));
    if (_notEquals) {
      fr.inria.diverse.dmgen.Range _range_1 = property.getRange();
      int _lower = _range_1.getLower();
      fr.inria.diverse.dmgen.Range _range_2 = property.getRange();
      int _upper = _range_2.getUpper();
      _xifexpression = Range.<Integer>between(Integer.valueOf(_lower), Integer.valueOf(_upper));
    } else {
      int _globalDensity = this.generator.getGlobalDensity();
      float _globalDeviation = this.generator.getGlobalDeviation();
      float _minus = (1 - _globalDeviation);
      float _multiply = (_globalDensity * _minus);
      int _round = Math.round(_multiply);
      int _globalDensity_1 = this.generator.getGlobalDensity();
      float _globalDeviation_1 = this.generator.getGlobalDeviation();
      float _plus = (1 + _globalDeviation_1);
      float _multiply_1 = (_globalDensity_1 * _plus);
      int _round_1 = Math.round(_multiply_1);
      _xifexpression = Range.<Integer>between(Integer.valueOf(_round), Integer.valueOf(_round_1));
    }
    return _xifexpression;
  }
  
  private Range<Integer> getReferenceRange(final Property property) {
    Range<Integer> _xifexpression = null;
    fr.inria.diverse.dmgen.Range _range = property.getRange();
    boolean _notEquals = (!Objects.equal(_range, null));
    if (_notEquals) {
      fr.inria.diverse.dmgen.Range _range_1 = property.getRange();
      int _lower = _range_1.getLower();
      fr.inria.diverse.dmgen.Range _range_2 = property.getRange();
      int _upper = _range_2.getUpper();
      _xifexpression = Range.<Integer>between(Integer.valueOf(_lower), Integer.valueOf(_upper));
    } else {
      int _globalDensity = this.generator.getGlobalDensity();
      float _globalDeviation = this.generator.getGlobalDeviation();
      float _minus = (1 - _globalDeviation);
      float _multiply = (_globalDensity * _minus);
      int _round = Math.round(_multiply);
      int _globalDensity_1 = this.generator.getGlobalDensity();
      float _globalDeviation_1 = this.generator.getGlobalDeviation();
      float _plus = (1 + _globalDeviation_1);
      float _multiply_1 = (_globalDensity_1 * _plus);
      int _round_1 = Math.round(_multiply_1);
      _xifexpression = Range.<Integer>between(Integer.valueOf(_round), Integer.valueOf(_round_1));
    }
    return _xifexpression;
  }
  
  @NotNull
  @Override
  public Range<Integer> getRangeFor(final EClass eCLass) {
    String _name = eCLass.getName();
    return this.classDepthRange.get(_name);
  }
  
  @NotNull
  @Override
  public Range<Integer> getRangeFor(final EAttribute eAttribute) {
    Range<Integer> _elvis = null;
    EClass _eClass = eAttribute.eClass();
    String _name = _eClass.getName();
    Map<String, Range<Integer>> _get = this.perClassValuesRange.get(_name);
    String _name_1 = eAttribute.getName();
    Range<Integer> _get_1 = _get.get(_name_1);
    if (_get_1 != null) {
      _elvis = _get_1;
    } else {
      _elvis = this.propertiesRange;
    }
    return _elvis;
  }
  
  @NotNull
  @Override
  public Range<Integer> getRangeFor(final EReference eReference) {
    EClass _eClass = eReference.eClass();
    String _name = _eClass.getName();
    Map<String, Range<Integer>> _get = this.perClassReferencesRange.get(_name);
    String _name_1 = eReference.getName();
    return _get.get(_name_1);
  }
  
  @NotNull
  @Override
  public IntegerDistribution getDistributionFor(final EAttribute eAttribute) {
    IntegerDistribution distribution = this.distributions.get(eAttribute);
    boolean _equals = Objects.equal(distribution, null);
    if (_equals) {
      boolean _isMany = eAttribute.isMany();
      boolean _not = (!_isMany);
      if (_not) {
        Range<Integer> _rangeFor = this.getRangeFor(eAttribute);
        Integer _minimum = _rangeFor.getMinimum();
        Range<Integer> _rangeFor_1 = this.getRangeFor(eAttribute);
        Integer _maximum = _rangeFor_1.getMaximum();
        UniformIntegerDistribution _uniformIntegerDistribution = new UniformIntegerDistribution((_minimum).intValue(), (_maximum).intValue());
        distribution = _uniformIntegerDistribution;
        long _nextLong = this.random.nextLong();
        distribution.reseedRandomGenerator(_nextLong);
      } else {
        int _xifexpression = (int) 0;
        int _upperBound = eAttribute.getUpperBound();
        boolean _equals_1 = (_upperBound == EAttribute.UNBOUNDED_MULTIPLICITY);
        if (_equals_1) {
          _xifexpression = Integer.MAX_VALUE;
        } else {
          _xifexpression = eAttribute.getUpperBound();
        }
        final int upperBound = _xifexpression;
        int _xifexpression_1 = (int) 0;
        int _lowerBound = eAttribute.getLowerBound();
        boolean _equals_2 = (upperBound == _lowerBound);
        if (_equals_2) {
          _xifexpression_1 = 0;
        } else {
          _xifexpression_1 = eAttribute.getLowerBound();
        }
        final int lowerBound = _xifexpression_1;
        Range<Integer> _rangeFor_2 = this.getRangeFor(eAttribute);
        Integer _minimum_1 = _rangeFor_2.getMinimum();
        int _min = Math.min((_minimum_1).intValue(), upperBound);
        final int min = Math.max(_min, lowerBound);
        Range<Integer> _rangeFor_3 = this.getRangeFor(eAttribute);
        Integer _maximum_1 = _rangeFor_3.getMaximum();
        final int max = Math.min((_maximum_1).intValue(), upperBound);
        if ((min == max)) {
          return new GenericMetamodelConfig.MonoValuedIntegerDistribution(min);
        } else {
          UniformIntegerDistribution _uniformIntegerDistribution_1 = new UniformIntegerDistribution(min, max);
          distribution = _uniformIntegerDistribution_1;
          long _nextLong_1 = this.random.nextLong();
          distribution.reseedRandomGenerator(_nextLong_1);
        }
      }
      this.distributions.put(eAttribute, distribution);
    }
    return distribution;
  }
  
  @NotNull
  @Override
  public IntegerDistribution getDistributionFor(final EReference eReference) {
    IntegerDistribution distribution = this.distributions.get(eReference);
    boolean _equals = Objects.equal(distribution, null);
    if (_equals) {
      boolean _isMany = eReference.isMany();
      boolean _not = (!_isMany);
      if (_not) {
        Range<Integer> _rangeFor = this.getRangeFor(eReference);
        Integer _minimum = _rangeFor.getMinimum();
        Range<Integer> _rangeFor_1 = this.getRangeFor(eReference);
        Integer _maximum = _rangeFor_1.getMaximum();
        UniformIntegerDistribution _uniformIntegerDistribution = new UniformIntegerDistribution((_minimum).intValue(), (_maximum).intValue());
        distribution = _uniformIntegerDistribution;
        long _nextLong = this.random.nextLong();
        distribution.reseedRandomGenerator(_nextLong);
      } else {
        int _xifexpression = (int) 0;
        int _upperBound = eReference.getUpperBound();
        boolean _equals_1 = (_upperBound == EAttribute.UNBOUNDED_MULTIPLICITY);
        if (_equals_1) {
          _xifexpression = Integer.MAX_VALUE;
        } else {
          _xifexpression = eReference.getUpperBound();
        }
        final int upperBound = _xifexpression;
        int _xifexpression_1 = (int) 0;
        int _lowerBound = eReference.getLowerBound();
        boolean _equals_2 = (upperBound == _lowerBound);
        if (_equals_2) {
          _xifexpression_1 = 0;
        } else {
          _xifexpression_1 = eReference.getLowerBound();
        }
        final int lowerBound = _xifexpression_1;
        Range<Integer> _rangeFor_2 = this.getRangeFor(eReference);
        Integer _minimum_1 = _rangeFor_2.getMinimum();
        int _min = Math.min((_minimum_1).intValue(), upperBound);
        final int min = Math.max(_min, lowerBound);
        Range<Integer> _rangeFor_3 = this.getRangeFor(eReference);
        Integer _maximum_1 = _rangeFor_3.getMaximum();
        final int max = Math.min((_maximum_1).intValue(), upperBound);
        if ((min == max)) {
          GenericMetamodelConfig.MonoValuedIntegerDistribution _monoValuedIntegerDistribution = new GenericMetamodelConfig.MonoValuedIntegerDistribution(min);
          distribution = _monoValuedIntegerDistribution;
        } else {
          UniformIntegerDistribution _uniformIntegerDistribution_1 = new UniformIntegerDistribution(min, max);
          distribution = _uniformIntegerDistribution_1;
          long _nextLong_1 = this.random.nextLong();
          distribution.reseedRandomGenerator(_nextLong_1);
        }
      }
      this.distributions.put(eReference, distribution);
    }
    return distribution;
  }
  
  @NotNull
  @Override
  public IntegerDistribution getDepthDistributionFor(final EClass eClass) {
    IntegerDistribution distribution = this.distributions.get(eClass);
    boolean _equals = Objects.equal(distribution, null);
    if (_equals) {
      Range<Integer> _rangeFor = this.getRangeFor(eClass);
      Integer _minimum = _rangeFor.getMinimum();
      Range<Integer> _rangeFor_1 = this.getRangeFor(eClass);
      Integer _maximum = _rangeFor_1.getMaximum();
      UniformIntegerDistribution _uniformIntegerDistribution = new UniformIntegerDistribution((_minimum).intValue(), (_maximum).intValue());
      distribution = _uniformIntegerDistribution;
      long _nextLong = this.random.nextLong();
      distribution.reseedRandomGenerator(_nextLong);
      this.distributions.put(eClass, distribution);
    }
    return distribution;
  }
  
  @Pure
  public Generator getGenerator() {
    return this.generator;
  }
  
  public void setGenerator(final Generator generator) {
    this.generator = generator;
  }
  
  @Pure
  public Map<String, Range<Integer>> getClassDepthRange() {
    return this.classDepthRange;
  }
  
  protected void setClassDepthRange(final Map<String, Range<Integer>> classDepthRange) {
    this.classDepthRange = classDepthRange;
  }
  
  @Pure
  public Map<String, Map<String, Range<Integer>>> getPerClassReferencesRange() {
    return this.perClassReferencesRange;
  }
  
  protected void setPerClassReferencesRange(final Map<String, Map<String, Range<Integer>>> perClassReferencesRange) {
    this.perClassReferencesRange = perClassReferencesRange;
  }
  
  @Pure
  public Map<String, Map<String, Range<Integer>>> getPerClassValuesRange() {
    return this.perClassValuesRange;
  }
  
  protected void setPerClassValuesRange(final Map<String, Map<String, Range<Integer>>> perClassValuesRange) {
    this.perClassValuesRange = perClassValuesRange;
  }
}
