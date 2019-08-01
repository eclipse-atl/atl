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

import java.io.IOException;
import java.util.Collections;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.Model;


/**
 * Saves a {@link Model}.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class SaveModelTask extends EMFTVMTask {

	private String name;
	private String wspath;
	private String uri;
	private boolean derived;

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
	 * Sets the workspace path.
	 * @param wspath the wspath to set
	 */
	public void setWspath(String wspath) {
		this.wspath = wspath;
	}

	/**
	 * Returns the workspace path.
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
	 * Sets this model file as derived.
	 * @param derived the derived to set
	 */
	public void setDerived(boolean derived) {
		this.derived = derived;
	}

	/**
	 * Returns whether this model file is derived.
	 * @return the derived
	 */
	public boolean isDerived() {
		return derived;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void innerExecute() throws Exception {
		final String nsuri = getUri();
		if (nsuri != null) {
			saveToNsuri(nsuri);
			return;
		}
		final String wspath = getWspath();
		if (wspath != null) {
			saveToWspath(wspath);
			return;
		}
		saveToURI(null);
	}

	/**
	 * Saves model to <pre>uri</pre>.
	 * @param uri the EMF URI
	 */
	protected void saveToNsuri(final String uri) {
		saveToURI(URI.createURI(uri));
	}

	/**
	 * Saves model to <pre>wspath</pre>.
	 * @param wspath the workspace path
	 */
	protected void saveToWspath(final String wspath) {
		saveToURI(URI.createPlatformResourceURI(wspath, true));
	}

	/**
	 * Saves model to EMF URI.
	 * @param uri the EMF URI
	 */
	@SuppressWarnings("deprecation")
	protected void saveToURI(final URI uri) {
		final Model m = getModel(getName());
		if (m == null) {
			throw new IllegalArgumentException(String.format("Model %s could not be found", getName()));
		}
		final Resource r = m.getResource();
		if (uri != null) {
			r.setURI(uri);
		}
		try {
			r.save(Collections.emptyMap());
			final URI rUri = r.getURI();
			if (isDerived() && rUri.isPlatformResource()) {
				final IPath path = new Path(rUri.toPlatformString(true));
				final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				file.setDerived(true);
			}
		} catch (IOException e) {
			throw new BuildException(e);
		} catch (CoreException e) {
			throw new BuildException(e);
		}
	}

}
