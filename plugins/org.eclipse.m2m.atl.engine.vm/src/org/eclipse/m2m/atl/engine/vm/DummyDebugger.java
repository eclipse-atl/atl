package org.eclipse.m2m.atl.engine.vm;


/**
 * A do-nothing ATL VM debugger.
 * @author Frédéric Jouault
 */
public class DummyDebugger implements Debugger {

	public void enter(StackFrame frame) {

	}

	public void leave(StackFrame frame) {

	}

	public void step(ASMStackFrame frame) {

	}

	public void error(StackFrame frame, String msg, Exception e) {

	}

	public void terminated() {

	}
}

