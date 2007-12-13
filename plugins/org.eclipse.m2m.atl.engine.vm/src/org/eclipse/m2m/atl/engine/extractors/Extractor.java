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
package org.eclipse.m2m.atl.engine.extractors;

import java.io.OutputStream;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * @author Frédéric Jouault
 */
public interface Extractor {

	/*	New Extractor interface. */

	/**
	 * returns the list of parameters supported by this extractor
	 * in the form of a Map with parameter names as keys and type
	 * name as value.
	 * Known type names are:
	 * 		"String"
	 * 		"Model" 
	 */
	public Map getParameterTypes();

	/**
	 * Performs the extraction.
	 * @param source The model to extract.
	 * @param target The target OutputStream. Note that other target kinds
	 * 				can be used using params.
	 * @param params A Map of additional parameters. The key is the name of the
	 * 				parameter.
	 */
	public void extract(ASMModel source, OutputStream target, Map params);

	/* Old Extractor interface. */
	/**
	 * @deprecated This information should be in a megamodel.
	 */
	public String getPrefix();

	/**
	 * @param format
	 * @param extent
	 * @param out
	 * @deprecated The other extract method should be used instead.
	 */
	public void extract(ASMModel format, ASMModel extent, OutputStream out);
}
