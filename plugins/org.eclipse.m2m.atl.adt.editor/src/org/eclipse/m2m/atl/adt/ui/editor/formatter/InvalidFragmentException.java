/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.editor.formatter;

/**
 * Returned when the formatter fails to manage a fragment.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public class InvalidFragmentException extends Exception {

	public InvalidFragmentException() {
		super();
	}

	public InvalidFragmentException(String message) {
		super(message);
	}

}
