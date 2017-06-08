/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen.dMGen.impl;

import fr.inria.diverse.dmgen.dMGen.DMGenPackage;
import fr.inria.diverse.dmgen.dMGen.GenConfig;
import fr.inria.diverse.dmgen.dMGen.Generator;
import fr.inria.diverse.dmgen.dMGen.Metamodel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.dmgen.dMGen.impl.GenConfigImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.dMGen.impl.GenConfigImpl#getGlobalDensity <em>Global Density</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.dMGen.impl.GenConfigImpl#getGlobalVariation <em>Global Variation</em>}</li>
 *   <li>{@link fr.inria.diverse.dmgen.dMGen.impl.GenConfigImpl#getGenerators <em>Generators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenConfigImpl extends MinimalEObjectImpl.Container implements GenConfig
{
  /**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected Metamodel metamodel;

  /**
   * The default value of the '{@link #getGlobalDensity() <em>Global Density</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalDensity()
   * @generated
   * @ordered
   */
  protected static final int GLOBAL_DENSITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getGlobalDensity() <em>Global Density</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalDensity()
   * @generated
   * @ordered
   */
  protected int globalDensity = GLOBAL_DENSITY_EDEFAULT;

  /**
   * The default value of the '{@link #getGlobalVariation() <em>Global Variation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalVariation()
   * @generated
   * @ordered
   */
  protected static final float GLOBAL_VARIATION_EDEFAULT = 0.0F;

  /**
   * The cached value of the '{@link #getGlobalVariation() <em>Global Variation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalVariation()
   * @generated
   * @ordered
   */
  protected float globalVariation = GLOBAL_VARIATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getGenerators() <em>Generators</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerators()
   * @generated
   * @ordered
   */
  protected EList<Generator> generators;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GenConfigImpl()
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
    return DMGenPackage.Literals.GEN_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Metamodel getMetamodel()
  {
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMetamodel(Metamodel newMetamodel, NotificationChain msgs)
  {
    Metamodel oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMGenPackage.GEN_CONFIG__METAMODEL, oldMetamodel, newMetamodel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodel(Metamodel newMetamodel)
  {
    if (newMetamodel != metamodel)
    {
      NotificationChain msgs = null;
      if (metamodel != null)
        msgs = ((InternalEObject)metamodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMGenPackage.GEN_CONFIG__METAMODEL, null, msgs);
      if (newMetamodel != null)
        msgs = ((InternalEObject)newMetamodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMGenPackage.GEN_CONFIG__METAMODEL, null, msgs);
      msgs = basicSetMetamodel(newMetamodel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DMGenPackage.GEN_CONFIG__METAMODEL, newMetamodel, newMetamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getGlobalDensity()
  {
    return globalDensity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobalDensity(int newGlobalDensity)
  {
    int oldGlobalDensity = globalDensity;
    globalDensity = newGlobalDensity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DMGenPackage.GEN_CONFIG__GLOBAL_DENSITY, oldGlobalDensity, globalDensity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public float getGlobalVariation()
  {
    return globalVariation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobalVariation(float newGlobalVariation)
  {
    float oldGlobalVariation = globalVariation;
    globalVariation = newGlobalVariation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DMGenPackage.GEN_CONFIG__GLOBAL_VARIATION, oldGlobalVariation, globalVariation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Generator> getGenerators()
  {
    if (generators == null)
    {
      generators = new EObjectContainmentEList<Generator>(Generator.class, this, DMGenPackage.GEN_CONFIG__GENERATORS);
    }
    return generators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DMGenPackage.GEN_CONFIG__METAMODEL:
        return basicSetMetamodel(null, msgs);
      case DMGenPackage.GEN_CONFIG__GENERATORS:
        return ((InternalEList<?>)getGenerators()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case DMGenPackage.GEN_CONFIG__METAMODEL:
        return getMetamodel();
      case DMGenPackage.GEN_CONFIG__GLOBAL_DENSITY:
        return getGlobalDensity();
      case DMGenPackage.GEN_CONFIG__GLOBAL_VARIATION:
        return getGlobalVariation();
      case DMGenPackage.GEN_CONFIG__GENERATORS:
        return getGenerators();
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
      case DMGenPackage.GEN_CONFIG__METAMODEL:
        setMetamodel((Metamodel)newValue);
        return;
      case DMGenPackage.GEN_CONFIG__GLOBAL_DENSITY:
        setGlobalDensity((Integer)newValue);
        return;
      case DMGenPackage.GEN_CONFIG__GLOBAL_VARIATION:
        setGlobalVariation((Float)newValue);
        return;
      case DMGenPackage.GEN_CONFIG__GENERATORS:
        getGenerators().clear();
        getGenerators().addAll((Collection<? extends Generator>)newValue);
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
      case DMGenPackage.GEN_CONFIG__METAMODEL:
        setMetamodel((Metamodel)null);
        return;
      case DMGenPackage.GEN_CONFIG__GLOBAL_DENSITY:
        setGlobalDensity(GLOBAL_DENSITY_EDEFAULT);
        return;
      case DMGenPackage.GEN_CONFIG__GLOBAL_VARIATION:
        setGlobalVariation(GLOBAL_VARIATION_EDEFAULT);
        return;
      case DMGenPackage.GEN_CONFIG__GENERATORS:
        getGenerators().clear();
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
      case DMGenPackage.GEN_CONFIG__METAMODEL:
        return metamodel != null;
      case DMGenPackage.GEN_CONFIG__GLOBAL_DENSITY:
        return globalDensity != GLOBAL_DENSITY_EDEFAULT;
      case DMGenPackage.GEN_CONFIG__GLOBAL_VARIATION:
        return globalVariation != GLOBAL_VARIATION_EDEFAULT;
      case DMGenPackage.GEN_CONFIG__GENERATORS:
        return generators != null && !generators.isEmpty();
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
    result.append(" (globalDensity: ");
    result.append(globalDensity);
    result.append(", globalVariation: ");
    result.append(globalVariation);
    result.append(')');
    return result.toString();
  }

} //GenConfigImpl
