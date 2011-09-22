/*******************************************************************************
 * Copyright (c) 2011 Dennis Wagelaar, Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.impl.CodeBlockImpl;

/**
 * {@link CodeBlock} with empty native Java body. Returns <code>null</code> by default.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class NativeCodeBlock extends CodeBlockImpl {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getMaxStack() {
		return 1; // store result
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StackFrame execute(final StackFrame frame) {
		frame.push(null); 
		return frame;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getStackLevel() {
		return 1; // result on stack
	}

}
