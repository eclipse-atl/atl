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
package org.eclipse.m2m.atl.common.OCL;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.LetExp#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.LetExp#getIn_ <em>In </em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getLetExp()
 * @model kind="class"
 * @generated
 */
public class LetExp extends OclExpression {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration variable;

	/**
	 * The cached value of the '{@link #getIn_() <em>In </em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn_()
	 * @generated
	 * @ordered
	 */
	protected OclExpression in_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LetExp() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLPackage.Literals.LET_EXP;
	}

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.OCL.VariableDeclaration#getLetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(VariableDeclaration)
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getLetExp_Variable()
	 * @see org.eclipse.m2m.atl.common.OCL.VariableDeclaration#getLetExp
	 * @model opposite="letExp" containment="true" required="true" ordered="false"
	 * @generated
	 */
	public VariableDeclaration getVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable(VariableDeclaration newVariable, NotificationChain msgs) {
		VariableDeclaration oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLPackage.LET_EXP__VARIABLE, oldVariable, newVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.LetExp#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	public void setVariable(VariableDeclaration newVariable) {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject)variable).eInverseRemove(this, OCLPackage.VARIABLE_DECLARATION__LET_EXP, VariableDeclaration.class, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, OCLPackage.VARIABLE_DECLARATION__LET_EXP, VariableDeclaration.class, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.LET_EXP__VARIABLE, newVariable, newVariable));
	}

	/**
	 * Returns the value of the '<em><b>In </b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.OCL.OclExpression#getLetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In </em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In </em>' containment reference.
	 * @see #setIn_(OclExpression)
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getLetExp_In_()
	 * @see org.eclipse.m2m.atl.common.OCL.OclExpression#getLetExp
	 * @model opposite="letExp" containment="true" required="true" ordered="false"
	 * @generated
	 */
	public OclExpression getIn_() {
		return in_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIn_(OclExpression newIn_, NotificationChain msgs) {
		OclExpression oldIn_ = in_;
		in_ = newIn_;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLPackage.LET_EXP__IN_, oldIn_, newIn_);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.LetExp#getIn_ <em>In </em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In </em>' containment reference.
	 * @see #getIn_()
	 * @generated
	 */
	public void setIn_(OclExpression newIn_) {
		if (newIn_ != in_) {
			NotificationChain msgs = null;
			if (in_ != null)
				msgs = ((InternalEObject)in_).eInverseRemove(this, OCLPackage.OCL_EXPRESSION__LET_EXP, OclExpression.class, msgs);
			if (newIn_ != null)
				msgs = ((InternalEObject)newIn_).eInverseAdd(this, OCLPackage.OCL_EXPRESSION__LET_EXP, OclExpression.class, msgs);
			msgs = basicSetIn_(newIn_, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.LET_EXP__IN_, newIn_, newIn_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLPackage.LET_EXP__VARIABLE:
				if (variable != null)
					msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OCLPackage.LET_EXP__VARIABLE, null, msgs);
				return basicSetVariable((VariableDeclaration)otherEnd, msgs);
			case OCLPackage.LET_EXP__IN_:
				if (in_ != null)
					msgs = ((InternalEObject)in_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OCLPackage.LET_EXP__IN_, null, msgs);
				return basicSetIn_((OclExpression)otherEnd, msgs);
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
			case OCLPackage.LET_EXP__VARIABLE:
				return basicSetVariable(null, msgs);
			case OCLPackage.LET_EXP__IN_:
				return basicSetIn_(null, msgs);
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
			case OCLPackage.LET_EXP__VARIABLE:
				return getVariable();
			case OCLPackage.LET_EXP__IN_:
				return getIn_();
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
			case OCLPackage.LET_EXP__VARIABLE:
				setVariable((VariableDeclaration)newValue);
				return;
			case OCLPackage.LET_EXP__IN_:
				setIn_((OclExpression)newValue);
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
			case OCLPackage.LET_EXP__VARIABLE:
				setVariable((VariableDeclaration)null);
				return;
			case OCLPackage.LET_EXP__IN_:
				setIn_((OclExpression)null);
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
			case OCLPackage.LET_EXP__VARIABLE:
				return variable != null;
			case OCLPackage.LET_EXP__IN_:
				return in_ != null;
		}
		return super.eIsSet(featureID);
	}

} // LetExp
