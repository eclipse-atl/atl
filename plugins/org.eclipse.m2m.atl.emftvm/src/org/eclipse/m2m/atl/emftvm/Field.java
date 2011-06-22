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

import org.eclipse.m2m.atl.emftvm.util.StackFrame;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getStaticValue <em>Static Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getInitialiser <em>Initialiser</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getField()
 * @model
 * @generated
 */
public interface Field extends Feature {

	/**
	 * Returns the value of the '<em><b>Static Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Value</em>' attribute.
	 * @see #setStaticValue(Object)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getField_StaticValue()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	Object getStaticValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Field#getStaticValue <em>Static Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Value</em>' attribute.
	 * @see #getStaticValue()
	 * @generated
	 */
	void setStaticValue(Object value);

	/**
	 * Returns the value of the '<em><b>Initialiser</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getInitialiserFor <em>Initialiser For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialiser</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialiser</em>' containment reference.
	 * @see #setInitialiser(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getField_Initialiser()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getInitialiserFor
	 * @model opposite="initialiserFor" containment="true" required="true"
	 * @generated
	 */
	CodeBlock getInitialiser();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Field#getInitialiser <em>Initialiser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialiser</em>' containment reference.
	 * @see #getInitialiser()
	 * @generated
	 */
	void setInitialiser(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Rule#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(Rule)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getField_Rule()
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getFields
	 * @model opposite="fields" transient="false"
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Field#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object getValue(Object context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setValue(Object context, Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	Object getValue(Object context, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	Object getStaticValue(StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clear();
} // Field
