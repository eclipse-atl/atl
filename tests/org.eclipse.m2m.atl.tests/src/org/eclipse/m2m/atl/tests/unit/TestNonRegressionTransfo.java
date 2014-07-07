/*******************************************************************************
 * Copyright (c) 2007, 2012 Obeo.
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.core.service.LauncherService;
import org.eclipse.m2m.atl.engine.compiler.AtlCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompilerNotFoundException;
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

	private double executionTotalTime;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegression#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
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
			info("Launch configuration file " + buildURI + "not found. Skipped."); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		try {
			launchParser.parseConfiguration(baseDirectory, buildURI);
		} catch (IOException e) {
			fail("Error accessing launch configuration " + buildURI, e); //$NON-NLS-1$
		} catch (ParserConfigurationException e) {
			fail("Error configuring launch configuration parser for:" + buildURI, e); //$NON-NLS-1$
		} catch (SAXException e) {
			fail("Error parsing launch configuration " + buildURI, e); //$NON-NLS-1$
		}

		String outName = ""; //$NON-NLS-1$
		if (recompileBeforeLaunch) {
			/*
			 * COMPILER LAUNCH
			 */
			URL atlUrl = launchParser.getAtlUrl();
			String atlFilePath = atlUrl.getFile();
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
					AtlCompiler.compile(new InputStreamReader(is), outName);
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
		} catch (Throwable e) {
			fail(directory.getName() + ": " + e.getMessage(), e); //$NON-NLS-1$
		}
		info(directory.getName() + ": " + executionTime + "s (pure execution: " + pureExecutionTime + "s)"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

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
					ModelUtils.registerMetamodel(URI.createFileURI(metapath));
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
				ModelUtils.assertEquals(new File(outputPath), new File(expectedPath), true);
			} catch (Throwable ex) {
				fail("Model comparison failed for " + directory.getPath() + " : " + ex.getMessage(), ex);
			}
		}
		totalTime += executionTime;
		executionTotalTime += pureExecutionTime;

		if (recompileBeforeLaunch && !applyCompilation) {
			File tempAsm = new File(outName);
			tempAsm.delete();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		info("total time : " + totalTime + "s (pure execution: " + executionTotalTime + "s)"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		super.tearDown();
	}

	/**
	 * Abstract method to launch a transformation.
	 * 
	 * @return pureExecutionTime, i.e. the execution time without loading/saving models
	 */
	protected double launch() throws ATLCoreException, IOException {
		String launcherName = getVMName();

		// Launch configuration analysis
		URL asmURL = launchParser.getAsmUrl();
		Map<String, String> unsortedSourceModels = launchParser.getInput();
		Map<String, String> unsortedTargetModels = launchParser.getOutput();
		Map<String, String> modelPaths = launchParser.getPath();
		Map<String, URL> libs = launchParser.getLibsFromConfig();
		List<URL> superimps = launchParser.getSuperimpose();
		Map<String, Object> options = launchParser.getOptions();

		// WARNING only atl2006 compiler refining mode is supported
		boolean isRefiningTraceMode = false;
		Object refiningOption = options.get(ATLLaunchConstants.IS_REFINING);
		if (refiningOption != null) {
			isRefiningTraceMode = new Boolean(refiningOption.toString());
		}
		options.put("isRefiningTraceMode", new Boolean(isRefiningTraceMode).toString()); //$NON-NLS-1$

		Map<String, String> modelHandlers = launchParser.getModelHandler();
		options.put("modelHandlers", modelHandlers); //$NON-NLS-1$

		// API extensions management
		ILauncher launcher = CoreService.getLauncher(launcherName);
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
		Map<String, InputStream> libraries = new HashMap<String, InputStream>();
		for (Iterator<String> i = libs.keySet().iterator(); i.hasNext();) {
			String libName = i.next();
			libraries.put(libName, libs.get(libName).openStream());
		}

		long startTime = System.currentTimeMillis();

		Map<String, String> sourceModels = unsortedSourceModels;
		List<String> orderedInput = launchParser.getOrderedInput();
		if (!orderedInput.isEmpty()) {
			sourceModels = sort(unsortedSourceModels, orderedInput);
		}

		Map<String, String> targetModels = unsortedTargetModels;
		List<String> orderedOutput = launchParser.getOrderedOutput();
		if (!orderedOutput.isEmpty()) {
			targetModels = sort(unsortedTargetModels, orderedOutput);
		}

		if (isRefiningTraceMode) {

			Iterator<String> sourceIterator = sourceModels.keySet().iterator();
			Iterator<String> targetIterator = targetModels.keySet().iterator();

			Map<String, String> newTargetModels = new HashMap<String, String>();
			newTargetModels.putAll(targetModels);
			List<String> targetToRemove = new ArrayList<String>();

			while (sourceIterator.hasNext()) {
				String sourceModelName = sourceIterator.next();
				String sourceMetamodelName = sourceModels.get(sourceModelName);

				// Lookup for a matching target model (same metamodel)
				while (targetIterator.hasNext()) {
					String targetModelName = targetIterator.next();
					String targetMetamodelName = targetModels.get(targetModelName);

					// Ignore previously used target models
					if (targetMetamodelName.equals(sourceMetamodelName)
							&& !targetToRemove.contains(targetModelName)) {
						String targetModelPath = modelPaths.get(targetModelName);

						// Compute the inout model path (for extraction)
						String refinedModelPathName = LauncherService.getRefinedModelName(sourceModelName);
						modelPaths.put(refinedModelPathName, targetModelPath);
						targetToRemove.add(targetModelName);
						break;
					}
				}
			}

			for (String key : targetToRemove) {
				newTargetModels.remove(key);
			}

			try {
				LauncherService.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), launcher,
						Collections.<String, String> emptyMap(), sourceModels, newTargetModels,
						convertPaths(modelPaths), options, libraries, modules);
			} catch (ATLExecutionException e) {
				fail(asmURL.toString(), e);
			}

		} else {
			try {
				LauncherService.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), launcher, sourceModels,
						Collections.<String, String> emptyMap(), targetModels, convertPaths(modelPaths),
						options, libraries, modules);
			} catch (ATLExecutionException e) {
				fail(asmURL.toString(), e);
			}
		}

		long endTime = System.currentTimeMillis();

		return (endTime - startTime) / 1000.;
	}

	private static Map<String, String> sort(Map<String, String> mapToSort, List<String> orderedKeys) {
		Map<String, String> res = new LinkedHashMap<String, String>();
		for (String key : orderedKeys) {
			res.put(key, mapToSort.get(key));
		}
		return res;
	}

	/**
	 * Returns the used VM name.
	 * 
	 * @return the used VM name
	 */
	protected abstract String getVMName();

	/**
	 * Convert model map paths.
	 * 
	 * @param modelPaths
	 *            the model path map
	 * @return the converted map
	 */
	public static Map<String, String> convertPaths(Map<String, String> modelPaths) {
		Map<String, String> result = new HashMap<String, String>();
		for (Iterator<String> iterator = modelPaths.keySet().iterator(); iterator.hasNext();) {
			String modelName = iterator.next();
			String modelPath = modelPaths.get(modelName);
			result.put(modelName, convertPath(modelPath));
		}
		return result;
	}

	/**
	 * Convert "launch configuration style" paths to EMF uris:
	 * <ul>
	 * <li>ext:<i>path</i> => file:<i>path</i> (file system resource)</li>
	 * <li>uri:<i>uri</i> => <i>uri</i> (EMF uri)</li>
	 * <li><i>path</i> => platform:/resource/<i>path</i> (workspace resource)</li>
	 * </ul>
	 * Unchanged paths:
	 * <ul>
	 * <li>platform:/plugin/<i>path</i> (plugin resource)</li>
	 * <li>pathmap:<i>path</i> (pathmap resource, e.g. UML2 profile)</li>
	 * </ul>
	 * 
	 * @param path
	 *            the path as created by the launchConfiguration
	 * @return the converted path
	 */
	public static String convertPath(String path) {
		if (path.startsWith("ext:")) { //$NON-NLS-1$
			return path.replaceFirst("ext:", "file:/"); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (path.startsWith("uri:")) { //$NON-NLS-1$
			return path.substring(4);
		} else if (path.startsWith("#") || path.startsWith("platform:") || path.startsWith("pathmap")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return path;
		}
		return "platform:/resource" + path; //$NON-NLS-1$
	}
}
