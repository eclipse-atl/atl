/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

/**
 * Abstract Stack Frame definition.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class AbstractStackFrame {

	// public static final int MAX_VARS = 100;

	/** The execution environment. */
	protected ExecEnv execEnv;

	protected AbstractStackFrame caller;

	protected Operation operation;

	/** The local variables list. */
	protected Object[] localVars;

	private ASMModule asmModule;

	/**
	 * Creates a new {@link AbstractStackFrame} with the given parameters.
	 * 
	 * @param execEnv
	 *            the execution environment
	 * @param asmModule
	 *            the transformation module
	 * @param operation
	 *            the main operation
	 */
	public AbstractStackFrame(ExecEnv execEnv, ASMModule asmModule, Operation operation) {
		this(null, operation);
		this.execEnv = execEnv;
		this.asmModule = asmModule;
		localVars[0] = asmModule;
	}

	/**
	 * Creates a new StackFrame.
	 * 
	 * @param caller
	 *            the parent stack frame
	 * @param frameOperation
	 *            the operation
	 */
	protected AbstractStackFrame(AbstractStackFrame caller, Operation frameOperation) {
		this.caller = caller;
		this.operation = frameOperation;
		if (caller != null) {
			this.execEnv = caller.execEnv;
			this.asmModule = caller.asmModule;
		}
		localVars = new Object[frameOperation.getMaxLocals()];
	}
		
	/**
	 * Creates an empty StackFrame which refers to its {@link ExecEnv}.
	 * 
	 * @param execEnv
	 *            the {@link ExecEnv}
	 */
	protected AbstractStackFrame(ExecEnv execEnv) {
		this.execEnv = execEnv;
	}

	/**
	 * Returns a new frame for the given operation.
	 * 
	 * @param frameOperation
	 *            the frame operation
	 * @return a new frame for the given operation
	 */
	public abstract AbstractStackFrame newFrame(Operation frameOperation);

	public ASMModule getAsmModule() {
		return asmModule;
	}

	public Object[] getLocalVars() {
		return localVars;
	}

	public void setLocalVars(Object[] localVars) {
		this.localVars = localVars;
	}

	public ExecEnv getExecEnv() {
		return execEnv;
	}
	
	public Operation getOperation() {
		return operation;
	}

	public AbstractStackFrame getCaller() {
		return caller;
	}

}
