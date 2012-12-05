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
	 * {@link IOException} with nested {@link Exception}.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public static class ATLIOException extends IOException {

		private static final long serialVersionUID = -6673120460005697460L;
		
		/**
		 * Creates a new {@link ATLIOException}.
		 */
		public ATLIOException() {
			super();
		}

		/**
		 * Creates a new {@link ATLIOException}.
		 * @param message the error message
		 * @param cause the nested exception
		 */
		public ATLIOException(String message, Throwable cause) {
			super(message);
			initCause(cause);
		}

		/**
		 * Creates a new {@link ATLIOException}.
		 * @param message the error message
		 */
		public ATLIOException(String message) {
			super(message);
		}

		/**
		 * Creates a new {@link ATLIOException}.
		 * @param cause the nested exception
		 */
		public ATLIOException(Throwable cause) {
			super();
			initCause(cause);
		}

	}

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
			throw new ATLIOException(e);
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
			throw new ATLIOException(e);
		}
	}

	/**
	 * Registers any dynamic EPackage URIs in <code>res</code>.
	 * 
	 * @param res
	 *            the resource containing the EPackages
	 * @throws IOException
	 *             if the nsURIs from EPackages from r are already registered by other EPackages
	 */
	protected void registerEPackages(final Resource res) throws IOException {
		final ResourceSet rs = getResourceSet();
		final Registry r = rs.getPackageRegistry();
		for (EObject o : res.getContents()) {
			if (o instanceof EPackage) {
				EPackage p = (EPackage)o;
				if (r.containsKey(p.getNsURI()) && r.get(p.getNsURI()) != p) {
					throw new IOException(String.format("EPackage with URI \"%s\" already registered by another EPackage instance",
							p.getNsURI()));
				}
				r.put(p.getNsURI(), p);
			}
		}
	}

}
