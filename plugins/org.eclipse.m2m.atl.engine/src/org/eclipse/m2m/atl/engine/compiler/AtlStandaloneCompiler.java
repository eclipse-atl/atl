/*******************************************************************************
 * Copyright (c) 2004, 2014 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Matthias Bohlen - initial API and implementation
 *     Dennis Wagelaar
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.compiler;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.core.IModel;

/**
 * Eclipse-independent interface for ATL compilers.
 * 
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
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
	 *            The Reader to get atl source from.
	 * @param outputFileName
	 *            Name of the file to which the ATL compiled program will be saved.
	 * @return array of compiletime errors (0 length if no errors)
	 */
	CompileTimeError[] compile(Reader in, String outputFileName);
	
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

	/**
	 * Compiles an ATL script and returns easily accessible error messages.
	 * 
	 * @param in
	 *            The Reader to get atl source from.
	 * @param outputFileName
	 *            Name of the file to which the ATL compiled program will be saved.
	 * @return array of compiletime errors as EObjects (0 length if no errors)
	 */
	EObject[] compileWithProblemModel(Reader in, String outputFileName);
	
	/**
	 * Compiles an ATL script and returns easily accessible error messages.
	 * 
	 * @param in
	 *            The InputStream to get atl source from.
	 * @param outputStream
	 *            the compilation ASM output stream
	 * @return array of compiletime errors as EObjects (0 length if no errors)
	 */
	EObject[] compileWithProblemModel(InputStream in, OutputStream outputStream);
	
	/**
	 * Compiles an ATL script and returns easily accessible error messages.
	 * 
	 * @param in
	 *            The Reader to get atl source from.
	 * @param outputStream
	 *            the compilation ASM output stream
	 * @return array of compiletime errors as EObjects (0 length if no errors)
	 */
	EObject[] compileWithProblemModel(Reader in, OutputStream outputStream);
	
	/**
	 * Compiles an ATL script and returns easily accessible error messages.
	 * 
	 * @param atlModel
	 *            The atlModel.
	 * @param outputStream
	 *            the compilation ASM output stream
	 * @return array of compiletime errors as EObjects (0 length if no errors)
	 */
	EObject[] compileWithProblemModel(IModel atlModel, OutputStream outputStream);
	
	/**
	 * Compiles an ATL script and returns easily accessible error messages.
	 * 
	 * @param atlModel
	 *            The atlModel.
	 * @param outputFileName
	 *            Name of the file to which the ATL compiled program will be saved.
	 * @return array of compiletime errors as EObjects (0 length if no errors)
	 */
	EObject[] compileWithProblemModel(IModel atlModel, String outputFileName);
}
