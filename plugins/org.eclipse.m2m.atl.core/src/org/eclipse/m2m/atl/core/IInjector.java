/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core;

import java.io.InputStream;
import java.util.Map;

/**
 * The IInjector interface defines a way to serialize a given IModel.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public interface IInjector {

	/**
	 * Injects data into an IModel using default options.
	 * 
	 * @param targetModel
	 *            the IModel where to inject
	 * @param source
	 *            the source indication to load the sourceModel
	 */
	void inject(IModel targetModel, String source) throws ATLCoreException;

	/**
	 * Injects data into an IModel using the given options.
	 * 
	 * @param targetModel
	 *            the IModel where to inject
	 * @param source
	 *            the source indication to load the sourceModel: an URL, or a specific thing
	 * @param options
	 *            the injection parameters
	 */
	void inject(IModel targetModel, String source, Map<String, Object> options) throws ATLCoreException;

	/**
	 * Injects data into an IModel using the given options.
	 * 
	 * @param targetModel
	 *            the IModel where to inject
	 * @param source
	 *            the {@link InputStream} containing the model
	 * @param options
	 *            the injection parameters
	 */
	void inject(IModel targetModel, InputStream source, Map<String, Object> options) throws ATLCoreException;

	
}
