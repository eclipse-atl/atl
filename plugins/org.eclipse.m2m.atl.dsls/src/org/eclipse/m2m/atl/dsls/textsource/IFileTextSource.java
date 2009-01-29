/*******************************************************************************
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls.textsource;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

/**
 * IFile text utility.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class IFileTextSource extends TextSource {
	
	private IFile file;
	
	/**
	 * Creates a new IFileTextSource.
	 * 
	 * @param file the file to manage
	 */
	public IFileTextSource(IFile file) {
		this.setFile(file);
	}

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.dsls.textsource.TextSource#openStream()
	 */
	public InputStream openStream() throws IOException {
		try {
			return getFile().getContents();
		} catch (CoreException e) {
			IOException ioe = new IOException("problem opening IFile");
			ioe.initCause(e);
			throw ioe;
		}
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(IFile file) {
		this.file = file;
	}

	/**
	 * @return the file
	 */
	public IFile getFile() {
		return file;
	}

}
