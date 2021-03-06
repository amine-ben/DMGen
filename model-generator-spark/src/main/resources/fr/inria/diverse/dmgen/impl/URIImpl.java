/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import fr.inria.diverse.dmgen.DMGenPackage;
import fr.inria.diverse.dmgen.URI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.dmgen.impl.URIImpl#getScheme <em>Scheme</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.impl.URIImpl#getAuthority <em>Authority</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.impl.URIImpl#getFragments <em>Fragments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class URIImpl extends MinimalEObjectImpl.Container implements URI
{
  /**
   * The default value of the '{@link #getScheme() <em>Scheme</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScheme()
   * @generated
   * @ordered
   */
  protected static final String SCHEME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getScheme() <em>Scheme</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScheme()
   * @generated
   * @ordered
   */
  protected String scheme = SCHEME_EDEFAULT;

  /**
   * The default value of the '{@link #getAuthority() <em>Authority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthority()
   * @generated
   * @ordered
   */
  protected static final String AUTHORITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAuthority() <em>Authority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthority()
   * @generated
   * @ordered
   */
  protected String authority = AUTHORITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getFragments() <em>Fragments</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFragments()
   * @generated
   * @ordered
   */
  protected EList<String> fragments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected URIImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DMGenPackage.Literals.URI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getScheme()
  {
    return scheme;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScheme(String newScheme)
  {
    String oldScheme = scheme;
    scheme = newScheme;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DMGenPackage.URI__SCHEME, oldScheme, scheme));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAuthority()
  {
    return authority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAuthority(String newAuthority)
  {
    String oldAuthority = authority;
    authority = newAuthority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DMGenPackage.URI__AUTHORITY, oldAuthority, authority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getFragments()
  {
    if (fragments == null)
    {
      fragments = new EDataTypeEList<String>(String.class, this, DMGenPackage.URI__FRAGMENTS);
    }
    return fragments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DMGenPackage.URI__SCHEME:
        return getScheme();
      case DMGenPackage.URI__AUTHORITY:
        return getAuthority();
      case DMGenPackage.URI__FRAGMENTS:
        return getFragments();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DMGenPackage.URI__SCHEME:
        setScheme((String)newValue);
        return;
      case DMGenPackage.URI__AUTHORITY:
        setAuthority((String)newValue);
        return;
      case DMGenPackage.URI__FRAGMENTS:
        getFragments().clear();
        getFragments().addAll((Collection<? extends String>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DMGenPackage.URI__SCHEME:
        setScheme(SCHEME_EDEFAULT);
        return;
      case DMGenPackage.URI__AUTHORITY:
        setAuthority(AUTHORITY_EDEFAULT);
        return;
      case DMGenPackage.URI__FRAGMENTS:
        getFragments().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DMGenPackage.URI__SCHEME:
        return SCHEME_EDEFAULT == null ? scheme != null : !SCHEME_EDEFAULT.equals(scheme);
      case DMGenPackage.URI__AUTHORITY:
        return AUTHORITY_EDEFAULT == null ? authority != null : !AUTHORITY_EDEFAULT.equals(authority);
      case DMGenPackage.URI__FRAGMENTS:
        return fragments != null && !fragments.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (scheme: ");
    result.append(scheme);
    result.append(", authority: ");
    result.append(authority);
    result.append(", fragments: ");
    result.append(fragments);
    result.append(')');
    return result.toString();
  }

} //URIImpl
