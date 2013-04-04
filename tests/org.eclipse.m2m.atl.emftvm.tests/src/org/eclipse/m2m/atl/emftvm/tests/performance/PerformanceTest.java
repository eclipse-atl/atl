/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.performance;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * EMFTVM performance test suite.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class PerformanceTest extends EMFTVMTest {

	public static final int TEST_COUNT = 1000;

	private static final Logger LOG = Logger.getLogger(PerformanceTest.class.getName());

	/**
	 * Tests EMFTVM performance of <code>EcoreCopy.atl</code>.
	 * 
	 * @throws IOException
	 */
	public void testEMFTVM_EcoreCopy() throws IOException {
		final SortedSet<Long> timings = new TreeSet<Long>();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ModuleResolver mr = new DefaultModuleResolver(PLUGIN_URI + "/test-data/EcoreCopy/", new ResourceSetImpl());
		env.loadModule(mr, "EcoreCopy");

		for (int i = 0; i < TEST_COUNT; i++) {
			final TimingData td = new TimingData();
			final ResourceSet rs = new ResourceSetImpl();
			final Model in = EmftvmFactory.eINSTANCE.createModel();
			in.setResource(rs.getResource(URI.createPlatformPluginURI(EMFTVM_PLUGIN_ID + "/model/emftvm.ecore", true), true));
			final Model out = EmftvmFactory.eINSTANCE.createModel();
			out.setResource(rs.createResource(URI.createURI("out.ecore")));

			env.registerInputModel("IN", in);
			env.registerOutputModel("OUT", out);
			td.finishLoading();
			env.run(td);
			td.finish();
			LOG.fine(String.format("PerformanceTest#testEMFTVM_EcoreCopy test %d %s", i, td));
			timings.add(td.getFinished());

			final Runtime runtime = Runtime.getRuntime();
			LOG.fine(String.format("PerformanceTest#testEMFTVM_EcoreCopy Heap space used for test %d: %d MB", i,
					(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
		}

		processTimings("PerformanceTest#testEMFTVM_EcoreCopy", timings, 1);
	}

	/**
	 * Tests EMFVM performance of <code>EcoreCopyASM.atl</code>.
	 * 
	 * @throws ATLCoreException
	 * @throws IOException
	 */
	public void testEMFVM_EcoreCopy() throws ATLCoreException, IOException {
		final SortedSet<Long> timings = new TreeSet<Long>();
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put("allowInterModelReferences", true);

		for (int i = 0; i < TEST_COUNT; i++) {
			final TimingData td = new TimingData();
			final ILauncher launcher = CoreService.getLauncher("EMF-specific VM");
			launcher.initialize(Collections.<String, Object> emptyMap());
			final ModelFactory mf = CoreService.getModelFactory(launcher.getDefaultModelFactoryName());
			final IReferenceModel ecore = mf.getMetametamodel();
			final IInjector injector = CoreService.getInjector(mf.getDefaultInjectorName());
			final IModel in = mf.newModel(ecore);
			injector.inject(in, EMFTVM_PLUGIN_URI + "/model/emftvm.ecore");
			final IModel out = mf.newModel(ecore);
			out.setIsTarget(true);

			launcher.addInModel(ecore, "ECORE", "ECORE");
			launcher.addInModel(in, "IN", "ECORE");
			launcher.addOutModel(out, "OUT", "ECORE");
			final InputStream is = bundle.getResource("/test-data/EcoreCopy/EcoreCopyASM.asm").openStream();
			try {
				final Object module = launcher.loadModule(is);
				td.finishLoading();
				launcher.launch(ILauncher.RUN_MODE, null, options, module);
			} finally {
				is.close();
			}
			td.finish();
			LOG.fine(String.format("PerformanceTest#testEMFVM_EcoreCopy test %d %s", i, td));
			timings.add(td.getFinished());

			final Runtime runtime = Runtime.getRuntime();
			LOG.fine(String.format("PerformanceTest#testEMFVM_EcoreCopy Heap space used for test %d: %d MB", i,
					(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
		}

		processTimings("PerformanceTest#testEMFVM_EcoreCopy", timings, 1);
	}

	/**
	 * Tests Regular VM performance of <code>EcoreCopyASM.atl</code>.
	 * 
	 * @throws ATLCoreException
	 * @throws IOException
	 */
	public void testRegularVM_EcoreCopy() throws ATLCoreException, IOException {
		final SortedSet<Long> timings = new TreeSet<Long>();
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put("allowInterModelReferences", true);
		final Map<String, Object> inOptions = new HashMap<String, Object>();
		inOptions.put("modelName", "IN");
		inOptions.put("path", EMFTVM_PLUGIN_URI + "/model/emftvm.ecore");
		inOptions.put("newModel", "false");
		final Map<String, Object> outOptions = new HashMap<String, Object>();
		outOptions.put("modelName", "OUT");
		outOptions.put("path", "out.ecore");
		outOptions.put("newModel", "true");

		final Level logLevel = ATLLogger.getLogger().getLevel();
		ATLLogger.getLogger().setLevel(Level.SEVERE);

		for (int i = 0; i < TEST_COUNT; i++) {
			final TimingData td = new TimingData();
			final ILauncher launcher = CoreService.getLauncher("Regular VM");
			launcher.initialize(Collections.<String, Object> emptyMap());
			final ModelFactory mf = CoreService.getModelFactory(launcher.getDefaultModelFactoryName());
			final IReferenceModel ecore = mf.getMetametamodel();
			final IInjector injector = CoreService.getInjector(mf.getDefaultInjectorName());
			final IModel in = mf.newModel(ecore, inOptions);
			injector.inject(in, EMFTVM_PLUGIN_URI + "/model/emftvm.ecore");
			final IModel out = mf.newModel(ecore, outOptions);
			out.setIsTarget(true);

			launcher.addInModel(ecore, "ECORE", "ECORE");
			launcher.addInModel(in, "IN", "ECORE");
			launcher.addOutModel(out, "OUT", "ECORE");
			final InputStream is = bundle.getResource("/test-data/EcoreCopy/EcoreCopyASM.asm").openStream();
			try {
				final Object module = launcher.loadModule(is);
				td.finishLoading();
				launcher.launch(ILauncher.RUN_MODE, null, options, module);
			} finally {
				is.close();
			}
			td.finish();
			LOG.fine(String.format("PerformanceTest#testRegularVM_EcoreCopy test %d %s", i, td));
			timings.add(td.getFinished());

			final Runtime runtime = Runtime.getRuntime();
			LOG.fine(String.format("PerformanceTest#testRegularVM_EcoreCopy Heap space used for test %d: %d MB", i,
					(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
		}

		ATLLogger.getLogger().setLevel(logLevel);
		processTimings("PerformanceTest#testRegularVM_EcoreCopy", timings, 1);
	}

	/**
	 * Tests {@link EcoreUtil} {@link Copier} performance.
	 */
	public void testEcoreUtil_EcoreCopy() {
		final SortedSet<Long> timings = new TreeSet<Long>();

		for (int i = 0; i < TEST_COUNT; i++) {
			final TimingData td = new TimingData();
			final ResourceSet rs = new ResourceSetImpl();
			final Resource in = rs.getResource(URI.createPlatformPluginURI(EMFTVM_PLUGIN_ID + "/model/emftvm.ecore", true), true);
			final Resource out = rs.createResource(URI.createURI("out.ecore"));
			td.finishLoading();

			final Copier copier = new Copier();
			final Collection<EObject> copies = copier.copyAll(in.getContents());
			copier.copyReferences();
			out.getContents().addAll(copies);
			td.finish();
			LOG.fine(String.format("PerformanceTest#testEcoreUtil_EcoreCopy test %d %s", i, td));
			timings.add(td.getFinished());

			final Runtime runtime = Runtime.getRuntime();
			LOG.fine(String.format("PerformanceTest#testEcoreUtil_EcoreCopy Heap space used for test %d: %d MB", i,
					(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
		}

		processTimings("PerformanceTest#testEcoreUtil_EcoreCopy", timings, 1);
	}

}
