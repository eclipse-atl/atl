/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
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
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;

/**
 * The EMF implementation of the {@link IExtractor} interface.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFExtractor implements IExtractor {

	/**
	 * {@inheritDoc} Below the target parameter semantic.
	 * <ul>
	 * <li><b>File system Resource: </b><code>file:/<i>path</i></code></li>
	 * <li><b>Workspace Resource: </b><code>platform:/resource/<i>path</i></code></li>
	 * </ul>
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.String,
	 *      java.util.Map)
	 */
	public void extract(IModel sourceModel, String target, Map<String, Object> options)
			throws ATLCoreException {
		if (target != null) {
			if (((EMFModel)sourceModel).getResource() != null) {
				recreateResourceIfNeeded((EMFModel)sourceModel, URI.createURI(target));
				Map<String, Object> extractOptions = new HashMap<String, Object>();
				extractOptions.put(XMLResource.OPTION_ENCODING, "ISO-8859-1"); //$NON-NLS-1$
				extractOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
				if (options != null) {
					extractOptions.putAll(options);
				}
				try {
					((EMFModel)sourceModel).getResource().save(extractOptions);
				} catch (IOException e) {
					throw new ATLCoreException(e.getMessage(), e);
				}
			} else {
				throw new ATLCoreException(Messages.getString(
						"EMFExtractor.NO_RESOURCE", new Object[] {target})); //$NON-NLS-1$
			}
		} else {
			throw new ATLCoreException(Messages.getString("EMFExtractor.NO_PATH")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.lang.String)
	 */
	public void extract(IModel sourceModel, String target) throws ATLCoreException {
		extract(sourceModel, target, Collections.<String, Object> emptyMap());
	}

	/**
	 * Extracts an {@link EMFModel} to an {@link OutputStream}.
	 * 
	 * @param sourceModel
	 *            the {@link EMFModel} to extract
	 * @param target
	 *            the target {@link OutputStream} to extract the targetModel
	 * @param fileExtension
	 *            the target file extension: defines the output format, default "xmi"
	 * @param options
	 *            the extraction parameters
	 */
	public void extract(EMFModel sourceModel, OutputStream target, String fileExtension,
			Map<String, Object> options) throws ATLCoreException {
		recreateResourceIfNeeded(sourceModel, URI.createURI("tmp." + fileExtension)); //$NON-NLS-1$
		extract(sourceModel, target, options);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.io.OutputStream, java.util.Map)
	 */
	public void extract(IModel sourceModel, OutputStream target, Map<String, Object> options) throws ATLCoreException {
		Map<String, Object> extractOptions = new HashMap<String, Object>();
		extractOptions.put(XMLResource.OPTION_ENCODING, "ISO-8859-1"); //$NON-NLS-1$
		extractOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		if (options != null) {
			extractOptions.putAll(options);
		}
		try {
			((EMFModel)sourceModel).getResource().save(target, extractOptions);
		} catch (IOException e) {
			throw new ATLCoreException(e.getMessage(), e);
		}
	}

	/**
	 * Recreates the resource in order to save in the correct format matching the file extension.
	 * 
	 * @param model
	 *            the model to recreate
	 * @param uri
	 *            the target {@link URI} with the correct extension
	 */
	protected static void recreateResourceIfNeeded(EMFModel model, URI uri) {
		if (model.getEmfResourceFactory() == null) {
			// recreates the resource only if no correct factory has been initialized
			ResourceSet resourceSet = model.getModelFactory().getResourceSet();
			Resource newResource = resourceSet.createResource(uri);
			newResource.getContents().addAll(model.getResource().getContents());
			model.setResource(newResource);
		} else {
			model.getResource().setURI(uri);
		}
	}

}
