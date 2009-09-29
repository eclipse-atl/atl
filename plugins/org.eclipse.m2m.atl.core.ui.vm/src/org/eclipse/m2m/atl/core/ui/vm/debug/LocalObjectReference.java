/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.vm.debug;

import java.util.ArrayList;
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
import org.eclipse.m2m.atl.engine.vm.ExecEnv;
import org.eclipse.m2m.atl.engine.vm.Operation;
import org.eclipse.m2m.atl.engine.vm.StackFrame;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMReal;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

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

		ASMOclAny o = null;
		try {
			o = ((ASMOclAny)object).get(debugger.getExecEnv().peek(), propName);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		ret = asm2value(o);

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
		ASMOclAny realValue = value2asm(value);
		((ASMOclAny)object).set(null, propName, realValue);
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
		Operation op = debugger.getExecEnv().getOperation(((ASMOclAny)object).getType(), opName);
		if (op == null) {
			ATLLogger.severe("Operation not found: " + opName + " on " + object + " : " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ ((ASMOclAny)object).getType());
		} else {
			List<ASMOclAny> realArgs = new ArrayList<ASMOclAny>();
			realArgs.add(value2asm(this));

			if (debug) {
				ATLLogger.info(object + " : " + ((ASMOclAny)object).getType() + "." + opName + "("); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}

			for (Iterator<Value> i = args.iterator(); i.hasNext();) {
				Value v = i.next();

				if (debug) {
					ATLLogger.info(v + ((i.hasNext()) ? ", " : "")); //$NON-NLS-1$ //$NON-NLS-2$
				}

				realArgs.add(value2asm(v));
			}
			ASMOclAny o = op.exec(new ADWPStackFrame(op, realArgs).enterFrame(op, realArgs));
			ret = asm2value(o);

			if (debug) {
				ATLLogger.info(") = " + o); //$NON-NLS-1$
			}

			if (debug) {
				ATLLogger.info(" => " + ret); //$NON-NLS-1$
			}

		}

		return ret;
	}

	private ASMOclAny value2asm(Value value) {
		ASMOclAny ret = null;

		if (value instanceof LocalObjectReference) {
			ret = (ASMOclAny)((LocalObjectReference)value).object;
		} else if (value instanceof StringValue) {
			ret = new ASMString(((StringValue)value).getValue());
		} else if (value instanceof IntegerValue) {
			ret = new ASMInteger(((IntegerValue)value).getValue());
		} else if (value instanceof RealValue) {
			ret = new ASMReal(((RealValue)value).getValue());
		} else if (value instanceof BooleanValue) {
			ret = new ASMBoolean(((BooleanValue)value).getValue());
		}
		return ret;
	}

	private Value asm2value(ASMOclAny o) {
		return asm2value(o, debugger);
	}

	/**
	 * Converts an ASM Object into a {@link Value}.
	 * 
	 * @param o
	 *            the object
	 * @param debugger
	 *            the current debugger
	 * @return the {@link Value}
	 */
	public static Value asm2value(ASMOclAny o, NetworkDebugger debugger) {
		Value ret = null;

		if (o instanceof ASMString) {
			ret = StringValue.valueOf(((ASMString)o).getSymbol());
		} else if (o instanceof ASMInteger) {
			ret = IntegerValue.valueOf(((ASMInteger)o).getSymbol());
		} else if (o instanceof ASMReal) {
			ret = RealValue.valueOf(((ASMReal)o).getSymbol());
		} else if (o instanceof ASMBoolean) {
			ret = BooleanValue.valueOf(((ASMBoolean)o).getSymbol());
		} else if (o == null) {
			ret = new NullValue();
		} else {
			ret = valueOf(o, debugger);
		}

		return ret;
	}

	/**
	 * A {@link StackFrame} for the debugging protocol, which doesn't interfere with the debugging process.
	 */
	protected class ADWPStackFrame extends StackFrame {

		/**
		 * Creates a new {@link ADWPStackFrame}.
		 * 
		 * @param op
		 *            the operation
		 * @param args
		 *            the frame arguments
		 */
		public ADWPStackFrame(Operation op, List<ASMOclAny> args) {
			super(myType, new ExecEnv(null), op, args);
		}

		/**
		 * {@inheritDoc} An error during a debugger request should not trigger the debugger.
		 * 
		 * @see org.eclipse.m2m.atl.engine.vm.StackFrame#printStackTrace(java.lang.String,
		 *      java.lang.Exception)
		 */
		@Override
		public void printStackTrace(String msg, Exception e) {
			ATLLogger.severe(msg);
		}
	}

}
