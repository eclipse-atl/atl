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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ModelDeclaration;
import org.eclipse.m2m.atl.emftvm.Module;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Declaration</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl#getMetaModelName <em>Meta Model Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl#getInputModelFor <em>Input Model For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl#getInoutModelFor <em>Inout Model For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModelDeclarationImpl#getOutputModelFor <em>Output Model For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelDeclarationImpl extends EObjectImpl implements ModelDeclaration {
	/**
	 * The default value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected String modelName = MODEL_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getMetaModelName() <em>Meta Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String META_MODEL_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMetaModelName() <em>Meta Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelName()
	 * @generated
	 * @ordered
	 */
	protected String metaModelName = META_MODEL_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link ModelDeclarationImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelDeclarationImpl() {
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
		return EmftvmPackage.Literals.MODEL_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelName(String newModelName) {
		String oldModelName = modelName;
		modelName = newModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.MODEL_DECLARATION__MODEL_NAME, oldModelName, modelName));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetaModelName() {
		return metaModelName;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelName(String newMetaModelName) {
		String oldMetaModelName = metaModelName;
		metaModelName = newMetaModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.MODEL_DECLARATION__META_MODEL_NAME, oldMetaModelName, metaModelName));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getInputModelFor() {
		if (eContainerFeatureID() != EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR) return null;
		return (Module)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputModelFor(Module newInputModelFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInputModelFor, EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputModelFor(Module newInputModelFor) {
		if (newInputModelFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR && newInputModelFor != null)) {
			if (EcoreUtil.isAncestor(this, newInputModelFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInputModelFor != null)
				msgs = ((InternalEObject)newInputModelFor).eInverseAdd(this, EmftvmPackage.MODULE__INPUT_MODELS, Module.class, msgs);
			msgs = basicSetInputModelFor(newInputModelFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR, newInputModelFor, newInputModelFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getInoutModelFor() {
		if (eContainerFeatureID() != EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR) return null;
		return (Module)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setInoutModelFor(Module)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInoutModelFor(Module newInoutModelFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInoutModelFor, EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInoutModelFor(Module newInoutModelFor) {
		if (newInoutModelFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR && newInoutModelFor != null)) {
			if (EcoreUtil.isAncestor(this, newInoutModelFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInoutModelFor != null)
				msgs = ((InternalEObject)newInoutModelFor).eInverseAdd(this, EmftvmPackage.MODULE__INOUT_MODELS, Module.class, msgs);
			msgs = basicSetInoutModelFor(newInoutModelFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR, newInoutModelFor, newInoutModelFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getOutputModelFor() {
		if (eContainerFeatureID() != EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR) return null;
		return (Module)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setOutputModelFor(Module)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputModelFor(Module newOutputModelFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOutputModelFor, EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputModelFor(Module newOutputModelFor) {
		if (newOutputModelFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR && newOutputModelFor != null)) {
			if (EcoreUtil.isAncestor(this, newOutputModelFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOutputModelFor != null)
				msgs = ((InternalEObject)newOutputModelFor).eInverseAdd(this, EmftvmPackage.MODULE__OUTPUT_MODELS, Module.class, msgs);
			msgs = basicSetOutputModelFor(newOutputModelFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR, newOutputModelFor, newOutputModelFor));
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
			case EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInputModelFor((Module)otherEnd, msgs);
			case EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInoutModelFor((Module)otherEnd, msgs);
			case EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOutputModelFor((Module)otherEnd, msgs);
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
			case EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR:
				return basicSetInputModelFor(null, msgs);
			case EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR:
				return basicSetInoutModelFor(null, msgs);
			case EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR:
				return basicSetOutputModelFor(null, msgs);
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
			case EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.MODULE__INPUT_MODELS, Module.class, msgs);
			case EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.MODULE__INOUT_MODELS, Module.class, msgs);
			case EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.MODULE__OUTPUT_MODELS, Module.class, msgs);
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
			case EmftvmPackage.MODEL_DECLARATION__MODEL_NAME:
				return getModelName();
			case EmftvmPackage.MODEL_DECLARATION__META_MODEL_NAME:
				return getMetaModelName();
			case EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR:
				return getInputModelFor();
			case EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR:
				return getInoutModelFor();
			case EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR:
				return getOutputModelFor();
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
			case EmftvmPackage.MODEL_DECLARATION__MODEL_NAME:
				setModelName((String)newValue);
				return;
			case EmftvmPackage.MODEL_DECLARATION__META_MODEL_NAME:
				setMetaModelName((String)newValue);
				return;
			case EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR:
				setInputModelFor((Module)newValue);
				return;
			case EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR:
				setInoutModelFor((Module)newValue);
				return;
			case EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR:
				setOutputModelFor((Module)newValue);
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
			case EmftvmPackage.MODEL_DECLARATION__MODEL_NAME:
				setModelName(MODEL_NAME_EDEFAULT);
				return;
			case EmftvmPackage.MODEL_DECLARATION__META_MODEL_NAME:
				setMetaModelName(META_MODEL_NAME_EDEFAULT);
				return;
			case EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR:
				setInputModelFor((Module)null);
				return;
			case EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR:
				setInoutModelFor((Module)null);
				return;
			case EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR:
				setOutputModelFor((Module)null);
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
			case EmftvmPackage.MODEL_DECLARATION__MODEL_NAME:
				return MODEL_NAME_EDEFAULT == null ? modelName != null : !MODEL_NAME_EDEFAULT.equals(modelName);
			case EmftvmPackage.MODEL_DECLARATION__META_MODEL_NAME:
				return META_MODEL_NAME_EDEFAULT == null ? metaModelName != null : !META_MODEL_NAME_EDEFAULT.equals(metaModelName);
			case EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR:
				return getInputModelFor() != null;
			case EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR:
				return getInoutModelFor() != null;
			case EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR:
				return getOutputModelFor() != null;
		}
		return super.eIsSet(featureID);
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
		result.append(modelName);
		result.append(" : ");
		result.append(metaModelName);
		return result.toString();
	}

} //ModelDeclarationImpl
