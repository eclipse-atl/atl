/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Variable</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getOwningBlock <em>Owning Block</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstruction <em>Start Instruction</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstruction <em>End Instruction</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstructionIndex <em>Start Instruction Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstructionIndex <em>End Instruction Index</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariable()
 * @model
 * @generated
 */
public interface LocalVariable extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Slot</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Automatically assigns a free slot for local variables without a slot.
	 * Verifies that previous overlapping local variables have a unique slot.
	 * Attempts to reuse free slots.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot</em>' attribute.
	 * @see #setSlot(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariable_Slot()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getSlot();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getSlot <em>Slot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot</em>' attribute.
	 * @see #getSlot()
	 * @generated
	 */
	void setSlot(int value);

	/**
	 * Returns the value of the '<em><b>Start Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Instruction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Instruction</em>' reference.
	 * @see #setStartInstruction(Instruction)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariable_StartInstruction()
	 * @model transient="true"
	 * @generated
	 */
	Instruction getStartInstruction();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstruction <em>Start Instruction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Instruction</em>' reference.
	 * @see #getStartInstruction()
	 * @generated
	 */
	void setStartInstruction(Instruction value);

	/**
	 * Returns the value of the '<em><b>End Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Instruction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Instruction</em>' reference.
	 * @see #setEndInstruction(Instruction)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariable_EndInstruction()
	 * @model transient="true"
	 * @generated
	 */
	Instruction getEndInstruction();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstruction <em>End Instruction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Instruction</em>' reference.
	 * @see #getEndInstruction()
	 * @generated
	 */
	void setEndInstruction(Instruction value);

	/**
	 * Returns the value of the '<em><b>Start Instruction Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Instruction Index</em>' attribute.
	 * @see #setStartInstructionIndex(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariable_StartInstructionIndex()
	 * @model default="-1" volatile="true" derived="true"
	 * @generated
	 */
	int getStartInstructionIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstructionIndex <em>Start Instruction Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Instruction Index</em>' attribute.
	 * @see #getStartInstructionIndex()
	 * @generated
	 */
	void setStartInstructionIndex(int value);

	/**
	 * Returns the value of the '<em><b>End Instruction Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Instruction Index</em>' attribute.
	 * @see #setEndInstructionIndex(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariable_EndInstructionIndex()
	 * @model default="-1" volatile="true" derived="true"
	 * @generated
	 */
	int getEndInstructionIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstructionIndex <em>End Instruction Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Instruction Index</em>' attribute.
	 * @see #getEndInstructionIndex()
	 * @generated
	 */
	void setEndInstructionIndex(int value);

	/**
	 * Returns the value of the '<em><b>Owning Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getLocalVariables <em>Local Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Block</em>' container reference.
	 * @see #setOwningBlock(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getLocalVariable_OwningBlock()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getLocalVariables
	 * @model opposite="localVariables" required="true" transient="false"
	 * @generated
	 */
	CodeBlock getOwningBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getOwningBlock <em>Owning Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Block</em>' container reference.
	 * @see #getOwningBlock()
	 * @generated
	 */
	void setOwningBlock(CodeBlock value);

} // LocalVariable
