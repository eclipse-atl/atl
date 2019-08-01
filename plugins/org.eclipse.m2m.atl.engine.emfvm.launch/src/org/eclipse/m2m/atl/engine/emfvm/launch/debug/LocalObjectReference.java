/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.launch.debug;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.debug.core.adwp.BooleanValue;
import org.eclipse.m2m.atl.debug.core.adwp.IntegerValue;
import org.eclipse.m2m.atl.debug.core.adwp.NullValue;
import org.eclipse.m2m.atl.debug.core.adwp.ObjectReference;
import org.eclipse.m2m.atl.debug.core.adwp.RealValue;
import org.eclipse.m2m.atl.debug.core.adwp.StringValue;
import org.eclipse.m2m.atl.debug.core.adwp.Value;
import org.eclipse.m2m.atl.engine.emfvm.StackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ASMModule;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.HasFields;
import org.eclipse.m2m.atl.engine.emfvm.lib.OclUndefined;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

/**
 * The local implementation of an object reference.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class LocalObjectReference extends ObjectReference {

	private static Map<List<Object>, ObjectReference> values = new HashMap<List<Object>, ObjectReference>();

	private static Map<Integer, ObjectReference> valuesById = new HashMap<Integer, ObjectReference>();

	private static int idGenerator;

	protected Object object;

	protected NetworkDebugger debugger;

	private ExecEnv execEnv;

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
		this.execEnv = debugger.getExecEnv();
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
		// ret cannot be null or the debugger is making a mistake
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
		List<Object> key = new ArrayList<Object>();
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
	public Value get(String propName) {
		Value ret = null;
		AbstractStackFrame frame = debugger.getLastFrame();
		try {
			Object type = getType();
			Operation ai = execEnv.getAttributeInitializer(type, propName);
			if (ai != null) {
				ret = object2value(execEnv.getHelperValue(frame, type, object, propName));
			} else if (object instanceof HasFields) {
				ret = object2value(((HasFields)object).get(frame, propName));
			} else {
				ret = object2value(execEnv.getModelAdapter().get(frame, object, propName));
			}
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
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
	public void set(String propName, Value value) {
		Object realValue = value2object(value);
		AbstractStackFrame frame = debugger.getLastFrame();
		if (object instanceof HasFields) {
			((HasFields)object).set(frame, propName, value);
		} else {
			if (value instanceof Collection<?>) {
				Collection<?> c = (Collection<?>)value;
				// TODO collections of collections have to be managed
				boolean temp = true;
				while (temp) {
					temp = c.remove(OclUndefined.SINGLETON);
				}
			} else if (realValue instanceof OclUndefined) { // other values are *not* wrapped
				realValue = null;
			}
			execEnv.getModelAdapter().set(frame, object, propName, realValue);
		}
	}

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

	private Object getType() {
		return execEnv.getModelAdapter().getType(object);
	}

	private Method getClassMethod(String name) {
		Method[] methods = object.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().equals(name)) {
				return method;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ObjectReference#call(java.lang.String, java.util.List)
	 */
	@Override
	public Value call(String opName, List<Value> args) {
		final boolean debug = false;
		Value ret = null;

		Object type = getType();
		Operation op = execEnv.getOperation(type, opName);
		if (op == null) {
			Method method = getClassMethod(opName);
			if (method != null) {
				try {
					Object[] realArgs = new Object[method.getParameterTypes().length];
					for (int i = 0; i < method.getParameterTypes().length; i++) {
						realArgs[i] = value2object(args.get(i));
					}
					ret = object2value(method.invoke(object, realArgs));
				} catch (IllegalArgumentException e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				} catch (IllegalAccessException e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				} catch (InvocationTargetException e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			} else {
				ATLLogger.severe("Operation not found: " + opName + " on " + object + " : " + type); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
		} else {
			List<Object> realArgs = new ArrayList<Object>();
			realArgs.add(value2object(this));

			if (debug) {
				ATLLogger.info(object + " : " + type + "." + opName + "("); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
			}

			for (Iterator<Value> i = args.iterator(); i.hasNext();) {
				Value v = i.next();

				if (debug) {
					ATLLogger.info(v + ((i.hasNext()) ? ", " : "")); //$NON-NLS-1$ //$NON-NLS-2$
				}

				realArgs.add(value2object(v));
			}

			// execution frame initialization
			AbstractStackFrame frame = new StackFrame(execEnv, new ASMModule(), op);
			frame.setLocalVars(realArgs.toArray());

			Object o = op.exec(frame.enter());
			ret = object2value(o);

			if (debug) {
				ATLLogger.info(") = " + o); //$NON-NLS-1$
			}

			if (debug) {
				ATLLogger.info(" => " + ret); //$NON-NLS-1$
			}
		}

		return ret;
	}

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
