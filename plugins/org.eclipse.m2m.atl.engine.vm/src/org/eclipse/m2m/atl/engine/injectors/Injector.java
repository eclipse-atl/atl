/*******************************************************************************
 * Copyright (c) 2004, 2014 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 * 	   Dennis Wagelaar
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.injectors;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;

/**
 * The Injector interface.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public interface Injector {

	/**
	 * returns the list of parameters supported by this injector in the form of a Map with parameter names as
	 * keys and type name as value. Known type names are: "String" "Model"
	 *
	 * @return the Map of parameter types
	 */
	Map getParameterTypes();

	/**
	 * Performs the injection.
	 * 
	 * @param target
	 *            The target model to populate.
	 * @param source
	 *            The source InputStream. Alternative source kinds can be passed in params.
	 * @param params
	 *            A Map of additional parameters. The key is the name.
	 * @return The root element of the populated model if it exists, any element else.
	 * @throws IOException
	 */
	ASMModelElement inject(ASMModel target, InputStream source, Map params) throws IOException;

	/**
	 * Performs the injection.
	 * 
	 * @param target
	 *            The target model to populate.
	 * @param source
	 *            The source Reader. Alternative source kinds can be passed in params.
	 * @param params
	 *            A Map of additional parameters. The key is the name.
	 * @return The root element of the populated model if it exists, any element else.
	 * @throws IOException
	 */
	ASMModelElement inject(ASMModel target, Reader source, Map params) throws IOException;
	
	/* Old Injector interface. */
	/**
	 * @deprecated This information should be in the megamodel.
	 */
	String getPrefix();

	/**
	 * @param format
	 * @param extent
	 * @param in
	 * @param other
	 * @throws IOException
	 * @deprecated The inject method should be used instead of this one.
	 */
	void performImportation(ASMModel format, ASMModel extent, InputStream in, String other)
			throws IOException;
}
