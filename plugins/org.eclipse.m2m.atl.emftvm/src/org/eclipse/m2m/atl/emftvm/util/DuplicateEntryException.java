/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

/**
 * Duplicate entry in {@link TypeHashMap}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class DuplicateEntryException extends RuntimeException {

	private static final long serialVersionUID = -2268735174303589159L;

	/**
	 * Creates a new {@link DuplicateEntryException}.
	 */
	public DuplicateEntryException() {
	}

	/**
	 * Creates a new {@link DuplicateEntryException}.
	 * @param msg the error message
	 */
	public DuplicateEntryException(String msg) {
		super(msg);
	}

	/**
	 * Creates a new {@link DuplicateEntryException}.
	 * @param cause the nested exception
	 */
	public DuplicateEntryException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creates a new {@link DuplicateEntryException}.
	 * @param msg the error message
	 * @param cause the nested exception
	 */
	public DuplicateEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
