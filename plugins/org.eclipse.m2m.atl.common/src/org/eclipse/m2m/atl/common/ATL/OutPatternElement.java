/**
 * Copyright (c) 2008, 2012, 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.atl.common.OCL.OclModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Out Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getOutPattern <em>Out Pattern</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPatternElement()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class OutPatternElement extends PatternElement {
	/**
	 * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected InPatternElement sourceElement;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<Binding> bindings;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected OclModel model;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutPatternElement() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ATLPackage.Literals.OUT_PATTERN_ELEMENT;
	}

	/**
	 * Returns the value of the '<em><b>Out Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Pattern</em>' container reference.
	 * @see #setOutPattern(OutPattern)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPatternElement_OutPattern()
	 * @see org.eclipse.m2m.atl.common.ATL.OutPattern#getElements
	 * @model opposite="elements" required="true" transient="false" ordered="false"
	 * @generated
	 */
	public OutPattern getOutPattern() {
		if (eContainerFeatureID() != ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN) return null;
		return (OutPattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutPattern(OutPattern newOutPattern, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOutPattern, ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN, msgs);
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getOutPattern <em>Out Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Pattern</em>' container reference.
	 * @see #getOutPattern()
	 * @generated
	 */
	public void setOutPattern(OutPattern newOutPattern) {
		if (newOutPattern != eInternalContainer() || (eContainerFeatureID() != ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN && newOutPattern != null)) {
			if (EcoreUtil.isAncestor(this, newOutPattern))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOutPattern != null)
				msgs = ((InternalEObject)newOutPattern).eInverseAdd(this, ATLPackage.OUT_PATTERN__ELEMENTS, OutPattern.class, msgs);
			msgs = basicSetOutPattern(newOutPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN, newOutPattern, newOutPattern));
	}

	/**
	 * Returns the value of the '<em><b>Source Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.InPatternElement#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Element</em>' reference.
	 * @see #setSourceElement(InPatternElement)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPatternElement_SourceElement()
	 * @see org.eclipse.m2m.atl.common.ATL.InPatternElement#getMapsTo
	 * @model opposite="mapsTo" ordered="false"
	 * @generated
	 */
	public InPatternElement getSourceElement() {
		if (sourceElement != null && sourceElement.eIsProxy()) {
			InternalEObject oldSourceElement = (InternalEObject)sourceElement;
			sourceElement = (InPatternElement)eResolveProxy(oldSourceElement);
			if (sourceElement != oldSourceElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT, oldSourceElement, sourceElement));
			}
		}
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPatternElement basicGetSourceElement() {
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceElement(InPatternElement newSourceElement, NotificationChain msgs) {
		InPatternElement oldSourceElement = sourceElement;
		sourceElement = newSourceElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT, oldSourceElement, newSourceElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getSourceElement <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Element</em>' reference.
	 * @see #getSourceElement()
	 * @generated
	 */
	public void setSourceElement(InPatternElement newSourceElement) {
		if (newSourceElement != sourceElement) {
			NotificationChain msgs = null;
			if (sourceElement != null)
				msgs = ((InternalEObject)sourceElement).eInverseRemove(this, ATLPackage.IN_PATTERN_ELEMENT__MAPS_TO, InPatternElement.class, msgs);
			if (newSourceElement != null)
				msgs = ((InternalEObject)newSourceElement).eInverseAdd(this, ATLPackage.IN_PATTERN_ELEMENT__MAPS_TO, InPatternElement.class, msgs);
			msgs = basicSetSourceElement(newSourceElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT, newSourceElement, newSourceElement));
	}

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.common.ATL.Binding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.common.ATL.Binding#getOutPatternElement <em>Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPatternElement_Bindings()
	 * @see org.eclipse.m2m.atl.common.ATL.Binding#getOutPatternElement
	 * @model opposite="outPatternElement" containment="true"
	 * @generated
	 */
	public EList<Binding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentWithInverseEList<Binding>(Binding.class, this, ATLPackage.OUT_PATTERN_ELEMENT__BINDINGS, ATLPackage.BINDING__OUT_PATTERN_ELEMENT);
		}
		return bindings;
	}

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(OclModel)
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPatternElement_Model()
	 * @model ordered="false"
	 * @generated
	 */
	public OclModel getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (OclModel)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ATLPackage.OUT_PATTERN_ELEMENT__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel basicGetModel() {
		return model;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	public void setModel(OclModel newModel) {
		OclModel oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ATLPackage.OUT_PATTERN_ELEMENT__MODEL, oldModel, model));
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
			case ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOutPattern((OutPattern)otherEnd, msgs);
			case ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT:
				if (sourceElement != null)
					msgs = ((InternalEObject)sourceElement).eInverseRemove(this, ATLPackage.IN_PATTERN_ELEMENT__MAPS_TO, InPatternElement.class, msgs);
				return basicSetSourceElement((InPatternElement)otherEnd, msgs);
			case ATLPackage.OUT_PATTERN_ELEMENT__BINDINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBindings()).basicAdd(otherEnd, msgs);
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
			case ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN:
				return basicSetOutPattern(null, msgs);
			case ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT:
				return basicSetSourceElement(null, msgs);
			case ATLPackage.OUT_PATTERN_ELEMENT__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
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
			case ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN:
				return eInternalContainer().eInverseRemove(this, ATLPackage.OUT_PATTERN__ELEMENTS, OutPattern.class, msgs);
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
			case ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN:
				return getOutPattern();
			case ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT:
				if (resolve) return getSourceElement();
				return basicGetSourceElement();
			case ATLPackage.OUT_PATTERN_ELEMENT__BINDINGS:
				return getBindings();
			case ATLPackage.OUT_PATTERN_ELEMENT__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
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
			case ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN:
				setOutPattern((OutPattern)newValue);
				return;
			case ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT:
				setSourceElement((InPatternElement)newValue);
				return;
			case ATLPackage.OUT_PATTERN_ELEMENT__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends Binding>)newValue);
				return;
			case ATLPackage.OUT_PATTERN_ELEMENT__MODEL:
				setModel((OclModel)newValue);
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
			case ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN:
				setOutPattern((OutPattern)null);
				return;
			case ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT:
				setSourceElement((InPatternElement)null);
				return;
			case ATLPackage.OUT_PATTERN_ELEMENT__BINDINGS:
				getBindings().clear();
				return;
			case ATLPackage.OUT_PATTERN_ELEMENT__MODEL:
				setModel((OclModel)null);
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
			case ATLPackage.OUT_PATTERN_ELEMENT__OUT_PATTERN:
				return getOutPattern() != null;
			case ATLPackage.OUT_PATTERN_ELEMENT__SOURCE_ELEMENT:
				return sourceElement != null;
			case ATLPackage.OUT_PATTERN_ELEMENT__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case ATLPackage.OUT_PATTERN_ELEMENT__MODEL:
				return model != null;
		}
		return super.eIsSet(featureID);
	}

} // OutPatternElement
