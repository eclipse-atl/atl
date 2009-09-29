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
package org.eclipse.m2m.atl.debug.core;

import java.util.Arrays;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.m2m.atl.debug.core.adwp.ADWP;
import org.eclipse.m2m.atl.debug.core.adwp.Value;

/**
 * The ATL thread definition (for debug).
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlThread extends AtlDebugElement implements IThread {

	private String threadName;

	private AtlDebugTarget atlDT;

	private AtlStackFrame[] stackFrames;

	/**
	 * COnstructor.
	 * 
	 * @param name the thread name
	 * @param atlDT the debug target
	 */
	public AtlThread(String name, AtlDebugTarget atlDT) {
		super(atlDT);
		this.threadName = name;
		this.atlDT = atlDT;
		this.stackFrames = null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IThread#getStackFrames()
	 */
	public IStackFrame[] getStackFrames() throws DebugException {
		if (!isSuspended()) {
			return new IStackFrame[0];
		}
		return stackFrames;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IThread#hasStackFrames()
	 */
	public boolean hasStackFrames() throws DebugException {
		if (!isSuspended()) {
			return false;
		}
		return ((getStackFrames() != null) && (getStackFrames().length > 0)) ? true : false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IThread#getPriority()
	 */
	public int getPriority() throws DebugException {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IThread#getTopStackFrame()
	 */
	public IStackFrame getTopStackFrame() throws DebugException {
		if (hasStackFrames()) {
			return getStackFrames()[0];
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IThread#getName()
	 */
	public String getName() throws DebugException {
		return threadName;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IThread#getBreakpoints()
	 */
	public IBreakpoint[] getBreakpoints() {
		String modelId = getModelIdentifier();
		return DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(modelId);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.debug.core.AtlDebugElement#getDebugTarget()
	 */
	@Override
	public IDebugTarget getDebugTarget() {
		return atlDT;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.debug.core.AtlDebugElement#getLaunch()
	 */
	@Override
	public ILaunch getLaunch() {
		return atlDT.getLaunch();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return atlDT.canResume();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return atlDT.canSuspend();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return atlDT.isSuspended();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		atlDT.resume();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		atlDT.suspend();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	public boolean canStepInto() {
		return atlDT.isSuspended();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	public boolean canStepOver() {
		return atlDT.isSuspended();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	public boolean canStepReturn() {
		return atlDT.isSuspended();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	public boolean isStepping() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	public void stepInto() throws DebugException {
		if (canStepInto()) {
			atlDT.setState(AtlDebugTarget.STATE_RUNNING);
			atlDT.generateDebugEvent(AtlDebugTarget.STEP_INTO, this);
			atlDT.getDebugger().sendCommand(ADWP.CMD_STEP, Arrays.asList(new Value[] {}));
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	public void stepOver() throws DebugException {
		if (canStepOver()) {
			atlDT.setState(AtlDebugTarget.STATE_RUNNING);
			atlDT.generateDebugEvent(AtlDebugTarget.STEP_OVER, this);
			atlDT.getDebugger().sendCommand(ADWP.CMD_STEP_OVER, Arrays.asList(new Value[] {}));
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	public void stepReturn() throws DebugException {

		if (canStepReturn()) {
			atlDT.setPrevLocation(null);
			atlDT.setState(AtlDebugTarget.STATE_RUNNING);
			atlDT.generateDebugEvent(AtlDebugTarget.STEP_RETURN, this);
			atlDT.getDebugger().sendCommand(ADWP.CMD_FINISH, Arrays.asList(new Value[] {}));
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return atlDT.canTerminate();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return atlDT.isTerminated();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		atlDT.terminate();
	}

	/**
	 * This method allow to update the array of stackFrames.
	 * 
	 * @param frames the frames to update
	 */
	public void setStackFrames(AtlStackFrame[] frames) {
		this.stackFrames = frames;
	}

}
