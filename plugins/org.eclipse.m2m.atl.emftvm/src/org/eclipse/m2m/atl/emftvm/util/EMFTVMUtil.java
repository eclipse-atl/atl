/*******************************************************************************
 * Copyright (c) 2011, 2012 Vrije Universiteit Brussel.
 * Copyright (c) 2012-2019, 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *     William Piers, Obeo
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;

/**
 * EMFTVM static utility methods.
 *
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class EMFTVMUtil {

	/**
	 * Returns the registry type of the switched object.
	 *
	 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
	 */
	public static class RegistryTypeSwitch extends EcoreSwitch<Object> {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object defaultCase(final EObject object) {
			throw new IllegalArgumentException("Unsupported type: " + object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseEClass(final EClass object) {
			return object;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseEClassifier(final EClassifier object) {
			final Class<?> ic = object.getInstanceClass();
			if (ic == null) {
				throw new IllegalArgumentException(String.format("Primitive EMF type without instance class %s", object));
			}
			return ic;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object caseEEnum(final EEnum object) {
			return EnumLiteral.class;
		}

	}

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
	 *
	 * @see #NS_DELIM
	 */
	public static final Pattern DELIM_PATTERN = Pattern.compile(NS_DELIM);

	/**
	 * Name of the "main" static parameterless operation.
	 */
	public static final String MAIN_OP_NAME = "main";

	/**
	 * Name of the "init" static parameterless operation.
	 */
	public static final String INIT_OP_NAME = "init";

	/**
	 * Name if the XMI ID feature for {@link EObject}s contained in {@link XMIResource}s.
	 */
	public static final String XMI_ID_FEATURE = "__xmiID__";

	/**
	 * Implementation class name for {@link WorkspaceUtil}.
	 */
	private static final String WORKSPACE_UTIL_IMPL = "org.eclipse.m2m.atl.emftvm.util.WorkspaceUtilImpl";

	/**
	 * Cache used to store native Java methods.
	 *
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static final ConcurrentMap<MethodSignature, WeakReference<Method>> METHOD_CACHE = new ConcurrentHashMap<MethodSignature, WeakReference<Method>>();

	/**
	 * Represents the <code>null</code> method reference for the {@link #METHOD_CACHE}.
	 */
	private static final WeakReference<Method> NULL_METHOD_REFERENCE = new WeakReference<Method>(null);

	/**
	 * Cache used to store the found root methods for native Java methods.
	 *
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static final Map<Method, WeakReference<Method>> ROOT_METHOD_CACHE = Collections
			.synchronizedMap(new WeakHashMap<Method, WeakReference<Method>>());

	/**
	 * Singleton {@link RegistryTypeSwitch} instance.
	 */
	private static final RegistryTypeSwitch REGISTRY_TYPE_SWITCH = new RegistryTypeSwitch();

	/**
	 * {@link Map#toString()} evaluation cut-off number.
	 */
	private static final int CUT_OFF = 31;

	private static Metamodel ecoreMetamodel;
	private static Metamodel emfTvmMetamodel;
	private static Metamodel traceMetamodel;

	private static volatile int MethodCacheAccesses;
	private static volatile int MethodCacheHits;
	private static volatile int RootMethodCacheAccesses;
	private static volatile int RootMethodCacheHits;

	/**
	 * Not used.
	 */
	private EMFTVMUtil() {
	}

	/**
	 * Returns the name of <code>type</code>, for printing.
	 *
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param type
	 *            the type
	 * @return the name of <code>type</code>, for printing
	 */
	public static String getTypeName(final ExecEnv env, final Object type) {
		if (type instanceof EClass) {
			final EClass eCls = (EClass) type;
			final Metamodel mm = env.getMetaModel(eCls.eResource());
			if (mm != null) {
				return env.getMetaModelID(mm) + '!' + eCls.getName();
			}
			return eCls.getName();
		} else if (type instanceof Class<?>) {
			final Class<?> cls = (Class<?>) type;
			final String nativeTypeName = NativeTypes.typeName(cls);
			return cls.getName().equals(nativeTypeName) ? NATIVE + '!' + nativeTypeName : nativeTypeName;
		} else {
			return type.toString();
		}
	}

	/**
	 * Returns the names of <code>types</code>, for printing.
	 *
	 * @param env
	 *            the current {@link ExecEnv}.
	 * @param types
	 *            the types
	 * @return the names of <code>types</code>, for printing
	 */
	public static String getTypeNames(final ExecEnv env, final Object[] types) {
		final StringBuffer names = new StringBuffer();
		boolean notFirst = false;
		for (final Object type : types) {
			if (notFirst) {
				names.append(", ");
			}
			names.append(getTypeName(env, type));
			notFirst = true;
		}
		return names.toString();
	}

	/**
	 * Returns the type object to use for the registry.
	 *
	 * @param type
	 *            the type object
	 * @return the type object to use for the registry
	 * @throws IllegalArgumentException
	 *             if type is a primitive EMF type without instance class
	 */
	public static Object getRegistryType(final Object type) throws IllegalArgumentException {
		if (type instanceof EClassifier) {
			return REGISTRY_TYPE_SWITCH.doSwitch((EClassifier) type);
		}
		return type;
	}

	/**
	 * Returns the singleton instance of the Ecore metamodel.
	 *
	 * @return the singleton instance of the Ecore metamodel
	 */
	public static synchronized Metamodel getEcoreMetamodel() {
		if (ecoreMetamodel == null) {
			ecoreMetamodel = EmftvmFactory.eINSTANCE.createMetamodel(EcorePackage.eINSTANCE.eResource());
		}
		return ecoreMetamodel;
	}

	/**
	 * Returns the singleton instance of the EMFTVM metamodel.
	 *
	 * @return the singleton instance of the EMFTVM metamodel
	 */
	public static synchronized Metamodel getEmfTvmMetamodel() {
		if (emfTvmMetamodel == null) {
			emfTvmMetamodel = EmftvmFactory.eINSTANCE.createMetamodel(EmftvmPackage.eINSTANCE.eResource());
		}
		return emfTvmMetamodel;
	}

	/**
	 * Returns the singleton instance of the Trace metamodel.
	 *
	 * @return the singleton instance of the Trace metamodel
	 */
	public static synchronized Metamodel getTraceMetamodel() {
		if (traceMetamodel == null) {
			traceMetamodel = EmftvmFactory.eINSTANCE.createMetamodel(TracePackage.eINSTANCE.eResource());
		}
		return traceMetamodel;
	}

	/**
	 * Finds all instances of type in the registered input/inout models.
	 *
	 * @param type
	 *            the type
	 * @param env
	 *            the current {@link ExecEnv}
	 * @return all instances of type in the registered input/inout models
	 */
	public static LazyList<EObject> findAllInstances(final EClass type, final ExecEnv env) {
		LazyList<EObject> allInst = new LazyList<EObject>();
		for (final Model model : env.getInputModels().values()) {
			allInst = allInst.union(model.allInstancesOf(type));
		}
		for (final Model model : env.getInoutModels().values()) {
			allInst = allInst.union(model.allInstancesOf(type));
		}
		return allInst;
	}

	/**
	 * Finds all instances of type in the given model.
	 *
	 * @param modelname
	 *            the model name
	 * @param type
	 *            the type
	 * @param env
	 *            the current {@link ExecEnv}
	 * @return all instances of type in the given model
	 */
	public static LazyList<EObject> findAllInstIn(final Object modelname, final EClass type, final ExecEnv env) {
		Model model = env.getInputModels().get(modelname);
		if (model == null) {
			model = env.getInoutModels().get(modelname);
		}
		if (model == null) {
			model = env.getMetaModels().get(modelname);
		}
		if (model == null) {
			throw new IllegalArgumentException(String.format("No input/inout model found with name %s", modelname));
		}
		return model.allInstancesOf(type);
	}

	/**
	 * Offers an alternative to the default <code>toString()</code> method. Uses <code>env</code> to determine the containing model of
	 * types. Compensates for {@link EObject}'s notoriously bad <code>toString()</code>.
	 *
	 * @param object
	 * @param env
	 * @return the string representation of <code>object</code>.
	 */
	public static String toPrettyString(final Object object, final ExecEnv env) {
		if (object instanceof EClassifier) {
			final StringBuffer sb = new StringBuffer();
			if (env != null) {
				final Model model = env.getModelOf((EClassifier) object);
				if (model != null) {
					sb.append(env.getModelID(model));
					sb.append('!');
				}
			}
			sb.append(((EClassifier) object).getName());
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
		} else if (object instanceof String) {
			return new StringBuffer().append('\'').append(object.toString()).append('\'').toString();
		} else if (object instanceof LazyCollection<?>) {
			return ((LazyCollection<?>) object).asString(env);
		} else if (object instanceof Map<?,?>) {
			final Map<?, ?> map = (Map<?, ?>) object;
			final StringBuilder buf = new StringBuilder("Map{");
			appendMapEntries(env, map, buf);
			buf.append('}');
			return buf.toString();
		} else if (object instanceof Tuple) {
			final Tuple tuple = (Tuple) object;
			final StringBuilder buf = new StringBuilder("Tuple{");
			appendMapEntries(env, tuple.asMap(), buf);
			buf.append('}');
			return buf.toString();
		} else if (object != null) {
			return object.toString();
		} else {
			return "OclUndefined";
		}
	}

	/**
	 * Appends the map entries to the string builder.
	 *
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param map
	 *            the {@link Map} for which to append the entries
	 * @param buf
	 *            the {@link StringBuilder} to append to
	 */
	private static void appendMapEntries(final ExecEnv env, final Map<?, ?> map, final StringBuilder buf) {
		int index = 0;
		for (final Map.Entry<?, ?> entry : map.entrySet()) {
			if (index > CUT_OFF) {
				buf.append(", ...");
				break;
			}
			if (index++ > 0) {
				buf.append(", ");
			}
			buf.append(EMFTVMUtil.toPrettyString(entry.getKey(), env));
			buf.append('=');
			buf.append(EMFTVMUtil.toPrettyString(entry.getValue(), env));
		}
	}

	/**
	 * Offers an alternative to the default <code>toString()</code> method. Uses <code>env</code> to determine the containing model of
	 * types. Compensates for {@link EObject}'s notoriously bad <code>toString()</code>.
	 *
	 * @param coll
	 * @param env
	 * @return the string representation of <code>coll</code>.
	 */
	public static String toPrettyString(final Collection<?> coll, final ExecEnv env) {
		final StringBuffer sb = new StringBuffer();
		sb.append('[');
		boolean first = true;
		for (final Object object : coll) {
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
	 * Offers an alternative to the default <code>toString()</code> method. Uses <code>env</code> to determine the containing model of
	 * types. Compensates for {@link EObject}'s notoriously bad <code>toString()</code>.
	 *
	 * @param array
	 * @param env
	 * @return the string representation of <code>coll</code>.
	 */
	public static <T> String toPrettyString(final T[] array, final ExecEnv env) {
		final StringBuffer sb = new StringBuffer();
		sb.append('[');
		boolean first = true;
		for (final Object object : array) {
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
	 * Retrieves the value of <code>eo.sf</code>. Checks that <code>eo</code> is not in an output model.
	 *
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param eo
	 *            the model element to retrieve the value from
	 * @param sf
	 *            the structural feature to retrieve the value from
	 * @return the value of <code>eo.sf</code>.
	 */
	public static Object get(final ExecEnv env, final EObject eo, final EStructuralFeature sf) {
		if (env.getOutputModelOf(eo) != null) {
			throw new IllegalArgumentException(String.format("Cannot read properties of %s, as it is contained in an output model",
					toPrettyString(eo, env)));
		}
		return uncheckedGet(env, eo, sf);
	}

	/**
	 * Retrieves the value of <code>eo.sf</code>.
	 *
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param eo
	 *            the model element to retrieve the value from
	 * @param sf
	 *            the structural feature to retrieve the value from
	 * @return the value of <code>eo.sf</code>.
	 */
	@SuppressWarnings("unchecked")
	public static Object uncheckedGet(final ExecEnv env, final EObject eo, final EStructuralFeature sf) {
		if (sf instanceof EReference) {
			// EReferences need only EList conversion, notably not EnumLiteral conversion
			final Object value = eo.eGet(sf);
			if (!(value instanceof Collection<?>) || (value instanceof LazyCollection<?>)) {
				// Simple values and internal collection types don't need conversion
				return value;
			}
			if (value instanceof List<?>) {
				if (eo != null && env.getInoutModelOf(eo) != null) {
					// Copy list for inout models
					return new LazyListOnList<Object>(new ArrayList<Object>((List<Object>) value));
				} else {
					return new LazyListOnList<Object>((List<Object>) value);
				}
			} else if (value instanceof Set<?>) {
				if (eo != null && env.getInoutModelOf(eo) != null) {
					// Copy list for inout models
					return new LazySetOnSet<Object>(new LinkedHashSet<Object>((Set<Object>) value));
				} else {
					return new LazySetOnSet<Object>((Set<Object>) value);
				}
			} else {
				if (eo != null && env.getInoutModelOf(eo) != null) {
					// Copy list for inout models
					return new LazyListOnCollection<Object>(new ArrayList<Object>((Collection<Object>) value));
				} else {
					return new LazyListOnCollection<Object>((Collection<Object>) value);
				}
			}
		} else {
			return emf2vm(env, eo, eo.eGet(sf));
		}
	}

	/**
	 * Converts <code>value</code> to an EMFTVM value.
	 *
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param eo
	 *            the {@link EObject} from which the value was obtained
	 * @param value
	 *            the EMF value to convert
	 * @return the EMFTVM value
	 */
	@SuppressWarnings("unchecked")
	public static Object emf2vm(final ExecEnv env, final EObject eo, final Object value) {
		if (value instanceof Enumerator) {
			return new EnumLiteral(value.toString());
		} else if (value instanceof Collection<?>) {
			if (value instanceof LazyCollection<?>) {
				// Internal collection types don't need conversion
				return value;
			} else if (value instanceof List<?>) {
				if (eo != null && env.getInoutModelOf(eo) != null) {
					// Copy list for inout models
					return new EnumConversionListOnList((List<Object>) value).cache();
				} else {
					return new EnumConversionListOnList((List<Object>) value);
				}
			} else if (value instanceof Set<?>) {
				if (eo != null && env.getInoutModelOf(eo) != null) {
					// Copy list for inout models
					return new EnumConversionSetOnSet((Set<Object>) value).cache();
				} else {
					return new EnumConversionSetOnSet((Set<Object>) value);
				}
			} else {
				if (eo != null && env.getInoutModelOf(eo) != null) {
					// Copy list for inout models
					return new EnumConversionList((Collection<Object>) value).cache();
				} else {
					return new EnumConversionList((Collection<Object>) value);
				}
			}
		} else if (value != null && value.getClass().isArray()) {
			if (Object.class.isAssignableFrom(value.getClass().getComponentType())) {
				return new LazyListOnList<Object>(Arrays.asList((Object[]) value));
			} else {
				return value; // don't wrap primitive type arrays
			}
		}
		assert eo == null || !(value instanceof Collection<?>);
		return value;
	}

	/**
	 * Sets the <code>value</code> of <code>eo.sf</code>.
	 *
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param eo
	 *            the model element to set the value for
	 * @param sf
	 *            the structural feature to set the value for
	 * @param value
	 *            the value to set
	 */
	public static void set(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Object value) {
		if (!sf.isChangeable()) {
			throw new IllegalArgumentException(String.format("Field %s::%s is not changeable",
					toPrettyString(sf.getEContainingClass(), env), sf.getName()));
		}
		if (env.getInputModelOf(eo) != null) {
			throw new IllegalArgumentException(String.format("Cannot set properties of %s, as it is contained in an input model",
					toPrettyString(eo, env)));
		}
		if (sf.isMany()) {
			if (!(value instanceof Collection<?>)) {
				throw new IllegalArgumentException(String.format("Cannot assign %s to multi-valued field %s::%s",
						toPrettyString(value, env), sf.getEContainingClass().getName(), sf.getName()));
			}
			setMany(env, eo, sf, (Collection<?>) value);
		} else {
			setSingle(env, eo, sf, value, -1);
		}
		assert eo.eResource() != null;
	}

	/**
	 * Adds the <code>value</code> of <code>eo.sf</code>.
	 *
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index
	 *            the insertion index (-1 for end)
	 */
	public static void add(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Object value, final int index) {
		if (!sf.isChangeable()) {
			throw new IllegalArgumentException(String.format("Field %s::%s is not changeable",
					toPrettyString(sf.getEContainingClass(), env), sf.getName()));
		}
		if (env.getInputModelOf(eo) != null) {
			throw new IllegalArgumentException(String.format("Cannot add properties to %s, as it is contained in an input model",
					toPrettyString(eo, env)));
		}
		if (sf.isMany()) {
			if (value instanceof Collection<?>) {
				EMFTVMUtil.addMany(env, eo, sf, (Collection<?>) value, index);
			} else {
				EMFTVMUtil.addMany(env, eo, sf, value, index);
			}
		} else {
			if (eo.eIsSet(sf)) {
				throw new IllegalArgumentException(String.format("Cannot add more than one value to %s::%s",
						toPrettyString(eo.eClass(), env), sf.getName()));
			}
			EMFTVMUtil.setSingle(env, eo, sf, value, index);
		}
		assert eo.eResource() != null;
	}

	/**
	 * Removes the <code>value</code> from <code>eo.sf</code>.
	 *
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 */
	public static void remove(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Object value) {
		if (!sf.isChangeable()) {
			throw new IllegalArgumentException(String.format("Field %s::%s is not changeable",
					toPrettyString(sf.getEContainingClass(), env), sf.getName()));
		}
		if (env.getInputModelOf(eo) != null) {
			throw new IllegalArgumentException(String.format("Cannot remove properties of %s, as it is contained in an input model",
					toPrettyString(eo, env)));
		}
		if (sf.isMany()) {
			if (value instanceof Collection<?>) {
				EMFTVMUtil.removeMany(env, eo, sf, (Collection<?>) value);
			} else {
				EMFTVMUtil.removeMany(env, eo, sf, value);
			}
		} else {
			final Object oldValue = eo.eGet(sf);
			final EClassifier sfType = sf.getEType();
			if (sfType instanceof EEnum && value instanceof EnumLiteral) {
				final EEnum eEnum = (EEnum) sfType;
				if (oldValue != null && oldValue.equals(((EnumLiteral) value).getEnumerator(eEnum))) {
					EMFTVMUtil.setSingle(env, eo, sf, sf.getDefaultValue(), -1);
				}
			} else {
				if (oldValue == null ? value == null : oldValue.equals(value)) {
					EMFTVMUtil.setSingle(env, eo, sf, sf.getDefaultValue(), -1);
				}
			}
		}
		assert eo.eResource() != null;
	}

	/**
	 * Sets the <code>value</code> of <code>eo.sf</code>. Assumes <code>sf</code> has a multiplicity &lt;= 1.
	 *
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index
	 *            the insertion index (-1 for end)
	 */
	private static void setSingle(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Object value, final int index) {
		assert !sf.isMany();
		if (index > 0) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			if (checkValue(env, eo, ref, value, isAllowInterModelReferences(env, eo))) {
				final EObject oldValue = (EObject) eo.eGet(sf);
				assert eo.eResource() != null;
				assert value == null || ((EObject) value).eResource() != null;
				assert oldValue == null || oldValue.eResource() != null;
				eo.eSet(sf, value);
				if (ref.isContainment() || ref.isContainer()) {
					if (value != null) {
						updateResource(eo, (EObject) value);
					}
					if (oldValue != null) {
						updateResource(eo, oldValue);
					}
				}
				assert eo.eResource() != null;
				assert value == null || ((EObject) value).eResource() != null;
				assert oldValue == null || oldValue.eResource() != null;
			}
		} else {
			final EClassifier sfType = sf.getEType();
			if (sfType instanceof EEnum) {
				final EEnum eEnum = (EEnum) sfType;
				if (value instanceof EnumLiteral) {
					eo.eSet(sf, ((EnumLiteral) value).getEnumerator(eEnum));
				} else {
					eo.eSet(sf, value);
				}
			} else {
				eo.eSet(sf, value);
			}
		}
	}

	/**
	 * Sets the <code>value</code> of <code>eo.sf</code>. Assumes <code>sf</code> has a multiplicity &gt; 1.
	 *
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	private static void setMany(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Collection<?> value) {
		assert sf.isMany();
		final Collection<Object> values = (Collection<Object>) eo.eGet(sf);
		if (!values.isEmpty()) {
			if (sf instanceof EReference) {
				final List<Object> vCopy = new ArrayList<Object>(values);
				for (final EObject v : (List<? extends EObject>) vCopy) {
					removeRefValue((EReference) sf, eo, values, v);
				}
			} else {
				values.clear();
			}
		}
		addMany(env, eo, sf, value, -1);
	}

	/**
	 * Adds <code>value</code> to <code>eo.sf</code>. Assumes <code>sf</code> has a multiplicity &gt; 1.
	 *
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index
	 *            the insertion index (-1 for end)
	 */
	@SuppressWarnings("unchecked")
	private static void addMany(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Object value, final int index) {
		assert sf.isMany();
		final Collection<Object> values = (Collection<Object>) eo.eGet(sf); // All EMF collections are ELists
		if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			addRefValue(env, ref, eo, values, (EObject) value, index, isAllowInterModelReferences(env, eo));
		} else {
			final EClassifier sfType = sf.getEType();
			if (sfType instanceof EEnum) {
				addEnumValue((EEnum) sfType, values, value, index);
			} else if (index > -1) {
				((List<Object>) values).add(index, value);
			} else {
				values.add(value);
			}
		}
	}

	/**
	 * Adds all <code>value</code> elements to <code>eo.sf</code>. Assumes <code>sf</code> has a multiplicity &gt; 1.
	 *
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 * @param index
	 *            the insertion index (-1 for end)
	 */
	@SuppressWarnings("unchecked")
	private static void addMany(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Collection<?> value, final int index) {
		assert sf.isMany();
		final Collection<Object> values = (Collection<Object>) eo.eGet(sf);
		if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			final boolean allowInterModelReferences = isAllowInterModelReferences(env, eo);
			final Collection<?> srcValues = ref.isContainment() ? new ArrayList<Object>(value) : value;
			if (index > -1) {
				int currentIndex = index;
				for (final Object v : srcValues) {
					checkValueTypeIsEObject(env, ref, v);
					addRefValue(env, ref, eo, values, (EObject) v, currentIndex++, allowInterModelReferences);
				}
			} else {
				for (final Object v : srcValues) {
					checkValueTypeIsEObject(env, ref, v);
					addRefValue(env, ref, eo, values, (EObject) v, -1, allowInterModelReferences);
				}
			}
		} else {
			final EClassifier sfType = sf.getEType();
			if (sfType instanceof EEnum) {
				final EEnum eEnum = (EEnum) sfType;
				if (index > -1) {
					int currentIndex = index;
					for (final Object v : value) {
						addEnumValue(eEnum, values, v, currentIndex++);
					}
				} else {
					for (final Object v : value) {
						addEnumValue(eEnum, values, v, -1);
					}
				}
			} else if (index > -1) {
				((List<Object>) values).addAll(index, value);
			} else {
				values.addAll(value);
			}
		}
	}

	/**
	 * Checks that the value is an instance of {@link EObject}.
	 *
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param ref
	 *            the {@link EReference} to assign to
	 * @param v
	 *            the value to check
	 */
	private static void checkValueTypeIsEObject(final ExecEnv env, final EReference ref, final Object v) {
		if (!(v instanceof EObject)) {
			final String message = v == null
					? String.format("Cannot add/remove OclUndefined to/from multi-valued field %s::%s",
							ref.getEContainingClass().getName(), ref.getName())
							: String.format("Cannot add/remove values of type %s to/from multi-valued field %s::%s",
									getTypeName(env, v.getClass()), ref.getEContainingClass().getName(), ref.getName());
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Removes the <code>value</code> from <code>eo.sf</code>. Assumes <code>sf</code> has a multiplicity &gt; 1.
	 *
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	private static void removeMany(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Object value) {
		assert sf.isMany();
		final Collection<Object> values = (Collection<Object>) eo.eGet(sf);
		if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			removeRefValue(ref, eo, values, (EObject) value);
		} else {
			final EClassifier sfType = sf.getEType();
			if (sfType instanceof EEnum) {
				final EEnum eEnum = (EEnum) sfType;
				removeEnumValue(eEnum, values, value);
			} else {
				values.remove(value);
			}
		}
	}

	/**
	 * Removes all elements of <code>value</code> from <code>eo.sf</code>. Assumes <code>sf</code> has a multiplicity &gt; 1.
	 *
	 * @param env
	 * @param eo
	 * @param sf
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	private static void removeMany(final ExecEnv env, final EObject eo, final EStructuralFeature sf, final Collection<?> value) {
		assert sf.isMany();
		final Collection<Object> values = (Collection<Object>) eo.eGet(sf);
		if (sf instanceof EReference) {
			final EReference ref = (EReference) sf;
			final Collection<?> srcValues = ref.isContainment() ? new ArrayList<Object>(value) : value;
			for (final Object v : srcValues) {
				checkValueTypeIsEObject(env, ref, v);
				removeRefValue(ref, eo, values, (EObject) v);
			}
		} else {
			final EClassifier sfType = sf.getEType();
			if (sfType instanceof EEnum) {
				final EEnum eEnum = (EEnum) sfType;
				for (final Object v : value) {
					removeEnumValue(eEnum, values, v);
				}
			} else {
				values.removeAll(value);
			}
		}
	}

	/**
	 * Adds <code>v</code> to <code>values</code>. Performs enumerator conversion.
	 *
	 * @param eEnum
	 *            The enumeration type
	 * @param values
	 * @param v
	 * @param index
	 *            the insertion index (-1 for end)
	 */
	private static void addEnumValue(final EEnum eEnum, final Collection<Object> values, final Object v, final int index) {
		final Object v2;
		if (v instanceof EnumLiteral) {
			v2 = ((EnumLiteral) v).getEnumerator(eEnum);
		} else {
			v2 = v;
		}
		if (index > -1) {
			((List<Object>) values).add(index, v2);
		} else {
			values.add(v2);
		}
	}

	/**
	 * Removes <code>v</code> from <code>values</code>. Performs enumerator conversion.
	 *
	 * @param eEnum
	 *            The enumeration type
	 * @param values
	 * @param v
	 */
	private static void removeEnumValue(final EEnum eEnum, final Collection<Object> values, final Object v) {
		if (v instanceof EnumLiteral) {
			values.remove(((EnumLiteral) v).getEnumerator(eEnum));
		} else {
			values.remove(v);
		}
	}

	/**
	 * Adds <code>v</code> to <code>values</code>. Performs constraint checking on <code>v</code>.
	 *
	 * @param env
	 * @param ref
	 *            The reference type
	 * @param eo
	 *            The object with <code>ref</code> set to <code>values</code>
	 * @param values
	 * @param v
	 * @param index
	 *            the insertion index (-1 for end)
	 * @param allowInterModelReferences
	 */
	private static void addRefValue(final ExecEnv env, final EReference ref, final EObject eo, final Collection<Object> values,
			final EObject v, final int index, final boolean allowInterModelReferences) {
		assert eo.eResource() != null;
		assert v == null || v.eResource() != null;
		if (checkValue(env, eo, ref, v, allowInterModelReferences)) {
			if (index > -1) {
				((List<Object>) values).add(index, v);
			} else {
				values.add(v);
			}
			if (ref.isContainment() || ref.isContainer()) {
				updateResource(eo, v);
			}
		}
		assert eo.eResource() != null;
		assert v.eResource() != null;
	}

	/**
	 * Removes <code>v</code> from <code>values</code>. Performs constraint checking on <code>v</code>.
	 *
	 * @param ref
	 *            The reference type
	 * @param eo
	 *            The object with <code>ref</code> set to <code>values</code>
	 * @param values
	 * @param v
	 */
	private static void removeRefValue(final EReference ref, final EObject eo, final Collection<Object> values, final EObject v) {
		assert eo.eResource() != null;
		assert v.eResource() != null;
		if (values.remove(v) && (ref.isContainment() || ref.isContainer())) {
			updateResource(eo, v);
		}
		assert eo.eResource() != null;
		assert v.eResource() != null;
	}

	/**
	 * Updates the eResource() for <code>eo</code> and <code>v</code> where necessary
	 *
	 * @param eo
	 *            the {@link EObject} for which an {@link EReference} has just been modified
	 * @param v
	 *            the value of the {@link EReference} that has just been modified
	 */
	private static void updateResource(final EObject eo, final EObject v) {
		if (eo.eResource() == null) {
			assert eo.eContainer() == null;
			v.eResource().getContents().add(eo);
		} else if (v.eResource() == null) {
			assert v.eContainer() == null;
			eo.eResource().getContents().add(v);
		}
		if (eo.eContainer() != null) {
			eo.eResource().getContents().remove(eo);
		}
		if (v.eContainer() != null) {
			v.eResource().getContents().remove(v);
		}
	}

	/**
	 * Checks whether the model containing <code>eo</code> allows inter-model references.
	 *
	 * @param env
	 *            the {@link ExecEnv} in which to find the model.
	 * @param eo
	 *            the model element to find the model for.
	 * @return <code>true</code> iff the model of <code>eo</code> allows inter-model references
	 */
	private static boolean isAllowInterModelReferences(final ExecEnv env, final EObject eo) {
		final Model eoModel = env.getModelOf(eo);
		if (eoModel != null) {
			return eoModel.isAllowInterModelReferences();
		} else {
			return true;
		}
	}

	/**
	 * Checks whether <code>value</code> may be assigned to <code>eo.ref</code>.
	 *
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param eo
	 *            the model element to assign to
	 * @param ref
	 *            the reference of the model element to assign to
	 * @param value
	 *            the value to assign
	 * @param allowInterModelReferences
	 *            whether to allow inter-model references
	 * @return <code>true</code> iff the value may be assigned
	 */
	private static boolean checkValue(final ExecEnv env, final EObject eo, final EReference ref, final Object value,
			final boolean allowInterModelReferences) {
		if (value instanceof EObject) {
			assert eo.eResource() != null;
			final EObject ev = (EObject) value;
			if (eo.eResource() == ev.eResource() || ev.eResource() == null) {
				return true;
			}
			assert ev.eResource() != null;
			if (!allowInterModelReferences) {
				ATLLogger
				.warning(String.format("Cannot set %s::%s to %s for %s: inter-model references are not allowed for this model",
						toPrettyString(ref.getEContainingClass(), env), ref.getName(), toPrettyString(value, env),
						toPrettyString(eo, env)));
				return false;
			}
			if (ref.isContainer() || ref.isContainment()) {
				ATLLogger
				.warning(String.format("Cannot set %s::%s to %s for %s: containment references cannot span across models",
						toPrettyString(ref.getEContainingClass(), env), ref.getName(), toPrettyString(value, env),
						toPrettyString(eo, env)));
				return false;
			}
			final EReference opposite = ref.getEOpposite();
			if (opposite != null) {
				final Model evModel = env.getInputModelOf(ev);
				if (evModel != null) {
					ATLLogger.warning(String.format(
							"Cannot set %s::%s to %s for %s: inter-model reference with opposite causes changes in input model %s",
							toPrettyString(ref.getEContainingClass(), env), ref.getName(), toPrettyString(value, env),
							toPrettyString(eo, env), env.getModelID(evModel)));
					return false;
				}
				if (!opposite.isMany()) {
					// Single-valued opposites cause changes in their respective opposite,
					// i.e. ref, which can belong to eo or another input model element.
					final Model oppositeModel = env.getInputModelOf((EObject) ev.eGet(opposite));
					if (oppositeModel != null) {
						ATLLogger
						.warning(String
								.format("Cannot set %s::%s to %s for %s: inter-model reference with single-valued opposite causes changes in input model %s",
										toPrettyString(ref.getEContainingClass(), env), ref.getName(), toPrettyString(value, env),
										toPrettyString(eo, env), env.getModelID(oppositeModel)));
						return false;
					}
				}
			}
		}
		return true; // any type errors can be delegated to EMF
	}

	/**
	 * Retrieves the types of <code>args</code>.
	 *
	 * @param args
	 * @return the types of <code>args</code>
	 */
	public static Object[] getArgumentTypes(final Object[] args) {
		final int argcount = args.length;
		final Object[] argTypes = new Object[argcount];
		for (int i = 0; i < argcount; i++) {
			argTypes[i] = getArgumentType(args[i]);
		}
		return argTypes;
	}

	/**
	 * Retrieves the type of <code>arg</code>.
	 *
	 * @param arg
	 * @return the type of <code>arg</code>
	 */
	public static Object getArgumentType(final Object arg) {
		if (arg instanceof EObject) {
			return ((EObject) arg).eClass();
		} else if (arg != null) {
			return arg.getClass();
		}
		// null is an instance of Void for the purpose of our multi-method semantics
		return Void.TYPE;
	}

	/**
	 * Invokes native Java method <code>opname</code> on <code>self</code> with arguments <code>args</code>.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param self
	 *            the object on which to invoke the method
	 * @param opname
	 *            the method name
	 * @param args
	 *            the method arguments
	 * @return the method result
	 */
	public static Object invokeNative(final StackFrame frame, final Object self, final String opname, final Object[] args) {
		final Method method = EMFTVMUtil.findNativeMethod(self == null ? Void.TYPE : self.getClass(), opname,
				EMFTVMUtil.getArgumentClasses(args), false);
		if (method != null) {
			return invokeNative(frame, self, method, args);
		}
		throw new UnsupportedOperationException(String.format("%s::%s(%s)", EMFTVMUtil.getTypeName(frame.getEnv(), getArgumentType(self)),
				opname, EMFTVMUtil.getTypeNames(frame.getEnv(), getArgumentTypes(args))));
	}

	/**
	 * Invokes native Java <code>method</code> on <code>self</code> with arguments <code>args</code>.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param self
	 *            the object on which to invoke the method
	 * @param method
	 *            the method
	 * @param args
	 *            the method arguments
	 * @return the method result
	 */
	public static Object invokeNative(final StackFrame frame, final Object self, Method method, final Object[] args) {
		// Fix for Bug # 461445: EMFTVM cannot invoke Java methods on instances of private classes:
		method = findRootMethod(method);
		final StackFrame subFrame = frame.prepareNativeArgs(method, self, args);
		try {
			return emf2vm(frame.getEnv(), self instanceof EObject ? (EObject) self : null, method.invoke(self, args));
		} catch (final InvocationTargetException e) {
			final Throwable target = e.getTargetException();
			if (target instanceof VMException) {
				throw (VMException) target;
			} else {
				throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, target);
			}
		} catch (final VMException e) {
			throw e;
		} catch (final Exception e) {
			throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, e);
		}
	}

	/**
	 * Invokes native Java method <code>opname</code> on <code>self</code> with argument <code>arg</code>.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param self
	 *            the object on which to invoke the method
	 * @param opname
	 *            the method name
	 * @param arg
	 *            the method argument
	 * @return the method result
	 */
	public static Object invokeNative(final StackFrame frame, final Object self, final String opname, final Object arg) {
		final Method method = EMFTVMUtil.findNativeMethod(self == null ? Void.TYPE : self.getClass(), opname,
				arg == null ? Void.TYPE : arg.getClass(), false);
		if (method != null) {
			return invokeNative(frame, self, method, arg);
		}
		throw new UnsupportedOperationException(String.format("%s::%s(%s)", EMFTVMUtil.getTypeName(frame.getEnv(), getArgumentType(self)),
				opname, EMFTVMUtil.getTypeName(frame.getEnv(), getArgumentType(arg))));
	}

	/**
	 * Invokes native Java <code>method</code> on <code>self</code> with argument <code>arg</code>.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param self
	 *            the object on which to invoke the method
	 * @param method
	 *            the method
	 * @param arg
	 *            the method argument
	 * @return the method result
	 */
	public static Object invokeNative(final StackFrame frame, final Object self, Method method, Object arg) {
		// Fix for Bug # 461445: EMFTVM cannot invoke Java methods on instances of private classes:
		method = findRootMethod(method);
		StackFrame subFrame = frame.prepareNativeContext(method, self);
		if (arg instanceof CodeBlock) {
			if (subFrame == null) {
				subFrame = new StackFrame(frame, method);
			}
			((CodeBlock) arg).setParentFrame(subFrame);
		} else if (arg instanceof EnumLiteral) {
			arg = convertEnumLiteral((EnumLiteral) arg, method.getParameterTypes()[0]);
		}
		try {
			return emf2vm(frame.getEnv(), self instanceof EObject ? (EObject) self : null, method.invoke(self, arg));
		} catch (final InvocationTargetException e) {
			final Throwable target = e.getTargetException();
			if (target instanceof VMException) {
				throw (VMException) target;
			} else {
				throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, target);
			}
		} catch (final VMException e) {
			throw e;
		} catch (final Exception e) {
			throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, e);
		}
	}

	/**
	 * Invokes native Java method <code>opname</code> on <code>self</code> without arguments.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param self
	 *            the object on which to invoke the method
	 * @param opname
	 *            the method name
	 * @return the method result
	 */
	public static Object invokeNative(final StackFrame frame, final Object self, final String opname) {
		final Method method = EMFTVMUtil.findNativeMethod(self == null ? Void.TYPE : self.getClass(), opname, false);
		if (method != null) {
			return invokeNative(frame, self, method);
		}
		throw new UnsupportedOperationException(String.format("%s::%s()", EMFTVMUtil.getTypeName(frame.getEnv(), getArgumentType(self)),
				opname));
	}

	/**
	 * Invokes native Java <code>method</code> on <code>self</code> without arguments.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param self
	 *            the object on which to invoke the method
	 * @param method
	 *            the method
	 * @return the method result
	 */
	public static Object invokeNative(final StackFrame frame, final Object self, Method method) {
		// Fix for Bug # 461445: EMFTVM cannot invoke Java methods on instances of private classes:
		method = findRootMethod(method);
		final StackFrame subFrame = frame.prepareNativeContext(method, self);
		try {
			return emf2vm(frame.getEnv(), self instanceof EObject ? (EObject) self : null, method.invoke(self));
		} catch (final InvocationTargetException e) {
			final Throwable target = e.getTargetException();
			if (target instanceof VMException) {
				throw (VMException) target;
			} else {
				throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, target);
			}
		} catch (final VMException e) {
			throw e;
		} catch (final Exception e) {
			throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, e);
		}
	}

	/**
	 * Invokes static native Java method <code>opname</code> with arguments <code>args</code>.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param type
	 *            the class in which the static method is defined
	 * @param opname
	 *            the method name
	 * @param args
	 *            the method arguments
	 * @return the method result
	 */
	public static Object invokeNativeStatic(final StackFrame frame, final Class<?> type, final String opname, final Object[] args) {
		final Method method = EMFTVMUtil.findNativeMethod(type, opname, EMFTVMUtil.getArgumentClasses(args), true);
		if (method != null) {
			final StackFrame subFrame = frame.prepareNativeArgs(method, args);
			try {
				return emf2vm(frame.getEnv(), null, method.invoke(type, args));
			} catch (final InvocationTargetException e) {
				final Throwable target = e.getTargetException();
				if (target instanceof VMException) {
					throw (VMException) target;
				} else {
					throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, target);
				}
			} catch (final VMException e) {
				throw e;
			} catch (final Exception e) {
				throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, e);
			}
		}
		throw new UnsupportedOperationException(String.format("static %s::%s(%s)", EMFTVMUtil.getTypeName(frame.getEnv(), type), opname,
				EMFTVMUtil.getTypeNames(frame.getEnv(), getArgumentTypes(args))));
	}

	/**
	 * Invokes static native Java method <code>opname</code> with argument <code>arg</code>.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param type
	 *            the class in which the static method is defined
	 * @param opname
	 *            the method name
	 * @param arg
	 *            the method arguments
	 * @return the method result
	 */
	public static Object invokeNativeStatic(final StackFrame frame, final Class<?> type, final String opname, Object arg) {
		final Method method = EMFTVMUtil.findNativeMethod(type, opname, arg == null ? Void.TYPE : arg.getClass(), true);
		if (method != null) {
			StackFrame subFrame = null;
			if (arg instanceof CodeBlock) {
				subFrame = new StackFrame(frame, method);
				((CodeBlock) arg).setParentFrame(subFrame);
			} else if (arg instanceof EnumLiteral) {
				arg = convertEnumLiteral((EnumLiteral) arg, method.getParameterTypes()[0]);
			}
			try {
				return emf2vm(frame.getEnv(), null, method.invoke(type, arg));
			} catch (final InvocationTargetException e) {
				final Throwable target = e.getTargetException();
				if (target instanceof VMException) {
					throw (VMException) target;
				} else {
					throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, target);
				}
			} catch (final VMException e) {
				throw e;
			} catch (final Exception e) {
				throw new VMException(subFrame == null ? new StackFrame(frame, method) : subFrame, e);
			}
		}
		throw new UnsupportedOperationException(String.format("static %s::%s(%s)", EMFTVMUtil.getTypeName(frame.getEnv(), type), opname,
				EMFTVMUtil.getTypeName(frame.getEnv(), getArgumentType(arg))));
	}

	/**
	 * Invokes static native Java method <code>opname</code> without arguments.
	 *
	 * @param frame
	 *            the current stack frame
	 * @param type
	 *            the class in which the static method is defined
	 * @param opname
	 *            the method name
	 * @return the method result
	 */
	public static Object invokeNativeStatic(final StackFrame frame, final Class<?> type, final String opname) {
		final Method method = EMFTVMUtil.findNativeMethod(type, opname, true);
		if (method != null) {
			try {
				return emf2vm(frame.getEnv(), null, method.invoke(type));
			} catch (final InvocationTargetException e) {
				final Throwable target = e.getTargetException();
				if (target instanceof VMException) {
					throw (VMException) target;
				} else {
					throw new VMException(new StackFrame(frame, method), target);
				}
			} catch (final VMException e) {
				throw e;
			} catch (final Exception e) {
				throw new VMException(new StackFrame(frame, method), e);
			}
		}
		throw new UnsupportedOperationException(String.format("static %s::%s()", EMFTVMUtil.getTypeName(frame.getEnv(), type), opname));
	}

	/**
	 * Looks for a native Java method.
	 *
	 * @param context
	 *            The class of the method
	 * @param opname
	 *            The method name
	 * @param argTypes
	 *            The types of all arguments
	 * @param isStatic
	 *            Whether to look for a static method or not
	 * @return the method if found, null otherwise
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static Method findNativeMethod(final Class<?> context, final String opname, final Class<?>[] argTypes, final boolean isStatic) {
		if (context == Void.TYPE) {
			return null; // Java methods cannot be invoked on null, or defined on Void
		}

		final MethodSignature sig = getMethodSignature(context, opname, argTypes, isStatic);
		MethodCacheAccesses++;
		final WeakReference<Method> methodRef = METHOD_CACHE.get(sig);
		final Method ret = methodRef != null ? methodRef.get() : null;
		if (ret != null || methodRef == NULL_METHOD_REFERENCE) {
			MethodCacheHits++;
			return methodRef.get();
		}

		return findNativeMethodInternal(context, opname, argTypes, isStatic, sig);
	}

	/**
	 * Looks for a native Java method.
	 *
	 * @param context
	 *            The class of the method
	 * @param opname
	 *            The method name
	 * @param argumentType
	 *            The type of the argument
	 * @param isStatic
	 *            Whether to look for a static method or not
	 * @return the method if found, null otherwise
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static Method findNativeMethod(final Class<?> context, final String opname, final Class<?> argType, final boolean isStatic) {
		if (context == Void.TYPE) {
			return null; // Java methods cannot be invoked on null, or defined on Void
		}

		final MethodSignature sig = getMethodSignature(context, opname, argType, isStatic);
		MethodCacheAccesses++;
		final WeakReference<Method> methodRef = METHOD_CACHE.get(sig);
		final Method ret = methodRef != null ? methodRef.get() : null;
		if (ret != null || methodRef == NULL_METHOD_REFERENCE) {
			MethodCacheHits++;
			return ret;
		}

		return findNativeMethodInternal(context, opname, argType, isStatic, sig);
	}

	/**
	 * Looks for a native Java method without arguments.
	 *
	 * @param context
	 *            The class of the method
	 * @param opname
	 *            The method name
	 * @param isStatic
	 *            Whether to look for a static method or not
	 * @return the method if found, null otherwise
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static Method findNativeMethod(final Class<?> context, final String opname, final boolean isStatic) {
		if (context == Void.TYPE) {
			return null; // Java methods cannot be invoked on null, or defined on Void
		}

		final MethodSignature sig = getMethodSignature(context, opname, isStatic);
		MethodCacheAccesses++;
		final WeakReference<Method> methodRef = METHOD_CACHE.get(sig);
		final Method ret = methodRef != null ? methodRef.get() : null;
		if (ret != null || methodRef == NULL_METHOD_REFERENCE) {
			MethodCacheHits++;
			return ret;
		}

		return findNativeMethodInternal(context, opname, isStatic, sig);
	}

	/**
	 * Looks for a native Java method.
	 *
	 * @param context
	 *            The class of the method
	 * @param opname
	 *            The method name
	 * @param argTypes
	 *            The types of all arguments
	 * @param isStatic
	 *            Whether to look for a static method or not
	 * @param sig
	 *            the method signature
	 * @return the method if found, null otherwise
	 */
	private static Method findNativeMethodInternal(final Class<?> context, final String opname,
			final Class<?>[] argTypes, final boolean isStatic, final MethodSignature sig) {
		Method ret = null;

		final Method[] methods = context.getDeclaredMethods();
		METHODS: for (int i = 0; i < methods.length; i++) {
			final Method method = methods[i];
			if ((Modifier.isStatic(method.getModifiers()) == isStatic) && method.getName().equals(opname)) {
				final Class<?>[] pts = method.getParameterTypes();
				if (pts.length == argTypes.length) {
					boolean ok = true;
					for (int j = 0; (j < pts.length) && ok; j++) {
						if (!checkParameterType(argTypes[j], pts[j])) {
							ok = false;
							break;
						}
					}
					if (ok) {
						ret = method;
						break METHODS;
					}
				}
			}
		}

		if ((ret == null) && !isStatic && (context.getSuperclass() != null)) {
			ret = findNativeMethodInternal(context.getSuperclass(), opname, argTypes, isStatic, sig);
		} else {
			METHOD_CACHE.put(sig, ret != null ? new WeakReference<Method>(ret) : NULL_METHOD_REFERENCE);
		}

		return ret;
	}

	/**
	 * Looks for a native Java method.
	 *
	 * @param context
	 *            The class of the method
	 * @param opname
	 *            The method name
	 * @param argType
	 *            The type of the argument
	 * @param isStatic
	 *            Whether to look for a static method or not
	 * @param sig
	 *            the method signature
	 * @return the method if found, null otherwise
	 */
	private static Method findNativeMethodInternal(final Class<?> context, final String opname, final Class<?> argType,
			final boolean isStatic, final MethodSignature sig) {
		Method ret = null;

		final Method[] methods = context.getDeclaredMethods();
		METHODS: for (int i = 0; i < methods.length; i++) {
			final Method method = methods[i];
			if ((Modifier.isStatic(method.getModifiers()) == isStatic) && method.getName().equals(opname)) {
				final Class<?>[] pts = method.getParameterTypes();
				if (pts.length == 1) {
					if (checkParameterType(argType, pts[0])) {
						ret = method;
						break METHODS;
					}
				}
			}
		}

		if ((ret == null) && !isStatic && (context.getSuperclass() != null)) {
			ret = findNativeMethodInternal(context.getSuperclass(), opname, argType, isStatic, sig);
		} else {
			METHOD_CACHE.put(sig, ret != null ? new WeakReference<Method>(ret) : NULL_METHOD_REFERENCE);
		}

		return ret;
	}

	/**
	 * Looks for a native Java method without arguments.
	 *
	 * @param context
	 *            The class of the method
	 * @param opname
	 *            The method name
	 * @param isStatic
	 *            Whether to look for a static method or not
	 * @param sig
	 *            the method signature
	 * @return the method if found, null otherwise
	 */
	private static Method findNativeMethodInternal(final Class<?> context, final String opname, final boolean isStatic,
			final MethodSignature sig) {
		Method ret = null;

		final Method[] methods = context.getDeclaredMethods();
		METHODS: for (int i = 0; i < methods.length; i++) {
			final Method method = methods[i];
			if ((Modifier.isStatic(method.getModifiers()) == isStatic) && method.getName().equals(opname)) {
				if (method.getParameterTypes().length == 0) {
					ret = method;
					break METHODS;
				}
			}
		}

		if ((ret == null) && !isStatic && (context.getSuperclass() != null)) {
			ret = findNativeMethodInternal(context.getSuperclass(), opname, isStatic, sig);
		} else {
			METHOD_CACHE.put(sig, ret != null ? new WeakReference<Method>(ret) : NULL_METHOD_REFERENCE);
		}

		return ret;
	}

	/**
	 * Checks whether the parameter type is compatible with the argument type
	 *
	 * @param argType
	 *            the invocation argument type
	 * @param pt
	 *            the method parameter type
	 * @return <code>true</code> if the parameter type is compatible,
	 *         <code>false</code> otherwise
	 */
	private static boolean checkParameterType(final Class<?> argType, final Class<?> pt) {
		if (argType == EnumLiteral.class && Enumerator.class.isAssignableFrom(pt)) {
			return true;
		}
		if (pt.isAssignableFrom(argType)) {
			return true;
		}
		if (pt == boolean.class){
			return argType == Boolean.class;
		}
		if (pt == int.class) {
			return argType == Integer.class;
		}
		if (pt == char.class) {
			return argType == Character.class;
		}
		if (pt == long.class) {
			return argType == Long.class;
		}
		if (pt == float.class) {
			return argType == Float.class;
		}
		if (pt == double.class) {
			return argType == Double.class;
		}
		return argType == Void.TYPE; // any type
	}

	/**
	 * Compares 0-parameter <code>op</code> to <code>method</code>.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param method
	 *            the found method
	 * @return the method if more specific than <code>op</code>, <code>null</code> otherwise
	 */
	private static Method compareNativeMethod0(final Operation op, final Method method) {
		if (op != null && method != null) {
			final Class<?> opCtx = op.getEContext().getInstanceClass();
			final Class<?> methCtx = NativeTypes.boxedType(method.getDeclaringClass());
			if (opCtx == null || methCtx.isAssignableFrom(opCtx) || !opCtx.isAssignableFrom(methCtx)) {
				return null;
			}
		}
		return method;
	}

	/**
	 * Compares 1-parameter <code>op</code> to <code>method</code>.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param method
	 *            the found method
	 * @return the method if more specific than <code>op</code>, <code>null</code> otherwise
	 */
	private static Method compareNativeMethod1(final Operation op, final Method method) {
		if (op != null && method != null) {
			final Class<?> opCtx = op.getEContext().getInstanceClass();
			final Class<?> methCtx = NativeTypes.boxedType(method.getDeclaringClass());
			if (opCtx == null) {
				return null;
			}
			if (methCtx.isAssignableFrom(opCtx) || !opCtx.isAssignableFrom(methCtx)) {
				if (!methCtx.equals(opCtx)) {
					return null;
				}
				final Class<?> opArgType = op.getParameters().get(0).getEType().getInstanceClass();
				final Class<?> methArgType = NativeTypes.boxedType(method.getParameterTypes()[0]);
				if (opArgType == null || methArgType.isAssignableFrom(opArgType) || !opArgType.isAssignableFrom(methArgType)) {
					return null;
				}
			}
		}
		return method;
	}

	/**
	 * Compares N-parameter <code>op</code> to <code>method</code>.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param method
	 *            the found method
	 * @return the method if more specific than <code>op</code>, <code>null</code> otherwise
	 */
	private static Method compareNativeMethodN(final Operation op, final Method method) {
		if (op != null && method != null) {
			Class<?> opCtx = op.getEContext().getInstanceClass();
			Class<?> methCtx = NativeTypes.boxedType(method.getDeclaringClass());
			if (opCtx == null) {
				return null;
			}
			final Class<?>[] parameterTypes = method.getParameterTypes();
			final EList<Parameter> parameters = op.getParameters();
			final int len = parameterTypes.length;
			int i = -1;
			while (methCtx.isAssignableFrom(opCtx) || !opCtx.isAssignableFrom(methCtx)) {
				i++;
				if (!methCtx.equals(opCtx) || i == len) {
					return null;
				}
				opCtx = parameters.get(i).getEType().getInstanceClass();
				if (opCtx == null) {
					return null;
				}
				methCtx = NativeTypes.boxedType(parameterTypes[i]);
			}
		}
		return method;
	}

	/**
	 * Looks for a native Java method without arguments.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param self
	 *            the object on which to invoke the method
	 * @param opname
	 *            the method name
	 * @return the method if found and more specific than <code>op</code>, <code>null</code> otherwise
	 */
	public static Method findNativeMethod(final Operation op, final Object self, final String opname) {
		return compareNativeMethod0(op, findNativeMethod(self == null ? Void.TYPE : self.getClass(), opname, false));
	}

	/**
	 * Looks for a native Java method with one argument.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param self
	 *            the object on which to invoke the method
	 * @param opname
	 *            the method name
	 * @param arg
	 *            the method argument
	 * @return the method if found and more specific than <code>op</code>, <code>null</code> otherwise
	 */
	public static Method findNativeMethod(final Operation op, final Object self, final String opname, final Object arg) {
		return compareNativeMethod1(op,
				findNativeMethod(self == null ? Void.TYPE : self.getClass(), opname, arg == null ? Void.TYPE : arg.getClass(), false));
	}

	/**
	 * Looks for a native Java method with multiple arguments.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param self
	 *            the object on which to invoke the method
	 * @param opname
	 *            the method name
	 * @param args
	 *            the method arguments
	 * @return the method if found and more specific than <code>op</code>, <code>null</code> otherwise
	 */
	public static Method findNativeMethod(final Operation op, final Object self, final String opname, final Object[] args) {
		return compareNativeMethodN(op,
				findNativeMethod(self == null ? Void.TYPE : self.getClass(), opname, getArgumentClasses(args), false));
	}

	/**
	 * Returns the superclass as well as super-interfaces for <code>type</code>.
	 *
	 * @param type
	 *            the type for which to return supertypes
	 * @return the superclass as well as super-interfaces for <code>type</code>
	 */
	private static Class<?>[] getSuperTypes(final Class<?> type) {
		if (type == null || type == Void.TYPE) {
			return new Class<?>[] { Void.TYPE };
		}
		final Class<?>[] interfaces = type.getInterfaces();
		final Class<?> superClass = type.getSuperclass();
		final Class<?>[] superTypes;
		if (superClass != null) {
			superTypes = new Class<?>[interfaces.length + 1];
			superTypes[0] = superClass;
			System.arraycopy(interfaces, 0, superTypes, 1, interfaces.length);
		} else {
			superTypes = new Class<?>[interfaces.length];
			System.arraycopy(interfaces, 0, superTypes, 0, interfaces.length);
		}
		return superTypes;
	}

	/**
	 * Compares 0-parameter <code>method1</code> to <code>method2</code>.
	 *
	 * @param method1
	 *            the previously found method
	 * @param method2
	 *            the next found method
	 * @return <code>method2</code> if more specific than <code>method1</code>, <code>method1</code> otherwise
	 */
	private static Method compareNativeMethod0(final Method method1, final Method method2) {
		if (method2 == null) {
			return method1;
		}
		if (method1 != null) {
			final Class<?> meth1Ctx = NativeTypes.boxedType(method1.getDeclaringClass());
			final Class<?> meth2Ctx = NativeTypes.boxedType(method2.getDeclaringClass());
			if (meth2Ctx.isAssignableFrom(meth1Ctx) || !meth1Ctx.isAssignableFrom(meth2Ctx)) {
				return method1;
			}
		}
		return method2;
	}

	/**
	 * Compares 1-parameter <code>method1</code> to <code>method2</code>.
	 *
	 * @param method1
	 *            the previously found method
	 * @param method2
	 *            the next found method
	 * @return <code>method2</code> if more specific than <code>method1</code>, <code>method1</code> otherwise
	 */
	private static Method compareNativeMethod1(final Method method1, final Method method2) {
		if (method2 == null) {
			return method1;
		}
		if (method1 != null) {
			final Class<?> meth1Ctx = NativeTypes.boxedType(method1.getDeclaringClass());
			final Class<?> meth2Ctx = NativeTypes.boxedType(method2.getDeclaringClass());
			if (meth2Ctx.isAssignableFrom(meth1Ctx) || !meth1Ctx.isAssignableFrom(meth2Ctx)) {
				if (!meth2Ctx.equals(meth1Ctx)) {
					return method1;
				}
				final Class<?> meth1ArgType = NativeTypes.boxedType(method1.getParameterTypes()[0]);
				final Class<?> meth2ArgType = NativeTypes.boxedType(method2.getParameterTypes()[0]);
				if (meth2ArgType.isAssignableFrom(meth1ArgType) || !meth1ArgType.isAssignableFrom(meth2ArgType)) {
					return method1;
				}
			}
		}
		return method2;
	}

	/**
	 * Compares N-parameter <code>op</code> to <code>method</code>.
	 *
	 * @param method1
	 *            the previously found EMFTVM {@link Operation}
	 * @param method2
	 *            the found method
	 * @return the method if more specific than <code>op</code>, <code>null</code> otherwise
	 */
	private static Method compareNativeMethodN(final Method method1, final Method method2) {
		if (method2 == null) {
			return method1;
		}
		if (method1 != null) {
			Class<?> meth1Ctx = NativeTypes.boxedType(method1.getDeclaringClass());
			Class<?> meth2Ctx = NativeTypes.boxedType(method2.getDeclaringClass());
			final Class<?>[] parameterTypes1 = method1.getParameterTypes();
			final Class<?>[] parameterTypes2 = method2.getParameterTypes();
			final int len = parameterTypes1.length;
			int i = -1;
			while (meth2Ctx.isAssignableFrom(meth1Ctx) || !meth1Ctx.isAssignableFrom(meth2Ctx)) {
				i++;
				if (!meth2Ctx.equals(meth1Ctx) || i == len) {
					return method1;
				}
				meth1Ctx = NativeTypes.boxedType(parameterTypes1[i]);
				meth2Ctx = NativeTypes.boxedType(parameterTypes2[i]);
			}
		}
		return method2;
	}

	/**
	 * Looks for a native superclass Java method without arguments.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param context
	 *            the context for which to find the superclass method
	 * @param opname
	 *            the method name
	 * @return the method if found and more specific than <code>op</code>, <code>null</code> otherwise
	 */
	public static Method findNativeSuperMethod(final Operation op, final Class<?> context, final String opname) {
		Method method = null;
		for (final Class<?> superCtx : getSuperTypes(context)) {
			method = compareNativeMethod0(method, findNativeMethod(superCtx, opname, false));
		}
		return compareNativeMethod0(op, method);
	}

	/**
	 * Looks for a native superclass Java method with one argument.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param context
	 *            the context for which to find the superclass method
	 * @param name
	 *            the method name
	 * @param arg
	 *            the method argument
	 * @return the method if found and more specific than <code>op</code>, <code>null</code> otherwise
	 */
	public static Method findNativeSuperMethod(final Operation op, final Class<?> context, final String opname, final Object arg) {
		final Class<?> argType = arg == null ? Void.TYPE : arg.getClass();
		Method method = null;
		for (final Class<?> superCtx : getSuperTypes(context)) {
			method = compareNativeMethod1(method, findNativeMethod(superCtx, opname, argType, false));
		}
		return compareNativeMethod1(op, method);
	}

	/**
	 * Looks for a native superclass Java method with multiple arguments.
	 *
	 * @param op
	 *            the previously found EMFTVM {@link Operation}
	 * @param context
	 *            the context for which to find the superclass method
	 * @param name
	 *            the method name
	 * @param args
	 *            the method arguments
	 * @return the method if found and more specific than <code>op</code>, <code>null</code> otherwise
	 */
	public static Method findNativeSuperMethod(final Operation op, final Class<?> context, final String opname, final Object[] args) {
		final Class<?>[] argTypes = getArgumentClasses(args);
		Method method = null;
		for (final Class<?> superCtx : getSuperTypes(context)) {
			method = compareNativeMethodN(method, findNativeMethod(superCtx, opname, argTypes, false));
		}
		return compareNativeMethodN(op, method);
	}

	/**
	 * Looks for a native Java constructor.
	 *
	 * @param context
	 *            The class of the method
	 * @param argumentTypes
	 *            The types of all arguments
	 * @return the constructor if found, <code>null</code> otherwise
	 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
	 */
	public static Constructor<?> findConstructor(final Class<?> context, final Class<?>[] argTypes) {
		if (context == Void.TYPE) {
			return null; // Java methods cannot be invoked on null, or defined on Void
		}

		Constructor<?> ret = null;

		final Constructor<?>[] constructors = context.getConstructors();
		CONSTRUCTOR: for (int i = 0; i < constructors.length; i++) {
			final Constructor<?> constructor = constructors[i];
			final Class<?>[] pts = constructor.getParameterTypes();
			if (pts.length == argTypes.length) {
				boolean ok = true;
				for (int j = 0; (j < pts.length) && ok; j++) {
					if (argTypes[j] == EnumLiteral.class && Enumerator.class.isAssignableFrom(pts[j])) {
						continue;
					}
					if (!pts[j].isAssignableFrom(argTypes[j])) {
						if (pts[j] == boolean.class)
							ok = argTypes[j] == Boolean.class;
						else if (pts[j] == int.class)
							ok = argTypes[j] == Integer.class;
						else if (pts[j] == char.class)
							ok = argTypes[j] == Character.class;
						else if (pts[j] == long.class)
							ok = argTypes[j] == Long.class;
						else if (pts[j] == float.class)
							ok = argTypes[j] == Float.class;
						else if (pts[j] == double.class)
							ok = argTypes[j] == Double.class;
						else
							ok = argTypes[j] == Void.TYPE; // any type
					}
				}
				if (ok) {
					ret = constructor;
					break CONSTRUCTOR;
				}
			}
		}

		return ret;
	}

	/**
	 * Generates a signature to store methods.
	 *
	 * @param context
	 *            the method declaring class
	 * @param name
	 *            the method name
	 * @param argumentTypes
	 *            the argument types
	 * @param isStatic
	 *            whether the method is static
	 * @return The method signature
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic
	 *         Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static MethodSignature getMethodSignature(final Class<?> context, final String name,
			final Class<?>[] argumentTypes, final boolean isStatic) {
		return new MethodSignature(context, name, argumentTypes, isStatic);
	}

	/**
	 * Generates a signature to store methods.
	 *
	 * @param context
	 *            the method declaring class
	 * @param name
	 *            the method name
	 * @param argumentType
	 *            the (single) argument type
	 * @param isStatic
	 *            whether the method is static
	 * @param isStatic
	 * @return The method signature
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic
	 *         Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static MethodSignature getMethodSignature(final Class<?> context, final String name,
			final Class<?> argumentType, final boolean isStatic) {
		return new MethodSignature(context, name, new Class<?>[] { argumentType }, isStatic);
	}

	/**
	 * Generates a signature to store methods.
	 *
	 * @param context
	 *            the method declaring class
	 * @param name
	 *            the method name
	 * @param isStatic
	 *            whether the method is static
	 * @return The method signature
	 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic
	 *         Jouault</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	private static MethodSignature getMethodSignature(final Class<?> context, final String name,
			final boolean isStatic) {
		return new MethodSignature(context, name, null, isStatic);
	}

	/**
	 * Retrieves the classes of <code>args</code>.
	 *
	 * @param args
	 * @return the classes of <code>args</code>
	 */
	public static Class<?>[] getArgumentClasses(final Object[] args) {
		final int argcount = args.length;
		final Class<?>[] argTypes = new Class<?>[argcount];
		for (int i = 0; i < argcount; i++) {
			argTypes[i] = args[i] == null ? Void.TYPE : args[i].getClass();
		}
		return argTypes;
	}

	/**
	 * Writes <code>string</code> to <code>path</code> with the given <code>charset</code>.
	 *
	 * @param string
	 *            the string to write
	 * @param path
	 *            the path of the file to write to
	 * @param charset
	 *            the character set to use, or use default when null
	 * @return true on success
	 * @throws IOException
	 *             when writing fails
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 */
	public static boolean writeToWithCharset(final String string, final String path, final String charset) throws IOException {
		final File file = getFile(path);
		if (file.getParentFile() != null) {
			file.getParentFile().mkdirs();
		}
		final PrintStream out;
		if (charset == null) {
			out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true);
		} else {
			out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, charset);
		}
		out.print(string);
		out.close();
		return true;
	}

	/**
	 * Returns the file with the given <code>path</code> in the workspace, or the file in the filesystem if the workspace is not available.
	 *
	 * @param path
	 *            the absolute or relative path to a file.
	 * @return the file in the workspace, or the file in the filesystem if the workspace is not available.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
	 */
	public static File getFile(final String path) {
		try {
			final WorkspaceUtil wsUtil = (WorkspaceUtil) Class.forName(WORKSPACE_UTIL_IMPL).getDeclaredConstructor()
					.newInstance();
			final String wsPath = wsUtil.getWorkspaceLocation(path);
			if (wsPath != null) {
				return new File(wsPath);
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			ATLLogger.log(Level.FINE, e.getMessage(), e);
		} finally {

		}
		ATLLogger.info("Could not find workspace root; falling back to native java.io.File path resolution");
		return new File(path);
	}

	/**
	 * Creates a new {@link Operation}.
	 *
	 * @param isStatic
	 *            whether the created operation is static
	 * @param name
	 *            operation name
	 * @param context
	 *            operation context [type model, type name]
	 * @param returnType
	 *            operation return [type model, type name]
	 * @param parameters
	 *            operations parameters: [[[name], [type model, type name]], ...]
	 * @param body
	 *            operation body
	 * @return a new {@link Operation}.
	 * @see Types
	 */
	public static Operation createOperation(final boolean isStatic, final String name, final String[] context, final String[] returnType,
			final String[][][] parameters, final CodeBlock body) {
		final EmftvmFactory factory = EmftvmFactory.eINSTANCE;
		final Operation op = factory.createOperation();
		op.setStatic(isStatic);
		op.setName(name);
		op.setContextModel(context[0]);
		op.setContext(context[1]);
		op.setTypeModel(returnType[0]);
		op.setType(returnType[1]);
		final EList<Parameter> pars = op.getParameters();
		final EList<LocalVariable> locals = body.getLocalVariables();
		if (!isStatic) {
			final LocalVariable self = factory.createLocalVariable();
			self.setName("self");
			self.setTypeModel(context[0]);
			self.setType(context[1]);
			locals.add(self);
		}
		for (final String[][] par : parameters) {
			final Parameter p = factory.createParameter();
			p.setName(par[0][0]);
			p.setTypeModel(par[1][0]);
			p.setType(par[1][1]);
			pars.add(p);
			final LocalVariable lv = factory.createLocalVariable();
			lv.setName(par[0][0]);
			lv.setTypeModel(par[1][0]);
			lv.setType(par[1][1]);
			locals.add(lv);
		}
		op.setBody(body);
		return op;
	}

	/**
	 * Creates a new {@link Field}.
	 *
	 * @param name
	 *            field name
	 * @param isStatic
	 *            whether the field is static
	 * @param context
	 *            field context [type model, type name]
	 * @param type
	 *            field [type model, type name]
	 * @param initialiser
	 *            field initialiser codeblock
	 * @return a new {@link Field}.
	 * @see Types
	 */
	public static Field createField(final String name, final boolean isStatic, final String[] context, final String[] type,
			final CodeBlock initialiser) {
		final Field f = EmftvmFactory.eINSTANCE.createField();
		f.setName(name);
		f.setContextModel(context[0]);
		f.setContext(context[1]);
		f.setTypeModel(type[0]);
		f.setType(type[1]);
		f.setInitialiser(initialiser);
		f.setStatic(isStatic);
		return f;
	}

	/**
	 * Retrieves the transitive closure of <code>field</code> on <code>object</code>.
	 *
	 * @param object
	 *            the object on which to retrieve <code>field</code>
	 * @param field
	 *            the field for which to retrieve the value
	 * @param frame
	 *            the current {@link StackFrame}
	 * @param result
	 *            the intermediate list of values
	 * @return the updated result
	 */
	@SuppressWarnings("unchecked")
	public static LazyList<Object> getTrans(final Object object, final Field field, final StackFrame frame, final LazyList<Object> result) {
		LazyList<Object> newResult = result;
		final Object value = field.getValue(object, frame);
		if (value instanceof List<?>) {
			final List<Object> cvalue = (List<Object>) value;
			newResult = newResult.union(new LazyListOnList<Object>(cvalue));
			for (final Object v : cvalue) {
				newResult = getTrans(v, field, frame, newResult);
			}
		} else if (value instanceof Collection<?>) {
			final Collection<Object> cvalue = (Collection<Object>) value;
			newResult = newResult.union(new LazyListOnCollection<Object>(cvalue));
			for (final Object v : cvalue) {
				newResult = getTrans(v, field, frame, newResult);
			}
		} else if (value != null) {
			newResult = newResult.append(value);
			newResult = getTrans(value, field, frame, newResult);
		}
		return newResult;
	}

	/**
	 * Retrieves the transitive closure of <code>sf</code> on <code>object</code>.
	 *
	 * @param object
	 *            the object on which to retrieve <code>sf</code>
	 * @param sf
	 *            the structural feature for which to retrieve the value
	 * @param env
	 *            the current {@link ExecEnv}
	 * @param result
	 *            the intermediate list of values
	 * @return the updated result
	 */
	@SuppressWarnings("unchecked")
	public static LazyList<Object> getTrans(final EObject object, final EStructuralFeature sf, final ExecEnv env,
			final LazyList<Object> result) {
		if (!sf.getEContainingClass().isSuperTypeOf(object.eClass())) {
			return result; // feature does not apply to object
		}
		LazyList<Object> newResult = result;
		final Object value = get(env, object, sf);
		if (value instanceof LazyList<?>) {
			final LazyList<Object> cvalue = (LazyList<Object>) value;
			newResult = newResult.union(cvalue);
			for (final Object v : cvalue) {
				if (v instanceof EObject) {
					newResult = getTrans((EObject) v, sf, env, newResult);
				}
			}
		} else if (value != null) {
			assert !(value instanceof Collection<?>); // All collections should be LazyLists
			if (value instanceof Enumerator) {
				newResult = newResult.append(new EnumLiteral(value.toString()));
			} else {
				newResult = newResult.append(value);
				if (value instanceof EObject) {
					newResult = getTrans((EObject) value, sf, env, newResult);
				}
			}
		}
		return newResult;
	}

	/**
	 * Retrieves the transitive closure of <code>field</code> on <code>object</code>.
	 *
	 * @param object
	 *            the object on which to retrieve <code>field</code>
	 * @param field
	 *            the field for which to retrieve the value
	 * @param result
	 *            the intermediate list of values
	 * @return the updated result
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public static LazyList<Object> getTrans(final Object object, final java.lang.reflect.Field field, final LazyList<Object> result)
			throws IllegalArgumentException, IllegalAccessException {
		if (!field.getDeclaringClass().isAssignableFrom(object.getClass())) {
			return result; // field does not apply to object
		}
		LazyList<Object> newResult = result;
		final Object value = field.get(object);
		if (value instanceof LazyList<?>) {
			final LazyList<Object> cvalue = (LazyList<Object>) value;
			newResult = newResult.union(cvalue);
			for (final Object v : cvalue) {
				newResult = getTrans(v, field, newResult);
			}
		} else if (value instanceof List<?>) {
			final List<Object> cvalue = (List<Object>) value;
			newResult = newResult.union(new LazyListOnList<Object>(cvalue));
			for (final Object v : cvalue) {
				newResult = getTrans(v, field, newResult);
			}
		} else if (value instanceof Collection<?>) {
			final Collection<Object> cvalue = (Collection<Object>) value;
			newResult = newResult.union(new LazyListOnCollection<Object>(cvalue));
			for (final Object v : cvalue) {
				newResult = getTrans(v, field, newResult);
			}
		} else if (value != null) {
			newResult = newResult.append(value);
			newResult = getTrans(value, field, newResult);
		}
		return newResult;
	}

	/**
	 * Tries to convert literal to an instance of type.
	 *
	 * @param literal
	 *            the enum literal to convert
	 * @param type
	 *            the type to instantiate
	 * @return an instance of type, or literal if conversion failed
	 */
	static Object convertEnumLiteral(final EnumLiteral literal, final Class<?> type) {
		if (Enumerator.class.isAssignableFrom(type)) {
			try {
				final String litName = literal.getName();
				final java.lang.reflect.Field valuesField = type.getDeclaredField("VALUES");
				final Object values = valuesField.get(null);
				if (values instanceof Collection<?>) {
					for (final Object value : (Collection<?>) values) {
						if (value instanceof Enumerator) {
							if (litName.equals(((Enumerator) value).getName()) || litName.equals(value.toString())) {
								return value;
							}
						}
					}
				}
				// Ignore exceptions; just don't convert here
			} catch (final SecurityException e) {
				// do nothing
			} catch (final NoSuchFieldException e) {
				// do nothing
			} catch (final IllegalArgumentException e) {
				// do nothing
			} catch (final IllegalAccessException e) {
				// do nothing
			}
		}
		return literal;
	}

	/**
	 * Returns the {@link Locale} for the given <code>locale</code> string.
	 *
	 * @param locale
	 *            the locale string (e.g. "nl_BE", "es_ES_Traditional_WIN")
	 * @return the {@link Locale} for the given <code>locale</code> string
	 */
	public static Locale getLocale(final String locale) {
		final StringTokenizer st = new StringTokenizer(locale, "_");
		final String language = st.nextToken();
		if (st.hasMoreTokens()) {
			final String country = st.nextToken();
			if (st.hasMoreTokens()) {
				final String variant = st.nextToken("\n");
				return new Locale(language, country, variant);
			}
			return new Locale(language, country);
		}
		return new Locale(language);
	}

	/**
	 * Registers all {@link EPackage} nsURIs in <code>rs</code> in the local <code>rs</code> {@link EPackage.Registry}. Sets the
	 * {@link EPackage} nsURI to the {@link EPackage} name if not set.
	 *
	 * @param rs
	 *            the {@link ResourceSet}
	 */
	public static void registerEPackages(final ResourceSet rs) {
		final EPackage.Registry registry = rs.getPackageRegistry();
		for (final Iterator<Object> i = EcoreUtil.getAllContents(rs, true); i.hasNext();) {
			final Object object = i.next();
			if (object instanceof EPackage) {
				final EPackage p = (EPackage) object;
				// force existence of nsURI
				String nsURI = p.getNsURI();
				if (nsURI == null) {
					nsURI = p.getName();
					p.setNsURI(nsURI);
				}
				// overwrite with current value to prevent aliasing problems
				registry.put(nsURI, p);
			} else if (object instanceof EDataType) {
				adaptDataType((EDataType) object);
			}
		}
	}

	/**
	 * Adapts the given {@link EDataType} if necessary.
	 * @param dt the {@link EDataType} to adapt
	 */
	private static void adaptDataType(final EDataType dt) {
		String icn = dt.getInstanceClassName();
		if (icn == null) {
			final String tname = dt.getName();
			if (tname.equals("Boolean")) { //$NON-NLS-1$
				icn = "boolean"; //$NON-NLS-1$
			} else if (tname.equals("Double") || tname.equals("Real")) { //$NON-NLS-1$ //$NON-NLS-2$
				icn = "java.lang.Double"; //$NON-NLS-1$
			} else if (tname.equals("Float")) { //$NON-NLS-1$
				icn = "java.lang.Float"; //$NON-NLS-1$
			} else if (tname.equals("Integer")) { //$NON-NLS-1$
				icn = "java.lang.Integer"; //$NON-NLS-1$
			} else if (tname.equals("String")) { //$NON-NLS-1$
				icn = "java.lang.String"; //$NON-NLS-1$
			}
			if (icn != null) {
				dt.setInstanceClassName(icn);
			}
		}
	}

	/**
	 * Finds the root {@link Class} declaration for the given <code>method</code>.
	 * @param method the method for which to find the root declaration
	 * @return the root {@link Method}
	 */
	public static Method findRootMethod(final Method method) {
		if (method == null) {
			return null;
		}
		RootMethodCacheAccesses++;
		final WeakReference<Method> rootMethodReference = ROOT_METHOD_CACHE.get(method);
		Method rootMethod = rootMethodReference != null ? rootMethodReference.get() : null;
		if (rootMethod != null) {
			RootMethodCacheHits++;
			return rootMethod;
		}
		rootMethod = findRootMethodInner(method);
		ROOT_METHOD_CACHE.put(method, new WeakReference<Method>(rootMethod));
		return rootMethod;
	}

	/**
	 * Finds the root {@link Class} declaration for the given <code>method</code>.
	 * @param method the method for which to find the root declaration
	 * @return the root {@link Method}
	 */
	private static Method findRootMethodInner(Method method) {
		final int methodModifiers = getRelevantModifiers(method);
		Class<?> dc = method.getDeclaringClass();
		java.util.Set<Class<?>> dis = new LinkedHashSet<Class<?>>(
				Arrays.<Class<?>> asList(dc.getInterfaces()));
		while ((dc = dc.getSuperclass()) != null) {
			try {
				final Method superMethod = dc.getDeclaredMethod(method.getName(), method.getParameterTypes());
				if (getRelevantModifiers(superMethod) == methodModifiers) {
					method = superMethod;
				} else {
					break;
				}
			} catch (final SecurityException e) {
			} catch (final NoSuchMethodException e) {
			}
			dis.addAll(Arrays.<Class<?>> asList(dc.getInterfaces()));
		}
		while (!dis.isEmpty()) {
			final java.util.Set<Class<?>> newDis = new LinkedHashSet<Class<?>>();
			for (final Class<?> di : dis) {
				try {
					// Only replace by method declared in a super-interface
					if (di.isAssignableFrom(method.getDeclaringClass())) {
						method = di.getDeclaredMethod(method.getName(), method.getParameterTypes());
					}
				} catch (final SecurityException e) {
				} catch (final NoSuchMethodException e) {
				}
				newDis.addAll(Arrays.<Class<?>> asList(di.getInterfaces()));
			}
			newDis.removeAll(dis);
			dis = newDis;
		}
		return method;
	}

	/**
	 * Returns the relevant modifiers (visibility and static) for the given method.
	 * @param method the method for which to return the modifiers
	 * @return the relevant modifiers (visibility and static) for the given method
	 */
	private static int getRelevantModifiers(final Method method) {
		final int methodModifiers = method.getModifiers();
		return methodModifiers & (Modifier.PRIVATE + Modifier.PROTECTED + Modifier.PUBLIC + Modifier.STATIC);
	}

	/**
	 * Returns the hit rate of the method cache.
	 *
	 * @return the hit rate of the method cache, or <code>-1.0</code> if no hits
	 *         were recorded yet
	 */
	public static double getMethodCacheHitRate() {
		return MethodCacheAccesses > 0 ? (double) MethodCacheHits / (double) MethodCacheAccesses : -1.0;
	}

	/**
	 * Returns the hit rate of the root method cache.
	 *
	 * @return the hit rate of the root method cache, or <code>-1.0</code> if no
	 *         hits were recorded yet
	 */
	public static double getRootMethodCacheHitRate() {
		return RootMethodCacheAccesses > 0 ? (double) RootMethodCacheHits / (double) RootMethodCacheAccesses : -1.0;
	}

}
