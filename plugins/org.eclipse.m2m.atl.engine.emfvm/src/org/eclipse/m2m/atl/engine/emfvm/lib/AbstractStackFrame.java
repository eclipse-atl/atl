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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Stack Frame definition.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class AbstractStackFrame {

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

	/**
	 * Returns the local variables map.
	 * 
	 * @return the local variables map
	 */
	public Map<String, Object> getLocalVariables() {
		Map<String, Object> ret = new HashMap<String, Object>();
		for (int i = 0; i < operation.getMaxLocals(); i++) {
			if (localVars[i] != null) {
				ret.put(Integer.valueOf(i).toString(), localVars[i]);
			}
		}
		return ret;
	}

	/**
	 * Makes the tool enter the frame.
	 * 
	 * @return self
	 */
	public AbstractStackFrame enter() {
		execEnv.enterTools(this);
		return this;
	}

	/**
	 * Makes the tool leave the frame.
	 */
	public void leave() {
		execEnv.leaveTools(this);
	}

	/**
	 * Gets a list of the stacks.
	 * 
	 * @return the Stack list
	 */
	public StackSequence getStack() {
		StackSequence res = new StackSequence();
		AbstractStackFrame tmp = this;
		while (tmp != null) {
			res.add(tmp);
			tmp = tmp.caller;
		}
		Collections.reverse(res);
		return res;
	}

	public String getSourceLocation() {
		return getOperation().resolveLineNumber(getLocation());
	}

	public String getOpName() {
		return operation.getName();
	}

	/**
	 * A Sequence of {@link AbstractStackFrame}.
	 */
	public class StackSequence extends ArrayList<AbstractStackFrame> {

		private static final long serialVersionUID = 1L;

		/**
		 * Returns the stack frame at the given index.
		 * @param index the index
		 * @return the stack frame
		 */
		public AbstractStackFrame at(int index) {
			return this.get(index - 1);
		}

	}

	/**
	 * Returns the current location.
	 * 
	 * @return the current location
	 */
	public abstract int getLocation();
}
