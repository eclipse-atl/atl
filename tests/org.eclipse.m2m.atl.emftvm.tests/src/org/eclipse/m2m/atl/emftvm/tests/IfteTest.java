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
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Ifte;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Opcode;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Ifte</b></em>'.
 *
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a> <!--
 *         end-user-doc -->
 *         <p>
 *         The following features are tested:
 *         <ul>
 *         <li>{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCbIndex() <em>Then
 *         Cb Index</em>}</li>
 *         <li>{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCbIndex() <em>Else
 *         Cb Index</em>}</li>
 *         <li>{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCb() <em>Then
 *         Cb</em>}</li>
 *         <li>{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCb() <em>Else
 *         Cb</em>}</li>
 *         </ul>
 *         </p>
 * @generated
 */
public class IfteTest extends InstructionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(final String[] args) {
		TestRunner.run(IfteTest.class);
	}

	/**
	 * Constructs a new Ifte test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfteTest(final String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ifte test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Ifte getFixture() {
		return (Ifte)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createIfte());
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
		assertEquals(Opcode.IFTE, fixture.getOpcode());
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

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCbIndex() <em>Then
	 * Cb Index</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#getThenCbIndex()
	 * @generated NOT
	 */
	public void testGetThenCbIndex() {
		assertEquals(-1, getFixture().getThenCbIndex());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Ifte#setThenCbIndex(int)
	 * <em>Then Cb Index</em>}' feature setter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#setThenCbIndex(int)
	 * @generated NOT
	 */
	public void testSetThenCbIndex() {
		final Ifte fixture = getFixture();
		fixture.setThenCbIndex(5);
		assertEquals(5, fixture.getThenCbIndex());
		fixture.setThenCbIndex(0);
		assertEquals(0, fixture.getThenCbIndex());
		fixture.setThenCbIndex(-1);
		assertEquals(-1, fixture.getThenCbIndex());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCbIndex() <em>Else
	 * Cb Index</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#getElseCbIndex()
	 * @generated NOT
	 */
	public void testGetElseCbIndex() {
		assertEquals(-1, getFixture().getElseCbIndex());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Ifte#setElseCbIndex(int)
	 * <em>Else Cb Index</em>}' feature setter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#setElseCbIndex(int)
	 * @generated NOT
	 */
	public void testSetElseCbIndex() {
		final Ifte fixture = getFixture();
		fixture.setElseCbIndex(5);
		assertEquals(5, fixture.getElseCbIndex());
		fixture.setElseCbIndex(0);
		assertEquals(0, fixture.getElseCbIndex());
		fixture.setElseCbIndex(-1);
		assertEquals(-1, fixture.getElseCbIndex());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCb() <em>Then
	 * Cb</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#getThenCb()
	 * @generated NOT
	 */
	public void testGetThenCb() {
		assertEquals(null, getFixture().getThenCb());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Ifte#setThenCb(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * <em>Then Cb</em>}' feature setter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#setThenCb(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * @generated NOT
	 */
	public void testSetThenCb() {
		final Ifte fixture = getFixture();
		final CodeBlock codeBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		fixture.setThenCb(codeBlock);
		assertEquals(codeBlock, fixture.getThenCb());
		fixture.setThenCb(null);
		assertEquals(null, fixture.getThenCb());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Ifte#setThenCb(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * <em>Then Cb</em>}' feature setter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#setThenCb(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * @generated NOT
	 */
	public void testSetThenCb_index() {
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		final CodeBlock nestedBlock1 = EmftvmFactory.eINSTANCE.createCodeBlock();
		final CodeBlock nestedBlock2 = EmftvmFactory.eINSTANCE.createCodeBlock();
		owningBlock.getNested().add(nestedBlock1);
		owningBlock.getNested().add(nestedBlock2);

		final Ifte fixture = getFixture();
		owningBlock.getCode().add(fixture);

		fixture.setThenCb(nestedBlock1);
		assertEquals(nestedBlock1, fixture.getThenCb());
		assertEquals(0, fixture.getThenCbIndex());

		fixture.setThenCb(nestedBlock2);
		assertEquals(nestedBlock2, fixture.getThenCb());
		assertEquals(1, fixture.getThenCbIndex());

		fixture.setThenCb(null);
		assertEquals(null, fixture.getThenCb());
		assertEquals(-1, fixture.getThenCbIndex());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCb() <em>Else
	 * Cb</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#getElseCb()
	 * @generated NOT
	 */
	public void testGetElseCb() {
		assertEquals(null, getFixture().getElseCb());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Ifte#setElseCb(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * <em>Else Cb</em>}' feature setter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#setElseCb(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * @generated NOT
	 */
	public void testSetElseCb() {
		final Ifte fixture = getFixture();
		final CodeBlock codeBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		fixture.setElseCb(codeBlock);
		assertEquals(codeBlock, fixture.getElseCb());
		fixture.setElseCb(null);
		assertEquals(null, fixture.getElseCb());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Ifte#setElseCb(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * <em>Else Cb</em>}' feature setter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Ifte#setElseCb(org.eclipse.m2m.atl.emftvm.CodeBlock)
	 * @generated NOT
	 */
	public void testSetElseCb_index() {
		final CodeBlock owningBlock = EmftvmFactory.eINSTANCE.createCodeBlock();
		final CodeBlock nestedBlock1 = EmftvmFactory.eINSTANCE.createCodeBlock();
		final CodeBlock nestedBlock2 = EmftvmFactory.eINSTANCE.createCodeBlock();
		owningBlock.getNested().add(nestedBlock1);
		owningBlock.getNested().add(nestedBlock2);

		final Ifte fixture = getFixture();
		owningBlock.getCode().add(fixture);

		fixture.setElseCb(nestedBlock1);
		assertEquals(nestedBlock1, fixture.getElseCb());
		assertEquals(0, fixture.getElseCbIndex());

		fixture.setElseCb(nestedBlock2);
		assertEquals(nestedBlock2, fixture.getElseCb());
		assertEquals(1, fixture.getElseCbIndex());

		fixture.setElseCb(null);
		assertEquals(null, fixture.getElseCb());
		assertEquals(-1, fixture.getElseCbIndex());
	}

} //IfteTest
