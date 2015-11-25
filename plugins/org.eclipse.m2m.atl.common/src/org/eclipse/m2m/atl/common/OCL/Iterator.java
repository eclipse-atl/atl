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

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.OCL.Iterator#getLoopExpr <em>Loop Expr</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getIterator()
 * @model kind="class"
 * @generated
 */
public class Iterator extends VariableDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Iterator() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLPackage.Literals.ITERATOR;
	}

	/**
	 * Returns the value of the '<em><b>Loop Expr</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.OCL.LoopExp#getIterators <em>Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Expr</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Expr</em>' container reference.
	 * @see #setLoopExpr(LoopExp)
	 * @see org.eclipse.m2m.atl.common.OCL.OCLPackage#getIterator_LoopExpr()
	 * @see org.eclipse.m2m.atl.common.OCL.LoopExp#getIterators
	 * @model opposite="iterators" transient="false" ordered="false"
	 * @generated
	 */
	public LoopExp getLoopExpr() {
		if (eContainerFeatureID() != OCLPackage.ITERATOR__LOOP_EXPR) return null;
		return (LoopExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopExpr(LoopExp newLoopExpr, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLoopExpr, OCLPackage.ITERATOR__LOOP_EXPR, msgs);
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.OCL.Iterator#getLoopExpr <em>Loop Expr</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Expr</em>' container reference.
	 * @see #getLoopExpr()
	 * @generated
	 */
	public void setLoopExpr(LoopExp newLoopExpr) {
		if (newLoopExpr != eInternalContainer() || (eContainerFeatureID() != OCLPackage.ITERATOR__LOOP_EXPR && newLoopExpr != null)) {
			if (EcoreUtil.isAncestor(this, newLoopExpr))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLoopExpr != null)
				msgs = ((InternalEObject)newLoopExpr).eInverseAdd(this, OCLPackage.LOOP_EXP__ITERATORS, LoopExp.class, msgs);
			msgs = basicSetLoopExpr(newLoopExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLPackage.ITERATOR__LOOP_EXPR, newLoopExpr, newLoopExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLPackage.ITERATOR__LOOP_EXPR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLoopExpr((LoopExp)otherEnd, msgs);
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
			case OCLPackage.ITERATOR__LOOP_EXPR:
				return basicSetLoopExpr(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OCLPackage.ITERATOR__LOOP_EXPR:
				return eInternalContainer().eInverseRemove(this, OCLPackage.LOOP_EXP__ITERATORS, LoopExp.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OCLPackage.ITERATOR__LOOP_EXPR:
				return getLoopExpr();
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
			case OCLPackage.ITERATOR__LOOP_EXPR:
				setLoopExpr((LoopExp)newValue);
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
			case OCLPackage.ITERATOR__LOOP_EXPR:
				setLoopExpr((LoopExp)null);
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
			case OCLPackage.ITERATOR__LOOP_EXPR:
				return getLoopExpr() != null;
		}
		return super.eIsSet(featureID);
	}

} // Iterator
