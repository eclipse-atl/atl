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
package org.eclipse.m2m.atl.emftvm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getModule <em>Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getInputElements <em>Input Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getOutputElements <em>Output Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getESuperRules <em>ESuper Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getESubRules <em>ESub Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getMatcher <em>Matcher</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getApplier <em>Applier</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getPostApply <em>Post Apply</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getSuperRules <em>Super Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getFields <em>Fields</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#isDistinctElements <em>Distinct Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Module</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Module#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' container reference.
	 * @see #setModule(Module)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_Module()
	 * @see org.eclipse.m2m.atl.emftvm.Module#getRules
	 * @model opposite="rules" transient="false"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Rule#getModule <em>Module</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' container reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.m2m.atl.emftvm.RuleMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.RuleMode
	 * @see #setMode(RuleMode)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_Mode()
	 * @model required="true"
	 * @generated
	 */
	RuleMode getMode();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Rule#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.RuleMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(RuleMode value);

	/**
	 * Returns the value of the '<em><b>Input Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.InputRuleElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#getInputFor <em>Input For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Elements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_InputElements()
	 * @see org.eclipse.m2m.atl.emftvm.InputRuleElement#getInputFor
	 * @model opposite="inputFor" containment="true" required="true"
	 * @generated
	 */
	EList<InputRuleElement> getInputElements();

	/**
	 * Returns the value of the '<em><b>Output Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.OutputRuleElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.OutputRuleElement#getOutputFor <em>Output For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Elements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_OutputElements()
	 * @see org.eclipse.m2m.atl.emftvm.OutputRuleElement#getOutputFor
	 * @model opposite="outputFor" containment="true"
	 * @generated
	 */
	EList<OutputRuleElement> getOutputElements();

	/**
	 * Returns the value of the '<em><b>ESuper Rules</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Rule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Rule#getESubRules <em>ESub Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ESuper Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ESuper Rules</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_ESuperRules()
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESubRules
	 * @model opposite="eSubRules" transient="true" derived="true"
	 * @generated
	 */
	EList<Rule> getESuperRules();

	/**
	 * Returns the value of the '<em><b>ESub Rules</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Rule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Rule#getESuperRules <em>ESuper Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ESub Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ESub Rules</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_ESubRules()
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESuperRules
	 * @model opposite="eSuperRules" transient="true" derived="true"
	 * @generated
	 */
	EList<Rule> getESubRules();

	/**
	 * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMatcherFor <em>Matcher For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher</em>' containment reference.
	 * @see #setMatcher(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_Matcher()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getMatcherFor
	 * @model opposite="matcherFor" containment="true"
	 * @generated
	 */
	CodeBlock getMatcher();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Rule#getMatcher <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher</em>' containment reference.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Applier</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getApplierFor <em>Applier For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applier</em>' containment reference.
	 * @see #setApplier(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_Applier()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getApplierFor
	 * @model opposite="applierFor" containment="true"
	 * @generated
	 */
	CodeBlock getApplier();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Rule#getApplier <em>Applier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applier</em>' containment reference.
	 * @see #getApplier()
	 * @generated
	 */
	void setApplier(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Post Apply</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getPostApplyFor <em>Post Apply For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Apply</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Apply</em>' containment reference.
	 * @see #setPostApply(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_PostApply()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getPostApplyFor
	 * @model opposite="postApplyFor" containment="true"
	 * @generated
	 */
	CodeBlock getPostApply();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Rule#getPostApply <em>Post Apply</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Apply</em>' containment reference.
	 * @see #getPostApply()
	 * @generated
	 */
	void setPostApply(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Super Rules</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Rules</em>' attribute list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_SuperRules()
	 * @model
	 * @generated
	 */
	EList<String> getSuperRules();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_Abstract()
	 * @model required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Rule#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Field}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Field#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_Fields()
	 * @see org.eclipse.m2m.atl.emftvm.Field#getRule
	 * @model opposite="rule" containment="true"
	 * @generated
	 */
	EList<Field> getFields();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_Default()
	 * @model required="true"
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Rule#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Distinct Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distinct Elements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distinct Elements</em>' attribute.
	 * @see #setDistinctElements(boolean)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRule_DistinctElements()
	 * @model required="true"
	 * @generated
	 */
	boolean isDistinctElements();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Rule#isDistinctElements <em>Distinct Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distinct Elements</em>' attribute.
	 * @see #isDistinctElements()
	 * @generated
	 */
	void setDistinctElements(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * Finds a {@link Field} registered within this {@link Rule}.
	 * @param context the context type of the field
	 * @param name the operation name
	 * @return the {@link Field} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Field findField(Object context, String name);

	/**
	 * <!-- begin-user-doc -->
	 * Finds a static {@link Field} registered within this {@link Rule}.
	 * @param context the context type of the field
	 * @param name the operation name
	 * @return the static {@link Field} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Field findStaticField(Object context, String name);

	/**
	 * <!-- begin-user-doc -->
	 * Registers a {@link Field} into this {@link Rule}.
	 * @param field the {@link Field} to register
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerField(Field field);

} // Rule
