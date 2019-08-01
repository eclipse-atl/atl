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

import java.util.ArrayList;
import java.util.Collections;

import junit.textui.TestRunner;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.util.LazyBag;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet;
import org.eclipse.m2m.atl.emftvm.util.LazySet;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Field</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getStaticValue() <em>Static Value</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getValue(java.lang.Object) <em>Get Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#setValue(java.lang.Object, java.lang.Object) <em>Set Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getValue(java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Get Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#getStaticValue(org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Get Static Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#clear() <em>Clear</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#addValue(java.lang.Object, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Add Value</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Field#removeValue(java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Remove Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class FieldTest extends FeatureTest {

	protected final EmftvmFactory factory = EmftvmFactory.eINSTANCE;

	/**
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FieldTest.class);
	}

	/**
	 * Constructs a new Field test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Field test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Field getFixture() {
		return (Field)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createField());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Field#getStaticValue() <em>Static Value</em>}' feature getter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#getStaticValue()
	 * @generated NOT
	 */
	public void testGetStaticValue() {
		final Field field = getFixture();
		assertNull(field.getStaticValue());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Field#setStaticValue(java.lang.Object) <em>Static Value</em>}' feature setter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#setStaticValue(java.lang.Object)
	 * @generated NOT
	 */
	public void testSetStaticValue() {
		final Field field = getFixture();
		field.setStaticValue(field);
		assertSame(field, field.getStaticValue());

		// Test Bug # 405673
		final StackFrame frame = new StackFrame(factory.createExecEnv(), factory.createCodeBlock());
		final CodeBlock cb = factory.createCodeBlock();
		cb.getLocalVariables().add(factory.createLocalVariable());
		cb.getCode().add(factory.createPusht());
		field.setInitialiser(cb);
		assertEquals(field, field.getStaticValue(frame));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Field#getValue(java.lang.Object) <em>Get Value</em>}' operation. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#getValue(java.lang.Object)
	 * @generated NOT
	 */
	public void testGetValue__Object() {
		final Field field = getFixture();
		assertNull(field.getValue(field));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Field#setValue(java.lang.Object, java.lang.Object) <em>Set Value</em>}' operation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#setValue(java.lang.Object, java.lang.Object)
	 * @generated NOT
	 */
	public void testSetValue__Object_Object() {
		final Field field = getFixture();
		final Object context = new Object();
		field.setValue(context, field);
		assertSame(field, field.getValue(context));
		assertNull(field.getValue(field));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Field#getValue(java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Get Value</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#getValue(java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testGetValue__Object_StackFrame() {
		final Field field = getFixture();
		final Object context = new Object();
		final StackFrame frame = new StackFrame(factory.createExecEnv(), factory.createCodeBlock());
		final CodeBlock cb = factory.createCodeBlock();
		cb.getLocalVariables().add(factory.createLocalVariable());
		cb.getCode().add(factory.createPusht());
		field.setInitialiser(cb);
		assertEquals(Boolean.TRUE, field.getValue(context, frame));
		// check that value is cached
		cb.getCode().clear();
		assertEquals(Boolean.TRUE, field.getValue(context, frame));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Field#getStaticValue(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Get Static Value</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#getStaticValue(org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testGetStaticValue__StackFrame() {
		final Field field = getFixture();
		final StackFrame frame = new StackFrame(factory.createExecEnv(), factory.createCodeBlock());
		final CodeBlock cb = factory.createCodeBlock();
		cb.getLocalVariables().add(factory.createLocalVariable());
		cb.getCode().add(factory.createPusht());
		field.setInitialiser(cb);
		assertEquals(Boolean.TRUE, field.getStaticValue(frame));
		// check that value is cached
		cb.getCode().clear();
		assertEquals(Boolean.TRUE, field.getStaticValue(frame));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Field#clear() <em>Clear</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#clear()
	 * @generated NOT
	 */
	public void testClear() {
		final Field field = getFixture();
		final Object context = new Object();
		field.setStaticValue(field);
		field.setValue(context, field);
		assertEquals(field, field.getStaticValue());
		assertEquals(field, field.getValue(context));
		field.clear();
		assertNull(field.getStaticValue());
		assertNull(field.getValue(context));
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.m2m.atl.emftvm.Field#addValue(java.lang.Object, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Add Value</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#addValue(java.lang.Object, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testAddValue__Object_Object_int_StackFrame() {
		final Field field = getFixture();
		final Object context = new Object();
		final StackFrame frame = new StackFrame(factory.createExecEnv(), factory.createCodeBlock());
		final CodeBlock cb = factory.createCodeBlock();
		cb.getLocalVariables().add(factory.createLocalVariable());
		field.setInitialiser(cb);

		field.addValue(context, Boolean.TRUE, -1, frame);
		assertEquals(Boolean.TRUE, field.getValue(context));

		// Test for collections
		field.setValue(context, new ArrayList<Object>());
		field.addValue(context, Boolean.TRUE, 0, frame);
		assertEquals(Collections.singletonList(Boolean.TRUE), field.getValue(context));

		// Test for lazy collections
		field.setValue(context, new LazyList<Object>());
		field.addValue(context, Boolean.TRUE, 0, frame);
		assertEquals(Collections.singletonList(Boolean.TRUE), field.getValue(context));

		field.setValue(context, new LazyBag<Object>());
		field.addValue(context, Boolean.TRUE, -1, frame);
		assertEquals(new LazyBag<Object>().including(Boolean.TRUE), field.getValue(context));

		field.setValue(context, new LazySet<Object>());
		field.addValue(context, Boolean.TRUE, -1, frame);
		assertEquals(Collections.singleton(Boolean.TRUE), field.getValue(context));

		field.setValue(context, new LazyOrderedSet<Object>());
		field.addValue(context, Boolean.TRUE, 0, frame);
		assertEquals(Collections.singletonList(Boolean.TRUE), field.getValue(context));
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.m2m.atl.emftvm.Field#removeValue(java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Remove Value</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Field#removeValue(java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testRemoveValue__Object_Object_StackFrame() {
		final Field field = getFixture();
		final Object context = new Object();
		final StackFrame frame = new StackFrame(factory.createExecEnv(), factory.createCodeBlock());
		final CodeBlock cb = factory.createCodeBlock();
		cb.getLocalVariables().add(factory.createLocalVariable());
		cb.getCode().add(factory.createPusht());
		field.setInitialiser(cb);

		field.removeValue(context, Boolean.TRUE, frame);
		assertNull(field.getValue(context));

		// Test for collections
		field.setValue(context, new ArrayList<Object>());
		field.addValue(context, Boolean.TRUE, 0, frame);
		assertEquals(Collections.singletonList(Boolean.TRUE), field.getValue(context));
		field.removeValue(context, Boolean.TRUE, frame);
		assertEquals(Collections.emptyList(), field.getValue(context));

		// Test for lazy collections
		field.setValue(context, new LazyList<Object>());
		field.addValue(context, Boolean.TRUE, 0, frame);
		assertEquals(Collections.singletonList(Boolean.TRUE), field.getValue(context));
		field.removeValue(context, Boolean.TRUE, frame);
		assertEquals(Collections.emptyList(), field.getValue(context));

		field.setValue(context, new LazyBag<Object>());
		field.addValue(context, Boolean.TRUE, -1, frame);
		assertEquals(new LazyBag<Object>().including(Boolean.TRUE), field.getValue(context));
		field.removeValue(context, Boolean.TRUE, frame);
		assertEquals(new LazyBag<Object>(), field.getValue(context));

		field.setValue(context, new LazySet<Object>());
		field.addValue(context, Boolean.TRUE, -1, frame);
		assertEquals(Collections.singleton(Boolean.TRUE), field.getValue(context));
		field.removeValue(context, Boolean.TRUE, frame);
		assertEquals(Collections.emptySet(), field.getValue(context));

		field.setValue(context, new LazyOrderedSet<Object>());
		field.addValue(context, Boolean.TRUE, 0, frame);
		assertEquals(Collections.singletonList(Boolean.TRUE), field.getValue(context));
		field.removeValue(context, Boolean.TRUE, frame);
		assertEquals(Collections.emptyList(), field.getValue(context));
	}

} //FieldTest
