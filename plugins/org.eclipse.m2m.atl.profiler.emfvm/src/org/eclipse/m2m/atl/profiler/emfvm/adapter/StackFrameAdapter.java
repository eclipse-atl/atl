/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.emfvm.adapter;

import java.util.Map;

import org.eclipse.m2m.atl.engine.emfvm.lib.AbstractStackFrame;
import org.eclipse.m2m.atl.profiler.core.vm.IOperation;
import org.eclipse.m2m.atl.profiler.core.vm.IStackFrame;

/**
 * An EMFVM / Profiler stack frame wrapper.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class StackFrameAdapter implements IStackFrame {

	private AbstractStackFrame frame;

	/**
	 * Creates an {@link StackFrameAdapter} wrapping the given {@link AbstractStackFrame}.
	 * 
	 * @param frame
	 *            the frame to wrap
	 */
	public StackFrameAdapter(AbstractStackFrame frame) {
		this.frame = frame;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.profiler.core.vm.IStackFrame#getIOperation()
	 */
	public IOperation getIOperation() {
		return new OperationAdapter(frame.getOperation());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.profiler.core.vm.IStackFrame#getLocalVariables()
	 */
	public Map<String, Object> getLocalVariables() {
		return frame.getLocalVariables();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.profiler.core.vm.IStackFrame#getLocation()
	 */
	public int getLocation() {
		return frame.getLocation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof StackFrameAdapter && ((StackFrameAdapter)obj).frame.equals(frame);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return frame.hashCode();
	}
}
