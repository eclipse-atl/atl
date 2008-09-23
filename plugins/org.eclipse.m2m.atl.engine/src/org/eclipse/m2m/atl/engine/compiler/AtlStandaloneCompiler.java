/*******************************************************************************
 * Copyright (c) 2004 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthias Bohlen - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.compiler;

import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;

/**
 * Eclipse-independent interface for ATL compilers.
 * 
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 */
public interface AtlStandaloneCompiler {
	/**
	 * Compiles an ATL script and returns easily accessible error messages.
	 * 
	 * @param in
	 *            The InputStream to get atl source from.
	 * @param outputFileName
	 *            Name of the file to which the ATL compiled program will be saved.
	 * @return array of compiletime errors (0 length if no errors)
	 */
	CompileTimeError[] compile(InputStream in, String outputFileName);

	/**
	 * Compiles an ATL script and returns easily accessible error messages.
	 * 
	 * @param in
	 *            The InputStream to get atl source from.
	 * @param outputFileName
	 *            Name of the file to which the ATL compiled program will be saved.
	 * @return array of compiletime errors as EObjects (0 length if no errors)
	 */
	EObject[] compileWithProblemModel(InputStream in, String outputFileName);
}
