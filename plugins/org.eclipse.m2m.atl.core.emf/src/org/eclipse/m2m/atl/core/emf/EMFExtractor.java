/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.service.LauncherService;

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
			recreateResourceIfNeeded(
					(EMFModel)sourceModel,
					URI.createURI(target),
					(String)options.get("contentType"), LauncherService.getBooleanOption(options.get("OPTION_CONTENT_TYPE"), false)); //$NON-NLS-1$ //$NON-NLS-2$
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
		recreateResourceIfNeeded(
				sourceModel,
				URI.createURI("tmp." + fileExtension), (String)options.get("contentType"), (Boolean)options.get("contentTypeLookup")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		extract(sourceModel, target, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IExtractor#extract(org.eclipse.m2m.atl.core.IModel, java.io.OutputStream,
	 *      java.util.Map)
	 */
	public void extract(IModel sourceModel, OutputStream target, Map<String, Object> options)
			throws ATLCoreException {
		if (((EMFModel)sourceModel).getResource() == null) {
			// creates a mock resource
			// TODO [Resource.Factory issues] use the correct factory
			((EMFModel)sourceModel).setResource(((EMFModel)sourceModel).getModelFactory().getResourceSet()
					.createResource(URI.createURI("tmp"))); //$NON-NLS-1$
			return;
		}
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
	 * @param contentType
	 *            the content type of the resource to save
	 * @param contentTypeLookup
	 *            specify whether the Extractor should automatically resolve the EPackage content type
	 */
	protected static void recreateResourceIfNeeded(EMFModel model, URI uri, String contentType,
			boolean contentTypeLookup) throws ATLCoreException {
		ResourceSet resourceSet = model.getModelFactory().getResourceSet();
		if (contentType == null && contentTypeLookup) {
			EMFReferenceModel referenceModel = model.getReferenceModel();
			Resource mmResource = referenceModel.getResource();
			if (mmResource != null) {
				contentType = getContentTypeIdentifier(resourceSet, mmResource.getURI());
			}
		}
		if (model.getResource() == null) {
			model.setResource(createResource(resourceSet, uri, contentType));
			return;
		}

		if (contentType != null || !uri.toString().endsWith(".xmi")) { //$NON-NLS-1$
			// recreates the resource to prevent contentType / ResourceFactory issues
			Resource newResource = createResource(resourceSet, uri, contentType);
			newResource.getContents().addAll(model.getResource().getContents());
			model.setResource(newResource);
		} else {
			model.getResource().setURI(uri);
		}
	}

	private static Resource createResource(ResourceSet resourceSet, URI uri, String contentType)
			throws ATLCoreException {
		if (contentType != null) {
			try {
				Method method = resourceSet.getClass().getDeclaredMethod(
						"createResource", URI.class, String.class); //$NON-NLS-1$
				try {
					if (method != null) {
						return (Resource)method.invoke(resourceSet, uri, contentType);
					}
				} catch (IllegalArgumentException e) {
					throw new ATLCoreException(e.getMessage(), e);
				} catch (IllegalAccessException e) {
					throw new ATLCoreException(e.getMessage(), e);
				} catch (InvocationTargetException e) {
					throw new ATLCoreException(e.getMessage(), e);
				}
			} catch (SecurityException e) {
				// should not happen
			} catch (NoSuchMethodException e) {
				// do nothing, switch to standard case
			}
		}
		return resourceSet.createResource(uri);
	}

	private static String getContentTypeIdentifier(ResourceSet resourceSet, URI uri) {
		EPackage pack = resourceSet.getPackageRegistry().getEPackage(uri.toString());
		if (pack != null) {
			try {
				Field contentType = pack.getClass().getField("eCONTENT_TYPE"); //$NON-NLS-1$
				if (contentType != null) {
					return (String)contentType.get(pack);
				}
			} catch (NoSuchFieldException e) {
				// no content type
			} catch (IllegalAccessException e) {
				// no content type
			}
		}
		return null;
	}
}
