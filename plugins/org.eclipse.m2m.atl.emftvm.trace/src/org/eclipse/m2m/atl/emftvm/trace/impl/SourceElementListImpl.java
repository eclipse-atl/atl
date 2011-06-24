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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.SourceElementList;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Element List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementListImpl#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementListImpl#getDefaultFor <em>Default For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceElementListImpl extends EObjectImpl implements SourceElementList {
	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceElement> sourceElements;

	/**
	 * Cached list of source element objects.
	 */
	protected final EList<EObject> sourceObjects = new BasicEList<EObject>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceElementListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.SOURCE_ELEMENT_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceElement> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectResolvingEList<SourceElement>(SourceElement.class, this, TracePackage.SOURCE_ELEMENT_LIST__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLinkSet getDefaultFor() {
		if (eContainerFeatureID() != TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR) return null;
		return (TraceLinkSet)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultFor(TraceLinkSet newDefaultFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDefaultFor, TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultFor(TraceLinkSet newDefaultFor) {
		if (newDefaultFor != eInternalContainer() || (eContainerFeatureID() != TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR && newDefaultFor != null)) {
			if (EcoreUtil.isAncestor(this, newDefaultFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDefaultFor != null)
				msgs = ((InternalEObject)newDefaultFor).eInverseAdd(this, TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS, TraceLinkSet.class, msgs);
			msgs = basicSetDefaultFor(newDefaultFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR, newDefaultFor, newDefaultFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EObject> getSourceObjects() {
		return ECollections.unmodifiableEList(sourceObjects);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDefaultFor((TraceLinkSet)otherEnd, msgs);
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
			case TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR:
				return basicSetDefaultFor(null, msgs);
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
			case TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR:
				return eInternalContainer().eInverseRemove(this, TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS, TraceLinkSet.class, msgs);
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
			case TracePackage.SOURCE_ELEMENT_LIST__SOURCE_ELEMENTS:
				return getSourceElements();
			case TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR:
				return getDefaultFor();
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
			case TracePackage.SOURCE_ELEMENT_LIST__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends SourceElement>)newValue);
				return;
			case TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR:
				setDefaultFor((TraceLinkSet)newValue);
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
			case TracePackage.SOURCE_ELEMENT_LIST__SOURCE_ELEMENTS:
				getSourceElements().clear();
				return;
			case TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR:
				setDefaultFor((TraceLinkSet)null);
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
			case TracePackage.SOURCE_ELEMENT_LIST__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
			case TracePackage.SOURCE_ELEMENT_LIST__DEFAULT_FOR:
				return getDefaultFor() != null;
		}
		return super.eIsSet(featureID);
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
		case TracePackage.SOURCE_ELEMENT_LIST__SOURCE_ELEMENTS:
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
		}
	}

	/**
	 * Updates {@link #sourceObjects} for <code>se</code>.
	 * @param se
	 */
	private void sourceElementAdded(final SourceElement se) {
		sourceObjects.add(se.getObject());
	}

	/**
	 * Updates {@link #sourceObjects} for <code>se</code>.
	 * @param se
	 */
	private void sourceElementRemoved(final SourceElement se) {
		sourceObjects.remove(se.getObject());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append('[');
		boolean notFirst = false;
		for (SourceElement se : getSourceElements()) {
			if (notFirst) {
				result.append(", ");
			}
			result.append(se.toString());
			notFirst = true;
		}
		result.append(']');
		return result.toString();
	}

} //SourceElementListImpl
