/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core;

import java.util.Map;

/**
 * The ModelFactory abstract class allows to create {@link IModel} and {@link IReferenceModel}.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class ModelFactory {
	/**
	 * Returns the Metametamodel.
	 * 
	 * @return the Metametamodel
	 */
	public abstract IReferenceModel getMetametamodel();

	/**
	 * Returns a default {@link IInjector} associated with the current factory.
	 * 
	 * @return the default {@link IInjector}
	 */
	public abstract String getDefaultInjectorName();

	/**
	 * Returns a default {@link IExtractor} associated with the current factory.
	 * 
	 * @return the default {@link IExtractor}
	 */
	public abstract String getDefaultExtractorName();

	/**
	 * Creates a new {@link IReferenceModel} using default options.
	 * 
	 * @return a new {@link IReferenceModel}
	 */
	public abstract IReferenceModel newReferenceModel() throws ATLCoreException;

	/**
	 * Creates a new {@link IReferenceModel} using specified options.
	 * 
	 * @param options
	 *            the creation options
	 * @return a new {@link IReferenceModel}
	 */
	public abstract IReferenceModel newReferenceModel(Map<String, Object> options) throws ATLCoreException;

	/**
	 * Creates a new {@link IModel} using default options and conforming to the given {@link IReferenceModel}.
	 * 
	 * @param referenceModel
	 *            the {@link IReferenceModel}
	 * @return a new {@link IModel}
	 */
	public abstract IModel newModel(IReferenceModel referenceModel) throws ATLCoreException;

	/**
	 * Creates a new {@link IModel} using specified options and conforming to the given
	 * {@link IReferenceModel}.
	 * 
	 * @param referenceModel
	 *            the {@link IReferenceModel}
	 * @param options
	 *            the creation options
	 * @return a new {@link IModel}
	 */
	public abstract IModel newModel(IReferenceModel referenceModel, Map<String, Object> options)
			throws ATLCoreException;

	/**
	 * Returns the built-in resource matching the given name.
	 * 
	 * @param name
	 *            the resource name
	 * @return the built-in resource matching the given name
	 */
	public abstract IReferenceModel getBuiltInResource(String name) throws ATLCoreException;
}
