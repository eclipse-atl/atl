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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.SourceElementList;
import org.eclipse.m2m.atl.emftvm.trace.TraceFactory;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkSetImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkSetImpl#getDefaultSourceElements <em>Default Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkSetImpl#getDefaultSourceElementLists <em>Default Source Element Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceLinkSetImpl extends EObjectImpl implements TraceLinkSet {

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedRule> rules;

	/**
	 * The cached value of the '{@link #getDefaultSourceElements() <em>Default Source Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceElement> defaultSourceElements;

	/**
	 * The cached value of the '{@link #getDefaultSourceElementLists() <em>Default Source Element Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSourceElementLists()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceElementList> defaultSourceElementLists;

	/**
	 * Lookup table of referred objects to {@link SourceElement}s.
	 */
	protected final Map<EObject, SourceElement> defaultSourceObjects = new HashMap<EObject, SourceElement>();

	/**
	 * Lookup table of referred objects to {@link SourceElementList}s.
	 */
	protected final Map<List<EObject>, SourceElementList> defaultSourceObjectLists = new HashMap<List<EObject>, SourceElementList>();

	/**
	 * Lookup table of traced rules by name.
	 */
	protected final Map<String, TracedRule> linksByRuleName = new HashMap<String, TracedRule>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceLinkSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE_LINK_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentWithInverseEList<TracedRule>(TracedRule.class, this, TracePackage.TRACE_LINK_SET__RULES, TracePackage.TRACED_RULE__LINK_SET);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceElement> getDefaultSourceElements() {
		if (defaultSourceElements == null) {
			defaultSourceElements = new EObjectWithInverseResolvingEList<SourceElement>(SourceElement.class, this, TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS, TracePackage.SOURCE_ELEMENT__DEFAULT_FOR);
		}
		return defaultSourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceElementList> getDefaultSourceElementLists() {
		if (defaultSourceElementLists == null) {
			defaultSourceElementLists = new EObjectContainmentWithInverseEList<SourceElementList>(SourceElementList.class, this, TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS, TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR);
		}
		return defaultSourceElementLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SourceElement getDefaultSourceElement(final EObject sourceElement) {
		return defaultSourceObjects.get(sourceElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SourceElementList getDefaultSourceElements(final List<?> sourceElements) {
		return defaultSourceObjectLists.get(sourceElements);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TracedRule getLinksByRule(final String rule, final boolean create) {
		if (linksByRuleName.containsKey(rule)) {
			return linksByRuleName.get(rule);
		} else if (create) {
			final TracedRule tr = TraceFactory.eINSTANCE.createTracedRule();
			tr.setRule(rule);
			getRules().add(tr);
			return tr;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clear() {
		getDefaultSourceElements().clear();
		getDefaultSourceElementLists().clear();
		defaultSourceObjects.clear();
		defaultSourceObjectLists.clear();
		linksByRuleName.clear();
		getRules().clear();
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
			case TracePackage.TRACE_LINK_SET__RULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRules()).basicAdd(otherEnd, msgs);
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDefaultSourceElements()).basicAdd(otherEnd, msgs);
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDefaultSourceElementLists()).basicAdd(otherEnd, msgs);
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
			case TracePackage.TRACE_LINK_SET__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS:
				return ((InternalEList<?>)getDefaultSourceElements()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS:
				return ((InternalEList<?>)getDefaultSourceElementLists()).basicRemove(otherEnd, msgs);
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
			case TracePackage.TRACE_LINK_SET__RULES:
				return getRules();
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS:
				return getDefaultSourceElements();
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS:
				return getDefaultSourceElementLists();
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
			case TracePackage.TRACE_LINK_SET__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends TracedRule>)newValue);
				return;
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS:
				getDefaultSourceElements().clear();
				getDefaultSourceElements().addAll((Collection<? extends SourceElement>)newValue);
				return;
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS:
				getDefaultSourceElementLists().clear();
				getDefaultSourceElementLists().addAll((Collection<? extends SourceElementList>)newValue);
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
			case TracePackage.TRACE_LINK_SET__RULES:
				getRules().clear();
				return;
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS:
				getDefaultSourceElements().clear();
				return;
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS:
				getDefaultSourceElementLists().clear();
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
			case TracePackage.TRACE_LINK_SET__RULES:
				return rules != null && !rules.isEmpty();
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS:
				return defaultSourceElements != null && !defaultSourceElements.isEmpty();
			case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS:
				return defaultSourceElementLists != null && !defaultSourceElementLists.isEmpty();
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

		StringBuffer result = new StringBuffer("TraceLinkSet [");
		boolean notFirst = false;
		for (TracedRule tr : getRules()) {
			if (notFirst) {
				result.append(", ");
			}
			result.append(tr.toString());
			notFirst = true;
		}
		result.append(']');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotificationRequired()
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		switch (notification.getFeatureID(null)) {
		case TracePackage.TRACE_LINK_SET__RULES:
			switch (notification.getEventType()) {
			case Notification.ADD:
				tracedRuleAdded((TracedRule) notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				for (TracedRule tr : ((Collection<? extends TracedRule>) notification.getNewValue())) {
					tracedRuleAdded(tr);
				}
				break;
			case Notification.REMOVE:
				tracedRuleRemoved((TracedRule) notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				for (TracedRule tr : ((Collection<? extends TracedRule>) notification.getOldValue())) {
					tracedRuleRemoved(tr);
				}
				break;
			}
			break;
		case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS:	
			switch (notification.getEventType()) {
			case Notification.ADD:
				defaultSourceElementAdded((SourceElement) notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				for (SourceElement se : ((Collection<? extends SourceElement>) notification.getNewValue())) {
					defaultSourceElementAdded(se);
				}
				break;
			case Notification.REMOVE:
				defaultSourceElementRemoved((SourceElement) notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				for (SourceElement se : ((Collection<? extends SourceElement>) notification.getOldValue())) {
					defaultSourceElementRemoved(se);
				}
				break;
			}
			break;
		case TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS:	
			switch (notification.getEventType()) {
			case Notification.ADD:
				defaultSourceElementListAdded((SourceElementList) notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				for (SourceElementList sel : ((Collection<? extends SourceElementList>) notification.getNewValue())) {
					defaultSourceElementListAdded(sel);
				}
				break;
			case Notification.REMOVE:
				defaultSourceElementListRemoved((SourceElementList) notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				for (SourceElementList sel : ((Collection<? extends SourceElementList>) notification.getOldValue())) {
					defaultSourceElementListRemoved(sel);
				}
				break;
			}
			break;
		}
	}

	/**
	 * Updates {@link #linksByRuleName} for <code>tr</code>.
	 * @param tr
	 */
	private void tracedRuleAdded(final TracedRule tr) {
		final String rule = tr.getRule();
		if (linksByRuleName.containsKey(rule)) {
			throw new IllegalArgumentException(String.format(
					"Traced rule with name %s already exists", rule));
		}
		linksByRuleName.put(rule, tr);
	}

	/**
	 * Updates {@link #linksByRuleName} for <code>tr</code>.
	 * @param tr
	 */
	private void tracedRuleRemoved(final TracedRule tr) {
		linksByRuleName.remove(tr.getRule());
	}

	/**
	 * Updates {@link #defaultSourceObjects} for <code>se</code>.
	 * @param se
	 */
	private void defaultSourceElementAdded(final SourceElement se) {
		final EObject object = se.getObject();
		if (defaultSourceObjects.containsKey(object)) {
			final SourceElement eSe = defaultSourceObjects.get(object);
			throw new IllegalArgumentException(String.format(
					"Default trace already exists for source element %s::%s: %s::%s", 
					se.getSourceOf().getRule(), se, 
					eSe.getSourceOf().getRule(), eSe));
		}
		defaultSourceObjects.put(object, se);
	}

	/**
	 * Updates {@link #defaultSourceObjects} for <code>sel</code>.
	 * @param se
	 */
	private void defaultSourceElementRemoved(final SourceElement se) {
		defaultSourceObjects.remove(se.getObject());
	}

	/**
	 * Updates {@link #defaultSourceObjectLists} for <code>sel</code>.
	 * @param sel
	 */
	private void defaultSourceElementListAdded(final SourceElementList sel) {
		final List<EObject> objects = sel.getSourceObjects();
		if (defaultSourceObjectLists.containsKey(objects)) {
			assert !sel.getSourceElements().isEmpty();
			final TracedRule selRule = sel.getSourceElements().get(0).getSourceOf().getRule();
			final SourceElementList eSel = defaultSourceObjectLists.get(objects);
			assert !eSel.getSourceElements().isEmpty();
			final TracedRule eSelRule = eSel.getSourceElements().get(0).getSourceOf().getRule();
			throw new IllegalArgumentException(String.format(
					"Default trace already exists for source element list %s::%s: %s::%s", 
					selRule, sel, eSelRule, eSel));
		}
		defaultSourceObjectLists.put(objects, sel);
	}

	/**
	 * Updates {@link #defaultSourceObjectLists} for <code>sel</code>.
	 * @param sel
	 */
	private void defaultSourceElementListRemoved(final SourceElementList sel) {
		defaultSourceObjectLists.remove(sel.getSourceObjects());
	}

} //TraceLinkSetImpl
