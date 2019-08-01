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
package org.eclipse.m2m.atl.emftvm.trace.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.TargetElement;
import org.eclipse.m2m.atl.emftvm.trace.TraceFactory;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Link</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getSourceElement(java.lang.String, boolean) <em>Get Source Element</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getTargetElement(java.lang.String) <em>Get Target Element</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TraceLinkTest extends TestCase {

	/**
	 * The fixture for this Link test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceLink fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TraceLinkTest.class);
	}

	/**
	 * Constructs a new Link test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLinkTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Link test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(TraceLink fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Link test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceLink getFixture() {
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
		setFixture(TraceFactory.eINSTANCE.createTraceLink());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getSourceElement(java.lang.String, boolean) <em>Get Source Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#getSourceElement(java.lang.String, boolean)
	 * @generated NOT
	 */
	public void testGetSourceElement__String_boolean() {
		final SourceElement se = fixture.getSourceElement("se", true);
		assertEquals("se", se.getName());

		final SourceElement se2 = fixture.getSourceElement("se2", false);
		assertNull(se2);

		final SourceElement se3 = TraceFactory.eINSTANCE.createSourceElement();
		se3.setName("se3");
		fixture.getSourceElements().add(se3);
		assertEquals(se3, fixture.getSourceElement("se3", false));
		assertEquals(se3, fixture.getSourceElement("se3", true));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getTargetElement(java.lang.String) <em>Get Target Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#getTargetElement(java.lang.String)
	 * @generated NOT
	 */
	public void testGetTargetElement__String() {
		final TargetElement te = fixture.getTargetElement("te");
		assertNull(te);
		
		final TargetElement te2 = TraceFactory.eINSTANCE.createTargetElement();
		te2.setName("te2");
		fixture.getTargetElements().add(te2);
		assertEquals(te2, fixture.getTargetElement("te2"));
	}

} //TraceLinkTest
