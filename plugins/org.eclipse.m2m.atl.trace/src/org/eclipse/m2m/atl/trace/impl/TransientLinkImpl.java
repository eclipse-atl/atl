/**
 * Copyright (C) 2009, Vrije Universiteit Brussel, Universidad de los Andes
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Andres Yie (Vrije Universiteit Brussel, Universidad de los Andes)
 * 	Dennis Wagelaar (Vrije Universiteit Brussel)
 *
 * $Id: TransientLinkImpl.java,v 1.1.2.2 2009/03/12 11:57:43 dwagelaar Exp $
 */
package org.eclipse.m2m.atl.trace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.atl.trace.TracePackage;
import org.eclipse.m2m.atl.trace.TransientElement;
import org.eclipse.m2m.atl.trace.TransientLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transient Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.trace.impl.TransientLinkImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.trace.impl.TransientLinkImpl#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.trace.impl.TransientLinkImpl#getTargetElements <em>Target Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransientLinkImpl extends EObjectImpl implements TransientLink {
	/**
	 * The default value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected String rule = RULE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TransientElement> sourceElements;

	/**
	 * The cached value of the '{@link #getTargetElements() <em>Target Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TransientElement> targetElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransientLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRANSIENT_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(String newRule) {
		String oldRule = rule;
		rule = newRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRANSIENT_LINK__RULE, oldRule, rule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransientElement> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<TransientElement>(TransientElement.class, this, TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransientElement> getTargetElements() {
		if (targetElements == null) {
			targetElements = new EObjectContainmentEList<TransientElement>(TransientElement.class, this, TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS);
		}
		return targetElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				return ((InternalEList<?>)getSourceElements()).basicRemove(otherEnd, msgs);
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				return ((InternalEList<?>)getTargetElements()).basicRemove(otherEnd, msgs);
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
			case TracePackage.TRANSIENT_LINK__RULE:
				return getRule();
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				return getSourceElements();
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				return getTargetElements();
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
			case TracePackage.TRANSIENT_LINK__RULE:
				setRule((String)newValue);
				return;
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends TransientElement>)newValue);
				return;
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				getTargetElements().clear();
				getTargetElements().addAll((Collection<? extends TransientElement>)newValue);
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
			case TracePackage.TRANSIENT_LINK__RULE:
				setRule(RULE_EDEFAULT);
				return;
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				getSourceElements().clear();
				return;
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				getTargetElements().clear();
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
			case TracePackage.TRANSIENT_LINK__RULE:
				return RULE_EDEFAULT == null ? rule != null : !RULE_EDEFAULT.equals(rule);
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				return targetElements != null && !targetElements.isEmpty();
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
		result.append(" (rule: ");
		result.append(rule);
		result.append(')');
		return result.toString();
	}

} //TransientLinkImpl
