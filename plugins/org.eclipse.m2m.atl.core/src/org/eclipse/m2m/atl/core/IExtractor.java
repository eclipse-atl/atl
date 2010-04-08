/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core;

import java.io.OutputStream;
import java.util.Map;

/**
 * The IExtractor interface defines a way to serialize a given IModel.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public interface IExtractor {

	/**
	 * Extracts an IModel using default options.
	 * 
	 * @param sourceModel
	 *            the IModel to extract
	 * @param target
	 *            the target indication to extract the targetModel
	 */
	void extract(IModel sourceModel, String target) throws ATLCoreException;

	/**
	 * Extracts an IModel using the given options.
	 * 
	 * @param sourceModel
	 *            the IModel to extract
	 * @param target
	 *            the target indication to extract the targetModel
	 * @param options
	 *            the extraction parameters
	 */
	void extract(IModel sourceModel, String target, Map<String, Object> options) throws ATLCoreException;
	
	/**
	 * Extracts an IModel using the given options.
	 * 
	 * @param sourceModel
	 *            the IModel to extract
	 * @param target
	 *            the {@link OutputStream} where to extract the targetModel
	 * @param options
	 *            the extraction parameters
	 */
	void extract(IModel sourceModel, OutputStream target, Map<String, Object> options) throws ATLCoreException;
}
