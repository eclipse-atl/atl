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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.OutputRuleElement;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.RuleMode;
import org.eclipse.m2m.atl.emftvm.util.FieldContainer;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getInputElements <em>Input Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getOutputElements <em>Output Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getESuperRules <em>ESuper Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getESubRules <em>ESub Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getApplier <em>Applier</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getPostApply <em>Post Apply</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getSuperRules <em>Super Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.RuleImpl#isDistinctElements <em>Distinct Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends NamedElementImpl implements Rule {
	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final RuleMode MODE_EDEFAULT = RuleMode.MANUAL;
	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected RuleMode mode = MODE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getInputElements() <em>Input Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputElements()
	 * @generated
	 * @ordered
	 */
	protected EList<InputRuleElement> inputElements;
	/**
	 * The cached value of the '{@link #getOutputElements() <em>Output Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputElements()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputRuleElement> outputElements;
	/**
	 * The cached value of the '{@link #getESuperRules() <em>ESuper Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getESuperRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> eSuperRules;
	/**
	 * The cached value of the '{@link #getESubRules() <em>ESub Rules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getESubRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> eSubRules;
	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock matcher;
	/**
	 * The cached value of the '{@link #getApplier() <em>Applier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplier()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock applier;
	/**
	 * The cached value of the '{@link #getPostApply() <em>Post Apply</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostApply()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock postApply;
	/**
	 * The cached value of the '{@link #getSuperRules() <em>Super Rules</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperRules()
	 * @generated
	 * @ordered
	 */
	protected EList<String> superRules;
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<Field> fields;
	/**
	 * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean default_ = DEFAULT_EDEFAULT;
	/**
	 * The default value of the '{@link #isDistinctElements() <em>Distinct Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinctElements()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISTINCT_ELEMENTS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDistinctElements() <em>Distinct Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinctElements()
	 * @generated
	 * @ordered
	 */
	protected boolean distinctElements = DISTINCT_ELEMENTS_EDEFAULT;
	/**
	 * Field storage and lookup. 
	 */
	protected FieldContainer fieldContainer = new FieldContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getModule() {
		if (eContainerFeatureID() != EmftvmPackage.RULE__MODULE) return null;
		return (Module)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModule, EmftvmPackage.RULE__MODULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModule(Module newModule) {
		if (newModule != eInternalContainer() || (eContainerFeatureID() != EmftvmPackage.RULE__MODULE && newModule != null)) {
			if (EcoreUtil.isAncestor(this, newModule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModule != null)
				msgs = ((InternalEObject)newModule).eInverseAdd(this, EmftvmPackage.MODULE__RULES, Module.class, msgs);
			msgs = basicSetModule(newModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__MODULE, newModule, newModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(RuleMode newMode) {
		RuleMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputRuleElement> getInputElements() {
		if (inputElements == null) {
			inputElements = new EObjectContainmentWithInverseEList<InputRuleElement>(InputRuleElement.class, this, EmftvmPackage.RULE__INPUT_ELEMENTS, EmftvmPackage.INPUT_RULE_ELEMENT__INPUT_FOR);
		}
		return inputElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputRuleElement> getOutputElements() {
		if (outputElements == null) {
			outputElements = new EObjectContainmentWithInverseEList<OutputRuleElement>(OutputRuleElement.class, this, EmftvmPackage.RULE__OUTPUT_ELEMENTS, EmftvmPackage.OUTPUT_RULE_ELEMENT__OUTPUT_FOR);
		}
		return outputElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getESuperRules() {
		if (eSuperRules == null) {
			eSuperRules = new EObjectWithInverseResolvingEList.ManyInverse<Rule>(Rule.class, this, EmftvmPackage.RULE__ESUPER_RULES, EmftvmPackage.RULE__ESUB_RULES);
		}
		return eSuperRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getESubRules() {
		if (eSubRules == null) {
			eSubRules = new EObjectWithInverseResolvingEList.ManyInverse<Rule>(Rule.class, this, EmftvmPackage.RULE__ESUB_RULES, EmftvmPackage.RULE__ESUPER_RULES);
		}
		return eSubRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcher(CodeBlock newMatcher, NotificationChain msgs) {
		CodeBlock oldMatcher = matcher;
		matcher = newMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__MATCHER, oldMatcher, newMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatcher(CodeBlock newMatcher) {
		if (newMatcher != matcher) {
			NotificationChain msgs = null;
			if (matcher != null)
				msgs = ((InternalEObject)matcher).eInverseRemove(this, EmftvmPackage.CODE_BLOCK__MATCHER_FOR, CodeBlock.class, msgs);
			if (newMatcher != null)
				msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__MATCHER_FOR, CodeBlock.class, msgs);
			msgs = basicSetMatcher(newMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__MATCHER, newMatcher, newMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getApplier() {
		return applier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplier(CodeBlock newApplier, NotificationChain msgs) {
		CodeBlock oldApplier = applier;
		applier = newApplier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__APPLIER, oldApplier, newApplier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplier(CodeBlock newApplier) {
		if (newApplier != applier) {
			NotificationChain msgs = null;
			if (applier != null)
				msgs = ((InternalEObject)applier).eInverseRemove(this, EmftvmPackage.CODE_BLOCK__APPLIER_FOR, CodeBlock.class, msgs);
			if (newApplier != null)
				msgs = ((InternalEObject)newApplier).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__APPLIER_FOR, CodeBlock.class, msgs);
			msgs = basicSetApplier(newApplier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__APPLIER, newApplier, newApplier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getPostApply() {
		return postApply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostApply(CodeBlock newPostApply, NotificationChain msgs) {
		CodeBlock oldPostApply = postApply;
		postApply = newPostApply;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__POST_APPLY, oldPostApply, newPostApply);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostApply(CodeBlock newPostApply) {
		if (newPostApply != postApply) {
			NotificationChain msgs = null;
			if (postApply != null)
				msgs = ((InternalEObject)postApply).eInverseRemove(this, EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR, CodeBlock.class, msgs);
			if (newPostApply != null)
				msgs = ((InternalEObject)newPostApply).eInverseAdd(this, EmftvmPackage.CODE_BLOCK__POST_APPLY_FOR, CodeBlock.class, msgs);
			msgs = basicSetPostApply(newPostApply, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__POST_APPLY, newPostApply, newPostApply));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSuperRules() {
		if (superRules == null) {
			superRules = new EDataTypeUniqueEList<String>(String.class, this, EmftvmPackage.RULE__SUPER_RULES);
		}
		return superRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentWithInverseEList<Field>(Field.class, this, EmftvmPackage.RULE__FIELDS, EmftvmPackage.FIELD__RULE);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(boolean newDefault) {
		boolean oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistinctElements() {
		return distinctElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistinctElements(boolean newDistinctElements) {
		boolean oldDistinctElements = distinctElements;
		distinctElements = newDistinctElements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.RULE__DISTINCT_ELEMENTS, oldDistinctElements, distinctElements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Field findField(Object context, String name) {
		return fieldContainer.findField(context, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Field findStaticField(Object context, String name) {
		return fieldContainer.findStaticField(context, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void registerField(Field field) {
		fieldContainer.registerField(field);
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
			case EmftvmPackage.RULE__MODULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModule((Module)otherEnd, msgs);
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputElements()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputElements()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.RULE__ESUPER_RULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getESuperRules()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.RULE__ESUB_RULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getESubRules()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.RULE__MATCHER:
				if (matcher != null)
					msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmftvmPackage.RULE__MATCHER, null, msgs);
				return basicSetMatcher((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.RULE__APPLIER:
				if (applier != null)
					msgs = ((InternalEObject)applier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmftvmPackage.RULE__APPLIER, null, msgs);
				return basicSetApplier((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.RULE__POST_APPLY:
				if (postApply != null)
					msgs = ((InternalEObject)postApply).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmftvmPackage.RULE__POST_APPLY, null, msgs);
				return basicSetPostApply((CodeBlock)otherEnd, msgs);
			case EmftvmPackage.RULE__FIELDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFields()).basicAdd(otherEnd, msgs);
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
			case EmftvmPackage.RULE__MODULE:
				return basicSetModule(null, msgs);
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				return ((InternalEList<?>)getInputElements()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				return ((InternalEList<?>)getOutputElements()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.RULE__ESUPER_RULES:
				return ((InternalEList<?>)getESuperRules()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.RULE__ESUB_RULES:
				return ((InternalEList<?>)getESubRules()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.RULE__MATCHER:
				return basicSetMatcher(null, msgs);
			case EmftvmPackage.RULE__APPLIER:
				return basicSetApplier(null, msgs);
			case EmftvmPackage.RULE__POST_APPLY:
				return basicSetPostApply(null, msgs);
			case EmftvmPackage.RULE__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
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
			case EmftvmPackage.RULE__MODULE:
				return eInternalContainer().eInverseRemove(this, EmftvmPackage.MODULE__RULES, Module.class, msgs);
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
			case EmftvmPackage.RULE__MODULE:
				return getModule();
			case EmftvmPackage.RULE__MODE:
				return getMode();
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				return getInputElements();
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				return getOutputElements();
			case EmftvmPackage.RULE__ESUPER_RULES:
				return getESuperRules();
			case EmftvmPackage.RULE__ESUB_RULES:
				return getESubRules();
			case EmftvmPackage.RULE__MATCHER:
				return getMatcher();
			case EmftvmPackage.RULE__APPLIER:
				return getApplier();
			case EmftvmPackage.RULE__POST_APPLY:
				return getPostApply();
			case EmftvmPackage.RULE__SUPER_RULES:
				return getSuperRules();
			case EmftvmPackage.RULE__ABSTRACT:
				return isAbstract();
			case EmftvmPackage.RULE__FIELDS:
				return getFields();
			case EmftvmPackage.RULE__DEFAULT:
				return isDefault();
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
				return isDistinctElements();
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
			case EmftvmPackage.RULE__MODULE:
				setModule((Module)newValue);
				return;
			case EmftvmPackage.RULE__MODE:
				setMode((RuleMode)newValue);
				return;
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				getInputElements().clear();
				getInputElements().addAll((Collection<? extends InputRuleElement>)newValue);
				return;
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				getOutputElements().clear();
				getOutputElements().addAll((Collection<? extends OutputRuleElement>)newValue);
				return;
			case EmftvmPackage.RULE__ESUPER_RULES:
				getESuperRules().clear();
				getESuperRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case EmftvmPackage.RULE__ESUB_RULES:
				getESubRules().clear();
				getESubRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case EmftvmPackage.RULE__MATCHER:
				setMatcher((CodeBlock)newValue);
				return;
			case EmftvmPackage.RULE__APPLIER:
				setApplier((CodeBlock)newValue);
				return;
			case EmftvmPackage.RULE__POST_APPLY:
				setPostApply((CodeBlock)newValue);
				return;
			case EmftvmPackage.RULE__SUPER_RULES:
				getSuperRules().clear();
				getSuperRules().addAll((Collection<? extends String>)newValue);
				return;
			case EmftvmPackage.RULE__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case EmftvmPackage.RULE__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends Field>)newValue);
				return;
			case EmftvmPackage.RULE__DEFAULT:
				setDefault((Boolean)newValue);
				return;
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
				setDistinctElements((Boolean)newValue);
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
			case EmftvmPackage.RULE__MODULE:
				setModule((Module)null);
				return;
			case EmftvmPackage.RULE__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				getInputElements().clear();
				return;
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				getOutputElements().clear();
				return;
			case EmftvmPackage.RULE__ESUPER_RULES:
				getESuperRules().clear();
				return;
			case EmftvmPackage.RULE__ESUB_RULES:
				getESubRules().clear();
				return;
			case EmftvmPackage.RULE__MATCHER:
				setMatcher((CodeBlock)null);
				return;
			case EmftvmPackage.RULE__APPLIER:
				setApplier((CodeBlock)null);
				return;
			case EmftvmPackage.RULE__POST_APPLY:
				setPostApply((CodeBlock)null);
				return;
			case EmftvmPackage.RULE__SUPER_RULES:
				getSuperRules().clear();
				return;
			case EmftvmPackage.RULE__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case EmftvmPackage.RULE__FIELDS:
				getFields().clear();
				return;
			case EmftvmPackage.RULE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
				setDistinctElements(DISTINCT_ELEMENTS_EDEFAULT);
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
			case EmftvmPackage.RULE__MODULE:
				return getModule() != null;
			case EmftvmPackage.RULE__MODE:
				return mode != MODE_EDEFAULT;
			case EmftvmPackage.RULE__INPUT_ELEMENTS:
				return inputElements != null && !inputElements.isEmpty();
			case EmftvmPackage.RULE__OUTPUT_ELEMENTS:
				return outputElements != null && !outputElements.isEmpty();
			case EmftvmPackage.RULE__ESUPER_RULES:
				return eSuperRules != null && !eSuperRules.isEmpty();
			case EmftvmPackage.RULE__ESUB_RULES:
				return eSubRules != null && !eSubRules.isEmpty();
			case EmftvmPackage.RULE__MATCHER:
				return matcher != null;
			case EmftvmPackage.RULE__APPLIER:
				return applier != null;
			case EmftvmPackage.RULE__POST_APPLY:
				return postApply != null;
			case EmftvmPackage.RULE__SUPER_RULES:
				return superRules != null && !superRules.isEmpty();
			case EmftvmPackage.RULE__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case EmftvmPackage.RULE__FIELDS:
				return fields != null && !fields.isEmpty();
			case EmftvmPackage.RULE__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
			case EmftvmPackage.RULE__DISTINCT_ELEMENTS:
				return distinctElements != DISTINCT_ELEMENTS_EDEFAULT;
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

		StringBuffer result = new StringBuffer();
		if (abstract_) {
			result.append("abstract ");
		}
		result.append("rule ");
		result.append(super.toString());
		return result.toString();
	}

} //RuleImpl
