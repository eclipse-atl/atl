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

import static org.junit.Assert.assertArrayEquals;

import java.util.Collections;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMException;

import junit.textui.TestRunner;

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
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchManualTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[]) <em>Match Manual Trace</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Match One</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#matchOneOnly(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Match One Only</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Create Traces</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#completeTraceFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Complete Trace For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#apply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#postApply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Post Apply</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#applyFirst(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply First</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#applyOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Apply One</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#applyOneTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Apply One Trace</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#applyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Apply For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#postApplyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Post Apply For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getAllESuperRules() <em>Get All ESuper Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#createUniqueMapping(org.eclipse.m2m.atl.emftvm.trace.TraceLink) <em>Create Unique Mapping</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#compileState(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile State</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#resetState() <em>Reset State</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#compileIterables(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile Iterables</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#clearFields() <em>Clear Fields</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#findInputElement(java.lang.String) <em>Find Input Element</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Rule#getUniqueTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[]) <em>Get Unique Trace</em>}</li>
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
	public static void main(final String[] args) {
		TestRunner.run(RuleTest.class);
	}

	/**
	 * Constructs a new Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleTest(final String name) {
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
		getFixture().setName("testRule");
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
		assertEquals(Collections.emptyList(), getFixture().getESuperRules());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getESubRules() <em>ESub Rules</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getESubRules()
	 * @generated NOT
	 */
	public void testGetESubRules() {
		assertEquals(Collections.emptyList(), getFixture().getESubRules());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#isLeaf() <em>Leaf</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isLeaf()
	 * @generated NOT
	 */
	public void testIsLeaf() {
		assertTrue(getFixture().isLeaf());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves() <em>With Leaves</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#isWithLeaves()
	 * @generated NOT
	 */
	public void testIsWithLeaves() {
		assertFalse(getFixture().isWithLeaves());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#findField(java.lang.Object, java.lang.String) <em>Find Field</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findField(java.lang.Object, java.lang.String)
	 * @generated NOT
	 */
	public void testFindField__Object_String() {
		assertEquals(null, getFixture().findField(Object.class, "test"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#hasField(java.lang.String) <em>Has Field</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#hasField(java.lang.String)
	 * @generated NOT
	 */
	public void testHasField__String() {
		assertFalse(getFixture().hasField("test"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findStaticField(java.lang.Object, java.lang.String)
	 * @generated NOT
	 */
	public void testFindStaticField__Object_String() {
		assertEquals(null, getFixture().findStaticField(Object.class, "test"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#hasStaticField(java.lang.String) <em>Has Static Field</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#hasStaticField(java.lang.String)
	 * @generated NOT
	 */
	public void testHasStaticField__String() {
		assertFalse(getFixture().hasStaticField("test"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field) <em>Register Field</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field)
	 * @generated NOT
	 */
	public void testRegisterField__Field() {
		final Field field = EmftvmFactory.eINSTANCE.createField();
		final EClassifier context = EcorePackage.eINSTANCE.getEClassifier();
		field.setEContext(context);
		final String name = "testField";
		field.setName(name);
		getFixture().registerField(field);
		assertSame(field, getFixture().findField(context, name));
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field)
	 * <em>Register Field</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#registerField(org.eclipse.m2m.atl.emftvm.Field)
	 * @generated NOT
	 */
	public void testRegisterField__Field_JavaType() {
		final Field field = EmftvmFactory.eINSTANCE.createField();
		final EClassifier context = EcorePackage.eINSTANCE.getEJavaObject();
		field.setEContext(context);
		final String name = "testField";
		field.setName(name);
		getFixture().registerField(field);
		assertSame(field, getFixture().findField(context.getInstanceClass(), name));
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Rule#matchSingle(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Match Single</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchSingle(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testMatchSingle__StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		assertFalse(getFixture().matchSingle(frame));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchRecursive(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Match Recursive</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchRecursive(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testMatchRecursive__StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		assertArrayEquals(new boolean[] { false, false }, getFixture().matchRecursive(frame));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchManual(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[]) <em>Match Manual</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchManual(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[])
	 * @generated NOT
	 */
	public void testMatchManual__StackFrame_Object() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		assertEquals(null, getFixture().matchManual(frame, new Object[] {}));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchManualTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[]) <em>Match Manual Trace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchManualTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[])
	 * @generated NOT
	 */
	public void testMatchManualTrace__StackFrame_Object() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		final TraceLink traceLink = getFixture().matchManualTrace(frame, new Object[] {});
		assertNotNull(traceLink);
		assertEquals(getFixture().getName(), traceLink.getRule().getRule());
		assertEquals(Collections.emptyList(), traceLink.getSourceElements());
		assertEquals(Collections.emptyList(), traceLink.getTargetElements());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map)
	 * <em>Match One</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map)
	 * @generated NOT
	 */
	public void testMatchOne__StackFrame_Map() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		assertTrue(getFixture().matchOne(frame, Collections.emptyMap()));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#matchOneOnly(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Match One Only</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#matchOneOnly(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map)
	 * @generated NOT
	 */
	public void testMatchOneOnly__StackFrame_Map() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		assertTrue(getFixture().matchOneOnly(frame, Collections.emptyMap()));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Create Traces</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testCreateTraces__StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		getFixture().matchOneOnly(frame, Collections.emptyMap());
		getFixture().createTraces(frame);
		assertEquals(1, env.getTraces().getRules().size());
		assertEquals(getFixture().getName(), env.getTraces().getRules().get(0).getRule());
		assertEquals(1, env.getTraces().getRules().get(0).getLinks().size());
		assertEquals(Collections.emptyList(), env.getTraces().getRules().get(0).getLinks().get(0).getSourceElements());
		assertEquals(Collections.emptyList(), env.getTraces().getRules().get(0).getLinks().get(0).getTargetElements());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Create Traces</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#createTraces(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testCreateTraces__StackFrame_noMatches() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		try {
			getFixture().createTraces(frame);
			fail("Expected VMException");
		} catch (final VMException e) {
			assertEquals("Cannot create traces for rule testRule; no matches exist", e.getMessage());
			assertEquals(Collections.emptyList(), env.getTraces().getRules());
		}
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.m2m.atl.emftvm.Rule#completeTraceFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * <em>Complete Trace For</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#completeTraceFor(org.eclipse.m2m.atl.emftvm.util.StackFrame,
	 *      org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated NOT
	 */
	public void testCompleteTraceFor__StackFrame_TraceLink() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		final TraceLink traceLink = getFixture().matchManualTrace(frame, new Object[] {});
		assertFalse(getFixture().completeTraceFor(frame, traceLink));
		assertEquals(getFixture().getName(), traceLink.getRule().getRule());
		assertEquals(Collections.emptyList(), traceLink.getSourceElements());
		assertEquals(Collections.emptyList(), traceLink.getTargetElements());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#apply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#apply(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testApply__StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		getFixture().matchManualTrace(frame, new Object[] {});
		getFixture().apply(frame);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#postApply(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Post Apply</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#postApply(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testPostApply__StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		getFixture().matchManualTrace(frame, new Object[] {});
		getFixture().postApply(frame);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#applyFirst(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Apply First</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#applyFirst(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testApplyFirst__StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		getFixture().matchManualTrace(frame, new Object[] {});
		getFixture().applyFirst(frame);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#applyOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Apply One</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#applyOne(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map)
	 * @generated NOT
	 */
	public void testApplyOne__StackFrame_Map() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		assertTrue(getFixture().matchOne(frame, Collections.emptyMap()));
		getFixture().applyOne(frame, Collections.emptyMap());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#applyOneTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map) <em>Apply One Trace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#applyOneTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.util.Map)
	 * @generated NOT
	 */
	public void testApplyOneTrace__StackFrame_Map() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		assertTrue(getFixture().matchOne(frame, Collections.emptyMap()));
		final TraceLink traceLink = getFixture().applyOneTrace(frame, Collections.emptyMap());
		assertNotNull(traceLink);
		assertEquals(getFixture().getName(), traceLink.getRule().getRule());
		assertEquals(Collections.emptyList(), traceLink.getSourceElements());
		assertEquals(Collections.emptyList(), traceLink.getTargetElements());
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.m2m.atl.emftvm.Rule#applyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame, org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * <em>Apply For</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#applyFor(org.eclipse.m2m.atl.emftvm.util.StackFrame,
	 *      org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated NOT
	 */
	public void testApplyFor__StackFrame_TraceLink() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		final TraceLink traceLink = getFixture().matchManualTrace(frame, new Object[] {});
		assertEquals(null, getFixture().applyFor(frame, traceLink));
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
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		final TraceLink traceLink = getFixture().matchManualTrace(frame, new Object[] {});
		assertEquals(null, getFixture().postApplyFor(frame, traceLink));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getAllESuperRules() <em>Get All ESuper Rules</em>}' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getAllESuperRules()
	 * @generated NOT
	 */
	public void testGetAllESuperRules() {
		assertEquals(Collections.emptySet(), getFixture().getAllESuperRules());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#createUniqueMapping(org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * <em>Create Unique Mapping</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#createUniqueMapping(org.eclipse.m2m.atl.emftvm.trace.TraceLink)
	 * @generated NOT
	 */
	public void testCreateUniqueMapping__TraceLink() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		final TraceLink traceLink = getFixture().matchManualTrace(frame, new Object[] {});
		getFixture().createUniqueMapping(traceLink);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#compileState(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile State</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#compileState(org.eclipse.m2m.atl.emftvm.ExecEnv)
	 * @generated NOT
	 */
	public void testCompileState__ExecEnv() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#resetState() <em>Reset State</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#resetState()
	 * @generated NOT
	 */
	public void testResetState() {
		getFixture().resetState();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#compileIterables(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile Iterables</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#compileIterables(org.eclipse.m2m.atl.emftvm.ExecEnv)
	 * @generated NOT
	 */
	public void testCompileIterables__ExecEnv() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		getFixture().compileIterables(env);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#compileIterables(org.eclipse.m2m.atl.emftvm.ExecEnv) <em>Compile Iterables</em>}'
	 * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#compileIterables(org.eclipse.m2m.atl.emftvm.ExecEnv)
	 * @generated NOT
	 */
	public void testCompileIterables__ExecEnv_noRuleState() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		try {
			getFixture().compileIterables(env);
			fail("Expected NullPointerException");
		} catch (final NullPointerException e) {
		}
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#clearFields() <em>Clear Fields</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#clearFields()
	 * @generated NOT
	 */
	public void testClearFields() {
		final Field field = EmftvmFactory.eINSTANCE.createField();
		final EClassifier context = EcorePackage.eINSTANCE.getEClassifier();
		field.setEContext(context);
		final String name = "testField";
		final String value = "testValue";
		field.setName(name);
		getFixture().registerField(field);
		field.setValue(this, value);
		assertEquals(value, field.getValue(this));

		getFixture().clearFields();

		assertEquals(null, field.getValue(this));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#findInputElement(java.lang.String) <em>Find Input Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findInputElement(java.lang.String)
	 * @generated NOT
	 */
	public void testFindInputElement__String() {
		final InputRuleElement ire = EmftvmFactory.eINSTANCE.createInputRuleElement();
		ire.setName("s");
		getFixture().getInputElements().add(ire);
		assertEquals(ire, getFixture().findInputElement(ire.getName()));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#findInputElement(java.lang.String) <em>Find Input Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findInputElement(java.lang.String)
	 * @generated NOT
	 */
	public void testFindInputElement__String_superRules() {
		final InputRuleElement ire = EmftvmFactory.eINSTANCE.createInputRuleElement();
		ire.setName("s");
		final Rule superRule = EmftvmFactory.eINSTANCE.createRule();
		superRule.getInputElements().add(ire);
		getFixture().getESuperRules().add(superRule);
		assertEquals(ire, getFixture().findInputElement(ire.getName()));
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Rule#findInputElement(java.lang.String)
	 * <em>Find Input Element</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Rule#findInputElement(java.lang.String)
	 * @generated NOT
	 */
	public void testFindInputElement__String_null() {
		assertEquals(null, getFixture().findInputElement("name"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Rule#getUniqueTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[]) <em>Get Unique Trace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getUniqueTrace(org.eclipse.m2m.atl.emftvm.util.StackFrame, java.lang.Object[])
	 * @generated NOT
	 */
	public void testGetUniqueTrace__StackFrame_Object() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		getFixture().compileState(env);
		final CodeBlock main = EmftvmFactory.eINSTANCE.createCodeBlock();
		final StackFrame frame = new StackFrame(env, main);
		assertEquals(null, getFixture().getUniqueTrace(frame, new Object[] {}));
	}

} //RuleTest
