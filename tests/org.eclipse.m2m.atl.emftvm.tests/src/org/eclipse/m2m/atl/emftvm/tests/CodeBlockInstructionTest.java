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

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.CodeBlockInstruction;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Code Block Instruction</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCbIndex() <em>Cb Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCodeBlock() <em>Code Block</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class CodeBlockInstructionTest extends InstructionTest {

	/**
	 * Constructs a new Code Block Instruction test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlockInstructionTest(final String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Code Block Instruction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CodeBlockInstruction getFixture() {
		return (CodeBlockInstruction)fixture;
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCbIndex() <em>Cb
	 * Index</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCbIndex()
	 * @generated NOT
	 */
	public void testGetCbIndex() {
		final CodeBlockInstruction fixture = this.getFixture();

		// Test that the default value is -1 (as specified in the interface)
		assertEquals(-1, fixture.getCbIndex());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#setCbIndex(int)
	 * <em>Cb Index</em>}' feature setter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#setCbIndex(int)
	 * @generated NOT
	 */
	public void testSetCbIndex() {
		final CodeBlockInstruction fixture = this.getFixture();

		// Test setting and getting a value
		final int expected = 5;
		fixture.setCbIndex(expected);
		assertEquals(expected, fixture.getCbIndex());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCodeBlock()
	 * <em>Code Block</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#getCodeBlock()
	 * @generated NOT
	 */
	public void testGetCodeBlock() {
		final CodeBlockInstruction fixture = this.getFixture();

		// Test that the default value is null (as specified in the interface)
		assertNull(fixture.getCodeBlock());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#setCodeBlock(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * <em>Code Block</em>}' feature setter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlockInstruction#setCodeBlock(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * @generated NOT
	 */
	public void testSetCodeBlock() {
		final CodeBlockInstruction fixture = this.getFixture();

		// Test setting and getting a value
		final CodeBlock expected = EmftvmFactory.eINSTANCE.createCodeBlock();
		fixture.setCodeBlock(expected);
		assertEquals(expected, fixture.getCodeBlock());
	}

} //CodeBlockInstructionTest
