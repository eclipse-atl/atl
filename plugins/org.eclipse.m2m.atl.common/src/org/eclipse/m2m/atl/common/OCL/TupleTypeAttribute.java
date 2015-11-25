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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.m2m.atl.common.ATL.LocatedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Type Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.TupleTypeAttribute#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.TupleTypeAttribute#getTupleType <em>Tuple Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.TupleTypeAttribute#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getTupleTypeAttribute()
 * @model kind="class"
 * @generated
 */
public class TupleTypeAttribute extends LocatedElement {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected OclType type;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleTypeAttribute() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLPackage.Literals.TUPLE_TYPE_ATTRIBUTE;
	}

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.OCL.OclType#getTupleTypeAttribute <em>Tuple Type Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(OclType)
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getTupleTypeAttribute_Type()
	 * @see org.eclipse.m2m.atl.common.OCL.OclType#getTupleTypeAttribute
	 * @model opposite="tupleTypeAttribute" containment="true" required="true" ordered="false"
	 * @generated
	 */
	public OclType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(OclType newType, NotificationChain msgs) {
		OclType oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.TupleTypeAttribute#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	public void setType(OclType newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, OCLPackage.OCL_TYPE__TUPLE_TYPE_ATTRIBUTE, OclType.class, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, OCLPackage.OCL_TYPE__TUPLE_TYPE_ATTRIBUTE, OclType.class, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE, newType, newType));
	}

	/**
	 * Returns the value of the '<em><b>Tuple Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.OCL.TupleType#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tuple Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tuple Type</em>' container reference.
	 * @see #setTupleType(TupleType)
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getTupleTypeAttribute_TupleType()
	 * @see org.eclipse.m2m.atl.common.OCL.TupleType#getAttributes
	 * @model opposite="attributes" required="true" transient="false" ordered="false"
	 * @generated
	 */
	public TupleType getTupleType() {
		if (eContainerFeatureID() != OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE) return null;
		return (TupleType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTupleType(TupleType newTupleType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTupleType, OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE, msgs);
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.TupleTypeAttribute#getTupleType <em>Tuple Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tuple Type</em>' container reference.
	 * @see #getTupleType()
	 * @generated
	 */
	public void setTupleType(TupleType newTupleType) {
		if (newTupleType != eInternalContainer() || (eContainerFeatureID() != OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE && newTupleType != null)) {
			if (EcoreUtil.isAncestor(this, newTupleType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTupleType != null)
				msgs = ((InternalEObject)newTupleType).eInverseAdd(this, OCLPackage.TUPLE_TYPE__ATTRIBUTES, TupleType.class, msgs);
			msgs = basicSetTupleType(newTupleType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE, newTupleType, newTupleType));
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
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getTupleTypeAttribute_Name()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.TupleTypeAttribute#getName <em>Name</em>}' attribute.
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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.TUPLE_TYPE_ATTRIBUTE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE:
				if (type != null)
					msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE, null, msgs);
				return basicSetType((OclType)otherEnd, msgs);
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTupleType((TupleType)otherEnd, msgs);
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
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE:
				return basicSetType(null, msgs);
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE:
				return basicSetTupleType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE:
				return eInternalContainer().eInverseRemove(this, OCLPackage.TUPLE_TYPE__ATTRIBUTES, TupleType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE:
				return getType();
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE:
				return getTupleType();
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE:
				setType((OclType)newValue);
				return;
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE:
				setTupleType((TupleType)newValue);
				return;
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__NAME:
				setName((String)newValue);
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
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE:
				setType((OclType)null);
				return;
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE:
				setTupleType((TupleType)null);
				return;
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
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
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TYPE:
				return type != null;
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__TUPLE_TYPE:
				return getTupleType() != null;
			case OCLPackage.TUPLE_TYPE_ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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

} // TupleTypeAttribute
