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
package org.eclipse.m2m.atl.emftvm.trace.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.SourceElementList;
import org.eclipse.m2m.atl.emftvm.trace.TraceFactory;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;


/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Source Element List</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getSourceObjects() <em>Get Source Objects</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SourceElementListTest extends TestCase {

	/**
	 * The fixture for this Source Element List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceElementList fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SourceElementListTest.class);
	}

	/**
	 * Constructs a new Source Element List test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceElementListTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Source Element List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SourceElementList fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Source Element List test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceElementList getFixture() {
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
		setFixture(TraceFactory.eINSTANCE.createSourceElementList());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getSourceObjects() <em>Get Source Objects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getSourceObjects()
	 * @generated NOT
	 */
	public void testGetSourceObjects() {
		final EObject se1Object = EcoreFactory.eINSTANCE.createEObject();
		final EObject se2Object = EcoreFactory.eINSTANCE.createEObject();
		
		final TraceLink link = TraceFactory.eINSTANCE.createTraceLink();
		
		final SourceElement se1 = link.getSourceElement("se1", true);
		assertEquals("se1", se1.getName());
		se1.setObject(se1Object);
		
		final SourceElement se2 = link.getSourceElement("se2", true);
		assertEquals("se2", se2.getName());
		se2.setObject(se2Object);
		
		fixture.getSourceElements().add(se1);
		assertTrue(fixture.getSourceObjects().contains(se1Object));
		fixture.getSourceElements().add(se2);
		assertTrue(fixture.getSourceObjects().contains(se2Object));
		
		final EList<EObject> sourceObjects = new BasicEList<EObject>();
		sourceObjects.add(se1Object);
		sourceObjects.add(se2Object);
		assertEquals(sourceObjects, fixture.getSourceObjects());
	}

} //SourceElementListTest
