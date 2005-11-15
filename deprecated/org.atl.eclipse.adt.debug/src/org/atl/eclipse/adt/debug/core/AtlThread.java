/*
 * Created on 10 mai 2004
 */
package org.atl.eclipse.adt.debug.core;

import java.util.Arrays;

import org.atl.eclipse.adt.debug.AtlDebugPlugin;
import org.atl.engine.vm.adwp.ADWP;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;


/**
 * @author Freddy Allilaire
 */
public class AtlThread implements IThread {

	private String threadName;
	private AtlDebugTarget atlDT;
	private AtlStackFrame stackFrames[];

	public AtlThread(String name, AtlDebugTarget atlDT) {
		this.threadName = name;
		this.atlDT = atlDT;
		this.stackFrames = null;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IThread#getStackFrames()
	 */
	public IStackFrame[] getStackFrames() throws DebugException {
		if(!isSuspended())
			return null;
		return stackFrames;
	}
	/**
	 * @see org.eclipse.debug.core.model.IThread#hasStackFrames()
	 */
	public boolean hasStackFrames() throws DebugException {
		if(!isSuspended())
			return false;
		return ((getStackFrames() != null) && (getStackFrames().length > 0))?true:false;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IThread#getPriority()
	 */
	public int getPriority() throws DebugException {
		return 0;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IThread#getTopStackFrame()
	 */
	public IStackFrame getTopStackFrame() throws DebugException {
		if (hasStackFrames())
			return getStackFrames()[0];
		else
			return null;
	}

	/**
	 * @see org.eclipse.debug.core.model.IThread#getName()
	 */
	public String getName() throws DebugException {
		return threadName;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IThread#getBreakpoints()
	 */
	public IBreakpoint[] getBreakpoints() {
		String modelId = getModelIdentifier();
		return DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(modelId);
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return AtlDebugPlugin.getUniqueIdentifier();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return atlDT;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return atlDT.getLaunch();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return atlDT.canResume();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return atlDT.canSuspend();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return atlDT.isSuspended();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		atlDT.resume();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		atlDT.suspend();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	public boolean canStepInto() {
		return atlDT.isSuspended();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	public boolean canStepOver() {
		return atlDT.isSuspended();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	public boolean canStepReturn() {
		return atlDT.isSuspended();
	}

	/**
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	public boolean isStepping() {
		return false;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	public void stepInto() throws DebugException {
		if (canStepInto()) {
			atlDT.setState(AtlDebugTarget.stateRunning);
			atlDT.generateDebugEvent(AtlDebugTarget.STEP_INTO, this);
			atlDT.getDebugger().sendCommand(ADWP.CMD_STEP, Arrays.asList(new Object[]{}));
		}
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	public void stepOver() throws DebugException {
		if (canStepOver()) {
			atlDT.setState(AtlDebugTarget.stateRunning);
			atlDT.generateDebugEvent(AtlDebugTarget.STEP_OVER, this);
			atlDT.getDebugger().sendCommand(ADWP.CMD_STEP_OVER, Arrays.asList(new Object[]{}));
		}
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	public void stepReturn() throws DebugException {
		
		if (canStepReturn()) {
			atlDT.setPrevLocation(null);
			atlDT.setState(AtlDebugTarget.stateRunning);
			atlDT.generateDebugEvent(AtlDebugTarget.STEP_RETURN, this);
			atlDT.getDebugger().sendCommand(ADWP.CMD_FINISH, Arrays.asList(new Object[]{}));
		}
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return atlDT.canTerminate();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return atlDT.isTerminated();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		atlDT.terminate();
	}
	
	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		return null;
	}
	
	/**
	 * This method allow to update the array of stackFrames 
	 * @param frames
	 */
	public void setStackFrames(AtlStackFrame[] frames) {
		this.stackFrames = frames;
	}
}