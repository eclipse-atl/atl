package org.atl.engine.vm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.atl.engine.vm.nativelib.ASMOclAny;

/**
 * @author Frédéric Jouault
 */
public class ClassNativeOperation extends NativeOperation {

	// The Method must be static and must have <type> self as a first parameter.
	public ClassNativeOperation(Method method) {
		super(method);
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

