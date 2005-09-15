package org.atl.engine.vm.adwp;

import org.atl.engine.vm.DummyDebugger;
import org.atl.engine.vm.ExecEnv;
import org.atl.engine.vm.Operation;
import org.atl.engine.vm.StackFrame;

import java.util.List;

/**
 * A StackFrame used for debugger queries to avoid recursive debugger activations.
 * @author Frédéric Jouault
 */
public class ADWPStackFrame extends StackFrame {

	public ADWPStackFrame(Operation op, List args) {
		super(myType, new ExecEnv(new DummyDebugger()), op, args);
	}

	// An error during a debugger request should not trigger the debugger
	public void printStackTrace(String msg, Exception e) {
		System.out.println("ERROR: " + msg);
		e.printStackTrace(System.out);
	}
}

