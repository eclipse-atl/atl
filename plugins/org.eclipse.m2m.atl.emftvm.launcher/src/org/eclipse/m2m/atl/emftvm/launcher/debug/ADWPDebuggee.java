/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *     Dennis Wagelaar, Vrije Universiteit Brussel
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.launcher.debug;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.m2m.atl.debug.core.adwp.ADWP;
import org.eclipse.m2m.atl.debug.core.adwp.ObjectReference;

/**
 * The {@link ADWP} Debuggee.
 * Adapted from org.eclipse.m2m.atl.engine.emfvm.launch.debug.ADWPDebuggee.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class ADWPDebuggee extends ADWP {

	/**
	 * Creates a new {@link ADWPDebuggee}.
	 * @param in the debugging socket input stream
	 * @param out the debugging socket output stream
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
