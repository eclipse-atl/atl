/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.vm.adapter;

import java.util.Collections;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.ASMStackFrame;
import org.eclipse.m2m.atl.engine.vm.StackFrame;
import org.eclipse.m2m.atl.profiler.core.vm.IOperation;
import org.eclipse.m2m.atl.profiler.core.vm.IStackFrame;

/**
 * A RegularM / Profiler stack frame wrapper.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class StackFrameAdapter implements IStackFrame {

	private StackFrame frame;

	/**
	 * Creates an {@link StackFrameAdapter} wrapping the given {@link StackFrame}.
	 * 
	 * @param frame
	 *            the frame to wrap
	 */
	public StackFrameAdapter(StackFrame frame) {
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
	@SuppressWarnings("unchecked")
	public Map<String, Object> getLocalVariables() {
		if (frame instanceof ASMStackFrame) {
			return ((ASMStackFrame)frame).getLocalVariables();
		}
		return Collections.emptyMap();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.profiler.core.vm.IStackFrame#getLocation()
	 */
	public int getLocation() {
		if (frame instanceof ASMStackFrame) {
			return ((ASMStackFrame)frame).getLocation();
		}
		return 0;
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
