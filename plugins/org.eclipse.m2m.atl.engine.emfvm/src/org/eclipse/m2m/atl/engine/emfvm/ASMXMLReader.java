/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The asm xml files reader.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ASMXMLReader extends DefaultHandler {

	private Object asmNameIndex;
	
	private List<String> cp = new ArrayList<String>();

	private boolean inCode;

	private ASM ret = new ASM();

	private ASMOperation currentOperation;

	private List<Bytecode> bytecodes;

	private int errors;

	/**
	 * Reads an ASM.
	 * 
	 * @param in
	 *            the stream to read
	 * @return the asm
	 */
	public ASM read(InputStream in) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			errors = 0;
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(in, this);
		} catch (ParserConfigurationException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		} catch (SAXException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		} catch (IOException e) {
			throw new VMException(null, e.getLocalizedMessage(), e);
		}
		if (errors > 0) {
			throw new VMException(null, Messages.getString("ASMXMLReader.FATALERROR")); //$NON-NLS-1$
		}
		return ret;
	}

	private String resolve(Object index) {
		int idx = toInt(index);
		return cp.get(idx);
	}

	private int toInt(Object s) {
		return Integer.parseInt((String)s);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String,
	 *      java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		Map<String, String> attrs = new HashMap<String, String>();
		for (int i = 0; i < attributes.getLength(); i++) {
			attrs.put(attributes.getQName(i), attributes.getValue(i));
		}

		if (qName.equals("asm")) { //$NON-NLS-1$
			asmNameIndex = attrs.get("name"); //$NON-NLS-1$
			Object version = attrs.get("version"); //$NON-NLS-1$
			if (version != null) {
				ret.setVersion(version.toString());				
			}
		} else if (qName.equals("cp")) { //$NON-NLS-1$
			// nothing to do
		} else if (qName.equals("constant")) { //$NON-NLS-1$
			cp.add(attrs.get("value")); //$NON-NLS-1$
		} else if (qName.equals("field")) { //$NON-NLS-1$
			ret.addField(resolve(attrs.get("name")), resolve(attrs.get("type"))); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (qName.equals("operation")) { //$NON-NLS-1$
			currentOperation = new ASMOperation(ret, resolve(attrs.get("name"))); //$NON-NLS-1$
			bytecodes = new ArrayList<Bytecode>();
		} else if (qName.equals("context")) { //$NON-NLS-1$
			currentOperation.setContext(resolve(attrs.get("type"))); //$NON-NLS-1$
		} else if (qName.equals("parameters")) { //$NON-NLS-1$
			// nothing to do
		} else if (qName.equals("parameter")) { //$NON-NLS-1$
			currentOperation.addParameter(resolve(attrs.get("name")), resolve(attrs.get("type"))); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (qName.equals("code")) { //$NON-NLS-1$
			inCode = true;
		} else if (qName.equals("linenumbertable")) { //$NON-NLS-1$
			// nothing to do
		} else if (qName.equals("lne")) { //$NON-NLS-1$
			currentOperation.addLineNumberEntry(resolve(attrs.get("id")), toInt(attrs.get("begin")), //$NON-NLS-1$ //$NON-NLS-2$
					toInt(attrs.get("end"))); //$NON-NLS-1$
		} else if (qName.equals("localvariabletable")) { //$NON-NLS-1$
			// nothing to do
		} else if (qName.equals("lve")) { //$NON-NLS-1$
			currentOperation.addLocalVariableEntry(toInt(attrs.get("slot")), resolve(attrs.get("name")), //$NON-NLS-1$ //$NON-NLS-2$
					toInt(attrs.get("begin")), toInt(attrs.get("end"))); //$NON-NLS-1$ //$NON-NLS-2$

		} else {
			if (inCode) {
				if (attrs.containsKey("arg")) { //$NON-NLS-1$
					// if(qName.equals("if") || qName.equals("goto")) {

					// } else {
					bytecodes.add(new Bytecode(qName, resolve(attrs.get("arg")))); //$NON-NLS-1$
					// }
				} else {
					bytecodes.add(new Bytecode(qName));
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("cp")) { //$NON-NLS-1$
			ret.setName(resolve(asmNameIndex));
		} else if (qName.equals("code")) { //$NON-NLS-1$
			inCode = false;
		} else if (qName.equals("operation")) { //$NON-NLS-1$
			currentOperation.setBytecodes(bytecodes.toArray(new Bytecode[0]));
			ret.addOperation(currentOperation);
			currentOperation = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException)
	 */
	@Override
	public void error(SAXParseException e) {
		errors++;
		throw new VMException(
				null,
				Messages
						.getString(
								"ASMXMLReader.PARSINGERROR", Integer.valueOf(e.getLineNumber()), Integer.valueOf(e.getColumnNumber()), e.getMessage())); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.SAXParseException)
	 */
	@Override
	public void fatalError(SAXParseException e) throws SAXParseException {
		throw new ASMXMLReaderException(
				Messages
						.getString(
								"ASMXMLReader.PARSINGERROR", Integer.valueOf(e.getLineNumber()), new Integer(e.getColumnNumber()), e.getLocalizedMessage()), e.getPublicId(), e.getSystemId(), e //$NON-NLS-1$
						.getLineNumber(), e.getColumnNumber(), e);
	}

}
