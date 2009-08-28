/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclSimpleType;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclType;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMStackFrame extends StackFrame {

	public static ASMOclType myType = new ASMOclSimpleType("ASMStackFrame", StackFrame.myType);

	public ASMStackFrame(ExecEnv execEnv, ASMOperation operation, List args) {
		super(myType, execEnv, operation, args);

		localVariables = new HashMap();
		Iterator j = args.iterator();
		localVariables.put("0", j.next());
		for (Iterator i = operation.getParameters().iterator(); i.hasNext();) {
			ASMParameter p = (ASMParameter)i.next();
			if (!j.hasNext()) {
				printStackTrace("Too few arguments");
			}
			localVariables.put(p.getName(), j.next());
		}
		if (j.hasNext()) {
			printStackTrace("Too many arguments");
		}
		localStack = new Stack();
		location = -1;
	}

	public static ASMStackFrame rootFrame(ASMExecEnv execEnv, ASMOperation operation, List args) {
		ASMStackFrame ret = new ASMStackFrame(execEnv, operation, args);

		execEnv.push(ret);
		execEnv.getDebugger().enter(ret);

		return ret;
	}

	public ASMOclAny leaveFrame() {
		super.leaveFrame();
		ASMOclAny ret = null;

		getExecEnv().pop();

		if (!empty())
			ret = pop();

		return ret;
	}

	public String toString() {
		StringBuffer ret = new StringBuffer();

		ASMOperation op = (ASMOperation)getOperation();
		ret.append("\tat "); //$NON-NLS-1$
		ret.append(getOperation());
		ret.append('(');
		ret.append(op.getASM().getName() + ".atl"); //$NON-NLS-1$
		String location = op.resolveLineNumber(getLocation());
		if (location != null) {
			if (location.matches("[0-9]*:[0-9]*-[0-9]*:[0-9]*")) { //$NON-NLS-1$
				ret.append('[' + location + ']'); //$NON-NLS-1$
			}
		}
		ret.append(")"); //$NON-NLS-1$
		ret.append("\n\t\tlocal variables = {");
		for (Iterator i = localVariables.keySet().iterator(); i.hasNext();) {
			String key = (String)i.next();
			ret.append(op.resolveVariableName(Integer.parseInt(key), getLocation()));
			ret.append("=");
			ret.append(localVariables.get(key));
			if (i.hasNext())
				ret.append(", ");
		}
		ret.append("}\n\t\tlocal stack = ");
		ret.append(localStack);

		return ret.toString();
	}

	public void push(ASMOclAny value) {
		localStack.push(value);
	}

	public ASMOclAny pop() {
		return (ASMOclAny)localStack.pop();
	}

	public ASMOclAny peek() {
		return (ASMOclAny)localStack.peek();
	}

	public boolean empty() {
		return localStack.empty();
	}

	public void setVariable(String name, ASMOclAny value) {
		localVariables.put(name, value);
	}

	public ASMOclAny getVariable(String name) {
		ASMOclAny ret = (ASMOclAny)localVariables.get(name);

		if(ret == null) ret = getExecEnv().getVariable(name);

		return ret;
	}

	public void pushVariable(String name) {
		push(getVariable(name));
	}

	public void popVariable(String name) {
		setVariable(name, pop());
	}

	public boolean hasNextInstruction() {
		return (location + 1) < ((ASMOperation)getOperation()).getInstructions().size();
	}

	public ASMInstruction nextInstruction() {
		return (ASMInstruction)((ASMOperation)getOperation()).getInstructions().get(++location);
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public void step() {
		debugger.step(this);
	}

	public Map getLocalVariables() {
		Map ret = new HashMap(localVariables);
		ret.put("_stack", localStack);
		return ret;
	}

	public List getLocalStack() {
		return localStack;
	}

	public String resolveVariableName(int slot) {
		return ((ASMOperation)getOperation()).resolveVariableName(slot, location);
	}

	public String getSourceLocation() {
		return ((ASMOperation)getOperation()).resolveLineNumber(location);
	}

	private Map localVariables;

	private Stack localStack;

	private int location;
}
