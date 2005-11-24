package org.atl.engine.injectors.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.atl.engine.injectors.Injector;
import org.atl.engine.vm.nativelib.ASMInteger;
import org.atl.engine.vm.nativelib.ASMModel;
import org.atl.engine.vm.nativelib.ASMModelElement;
import org.atl.engine.vm.nativelib.ASMOclAny;
import org.atl.engine.vm.nativelib.ASMString;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Frédéric Jouault
 */
public class XMLInjector extends DefaultHandler implements Injector {

	/** Set to true to enable debugging information printouts. */
	private final static boolean debug = false;

	private boolean keepWhitespace = true;


	/** Target model. */
	private ASMModel extent;
	
	/**
	 * SAX Locator, used to store elements locations in the target model
	 * for traceability.
	 */
	private Locator locator = null;
	
	/**
	 * Current element. Since it owns a reference to its parent, it behaves
	 * as a stack.
	 */
	private ASMModelElement current = null;
	
	/**
	 * Root element.
	 */
	private ASMModelElement root = null;

	/**
	 * Number of encountered errors. 
	 */
	private int errors;

	
	/* New Injector interface. */
	
	private static Map parameterTypes = new HashMap();
	
	static {
		parameterTypes.put("keepWhitespace", "String");		// optional, default = false		
	}

	public Map getParameterTypes() {
		return parameterTypes;
	}
	
	public ASMModelElement inject(ASMModel target, InputStream source, Map params) throws IOException {
		keepWhitespace = !("false".equals(params.get("keepWhitespace")));
		performImportation(null, target, source, null);
		return root;
	}
	
	/* Old Injector interface. */
	
	public String getPrefix() {
		return "xml";
	}

	public void performImportation(ASMModel format, ASMModel extent, InputStream in, String other) throws IOException {
		this.extent = extent;

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			errors = 0;
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(in, this);
		} catch (Throwable err) {
			err.printStackTrace(System.out);
		}
	}

	/* Content Handler below */
	
	public void setDocumentLocator(Locator locator) {
		this.locator = locator;
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		int end = start + length - 1;

		if(start > end) return;

		String value = new String(ch, start, length);

		if(debug) {
			System.out.println("text = " + value);
		}
		
		if(!keepWhitespace) {
			value = value.trim();
		}

		if(value.length() > 0) {
			ASMModelElement attr = extent.newModelElement("Text");
			attr.set(null, "name", new ASMString("#text"));	// as in DOM
			attr.set(null, "value", new ASMString(value));
			attr.set(null, "parent", current);
			if(locator != null) {
				if(locator.getLineNumber() != -1) {
					attr.set(null, "startLine", new ASMInteger(locator.getLineNumber()));
				}
				if(locator.getColumnNumber() != -1) {
					attr.set(null, "startColumn", new ASMInteger(locator.getColumnNumber()));
				}
			}
		}
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		ASMModelElement parent = current;
		if(debug) {
			System.out.println("uri = " + uri);
			System.out.println("localName = " + localName);
			System.out.println("qName = " + qName);
		}

		if(current == null) {
			current = root = extent.newModelElement("Root");
		} else {
			current = extent.newModelElement("Element");
			current.set(null, "parent", parent);
		}

		current.set(null, "name", new ASMString(qName));
		for(int i = 0 ; i < attributes.getLength() ; i++) {
			if(debug) {
				System.out.println("Attribute localName = " + attributes.getLocalName(i));
				System.out.println("Attribute qName = " + attributes.getQName(i));
			}
			ASMModelElement attr = extent.newModelElement("Attribute");
			attr.set(null, "name", new ASMString(attributes.getQName(i)));
			attr.set(null, "value", new ASMString(attributes.getValue(i)));
			attr.set(null, "parent", current);
		}
		
		if(locator != null) {
			if(locator.getLineNumber() != -1) {
				current.set(null, "startLine", new ASMInteger(locator.getLineNumber()));
			}
			if(locator.getColumnNumber() != -1) {
				current.set(null, "startColumn", new ASMInteger(locator.getColumnNumber()));
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		ASMOclAny parent = current.get(null, "parent");
		if(locator != null) {
			if(locator.getLineNumber() != -1) {
				current.set(null, "endLine", new ASMInteger(locator.getLineNumber()));
			}
			if(locator.getColumnNumber() != -1) {
				current.set(null, "endColumn", new ASMInteger(locator.getColumnNumber()));
			}
		}
		if(parent instanceof ASMModelElement) {
			current = (ASMModelElement)parent;
		} else {
			current = null;
		}
	}

	public void error(SAXParseException e) {
		System.out.println("Error: line " + e.getLineNumber() + ":" + e.getColumnNumber() + ": " + e.getMessage());
		errors++;
	}

    public void fatalError(SAXParseException e) {
		System.out.println("Fatal error: line " + e.getLineNumber() + ":" + e.getColumnNumber() + ": " + e.getMessage());
		errors++;
	}
}

