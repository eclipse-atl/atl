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
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.InvokeCb;
import org.eclipse.m2m.atl.emftvm.InvokeInstruction;
import org.eclipse.m2m.atl.emftvm.Opcode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke cb</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InvokeCbImpl#getArgcount <em>Argcount</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvokeCbImpl extends CodeBlockInstructionImpl implements InvokeCb {
	/**
	 * The default value of the '{@link #getArgcount() <em>Argcount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgcount()
	 * @generated
	 * @ordered
	 */
	protected static final int ARGCOUNT_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getArgcount() <em>Argcount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgcount()
	 * @generated
	 * @ordered
	 */
	protected int argcount = ARGCOUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link InvokeCbImpl}.
	 * <!-- end-user-doc -->
	 */
	protected InvokeCbImpl() {
		super();
		opcode = Opcode.INVOKE_CB;
		stackProduction = 0;
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
		return EmftvmPackage.Literals.INVOKE_CB;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getArgcount() {
		return argcount;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgcount(int newArgcount) {
		int oldArgcount = argcount;
		argcount = newArgcount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.INVOKE_CB__ARGCOUNT, oldArgcount, argcount));
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
			case EmftvmPackage.INVOKE_CB__ARGCOUNT:
				return getArgcount();
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
			case EmftvmPackage.INVOKE_CB__ARGCOUNT:
				setArgcount((Integer)newValue);
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
			case EmftvmPackage.INVOKE_CB__ARGCOUNT:
				setArgcount(ARGCOUNT_EDEFAULT);
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
			case EmftvmPackage.INVOKE_CB__ARGCOUNT:
				return argcount != ARGCOUNT_EDEFAULT;
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == InvokeInstruction.class) {
			switch (derivedFeatureID) {
				case EmftvmPackage.INVOKE_CB__ARGCOUNT: return EmftvmPackage.INVOKE_INSTRUCTION__ARGCOUNT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == InvokeInstruction.class) {
			switch (baseFeatureID) {
				case EmftvmPackage.INVOKE_INSTRUCTION__ARGCOUNT: return EmftvmPackage.INVOKE_CB__ARGCOUNT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (argcount: ");
		result.append(argcount);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getStackConsumption() {
		return stackConsumption + getArgcount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getStackProduction() {
		final CodeBlock cb = getCodeBlock();
		if (cb != null) {
			return (cb.getStackLevel() > 0) ? stackProduction + 1 : stackProduction;
		}
		return super.getStackProduction();
	}

} //Invoke_cbImpl
