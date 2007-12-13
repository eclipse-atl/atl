/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;

/**
 * @author Frédéric Jouault
 */
public class ExecEnv {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	public ExecEnv(Debugger debugger) {
		this.debugger = debugger;
	}

	public boolean empty() {
		return frames.empty();
	}

	public void push(StackFrame frame) {
		frames.push(frame);
	}

	public StackFrame peek() {
		return (StackFrame)frames.peek();
	}

	public StackFrame pop() {
		return (StackFrame)frames.pop();
	}

	public void addModel(ASMModel model) {
		models.put(model.getName(), model);
	}

	/** To add a model with a name different in this ASMExecEnv than it actually is. 
	 * This is necessary for composite transformations in which the in model of transformation
	 * may not bear the same name as the out model of the preceding transformation.
	 */
	public void addModel(String name, ASMModel model) {
		models.put(name, model);
	}

	public ASMModel getModel(String name) {
		return (ASMModel)models.get(name);
	}

	public Map getModels() {
		return models;
	}

	public void printStackTrace() {
		for(Iterator i = frames.iterator() ; i.hasNext() ; ) {
			StringTokenizer lines = new StringTokenizer(i.next().toString(), "\n");
			while (lines.hasMoreTokens()) {
				logger.severe(lines.nextToken());
			}
//			System.out.println(i.next());
		}
	}

	public ASMOclAny getVariable(String name) {
		return (ASMOclAny)globalVariables.get(name);
	}

	public Debugger getDebugger() {
		return debugger;
	}

	public Stack getStack() {
		return frames;
	}

	private Stack frames = new Stack();
	private Map models = new HashMap();
	protected Map globalVariables = new HashMap();
	private Debugger debugger;
}

