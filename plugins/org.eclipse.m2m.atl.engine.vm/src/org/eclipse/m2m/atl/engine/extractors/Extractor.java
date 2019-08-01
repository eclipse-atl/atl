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
package org.eclipse.m2m.atl.engine.extractors;

import java.io.OutputStream;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public interface Extractor {

	/* New Extractor interface. */

	/**
	 * returns the list of parameters supported by this extractor in the form of a Map with parameter names as
	 * keys and type name as value. Known type names are: "String" "Model"
	 */
	Map getParameterTypes();

	/**
	 * Performs the extraction.
	 * 
	 * @param source
	 *            The model to extract.
	 * @param target
	 *            The target OutputStream. Note that other target kinds can be used using params.
	 * @param params
	 *            A Map of additional parameters. The key is the name of the parameter.
	 */
	void extract(ASMModel source, OutputStream target, Map params);

	/* Old Extractor interface. */
	/**
	 * @deprecated This information should be in a megamodel.
	 */
	String getPrefix();

	/**
	 * @param format
	 * @param extent
	 * @param out
	 * @deprecated The other extract method should be used instead.
	 */
	void extract(ASMModel format, ASMModel extent, OutputStream out);
}
