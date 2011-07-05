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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.FieldInstruction#getFieldname <em>Fieldname</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getFieldInstruction()
 * @model abstract="true"
 * @generated
 */
public interface FieldInstruction extends Instruction {
	/**
	 * Returns the value of the '<em><b>Fieldname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fieldname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fieldname</em>' attribute.
	 * @see #setFieldname(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getFieldInstruction_Fieldname()
	 * @model required="true"
	 * @generated
	 */
	String getFieldname();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.FieldInstruction#getFieldname <em>Fieldname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fieldname</em>' attribute.
	 * @see #getFieldname()
	 * @generated
	 */
	void setFieldname(String value);

} // FieldInstruction
