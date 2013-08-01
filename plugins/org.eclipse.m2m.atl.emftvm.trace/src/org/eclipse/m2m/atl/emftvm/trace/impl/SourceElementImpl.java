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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.TargetElement;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl#getSourceOf <em>Source Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl#getMapsTo <em>Maps To</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl#getDefaultFor <em>Default For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl#getUniqueFor <em>Unique For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl#isMapsToSelf <em>Maps To Self</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceElementImpl extends TraceElementImpl implements SourceElement {
	
	/**
	 * The cached value of the '{@link #getMapsTo() <em>Maps To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetElement> mapsTo;

	/**
	 * The cached value of the '{@link #getDefaultFor() <em>Default For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultFor()
	 * @generated
	 * @ordered
	 */
	protected TraceLinkSet defaultFor;

	/**
	 * The cached value of the '{@link #getUniqueFor() <em>Unique For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueFor()
	 * @generated
	 * @ordered
	 */
	protected TracedRule uniqueFor;

	/**
	 * The default value of the '{@link #isMapsToSelf() <em>Maps To Self</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMapsToSelf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAPS_TO_SELF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMapsToSelf() <em>Maps To Self</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMapsToSelf()
	 * @generated
	 * @ordered
	 */
	protected boolean mapsToSelf = MAPS_TO_SELF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLink getSourceOf() {
		if (eContainerFeatureID() != TracePackage.SOURCE_ELEMENT__SOURCE_OF) return null;
		return (TraceLink)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceOf(TraceLink newSourceOf, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourceOf, TracePackage.SOURCE_ELEMENT__SOURCE_OF, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceOf(TraceLink newSourceOf) {
		if (newSourceOf != eInternalContainer() || (eContainerFeatureID() != TracePackage.SOURCE_ELEMENT__SOURCE_OF && newSourceOf != null)) {
			if (EcoreUtil.isAncestor(this, newSourceOf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourceOf != null)
				msgs = ((InternalEObject)newSourceOf).eInverseAdd(this, TracePackage.TRACE_LINK__SOURCE_ELEMENTS, TraceLink.class, msgs);
			msgs = basicSetSourceOf(newSourceOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.SOURCE_ELEMENT__SOURCE_OF, newSourceOf, newSourceOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetElement> getMapsTo() {
		if (mapsTo == null) {
			mapsTo = new EObjectWithInverseResolvingEList.ManyInverse<TargetElement>(TargetElement.class, this, TracePackage.SOURCE_ELEMENT__MAPS_TO, TracePackage.TARGET_ELEMENT__MAPS_TO);
		}
		return mapsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLinkSet getDefaultFor() {
		if (defaultFor != null && defaultFor.eIsProxy()) {
			InternalEObject oldDefaultFor = (InternalEObject)defaultFor;
			defaultFor = (TraceLinkSet)eResolveProxy(oldDefaultFor);
			if (defaultFor != oldDefaultFor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.SOURCE_ELEMENT__DEFAULT_FOR, oldDefaultFor, defaultFor));
			}
		}
		return defaultFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLinkSet basicGetDefaultFor() {
		return defaultFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultFor(TraceLinkSet newDefaultFor, NotificationChain msgs) {
		TraceLinkSet oldDefaultFor = defaultFor;
		defaultFor = newDefaultFor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.SOURCE_ELEMENT__DEFAULT_FOR, oldDefaultFor, newDefaultFor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultFor(TraceLinkSet newDefaultFor) {
		if (newDefaultFor != defaultFor) {
			NotificationChain msgs = null;
			if (defaultFor != null)
				msgs = ((InternalEObject)defaultFor).eInverseRemove(this, TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS, TraceLinkSet.class, msgs);
			if (newDefaultFor != null)
				msgs = ((InternalEObject)newDefaultFor).eInverseAdd(this, TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS, TraceLinkSet.class, msgs);
			msgs = basicSetDefaultFor(newDefaultFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.SOURCE_ELEMENT__DEFAULT_FOR, newDefaultFor, newDefaultFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedRule getUniqueFor() {
		if (uniqueFor != null && uniqueFor.eIsProxy()) {
			InternalEObject oldUniqueFor = (InternalEObject)uniqueFor;
			uniqueFor = (TracedRule)eResolveProxy(oldUniqueFor);
			if (uniqueFor != oldUniqueFor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.SOURCE_ELEMENT__UNIQUE_FOR, oldUniqueFor, uniqueFor));
			}
		}
		return uniqueFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedRule basicGetUniqueFor() {
		return uniqueFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUniqueFor(TracedRule newUniqueFor, NotificationChain msgs) {
		TracedRule oldUniqueFor = uniqueFor;
		uniqueFor = newUniqueFor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.SOURCE_ELEMENT__UNIQUE_FOR, oldUniqueFor, newUniqueFor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUniqueFor(TracedRule newUniqueFor) {
		if (newUniqueFor != uniqueFor) {
			NotificationChain msgs = null;
			if (uniqueFor != null)
				msgs = ((InternalEObject)uniqueFor).eInverseRemove(this, TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS, TracedRule.class, msgs);
			if (newUniqueFor != null)
				msgs = ((InternalEObject)newUniqueFor).eInverseAdd(this, TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS, TracedRule.class, msgs);
			msgs = basicSetUniqueFor(newUniqueFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.SOURCE_ELEMENT__UNIQUE_FOR, newUniqueFor, newUniqueFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMapsToSelf() {
		return mapsToSelf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapsToSelf(boolean newMapsToSelf) {
		boolean oldMapsToSelf = mapsToSelf;
		mapsToSelf = newMapsToSelf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.SOURCE_ELEMENT__MAPS_TO_SELF, oldMapsToSelf, mapsToSelf));
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
			case TracePackage.SOURCE_ELEMENT__SOURCE_OF:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourceOf((TraceLink)otherEnd, msgs);
			case TracePackage.SOURCE_ELEMENT__MAPS_TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMapsTo()).basicAdd(otherEnd, msgs);
			case TracePackage.SOURCE_ELEMENT__DEFAULT_FOR:
				if (defaultFor != null)
					msgs = ((InternalEObject)defaultFor).eInverseRemove(this, TracePackage.TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS, TraceLinkSet.class, msgs);
				return basicSetDefaultFor((TraceLinkSet)otherEnd, msgs);
			case TracePackage.SOURCE_ELEMENT__UNIQUE_FOR:
				if (uniqueFor != null)
					msgs = ((InternalEObject)uniqueFor).eInverseRemove(this, TracePackage.TRACED_RULE__UNIQUE_SOURCE_ELEMENTS, TracedRule.class, msgs);
				return basicSetUniqueFor((TracedRule)otherEnd, msgs);
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
			case TracePackage.SOURCE_ELEMENT__SOURCE_OF:
				return basicSetSourceOf(null, msgs);
			case TracePackage.SOURCE_ELEMENT__MAPS_TO:
				return ((InternalEList<?>)getMapsTo()).basicRemove(otherEnd, msgs);
			case TracePackage.SOURCE_ELEMENT__DEFAULT_FOR:
				return basicSetDefaultFor(null, msgs);
			case TracePackage.SOURCE_ELEMENT__UNIQUE_FOR:
				return basicSetUniqueFor(null, msgs);
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
			case TracePackage.SOURCE_ELEMENT__SOURCE_OF:
				return eInternalContainer().eInverseRemove(this, TracePackage.TRACE_LINK__SOURCE_ELEMENTS, TraceLink.class, msgs);
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
			case TracePackage.SOURCE_ELEMENT__SOURCE_OF:
				return getSourceOf();
			case TracePackage.SOURCE_ELEMENT__MAPS_TO:
				return getMapsTo();
			case TracePackage.SOURCE_ELEMENT__DEFAULT_FOR:
				if (resolve) return getDefaultFor();
				return basicGetDefaultFor();
			case TracePackage.SOURCE_ELEMENT__UNIQUE_FOR:
				if (resolve) return getUniqueFor();
				return basicGetUniqueFor();
			case TracePackage.SOURCE_ELEMENT__MAPS_TO_SELF:
				return isMapsToSelf();
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
			case TracePackage.SOURCE_ELEMENT__SOURCE_OF:
				setSourceOf((TraceLink)newValue);
				return;
			case TracePackage.SOURCE_ELEMENT__MAPS_TO:
				getMapsTo().clear();
				getMapsTo().addAll((Collection<? extends TargetElement>)newValue);
				return;
			case TracePackage.SOURCE_ELEMENT__DEFAULT_FOR:
				setDefaultFor((TraceLinkSet)newValue);
				return;
			case TracePackage.SOURCE_ELEMENT__UNIQUE_FOR:
				setUniqueFor((TracedRule)newValue);
				return;
			case TracePackage.SOURCE_ELEMENT__MAPS_TO_SELF:
				setMapsToSelf((Boolean)newValue);
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
			case TracePackage.SOURCE_ELEMENT__SOURCE_OF:
				setSourceOf((TraceLink)null);
				return;
			case TracePackage.SOURCE_ELEMENT__MAPS_TO:
				getMapsTo().clear();
				return;
			case TracePackage.SOURCE_ELEMENT__DEFAULT_FOR:
				setDefaultFor((TraceLinkSet)null);
				return;
			case TracePackage.SOURCE_ELEMENT__UNIQUE_FOR:
				setUniqueFor((TracedRule)null);
				return;
			case TracePackage.SOURCE_ELEMENT__MAPS_TO_SELF:
				setMapsToSelf(MAPS_TO_SELF_EDEFAULT);
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
			case TracePackage.SOURCE_ELEMENT__SOURCE_OF:
				return getSourceOf() != null;
			case TracePackage.SOURCE_ELEMENT__MAPS_TO:
				return mapsTo != null && !mapsTo.isEmpty();
			case TracePackage.SOURCE_ELEMENT__DEFAULT_FOR:
				return defaultFor != null;
			case TracePackage.SOURCE_ELEMENT__UNIQUE_FOR:
				return uniqueFor != null;
			case TracePackage.SOURCE_ELEMENT__MAPS_TO_SELF:
				return mapsToSelf != MAPS_TO_SELF_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" -> [");
		boolean notFirst = false;
		for (TargetElement te : getMapsTo()) {
			if (notFirst) {
				result.append(", ");
			}
			result.append(te.toString());
			notFirst = true;
		}
		result.append(']');
		return result.toString();
	}

} //SourceElementImpl
