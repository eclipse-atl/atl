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
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.atl.common.OCL.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Called Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.CalledRule#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.CalledRule#isIsEntrypoint <em>Is Entrypoint</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.CalledRule#isIsEndpoint <em>Is Endpoint</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getCalledRule()
 * @model kind="class"
 * @generated
 */
public class CalledRule extends Rule {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The default value of the '{@link #isIsEntrypoint() <em>Is Entrypoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEntrypoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENTRYPOINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEntrypoint() <em>Is Entrypoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEntrypoint()
	 * @generated
	 * @ordered
	 */
	protected boolean isEntrypoint = IS_ENTRYPOINT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEndpoint() <em>Is Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEndpoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENDPOINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEndpoint() <em>Is Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEndpoint()
	 * @generated
	 * @ordered
	 */
	protected boolean isEndpoint = IS_ENDPOINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CalledRule() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ATLPackage.Literals.CALLED_RULE;
	}

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.OCL.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getCalledRule_Parameters()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, ATLPackage.CALLED_RULE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * Returns the value of the '<em><b>Is Entrypoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Entrypoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Entrypoint</em>' attribute.
	 * @see #setIsEntrypoint(boolean)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getCalledRule_IsEntrypoint()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	public boolean isIsEntrypoint() {
		return isEntrypoint;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.CalledRule#isIsEntrypoint <em>Is Entrypoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Entrypoint</em>' attribute.
	 * @see #isIsEntrypoint()
	 * @generated
	 */
	public void setIsEntrypoint(boolean newIsEntrypoint) {
		boolean oldIsEntrypoint = isEntrypoint;
		isEntrypoint = newIsEntrypoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.CALLED_RULE__IS_ENTRYPOINT, oldIsEntrypoint, isEntrypoint));
	}

	/**
	 * Returns the value of the '<em><b>Is Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Endpoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Endpoint</em>' attribute.
	 * @see #setIsEndpoint(boolean)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getCalledRule_IsEndpoint()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	public boolean isIsEndpoint() {
		return isEndpoint;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.CalledRule#isIsEndpoint <em>Is Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Endpoint</em>' attribute.
	 * @see #isIsEndpoint()
	 * @generated
	 */
	public void setIsEndpoint(boolean newIsEndpoint) {
		boolean oldIsEndpoint = isEndpoint;
		isEndpoint = newIsEndpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.CALLED_RULE__IS_ENDPOINT, oldIsEndpoint, isEndpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ATLPackage.CALLED_RULE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case ATLPackage.CALLED_RULE__PARAMETERS:
				return getParameters();
			case ATLPackage.CALLED_RULE__IS_ENTRYPOINT:
				return isIsEntrypoint();
			case ATLPackage.CALLED_RULE__IS_ENDPOINT:
				return isIsEndpoint();
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
			case ATLPackage.CALLED_RULE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case ATLPackage.CALLED_RULE__IS_ENTRYPOINT:
				setIsEntrypoint((Boolean)newValue);
				return;
			case ATLPackage.CALLED_RULE__IS_ENDPOINT:
				setIsEndpoint((Boolean)newValue);
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
			case ATLPackage.CALLED_RULE__PARAMETERS:
				getParameters().clear();
				return;
			case ATLPackage.CALLED_RULE__IS_ENTRYPOINT:
				setIsEntrypoint(IS_ENTRYPOINT_EDEFAULT);
				return;
			case ATLPackage.CALLED_RULE__IS_ENDPOINT:
				setIsEndpoint(IS_ENDPOINT_EDEFAULT);
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
			case ATLPackage.CALLED_RULE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case ATLPackage.CALLED_RULE__IS_ENTRYPOINT:
				return isEntrypoint != IS_ENTRYPOINT_EDEFAULT;
			case ATLPackage.CALLED_RULE__IS_ENDPOINT:
				return isEndpoint != IS_ENDPOINT_EDEFAULT;
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
		result.append(" (isEntrypoint: ");
		result.append(isEntrypoint);
		result.append(", isEndpoint: ");
		result.append(isEndpoint);
		result.append(')');
		return result.toString();
	}

} // CalledRule
