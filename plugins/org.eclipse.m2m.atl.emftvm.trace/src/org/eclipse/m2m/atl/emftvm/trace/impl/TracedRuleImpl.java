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
package org.eclipse.m2m.atl.emftvm.trace.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traced Rule</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl#getLinkSet <em>Link Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TracedRuleImpl extends EObjectImpl implements TracedRule {
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
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceLink> links;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACED_RULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACED_RULE__RULE, oldRule, rule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceLink> getLinks() {
		if (links == null) {
			links = new EObjectContainmentWithInverseEList<TraceLink>(TraceLink.class, this, TracePackage.TRACED_RULE__LINKS, TracePackage.TRACE_LINK__RULE);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLinkSet getLinkSet() {
		if (eContainerFeatureID() != TracePackage.TRACED_RULE__LINK_SET) return null;
		return (TraceLinkSet)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkSet(TraceLinkSet newLinkSet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLinkSet, TracePackage.TRACED_RULE__LINK_SET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkSet(TraceLinkSet newLinkSet) {
		if (newLinkSet != eInternalContainer() || (eContainerFeatureID() != TracePackage.TRACED_RULE__LINK_SET && newLinkSet != null)) {
			if (EcoreUtil.isAncestor(this, newLinkSet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLinkSet != null)
				msgs = ((InternalEObject)newLinkSet).eInverseAdd(this, TracePackage.TRACE_LINK_SET__RULES, TraceLinkSet.class, msgs);
			msgs = basicSetLinkSet(newLinkSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACED_RULE__LINK_SET, newLinkSet, newLinkSet));
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
			case TracePackage.TRACED_RULE__LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLinks()).basicAdd(otherEnd, msgs);
			case TracePackage.TRACED_RULE__LINK_SET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLinkSet((TraceLinkSet)otherEnd, msgs);
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
			case TracePackage.TRACED_RULE__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACED_RULE__LINK_SET:
				return basicSetLinkSet(null, msgs);
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
			case TracePackage.TRACED_RULE__LINK_SET:
				return eInternalContainer().eInverseRemove(this, TracePackage.TRACE_LINK_SET__RULES, TraceLinkSet.class, msgs);
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
			case TracePackage.TRACED_RULE__RULE:
				return getRule();
			case TracePackage.TRACED_RULE__LINKS:
				return getLinks();
			case TracePackage.TRACED_RULE__LINK_SET:
				return getLinkSet();
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
			case TracePackage.TRACED_RULE__RULE:
				setRule((String)newValue);
				return;
			case TracePackage.TRACED_RULE__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends TraceLink>)newValue);
				return;
			case TracePackage.TRACED_RULE__LINK_SET:
				setLinkSet((TraceLinkSet)newValue);
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
			case TracePackage.TRACED_RULE__RULE:
				setRule(RULE_EDEFAULT);
				return;
			case TracePackage.TRACED_RULE__LINKS:
				getLinks().clear();
				return;
			case TracePackage.TRACED_RULE__LINK_SET:
				setLinkSet((TraceLinkSet)null);
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
			case TracePackage.TRACED_RULE__RULE:
				return RULE_EDEFAULT == null ? rule != null : !RULE_EDEFAULT.equals(rule);
			case TracePackage.TRACED_RULE__LINKS:
				return links != null && !links.isEmpty();
			case TracePackage.TRACED_RULE__LINK_SET:
				return getLinkSet() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		return (rule == null) ? super.toString() : rule;
	}

} //TracedRuleImpl
