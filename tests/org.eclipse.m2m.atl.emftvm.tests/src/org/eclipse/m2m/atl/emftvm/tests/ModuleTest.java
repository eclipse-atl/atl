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

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Module;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Module</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getEImports() <em>EImports</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ModuleTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModuleTest.class);
	}

	/**
	 * Constructs a new Module test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Module test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Module getFixture() {
		return (Module)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createModule());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Module#getEImports() <em>EImports</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Module#getEImports()
	 * @generated NOT
	 */
	public void testGetEImports() {
		final Module module = getFixture();
		assertTrue(module.getEImports().isEmpty());
		final Module imported = EmftvmFactory.eINSTANCE.createModule();
		module.getEImports().add(imported);
		assertEquals(1, module.getEImports().size());
		assertTrue(module.getEImports().contains(imported));
		module.getEImports().remove(imported);
		assertTrue(module.getEImports().isEmpty());
		assertFalse(module.getEImports().contains(imported));
	}

} //ModuleTest
