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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Text utility.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ByteArrayTextSource extends TextSource {

	private byte[] bs;
	
	/**
	 * Creates a new ByteArrayTextSource.
	 * 
	 * @param bs the byte array
	 */
	public ByteArrayTextSource(byte[] bs) {
		this.bs = bs;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.dsls.textsource.TextSource#openStream()
	 */
	public InputStream openStream() throws IOException {
		return new ByteArrayInputStream(bs);
	}

}
