/*******************************************************************************
 * Copyright (c) 2007 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *    William Piers - oclType implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Abstract OCLtype.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class OclType {

	private static final OclType OCL_ANY = new OclSimpleType("OclAny"); //$NON-NLS-1$

	private static final OclType SEQUENCE = new OclParametrizedType("Sequence", OCL_ANY); //$NON-NLS-1$

	private static final OclType SET = new OclParametrizedType("Set", OCL_ANY); //$NON-NLS-1$

	private static final OclType BAG = new OclParametrizedType("Bag", OCL_ANY); //$NON-NLS-1$

	private static Map<Class<?>, OclType> oclTypes = new HashMap<Class<?>, OclType>();

	static {
		oclTypes.put(Collection.class, new OclParametrizedType("Collection", OCL_ANY)); //$NON-NLS-1$
		oclTypes.put(ArrayList.class, SEQUENCE);
		oclTypes.put(HashSet.class, SET);
		oclTypes.put(LinkedHashSet.class, new OclParametrizedType("OrderedSet", OCL_ANY)); //$NON-NLS-1$
		oclTypes.put(Bag.class, BAG);
		oclTypes.put(Tuple.class, new OclSimpleType("Tuple")); //$NON-NLS-1$
		oclTypes.put(EnumLiteral.class, new OclSimpleType("EnumLiteral")); //$NON-NLS-1$
		oclTypes.put(TransientLinkSet.class, new OclSimpleType("TransientLinkSet")); //$NON-NLS-1$
		oclTypes.put(TransientLink.class, new OclSimpleType("TransientLink")); //$NON-NLS-1$
		oclTypes.put(HashMap.class, new OclSimpleType("Map")); //$NON-NLS-1$
		oclTypes.put(String.class, new OclSimpleType("String")); //$NON-NLS-1$
		oclTypes.put(Integer.class, new OclSimpleType("Integer")); //$NON-NLS-1$
		oclTypes.put(Object.class, OCL_ANY);
		oclTypes.put(Boolean.class, new OclSimpleType("Boolean")); //$NON-NLS-1$
		oclTypes.put(Double.class, new OclSimpleType("Real")); //$NON-NLS-1$
		oclTypes.put(ASMModule.class, new OclSimpleType("Module")); //$NON-NLS-1$
		oclTypes.put(OclSimpleType.class, new OclSimpleType("OclSimpleType")); //$NON-NLS-1$
		oclTypes.put(OclParametrizedType.class, new OclSimpleType("OclParametrizedType")); //$NON-NLS-1$
	}

	private static Map<String, Class<?>> nativeClasses = new HashMap<String, Class<?>>();

	static {
		nativeClasses.put("Collection", Collection.class); //$NON-NLS-1$
		nativeClasses.put("Sequence", ArrayList.class); //$NON-NLS-1$
		nativeClasses.put("Set", HashSet.class); //$NON-NLS-1$
		nativeClasses.put("Bag", Bag.class); //$NON-NLS-1$
		nativeClasses.put("OrderedSet", LinkedHashSet.class); //$NON-NLS-1$
		nativeClasses.put("Tuple", Tuple.class); //$NON-NLS-1$
		nativeClasses.put("EnumLiteral", EnumLiteral.class); //$NON-NLS-1$
		nativeClasses.put("OclSimpleType", OclSimpleType.class); //$NON-NLS-1$
		nativeClasses.put("OclParametrizedType", OclParametrizedType.class); //$NON-NLS-1$
		nativeClasses.put("TransientLinkSet", TransientLinkSet.class); //$NON-NLS-1$
		nativeClasses.put("TransientLink", TransientLink.class); //$NON-NLS-1$
		nativeClasses.put("Map", HashMap.class); //$NON-NLS-1$
		nativeClasses.put("Module", ASMModule.class); //$NON-NLS-1$

		// should not use "new" on the following types
		nativeClasses.put("String", String.class); //$NON-NLS-1$
		nativeClasses.put("Integer", Integer.class); //$NON-NLS-1$
		nativeClasses.put("OclAny", Object.class); //$NON-NLS-1$
		nativeClasses.put("Boolean", Boolean.class); //$NON-NLS-1$
		nativeClasses.put("Real", Double.class); //$NON-NLS-1$
	}

	/** Supertypes correspondance map. */
	private static Map<Class<?>, List<Class<?>>> supertypes = new HashMap<Class<?>, List<Class<?>>>();

	static {
		// Integer extends Real
		supertypes.put(Integer.class, Arrays.asList(new Class<?>[] {Double.class}));
		// Boolean extends OclAny
		supertypes.put(Boolean.class, Arrays.asList(new Class<?>[] {Object.class}));
		// String extends OclAny
		supertypes.put(String.class, Arrays.asList(new Class<?>[] {Object.class}));
		// Bag extends Collection
		supertypes.put(Bag.class, Arrays.asList(new Class<?>[] {Collection.class}));
		// Sequence extends Collection
		supertypes.put(ArrayList.class, Arrays.asList(new Class<?>[] {Collection.class}));
		// OrderedSet extends Collection
		supertypes.put(LinkedHashSet.class, Arrays.asList(new Class<?>[] {Collection.class}));
		// Set extends Collection
		supertypes.put(HashSet.class, Arrays.asList(new Class<?>[] {Collection.class}));
		// Collection extends OclAny
		supertypes.put(Collection.class, Arrays.asList(new Class<?>[] {Object.class}));
		// Real extends OclAny
		supertypes.put(Double.class, Arrays.asList(new Class<?>[] {Object.class}));
		// OclParametrizedType extends OclType
		supertypes.put(OclParametrizedType.class, Arrays.asList(new Class<?>[] {OclType.class}));
		// OclSimpleType extends OclType
		supertypes.put(OclSimpleType.class, Arrays.asList(new Class<?>[] {OclType.class}));
		// OclUndefined extends OclAny
		supertypes.put(OclUndefined.class, Arrays.asList(new Class<?>[] {Object.class}));
		// TransientLink extends OclAny
		supertypes.put(TransientLink.class, Arrays.asList(new Class<?>[] {Object.class}));
		// Map extends OclAny
		supertypes.put(HashMap.class, Arrays.asList(new Class<?>[] {Object.class}));
		// ATLModule extends OclAny
		supertypes.put(ASMModule.class, Arrays.asList(new Class<?>[] {Object.class}));
		// Tuple extends OclAny
		supertypes.put(Tuple.class, Arrays.asList(new Class<?>[] {Object.class}));
		// EnumLiteral extends OclAny
		supertypes.put(EnumLiteral.class, Arrays.asList(new Class<?>[] {Object.class}));
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (name == null) ? "<unnamed>" : name; //$NON-NLS-1$
	}

	/**
	 * Tests if the current object conforms to the given object.
	 * 
	 * @param other
	 *            the other object
	 * @return true if the current object conforms to the given object
	 */
	public abstract boolean conformsTo(OclType other);

	public static Map<Class<?>, List<Class<?>>> getSupertypes() {
		return supertypes;
	}

	/**
	 * oclType util.
	 * 
	 * @param cl
	 *            the given class
	 * @return the ocl type
	 */
	public static OclType getOclTypeFromObject(Object cl) {
		OclType res = oclTypes.get(cl.getClass());
		if (res == null) {
			if (cl instanceof Collection) {
				if (cl instanceof List) {
					return SEQUENCE;
				} else if (cl instanceof Set) {
					return SET;
				} else {
					return BAG;
				}
			} else {
				res = OCL_ANY;	
			}			
		}		
		return res;
	}

	/**
	 * oclType util.
	 * 
	 * @param typeName
	 *            the given class
	 * @return the ocl type
	 */
	public static Class<? extends Object> getNativeClassfromOclTypeName(String typeName) {
		return nativeClasses.get(typeName);
	}

	/**
	 * Registers a simple type.
	 * 
	 * @param typeName
	 *            the type name
	 * @param typeClass
	 *            the type class
	 */
	public static void addSimpleType(String typeName, Class<?> typeClass) {
		oclTypes.put(typeClass, new OclSimpleType(typeName));
		nativeClasses.put(typeName, typeClass);
		supertypes.put(typeClass, Arrays.asList(new Class<?>[] {Object.class}));
	}
}
