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
import java.net.MalformedURLException;
import java.net.URL;


public class URLTextSource extends TextSource {
	
	private URL url;
	
	public URLTextSource(URL url) {
		this.url = url;
	}

	public URLTextSource(String url) throws MalformedURLException {
		this(new URL(url));
	}

	public InputStream openStream() throws IOException {
		return url.openStream();
	}

}
