package org.atl.engine.vm;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.atl.engine.vm.nativelib.ASMBag;
import org.atl.engine.vm.nativelib.ASMBoolean;
import org.atl.engine.vm.nativelib.ASMInteger;
import org.atl.engine.vm.nativelib.ASMMap;
import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclType;
import org.atl.engine.vm.nativelib.ASMReal;
import org.atl.engine.vm.nativelib.ASMSequence;
import org.atl.engine.vm.nativelib.ASMSet;
import org.atl.engine.vm.nativelib.ASMString;

/**
 * @author Frédéric Jouault
 */
public abstract class NativeOperation extends Operation {

	private static Map trans;

	private static Map getTrans() {
		if(trans == null) {
			trans = new HashMap();
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
		return trans;
	}

	// The Method must be static and must have <type> self as a first parameter.
	public NativeOperation(Method method, List parameters, ASMOclType returnType) {
		this.method = method;
		this.parameters = parameters;
		this.returnType = returnType;
		name = method.getName();
		if(getTrans().containsKey(name)) name = (String)getTrans().get(name);
	}

	public static void registerOperations(ASMOclType t, Class c) {
		registerOperations(t, c, true, false, false, false);
	}

	public static void registerOperations(ASMOclType t, Class c, boolean allowClassLevel, boolean allowInstanceLevel, boolean allowTypeTranslation, boolean allowDontUseFrame) {
		final boolean debug = false;
		for(Iterator i = Arrays.asList(c.getDeclaredMethods()).iterator() ; i.hasNext() ; ) {
			Method m = (Method)i.next();
			boolean isStatic = ((Modifier.STATIC & m.getModifiers()) != 0);
			if((!allowClassLevel) && isStatic) continue;
			if((!allowInstanceLevel) && !isStatic) continue;
			if(((Modifier.PUBLIC & m.getModifiers()) == 0)) continue;

			boolean dontUseFrame = false;
			boolean notGood = false;

			Iterator j = Arrays.asList(m.getParameterTypes()).iterator();
			List parameters = new ArrayList();
			if(j.hasNext()) {
				Class pt = (Class)j.next();
				if(!pt.equals(StackFrame.class)) {
					if(allowDontUseFrame) {
						dontUseFrame = true;
					} else {
						notGood = true;
if(debug) System.out.println("No StackFrame as first parameter");
					}
					j = Arrays.asList(m.getParameterTypes()).iterator();
				}
				if(!isStatic) {
					j = Arrays.asList(m.getParameterTypes()).iterator();
				}
			} else {
				if(allowDontUseFrame) {
					dontUseFrame = true;
				} else {
					notGood = true;
if(debug) System.out.println("No StackFrame as first parameter");
				}
			}
			for( ; j.hasNext() && !notGood ; ) {
				Class pt = (Class)j.next();
				ASMOclType paramType = getASMType(pt, allowTypeTranslation);
				if(paramType == null) {
					notGood = true;
					if(debug) System.out.println("Incompatible type as parameter");
				} else {
					parameters.add(paramType);
				}
			}

			Class rt = m.getReturnType();
			ASMOclType returnType = getASMType(rt, allowTypeTranslation);
			if((returnType == null) && (!(rt.isPrimitive() && rt.getName().equals("void")))) {
				notGood = true;
if(debug) System.out.println("Incompatible return type");
			}

			if(!notGood) {
				if((Modifier.STATIC & m.getModifiers()) != 0) {
					t.registerVMOperation(new ClassNativeOperation(m, parameters, returnType));
				} else {
					t.registerVMOperation(new InstanceNativeOperation(m, allowTypeTranslation, dontUseFrame, parameters, returnType));
				}
			} else {
if(debug) System.err.println("Strange !!! This method is not good: " + m);
			}
		}
	}
	
	protected static ASMOclType getASMType(Class pt, boolean allowTypeTranslation) {
		ASMOclType ret = null;
		
		if(ASMOclAny.class.isAssignableFrom(pt)) {
			if(ASMOclAny.class.equals(pt)) {
				ret = ASMOclAny.getOclAnyType();
			} else {
				try {
					ret = (ASMOclType)pt.getField("myType").get(null);
				} catch(IllegalAccessException iae) {
				} catch(NoSuchFieldException iae) {}
			}
		} else if(allowTypeTranslation) {
			if(pt.equals(Integer.TYPE) || pt.equals(Integer.class)) {
				ret = ASMInteger.myType;
			} else if(pt.equals(Double.TYPE) || pt.equals(Double.class) ||
					pt.equals(Float.TYPE) || pt.equals(Float.class)) {
				ret = ASMReal.myType;
			} else if(pt.equals(Boolean.TYPE) || pt.equals(Boolean.class)) {
				ret = ASMBoolean.myType;
			} else if(pt.equals(String.class)) {
				ret = ASMString.myType;
			} else if(pt.equals(List.class)) {
				ret = ASMSequence.myType;
			} else if(pt.equals(Set.class)) {
				ret = ASMSet.myType;
			} else if(pt.equals(Collection.class)) {
				ret = ASMBag.myType;
			} else if(pt.equals(Map.class)) {
				ret = ASMMap.myType;
			} else {	// TODO: collections
				ret = null;	// untranslatable type
			}
		} else {
			ret = null;		// not a valid type
		}
		
		return ret;
	}

	public String getName() {
		return name;
	}

	public String getContext() {
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

	public List getParameters() {
		return parameters;
	}

	public ASMOclType getReturnType() {
		return returnType;
	}

	private List parameters;
	private ASMOclType returnType;
	private Method method;
	private String name;	
}

