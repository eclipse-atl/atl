/*******************************************************************************
 * Copyright (c) 2007 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.suite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo;
import org.eclipse.m2m.atl.tests.unit.atlvm.TestNonRegressionEMFVM;
import org.eclipse.m2m.atl.tests.unit.atlvm.TestNonRegressionVM;
import org.eclipse.m2m.atl.tests.util.FileUtils;

/**
 * Launches all the JUnit tests for ATL.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class AllTests extends TestCase implements IApplication {

	private static Map vmresults = new HashMap();
	private static Map emfvmresults = new HashMap();

	public static void addVMResult(TestNonRegressionTransfo test, File directory, Double time) {
		if (test instanceof TestNonRegressionVM) {
			vmresults.put(directory, time);			
		} else
			if (test instanceof TestNonRegressionEMFVM) {
				emfvmresults.put(directory, time);			
			}
	}

	/**
	 * Launches the test with the given arguments.
	 * 
	 * @param args
	 *            Arguments of the testCase.
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * Creates the {@link junit.framework.TestSuite TestSuite} for all the test.
	 * 
	 * @return The testsuite containing all the tests
	 */
	public static Test suite() {
		final TestSuite suite = new TestSuite("ATL test suite") {
			protected void finalize() throws Throwable {
				outputsResults();
				super.finalize();
			}
		};
		//suite.addTestSuite(TestNonRegressionParser.class);
		suite.addTestSuite(TestNonRegressionEMFVM.class);
		suite.addTestSuite(TestNonRegressionVM.class);
		return suite;
	}

	private static void outputsResults() throws Exception {
		String localPath = FileUtils.getTestCommonDirectory();
		File trace = new File(localPath+"\\trace.txt");

		PrintWriter writer = new PrintWriter(new FileOutputStream(trace));
		
		final String htmlPath = "http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.m2m/org.eclipse.m2m.atl/tests/org.eclipse.m2m.atl.tests";	
		
		for (Iterator iterator = vmresults.keySet().iterator(); iterator.hasNext();) {
			File directory = (File) iterator.next();
			String path = directory.toString();
			path = path.substring(localPath.length());
			path = htmlPath+path.replaceAll("[/\\\\]+", "/")+"/?root=Modeling_Project";

			writer.println("|-");
			writer.println("! colspan=1 | ["+path+" "+directory.getName()+"]");

			if (emfvmresults.get(directory) != null) {
				writer.println("! colspan=1 | <b style=\"color:green\">PASS</b>");
				writer.println("! colspan=1 | "+emfvmresults.get(directory)+"s.");
			} else {

				writer.println("! colspan=1 | <b style=\"color:red\">FAIL</b>");
				writer.println("! colspan=1 | ");
			}
			writer.println("! colspan=1 | "+vmresults.get(directory)+"s.");
			writer.println("! colspan=1 | ");

		}

		writer.close();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		TestRunner.run(suite());
		return Arrays.asList(new String[] {"Please see raw test suite output for details."}); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// implements org.eclipse.equinox.app.IApplication#stop(). No action.
	}

}
