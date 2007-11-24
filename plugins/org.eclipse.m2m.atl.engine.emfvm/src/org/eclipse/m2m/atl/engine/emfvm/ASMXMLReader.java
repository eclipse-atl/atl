/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.emfvm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ASMXMLReader extends DefaultHandler {

	private Object asmNameIndex;
	private ArrayList cp = new ArrayList();
	private boolean inCode;
	private ASM ret = new ASM();
	private ASMOperation currentOperation;
	private List bytecodes;

	public ASM read(InputStream in) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			errors = 0;
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(in, this);
		} catch (Throwable err) {
		       	err.printStackTrace(System.out);
		}
		if(errors > 0) System.exit(1);
		return ret;
	}

	private String resolve(Object index) {
		int idx = toInt(index);
		return (String)cp.get(idx);
	}

	private int toInt(Object s) {
		return Integer.parseInt((String)s);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		Map attrs = new HashMap();
		for(int i = 0 ; i < attributes.getLength() ; i++) {
			attrs.put(attributes.getQName(i), attributes.getValue(i));
		}

		if(qName.equals("asm")) {
			asmNameIndex = attrs.get("name");
		} else if(qName.equals("cp")) {
			// nothing to do
		} else if(qName.equals("constant")) {
			cp.add(attrs.get("value"));
		} else if(qName.equals("field")) {
			ret.addField(resolve(attrs.get("name")), resolve(attrs.get("type")));
		} else if(qName.equals("operation")) {
			currentOperation = new ASMOperation(resolve(attrs.get("name")));
			bytecodes = new ArrayList();
		} else if(qName.equals("context")) {
			currentOperation.setContext(resolve(attrs.get("type")));
		} else if(qName.equals("parameters")) {
			// nothing to do
		} else if(qName.equals("parameter")) {
			currentOperation.addParameter(resolve(attrs.get("name")), resolve(attrs.get("type")));
		} else if(qName.equals("code")) {
			inCode = true;
		} else if(qName.equals("linenumbertable")) {
			// nothing to do
		} else if(qName.equals("lne")) {
			currentOperation.addLineNumberEntry(resolve(attrs.get("id")), toInt(attrs.get("begin")), toInt(attrs.get("end")));
		} else if(qName.equals("localvariabletable")) {
			// nothing to do
		} else if(qName.equals("lve")) {
			currentOperation.addLocalVariableEntry(toInt(attrs.get("slot")), resolve(attrs.get("name")), toInt(attrs.get("begin")), toInt(attrs.get("end")));

		} else {
			if(inCode) {
				if(attrs.containsKey("arg")) {
//					if(qName.equals("if") || qName.equals("goto")) {
						
//					} else {
					bytecodes.add(new Bytecode(qName, resolve(attrs.get("arg"))));
//					}
				} else {
					bytecodes.add(new Bytecode(qName));
				}
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("cp")) {
			ret.setName(resolve(asmNameIndex));
		} else if(qName.equals("code")) {
			inCode = false;
		} else if(qName.equals("operation")) {
			currentOperation.setBytecodes((Bytecode[])bytecodes.toArray(new Bytecode[0]));
			ret.addOperation(currentOperation);
			currentOperation = null;
		}
	}

	public void error(SAXParseException e) {
		System.out.println("Error: line " + e.getLineNumber() + ":" + e.getColumnNumber() + ": " + e.getMessage());
	       	errors++;
	}

	public void fatalError(SAXParseException e) {
		System.out.println("Fatal error: line " + e.getLineNumber() + ":" + e.getColumnNumber() + ": " + e.getMessage());
		System.exit(1);
	}

	private int errors;
}
