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

