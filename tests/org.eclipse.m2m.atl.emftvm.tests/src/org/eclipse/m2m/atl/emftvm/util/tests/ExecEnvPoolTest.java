/*******************************************************************************
 * Copyright (c) 2013, 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util.tests;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.ExecEnvPool;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolverFactory;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * Tests {@link ExecEnvPool}.
 *
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class ExecEnvPoolTest extends EMFTVMTest {

	public static final int TEST_COUNT = 1000;

	private static final Logger LOG = Logger.getLogger(ExecEnvPoolTest.class.getName());

	/**
	 * Test method for {@link ExecEnvPool#registerMetaModel(String, org.eclipse.m2m.atl.emftvm.Metamodel)}.
	 */
	public void testRegisterMetamodel() {
		final Metamodel metamodel = EmftvmFactory.eINSTANCE.createMetamodel();

		final ExecEnvPool pool = new ExecEnvPool();
		pool.registerMetaModel("metamodel", metamodel);

		assertEquals(metamodel, pool.getExecEnv().getMetaModels().get("metamodel"));
		try {
			pool.registerMetaModel("otherMetamodel", metamodel);
			fail("Expected IllegalStateException");
		} catch (final IllegalStateException e) {
			// expected
		}
	}

	/**
	 * Test method for {@link ExecEnvPool#loadModule(ModuleResolver, String)}.
	 */
	public void testLoadModule() {
		final ModuleResolverFactory mrf = new DefaultModuleResolverFactory(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/EcoreCopy/",
				true).toString());

		final ExecEnvPool pool = new ExecEnvPool();
		pool.setModuleResolverFactory(mrf);
		pool.loadModule("EcoreCopy");

		assertTrue(pool.getExecEnv().getModules().containsKey("EcoreCopy"));
		try {
			pool.loadModule("EcoreCopy");
			fail("Expected IllegalStateException");
		} catch (final IllegalStateException e) {
			// expected
		}
	}

	/**
	 * Test method for {@link ExecEnvPool#getExecEnv()}.
	 */
	public void testGetExecEnv() {
		final ExecEnvPool pool = new ExecEnvPool();
		final ExecEnv env = pool.getExecEnv();
		pool.returnExecEnv(env);

		assertSame(env, pool.getExecEnv());
		assertNotSame(env, pool.getExecEnv());
	}

	/**
	 * Test method for {@link ExecEnvPool#returnExecEnv(ExecEnv)}.
	 */
	public void testReturnExecEnv() {
		final ExecEnvPool pool = new ExecEnvPool();
		final ExecEnv env = pool.getExecEnv();
		pool.returnExecEnv(env);
		pool.returnExecEnv(env);

		assertSame(env, pool.getExecEnv());
		assertNotSame(env, pool.getExecEnv());

		try {
			pool.returnExecEnv(EmftvmFactory.eINSTANCE.createExecEnv());
			fail("Expected IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			// expected
		}
	}

	/**
	 * Tests the performance of EcoreCopy.emftvm.
	 *
	 * @throws InterruptedException
	 */
	public void testEcoreCopyPerformance() throws InterruptedException {
		final SortedSet<Long> timings = Collections.synchronizedSortedSet(new TreeSet<Long>());
		final SortedSet<Long> pureTimings = Collections.synchronizedSortedSet(new TreeSet<Long>());
		final int threadCount = Runtime.getRuntime().availableProcessors();

		final ExecEnvPool pool = new ExecEnvPool();
		final ExecutorService execSvc = Executors.newFixedThreadPool(threadCount);

		final ModuleResolverFactory mrf = new DefaultModuleResolverFactory(PLUGIN_URI + "/test-data/EcoreCopy/");
		pool.setModuleResolverFactory(mrf);
		pool.loadModule("EcoreCopy");

		for (int i = 0; i < TEST_COUNT; i++) {
			final int testNr = i;
			execSvc.execute(new Runnable() {
				public void run() {
					final ExecEnv env = pool.getExecEnv();

					final TimingData td = new TimingData();
					final ResourceSet rs = new ResourceSetImpl();
					final Resource inRes = rs.getResource(
							URI.createPlatformPluginURI(EMFTVM_PLUGIN_ID + "/model/emftvm.ecore", true), true);
					final Model in = EmftvmFactory.eINSTANCE.createModel(inRes);
					final Resource outRes = rs.createResource(URI.createURI("out.ecore"));
					final Model out = EmftvmFactory.eINSTANCE.createModel(outRes);

					assertFalse(env.getInputModels().containsKey("IN"));
					assertFalse(env.getOutputModels().containsKey("OUT"));
					env.registerInputModel("IN", in);
					env.registerOutputModel("OUT", out);
					td.finishLoading();
					env.run(td);
					td.finish();
					LOG.fine(String.format("ExecEnvPoolTest#testEcoreCopyPerformance test %d %s", testNr, td));
					timings.add(td.getFinished());
					pureTimings.add(td.getFinished() - td.getFinishedLoading());

					pool.returnExecEnv(env);
					final Runtime runtime = Runtime.getRuntime();
					LOG.fine(String.format("ExecEnvPoolTest#testEcoreCopyPerformance Heap space used for test %d: %d MB", testNr,
							(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)));
				}
			});
		}

		execSvc.shutdown();
		final boolean finished = execSvc.awaitTermination(60, TimeUnit.SECONDS);
		if (!finished) {
			LOG.info(String.format("ExecEnvPoolTest#testEcoreCopyPerformance Timed out; %d runs completed", timings.size()));
		}

		processTimings("ExecEnvPoolTest#testEcoreCopyPerformance", timings, pureTimings, threadCount);
	}

}
