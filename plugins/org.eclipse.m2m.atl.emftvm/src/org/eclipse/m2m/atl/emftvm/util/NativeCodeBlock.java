/*******************************************************************************
 * Copyright (c) 2011-2012 Dennis Wagelaar, Vrije Universiteit Brussel.
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
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
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
	public Object execute(final StackFrame frame) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getStackLevel() {
		return 1; // result on stack
	}

}
