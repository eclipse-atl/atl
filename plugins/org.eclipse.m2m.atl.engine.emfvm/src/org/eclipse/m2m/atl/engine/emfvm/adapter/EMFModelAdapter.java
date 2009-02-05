/**
 * Copyright (c) 2008 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     William Piers - oclType implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 */
package org.eclipse.m2m.atl.engine.emfvm.adapter;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.engine.emfvm.Messages;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.HasFields;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclType;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclUndefined;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

/**
 * The model adapter dedicated to EMF.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@univ-nantes.fr">Mikael Barbero</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFModelAdapter implements IModelAdapter {

	private Map<Resource, EMFModel> modelsByResource;

	private boolean allowInterModelReferences;

	private ExecEnv execEnv;

	/**
	 * Creates an EMF model adapter.
	 * 
	 * @param execEnv
	 *            the execution environment
	 */
	public EMFModelAdapter(ExecEnv execEnv) {
		this.execEnv = execEnv;
		modelsByResource = new HashMap<Resource, EMFModel>();
		for (Iterator<String> i = execEnv.getModelsByName().keySet().iterator(); i.hasNext();) {
			String name = i.next();
			EMFModel model = (EMFModel)execEnv.getModelsByName().get(name);
			modelsByResource.put(model.getResource(), model);
		}
	}

	/**
	 * Sets "allow inter-model references" for this model adapter.
	 * 
	 * @param allowInterModelRefs
	 *            the parameter value
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public void setAllowInterModelReferences(boolean allowInterModelRefs) {
		allowInterModelReferences = allowInterModelRefs;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#getModelOf(java.lang.Object)
	 */
	public IModel getModelOf(Object element) {
		return modelsByResource.get(((EObject)element).eResource());
	}

	/**
	 * Returns the name of an eObject.
	 * 
	 * @param eo
	 *            the eObject
	 * @return the name of an eObject
	 */
	public static Object getNameOf(EObject eo) {
		Object ret = null;

		final EClass ec = eo.eClass();
		final EStructuralFeature sf = ec.getEStructuralFeature("name"); //$NON-NLS-1$
		if (sf != null) {
			ret = eo.eGet(sf);
		}
		if (ret == null) {
			ret = "<unnamed>"; //$NON-NLS-1$
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#getSupertypes(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getSupertypes(Object type) {
		List ret = null;

		if (type != null) {
			if (type instanceof EClass) {
				ret = ((EClass)type).getESuperTypes();
				if (ret.size() == 0) { // extends OclAny
					ret = Arrays.asList(new Class[] {Object.class});
				} else {
					// invert list to comply with regular ATL VM behaviour
					final List sts = ret;
					ret = new ArrayList(sts.size());
					for (int i = sts.size() - 1; i >= 0; i--) {
						ret.add(sts.get(i));
					}
				}
			} else {
				ret = OclType.getSupertypes().get(type);
				if (ret == null) {
					// Support for Java subclasses that do not correspond to OCL subtypes
					Class sc = ((Class)type).getSuperclass();
					if (sc != null) {
						ret = Arrays.asList(new Class[] {sc});
					}
				}
			}
		}

		if (ret == null) {
			ret = Collections.EMPTY_LIST;
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#getType(java.lang.Object)
	 */
	public Object getType(Object value) {
		if (value instanceof EObject) {
			return ((EObject)value).eClass();
		} else if (value instanceof EList) {
			return ArrayList.class;
		} else {
			return value.getClass();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#prettyPrint(java.io.PrintStream,
	 *      java.lang.Object)
	 */
	public boolean prettyPrint(PrintStream out, Object value) {
		if (value instanceof EClass) {
			final EClass c = (EClass)value;
			final String mName = execEnv.getModelNameOf(c);
			if (mName != null) {
				out.print(mName);
			} else {
				out.print("<unknown>"); //$NON-NLS-1$
			}
			out.print('!');
			String name = c.getName();
			if (name == null) {
				name = "<unnamed>"; //$NON-NLS-1$
			}
			out.print(name);
			return true;
		} else if (value instanceof EObject) {
			final EObject eo = (EObject)value;
			final IModel model = getModelOf(eo);
			if (model != null) {
				out.print(execEnv.getNameOf(model));
			} else {
				out.print("<unknown>"); //$NON-NLS-1$
			}
			out.print('!');
			out.print(getNameOf(eo));
			out.print(':');
			if (model != null) {
				final IReferenceModel mModel = model.getReferenceModel();
				out.print(execEnv.getNameOf(mModel));
				out.print('!');
				String name = eo.eClass().getName();
				if (name == null) {
					name = "<unnamed>"; //$NON-NLS-1$
				}
				out.print(name);
			} else {
				prettyPrint(out, eo.eClass());
			}
			return true;
		} else if (value instanceof EList) {
			out.print("Sequence {"); //$NON-NLS-1$
			execEnv.prettyPrintCollection(out, (EList<?>)value);
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#registerVMSupertypes(java.util.Map)
	 */
	public void registerVMSupertypes(Map<Class<?>, List<Class<?>>> vmSupertypes) {
		// EClass extends EObject
		vmSupertypes.put(EClassImpl.class, Arrays.asList(new Class<?>[] {EObjectImpl.class}));
		// is necessary ? vmSupertypes.put(EObjectImpl.class, Arrays.asList(new Class[] {Object.class}));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#registerVMTypeOperations(java.util.Map)
	 */
	public void registerVMTypeOperations(Map<Object, Map<String, Operation>> vmTypeOperations) {
		// Object
		Map<String, Operation> operationsByName = vmTypeOperations.get(Object.class);
		operationsByName.put("=", new Operation(2) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						/*
						 * handle EMF enumeration literals by calling other end's equals() method. Other end
						 * can be Enumerator, in which case comparison is done according to EMF semantics.
						 * Other end can also be EnumLiteral, in which case EnumLiteral.equals() handles the
						 * comparison against EMF Enumerators.
						 */
						if (localVars[0] instanceof Enumerator) {
							return new Boolean(localVars[1].equals(localVars[0]));
						}
						return new Boolean(localVars[0].equals(localVars[1]));
					}
				});
		operationsByName.put("refGetValue", new Operation(2) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[0] instanceof EObject) {
							return EMFModelAdapter.this.get(frame, (EObject)localVars[0],
									(String)localVars[1]);
						} else {
							return ((HasFields)localVars[0]).get(frame, localVars[1]);
						}
					}
				});
		operationsByName.put("refSetValue", new Operation(3) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[0] instanceof EObject) {
							EMFModelAdapter.this.set(frame, (EObject)localVars[0], (String)localVars[1],
									localVars[2]);
						} else {
							((HasFields)localVars[0]).set(frame, localVars[1], localVars[2]);
						}
						return localVars[0];
					}
				});
		operationsByName.put("oclType", new Operation(1) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[0] instanceof EObject) {
							return ((EObject)localVars[0]).eClass();
						}
						return OclType.getOclTypeFromObject(localVars[0]);
					}
				});
		operationsByName.put("oclIsTypeOf", new Operation(2) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[1] instanceof Class) {
							return new Boolean(localVars[1].equals(localVars[0].getClass()));
						} else if (localVars[1] instanceof EClass) {
							if (localVars[0] instanceof EObject) {
								return new Boolean(localVars[1].equals(((EObject)localVars[0]).eClass()));
							} else {
								return Boolean.FALSE;
							}
						} else if (localVars[1] instanceof OclType) {
							return new Boolean(((OclType)localVars[1]).equals(OclType
									.getOclTypeFromObject(localVars[0])));
						} else {
							throw new VMException(frame, Messages.getString(
									"EMFModelAdapter.UNHANDLEDTYPE", new Object[] {localVars[1]})); //$NON-NLS-1$
						}
					}
				});
		operationsByName.put("oclIsKindOf", new Operation(2) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[1] instanceof Class) {
							return new Boolean(((Class<?>)localVars[1]).isInstance(localVars[0]));
						} else if (localVars[1] instanceof EClass) {
							return new Boolean(((EClass)localVars[1]).isInstance(localVars[0]));
						} else if (localVars[1] instanceof OclType) {
							OclType selfType = OclType.getOclTypeFromObject(localVars[0]);
							return new Boolean(selfType.conformsTo((OclType)localVars[1]));
						} else {
							throw new VMException(frame, Messages.getString(
									"EMFModelAdapter.UNHANDLEDTYPE", new Object[] {localVars[1]})); //$NON-NLS-1$
						}
					}
				});
		operationsByName.put("refImmediateComposite", new Operation(1) { //$NON-NLS-1$ 
					@Override
					// TODO: should only exist on EObject
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[0] instanceof EObject) {
							Object ret = ((EObject)localVars[0]).eContainer();
							if (ret == null) {
								ret = OclUndefined.SINGLETON;
							}
							return ret;
						} else {
							throw new VMException(frame, Messages
									.getString("EMFModelAdapter.REFIMMEDIATECOMPOSITE")); //$NON-NLS-1$
						}
					}
				});
		// EClass
		operationsByName = new HashMap<String, Operation>();
		vmTypeOperations.put(EcorePackage.eINSTANCE.getEClass(), operationsByName);
		operationsByName.put("allInstancesFrom", new Operation(2) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						IModel model = frame.getExecEnv().getModel(localVars[1]);
						if (model == null) {
							throw new VMException(frame, Messages.getString(
									"EMFModelAdapter.MODELNOTFOUND", new Object[] {localVars[1]})); //$NON-NLS-1$
						}
						return model.getElementsByType(localVars[0]);
					}
				});
		operationsByName.put("allInstances", new Operation(1) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();

						// could be a Set (actually was) instead of an OrderedSet
						Set<Object> ret = new LinkedHashSet<Object>();
						EClass ec = (EClass)localVars[0];
						// Model rm = getModelOf(ec); // this is not possible when considering referenced
						// resources!
						for (Iterator<IModel> i = frame.getExecEnv().getModelsByName().values().iterator(); i
								.hasNext();) {
							IModel model = i.next();
							if ((!model.isTarget()) && (model.getReferenceModel().isModelOf(ec))) {
								ret.addAll(model.getElementsByType(ec));
							}
						}
						return ret;
					}
				});
		operationsByName.put("registerHelperAttribute", new Operation(3) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						String name = (String)localVars[1];
						String initOperationName = (String)localVars[2];
						frame.getExecEnv().registerHelperAttribute(localVars[0], name, initOperationName);
						return null;
					}
				});
		operationsByName.put("newInstance", new Operation(1) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						EClass ec = (EClass)localVars[0];
						return execEnv.newElement(frame, ec);
					}
				});
		operationsByName.put("newInstanceIn", new Operation(2) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						EClass ec = (EClass)localVars[0];
						String modelName = (String)localVars[1];
						return execEnv.newElementIn(frame, ec, modelName);
					}
				});
		operationsByName.put("getInstanceById", new Operation(3) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						final Object[] localVars = frame.getLocalVars();
						final EMFModel model = (EMFModel)execEnv.getModel(localVars[1]);
						final Resource resource = model.getResource();
						Object ret = resource.getEObject((String)localVars[2]);
						// for (Iterator<Resource> iterator = model.getResources().iterator(); iterator
						// .hasNext()
						// && ret == null;) {
						// Resource resource = iterator.next();
						// ret = resource.getEObject((String)localVars[2]);
						// }
						if (ret == null) {
							ret = OclUndefined.SINGLETON;
						}
						return ret;
					}
				});
		operationsByName.put("conformsTo", new Operation(2) { //$NON-NLS-1$
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						return new Boolean(((EClass)localVars[1]).isSuperTypeOf((EClass)localVars[0]));
					}
				});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#get(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object, java.lang.String)
	 */
	public Object get(AbstractStackFrame frame, Object modelElement, String name) {
		EObject eo = (EObject)modelElement;
		Object ret = null;

		EClass ec = eo.eClass();

		if ((frame != null) && execEnv.isHelper(ec, name)) {
			ret = execEnv.getHelperValue(frame, ec, eo, name);
		} else if ("__xmiID__".equals(name)) { //$NON-NLS-1$
			ret = eo.eResource();
		} else {
			EStructuralFeature sf = ec.getEStructuralFeature(name);
			if (sf == null) {
				throw new VMException(frame, Messages.getString(
						"EMFModelAdapter.FEATURE_NOT_EXISTS", new Object[] {name, ec.getName()})); //$NON-NLS-1$
			}
			Object val = eo.eGet(sf);
			if (val == null) {
				val = OclUndefined.SINGLETON;
			}
			ret = val;
		}
		return ret;
	}

	// TODO analyze:
	// - could be different (faster?) when same metamodel in source and target
	// - may be too permissive (any value for which toString returns a valid literal name works)
	// - should flatten nested collections
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#set(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object, java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public void set(AbstractStackFrame frame, Object modelElement, String name, Object value) {
		Object settableValue = value;
		if (settableValue == null || value.equals(OclUndefined.SINGLETON)) {
			return;
		}

		final EObject eo = (EObject)modelElement;
		final EStructuralFeature feature = eo.eClass().getEStructuralFeature(name);

		if (frame != null) {
			if (execEnv.isWeavingHelper(eo.eClass(), name)) {
				execEnv.setHelperValue(frame, modelElement, name, value);
				return;
			}
		}

		if (feature == null) {
			throw new VMException(frame, Messages.getString(
					"EMFModelAdapter.FEATURE_NOT_EXISTS", new Object[] {name, eo.eClass().getName()})); //$NON-NLS-1$
		}

		// makes it possible to use an integer to set a floating point property
		if (settableValue instanceof Integer) {
			String targetType = feature.getEType().getInstanceClassName();
			if ("java.lang.Double".equals(targetType) || "java.lang.Float".equals(targetType)) { //$NON-NLS-1$ //$NON-NLS-2$
				settableValue = new Double(((Integer)value).doubleValue());
			}
		}

		EClassifier type = feature.getEType();
		boolean targetIsEnum = type instanceof EEnum;

		try {

			Object oldValue = eo.eGet(feature);
			if (oldValue instanceof Collection) {
				Collection<Object> oldCol = (Collection<Object>)oldValue;
				if (settableValue instanceof Collection) {
					if (targetIsEnum) {
						EEnum eenum = (EEnum)type;
						for (Iterator<?> i = ((Collection<?>)settableValue).iterator(); i.hasNext();) {
							Object v = i.next();
							//oldCol.add(eenum.getEEnumLiteral(v.toString()).getInstance());
							oldCol.add(eenum.getEEnumLiteralByLiteral(v.toString()).getInstance());
						}
					} else if (allowInterModelReferences) {
						oldCol.addAll((Collection<?>)settableValue);
					} else { // !allowIntermodelReferences
						for (Iterator<?> i = ((Collection<?>)settableValue).iterator(); i.hasNext();) {
							Object v = i.next();
							if (v instanceof EObject) {
								if (getModelOf(eo) == getModelOf(v)) {
									oldCol.add(v);
								}
							} else {
								oldCol.add(v);
							}
						}
					}
				} else {
					if (targetIsEnum) {
						EEnum eenum = (EEnum)type;
						oldCol.add(eenum.getEEnumLiteral(settableValue.toString()).getInstance());
					} else if (allowInterModelReferences || !(settableValue instanceof EObject)) {
						oldCol.add(settableValue);
					} else { // (!allowIntermodelReferences) && (value instanceof EObject)
						if (getModelOf(eo) == getModelOf(settableValue)) {
							oldCol.add(settableValue);
						}
					}
				}
			} else {
				if (settableValue instanceof Collection) {
					ATLLogger.warning(Messages.getString("EMFModelAdapter.ASSIGNMENTWARNING")); //$NON-NLS-1$
					Collection<?> c = (Collection<?>)settableValue;
					if (!c.isEmpty()) {
						settableValue = c.iterator().next();
					} else {
						settableValue = null;
					}
				}
				if (targetIsEnum) {
					EEnum eenum = (EEnum)type;
					if (settableValue != null) {
						EEnumLiteral literal = eenum.getEEnumLiteral(settableValue.toString());
						if (literal != null) {
							eo.eSet(feature, literal.getInstance());
						} else {
							throw new VMException(
									frame,
									Messages
											.getString(
													"EMFModelAdapter.LITERALERROR", new Object[] {settableValue, eenum.getName()})); //$NON-NLS-1$
						}
					}
				} else if (allowInterModelReferences || !(settableValue instanceof EObject)) {
					eo.eSet(feature, settableValue);
				} else { // (!allowIntermodelReferences) && (value intanceof EObject)
					if (getModelOf(eo) == getModelOf(settableValue)) {
						eo.eSet(feature, settableValue);
					}
				}
			}

		} catch (ClassCastException e) {
			throw new VMException(frame, e.getMessage(), e);
		} catch (ArrayStoreException e) {
			throw new VMException(frame, e.getMessage(), e);
		}


	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#delete(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object)
	 */
	public void delete(AbstractStackFrame frame, Object modelElement) {
		EObject eo = (EObject)modelElement;
		eo.eAdapters().clear();
		EcoreUtil.remove(eo);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#invoke(java.lang.reflect.Method,
	 *      java.lang.Object, java.lang.Object[])
	 */
	public Object invoke(Method method, Object self, Object[] arguments) {
		Object res = null;
		try {
			res = method.invoke(self, arguments);
		} catch (IllegalAccessException e) {
			throw new VMException(null, Messages.getString(
					"EMFModelAdapter.UNABLE_TO_INVOKE_OPERATION", new Object[] {method.getName(), self}), e); //$NON-NLS-1$
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			Exception toReport = (cause instanceof Exception) ? (Exception)cause : e;
			throw new VMException(
					null,
					Messages.getString(
							"EMFModelAdapter.INVOKE_OPERATION_ERROR", new Object[] {method.getName(), self}), toReport); //$NON-NLS-1$
		}
		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#notifyFinish()
	 */
	public void notifyFinish() {
		for (Iterator<IModel> it = execEnv.getModels(); it.hasNext();) {
			EMFModel model = (EMFModel)it.next();
			if (model.isTarget()) {
				model.commitToResource();
			}
		}
	}

}
