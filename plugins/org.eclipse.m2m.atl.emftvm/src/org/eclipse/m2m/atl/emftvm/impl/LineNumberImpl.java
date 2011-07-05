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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.LineNumber;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Line Number</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl#getStartColumn <em>Start Column</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl#getEndColumn <em>End Column</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl#getStartChar <em>Start Char</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl#getEndChar <em>End Char</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl#getOwningBlock <em>Owning Block</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.LineNumberImpl#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LineNumberImpl extends EObjectImpl implements LineNumber {
	/**
	 * The default value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected static final int START_LINE_EDEFAULT = -1;
	/**
	 * The default value of the '{@link #getStartColumn() <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int START_COLUMN_EDEFAULT = -1;
	/**
	 * The default value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected static final int END_LINE_EDEFAULT = -1;
	/**
	 * The default value of the '{@link #getEndColumn() <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int END_COLUMN_EDEFAULT = -1;
	/**
	 * The default value of the '{@link #getStartChar() <em>Start Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartChar()
	 * @generated
	 * @ordered
	 */
	protected static final int START_CHAR_EDEFAULT = -1;
	/**
	 * The default value of the '{@link #getEndChar() <em>End Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndChar()
	 * @generated
	 * @ordered
	 */
	protected static final int END_CHAR_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected int startLine = START_LINE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getStartColumn() <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartColumn()
	 * @generated
	 * @ordered
	 */
	protected int startColumn = START_COLUMN_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected int endLine = END_LINE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEndColumn() <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndColumn()
	 * @generated
	 * @ordered
	 */
	protected int endColumn = END_COLUMN_EDEFAULT;
	/**
	 * The cached value of the '{@link #getStartChar() <em>Start Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartChar()
	 * @generated
	 * @ordered
	 */
	protected int startChar = START_CHAR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEndChar() <em>End Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndChar()
	 * @generated
	 * @ordered
	 */
	protected int endChar = END_CHAR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getInstructions() <em>Instructions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructions()
	 * @generated
	 * @ordered
	 */
	protected EList<Instruction> instructions;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link LineNumberImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineNumberImpl() {
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
		return EmftvmPackage.Literals.LINE_NUMBER;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartLine() {
		return startLine;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLine(int newStartLine) {
		int oldStartLine = startLine;
		startLine = newStartLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LINE_NUMBER__START_LINE, oldStartLine, startLine));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartColumn() {
		return startColumn;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartColumn(int newStartColumn) {
		int oldStartColumn = startColumn;
		startColumn = newStartColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LINE_NUMBER__START_COLUMN, oldStartColumn, startColumn));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndLine() {
		return endLine;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndLine(int newEndLine) {
		int oldEndLine = endLine;
		endLine = newEndLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LINE_NUMBER__END_LINE, oldEndLine, endLine));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndColumn() {
		return endColumn;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndColumn(int newEndColumn) {
		int oldEndColumn = endColumn;
		endColumn = newEndColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LINE_NUMBER__END_COLUMN, oldEndColumn, endColumn));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartChar() {
		return startChar;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartChar(int newStartChar) {
		int oldStartChar = startChar;
		startChar = newStartChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LINE_NUMBER__START_CHAR, oldStartChar, startChar));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndChar() {
		return endChar;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndChar(int newEndChar) {
		int oldEndChar = endChar;
		endChar = newEndChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LINE_NUMBER__END_CHAR, oldEndChar, endChar));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getOwningBlock() {
		if (eContainerFeatureID() != EmftvmPackage.LINE_NUMBER__OWNING_BLOCK) return null;
		return (CodeBlock)eContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setOwningBlock(CodeBlock)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningBlock(CodeBlock newOwningBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningBlock, EmftvmPackage.LINE_NUMBER__OWNING_BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningBlock(CodeBlock newOwningBlock) {
		if (newOwningBlock != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.LINE_NUMBER__OWNING_BLOCK && newOwningBlock != null)) {
			if (EcoreUtil.isAncestor(this, newOwningBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningBlock != null)
				msgs = ((InternalEObject)newOwningBlock).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__LINE_NUMBERS, CodeBlock.class, msgs);
			msgs = basicSetOwningBlock(newOwningBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.LINE_NUMBER__OWNING_BLOCK, newOwningBlock, newOwningBlock));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instruction> getInstructions() {
		if (instructions == null) {
			instructions = new EObjectWithInverseResolvingEList<Instruction>(Instruction.class, this, EmftvmPackage.LINE_NUMBER__INSTRUCTIONS, EmftvmPackage.INSTRUCTION__LINE_NUMBER);
		}
		return instructions;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.LINE_NUMBER__OWNING_BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningBlock((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.LINE_NUMBER__INSTRUCTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstructions()).basicAdd(otherEnd, msgs);
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
			case EmftvmPackage.LINE_NUMBER__OWNING_BLOCK:
				return basicSetOwningBlock(null, msgs);
			case EmftvmPackage.LINE_NUMBER__INSTRUCTIONS:
				return ((InternalEList<?>)getInstructions()).basicRemove(otherEnd, msgs);
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
			case EmftvmPackage.LINE_NUMBER__OWNING_BLOCK:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.CODE_BLOCK__LINE_NUMBERS, CodeBlock.class, msgs);
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
			case EmftvmPackage.LINE_NUMBER__START_LINE:
				return getStartLine();
			case EmftvmPackage.LINE_NUMBER__START_COLUMN:
				return getStartColumn();
			case EmftvmPackage.LINE_NUMBER__END_LINE:
				return getEndLine();
			case EmftvmPackage.LINE_NUMBER__END_COLUMN:
				return getEndColumn();
			case EmftvmPackage.LINE_NUMBER__START_CHAR:
				return getStartChar();
			case EmftvmPackage.LINE_NUMBER__END_CHAR:
				return getEndChar();
			case EmftvmPackage.LINE_NUMBER__OWNING_BLOCK:
				return getOwningBlock();
			case EmftvmPackage.LINE_NUMBER__INSTRUCTIONS:
				return getInstructions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.LINE_NUMBER__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case EmftvmPackage.LINE_NUMBER__START_COLUMN:
				setStartColumn((Integer)newValue);
				return;
			case EmftvmPackage.LINE_NUMBER__END_LINE:
				setEndLine((Integer)newValue);
				return;
			case EmftvmPackage.LINE_NUMBER__END_COLUMN:
				setEndColumn((Integer)newValue);
				return;
			case EmftvmPackage.LINE_NUMBER__START_CHAR:
				setStartChar((Integer)newValue);
				return;
			case EmftvmPackage.LINE_NUMBER__END_CHAR:
				setEndChar((Integer)newValue);
				return;
			case EmftvmPackage.LINE_NUMBER__OWNING_BLOCK:
				setOwningBlock((CodeBlock)newValue);
				return;
			case EmftvmPackage.LINE_NUMBER__INSTRUCTIONS:
				getInstructions().clear();
				getInstructions().addAll((Collection<? extends Instruction>)newValue);
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
			case EmftvmPackage.LINE_NUMBER__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case EmftvmPackage.LINE_NUMBER__START_COLUMN:
				setStartColumn(START_COLUMN_EDEFAULT);
				return;
			case EmftvmPackage.LINE_NUMBER__END_LINE:
				setEndLine(END_LINE_EDEFAULT);
				return;
			case EmftvmPackage.LINE_NUMBER__END_COLUMN:
				setEndColumn(END_COLUMN_EDEFAULT);
				return;
			case EmftvmPackage.LINE_NUMBER__START_CHAR:
				setStartChar(START_CHAR_EDEFAULT);
				return;
			case EmftvmPackage.LINE_NUMBER__END_CHAR:
				setEndChar(END_CHAR_EDEFAULT);
				return;
			case EmftvmPackage.LINE_NUMBER__OWNING_BLOCK:
				setOwningBlock((CodeBlock)null);
				return;
			case EmftvmPackage.LINE_NUMBER__INSTRUCTIONS:
				getInstructions().clear();
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
			case EmftvmPackage.LINE_NUMBER__START_LINE:
				return startLine != START_LINE_EDEFAULT;
			case EmftvmPackage.LINE_NUMBER__START_COLUMN:
				return startColumn != START_COLUMN_EDEFAULT;
			case EmftvmPackage.LINE_NUMBER__END_LINE:
				return endLine != END_LINE_EDEFAULT;
			case EmftvmPackage.LINE_NUMBER__END_COLUMN:
				return endColumn != END_COLUMN_EDEFAULT;
			case EmftvmPackage.LINE_NUMBER__START_CHAR:
				return startChar != START_CHAR_EDEFAULT;
			case EmftvmPackage.LINE_NUMBER__END_CHAR:
				return endChar != END_CHAR_EDEFAULT;
			case EmftvmPackage.LINE_NUMBER__OWNING_BLOCK:
				return getOwningBlock() != null;
			case EmftvmPackage.LINE_NUMBER__INSTRUCTIONS:
				return instructions != null && !instructions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		if (eIsSet(EmftvmPackage.LINE_NUMBER__START_LINE)) {
			result.append(startLine);
		}
		if (eIsSet(EmftvmPackage.LINE_NUMBER__START_COLUMN)) {
			result.append(':');
			result.append(startColumn);
		}
		if (eIsSet(EmftvmPackage.LINE_NUMBER__END_LINE)) {
			result.append('-');
			result.append(endLine);
			if (eIsSet(EmftvmPackage.LINE_NUMBER__END_COLUMN)) {
				result.append(':');
				result.append(endColumn);
			}
		}
		if (eIsSet(EmftvmPackage.LINE_NUMBER__START_CHAR)) {
			result.append('(');
			result.append(startChar);
			if (eIsSet(EmftvmPackage.LINE_NUMBER__END_CHAR)) {
				result.append('-');
				result.append(endChar);
			}
			result.append(')');
		}
		return result.toString();
	}

} //LineNumberImpl
