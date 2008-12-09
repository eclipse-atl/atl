/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm.lib;

/**
 * The abstract Operation class.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class Operation {

	protected int maxLocals;

	/**
	 * Creates a new operation.
	 * 
	 * @param maxLocals
	 *            max locals
	 */
	public Operation(int maxLocals) {
		this.maxLocals = maxLocals;
	}

	/**
	 * Executes an operation.
	 * 
	 * @param frame
	 *            the frame for execution
	 * @return the result
	 */
	public abstract Object exec(AbstractStackFrame frame);

	public int getMaxLocals() {
		return maxLocals;
	}

}
