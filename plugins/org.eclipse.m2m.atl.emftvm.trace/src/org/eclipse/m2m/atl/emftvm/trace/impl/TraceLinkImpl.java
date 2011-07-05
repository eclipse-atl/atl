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
import java.util.Map;

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
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.TargetElement;
import org.eclipse.m2m.atl.emftvm.trace.TraceFactory;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkImpl#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkImpl#getTargetElements <em>Target Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkImpl#isOverridden <em>Overridden</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceLinkImpl extends EObjectImpl implements TraceLink {
	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceElement> sourceElements;

	/**
	 * The cached value of the '{@link #getTargetElements() <em>Target Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetElement> targetElements;

	/**
	 * The default value of the '{@link #isOverridden() <em>Overridden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverridden()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERRIDDEN_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isOverridden() <em>Overridden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverridden()
	 * @generated
	 * @ordered
	 */
	protected boolean overridden = OVERRIDDEN_EDEFAULT;

	/**
	 * Lookup table of {@link SourceElement}s by name.
	 */
	protected final Map<String, SourceElement> sourceElementsByName = new HashMap<String, SourceElement>();

	/**
	 * Lookup table of {@link TargetElement}s by name.
	 */
	protected final Map<String, TargetElement> targetElementsByName = new HashMap<String, TargetElement>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedRule getRule() {
		if (eContainerFeatureID() != TracePackage.TRACE_LINK__RULE) return null;
		return (TracedRule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRule(TracedRule newRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRule, TracePackage.TRACE_LINK__RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(TracedRule newRule) {
		if (newRule != eInternalContainer() || (eContainerFeatureID() != TracePackage.TRACE_LINK__RULE && newRule != null)) {
			if (EcoreUtil.isAncestor(this, newRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRule != null)
				msgs = ((InternalEObject)newRule).eInverseAdd(this, TracePackage.TRACED_RULE__LINKS, TracedRule.class, msgs);
			msgs = basicSetRule(newRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_LINK__RULE, newRule, newRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverridden() {
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverridden(boolean newOverridden) {
		boolean oldOverridden = overridden;
		overridden = newOverridden;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_LINK__OVERRIDDEN, oldOverridden, overridden));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SourceElement getSourceElement(String name, boolean create) {
		if (sourceElementsByName.containsKey(name)) {
			return sourceElementsByName.get(name);
		} else if (create) {
			final SourceElement se = TraceFactory.eINSTANCE.createSourceElement();
			se.setName(name);
			getSourceElements().add(se);
			return se;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceElement> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentWithInverseEList<SourceElement>(SourceElement.class, this, TracePackage.TRACE_LINK__SOURCE_ELEMENTS, TracePackage.SOURCE_ELEMENT__SOURCE_OF);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetElement> getTargetElements() {
		if (targetElements == null) {
			targetElements = new EObjectContainmentWithInverseEList<TargetElement>(TargetElement.class, this, TracePackage.TRACE_LINK__TARGET_ELEMENTS, TracePackage.TARGET_ELEMENT__TARGET_OF);
		}
		return targetElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TargetElement getTargetElement(String name) {
		return targetElementsByName.get(name);
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
			case TracePackage.TRACE_LINK__SOURCE_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceElements()).basicAdd(otherEnd, msgs);
			case TracePackage.TRACE_LINK__TARGET_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetElements()).basicAdd(otherEnd, msgs);
			case TracePackage.TRACE_LINK__RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRule((TracedRule)otherEnd, msgs);
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
			case TracePackage.TRACE_LINK__SOURCE_ELEMENTS:
				return ((InternalEList<?>)getSourceElements()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_LINK__TARGET_ELEMENTS:
				return ((InternalEList<?>)getTargetElements()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_LINK__RULE:
				return basicSetRule(null, msgs);
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
			case TracePackage.TRACE_LINK__RULE:
				return eInternalContainer().eInverseRemove(this, TracePackage.TRACED_RULE__LINKS, TracedRule.class, msgs);
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
			case TracePackage.TRACE_LINK__SOURCE_ELEMENTS:
				return getSourceElements();
			case TracePackage.TRACE_LINK__TARGET_ELEMENTS:
				return getTargetElements();
			case TracePackage.TRACE_LINK__RULE:
				return getRule();
			case TracePackage.TRACE_LINK__OVERRIDDEN:
				return isOverridden();
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
			case TracePackage.TRACE_LINK__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends SourceElement>)newValue);
				return;
			case TracePackage.TRACE_LINK__TARGET_ELEMENTS:
				getTargetElements().clear();
				getTargetElements().addAll((Collection<? extends TargetElement>)newValue);
				return;
			case TracePackage.TRACE_LINK__RULE:
				setRule((TracedRule)newValue);
				return;
			case TracePackage.TRACE_LINK__OVERRIDDEN:
				setOverridden((Boolean)newValue);
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
			case TracePackage.TRACE_LINK__SOURCE_ELEMENTS:
				getSourceElements().clear();
				return;
			case TracePackage.TRACE_LINK__TARGET_ELEMENTS:
				getTargetElements().clear();
				return;
			case TracePackage.TRACE_LINK__RULE:
				setRule((TracedRule)null);
				return;
			case TracePackage.TRACE_LINK__OVERRIDDEN:
				setOverridden(OVERRIDDEN_EDEFAULT);
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
			case TracePackage.TRACE_LINK__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
			case TracePackage.TRACE_LINK__TARGET_ELEMENTS:
				return targetElements != null && !targetElements.isEmpty();
			case TracePackage.TRACE_LINK__RULE:
				return getRule() != null;
			case TracePackage.TRACE_LINK__OVERRIDDEN:
				return overridden != OVERRIDDEN_EDEFAULT;
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

		StringBuffer result = new StringBuffer("TraceLink [[");
		boolean notFirst = false;
		for (SourceElement se : getSourceElements()) {
			if (notFirst) {
				result.append(", ");
			}
			result.append(se.toString());
			notFirst = true;
		}
		result.append("] -> [");
		notFirst = false;
		for (TargetElement te : getTargetElements()) {
			if (notFirst) {
				result.append(", ");
			}
			result.append(te.toString());
			notFirst = true;
		}
		result.append("]]");
		return result.toString();
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
		case TracePackage.TRACE_LINK__SOURCE_ELEMENTS:
			switch (notification.getEventType()) {
			case Notification.ADD:
				sourceElementAdded((SourceElement) notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				for (SourceElement se : ((Collection<? extends SourceElement>) notification.getNewValue())) {
					sourceElementAdded(se);
				}
				break;
			case Notification.REMOVE:
				sourceElementRemoved((SourceElement) notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				for (SourceElement se : ((Collection<? extends SourceElement>) notification.getOldValue())) {
					sourceElementRemoved(se);
				}
				break;
			}
			break;
		case TracePackage.TRACE_LINK__TARGET_ELEMENTS:
			switch (notification.getEventType()) {
			case Notification.ADD:
				targetElementAdded((TargetElement) notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				for (TargetElement te : ((Collection<? extends TargetElement>) notification.getNewValue())) {
					targetElementAdded(te);
				}
				break;
			case Notification.REMOVE:
				targetElementRemoved((TargetElement) notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				for (TargetElement te : ((Collection<? extends TargetElement>) notification.getOldValue())) {
					targetElementRemoved(te);
				}
				break;
			}
			break;
		}
	}

	private void sourceElementAdded(final SourceElement se) {
		final String seName = se.getName();
		if (sourceElementsByName.containsKey(seName)) {
			throw new IllegalArgumentException(String.format(
					"Trace link %s already contains a source element named %s", 
					this, seName));
		}
		sourceElementsByName.put(seName, se);
	}

	private void sourceElementRemoved(final SourceElement se) {
		sourceElementsByName.remove(se.getName());
	}

	private void targetElementAdded(final TargetElement te) {
		final String teName = te.getName();
		if (targetElementsByName.containsKey(teName)) {
			throw new IllegalArgumentException(String.format(
					"Trace link %s already contains a target element named %s", 
					this, teName));
		}
		targetElementsByName.put(teName, te);
	}

	private void targetElementRemoved(final TargetElement te) {
		targetElementsByName.remove(te.getName());
	}

} //TraceLinkImpl
