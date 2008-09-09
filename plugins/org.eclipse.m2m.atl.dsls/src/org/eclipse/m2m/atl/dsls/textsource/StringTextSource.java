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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Manages a text source in a string.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class StringTextSource extends TextSource {

	private String string;

	/**
	 * Constructor.
	 * 
	 * @param string
	 *            the string text
	 */
	public StringTextSource(String string) {
		this.string = string;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.dsls.textsource.TextSource#openStream()
	 */
	public InputStream openStream() throws IOException {
		return new ByteArrayInputStream(string.getBytes());
	}

}
