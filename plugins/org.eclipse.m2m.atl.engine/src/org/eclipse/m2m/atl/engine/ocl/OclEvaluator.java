/*******************************************************************************
 * Copyright (c) 2006 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.ocl;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.asm.ASM;

/**
 * Utility to evaluate ocl.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class OclEvaluator {

	protected EObject[] pbs;

	/**
	 * Compiles an atl string into asm.
	 * 
	 * @param atlArg
	 *            the string
	 * @return the ASM file
	 * @throws IOException
	 */
	protected ASM compile(String atlArg) throws IOException {
		// TODO
		// // forcing usage of ATL 2006
		//		String atl = "-- @atlcompiler atl2006\n" + atlArg; //$NON-NLS-1$
		// ByteArrayInputStream input = new ByteArrayInputStream(atl.getBytes());
		// IFile file = ASMRetriever.getFile();
		// pbs = AtlCompiler.compile(input, file);
		// input.close();
		// return ASMRetriever.getASM(file);
		return null;
	}
}
