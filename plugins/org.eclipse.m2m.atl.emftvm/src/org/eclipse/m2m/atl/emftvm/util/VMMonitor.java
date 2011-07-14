/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;


/**
 * Allows monitoring and controlling a running EMFTVM instance.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public interface VMMonitor {

	/**
	 * Returns <code>true</code> when the running EMFTVM instance should be terminated.
	 * @return <code>true</code> when the running EMFTVM instance should be terminated
	 */
	boolean isTerminated();

	/**
	 * Enters the stack frame.
	 * @param frame the frame to enter in
	 */
	void enter(StackFrame frame);

	/**
	 * Leaves the stack frame.
	 * @param frame the frame to leave
	 */
	void leave(StackFrame frame);

	/**
	 * Steps into the stack frame.
	 * @param frame the frame to step
	 */
	void step(StackFrame frame);

	/**
	 * Invoked when execution is terminated.
	 */
	void terminated();

	/**
	 * Throws an error. 
	 * @param frame the current frame
	 * @param msg the error message
	 * @param e the exception
	 */
	void error(StackFrame frame, String msg, Exception e);

}
