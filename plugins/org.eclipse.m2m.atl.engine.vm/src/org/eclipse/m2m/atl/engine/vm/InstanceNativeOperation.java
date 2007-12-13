/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBag;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMBoolean;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMInteger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMMap;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMSequence;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMSet;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * @author Frédéric Jouault
 */
public class InstanceNativeOperation extends NativeOperation {

	// The Method must be non-static and defined in the context of the type it applies on
	public InstanceNativeOperation(Method method, boolean translateTypes, boolean dontUseFrame, List parameters, ASMOclType returnType, ASMOclType contextType) {
		super(method, parameters, returnType, contextType);
		this.translateTypes = translateTypes;
		this.dontUseFrame = dontUseFrame;
	}

	public ASMOclAny exec(StackFrame frame) {
		ASMOclAny ret = null;

		try {
			Object self = null;
			List args = new ArrayList();
			boolean isFirst = true;

			for(Iterator i = frame.getArgs().iterator(), j = Arrays.asList(getMethod().getParameterTypes()).iterator() ; i.hasNext() ; ) {
				if(isFirst) {
					self = i.next();
					isFirst = false;
				} else {
					Object o = i.next();
					Class type = (Class)j.next();
					if(ASMOclAny.class.isAssignableFrom(type)) {
						// nothing to do
					} else if(!translateTypes) {
						frame.printStackTrace("ERROR: type translation not allowed but " + o + " is of type " + o.getClass() + ".");
					} else if(type.equals(String.class) && (o instanceof ASMString)) {
						o = ((ASMString)o).getSymbol();
					} else if(type.isPrimitive() && type.getName().equals("int") && (o instanceof ASMInteger)) {
						o = new Integer(((ASMInteger)o).getSymbol());
					} else if(type.isPrimitive() && type.getName().equals("boolean") && (o instanceof ASMBoolean)) {
						o = new Boolean(((ASMBoolean)o).getSymbol());
					} else {
						frame.printStackTrace("ERROR: cannot convert " + o + " to " + type + ".");
					}
					args.add(o);
				}
			}

			if(!dontUseFrame)
				args.add(0, frame);
			Object r = getMethod().invoke(self, args.toArray());
			ret = java2ASM(frame, r);
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

	private ASMOclAny java2ASM(StackFrame frame, Object r) {
		ASMOclAny ret = null;

		if(r == null) {
			ret = null;
		} else if(r instanceof ASMOclAny) {
			ret = (ASMOclAny)r;
		} else if(r instanceof Boolean) {
			ret = new ASMBoolean(((Boolean)r).booleanValue());
		} else if(r instanceof Integer) {
			ret = new ASMInteger(((Integer)r).intValue());
		} else if(r instanceof String) {
			ret = new ASMString((String)r);
		} else if(r instanceof List) {
			ret = new ASMSequence();
			for(Iterator i = ((List)r).iterator() ; i.hasNext() ; )
				((ASMSequence)ret).add(java2ASM(frame, i.next()));
		} else if(r instanceof Set) {
			ret = new ASMSet();
			for(Iterator i = ((Set)r).iterator() ; i.hasNext() ; )
				((ASMSet)ret).add(java2ASM(frame, i.next()));
		} else if(r instanceof Collection) {
			ret = new ASMBag();
			for(Iterator i = ((Collection)r).iterator() ; i.hasNext() ; )
				((ASMBag)ret).add(java2ASM(frame, i.next()));
		} else if(r instanceof Map) {
			ret = new ASMMap();
			for(Iterator i = ((Map)r).keySet().iterator() ; i.hasNext() ; ) {
				Object key = i.next();
				Object value = ((Map)r).get(key);
				((ASMMap)ret).put(java2ASM(frame, key), java2ASM(frame, value));
			}
		} else {
			frame.printStackTrace("ERROR: cannot convert " + r + " to ASMOclAny.");
		}

		return ret;
	}
	
	public List getParameters() {
		return parameters;
	}

	private List parameters;
	private boolean translateTypes;
	private boolean dontUseFrame;
}

