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
 * A representation of the model object '<em><b>Invoke Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.InvokeInstruction#getArgcount <em>Argcount</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInvokeInstruction()
 * @model abstract="true"
 * @generated
 */
public interface InvokeInstruction extends Instruction {
	/**
	 * Returns the value of the '<em><b>Argcount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argcount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argcount</em>' attribute.
	 * @see #setArgcount(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInvokeInstruction_Argcount()
	 * @model required="true"
	 * @generated
	 */
	int getArgcount();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.InvokeInstruction#getArgcount <em>Argcount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argcount</em>' attribute.
	 * @see #getArgcount()
	 * @generated
	 */
	void setArgcount(int value);

} // InvokeInstruction
