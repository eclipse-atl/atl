package org.atl.engine.vm.adwp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.atl.engine.vm.NetworkDebugger;
import org.atl.engine.vm.Operation;
import org.atl.engine.vm.nativelib.ASMBoolean;
import org.atl.engine.vm.nativelib.ASMInteger;
import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMReal;
import org.atl.engine.vm.nativelib.ASMString;

/**
 * @author Frédéric Jouault
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

		if(ret == null) {
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
			o = object.get(null, propName);
		} catch(Exception e) {
			e.printStackTrace();
		}

		ret = asm2value(o);

		return ret;
	}

	private Value asm2value(ASMOclAny o) {
		Value ret = null;

		if(o instanceof ASMString) {
			ret = StringValue.valueOf(((ASMString)o).getSymbol());
		} else if(o instanceof ASMInteger) {
			ret = IntegerValue.valueOf(((ASMInteger)o).getSymbol());
		} else if(o instanceof ASMReal) {
			ret = RealValue.valueOf(((ASMReal)o).getSymbol());
		} else if(o instanceof ASMBoolean) {
			ret = BooleanValue.valueOf(((ASMBoolean)o).getSymbol());
		} else if(o == null) {
			ret = new NullValue();
		} else {
			ret = valueOf(o, debugger);
		}

		return ret;
	}

	public ASMOclAny value2asm(Value value) {
		ASMOclAny ret = null;

		if(value instanceof LocalObjectReference) {
			ret = ((LocalObjectReference)value).object;
		} else if(value instanceof StringValue) {
			ret = new ASMString(((StringValue)value).getValue());
		} else if(value instanceof IntegerValue) {
			ret = new ASMInteger(((IntegerValue)value).getValue());
		} else if(value instanceof RealValue) {
			ret = new ASMReal(((RealValue)value).getValue());
		} else if(value instanceof BooleanValue) {
			ret = new ASMBoolean(((BooleanValue)value).getValue());
		} else if(value instanceof NullValue) {
			ret = null;
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
		if(op == null) {
			System.out.println("ERROR: operation not found: " + opName + " on " + object + " : "+ object.getType());
		} else {
			List realArgs = new ArrayList();
			realArgs.add(value2asm(this));
if(debug) System.out.print(object + " : " + object.getType() + "." + opName + "(");
			for(Iterator i = args.iterator() ; i.hasNext() ; ) {
				Value v = (Value)i.next();
if(debug) System.out.print(v + ((i.hasNext()) ? ", " : ""));
				realArgs.add(value2asm(v));
			}
			ASMOclAny o = op.exec(new ADWPStackFrame(op, args).enterFrame(op, realArgs));
			ret = asm2value(o);
if(debug) System.out.print(") = " + o);
if(debug) System.out.println(" => " + ret);
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

