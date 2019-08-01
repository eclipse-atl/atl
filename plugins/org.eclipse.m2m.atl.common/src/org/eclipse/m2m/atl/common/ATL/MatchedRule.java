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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matched Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getInPattern <em>In Pattern</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getSuperRule <em>Super Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsRefining <em>Is Refining</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsNoDefault <em>Is No Default</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule()
 * @model kind="class"
 * @generated
 */
public class MatchedRule extends Rule {
	/**
	 * The cached value of the '{@link #getInPattern() <em>In Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInPattern()
	 * @generated
	 * @ordered
	 */
	protected InPattern inPattern;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<MatchedRule> children;

	/**
	 * The cached value of the '{@link #getSuperRule() <em>Super Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule superRule;

	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsRefining() <em>Is Refining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRefining()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REFINING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsRefining() <em>Is Refining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRefining()
	 * @generated
	 * @ordered
	 */
	protected boolean isRefining = IS_REFINING_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsNoDefault() <em>Is No Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNoDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NO_DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsNoDefault() <em>Is No Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNoDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean isNoDefault = IS_NO_DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchedRule() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ATLPackage.Literals.MATCHED_RULE;
	}

	/**
	 * Returns the value of the '<em><b>In Pattern</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.InPattern#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Pattern</em>' containment reference.
	 * @see #setInPattern(InPattern)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule_InPattern()
	 * @see org.eclipse.m2m.atl.common.ATL.InPattern#getRule
	 * @model opposite="rule" containment="true" ordered="false"
	 * @generated
	 */
	public InPattern getInPattern() {
		return inPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInPattern(InPattern newInPattern, NotificationChain msgs) {
		InPattern oldInPattern = inPattern;
		inPattern = newInPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ATLPackage.MATCHED_RULE__IN_PATTERN, oldInPattern, newInPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getInPattern <em>In Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Pattern</em>' containment reference.
	 * @see #getInPattern()
	 * @generated
	 */
	public void setInPattern(InPattern newInPattern) {
		if (newInPattern != inPattern) {
			NotificationChain msgs = null;
			if (inPattern != null)
				msgs = ((InternalEObject)inPattern).eInverseRemove(this, ATLPackage.IN_PATTERN__RULE, InPattern.class, msgs);
			if (newInPattern != null)
				msgs = ((InternalEObject)newInPattern).eInverseAdd(this, ATLPackage.IN_PATTERN__RULE, InPattern.class, msgs);
			msgs = basicSetInPattern(newInPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.MATCHED_RULE__IN_PATTERN, newInPattern, newInPattern));
	}

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.ATL.MatchedRule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getSuperRule <em>Super Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule_Children()
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule#getSuperRule
	 * @model opposite="superRule" ordered="false"
	 * @generated
	 */
	public EList<MatchedRule> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList<MatchedRule>(MatchedRule.class, this, ATLPackage.MATCHED_RULE__CHILDREN, ATLPackage.MATCHED_RULE__SUPER_RULE);
		}
		return children;
	}

	/**
	 * Returns the value of the '<em><b>Super Rule</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Rule</em>' reference.
	 * @see #setSuperRule(MatchedRule)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule_SuperRule()
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule#getChildren
	 * @model opposite="children" ordered="false"
	 * @generated
	 */
	public MatchedRule getSuperRule() {
		if (superRule != null && superRule.eIsProxy()) {
			InternalEObject oldSuperRule = (InternalEObject)superRule;
			superRule = (MatchedRule)eResolveProxy(oldSuperRule);
			if (superRule != oldSuperRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ATLPackage.MATCHED_RULE__SUPER_RULE, oldSuperRule, superRule));
			}
		}
		return superRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetSuperRule() {
		return superRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperRule(MatchedRule newSuperRule, NotificationChain msgs) {
		MatchedRule oldSuperRule = superRule;
		superRule = newSuperRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ATLPackage.MATCHED_RULE__SUPER_RULE, oldSuperRule, newSuperRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getSuperRule <em>Super Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Rule</em>' reference.
	 * @see #getSuperRule()
	 * @generated
	 */
	public void setSuperRule(MatchedRule newSuperRule) {
		if (newSuperRule != superRule) {
			NotificationChain msgs = null;
			if (superRule != null)
				msgs = ((InternalEObject)superRule).eInverseRemove(this, ATLPackage.MATCHED_RULE__CHILDREN, MatchedRule.class, msgs);
			if (newSuperRule != null)
				msgs = ((InternalEObject)newSuperRule).eInverseAdd(this, ATLPackage.MATCHED_RULE__CHILDREN, MatchedRule.class, msgs);
			msgs = basicSetSuperRule(newSuperRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.MATCHED_RULE__SUPER_RULE, newSuperRule, newSuperRule));
	}

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule_IsAbstract()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.MATCHED_RULE__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * Returns the value of the '<em><b>Is Refining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Refining</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Refining</em>' attribute.
	 * @see #setIsRefining(boolean)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule_IsRefining()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	public boolean isIsRefining() {
		return isRefining;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsRefining <em>Is Refining</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Refining</em>' attribute.
	 * @see #isIsRefining()
	 * @generated
	 */
	public void setIsRefining(boolean newIsRefining) {
		boolean oldIsRefining = isRefining;
		isRefining = newIsRefining;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.MATCHED_RULE__IS_REFINING, oldIsRefining, isRefining));
	}

	/**
	 * Returns the value of the '<em><b>Is No Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is No Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is No Default</em>' attribute.
	 * @see #setIsNoDefault(boolean)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule_IsNoDefault()
	 * @model unique="false" dataType="org.eclipse.m2m.atl.common.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	public boolean isIsNoDefault() {
		return isNoDefault;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsNoDefault <em>Is No Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is No Default</em>' attribute.
	 * @see #isIsNoDefault()
	 * @generated
	 */
	public void setIsNoDefault(boolean newIsNoDefault) {
		boolean oldIsNoDefault = isNoDefault;
		isNoDefault = newIsNoDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.MATCHED_RULE__IS_NO_DEFAULT, oldIsNoDefault, isNoDefault));
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
			case ATLPackage.MATCHED_RULE__IN_PATTERN:
				if (inPattern != null)
					msgs = ((InternalEObject)inPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ATLPackage.MATCHED_RULE__IN_PATTERN, null, msgs);
				return basicSetInPattern((InPattern)otherEnd, msgs);
			case ATLPackage.MATCHED_RULE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case ATLPackage.MATCHED_RULE__SUPER_RULE:
				if (superRule != null)
					msgs = ((InternalEObject)superRule).eInverseRemove(this, ATLPackage.MATCHED_RULE__CHILDREN, MatchedRule.class, msgs);
				return basicSetSuperRule((MatchedRule)otherEnd, msgs);
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
			case ATLPackage.MATCHED_RULE__IN_PATTERN:
				return basicSetInPattern(null, msgs);
			case ATLPackage.MATCHED_RULE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case ATLPackage.MATCHED_RULE__SUPER_RULE:
				return basicSetSuperRule(null, msgs);
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
			case ATLPackage.MATCHED_RULE__IN_PATTERN:
				return getInPattern();
			case ATLPackage.MATCHED_RULE__CHILDREN:
				return getChildren();
			case ATLPackage.MATCHED_RULE__SUPER_RULE:
				if (resolve) return getSuperRule();
				return basicGetSuperRule();
			case ATLPackage.MATCHED_RULE__IS_ABSTRACT:
				return isIsAbstract();
			case ATLPackage.MATCHED_RULE__IS_REFINING:
				return isIsRefining();
			case ATLPackage.MATCHED_RULE__IS_NO_DEFAULT:
				return isIsNoDefault();
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
			case ATLPackage.MATCHED_RULE__IN_PATTERN:
				setInPattern((InPattern)newValue);
				return;
			case ATLPackage.MATCHED_RULE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends MatchedRule>)newValue);
				return;
			case ATLPackage.MATCHED_RULE__SUPER_RULE:
				setSuperRule((MatchedRule)newValue);
				return;
			case ATLPackage.MATCHED_RULE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case ATLPackage.MATCHED_RULE__IS_REFINING:
				setIsRefining((Boolean)newValue);
				return;
			case ATLPackage.MATCHED_RULE__IS_NO_DEFAULT:
				setIsNoDefault((Boolean)newValue);
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
			case ATLPackage.MATCHED_RULE__IN_PATTERN:
				setInPattern((InPattern)null);
				return;
			case ATLPackage.MATCHED_RULE__CHILDREN:
				getChildren().clear();
				return;
			case ATLPackage.MATCHED_RULE__SUPER_RULE:
				setSuperRule((MatchedRule)null);
				return;
			case ATLPackage.MATCHED_RULE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case ATLPackage.MATCHED_RULE__IS_REFINING:
				setIsRefining(IS_REFINING_EDEFAULT);
				return;
			case ATLPackage.MATCHED_RULE__IS_NO_DEFAULT:
				setIsNoDefault(IS_NO_DEFAULT_EDEFAULT);
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
			case ATLPackage.MATCHED_RULE__IN_PATTERN:
				return inPattern != null;
			case ATLPackage.MATCHED_RULE__CHILDREN:
				return children != null && !children.isEmpty();
			case ATLPackage.MATCHED_RULE__SUPER_RULE:
				return superRule != null;
			case ATLPackage.MATCHED_RULE__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case ATLPackage.MATCHED_RULE__IS_REFINING:
				return isRefining != IS_REFINING_EDEFAULT;
			case ATLPackage.MATCHED_RULE__IS_NO_DEFAULT:
				return isNoDefault != IS_NO_DEFAULT_EDEFAULT;
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
		result.append(" (isAbstract: ");
		result.append(isAbstract);
		result.append(", isRefining: ");
		result.append(isRefining);
		result.append(", isNoDefault: ");
		result.append(isNoDefault);
		result.append(')');
		return result.toString();
	}

} // MatchedRule
