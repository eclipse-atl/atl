/**
 * 
 */
package org.eclipse.m2m.atl.engine.injectors.xml;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ProtectedHandler extends DefaultHandler {
	
	private DefaultHandler handler;
	
	public ProtectedHandler(DefaultHandler handler) {
		this.handler = handler;
	}

	public void setDocumentLocator(Locator locator) {
		try {
			handler.setDocumentLocator(locator);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		try {
			handler.characters(ch, start, length);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			handler.startElement(uri, localName, qName, attributes);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		try {
			handler.endElement(uri, localName, qName);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void error(SAXParseException e) throws SAXException {
		try {
			handler.error(e);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

    public void fatalError(SAXParseException e) throws SAXException {
    	try {
    		handler.fatalError(e);
		} catch(Exception ex) {
			ex.printStackTrace();				
		}
    }
}