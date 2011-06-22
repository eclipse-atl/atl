/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * Wraps the ATL parser.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class AtlResourceImpl extends ResourceImpl {

	/**
	 * Wraps an {@link EMFModel} around this resource.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public class EMFModelWrapper extends EMFModel {

		/**
		 * Creates a new {@link EMFModelWrapper} around this resource.
		 */
		public EMFModelWrapper() {
			super(
					(EMFReferenceModel)parser.getAtlMetamodel(), 
					(EMFModelFactory)parser.getModelFactory());
			setResource(AtlResourceImpl.this);
		}
		
	}

	protected final AtlParser parser = AtlParser.getDefault();
	protected final EMFModelWrapper modelWrapper = new EMFModelWrapper();

	/**
	 * Creates a new {@link AtlResourceImpl}.
	 */
	public AtlResourceImpl() {
		super();
	}

	/**
	 * Creates a new {@link AtlResourceImpl} for <code>uri</code>.
	 * @param uri the resource's URI
	 */
	public AtlResourceImpl(URI uri) {
		super(uri);
	}

	/**
	 * Loads an ATL resource.
	 * @param inputStream the data source
	 * @param options options passed to the ATL parser
	 */
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		try {
			parser.inject(modelWrapper, inputStream, options);
			registerEPackages(modelWrapper.getReferenceModel().getResource());
		} catch (ATLCoreException e) {
			throw new IOException(e);
		}
	}

	/**
	 * Saves an ATL resource.
	 * @param outputStream the data destination
	 * @param options the options passed to the ATL extractor
	 */
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		try {
			parser.extract(modelWrapper, outputStream, options);
		} catch (ATLCoreException e) {
			throw new IOException(e);
		}
	}

	/**
	 * Registers any dynamic EPackage URIs in <code>res</code>.
	 * @param res the resource containing the EPackages
	 */
	protected void registerEPackages(final Resource res) {
		final ResourceSet rs = getResourceSet();
		final Registry r = rs.getPackageRegistry();
		for (EObject o : res.getContents()) {
			if (o instanceof EPackage) {
				EPackage p = (EPackage)o;
				r.put(p.getNsURI(), p);
			}
		}
	}

}
