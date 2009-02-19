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

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;

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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.String,
	 *      java.util.Map)
	 */
	public void inject(IModel sourceModel, String source, Map<String, Object> options)
			throws ATLCoreException {
		boolean loadOnDemand = true;
		if (options.containsKey(OPTION_LOAD_ON_DEMAND)) {
			loadOnDemand = options.get(OPTION_LOAD_ON_DEMAND).toString().equals("true"); //$NON-NLS-1$
		}
		Resource mainResource = null;
		ResourceSet resourceSet = ((EMFModelFactory)sourceModel.getModelFactory()).getResourceSet();
		String path = source.toString();
		if (path != null) {
			try {
				if (path.equals("#EMF")) { //$NON-NLS-1$
					mainResource = EcorePackage.eINSTANCE.eResource();
				} else if (path.startsWith("pathmap:")) { //$NON-NLS-1$
					mainResource = resourceSet.getResource(URI.createURI(path).trimFragment(), loadOnDemand);
				} else {
					mainResource = resourceSet.getResource(URI.createURI(path), loadOnDemand);
				}
			} catch (Exception e) {
				throw new ATLCoreException(Messages.getString("EMFInjector.NO_RESOURCE"),e); //$NON-NLS-1$
			}
		} else {
			throw new ATLCoreException(Messages.getString("EMFInjector.NO_RESOURCE")); //$NON-NLS-1$
		}
		inject((EMFModel)sourceModel, mainResource);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.String)
	 */
	public void inject(IModel sourceModel, String source) throws ATLCoreException {
		inject(sourceModel, source, Collections.<String, Object> emptyMap());
	}

	/**
	 * Injects data into an IModel from a {@link Resource}.
	 * 
	 * @param sourceModel
	 *            the IModel where to inject
	 * @param mainResource
	 *            the main Resource
	 */
	public void inject(EMFModel sourceModel, Resource mainResource) {
		sourceModel.setResource(mainResource);
		if (sourceModel instanceof EMFReferenceModel) {
			((EMFReferenceModel)sourceModel).register();
		}
	}

}
