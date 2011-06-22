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
 * A representation of the model object '<em><b>Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Instruction#getOwningBlock <em>Owning Block</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Instruction#getOpcode <em>Opcode</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackProduction <em>Stack Production</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackConsumption <em>Stack Consumption</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Instruction#getLineNumber <em>Line Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInstruction()
 * @model abstract="true"
 * @generated
 */
public interface Instruction extends EObject {
	/**
	 * Returns the value of the '<em><b>Owning Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Block</em>' container reference.
	 * @see #setOwningBlock(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInstruction_OwningBlock()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getCode
	 * @model opposite="code" required="true" transient="false"
	 * @generated
	 */
	CodeBlock getOwningBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Instruction#getOwningBlock <em>Owning Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Block</em>' container reference.
	 * @see #getOwningBlock()
	 * @generated
	 */
	void setOwningBlock(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Opcode</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.eclipse.m2m.atl.emftvm.Opcode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opcode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opcode</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.Opcode
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInstruction_Opcode()
	 * @model default="" required="true" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	Opcode getOpcode();

	/**
	 * Returns the value of the '<em><b>Stack Production</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack Production</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack Production</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInstruction_StackProduction()
	 * @model default="0" required="true" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	int getStackProduction();

	/**
	 * Returns the value of the '<em><b>Stack Consumption</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack Consumption</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack Consumption</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInstruction_StackConsumption()
	 * @model default="0" required="true" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	int getStackConsumption();

	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.LineNumber#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' reference.
	 * @see #setLineNumber(LineNumber)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getInstruction_LineNumber()
	 * @see org.eclipse.m2m.atl.emftvm.LineNumber#getInstructions
	 * @model opposite="instructions"
	 * @generated
	 */
	LineNumber getLineNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Instruction#getLineNumber <em>Line Number</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' reference.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(LineNumber value);

	/**
	 * <!-- begin-user-doc -->
	 * Calculates the amount of elements on the stack after executing this instruction,
	 * also taking into account the execution of previous instructions in the code block.
	 * @return the amount of elements on the stack after executing this instruction
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	int getStackLevel();

} // Instruction
