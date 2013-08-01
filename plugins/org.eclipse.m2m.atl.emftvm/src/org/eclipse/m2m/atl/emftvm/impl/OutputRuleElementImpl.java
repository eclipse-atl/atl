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


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.OutputRuleElement;
import org.eclipse.m2m.atl.emftvm.Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Rule Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.OutputRuleElementImpl#getMapsTo <em>Maps To</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.OutputRuleElementImpl#getOutputFor <em>Output For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputRuleElementImpl extends RuleElementImpl implements OutputRuleElement {
	/**
	 * The cached value of the '{@link #getMapsTo() <em>Maps To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<InputRuleElement> mapsTo;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link OutputRuleElementImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputRuleElementImpl() {
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
		return EmftvmPackage.Literals.OUTPUT_RULE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputRuleElement> getMapsTo() {
		if (mapsTo == null) {
			mapsTo = new EObjectResolvingEList<InputRuleElement>(InputRuleElement.class, this, EmftvmPackage.OUTPUT_RULE_ELEMENT__MAPS_TO);
		}
		return mapsTo;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getOutputFor() {
		if (eContainerFeatureID() != EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setOutputFor(Rule)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputFor(Rule newOutputFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOutputFor, EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputFor(Rule newOutputFor) {
		if (newOutputFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR && newOutputFor != null)) {
			if (EcoreUtil.isAncestor(this, newOutputFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOutputFor != null)
				msgs = ((InternalEObject)newOutputFor).eInverseAdd(this, EmftvmPackage.RULE__OUTPUT_ELEMENTS, Rule.class, msgs);
			msgs = basicSetOutputFor(newOutputFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR, newOutputFor, newOutputFor));
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
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOutputFor((Rule)otherEnd, msgs);
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
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR:
				return basicSetOutputFor(null, msgs);
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
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.RULE__OUTPUT_ELEMENTS, Rule.class, msgs);
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
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__MAPS_TO:
				return getMapsTo();
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR:
				return getOutputFor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__MAPS_TO:
				getMapsTo().clear();
				getMapsTo().addAll((Collection<? extends InputRuleElement>)newValue);
				return;
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR:
				setOutputFor((Rule)newValue);
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
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__MAPS_TO:
				getMapsTo().clear();
				return;
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR:
				setOutputFor((Rule)null);
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
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__MAPS_TO:
				return mapsTo != null && !mapsTo.isEmpty();
			case EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR:
				return getOutputFor() != null;
		}
		return super.eIsSet(featureID);
	}

} //OutputRuleElementImpl
