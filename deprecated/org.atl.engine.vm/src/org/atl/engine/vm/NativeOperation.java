package org.atl.engine.vm;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclType;

/**
 * @author Frédéric Jouault
 */
public abstract class NativeOperation implements Operation {

	private static Map trans = new HashMap();
	static {
		trans.put("operatorMinus", "-");
		trans.put("operatorPlus", "+");
		trans.put("operatorMul", "*");
		trans.put("operatorDiv", "/");
		trans.put("operatorEQ", "=");
		trans.put("operatorNE", "<>");
		trans.put("operatorLT", "<");
		trans.put("operatorLE", "<=");
		trans.put("operatorGT", ">");
		trans.put("operatorGE", ">=");
	}

	// The Method must be static and must have <type> self as a first parameter.
	public NativeOperation(Method method) {
		this.method = method;
		name = method.getName();
		if(trans.containsKey(name)) name = (String)trans.get(name);
	}

	public static void registerOperations(ASMOclType t, Class c) {
		registerOperations(t, c, true, false, false, false);
	}

	public static void registerOperations(ASMOclType t, Class c, boolean allowClassLevel, boolean allowInstanceLevel, boolean allowTypeTranslation, boolean allowDontUseFrame) {
		final boolean debug = false;
		for(Iterator i = Arrays.asList(c.getDeclaredMethods()).iterator() ; i.hasNext() ; ) {
			Method m = (Method)i.next();
			if((!allowClassLevel) && ((Modifier.STATIC & m.getModifiers()) != 0)) continue;
			if((!allowInstanceLevel) && ((Modifier.STATIC & m.getModifiers()) == 0)) continue;
			if(((Modifier.PUBLIC & m.getModifiers()) == 0)) continue;

			boolean dontUseFrame = false;
			boolean notGood = false;

			Iterator j = Arrays.asList(m.getParameterTypes()).iterator();
			if(j.hasNext()) {
				Class pt = (Class)j.next();
				if(!pt.equals(StackFrame.class)) {
					if(allowDontUseFrame) {
						dontUseFrame = true;
					} else {
						notGood = true;
if(debug) System.out.println("No StackFrame as first parameter");
					}
				}
				j = Arrays.asList(m.getParameterTypes()).iterator();
			} else {
				if(allowDontUseFrame) {
					dontUseFrame = true;
				} else {
					notGood = true;
if(debug) System.out.println("No StackFrame as first parameter");
				}
			}
			if(!allowTypeTranslation) {
				for( ; j.hasNext() && !notGood ; ) {
					Class pt = (Class)j.next();
					if(!ASMOclAny.class.isAssignableFrom(pt)) {
						notGood = true;
if(debug) System.out.println("Incompatible type as parameter");
					}
				}
			}
			Class rt = m.getReturnType();
			if((!allowTypeTranslation) && (!ASMOclAny.class.isAssignableFrom(rt)) && (!(rt.isPrimitive() && rt.getName().equals("void")))) {
				notGood = true;
if(debug) System.out.println("Incompatible return type");
			}

			if(!notGood) {
				if((Modifier.STATIC & m.getModifiers()) != 0) {
					t.registerVMOperation(new ClassNativeOperation(m));
				} else {
					t.registerVMOperation(new InstanceNativeOperation(m, allowTypeTranslation, dontUseFrame));
				}
			} else {
if(debug) System.err.println("Strange !!! This method is not good: " + m);
			}
		}
	}

	public String getName() {
		return name;
	}

	public String getContext() {
		return null;
	}

	public List getParameters() {
		return null;
	}

	public String getSignature() {
		return null;
	}

	public abstract ASMOclAny exec(StackFrame frame);

	public String toString() {
		return "NativeOperation " + method;
	}

	public Method getMethod() {
		return method;
	}

	private Method method;
	private String name;
}

