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
package org.eclipse.m2m.atl.engine.emfvm.lib;



public abstract class StackFrame {
	
	public static final int MAX_VARS = 100;

	public ExecEnv execEnv;
	public Object[] localVars;
	public StackFrame caller;
	public Operation operation;

	public ASMModule asmModule;
	
	public StackFrame(ExecEnv execEnv, ASMModule asmModule, Operation operation) {
		this(null, operation);
		this.execEnv = execEnv;
		this.asmModule = asmModule;
		localVars[0] = asmModule;
	}
	
	protected StackFrame(StackFrame caller, Operation operation) {
		this.caller = caller;
		this.operation = operation;
		if(caller != null) {
			this.execEnv = caller.execEnv;
			this.asmModule = caller.asmModule;
		}
		localVars = new Object[operation.getMaxLocals()];
	}
	
	public abstract StackFrame newFrame(Operation operation);
}
