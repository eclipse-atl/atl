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

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Rule Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#getInputFor <em>Input For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#isMapsToSelf <em>Maps To Self</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInputRuleElement()
 * @model
 * @generated
 */
public interface InputRuleElement extends RuleElement {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getBindingFor <em>Binding For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' containment reference.
	 * @see #setBinding(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInputRuleElement_Binding()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getBindingFor
	 * @model opposite="bindingFor" containment="true"
	 * @generated
	 */
	CodeBlock getBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#getBinding <em>Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' containment reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Input For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Rule#getInputElements <em>Input Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input For</em>' container reference.
	 * @see #setInputFor(Rule)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInputRuleElement_InputFor()
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getInputElements
	 * @model opposite="inputElements" transient="false"
	 * @generated
	 */
	Rule getInputFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#getInputFor <em>Input For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input For</em>' container reference.
	 * @see #getInputFor()
	 * @generated
	 */
	void setInputFor(Rule value);

	/**
	 * Returns the value of the '<em><b>Maps To Self</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps To Self</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maps To Self</em>' attribute.
	 * @see #setMapsToSelf(boolean)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInputRuleElement_MapsToSelf()
	 * @model required="true"
	 * @generated
	 */
	boolean isMapsToSelf();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#isMapsToSelf <em>Maps To Self</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maps To Self</em>' attribute.
	 * @see #isMapsToSelf()
	 * @generated
	 */
	void setMapsToSelf(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link Iterable} of possible match values for this rule element.
	 * @param env the execution environment context
	 * @return a new {@link Iterable} of possible match values for this rule element.
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.m2m.atl.emftvm.EJavaIterable&lt;org.eclipse.emf.ecore.EObject&gt;"
	 * @generated
	 */
	Iterable<EObject> createIterable(ExecEnv env);

} // InputRuleElement
