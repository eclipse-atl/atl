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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;

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
	public static void main(String[] args) {
		TestRunner.run(CodeBlockTest.class);
	}

	/**
	 * Constructs a new Code Block test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlockTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Code Block test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(CodeBlock fixture) {
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals() <em>Max Locals</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxLocals()
	 * @generated NOT
	 */
	public void testGetMaxLocals() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#setMaxLocals(int) <em>Max Locals</em>}' feature setter. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#setMaxLocals(int)
	 * @generated NOT
	 */
	public void testSetMaxLocals() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack() <em>Max Stack</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getMaxStack()
	 * @generated NOT
	 */
	public void testGetMaxStack() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#setMaxStack(int) <em>Max Stack</em>}' feature setter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#setMaxStack(int)
	 * @generated NOT
	 */
	public void testSetMaxStack() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#execute(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Execute</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#execute(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testExecute__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getStackLevel() <em>Get Stack Level</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getStackLevel()
	 * @generated NOT
	 */
	public void testGetStackLevel() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getModule() <em>Get Module</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getModule()
	 * @generated NOT
	 */
	public void testGetModule() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getOperation() <em>Get Operation</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getOperation()
	 * @generated NOT
	 */
	public void testGetOperation() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getField() <em>Get Field</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getField()
	 * @generated NOT
	 */
	public void testGetField() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get Predecessors</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetPredecessors__Instruction() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getAllPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get All Predecessors</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getAllPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetAllPredecessors__Instruction() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getNonLoopingPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * <em>Get Non Looping Predecessors</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getNonLoopingPredecessors(org.eclipse.m2m.atl.emftvm.Instruction)
	 * @generated NOT
	 */
	public void testGetNonLoopingPredecessors__Instruction() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

} //CodeBlockTest
