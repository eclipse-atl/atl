package org.atl.engine.vm;


/**
 * Interface for ATL VM debuggers (or other tools like profilers).
 * @author Frédéric Jouault
 */
public interface Debugger {

	public void enter(StackFrame frame);

	public void leave(StackFrame frame);

	public void step(ASMStackFrame frame);
	
	public void terminated();

	public void error(StackFrame frame, String msg, Exception e);
}

