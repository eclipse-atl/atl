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
package org.eclipse.m2m.atl.engine.emfvm.launch;

import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;

/**
 * Interface for ATL VM debuggers (or other tools like profilers).
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public interface ITool {

	/**
	 * Enters the frame.
	 * 
	 * @param frame
	 *            the frame to enter in
	 */
	void enter(AbstractStackFrame frame);

	/**
	 * Leaves the frame.
	 * 
	 * @param frame
	 *            the frame to leave
	 */
	void leave(AbstractStackFrame frame);

	/**
	 * Steps into the frame.
	 * 
	 * @param frame
	 *            the frame to step
	 */
	void step(AbstractStackFrame frame);

	/**
	 * Terminates the execution.
	 */
	void terminated();

	/**
	 * Throws an error.
	 * 
	 * @param frame
	 *            the current frame
	 * @param msg
	 *            the error message
	 * @param e
	 *            the exception
	 */
	void error(AbstractStackFrame frame, String msg, Exception e);
}
