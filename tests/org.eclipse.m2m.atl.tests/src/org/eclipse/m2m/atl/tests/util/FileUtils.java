/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.m2m.atl.tests.AtlTestsMessages;

/**
 * Provide utilities to get file paths, or compare files.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class FileUtils {

	/**
	 * Compare bytes of two files.
	 * 
	 * @param left
	 * @param right
	 * @throws IOException
	 */
	public static void compareFiles(File left, File right, boolean delete) throws Exception {
		if (left.length() != right.length())
			throw new Exception(AtlTestsMessages.getString("AtlTestPlugin.DIFFFAIL")); //$NON-NLS-1$

		FileInputStream lin = new FileInputStream(left);
		FileInputStream rin = new FileInputStream(right);
		try
		{
			byte[] lbuffer = new byte[4096];
			byte[] rbuffer = new byte[lbuffer.length];
			for (int lcount = 0; (lcount = lin.read(lbuffer)) > 0;)
			{
				int bytesRead = 0;
				for (int rcount = 0; (rcount = rin.read(rbuffer, bytesRead, lcount - bytesRead)) > 0;)
				{
					bytesRead += rcount;
				}
				for (int byteIndex = 0; byteIndex < lcount; byteIndex++)
				{
					if (lbuffer[byteIndex] != rbuffer[byteIndex])
						throw new Exception(AtlTestsMessages.getString("AtlTestPlugin.DIFFFAIL")); //$NON-NLS-1$
				}
			}
		}
		finally
		{
			lin.close();
			rin.close();
		}
		if (delete) {
			left.delete();
		}
	}

	/**
	 * Lists all subdirectories contained within a given folder, with the exception
	 * of directories starting with a "." or directories named "CVS".
	 * 
	 * @param aDirectory
	 * 			Directory from which we need to list subfolders.
	 * @return
	 * 			Array composed by all <code>aDirectory</code> subfolders.
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
