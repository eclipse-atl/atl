/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.core.emf;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;

/**
 * The EMF implementation of the {@link IInjector} interface.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFInjector implements IInjector {

	/** EMF loadOnDemand option. */
	public static final String OPTION_LOAD_ON_DEMAND = "loadOnDemand"; //$NON-NLS-1$

	/**
	 * {@inheritDoc} Below the source parameter semantic.
	 * <ul>
	 * <li><b>File system Resource: </b><code>file:/<i>path</i></code></li>
	 * <li><b>EMF {@link URI}: </b><code><i>uri</i></code></li>
	 * <li><b>pathmap: </b><code>pathmap:<i>path</i></code></li>
	 * <li><b>Workspace Resource: </b><code>platform:/resource/<i>path</i></code></li>
	 * <li><b>Plug-in Resource: </b><code>platform:/plugin/<i>path</i></code></li>
	 * </ul>
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.String,
	 *      java.util.Map)
	 */
	public void inject(IModel targetModel, String source, Map<String, Object> options)
			throws ATLCoreException {
		boolean loadOnDemand = true;
		if (options.containsKey(OPTION_LOAD_ON_DEMAND)) {
			loadOnDemand = options.get(OPTION_LOAD_ON_DEMAND).toString().equals("true"); //$NON-NLS-1$
		}
		ResourceSet resourceSet = ((EMFModelFactory)targetModel.getModelFactory()).getResourceSet();
		String path = source.toString();
		if (path != null) {
			try {
				Resource mainResource = null;
				if (path.startsWith("pathmap:")) { //$NON-NLS-1$
					mainResource = resourceSet.getResource(URI.createURI(path).trimFragment(), loadOnDemand);
				} else {
					mainResource = resourceSet.getResource(URI.createURI(path), loadOnDemand);
				}
				inject(targetModel, mainResource);
				// Catching Exception to prevent EMF DiagnosticWrappedExceptions
			} catch (Throwable e) {
				throw new ATLCoreException(Messages.getString(
						"EMFInjector.LOADING_ERROR", source, e.getMessage()), e); //$NON-NLS-1$ 
			}
		} else {
			throw new ATLCoreException(Messages.getString("EMFInjector.NO_RESOURCE")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.String)
	 */
	public void inject(IModel targetModel, String source) throws ATLCoreException {
		inject(targetModel, source, Collections.<String, Object> emptyMap());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.io.InputStream,
	 *      java.util.Map)
	 */
	public void inject(IModel targetModel, InputStream source, Map<String, Object> options)
			throws ATLCoreException {
		Resource mainResource = null;
		ResourceSet resourceSet = ((EMFModelFactory)targetModel.getModelFactory()).getResourceSet();
		// TODO [Resource.Factory issues] use the correct factory
		mainResource = resourceSet.createResource(URI.createURI("new-model")); //$NON-NLS-1$
		try {
			mainResource.load(source, options);
		} catch (IOException e) {
			throw new ATLCoreException(e.getMessage(), e);
		}
		inject(targetModel, mainResource);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.io.Reader,
	 *      java.util.Map)
	 */
	public void inject(IModel targetModel, Reader source, Map<String, Object> options)
			throws ATLCoreException {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Injects data into an IModel from a {@link Resource}.
	 * 
	 * @param targetModel
	 *            the IModel where to inject
	 * @param mainResource
	 *            the main Resource
	 */
	public void inject(IModel targetModel, Resource mainResource) {
		((EMFModel)targetModel).setResource(mainResource);
		if (targetModel instanceof IReferenceModel) {
			((EMFReferenceModel)targetModel).register();
		}
	}

}
