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
package org.eclipse.m2m.atl.emftvm.tests;

import junit.textui.TestRunner;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.Opcode;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Local Variable</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getSlot() <em>Slot</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstructionIndex() <em>Start Instruction Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstructionIndex() <em>End Instruction Index</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class LocalVariableTest extends TypedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LocalVariableTest.class);
	}

	/**
	 * Constructs a new Local Variable test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariableTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Local Variable test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LocalVariable getFixture() {
		return (LocalVariable)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createLocalVariable());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getSlot() <em>Slot</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getSlot()
	 * @generated NOT
	 */
	public void testGetSlot() {
		final LocalVariable localVar = getFixture();
		assertEquals(-1, localVar.getSlot());
		// Test with code block
		final CodeBlock cb = EmftvmFactory.eINSTANCE.createCodeBlock();
		localVar.setOwningBlock(cb);
		assertEquals(0, localVar.getSlot());
		// Test with two variables
		final CodeBlock cb2 = EmftvmFactory.eINSTANCE.createCodeBlock();
		final LocalVariable lv = EmftvmFactory.eINSTANCE.createLocalVariable();
		final LocalVariable lv2 = EmftvmFactory.eINSTANCE.createLocalVariable();
		lv.setOwningBlock(cb2);
		lv2.setOwningBlock(cb2);
		assertEquals(0, lv.getSlot());
		assertEquals(1, lv2.getSlot());
		// Test with slot reuse
		final CodeBlock cb3 = EmftvmFactory.eINSTANCE.createCodeBlock();
		final Instruction ins1 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHT);
		final Instruction ins2 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.POP);
		final Instruction ins3 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHF);
		ins1.setOwningBlock(cb3);
		ins2.setOwningBlock(cb3);
		ins3.setOwningBlock(cb3);
		final LocalVariable lv3 = EmftvmFactory.eINSTANCE.createLocalVariable();
		final LocalVariable lv4 = EmftvmFactory.eINSTANCE.createLocalVariable();
		lv3.setOwningBlock(cb3);
		lv4.setOwningBlock(cb3);
		lv3.setStartInstruction(ins1);
		lv3.setEndInstruction(ins2);
		lv4.setStartInstruction(ins3);
		lv4.setEndInstruction(ins3);
		assertEquals(0, lv3.getSlot());
		assertEquals(0, lv4.getSlot());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#setSlot(int) <em>Slot</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#setSlot(int)
	 * @generated NOT
	 */
	public void testSetSlot() {
		final LocalVariable localVar = getFixture();
		localVar.setSlot(2);
		assertEquals(2, localVar.getSlot());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstructionIndex() <em>Start Instruction Index</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getStartInstructionIndex()
	 * @generated NOT
	 */
	public void testGetStartInstructionIndex() {
		final LocalVariable localVar = getFixture();
		assertEquals(-1, localVar.getStartInstructionIndex());

		final CodeBlock cb = EmftvmFactory.eINSTANCE.createCodeBlock();
		final Instruction ins1 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHT);
		final Instruction ins2 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.POP);
		final Instruction ins3 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHF);
		ins1.setOwningBlock(cb);
		ins2.setOwningBlock(cb);
		ins3.setOwningBlock(cb);
		localVar.setOwningBlock(cb);
		localVar.setStartInstruction(ins2);
		assertEquals(1, localVar.getStartInstructionIndex());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#setStartInstructionIndex(int) <em>Start Instruction Index</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#setStartInstructionIndex(int)
	 * @generated NOT
	 */
	public void testSetStartInstructionIndex() {
		final LocalVariable localVar = getFixture();
		localVar.setStartInstructionIndex(1);
		assertEquals(1, localVar.getStartInstructionIndex());

		final CodeBlock cb = EmftvmFactory.eINSTANCE.createCodeBlock();
		final Instruction ins1 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHT);
		final Instruction ins2 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.POP);
		final Instruction ins3 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHF);
		ins1.setOwningBlock(cb);
		ins2.setOwningBlock(cb);
		ins3.setOwningBlock(cb);
		localVar.setOwningBlock(cb);
		assertEquals(ins2, localVar.getStartInstruction());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstructionIndex() <em>End Instruction Index</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#getEndInstructionIndex()
	 * @generated NOT
	 */
	public void testGetEndInstructionIndex() {
		final LocalVariable localVar = getFixture();
		assertEquals(-1, localVar.getEndInstructionIndex());

		final CodeBlock cb = EmftvmFactory.eINSTANCE.createCodeBlock();
		final Instruction ins1 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHT);
		final Instruction ins2 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.POP);
		final Instruction ins3 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHF);
		ins1.setOwningBlock(cb);
		ins2.setOwningBlock(cb);
		ins3.setOwningBlock(cb);
		localVar.setOwningBlock(cb);
		localVar.setEndInstruction(ins2);
		assertEquals(1, localVar.getEndInstructionIndex());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.LocalVariable#setEndInstructionIndex(int) <em>End Instruction Index</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.LocalVariable#setEndInstructionIndex(int)
	 * @generated NOT
	 */
	public void testSetEndInstructionIndex() {
		final LocalVariable localVar = getFixture();
		localVar.setEndInstructionIndex(1);
		assertEquals(1, localVar.getEndInstructionIndex());

		final CodeBlock cb = EmftvmFactory.eINSTANCE.createCodeBlock();
		final Instruction ins1 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHT);
		final Instruction ins2 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.POP);
		final Instruction ins3 = EmftvmFactory.eINSTANCE.createInstruction(Opcode.PUSHF);
		ins1.setOwningBlock(cb);
		ins2.setOwningBlock(cb);
		ins3.setOwningBlock(cb);
		localVar.setOwningBlock(cb);
		assertEquals(ins2, localVar.getEndInstruction());
	}

} //LocalVariableTest
