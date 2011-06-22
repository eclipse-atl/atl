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
 * Duplicate entry in {@link TypeHashMap}.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 *
 */
public class DuplicateEntryException extends RuntimeException {

	private static final long serialVersionUID = -2268735174303589159L;

	public DuplicateEntryException() {
	}

	public DuplicateEntryException(String arg0) {
		super(arg0);
	}

	public DuplicateEntryException(Throwable arg0) {
		super(arg0);
	}

	public DuplicateEntryException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
