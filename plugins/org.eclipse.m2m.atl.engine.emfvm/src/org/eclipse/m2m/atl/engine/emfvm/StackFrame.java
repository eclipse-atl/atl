/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import org.eclipse.m2m.atl.engine.emfvm.lib.ASMModule;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;


public class StackFrame extends org.eclipse.m2m.atl.engine.emfvm.lib.StackFrame {
	
	// only initialized when there is a VMException to avoid performance impact
	public int pc = -1;

	public StackFrame(ExecEnv execEnv, ASMModule asmModule, Operation operation) {
		super(execEnv, asmModule, operation);
	}
	
	protected StackFrame(StackFrame caller, Operation operation) {
		super(caller, operation);
	}
	
	public org.eclipse.m2m.atl.engine.emfvm.lib.StackFrame newFrame(Operation operation) {
		return new StackFrame(this, operation);
	}

	protected String getLocation() {
		String ret = ((ASMOperation)operation).resolveLineNumber(pc);
		
		if(ret == null) {
			ret = "";
		}
		ret += "#" + pc;

		return ret;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();
		
		if(caller != null) {
			ret.append(caller.toString());
			ret.append('\n'); 
		}
		
		if(operation instanceof ASMOperation) {
			ret.append(((ASMOperation)operation).getName());
			if(operation instanceof ASMOperation) {
				ret.append(": ");
				ASMOperation ao = (ASMOperation)operation;
				String location = getLocation();
				if(location != null) {
					ret.append(location);
					ret.append(' ');
				}
				
				ret.append("\n\tlocal variables: ");
				boolean first = true;
				for(int i = 0 ; i < ao.maxLocals ; i++) {
					String varName = ao.resolveVariableName(i, pc);
					if(varName != null) {
						if(!first)
							ret.append(", ");
						first = false;
						ret.append(varName);
						ret.append('=');
						ret.append(localVars[i]);
					}
				}
			}
		} else
			ret.append("<native>");
		
		return ret.toString();
	}
}
