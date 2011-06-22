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

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;


/**
 * EMFTVM static utility methods.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public final class EMFTVMUtil {
	
	/**
	 * Native type namespace.
	 */
	public static final String NATIVE = "#native";

	/**
	 * Type namespace delimiter.
	 */
	public static final String NS_DELIM = "::";

	/**
	 * Type namespace matching pattern.
	 * @see #NS_DELIM
	 */
	public static final Pattern DELIM_PATTERN = Pattern.compile(NS_DELIM);

	/**
	 * Name of the "main" static parameterless operation.
	 */
	public static final String MAIN_OP_NAME = "main";

	/**
	 * Name if the XMI ID feature for {@link EObject}s contained in {@link XMIResource}s.
	 */
	public static final String XMI_ID_FEATURE = "__xmiID__";

	private static Metamodel ecoreMetamodel = null;
	private static Metamodel emfTvmMetamodel = null;
	private static Metamodel traceMetamodel = null;

	/**
	 * @param env the execution environment to search for the metamodel
	 * @param modelname the metamodel name
	 * @param typename
	 * @return the type with typename in the metamodel with modelname, or the native type
	 * @throws ClassNotFoundException
	 */
	public static Object findType(final ExecEnv env, final String modelname, 
			final String typename) throws ClassNotFoundException {
		if (NATIVE.equals(modelname)) {
			final Matcher m = DELIM_PATTERN.matcher(typename);
			return Class.forName(m.replaceAll("."));
		} else {
			final Metamodel mm = env.getMetaModels().get(modelname);
			if (mm == null) {
				throw new IllegalArgumentException(String.format("Metamodel %s not found", modelname));
			}
			return mm.findType(typename);
		}
	
	}

	/**
	 * @param env
	 * @param type
	 * @return the name of <code>type</code>, for printing
	 */
	public static String getTypeName(final ExecEnv env, final Object type) {
		if (type instanceof EClass) {
			EClass eCls = (EClass) type;
			for (Map.Entry<String, Metamodel> mm : env.getMetaModels().entrySet()) {
				if (mm.getValue().getResource() == eCls.eResource()) {
					return mm.getKey() + '!' + eCls.getName();
				}
			}
			return ((EClass) type).getName();
		} else if (type instanceof Class<?>) {
			return NATIVE + '!' + ((Class<?>) type).getName();
		} else {
			return type.toString();
		}
	}

	/**
	 * @param env
	 * @param types
	 * @return the names of <code>types</code>, for printing
	 */
	public static String getTypeNames(final ExecEnv env, final Collection<?> types) {
		final StringBuffer names = new StringBuffer();
		boolean notFirst = false;
		for (Object type : types) {
			if (notFirst) {
				names.append(", ");
			}
			names.append(getTypeName(env, type));
		}
		return names.toString();
	}

	/**
	 * @param type
	 * @return the type object to use for the registry
	 * @throws IllegalArgumentException if type is a primitive EMF type without instance class
	 */
	public static Object getRegistryType(final Object type) {
		if (type instanceof EClassifier && !(type instanceof EClass)) {
			final Class<?> ic = ((EClassifier) type).getInstanceClass();
			if (ic == null) {
				throw new IllegalArgumentException(String.format("Primitive EMF type without instance class %s", type));
			}
			return ic;
		}
		return type;
	}

	/**
	 * @return the singleton instance of the Ecore metamodel
	 */
	public static Metamodel getEcoreMetamodel() {
		if (ecoreMetamodel == null) {
			ecoreMetamodel = EmftvmFactory.eINSTANCE.createMetamodel();
			ecoreMetamodel.setResource(EcorePackage.eINSTANCE.eResource());
		}
		return ecoreMetamodel;
	}

	/**
	 * @return the singleton instance of the EMFTVM metamodel
	 */
	public static Metamodel getEmfTvmMetamodel() {
		if (emfTvmMetamodel == null) {
			emfTvmMetamodel = EmftvmFactory.eINSTANCE.createMetamodel();
			emfTvmMetamodel.setResource(EmftvmPackage.eINSTANCE.eResource());
		}
		return emfTvmMetamodel;
	}

	/**
	 * @return the singleton instance of the Trace metamodel
	 */
	public static Metamodel getTraceMetamodel() {
		if (traceMetamodel == null) {
			traceMetamodel = EmftvmFactory.eINSTANCE.createMetamodel();
			traceMetamodel.setResource(TracePackage.eINSTANCE.eResource());
		}
		return traceMetamodel;
	}

	/**
	 * @param env
	 * @param type
	 * @return all instances of type in the registered input/inout models
	 */
	public static LazyList<EObject> findAllInstances(final ExecEnv env, final EClass type) {
		LazyList<EObject> allInst = new LazyList<EObject>();
		for (Model model : env.getInputModels().values()) {
			allInst = allInst.union(model.allInstancesOf(type));
		}
		for (Model model : env.getInoutModels().values()) {
			allInst = allInst.union(model.allInstancesOf(type));
		}
		return allInst;
	}

	/**
	 * @param env
	 * @return all instances of type in the given model
	 */
	public static LazyList<EObject> findAllInstIn(final ExecEnv env, final EClass type, final Object modelname) {
		Model model = env.getInputModels().get(modelname);
		if (model == null) {
			model = env.getInoutModels().get(modelname);
		}
		if (model == null) {
			throw new IllegalArgumentException(String.format("No input/inout model found with name %s", modelname));
		}
		return model.allInstancesOf(type);
	}

	/**
	 * Offers an alternative to the default <code>toString()</code> method.
	 * Uses <code>env</code> to determine the containing model of types.
	 * Compensates for {@link EObject}'s notoriously bad <code>toString()</code>.
	 * @param object
	 * @param env
	 * @return the string representation of <code>object</code>.
	 */
	public static String toPrettyString(final Object object, final ExecEnv env) {
		if (object instanceof EClass) {
			final StringBuffer sb = new StringBuffer();
			if (env != null) {
				final Model model = env.getModelOf((EClass) object);
				if (model != null) {
					sb.append(env.getModelID(model));
					sb.append('!');
				}
			}
			sb.append(((EClass) object).getName());
			return sb.toString();
		} else if (object instanceof EObject) { // EObjects have a notoriously bad toString()
			final StringBuffer buf = new StringBuffer();
			final EObject eo = (EObject) object;
			EStructuralFeature sf = eo.eClass().getEIDAttribute();
			if (sf == null) {
				sf = eo.eClass().getEStructuralFeature("name");
			}
			if (sf != null && eo.eGet(sf) != null) {
				buf.append(eo.eGet(sf));
			} else {
				buf.append(Integer.toHexString(eo.hashCode()));
			}
			buf.append(':');
			buf.append(toPrettyString(eo.eClass(), env));
			return buf.toString();
		} else if (object instanceof Class<?>) {
			return ((Class<?>) object).getName();
		} else if (object != null) {
			return object.toString();
		} else {
			return "null";
		}
	}

	/**
	 * Offers an alternative to the default <code>toString()</code> method.
	 * Uses <code>env</code> to determine the containing model of types.
	 * Compensates for {@link EObject}'s notoriously bad <code>toString()</code>.
	 * @param coll
	 * @param env
	 * @return the string representation of <code>coll</code>.
	 */
	public static String toPrettyString(final Collection<?> coll, final ExecEnv env) {
		final StringBuffer sb = new StringBuffer();
		sb.append('[');
		boolean first = true;
		for (Object object : coll) {
			if (!first) {
				sb.append(", ");
			}
			first = false;
			sb.append(EMFTVMUtil.toPrettyString(object, env));
		}
		sb.append(']');
		return sb.toString();
	}

	/**
	 * Offers an alternative to the default <code>toString()</code> method.
	 * Uses <code>env</code> to determine the containing model of types.
	 * Compensates for {@link EObject}'s notoriously bad <code>toString()</code>.
	 * @param array
	 * @param env
	 * @return the string representation of <code>coll</code>.
	 */
	public static <T> String toPrettyString(final T[] array, final ExecEnv env) {
		final StringBuffer sb = new StringBuffer();
		sb.append('[');
		boolean first = true;
		for (Object object : array) {
			if (!first) {
				sb.append(", ");
			}
			first = false;
			sb.append(EMFTVMUtil.toPrettyString(object, env));
		}
		sb.append(']');
		return sb.toString();
	}

}
