/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.dmgen.SetRule#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.dmgen.DMGenPackage#getSetRule()
 * @model
 * @generated
 */
public interface SetRule extends NumericalRule
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' attribute list.
   * @see fr.inria.diverse.dmgen.DMGenPackage#getSetRule_Elements()
   * @model unique="false"
   * @generated
   */
  EList<String> getElements();

} // SetRule
