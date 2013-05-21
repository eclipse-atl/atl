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
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#hasField(java.lang.String) <em>Has Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#hasStaticField(java.lang.String) <em>Has Static Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field) <em>Register Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchSingle(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Match Single</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchRecursive(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Match Recursive</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchManual(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[]) <em>Match Manual</em>}</li>
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
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#compileIterables(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile Iterables</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#clearFields() <em>Clear Fields</em>}</li>
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getESuperRules() <em>ESuper Rules</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESuperRules()
	 * @generated NOT
	 */
	public void testGetESuperRules() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getESubRules() <em>ESub Rules</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESubRules()
	 * @generated NOT
	 */
	public void testGetESubRules() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#isLeaf() <em>Leaf</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isLeaf()
	 * @generated NOT
	 */
	public void testIsLeaf() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves() <em>With Leaves</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves()
	 * @generated NOT
	 */
	public void testIsWithLeaves() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#findField(java.lang.Object, java.lang.String) <em>Find Field</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findField(java.lang.Object, java.lang.String)
	 * @generated NOT
	 */
	public void testFindField__Object_String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#hasField(java.lang.String) <em>Has Field</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#hasField(java.lang.String)
	 * @generated NOT
	 */
	public void testHasField__String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findStaticField(java.lang.Object, java.lang.String)
	 * @generated NOT
	 */
	public void testFindStaticField__Object_String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#hasStaticField(java.lang.String) <em>Has Static Field</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#hasStaticField(java.lang.String)
	 * @generated NOT
	 */
	public void testHasStaticField__String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field) <em>Register Field</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field)
	 * @generated NOT
	 */
	public void testRegisterField__Field() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchSingle(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Match Single</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchSingle(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testMatchSingle__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchRecursive(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Match Recursive</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchRecursive(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testMatchRecursive__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchManual(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[]) <em>Match Manual</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchManual(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[])
	 * @generated
	 */
	public void testMatchManual__StackFrame_Object() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map)
	 * <em>Match One</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map)
	 * @generated NOT
	 */
	public void testMatchOne__StackFrame_Map() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Create Traces</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testCreateTraces__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '
	 * {@link org.eclipse.m2m.atl.emftvm.Rule#completeTraceFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * <em>Complete Trace For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#completeTraceFor(org.eclipse.m2m.atl.emftvm.util.StackFrame,
	 *      org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated NOT
	 */
	public void testCompleteTraceFor__StackFrame_TraceLink() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#apply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#apply(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testApply__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#postApply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Post Apply</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#postApply(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testPostApply__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#applyFirst(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply First</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#applyFirst(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testApplyFirst__StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '
	 * {@link org.eclipse.m2m.atl.emftvm.Rule#applyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * <em>Apply For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#applyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated NOT
	 */
	public void testApplyFor__StackFrame_TraceLink() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '
	 * {@link org.eclipse.m2m.atl.emftvm.Rule#postApplyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * <em>Post Apply For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#postApplyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame,
	 *      org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated NOT
	 */
	public void testPostApplyFor__StackFrame_TraceLink() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getAllESuperRules() <em>Get All ESuper Rules</em>}' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getAllESuperRules()
	 * @generated NOT
	 */
	public void testGetAllESuperRules() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#createUniqueMapping(org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * <em>Create Unique Mapping</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#createUniqueMapping(org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated NOT
	 */
	public void testCreateUniqueMapping__TraceLink() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#compileState(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile State</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#compileState(org.eclipse.m2m.atl.emftvm.ExecEnv)
	 * @generated NOT
	 */
	public void testCompileState__ExecEnv() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#resetState() <em>Reset State</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#resetState()
	 * @generated NOT
	 */
	public void testResetState() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#compileIterables(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile Iterables</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#compileIterables(org.eclipse.m2m.atl.emftvm.ExecEnv)
	 * @generated NOT
	 */
	public void testCompileIterables__ExecEnv() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#clearFields() <em>Clear Fields</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Rule#clearFields()
	 * @generated NOT
	 */
	public void testClearFields() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT

	}

} //RuleTest
