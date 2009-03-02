/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.m2m.atl.common.AtlNbCharFile;
import org.eclipse.m2m.atl.engine.vm.adwp.ADWPDebugger;
import org.eclipse.m2m.atl.engine.vm.adwp.IntegerValue;
import org.eclipse.m2m.atl.engine.vm.adwp.ObjectReference;
import org.eclipse.m2m.atl.engine.vm.adwp.StringValue;
import org.eclipse.m2m.atl.engine.vm.adwp.Value;

/**
 * This class implements IStackFrame It contains a stackframe.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlStackFrame extends AtlDebugElement implements IStackFrame {

	private ObjectReference stackFrame;

	private AtlThread thread;

	private int charStart = -1;

	// private int startLine = -1;
	private int charEnd = -1;

	private int location = -1;

	private String opName;

	// private AtlNbCharFile atlnbcharfile;
	private Map vars = new HashMap();

	private IFile sourcefile;

	/**
	 * Creates a new AtlStackFrame for Eclipse-based debugging.
	 * 
	 * @param thread
	 *            The ATL execution thread
	 * @param stackFrame
	 *            The ASMStackFrame to encapsulate
	 * @param atlnbcharfile
	 *            The source code lookup helper
	 * @param sourcefile
	 *            The file containing the source code
	 */
	public AtlStackFrame(AtlThread thread, ObjectReference stackFrame, AtlNbCharFile atlnbcharfile,
			IFile sourcefile) {
		super((AtlDebugTarget)thread.getDebugTarget());
		this.thread = thread;
		this.stackFrame = stackFrame;
		this.sourcefile = sourcefile;
		Value slv = stackFrame.call("getSourceLocation", new ArrayList()); //$NON-NLS-1$
		String sourceLocation = null;
		if (slv instanceof StringValue) {
			sourceLocation = ((StringValue)slv).getValue();
		}
		if (sourceLocation != null) {
			int[] sl = atlnbcharfile.getIndexChar(sourceLocation);
			charStart = sl[0];
			charEnd = sl[1];
		}
		location = ((IntegerValue)stackFrame.call("getLocation", new ArrayList())).getValue(); //$NON-NLS-1$
		this.opName = ((StringValue)stackFrame.call("getOpName", new ArrayList())).getValue(); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getThread()
	 */
	public IThread getThread() {
		return thread;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getVariables()
	 */
	public IVariable[] getVariables() throws DebugException {
		// IVariable ret[] = null;
		// Map of local variables
		ObjectReference lvs = (ObjectReference)stackFrame.call("getLocalVariables", new ArrayList()); //$NON-NLS-1$
		// Set of local variable names
		ObjectReference lvns = (ObjectReference)lvs.call("getKeys", new ArrayList()); //$NON-NLS-1$
		// Sequence of local variable names
		lvns = (ObjectReference)lvns.call("asSequence", new ArrayList()); //$NON-NLS-1$
		// number of localVariables
		IntegerValue nblvs = (IntegerValue)lvns.call("size", new ArrayList()); //$NON-NLS-1$
		List atlVars = new ArrayList();
		for (int i = 1; i <= nblvs.getValue(); i++) {
			StringValue name = (StringValue)(lvns.call(
					"at", Arrays.asList(new Object[] {IntegerValue.valueOf(i)}))); //$NON-NLS-1$
			Value value = lvs.call("get", Arrays.asList(new Object[] {name})); //$NON-NLS-1$
			AtlValue atlValue = new AtlValue(value, (AtlDebugTarget)thread.getDebugTarget());

			if (name.getValue().matches("^[0-9]*$")) { //$NON-NLS-1$
				Value val = stackFrame
						.call(
								"resolveVariableName", Arrays.asList(new Object[] {IntegerValue.valueOf(Integer.parseInt(name.getValue()))})); //$NON-NLS-1$
				if (val instanceof StringValue) {
					name = (StringValue)val;
				}
			} else if (!((AtlDebugTarget)thread.getDebugTarget()).isDisassemblyMode()) {
				continue;
			}

			String sname = name.toString();
			AtlVariable atlVariable = (AtlVariable)vars.get(sname);
			if (atlVariable == null) {
				atlVariable = new AtlVariable(name.toString(), atlValue, (AtlDebugTarget)thread
						.getDebugTarget(), AtlVariable.LOCALVARIABLE);
				vars.put(sname, atlVariable);
			} else {
				atlVariable.setValue(atlValue);
			}

			atlVars.add(atlVariable);
		}
		return (IVariable[])atlVars.toArray(new IVariable[0]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#hasVariables()
	 */
	public boolean hasVariables() throws DebugException {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getLineNumber()
	 */
	public int getLineNumber() throws DebugException {
		int ret = -1;

		if (((AtlDebugTarget)thread.getDebugTarget()).isDisassemblyMode()) {
			ret = location + 1;
		}

		return ret;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharStart()
	 */
	public int getCharStart() throws DebugException {
		int ret = -1;

		if (!((AtlDebugTarget)thread.getDebugTarget()).isDisassemblyMode()) {
			ret = charStart;
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharEnd()
	 */
	public int getCharEnd() throws DebugException {
		int ret = -1;

		if (!((AtlDebugTarget)thread.getDebugTarget()).isDisassemblyMode()) {
			ret = charEnd;
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getName()
	 */
	public String getName() throws DebugException {
		String ret = null;

		if ((charStart == -1) || ((AtlDebugTarget)getDebugTarget()).isDisassemblyMode()) {
			ret = opName + "() location: " + location; //$NON-NLS-1$
		} else {
			ret = opName + "() location: " + charStart + ":" + charEnd; //$NON-NLS-1$//$NON-NLS-2$
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getRegisterGroups()
	 */
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#hasRegisterGroups()
	 */
	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return thread.getModelIdentifier();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return thread.getDebugTarget();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.debug.core.AtlDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return thread.getLaunch();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	public boolean canStepInto() {
		return thread.canStepInto();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	public boolean canStepOver() {
		return thread.canStepOver();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	public boolean isStepping() {
		return thread.isStepping();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return thread.canResume();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return thread.canSuspend();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return thread.isSuspended();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		thread.resume();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		thread.suspend();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return thread.canTerminate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return thread.isTerminated();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		thread.terminate();
	}

	/**
	 * Stores disassembly.
	 */
	private class DisassemblyStorage implements IStorage {

		private String contents;

		private String name;

		public DisassemblyStorage(String name, String contents) {
			this.contents = contents;
			this.name = name;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.core.resources.IStorage#getContents()
		 */
		public InputStream getContents() throws CoreException {
			return new ByteArrayInputStream(contents.getBytes());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.core.resources.IStorage#getFullPath()
		 */
		public IPath getFullPath() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.core.resources.IStorage#getName()
		 */
		public String getName() {
			return name;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.core.resources.IStorage#isReadOnly()
		 */
		public boolean isReadOnly() {
			return true;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
		 */
		public Object getAdapter(Class adapter) {
			return null;
		}
	}

	/**
	 * Returns the disassembled IStorage.
	 * 
	 * @return the disassembled IStorage
	 */
	public IStorage getDisassembled() {
		StringBuffer ret = new StringBuffer();
		int k = 0;

		ADWPDebugger debugger = ((AtlDebugTarget)thread.getDebugTarget()).getDebugger();
		List l = debugger.requestMessage(ADWPDebugger.CMD_DISASSEMBLE,
				Arrays.asList(new Object[] {stackFrame})).getArgs();
		for (Iterator i = l.iterator(); i.hasNext();) {
			ret.append("<" + opName + "+" + k++ + ">\t" + i.next()); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
			ret.append("\n"); //$NON-NLS-1$
		}

		return new DisassemblyStorage("ATL#" + opName, ret.toString()); //$NON-NLS-1$
	}

	public ObjectReference getStackFrame() {
		return stackFrame;
	}

	/**
	 * Returns the ATL source code file that is being executed in this stack frame.
	 * 
	 * @return The ATL source code file that is being executed in this stack frame
	 */
	public IFile getSourcefile() {
		return sourcefile;
	}

}
