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
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Manages a text source by url.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class URLTextSource extends TextSource {

	private URL url;

	/**
	 * Constructor.
	 * 
	 * @param url
	 *            the text source url
	 */
	public URLTextSource(URL url) {
		this.url = url;
	}

	/**
	 * Constructor.
	 * 
	 * @param url
	 *            the text source url, in a String form
	 * @throws MalformedURLException
	 */
	public URLTextSource(String url) throws MalformedURLException {
		this(new URL(url));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.dsls.textsource.TextSource#openStream()
	 */
	public InputStream openStream() throws IOException {
		return url.openStream();
	}

}
