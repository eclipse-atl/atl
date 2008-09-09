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

/**
 * Interface for ATL VM debuggers (or other tools like profilers).
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public interface Debugger {

	/**
	 * @param frame
	 */
	void enter(StackFrame frame);

	/**
	 * @param frame
	 */
	void leave(StackFrame frame);

	/**
	 * @param frame
	 */
	void step(ASMStackFrame frame);

	/**
	 * 
	 */
	void terminated();

	/**
	 * @param frame
	 * @param msg
	 * @param e
	 */
	void error(StackFrame frame, String msg, Exception e);
}
