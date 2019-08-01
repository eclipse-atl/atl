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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Iterate;
import org.eclipse.m2m.atl.emftvm.LineNumber;
import org.eclipse.m2m.atl.emftvm.Opcode;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#getOwningBlock <em>Owning Block</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#getOpcode <em>Opcode</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#getStackProduction <em>Stack Production</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#getStackConsumption <em>Stack Consumption</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#getStackLevel <em>Stack Level</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#getLineNumber <em>Line Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InstructionImpl extends EObjectImpl implements Instruction {
	/**
	 * The default value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpcode()
	 * @generated
	 * @ordered
	 */
	protected static final Opcode OPCODE_EDEFAULT = Opcode.PUSH;
	/**
	 * The cached value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpcode()
	 * @generated
	 * @ordered
	 */
	protected Opcode opcode = OPCODE_EDEFAULT;
	/**
	 * The default value of the '{@link #getStackProduction() <em>Stack Production</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackProduction()
	 * @generated
	 * @ordered
	 */
	protected static final int STACK_PRODUCTION_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getStackProduction() <em>Stack Production</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackProduction()
	 * @generated
	 * @ordered
	 */
	protected int stackProduction = STACK_PRODUCTION_EDEFAULT;
	/**
	 * The default value of the '{@link #getStackConsumption() <em>Stack Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackConsumption()
	 * @generated
	 * @ordered
	 */
	protected static final int STACK_CONSUMPTION_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getStackConsumption() <em>Stack Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackConsumption()
	 * @generated
	 * @ordered
	 */
	protected int stackConsumption = STACK_CONSUMPTION_EDEFAULT;
	/**
	 * The default value of the '{@link #getStackLevel() <em>Stack Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int STACK_LEVEL_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getStackLevel() <em>Stack Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackLevel()
	 * @generated
	 * @ordered
	 */
	protected int stackLevel = STACK_LEVEL_EDEFAULT;
	protected boolean stackLevelSet;
	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected LineNumber lineNumber;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link InstructionImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstructionImpl() {
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
		return EmftvmPackage.Literals.INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getOwningBlock() {
		if (eContainerFeatureID() != EmftvmPackage.INSTRUCTION__OWNING_BLOCK) return null;
		return (CodeBlock)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setOwningBlock(CodeBlock)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningBlock(CodeBlock newOwningBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningBlock, EmftvmPackage.INSTRUCTION__OWNING_BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningBlock(CodeBlock newOwningBlock) {
		if (newOwningBlock != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.INSTRUCTION__OWNING_BLOCK && newOwningBlock != null)) {
			if (EcoreUtil.isAncestor(this, newOwningBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningBlock != null)
				msgs = ((InternalEObject)newOwningBlock).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__CODE, CodeBlock.class, msgs);
			msgs = basicSetOwningBlock(newOwningBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.INSTRUCTION__OWNING_BLOCK, newOwningBlock, newOwningBlock));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Opcode getOpcode() {
		return opcode;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStackProduction() {
		return stackProduction;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStackConsumption() {
		return stackConsumption;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getStackLevel() {
		if (!stackLevelSet) {
			stackLevel = getStackProduction() - getStackConsumption();
			final CodeBlock cb = getOwningBlock();
			if (cb != null) {
				int prevStackLevel = 0;
				final EList<Instruction> code = cb.getCode();
				final int index = code.indexOf(this);
				final EList<Instruction> nlp = cb.getNonLoopingPredecessors(this);
				for (Instruction pred : nlp) {
					// ITERATE only gives correct stack production/consumption in combination
					// with its ENDITERATE companion, so ignore jumps from ITERATE
					if (!(pred instanceof Iterate) || code.indexOf(pred) == index - 1) {
						prevStackLevel = Math.max(prevStackLevel, pred.getStackLevel());
					}
				}
				stackLevel += prevStackLevel;
			}
			stackLevelSet = true;
		}
		return stackLevel;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineNumber getLineNumber() {
		if (lineNumber != null && lineNumber.eIsProxy()) {
			InternalEObject oldLineNumber = (InternalEObject)lineNumber;
			lineNumber = (LineNumber)eResolveProxy(oldLineNumber);
			if (lineNumber != oldLineNumber) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.INSTRUCTION__LINE_NUMBER, oldLineNumber, lineNumber));
			}
		}
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #getLineNumber()
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineNumber basicGetLineNumber() {
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setLineNumber(LineNumber)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLineNumber(LineNumber newLineNumber, NotificationChain msgs) {
		LineNumber oldLineNumber = lineNumber;
		lineNumber = newLineNumber;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmftvmPackage.INSTRUCTION__LINE_NUMBER, oldLineNumber, newLineNumber);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(LineNumber newLineNumber) {
		if (newLineNumber != lineNumber) {
			NotificationChain msgs = null;
			if (lineNumber != null)
				msgs = ((InternalEObject)lineNumber).eInverseRemove(this, EmftvmPackage.LINE_NUMBER__INSTRUCTIONS, LineNumber.class, msgs);
			if (newLineNumber != null)
				msgs = ((InternalEObject)newLineNumber).eInverseAdd(this, EmftvmPackage.LINE_NUMBER__INSTRUCTIONS, LineNumber.class, msgs);
			msgs = basicSetLineNumber(newLineNumber, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.INSTRUCTION__LINE_NUMBER, newLineNumber, newLineNumber));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.INSTRUCTION__OWNING_BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningBlock((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.INSTRUCTION__LINE_NUMBER:
				if (lineNumber != null)
					msgs = ((InternalEObject)lineNumber).eInverseRemove(this, EmftvmPackage.LINE_NUMBER__INSTRUCTIONS, LineNumber.class, msgs);
				return basicSetLineNumber((LineNumber)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.INSTRUCTION__OWNING_BLOCK:
				return basicSetOwningBlock(null, msgs);
			case EmftvmPackage.INSTRUCTION__LINE_NUMBER:
				return basicSetLineNumber(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EmftvmPackage.INSTRUCTION__OWNING_BLOCK:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.CODE_BLOCK__CODE, CodeBlock.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case EmftvmPackage.INSTRUCTION__OWNING_BLOCK:
				return getOwningBlock();
			case EmftvmPackage.INSTRUCTION__OPCODE:
				return getOpcode();
			case EmftvmPackage.INSTRUCTION__STACK_PRODUCTION:
				return getStackProduction();
			case EmftvmPackage.INSTRUCTION__STACK_CONSUMPTION:
				return getStackConsumption();
			case EmftvmPackage.INSTRUCTION__STACK_LEVEL:
				return getStackLevel();
			case EmftvmPackage.INSTRUCTION__LINE_NUMBER:
				if (resolve) return getLineNumber();
				return basicGetLineNumber();
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
			case EmftvmPackage.INSTRUCTION__OWNING_BLOCK:
				setOwningBlock((CodeBlock)newValue);
				return;
			case EmftvmPackage.INSTRUCTION__LINE_NUMBER:
				setLineNumber((LineNumber)newValue);
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
			case EmftvmPackage.INSTRUCTION__OWNING_BLOCK:
				setOwningBlock((CodeBlock)null);
				return;
			case EmftvmPackage.INSTRUCTION__LINE_NUMBER:
				setLineNumber((LineNumber)null);
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
			case EmftvmPackage.INSTRUCTION__OWNING_BLOCK:
				return getOwningBlock() != null;
			case EmftvmPackage.INSTRUCTION__OPCODE:
				return opcode != OPCODE_EDEFAULT;
			case EmftvmPackage.INSTRUCTION__STACK_PRODUCTION:
				return stackProduction != STACK_PRODUCTION_EDEFAULT;
			case EmftvmPackage.INSTRUCTION__STACK_CONSUMPTION:
				return stackConsumption != STACK_CONSUMPTION_EDEFAULT;
			case EmftvmPackage.INSTRUCTION__STACK_LEVEL:
				return stackLevel != STACK_LEVEL_EDEFAULT;
			case EmftvmPackage.INSTRUCTION__LINE_NUMBER:
				return lineNumber != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		switch (notification.getFeatureID(null)) {
		case EmftvmPackage.CODE_BLOCK__CODE:
			stackLevelSet = false;
			break;
		}
	}

	/**
	 * <!-- begin-user-doc. --> {@inheritDoc} <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		if (getOwningBlock() != null) {
			result.append(String.format("%2d: ", 
					getOwningBlock().getCode().indexOf(this)));
		}
		result.append(getOpcode());
		return result.toString();
	}

} //InstructionImpl
