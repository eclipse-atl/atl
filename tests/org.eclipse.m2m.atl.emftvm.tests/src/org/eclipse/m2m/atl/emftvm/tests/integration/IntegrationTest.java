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
package org.eclipse.m2m.atl.emftvm.tests.integration;

import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 *
 */
public class IntegrationTest extends EMFTVMTest {

	/**
	 * Tests "PrimitiveTypeLazyRuleTest.atl".
	 */
	public void testPrimitiveTypeLazyRule() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.registerInputModel("IN", loadTestModel(rs, "/test-data/EcoreCopy/My.ecore"));
		env.registerOutputModel("OUT", createTestModel(rs, "/test-data/PrimitiveTypeLazyRuleTest-out.ecore"));
		env.registerInOutModel("trace", createTestModel(rs, "/test-data/PrimitiveTypeLazyRuleTest-trace.xmi"));
		env.loadModule(createTestModuleResolver(), "PrimitiveTypeLazyRuleTest");
		td.finishLoading();
		env.run(td);
		td.finish();
		ATLLogger.info("Finished PrimitiveTypeLazyRuleTest:\n" + td.toString());

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refOut = loadTestModel(refRs, "/test-data/PrimitiveTypeLazyRuleTest-out.ecore");
		final Model refTrace = loadTestModel(refRs, "/test-data/PrimitiveTypeLazyRuleTest-trace.xmi");
		assertEquals(refOut.getResource(), env.getOutputModels().get("OUT").getResource());
		assertEquals(refTrace.getResource(), env.getInoutModels().get("trace").getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=408391">Bug # 408391</a>.
	 */
	public void testBug408391() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.loadModule(createTestModuleResolver(), "Regression::Bug408391");
		td.finishLoading();
		final Object result = env.run(td);
		td.finish();

		final Calendar cal = Calendar.getInstance();
		cal.clear();
		LazyList<Object> expected = new LazyList<Object>();
		expected = expected.append(cal.getTime());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 1999);
		expected = expected.append(cal.getTime());
		expected = expected.append(Character.valueOf('S')).append("0");
		expected = expected.append(Arrays.asList("String1,String2,String3".split(",", 2))).append("N");

		assertEquals(expected, result);

		// Test for JIT implementation
		final Level level = ATLLogger.getLogger().getLevel();
		ATLLogger.getLogger().setLevel(Level.WARNING);
		for (int i = 0; i < 100; i++) {
			env.run(null);
		}
		ATLLogger.getLogger().setLevel(level);

		final Object jitResult = env.run(td);

		assertEquals(expected, jitResult);
	}

}
