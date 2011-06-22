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
import java.util.Iterator;
import java.util.List;

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
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public final class OCLOperations {

	public static class ResolveList extends LazyList<Object> {
		
		public class ResolveIterator extends CachingIterator {
	
			public ResolveIterator() {
				super(dataSource.iterator());
			}
	
			/*
			 * (non-Javadoc)
			 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection.CachingIterator#next()
			 */
			@Override
			public Object next() {
				Object next = inner.next();
				if (next instanceof EObject) {
					final SourceElement se = tls.getDefaultSourceElement((EObject) next);
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
		 * @param dataSource
		 */
		public ResolveList(final Collection<Object> dataSource, final StackFrame frame) {
			super(dataSource);
			this.frame = frame;
			this.env = frame.getEnv();
			this.traces = env.findStaticField(env.eClass(), "traces");
			this.tls = (TraceLinkSet) traces.getStaticValue(frame);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#iterator()
		 */
		@Override
		public Iterator<Object> iterator() {
			if (dataSource == null) {
				return cache.iterator();
			}
			return new ResolveIterator(); // extends CachingIterator
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.atl.emftvm.util.LazyCollection#size()
		 */
		@Override
		public int size() {
			if (dataSource == null) {
				return cache.size();
			}
			return ((Collection<Object>) dataSource).size();
		}
		
	}

	public static final String OclModel = EMFTVMUtil.NATIVE;
	public static final String EcoreModel = EcorePackage.eNAME.toUpperCase();
	public static final String EmftvmModel = EmftvmPackage.eNAME.toUpperCase();

	public static final String[] OclAnyType			= new String[]{OclModel, "java.lang.Object"};
	public static final String[] BooleanType		= new String[]{OclModel, "java.lang.Boolean"};
	public static final String[] RealType			= new String[]{OclModel, "java.lang.Double"};
	public static final String[] IntegerType		= new String[]{OclModel, "java.lang.Integer"};
	public static final String[] StringType			= new String[]{OclModel, "java.lang.String"};
	public static final String[] JavaClassType		= new String[]{OclModel, "java.lang.Class"};
	public static final String[] JavaCollectionType = new String[]{OclModel, "java.util.Collection"};
	public static final String[] JavaListType		= new String[]{OclModel, "java.util.List"};
	public static final String[] CollectionType 	= new String[]{OclModel, "org.eclipse.m2m.atl.emftvm.util.LazyCollection"};
	public static final String[] BagType 			= new String[]{OclModel, "org.eclipse.m2m.atl.emftvm.util.LazyBag"};
	public static final String[] SequenceType 		= new String[]{OclModel, "org.eclipse.m2m.atl.emftvm.util.LazyList"};
	public static final String[] SetType 			= new String[]{OclModel, "org.eclipse.m2m.atl.emftvm.util.LazySet"};
	public static final String[] OrderedSetType 	= new String[]{OclModel, "org.eclipse.m2m.atl.emftvm.util.LazyOrderedSet"};

	public static final String[] ClassifierType 	= new String[]{EcoreModel, "EClassifier"};
	public static final String[] ClassType 			= new String[]{EcoreModel, "EClass"};

	public static final String[] ExecEnvType 		= new String[]{EmftvmModel, "ExecEnv"};

	private static OCLOperations INSTANCE = null;

	/**
	 * @return the singleton instance of {@link OCLOperations}.
	 */
	public static OCLOperations getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new OCLOperations();
		}
		return INSTANCE;
	}

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
	 * Adds native operations to the oclModule.
	 */
	private void createOperations() {
		/////////////////////////////////////////////////////////////////////
		// OclAny
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "debug", OclAnyType, OclAnyType,
				new String[][][]{{{"message"}, StringType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final StringBuffer buf = new StringBuffer((String) frame.getLocal(0, 1));
						buf.append(": ");
						if (object instanceof String) {
							buf.append('\'');
							buf.append((String) object);
							buf.append('\'');
						} else {
							buf.append(object);
						}
						ATLLogger.info(buf.toString());
						return object;
					}
		});
		createOperation(false, "oclAsType", OclAnyType, OclAnyType,
				new String[][][]{{{"type"}, ClassifierType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final EClassifier type = (EClassifier) frame.getLocal(0, 1);
						if (!type.isInstance(object)) {
							throw new IllegalArgumentException(String.format(
									"%s is not an instance of %s",
									object, type));
						}
						return object;
					}
		});
		createOperation(false, "oclAsType", OclAnyType, OclAnyType,
				new String[][][]{{{"type"}, JavaClassType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final Class<?> type = (Class<?>) frame.getLocal(0, 1);
						if (!type.isInstance(object)) {
							throw new IllegalArgumentException(String.format(
									"%s is not an instance of %s",
									object, type));
						}
						return object;
					}
		});
		createOperation(false, "oclIsTypeOf", OclAnyType, BooleanType,
				new String[][][]{{{"type"}, ClassifierType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final EClassifier type = (EClassifier) frame.getLocal(0, 1);
						if (type instanceof EClass && o instanceof EObject) {
							return ((EObject) o).eClass() == type;
						} else if (o != null) {
							final Class<?> ic = ((EClassifier) type).getInstanceClass();
							if (ic == null) {
								throw new IllegalArgumentException(String.format("EClassifier %s must have an instance class", type));
							}
							return o.getClass() == ic;
						}
						return false;
					}
		});
		createOperation(false, "oclIsTypeOf", OclAnyType, BooleanType,
				new String[][][]{{{"type"}, JavaClassType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Class<?> type = (Class<?>) frame.getLocal(0, 1);
						return o != null ? o.getClass() == type : false;
					}
		});
		createOperation(false, "oclIsKindOf", OclAnyType, BooleanType,
				new String[][][]{{{"type"}, ClassifierType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final EClassifier type = (EClassifier) frame.getLocal(0, 1);
						return type.isInstance(o);
					}
		});
		createOperation(false, "oclIsKindOf", OclAnyType, BooleanType,
				new String[][][]{{{"type"}, JavaClassType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Class<?> type = (Class<?>) frame.getLocal(0, 1);
						return type.isInstance(o);
					}
		});
		createOperation(false, "oclType", OclAnyType, OclAnyType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						if (o instanceof EObject) {
							return ((EObject) o).eClass();
						} else if (o != null) {
							return o.getClass();
						}
						return Void.TYPE;
					}
		});
		createOperation(false, "=", OclAnyType, BooleanType,
				new String[][][]{{{"o"}, OclAnyType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return (o==null ? o2==null : o.equals(o2));
					}
		});
		createOperation(false, "=~", OclAnyType, BooleanType,
				new String[][][]{{{"o"}, OclAnyType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return (o==null ? o2==null : o.equals(o2));
					}
		});
		createOperation(false, "=~|", OclAnyType, BooleanType,
				new String[][][]{{{"o"}, OclAnyType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return (o==null ? o2==null : o.equals(o2));
					}
		});
		createOperation(false, "<>", OclAnyType, BooleanType,
				new String[][][]{{{"o"}, OclAnyType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						return !(o==null ? o2==null : o.equals(o2));
					}
		});
		createOperation(false, "isInModel", OclAnyType, BooleanType,
				new String[][][]{{{"model"}, StringType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object o = frame.getLocal(0, 0);
						if (o instanceof EObject) {
							final String mName = (String) frame.getLocal(0, 1);
							final ExecEnv env = frame.getEnv();
							Model model = env.getInputModels().get(mName);
							if (model == null) {
								model = env.getInoutModels().get(mName);
							}
							if (model == null) {
								model = env.getOutputModels().get(mName);
							}
							if (model != null) {
								return model.getResource() == ((EObject) o).eResource();
							}
						}
						return false;
					}
		});
		createOperation(false, "refImmediateComposite", OclAnyType, OclAnyType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							return ((EObject) object).eContainer();
						}
						throw new VMException(frame, String.format(
								"Cannot retrieve immediate composite for regular objects: %s",
								object));
					}
		});
		createOperation(false, "refGet", OclAnyType, OclAnyType,
				new String[][][]{{{"propname"}, StringType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							final String propname = (String) frame.getLocal(0, 1);
							final EObject eo = (EObject) object;
							final EClass ecls = eo.eClass();
							final EStructuralFeature sf = ecls.getEStructuralFeature(propname);
							if (sf == null) {
								throw new VMException(frame, String.format(
										"Cannot find property %s::%s", ecls.getName(), propname));
							}
							return ((EObject) object).eGet(sf);
						}
						throw new VMException(frame, String.format(
								"Cannot retrieve properties for regular objects: %s",
								object));
					}
		});
		createOperation(false, "refSet", OclAnyType, OclAnyType,
				new String[][][]{{{"propname"}, StringType}, {{"value"}, OclAnyType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							final String propname = (String) frame.getLocal(0, 1);
							final Object value = frame.getLocal(0, 2);
							final EObject eo = (EObject) object;
							final EClass ecls = eo.eClass();
							final EStructuralFeature sf = ecls.getEStructuralFeature(propname);
							if (sf == null) {
								throw new VMException(frame, String.format(
										"Cannot find property %s::%s", ecls.getName(), propname));
							}
							((EObject) object).eSet(sf, value);
							return null;
						}
						throw new VMException(frame, String.format(
								"Cannot set properties for regular objects: %s",
								object));
					}
		});
		createOperation(false, "resolve", OclAnyType, OclAnyType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						if (object instanceof EObject) {
							final ExecEnv env = frame.getEnv();
							final Field traces = env.findStaticField(env.eClass(), "traces");
							final TraceLinkSet tls = (TraceLinkSet) traces.getStaticValue(frame);
							final SourceElement se = tls.getDefaultSourceElement((EObject) object);
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
		createOperation(false, "resolve", JavaCollectionType, SequenceType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@SuppressWarnings("unchecked")
					@Override
					public Object execute(StackFrame frame) {
						final Collection<Object> object = (Collection<Object>) frame.getLocal(0, 0);
						return new ResolveList(object, frame);
					}
		});
		createOperation(false, "=~", JavaCollectionType, BooleanType,
				new String[][][]{{{"o"}, OclAnyType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Collection<?> o = (Collection<?>) frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						if (o2 instanceof Collection<?>) {
							return o.containsAll((Collection<?>) o2);
						}
						return o.contains(o2);
					}
		});
		createOperation(false, "=~|", JavaCollectionType, BooleanType,
				new String[][][]{{{"o"}, OclAnyType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final Collection<?> o = (Collection<?>) frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						if (o2 instanceof Collection<?>) {
							return o.containsAll((Collection<?>) o2);
						}
						return o.contains(o2);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// JavaList
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "=~|", JavaListType, BooleanType,
				new String[][][]{{{"o"}, OclAnyType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final List<?> o = (List<?>) frame.getLocal(0, 0);
						final Object o2 = frame.getLocal(0, 1);
						if (o2 instanceof Collection<?>) {
							final Collection<?> coll2 = (Collection<?>) o2;
							final int sizediff = o.size() - coll2.size();
							if (sizediff < 0) {
								return false;
							} else {
								return o.subList(sizediff, o.size()).containsAll(coll2);
							}
						}
						if (o.size() > 0) {
							final Object last = o.get(o.size()-1);
							return last==null ? o2==null : last.equals(o2);
						}
						return false;
					}
		});
		/////////////////////////////////////////////////////////////////////
		// ExecEnv
		/////////////////////////////////////////////////////////////////////
		createOperation(true, "resolveTemp", ExecEnvType, OclAnyType,
				new String[][][]{{{"var"}, OclAnyType}, {{"target_pattern_name"}, StringType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(final StackFrame frame) {
						final Object object = frame.getLocal(0, 0);
						final String name = (String) frame.getLocal(0, 1);
						if (object instanceof EObject) {
							final ExecEnv env = frame.getEnv();
							final Field traces = env.findStaticField(env.eClass(), "traces");
							final TraceLinkSet tls = (TraceLinkSet) traces.getStaticValue(frame);
							final SourceElement se = tls.getDefaultSourceElement((EObject) object);
							if (se != null) {
								final TargetElement te = se.getSourceOf().getTargetElement(name);
								if (te != null) {
									return te.getObject();
								}
							}
						} else if (object instanceof List<?>) {
							final ExecEnv env = frame.getEnv();
							final Field traces = env.findStaticField(env.eClass(), "traces");
							final TraceLinkSet tls = (TraceLinkSet) traces.getStaticValue(frame);
							final SourceElementList sel = tls.getDefaultSourceElements((List<?>) object);
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
		createOperation(false, "allInstances", ClassType, SequenceType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final EClass c = (EClass) frame.getLocal(0, 0);
						return EMFTVMUtil.findAllInstances(frame.getEnv(), c);
					}
		});
		createOperation(false, "allInstancesFrom", ClassType, SequenceType,
				new String[][][]{{{"metamodel"}, StringType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						final EClass c = (EClass) frame.getLocal(0, 0);
						final String mm = (String) frame.getLocal(0, 1);
						return EMFTVMUtil.findAllInstIn(frame.getEnv(), c, mm);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Real
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "+", RealType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) + (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "+", RealType, RealType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) + (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", RealType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) - (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", RealType, RealType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) - (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", RealType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) * (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", RealType, RealType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) * (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "neg", RealType, RealType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return - (Double) frame.getLocal(0, 0);
					}
		});
		createOperation(false, "/", RealType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) / (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", RealType, RealType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) / (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "abs", RealType, RealType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.abs((Double) frame.getLocal(0, 0));
					}
		});
		createOperation(false, "floor", RealType, IntegerType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Double.valueOf(Math.floor((Double) frame.getLocal(0, 0))).intValue();
					}
		});
		createOperation(false, "round", RealType, IntegerType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Double.valueOf(Math.round((Double) frame.getLocal(0, 0))).intValue();
					}
		});
		createOperation(false, "max", RealType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.max((Double) frame.getLocal(0, 0), (Double) frame.getLocal(0, 1));
					}
		});
		createOperation(false, "max", RealType, RealType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.max((Double) frame.getLocal(0, 0), (Integer) frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", RealType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.min((Double) frame.getLocal(0, 0), (Double) frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", RealType, RealType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.min((Double) frame.getLocal(0, 0), (Integer) frame.getLocal(0, 1));
					}
		});
		createOperation(false, "<", RealType, BooleanType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) < (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<", RealType, BooleanType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) < (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", RealType, BooleanType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) > (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", RealType, BooleanType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) > (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", RealType, BooleanType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) <= (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", RealType, BooleanType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) <= (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", RealType, BooleanType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) >= (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", RealType, BooleanType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Double) frame.getLocal(0, 0) >= (Integer) frame.getLocal(0, 1);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// Integer
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "neg", IntegerType, IntegerType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return - (Integer) frame.getLocal(0, 0);
					}
		});
		createOperation(false, "+", IntegerType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) + (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "+", IntegerType, IntegerType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) + (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", IntegerType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) - (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "-", IntegerType, IntegerType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) - (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", IntegerType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) * (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "*", IntegerType, IntegerType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) * (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", IntegerType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) / (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "/", IntegerType, RealType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((Integer) frame.getLocal(0, 0)).doubleValue() / (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "abs", IntegerType, IntegerType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.abs((Integer) frame.getLocal(0, 0));
					}
		});
		createOperation(false, "div", IntegerType, IntegerType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) / (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "mod", IntegerType, IntegerType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) % (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "max", IntegerType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.max((Integer) frame.getLocal(0, 0), (Double) frame.getLocal(0, 1));
					}
		});
		createOperation(false, "max", IntegerType, IntegerType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.max((Integer) frame.getLocal(0, 0), (Integer) frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", IntegerType, RealType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.min((Integer) frame.getLocal(0, 0), (Double) frame.getLocal(0, 1));
					}
		});
		createOperation(false, "min", IntegerType, IntegerType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Math.min((Integer) frame.getLocal(0, 0), (Integer) frame.getLocal(0, 1));
					}
		});
		createOperation(false, "<", IntegerType, BooleanType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) < (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<", IntegerType, BooleanType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) < (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", IntegerType, BooleanType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) > (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">", IntegerType, BooleanType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) > (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", IntegerType, BooleanType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) <= (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "<=", IntegerType, BooleanType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) <= (Integer) frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", IntegerType, BooleanType,
				new String[][][]{{{"r"}, RealType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) >= (Double) frame.getLocal(0, 1);
					}
		});
		createOperation(false, ">=", IntegerType, BooleanType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (Integer) frame.getLocal(0, 0) >= (Integer) frame.getLocal(0, 1);
					}
		});
		/////////////////////////////////////////////////////////////////////
		// String
		/////////////////////////////////////////////////////////////////////
		createOperation(false, "+", StringType, StringType,
				new String[][][]{{{"s"}, StringType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return (String) frame.getLocal(0, 0) + (String) frame.getLocal(0, 1);
					}
		});
		createOperation(false, "size", StringType, IntegerType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((String) frame.getLocal(0, 0)).length();
					}
		});
		createOperation(false, "substring", StringType, StringType,
				new String[][][]{{{"lower"}, IntegerType}, {{"upper"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((String) frame.getLocal(0, 0)).substring(
								(Integer) frame.getLocal(0, 1) - 1,
								(Integer) frame.getLocal(0, 2));
					}
		});
		createOperation(false, "toInteger", StringType, IntegerType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Integer.parseInt((String) frame.getLocal(0, 0));
					}
		});
		createOperation(false, "toReal", StringType, RealType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Double.parseDouble((String) frame.getLocal(0, 0));
					}
		});
		createOperation(false, "indexOf", StringType, IntegerType,
				new String[][][]{{{"s"}, StringType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((String) frame.getLocal(0, 0)).indexOf((String) frame.getLocal(0, 1)) + 1;
					}
		});
		createOperation(false, "lastIndexOf", StringType, IntegerType,
				new String[][][]{{{"s"}, StringType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return ((String) frame.getLocal(0, 0)).lastIndexOf((String) frame.getLocal(0, 1)) + 1;
					}
		});
		createOperation(false, "at", StringType, StringType,
				new String[][][]{{{"i"}, IntegerType}}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return String.valueOf(((String) frame.getLocal(0, 0)).charAt((Integer) frame.getLocal(0, 1) - 1));
					}
		});
		createOperation(false, "characters", StringType, SequenceType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						LazyList<String> seq = new LazyList<String>();
						for (char c : ((String) frame.getLocal(0, 0)).toCharArray()) {
							seq = seq.append(String.valueOf(c));
						}
						return seq;
					}
		});
		createOperation(false, "toBoolean", StringType, BooleanType,
				new String[][][]{}, 
				new CodeBlockImpl() {
					@Override
					public Object execute(StackFrame frame) {
						return Boolean.parseBoolean((String) frame.getLocal(0, 0));
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
