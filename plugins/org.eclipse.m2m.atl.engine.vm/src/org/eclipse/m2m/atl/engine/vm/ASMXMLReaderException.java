/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

public class ASMXMLReaderException extends SAXParseException {

	private static final long serialVersionUID = 8581830395699590847L;

	public ASMXMLReaderException(String message, Locator locator) {
		super(message, locator);
	}

	public ASMXMLReaderException(String message, Locator locator, Exception e) {
		super(message, locator, e);
	}

	public ASMXMLReaderException(String message, String publicId,
			String systemId, int lineNumber, int columnNumber) {
		super(message, publicId, systemId, lineNumber, columnNumber);
	}

	public ASMXMLReaderException(String message, String publicId,
			String systemId, int lineNumber, int columnNumber, Exception e) {
		super(message, publicId, systemId, lineNumber, columnNumber, e);
	}

}
