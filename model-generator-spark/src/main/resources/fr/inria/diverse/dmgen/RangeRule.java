/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.dmgen.RangeRule#isIsLowerExclu <em>Is Lower Exclu</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.RangeRule#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.RangeRule#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.RangeRule#isIsUpperExclu <em>Is Upper Exclu</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.dmgen.DMGenPackage#getRangeRule()
 * @model
 * @generated
 */
public interface RangeRule extends NumericalRule
{
  /**
   * Returns the value of the '<em><b>Is Lower Exclu</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Lower Exclu</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Lower Exclu</em>' attribute.
   * @see #setIsLowerExclu(boolean)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getRangeRule_IsLowerExclu()
   * @model
   * @generated
   */
  boolean isIsLowerExclu();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.RangeRule#isIsLowerExclu <em>Is Lower Exclu</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Lower Exclu</em>' attribute.
   * @see #isIsLowerExclu()
   * @generated
   */
  void setIsLowerExclu(boolean value);

  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #setLowerBound(String)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getRangeRule_LowerBound()
   * @model
   * @generated
   */
  String getLowerBound();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.RangeRule#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(String value);

  /**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #setUpperBound(String)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getRangeRule_UpperBound()
   * @model
   * @generated
   */
  String getUpperBound();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.RangeRule#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #getUpperBound()
   * @generated
   */
  void setUpperBound(String value);

  /**
   * Returns the value of the '<em><b>Is Upper Exclu</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Upper Exclu</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Upper Exclu</em>' attribute.
   * @see #setIsUpperExclu(boolean)
   * @see fr.inria.diverse.dmgen.DMGenPackage#getRangeRule_IsUpperExclu()
   * @model
   * @generated
   */
  boolean isIsUpperExclu();

  /**
   * Sets the value of the '{@link fr.inria.diverse.dmgen.RangeRule#isIsUpperExclu <em>Is Upper Exclu</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Upper Exclu</em>' attribute.
   * @see #isIsUpperExclu()
   * @generated
   */
  void setIsUpperExclu(boolean value);

} // RangeRule
