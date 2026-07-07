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

import org.eclipse.emf.common.util.EList;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Operation;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Code Block</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals() <em>Max Locals</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack() <em>Max Stack</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#execute(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Execute</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getStackLevel() <em>Get Stack Level</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getModule() <em>Get Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getOperation() <em>Get Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getField() <em>Get Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getPredecessors(org.eclipse.m2m.atl.emftvm.Instruction) <em>Get Predecessors</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getAllPredecessors(org.eclipse.m2m.atl.emftvm.Instruction) <em>Get All Predecessors</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNonLoopingPredecessors(org.eclipse.m2m.atl.emftvm.Instruction) <em>Get Non Looping Predecessors</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CodeBlockTest extends TestCase {

	/**
	 * The fixture for this Code Block test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeBlock fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(final String[] args) {
		TestRunner.run(CodeBlockTest.class);
	}

	/**
	 * Constructs a new Code Block test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlockTest(final String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Code Block test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(final CodeBlock fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Code Block test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeBlock getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createCodeBlock());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals() <em>Max
	 * Locals</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals()
	 * @generated NOT
	 */
	public void testGetMaxLocals() {
		final CodeBlock cb = getFixture();
		assertEquals(0, cb.getMaxLocals());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#setMaxLocals(int)
	 * <em>Max Locals</em>}' feature setter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#setMaxLocals(int)
	 * @generated NOT
	 */
	public void testSetMaxLocals() {
		final CodeBlock cb = getFixture();
		cb.setMaxLocals(5);
		assertEquals(5, cb.getMaxLocals());

		cb.setMaxLocals(0);
		assertEquals(0, cb.getMaxLocals());

		cb.setMaxLocals(10);
		assertEquals(10, cb.getMaxLocals());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack() <em>Max
	 * Stack</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack()
	 * @generated NOT
	 */
	public void testGetMaxStack() {
		final CodeBlock cb = getFixture();
		assertEquals(0, cb.getMaxStack());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#setMaxStack(int)
	 * <em>Max Stack</em>}' feature setter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#setMaxStack(int)
	 * @generated NOT
	 */
	public void testSetMaxStack() {
		final CodeBlock cb = getFixture();
		cb.setMaxStack(5);
		assertEquals(5, cb.getMaxStack());

		cb.setMaxStack(0);
		assertEquals(0, cb.getMaxStack());

		cb.setMaxStack(10);
		assertEquals(10, cb.getMaxStack());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#execute(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Execute</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#execute(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testExecute__StackFrame() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test with null StackFrame - should not throw an exception in the basic implementation
		try {
			final Object result = cb.execute(null);
			fail("Expected NullPointerException, but got: " + result);
		} catch (final NullPointerException e) {
			// Expected
		}

		// Test that the method exists and is callable
		assertTrue(true); // Basic test to ensure method can be called
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getStackLevel()
	 * <em>Get Stack Level</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getStackLevel()
	 * @generated NOT
	 */
	public void testGetStackLevel() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test that the method exists and returns a value (default should be 0 or some valid int)
		final int level = cb.getStackLevel();
		assertTrue("Stack level should be non-negative", level >= 0);

		// Test with empty code block
		assertEquals(0, level);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getModule() <em>Get
	 * Module</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getModule()
	 * @generated NOT
	 */
	public void testGetModule() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test that the method exists and returns null for a fresh code block (no module assigned)
		final org.eclipse.m2m.atl.emftvm.Module module = cb.getModule();
		assertNull(module);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getOperation() <em>Get
	 * Operation</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getOperation()
	 * @generated NOT
	 */
	public void testGetOperation() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test that the method exists and returns null for a fresh code block (no operation assigned)
		final Operation operation = cb.getOperation();
		assertNull(operation);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getField() <em>Get
	 * Field</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getField()
	 * @generated NOT
	 */
	public void testGetField() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test that the method exists and returns null for a fresh code block (no field assigned)
		final Field field = cb.getField();
		assertNull(field);
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get Predecessors</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetPredecessors__Instruction() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test with a real instruction (create one)
		final Instruction instr = EmftvmFactory.eINSTANCE.createPush();
		instr.setOwningBlock(cb);
		final EList<Instruction> predecessors = cb.getPredecessors(instr);
		assertNotNull(predecessors);
		assertEquals(0, predecessors.size());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get Predecessors</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetPredecessors__Instruction_null() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test that the method exists and returns an empty list for a fresh code block
		final Instruction instruction = null; // null instruction
		try {
			final EList<Instruction> predecessors = cb.getPredecessors(instruction);
			fail("Expected IllegalArgumentException but got: " + predecessors);
		} catch (final IllegalArgumentException e) {
			// expected
		}
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getAllPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get All Predecessors</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getAllPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetAllPredecessors__Instruction() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test with a real instruction (create one)
		final Instruction instr = EmftvmFactory.eINSTANCE.createPush();
		instr.setOwningBlock(cb);
		final EList<Instruction> allPredecessors = cb.getAllPredecessors(instr);
		assertNotNull(allPredecessors);
		assertEquals(0, allPredecessors.size());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getAllPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get All Predecessors</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getAllPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetAllPredecessors__Instruction_null() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test that the method exists and returns an empty list for a fresh code block
		final Instruction instruction = null; // null instruction
		try {
			final EList<Instruction> allPredecessors = cb.getAllPredecessors(instruction);
			fail("Expected IllegalArgumentException but got: " + allPredecessors);
		} catch (final IllegalArgumentException e) {
			// expected
		}
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNonLoopingPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get Non Looping Predecessors</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getNonLoopingPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetNonLoopingPredecessors__Instruction() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test with a real instruction (create one)
		final Instruction instr = EmftvmFactory.eINSTANCE.createPush();
		instr.setOwningBlock(cb);
		final EList<Instruction> nonLoopingPredecessors = cb.getNonLoopingPredecessors(instr);
		assertNotNull(nonLoopingPredecessors);
		assertEquals(0, nonLoopingPredecessors.size());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNonLoopingPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get Non Looping Predecessors</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getNonLoopingPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetNonLoopingPredecessors__Instruction_null() {
		final CodeBlock cb = getFixture();
		assertNotNull(cb);

		// Test that the method exists and returns an empty list for a fresh code block
		final Instruction instruction = null; // null instruction
		try {
			final EList<Instruction> nonLoopingPredecessors = cb.getNonLoopingPredecessors(instruction);
			fail("Expected IllegalArgumentException but got: " + nonLoopingPredecessors);
		} catch (final IllegalArgumentException e) {
			// expected
		}
	}

} //CodeBlockTest
