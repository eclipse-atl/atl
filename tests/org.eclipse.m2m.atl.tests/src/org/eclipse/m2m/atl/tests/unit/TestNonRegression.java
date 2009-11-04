/*******************************************************************************
 * Copyright (c) 2007, 2009 Obeo.
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
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.tests.AtlTestPlugin;
import org.eclipse.m2m.atl.tests.util.FileUtils;

/**
 * Launches all non-regression tests.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class TestNonRegression extends TestCase {

	/** The path for usecases. */
	protected static final String INPUT_PATH = "/data/inputs/"; //$NON-NLS-1$

	private Properties properties;

	protected File baseDirectory;

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String name = this.getClass().getName();
		info(name);
		String line = ""; //$NON-NLS-1$
		for (int i = 0; i < name.length(); i++) {
			line += "="; //$NON-NLS-1$
		}
		info(line);
	}

	/**
	 * Compare the expected models (in the expected directories) with the result of the transformation.
	 * 
	 * @throws Exception
	 *             Thrown if an operation has failed or been interrupted.
	 */
	public void testNonRegression() throws Exception {
		File inputDir = null;
		if (CoreService.isEclipseRunning()) {
			this.baseDirectory = FileLocator.getBundleFile(AtlTestPlugin.getDefault().getBundle());
		} else {
			this.baseDirectory = new File(AtlTestPlugin.class.getResource("").toURI()).getParentFile() //$NON-NLS-1$
					.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile();
		}
		inputDir = new File(baseDirectory + INPUT_PATH);
		final File[] directories = FileUtils.listDirectories(inputDir);
		assertNotNull(directories);
		for (int i = 0; i < directories.length; i++) {
			compareSnapshots(directories[i], true);
		}
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
		String[] testsToJump = getTestsToJump(directory);
		if (testsToJump != null) {
			for (int i = 0; i < testsToJump.length; i++) {
				String testToJump = testsToJump[i];
				if (testToJump.equals(directory.getName())) {
					return;
				}
			}
		}
		if (FileUtils.listDirectories(directory).length != 0) {
			for (int i = 0; i < FileUtils.listDirectories(directory).length; i++) {
				compareSnapshots(FileUtils.listDirectories(directory)[i], useEmfCompare);
			}
		} else {
			singleTest(directory);
		}
	}

	/**
	 * Parse a properties file to get the list of the tests to avoid.
	 * 
	 * @param directory
	 *            the current directory
	 * @return the list of the tests which need to be avoided
	 * @throws IOException
	 */
	private String[] getTestsToJump(File directory) throws IOException {
		String[] res = null;
		if (properties == null) {
			return null;
		}
		Set<Object> testsToJump = properties.keySet();
		int i = 0;
		res = new String[testsToJump.size()];
		for (Iterator<Object> iterator = testsToJump.iterator(); iterator.hasNext();) {
			String test = (String)iterator.next();
			res[i] = test.trim();
			i++;
		}
		return res;
	}

	/**
	 * Process specific instructions on a given use case.
	 * 
	 * @param directory
	 *            the use case container
	 */
	protected abstract void singleTest(File directory);

	protected void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * Log a failure message.
	 * 
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 * @param thrown
	 *            the throwable cause
	 */
	public static void fail(String msg, Throwable thrown) {
		System.err.println(msg);
		thrown.printStackTrace();
		fail(msg);
	}

	/**
	 * Log a message.
	 * 
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 */
	public static void info(String msg) {
		System.out.println(msg);
	}

}
