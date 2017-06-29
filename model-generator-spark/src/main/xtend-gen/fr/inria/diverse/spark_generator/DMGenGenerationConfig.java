package fr.inria.diverse.spark_generator;

import fr.inria.diverse.dmgen.Generator;
import fr.inria.diverse.spark_generator.DMGenConfiguration;
import fr.inria.diverse.spark_generator.GenericMetamodelConfig;
import fr.inria.diverse.spark_generator.specimen.ISpecimenConfiguration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.Range;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author <a href="mailto:abel.gomez-llana@inria.fr">Abel Gomez</a>
 * @author <A href="mailto:amine.benelallam@inria.fr">Amine Benelallam</a>
 */
@SuppressWarnings("all")
public class DMGenGenerationConfig extends GenericMetamodelConfig implements DMGenConfiguration {
  @Accessors
  protected Generator dmgenModule;
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
  protected Map<String, Map<String, Range<Integer>>> perClassPropertiesRange;
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
  protected Map<String, Map<String, Range<Integer>>> perClassReferencesRange;
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
  protected Map<String, Map<String, Range<Integer>>> perClassValuesRange;
  
  @Accessors
  protected float globalVariation;
  
  @Accessors
  protected int globalDensity;
  
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
  public DMGenGenerationConfig(final Resource metamodelResource, final Resource dmgen, final Range<Integer> elementsRange, final long seed) {
    this(metamodelResource, elementsRange, seed);
    HashMap<String, Map<String, Range<Integer>>> _hashMap = new HashMap<String, Map<String, Range<Integer>>>();
    this.perClassPropertiesRange = _hashMap;
    HashMap<String, Map<String, Range<Integer>>> _hashMap_1 = new HashMap<String, Map<String, Range<Integer>>>();
    this.perClassValuesRange = _hashMap_1;
    HashMap<String, Map<String, Range<Integer>>> _hashMap_2 = new HashMap<String, Map<String, Range<Integer>>>();
    this.perClassReferencesRange = _hashMap_2;
    this.initConfig();
  }
  
  public Object initConfig() {
    return null;
  }
  
  @Override
  public Range<Integer> getRangeFor(final EClass eCLass) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Range<Integer> getRangeFor(final EAttribute eAttribute) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Range<Integer> getRangeFor(final EReference eReference) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IntegerDistribution getDistributionFor(final EAttribute eAttribute) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IntegerDistribution getDistributionFor(final EReference eReference) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IntegerDistribution getDepthDistributionFor(final EClass eClass) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public Generator getDmgenModule() {
    return this.dmgenModule;
  }
  
  public void setDmgenModule(final Generator dmgenModule) {
    this.dmgenModule = dmgenModule;
  }
  
  @Pure
  public Map<String, Map<String, Range<Integer>>> getPerClassPropertiesRange() {
    return this.perClassPropertiesRange;
  }
  
  protected void setPerClassPropertiesRange(final Map<String, Map<String, Range<Integer>>> perClassPropertiesRange) {
    this.perClassPropertiesRange = perClassPropertiesRange;
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
  
  @Pure
  public float getGlobalVariation() {
    return this.globalVariation;
  }
  
  public void setGlobalVariation(final float globalVariation) {
    this.globalVariation = globalVariation;
  }
  
  @Pure
  public int getGlobalDensity() {
    return this.globalDensity;
  }
  
  public void setGlobalDensity(final int globalDensity) {
    this.globalDensity = globalDensity;
  }
}
