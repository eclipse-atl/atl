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
package org.eclipse.m2m.atl.engine.extractors.xml;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.m2m.atl.engine.extractors.Extractor;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMCollection;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMOclAny;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class XMLExtractor implements Extractor {

	/* New Extractor Interface. */
	
	private static Map parameterTypes = Collections.EMPTY_MAP;

	public Map getParameterTypes() {
		return parameterTypes;
	}

	public void extract(ASMModel source, OutputStream target, Map params) {
		extract(null, source, target);
	}

	/* Old Extractor Interface. */
	
	public String getPrefix() {
		return "xml";
	}

	public void extract(ASMModel format, ASMModel extent, OutputStream out) {
		PrintStream out2 = new PrintStream(new BufferedOutputStream(out));
		out2.println("<?xml version = '1.0' encoding = 'ISO-8859-1' ?>");

		write((ASMModelElement)extent.getElementsByType("Root").iterator().next(), extent, out2, "");

		out2.close();
	}

	/* Serializer. */
	
	private void write(ASMModelElement o, ASMModel extent, PrintStream out, String indent) {
		String oTypeName = getString(o.getMetaobject(), "name");
		if(oTypeName.equals("Element") || oTypeName.equals("Root")) {
			String name = getString(o, "name");
			out.print(indent + "<" + name);

			ASMCollection children = (ASMCollection)o.get(null, "children");
			boolean hasElements = false;
			boolean hasTexts = false;
			for(Iterator i = children.iterator() ; i.hasNext() ; ) {
				ASMModelElement c = (ASMModelElement)i.next();
				String typeName = getString(c.getMetaobject(), "name");
				if(typeName.equals("Attribute")) {
					out.print(" " + getString(c, "name") + " = \'" + convertText(getString(c, "value"), true) + "\'");
				} else if(typeName.equals("Element")) {
					hasElements = true;
				} else if(typeName.equals("Text")) {
					hasTexts = true;
				}
			}
			if(hasElements) {
				out.println(">");

				for(Iterator i = children.iterator() ; i.hasNext() ; ) {
					ASMModelElement c = (ASMModelElement)i.next();
					String typeName = getString(c.getMetaobject(), "name");
					if(typeName.equals("Element")) {
						write(c, extent, out, indent + "  ");
					} else if(typeName.equals("Text")) {
						out.print(convertText(getString(c, "value"), false));
					}
				}

				out.println(indent + "</" + name + ">");
			} else if(hasTexts) {
				out.print(">");

				for(Iterator i = children.iterator() ; i.hasNext() ; ) {
					ASMModelElement c = (ASMModelElement)i.next();
					String typeName = getString(c.getMetaobject(), "name");
					if(typeName.equals("Text")) {
						out.print(convertText(getString(c, "value"), false));
					}
				}

				out.println("</" + name + ">");
			} else {
				out.println("/>");
			}
		}
	}

	private String getString(ASMModelElement ame, String name) {
		ASMOclAny ret = ame.get(null, name);
		
		if(!(ret instanceof ASMString))
			throw new RuntimeException("could not read " + name + " of " + ame + " : " + ame.getType());
		
		return ((ASMString)ret).getSymbol();
	}

	private String convertText(String in, boolean inAttr) {
		String ret = in.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		
		if(inAttr) {
			ret = ret.replaceAll("\n", "&#10;").replaceAll("\t", "&#9;").replaceAll("'", "&apos;").replaceAll("\"", "&quot;");
		}
		
		return ret;
	}
}

