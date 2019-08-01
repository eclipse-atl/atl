/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ExecEnv {

	public ExecEnv(Debugger debugger) {
		if (debugger == null) {
			this.debugger = new DummyDebugger();
		} else {
			this.debugger = debugger;
		}
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

	/**
	 * To add a model with a name different in this ASMExecEnv than it actually is. This is necessary for
	 * composite transformations in which the in model of transformation may not bear the same name as the out
	 * model of the preceding transformation.
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
		for (Iterator i = frames.iterator(); i.hasNext();) {
			StringTokenizer lines = new StringTokenizer(i.next().toString(), "\n");
			while (lines.hasMoreTokens()) {
				ATLLogger.severe(lines.nextToken());
			}
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

	public boolean checkPermission(String permission) {
		return permissions.contains(permission);
	}

	public void addPermission(String permission) {
		permissions.add(permission);
	}

	private Set permissions = new HashSet();

	private Stack frames = new Stack();

	private Map models = new HashMap();

	protected Map globalVariables = new HashMap();

	private Debugger debugger;
}
