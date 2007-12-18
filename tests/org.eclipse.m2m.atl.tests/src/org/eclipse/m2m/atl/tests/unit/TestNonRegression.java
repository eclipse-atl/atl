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
package org.eclipse.m2m.atl.tests.unit;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.m2m.atl.tests.util.FileUtils;

/**
 * Launches all non-regression tests.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public abstract class TestNonRegression extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		String name = this.getClass().getName();
		System.out.println(this.getClass().getName());
		for (int i = 0; i < name.length(); i++) {
			System.out.print("=");//$NON-NLS-1$
		}
		System.out.println();
	}

	/** The path for usecases */
	protected static final String INPUT_PATH = "/data/inputs";//$NON-NLS-1$
	private String propertiesPath = null;

	/**
	 * Compare the expected models (in the expected directories) with the result
	 * of the transformation.
	 * 
	 * @throws IOException Thrown if an I/O operation has failed or been interrupted.
	 * @throws InterruptedException If one of the threads is interrupted.
	 */
	public void testNonRegression() throws Exception {
		File inputDir = new File(FileUtils.getTestCommonDirectory() + INPUT_PATH);
		final File[] directories = listDirectories(inputDir);
		final Date start = Calendar.getInstance().getTime();
		if (directories != null) {
			for (int i = 0; i < directories.length; i++) {
				compareSnapshots(directories[i], true);
			}
		}
		final Date end = Calendar.getInstance().getTime();
		System.out.println("non-regression evaluated in " //$NON-NLS-1$
				+ (end.getTime() - start.getTime()) / 1000 + "s"); //$NON-NLS-1$
		System.out.println();
	}

	/**
	 * Compares the snapshot of a given folder with its expected folder snapshot.
	 * 
	 * @param directory
	 *            Input directory containing the models.
	 * @throws Exception
	 *             Thrown if an operation has failed or been interrupted.
	 */
	private void compareSnapshots(File directory, boolean useEmfCompare) throws IOException {
		String[] tests_to_jump = getTestsToJump();
		if (tests_to_jump != null) {
			for (int i = 0; i < tests_to_jump.length; i++) {
				String test_to_jump = tests_to_jump[i];
				if (test_to_jump.equals(directory.getName())) {
					//System.out.println("(Avoiding "+directory.getName()+")");
					return;
				}			
			}
		}
		if (listDirectories(directory).length != 0) {
			for (int i = 0; i < listDirectories(directory).length; i++) {
				compareSnapshots(listDirectories(directory)[i], useEmfCompare);
			}
		} else {
			singleTest(directory);
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
	private static File[] listDirectories(File aDirectory) {
		File[] directories = null;

		if (aDirectory.exists() && aDirectory.isDirectory()) {
			directories = aDirectory.listFiles(new FileFilter() {
				public boolean accept(File file) {
					return file.isDirectory() 
					&& !file.getName().startsWith(".") //$NON-NLS-1$
					&& !file.getName().equals("CVS"); //$NON-NLS-1$
				}
			});
		}
		Arrays.sort(directories);
		return directories;
	}

	/**
	 * Parse a properties file to get the list of the tests to avoid.
	 * 
	 * @return the list of the tests which need to be avoided
	 * @throws IOException
	 */
	private String[] getTestsToJump() throws IOException {
		String[] res = null;
		Properties props = new Properties();
		if (propertiesPath == null) return null;
		File propertiesFile = new File(FileUtils.getTestCommonDirectory() + propertiesPath);
		FileInputStream fis = new FileInputStream(propertiesFile);
		props.load(fis);
		Set tests_to_jump = props.keySet();
		int i =0;
		res = new String[tests_to_jump.size()];
		for (Iterator iterator = tests_to_jump.iterator(); iterator.hasNext();) {
			String test = (String) iterator.next();
			res[i] = test.trim();
			i++;
		}
		return res;
	}

	/**
	 * Process specific instructions on a given use case
	 * 
	 * @param directory the use case container
	 */
	protected abstract void singleTest(File directory) ;

	protected void setPropertiesPath(String propertiesPath) {
		this.propertiesPath = propertiesPath;
	}

}

