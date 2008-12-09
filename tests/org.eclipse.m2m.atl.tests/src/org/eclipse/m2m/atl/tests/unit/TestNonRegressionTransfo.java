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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.core.service.LauncherService;
import org.eclipse.m2m.atl.engine.compiler.AtlCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompilerNotFoundException;
import org.eclipse.m2m.atl.tests.AtlTestPlugin;
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
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		results = new FileWriter("results/" + getVMName() + "_results.xml"); //$NON-NLS-1$ //$NON-NLS-2$
		results.write("<?xml version=\"1.0\"?>\n"); //$NON-NLS-1$
		results.write("<vm>\n"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#singleTest(java.io.File)
	 */
	@Override
	protected void singleTest(File directory) {
		final String buildURI = directory + File.separator + directory.getName() + ".launch"; //$NON-NLS-1$

		if (!new File(buildURI).exists()) {
			fail("Launch configuration file " + buildURI + "not found"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		try {
			launchParser.parseConfiguration(buildURI);
		} catch (IOException e) {
			fail("Error accessing launch configuration " + buildURI, e); //$NON-NLS-1$
		} catch (ParserConfigurationException e) {
			fail("Error configuring launch configuration parser for:" + buildURI, e); //$NON-NLS-1$
		} catch (SAXException e) {
			fail("Error parsing launch configuration " + buildURI, e); //$NON-NLS-1$
		}

		if (recompileBeforeLaunch) {
			/*
			 * COMPILER LAUNCH
			 */
			URL atlUrl = launchParser.getAtlUrl();
			String atlFilePath = atlUrl.getFile();
			String outName = ""; //$NON-NLS-1$
			InputStream is = null;

			try {
				if (applyCompilation) {
					outName = atlFilePath.substring(0, atlFilePath.lastIndexOf('.')) + ".asm"; //$NON-NLS-1$
				} else {
					try {
						outName = atlFilePath.substring(0, atlFilePath.lastIndexOf('.')) + ".temp.asm"; //$NON-NLS-1$
						launchParser.setAsmUrl(new URL("file:" + outName)); //$NON-NLS-1$
					} catch (MalformedURLException e) {
						fail("URL problem: " + atlUrl, e); //$NON-NLS-1$
					}
				}

				is = atlUrl.openStream();
				try {
					AtlCompiler.compile(is, outName);
				} catch (CompilerNotFoundException e) {
					fail("Compiler not found", e); //$NON-NLS-1$
				}
				try {
					is.close();
				} catch (IOException e) {
					fail(atlUrl + " compilation failed", e); //$NON-NLS-1$
				}
			} catch (IOException e) {
				fail("File not found: " + atlUrl, e); //$NON-NLS-1$
			}

		}

		/*
		 * TRANSFORMATION LAUNCH
		 */
		double executionTime = 0;
		double pureExecutionTime = 0;
		try {
			long startTime = System.currentTimeMillis();
			pureExecutionTime = launch();
			long endTime = System.currentTimeMillis();
			executionTime = (endTime - startTime) / 1000.;
			results.write("\t<test name=\"" + directory.getName() + "\" directory=\"" //$NON-NLS-1$ //$NON-NLS-2$
					+ directory.toString().substring(AtlTestPlugin.getDefault().getBaseDirectory().length())
					+ "\" time=\"" + executionTime + "\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (IOException e) {
			fail("Error writing results for: " + directory.getName(), e); //$NON-NLS-1$
		} catch (CoreException e) {
			fail(directory.getName() + ": " + e.getMessage(), e); //$NON-NLS-1$
		}
		info(directory.getName() + ": " + executionTime + "s (pure execution: " + pureExecutionTime + "s)"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		AtlTestPlugin.getDefault().getResourceSet().getResources().clear();

		/*
		 * RESULTS COMPARISON
		 */

		Map<String, String> output = launchParser.getOutput();
		// metamodels registration for emf comparison
		for (Iterator<String> iter = output.values().iterator(); iter.hasNext();) {
			String metaid = iter.next();
			String metapath = launchParser.getPath().get(metaid);
			try {
				if (!metapath.startsWith("uri:")) { //$NON-NLS-1$
					if (metapath.startsWith("ext:")) { //$NON-NLS-1$
						metapath = metapath.substring(4);
					}
					ModelUtils.registerMetamodel(URI.createFileURI(metapath), AtlTestPlugin.getDefault()
							.getResourceSet());
				}
			} catch (IOException ex) {
				fail("Unable to register output metamodel " + metaid + " for comparison: " + ex); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		for (Iterator<String> iter = output.keySet().iterator(); iter.hasNext();) {
			String outputid = iter.next();
			String outputPath = launchParser.getPath().get(outputid);
			if (outputPath.startsWith("ext:")) { //$NON-NLS-1$
				outputPath = outputPath.substring(4);
			}
			String expectedPath = outputPath.replaceFirst("inputs", "expected"); //$NON-NLS-1$ //$NON-NLS-2$
			try {
				ModelUtils.compareModels(new File(outputPath), new File(expectedPath), true, true);
			} catch (IOException ex) {
				fail(ex.getMessage());
			} catch (InterruptedException ex) {
				fail(ex.getMessage());
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
	@Override
	protected void tearDown() throws Exception {
		info("total time : " + totalTime + "s"); //$NON-NLS-1$ //$NON-NLS-2$
		results.write("\t<test name=\"TOTAL\" time=\"" + totalTime + "\"/>\n"); //$NON-NLS-1$ //$NON-NLS-2$
		results.write("</vm>\n"); //$NON-NLS-1$
		results.close();
		super.tearDown();
	}

	/**
	 * Abstract method to launch a transformation.
	 * 
	 * @return pureExecutionTime, i.e. the execution time without loading/saving models
	 * @throws Exception
	 */
	protected double launch() throws CoreException, IOException {
		String launcherName = getVMName();

		// Launch configuration analysis
		URL asmURL = launchParser.getAsmUrl();
		Map<String, String> sourceModels = launchParser.getInput();
		Map<String, String> targetModels = launchParser.getOutput();
		Map<String, String> modelPaths = launchParser.getPath();
		Map<String, URL> libs = launchParser.getLibsFromConfig();
		List<URL> superimps = launchParser.getSuperimpose();
		Map<String, Object> options = launchParser.getOptions();

		Map<String, String> modelHandlers = launchParser.getModelHandler();
		options.put("modelHandlers", modelHandlers); //$NON-NLS-1$

		// API extensions management
		ILauncher launcher = CoreService.getLauncher(launcherName);
		Map<String, ModelFactory> modelFactories = new HashMap<String, ModelFactory>();
		Map<String, IExtractor> extractors = new HashMap<String, IExtractor>();
		Map<String, IInjector> injectors = new HashMap<String, IInjector>();

		ModelFactory modelfactory = launcher.getDefaultModelFactory();
		IInjector injector = modelfactory.getDefaultInjector();
		IExtractor extractor = modelfactory.getDefaultExtractor();

		for (Iterator<String> iterator = modelPaths.keySet().iterator(); iterator.hasNext();) {
			String modelName = iterator.next();
			modelFactories.put(modelName, modelfactory);
			extractors.put(modelName, extractor);
			injectors.put(modelName, injector);
		}

		InputStream asmInputStream = asmURL.openStream();
		InputStream[] modules = new InputStream[superimps.size() + 1];
		modules[0] = asmInputStream;
		for (int i = 1; i < modules.length; i++) {
			URL url = superimps.get(i - 1);
			try {
				modules[i] = url.openStream();
			} catch (IOException e) {
				fail(e.getLocalizedMessage());
			}
		}

		// Libraries
		Map<String, Object> libraries = new HashMap<String, Object>();
		for (Iterator<String> i = libs.keySet().iterator(); i.hasNext();) {
			String libName = i.next();
			libraries.put(libName, libs.get(libName).openStream());
		}
		long startTime = System.currentTimeMillis();
		LauncherService.launch(ILauncher.RUN_MODE, launcher, modelFactories, extractors, injectors,
				sourceModels, Collections.<String, String> emptyMap(), targetModels, modelPaths, options,
				libraries, (Object[])modules);

		long endTime = System.currentTimeMillis();

		return (endTime - startTime) / 1000.;
	}

	/**
	 * Returns the used VM name.
	 * 
	 * @return the used VM name
	 */
	protected abstract String getVMName();
}
