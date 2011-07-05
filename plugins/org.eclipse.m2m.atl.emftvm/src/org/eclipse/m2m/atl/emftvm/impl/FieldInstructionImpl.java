/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.FieldInstruction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.FieldInstructionImpl#getFieldname <em>Fieldname</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FieldInstructionImpl extends InstructionImpl implements FieldInstruction {
	/**
	 * The default value of the '{@link #getFieldname() <em>Fieldname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldname()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELDNAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFieldname() <em>Fieldname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldname()
	 * @generated
	 * @ordered
	 */
	protected String fieldname = FIELDNAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link FieldInstructionImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FieldInstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link EClass} that correspond to this metaclass.
	 * @return the {@link EClass} that correspond to this metaclass.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.FIELD_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldname() {
		return fieldname;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldname(String newFieldname) {
		String oldFieldname = fieldname;
		fieldname = newFieldname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.FIELD_INSTRUCTION__FIELDNAME, oldFieldname, fieldname));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmftvmPackage.FIELD_INSTRUCTION__FIELDNAME:
				return getFieldname();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.FIELD_INSTRUCTION__FIELDNAME:
				setFieldname((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmftvmPackage.FIELD_INSTRUCTION__FIELDNAME:
				setFieldname(FIELDNAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmftvmPackage.FIELD_INSTRUCTION__FIELDNAME:
				return FIELDNAME_EDEFAULT == null ? fieldname != null : !FIELDNAME_EDEFAULT.equals(fieldname);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fieldname: ");
		result.append(fieldname);
		result.append(')');
		return result.toString();
	}

} //FieldInstructionImpl
