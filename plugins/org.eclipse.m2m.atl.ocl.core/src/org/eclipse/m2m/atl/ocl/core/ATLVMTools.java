package org.eclipse.m2m.atl.ocl.core;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ClassNativeOperation;
import org.eclipse.m2m.atl.engine.vm.Operation;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;

/**
 * 
 * @author Frédéric Jouault
 *
 */
public abstract class ATLVMTools {
	
	public static Operation toVMOperation(Class cl, String name) throws Exception {
		Operation ret = null;
		
		Method m = null;
		
		for(Iterator i = Arrays.asList(cl.getDeclaredMethods()).iterator() ; i.hasNext() && (m == null) ; ) {
			Method me = (Method)i.next();
			if(me.getName().equals(name)) {
				m = me;
			}
		}
		
		if(m != null) {
			ret = new ClassNativeOperation(m);
		}

		return ret;
	}
	
	public static void addVMOperation(ASMOclType context, Operation op) {
		((Map)ASMOclType.getVMOperations().get(context)).put(op.getName(), op);		
	}
}
