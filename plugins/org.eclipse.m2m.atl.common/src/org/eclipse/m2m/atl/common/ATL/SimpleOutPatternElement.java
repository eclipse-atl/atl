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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Out Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement#getReverseBindings <em>Reverse Bindings</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getSimpleOutPatternElement()
 * @model kind="class"
 * @generated
 */
public class SimpleOutPatternElement extends OutPatternElement {
	/**
	 * The cached value of the '{@link #getReverseBindings() <em>Reverse Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverseBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpression> reverseBindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleOutPatternElement() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ATLPackage.Literals.SIMPLE_OUT_PATTERN_ELEMENT;
	}

	/**
	 * Returns the value of the '<em><b>Reverse Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.OCL.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse Bindings</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getSimpleOutPatternElement_ReverseBindings()
	 * @model containment="true"
	 * @generated
	 */
	public EList<OclExpression> getReverseBindings() {
		if (reverseBindings == null) {
			reverseBindings = new EObjectContainmentEList<OclExpression>(OclExpression.class, this, ATLPackage.SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS);
		}
		return reverseBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ATLPackage.SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS:
				return ((InternalEList<?>)getReverseBindings()).basicRemove(otherEnd, msgs);
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
			case ATLPackage.SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS:
				return getReverseBindings();
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
			case ATLPackage.SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS:
				getReverseBindings().clear();
				getReverseBindings().addAll((Collection<? extends OclExpression>)newValue);
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
			case ATLPackage.SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS:
				getReverseBindings().clear();
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
			case ATLPackage.SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS:
				return reverseBindings != null && !reverseBindings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // SimpleOutPatternElement
