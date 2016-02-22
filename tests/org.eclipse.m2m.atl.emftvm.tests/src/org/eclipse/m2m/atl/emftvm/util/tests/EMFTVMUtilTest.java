/*******************************************************************************
 * Copyright (c) 2016 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util.tests;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyList.AppendList;

import junit.framework.TestCase;

/**
 * Tests {@link EMFTVMUtil}.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class EMFTVMUtilTest extends TestCase {

	/**
	 * Test method for {@link EMFTVMUtil#findNativeMethod(Class, String, Class[], boolean)}.
	 */
	public void testFindNativeMethodClassOfQStringClassOfQArrayBoolean() {
		final LazyList<Object> list = new LazyList<Object>().append(EcorePackage.eINSTANCE.getEClass());
		final EClass object = EcorePackage.eINSTANCE.getEEnum();
		final Integer index = 0;
		
		final Method method = EMFTVMUtil.findNativeMethod(list.getClass(), "including",
				new Class[] { object.getClass(), index.getClass() }, false);

		assertNotNull(method);
		assertEquals("including", method.getName());
		assertEquals(LazyList.class, method.getDeclaringClass());
		assertFalse(Modifier.isStatic(method.getModifiers()));
		assertTrue(Modifier.isPublic(method.getModifiers()));
		assertFalse(Modifier.isAbstract(method.getModifiers()));
		assertFalse(Modifier.isInterface(method.getModifiers()));
		assertFalse(Modifier.isFinal(method.getModifiers()));
		assertFalse(Modifier.isNative(method.getModifiers()));
		final Class<?>[] parameterTypes = method.getParameterTypes();
		assertEquals(2, parameterTypes.length);
		assertEquals(Object.class, parameterTypes[0]);
		assertEquals(int.class, parameterTypes[1]);
		// Sometimes return type is LazyList, sometimes LazyCollection. Java
		// reflection bug?
		assertTrue(LazyCollection.class.isAssignableFrom(method.getReturnType()));
	}

	/**
	 * Test method for
	 * {@link EMFTVMUtil#findNativeMethod(Class, String, Class, boolean)}.
	 */
	public void testFindNativeMethodClassOfQStringClassOfQBoolean() {
		final LazyList<Object> list = new LazyList<Object>().append(EcorePackage.eINSTANCE.getEClass());
		final EClass object = EcorePackage.eINSTANCE.getEEnum();

		final Method method = EMFTVMUtil.findNativeMethod(list.getClass(), "including", object.getClass(), false);

		assertNotNull(method);
		assertEquals("including", method.getName());
		assertEquals(LazyList.class, method.getDeclaringClass());
		assertFalse(Modifier.isStatic(method.getModifiers()));
		assertTrue(Modifier.isPublic(method.getModifiers()));
		assertFalse(Modifier.isAbstract(method.getModifiers()));
		assertFalse(Modifier.isInterface(method.getModifiers()));
		assertFalse(Modifier.isFinal(method.getModifiers()));
		assertFalse(Modifier.isStrict(method.getModifiers()));
		assertFalse(Modifier.isNative(method.getModifiers()));
		final Class<?>[] parameterTypes = method.getParameterTypes();
		assertEquals(1, parameterTypes.length);
		assertEquals(Object.class, parameterTypes[0]);
		// Sometimes return type is LazyList, sometimes LazyCollection. Java
		// reflection bug?
		assertTrue(LazyCollection.class.isAssignableFrom(method.getReturnType()));
	}

	/**
	 * Test method for
	 * {@link EMFTVMUtil#findNativeMethod(Class, String, boolean)}.
	 */
	public void testFindNativeMethodClassOfQStringBoolean() {
		final LazyList<Object> list = new LazyList<Object>().append(EcorePackage.eINSTANCE.getEClass());

		final Method method = EMFTVMUtil.findNativeMethod(list.getClass(), "size", false);

		assertNotNull(method);
		assertEquals("size", method.getName());
		assertEquals(AppendList.class, method.getDeclaringClass());
		assertFalse(Modifier.isStatic(method.getModifiers()));
		assertTrue(Modifier.isPublic(method.getModifiers()));
		assertFalse(Modifier.isAbstract(method.getModifiers()));
		assertFalse(Modifier.isInterface(method.getModifiers()));
		assertFalse(Modifier.isFinal(method.getModifiers()));
		assertFalse(Modifier.isStrict(method.getModifiers()));
		assertFalse(Modifier.isNative(method.getModifiers()));
		final Class<?>[] parameterTypes = method.getParameterTypes();
		assertEquals(0, parameterTypes.length);
		assertEquals(int.class, method.getReturnType());
	}

}
