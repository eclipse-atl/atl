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
 * A representation of the model object '<em><b>Branch Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getBranchInstruction()
 * @model abstract="true"
 * @generated
 */
public interface BranchInstruction extends Instruction {
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Represents the instruction offset to jump to.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getBranchInstruction_Offset()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * Represents the instruction offset to jump to.
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Represents the '<em>Target</em>' instruction to jump <em>over</em>, i.e. the
	 * '<em>Offset</em>' corresponds to the instruction following '<em>Target</em>'.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Instruction)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getBranchInstruction_Target()
	 * @model required="true" transient="true" volatile="true"
	 * @generated
	 */
	Instruction getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Represents the '<em>Target</em>' instruction to jump <em>over</em>, i.e. the
	 * '<em>Offset</em>' corresponds to the instruction following '<em>Target</em>'.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Instruction value);

} // BranchInstruction
