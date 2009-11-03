/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL extractor
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.util;

import java.io.File;
import java.io.FileInputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * Init parser data.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class InitParserData {

	protected static boolean update;

	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private InitParserData() {
		// prevents instantiation
	}

	/**
	 * PARSER TEST INITIALIZER creates all missing atl.ecore files into the expected directory.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		File expDir = new File("data/expected"); //$NON-NLS-1$
		final File[] directories = FileUtils.listDirectories(expDir);
		try {
			if (directories != null) {
				for (int i = 0; i < directories.length; i++) {
					initSnapshots(directories[i]);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void initSnapshots(File directory) throws Exception {
		if (FileUtils.listDirectories(directory).length != 0) {
			for (int i = 0; i < FileUtils.listDirectories(directory).length; i++) {
				initSnapshots(FileUtils.listDirectories(directory)[i]);
			}
		} else {
			initTest(directory);
		}
	}

	private static void initTest(File directory) throws Exception {
		final String transfoPath = directory.toString().replaceAll("expected", "inputs") + "/" + directory.getName() + ".atl"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		final String xmiTransfoPath = directory.toString() + "/" + directory.getName() + ".atl.xmi"; //$NON-NLS-1$ //$NON-NLS-2$
		if (new File(xmiTransfoPath).exists() && !update) {
			return;
		}
		EObject result = AtlParser.getDefault().parse(new FileInputStream(transfoPath));
		ModelUtils.save(result, xmiTransfoPath);
		System.out.println(transfoPath + " extracted.\n"); //$NON-NLS-1$
	}
}
