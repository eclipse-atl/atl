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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
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
	protected final EMFModelFactory modelFactory = new EMFModelFactory();

	private byte[] rawContent;

	/**
	 * Creates a new {@link AtlResourceImpl}.
	 */
	public AtlResourceImpl() {
		super();
		setTrackingModification(true);
	}

	/**
	 * Creates a new {@link AtlResourceImpl} for <code>uri</code>.
	 * @param uri the resource's URI
	 */
	public AtlResourceImpl(URI uri) {
		super(uri);
		setTrackingModification(true);
	}

	/**
	 * Returns the raw concrete syntax for this resource.
	 * 
	 * @return the rawContent
	 */
	protected byte[] getRawContent() {
		return rawContent;
	}

	/**
	 * Sets the raw concrete syntax for this resource.
	 * 
	 * @param rawContent
	 *            the rawContent to set
	 */
	protected void setRawContent(byte[] rawContent) {
		this.rawContent = rawContent;
	}

	/**
	 * Loads an ATL resource.
	 * @param inputStream the data source
	 * @param options options passed to the ATL parser
	 */
	@Override
	protected void doLoad(final InputStream inputStream, final Map<?, ?> options) throws IOException {
		// Cache original input
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		final byte[] buf = new byte[1024];
		int read;
		while ((read = inputStream.read(buf)) > 0) {
			bos.write(buf, 0, read);
		}
		setRawContent(bos.toByteArray());
		// Parse model
		final EMFTCSInjector ebnfi = new EMFTCSInjector();
		final IModel pbs = modelFactory.newModel(parser.getProblemMetamodel());
		final Map<Object, Object> params = new HashMap<Object, Object>();
		params.put("name", "ATL");
		params.put("problems", pbs);
		if (options != null) {
			params.putAll(options);
		}
		ebnfi.inject(modelWrapper, new ByteArrayInputStream(getRawContent()), params);
		// Report problems
		int nbErrors = 0;
		for (Iterator<? extends Object> i = pbs.getElementsByType(parser.getProblemMetamodel().getMetaElementByName("Problem")).iterator(); i
				.hasNext();) {
			final EObject ame = (EObject) i.next();
			final Enumerator severity = (Enumerator) ame.eGet(ame.eClass().getEStructuralFeature("severity"));
			List<Diagnostic> list = null;
			if (severity.getName().equals("error")) {
				list = getErrors();
				nbErrors++;
			} else if (severity.getName().equals("warning")) {
				list = getWarnings();
			}
			if (list != null) {
				final String message = (String) ame.eGet(ame.eClass().getEStructuralFeature("description")); //$NON-NLS-1$
				final String location = (String) ame.eGet(ame.eClass().getEStructuralFeature("location")); //$NON-NLS-1$
				final String parts[] = location.split("-")[0].split(":");
				final int line = Integer.parseInt(parts[0]);
				final int column = Integer.parseInt(parts[1]);
				list.add(new Diagnostic() {
					public int getColumn() {
						return column;
					}

					public int getLine() {
						return line;
					}

					public String getLocation() {
						return getURI().toString();
					}

					public String getMessage() {
						return message;
					}

					@Override
					public String toString() {
						final StringBuffer buf = new StringBuffer(getMessage());
						buf.append(" (");
						buf.append(getLocation());
						buf.append(':');
						buf.append(getLine());
						buf.append(')');
						return buf.toString();
					}
				});
			}
		}
		if (nbErrors == 0) {
			getWarnings().clear(); // because the EMF editor fails when there are warnings
		}

		registerEPackages(modelWrapper.getReferenceModel().getResource());
	}

	/**
	 * Saves an ATL resource.
	 * @param outputStream the data destination
	 * @param options the options passed to the ATL extractor
	 */
	@Override
	protected void doSave(final OutputStream outputStream, final Map<?, ?> options) throws IOException {
		final byte[] rawContent = getRawContent();
		if (!isModified() && rawContent != null) {
			ATLLogger.fine("Content not modified - saving original content.");
			outputStream.write(rawContent);
			outputStream.close();
		} else {
			try {
				parser.extract(modelWrapper, outputStream, options);
			} catch (ATLCoreException e) {
				throw new ATLIOException(e);
			}
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
