/*******************************************************************************
 * Copyright (c) 2016-2017 Dennis Wagelaar.
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.LazyCollection;
import org.eclipse.m2m.atl.emftvm.util.LazyCollections;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.LazyList.AppendList;
import org.eclipse.m2m.atl.emftvm.util.Tuple;

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

	/**
	 * Test method for
	 * {@link EMFTVMUtil#set(ExecEnv, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, Object)}.
	 */
	public void testSet_Bug496434() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final CodeBlock eo = EmftvmFactory.eINSTANCE.createCodeBlock();
		final EReference sf = EmftvmPackage.eINSTANCE.getCodeBlock_Code();
		final LazyList<Instruction> element = new LazyList<Instruction>().append(EmftvmFactory.eINSTANCE.createPusht());
		final LazyList<LazyList<Instruction>> value = new LazyList<LazyList<Instruction>>().append(element);

		try {
			EMFTVMUtil.set(env, eo, sf, value);
			fail("Expected IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			assertEquals("Cannot add/remove values of type Sequence to/from multi-valued field CodeBlock::code",
					e.getMessage());
		}
	}

	/**
	 * Test method for {@link EMFTVMUtil#add(ExecEnv,
	 * org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature,
	 * Object, int).
	 */
	public void testAdd_Bug496434() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final CodeBlock eo = EmftvmFactory.eINSTANCE.createCodeBlock();
		final EReference sf = EmftvmPackage.eINSTANCE.getCodeBlock_Code();
		final LazyList<Instruction> element = new LazyList<Instruction>().append(EmftvmFactory.eINSTANCE.createPusht());
		final LazyList<LazyList<Instruction>> value = new LazyList<LazyList<Instruction>>().append(element);

		try {
			EMFTVMUtil.add(env, eo, sf, value, 0);
			fail("Expected IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			assertEquals("Cannot add/remove values of type Sequence to/from multi-valued field CodeBlock::code",
					e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link EMFTVMUtil#remove(ExecEnv, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, Object)}.
	 */
	public void testRemove_Bug496434() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final CodeBlock eo = EmftvmFactory.eINSTANCE.createCodeBlock();
		final EReference sf = EmftvmPackage.eINSTANCE.getCodeBlock_Code();
		final LazyList<Instruction> element = new LazyList<Instruction>().append(EmftvmFactory.eINSTANCE.createPusht());
		final LazyList<LazyList<Instruction>> value = new LazyList<LazyList<Instruction>>().append(element);

		try {
			EMFTVMUtil.remove(env, eo, sf, value);
			fail("Expected IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			assertEquals("Cannot add/remove values of type Sequence to/from multi-valued field CodeBlock::code",
					e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link EMFTVMUtil#set(ExecEnv, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, Object)}.
	 */
	public void testSet_null() {
		final Resource res = new ResourceImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final CodeBlock eo = EmftvmFactory.eINSTANCE.createCodeBlock();
		res.getContents().add(eo);
		final EReference sf = EmftvmPackage.eINSTANCE.getCodeBlock_Code();
		final LazyList<Instruction> value = new LazyList<Instruction>().append(null);

		try {
			EMFTVMUtil.set(env, eo, sf, value);
			fail("Expected IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			assertEquals("Cannot add/remove OclUndefined to/from multi-valued field CodeBlock::code", e.getMessage());
		}
	}

	/**
	 * Test method for {@link EMFTVMUtil#add(ExecEnv, org.eclipse.emf.ecore.EObject,
	 * org.eclipse.emf.ecore.EStructuralFeature, Object, int).
	 */
	public void testAdd_null() {
		final Resource res = new ResourceImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final CodeBlock eo = EmftvmFactory.eINSTANCE.createCodeBlock();
		res.getContents().add(eo);
		final EReference sf = EmftvmPackage.eINSTANCE.getCodeBlock_Code();
		final LazyList<Instruction> value = new LazyList<Instruction>().append(null);

		try {
			EMFTVMUtil.add(env, eo, sf, value, 0);
			fail("Expected IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			assertEquals("Cannot add/remove OclUndefined to/from multi-valued field CodeBlock::code", e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link EMFTVMUtil#remove(ExecEnv, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, Object)}.
	 */
	public void testRemove_null() {
		final Resource res = new ResourceImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final CodeBlock eo = EmftvmFactory.eINSTANCE.createCodeBlock();
		res.getContents().add(eo);
		final EReference sf = EmftvmPackage.eINSTANCE.getCodeBlock_Code();
		final LazyList<Instruction> value = new LazyList<Instruction>().append(null);

		try {
			EMFTVMUtil.remove(env, eo, sf, value);
			fail("Expected IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			assertEquals("Cannot add/remove OclUndefined to/from multi-valued field CodeBlock::code", e.getMessage());
		}
	}

	/**
	 * Test method for {@link EMFTVMUtil#findRootMethod(Method)}.
	 */
	public void testFindRootMethod() {
		final Map<String, String> sourceMap = new HashMap<String, String>();
		sourceMap.put("key", "value");
		final Map<String, String> wrapperMap = Collections.unmodifiableMap(sourceMap);
		final Method getMethod = EMFTVMUtil.findNativeMethod(wrapperMap.getClass(), "get", String.class, false);

		assertNotNull(getMethod);
		assertNotSame(Map.class, getMethod.getDeclaringClass());
		assertTrue(Modifier.isPrivate(getMethod.getDeclaringClass().getModifiers()));

		final Method rootMethod = EMFTVMUtil.findRootMethod(getMethod);

		assertNotNull(rootMethod);
		assertNotSame(getMethod, rootMethod);
		assertEquals(Map.class, rootMethod.getDeclaringClass());
	}

	/**
	 * Test method for {@link EMFTVMUtil#getMethodCacheHitRate()}.
	 */
	public void testGetMethodCacheHitRate() {
		testFindNativeMethodClassOfQStringBoolean();
		testFindNativeMethodClassOfQStringBoolean();
		testFindNativeMethodClassOfQStringBoolean();
		testFindNativeMethodClassOfQStringClassOfQBoolean();
		testFindNativeMethodClassOfQStringClassOfQBoolean();
		testFindNativeMethodClassOfQStringClassOfQBoolean();
		testFindNativeMethodClassOfQStringClassOfQArrayBoolean();
		testFindNativeMethodClassOfQStringClassOfQArrayBoolean();
		testFindNativeMethodClassOfQStringClassOfQArrayBoolean();

		final double hitRate = EMFTVMUtil.getMethodCacheHitRate();

		assertTrue("Expected hitRate >= 0.5, but was " + hitRate, hitRate >= 0.5);
	}

	/**
	 * Test method for {@link EMFTVMUtil#getRootMethodCacheHitRate()}.
	 */
	public void testGetRootMethodCacheHitRate() {
		testFindRootMethod();
		testFindRootMethod();

		final double hitRate = EMFTVMUtil.getRootMethodCacheHitRate();

		assertTrue("Expected hitRate >= 0.5, but was " + hitRate, hitRate >= 0.5);
	}

	/**
	 * Test method for {@link EMFTVMUtil#toPrettyString(Object, ExecEnv)}.
	 */
	public void testToPrettyString_Map() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		map.put(Integer.valueOf(3), EmftvmPackage.eINSTANCE.getExecEnv());
		map.put(Integer.valueOf(5), LazyCollections.asLazyBag(Arrays.asList(1, 2, 3, 4, 5)));
		map.put("6", null);
		for (int i = 100; i < 1000; i++) {
			map.put(i, LazyCollections.asLazyList(Collections.singletonList(Collections.singletonMap(1, 2))));
		}

		final String result = EMFTVMUtil.toPrettyString(map, env);

		assertEquals(
				"Map{3=EMFTVM!ExecEnv, 5=Bag{1, 2, 3, 4, 5}, '6'=OclUndefined, 100=Sequence{Map{1=2}}, 101=Sequence{Map{1=2}}, 102=Sequence{Map{1=2}}, 103=Sequence{Map{1=2}}, 104=Sequence{Map{1=2}}, 105=Sequence{Map{1=2}}, 106=Sequence{Map{1=2}}, 107=Sequence{Map{1=2}}, 108=Sequence{Map{1=2}}, 109=Sequence{Map{1=2}}, 110=Sequence{Map{1=2}}, 111=Sequence{Map{1=2}}, 112=Sequence{Map{1=2}}, 113=Sequence{Map{1=2}}, 114=Sequence{Map{1=2}}, 115=Sequence{Map{1=2}}, 116=Sequence{Map{1=2}}, 117=Sequence{Map{1=2}}, 118=Sequence{Map{1=2}}, 119=Sequence{Map{1=2}}, 120=Sequence{Map{1=2}}, 121=Sequence{Map{1=2}}, 122=Sequence{Map{1=2}}, 123=Sequence{Map{1=2}}, 124=Sequence{Map{1=2}}, 125=Sequence{Map{1=2}}, 126=Sequence{Map{1=2}}, 127=Sequence{Map{1=2}}, 128=Sequence{Map{1=2}}, ...}",
				result);
	}

	/**
	 * Test method for {@link EMFTVMUtil#toPrettyString(Object, ExecEnv)}.
	 */
	public void testToPrettyString_Tuple() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("one", EmftvmPackage.eINSTANCE.getExecEnv());
		map.put("three", LazyCollections.asLazyBag(Arrays.asList(1, 2, 3, 4, 5)));
		map.put("6", null);
		for (int i = 100; i < 1000; i++) {
			map.put(Integer.toString(i),
					LazyCollections
					.asLazyList(Collections
							.singletonList(Tuple.fromMap(Collections.singletonMap("key", "value")))));
		}
		final Tuple tuple = Tuple.fromMap(map);

		final String result = EMFTVMUtil.toPrettyString(tuple, env);

		assertEquals(
				"Tuple{'one'=EMFTVM!ExecEnv, 'three'=Bag{1, 2, 3, 4, 5}, '6'=OclUndefined, '100'=Sequence{Tuple{'key'='value'}}, '101'=Sequence{Tuple{'key'='value'}}, '102'=Sequence{Tuple{'key'='value'}}, '103'=Sequence{Tuple{'key'='value'}}, '104'=Sequence{Tuple{'key'='value'}}, '105'=Sequence{Tuple{'key'='value'}}, '106'=Sequence{Tuple{'key'='value'}}, '107'=Sequence{Tuple{'key'='value'}}, '108'=Sequence{Tuple{'key'='value'}}, '109'=Sequence{Tuple{'key'='value'}}, '110'=Sequence{Tuple{'key'='value'}}, '111'=Sequence{Tuple{'key'='value'}}, '112'=Sequence{Tuple{'key'='value'}}, '113'=Sequence{Tuple{'key'='value'}}, '114'=Sequence{Tuple{'key'='value'}}, '115'=Sequence{Tuple{'key'='value'}}, '116'=Sequence{Tuple{'key'='value'}}, '117'=Sequence{Tuple{'key'='value'}}, '118'=Sequence{Tuple{'key'='value'}}, '119'=Sequence{Tuple{'key'='value'}}, '120'=Sequence{Tuple{'key'='value'}}, '121'=Sequence{Tuple{'key'='value'}}, '122'=Sequence{Tuple{'key'='value'}}, '123'=Sequence{Tuple{'key'='value'}}, '124'=Sequence{Tuple{'key'='value'}}, '125'=Sequence{Tuple{'key'='value'}}, '126'=Sequence{Tuple{'key'='value'}}, '127'=Sequence{Tuple{'key'='value'}}, '128'=Sequence{Tuple{'key'='value'}}, ...}",
				result);
	}

}
