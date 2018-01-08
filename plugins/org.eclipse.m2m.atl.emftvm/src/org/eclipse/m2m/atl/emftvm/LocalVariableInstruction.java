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
 * A representation of the model object '<em><b>Local Variable Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getCbOffset <em>Cb Offset</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getLocalVariableIndex <em>Local Variable Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getLocalVariable <em>Local Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariableInstruction()
 * @model abstract="true"
 * @generated
 */
public interface LocalVariableInstruction extends Instruction {
	/**
	 * Returns the value of the '<em><b>Cb Offset</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cb Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cb Offset</em>' attribute.
	 * @see #setCbOffset(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariableInstruction_CbOffset()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getCbOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getCbOffset <em>Cb Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cb Offset</em>' attribute.
	 * @see #getCbOffset()
	 * @generated
	 */
	void setCbOffset(int value);

	/**
	 * Returns the value of the '<em><b>Slot</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariableInstruction_Slot()
	 * @model default="-1" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getSlot();

	/**
	 * Returns the value of the '<em><b>Local Variable Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Variable Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Variable Index</em>' attribute.
	 * @see #setLocalVariableIndex(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariableInstruction_LocalVariableIndex()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getLocalVariableIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getLocalVariableIndex <em>Local Variable Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Variable Index</em>' attribute.
	 * @see #getLocalVariableIndex()
	 * @generated
	 */
	void setLocalVariableIndex(int value);

	/**
	 * Returns the value of the '<em><b>Local Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Variable</em>' reference.
	 * @see #setLocalVariable(LocalVariable)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariableInstruction_LocalVariable()
	 * @model required="true" transient="true" volatile="true"
	 * @generated
	 */
	LocalVariable getLocalVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariableInstruction#getLocalVariable <em>Local Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Variable</em>' reference.
	 * @see #getLocalVariable()
	 * @generated
	 */
	void setLocalVariable(LocalVariable value);

} // LocalVariableInstruction
