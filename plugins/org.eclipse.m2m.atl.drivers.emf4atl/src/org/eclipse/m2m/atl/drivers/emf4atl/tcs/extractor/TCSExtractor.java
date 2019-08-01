/**
 * Copyright (c) 2005, 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: TCSExtractor.java,v 1.1 2009/04/21 14:11:03 wpiers Exp $
 */
package org.eclipse.m2m.atl.drivers.emf4atl.tcs.extractor;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.dsls.tcs.extractor.PrettyPrinter;
import org.eclipse.m2m.atl.engine.extractors.Extractor;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * Created on 9 mars 2005
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class TCSExtractor implements Extractor {

	private static Map parameterTypes = new HashMap();
	
	static {
		parameterTypes.put("format", "Model:TCS");			// required
		parameterTypes.put("indentString", "String");		// optional, default = "  "
		parameterTypes.put("standardSeparator", "String");	// optional, default = " "
		parameterTypes.put("kwCheckIgnoreCase", "String");	// optional, default = false
		parameterTypes.put("identEsc", "String");			// optional, default = "\"", has priority over the two others below
		parameterTypes.put("identEscStart", "String");		// optional, default = "\""
		parameterTypes.put("identEscEnd", "String");		// optional, default = "\""
		parameterTypes.put("stringDelim", "String");		// optional, default = "\'"	
		parameterTypes.put("debug", "String");				// optional, default = false	
		parameterTypes.put("debugws", "String");			// optional, default = false	
		parameterTypes.put("serializeComments", "String");	// optional, default = true
		parameterTypes.put("usePrimitiveTemplates", "String");	// optional, default = false
		parameterTypes.put("decimalFormat", "String");		// optional, default = "0.##############"
		parameterTypes.put("stream", "TCSExtractorStream");// optional, default = new TCSExtractorPrintStream(target);
	}

	public Map getParameterTypes() {
		return parameterTypes;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.extractors.Extractor#extract(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.OutputStream, java.util.Map)
	 */
	public void extract(ASMModel source, OutputStream target, Map params) {
		new PrettyPrinter().prettyPrint(source, new ASMModelAdapter(), target, params);		
	}
	
	public void extract(ASMModel format, ASMModel extent, OutputStream out) {
		throw new UnsupportedOperationException("Was deprecated a long time ago. It is now unsupported");
	}

	public String getPrefix() {
		return "ebnf";
	}
}
