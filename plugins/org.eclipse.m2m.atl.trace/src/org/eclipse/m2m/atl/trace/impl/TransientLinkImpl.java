/**
 * Copyright (C) 2009, Vrije Universiteit Brussel, Universidad de los Andes
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Andres Yie (Vrije Universiteit Brussel, Universidad de los Andes)
 * 	Dennis Wagelaar (Vrije Universiteit Brussel)
 *
 * $Id: TransientLinkImpl.java,v 1.1.2.3 2009/03/13 15:39:39 dwagelaar Exp $
 */
package org.eclipse.m2m.atl.trace.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.atl.trace.TracePackage;
import org.eclipse.m2m.atl.trace.TransientElement;
import org.eclipse.m2m.atl.trace.TransientLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transient Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.trace.impl.TransientLinkImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.trace.impl.TransientLinkImpl#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.trace.impl.TransientLinkImpl#getTargetElements <em>Target Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransientLinkImpl extends EObjectImpl implements TransientLink {
	/**
	 * The default value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected String rule = RULE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TransientElement> sourceElements;

	/**
	 * The cached value of the '{@link #getTargetElements() <em>Target Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TransientElement> targetElements;
	
	/**
	 * Map with the source elements of the transient link. The key of the map is the variable's name
	 */
	protected Map<String, EObject> sourceElementsMap;
	
	/**
	 * Map with the target elements of the transient link. The key of the map is the variable's name
	 */
	protected Map<String, EObject> targetElementsMap;
	
	/**
	 * Map with the variables of the transient link. The key of the map is the variable's name
	 */
	protected Map<String, Object> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected TransientLinkImpl() {
		super();
		
		sourceElements = new EObjectContainmentEList<TransientElement>(TransientElement.class, this, TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS);
		targetElements = new EObjectContainmentEList<TransientElement>(TransientElement.class, this, TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS);
		sourceElementsMap = new HashMap<String, EObject>();
		targetElementsMap = new HashMap<String, EObject>();
		variables = new HashMap<String, Object>();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRANSIENT_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Return the rule name 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Set the name of the rule
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(String newRule) {
		String oldRule = rule;
		rule = newRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRANSIENT_LINK__RULE, oldRule, rule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Return the source elements list
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransientElement> getSourceElements() {
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<TransientElement>(TransientElement.class, this, TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Return the target elements list
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransientElement> getTargetElements() {
		if (targetElements == null) {
			targetElements = new EObjectContainmentEList<TransientElement>(TransientElement.class, this, TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS);
		}
		return targetElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the value of a variable given its name
	 * @param 
	 * 			name of the variable
	 * @return 
	 * 			value of the variable
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getVariable(String name) {
		return (Object) variables.get(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Add a variable to the map
	 * @param 
	 * 			name name of the variable
	 * @param 
	 * 			element value of the variable
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addVariable(String name, Object element) {
		variables.put(name, element);
	}

	/**
	 * <!-- begin-user-doc -->
	 * add a new source element to the collection and map
	 * @param name
	 * 					variable's name of the element
	 * @param element
	 * 					source element to be added
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addSourceElement(String name, EObject element) {
		TransientElement te = new TransientElementImpl();
		te.setName(name);
		te.setValue((EObject) element);		
		
		this.sourceElements.add(te);
		this.sourceElementsMap.put(name, element);
	}

	/**
	 * <!-- begin-user-doc -->
	 * add a new target element to the collection and map
	 * @param name
	 * 					variable's name of the element
	 * @param element
	 * 					target element to be added
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addTargetElement(String name, EObject element) {
		TransientElement te = new TransientElementImpl();
		te.setName(name);
		te.setValue((EObject) element);		
	
		this.targetElements.add(te);
		this.targetElementsMap.put(name, element);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the target element for a given source element
	 * @param sourceElement
	 * 				source element 
	 * @return
	 * 				target element for the source element
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getTargetFromSource(EObject sourceElement) {
		EObject ret = null;
		
		if(!this.targetElements.isEmpty()) {
			ret = (EObject)((TransientElement) this.targetElements.iterator().next()).getValue();
		}
		
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns a target element for a given source element and variable name
	 * @param source
	 * 				source element
	 * @param name
	 * 				variable naem of the target element
	 * @return
	 * 				the target element for the given source element and variable name
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getNamedTargetFromSource(EObject source, String name) {
		EObject ret = null;
		
		if(!this.targetElements.isEmpty()) {
			ret = (EObject)( this.targetElementsMap.get(name));
		}
		
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method allows for retrieving all source elements for this link
	 * without knowing the local variable names of the rule
	 * that created the mappings. This reduces fragility.
	 * @param 
	 * 			frame
	 * @param 
	 * 			self
	 * @return 
	 * 			A Map of source element names to target elements for this link.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<String, EObject> getSourceElementsMap() {
		return this.sourceElementsMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method allows for retrieving all target elements for this link
	 * without knowing the local variable names of the rule
	 * that created the mappings. This reduces fragility.
	 * @param 
	 * 			frame
	 * @param 
	 * 			self
	 * @return 
	 * 			A Map of target element names to target elements for this link.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<String, EObject> getTargetElementsMap() {
		return this.targetElementsMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the source element for a given variable name
	 * @param varName
	 * 				variable name
	 * @return
	 * 				source element for the variable name
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getSourceElement(String varName) {
		return (EObject) this.sourceElementsMap.get(varName);

	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the target element for a given variable name
	 * @param varName
	 * 				variable name
	 * @return
	 * 				target element for the variable name
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getTargetElement(String varName) {
		return (EObject) this.targetElementsMap.get(varName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				return ((InternalEList<?>)getSourceElements()).basicRemove(otherEnd, msgs);
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				return ((InternalEList<?>)getTargetElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.TRANSIENT_LINK__RULE:
				return getRule();
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				return getSourceElements();
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				return getTargetElements();
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
			case TracePackage.TRANSIENT_LINK__RULE:
				setRule((String)newValue);
				return;
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends TransientElement>)newValue);
				return;
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				getTargetElements().clear();
				getTargetElements().addAll((Collection<? extends TransientElement>)newValue);
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
			case TracePackage.TRANSIENT_LINK__RULE:
				setRule(RULE_EDEFAULT);
				return;
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				getSourceElements().clear();
				return;
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				getTargetElements().clear();
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
			case TracePackage.TRANSIENT_LINK__RULE:
				return RULE_EDEFAULT == null ? rule != null : !RULE_EDEFAULT.equals(rule);
			case TracePackage.TRANSIENT_LINK__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
			case TracePackage.TRANSIENT_LINK__TARGET_ELEMENTS:
				return targetElements != null && !targetElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (rule: ");
		result.append(rule);
		result.append(')');
		return result.toString();
	}

} //TransientLinkImpl
