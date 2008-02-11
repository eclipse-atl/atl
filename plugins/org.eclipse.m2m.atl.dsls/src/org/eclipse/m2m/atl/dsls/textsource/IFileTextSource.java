/*******************************************************************************
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Frédéric Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls.textsource;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

public class IFileTextSource extends TextSource {
	
	public IFile file;
	
	public IFileTextSource(IFile file) {
		this.file = file;
	}

	public InputStream openStream() throws IOException {
		try {
			return file.getContents();
		} catch (CoreException e) {
			IOException ioe = new IOException("problem opening IFile");
			ioe.initCause(e);
			throw ioe;
		}
	}

}
