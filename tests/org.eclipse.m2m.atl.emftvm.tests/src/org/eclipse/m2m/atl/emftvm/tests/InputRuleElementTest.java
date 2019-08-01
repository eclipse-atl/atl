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

import junit.textui.TestRunner;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Input Rule Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#createIterable(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Create Iterable</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class InputRuleElementTest extends RuleElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InputRuleElementTest.class);
	}

	/**
	 * Constructs a new Input Rule Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputRuleElementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Input Rule Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InputRuleElement getFixture() {
		return (InputRuleElement)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createInputRuleElement());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.InputRuleElement#createIterable(org.eclipse.m2m.atl.emftvm.ExecEnv)
	 * <em>Create Iterable</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.InputRuleElement#createIterable(org.eclipse.m2m.atl.emftvm.ExecEnv)
	 * @generated NOT
	 */
	public void testCreateIterable__ExecEnv() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

} //InputRuleElementTest
