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

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Field;
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

} //FieldTest
