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

