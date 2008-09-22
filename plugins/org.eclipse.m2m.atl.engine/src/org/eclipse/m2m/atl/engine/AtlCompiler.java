/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Matthias Bohlen - refactorings for ease of use and elimination of duplicate code
 *******************************************************************************/
package org.eclipse.m2m.atl.engine;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.ATLPlugin;

/**
 * The ATL compiler.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 */
public class AtlCompiler {

	private static AtlCompiler defaultCompiler;

	private static final int MAX_LINE_LENGTH = 1000;
	
	private static Map compilers = new HashMap();
	
	/**
	 * Returns the default ATL compiler.
	 * 
	 * @return the default ATL compiler
	 */
	public static AtlCompiler getDefault() {
		if (defaultCompiler == null) {
			defaultCompiler = new AtlCompiler();
		}
		return defaultCompiler;
	}

	/**
	 * Performs compilation.
	 * 
	 * @param in The InputStream to get atl source from.
	 * @param out The IFile to which the ATL compiled program will be saved.
	 * @return the problems which occured during compilation
	 */
	public EObject[] compile(InputStream in, IFile out) {
		EObject[] ret = null;
		String atlcompiler = null;
		InputStream newIn = in;
		// The BufferedInputStream is required to reset the stream before actually compiling
		newIn = new BufferedInputStream(newIn, MAX_LINE_LENGTH);
		newIn.mark(MAX_LINE_LENGTH);
		byte[] buffer = new byte[MAX_LINE_LENGTH];
		try {
			int length = newIn.read(buffer);
			// The BufferedReader is used to read the first line
			// (it cannot be used to reset the underlying InputStream required by the compiler below)
			BufferedReader brin = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buffer,
					0, length)));

			String firstLine = brin.readLine();
			atlcompiler = firstLine.replaceFirst(
					"^\\p{Space}*--\\p{Space}*@atlcompiler\\p{Space}+([^\\p{Space}]*)\\p{Space}*$", "$1"); //$NON-NLS-1$ //$NON-NLS-2$
			// if firstLine does not match the pattern then nothing was replaced and atlcompiler = firstLine
			if (atlcompiler.equals(firstLine)) {
				atlcompiler = "atl2004"; //$NON-NLS-1$
			}
		} catch (IOException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		try {
			newIn.reset();
		} catch (IOException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
			// e.printStackTrace();
		}

		ret = getCompiler(atlcompiler).compileWithProblemModel(newIn, out.getLocation().toString());

		try {
			out.refreshLocal(0, null);
		} catch (CoreException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
			// e.printStackTrace();
		}

		return ret;
	}

	/**
	 * Searches for the correct implementation of {@link AtlStandaloneCompiler} which is independent of
	 * Eclipse platform stuff like IFile, IResource, etc.
	 * 
	 * @param compilerName
	 *            name of the compiler to search for
	 * @return the compiler which was found
	 */
	private static AtlStandaloneCompiler getCompiler(String compilerName) {
		AtlStandaloneCompiler ret = (AtlStandaloneCompiler)compilers.get(compilerName);
		if (ret == null) {
			if ("atl2004".equals(compilerName)) { //$NON-NLS-1$
				ret = new Atl2004Compiler();
				compilers.put(compilerName, ret);
			} else {
				IExtensionRegistry registry = Platform.getExtensionRegistry();
				if (registry == null) {
					throw new RuntimeException(AtlEngineMessages.getString("AtlCompiler.EMFREGISTRYNOTFOUND")); //$NON-NLS-1$
				}

				IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.engine.atlcompiler"); //$NON-NLS-1$

				IExtension[] extensions = point.getExtensions();
				extensions: for (int i = 0; i < extensions.length; i++) {
					IConfigurationElement[] elements = extensions[i].getConfigurationElements();
					for (int j = 0; j < elements.length; j++) {
						try {
							if (elements[j].getAttribute("name").equals(compilerName)) { //$NON-NLS-1$
								ret = (AtlStandaloneCompiler)elements[j].createExecutableExtension("class"); //$NON-NLS-1$
								compilers.put(compilerName, ret);
								break extensions;
							}
						} catch (CoreException e) {
							ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
						}
					}
				}
			}

			if (ret == null) {
				throw new CompilerNotFoundException(AtlEngineMessages.getString(
						"AtlCompiler.COMPILERNOTFOUND", new Object[] {compilerName})); //$NON-NLS-1$
			}
		}

		return ret;
	}

	/**
	 * Standalone compilation.
	 * 
	 * @param in
	 *            The InputStream to get atl source from.
	 * @param outputFileName
	 *            The output file name
	 * @return the problems which occured during compilation
	 */
	public EObject[] compile(InputStream in, String outputFileName) {
		EObject[] ret = null;
		String atlcompiler = null;
		InputStream newIn = in;
		// The BufferedInputStream is required to reset the stream before actually compiling
		newIn = new BufferedInputStream(newIn, MAX_LINE_LENGTH);
		newIn.mark(MAX_LINE_LENGTH);
		byte[] buffer = new byte[MAX_LINE_LENGTH];
		try {
			int length = newIn.read(buffer);
			BufferedReader brin = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buffer,
					0, length)));
			String firstLine = brin.readLine();
			atlcompiler = firstLine.replaceFirst(
					"^\\p{Space}*--\\p{Space}*@atlcompiler\\p{Space}+([^\\p{Space}]*)\\p{Space}*$", "$1"); //$NON-NLS-1$ //$NON-NLS-2$
			// if firstLine does not match the pattern then nothing was replaced and atlcompiler = firstLine
			if (atlcompiler.equals(firstLine)) {
				atlcompiler = "atl2004"; //$NON-NLS-1$
			}
		} catch (IOException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		try {
			newIn.reset();
		} catch (IOException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		ret = getCompiler(atlcompiler).compileWithProblemModel(newIn, outputFileName);
		return ret;
	}

}
