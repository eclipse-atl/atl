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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.atl.emftvm.BranchInstruction;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Instruction;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.BranchInstructionImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.BranchInstructionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BranchInstructionImpl extends InstructionImpl implements BranchInstruction {
	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated NOT
	 * @ordered
	 */
	protected int offset = OFFSET_EDEFAULT;
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated NOT
	 * @ordered
	 */
	protected Instruction target;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchInstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.BRANCH_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getOffset() {
		if (offset == OFFSET_EDEFAULT) {
			final CodeBlock ob = getOwningBlock();
			final Instruction target = getTarget();
			if (ob != null && target != null) {
				offset = ob.getCode().indexOf(target);
			}
		}
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOffset(int newOffset) {
		int oldOffset = offset;
		offset = newOffset;
		if (newOffset != OFFSET_EDEFAULT) { // this value is normally derived
			target = null;
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.BRANCH_INSTRUCTION__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Instruction getTarget() {
		if (target == null) {
			final CodeBlock ob = getOwningBlock();
			if (ob != null && offset != OFFSET_EDEFAULT &&
					offset < ob.getCode().size()) {
				target = ob.getCode().get(offset);
			}
		}
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Instruction)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.BRANCH_INSTRUCTION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Instruction basicGetTarget() {
		if (target == null) {
			final CodeBlock ob = getOwningBlock();
			if (ob != null && offset != OFFSET_EDEFAULT &&
					offset < ob.getCode().size()) {
				target = ob.getCode().get(offset);
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTarget(Instruction newTarget) {
		Instruction oldTarget = target;
		target = newTarget;
			offset = OFFSET_EDEFAULT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.BRANCH_INSTRUCTION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmftvmPackage.BRANCH_INSTRUCTION__OFFSET:
				return getOffset();
			case EmftvmPackage.BRANCH_INSTRUCTION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case EmftvmPackage.BRANCH_INSTRUCTION__OFFSET:
				setOffset((Integer)newValue);
				return;
			case EmftvmPackage.BRANCH_INSTRUCTION__TARGET:
				setTarget((Instruction)newValue);
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
			case EmftvmPackage.BRANCH_INSTRUCTION__OFFSET:
				setOffset(OFFSET_EDEFAULT);
				return;
			case EmftvmPackage.BRANCH_INSTRUCTION__TARGET:
				setTarget((Instruction)null);
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
			case EmftvmPackage.BRANCH_INSTRUCTION__OFFSET:
				return getOffset() != OFFSET_EDEFAULT;
			case EmftvmPackage.BRANCH_INSTRUCTION__TARGET:
				return basicGetTarget() != null;
		}
		return super.eIsSet(featureID);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#toString()
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(' ');
		result.append(getOffset());
		return result.toString();
	}

} //BranchInstructionImpl
