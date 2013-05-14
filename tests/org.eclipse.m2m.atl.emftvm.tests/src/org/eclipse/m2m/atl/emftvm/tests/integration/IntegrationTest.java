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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
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

}
