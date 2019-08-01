/**
 * Copyright (c) 2008, 2012, 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 */
package org.eclipse.m2m.atl.common.ATL;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.Rule#getOutPattern <em>Out Pattern</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.Rule#getActionBlock <em>Action Block</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.Rule#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.Rule#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRule()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class Rule extends ModuleElement {
	/**
	 * The cached value of the '{@link #getOutPattern() <em>Out Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutPattern()
	 * @generated
	 * @ordered
	 */
	protected OutPattern outPattern;

	/**
	 * The cached value of the '{@link #getActionBlock() <em>Action Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionBlock()
	 * @generated
	 * @ordered
	 */
	protected ActionBlock actionBlock;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleVariableDeclaration> variables;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Rule() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ATLPackage.Literals.RULE;
	}

	/**
	 * Returns the value of the '<em><b>Out Pattern</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Pattern</em>' containment reference.
	 * @see #setOutPattern(OutPattern)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRule_OutPattern()
	 * @see org.eclipse.m2m.atl.common.ATL.OutPattern#getRule
	 * @model opposite="rule" containment="true" ordered="false"
	 * @generated
	 */
	public OutPattern getOutPattern() {
		return outPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutPattern(OutPattern newOutPattern, NotificationChain msgs) {
		OutPattern oldOutPattern = outPattern;
		outPattern = newOutPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ATLPackage.RULE__OUT_PATTERN, oldOutPattern, newOutPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.Rule#getOutPattern <em>Out Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Pattern</em>' containment reference.
	 * @see #getOutPattern()
	 * @generated
	 */
	public void setOutPattern(OutPattern newOutPattern) {
		if (newOutPattern != outPattern) {
			NotificationChain msgs = null;
			if (outPattern != null)
				msgs = ((InternalEObject)outPattern).eInverseRemove(this, ATLPackage.OUT_PATTERN__RULE, OutPattern.class, msgs);
			if (newOutPattern != null)
				msgs = ((InternalEObject)newOutPattern).eInverseAdd(this, ATLPackage.OUT_PATTERN__RULE, OutPattern.class, msgs);
			msgs = basicSetOutPattern(newOutPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.RULE__OUT_PATTERN, newOutPattern, newOutPattern));
	}

	/**
	 * Returns the value of the '<em><b>Action Block</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.ActionBlock#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Block</em>' containment reference.
	 * @see #setActionBlock(ActionBlock)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRule_ActionBlock()
	 * @see org.eclipse.m2m.atl.common.ATL.ActionBlock#getRule
	 * @model opposite="rule" containment="true" ordered="false"
	 * @generated
	 */
	public ActionBlock getActionBlock() {
		return actionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionBlock(ActionBlock newActionBlock, NotificationChain msgs) {
		ActionBlock oldActionBlock = actionBlock;
		actionBlock = newActionBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ATLPackage.RULE__ACTION_BLOCK, oldActionBlock, newActionBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.Rule#getActionBlock <em>Action Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Block</em>' containment reference.
	 * @see #getActionBlock()
	 * @generated
	 */
	public void setActionBlock(ActionBlock newActionBlock) {
		if (newActionBlock != actionBlock) {
			NotificationChain msgs = null;
			if (actionBlock != null)
				msgs = ((InternalEObject)actionBlock).eInverseRemove(this, ATLPackage.ACTION_BLOCK__RULE, ActionBlock.class, msgs);
			if (newActionBlock != null)
				msgs = ((InternalEObject)newActionBlock).eInverseAdd(this, ATLPackage.ACTION_BLOCK__RULE, ActionBlock.class, msgs);
			msgs = basicSetActionBlock(newActionBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.RULE__ACTION_BLOCK, newActionBlock, newActionBlock));
	}

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRule_Variables()
	 * @see org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration#getRule
	 * @model opposite="rule" containment="true"
	 * @generated
	 */
	public EList<RuleVariableDeclaration> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentWithInverseEList<RuleVariableDeclaration>(RuleVariableDeclaration.class, this, ATLPackage.RULE__VARIABLES, ATLPackage.RULE_VARIABLE_DECLARATION__RULE);
		}
		return variables;
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRule_Name()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.Rule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.RULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ATLPackage.RULE__OUT_PATTERN:
				if (outPattern != null)
					msgs = ((InternalEObject)outPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ATLPackage.RULE__OUT_PATTERN, null, msgs);
				return basicSetOutPattern((OutPattern)otherEnd, msgs);
			case ATLPackage.RULE__ACTION_BLOCK:
				if (actionBlock != null)
					msgs = ((InternalEObject)actionBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ATLPackage.RULE__ACTION_BLOCK, null, msgs);
				return basicSetActionBlock((ActionBlock)otherEnd, msgs);
			case ATLPackage.RULE__VARIABLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariables()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ATLPackage.RULE__OUT_PATTERN:
				return basicSetOutPattern(null, msgs);
			case ATLPackage.RULE__ACTION_BLOCK:
				return basicSetActionBlock(null, msgs);
			case ATLPackage.RULE__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case ATLPackage.RULE__OUT_PATTERN:
				return getOutPattern();
			case ATLPackage.RULE__ACTION_BLOCK:
				return getActionBlock();
			case ATLPackage.RULE__VARIABLES:
				return getVariables();
			case ATLPackage.RULE__NAME:
				return getName();
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
			case ATLPackage.RULE__OUT_PATTERN:
				setOutPattern((OutPattern)newValue);
				return;
			case ATLPackage.RULE__ACTION_BLOCK:
				setActionBlock((ActionBlock)newValue);
				return;
			case ATLPackage.RULE__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends RuleVariableDeclaration>)newValue);
				return;
			case ATLPackage.RULE__NAME:
				setName((String)newValue);
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
			case ATLPackage.RULE__OUT_PATTERN:
				setOutPattern((OutPattern)null);
				return;
			case ATLPackage.RULE__ACTION_BLOCK:
				setActionBlock((ActionBlock)null);
				return;
			case ATLPackage.RULE__VARIABLES:
				getVariables().clear();
				return;
			case ATLPackage.RULE__NAME:
				setName(NAME_EDEFAULT);
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
			case ATLPackage.RULE__OUT_PATTERN:
				return outPattern != null;
			case ATLPackage.RULE__ACTION_BLOCK:
				return actionBlock != null;
			case ATLPackage.RULE__VARIABLES:
				return variables != null && !variables.isEmpty();
			case ATLPackage.RULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // Rule
