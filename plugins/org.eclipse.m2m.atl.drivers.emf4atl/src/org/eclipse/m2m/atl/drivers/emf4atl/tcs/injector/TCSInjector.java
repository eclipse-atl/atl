/**
 * Copyright (c) 2004, 2008, 2014 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     Dennis Wagelaar
 *
 * $Id: TCSInjector.java,v 1.1 2009/04/21 14:11:03 wpiers Exp $
 */
package org.eclipse.m2m.atl.drivers.emf4atl.tcs.injector;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.atl.dsls.tcs.injector.ModelAdapter;
import org.eclipse.m2m.atl.dsls.tcs.injector.ParserLauncher;
import org.eclipse.m2m.atl.engine.injectors.Injector;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class TCSInjector implements Injector {
	
	private static Map parameterTypes = new HashMap();
	
	static {
		parameterTypes.put("name", "String");			// required
		parameterTypes.put("keepNL", "String");			// optional, default = false		
		parameterTypes.put("keepLocation", "String");	// optional, default = true		
		parameterTypes.put("keepComments", "String");	// optional, default = true		
		parameterTypes.put("tabSize", "String");		// optional, default = 8
		parameterTypes.put("parserGenerator", "String");// optional, default = "antlr3" 
		parameterTypes.put("hyperlinks", "Map");		// optional, default = null 
		parameterTypes.put("trace", "Map");				// optional, default = null 
		parameterTypes.put("locationByElement", "Map");	// optional, default = null 
		parameterTypes.put("problems", "Model:Problem");// optional, default = null

		// Useful when the lexer and/or parser cannot be resolved from here
		parameterTypes.put("lexerClass", "Class");		// optional, default = null 
		parameterTypes.put("parserClass", "Class");		// optional, default = null 
	}

	public Map getParameterTypes() {
		return parameterTypes;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.injectors.Injector#inject(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.InputStream, java.util.Map)
	 */
	public ASMModelElement inject(ASMModel target, InputStream source, Map params) throws IOException {
		return inject(target, new InputStreamReader(source), params);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.engine.injectors.Injector#inject(org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel, java.io.Reader, java.util.Map)
	 */
	public ASMModelElement inject(ASMModel target, Reader source, Map params) throws IOException {
		this.targetModelAdapter = new ASMModelAdapter(target);
		
		ASMModel problems = (ASMModel)params.get("problems");
		if (problems != null) {
			this.problemsModelAdapter = new ASMModelAdapter(problems);
			params.put("problems", this.problemsModelAdapter);
		}	
		
		ASMModelElement root = (ASMModelElement)new ParserLauncher().parse(targetModelAdapter, source, params);
		
		return root;
	}

	public String getPrefix() {
		return "ebnf2";
	}
	
	protected ModelAdapter problemsModelAdapter;
	protected ModelAdapter targetModelAdapter;


	public void performImportation(ASMModel format, ASMModel extent, InputStream in, String other) throws IOException {
		throw new UnsupportedOperationException("Was deprecated a long time ago. It is now unsupported");		
	}
}
