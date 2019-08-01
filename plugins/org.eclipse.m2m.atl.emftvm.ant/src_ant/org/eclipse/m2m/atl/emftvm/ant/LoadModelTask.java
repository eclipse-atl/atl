/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Model;


/**
 * Loads a {@link Model}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class LoadModelTask extends EMFTVMTask {

	private String name;
	private String wspath;
	private String uri;

	/**
	 * Sets the model name.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the model name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the model workspace path.
	 * @param wspath the wspath to set
	 */
	public void setWspath(String wspath) {
		this.wspath = wspath;
	}

	/**
	 * Returns the model workspace path.
	 * @return the wspath
	 */
	public String getWspath() {
		return wspath;
	}

	/**
	 * Sets the model URI.
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * Returns the model URI.
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void innerExecute() throws Exception {
		final String nsuri = getUri();
		if (nsuri != null) {
			loadFromNsuri(nsuri);
			return;
		}
		final String wspath = getWspath();
		if (wspath != null) {
			loadFromWspath(wspath);
			return;
		}
		throw new IllegalArgumentException("Either nsuri or wspath must be set");
	}

	/**
	 * Creates a new {@link Model} instance.
	 * @return a new {@link Model}.
	 */
	protected Model createModel() {
		return EmftvmFactory.eINSTANCE.createModel();
	}

	/**
	 * Loads model from <pre>nsuri</pre>.
	 * @param uri the namespace URI
	 */
	protected void loadFromNsuri(final String uri) {
		loadFromURI(URI.createURI(uri));
	}

	/**
	 * Loads model from <pre>wspath</pre>.
	 * @param wspath the workspace path
	 */
	protected void loadFromWspath(final String wspath) {
		loadFromURI(URI.createPlatformResourceURI(wspath, true));
	}

	/**
	 * Loads model from <pre>uri</pre>.
	 * @param uri the EMF URI
	 */
	protected void loadFromURI(final URI uri) {
		final ResourceSet rs = getResourceSet();
		final Resource r = rs.getResource(uri, true);
		if (r == null) {
			throw new IllegalArgumentException(String.format("Model with uri %s could not be found", uri));
		}
		final Model m = createModel();
		m.setResource(r);
		setModel(getName(), m);
	}

}
