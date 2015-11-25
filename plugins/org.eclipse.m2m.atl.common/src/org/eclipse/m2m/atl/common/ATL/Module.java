/**
 * Copyright (c) 2008, 2012, 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 */
package org.eclipse.m2m.atl.common.ATL;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.atl.common.OCL.OclModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.Module#isIsRefining <em>Is Refining</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.Module#getInModels <em>In Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.Module#getOutModels <em>Out Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.Module#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModule()
 * @model kind="class"
 * @generated
 */
public class Module extends Unit {
	/**
	 * The default value of the '{@link #isIsRefining() <em>Is Refining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRefining()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REFINING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsRefining() <em>Is Refining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRefining()
	 * @generated
	 * @ordered
	 */
	protected boolean isRefining = IS_REFINING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInModels() <em>In Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModels()
	 * @generated
	 * @ordered
	 */
	protected EList<OclModel> inModels;

	/**
	 * The cached value of the '{@link #getOutModels() <em>Out Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutModels()
	 * @generated
	 * @ordered
	 */
	protected EList<OclModel> outModels;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModuleElement> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Module() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ATLPackage.Literals.MODULE;
	}

	/**
	 * Returns the value of the '<em><b>Is Refining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Refining</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Refining</em>' attribute.
	 * @see #setIsRefining(boolean)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModule_IsRefining()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	public boolean isIsRefining() {
		return isRefining;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.Module#isIsRefining <em>Is Refining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Refining</em>' attribute.
	 * @see #isIsRefining()
	 * @generated
	 */
	public void setIsRefining(boolean newIsRefining) {
		boolean oldIsRefining = isRefining;
		isRefining = newIsRefining;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.MODULE__IS_REFINING, oldIsRefining, isRefining));
	}

	/**
	 * Returns the value of the '<em><b>In Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.OCL.OclModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Models</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModule_InModels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	public EList<OclModel> getInModels() {
		if (inModels == null) {
			inModels = new EObjectContainmentEList<OclModel>(OclModel.class, this, ATLPackage.MODULE__IN_MODELS);
		}
		return inModels;
	}

	/**
	 * Returns the value of the '<em><b>Out Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.OCL.OclModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Models</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModule_OutModels()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public EList<OclModel> getOutModels() {
		if (outModels == null) {
			outModels = new EObjectContainmentEList<OclModel>(OclModel.class, this, ATLPackage.MODULE__OUT_MODELS);
		}
		return outModels;
	}

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.ATL.ModuleElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.ModuleElement#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModule_Elements()
	 * @see org.eclipse.m2m.atl.common.ATL.ModuleElement#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	public EList<ModuleElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<ModuleElement>(ModuleElement.class, this, ATLPackage.MODULE__ELEMENTS, ATLPackage.MODULE_ELEMENT__MODULE);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ATLPackage.MODULE__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ATLPackage.MODULE__IN_MODELS:
				return ((InternalEList<?>)getInModels()).basicRemove(otherEnd, msgs);
			case ATLPackage.MODULE__OUT_MODELS:
				return ((InternalEList<?>)getOutModels()).basicRemove(otherEnd, msgs);
			case ATLPackage.MODULE__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ATLPackage.MODULE__IS_REFINING:
				return isIsRefining();
			case ATLPackage.MODULE__IN_MODELS:
				return getInModels();
			case ATLPackage.MODULE__OUT_MODELS:
				return getOutModels();
			case ATLPackage.MODULE__ELEMENTS:
				return getElements();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ATLPackage.MODULE__IS_REFINING:
				setIsRefining((Boolean)newValue);
				return;
			case ATLPackage.MODULE__IN_MODELS:
				getInModels().clear();
				getInModels().addAll((Collection<? extends OclModel>)newValue);
				return;
			case ATLPackage.MODULE__OUT_MODELS:
				getOutModels().clear();
				getOutModels().addAll((Collection<? extends OclModel>)newValue);
				return;
			case ATLPackage.MODULE__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ModuleElement>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ATLPackage.MODULE__IS_REFINING:
				setIsRefining(IS_REFINING_EDEFAULT);
				return;
			case ATLPackage.MODULE__IN_MODELS:
				getInModels().clear();
				return;
			case ATLPackage.MODULE__OUT_MODELS:
				getOutModels().clear();
				return;
			case ATLPackage.MODULE__ELEMENTS:
				getElements().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ATLPackage.MODULE__IS_REFINING:
				return isRefining != IS_REFINING_EDEFAULT;
			case ATLPackage.MODULE__IN_MODELS:
				return inModels != null && !inModels.isEmpty();
			case ATLPackage.MODULE__OUT_MODELS:
				return outModels != null && !outModels.isEmpty();
			case ATLPackage.MODULE__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isRefining: ");
		result.append(isRefining);
		result.append(')');
		return result.toString();
	}

} // Module
