package org.atl.engine.vm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclType;

/**
 * @author Frédéric Jouault
 */
public class ClassNativeOperation extends NativeOperation {

	// The Method must be static and must have <type> self as a first parameter.
	public ClassNativeOperation(Method method, List parameters, ASMOclType returnType, ASMOclType contextType) {
		super(method, parameters, returnType, contextType);
	}

	public ClassNativeOperation(Method method) {
		super(method, getParameters(method), getReturnType(method), getContextType(method));
	}
	
	private static List getParameters(Method method) {
		List ret = new ArrayList();
		
		Class paramTypes[] = method.getParameterTypes();
		for(int i = 2 ; i < paramTypes.length ; i++) {	// paramTypes[0] is a StackFrame
														// paramTypes[1] is self
			ret.add(getASMType(paramTypes[i], false));
		}
		
		return ret;
	}

	private static ASMOclType getReturnType(Method method) {
		ASMOclType ret = null;
		
		ret = getASMType(method.getReturnType(), false);
		
		return ret;
	}

	private static ASMOclType getContextType(Method method) {
		ASMOclType ret = null;
		
		ret = getASMType(method.getParameterTypes()[1], false);
		
		return ret;
	}

	public ASMOclAny exec(StackFrame frame) {
		ASMOclAny ret = null;

		try {
			List args = new ArrayList(frame.getArgs());
			args.add(0, frame);
			ret = (ASMOclAny)getMethod().invoke(null, args.toArray());
		} catch(IllegalAccessException iae) {
			frame.printStackTrace(iae);
			ret = null;
		} catch(IllegalArgumentException iae2) {
			frame.printStackTrace(iae2);
			ret = null;
		} catch(InvocationTargetException ite) {
			frame.printStackTrace(ite);
			ret = null;
		}
		((NativeStackFrame)frame).setRet(ret);
		frame.leaveFrame();

		return ret;
	}
}

