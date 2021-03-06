/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.dmgen.Property#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.Property#getRange <em>Range</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.Property#getDensity <em>Density</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.Property#getVariation <em>Variation</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.Property#getRule <em>Rule</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.Property#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.dmgen.DMGenPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getProperty_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.Property#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Range</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Range</em>' containment reference.
   * @see #setRange(Range)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getProperty_Range()
   * @model containment="true"
   * @generated
   */
  Range getRange();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.Property#getRange <em>Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range</em>' containment reference.
   * @see #getRange()
   * @generated
   */
  void setRange(Range value);

  /**
   * Returns the value of the '<em><b>Density</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Density</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Density</em>' attribute.
   * @see #setDensity(int)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getProperty_Density()
   * @model
   * @generated
   */
  int getDensity();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.Property#getDensity <em>Density</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Density</em>' attribute.
   * @see #getDensity()
   * @generated
   */
  void setDensity(int value);

  /**
   * Returns the value of the '<em><b>Variation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variation</em>' attribute.
   * @see #setVariation(int)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getProperty_Variation()
   * @model
   * @generated
   */
  int getVariation();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.Property#getVariation <em>Variation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variation</em>' attribute.
   * @see #getVariation()
   * @generated
   */
  void setVariation(int value);

  /**
   * Returns the value of the '<em><b>Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' containment reference.
   * @see #setRule(Rule)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getProperty_Rule()
   * @model containment="true"
   * @generated
   */
  Rule getRule();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.Property#getRule <em>Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' containment reference.
   * @see #getRule()
   * @generated
   */
  void setRule(Rule value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getProperty_Condition()
   * @model containment="true"
   * @generated
   */
  Condition getCondition();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.Property#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Condition value);

} // Property
