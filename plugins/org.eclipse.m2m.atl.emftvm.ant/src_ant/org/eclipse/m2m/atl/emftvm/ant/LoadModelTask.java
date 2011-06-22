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
package org.eclipse.m2m.atl.emftvm.ant;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.Model;


/**
 * Loads a {@link Model}.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class LoadModelTask extends EMFTVMTask {

	private String name;
	private String wspath;
	private String uri;

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param wspath the wspath to set
	 */
	public void setWspath(String wspath) {
		this.wspath = wspath;
	}

	/**
	 * @return the wspath
	 */
	public String getWspath() {
		return wspath;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.ant.EMFTVMTask#innerExecute()
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
	 * @return a new Model.
	 */
	protected Model createModel() {
		return EmftvmFactory.eINSTANCE.createModel();
	}

	/**
	 * Loads model from nsuri.
	 * @param uri
	 */
	protected void loadFromNsuri(final String uri) {
		loadFromURI(URI.createURI(uri));
	}

	/**
	 * Loads model from wspath.
	 * @param wspath
	 */
	protected void loadFromWspath(final String wspath) {
		loadFromURI(URI.createPlatformResourceURI(wspath, true));
	}

	/**
	 * Loads model from EMF URI.
	 * @param uri
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
