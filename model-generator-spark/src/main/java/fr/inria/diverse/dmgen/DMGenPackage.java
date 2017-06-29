/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.inria.diverse.dmgen.DMGenFactory
 * @model kind="package"
 * @generated
 */
public interface DMGenPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dMGen";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.inria.fr/diverse/dmgen/DMGen";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dMGen";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DMGenPackage eINSTANCE = fr.inria.diverse.dmgen.impl.DMGenPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.inria.diverse.dmgen.impl.GenConfigImpl <em>Gen Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.inria.diverse.dmgen.impl.GenConfigImpl
   * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getGenConfig()
   * @generated
   */
  int GEN_CONFIG = 0;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CONFIG__METAMODEL = 0;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CONFIG__PACKAGE = 1;

  /**
   * The feature id for the '<em><b>Hdfs Master</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CONFIG__HDFS_MASTER = 2;

  /**
   * The feature id for the '<em><b>Generators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CONFIG__GENERATORS = 3;

  /**
   * The number of structural features of the '<em>Gen Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_CONFIG_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link fr.inria.diverse.dmgen.impl.GeneratorImpl <em>Generator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.inria.diverse.dmgen.impl.GeneratorImpl
   * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getGenerator()
   * @generated
   */
  int GENERATOR = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__NAME = 0;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__NUMBER = 1;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__SIZE = 2;

  /**
   * The feature id for the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__PREFIX = 3;

  /**
   * The feature id for the '<em><b>Global Density</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__GLOBAL_DENSITY = 4;

  /**
   * The feature id for the '<em><b>Global Deviation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__GLOBAL_DEVIATION = 5;

  /**
   * The feature id for the '<em><b>Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR__CLASSES = 6;

  /**
   * The number of structural features of the '<em>Generator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATOR_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link fr.inria.diverse.dmgen.impl.BundleImpl <em>Bundle</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.inria.diverse.dmgen.impl.BundleImpl
   * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getBundle()
   * @generated
   */
  int BUNDLE = 2;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUNDLE__SIZE = 0;

  /**
   * The feature id for the '<em><b>Times</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUNDLE__TIMES = 1;

  /**
   * The number of structural features of the '<em>Bundle</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUNDLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.inria.diverse.dmgen.impl.MetamodelImpl <em>Metamodel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.inria.diverse.dmgen.impl.MetamodelImpl
   * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getMetamodel()
   * @generated
   */
  int METAMODEL = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Uri</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL__URI = 1;

  /**
   * The number of structural features of the '<em>Metamodel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METAMODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.inria.diverse.dmgen.impl.ClazzImpl <em>Clazz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.inria.diverse.dmgen.impl.ClazzImpl
   * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getClazz()
   * @generated
   */
  int CLAZZ = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAZZ__NAME = 0;

  /**
   * The feature id for the '<em><b>Instances</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAZZ__INSTANCES = 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAZZ__PROPERTIES = 2;

  /**
   * The number of structural features of the '<em>Clazz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAZZ_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.inria.diverse.dmgen.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.inria.diverse.dmgen.impl.PropertyImpl
   * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__NAME = 0;

  /**
   * The feature id for the '<em><b>Density</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__DENSITY = 1;

  /**
   * The feature id for the '<em><b>Variation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__VARIATION = 2;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.inria.diverse.dmgen.impl.URIImpl <em>URI</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.inria.diverse.dmgen.impl.URIImpl
   * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getURI()
   * @generated
   */
  int URI = 6;

  /**
   * The feature id for the '<em><b>Scheme</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI__SCHEME = 0;

  /**
   * The feature id for the '<em><b>Authority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI__AUTHORITY = 1;

  /**
   * The feature id for the '<em><b>Fragments</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI__FRAGMENTS = 2;

  /**
   * The number of structural features of the '<em>URI</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int URI_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link fr.inria.diverse.dmgen.GenConfig <em>Gen Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Config</em>'.
   * @see fr.inria.diverse.dmgen.GenConfig
   * @generated
   */
  EClass getGenConfig();

  /**
   * Returns the meta object for the containment reference '{@link fr.inria.diverse.dmgen.GenConfig#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Metamodel</em>'.
   * @see fr.inria.diverse.dmgen.GenConfig#getMetamodel()
   * @see #getGenConfig()
   * @generated
   */
  EReference getGenConfig_Metamodel();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.GenConfig#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see fr.inria.diverse.dmgen.GenConfig#getPackage()
   * @see #getGenConfig()
   * @generated
   */
  EAttribute getGenConfig_Package();

  /**
   * Returns the meta object for the containment reference '{@link fr.inria.diverse.dmgen.GenConfig#getHdfsMaster <em>Hdfs Master</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Hdfs Master</em>'.
   * @see fr.inria.diverse.dmgen.GenConfig#getHdfsMaster()
   * @see #getGenConfig()
   * @generated
   */
  EReference getGenConfig_HdfsMaster();

  /**
   * Returns the meta object for the containment reference list '{@link fr.inria.diverse.dmgen.GenConfig#getGenerators <em>Generators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generators</em>'.
   * @see fr.inria.diverse.dmgen.GenConfig#getGenerators()
   * @see #getGenConfig()
   * @generated
   */
  EReference getGenConfig_Generators();

  /**
   * Returns the meta object for class '{@link fr.inria.diverse.dmgen.Generator <em>Generator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generator</em>'.
   * @see fr.inria.diverse.dmgen.Generator
   * @generated
   */
  EClass getGenerator();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Generator#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.inria.diverse.dmgen.Generator#getName()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_Name();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Generator#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see fr.inria.diverse.dmgen.Generator#getNumber()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_Number();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Generator#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see fr.inria.diverse.dmgen.Generator#getSize()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_Size();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Generator#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prefix</em>'.
   * @see fr.inria.diverse.dmgen.Generator#getPrefix()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_Prefix();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Generator#getGlobalDensity <em>Global Density</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Global Density</em>'.
   * @see fr.inria.diverse.dmgen.Generator#getGlobalDensity()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_GlobalDensity();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Generator#getGlobalDeviation <em>Global Deviation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Global Deviation</em>'.
   * @see fr.inria.diverse.dmgen.Generator#getGlobalDeviation()
   * @see #getGenerator()
   * @generated
   */
  EAttribute getGenerator_GlobalDeviation();

  /**
   * Returns the meta object for the containment reference list '{@link fr.inria.diverse.dmgen.Generator#getClasses <em>Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classes</em>'.
   * @see fr.inria.diverse.dmgen.Generator#getClasses()
   * @see #getGenerator()
   * @generated
   */
  EReference getGenerator_Classes();

  /**
   * Returns the meta object for class '{@link fr.inria.diverse.dmgen.Bundle <em>Bundle</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bundle</em>'.
   * @see fr.inria.diverse.dmgen.Bundle
   * @generated
   */
  EClass getBundle();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Bundle#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see fr.inria.diverse.dmgen.Bundle#getSize()
   * @see #getBundle()
   * @generated
   */
  EAttribute getBundle_Size();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Bundle#getTimes <em>Times</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Times</em>'.
   * @see fr.inria.diverse.dmgen.Bundle#getTimes()
   * @see #getBundle()
   * @generated
   */
  EAttribute getBundle_Times();

  /**
   * Returns the meta object for class '{@link fr.inria.diverse.dmgen.Metamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metamodel</em>'.
   * @see fr.inria.diverse.dmgen.Metamodel
   * @generated
   */
  EClass getMetamodel();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Metamodel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.inria.diverse.dmgen.Metamodel#getName()
   * @see #getMetamodel()
   * @generated
   */
  EAttribute getMetamodel_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.inria.diverse.dmgen.Metamodel#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Uri</em>'.
   * @see fr.inria.diverse.dmgen.Metamodel#getUri()
   * @see #getMetamodel()
   * @generated
   */
  EReference getMetamodel_Uri();

  /**
   * Returns the meta object for class '{@link fr.inria.diverse.dmgen.Clazz <em>Clazz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clazz</em>'.
   * @see fr.inria.diverse.dmgen.Clazz
   * @generated
   */
  EClass getClazz();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Clazz#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.inria.diverse.dmgen.Clazz#getName()
   * @see #getClazz()
   * @generated
   */
  EAttribute getClazz_Name();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Clazz#getInstances <em>Instances</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Instances</em>'.
   * @see fr.inria.diverse.dmgen.Clazz#getInstances()
   * @see #getClazz()
   * @generated
   */
  EAttribute getClazz_Instances();

  /**
   * Returns the meta object for the containment reference list '{@link fr.inria.diverse.dmgen.Clazz#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see fr.inria.diverse.dmgen.Clazz#getProperties()
   * @see #getClazz()
   * @generated
   */
  EReference getClazz_Properties();

  /**
   * Returns the meta object for class '{@link fr.inria.diverse.dmgen.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see fr.inria.diverse.dmgen.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Property#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.inria.diverse.dmgen.Property#getName()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Name();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Property#getDensity <em>Density</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Density</em>'.
   * @see fr.inria.diverse.dmgen.Property#getDensity()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Density();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.Property#getVariation <em>Variation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variation</em>'.
   * @see fr.inria.diverse.dmgen.Property#getVariation()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Variation();

  /**
   * Returns the meta object for class '{@link fr.inria.diverse.dmgen.URI <em>URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>URI</em>'.
   * @see fr.inria.diverse.dmgen.URI
   * @generated
   */
  EClass getURI();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.URI#getScheme <em>Scheme</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scheme</em>'.
   * @see fr.inria.diverse.dmgen.URI#getScheme()
   * @see #getURI()
   * @generated
   */
  EAttribute getURI_Scheme();

  /**
   * Returns the meta object for the attribute '{@link fr.inria.diverse.dmgen.URI#getAuthority <em>Authority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Authority</em>'.
   * @see fr.inria.diverse.dmgen.URI#getAuthority()
   * @see #getURI()
   * @generated
   */
  EAttribute getURI_Authority();

  /**
   * Returns the meta object for the attribute list '{@link fr.inria.diverse.dmgen.URI#getFragments <em>Fragments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Fragments</em>'.
   * @see fr.inria.diverse.dmgen.URI#getFragments()
   * @see #getURI()
   * @generated
   */
  EAttribute getURI_Fragments();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DMGenFactory getDMGenFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link fr.inria.diverse.dmgen.impl.GenConfigImpl <em>Gen Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.inria.diverse.dmgen.impl.GenConfigImpl
     * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getGenConfig()
     * @generated
     */
    EClass GEN_CONFIG = eINSTANCE.getGenConfig();

    /**
     * The meta object literal for the '<em><b>Metamodel</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GEN_CONFIG__METAMODEL = eINSTANCE.getGenConfig_Metamodel();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GEN_CONFIG__PACKAGE = eINSTANCE.getGenConfig_Package();

    /**
     * The meta object literal for the '<em><b>Hdfs Master</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GEN_CONFIG__HDFS_MASTER = eINSTANCE.getGenConfig_HdfsMaster();

    /**
     * The meta object literal for the '<em><b>Generators</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GEN_CONFIG__GENERATORS = eINSTANCE.getGenConfig_Generators();

    /**
     * The meta object literal for the '{@link fr.inria.diverse.dmgen.impl.GeneratorImpl <em>Generator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.inria.diverse.dmgen.impl.GeneratorImpl
     * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getGenerator()
     * @generated
     */
    EClass GENERATOR = eINSTANCE.getGenerator();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__NAME = eINSTANCE.getGenerator_Name();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__NUMBER = eINSTANCE.getGenerator_Number();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__SIZE = eINSTANCE.getGenerator_Size();

    /**
     * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__PREFIX = eINSTANCE.getGenerator_Prefix();

    /**
     * The meta object literal for the '<em><b>Global Density</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__GLOBAL_DENSITY = eINSTANCE.getGenerator_GlobalDensity();

    /**
     * The meta object literal for the '<em><b>Global Deviation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATOR__GLOBAL_DEVIATION = eINSTANCE.getGenerator_GlobalDeviation();

    /**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GENERATOR__CLASSES = eINSTANCE.getGenerator_Classes();

    /**
     * The meta object literal for the '{@link fr.inria.diverse.dmgen.impl.BundleImpl <em>Bundle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.inria.diverse.dmgen.impl.BundleImpl
     * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getBundle()
     * @generated
     */
    EClass BUNDLE = eINSTANCE.getBundle();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUNDLE__SIZE = eINSTANCE.getBundle_Size();

    /**
     * The meta object literal for the '<em><b>Times</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUNDLE__TIMES = eINSTANCE.getBundle_Times();

    /**
     * The meta object literal for the '{@link fr.inria.diverse.dmgen.impl.MetamodelImpl <em>Metamodel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.inria.diverse.dmgen.impl.MetamodelImpl
     * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getMetamodel()
     * @generated
     */
    EClass METAMODEL = eINSTANCE.getMetamodel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METAMODEL__NAME = eINSTANCE.getMetamodel_Name();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METAMODEL__URI = eINSTANCE.getMetamodel_Uri();

    /**
     * The meta object literal for the '{@link fr.inria.diverse.dmgen.impl.ClazzImpl <em>Clazz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.inria.diverse.dmgen.impl.ClazzImpl
     * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getClazz()
     * @generated
     */
    EClass CLAZZ = eINSTANCE.getClazz();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAZZ__NAME = eINSTANCE.getClazz_Name();

    /**
     * The meta object literal for the '<em><b>Instances</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAZZ__INSTANCES = eINSTANCE.getClazz_Instances();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAZZ__PROPERTIES = eINSTANCE.getClazz_Properties();

    /**
     * The meta object literal for the '{@link fr.inria.diverse.dmgen.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.inria.diverse.dmgen.impl.PropertyImpl
     * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

    /**
     * The meta object literal for the '<em><b>Density</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__DENSITY = eINSTANCE.getProperty_Density();

    /**
     * The meta object literal for the '<em><b>Variation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__VARIATION = eINSTANCE.getProperty_Variation();

    /**
     * The meta object literal for the '{@link fr.inria.diverse.dmgen.impl.URIImpl <em>URI</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.inria.diverse.dmgen.impl.URIImpl
     * @see fr.inria.diverse.dmgen.impl.DMGenPackageImpl#getURI()
     * @generated
     */
    EClass URI = eINSTANCE.getURI();

    /**
     * The meta object literal for the '<em><b>Scheme</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute URI__SCHEME = eINSTANCE.getURI_Scheme();

    /**
     * The meta object literal for the '<em><b>Authority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute URI__AUTHORITY = eINSTANCE.getURI_Authority();

    /**
     * The meta object literal for the '<em><b>Fragments</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute URI__FRAGMENTS = eINSTANCE.getURI_Fragments();

  }

} //DMGenPackage
