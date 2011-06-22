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


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.TargetElement;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TargetElementImpl#getTargetOf <em>Target Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.TargetElementImpl#getMapsTo <em>Maps To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetElementImpl extends TraceElementImpl implements TargetElement {
	/**
	 * The cached value of the '{@link #getMapsTo() <em>Maps To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapsTo()
	 * @generated
	 * @ordered
	 */
	protected SourceElement mapsTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TARGET_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLink getTargetOf() {
		if (eContainerFeatureID() != TracePackage.TARGET_ELEMENT__TARGET_OF) return null;
		return (TraceLink)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetOf(TraceLink newTargetOf, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTargetOf, TracePackage.TARGET_ELEMENT__TARGET_OF, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetOf(TraceLink newTargetOf) {
		if (newTargetOf != eInternalContainer() || (eContainerFeatureID() != TracePackage.TARGET_ELEMENT__TARGET_OF && newTargetOf != null)) {
			if (EcoreUtil.isAncestor(this, newTargetOf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTargetOf != null)
				msgs = ((InternalEObject)newTargetOf).eInverseAdd(this, TracePackage.TRACE_LINK__TARGET_ELEMENTS, TraceLink.class, msgs);
			msgs = basicSetTargetOf(newTargetOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TARGET_ELEMENT__TARGET_OF, newTargetOf, newTargetOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceElement getMapsTo() {
		if (mapsTo != null && mapsTo.eIsProxy()) {
			InternalEObject oldMapsTo = (InternalEObject)mapsTo;
			mapsTo = (SourceElement)eResolveProxy(oldMapsTo);
			if (mapsTo != oldMapsTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.TARGET_ELEMENT__MAPS_TO, oldMapsTo, mapsTo));
			}
		}
		return mapsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceElement basicGetMapsTo() {
		return mapsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapsTo(SourceElement newMapsTo, NotificationChain msgs) {
		SourceElement oldMapsTo = mapsTo;
		mapsTo = newMapsTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.TARGET_ELEMENT__MAPS_TO, oldMapsTo, newMapsTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapsTo(SourceElement newMapsTo) {
		if (newMapsTo != mapsTo) {
			NotificationChain msgs = null;
			if (mapsTo != null)
				msgs = ((InternalEObject)mapsTo).eInverseRemove(this, TracePackage.SOURCE_ELEMENT__MAPS_TO, SourceElement.class, msgs);
			if (newMapsTo != null)
				msgs = ((InternalEObject)newMapsTo).eInverseAdd(this, TracePackage.SOURCE_ELEMENT__MAPS_TO, SourceElement.class, msgs);
			msgs = basicSetMapsTo(newMapsTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TARGET_ELEMENT__MAPS_TO, newMapsTo, newMapsTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TARGET_ELEMENT__TARGET_OF:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTargetOf((TraceLink)otherEnd, msgs);
			case TracePackage.TARGET_ELEMENT__MAPS_TO:
				if (mapsTo != null)
					msgs = ((InternalEObject)mapsTo).eInverseRemove(this, TracePackage.SOURCE_ELEMENT__MAPS_TO, SourceElement.class, msgs);
				return basicSetMapsTo((SourceElement)otherEnd, msgs);
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
			case TracePackage.TARGET_ELEMENT__TARGET_OF:
				return basicSetTargetOf(null, msgs);
			case TracePackage.TARGET_ELEMENT__MAPS_TO:
				return basicSetMapsTo(null, msgs);
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
			case TracePackage.TARGET_ELEMENT__TARGET_OF:
				return eInternalContainer().eInverseRemove(this, TracePackage.TRACE_LINK__TARGET_ELEMENTS, TraceLink.class, msgs);
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
			case TracePackage.TARGET_ELEMENT__TARGET_OF:
				return getTargetOf();
			case TracePackage.TARGET_ELEMENT__MAPS_TO:
				if (resolve) return getMapsTo();
				return basicGetMapsTo();
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
			case TracePackage.TARGET_ELEMENT__TARGET_OF:
				setTargetOf((TraceLink)newValue);
				return;
			case TracePackage.TARGET_ELEMENT__MAPS_TO:
				setMapsTo((SourceElement)newValue);
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
			case TracePackage.TARGET_ELEMENT__TARGET_OF:
				setTargetOf((TraceLink)null);
				return;
			case TracePackage.TARGET_ELEMENT__MAPS_TO:
				setMapsTo((SourceElement)null);
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
			case TracePackage.TARGET_ELEMENT__TARGET_OF:
				return getTargetOf() != null;
			case TracePackage.TARGET_ELEMENT__MAPS_TO:
				return mapsTo != null;
		}
		return super.eIsSet(featureID);
	}

} //TargetElementImpl
