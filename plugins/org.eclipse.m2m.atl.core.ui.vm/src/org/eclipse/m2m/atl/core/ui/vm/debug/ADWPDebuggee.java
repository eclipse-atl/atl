/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui.vm.debug;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.m2m.atl.debug.core.adwp.ADWP;
import org.eclipse.m2m.atl.debug.core.adwp.ObjectReference;

/**
 * The ADWP Debuggee.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ADWPDebuggee extends ADWP {

	/**
	 * Creates a new Debuggee.
	 * 
	 * @param in
	 *            the debugging socket input stream
	 * @param out
	 *            the debugging socket output stream
	 */
	public ADWPDebuggee(InputStream in, OutputStream out) {
		super(in, out);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.debug.core.adwp.ADWP#readObjectReference(int)
	 */
	@Override
	protected ObjectReference readObjectReference(int id) {
		return LocalObjectReference.valueOf(id);
	}
}
