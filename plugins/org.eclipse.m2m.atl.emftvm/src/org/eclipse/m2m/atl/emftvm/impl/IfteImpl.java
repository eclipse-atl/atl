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
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Ifte;
import org.eclipse.m2m.atl.emftvm.Opcode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifte</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.IfteImpl#getThenCbIndex <em>Then Cb Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.IfteImpl#getElseCbIndex <em>Else Cb Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.IfteImpl#getThenCb <em>Then Cb</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.IfteImpl#getElseCb <em>Else Cb</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfteImpl extends InstructionImpl implements Ifte {
	/**
	 * The default value of the '{@link #getThenCbIndex() <em>Then Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenCbIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int THEN_CB_INDEX_EDEFAULT = -1;
	/**
	 * The default value of the '{@link #getElseCbIndex() <em>Else Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseCbIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int ELSE_CB_INDEX_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getThenCbIndex() <em>Then Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenCbIndex()
	 * @generated NOT
	 * @ordered
	 */
	protected int thenCbIndex = THEN_CB_INDEX_EDEFAULT;
	/**
	 * The cached value of the '{@link #getElseCbIndex() <em>Else Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseCbIndex()
	 * @generated NOT
	 * @ordered
	 */
	protected int elseCbIndex = ELSE_CB_INDEX_EDEFAULT;
	/**
	 * The cached value of the '{@link #getThenCb() <em>Then Cb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenCb()
	 * @generated NOT
	 * @ordered
	 */
	protected CodeBlock thenCb;
	/**
	 * The cached value of the '{@link #getElseCb() <em>Else Cb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseCb()
	 * @generated NOT
	 * @ordered
	 */
	protected CodeBlock elseCb;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link IfteImpl}.
	 * <!-- end-user-doc -->
	 */
	protected IfteImpl() {
		super();
		opcode = Opcode.IFTE;
		stackConsumption = 1;
		stackProduction = 1;
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
		return EmftvmPackage.Literals.IFTE;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getThenCbIndex() {
		if (thenCbIndex == THEN_CB_INDEX_EDEFAULT) {
			final CodeBlock ob = getOwningBlock();
			final CodeBlock cb = getThenCb();
			if (ob != null && cb != null) {
				thenCbIndex = ob.getNested().indexOf(cb);
				if (thenCbIndex < 0) {
					throw new IllegalArgumentException(String.format(
							"Code block argument %s not found with nested code blocks of %s", 
							cb, ob));
				}
			}
		}
		return thenCbIndex;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setThenCbIndex(int newThenCbIndex) {
		int oldThenCbIndex = thenCbIndex;
		thenCbIndex = newThenCbIndex;
		if (newThenCbIndex != THEN_CB_INDEX_EDEFAULT) { // this value is normally derived
			thenCb = null;
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.IFTE__THEN_CB_INDEX, oldThenCbIndex, thenCbIndex));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getElseCbIndex() {
		if (elseCbIndex == ELSE_CB_INDEX_EDEFAULT) {
			final CodeBlock ob = getOwningBlock();
			final CodeBlock cb = getElseCb();
			if (ob != null && cb != null) {
				elseCbIndex = ob.getNested().indexOf(cb);
				if (elseCbIndex < 0) {
					throw new IllegalArgumentException(String.format(
							"Code block argument %s not found with nested code blocks of %s", 
							cb, ob));
				}
			}
		}
		return elseCbIndex;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setElseCbIndex(int newElseCbIndex) {
		int oldElseCbIndex = elseCbIndex;
		elseCbIndex = newElseCbIndex;
		if (newElseCbIndex != ELSE_CB_INDEX_EDEFAULT) { // this value is normally derived
			elseCb = null;
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.IFTE__ELSE_CB_INDEX, oldElseCbIndex, elseCbIndex));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CodeBlock getThenCb() {
		if (thenCb == null) {
			final CodeBlock ob = getOwningBlock();
			if (ob != null && thenCbIndex != THEN_CB_INDEX_EDEFAULT &&
					thenCbIndex < ob.getNested().size()) {
				thenCb = ob.getNested().get(thenCbIndex);
			}
		}
		if (thenCb != null && thenCb.eIsProxy()) {
			InternalEObject oldThenCb = (InternalEObject)thenCb;
			thenCb = (CodeBlock)eResolveProxy(oldThenCb);
			if (thenCb != oldThenCb) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.IFTE__THEN_CB, oldThenCb, thenCb));
			}
		}
		return thenCb;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #getThenCb()
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CodeBlock basicGetThenCb() {
		if (thenCb == null) {
			final CodeBlock ob = getOwningBlock();
			if (ob != null && thenCbIndex != THEN_CB_INDEX_EDEFAULT &&
					thenCbIndex < ob.getNested().size()) {
				thenCb = ob.getNested().get(thenCbIndex);
			}
		}
		return thenCb;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setThenCb(CodeBlock newThenCb) {
		CodeBlock oldThenCb = thenCb;
		thenCb = newThenCb;
		thenCbIndex = THEN_CB_INDEX_EDEFAULT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.IFTE__THEN_CB, oldThenCb, thenCb));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CodeBlock getElseCb() {
		if (elseCb == null) {
			final CodeBlock ob = getOwningBlock();
			if (ob != null && elseCbIndex != ELSE_CB_INDEX_EDEFAULT &&
					elseCbIndex < ob.getNested().size()) {
				elseCb = ob.getNested().get(elseCbIndex);
			}
		}
		if (elseCb != null && elseCb.eIsProxy()) {
			InternalEObject oldElseCb = (InternalEObject)elseCb;
			elseCb = (CodeBlock)eResolveProxy(oldElseCb);
			if (elseCb != oldElseCb) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.IFTE__ELSE_CB, oldElseCb, elseCb));
			}
		}
		return elseCb;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #getElseCb()
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CodeBlock basicGetElseCb() {
		if (elseCb == null) {
			final CodeBlock ob = getOwningBlock();
			if (ob != null && elseCbIndex != ELSE_CB_INDEX_EDEFAULT &&
					elseCbIndex < ob.getNested().size()) {
				elseCb = ob.getNested().get(elseCbIndex);
			}
		}
		return elseCb;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setElseCb(CodeBlock newElseCb) {
		CodeBlock oldElseCb = elseCb;
		elseCb = newElseCb;
		elseCbIndex = ELSE_CB_INDEX_EDEFAULT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.IFTE__ELSE_CB, oldElseCb, elseCb));
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
			case EmftvmPackage.IFTE__THEN_CB_INDEX:
				return getThenCbIndex();
			case EmftvmPackage.IFTE__ELSE_CB_INDEX:
				return getElseCbIndex();
			case EmftvmPackage.IFTE__THEN_CB:
				if (resolve) return getThenCb();
				return basicGetThenCb();
			case EmftvmPackage.IFTE__ELSE_CB:
				if (resolve) return getElseCb();
				return basicGetElseCb();
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
			case EmftvmPackage.IFTE__THEN_CB_INDEX:
				setThenCbIndex((Integer)newValue);
				return;
			case EmftvmPackage.IFTE__ELSE_CB_INDEX:
				setElseCbIndex((Integer)newValue);
				return;
			case EmftvmPackage.IFTE__THEN_CB:
				setThenCb((CodeBlock)newValue);
				return;
			case EmftvmPackage.IFTE__ELSE_CB:
				setElseCb((CodeBlock)newValue);
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
			case EmftvmPackage.IFTE__THEN_CB_INDEX:
				setThenCbIndex(THEN_CB_INDEX_EDEFAULT);
				return;
			case EmftvmPackage.IFTE__ELSE_CB_INDEX:
				setElseCbIndex(ELSE_CB_INDEX_EDEFAULT);
				return;
			case EmftvmPackage.IFTE__THEN_CB:
				setThenCb((CodeBlock)null);
				return;
			case EmftvmPackage.IFTE__ELSE_CB:
				setElseCb((CodeBlock)null);
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
			case EmftvmPackage.IFTE__THEN_CB_INDEX:
				return getThenCbIndex() != THEN_CB_INDEX_EDEFAULT;
			case EmftvmPackage.IFTE__ELSE_CB_INDEX:
				return getElseCbIndex() != ELSE_CB_INDEX_EDEFAULT;
			case EmftvmPackage.IFTE__THEN_CB:
				return basicGetThenCb() != null;
			case EmftvmPackage.IFTE__ELSE_CB:
				return basicGetElseCb() != null;
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
		result.append(getThenCbIndex());
		result.append(", ");
		result.append(getElseCbIndex());
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.impl.InstructionImpl#getStackProduction()
	 */
	@Override
	public int getStackProduction() {
		// TODO Auto-generated method stub
		return super.getStackProduction();
	}

} //IfteImpl
