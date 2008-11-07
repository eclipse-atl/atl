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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.compiler.AtlCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompilerNotFoundException;
import org.eclipse.m2m.atl.tests.AtlTestPlugin;
import org.eclipse.m2m.atl.tests.AtlTestsMessages;
import org.eclipse.m2m.atl.tests.TestException;
import org.eclipse.m2m.atl.tests.util.LaunchParser;
import org.eclipse.m2m.atl.tests.util.ModelUtils;
import org.xml.sax.SAXException;

/**
 * Test if the results models are still the same as expected.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public abstract class TestNonRegressionTransfo extends TestNonRegression {

	protected static boolean recompileBeforeLaunch;

	protected static boolean applyCompilation;

	protected LaunchParser launchParser = new LaunchParser();

	private double totalTime;

	private FileWriter results;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		results = new FileWriter("results/" + getVMName() + "_results.xml");
		results.write("<?xml version=\"1.0\"?>\n");
		results.write("<vm>\n");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#singleTest(java.io.File)
	 */
	protected void singleTest(File directory) {
		System.out.print(AtlTestsMessages.getString(
				"TestNonRegressionTransfo.SINGLETEST", new Object[] {directory.getName()})); //$NON-NLS-1$
		final String buildURI = directory + File.separator + directory.getName() + ".launch"; //$NON-NLS-1$

		if (!new File(buildURI).exists()) {
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.3")); //$NON-NLS-1$
		}
		if (launchParser == null) {
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.4")); //$NON-NLS-1$
		}
		try {
			launchParser.parseConfiguration(buildURI);
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.5")); //$NON-NLS-1$
		} catch (SAXException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.5")); //$NON-NLS-1$
		} catch (ParserConfigurationException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.5")); //$NON-NLS-1$
		} 


		if (recompileBeforeLaunch) {
			/*
			 * COMPILER LAUNCH
			 */
			URL atlUrl = launchParser.getAtlUrl();
			String atlFilePath = atlUrl.getFile();
			String outName = "";
			InputStream is = null;

			try {
				if (applyCompilation) {
					outName = atlFilePath.substring(0, atlFilePath.lastIndexOf('.')) + ".asm"; //$NON-NLS-1$
				} else {
					try {
						outName = atlFilePath.substring(0, atlFilePath.lastIndexOf('.')) + ".temp.asm"; //$NON-NLS-1$
						launchParser.setAsmUrl(new URL("file:" + outName));
					} catch (MalformedURLException e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
						fail("URL problem : " + atlUrl); //$NON-NLS-1$
					}
				}

				is = atlUrl.openStream();
			} catch (IOException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				fail("File not found : " + atlUrl); //$NON-NLS-1$
			}
			try {
				AtlCompiler.compile(is, outName);
			} catch (CompilerNotFoundException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				fail("Compiler not found"); //$NON-NLS-1$
			}
			try {
				is.close();
			} catch (IOException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				fail(atlUrl + " compilation failed"); //$NON-NLS-1$
			}
		}

		/*
		 * TRANSFORMATION LAUNCH
		 */
		double executionTime = 0;
		try {
			executionTime = launch();
			results.write("\t<test name=\"" + directory.getName() + "\" directory=\""
					+ directory.toString().substring(AtlTestPlugin.getDefault().getBaseDirectory().length())
					+ "\" time=\"" + executionTime + "\"/>\n");
		} catch (IOException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.6", new Object[] {e})); //$NON-NLS-1$
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
			fail(AtlTestsMessages.getString("TestNonRegressionTransfo.6", new Object[] {e})); //$NON-NLS-1$
		}
		System.out.println(executionTime + "s."); //$NON-NLS-1$
		AtlTestPlugin.getDefault().getResourceSet().getResources().clear();

		/*
		 * RESULTS COMPARISON
		 */

		Map output = launchParser.getOutput();
		// metamodels registration for emf comparison
		for (Iterator iter = output.values().iterator(); iter.hasNext();) {
			String metaid = (String)iter.next();
			String metapath = (String)launchParser.getPath().get(metaid);
			try {
				if (!metapath.startsWith("uri:")) {
					ModelUtils.registerMetamodel(URI.createFileURI(metapath), AtlTestPlugin.getDefault()
							.getResourceSet());
				}
			} catch (IOException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				fail(AtlTestsMessages.getString("TestNonRegressionTransfo.7")); //$NON-NLS-1$
			}
		}

		for (Iterator iter = output.keySet().iterator(); iter.hasNext();) {
			String outputid = (String)iter.next();
			String outputPath = (String)launchParser.getPath().get(outputid);
			String expectedPath = outputPath.replaceFirst("inputs", "expected"); //$NON-NLS-1$ //$NON-NLS-2$
			try {
				ModelUtils.compareModels(new File(outputPath), new File(expectedPath), true, true);
			} catch (IOException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				fail(AtlTestsMessages.getString("TestNonRegressionTransfo.8")); //$NON-NLS-1$
			} catch (InterruptedException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				fail(AtlTestsMessages.getString("TestNonRegressionTransfo.8")); //$NON-NLS-1$
			} catch (TestException e) {
				ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				fail(AtlTestsMessages.getString("TestNonRegressionTransfo.8")); //$NON-NLS-1$
			}
		}
		totalTime += executionTime;
		AtlTestPlugin.getDefault().getResourceSet().getResources().clear();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		System.out.println("total time : " + totalTime + "s.");
		results.write("\t<test name=\"TOTAL\" time=\"" + totalTime + "\"/>\n");
		results.write("</vm>\n");
		results.close();
		super.tearDown();
	}

	/**
	 * Abstract method to launch a transformation.
	 * 
	 * @return the execution time
	 * @throws Exception
	 */
	protected abstract double launch() throws CoreException, IOException;

	/**
	 * Returns the used VM name.
	 * 
	 * @return the used VM name
	 */
	protected abstract String getVMName();
}
