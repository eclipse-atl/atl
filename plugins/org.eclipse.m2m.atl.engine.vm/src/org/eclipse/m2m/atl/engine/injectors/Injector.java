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
package org.eclipse.m2m.atl.engine.injectors;

import java.io.*;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.nativelib.*;

/**
 * @author Frédéric Jouault
 */
public interface Injector {

	/* New Injector interface. */

	/**
	 * returns the list of parameters supported by this injector
	 * in the form of a Map with parameter names as keys and type
	 * name as value.
	 * Known type names are:
	 * 		"String"
	 * 		"Model" 
	 */
	public Map getParameterTypes();
	
	/**
	 * Performs the injection.
	 * @param target The target model to populate.
	 * @param source The source InputStream. Alternative source kinds can be passed
	 * 				in params.
	 * @param params A Map of additional parameters. The key is the name.
	 * @return The root element of the populated model if it exists, any element else.
	 * @throws IOException
	 */
	public ASMModelElement inject(ASMModel target, InputStream source, Map params) throws IOException;

	/* Old Injector interface. */
	/**
	 * @deprecated This information should be in the megamodel.
	 */
	public String getPrefix();

	/**
	 * 
	 * @param format
	 * @param extent
	 * @param in
	 * @param other
	 * @throws IOException
	 * @deprecated The inject method should be used instead of this one.
	 */
	public void performImportation(ASMModel format, ASMModel extent, InputStream in, String other) throws IOException;
}
