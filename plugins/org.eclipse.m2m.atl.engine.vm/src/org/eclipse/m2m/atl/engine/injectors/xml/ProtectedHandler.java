/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frédéric Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.injectors.xml;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ProtectedHandler extends DefaultHandler {
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private DefaultHandler handler;
	
	public ProtectedHandler(DefaultHandler handler) {
		this.handler = handler;
	}

	public void setDocumentLocator(Locator locator) {
		try {
			handler.setDocumentLocator(locator);
		} catch(Exception ex) {
			logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
//			ex.printStackTrace();
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		try {
			handler.characters(ch, start, length);
		} catch(Exception ex) {
			logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
//			ex.printStackTrace();
		}
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			handler.startElement(uri, localName, qName, attributes);
		} catch(Exception ex) {
			logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
//			ex.printStackTrace();
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		try {
			handler.endElement(uri, localName, qName);
		} catch(Exception ex) {
			logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
//			ex.printStackTrace();
		}
	}
	
	public void error(SAXParseException e) throws SAXException {
		try {
			handler.error(e);
		} catch(Exception ex) {
			logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
//			ex.printStackTrace();
		}
	}

    public void fatalError(SAXParseException e) throws SAXException {
    	try {
    		handler.fatalError(e);
		} catch(Exception ex) {
			logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
//			ex.printStackTrace();				
		}
    }
}