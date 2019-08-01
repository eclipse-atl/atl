/*******************************************************************************
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls.textsource;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.atl.dsls.Messages;

/**
 * IFile text utility.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class IFileTextSource extends TextSource {
	
	private IFile file;
	
	public IFile getFile() {
		return file;
	}

	/**
	 * Creates a new IFileTextSource.
	 * 
	 * @param file the file to manage
	 */
	public IFileTextSource(IFile file) {
		this.file = file;
	}

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.dsls.textsource.TextSource#openStream()
	 */
	public InputStream openStream() throws IOException {
		try {
			return file.getContents();
		} catch (CoreException e) {
			IOException ioe = new IOException(Messages.getString("IFileTextSource.OPENINGPROBLEM")); //$NON-NLS-1$
			ioe.initCause(e);
			throw ioe;
		}
	}

}
