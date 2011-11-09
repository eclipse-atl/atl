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
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.LocalVariableInstruction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Variable Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LocalVariableInstructionImpl#getCbOffset <em>Cb Offset</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LocalVariableInstructionImpl#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LocalVariableInstructionImpl#getLocalVariableIndex <em>Local Variable Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LocalVariableInstructionImpl#getLocalVariable <em>Local Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LocalVariableInstructionImpl extends InstructionImpl implements LocalVariableInstruction {
	/**
	 * The default value of the '{@link #getCbOffset() <em>Cb Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCbOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int CB_OFFSET_EDEFAULT = -1;
	/**
	 * The default value of the '{@link #getSlot() <em>Slot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlot()
	 * @generated
	 * @ordered
	 */
	protected static final int SLOT_EDEFAULT = -1;
	/**
	 * The default value of the '{@link #getLocalVariableIndex() <em>Local Variable Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalVariableIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int LOCAL_VARIABLE_INDEX_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getCbOffset() <em>Cb Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCbOffset()
	 * @generated NOT
	 * @ordered
	 */
	protected int cbOffset = CB_OFFSET_EDEFAULT;
	/**
	 * The cached value of the '{@link #getLocalVariableIndex() <em>Local Variable Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalVariableIndex()
	 * @generated NOT
	 * @ordered
	 */
	protected int localVariableIndex = LOCAL_VARIABLE_INDEX_EDEFAULT;
	/**
	 * The cached value of the '{@link #getSlot() <em>Slot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlot()
	 * @generated NOT
	 * @ordered
	 */
	protected int slot = SLOT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getLocalVariable() <em>Local Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalVariable()
	 * @generated NOT
	 * @ordered
	 */
	protected LocalVariable localVariable;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link LocalVariableInstructionImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalVariableInstructionImpl() {
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
		return EmftvmPackage.Literals.LOCAL_VARIABLE_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getCbOffset() {
		if (cbOffset == CB_OFFSET_EDEFAULT) {
			final LocalVariable lv = getLocalVariable();
			if (lv != null) {
				final CodeBlock lvBlock = lv.getOwningBlock();
				if (lvBlock != null) {
					CodeBlock cb = getOwningBlock();
					int offset = 0;
					while (cb != null && lvBlock != cb) {
						cb = cb.getNestedFor();
						offset++;
					}
					if (cb == lvBlock) {
						cbOffset = offset;
					} else {
						throw new IllegalArgumentException(String.format(
								"Referred local variable %s::%s not reachable from %s::%s", 
								lvBlock, lv, getOwningBlock(), super.toString()));
					}
				}
			}
		}
		return cbOffset;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCbOffset(int newCbOffset) {
		int oldCbOffset = cbOffset;
		cbOffset = newCbOffset;
		if (newCbOffset != CB_OFFSET_EDEFAULT) { // this value is normally derived
			localVariable = null;
		}
		slot = SLOT_EDEFAULT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET, oldCbOffset, cbOffset));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getSlot() {
		if (slot == SLOT_EDEFAULT) {
			final LocalVariable lv = getLocalVariable();
			if (lv != null) {
				slot = lv.getSlot();
			}
		}
		return slot;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getLocalVariableIndex() {
		if (localVariableIndex == LOCAL_VARIABLE_INDEX_EDEFAULT) {
			final LocalVariable lv = getLocalVariable();
			if (lv != null) {
				CodeBlock lvBlock = lv.getOwningBlock();
				if (lvBlock != null) {
					localVariableIndex = lvBlock.getLocalVariables().indexOf(lv);
					assert localVariableIndex > -1;
				}
			}
		}
		return localVariableIndex;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLocalVariableIndex(int newLocalVariableIndex) {
		int oldLocalVariableIndex = localVariableIndex;
		localVariableIndex = newLocalVariableIndex;
		if (newLocalVariableIndex != LOCAL_VARIABLE_INDEX_EDEFAULT) { // this value is normally derived
			localVariable = null;
		}
		slot = SLOT_EDEFAULT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX, oldLocalVariableIndex, localVariableIndex));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LocalVariable getLocalVariable() {
		if (localVariable == null) {
			if (cbOffset != CB_OFFSET_EDEFAULT && localVariableIndex != LOCAL_VARIABLE_INDEX_EDEFAULT) {
				final CodeBlock cb = getOwningBlock();
				if (cb != null) {
					final int index = cb.getCode().indexOf(this);
					assert index > -1;
					CodeBlock lvBlock = cb;
					for (int i = 0; i < cbOffset; i++) {
						lvBlock = lvBlock.getNestedFor();
						if (lvBlock == null) {
							throw new IllegalArgumentException(String.format(
									"Code block of referred local variable at (cbOffset = %d, index = %d) not found for %s::%s", 
									cbOffset, localVariableIndex, cb, super.toString()));
						}
					}
					localVariable = lvBlock.getLocalVariables().get(localVariableIndex);
					if (localVariable == null) {
						throw new IllegalArgumentException(String.format(
								"Referred local variable at (cbOffset = %d, index = %d) not found for %s::%s", 
								cbOffset, localVariableIndex, cb, super.toString()));
					}
				}
			}
		}
		if (localVariable != null && localVariable.eIsProxy()) {
			InternalEObject oldLocalVariable = (InternalEObject)localVariable;
			localVariable = (LocalVariable)eResolveProxy(oldLocalVariable);
			if (localVariable != oldLocalVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE, oldLocalVariable, localVariable));
			}
		}
		return localVariable;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #getLocalVariable()
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LocalVariable basicGetLocalVariable() {
		if (localVariable == null) {
			if (cbOffset != CB_OFFSET_EDEFAULT && localVariableIndex != LOCAL_VARIABLE_INDEX_EDEFAULT) {
				final CodeBlock cb = getOwningBlock();
				if (cb != null) {
					final int index = cb.getCode().indexOf(this);
					assert index > -1;
					CodeBlock lvBlock = cb;
					for (int i = 0; i < cbOffset; i++) {
						lvBlock = lvBlock.getNestedFor();
						if (lvBlock == null) {
							throw new IllegalArgumentException(String.format(
									"Code block of referred local variable at (cbOffset = %d, index = %d) not found for %s::%s", 
									cbOffset, localVariableIndex, cb, this));
						}
					}
					localVariable = lvBlock.getLocalVariables().get(localVariableIndex);
					if (localVariable == null) {
						throw new IllegalArgumentException(String.format(
								"Referred local variable at (cbOffset = %d, index = %d) not found for %s::%s", 
								cbOffset, localVariableIndex, cb, this));
					}
				}
			}
		}
		return localVariable;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLocalVariable(LocalVariable newLocalVariable) {
		LocalVariable oldLocalVariable = localVariable;
		localVariable = newLocalVariable;
		cbOffset = CB_OFFSET_EDEFAULT;
		localVariableIndex = LOCAL_VARIABLE_INDEX_EDEFAULT;
		slot = SLOT_EDEFAULT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE, oldLocalVariable, localVariable));
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
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET:
				return getCbOffset();
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__SLOT:
				return getSlot();
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX:
				return getLocalVariableIndex();
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE:
				if (resolve) return getLocalVariable();
				return basicGetLocalVariable();
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
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET:
				setCbOffset((Integer)newValue);
				return;
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX:
				setLocalVariableIndex((Integer)newValue);
				return;
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE:
				setLocalVariable((LocalVariable)newValue);
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
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET:
				setCbOffset(CB_OFFSET_EDEFAULT);
				return;
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX:
				setLocalVariableIndex(LOCAL_VARIABLE_INDEX_EDEFAULT);
				return;
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE:
				setLocalVariable((LocalVariable)null);
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
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__CB_OFFSET:
				return getCbOffset() != CB_OFFSET_EDEFAULT;
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__SLOT:
				return getSlot() != SLOT_EDEFAULT;
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE_INDEX:
				return getLocalVariableIndex() != LOCAL_VARIABLE_INDEX_EDEFAULT;
			case EmftvmPackage.LOCAL_VARIABLE_INSTRUCTION__LOCAL_VARIABLE:
				return basicGetLocalVariable() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(' ');
		result.append(getCbOffset());
		result.append(", ");
		result.append(getSlot());
		result.append(" (");
		result.append(getLocalVariable());
		result.append(')');
		return result.toString();
	}

} //LocalVariableInstructionImpl
