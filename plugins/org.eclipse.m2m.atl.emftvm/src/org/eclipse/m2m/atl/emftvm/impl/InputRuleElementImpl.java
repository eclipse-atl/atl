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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.LazyList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Rule Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InputRuleElementImpl#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.InputRuleElementImpl#getInputFor <em>Input For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputRuleElementImpl extends RuleElementImpl implements InputRuleElement {
	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock binding;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link InputRuleElementImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputRuleElementImpl() {
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
		return EmftvmPackage.Literals.INPUT_RULE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setBinding(CodeBlock)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBinding(CodeBlock newBinding, NotificationChain msgs) {
		CodeBlock oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmftvmPackage.INPUT_RULE_ELEMENT__BINDING, oldBinding, newBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(CodeBlock newBinding) {
		if (newBinding != binding) {
			NotificationChain msgs = null;
			if (binding != null)
				msgs = ((InternalEObject)binding).eInverseRemove(this, EmftvmPackage.CODE_BLOCK__BINDING_FOR, CodeBlock.class, msgs);
			if (newBinding != null)
				msgs = ((InternalEObject)newBinding).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__BINDING_FOR, CodeBlock.class, msgs);
			msgs = basicSetBinding(newBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.INPUT_RULE_ELEMENT__BINDING, newBinding, newBinding));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getInputFor() {
		if (eContainerFeatureID() != EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR) return null;
		return (Rule)eContainer();
	}

	/**
	 * <!-- begin-user-doc. -->
	 * @see #setInputFor(Rule)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputFor(Rule newInputFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInputFor, EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputFor(Rule newInputFor) {
		if (newInputFor != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR && newInputFor != null)) {
			if (EcoreUtil.isAncestor(this, newInputFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInputFor != null)
				msgs = ((InternalEObject)newInputFor).eInverseAdd(this, EmftvmPackage.RULE__INPUT_ELEMENTS, Rule.class, msgs);
			msgs = basicSetInputFor(newInputFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR, newInputFor, newInputFor));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Iterable<EObject> createIterable(final ExecEnv env) {
		if (getEModels().isEmpty()) {
			return EMFTVMUtil.findAllInstances((EClass)getEType(), env);
		} else {
			LazyList<EObject> allInstances = new LazyList<EObject>();
			for (Model m : getEModels()) {
				allInstances = allInstances.union(m.allInstancesOf((EClass)getEType()));
			}
			return allInstances;
		}
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
			case EmftvmPackage.INPUT_RULE_ELEMENT__BINDING:
				if (binding != null)
					msgs = ((InternalEObject)binding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmftvmPackage.INPUT_RULE_ELEMENT__BINDING, null, msgs);
				return basicSetBinding((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInputFor((Rule)otherEnd, msgs);
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
			case EmftvmPackage.INPUT_RULE_ELEMENT__BINDING:
				return basicSetBinding(null, msgs);
			case EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR:
				return basicSetInputFor(null, msgs);
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
			case EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.RULE__INPUT_ELEMENTS, Rule.class, msgs);
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
			case EmftvmPackage.INPUT_RULE_ELEMENT__BINDING:
				return getBinding();
			case EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR:
				return getInputFor();
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
			case EmftvmPackage.INPUT_RULE_ELEMENT__BINDING:
				setBinding((CodeBlock)newValue);
				return;
			case EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR:
				setInputFor((Rule)newValue);
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
			case EmftvmPackage.INPUT_RULE_ELEMENT__BINDING:
				setBinding((CodeBlock)null);
				return;
			case EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR:
				setInputFor((Rule)null);
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
			case EmftvmPackage.INPUT_RULE_ELEMENT__BINDING:
				return binding != null;
			case EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR:
				return getInputFor() != null;
		}
		return super.eIsSet(featureID);
	}

} //InputRuleElementImpl
