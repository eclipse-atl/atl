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
package org.eclipse.m2m.atl.common.OCL;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.atl.common.ATL.LocatedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.OclModel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.OclModel#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.OclModel#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.OclModel#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getOclModel()
 * @model kind="class"
 * @generated
 */
public class OclModel extends LocatedElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected OclModel metamodel;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<OclModelElement> elements;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EList<OclModel> model;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclModel() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLPackage.Literals.OCL_MODEL;
	}

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
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getOclModel_Name()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.OclModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.OCL_MODEL__NAME, oldName, name));
	}

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.OCL.OclModel#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(OclModel)
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getOclModel_Metamodel()
	 * @see org.eclipse.m2m.atl.common.OCL.OclModel#getModel
	 * @model opposite="model" required="true" ordered="false"
	 * @generated
	 */
	public OclModel getMetamodel() {
		if (metamodel != null && metamodel.eIsProxy()) {
			InternalEObject oldMetamodel = (InternalEObject)metamodel;
			metamodel = (OclModel)eResolveProxy(oldMetamodel);
			if (metamodel != oldMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OCLPackage.OCL_MODEL__METAMODEL, oldMetamodel, metamodel));
			}
		}
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel basicGetMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetamodel(OclModel newMetamodel, NotificationChain msgs) {
		OclModel oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLPackage.OCL_MODEL__METAMODEL, oldMetamodel, newMetamodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.OclModel#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	public void setMetamodel(OclModel newMetamodel) {
		if (newMetamodel != metamodel) {
			NotificationChain msgs = null;
			if (metamodel != null)
				msgs = ((InternalEObject)metamodel).eInverseRemove(this, OCLPackage.OCL_MODEL__MODEL, OclModel.class, msgs);
			if (newMetamodel != null)
				msgs = ((InternalEObject)newMetamodel).eInverseAdd(this, OCLPackage.OCL_MODEL__MODEL, OclModel.class, msgs);
			msgs = basicSetMetamodel(newMetamodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.OCL_MODEL__METAMODEL, newMetamodel, newMetamodel));
	}

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.OCL.OclModelElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.OCL.OclModelElement#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getOclModel_Elements()
	 * @see org.eclipse.m2m.atl.common.OCL.OclModelElement#getModel
	 * @model opposite="model" ordered="false"
	 * @generated
	 */
	public EList<OclModelElement> getElements() {
		if (elements == null) {
			elements = new EObjectWithInverseResolvingEList<OclModelElement>(OclModelElement.class, this, OCLPackage.OCL_MODEL__ELEMENTS, OCLPackage.OCL_MODEL_ELEMENT__MODEL);
		}
		return elements;
	}

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.OCL.OclModel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.OCL.OclModel#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference list.
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getOclModel_Model()
	 * @see org.eclipse.m2m.atl.common.OCL.OclModel#getMetamodel
	 * @model opposite="metamodel" ordered="false"
	 * @generated
	 */
	public EList<OclModel> getModel() {
		if (model == null) {
			model = new EObjectWithInverseResolvingEList<OclModel>(OclModel.class, this, OCLPackage.OCL_MODEL__MODEL, OCLPackage.OCL_MODEL__METAMODEL);
		}
		return model;
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
			case OCLPackage.OCL_MODEL__METAMODEL:
				if (metamodel != null)
					msgs = ((InternalEObject)metamodel).eInverseRemove(this, OCLPackage.OCL_MODEL__MODEL, OclModel.class, msgs);
				return basicSetMetamodel((OclModel)otherEnd, msgs);
			case OCLPackage.OCL_MODEL__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
			case OCLPackage.OCL_MODEL__MODEL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModel()).basicAdd(otherEnd, msgs);
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
			case OCLPackage.OCL_MODEL__METAMODEL:
				return basicSetMetamodel(null, msgs);
			case OCLPackage.OCL_MODEL__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case OCLPackage.OCL_MODEL__MODEL:
				return ((InternalEList<?>)getModel()).basicRemove(otherEnd, msgs);
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
			case OCLPackage.OCL_MODEL__NAME:
				return getName();
			case OCLPackage.OCL_MODEL__METAMODEL:
				if (resolve) return getMetamodel();
				return basicGetMetamodel();
			case OCLPackage.OCL_MODEL__ELEMENTS:
				return getElements();
			case OCLPackage.OCL_MODEL__MODEL:
				return getModel();
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
			case OCLPackage.OCL_MODEL__NAME:
				setName((String)newValue);
				return;
			case OCLPackage.OCL_MODEL__METAMODEL:
				setMetamodel((OclModel)newValue);
				return;
			case OCLPackage.OCL_MODEL__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends OclModelElement>)newValue);
				return;
			case OCLPackage.OCL_MODEL__MODEL:
				getModel().clear();
				getModel().addAll((Collection<? extends OclModel>)newValue);
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
			case OCLPackage.OCL_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OCLPackage.OCL_MODEL__METAMODEL:
				setMetamodel((OclModel)null);
				return;
			case OCLPackage.OCL_MODEL__ELEMENTS:
				getElements().clear();
				return;
			case OCLPackage.OCL_MODEL__MODEL:
				getModel().clear();
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
			case OCLPackage.OCL_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OCLPackage.OCL_MODEL__METAMODEL:
				return metamodel != null;
			case OCLPackage.OCL_MODEL__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case OCLPackage.OCL_MODEL__MODEL:
				return model != null && !model.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // OclModel
