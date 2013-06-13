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
package org.eclipse.m2m.atl.emftvm.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import org.eclipse.emf.common.util.Enumerator;

/**
 * Contains a registry of native type names and their Java class implementations,
 * and provides methods to instantiate native types.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class NativeTypes {

	/**
	 * Enumeration of registered native types.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static enum NativeType {
		OBJECT("Object", Object.class),
		COLLECTION("Collection", LazyCollection.class),
		BAG("Bag", LazyBag.class),
		SEQUENCE("Sequence", LazyList.class),
		SET("Set", LazySet.class),
		ORDERED_SET("OrderedSet", LazyOrderedSet.class),
		MAP("Map", Map.class),
		TUPLE("Tuple", Tuple.class),
		BOOLEAN("Boolean", Boolean.class),
		INTEGER("Integer", Integer.class),
		REAL("Real", Double.class),
		STRING("String", String.class);
		
		private final String name;
		private final Class<?> type;
		
		private NativeType(String name, Class<?> type) {
			this.name = name;
			this.type = type;
		}

		/**
		 * Returns the name.
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Returns the type.
		 * @return the type
		 */
		public Class<?> getType() {
			return type;
		}
	}

	private static final Map<String, NativeType> typeNames = new HashMap<String, NativeType>();
	private static final TypeMap<Class<?>, NativeType> types = new TypeHashMap<Class<?>, NativeType>();
	private static final Map<Class<?>, Class<?>> primitiveTypes = new HashMap<Class<?>, Class<?>>();

	static {
		for (NativeType type : NativeType.values()) {
			typeNames.put(type.getName(), type);
			types.put(type.getType(), type);
		}
		primitiveTypes.put(Boolean.TYPE, Boolean.class);
		primitiveTypes.put(Byte.TYPE, Byte.class);
		primitiveTypes.put(Character.TYPE, Character.class);
		primitiveTypes.put(Short.TYPE, Short.class);
		primitiveTypes.put(Integer.TYPE, Integer.class);
		primitiveTypes.put(Long.TYPE, Long.class);
		primitiveTypes.put(Float.TYPE, Float.class);
		primitiveTypes.put(Double.TYPE, Double.class);
	}

	/**
	 * Do not use.
	 */
	private NativeTypes() {
		super();
	}

	/**
	 * Finds the {@link Class} for <code>typeName</code>.
	 * @param typeName the native type name
	 * @return the {@link Class} for <code>typeName</code>
	 * @throws ClassNotFoundException if the {@link Class} could not be found
	 */
	public static Class<?> findType(final String typeName) throws ClassNotFoundException {
		if (typeNames.containsKey(typeName)) {
			switch (typeNames.get(typeName)) {
			case OBJECT:
				return Object.class;
			case COLLECTION:
				return LazyCollection.class;
			case BAG:
				return LazyBag.class;
			case SEQUENCE:
				return LazyList.class;
			case SET:
				return LazySet.class;
			case ORDERED_SET:
				return LazyOrderedSet.class;
			case MAP:
				return Map.class;
			case TUPLE:
				return Tuple.class;
			case BOOLEAN:
				return Boolean.class;
			case INTEGER:
				return Integer.class;
			case REAL:
				return Double.class;
			case STRING:
				return String.class;
			default:
				throw new ClassNotFoundException(typeName);
			}
		}
		final Matcher m = EMFTVMUtil.DELIM_PATTERN.matcher(typeName);
		return Class.forName(m.replaceAll("."));
	}

	/**
	 * Creates a new instance of <code>type</code>.
	 * @param type the type to instantiate
	 * @return a new instance of <code>type</code>
	 * @throws InstantiationException if the type cannot be instantiated
	 * @throws IllegalAccessException if the type cannot be accessed
	 */
	public static Object newInstance(final Class<?> type)
	throws InstantiationException, IllegalAccessException {
		if (types.containsKey(type)) {
			switch (types.get(type)) {
			case BAG:
				return new LazyBag<Object>();
			case SEQUENCE:
				return new LazyList<Object>();
			case SET:
				return new LazySet<Object>();
			case ORDERED_SET:
				return new LazyOrderedSet<Object>();
			case MAP:
				return new HashMap<Object, Object>();
			case TUPLE:
				return new Tuple();
			case BOOLEAN:
				return Boolean.FALSE;
			case INTEGER:
				return new Integer(0);
			case REAL:
				return new Double(0.0);
			case STRING:
				return new String();
			default:
				throw new InstantiationException(type.getName());
			}
		}
		return type.newInstance();
	}

	/**
	 * Returns the name of <code>type</code>.
	 * @param type the type
	 * @return the name of <code>type</code>
	 */
	public static String typeName(final Class<?> type) {
		final Object key = types.findKey(type);
		if (key != null) {
			return types.get(key).getName();
		}
		return type.getName();
	}

	/**
	 * Returns the boxed EMFTVM type for the given type.
	 * 
	 * @param type
	 *            the Java type for which to return the boxed type
	 * @return the boxed EMFTVM type for the given type
	 */
	public static Class<?> boxedType(final Class<?> type) {
		return Enumerator.class.isAssignableFrom(type) ? EnumLiteral.class : (primitiveTypes.containsKey(type) ? primitiveTypes.get(type)
				: type);
	}

}
