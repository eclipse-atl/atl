/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.m2m.atl.emftvm.CodeBlockInstruction;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Block Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockInstructionImpl#getCbIndex <em>Cb Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.CodeBlockInstructionImpl#getCodeBlock <em>Code Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CodeBlockInstructionImpl extends InstructionImpl implements CodeBlockInstruction {
	/**
	 * The default value of the '{@link #getCbIndex() <em>Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCbIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int CB_INDEX_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getCbIndex() <em>Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCbIndex()
	 * @generated NOT
	 * @ordered
	 */
	protected int cbIndex = CB_INDEX_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCodeBlock() <em>Code Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeBlock()
	 * @generated NOT
	 * @ordered
	 */
	protected CodeBlock codeBlock;
	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link CodeBlockInstructionImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeBlockInstructionImpl() {
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
		return EmftvmPackage.Literals.CODE_BLOCK_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CodeBlock getCodeBlock() {
		if (codeBlock == null) {
			final CodeBlock ob = getOwningBlock();
			if (ob != null && cbIndex != CB_INDEX_EDEFAULT &&
					cbIndex < ob.getNested().size()) {
				codeBlock = ob.getNested().get(cbIndex);
			}
		}
		if (codeBlock != null && codeBlock.eIsProxy()) {
			InternalEObject oldCodeBlock = (InternalEObject)codeBlock;
			codeBlock = (CodeBlock)eResolveProxy(oldCodeBlock);
			if (codeBlock != oldCodeBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.CODE_BLOCK_INSTRUCTION__CODE_BLOCK, oldCodeBlock, codeBlock));
			}
		}
		return codeBlock;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #getCodeBlock()
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CodeBlock basicGetCodeBlock() {
		if (codeBlock == null) {
			final CodeBlock ob = getOwningBlock();
			if (ob != null && cbIndex != CB_INDEX_EDEFAULT &&
					cbIndex < ob.getNested().size()) {
				codeBlock = ob.getNested().get(cbIndex);
			}
		}
		return codeBlock;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCodeBlock(CodeBlock newCodeBlock) {
		CodeBlock oldCodeBlock = codeBlock;
		codeBlock = newCodeBlock;
		cbIndex = CB_INDEX_EDEFAULT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK_INSTRUCTION__CODE_BLOCK, oldCodeBlock, codeBlock));
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
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION__CB_INDEX:
				return getCbIndex();
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION__CODE_BLOCK:
				if (resolve) return getCodeBlock();
				return basicGetCodeBlock();
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
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION__CB_INDEX:
				setCbIndex((Integer)newValue);
				return;
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION__CODE_BLOCK:
				setCodeBlock((CodeBlock)newValue);
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
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION__CB_INDEX:
				setCbIndex(CB_INDEX_EDEFAULT);
				return;
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION__CODE_BLOCK:
				setCodeBlock((CodeBlock)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getCbIndex() {
		if (cbIndex == CB_INDEX_EDEFAULT) {
			final CodeBlock ob = getOwningBlock();
			final CodeBlock cb = getCodeBlock();
			if (ob != null && cb != null) {
				cbIndex = ob.getNested().indexOf(cb);
				if (cbIndex < 0) {
					throw new IllegalArgumentException(String.format(
							"Code block argument %s not found with nested code blocks of %s", 
							cb, ob));
				}
			}
		}
		return cbIndex;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCbIndex(int newCbIndex) {
		int oldCbIndex = cbIndex;
		cbIndex = newCbIndex;
		if (newCbIndex != CB_INDEX_EDEFAULT) { // this value is normally derived
			codeBlock = null;
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.CODE_BLOCK_INSTRUCTION__CB_INDEX, oldCbIndex, cbIndex));
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
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION__CB_INDEX:
				return getCbIndex() != CB_INDEX_EDEFAULT;
			case EmftvmPackage.CODE_BLOCK_INSTRUCTION__CODE_BLOCK:
				return basicGetCodeBlock() != null;
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
		result.append(getCbIndex());
		return result.toString();
	}

} //CodeBlockInstructionImpl
