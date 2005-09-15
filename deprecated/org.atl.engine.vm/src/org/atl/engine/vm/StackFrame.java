package org.atl.engine.vm;

import java.util.List;
import java.util.Map;

import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclSimpleType;
import org.atl.engine.vm.nativelib.ASMOclType;
import org.atl.engine.vm.nativelib.ASMSequence;

/**
 * @author Frédéric Jouault
 */
public abstract class StackFrame extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("StackFrame", getOclAnyType());
	static {  
		NativeOperation.registerOperations(myType, StackFrame.class, false, true, true, true);
	}

	public StackFrame(ASMOclType myType, ExecEnv execEnv, Operation operation, List args) {
		super(myType);
		this.execEnv = execEnv;
		this.operation = operation;
		this.args = args;
		this.debugger = execEnv.getDebugger();
	}

	public StackFrame enterFrame(Operation op, List args) {
		StackFrame ret = null;

		if(op instanceof ASMOperation) {
			ret = new ASMStackFrame(execEnv, (ASMOperation)op, args);
		} else {
			ret = new NativeStackFrame(execEnv, (NativeOperation)op, args);
		}
		ret.setParent(this);
		debugger.enter(ret);

		execEnv.push(ret);

		return ret;
	}
	
	public StackFrame getParent() {
		return parent;
	}
	
	public void setParent(StackFrame parent) {
		this.parent = parent;
	}

	public ASMOclAny leaveFrame() {
		debugger.leave(this);
		return null;
	}

	public ExecEnv getExecEnv() {
		return execEnv;
	}

	public Operation getOperation() {
		return operation;
	}

	public ASMModel getModel(String name) {
		return execEnv.getModel(name);
	}

	public Map getModels() {
		return execEnv.getModels();
	}

	public void printStackTrace() {
		printStackTrace(null, null);
	}

	public void printStackTrace(Exception e) {
		printStackTrace(null, e);
	}

	public void printStackTrace(String msg) {
		printStackTrace(msg, null);
	}

	public void printStackTrace(String msg, Exception e) {
		debugger.error(this, msg, e);
	}

	public List getArgs() {
		return args;
	}

	public ASMSequence getStack() {
		ASMSequence ret = new ASMSequence(execEnv.getStack());
		return ret;
	}

	public String getOpName() {
		return operation.getName(); 
	}
	
	private ExecEnv execEnv;
	private Operation operation;
	private List args;
	protected Debugger debugger;
	private StackFrame parent = null;
}
