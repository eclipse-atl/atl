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
package org.eclipse.m2m.atl.engine.emfvm;

import org.eclipse.m2m.atl.engine.emfvm.lib.ASMModule;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.engine.emfvm.lib.ExecEnv;
import org.eclipse.m2m.atl.engine.emfvm.lib.Operation;

/**
 * The Stack Frame implementation.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class StackFrame extends AbstractStackFrame {

	/** only initialized when there is a VMException to avoid performance impact. */
	private int pc = -1;

	/**
	 * Creates a new {@link StackFrame} with the given parameters.
	 * 
	 * @param execEnv
	 *            the execution environment
	 * @param asmModule
	 *            the transformation module
	 * @param operation
	 *            the main operation
	 */
	public StackFrame(ExecEnv execEnv, ASMModule asmModule, Operation operation) {
		super(execEnv, asmModule, operation);
	}

	/**
	 * Creates a new StackFrame.
	 * 
	 * @param caller
	 *            the parent stack frame
	 * @param operation
	 *            the operation
	 */
	protected StackFrame(StackFrame caller, Operation operation) {
		super(caller, operation);
	}

	/**
	 * Creates an empty StackFrame which refers to its {@link ExecEnv}.
	 * 
	 * @param execEnv
	 *            the {@link ExecEnv}
	 */
	public StackFrame(ExecEnv execEnv) {
		super(execEnv);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame#newFrame(org.eclipse.m2m.atl.engine.emfvm.lib.Operation)
	 */
	@Override
	public org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame newFrame(Operation operation) {
		return new StackFrame(this, operation);
	}

	/**
	 * Returns the current location.
	 * 
	 * @return the current location
	 */
	protected String getStringLocation() {
		String ret = ((ASMOperation)operation).resolveLineNumber(pc);

		if (ret == null) {
			ret = ""; //$NON-NLS-1$
		}
		ret += "#" + pc; //$NON-NLS-1$
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame#getLocation()
	 */
	@Override
	public int getLocation() {
		return pc;
	}

	/**
	 * Returns the variable name at the given slot.
	 * 
	 * @param slot
	 *            the slot
	 * @return the variable name at the given slot
	 */
	public String resolveVariableName(int slot) {
		return getOperation().resolveVariableName(slot, pc);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer();
		if (operation instanceof ASMOperation) {
			ret.append("\tat "); //$NON-NLS-1$
			ret.append(((ASMOperation)operation).getName());
			ret.append('(');
			ret.append(((ASMOperation)operation).getASM().getName() + ".atl"); //$NON-NLS-1$

			String location = getStringLocation();
			if (location != null) {
				if (location.matches("[0-9]*:[0-9]*-[0-9]*:[0-9]*#[0-9]*")) { //$NON-NLS-1$
					ret.append('[' + location.split("#")[0] + ']'); //$NON-NLS-1$
				}
			}
			ret.append(')');
			ret.append("\n\t\tlocal variables: "); //$NON-NLS-1$
			boolean first = true;
			ASMOperation ao = (ASMOperation)operation;
			for (int i = 0; i < ao.getMaxLocals(); i++) {
				String varName = ao.resolveVariableName(i, pc);
				if (varName != null) {
					if (!first) {
						ret.append(", "); //$NON-NLS-1$
					}
					first = false;
					ret.append(varName);
					ret.append('=');
					ret.append(getExecEnv().toPrettyPrintedString(localVars[i]));
				}
			}
		} else {
			ret.append("<native>"); //$NON-NLS-1$
		}
		if (caller != null) {
			ret.append('\n');
			ret.append(caller.toString());
		}
		return ret.toString();
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}
}
