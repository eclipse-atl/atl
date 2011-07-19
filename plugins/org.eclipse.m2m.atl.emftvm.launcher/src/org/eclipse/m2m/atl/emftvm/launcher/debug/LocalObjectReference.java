/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher.debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.debug.core.adwp.ADWP;
import org.eclipse.m2m.atl.debug.core.adwp.BooleanValue;
import org.eclipse.m2m.atl.debug.core.adwp.IntegerValue;
import org.eclipse.m2m.atl.debug.core.adwp.NullValue;
import org.eclipse.m2m.atl.debug.core.adwp.ObjectReference;
import org.eclipse.m2m.atl.debug.core.adwp.RealValue;
import org.eclipse.m2m.atl.debug.core.adwp.StringValue;
import org.eclipse.m2m.atl.debug.core.adwp.Value;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.launcher.EmftvmLauncherPlugin;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.VMException;

/**
 * The local implementation of an object reference.
 * Adapted from org.eclipse.m2m.atl.engine.emfvm.launch.debug.LocalObjectReference.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class LocalObjectReference extends ObjectReference {

	private static final CodeBlock EMPTY_CB = EmftvmFactory.eINSTANCE.createCodeBlock();

	private static Map<List<Object>, ObjectReference> values = new HashMap<List<Object>, ObjectReference>();
	private static Map<Integer, ObjectReference> valuesById = new HashMap<Integer, ObjectReference>();
	private static int idGenerator;

	protected Object object;
	protected NetworkDebugger debugger;

	/**
	 * Creates a new LocalObjectReference.
	 * 
	 * @param object
	 *            the object
	 * @param id
	 *            the objecct id
	 * @param debugger
	 *            the debugger
	 */
	protected LocalObjectReference(Object object, int id, NetworkDebugger debugger) {
		super(id);
		this.object = object;
		this.debugger = debugger;
	}

	public Object getObject() {
		return object;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#toString()
	 */
	@Override
	public String toString() {
		return object.toString();
	}

	/**
	 * Returns the object reference matching the given id.
	 * 
	 * @param objectId
	 *            the object id
	 * @return the object reference matching the given id
	 */
	public static ObjectReference valueOf(int objectId) {
		Integer id = Integer.valueOf(objectId);
		ObjectReference ret = valuesById.get(id);
		assert ret != null;
		return ret;
	}

	/**
	 * Returns an object reference for the given object.
	 * 
	 * @param object
	 *            the object
	 * @param debugger
	 *            the current debugger
	 * @return the object reference
	 */
	public static ObjectReference valueOf(Object object, NetworkDebugger debugger) {
		final List<Object> key = new ArrayList<Object>();
		key.add(object);
		key.add(debugger);
		ObjectReference ret = values.get(key);

		if (ret == null) {
			int id = idGenerator++;
			ret = new LocalObjectReference(object, id, debugger);
			values.put(key, ret);
			valuesById.put(Integer.valueOf(id), ret);
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#get(java.lang.String)
	 */
	@Override
	public Value get(final String propName) {
		Value ret = null;
		final StackFrame frame = debugger.getLastFrame();
		final ExecEnv env = debugger.getExecEnv();
		try {
			final Object type = getType();
			final Field field = env.findField(type, propName);
			if (field != null) {
				ret = object2value(field.getValue(object, frame));
			} else if (object instanceof EObject) {
				assert type instanceof EClass;
				final EStructuralFeature sf = ((EClass)type).getEStructuralFeature(propName);
				if (sf != null) {
					ret = object2value(EMFTVMUtil.uncheckedGet(env, (EObject)object, sf));
				}
			}
		} catch (Exception e) {
			EmftvmLauncherPlugin.log(e);
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#set(java.lang.String,
	 *      org.eclipse.m2m.atl.debug.core.adwp.Value)
	 */
	@Override
	public void set(final String propName, final Value value) {
		final ExecEnv env = debugger.getExecEnv();
		final Object realValue = value2object(value);
		final Object type = getType();
		final Field field = env.findField(type, propName);
		if (field != null) {
			field.setValue(object, realValue);
		} else if (object instanceof EObject) {
			assert type instanceof EClass;
			final EStructuralFeature sf = ((EClass)type).getEStructuralFeature(propName);
			if (sf != null) {
				EMFTVMUtil.set(env, (EObject)object, sf, realValue);
			}
		}
	}

	/**
	 * Converts <code>value</code> to a regular object.
	 * @param value the {@link org.eclipse.m2m.atl.debug.core.adwp.ADWP} value to convert
	 * @return the regular object
	 */
	private Object value2object(Value value) {
		Object ret = null;
		if (value instanceof LocalObjectReference) {
			ret = ((LocalObjectReference)value).object;
		} else if (value instanceof StringValue) {
			ret = ((StringValue)value).getValue();
		} else if (value instanceof IntegerValue) {
			ret = ((IntegerValue)value).getValue();
		} else if (value instanceof RealValue) {
			ret = ((RealValue)value).getValue();
		} else if (value instanceof BooleanValue) {
			ret = ((BooleanValue)value).getValue();
		}
		return ret;
	}

	/**
	 * Returns the type of this object.
	 * @return the type
	 */
	private Object getType() {
		if (object instanceof EObject) {
			return ((EObject)object).eClass();
		}
		return object == null ? Void.TYPE : object.getClass();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#call(java.lang.String, java.util.List)
	 */
	@Override
	public Value call(String opName, List<Value> args) {
		final boolean debug = false;
		final ExecEnv execEnv = debugger.getExecEnv();
		Value ret = null;

		final Object type = getType();
		final Object[] realArgs = getRealArgs(args);
		final EList<Object> argTypes = EMFTVMUtil.getArgumentTypes(realArgs);
		final Operation op = execEnv.findOperation(type, opName, argTypes);

		if (op == null) {
			try {
				final StackFrame frame = new StackFrame(execEnv, EMPTY_CB);
				ret = object2value(EMFTVMUtil.invokeNative(frame, object, opName, realArgs));
			} catch (VMException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			} catch (UnsupportedOperationException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
		} else {
			if (debug) {
				ATLLogger.info(object + " : " + type + "." + opName + "("); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				for (Iterator<Value> i = args.iterator(); i.hasNext();) {
					Value v = i.next();
					ATLLogger.info(v + ((i.hasNext()) ? ", " : "")); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}

			final CodeBlock body = op.getBody();
			final StackFrame frame = new StackFrame(execEnv, body);
			frame.setLocals(object, realArgs);
			final Object o = body.execute(frame);
			ret = object2value(o);

			if (debug) {
				ATLLogger.info(") = " + o); //$NON-NLS-1$
				ATLLogger.info(" => " + ret); //$NON-NLS-1$
			}
		}

		return ret;
	}

	/**
	 * Returns the real arguments wrapped as {@link Value}s inside the given <code>args</code>. 
	 * @param args the wrapped arguments
	 * @return the real arguments
	 */
	private Object[] getRealArgs(List<Value> args) {
		final Object[] realArgs = new Object[args.size()];
		for (int i = 0; i < realArgs.length; i++) {
			realArgs[i] = value2object(args.get(i));
		}
		return realArgs;
	}

	/**
	 * Converts a regular object into an {@link ADWP} value.
	 * @param o the regular object to convert
	 * @return the {@link ADWP} value
	 */
	private Value object2value(Object o) {
		return object2value(o, debugger);
	}

	/**
	 * Converts an Object into a {@link Value}.
	 * 
	 * @param o
	 *            the object
	 * @param debugger
	 *            the current debugger
	 * @return the {@link Value}
	 */
	public static Value object2value(Object o, NetworkDebugger debugger) {
		Value ret = null;
		if (o instanceof String) {
			ret = StringValue.valueOf((String)o);
		} else if (o instanceof Integer) {
			ret = IntegerValue.valueOf((Integer)o);
		} else if (o instanceof Double) {
			ret = RealValue.valueOf((Double)o);
		} else if (o instanceof Boolean) {
			ret = BooleanValue.valueOf((Boolean)o);
		} else if (o == null) {
			ret = new NullValue();
		} else {
			ret = valueOf(o, debugger);
		}
		return ret;
	}

}
