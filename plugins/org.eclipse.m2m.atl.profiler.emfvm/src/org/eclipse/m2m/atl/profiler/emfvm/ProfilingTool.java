/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.emfvm;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.emfvm.launch.ITool;
import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.profiler.core.ATLProfiler;
import org.eclipse.m2m.atl.profiler.emfvm.adapter.StackFrameAdapter;

/**
 * Class used by the ATL Virtual Machine.<br>
 * Redirect operations to the ATL profiler
 * 
 * @see org.eclipse.m2m.atl.profiler.core.ATLProfiler
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class ProfilingTool implements ITool {

	/**
	 * Creates a new profiling tool.
	 * 
	 * @param atlModel
	 *            the atl code model
	 */
	public ProfilingTool(EObject atlModel) {
		init(atlModel);
	}

	private void init(EObject atlModel) {
		ATLProfiler.getInstance().initProfiler(atlModel);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#terminated()
	 */
	public void terminated() {
		ATLProfiler.getInstance().interceptTerminated();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#error(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame,
	 *      java.lang.String, java.lang.Exception)
	 */
	public void error(AbstractStackFrame frame, String msg, Exception e) {
		ATLProfiler.getInstance().interceptError(new StackFrameAdapter(frame), msg, e);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#enter(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame)
	 */
	public void enter(AbstractStackFrame frame) {
		ATLProfiler.getInstance().interceptEnter(new StackFrameAdapter(frame));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#leave(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame)
	 */
	public void leave(AbstractStackFrame frame) {
		ATLProfiler.getInstance().interceptLeave(new StackFrameAdapter(frame));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.engine.emfvm.launch.ITool#step(org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame)
	 */
	public void step(AbstractStackFrame frame) {
		ATLProfiler.getInstance().interceptStep(new StackFrameAdapter(frame));
	}
}
