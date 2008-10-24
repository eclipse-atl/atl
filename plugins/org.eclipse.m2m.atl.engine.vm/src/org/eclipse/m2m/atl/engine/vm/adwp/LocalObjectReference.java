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
package org.eclipse.m2m.atl.engine.vm.adwp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.NetworkDebugger;
import org.eclipse.m2m.atl.engine.vm.Operation;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMReal;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class LocalObjectReference extends ObjectReference {

	private static Map values = new HashMap();

	private static Map valuesById = new HashMap();

	public static ObjectReference valueOf(int id_) {
		Integer id = new Integer(id_);
		ObjectReference ret = (ObjectReference)valuesById.get(id);

		// ret cannot be null or the debugger is making a mistake

		return ret;
	}

	public static ObjectReference valueOf(ASMOclAny object, NetworkDebugger debugger) {
		List key = new ArrayList();
		key.add(object);
		key.add(debugger);
		ObjectReference ret = (ObjectReference)values.get(key);

		if (ret == null) {
			int id = idGenerator++;
			ret = new LocalObjectReference(object, id, debugger);
			values.put(key, ret);
			valuesById.put(new Integer(id), ret);
		}

		return ret;
	}

	private LocalObjectReference(ASMOclAny object, int id, NetworkDebugger debugger) {
		super(id);
		this.object = object;
		this.debugger = debugger;
	}

	public Value get(String propName) {
		Value ret = null;

		ASMOclAny o = null;
		try {
			o = object.get(debugger.getExecEnv().peek(), propName);
		} catch (Exception e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		ret = asm2value(o);

		return ret;
	}

	private Value asm2value(ASMOclAny o) {
		return asm2value(o, debugger);
	}

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

	public ASMOclAny value2asm(Value value) {
		ASMOclAny ret = null;

		if (value instanceof LocalObjectReference) {
			ret = ((LocalObjectReference)value).object;
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

	public void set(String propName, Value value) {
		ASMOclAny realValue = value2asm(value);
		object.set(null, propName, realValue);
	}

	public Value call(String opName, List args) {
		final boolean debug = false;
		Value ret = null;
		Operation op = debugger.getExecEnv().getOperation(object.getType(), opName);
		if (op == null) {
			ATLLogger.severe("Operation not found: " + opName + " on " + object + " : " + object.getType());
		} else {
			List realArgs = new ArrayList();
			realArgs.add(value2asm(this));

			if (debug) {
				ATLLogger.info(object + " : " + object.getType() + "." + opName + "(");
			}

			for (Iterator i = args.iterator(); i.hasNext();) {
				Value v = (Value)i.next();

				if (debug) {
					ATLLogger.info(v + ((i.hasNext()) ? ", " : ""));
				}

				realArgs.add(value2asm(v));
			}
			ASMOclAny o = op.exec(new ADWPStackFrame(op, args).enterFrame(op, realArgs));
			ret = asm2value(o);

			if (debug) {
				ATLLogger.info(") = " + o);
			}

			if (debug) {
				ATLLogger.info(" => " + ret);
			}

		}

		return ret;
	}

	public ASMOclAny getObject() {
		return object;
	}

	private static int idGenerator = 0;

	private ASMOclAny object;

	private NetworkDebugger debugger;
}
