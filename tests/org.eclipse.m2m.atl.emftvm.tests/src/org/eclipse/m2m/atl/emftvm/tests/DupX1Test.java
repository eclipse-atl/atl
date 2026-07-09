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

import org.eclipse.m2m.atl.emftvm.DupX1;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Opcode;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Dup x1</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * @generated
 */
public class DupX1Test extends InstructionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(final String[] args) {
		TestRunner.run(DupX1Test.class);
	}

	/**
	 * Constructs a new Dup X1 test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DupX1Test(final String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Dup X1 test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DupX1 getFixture() {
		return (DupX1)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createDupX1());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Instruction#getOpcode()
	 * <em>Opcode</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getOpcode()
	 * @generated NOT
	 */
	@Override
	public void testGetOpcode() {
		final Instruction fixture = this.getFixture();
		assertEquals(Opcode.DUP_X1, fixture.getOpcode());
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

		// Test that the default value is 0
		assertEquals(3, fixture.getStackProduction());
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
		assertEquals(2, fixture.getStackConsumption());
	}

} //Dup_x1Test
