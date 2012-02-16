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
import org.eclipse.m2m.atl.emftvm.Rule;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Rule</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getESuperRules() <em>ESuper Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getESubRules() <em>ESub Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#isLeaf() <em>Leaf</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves() <em>With Leaves</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#findField(java.lang.Object, java.lang.String) <em>Find Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field) <em>Register Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchSingle(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Match Single</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchRecursive(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Match Recursive</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchManual(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.emf.ecore.EObject[]) <em>Match Manual</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Match One</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Create Traces</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#completeTraceFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Complete Trace For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#apply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#postApply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Post Apply</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#applyFirst(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply First</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#applyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Apply For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#postApplyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Post Apply For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getAllESuperRules() <em>Get All ESuper Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#createUniqueMapping(org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Create Unique Mapping</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#compileState(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile State</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#resetState() <em>Reset State</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class RuleTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RuleTest.class);
	}

	/**
	 * Constructs a new Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Rule getFixture() {
		return (Rule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createRule());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getESuperRules() <em>ESuper Rules</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESuperRules()
	 * @generated
	 */
	public void testGetESuperRules() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getESubRules() <em>ESub Rules</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESubRules()
	 * @generated
	 */
	public void testGetESubRules() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#isLeaf() <em>Leaf</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isLeaf()
	 * @generated
	 */
	public void testIsLeaf() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves() <em>With Leaves</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves()
	 * @generated
	 */
	public void testIsWithLeaves() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#findField(java.lang.Object, java.lang.String) <em>Find Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findField(java.lang.Object, java.lang.String)
	 * @generated
	 */
	public void testFindField__Object_String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findStaticField(java.lang.Object, java.lang.String)
	 * @generated
	 */
	public void testFindStaticField__Object_String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field) <em>Register Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field)
	 * @generated
	 */
	public void testRegisterField__Field() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchSingle(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Match Single</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchSingle(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated
	 */
	public void testMatchSingle__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchRecursive(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Match Recursive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchRecursive(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated
	 */
	public void testMatchRecursive__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchManual(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.emf.ecore.EObject[]) <em>Match Manual</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchManual(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.emf.ecore.EObject[])
	 * @generated
	 */
	public void testMatchManual__StackFrame_EObject() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Match One</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map)
	 * @generated
	 */
	public void testMatchOne__StackFrame_Map() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Create Traces</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated
	 */
	public void testCreateTraces__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#completeTraceFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Complete Trace For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#completeTraceFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated
	 */
	public void testCompleteTraceFor__StackFrame_TraceLink() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#apply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#apply(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated
	 */
	public void testApply__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#postApply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Post Apply</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#postApply(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated
	 */
	public void testPostApply__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#applyFirst(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply First</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#applyFirst(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated
	 */
	public void testApplyFirst__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#applyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Apply For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#applyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated
	 */
	public void testApplyFor__StackFrame_TraceLink() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#postApplyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Post Apply For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#postApplyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated
	 */
	public void testPostApplyFor__StackFrame_TraceLink() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getAllESuperRules() <em>Get All ESuper Rules</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getAllESuperRules()
	 * @generated
	 */
	public void testGetAllESuperRules() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#createUniqueMapping(org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Create Unique Mapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#createUniqueMapping(org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated
	 */
	public void testCreateUniqueMapping__TraceLink() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#compileState(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#compileState(org.eclipse.m2m.atl.emftvm.ExecEnv)
	 * @generated
	 */
	public void testCompileState__ExecEnv() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#resetState() <em>Reset State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#resetState()
	 * @generated
	 */
	public void testResetState() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //RuleTest
