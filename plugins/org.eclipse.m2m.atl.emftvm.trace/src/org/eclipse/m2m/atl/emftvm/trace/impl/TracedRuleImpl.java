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
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.SourceElementList;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;
import org.eclipse.m2m.atl.emftvm.trace.util.IdentityHashList;

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
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl#getUniqueSourceElements <em>Unique Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl#getUniqueSourceElementLists <em>Unique Source Element Lists</em>}</li>
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
	 * The cached value of the '{@link #getUniqueSourceElements() <em>Unique Source Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceElement> uniqueSourceElements;

	/**
	 * The cached value of the '{@link #getUniqueSourceElementLists() <em>Unique Source Element Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueSourceElementLists()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceElementList> uniqueSourceElementLists;

	/**
	 * Lookup table of referred objects to {@link SourceElement}s.
	 */
	protected final Map<Object, SourceElement> uniqueSourceObjects = new IdentityHashMap<Object, SourceElement>();

	/**
	 * Lookup table of referred objects to {@link SourceElementList}s.
	 */
	protected final Map<IdentityHashList<Object>, SourceElementList> uniqueSourceObjectLists = new HashMap<IdentityHashList<Object>, SourceElementList>();

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
		return (TraceLinkSet)eInternalContainer();
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
	public EList<SourceElement> getUniqueSourceElements() {
		if (uniqueSourceElements == null) {
			uniqueSourceElements = new EObjectWithInverseResolvingEList<SourceElement>(SourceElement.class, this, TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS, TracePackage.SOURCE_ELEMENT__UNIQUE_FOR);
		}
		return uniqueSourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceElementList> getUniqueSourceElementLists() {
		if (uniqueSourceElementLists == null) {
			uniqueSourceElementLists = new EObjectContainmentWithInverseEList<SourceElementList>(SourceElementList.class, this, TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS, TracePackage.SOURCE_ELEMENT_LIST__UNIQUE_FOR);
		}
		return uniqueSourceElementLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SourceElement getUniqueSourceElement(Object sourceElement) {
		return uniqueSourceObjects.get(sourceElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SourceElementList getUniqueSourceElements(List<?> sourceElements) {
		return uniqueSourceObjectLists.get(sourceElements);
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
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUniqueSourceElements()).basicAdd(otherEnd, msgs);
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUniqueSourceElementLists()).basicAdd(otherEnd, msgs);
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
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS:
				return ((InternalEList<?>)getUniqueSourceElements()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS:
				return ((InternalEList<?>)getUniqueSourceElementLists()).basicRemove(otherEnd, msgs);
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
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS:
				return getUniqueSourceElements();
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS:
				return getUniqueSourceElementLists();
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
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS:
				getUniqueSourceElements().clear();
				getUniqueSourceElements().addAll((Collection<? extends SourceElement>)newValue);
				return;
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS:
				getUniqueSourceElementLists().clear();
				getUniqueSourceElementLists().addAll((Collection<? extends SourceElementList>)newValue);
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
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS:
				getUniqueSourceElements().clear();
				return;
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS:
				getUniqueSourceElementLists().clear();
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
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS:
				return uniqueSourceElements != null && !uniqueSourceElements.isEmpty();
			case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS:
				return uniqueSourceElementLists != null && !uniqueSourceElementLists.isEmpty();
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		switch (notification.getFeatureID(null)) {
		case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS:	
			switch (notification.getEventType()) {
			case Notification.ADD:
				uniqueSourceElementAdded((SourceElement) notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				for (SourceElement se : ((Collection<? extends SourceElement>) notification.getNewValue())) {
					uniqueSourceElementAdded(se);
				}
				break;
			case Notification.REMOVE:
				uniqueSourceElementRemoved((SourceElement) notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				for (SourceElement se : ((Collection<? extends SourceElement>) notification.getOldValue())) {
					uniqueSourceElementRemoved(se);
				}
				break;
			}
			break;
		case TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS:	
			switch (notification.getEventType()) {
			case Notification.ADD:
				uniqueSourceElementListAdded((SourceElementList) notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				for (SourceElementList sel : ((Collection<? extends SourceElementList>) notification.getNewValue())) {
					uniqueSourceElementListAdded(sel);
				}
				break;
			case Notification.REMOVE:
				uniqueSourceElementListRemoved((SourceElementList) notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				for (SourceElementList sel : ((Collection<? extends SourceElementList>) notification.getOldValue())) {
					uniqueSourceElementListRemoved(sel);
				}
				break;
			}
			break;
		}
	}

	/**
	 * Updates {@link #uniqueSourceObjects} for <code>se</code>.
	 * @param se
	 */
	private void uniqueSourceElementAdded(final SourceElement se) {
		final Object object = se.getRuntimeObject();
		final SourceElement eSe = uniqueSourceObjects.put(object, se);
		if (eSe != null) {
			throw new IllegalArgumentException(String.format(
					"Unique trace already exists for source element %s::%s: %s::%s", 
					se.getSourceOf().getRule(), se, 
					eSe.getSourceOf().getRule(), eSe));
		}
	}

	/**
	 * Updates {@link #uniqueSourceObjects} for <code>sel</code>.
	 * @param se
	 */
	private void uniqueSourceElementRemoved(final SourceElement se) {
		uniqueSourceObjects.remove(se.getRuntimeObject());
	}

	/**
	 * Updates {@link #uniqueSourceObjectLists} for <code>sel</code>.
	 * @param sel
	 */
	private void uniqueSourceElementListAdded(final SourceElementList sel) {
		final List<Object> objects = sel.getSourceObjects();
		final SourceElementList eSel = uniqueSourceObjectLists.put(new IdentityHashList<Object>(objects), sel);
		if (eSel != null) {
			assert !sel.getSourceElements().isEmpty();
			final TracedRule selRule = sel.getSourceElements().get(0).getSourceOf().getRule();
			assert !eSel.getSourceElements().isEmpty();
			final TracedRule eSelRule = eSel.getSourceElements().get(0).getSourceOf().getRule();
			throw new IllegalArgumentException(String.format(
					"Unique trace already exists for source element list %s::%s: %s::%s", 
					selRule, sel, eSelRule, eSel));
		}
	}

	/**
	 * Updates {@link #uniqueSourceObjectLists} for <code>sel</code>.
	 * @param sel
	 */
	private void uniqueSourceElementListRemoved(final SourceElementList sel) {
		uniqueSourceObjectLists.remove(new IdentityHashList<Object>(sel.getSourceObjects()));
	}

} //TracedRuleImpl
