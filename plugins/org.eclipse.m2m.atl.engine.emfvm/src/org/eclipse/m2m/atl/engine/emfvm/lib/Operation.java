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

import java.util.Collections;
import java.util.List;

/**
 * The abstract Operation class.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class Operation {

	protected int maxLocals;

	protected String name;

	/**
	 * Creates a new operation.
	 * 
	 * @param maxLocals
	 *            max locals
	 * @param name
	 *            the operation name
	 */
	public Operation(int maxLocals, String name) {
		this.maxLocals = maxLocals;
		this.name = name;
	}

	/**
	 * Creates a new operation.
	 * 
	 * @param maxLocals
	 *            max locals
	 * @deprecated use {@link #Operation(int, String)} instead
	 */
	public Operation(int maxLocals) {
		this.maxLocals = maxLocals;
		this.name = "<unnamed>"; //$NON-NLS-1$
	}

	public void setName(String name) {
		this.name = name;
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

	public String getName() {
		return name;
	}

	public List<?> getInstructions() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Returns the line at the specified number.
	 * 
	 * @param l
	 *            the line number
	 * @return the line at the specified number
	 */
	public String resolveLineNumber(int l) {
		return null;
	}

	/**
	 * Resolves a variable name by its slot number and its index.
	 * 
	 * @param slot
	 *            the slot number
	 * @param l
	 *            the variable index
	 * @return the variable name
	 */
	public String resolveVariableName(int slot, int l) {
		return null;
	}

}
