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
package org.eclipse.m2m.atl.emftvm.tests;

import org.eclipse.m2m.atl.emftvm.BranchInstruction;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Instruction;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Branch Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getOffset() <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getTarget() <em>Target</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class BranchInstructionTest extends InstructionTest {

	/**
	 * Constructs a new Branch Instruction test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchInstructionTest(final String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Branch Instruction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected BranchInstruction getFixture() {
		return (BranchInstruction)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getOffset()
	 * <em>Offset</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.BranchInstruction#getOffset()
	 * @generated NOT
	 */
	public void testGetOffset() {
		final BranchInstruction fixture = this.getFixture();
		assertEquals(-1, fixture.getOffset());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#setOffset(int)
	 * <em>Offset</em>}' feature setter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.BranchInstruction#setOffset(int)
	 * @generated NOT
	 */
	public void testSetOffset() {
		final BranchInstruction fixture = this.getFixture();
		final int expectedOffset = 10;
		fixture.setOffset(expectedOffset);
		assertEquals(expectedOffset, fixture.getOffset());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#getTarget()
	 * <em>Target</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.BranchInstruction#getTarget()
	 * @generated NOT
	 */
	public void testGetTarget() {
		final BranchInstruction fixture = this.getFixture();
		assertEquals((Instruction) null, fixture.getTarget());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.BranchInstruction#setTarget(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Target</em>}' feature setter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.BranchInstruction#setTarget(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testSetTarget() {
		final BranchInstruction fixture = this.getFixture();
		final Instruction target = EmftvmFactory.eINSTANCE.createAdd();
		fixture.setTarget(target);
		final Instruction actualTarget = fixture.getTarget();
		assertEquals(target, actualTarget);
	}

} //BranchInstructionTest
