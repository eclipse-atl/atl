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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.SourceElementList;
import org.eclipse.m2m.atl.emftvm.trace.TargetElement;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;


/**
 * Provides native operations on simple OCL types.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class OCLOperations {

	/**
	 * {@link LazyList} that resolves default trace links.
	 */
	public static class ResolveList extends LazyList<Object> {

		/**
		 * {@link Iterator} that resolves default trace links.
		 */
		public class ResolveIterator extends CachingIterator {

			/**
			 * Creates a new {@link ResolveIterator}.
			 */
			public ResolveIterator() {
				super(dataSource.iterator());
			}
	
			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object next() {
				Object next = inner.next();
				if (next instanceof EObject) {
					final SourceElement se = tls.getDefaultSourceElement((EObject)next);
					if (se != null) {
						final EList<TargetElement> seMapsTo = se.getMapsTo();
						if (!seMapsTo.isEmpty()) {
							assert seMapsTo.get(0).getObject().eResource() != null;
							next = seMapsTo.get(0).getObject();
						} else {
							for (TargetElement te : se.getSourceOf().getTargetElements()) {
								if (te.getMapsTo() == null) { // default mapping
									assert te.getObject().eResource() != null;
									next = te.getObject();
									break;
								}
							}
						}
					}
				}
				if (++i > cache.size()) {
					assert dataSource != null; // cache not complete
					cache.add(next);
				} else {
					assert cache.contains(next);
				}
				return next;
			}
		}

		protected final StackFrame frame;
		protected final ExecEnv env;
		protected final Field traces;
		protected final TraceLinkSet tls;

		/**
		 * Creates a new {@link ResolveList} around <code>dataSource</code>.
		 * @param dataSource he underlying collection
		 * @param frame the current {@link StackFrame}
		 */
		public ResolveList(final Collection<Object> dataSource, final StackFrame frame) {
			super(dataSource);
			this.frame = frame;
			this.env = frame.getEnv();
			this.traces = env.findStaticField(env.eClass(), "traces");
			this.tls = (TraceLinkSet)traces.getStaticValue(frame);
		}
	
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<Object> iterator() {
			if (dataSource == null) {
				return cache.iterator();
			}
			return new ResolveIterator(); // extends CachingIterator
		}
	
		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			if (dataSource == null) {
				return cache.size();
			}
			return ((Collection<Object>)dataSource).size();
		}
		
	}

	/**
	 * The OCL metamodel namespace.
	 */
	public static final String OCL_MODEL = EMFTVMUtil.NATIVE;
	/**
	 * The Ecore metamodel namespace.
	 */
	public static final String ECORE_MODEL = EcorePackage.eNAME.toUpperCase();
	/**
	 * The EMFTVM metamodel namespace.
	 */
	public static final String EMFTVM_MODEL = EmftvmPackage.eNAME.toUpperCase();

	static final String[] OCL_ANY_TYPE			= new String[]{OCL_MODEL, "java.lang.Object"};
	static final String[] BOOLEAN_TYPE			= new String[]{OCL_MODEL, "java.lang.Boolean"};
	static final String[] REAL_TYPE				= new String[]{OCL_MODEL, "java.lang.Double"};
	static final String[] INTEGER_TYPE			= new String[]{OCL_MODEL, "java.lang.Integer"};
	static final String[] STRING_TYPE			= new String[]{OCL_MODEL, "java.lang.String"};
	static final String[] JAVA_CLASS_TYPE		= new String[]{OCL_MODEL, "java.lang.Class"};
	static final String[] JAVA_COLLECTION_TYPE	= new String[]{OCL_MODEL, "java.util.Collection"};
	static final String[] JAVA_LIST_TYPE		= new String[]{OCL_MODEL, "java.util.List"};
	static final String[] COLLECTION_TYPE 		= new String[]{OCL_MODEL, "org.eclipse.m2m.atl.emftvm.util.LazyCollection"};
	static final String[] BAG_TYPE 				= new String[]{OCL_MODEL, "org.eclipse.m2m.atl.emftvm.util.LazyBag"};
	static final String[] SEQUENCE_TYPE 		= new String[]{OCL_MODEL, "org.eclipse.m2m.atl.emftvm.util.LazyList"};
	static final String[] SET_TYPE 				= new String[]{OCL_MODEL, "org.eclipse.m2m.atl.emftvm.util.LazySet"};
	static final String[] ORDERED_SET_TYPE 		= new String[]{OCL_MODEL, "org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet"};
	static final String[] MAP_TYPE				= new String[]{OCL_MODEL, "java.util.Map"};

	static final String[] CLASSIFIER_TYPE 		= new String[]{ECORE_MODEL, "EClassifier"};
	static final String[] CLASS_TYPE 			= new String[]{ECORE_MODEL, "EClass"};

	static final String[] EXEC_ENV_TYPE 		= new String[]{EMFTVM_MODEL, "ExecEnv"};

	private static OCLOperations instance;

	private final EmftvmFactory factory = EmftvmFactory.eINSTANCE;
	private final Module oclModule;

	/**
	 * Do not use.
	 */
	private OCLOperations() {
		super();
		oclModule = factory.createModule();
		oclModule.setName("OCL");
		createOperations();
	}

	/**
	 * Returns the singleton instance of {@link OCLOperations}.
	 * @return the singleton instance of {@link OCLOperations}.
	 */
	public static OCLOperations getInstance() {
		if (instance == null) {
			instance = new OCLOperations();
		}
		return instance;
	}

	/**
	 * Adds native operations to the oclModule.
	 */
	private void createOperations() {
		/////////////////////////////////////////////////////////////////////
		// OclAny
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "debug", OCL_ANY_TYPE, OCL_ANY_TYPE,
				new String[][][]{{{"message"}, STRING_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final StringBuffer buf = new StringBuffer((String)frame.getLocal(0, 1));
						buf.append(": ");
						if (object instanceof String) {
							buf.append('\'');
							buf.append((String)object);
							buf.append('\'');
						} else {
							buf.append(object);
						}
						ATLLogger.info(buf.toString());
						return object;
					}
		});
		createOperation(false, "oclAsType", OCL_ANY_TYPE, OCL_ANY_TYPE,
				new String[][][]{{{"type"}, CLASSIFIER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final EClassifier type = (EClassifier)frame.getLocal(0, 1);
						if (!type.isInstance(object)) {
							throw new IllegalArgumentException(String.format(
									"%s is not an instance of %s",
									object, type));
						}
						return object;
					}
		});
		createOperation(false, "oclAsType", OCL_ANY_TYPE, OCL_ANY_TYPE,
				new String[][][]{{{"type"}, JAVA_CLASS_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final Class<?> type = (Class<?>)frame.getLocal(0, 1);
						if (!type.isInstance(object)) {
							throw new IllegalArgumentException(String.format(
									"%s is not an instance of %s",
									object, type));
						}
						return object;
					}
		});
		createOperation(false, "oclIsTypeOf", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"type"}, CLASSIFIER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final EClassifier type = (EClassifier)frame.getLocal(0, 1);
						if (type instanceof EClass && o instanceof EObject) {
							return ((EObject)o).eClass() == type;
						} else if (o != null) {
							final Class<?> ic = ((EClassifier)type).getInstanceClass();
							if (ic == null) {
								throw new IllegalArgumentException(String.format("EClassifier %s must have an instance class", type));
							}
							return o.getClass() == ic;
						}
						return false;
					}
		});
		createOperation(false, "oclIsTypeOf", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"type"}, JAVA_CLASS_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Class<?> type = (Class<?>)frame.getLocal(0, 1);
						return o != null ? o.getClass() == type : false;
					}
		});
		createOperation(false, "oclIsKindOf", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"type"}, CLASSIFIER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final EClassifier type = (EClassifier)frame.getLocal(0, 1);
						return type.isInstance(o);
					}
		});
		createOperation(false, "oclIsKindOf", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"type"}, JAVA_CLASS_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Class<?> type = (Class<?>)frame.getLocal(0, 1);
						return type.isInstance(o);
					}
		});
		createOperation(false, "oclType", OCL_ANY_TYPE, OCL_ANY_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						if (o instanceof EObject) {
							return ((EObject)o).eClass();
						} else if (o != null) {
							return o.getClass();
						}
						return Void.TYPE;
					}
		});
		createOperation(false, "=", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"o"}, OCL_ANY_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return o == null ? o2 == null : o.equals(o2);
					}
		});
		createOperation(false, "=~", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"o"}, OCL_ANY_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return o == null ? o2 == null : o.equals(o2);
					}
		});
		createOperation(false, "=~|", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"o"}, OCL_ANY_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return o == null ? o2 == null : o.equals(o2);
					}
		});
		createOperation(false, "<>", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"o"}, OCL_ANY_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return !(o == null ? o2 == null : o.equals(o2));
					}
		});
		createOperation(false, "isInModel", OCL_ANY_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"model"}, STRING_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						if (o instanceof EObject) {
							final String mName = (String)frame.getLocal(0, 1);
							final ExecEnv env = frame.getEnv();
							Model model = env.getInputModels().get(mName);
							if (model == null) {
								model = env.getInoutModels().get(mName);
							}
							if (model == null) {
								model = env.getOutputModels().get(mName);
							}
							if (model != null) {
								return model.getResource() == ((EObject)o).eResource();
							}
						}
						return false;
					}
		});
		createOperation(false, "refImmediateComposite", OCL_ANY_TYPE, OCL_ANY_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							return ((EObject)object).eContainer();
						}
						throw new VMException(frame, String.format(
								"Cannot retrieve immediate composite for regular objects: %s",
								object));
					}
		});
		createOperation(false, "refGet", OCL_ANY_TYPE, OCL_ANY_TYPE,
				new String[][][]{{{"propname"}, STRING_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							final String propname = (String)frame.getLocal(0, 1);
							final EObject eo = (EObject)object;
							final EClass ecls = eo.eClass();
							final EStructuralFeature sf = ecls.getEStructuralFeature(propname);
							if (sf == null) {
								throw new VMException(frame, String.format(
										"Cannot find property %s::%s", ecls.getName(), propname));
							}
							return ((EObject)object).eGet(sf);
						}
						throw new VMException(frame, String.format(
								"Cannot retrieve properties for regular objects: %s",
								object));
					}
		});
		createOperation(false, "refSet", OCL_ANY_TYPE, OCL_ANY_TYPE,
				new String[][][]{{{"propname"}, STRING_TYPE}, {{"value"}, OCL_ANY_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							final String propname = (String)frame.getLocal(0, 1);
							final Object value = frame.getLocal(0, 2);
							final EObject eo = (EObject)object;
							final EClass ecls = eo.eClass();
							final EStructuralFeature sf = ecls.getEStructuralFeature(propname);
							if (sf == null) {
								throw new VMException(frame, String.format(
										"Cannot find property %s::%s", ecls.getName(), propname));
							}
							((EObject)object).eSet(sf, value);
							return null;
						}
						throw new VMException(frame, String.format(
								"Cannot set properties for regular objects: %s",
								object));
					}
		});
		createOperation(false, "resolve", OCL_ANY_TYPE, OCL_ANY_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							final ExecEnv env = frame.getEnv();
							final Field traces = env.findStaticField(env.eClass(), "traces");
							final TraceLinkSet tls = (TraceLinkSet)traces.getStaticValue(frame);
							final SourceElement se = tls.getDefaultSourceElement((EObject)object);
							if (se != null) {
								final EList<TargetElement> seMapsTo = se.getMapsTo();
								if (!seMapsTo.isEmpty()) {
									assert seMapsTo.get(0).getObject().eResource() != null;
									return seMapsTo.get(0).getObject();
								}
								for (TargetElement te : se.getSourceOf().getTargetElements()) {
									if (te.getMapsTo() == null) { // default mapping
										assert te.getObject().eResource() != null;
										return te.getObject();
									}
								}
							}
						}
						return object;
					}
		});
		/////////////////////////////////////////////////////////////////////
		// JavaCollection
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "resolve", JAVA_COLLECTION_TYPE, SEQUENCE_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@SuppressWarnings("unchecked")
					@Override
					public Object execute(StackFrame frame) {
						final Collection<Object> object = (Collection<Object>)frame.getLocal(0, 0);
						return new ResolveList(object, frame);
					}
		});
		createOperation(false, "=~", JAVA_COLLECTION_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"o"}, OCL_ANY_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Collection<?> o = (Collection<?>)frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						if (o2 instanceof Collection<?>) {
							return o.containsAll((Collection<?>)o2);
						}
						return o.contains(o2);
					}
		});
		createOperation(false, "=~|", JAVA_COLLECTION_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"o"}, OCL_ANY_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Collection<?> o = (Collection<?>)frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						if (o2 instanceof Collection<?>) {
							return o.containsAll((Collection<?>)o2);
						}
						return o.contains(o2);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// JavaList
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "=~|", JAVA_LIST_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"o"}, OCL_ANY_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final List<?> o = (List<?>)frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						if (o2 instanceof Collection<?>) {
							final Collection<?> coll2 = (Collection<?>)o2;
							final int sizediff = o.size() - coll2.size();
							if (sizediff < 0) {
								return false;
							} else {
								return o.subList(sizediff, o.size()).containsAll(coll2);
							}
						}
						if (o.size() > 0) {
							final Object last = o.get(o.size() - 1);
							return last == null ? o2 == null : last.equals(o2);
						}
						return false;
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Map
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "including", MAP_TYPE, SET_TYPE,
				new String[][][]{{{"key"}, OCL_ANY_TYPE}, {{"value"}, OCL_ANY_TYPE}},
				new CodeBlockImpl() {
			@Override
			public Object execute(StackFrame frame) {
				final Map<Object, Object> o = new HashMap<Object, Object>((Map<?, ?>)frame.getLocal(0, 0));
				final Object key = frame.getLocal(0, 1);
				final Object value = frame.getLocal(0, 2);
				o.put(key, value);
				return o;
			}
		});
		createOperation(false, "getKeys", MAP_TYPE, SET_TYPE,
				new String[][][]{},
				new CodeBlockImpl() {
			@SuppressWarnings("unchecked")
			@Override
			public Object execute(StackFrame frame) {
				final Map<?, ?> o = (Map<?, ?>)frame.getLocal(0, 0);
				return new LazySetOnSet<Object>((Set<Object>)o.keySet());
			}
		});
		createOperation(false, "getValues", MAP_TYPE, SET_TYPE,
				new String[][][]{},
				new CodeBlockImpl() {
			@SuppressWarnings("unchecked")
			@Override
			public Object execute(StackFrame frame) {
				final Map<?, ?> o = (Map<?, ?>)frame.getLocal(0, 0);
				return new LazyBagOnCollection<Object>((Collection<Object>)o.values());
			}
		});
		createOperation(false, "union", MAP_TYPE, SET_TYPE,
				new String[][][]{{{"m"}, MAP_TYPE}},
				new CodeBlockImpl() {
			@Override
			public Object execute(StackFrame frame) {
				final Map<Object, Object> o = new HashMap<Object, Object>((Map<?, ?>)frame.getLocal(0, 0));
				final Map<?, ?> m = (Map<?, ?>)frame.getLocal(0, 1);
				o.putAll(m);
				return o;
			}
		});
		/////////////////////////////////////////////////////////////////////
		// ExecEnv
		/////////////////////////////////////////////////////////////////////
		createOperation(true, "resolveTemp", EXEC_ENV_TYPE, OCL_ANY_TYPE,
				new String[][][]{{{"var"}, OCL_ANY_TYPE}, {{"target_pattern_name"}, STRING_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final String name = (String)frame.getLocal(0, 1);
						if (object instanceof EObject) {
							final ExecEnv env = frame.getEnv();
							final Field traces = env.findStaticField(env.eClass(), "traces");
							final TraceLinkSet tls = (TraceLinkSet)traces.getStaticValue(frame);
							final SourceElement se = tls.getDefaultSourceElement((EObject)object);
							if (se != null) {
								final TargetElement te = se.getSourceOf().getTargetElement(name);
								if (te != null) {
									return te.getObject();
								}
							}
						} else if (object instanceof List<?>) {
							final ExecEnv env = frame.getEnv();
							final Field traces = env.findStaticField(env.eClass(), "traces");
							final TraceLinkSet tls = (TraceLinkSet)traces.getStaticValue(frame);
							final SourceElementList sel = tls.getDefaultSourceElements((List<?>)object);
							if (sel != null) {
								assert !sel.getSourceElements().isEmpty();
								final TargetElement te = sel.getSourceElements().get(0).getSourceOf().getTargetElement(name);
								if (te != null) {
									return te.getObject();
								}
							}
						}
						throw new VMException(frame, String.format(
								"Cannot resolve default trace target '%s' for %s", 
								name, EMFTVMUtil.toPrettyString(object, frame.getEnv())));
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Class
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "allInstances", CLASS_TYPE, SEQUENCE_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final EClass c = (EClass)frame.getLocal(0, 0);
						return EMFTVMUtil.findAllInstances(frame.getEnv(), c);
					}
		});
		createOperation(false, "allInstancesFrom", CLASS_TYPE, SEQUENCE_TYPE,
				new String[][][]{{{"metamodel"}, STRING_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final EClass c = (EClass)frame.getLocal(0, 0);
						final String mm = (String)frame.getLocal(0, 1);
						return EMFTVMUtil.findAllInstIn(frame.getEnv(), c, mm);
					}
		});
		createOperation(false, "conformsTo", CLASS_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"type"}, CLASS_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final EClass c = (EClass)frame.getLocal(0, 0);
						final EClass c2 = (EClass)frame.getLocal(0, 1);
						return c2.isSuperTypeOf(c);
					}
		});
		createOperation(false, "conformsTo", CLASS_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"type"}, JAVA_CLASS_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final EClass c = (EClass)frame.getLocal(0, 0);
						final Class<?> c2 = (Class<?>)frame.getLocal(0, 1);
						final Class<?> ic = c.getInstanceClass();
						if (ic != null) {
							return c2.isAssignableFrom(ic);
						}
						return c2 == Object.class; // everything is an Object
					}
		});
		/////////////////////////////////////////////////////////////////////
		// JavaClass
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "conformsTo", JAVA_CLASS_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"type"}, CLASS_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Class<?> c = (Class<?>)frame.getLocal(0, 0);
						final EClass c2 = (EClass)frame.getLocal(0, 1);
						final Class<?> ic2 = c2.getInstanceClass();
						if (ic2 != null) {
							return ic2.isAssignableFrom(c);
						}
						return false;
					}
		});
		createOperation(false, "conformsTo", JAVA_CLASS_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"type"}, JAVA_CLASS_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Class<?> c = (Class<?>)frame.getLocal(0, 0);
						final Class<?> c2 = (Class<?>)frame.getLocal(0, 1);
						return c2.isAssignableFrom(c);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Real
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "+", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) + (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "+", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) + (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) - (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) - (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) * (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) * (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "neg", REAL_TYPE, REAL_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return -(Double)frame.getLocal(0, 0);
					}
		});
		createOperation(false, "/", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) / (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) / (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "abs", REAL_TYPE, REAL_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.abs((Double)frame.getLocal(0, 0));
					}
		});
		createOperation(false, "floor", REAL_TYPE, INTEGER_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Double.valueOf(Math.floor((Double)frame.getLocal(0, 0))).intValue();
					}
		});
		createOperation(false, "round", REAL_TYPE, INTEGER_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Double.valueOf(Math.round((Double)frame.getLocal(0, 0))).intValue();
					}
		});
		createOperation(false, "max", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.max((Double)frame.getLocal(0, 0), (Double)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "max", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.max((Double)frame.getLocal(0, 0), (Integer)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.min((Double)frame.getLocal(0, 0), (Double)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", REAL_TYPE, REAL_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.min((Double)frame.getLocal(0, 0), (Integer)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "<", REAL_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) < (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<", REAL_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) < (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", REAL_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) > (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", REAL_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) > (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", REAL_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) <= (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", REAL_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) <= (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", REAL_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) >= (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", REAL_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double)frame.getLocal(0, 0) >= (Integer)frame.getLocal(0, 1);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Integer
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "neg", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return -(Integer)frame.getLocal(0, 0);
					}
		});
		createOperation(false, "+", INTEGER_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) + (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "+", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) + (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", INTEGER_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) - (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) - (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", INTEGER_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) * (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) * (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", INTEGER_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) / (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", INTEGER_TYPE, REAL_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((Integer)frame.getLocal(0, 0)).doubleValue() / (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "abs", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.abs((Integer)frame.getLocal(0, 0));
					}
		});
		createOperation(false, "div", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) / (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "mod", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) % (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "max", INTEGER_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.max((Integer)frame.getLocal(0, 0), (Double)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "max", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.max((Integer)frame.getLocal(0, 0), (Integer)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", INTEGER_TYPE, REAL_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.min((Integer)frame.getLocal(0, 0), (Double)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", INTEGER_TYPE, INTEGER_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.min((Integer)frame.getLocal(0, 0), (Integer)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "<", INTEGER_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) < (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<", INTEGER_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) < (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", INTEGER_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) > (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", INTEGER_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) > (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", INTEGER_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) <= (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", INTEGER_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) <= (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", INTEGER_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"r"}, REAL_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) >= (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", INTEGER_TYPE, BOOLEAN_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) >= (Integer)frame.getLocal(0, 1);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// String
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "+", STRING_TYPE, STRING_TYPE,
				new String[][][]{{{"s"}, STRING_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (String)frame.getLocal(0, 0) + (String)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "size", STRING_TYPE, INTEGER_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).length();
					}
		});
		createOperation(false, "substring", STRING_TYPE, STRING_TYPE,
				new String[][][]{{{"lower"}, INTEGER_TYPE}, {{"upper"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).substring(
								(Integer)frame.getLocal(0, 1) - 1,
								(Integer)frame.getLocal(0, 2));
					}
		});
		createOperation(false, "toInteger", STRING_TYPE, INTEGER_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Integer.parseInt((String)frame.getLocal(0, 0));
					}
		});
		createOperation(false, "toReal", STRING_TYPE, REAL_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Double.parseDouble((String)frame.getLocal(0, 0));
					}
		});
		createOperation(false, "indexOf", STRING_TYPE, INTEGER_TYPE,
				new String[][][]{{{"s"}, STRING_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).indexOf((String)frame.getLocal(0, 1)) + 1;
					}
		});
		createOperation(false, "lastIndexOf", STRING_TYPE, INTEGER_TYPE,
				new String[][][]{{{"s"}, STRING_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).lastIndexOf((String)frame.getLocal(0, 1)) + 1;
					}
		});
		createOperation(false, "at", STRING_TYPE, STRING_TYPE,
				new String[][][]{{{"i"}, INTEGER_TYPE}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return String.valueOf(((String)frame.getLocal(0, 0)).charAt((Integer)frame.getLocal(0, 1) - 1));
					}
		});
		createOperation(false, "characters", STRING_TYPE, SEQUENCE_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						LazyList<String> seq = new LazyList<String>();
						for (char c : ((String)frame.getLocal(0, 0)).toCharArray()) {
							seq = seq.append(String.valueOf(c));
						}
						return seq;
					}
		});
		createOperation(false, "toBoolean", STRING_TYPE, BOOLEAN_TYPE,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Boolean.parseBoolean((String)frame.getLocal(0, 0));
					}
		});
	}

	/**
	 * Creates and registers a new {@link Operation}.
	 * @param isStatic
	 * @param name operation name
	 * @param context operation context type model and name
	 * @param returnType operation return type model and name
	 * @param parameters operations parameters: [[name, type name], ...]
	 * @param body operation body
	 */
	private Operation createOperation(final boolean isStatic, final String name, final String[] context, 
			final String[] returnType, final String[][][] parameters, final CodeBlock body) {
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
			LocalVariable self = factory.createLocalVariable();
			self.setName("self");
			self.setTypeModel(context[0]);
			self.setType(context[1]);
			locals.add(self);
		}
		for (String[][] par : parameters) {
			Parameter p = factory.createParameter();
			p.setName(par[0][0]);
			p.setTypeModel(par[1][0]);
			p.setType(par[1][1]);
			pars.add(p);
			LocalVariable lv = factory.createLocalVariable();
			lv.setName(par[0][0]);
			lv.setTypeModel(par[1][0]);
			lv.setType(par[1][1]);
			locals.add(lv);
		}
		op.setBody(body);
		oclModule.getFeatures().add(op);
		return op;
	}

	/**
	 * @return the oclModule
	 */
	public Module getOclModule() {
		return oclModule;
	}
}
