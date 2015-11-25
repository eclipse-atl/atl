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
package org.eclipse.m2m.atl.common.ATL;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Stat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.IfStat#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.IfStat#getThenStatements <em>Then Statements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.IfStat#getElseStatements <em>Else Statements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getIfStat()
 * @model kind="class"
 * @generated
 */
public class IfStat extends Statement {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected OclExpression condition;

	/**
	 * The cached value of the '{@link #getThenStatements() <em>Then Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> thenStatements;

	/**
	 * The cached value of the '{@link #getElseStatements() <em>Else Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> elseStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfStat() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ATLPackage.Literals.IF_STAT;
	}

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(OclExpression)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getIfStat_Condition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public OclExpression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(OclExpression newCondition, NotificationChain msgs) {
		OclExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ATLPackage.IF_STAT__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.IfStat#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	public void setCondition(OclExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ATLPackage.IF_STAT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ATLPackage.IF_STAT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.IF_STAT__CONDITION, newCondition, newCondition));
	}

	/**
	 * Returns the value of the '<em><b>Then Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.ATL.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Statements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getIfStat_ThenStatements()
	 * @model containment="true"
	 * @generated
	 */
	public EList<Statement> getThenStatements() {
		if (thenStatements == null) {
			thenStatements = new EObjectContainmentEList<Statement>(Statement.class, this, ATLPackage.IF_STAT__THEN_STATEMENTS);
		}
		return thenStatements;
	}

	/**
	 * Returns the value of the '<em><b>Else Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.ATL.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Statements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getIfStat_ElseStatements()
	 * @model containment="true"
	 * @generated
	 */
	public EList<Statement> getElseStatements() {
		if (elseStatements == null) {
			elseStatements = new EObjectContainmentEList<Statement>(Statement.class, this, ATLPackage.IF_STAT__ELSE_STATEMENTS);
		}
		return elseStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ATLPackage.IF_STAT__CONDITION:
				return basicSetCondition(null, msgs);
			case ATLPackage.IF_STAT__THEN_STATEMENTS:
				return ((InternalEList<?>)getThenStatements()).basicRemove(otherEnd, msgs);
			case ATLPackage.IF_STAT__ELSE_STATEMENTS:
				return ((InternalEList<?>)getElseStatements()).basicRemove(otherEnd, msgs);
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
			case ATLPackage.IF_STAT__CONDITION:
				return getCondition();
			case ATLPackage.IF_STAT__THEN_STATEMENTS:
				return getThenStatements();
			case ATLPackage.IF_STAT__ELSE_STATEMENTS:
				return getElseStatements();
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
			case ATLPackage.IF_STAT__CONDITION:
				setCondition((OclExpression)newValue);
				return;
			case ATLPackage.IF_STAT__THEN_STATEMENTS:
				getThenStatements().clear();
				getThenStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case ATLPackage.IF_STAT__ELSE_STATEMENTS:
				getElseStatements().clear();
				getElseStatements().addAll((Collection<? extends Statement>)newValue);
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
			case ATLPackage.IF_STAT__CONDITION:
				setCondition((OclExpression)null);
				return;
			case ATLPackage.IF_STAT__THEN_STATEMENTS:
				getThenStatements().clear();
				return;
			case ATLPackage.IF_STAT__ELSE_STATEMENTS:
				getElseStatements().clear();
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
			case ATLPackage.IF_STAT__CONDITION:
				return condition != null;
			case ATLPackage.IF_STAT__THEN_STATEMENTS:
				return thenStatements != null && !thenStatements.isEmpty();
			case ATLPackage.IF_STAT__ELSE_STATEMENTS:
				return elseStatements != null && !elseStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // IfStat
