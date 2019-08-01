/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import org.xml.sax.SAXParseException;

/**
 * An ASM XML read exception.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMXMLReaderException extends SAXParseException {

	private static final long serialVersionUID = 8581830395699590847L;

	/**
	 * Creates a new {@link ASMXMLReaderException} with the given parameters.
	 * 
	 * @param message
	 *            the error message
	 * @param publicId
	 *            the public id
	 * @param systemId
	 *            the system id
	 * @param lineNumber
	 *            the error location line
	 * @param columnNumber
	 *            the error location column
	 * @param e
	 *            the exception
	 */
	public ASMXMLReaderException(String message, String publicId, String systemId, int lineNumber,
			int columnNumber, Exception e) {
		super(message, publicId, systemId, lineNumber, columnNumber, e);
	}

}
