/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: EMFModelAdapter.java,v 1.1.2.3 2008/04/01 12:17:12 fjouault Exp $
 */

package org.eclipse.m2m.atl.engine.emfvm.emf;

import java.io.PrintStream;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.HasFields;
import org.eclipse.m2m.atl.engine.emfvm.lib.Model;
import org.eclipse.m2m.atl.engine.emfvm.lib.ModelAdapter;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclParametrizedType;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclType;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclUndefined;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;
import org.eclipse.m2m.atl.engine.emfvm.lib.ReferenceModel;
import org.eclipse.m2m.atl.engine.emfvm.lib.StackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.VMException;

/**
 * 
 * @author Frederic Jouault
 * @author Mikael Barbero
 *
 */
public class EMFModelAdapter implements ModelAdapter {

	private Map modelsByResource;
	
	private boolean allowInterModelReferences = false;

	// TODO: map this to corresponding option	public boolean supportUML2Stereotypes = false;
	public boolean supportUML2Stereotypes = false;
	
	private ExecEnv execEnv;
	
	public EMFModelAdapter(ExecEnv execEnv) {
		this.execEnv = execEnv;
		
		modelsByResource = new HashMap();
		for(Iterator i = execEnv.modelsByName.keySet().iterator() ; i.hasNext() ; ) {
			String name = (String)i.next();
			EMFModel model = (EMFModel)execEnv.modelsByName.get(name);
			modelsByResource.put(model.resource, model);
		}
	}

	/**
	 * Sets "allow inter-model references" for this model adapter.
	 * @param allowInterModelRefs
	 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
	 */
	public void setAllowInterModelReferences(boolean allowInterModelRefs) {
		allowInterModelReferences = allowInterModelRefs;
	}

	public Model getModelOf(Object element) {
		return (Model)modelsByResource.get(((EObject)element).eResource());
	}
	
	public static Object getNameOf(EObject eo) {
		Object ret = null;
		
		final EClass ec = eo.eClass();
		final EStructuralFeature sf = ec.getEStructuralFeature("name");
		if (sf != null) {
			ret = eo.eGet(sf);
		}
		if(ret == null) ret = "<unnamed>";

		return ret;
	}

	public List getSupertypes(Object type) {
		List ret = null;

		if(type != null) {
			if(type instanceof EClass) {
				ret = ((EClass)type).getESuperTypes();
				if(ret.size() == 0)	// extends OclAny
					ret = Arrays.asList(new Class[] {Object.class});
				else {
					// invert list to comply with regular ATL VM behaviour
					final List sts = ret;
					ret = new ArrayList(sts.size());
					for (int i = sts.size() - 1; i >= 0; i--) {
						ret.add(sts.get(i));
					}
				}
			} else {
				ret = (List)execEnv.supertypes.get(type);
				if(ret == null) {
					// Support for Java subclasses that do not correspond to OCL subtypes
					Class sc = ((Class)type).getSuperclass();
					if(sc != null) {
						ret = Arrays.asList(new Class[] {sc});
					}
				}
			}
		}

		if(ret == null) ret = Collections.EMPTY_LIST; 

		return ret;
	}

	public Object getType(Object value) {
		if(value instanceof EObject) {
			return ((EObject)value).eClass();
		} else if(value instanceof EList) {
			return ArrayList.class;
		} else {
			return value.getClass();
		}
	}

	public boolean prettyPrint(PrintStream out, Object value) {
		if(value instanceof EClass){
			final EClass c = (EClass)value;
			final String mName = execEnv.getModelNameOf(c);
			if(mName != null){
				out.print(mName);
			} else {
				out.print("<unknown>");
			}
			out.print('!');
			String name = c.getName();
			if(name == null)
				name = "<unnamed>";
			out.print(name);
			return true;
		} else if(value instanceof EObject) {
			final EObject eo = (EObject)value;
			final Model model = getModelOf(eo);
			if(model != null) {
				out.print((String) execEnv.getNameOf(model));
			} else {
				out.print("<unknown>");
			}
			out.print('!');
			out.print(getNameOf(eo));
			out.print(':');
			if(model != null) {
				final ReferenceModel mModel = model.getReferenceModel();
				out.print((String) execEnv.getNameOf(mModel));
				out.print('!');
				String name = eo.eClass().getName();
				if(name == null)
					name = "<unnamed>";
				out.print(name);
			} else {
				prettyPrint(out, eo.eClass());
			}
			return true;
		} else if(value instanceof EList) {
			out.print("Sequence {");
			execEnv.prettyPrintCollection(out, (Collection)value);
			return true;
		} 
		return false;
	}
	
	public void registerVMSupertypes(Map vmSupertypes) {
		// EClass extends EObject
		vmSupertypes.put(EClassImpl.class, Arrays.asList(new Class[] {EObjectImpl.class}));
		// is necessary ? vmSupertypes.put(EObjectImpl.class, Arrays.asList(new Class[] {Object.class}));
	}

	public void registerVMTypeOperations(Map vmTypeOperations) {
		// Object
		Map operationsByName = (Map)vmTypeOperations.get(Object.class);
		operationsByName.put("=", new Operation(2) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				/* handle EMF enumeration literals by calling other end's
				 * equals() method. Other end can be Enumerator, in which case
				 * comparison is done according to EMF semantics. Other end
				 * can also be EnumLiteral, in which case EnumLiteral.equals()
				 * handles the comparison against EMF Enumerators.
				 */
				if (localVars[0] instanceof Enumerator) {
					return new Boolean(localVars[1].equals(localVars[0]));
				}
				return new Boolean(localVars[0].equals(localVars[1]));					
			}
		});
		operationsByName.put("refGetValue", new Operation(2) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				if(localVars[0] instanceof EObject) {
					return EMFModelAdapter.this.get(frame, (EObject)localVars[0], (String)localVars[1]);
				} else {
					return ((HasFields)localVars[0]).get(frame, localVars[1]);
				}
			}
		});
		operationsByName.put("refSetValue", new Operation(3) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				if(localVars[0] instanceof EObject) {
					EMFModelAdapter.this.set(frame, (EObject)localVars[0], (String)localVars[1], localVars[2]);
				} else {
					((HasFields)localVars[0]).set(frame, localVars[1], localVars[2]);
				}
				return localVars[0];
			}
		});
		operationsByName.put("oclType", new Operation(1) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				if(localVars[0] instanceof EObject) {
					return ((EObject)localVars[0]).eClass();
				} else {
					throw new RuntimeException(".oclType not implemented for OCL library yet");
				}
			}
		});
		operationsByName.put("oclIsTypeOf", new Operation(2) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				if(localVars[1] instanceof Class) {
					return new Boolean(localVars[1].equals(localVars[0].getClass()));
//					} else if(localVars[1] instanceof OclType) {		// TODO
//					if(localVars[1] instanceof OclParametrizedType)
//					return new Boolean(localVars[0] instanceof Collection);
//					else
//					return Boolean.FALSE;	//TODO
				} else if(localVars[1] instanceof EClass) {
					if(localVars[0] instanceof EObject) {
						return new Boolean(localVars[1].equals(((EObject)localVars[0]).eClass()));
					} else {
						return Boolean.FALSE;
					}
				} else {
					throw new RuntimeException("do not know how to handle type: " + localVars[1]);
				}
			}
		});
		operationsByName.put("oclIsKindOf", new Operation(2) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				if(localVars[1] instanceof Class) {
					return new Boolean(((Class)localVars[1]).isInstance(localVars[0]));
				} else if(localVars[1] instanceof OclType) {
					if(localVars[1] instanceof OclParametrizedType)
						return new Boolean(localVars[0] instanceof Collection);
					else
						return Boolean.FALSE;	//TODO
				} else if(localVars[1] instanceof EClass) {
					return new Boolean(((EClass)localVars[1]).isInstance(localVars[0]));					
				} else {
					throw new RuntimeException("do not know how to handle type: " + localVars[1]);
				}
			}
		});
		operationsByName.put("refImmediateComposite", new Operation(1) {	// TODO: should only exist on EObject
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				if(localVars[0] instanceof EObject) {
					Object ret = ((EObject)localVars[0]).eContainer();
					if(ret == null)
						ret = OclUndefined.SINGLETON;
					return ret;
				} else {
					throw new RuntimeException("refImmediateComposite only valid on model elements");
				}
			}
		});
		// EClass
		operationsByName = new HashMap();
		vmTypeOperations.put(EcorePackage.eINSTANCE.getEClass(), operationsByName);
		operationsByName.put("allInstancesFrom", new Operation(2) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				Model model = frame.execEnv.getModel(localVars[1]);
				if(model == null)
					throw new RuntimeException("model not found: " + localVars[1]);
				return model.getElementsByType(localVars[0]);
			}
		});
		operationsByName.put("allInstances", new Operation(1) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;

				// could be a Set (actually was) instead of an OrderedSet
				Set ret = new LinkedHashSet();
				EClass ec = (EClass)localVars[0];
//				Model rm = getModelOf(ec); // this is not possible when considering referenced resources!
				for(Iterator i = frame.execEnv.modelsByName.values().iterator() ; i.hasNext() ; ) {
					AbstractModel model = (AbstractModel)i.next();
					if((!model.isTarget) && (model.getReferenceModel().isModelOf(ec)))
						ret.addAll(model.getElementsByType(ec));
				}
				return ret;
			}
		});
		operationsByName.put("registerHelperAttribute", new Operation(3) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				String name = (String)localVars[1];
				String initOperationName = (String)localVars[2];
				frame.execEnv.registerAttributeHelper(localVars[0], name, initOperationName);
				return null;
			}
		});
		operationsByName.put("newInstance", new Operation(1) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				EClass ec = (EClass)localVars[0];
				return execEnv.newElement(frame, ec);
			}
		});
		operationsByName.put("getInstanceById", new Operation(3) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				EMFModel model = (EMFModel)execEnv.getModel(localVars[1]);
				Object ret = model.resource.getEObject((String)localVars[2]);
				if(ret == null)
					ret = OclUndefined.SINGLETON;
				return ret;
			}
		});
		operationsByName.put("conformsTo", new Operation(2) {
			public Object exec(StackFrame frame) {
				Object localVars[] = frame.localVars;
				return new Boolean(((EClass)localVars[1]).isSuperTypeOf(((EClass)localVars[0])));
			}
		});
	}

	public Object get(StackFrame frame, Object modelElement, String name) {
		EObject eo = (EObject)modelElement;
		Object ret = null;
		
		EClass ec = eo.eClass();
		try {
			if("__xmiID__".equals(name)) {
				// TODO: optimize using ((EObject)modelElement).getResource()
				ret = ((EMFModel)getModelOf(eo)).resource.getURIFragment(eo);
			} else {
				EStructuralFeature sf = ec.getEStructuralFeature(name);
				Object val = eo.eGet(sf);
				if(val == null) val = OclUndefined.SINGLETON;
				ret = val;
			}
		} catch(Exception e) {
			throw new VMException(frame, "error accessing " + frame.execEnv.toPrettyPrintedString(ec) + "." + name, e);
		}

		return ret;
	}

	// TODO:
	//	- EEnumliteral implementation
	//		- could be different (faster?) when same metamodel in source and target
	//		- may be too permissive (any value for which toString returns a valid literal name works) 
	//	- should flatten nested collections
	public void set(StackFrame frame, Object modelElement, String name, Object value) {
		if(value == null) return;
		final ExecEnv execEnv = frame.execEnv;
		final EObject eo = (EObject)modelElement;
		final EStructuralFeature feature = eo.eClass().getEStructuralFeature(name);
		
		// makes it possible to use an integer to set a floating point property  
		if(value instanceof Integer) {
			String targetType = feature.getEType().getInstanceClassName();
			if("java.lang.Double".equals(targetType) || "java.lang.Float".equals(targetType)) {
				value = new Double(((Integer)value).doubleValue());
			}
		}
		
		EClassifier type = feature.getEType();
		boolean targetIsEnum = type instanceof EEnum;
		try {
			Object oldValue = eo.eGet(feature);
			if(oldValue instanceof Collection) {
				Collection oldCol = (Collection)oldValue;
				if(value instanceof Collection) {
					if(targetIsEnum) {
						EEnum eenum = (EEnum)type;
						for(Iterator i = ((Collection)value).iterator() ; i.hasNext() ; ) {
							Object v = i.next();
							oldCol.add(eenum.getEEnumLiteral(v.toString()).getInstance());							
						}
					} else if(allowInterModelReferences) {
						oldCol.addAll((Collection)value);
					} else {	// !allowIntermodelReferences
						for(Iterator i = ((Collection)value).iterator() ; i.hasNext() ; ) {
							Object v = i.next();
							if(v instanceof EObject) {
								if(getModelOf(eo) == getModelOf(v))
									oldCol.add(v);
							} else {
								oldCol.add(v);								
							}
						}
					}
				} else {
					if(targetIsEnum) {
						EEnum eenum = (EEnum)type;
						oldCol.add(eenum.getEEnumLiteral(value.toString()).getInstance());							
					} else if(allowInterModelReferences || !(value instanceof EObject)) {
						oldCol.add(value);
					} else {	// (!allowIntermodelReferences) && (value intanceof EObject)
						if(getModelOf(eo) == getModelOf(value))
							oldCol.add(value);
					}
				}
			} else {
				if(value instanceof Collection) {
					execEnv.logger.warning("Assigning a Collection to a single-valued feature");
					Collection c = (Collection)value;
					if(!c.isEmpty()) {
						value = c.iterator().next();
					} else {
						value = null;
					}
				}
				if(targetIsEnum) {
					EEnum eenum = (EEnum)type;
					eo.eSet(feature, eenum.getEEnumLiteral(value.toString()).getInstance());							
				} else if(allowInterModelReferences || !(value instanceof EObject)) {
					eo.eSet(feature, value);
				} else {	// (!allowIntermodelReferences) && (value intanceof EObject)
					if(getModelOf(eo) == getModelOf(value))
						eo.eSet(feature, value);
				}
			}
		} catch(Exception e) {
			// TODO: implement a better mechanism than println for warnings
			execEnv.logger.warning("Warning: could not assign " + value + " to " + frame.execEnv.toPrettyPrintedString(eo) + "." + name);
		}
	}
	
	public void delete(StackFrame frame, Object modelElement) {
		EObject eo = (EObject)modelElement;
		eo.eAdapters().clear();
		EcoreUtil.remove(eo);
	}

}
