/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Freddy Allilaire (INRIA)
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.drivers.emf4atl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ClassNativeOperation;
import org.eclipse.m2m.atl.engine.vm.Operation;
import org.eclipse.m2m.atl.engine.vm.StackFrame;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBag;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMCollection;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclUndefined;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOrderedSet;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMReal;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMSequence;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMSet;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMTuple;

/**
 * The EMF implementation for ASMModelElement.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMEMFModelElement extends ASMModelElement {

	private static WeakHashMap methodCache = new WeakHashMap();

	protected EObject object;

	/**
	 * Creates a new {@link ASMEMFModelElement} with the given parameters.
	 * 
	 * @param modelElements
	 *            the model elements map
	 * @param model
	 *            the model element
	 * @param object
	 *            the object
	 */
	protected ASMEMFModelElement(Map modelElements, ASMModel model, EObject object) {
		super(model, getMetaobject(model, object));
		this.object = object;

		// must be done here and not in getASMModelElement because EClass extends EClassifier whose type is
		// EClass
		modelElements.put(object, this);

		EStructuralFeature sfName = object.eClass().getEStructuralFeature("name");
		if (sfName != null) {
			String name = null;
			try {
				name = (String)object.eGet(sfName);
				if (name == null) {
					name = "<notnamedyet>";
				}
			} catch (Exception e) {
				name = "<nonstringname>";
			}
			setName(name);
		} else {
			setName("<unnamed>");
		}

		if (getMetaobject() == null) {
			setMetaobject(this);
		}
		setType(getMetaobject());

		// Supertypes
		if (object instanceof EClass) {
			addSupertype(ASMOclType.myType);
			EClass cl = (EClass)object;
			for (Iterator i = cl.getESuperTypes().iterator(); i.hasNext();) {
				EClass s = (EClass)i.next();
				addSupertype(((ASMEMFModel)model).getASMModelElement(s));
			}
		}
	}

	// only for metamodels...?
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement#conformsTo(org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType)
	 */
	public ASMBoolean conformsTo(ASMOclType other) {
		boolean ret = false;

		if (other instanceof ASMEMFModelElement) {
			EObject o = ((ASMEMFModelElement)other).object;
			EObject t = object;

			if ((o instanceof EClass) && (t instanceof EClass)) {
				try {
					ret = o.equals(t) || ((EClass)o).isSuperTypeOf((EClass)t);
				} catch (Exception e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
		}

		return new ASMBoolean(ret);
	}

	// only for metamodels...?
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement#getPropertyType(java.lang.String)
	 */
	public ASMModelElement getPropertyType(String name) {
		ASMModelElement ret = null;

		ASMModelElement p = getProperty(name);
		if (p != null) {
			ret = (ASMModelElement)p.get(null, "eType");
		}

		return ret;
	}

	// only for metamodels...?
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement#getProperty(java.lang.String)
	 */
	public ASMModelElement getProperty(String name) {
		ASMModelElement ret = null;

		EObject t = object;

		if (t instanceof EClass) {
			try {
				ret = ((ASMEMFModel)getModel()).getASMModelElement(((EClass)t).getEStructuralFeature(name));
			} catch (Exception e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny#refImmediateComposite()
	 */
	public ASMOclAny refImmediateComposite() {
		ASMOclAny ret = null;

		EObject ic = object.eContainer();
		if (ic == null) {
			ret = super.refImmediateComposite();
		} else {
			ret = ((ASMEMFModel)getModel()).getASMModelElement(ic);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement#get(org.eclipse.m2m.atl.engine.vm.StackFrame,
	 *      java.lang.String)
	 */
	public ASMOclAny get(StackFrame frame, String name) {
		ASMOclAny ret = null;

		if ((frame != null) && isHelper(frame, name)) {
			ret = getHelper(frame, name);
		} else if ("__xmiID__".equals(name)) {
			String id = ((XMIResource)((ASMEMFModel)getModel()).getExtent()).getURIFragment(object);
			ret = emf2ASM(frame, id);
		} else {
			EStructuralFeature sf = object.eClass().getEStructuralFeature(name);
			if (sf == null) {
				String msg = "Feature " + name + " does not exist on " + getType();
				if (frame == null) {
					throw new RuntimeException(msg);
				} else {
					frame.printStackTrace(msg);
				}
			}
			ret = emf2ASM(frame, object.eGet(sf));
		}
		return ret;
	}

	/**
	 * Converts an ASM element to its EMF equivalent.
	 * 
	 * @param frame
	 *            the frame context
	 * @param value
	 *            the element to convert
	 * @param propName
	 *            the property name
	 * @param feature
	 *            the feature which refers to the element
	 * @return the converted element
	 */
	protected Object asm2EMF(StackFrame frame, ASMOclAny value, String propName, EStructuralFeature feature) {
		Object ret = null;

		if (value instanceof ASMString) {
			ret = ((ASMString)value).getSymbol();
		} else if (value instanceof ASMBoolean) {
			ret = new Boolean(((ASMBoolean)value).getSymbol());
		} else if (value instanceof ASMReal) {
			ret = new Double(((ASMReal)value).getSymbol());
		} else if (value instanceof ASMInteger) {
			int val = ((ASMInteger)value).getSymbol();
			if (feature != null) {
				String targetType = feature.getEType().getInstanceClassName();
				if (targetType.equals("java.lang.Double") || targetType.equals("java.lang.Float")) {
					ret = new Double(val);
				} else {
					ret = new Integer(val);
					// Java 1.5 API:
					// ret = Integer.valueOf(val);
				}
			} else {
				ret = new Integer(val);
				// Java 1.5 API:
				// ret = Integer.valueOf(val);
			}
		} else if (value instanceof ASMEMFModelElement) {
			ret = ((ASMEMFModelElement)value).object;
		} else if (value instanceof ASMOclUndefined) {
			ret = null;
		} else if (value instanceof ASMEnumLiteral) {
			String name = ((ASMEnumLiteral)value).getName();
			EClassifier type = ((EClass)((ASMEMFModelElement)getMetaobject()).object).getEStructuralFeature(
					propName).getEType();
			ret = ((EEnum)type).getEEnumLiteral(name).getInstance();
		} else if (value instanceof ASMTuple) {
			Object f = asm2EMF(frame, ((ASMTuple)value).get(frame, "eStructuralFeature"), propName, feature);
			if (f instanceof EStructuralFeature) {
				Object v = asm2EMF(frame, ((ASMTuple)value).get(frame, "value"), propName, feature);
				ret = FeatureMapUtil.createEntry((EStructuralFeature)f, v);
			} else {
				frame.printStackTrace("Cannot convert " + value + " : " + value.getClass() + " to EMF.");
			}
		} else if (value instanceof ASMCollection) {
			ret = new ArrayList();
			for (Iterator i = ((ASMCollection)value).iterator(); i.hasNext();) {
				Object v = asm2EMF(frame, (ASMOclAny)i.next(), propName, feature);
				if (v != null) {
					((List)ret).add(v);
				}
			}
		} else {
			frame.printStackTrace("Cannot convert " + value + " : " + value.getClass() + " to EMF.");
		}

		return ret;
	}

	/**
	 * Converts an EMF element to its ASM equivalent.
	 * 
	 * @param frame
	 *            the frame context
	 * @param value
	 *            the element to convert
	 * @return the converted element
	 */
	protected ASMOclAny emf2ASM(StackFrame frame, Object value) {
		ASMOclAny ret = null;

		if (value instanceof String) {
			ret = new ASMString((String)value);
		} else if (value instanceof Boolean) {
			ret = new ASMBoolean(((Boolean)value).booleanValue());
		} else if (value instanceof Double) {
			ret = new ASMReal(((Double)value).doubleValue());
		} else if (value instanceof Float) {
			ret = new ASMReal(((Float)value).doubleValue());
		} else if (value instanceof Integer) {
			ret = new ASMInteger(((Integer)value).intValue());
		} else if (value instanceof Long) {
			ret = new ASMInteger(((Long)value).intValue());
		} else if (value instanceof Byte) {
			ret = new ASMInteger(((Byte)value).intValue());
		} else if (value instanceof Short) {
			ret = new ASMInteger(((Short)value).intValue());
		} else if (value instanceof Character) {
			ret = new ASMInteger(((Character)value).charValue());
		} else if (value instanceof Enumerator) {
			ret = new ASMEnumLiteral(((Enumerator)value).getName());
		} else if (value instanceof FeatureMap.Entry) {
			ret = new ASMTuple();
			ret.set(frame, "eStructuralFeature", emf2ASM(frame, ((FeatureMap.Entry)value)
					.getEStructuralFeature()));
			ret.set(frame, "value", emf2ASM(frame, ((FeatureMap.Entry)value).getValue()));
		} else if (value instanceof EObject) {
			ret = eObjectToASM(frame, (EObject)value);
		} else if (value == null) {
			ret = new ASMOclUndefined();
		} else if (value instanceof Collection) {
			ASMCollection col;
			if (value instanceof List) {
				col = new ASMSequence();
			} else if (value instanceof Set) {
				col = new ASMSet();
			} else {
				col = new ASMBag();
			}

			for (Iterator i = ((Collection)value).iterator(); i.hasNext();) {
				col.add(emf2ASM(frame, i.next()));
			}
			ret = col;
		} else {
			frame.printStackTrace("Cannot convert " + value + " : " + value.getClass() + " from EMF.");
		}

		return ret;
	}

	/**
	 * Returns the corresponding ASMModelElement, taking into account the model in which the element should
	 * reside. Uses this model as a proxy if no other model contains the given value.
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @param frame
	 *            The ATL VM stackframe
	 * @param value
	 *            The EMF value to convert
	 * @return The corresponding ASMModelElement, taking into account the model in which the element should
	 *         reside
	 */
	private ASMOclAny eObjectToASM(StackFrame frame, EObject value) {
		ASMEMFModel model = (ASMEMFModel)getModel();
		Resource valueExtent = value.eResource();
		if (model.getExtent().equals(valueExtent)) {
			return model.getASMModelElement(value);
		} else {
			Iterator models = frame.getModels().values().iterator();
			while (models.hasNext()) {
				Object m = models.next();
				if ((m instanceof ASMEMFModel) && (!model.equals(m))) {
					if (((ASMEMFModel)m).getExtent().equals(valueExtent)) {
						return ((ASMEMFModel)m).getASMModelElement(value);
					}
				}
			}
		}
		// Use this model as proxy
		return model.getASMModelElement(value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement#set(org.eclipse.m2m.atl.engine.vm.StackFrame,
	 *      java.lang.String, org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny)
	 */
	public void set(StackFrame frame, String name, ASMOclAny value) {

		final boolean debug = false;
		// final boolean checkSameModel = !true;

		if (debug) {
			ATLLogger.info("Setting: " + this + " : " + getType() + "." + name + " to " + value);
		}

		super.set(frame, name, value);
		EStructuralFeature feature = object.eClass().getEStructuralFeature(name);

		if ("__xmiID__".equals(name)) {
			// WARNING: Allowed manual setting of XMI ID for the current model element
			// This operation is advised against but seems necessary of some special case
			Resource r = ((ASMEMFModel)getModel()).getExtent();
			ATLLogger.warning("\t\tManual setting of " + this + ":" + getType() + " XMI ID.");
			((XMLResource)r).setID(object, value.toString());
			return;
		}
		if (frame != null) {
			ASMExecEnv execEnv = (ASMExecEnv)frame.getExecEnv();
			if (execEnv.isWeavingHelper(getMetaobject(), name)) {
				execEnv.setHelperValue(frame, this, name, value);
				return;
			}
		}
		if (feature == null) {
			String msg = "Feature " + name + " does not exist on " + getType();
			if (frame == null) {
				throw new RuntimeException(msg);
			} else {
				frame.printStackTrace(msg);
			}
		} else {
			if (!feature.isChangeable()) {
				String msg = "Feature " + name + " is not changeable";
				if (frame == null) {
					throw new RuntimeException(msg);
				} else {
					frame.printStackTrace(msg);
				}
			}
			if (feature.isMany()) {
				EList l = (EList)object.eGet(feature);
				if (value instanceof ASMCollection) {
					for (Iterator i = ((ASMCollection)value).iterator(); i.hasNext();) {
						ASMOclAny sv = (ASMOclAny)i.next();
						if (isNotAssignable(feature, sv)) {
							continue;
						}
						Object val = asm2EMF(frame, sv, name, feature);
						if (val != null) {
							try {
								l.add(val);
								checkContainment(feature, val);
							} catch (Exception e) {
								String msg = "Cannot set feature " + getType() + "." + name + " to value "
										+ val;
								if (frame == null) {
									throw new RuntimeException(msg, e);
								} else {
									frame.printStackTrace(msg, e);
								}
							}
						}
					}
				} else {
					Object val = asm2EMF(frame, value, name, feature);
					l.add(val);
					checkContainment(feature, val);
				}
			} else {
				if (isNotAssignable(feature, value)) {
					// should not happen but the ATL compiler does not add checks for this in resolveTemp yet
				} else {
					Object val = asm2EMF(frame, value, name, feature);
					if (val != null) {
						try {
							object.eSet(feature, val);
							checkContainment(feature, val);
						} catch (Exception e) {
							String msg = "Cannot set feature " + getType() + "." + name + " to value " + val;
							if (frame == null) {
								throw new RuntimeException(msg, e);
							} else {
								frame.printStackTrace(msg, e);
							}

						}
					}
				}
			}
		}
	}

	/**
	 * Returns <code>true</code> if the value cannot be assigned to the feature.
	 * 
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @param feature
	 *            The feature to assign to
	 * @param value
	 *            The value to assign
	 * @return <code>true</code> if the value cannot be assigned to the feature
	 */
	private boolean isNotAssignable(EStructuralFeature feature, ASMOclAny value) {
		if ((value instanceof ASMModelElement) && (((ASMModelElement)value).getModel() != getModel())) {
			// assigning a model element that resides in a different model isn't always allowed
			if (((ASMEMFModel)getModel()).isCheckSameModel()) {
				// cross-model references are explicitly disallowed
				return true;
			} else if (feature instanceof EReference) {
				// containment references cannot span across models
				EReference ref = (EReference)feature;
				return ref.isContainer() || ref.isContainment();
			}
		}
		return false;
	}

	private void checkContainment(EStructuralFeature feature, Object val) {
		if ((val != null) && (feature instanceof EReference)) {
			EReference ref = (EReference)feature;
			if (ref.isContainment()) {
				ASMEMFModel model = (ASMEMFModel)getModel();
				/*
				 * TODO add a plugin dependency to an assertion API (e.g., org.eclipse.jface.text.Assert in
				 * 3.1.2 or org.eclipse.core.runtime.Assert in 3.2) Assert.isNotNull(model);
				 */
				EList toplevelElements = model.getExtent().getContents();
				// Check if 'val' is a toplevel element
				// in the content list of the model resource extent.
				if (toplevelElements.contains(val)) {
					// 'val' is about to become a contained element.
					// therefore, we need to remove it from the list of toplevel elements
					toplevelElements.remove(val);
				}
			} else if (ref.isContainer()) {
				ASMEMFModel model = (ASMEMFModel)getModel();
				/*
				 * TODO add a plugin dependency to an assertion API (e.g., org.eclipse.jface.text.Assert in
				 * 3.1.2 or org.eclipse.core.runtime.Assert in 3.2) Assert.isNotNull(model);
				 */
				EList toplevelElements = model.getExtent().getContents();
				// Check if 'val' is a toplevel element
				// in the content list of the model resource extent.
				if (toplevelElements.contains(object)) {
					// 'val' is about to become a contained element.
					// therefore, we need to remove it from the list of toplevel elements
					toplevelElements.remove(object);
				}
			}
		}
	}

	private static ASMModelElement getMetaobject(ASMModel model, EObject object) {
		ASMModelElement ret = null;

		EObject metaobject = object.eClass();
		if (metaobject != object) {
			ret = ((ASMEMFModel)model.getMetamodel()).getASMModelElement(metaobject);
		}

		return ret;
	}

	private static void registerMOFOperation(String modelelementName, String methodName, Class[] args)
			throws Exception {
		List realArgs = new ArrayList(Arrays.asList(args));
		realArgs.add(0, ASMEMFModelElement.class);
		realArgs.add(0, StackFrame.class);
		ClassNativeOperation no = new ClassNativeOperation(ASMEMFModelElement.class.getMethod(methodName,
				(Class[])realArgs.toArray(args)));
		ASMModelElement amme = ASMEMFModel.getMOF().findModelElement(modelelementName);
		amme.registerVMOperation(no);
	}

	static {
		try {
			// Force creation of MOF!EClass before any other (otherwise MOF!Classifier gets created twice)
			ASMEMFModel.getMOF().findModelElement("EClass");

			// Operations on MOF!Classifier
			// TODO on EClassifier after having added supertypes
			registerMOFOperation("EClass", "allInstances", new Class[] {});
			registerMOFOperation("EClass", "allInstancesFrom", new Class[] {ASMString.class});
			registerMOFOperation("EClassifier", "newInstance", new Class[] {});
			registerMOFOperation("EClassifier", "newInstanceIn", new Class[] {ASMString.class});
			registerMOFOperation("EClassifier", "getInstanceById", new Class[] {ASMString.class,
					ASMString.class,});

		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Returns the instance with the given id. For testing purpose.
	 * 
	 * @param frame
	 *            the frame context
	 * @param self
	 *            the current element
	 * @param modelName
	 *            the model name
	 * @param id
	 *            the instance id
	 * @return the instance
	 */
	public static ASMOclAny getInstanceById(StackFrame frame, ASMEMFModelElement self, ASMString modelName,
			ASMString id) {
		ASMOclAny ret = null;

		ASMModel model = (ASMModel)frame.getModels().get(modelName.getSymbol());
		if (model instanceof ASMEMFModel) {
			// TODO: test new version, was: getIDToEObjectMap().get(id.getSymbol());
			EObject eo = ((XMIResource)((ASMEMFModel)model).getExtent()).getEObject(id.getSymbol());
			if (eo != null) {
				ret = ((ASMEMFModel)model).getASMModelElement(eo);
			}
		}

		return (ret == null) ? new ASMOclUndefined() : ret;
	}

	/**
	 * Returns all instances of a type.
	 * 
	 * @param frame
	 *            the frame context
	 * @param self
	 *            the caller type
	 * @return all instances of a type
	 */
	public static ASMOrderedSet allInstances(StackFrame frame, ASMEMFModelElement self) {
		return allInstancesFrom(frame, self, null);
	}

	/**
	 * Returns all instances of a type from a given model. TODO: return type could be a Set because there is
	 * no order, in theory However, keeping resource (i.e., XMI) order is sometimes less confusing
	 * 
	 * @param frame
	 *            the frame context
	 * @param self
	 *            the caller type
	 * @param sourceModelName
	 *            the model name
	 * @return all instances of a type from a given model
	 */
	public static ASMOrderedSet allInstancesFrom(StackFrame frame, ASMEMFModelElement self,
			ASMString sourceModelName) {

		final boolean debug = false;

		ASMOrderedSet aret = new ASMOrderedSet();
		Collection ret = aret.collection();

		if (debug) {
			ATLLogger.info(self + ".allInstancesFrom("
					+ ((sourceModelName == null) ? "null" : "\"" + sourceModelName + "\"") + ")");
		}
		for (Iterator i = frame.getModels().keySet().iterator(); i.hasNext();) {
			String mname = (String)i.next();

			if (debug) {
				ATLLogger.info("\ttrying: " + mname);
			}

			if ((sourceModelName != null) && !mname.equals(sourceModelName.getSymbol())) {
				continue;
			}
			ASMModel am = (ASMModel)frame.getModels().get(mname);

			if (debug) {
				ATLLogger.info("\t\tfound: " + am.getName());
				ATLLogger.info("\t\tam.getMetamodel() = " + am.getMetamodel().hashCode());
				ATLLogger.info("\t\tself.getModel() = " + self.getModel().hashCode());
				ATLLogger.info("\t\tam.getMetamodel().equals(self.getModel()) = "
						+ am.getMetamodel().equals(self.getModel()));
			}

			if (!am.getMetamodel().equals(self.getModel())) {
				continue;
			}

			if (debug) {
				ATLLogger.info("\t\t\tsearching on: " + am.getName());
			}

			Set elems = am.getElementsByType(self);
			ret.addAll(elems);

			if (debug) {
				ATLLogger.info("\t\t\t\tfound: " + elems);
			}

		}
		// }

		return aret;
	}

	/**
	 * Creates a new instance of a given type.
	 * 
	 * @param frame
	 *            the frame context
	 * @param self
	 *            the given type
	 * @return the new element
	 */
	public static ASMModelElement newInstance(StackFrame frame, ASMEMFModelElement self) {
		ASMModelElement ret = null;
		if (self.object.eClass().getName().equals("EClass")) {
			ret = createNewInstance(frame, self);
		}
		return ret;
	}

	/**
	 * Creates a new instance of a given type.
	 * 
	 * @param frame
	 *            the frame context
	 * @param self
	 *            the given type
	 * @param modelName
	 *            the model where to create the element
	 * @return the new element
	 */
	public static ASMModelElement newInstanceIn(StackFrame frame, ASMEMFModelElement self, ASMString modelName) {
		ASMModelElement ret = null;
		if (self.object.eClass().getName().equals("EClass")) {
			for (Iterator j = frame.getExecEnv().getModels().values().iterator(); j.hasNext();) {
				ASMModel model = (ASMModel)j.next();
				if (model.isTarget() && model.getName().equals(modelName.cString())) {
					return model.newModelElement(self);
				}
			}
		}
		return ret;
	}

	/**
	 * Returns the method which match the given parameters.
	 * 
	 * @param cls
	 *            the class which contains the method
	 * @param name
	 *            the method name
	 * @param argumentTypes
	 *            th method parameters
	 * @return the method
	 */
	protected Method findMethod(Class cls, String name, Class[] argumentTypes) {
		String sig = getMethodSignature(name, argumentTypes);
		Method ret = findCachedMethod(sig);
		if (ret != null) {
			return ret;
		}

		Method[] methods = cls.getDeclaredMethods();
		for (int i = 0; i < (methods.length) && (ret == null); i++) {
			Method method = methods[i];
			if (method.getName().equals(name)) {
				Class[] pts = method.getParameterTypes();
				if (pts.length == argumentTypes.length) {
					boolean ok = true;
					for (int j = 0; (j < pts.length) && ok; j++) {
						if (!pts[j].isAssignableFrom(argumentTypes[j])) {
							if (!(pts[j] == boolean.class && argumentTypes[j] == Boolean.class
									|| pts[j] == int.class && argumentTypes[j] == Integer.class
									|| pts[j] == char.class && argumentTypes[j] == Character.class
									|| pts[j] == long.class && argumentTypes[j] == Long.class
									|| pts[j] == float.class && argumentTypes[j] == Float.class || pts[j] == double.class
									&& argumentTypes[j] == Double.class)) {
								ok = false;
							}
						}
					}
					if (ok) {
						ret = method;
					}
				}
			}
		}

		if ((ret == null) && (cls.getSuperclass() != null)) {
			ret = findMethod(cls.getSuperclass(), name, argumentTypes);
		}

		cacheMethod(sig, ret);

		return ret;
	}

	private Method findCachedMethod(String signature) {
		Method ret = null;
		Map sigMap = (Map)methodCache.get(getMetaobject());
		if (sigMap != null) {
			ret = (Method)sigMap.get(signature);
		}
		return ret;
	}

	private void cacheMethod(String signature, Method method) {
		ASMModelElement mo = getMetaobject();
		synchronized (methodCache) {
			Map sigMap = (Map)methodCache.get(mo);
			if (sigMap == null) {
				sigMap = new HashMap();
				methodCache.put(mo, sigMap);
			}
			sigMap.put(signature, method);
		}
	}

	/**
	 * Returns the method signature.
	 * 
	 * @param name
	 *            the method name
	 * @param argumentTypes
	 *            the arguments type of the method
	 * @return The method signature
	 */
	private String getMethodSignature(String name, Class[] argumentTypes) {
		StringBuffer sig = new StringBuffer();
		sig.append(name);
		sig.append('(');
		for (int i = 0; i < argumentTypes.length; i++) {
			if (i > 0) {
				sig.append(',');
			}
			sig.append(argumentTypes[i].getName());
		}
		sig.append(')');
		return sig.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny#invoke(org.eclipse.m2m.atl.engine.vm.StackFrame,
	 *      java.lang.String, java.util.List)
	 */
	public ASMOclAny invoke(StackFrame frame, String opName, List arguments) {
		ASMOclAny ret = null;

		Operation oper = findOperation(frame, opName, arguments, getType());
		if (oper != null) {
			ret = invoke(frame, oper, arguments);
		} else {
			Object[] args = new Object[arguments.size()];
			Class[] argumentTypes = new Class[arguments.size()];
			int k = 0;
			for (Iterator i = arguments.iterator(); i.hasNext();) {
				// warning: ASMEnumLiterals will not be converted!
				args[k] = asm2EMF(frame, (ASMOclAny)i.next(), null, null);
				argumentTypes[k] = args[k].getClass();
				k++;
			}

			Method method = findMethod(object.getClass(), opName, argumentTypes);
			try {
				if (method != null) {
					ret = emf2ASM(frame, method.invoke(object, args));
				} else {
					frame.printStackTrace("Could not find operation " + opName + " on " + getType()
							+ " having supertypes: " + getType().getSupertypes()
							+ " (including Java operations)");
				}
			} catch (IllegalAccessException e) {
				frame
						.printStackTrace("Could not invoke operation " + opName + " on " + getType()
								+ " having supertypes: " + getType().getSupertypes()
								+ " (including Java operations)");
			} catch (InvocationTargetException e) {
				Throwable cause = e.getCause();
				Exception toReport = (cause instanceof Exception) ? (Exception)cause : e;
				frame.printStackTrace("Exception during invocation of operation " + opName + " on "
						+ getType() + " (java method: " + method + ")", toReport);
			}
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny#invokeSuper(org.eclipse.m2m.atl.engine.vm.StackFrame,
	 *      java.lang.String, java.util.List)
	 */
	public ASMOclAny invokeSuper(StackFrame frame, String opName, List arguments) {
		ASMOclAny ret = null;

		Operation oper = null;
		for (Iterator i = getType().getSupertypes().iterator(); i.hasNext() && oper == null;) {
			oper = findOperation(frame, opName, arguments, (ASMOclType)i.next());
		}
		if (oper != null) {
			ret = invoke(frame, oper, arguments);
		} else {
			Object[] args = new Object[arguments.size()];
			Class[] argumentTypes = new Class[arguments.size()];
			int k = 0;
			for (Iterator i = arguments.iterator(); i.hasNext();) {
				// warning: ASMEnumLiterals will not be converted!
				args[k] = asm2EMF(frame, (ASMOclAny)i.next(), null, null);
				argumentTypes[k] = args[k].getClass();
				k++;
			}

			Method method = findMethod(object.getClass().getSuperclass(), opName, argumentTypes);
			try {
				if (method != null) {
					ret = emf2ASM(frame, method.invoke(object, args));
				} else {
					frame.printStackTrace("Could not find operation " + opName + " on " + getType()
							+ " having supertypes: " + getType().getSupertypes()
							+ " (including Java operations)");
				}
			} catch (IllegalAccessException e) {
				frame
						.printStackTrace("Could not invoke operation " + opName + " on " + getType()
								+ " having supertypes: " + getType().getSupertypes()
								+ " (including Java operations)");
			} catch (InvocationTargetException e) {
				Throwable cause = e.getCause();
				Exception toReport = (cause instanceof Exception) ? (Exception)cause : e;
				frame.printStackTrace("Exception during invocation of operation " + opName + " on "
						+ getType() + " (java method: " + method + ")", toReport);
			}
		}

		return ret;
	}

	public EObject getObject() {
		return object;
	}

}
