/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.vm;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.vm.ASMStackFrame;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.StackFrame;
import org.eclipse.m2m.atl.profiler.core.ATLProfiler;
import org.eclipse.m2m.atl.profiler.vm.adapter.StackFrameAdapter;

/**
 * Class used by the ATL Virtual Machine.<br>
 * Redirect operations to the ATL profiler
 * 
 * @see org.eclipse.m2m.atl.profiler.core.ATLProfiler
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class ProfilingDebugger implements Debugger {

	/**
	 * Creates a new profiling debugger.
	 * 
	 * @param atlModel
	 *            the atl code model
	 */
	public ProfilingDebugger(EObject atlModel) {
		init(atlModel);
	}
	private void init(EObject atlModel) {
		ATLProfiler.getInstance().initProfiler(atlModel);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.Debugger#terminated()
	 */
	public void terminated() {
		ATLProfiler.getInstance().interceptTerminated();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.Debugger#error(org.eclipse.m2m.atl.engine.vm.StackFrame, java.lang.String, java.lang.Exception)
	 */
	public void error(StackFrame frame, String msg, Exception e) {
		ATLProfiler.getInstance().interceptError(new StackFrameAdapter(frame), msg, e);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.Debugger#enter(org.eclipse.m2m.atl.engine.vm.StackFrame)
	 */
	public void enter(StackFrame frame) {
		ATLProfiler.getInstance().interceptEnter(new StackFrameAdapter(frame));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.Debugger#leave(org.eclipse.m2m.atl.engine.vm.StackFrame)
	 */
	public void leave(StackFrame frame) {
		ATLProfiler.getInstance().interceptLeave(new StackFrameAdapter(frame));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.vm.Debugger#step(org.eclipse.m2m.atl.engine.vm.ASMStackFrame)
	 */
	public void step(ASMStackFrame frame) {
		ATLProfiler.getInstance().interceptStep(new StackFrameAdapter(frame));
	}
}
