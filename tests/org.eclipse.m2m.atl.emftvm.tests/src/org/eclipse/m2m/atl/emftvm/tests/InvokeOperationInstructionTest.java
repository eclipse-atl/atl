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

import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.InvokeOperationInstruction;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Invoke Operation Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class InvokeOperationInstructionTest extends InvokeInstructionTest {

	/**
	 * Constructs a new Invoke Operation Instruction test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeOperationInstructionTest(final String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Invoke Operation Instruction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InvokeOperationInstruction getFixture() {
		return (InvokeOperationInstruction)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackProduction()
	 * <em>Stack Production</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getStackProduction()
	 * @generated NOT
	 */
	@Override
	public void testGetStackProduction() {
		final Instruction fixture = this.getFixture();
		assertEquals(1, fixture.getStackProduction());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackConsumption()
	 * <em>Stack Consumption</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getStackConsumption()
	 * @generated NOT
	 */
	@Override
	public void testGetStackConsumption() {
		final Instruction fixture = this.getFixture();
		assertEquals(1, fixture.getStackConsumption());
	}

} //InvokeOperationInstructionTest
