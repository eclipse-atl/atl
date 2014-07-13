/*******************************************************************************
 * Copyright (c) 2013-2014 Dennis Wagelaar.
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
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * EMFTVM performance test suite for <code>EcoreCopy.atl</code>.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class EcoreCopyPerformanceTest extends PerformanceTest {

	private static final int TEST_COUNT = 500;
	
	/**
	 * Tests EMFTVM performance of <code>EcoreCopy.atl</code>.
	 * 
	 * @throws IOException
	 */
	public void testEMFTVM_EcoreCopy() throws IOException {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		runTestEMFTVM_EcoreCopy(env, "EcoreCopyPerformanceTest#testEMFTVM_EcoreCopy");
	}

	/**
	 * Tests EMFTVM performance of <code>EcoreCopy.atl</code> without JIT.
	 * 
	 * @throws IOException
	 */
	public void testEMFTVM_NoJIT_EcoreCopy() throws IOException {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.setJitDisabled(true);
		runTestEMFTVM_EcoreCopy(env, "EcoreCopyPerformanceTest#testEMFTVM_NoJIT_EcoreCopy");
	}

	/**
	 * Runs the EMFTVM performance test of <code>EcoreCopy.atl</code>.
	 * 
	 * @throws IOException
	 */
	protected void runTestEMFTVM_EcoreCopy(final ExecEnv env, final String prefix) throws IOException {
		final ModuleResolver mr = new DefaultModuleResolver(PLUGIN_URI + "/test-data/EcoreCopy/", new ResourceSetImpl());
		env.loadModule(mr, "EcoreCopy");

		// JIT warmup
		for (int i = 0; i < TEST_COUNT / 10; i++) {
			final ResourceSet rs = new ResourceSetImpl();
			final Model in = EmftvmFactory.eINSTANCE.createModel();
			in.setResource(rs.getResource(URI.createPlatformPluginURI(EMFTVM_PLUGIN_ID + "/model/emftvm.ecore", true), true));
			final Model out = EmftvmFactory.eINSTANCE.createModel();
			out.setResource(rs.createResource(URI.createURI("out.ecore")));

			env.registerInputModel("IN", in);
			env.registerOutputModel("OUT", out);
			env.run(null);
		}

		final SortedSet<Long> timings = new TreeSet<Long>();
		final SortedSet<Long> pureTimings = new TreeSet<Long>();

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
			LOG.fine(String.format("%s test %d %s", prefix, i, td));
			timings.add(td.getFinished());
			pureTimings.add(td.getFinished() - td.getFinishedLoading());

			final Runtime runtime = Runtime.getRuntime();
			LOG.fine(String.format("%s Heap space used for test %d: %d MB", prefix, i,
					(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
		}

		processTimings(prefix, timings, pureTimings, 1);
	}

	/**
	 * Tests EMFVM performance of <code>EcoreCopyASM.atl</code>.
	 * 
	 * @throws ATLCoreException
	 * @throws IOException
	 */
	public void testEMFVM_EcoreCopy() throws ATLCoreException, IOException {
		runTestATLVM_EcoreCopy("EMF-specific VM", "EcoreCopyPerformanceTest#testEMFVM_EcoreCopy");
	}

	/**
	 * Tests Regular VM performance of <code>EcoreCopyASM.atl</code>.
	 * 
	 * @throws ATLCoreException
	 * @throws IOException
	 */
	public void testRegularVM_EcoreCopy() throws ATLCoreException, IOException {
		runTestATLVM_EcoreCopy("Regular VM", "EcoreCopyPerformanceTest#testRegularVM_EcoreCopy");
	}

	/**
	 * Tests Regular VM performance of <code>EcoreCopyASM.atl</code>.
	 * 
	 * @throws ATLCoreException
	 * @throws IOException
	 */
	protected void runTestATLVM_EcoreCopy(final String vmName, final String prefix) throws ATLCoreException, IOException {
		final Level logLevel = ATLLogger.getLogger().getLevel();
		ATLLogger.getLogger().setLevel(Level.SEVERE);

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

		// JIT warmup
		for (int i = 0; i < TEST_COUNT / 10; i++) {
			final ILauncher launcher = CoreService.getLauncher(vmName);
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
				launcher.launch(ILauncher.RUN_MODE, null, options, module);
			} finally {
				is.close();
			}
		}

		final SortedSet<Long> timings = new TreeSet<Long>();
		final SortedSet<Long> pureTimings = new TreeSet<Long>();

		for (int i = 0; i < TEST_COUNT; i++) {
			final TimingData td = new TimingData();
			final ILauncher launcher = CoreService.getLauncher(vmName);
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
			LOG.fine(String.format("%s test %d %s", prefix, i, td));
			timings.add(td.getFinished());
			pureTimings.add(td.getFinished() - td.getFinishedLoading());

			final Runtime runtime = Runtime.getRuntime();
			LOG.fine(String.format("%s Heap space used for test %d: %d MB", prefix, i,
					(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
		}

		ATLLogger.getLogger().setLevel(logLevel);
		processTimings(prefix, timings, pureTimings, 1);
	}

	/**
	 * Tests {@link EcoreUtil} {@link Copier} performance.
	 */
	public void testEcoreUtil_EcoreCopy() {
		final String prefix = "EcoreCopyPerformanceTest#testEcoreUtil_EcoreCopy";

		// JIT warmup
		for (int i = 0; i < TEST_COUNT / 10; i++) {
			final ResourceSet rs = new ResourceSetImpl();
			final Resource in = rs.getResource(URI.createPlatformPluginURI(EMFTVM_PLUGIN_ID + "/model/emftvm.ecore", true), true);
			final Resource out = rs.createResource(URI.createURI("out.ecore"));

			final Copier copier = new Copier();
			final Collection<EObject> copies = copier.copyAll(in.getContents());
			copier.copyReferences();
			out.getContents().addAll(copies);
		}

		final SortedSet<Long> timings = new TreeSet<Long>();
		final SortedSet<Long> pureTimings = new TreeSet<Long>();

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
			LOG.fine(String.format("%s test %d %s", prefix, i, td));
			timings.add(td.getFinished());
			pureTimings.add(td.getFinished() - td.getFinishedLoading());

			final Runtime runtime = Runtime.getRuntime();
			LOG.fine(String.format("%s Heap space used for test %d: %d MB", prefix, i,
					(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
		}

		processTimings(prefix, timings, pureTimings, 1);
	}

}
