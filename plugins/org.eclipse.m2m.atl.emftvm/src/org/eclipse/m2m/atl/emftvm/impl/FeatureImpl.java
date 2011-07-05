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
package org.eclipse.m2m.atl.emftvm.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.FeatureImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.FeatureImpl#getEContext <em>EContext</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.FeatureImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.FeatureImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.FeatureImpl#getContextModel <em>Context Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureImpl extends TypedElementImpl implements Feature {
	/**
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;
	/**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getContextModel() <em>Context Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextModel()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_MODEL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean static_ = STATIC_EDEFAULT;
	/**
	 * The cached value of the '{@link #getEContext() <em>EContext</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEContext()
	 * @generated
	 * @ordered
	 */
	protected EClassifier eContext;
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected String context = CONTEXT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getContextModel() <em>Context Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextModel()
	 * @generated
	 * @ordered
	 */
	protected String contextModel = CONTEXT_MODEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link FeatureImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link EClass} that correspond to this metaclass.
	 * @return the {@link EClass} that correspond to this metaclass.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatic() {
		return static_;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatic(boolean newStatic) {
		boolean oldStatic = static_;
		static_ = newStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.FEATURE__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getEContext() {
		if (eContext != null && eContext.eIsProxy()) {
			InternalEObject oldEContext = (InternalEObject)eContext;
			eContext = (EClassifier)eResolveProxy(oldEContext);
			if (eContext != oldEContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmftvmPackage.FEATURE__ECONTEXT, oldEContext, eContext));
			}
		}
		return eContext;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #getEContext()
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetEContext() {
		return eContext;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEContext(EClassifier newEContext) {
		EClassifier oldEContext = eContext;
		eContext = newEContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.FEATURE__ECONTEXT, oldEContext, eContext));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(String newContext) {
		String oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.FEATURE__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContextModel() {
		return contextModel;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextModel(String newContextModel) {
		String oldContextModel = contextModel;
		contextModel = newContextModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.FEATURE__CONTEXT_MODEL, oldContextModel, contextModel));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.FEATURE__MODULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModule((Module)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.FEATURE__MODULE:
				return basicSetModule(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EmftvmPackage.FEATURE__MODULE:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.MODULE__FEATURES, Module.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmftvmPackage.FEATURE__STATIC:
				return isStatic();
			case EmftvmPackage.FEATURE__ECONTEXT:
				if (resolve) return getEContext();
				return basicGetEContext();
			case EmftvmPackage.FEATURE__MODULE:
				return getModule();
			case EmftvmPackage.FEATURE__CONTEXT:
				return getContext();
			case EmftvmPackage.FEATURE__CONTEXT_MODEL:
				return getContextModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.FEATURE__STATIC:
				setStatic((Boolean)newValue);
				return;
			case EmftvmPackage.FEATURE__ECONTEXT:
				setEContext((EClassifier)newValue);
				return;
			case EmftvmPackage.FEATURE__MODULE:
				setModule((Module)newValue);
				return;
			case EmftvmPackage.FEATURE__CONTEXT:
				setContext((String)newValue);
				return;
			case EmftvmPackage.FEATURE__CONTEXT_MODEL:
				setContextModel((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmftvmPackage.FEATURE__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case EmftvmPackage.FEATURE__ECONTEXT:
				setEContext((EClassifier)null);
				return;
			case EmftvmPackage.FEATURE__MODULE:
				setModule((Module)null);
				return;
			case EmftvmPackage.FEATURE__CONTEXT:
				setContext(CONTEXT_EDEFAULT);
				return;
			case EmftvmPackage.FEATURE__CONTEXT_MODEL:
				setContextModel(CONTEXT_MODEL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmftvmPackage.FEATURE__STATIC:
				return static_ != STATIC_EDEFAULT;
			case EmftvmPackage.FEATURE__ECONTEXT:
				return eContext != null;
			case EmftvmPackage.FEATURE__MODULE:
				return getModule() != null;
			case EmftvmPackage.FEATURE__CONTEXT:
				return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
			case EmftvmPackage.FEATURE__CONTEXT_MODEL:
				return CONTEXT_MODEL_EDEFAULT == null ? contextModel != null : !CONTEXT_MODEL_EDEFAULT.equals(contextModel);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getModule() {
		if (eContainerFeatureID() != EmftvmPackage.FEATURE__MODULE) return null;
		return (Module)eContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setModule(Module)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModule, EmftvmPackage.FEATURE__MODULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModule(Module newModule) {
		if (newModule != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.FEATURE__MODULE && newModule != null)) {
			if (EcoreUtil.isAncestor(this, newModule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModule != null)
				msgs = ((InternalEObject)newModule).eInverseAdd(this, EmftvmPackage.MODULE__FEATURES, Module.class, msgs);
			msgs = basicSetModule(newModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.FEATURE__MODULE, newModule, newModule));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		if (isStatic()) result.append("static ");
		if (!EMFTVMUtil.NATIVE.equals(contextModel)) {
			result.append(contextModel);
			result.append('!');
		}
		result.append(context);
		result.append("::");
		result.append(super.toString());
		return result.toString();
	}

} //FeatureImpl
