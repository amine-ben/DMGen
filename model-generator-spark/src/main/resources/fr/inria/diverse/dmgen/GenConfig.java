/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.dmgen.GenConfig#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.GenConfig#getPackage <em>Package</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.GenConfig#getHdfsMaster <em>Hdfs Master</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.GenConfig#getDeployMode <em>Deploy Mode</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.GenConfig#getNumberOfNodes <em>Number Of Nodes</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.GenConfig#getHbaseMaster <em>Hbase Master</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.GenConfig#getGenerators <em>Generators</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.dmgen.DMGenPackage#getGenConfig()
 * @model
 * @generated
 */
public interface GenConfig extends EObject
{
  /**
   * Returns the value of the '<em><b>Metamodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel</em>' containment reference.
   * @see #setMetamodel(Metamodel)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getGenConfig_Metamodel()
   * @model containment="true"
   * @generated
   */
  Metamodel getMetamodel();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.GenConfig#getMetamodel <em>Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel</em>' containment reference.
   * @see #getMetamodel()
   * @generated
   */
  void setMetamodel(Metamodel value);

  /**
   * Returns the value of the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' attribute.
   * @see #setPackage(String)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getGenConfig_Package()
   * @model
   * @generated
   */
  String getPackage();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.GenConfig#getPackage <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' attribute.
   * @see #getPackage()
   * @generated
   */
  void setPackage(String value);

  /**
   * Returns the value of the '<em><b>Hdfs Master</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hdfs Master</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hdfs Master</em>' containment reference.
   * @see #setHdfsMaster(URI)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getGenConfig_HdfsMaster()
   * @model containment="true"
   * @generated
   */
  URI getHdfsMaster();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.GenConfig#getHdfsMaster <em>Hdfs Master</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hdfs Master</em>' containment reference.
   * @see #getHdfsMaster()
   * @generated
   */
  void setHdfsMaster(URI value);

  /**
   * Returns the value of the '<em><b>Deploy Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deploy Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deploy Mode</em>' attribute.
   * @see #setDeployMode(String)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getGenConfig_DeployMode()
   * @model
   * @generated
   */
  String getDeployMode();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.GenConfig#getDeployMode <em>Deploy Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deploy Mode</em>' attribute.
   * @see #getDeployMode()
   * @generated
   */
  void setDeployMode(String value);

  /**
   * Returns the value of the '<em><b>Number Of Nodes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Of Nodes</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number Of Nodes</em>' attribute.
   * @see #setNumberOfNodes(String)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getGenConfig_NumberOfNodes()
   * @model
   * @generated
   */
  String getNumberOfNodes();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.GenConfig#getNumberOfNodes <em>Number Of Nodes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number Of Nodes</em>' attribute.
   * @see #getNumberOfNodes()
   * @generated
   */
  void setNumberOfNodes(String value);

  /**
   * Returns the value of the '<em><b>Hbase Master</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hbase Master</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hbase Master</em>' containment reference.
   * @see #setHbaseMaster(URI)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getGenConfig_HbaseMaster()
   * @model containment="true"
   * @generated
   */
  URI getHbaseMaster();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.GenConfig#getHbaseMaster <em>Hbase Master</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hbase Master</em>' containment reference.
   * @see #getHbaseMaster()
   * @generated
   */
  void setHbaseMaster(URI value);

  /**
   * Returns the value of the '<em><b>Generators</b></em>' containment reference list.
   * The list contents are of type {@link fr.inria.diverse.dmgen.Generator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generators</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generators</em>' containment reference list.
   * @see fr.inria.diverse.dmgen.DMGenPackage#getGenConfig_Generators()
   * @model containment="true"
   * @generated
   */
  EList<Generator> getGenerators();

} // GenConfig
