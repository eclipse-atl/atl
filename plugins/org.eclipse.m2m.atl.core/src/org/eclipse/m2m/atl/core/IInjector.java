/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core;

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
	 * @param sourceModel
	 *            the IModel where to inject
	 * @param source
	 *            the source indication to extract the targetModel
	 */
	void inject(IModel sourceModel, Object source) throws ATLCoreException;

	/**
	 * Injects data into an IModel using the given options.
	 * 
	 * @param sourceModel
	 *            the IModel where to inject
	 * @param source
	 *            the source indication to extract the targetModel
	 * @param options
	 *            the injection parameters
	 */
	void inject(IModel sourceModel, Object source, Map<String, Object> options) throws ATLCoreException;

}
