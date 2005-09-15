/*
 * Created on 10 mai 2004
 */
package org.atl.eclipse.adt.debug.core;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.atl.eclipse.engine.AtlNbCharFile;
import org.atl.engine.vm.adwp.ADWPDebugger;
import org.atl.engine.vm.adwp.IntegerValue;
import org.atl.engine.vm.adwp.ObjectReference;
import org.atl.engine.vm.adwp.StringValue;
import org.atl.engine.vm.adwp.Value;
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

/**
 * This class implements IStackFrame
 * It contains a stackframe
 * 
 * @author allilaire
 */

public class AtlStackFrame implements IStackFrame {

	private ObjectReference stackFrame;
	private AtlThread thread;
	private int charStart = -1;
//	private int startLine = -1;
	private int charEnd = -1;
	private int location = -1;
	private String opName;
//	private AtlNbCharFile atlnbcharfile;
	private Map vars = new HashMap();

	public AtlStackFrame(AtlThread thread, ObjectReference stackFrame, AtlNbCharFile atlnbcharfile) {
		// TODO Add a parameter: File name of file being debugged
		this.thread = thread;
		this.stackFrame = stackFrame;
//		this.atlnbcharfile = atlnbcharfile;
		Value slv = stackFrame.call("getSourceLocation", new ArrayList());
		String sourceLocation = null;
		if(slv instanceof StringValue) sourceLocation = ((StringValue)slv).getValue();
		if(sourceLocation != null) {
			int sl[] = atlnbcharfile.getIndexChar(sourceLocation);
			charStart = sl[0];
			charEnd = sl[1];
		}
		location = ((IntegerValue)stackFrame.call("getLocation", new ArrayList())).getValue();
		this.opName = ((StringValue)stackFrame.call("getOpName", new ArrayList())).getValue();;
	}

	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#getThread()
	 */
	public IThread getThread() 
	{
		return thread;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#getVariables()
	 */
	public IVariable[] getVariables() throws DebugException {
//		IVariable ret[] = null;
		// Map of local variables
		ObjectReference lvs = (ObjectReference)stackFrame.call("getLocalVariables", new ArrayList());
		// Set of local variable names
		ObjectReference lvns = (ObjectReference)lvs.call("getKeys", new ArrayList());
		// Sequence of local variable names
		lvns = (ObjectReference)lvns.call("asSequence", new ArrayList());
		// number of localVariables
		IntegerValue nblvs = (IntegerValue)lvns.call("size", new ArrayList());
		List atlVars = new ArrayList();
		for(int i = 1 ; i <= nblvs.getValue() ; i++) 
		{
			StringValue name = (StringValue)(lvns.call("at", Arrays.asList(new Object[] {IntegerValue.valueOf(i)})));
         	Value value = lvs.call("get", Arrays.asList(new Object[] {name}));
         	AtlValue atlValue = new AtlValue(value, (AtlDebugTarget)thread.getDebugTarget());
         	
         	if(name.getValue().matches("^[0-9]*$")) {
         		Value val = stackFrame.call("resolveVariableName", Arrays.asList(new Object[] {IntegerValue.valueOf(Integer.parseInt(name.getValue()))}));
         		if(val instanceof StringValue) {
         			name = (StringValue)val;
         		}
         	} else if(!((AtlDebugTarget)thread.getDebugTarget()).isDisassemblyMode()) {
         		continue;
         	}
         	
         	String sname = name.toString();
         	AtlVariable atlVariable = (AtlVariable)vars.get(sname);
         	if(atlVariable == null) {
         		atlVariable = new AtlVariable(name.toString(), atlValue, (AtlDebugTarget)thread.getDebugTarget(), AtlVariable.LOCALVARIABLE);
         		vars.put(sname, atlVariable);
         	} else {
         		atlVariable.setValue(atlValue);
         	}
 			
 			
 			
 			atlVars.add(atlVariable);

 /*
         	else {
         		System.out.println("ERROR: variable " + name + " is named " + val + " : " + val.getClass() + " which is not a StringValue => renamed as null-name");
         		AtlVariable atlVariable = new AtlVariable( "null-name", atlValue, (AtlDebugTarget)thread.getDebugTarget(), AtlVariable.LOCALVARIABLE);
         		atlVars[i-1] = atlVariable;
         	}
*/
		}
		return (IVariable[])atlVars.toArray(new IVariable[0]);
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#hasVariables()
	 */
	public boolean hasVariables() throws DebugException 
	{		
		return true;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#getLineNumber()
	 */
	public int getLineNumber() throws DebugException {
		int ret = -1;
		
		if(((AtlDebugTarget)thread.getDebugTarget()).isDisassemblyMode()) {
			ret = location + 1;
		}
		
		return ret;

	}

	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharStart()
	 */
	public int getCharStart() throws DebugException {
		int ret = -1;

		if(!((AtlDebugTarget)thread.getDebugTarget()).isDisassemblyMode()) {
			ret = charStart;
		}
		
		return ret;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharEnd()
	 */
	public int getCharEnd() throws DebugException {
		int ret = -1;

		if(!((AtlDebugTarget)thread.getDebugTarget()).isDisassemblyMode()) {
			ret = charEnd;
		}
		
		return ret;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#getName()
	 */
	public String getName() throws DebugException {
		String ret = null;
		
		if((charStart == -1) || ((AtlDebugTarget)getDebugTarget()).isDisassemblyMode()) {
			ret = opName +  "() location: " + location;	
		} else {
			ret = opName +  "() location: " + charStart + ":" + charEnd;
		}
		
		return ret;
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#getRegisterGroups()
	 */
	public IRegisterGroup[] getRegisterGroups() throws DebugException 
	{
		return null;		
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#hasRegisterGroups()
	 */
	public boolean hasRegisterGroups() throws DebugException 
	{		
		return false;
	}
	
	/** 
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return thread.getModelIdentifier();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return thread.getDebugTarget();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return thread.getLaunch();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	public boolean canStepInto() {
		return thread.canStepInto();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	public boolean canStepOver() {
		return thread.canStepOver();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	public boolean canStepReturn() {
		return thread.canStepReturn();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	public boolean isStepping() {
		return thread.isStepping();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	public void stepInto() throws DebugException {
		thread.stepInto();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	public void stepOver() throws DebugException {
		thread.stepOver();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return thread.canResume();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return thread.canSuspend();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return thread.isSuspended();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		thread.resume();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		thread.suspend();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return thread.canTerminate();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return thread.isTerminated();
	}
	
	/**
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		thread.terminate();
	}
	
	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		return null;
	}
	
	private class DisassemblyStorage implements IStorage {
		
		private String contents;
		private String name;
		public DisassemblyStorage(String name, String contents) {
			this.contents = contents;
			this.name = name;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.resources.IStorage#getContents()
		 */
		public InputStream getContents() throws CoreException {
			return new StringBufferInputStream(contents);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.resources.IStorage#getFullPath()
		 */
		public IPath getFullPath() {
			return null;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.core.resources.IStorage#getName()
		 */
		public String getName() {
			return name;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.core.resources.IStorage#isReadOnly()
		 */
		public boolean isReadOnly() {
			return true;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
		 */
		public Object getAdapter(Class adapter) {
			return null;
		}
}

	public IStorage getDisassembled() {
		StringBuffer ret = new StringBuffer();
		int k = 0;
		
		ADWPDebugger debugger = ((AtlDebugTarget)thread.getDebugTarget()).getDebugger();
		List l = debugger.requestMessage(ADWPDebugger.CMD_DISASSEMBLE, Arrays.asList(new Object[] {stackFrame})).getArgs();
		for(Iterator i = l.iterator() ; i.hasNext() ; ) {
			ret.append("<" + opName + "+" + k++ + ">\t" + i.next());
			ret.append("\n");
		}
		
		return new DisassemblyStorage("ATL#" + opName, ret.toString());
	}
	
}
