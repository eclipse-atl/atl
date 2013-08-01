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
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;


/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Link Set</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElement(java.lang.Object) <em>Get Default Source Element</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElements(java.util.List) <em>Get Default Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getLinksByRule(java.lang.String, boolean) <em>Get Links By Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#clear() <em>Clear</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TraceLinkSetTest extends TestCase {

	/**
	 * The fixture for this Link Set test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceLinkSet fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TraceLinkSetTest.class);
	}

	/**
	 * Constructs a new Link Set test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLinkSetTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Link Set test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(TraceLinkSet fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Link Set test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceLinkSet getFixture() {
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
		setFixture(TraceFactory.eINSTANCE.createTraceLinkSet());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElement(java.lang.Object) <em>Get Default Source Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElement(java.lang.Object)
	 * @generated NOT
	 */
	public void testGetDefaultSourceElement__Object() {
		final EObject se1Object = EcoreFactory.eINSTANCE.createEObject();
		
		final TraceLink link = TraceFactory.eINSTANCE.createTraceLink();
		
		final SourceElement se1 = link.getSourceElement("se1", true);
		assertEquals("se1", se1.getName());
		se1.setObject(se1Object);
		
		final TracedRule tr = fixture.getLinksByRule("tr", true);
		assertEquals("tr", tr.getRule());
		tr.getLinks().add(link);
		
		fixture.getDefaultSourceElements().add(se1);
		
		assertEquals(se1, fixture.getDefaultSourceElement(se1Object));
		
		final SourceElement se2 = link.getSourceElement("se2", true);
		assertEquals("se2", se2.getName());
		se2.setObject(se1Object);
		
		try {
			fixture.getDefaultSourceElements().add(se2);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// should occur
		}
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElements(java.util.List) <em>Get Default Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElements(java.util.List)
	 * @generated NOT
	 */
	public void testGetDefaultSourceElements__List() {
		final EObject se1Object = EcoreFactory.eINSTANCE.createEObject();
		final EObject se2Object = EcoreFactory.eINSTANCE.createEObject();
		
		final TraceLink link = TraceFactory.eINSTANCE.createTraceLink();
		
		final SourceElement se1 = link.getSourceElement("se1", true);
		assertEquals("se1", se1.getName());
		se1.setObject(se1Object);
		
		final SourceElement se2 = link.getSourceElement("se2", true);
		assertEquals("se2", se2.getName());
		se2.setObject(se2Object);
		
		final SourceElementList sel = TraceFactory.eINSTANCE.createSourceElementList();
		sel.getSourceElements().add(se1);
		assertTrue(sel.getSourceObjects().contains(se1Object));
		sel.getSourceElements().add(se2);
		assertTrue(sel.getSourceObjects().contains(se2Object));
		
		final TracedRule tr = fixture.getLinksByRule("tr", true);
		assertEquals("tr", tr.getRule());
		tr.getLinks().add(link);
		
		fixture.getDefaultSourceElementLists().add(sel);
		
		final EList<EObject> sourceObjects = new BasicEList<EObject>();
		sourceObjects.add(se1Object);
		sourceObjects.add(se2Object);
		
		assertEquals(sel, fixture.getDefaultSourceElements(sourceObjects));
		
		final SourceElementList sel2 = TraceFactory.eINSTANCE.createSourceElementList();
		sel2.getSourceElements().add(se1);
		assertTrue(sel2.getSourceObjects().contains(se1Object));
		sel2.getSourceElements().add(se2);
		assertTrue(sel2.getSourceObjects().contains(se2Object));
		
		try {
			fixture.getDefaultSourceElementLists().add(sel2);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// should occur
		}
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getLinksByRule(java.lang.String, boolean) <em>Get Links By Rule</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getLinksByRule(java.lang.String, boolean)
	 * @generated NOT
	 */
	public void testGetLinksByRule__String_boolean() {
		final TracedRule tr = fixture.getLinksByRule("tr", true);
		assertEquals("tr", tr.getRule());
		
		final TracedRule tr2 = fixture.getLinksByRule("tr2", false);
		assertNull(tr2);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#clear() <em>Clear</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#clear()
	 * @generated NOT
	 */
	public void testClear() {
		fixture.clear();
		assertTrue(fixture.getDefaultSourceElements().isEmpty());
		assertTrue(fixture.getRules().isEmpty());
	}

} //TraceLinkSetTest
