/*******************************************************************************
 * Copyright (c) 2008 Obeo.
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
import org.eclipse.emf.ecore.EPackage;
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.Object,
	 *      java.util.Map)
	 */
	public void inject(IModel sourceModel, Object source, Map<String, Object> options) throws ATLCoreException {
		Resource mainResource = null;
		ResourceSet resourceSet = ((EMFModelFactory)sourceModel.getModelFactory()).getResourceSet();

		String path = source.toString();
		if (path != null) {
			// EMF Registry
			if (path.startsWith("uri:")) { //$NON-NLS-1$
				path = path.substring(4);
				EPackage pack = EPackage.Registry.INSTANCE.getEPackage(path);
				if (pack != null) {
					mainResource = pack.eResource();
				} else {
					throw new ATLCoreException(Messages.getString("EMFInjector.PACKAGE_NOT_FOUND", path)); //$NON-NLS-1$
				}
				// File system
			} else if (path.startsWith("ext:")) { //$NON-NLS-1$
				path = path.substring(4);
				mainResource = resourceSet.getResource(URI.createFileURI(path), true);
				// EMF
			} else if (path.equals("#EMF")) { //$NON-NLS-1$
				mainResource = EcorePackage.eINSTANCE.eResource();
				// Workspace
			} else if (path.startsWith("pathmap:")) { //$NON-NLS-1$
				mainResource = resourceSet.getResource(URI.createURI(path).trimFragment(), true);
			} else {
				mainResource = resourceSet.getResource(URI.createPlatformResourceURI(path, false), true);
			}
		} else {
			throw new ATLCoreException(Messages.getString("EMFInjector.NO_RESOURCE")); //$NON-NLS-1$
		}

		((EMFModel)sourceModel).setResource(mainResource);

		if (sourceModel instanceof EMFReferenceModel) {
			((EMFReferenceModel)sourceModel).register();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.core.IInjector#inject(org.eclipse.m2m.atl.core.IModel, java.lang.Object)
	 */
	public void inject(IModel sourceModel, Object source) throws ATLCoreException {
		inject(sourceModel, source, Collections.<String, Object> emptyMap());
	}

}
