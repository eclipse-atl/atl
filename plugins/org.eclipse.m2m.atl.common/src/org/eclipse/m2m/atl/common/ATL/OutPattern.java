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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Out Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getDropPattern <em>Drop Pattern</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPattern()
 * @model kind="class"
 * @generated
 */
public class OutPattern extends LocatedElement {
	/**
	 * The cached value of the '{@link #getDropPattern() <em>Drop Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDropPattern()
	 * @generated
	 * @ordered
	 */
	protected DropPattern dropPattern;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<OutPatternElement> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutPattern() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ATLPackage.Literals.OUT_PATTERN;
	}

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.Rule#getOutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(Rule)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPattern_Rule()
	 * @see org.eclipse.m2m.atl.common.ATL.Rule#getOutPattern
	 * @model opposite="outPattern" required="true" transient="false" ordered="false"
	 * @generated
	 */
	public Rule getRule() {
		if (eContainerFeatureID() != ATLPackage.OUT_PATTERN__RULE) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRule(Rule newRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRule, ATLPackage.OUT_PATTERN__RULE, msgs);
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	public void setRule(Rule newRule) {
		if (newRule != eInternalContainer() || (eContainerFeatureID() != ATLPackage.OUT_PATTERN__RULE && newRule != null)) {
			if (EcoreUtil.isAncestor(this, newRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRule != null)
				msgs = ((InternalEObject)newRule).eInverseAdd(this, ATLPackage.RULE__OUT_PATTERN, Rule.class, msgs);
			msgs = basicSetRule(newRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.OUT_PATTERN__RULE, newRule, newRule));
	}

	/**
	 * Returns the value of the '<em><b>Drop Pattern</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.DropPattern#getOutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drop Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drop Pattern</em>' containment reference.
	 * @see #setDropPattern(DropPattern)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPattern_DropPattern()
	 * @see org.eclipse.m2m.atl.common.ATL.DropPattern#getOutPattern
	 * @model opposite="outPattern" containment="true" ordered="false"
	 * @generated
	 */
	public DropPattern getDropPattern() {
		return dropPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDropPattern(DropPattern newDropPattern, NotificationChain msgs) {
		DropPattern oldDropPattern = dropPattern;
		dropPattern = newDropPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ATLPackage.OUT_PATTERN__DROP_PATTERN, oldDropPattern, newDropPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getDropPattern <em>Drop Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drop Pattern</em>' containment reference.
	 * @see #getDropPattern()
	 * @generated
	 */
	public void setDropPattern(DropPattern newDropPattern) {
		if (newDropPattern != dropPattern) {
			NotificationChain msgs = null;
			if (dropPattern != null)
				msgs = ((InternalEObject)dropPattern).eInverseRemove(this, ATLPackage.DROP_PATTERN__OUT_PATTERN, DropPattern.class, msgs);
			if (newDropPattern != null)
				msgs = ((InternalEObject)newDropPattern).eInverseAdd(this, ATLPackage.DROP_PATTERN__OUT_PATTERN, DropPattern.class, msgs);
			msgs = basicSetDropPattern(newDropPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.OUT_PATTERN__DROP_PATTERN, newDropPattern, newDropPattern));
	}

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.ATL.OutPatternElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getOutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPattern_Elements()
	 * @see org.eclipse.m2m.atl.common.ATL.OutPatternElement#getOutPattern
	 * @model opposite="outPattern" containment="true" required="true"
	 * @generated
	 */
	public EList<OutPatternElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<OutPatternElement>(OutPatternElement.class, this, ATLPackage.OUT_PATTERN__ELEMENTS, ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN);
		}
		return elements;
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
			case ATLPackage.OUT_PATTERN__RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRule((Rule)otherEnd, msgs);
			case ATLPackage.OUT_PATTERN__DROP_PATTERN:
				if (dropPattern != null)
					msgs = ((InternalEObject)dropPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ATLPackage.OUT_PATTERN__DROP_PATTERN, null, msgs);
				return basicSetDropPattern((DropPattern)otherEnd, msgs);
			case ATLPackage.OUT_PATTERN__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
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
			case ATLPackage.OUT_PATTERN__RULE:
				return basicSetRule(null, msgs);
			case ATLPackage.OUT_PATTERN__DROP_PATTERN:
				return basicSetDropPattern(null, msgs);
			case ATLPackage.OUT_PATTERN__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case ATLPackage.OUT_PATTERN__RULE:
				return eInternalContainer().eInverseRemove(this, ATLPackage.RULE__OUT_PATTERN, Rule.class, msgs);
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
			case ATLPackage.OUT_PATTERN__RULE:
				return getRule();
			case ATLPackage.OUT_PATTERN__DROP_PATTERN:
				return getDropPattern();
			case ATLPackage.OUT_PATTERN__ELEMENTS:
				return getElements();
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
			case ATLPackage.OUT_PATTERN__RULE:
				setRule((Rule)newValue);
				return;
			case ATLPackage.OUT_PATTERN__DROP_PATTERN:
				setDropPattern((DropPattern)newValue);
				return;
			case ATLPackage.OUT_PATTERN__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends OutPatternElement>)newValue);
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
			case ATLPackage.OUT_PATTERN__RULE:
				setRule((Rule)null);
				return;
			case ATLPackage.OUT_PATTERN__DROP_PATTERN:
				setDropPattern((DropPattern)null);
				return;
			case ATLPackage.OUT_PATTERN__ELEMENTS:
				getElements().clear();
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
			case ATLPackage.OUT_PATTERN__RULE:
				return getRule() != null;
			case ATLPackage.OUT_PATTERN__DROP_PATTERN:
				return dropPattern != null;
			case ATLPackage.OUT_PATTERN__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // OutPattern
