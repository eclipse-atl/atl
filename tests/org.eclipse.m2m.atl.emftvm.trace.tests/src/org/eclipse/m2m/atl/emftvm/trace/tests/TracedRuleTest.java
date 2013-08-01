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
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Traced Rule</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElement(java.lang.Object) <em>Get Unique Source Element</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElements(java.util.List) <em>Get Unique Source Elements</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TracedRuleTest extends TestCase {

	/**
	 * The fixture for this Traced Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedRule fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TracedRuleTest.class);
	}

	/**
	 * Constructs a new Traced Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedRuleTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Traced Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(TracedRule fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Traced Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedRule getFixture() {
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
		setFixture(TraceFactory.eINSTANCE.createTracedRule());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElement(java.lang.Object) <em>Get Unique Source Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElement(java.lang.Object)
	 * @generated NOT
	 */
	public void testGetUniqueSourceElement__Object() {
		final EObject se1Object = EcoreFactory.eINSTANCE.createEObject();
		
		final TraceLink link = TraceFactory.eINSTANCE.createTraceLink();
		
		final SourceElement se1 = link.getSourceElement("se1", true);
		assertEquals("se1", se1.getName());
		se1.setObject(se1Object);
		
		final TracedRule tr = fixture;
		tr.setRule("tr");
		assertEquals("tr", tr.getRule());
		tr.getLinks().add(link);
		
		tr.getUniqueSourceElements().add(se1);
		
		assertEquals(se1, tr.getUniqueSourceElement(se1Object));
		
		final SourceElement se2 = link.getSourceElement("se2", true);
		assertEquals("se2", se2.getName());
		se2.setObject(se1Object);
		
		try {
			tr.getUniqueSourceElements().add(se2);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// should occur
		}
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElements(java.util.List) <em>Get Unique Source Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElements(java.util.List)
	 * @generated NOT
	 */
	public void testGetUniqueSourceElements__List() {
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
		
		final TracedRule tr = fixture;
		tr.setRule("tr");
		assertEquals("tr", tr.getRule());
		tr.getLinks().add(link);
		
		tr.getUniqueSourceElementLists().add(sel);
		
		final EList<EObject> sourceObjects = new BasicEList<EObject>();
		sourceObjects.add(se1Object);
		sourceObjects.add(se2Object);
		
		assertEquals(sel, tr.getUniqueSourceElements(sourceObjects));
		
		final SourceElementList sel2 = TraceFactory.eINSTANCE.createSourceElementList();
		sel2.getSourceElements().add(se1);
		assertTrue(sel2.getSourceObjects().contains(se1Object));
		sel2.getSourceElements().add(se2);
		assertTrue(sel2.getSourceObjects().contains(se2Object));
		
		try {
			tr.getUniqueSourceElementLists().add(sel2);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// should occur
		}
	}

} //TracedRuleTest
