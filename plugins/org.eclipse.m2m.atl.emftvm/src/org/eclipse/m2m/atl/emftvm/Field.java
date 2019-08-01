/*******************************************************************************
 * Copyright (c) 2011-2012 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getStaticValue <em>Static Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getInitialiser <em>Initialiser</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getRule <em>Rule</em>}</li>
 * </ul>
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
	 * Returns the value of this {@link Field} for the given <code>context</code> object.
	 * @param context the context object
	 * @return the value of this {@link Field} for the given <code>context</code> object.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object getValue(Object context);

	/**
	 * <!-- begin-user-doc -->
	 * Sets the value of this {@link Field} for the given <code>context</code> object.
	 * @param context the context object
	 * @param value the field value to set
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setValue(Object context, Object value);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the value of this {@link Field} for the given <code>context</code> object.
	 * Evaluates the initial value using <code>frame</code> if necessary.
	 * @param context the context object
	 * @param frame the {@link StackFrame} in which to execute the initial value evaluator
	 * @return the value of this {@link Field} for the given <code>context</code> object.
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	Object getValue(Object context, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the static value of this {@link Field}.
	 * Evaluates the initial value using <code>frame</code> if necessary.
	 * @param frame the {@link StackFrame} in which to execute the initial value evaluator
	 * @return the static value of this {@link Field}.
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	Object getStaticValue(StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Clears all values of this {@link Field}.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clear();

	/**
	 * <!-- begin-user-doc -->
	 * Adds a value to this {@link Field} for the given <code>context</code> object.
	 * @param context the context object
	 * @param value the field value to add
	 * @param index the index to add the value at, or <code>-1</code>
	 * @param frame the {@link StackFrame} in which to execute the initial value evaluator
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void addValue(Object context, Object value, int index, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Removes a value from this {@link Field} for the given <code>context</code> object.
	 * @param context the context object
	 * @param value the field value to remove
	 * @param frame the {@link StackFrame} in which to execute the initial value evaluator
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void removeValue(Object context, Object value, StackFrame frame);
} // Field
