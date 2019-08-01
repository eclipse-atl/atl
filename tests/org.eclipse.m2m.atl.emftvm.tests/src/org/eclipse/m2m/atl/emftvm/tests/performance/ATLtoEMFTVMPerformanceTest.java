/*******************************************************************************
 * Copyright (c) 2014 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.performance;

import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * EMFTVM performance test suite for <code>EcoreCopy.atl</code>.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class ATLtoEMFTVMPerformanceTest extends PerformanceTest {

	private static final int TEST_COUNT = 50;

	/**
	 * Tests EMFTVM performance of <code>ATLtoEMFTVM.atl</code>.
	 * 
	 * @throws IOException
	 */
	public void testEMFTVM_ATLtoEMFTVM() throws IOException {
		runTestEMFTVM_ATLtoEMFTVM("ATLtoEMFTVMPerformanceTest#testEMFTVM_ATLtoEMFTVM", false);
	}

	/**
	 * Tests EMFTVM performance of <code>ATLtoEMFTVM.atl</code> without JIT.
	 * 
	 * @throws IOException
	 */
	public void testEMFTVM_NoJIT_ATLtoEMFTVM() throws IOException {
		runTestEMFTVM_ATLtoEMFTVM("ATLtoEMFTVMPerformanceTest#testEMFTVM_NoJIT_ATLtoEMFTVM", true);
	}

	/**
	 * Runs the EMFTVM performance test of <code>ATLtoEMFTVM.atl</code>.
	 * 
	 * @throws IOException
	 */
	protected void runTestEMFTVM_ATLtoEMFTVM(final String prefix, final boolean jitDisabled) throws IOException {
		final Metamodel atlmm = EmftvmFactory.eINSTANCE.createMetamodel();
		atlmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getAtlMetamodel()).getResource());
		final Metamodel pbmm = EmftvmFactory.eINSTANCE.createMetamodel();
		pbmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getProblemMetamodel()).getResource());

		final ExecEnvPool pool = new ExecEnvPool();
		pool.setModuleResolverFactory(new DefaultModuleResolverFactory(COMPILER_PLUGIN_URI + "/transformations/"));
		pool.registerMetaModel("ATL", atlmm);
		pool.registerMetaModel("Problem", pbmm);
		pool.loadModule("ATLtoEMFTVM");

		// JIT warmup
		for (int i = 0; i < TEST_COUNT / 10; i++) {
			final ResourceSet rs = new ResourceSetImpl();
			final Model in = EmftvmFactory.eINSTANCE.createModel();
			in.setResource(rs.getResource(URI.createPlatformPluginURI(COMPILER_PLUGIN_ID + "/transformations/ATLtoEMFTVM.atl", true), true));
			final Model out = EmftvmFactory.eINSTANCE.createModel();
			out.setResource(rs.createResource(URI.createURI("ATLtoEMFTVM.emftvm")));
			final Model pbsModel = EmftvmFactory.eINSTANCE.createModel();
			pbsModel.setResource(rs.createResource(URI.createFileURI("pbs.xmi")));

			final ExecEnv env = pool.getExecEnv();
			env.setJitDisabled(jitDisabled);
			env.registerInputModel("IN", in);
			env.registerOutputModel("OUT", out);
			env.registerOutputModel("PBS", pbsModel);
			env.run(null);
			pool.returnExecEnv(env);
		}

		final SortedSet<Long> timings = new TreeSet<Long>();
		final SortedSet<Long> pureTimings = new TreeSet<Long>();

		for (int i = 0; i < TEST_COUNT; i++) {
			final TimingData td = new TimingData();
			final ResourceSet rs = new ResourceSetImpl();
			final Model in = EmftvmFactory.eINSTANCE.createModel();
			in.setResource(rs.getResource(URI.createPlatformPluginURI(COMPILER_PLUGIN_ID + "/transformations/ATLtoEMFTVM.atl", true), true));
			final Model out = EmftvmFactory.eINSTANCE.createModel();
			out.setResource(rs.createResource(URI.createURI("ATLtoEMFTVM.emftvm")));
			final Model pbsModel = EmftvmFactory.eINSTANCE.createModel();
			pbsModel.setResource(rs.createResource(URI.createFileURI("pbs.xmi")));

			final ExecEnv env = pool.getExecEnv();
			env.setJitDisabled(jitDisabled);
			env.registerInputModel("IN", in);
			env.registerOutputModel("OUT", out);
			env.registerOutputModel("PBS", pbsModel);
			td.finishLoading();
			env.run(td);
			pool.returnExecEnv(env);
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
