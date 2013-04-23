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

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.trace.SourceElement;
import org.eclipse.m2m.atl.emftvm.trace.SourceElementList;
import org.eclipse.m2m.atl.emftvm.trace.TargetElement;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracedRule;


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
								if (te.getMapsTo().isEmpty()) { // default mapping
									assert te.getObject().eResource() != null;
									next = te.getObject();
									break;
								}
							}
						}
					}
				}
				updateCache(next);
				return next;
			}
		}

		protected final TraceLinkSet tls;

		/**
		 * Creates a new {@link ResolveList} around <code>dataSource</code>.
		 * @param dataSource he underlying collection
		 * @param frame the current {@link StackFrame}
		 */
		public ResolveList(final Collection<Object> dataSource, final StackFrame frame) {
			super(dataSource);
			this.tls = frame.getEnv().getTraces();
		}
	
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<Object> iterator() {
			if (dataSource == null) {
				return Collections.unmodifiableCollection(cache).iterator();
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
	 * {@link LazyList} that resolves unique trace links within a given traced rule.
	 */
	public static class UniqueResolveList extends ResolveList {

		/**
		 * {@link Iterator} that resolves unique trace links for a given rule.
		 */
		public class UniqueResolveIterator extends ResolveIterator {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object next() {
				Object next = inner.next();
				if (next instanceof EObject) {
					final SourceElement se = tr.getUniqueSourceElement((EObject)next);
					if (se != null) {
						final EList<TargetElement> seMapsTo = se.getMapsTo();
						if (!seMapsTo.isEmpty()) {
							assert seMapsTo.get(0).getObject().eResource() != null;
							next = seMapsTo.get(0).getObject();
						} else {
							for (TargetElement te : se.getSourceOf().getTargetElements()) {
								if (te.getMapsTo().isEmpty()) { // default mapping
									assert te.getObject().eResource() != null;
									next = te.getObject();
									break;
								}
							}
						}
					}
				}
				updateCache(next);
				return next;
			}
		}

		protected final TracedRule tr;

		/**
		 * Creates a new {@link UniqueResolveList} around <code>dataSource</code>.
		 * @param dataSource he underlying collection
		 * @param frame the current {@link StackFrame}
		 * @param rule the name of the rule to resolve the unique traces for
		 */
		public UniqueResolveList(final Collection<Object> dataSource, final StackFrame frame,
				final String rule) {
			super(dataSource, frame);
			this.tr = tls.getLinksByRule(rule, false);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<Object> iterator() {
			if (dataSource == null) {
				return Collections.unmodifiableCollection(cache).iterator();
			}
			if (tr == null) {
				return new CachingIterator(dataSource.iterator()); // no need to trace
			} else {
				return new UniqueResolveIterator(); // extends CachingIterator
			}
		}
		
	}

	private static OCLOperations instance;

	private final Module oclModule;

	/**
	 * Do not use.
	 */
	private OCLOperations() {
		super();
		oclModule = EmftvmFactory.eINSTANCE.createModule();
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
		createOperation(false, "debug", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final StringBuffer buf = new StringBuffer();
						if (object instanceof String) {
							buf.append('\'');
							buf.append((String)object);
							buf.append('\'');
						} else if (object instanceof LazyCollection<?>) {
							buf.append(((LazyCollection<?>)object).asString());
						} else {
							buf.append(object);
						}
						ATLLogger.info(buf.toString());
						return object;
					}
		});
		createOperation(false, "debug", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"message"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final StringBuffer buf = new StringBuffer((String)frame.getLocal(0, 1));
						buf.append(": ");
						if (object instanceof String) {
							buf.append('\'');
							buf.append((String)object);
							buf.append('\'');
						} else if (object instanceof LazyCollection<?>) {
							buf.append(((LazyCollection<?>)object).asString());
						} else {
							buf.append(object);
						}
						ATLLogger.info(buf.toString());
						return object;
					}
		});
		createOperation(false, "oclAsType", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"type"}, Types.CLASSIFIER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
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
		createOperation(false, "oclAsType", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"type"}, Types.JAVA_CLASS_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
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
		createOperation(false, "oclIsTypeOf", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"type"}, Types.CLASSIFIER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final EClassifier type = (EClassifier)frame.getLocal(0, 1);
						if (type instanceof EClass && o instanceof EObject) {
							return ((EObject) o).eClass() == type;
						} else if (o != null) {
							final Class<?> ic = ((EClassifier)type).getInstanceClass();
							if (ic == null) {
								throw new IllegalArgumentException(String.format("EClassifier %s must have an instance class", type));
							}
							return o.getClass() == ic;
						} else {
							return false;
						}
					}
		});
		createOperation(false, "oclIsTypeOf", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"type"}, Types.JAVA_CLASS_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Class<?> type = (Class<?>)frame.getLocal(0, 1);
						return o != null ? o.getClass() == type : false;
					}
		});
		createOperation(false, "oclIsKindOf", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"type"}, Types.CLASSIFIER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final EClassifier type = (EClassifier)frame.getLocal(0, 1);
						return type.isInstance(o);
					}
		});
		createOperation(false, "oclIsKindOf", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"type"}, Types.JAVA_CLASS_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Class<?> type = (Class<?>)frame.getLocal(0, 1);
						return type.isInstance(o);
					}
		});
		createOperation(false, "oclType", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						if (o instanceof EObject) {
							return ((EObject)o).eClass();
						} else if (o != null) {
							return o.getClass();
						} else {
							return Void.TYPE;
						}
					}
		});
		createOperation(false, "=", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"o"}, Types.OCL_ANY_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return o == null ? o2 == null : o.equals(o2);
					}
		});
		createOperation(false, "=~", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"o"}, Types.OCL_ANY_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return o == null ? o2 == null : o.equals(o2);
					}
		});
		createOperation(false, "=~|", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"o"}, Types.OCL_ANY_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return o == null ? o2 == null : o.equals(o2);
					}
		});
		createOperation(false, "<>", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"o"}, Types.OCL_ANY_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return !(o == null ? o2 == null : o.equals(o2));
					}
		});
		createOperation(false, "isInModel", Types.OCL_ANY_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"model"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
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
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
		});
		createOperation(false, "refImmediateComposite", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							return ((EObject)object).eContainer();
						}
						throw new VMException(frame, String.format(
								"Cannot retrieve immediate composite for regular objects: %s",
								object));
					}
		});
		createOperation(false, "refGetValue", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"propname"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
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
		createOperation(false, "refSetValue", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"propname"}, Types.STRING_TYPE}, {{"value"}, Types.OCL_ANY_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
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
		createOperation(false, "refUnsetValue", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"propname"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
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
							((EObject)object).eUnset(sf);
							return null;
						}
						throw new VMException(frame, String.format(
								"Cannot unset properties for regular objects: %s",
								object));
					}
		});
		createOperation(false, "refInvokeOperation", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"opname"}, Types.STRING_TYPE}, {{"arguments"}, Types.SEQUENCE_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final String opname = (String)frame.getLocal(0, 1);
						final List<?> args = (List<?>)frame.getLocal(0, 2);
						return EMFTVMUtil.invokeNative(frame, object, opname, args.toArray());
					}
		});
		createOperation(false, "resolve", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							final SourceElement se = frame.getEnv().getTraces().getDefaultSourceElement((EObject)object);
							if (se != null) {
								final EList<TargetElement> seMapsTo = se.getMapsTo();
								if (!seMapsTo.isEmpty()) {
									assert seMapsTo.get(0).getObject().eResource() != null;
									return seMapsTo.get(0).getObject();
								}
								for (TargetElement te : se.getSourceOf().getTargetElements()) {
									if (te.getMapsTo().isEmpty()) { // default mapping
										assert te.getObject().eResource() != null;
										return te.getObject();
									}
								}
							}
						}
				return object;

					}
		});
		createOperation(false, "resolve", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"rule"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							final String rule = (String)frame.getLocal(0, 1);
							final TracedRule tr = frame.getEnv().getTraces().getLinksByRule(rule, false);
							if (tr != null) {
								final SourceElement se = tr.getUniqueSourceElement((EObject)object);
								if (se != null) {
									final EList<TargetElement> seMapsTo = se.getMapsTo();
									if (!seMapsTo.isEmpty()) {
										assert seMapsTo.get(0).getObject().eResource() != null;
										return seMapsTo.get(0).getObject();
									}
									for (TargetElement te : se.getSourceOf().getTargetElements()) {
										if (te.getMapsTo().isEmpty()) { // default mapping
											assert te.getObject().eResource() != null;
											return te.getObject();
										}
									}
								}
							}
						}
						return object;

					}
		});
		createOperation(false, "remap", Types.OCL_ANY_TYPE, Types.OCL_ANY_TYPE, 
				new String[][][]{{{"to"}, Types.OCL_ANY_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object source = frame.getLocal(0, 0);
						final Object target = frame.getLocal(0, 1);
						if (source instanceof EObject && target instanceof EObject && source != target) { // different physical objects
							frame.getEnv().queueForRemap((EObject) source, (EObject) target, frame);
						}
						return target;
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Collection
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "toString", Types.COLLECTION_TYPE, Types.STRING_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@SuppressWarnings("unchecked")
					@Override
					public Object execute(final StackFrame frame) {
						final LazyCollection<Object> coll = (LazyCollection<Object>)frame.getLocal(0, 0);
						return coll.asString();
					}
		});
		/////////////////////////////////////////////////////////////////////
		// JavaCollection
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "resolve", Types.JAVA_COLLECTION_TYPE, Types.SEQUENCE_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@SuppressWarnings("unchecked")
					@Override
					public Object execute(final StackFrame frame) {
						final Collection<Object> object = (Collection<Object>)frame.getLocal(0, 0);
						return new ResolveList(object, frame);
					}
		});
		createOperation(false, "resolve", Types.JAVA_COLLECTION_TYPE, Types.SEQUENCE_TYPE,
				new String[][][]{{{"rule"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@SuppressWarnings("unchecked")
					@Override
					public Object execute(final StackFrame frame) {
						final Collection<Object> object = (Collection<Object>)frame.getLocal(0, 0);
						final String rule = (String)frame.getLocal(0, 1);
						return new UniqueResolveList(object, frame, rule);
					}
		});
		createOperation(false, "=~", Types.JAVA_COLLECTION_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"o"}, Types.OCL_ANY_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Collection<?> o = (Collection<?>)frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						if (o2 instanceof Collection<?>) {
							return o.containsAll((Collection<?>)o2);
						} else {
							return o.contains(o2);
						}
					}
		});
		createOperation(false, "=~|", Types.JAVA_COLLECTION_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"o"}, Types.OCL_ANY_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Collection<?> o = (Collection<?>)frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						if (o2 instanceof Collection<?>) {
							return o.containsAll((Collection<?>)o2);
						} else {
							return o.contains(o2);
						}
					}
		});
		/////////////////////////////////////////////////////////////////////
		// JavaList
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "=~|", Types.JAVA_LIST_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"o"}, Types.OCL_ANY_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
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
						} else if (o.size() > 0) {
							final Object last = o.get(o.size() - 1);
							return last == null ? o2 == null : last.equals(o2);
						} else {
							return false;
						}
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Map
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "including", Types.MAP_TYPE, Types.SET_TYPE,
				new String[][][]{{{"key"}, Types.OCL_ANY_TYPE}, {{"value"}, Types.OCL_ANY_TYPE}},
				new NativeCodeBlock() {
			@Override
			public Object execute(final StackFrame frame) {
				final Map<Object, Object> o = new HashMap<Object, Object>((Map<?, ?>)frame.getLocal(0, 0));
				final Object key = frame.getLocal(0, 1);
				final Object value = frame.getLocal(0, 2);
				o.put(key, value);
				return o;
			}
		});
		createOperation(false, "getKeys", Types.MAP_TYPE, Types.SET_TYPE,
				new String[][][]{},
				new NativeCodeBlock() {
			@SuppressWarnings("unchecked")
			@Override
			public Object execute(final StackFrame frame) {
				final Map<?, ?> o = (Map<?, ?>)frame.getLocal(0, 0);
				return new LazySetOnSet<Object>((Set<Object>)o.keySet());
			}
		});
		createOperation(false, "getValues", Types.MAP_TYPE, Types.SET_TYPE,
				new String[][][]{},
				new NativeCodeBlock() {
			@SuppressWarnings("unchecked")
			@Override
			public Object execute(final StackFrame frame) {
				final Map<?, ?> o = (Map<?, ?>)frame.getLocal(0, 0);
				return new LazyBagOnCollection<Object>((Collection<Object>)o.values());
			}
		});
		createOperation(false, "union", Types.MAP_TYPE, Types.SET_TYPE,
				new String[][][]{{{"m"}, Types.MAP_TYPE}},
				new NativeCodeBlock() {
			@Override
			public Object execute(final StackFrame frame) {
				final Map<Object, Object> o = new HashMap<Object, Object>((Map<?, ?>)frame.getLocal(0, 0));
				final Map<?, ?> m = (Map<?, ?>)frame.getLocal(0, 1);
				o.putAll(m);
				return o;
			}
		});
		/////////////////////////////////////////////////////////////////////
		// ExecEnv
		/////////////////////////////////////////////////////////////////////
		createOperation(true, "resolveTemp", Types.EXEC_ENV_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"var"}, Types.OCL_ANY_TYPE}, {{"target_pattern_name"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final String name = (String)frame.getLocal(0, 1);
						if (object instanceof EObject) {
							final SourceElement se = frame.getEnv().getTraces().getDefaultSourceElement((EObject)object);
							if (se != null) {
								final TargetElement te = se.getSourceOf().getTargetElement(name);
								if (te != null) {
									return te.getObject();
								}
							}
						} else if (object instanceof List<?>) {
							final SourceElementList sel = frame.getEnv().getTraces().getDefaultSourceElements((List<?>)object);
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
		createOperation(true, "resolveTemp", Types.EXEC_ENV_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"var"}, Types.OCL_ANY_TYPE}, 
					{{"rule_name"}, Types.STRING_TYPE}, 
					{{"target_pattern_name"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final String rule = (String)frame.getLocal(0, 1);
						final String name = (String)frame.getLocal(0, 2);
						if (object instanceof EObject) {
							final TracedRule tr = frame.getEnv().getTraces().getLinksByRule(rule, false);
							if (tr != null) {
								final SourceElement se = tr.getUniqueSourceElement((EObject)object);
								if (se != null) {
									final TargetElement te = se.getSourceOf().getTargetElement(name);
									if (te != null) {
										return te.getObject();
									}
								}
							}
						} else if (object instanceof List<?>) {
							final TracedRule tr = frame.getEnv().getTraces().getLinksByRule(rule, false);
							if (tr != null) {
								final SourceElementList sel = tr.getUniqueSourceElements((List<?>)object);
								if (sel != null) {
									assert !sel.getSourceElements().isEmpty();
									final TargetElement te = sel.getSourceElements().get(0).getSourceOf().getTargetElement(name);
									if (te != null) {
										return te.getObject();
									}
								}
							}
						}
						throw new VMException(frame, String.format(
								"Cannot resolve unique trace target '%s::%s' for %s", 
								rule, name, EMFTVMUtil.toPrettyString(object, frame.getEnv())));
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Class
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "allInstances", Types.CLASS_TYPE, Types.SEQUENCE_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final EClass c = (EClass)frame.getLocal(0, 0);
						return EMFTVMUtil.findAllInstances(c, frame.getEnv());
					}
		});
		createOperation(false, "allInstancesFrom", Types.CLASS_TYPE, Types.SEQUENCE_TYPE,
				new String[][][]{{{"metamodel"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final EClass c = (EClass)frame.getLocal(0, 0);
						final String mm = (String)frame.getLocal(0, 1);
						return EMFTVMUtil.findAllInstIn(mm, c, frame.getEnv());
					}
		});
		createOperation(false, "conformsTo", Types.CLASS_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"type"}, Types.CLASS_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final EClass c = (EClass)frame.getLocal(0, 0);
						final EClass c2 = (EClass)frame.getLocal(0, 1);
						return c2.isSuperTypeOf(c);
					}
		});
		createOperation(false, "conformsTo", Types.CLASS_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"type"}, Types.JAVA_CLASS_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final EClass c = (EClass)frame.getLocal(0, 0);
						final Class<?> c2 = (Class<?>)frame.getLocal(0, 1);
						final Class<?> ic = c.getInstanceClass();
						if (ic != null) {
							return c2.isAssignableFrom(ic);
						} else {
							return c2 == Object.class; // everything is an Object
						}
					}
		});
		createOperation(false, "newInstance", Types.CLASS_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final EClass type = (EClass)frame.getLocal(0, 0);
						return type.getEPackage().getEFactoryInstance().create(type);
					}
		});
		createOperation(false, "newInstanceIn", Types.CLASS_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"modelname"}, Types.STRING_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final EClass type = (EClass)frame.getLocal(0, 0);
						final String modelname = (String)frame.getLocal(0, 1);
						final ExecEnv env = frame.getEnv();
						Model model = env.getOutputModels().get(modelname);
						if (model == null) {
							model = env.getInoutModels().get(modelname);
						}
						if (model == null) {
							throw new IllegalArgumentException(String.format("Inout/output model %s not found", modelname));
						}
						return model.newElement(type);
					}
		});
		createOperation(false, "getInstanceById", Types.CLASS_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"id"}, Types.STRING_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final EClass type = (EClass)frame.getLocal(0, 0);
						final String id = (String)frame.getLocal(0, 1);
						final ExecEnv env = frame.getEnv();
						final List<Model> models = new LazyListOnCollection<Model>(
								env.getInputModels().values()).union(new LazyListOnCollection<Model>(
										env.getInoutModels().values()));
						for (Model model : models) {
							final EObject instance = model.getResource().getEObject(id);
							if (type.isInstance(instance)) {
								return instance;
							}
						}
						return null;
					}
		});
		createOperation(false, "getInstanceById", Types.CLASS_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"modelname"}, Types.STRING_TYPE}, {{"id"}, Types.STRING_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final EClass type = (EClass)frame.getLocal(0, 0);
						final String modelname = (String)frame.getLocal(0, 1);
						final String id = (String)frame.getLocal(0, 2);
						final ExecEnv env = frame.getEnv();
						Model model = env.getInputModels().get(modelname);
						if (model == null) {
							model = env.getInoutModels().get(modelname);
						}
						if (model == null) {
							throw new IllegalArgumentException(String.format("Input/inout model %s not found", modelname));
						}
						final EObject instance = model.getResource().getEObject(id);
						if (type.isInstance(instance)) {
							return instance;
						} else {
							return null;
						}
					}
		});
		/////////////////////////////////////////////////////////////////////
		// JavaClass
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "conformsTo", Types.JAVA_CLASS_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"type"}, Types.CLASS_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Class<?> c = (Class<?>)frame.getLocal(0, 0);
						final EClass c2 = (EClass)frame.getLocal(0, 1);
						final Class<?> ic2 = c2.getInstanceClass();
						if (ic2 != null) {
							return ic2.isAssignableFrom(c);
						} else {
							return false;
						}
					}
		});
		createOperation(false, "conformsTo", Types.JAVA_CLASS_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"type"}, Types.JAVA_CLASS_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Class<?> c = (Class<?>)frame.getLocal(0, 0);
						final Class<?> c2 = (Class<?>)frame.getLocal(0, 1);
						return c2.isAssignableFrom(c);
					}
		});
		createOperation(false, "getName", Types.JAVA_CLASS_TYPE, Types.STRING_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Class<?> c = (Class<?>)frame.getLocal(0, 0);
						return NativeTypes.typeName(c);
					}
		});
		createOperation(false, "refInvokeStaticOperation", Types.JAVA_CLASS_TYPE, Types.OCL_ANY_TYPE,
				new String[][][]{{{"opname"}, Types.STRING_TYPE}, {{"arguments"}, Types.SEQUENCE_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Class<?> c = (Class<?>)frame.getLocal(0, 0);
						final String opname = (String)frame.getLocal(0, 1);
						final List<?> args = (List<?>)frame.getLocal(0, 2);
						return EMFTVMUtil.invokeNativeStatic(frame, c, opname, args.toArray());
					}
		});
		createOperation(false, "refNewInstance", Types.JAVA_CLASS_TYPE, Types.OCL_ANY_TYPE, new String[][][] { { { "arguments" },
				Types.SEQUENCE_TYPE } }, new NativeCodeBlock() {
			@Override
			public Object execute(final StackFrame frame) {
				final Class<?> c = (Class<?>) frame.getLocal(0, 0);
				final Object[] args = ((List<?>) frame.getLocal(0, 1)).toArray();
				final Constructor<?> constructor = EMFTVMUtil.findConstructor(c, EMFTVMUtil.getArgumentClasses(args));
				if (constructor != null) {
					try {
						return EMFTVMUtil.emf2vm(frame.getEnv(), null, constructor.newInstance(args));
					} catch (InvocationTargetException e) {
						final Throwable target = e.getTargetException();
						if (target instanceof VMException) {
							throw (VMException) target;
						} else {
							throw new VMException(frame, target);
						}
					} catch (VMException e) {
						throw e;
					} catch (Exception e) {
						throw new VMException(frame, e);
					}
				}
				throw new UnsupportedOperationException(String.format("%s::<init>(%s)", EMFTVMUtil.getTypeName(frame.getEnv(), c),
						EMFTVMUtil.getTypeNames(frame.getEnv(), EMFTVMUtil.getArgumentTypes(args))));
			}
		});
		/////////////////////////////////////////////////////////////////////
		// Real
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "+", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) + (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "+", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) + (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) - (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) - (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) * (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) * (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "neg", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return -(Double)frame.getLocal(0, 0);
					}
		});
		createOperation(false, "/", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) / (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) / (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "abs", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.abs((Double)frame.getLocal(0, 0));
					}
		});
		createOperation(false, "floor", Types.REAL_TYPE, Types.INTEGER_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Double.valueOf(Math.floor((Double)frame.getLocal(0, 0))).intValue();
					}
		});
		createOperation(false, "round", Types.REAL_TYPE, Types.INTEGER_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Double.valueOf(Math.round((Double)frame.getLocal(0, 0))).intValue();
					}
		});
		createOperation(false, "max", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.max((Double)frame.getLocal(0, 0), (Double)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "max", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.max((Double)frame.getLocal(0, 0), (Integer)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.min((Double)frame.getLocal(0, 0), (Double)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", Types.REAL_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.min((Double)frame.getLocal(0, 0), (Integer)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "<", Types.REAL_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) < (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<", Types.REAL_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) < (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", Types.REAL_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) > (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", Types.REAL_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) > (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", Types.REAL_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) <= (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", Types.REAL_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) <= (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", Types.REAL_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) >= (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", Types.REAL_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Double)frame.getLocal(0, 0) >= (Integer)frame.getLocal(0, 1);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Integer
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "neg", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return -(Integer)frame.getLocal(0, 0);
					}
		});
		createOperation(false, "+", Types.INTEGER_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) + (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "+", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) + (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", Types.INTEGER_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) - (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) - (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", Types.INTEGER_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) * (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) * (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", Types.INTEGER_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) / (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", Types.INTEGER_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return ((Integer)frame.getLocal(0, 0)).doubleValue() / (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "abs", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.abs((Integer)frame.getLocal(0, 0));
					}
		});
		createOperation(false, "div", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) / (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "mod", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) % (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "max", Types.INTEGER_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.max((Integer)frame.getLocal(0, 0), (Double)frame.getLocal(0, 1));

					}
		});
		createOperation(false, "max", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.max((Integer)frame.getLocal(0, 0), (Integer)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", Types.INTEGER_TYPE, Types.REAL_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.min((Integer)frame.getLocal(0, 0), (Double)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", Types.INTEGER_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Math.min((Integer)frame.getLocal(0, 0), (Integer)frame.getLocal(0, 1));
					}
		});
		createOperation(false, "<", Types.INTEGER_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) < (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<", Types.INTEGER_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) < (Integer)frame.getLocal(0, 1);

					}
		});
		createOperation(false, ">", Types.INTEGER_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) > (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", Types.INTEGER_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) > (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", Types.INTEGER_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) <= (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", Types.INTEGER_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) <= (Integer)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", Types.INTEGER_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"r"}, Types.REAL_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) >= (Double)frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", Types.INTEGER_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (Integer)frame.getLocal(0, 0) >= (Integer)frame.getLocal(0, 1);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// String
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "+", Types.STRING_TYPE, Types.STRING_TYPE,
				new String[][][]{{{"s"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return (String)frame.getLocal(0, 0) + (String)frame.getLocal(0, 1);
					}
		});
		createOperation(false, "size", Types.STRING_TYPE, Types.INTEGER_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).length();
					}
		});
		createOperation(false, "substring", Types.STRING_TYPE, Types.STRING_TYPE,
				new String[][][]{{{"lower"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return ((String)frame.getLocal(0, 0)).substring(
									(Integer)frame.getLocal(0, 1) - 1);
						} catch (IndexOutOfBoundsException e) {
							throw new VMException(frame, e);
						}
					}
		});
		createOperation(false, "substring", Types.STRING_TYPE, Types.STRING_TYPE,
				new String[][][]{{{"lower"}, Types.INTEGER_TYPE}, {{"upper"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return ((String)frame.getLocal(0, 0)).substring(
									(Integer)frame.getLocal(0, 1) - 1,
									(Integer)frame.getLocal(0, 2));
						} catch (IndexOutOfBoundsException e) {
							throw new VMException(frame, e);
						}
					}
		});
		createOperation(false, "toInteger", Types.STRING_TYPE, Types.INTEGER_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return Integer.parseInt((String)frame.getLocal(0, 0));
						} catch (NumberFormatException e) {
							throw new VMException(frame, e);
						}
					}
		});
		createOperation(false, "toReal", Types.STRING_TYPE, Types.REAL_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return Double.parseDouble((String)frame.getLocal(0, 0));
						} catch (NumberFormatException e) {
							throw new VMException(frame, e);
						}
					}
		});
		createOperation(false, "indexOf", Types.STRING_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"s"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).indexOf((String)frame.getLocal(0, 1)) + 1;
					}
		});
		createOperation(false, "lastIndexOf", Types.STRING_TYPE, Types.INTEGER_TYPE,
				new String[][][]{{{"s"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).lastIndexOf((String)frame.getLocal(0, 1)) + 1;
					}
		});
		createOperation(false, "at", Types.STRING_TYPE, Types.STRING_TYPE,
				new String[][][]{{{"i"}, Types.INTEGER_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return String.valueOf(((String)frame.getLocal(0, 0))
									.charAt((Integer)frame.getLocal(0, 1) - 1));
						} catch (IndexOutOfBoundsException e) {
							throw new VMException(frame, e);
						}
					}
		});
		createOperation(false, "characters", Types.STRING_TYPE, Types.SEQUENCE_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						LazyList<String> seq = new LazyList<String>();
						for (char c : ((String)frame.getLocal(0, 0)).toCharArray()) {
							seq = seq.append(String.valueOf(c));
						}
						return seq;
					}
		});
		createOperation(false, "toBoolean", Types.STRING_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return Boolean.parseBoolean((String)frame.getLocal(0, 0));
					}
		});
		createOperation(false, "toUpper", Types.STRING_TYPE, Types.STRING_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).toUpperCase();
					}
		});
		createOperation(false, "toLower", Types.STRING_TYPE, Types.STRING_TYPE,
				new String[][][]{}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return ((String)frame.getLocal(0, 0)).toLowerCase();
					}
		});
		createOperation(false, "writeTo", Types.STRING_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"path"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return EMFTVMUtil.writeToWithCharset(
									(String)frame.getLocal(0, 0), 
									(String)frame.getLocal(0, 1),
									null);

						} catch (IOException e) {
							throw new VMException(frame, e);
						}
					}
		});
		createOperation(false, "writeToWithCharset", Types.STRING_TYPE, Types.BOOLEAN_TYPE,
				new String[][][]{{{"path"}, Types.STRING_TYPE}, {{"charset"}, Types.STRING_TYPE}}, 
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return EMFTVMUtil.writeToWithCharset(
									(String)frame.getLocal(0, 0), 
									(String)frame.getLocal(0, 1),
									(String)frame.getLocal(0, 2));

						} catch (IOException e) {
							throw new VMException(frame, e);
						}
					}
		});
		createOperation(false, "toDate", Types.STRING_TYPE, Types.JAVA_DATE_TYPE, 
				new String[][][]{{{"format"}, Types.STRING_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return new SimpleDateFormat((String) frame.getLocal(1)).parse((String) frame.getLocal(0));
						} catch (ParseException e) {
							throw new VMException(frame, e);
						}
					}
				});
		createOperation(false, "toDate", Types.STRING_TYPE, Types.JAVA_DATE_TYPE, 
				new String[][][]{{{"format"}, Types.STRING_TYPE}, {{"locale"}, Types.STRING_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						try {
							return new SimpleDateFormat((String) frame.getLocal(1), EMFTVMUtil.getLocale((String) frame.getLocal(2)))
									.parse((String) frame.getLocal(0));
						} catch (ParseException e) {
							throw new VMException(frame, e);
						}
					}
				});
		/////////////////////////////////////////////////////////////////////
		// Date
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "toString", Types.JAVA_DATE_TYPE, Types.STRING_TYPE, 
				new String[][][]{{{"format"}, Types.STRING_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return new SimpleDateFormat((String) frame.getLocal(1)).format((Date) frame.getLocal(0));
					}
				});
		createOperation(false, "toString", Types.JAVA_DATE_TYPE, Types.STRING_TYPE, 
				new String[][][]{{{"format"}, Types.STRING_TYPE}, {{"locale"}, Types.STRING_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						return new SimpleDateFormat((String) frame.getLocal(1), EMFTVMUtil.getLocale((String) frame.getLocal(2)))
								.format((Date) frame.getLocal(0));
					}
				});
		createOperation(false, "toTuple", Types.JAVA_DATE_TYPE, Types.TUPLE_TYPE, new String[][][]{},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Calendar cal = Calendar.getInstance();
						cal.setTime((Date) frame.getLocal(0));
						return Tuple.fromCalendar(cal);
					}
				});
		createOperation(false, "toTuple", Types.JAVA_DATE_TYPE, Types.TUPLE_TYPE, 
				new String[][][]{{{"timezone"}, Types.STRING_TYPE}},
				new NativeCodeBlock() {
					@Override
					public Object execute(final StackFrame frame) {
						final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone((String) frame.getLocal(1)));
						cal.setTime((Date) frame.getLocal(0));
						return Tuple.fromCalendar(cal);
					}
				});
	}

	/**
	 * Creates and registers a new {@link Operation}.
	 * @param isStatic whether the created operation is static
	 * @param name operation name
	 * @param context operation context [type model, type name]
	 * @param returnType operation return [type model, type name]
	 * @param parameters operations parameters: [[[name], [type model, type name]], ...]
	 * @param body operation body
	 * @return a new {@link Operation}.
	 * @see Types
	 */
	private Operation createOperation(final boolean isStatic, final String name, final String[] context, 
			final String[] returnType, final String[][][] parameters, final CodeBlock body) {
		final Operation op = EMFTVMUtil.createOperation(isStatic, name, context, returnType, parameters, body);
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
