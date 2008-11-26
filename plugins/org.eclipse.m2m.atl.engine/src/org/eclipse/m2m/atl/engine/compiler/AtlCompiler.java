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
package org.eclipse.m2m.atl.engine.compiler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.Messages;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL compiler.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 */
public final class AtlCompiler {

	/** The default ATL compiler. */
	public static final String DEFAULT_COMPILER_NAME = "atl2006";

	private static final int MAX_LINE_LENGTH = 1000;

	private static Map compilers = new HashMap();

	private AtlCompiler() {
		super();
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
			if ("atl2006".equals(compilerName)) { //$NON-NLS-1$
				ret = new Atl2006Compiler();
				compilers.put(compilerName, ret);
			} else if ("atl2004".equals(compilerName)) { //$NON-NLS-1$
				ret = new Atl2004Compiler();
				compilers.put(compilerName, ret);
			} else {
				if (Platform.isRunning()) {
					IExtensionRegistry registry = Platform.getExtensionRegistry();
					if (registry == null) {
						ATLLogger.log(Level.SEVERE, Messages.getString("AtlCompiler.REGISTRYNOTFOUND"), null); //$NON-NLS-1$
						return null;
					}
					IExtensionPoint point = registry
							.getExtensionPoint("org.eclipse.m2m.atl.engine.atlcompiler"); //$NON-NLS-1$

					IExtension[] extensions = point.getExtensions();
					extensions: for (int i = 0; i < extensions.length; i++) {
						IConfigurationElement[] elements = extensions[i].getConfigurationElements();
						for (int j = 0; j < elements.length; j++) {
							try {
								if (elements[j].getAttribute("name").equals(compilerName)) { //$NON-NLS-1$
									ret = (AtlStandaloneCompiler)elements[j]
											.createExecutableExtension("class"); //$NON-NLS-1$
									compilers.put(compilerName, ret);
									break extensions;
								}
							} catch (CoreException e) {
								ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
							}
						}
					}
				}
			}

			if (ret == null) {
				throw new CompilerNotFoundException(Messages.getString(
						"AtlCompiler.COMPILERNOTFOUND", new Object[] {compilerName})); //$NON-NLS-1$
			}
		}

		return ret;
	}

	/**
	 * Performs compilation.
	 * 
	 * @param in
	 *            The InputStream to get atl source from.
	 * @param out
	 *            The IFile to which the ATL compiled program will be saved.
	 * @return the problems which occured during compilation
	 */
	public static EObject[] compile(InputStream in, IFile out) {
		EObject[] ret = compile(in, out.getLocation().toString());
		try {
			out.refreshLocal(0, null);
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
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
	 * @return the problems which occurred during compilation
	 */
	public static EObject[] compile(InputStream in, String outputFileName) {
		EObject[] ret = null;
		String atlcompiler = null;
		InputStream newIn = in;
		try {
			// The BufferedInputStream is required to reset the stream before actually compiling
			newIn = new BufferedInputStream(newIn, MAX_LINE_LENGTH);
			newIn.mark(MAX_LINE_LENGTH);
			byte[] buffer = new byte[MAX_LINE_LENGTH];
			newIn.read(buffer);
			atlcompiler = AtlSourceManager.getCompilerName(AtlSourceManager.getTaggedInformations(buffer, AtlSourceManager.COMPILER_TAG));
			newIn.reset();
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		ret = getCompiler(atlcompiler).compileWithProblemModel(newIn, outputFileName);
		return ret;
	}

}
