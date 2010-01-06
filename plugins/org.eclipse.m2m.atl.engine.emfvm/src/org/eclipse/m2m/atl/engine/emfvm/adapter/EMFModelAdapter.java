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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.engine.emfvm.Messages;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.EnumLiteral;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.HasFields;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclType;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclUndefined;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

/**
 * The model adapter dedicated to EMF.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFModelAdapter implements IModelAdapter {

	private boolean allowInterModelReferences;

	/**
	 * Creates an EMF model adapter.
	 */
	public EMFModelAdapter() {
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

	// fix 255613
	/**
	 * Returns the literal matching the given name or literal.
	 * 
	 * @param eEnum
	 *            the enumeration
	 * @param id
	 *            the name or the literal
	 * @return the literal
	 */
	public static EEnumLiteral getEENumLiteral(EEnum eEnum, String id) {
		EEnumLiteral ret = eEnum.getEEnumLiteralByLiteral(id);
		if (ret == null) {
			ret = eEnum.getEEnumLiteral(id);
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
		} else if (value instanceof EList<?>) {
			return ArrayList.class;
		} else {
			return value.getClass();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#prettyPrint(org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv,
	 *      java.io.PrintStream, java.lang.Object)
	 */
	public boolean prettyPrint(ExecEnv execEnv, PrintStream out, Object value) {
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
			final IModel model = execEnv.getModelOf(eo);
			if (model != null) {
				out.print(execEnv.getNameOf(model));
			} else {
				out.print("<unknown>"); //$NON-NLS-1$
			}
			out.print('!');
			out.print(getNameOf(eo));
			return true;
		} else if (value instanceof EList<?>) {
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

	private void registerOperation(Map<String, Operation> map, Operation oper) {
		map.put(oper.getName(), oper);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#registerVMTypeOperations(java.util.Map)
	 */
	public void registerVMTypeOperations(Map<Object, Map<String, Operation>> vmTypeOperations) {
		// Object
		Map<String, Operation> operationsByName = vmTypeOperations.get(Object.class);
		registerOperation(operationsByName, new Operation(2, "=") { //$NON-NLS-1$ 
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
							return Boolean.valueOf(localVars[1].equals(localVars[0]));
						}
						return Boolean.valueOf(localVars[0].equals(localVars[1]));
					}
				});
		registerOperation(operationsByName, new Operation(2, "refGetValue") { //$NON-NLS-1$ 
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
		registerOperation(operationsByName, new Operation(3, "refSetValue") { //$NON-NLS-1$ 
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
		// TODO document
		registerOperation(operationsByName, new Operation(3, "refUnSetValue") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[0] instanceof EObject) {
							EMFModelAdapter.this.unSet(frame, (EObject)localVars[0], (String)localVars[1]);
						} else {
							((HasFields)localVars[0]).unset(frame, localVars[1]);
						}
						return localVars[0];
					}
				});
		registerOperation(operationsByName, new Operation(1, "oclType") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[0] instanceof EObject) {
							return ((EObject)localVars[0]).eClass();
						}
						return OclType.getOclTypeFromObject(localVars[0]);
					}
				});
		registerOperation(operationsByName, new Operation(2, "oclIsTypeOf") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[1] instanceof Class<?>) {
							return Boolean.valueOf(localVars[1].equals(localVars[0].getClass()));
						} else if (localVars[1] instanceof EClass) {
							if (localVars[0] instanceof EObject) {
								return Boolean.valueOf(localVars[1].equals(((EObject)localVars[0]).eClass()));
							} else {
								return Boolean.FALSE;
							}
						} else if (localVars[1] instanceof OclType) {
							return Boolean.valueOf(((OclType)localVars[1]).equals(OclType
									.getOclTypeFromObject(localVars[0])));
						} else {
							throw new VMException(frame, Messages.getString(
									"EMFModelAdapter.UNHANDLEDTYPE", localVars[1])); //$NON-NLS-1$
						}
					}
				});
		registerOperation(operationsByName, new Operation(2, "oclIsKindOf") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						if (localVars[1] instanceof Class<?>) {
							return Boolean.valueOf(((Class<?>)localVars[1]).isInstance(localVars[0]));
						} else if (localVars[1] instanceof EClass) {
							return Boolean.valueOf(((EClass)localVars[1]).isInstance(localVars[0]));
						} else if (localVars[1] instanceof OclType) {
							OclType selfType = OclType.getOclTypeFromObject(localVars[0]);
							return Boolean.valueOf(selfType.conformsTo((OclType)localVars[1]));
						} else {
							throw new VMException(frame, Messages.getString(
									"EMFModelAdapter.UNHANDLEDTYPE", localVars[1])); //$NON-NLS-1$
						}
					}
				});
		registerOperation(operationsByName, new Operation(1, "refImmediateComposite") { //$NON-NLS-1$ 
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
		registerOperation(operationsByName, new Operation(2, "allInstancesFrom") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						IModel model = frame.getExecEnv().getModel(localVars[1]);
						if (model == null) {
							throw new VMException(frame, Messages.getString(
									"EMFModelAdapter.MODELNOTFOUND", localVars[1])); //$NON-NLS-1$
						}
						return model.getElementsByType(localVars[0]);
					}
				});
		registerOperation(operationsByName, new Operation(1, "allInstances") { //$NON-NLS-1$ 
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
							// if ((!model.isTarget()) && (model.getReferenceModel().isModelOf(ec))) {
							// ret.addAll(model.getElementsByType(ec));
							// }
							if (model.getReferenceModel().isModelOf(ec)) {
								ret.addAll(model.getElementsByType(ec));
							}
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(3, "registerHelperAttribute") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						String name = (String)localVars[1];
						String initOperationName = (String)localVars[2];
						frame.getExecEnv().registerHelperAttribute(localVars[0], name, initOperationName);
						return null;
					}
				});
		registerOperation(operationsByName, new Operation(1, "newInstance") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						EClass ec = (EClass)localVars[0];
						return frame.getExecEnv().newElement(frame, ec);
					}
				});
		registerOperation(operationsByName, new Operation(2, "newInstanceIn") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						EClass ec = (EClass)localVars[0];
						String modelName = (String)localVars[1];
						return frame.getExecEnv().newElementIn(frame, ec, modelName);
					}
				});
		registerOperation(operationsByName, new Operation(3, "getInstanceById") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						final Object[] localVars = frame.getLocalVars();
						final EMFModel model = (EMFModel)frame.getExecEnv().getModel(localVars[1]);
						final Resource resource = model.getResource();
						Object ret = resource.getEObject((String)localVars[2]);
						if (ret == null) {
							ret = OclUndefined.SINGLETON;
						}
						return ret;
					}
				});
		registerOperation(operationsByName, new Operation(2, "conformsTo") { //$NON-NLS-1$ 
					@Override
					public Object exec(AbstractStackFrame frame) {
						Object[] localVars = frame.getLocalVars();
						return Boolean.valueOf(((EClass)localVars[1]).isSuperTypeOf((EClass)localVars[0]));
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
		Object ret = null;
		if (modelElement instanceof Collection<?>) {
			throw new VMException(frame, Messages.getString("EMFModelAdapter.GET_ON_COLLECTION")); //$NON-NLS-1$		
		}
		if (modelElement == null || modelElement.equals(OclUndefined.SINGLETON)) {
			throw new VMException(frame, Messages.getString("EMFModelAdapter.GET_PROBLEM", name)); //$NON-NLS-1$
		} else {
			EObject eo = (EObject)modelElement;
			EClass ec = eo.eClass();

			if ((frame != null) && frame.getExecEnv().isHelper(ec, name)) {
				ret = frame.getExecEnv().getHelperValue(frame, ec, eo, name);
			} else if ("__xmiID__".equals(name)) { //$NON-NLS-1$
				ret = getID(eo);
			} else {
				EStructuralFeature sf = ec.getEStructuralFeature(name);
				if (sf == null) {
					throw new VMException(frame, Messages.getString(
							"EMFModelAdapter.FEATURE_NOT_EXISTS", new Object[] {name, ec.getName()})); //$NON-NLS-1$
				}
				Object val = eo.eGet(sf);
				if (val == null) {
					val = OclUndefined.SINGLETON;
				} else if (val instanceof Enumerator) {
					val = new EnumLiteral(val.toString());
				} else if (val instanceof Collection<?>) {
					if (sf.getEType() instanceof EEnum) {
						Collection<Object> c = new ArrayList<Object>();
						for (Iterator<?> i = ((Collection<?>)val).iterator(); i.hasNext();) {
							Object v = i.next();
							c.add(new EnumLiteral(v.toString()));
						}
						val = c;
					}
				}
				ret = val;
			}
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

		if ("__xmiID__".equals(name)) { //$NON-NLS-1$
			setID(eo, value);
			return;
		}

		final EStructuralFeature feature = eo.eClass().getEStructuralFeature(name);

		if (frame != null) {
			if (frame.getExecEnv().isWeavingHelper(eo.eClass(), name)) {
				frame.getExecEnv().setHelperValue(modelElement, name, value);
				return;
			}
		}

		if (feature == null) {
			throw new VMException(frame, Messages.getString(
					"EMFModelAdapter.FEATURE_NOT_EXISTS", name, eo.eClass().getName())); //$NON-NLS-1$
		}

		if (!feature.isChangeable()) {
			throw new VMException(frame, Messages.getString("EMFModelAdapter.FEATURE_NOT_CHANGEABLE", name)); //$NON-NLS-1$
		}

		if (settableValue instanceof Integer) {
			String targetType = feature.getEType().getInstanceClassName();
			if ("java.lang.Double".equals(targetType) || "double".equals(targetType)) { //$NON-NLS-1$ //$NON-NLS-2$
				settableValue = new Double(((Integer)value).doubleValue());
			} else if ("java.lang.Float".equals(targetType) || "float".equals(targetType)) { //$NON-NLS-1$ //$NON-NLS-2$
				settableValue = new Float(((Integer)value).floatValue());
			}
		} else if (settableValue instanceof Double) {
			String targetType = feature.getEType().getInstanceClassName();
			if ("java.lang.Float".equals(targetType) || "float".equals(targetType)) { //$NON-NLS-1$//$NON-NLS-2$
				settableValue = new Float(((Double)value).floatValue());
			}
		}

		EClassifier type = feature.getEType();
		boolean targetIsEnum = type instanceof EEnum;

		try {
			ExecEnv execEnv = frame.getExecEnv();

			Object oldValue = eo.eGet(feature);
			if (oldValue instanceof Collection) {
				Collection<Object> oldCol = (Collection<Object>)oldValue;
				if (settableValue instanceof Collection) {
					if (targetIsEnum) {
						EEnum eenum = (EEnum)type;
						for (Iterator<?> i = ((Collection<?>)settableValue).iterator(); i.hasNext();) {
							Object v = i.next();
							oldCol.add(getEENumLiteral(eenum, v.toString()).getInstance());
						}
					} else {
						for (Iterator<?> i = ((Collection<?>)settableValue).iterator(); i.hasNext();) {
							Object v = i.next();
							if (v instanceof EObject) {
								if (execEnv.getModelOf(eo) == execEnv.getModelOf(v)) {
									oldCol.add(v);
								} else if (allowInterModelReferences && feature instanceof EReference) {
									EReference ref = (EReference)feature;
									if (!ref.isContainer() && !ref.isContainment()) {
										oldCol.add(v);
									} else {
										// containment references cannot span across models
									}
								}
							} else {
								oldCol.add(v);
							}
						}
					}
				} else {
					if (targetIsEnum) {
						EEnum eenum = (EEnum)type;
						oldCol.add(getEENumLiteral(eenum, settableValue.toString()).getInstance());
					} else if (allowInterModelReferences || !(settableValue instanceof EObject)) {
						oldCol.add(settableValue);
					} else { // (!allowIntermodelReferences) && (value instanceof EObject)
						if (execEnv.getModelOf(eo) == execEnv.getModelOf(settableValue)) {
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
						EEnumLiteral literal = getEENumLiteral(eenum, settableValue.toString());
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
					if (execEnv.getModelOf(eo) == execEnv.getModelOf(settableValue)) {
						eo.eSet(feature, settableValue);
					}
				}
			}
		} catch (Throwable e) {
			throw new VMException(frame, e.getMessage(), e);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#unSet(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.Object, java.lang.String)
	 */
	public void unSet(AbstractStackFrame frame, Object modelElement, String name) {
		final EObject eo = (EObject)modelElement;
		final EStructuralFeature feature = eo.eClass().getEStructuralFeature(name);

		if (feature == null) {
			throw new VMException(frame, Messages.getString(
					"EMFModelAdapter.FEATURE_NOT_EXISTS", name, eo.eClass().getName())); //$NON-NLS-1$
		}
		eo.eUnset(feature);
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
					"EMFModelAdapter.UNABLE_TO_INVOKE_OPERATION", method.getName(), self), e); //$NON-NLS-1$
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			Exception toReport = (cause instanceof Exception) ? (Exception)cause : e;
			throw new VMException(null, Messages.getString(
					"EMFModelAdapter.INVOKE_OPERATION_ERROR", method.getName(), self), toReport); //$NON-NLS-1$
		}
		return res == null && method.getReturnType() != void.class ? OclUndefined.SINGLETON : res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#finalizeModel(org.eclipse.m2m.atl.core.IModel)
	 */
	public void finalizeModel(IModel model) {
		if (model.isTarget()) {
			((EMFModel)model).commitToResource();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#getID(java.lang.Object)
	 */
	public Object getID(Object element) {
		if (element instanceof EObject) {
			EObject eo = (EObject)element;
			return eo.eResource().getURIFragment(eo);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#setID(java.lang.Object, java.lang.Object)
	 */
	public void setID(Object element, Object id) {
		if (element instanceof EObject) {
			EObject eo = (EObject)element;
			Resource resource = eo.eResource();
			if (resource instanceof XMIResource) {
				XMIResource xmiResource = (XMIResource)resource;
				// WARNING: Allowed manual setting of XMI ID for the current model element
				// This operation is advised against but seems necessary of some special case
				ATLLogger
						.warning("Manual setting of " + getNameOf(eo) + ":" + eo.eClass().getName() + " XMI ID."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				xmiResource.setID(eo, id.toString());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#isModelElement(java.lang.Object)
	 */
	public boolean isModelElement(Object o) {
		return o instanceof EObject;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.adapter.IModelAdapter#isMetametaElement(java.lang.Object)
	 */
	public boolean isMetametaElement(Object element) {
		if (element instanceof EObject) {
			return ((EObject)element).eClass().equals(element);
		}
		return false;
	}

}
