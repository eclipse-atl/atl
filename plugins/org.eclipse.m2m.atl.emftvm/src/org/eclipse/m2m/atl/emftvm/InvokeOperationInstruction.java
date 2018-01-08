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

import java.lang.reflect.Method;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke Operation Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction#getOpname <em>Opname</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInvokeOperationInstruction()
 * @model abstract="true"
 * @generated
 */
public interface InvokeOperationInstruction extends InvokeInstruction {
	/**
	 * Returns the value of the '<em><b>Opname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opname</em>' attribute.
	 * @see #setOpname(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInvokeOperationInstruction_Opname()
	 * @model required="true"
	 * @generated
	 */
	String getOpname();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction#getOpname <em>Opname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opname</em>' attribute.
	 * @see #getOpname()
	 * @generated
	 */
	void setOpname(String value);

	/**
	 * Returns the recorded native method that was invoked as a result of this instruction.
	 * @return the recorded native method that was invoked as a result of this instruction.
	 */
	Method getNativeMethod();

	/**
	 * Sets the recorded native method that was invoked as a result of this instruction.
	 * @param method the recorded native method that was invoked as a result of this instruction
	 */
	void setNativeMethod(Method method);

} // InvokeOperationInstruction
