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
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Metamodel;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Metamodel</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Metamodel#findType(java.lang.String) <em>Find Type</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class MetamodelTest extends ModelTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MetamodelTest.class);
	}

	/**
	 * Constructs a new Metamodel test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Metamodel test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Metamodel getFixture() {
		return (Metamodel)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createMetamodel());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Metamodel#findType(java.lang.String) <em>Find Type</em>}' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Metamodel#findType(java.lang.String)
	 * @generated NOT
	 */
	public void testFindType__String() {
		final Metamodel metamodel = getFixture();
		metamodel.setResource(EmftvmPackage.eINSTANCE.eResource());
		assertSame(EmftvmPackage.eINSTANCE.getModule(), metamodel.findType("Module"));
		assertSame(EmftvmPackage.eINSTANCE.getModule(), metamodel.findType("emftvm::Module"));
	}

} //MetamodelTest
