/*******************************************************************************
 * Copyright (c) 2007, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * Provide utilities to get file paths, or compare files.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class FileUtils {

	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private FileUtils() {
		// prevents instantiation
	}

	/**
	 * Reads the content of a file.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the file content
	 * @throws java.io.IOException
	 */
	public static String readFileAsString(File file) throws java.io.IOException {
		byte[] buffer = new byte[(int) file.length()];
		BufferedInputStream f = new BufferedInputStream(new FileInputStream(
				file));
		f.read(buffer);
		f.close();
		return new String(buffer);
	}

	/**
	 * Lists all subdirectories contained within a given folder, with the
	 * exception of directories starting with a "." or directories named "CVS".
	 * 
	 * @param aDirectory
	 *            Directory from which we need to list subfolders.
	 * @return Array composed by all <code>aDirectory</code> subfolders.
	 */
	public static File[] listDirectories(File aDirectory) {
		File[] directories = null;
		if (aDirectory.exists() && aDirectory.isDirectory()) {
			directories = aDirectory.listFiles(new FileFilter() {
				public boolean accept(File file) {
					return file.isDirectory()
							&& !file.getName().startsWith(".") //$NON-NLS-1$
							&& !file.getName().equals("CVS"); //$NON-NLS-1$
				}
			});
			Arrays.sort(directories);
		}
		return directories;
	}

}
