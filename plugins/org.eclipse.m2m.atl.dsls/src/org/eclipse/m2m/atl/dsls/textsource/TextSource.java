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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The abstract text source definition.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class TextSource {

	/**
	 * Returns an input stream of the text source.
	 * 
	 * @return an input stream of the text source
	 * @throws IOException
	 */
	public abstract InputStream openStream() throws IOException;

	/**
	 * Returns a buffered reader of the text source.
	 * 
	 * @return a buffered reader of the text source
	 * @throws IOException
	 */
	public BufferedReader openBufferedReader() throws IOException {
		return new BufferedReader(new InputStreamReader(openStream()));
	}
}
