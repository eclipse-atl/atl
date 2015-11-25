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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.BooleanExp#isBooleanSymbol <em>Boolean Symbol</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getBooleanExp()
 * @model kind="class"
 * @generated
 */
public class BooleanExp extends PrimitiveExp {
	/**
	 * The default value of the '{@link #isBooleanSymbol() <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOLEAN_SYMBOL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBooleanSymbol() <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanSymbol()
	 * @generated
	 * @ordered
	 */
	protected boolean booleanSymbol = BOOLEAN_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanExp() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLPackage.Literals.BOOLEAN_EXP;
	}

	/**
	 * Returns the value of the '<em><b>Boolean Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #setBooleanSymbol(boolean)
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getBooleanExp_BooleanSymbol()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	public boolean isBooleanSymbol() {
		return booleanSymbol;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.BooleanExp#isBooleanSymbol <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #isBooleanSymbol()
	 * @generated
	 */
	public void setBooleanSymbol(boolean newBooleanSymbol) {
		boolean oldBooleanSymbol = booleanSymbol;
		booleanSymbol = newBooleanSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.BOOLEAN_EXP__BOOLEAN_SYMBOL, oldBooleanSymbol, booleanSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OCLPackage.BOOLEAN_EXP__BOOLEAN_SYMBOL:
				return isBooleanSymbol();
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
			case OCLPackage.BOOLEAN_EXP__BOOLEAN_SYMBOL:
				setBooleanSymbol((Boolean)newValue);
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
			case OCLPackage.BOOLEAN_EXP__BOOLEAN_SYMBOL:
				setBooleanSymbol(BOOLEAN_SYMBOL_EDEFAULT);
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
			case OCLPackage.BOOLEAN_EXP__BOOLEAN_SYMBOL:
				return booleanSymbol != BOOLEAN_SYMBOL_EDEFAULT;
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
		result.append(" (booleanSymbol: ");
		result.append(booleanSymbol);
		result.append(')');
		return result.toString();
	}

} // BooleanExp
