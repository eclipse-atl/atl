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


import java.lang.reflect.Method;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke Operation Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InvokeOperationInstructionImpl#getOpname <em>Opname</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InvokeOperationInstructionImpl extends InvokeInstructionImpl implements InvokeOperationInstruction {
	/**
	 * The default value of the '{@link #getOpname() <em>Opname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpname()
	 * @generated
	 * @ordered
	 */
	protected static final String OPNAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOpname() <em>Opname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpname()
	 * @generated
	 * @ordered
	 */
	protected String opname = OPNAME_EDEFAULT;

	private Method nativeMethod;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link InvokeOperationInstructionImpl}.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected InvokeOperationInstructionImpl() {
		super();
		stackConsumption = 1;
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
		return EmftvmPackage.Literals.INVOKE_OPERATION_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOpname() {
		return opname;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpname(String newOpname) {
		String oldOpname = opname;
		opname = newOpname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.INVOKE_OPERATION_INSTRUCTION__OPNAME, oldOpname, opname));
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
			case EmftvmPackage.INVOKE_OPERATION_INSTRUCTION__OPNAME:
				return getOpname();
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
			case EmftvmPackage.INVOKE_OPERATION_INSTRUCTION__OPNAME:
				setOpname((String)newValue);
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
			case EmftvmPackage.INVOKE_OPERATION_INSTRUCTION__OPNAME:
				setOpname(OPNAME_EDEFAULT);
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
			case EmftvmPackage.INVOKE_OPERATION_INSTRUCTION__OPNAME:
				return OPNAME_EDEFAULT == null ? opname != null : !OPNAME_EDEFAULT.equals(opname);
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
		result.append(" (opname: ");
		result.append(opname);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public Method getNativeMethod() {
		return nativeMethod;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setNativeMethod(final Method method) {
		this.nativeMethod = method;
	}

} //InvokeOperationInstructionImpl
