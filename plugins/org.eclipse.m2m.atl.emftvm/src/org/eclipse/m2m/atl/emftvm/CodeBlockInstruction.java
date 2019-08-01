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
 * A representation of the model object '<em><b>Code Block Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCbIndex <em>Cb Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCodeBlock <em>Code Block</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlockInstruction()
 * @model abstract="true"
 * @generated
 */
public interface CodeBlockInstruction extends Instruction {
	/**
	 * Returns the value of the '<em><b>Code Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Represents the '{@link CodeBlock#getNested() <em>Nested</em>}' {@link CodeBlock} to which this instruction refers.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code Block</em>' reference.
	 * @see #setCodeBlock(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlockInstruction_CodeBlock()
	 * @model required="true" transient="true" volatile="true"
	 * @generated
	 */
	CodeBlock getCodeBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCodeBlock <em>Code Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Represents the '{@link CodeBlock#getNested() <em>Nested</em>}' {@link CodeBlock} to which this instruction refers.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code Block</em>' reference.
	 * @see #getCodeBlock()
	 * @generated
	 */
	void setCodeBlock(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Cb Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Represents the index of the '{@link CodeBlock#getNested() <em>Nested</em>}' {@link CodeBlock}
	 * in the parent code block's list of nested code blocks.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cb Index</em>' attribute.
	 * @see #setCbIndex(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getCodeBlockInstruction_CbIndex()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getCbIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCbIndex <em>Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Represents the index of the '{@link CodeBlock#getNested() <em>Nested</em>}' {@link CodeBlock}
	 * in the parent code block's list of nested code blocks.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cb Index</em>' attribute.
	 * @see #getCbIndex()
	 * @generated
	 */
	void setCbIndex(int value);

} // CodeBlockInstruction
