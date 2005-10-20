package org.atl.engine.vm;

import java.util.List;

import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMOclSimpleType;
import org.atl.engine.vm.nativelib.ASMOclType;

/**
 * @author Frédéric Jouault
 */
public class NativeStackFrame extends StackFrame {

	public static ASMOclType myType = new ASMOclSimpleType("NativeStackFrame", StackFrame.myType);

	public NativeStackFrame(ExecEnv execEnv, NativeOperation operation, List args) {
		super(myType, execEnv, operation, args);
	}

	public ASMOclAny leaveFrame() {
		super.leaveFrame();

		getExecEnv().pop();

		return ret;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append(getOperation());
		ret.append("\n\targs = ");
		ret.append(getArgs());

		return ret.toString();
	}

	public void setRet(ASMOclAny ret) {
		this.ret = ret;
	}

	public ASMOclAny getRet() {
		return ret;
	}

	private ASMOclAny ret = null;
}

