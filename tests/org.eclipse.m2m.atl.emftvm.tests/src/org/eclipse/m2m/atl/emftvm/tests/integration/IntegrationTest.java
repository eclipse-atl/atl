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
package org.eclipse.m2m.atl.emftvm.tests.integration;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.logging.Level;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 *
 */
public class IntegrationTest extends EMFTVMTest {

	/**
	 * Tests "PrimitiveTypeLazyRuleTest.atl".
	 */
	public void testPrimitiveTypeLazyRule() throws Exception {
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
		loadTestModel(refRs, "/test-data/EcoreCopy/My.ecore");
		final Model refOut = loadTestModel(refRs, "/test-data/PrimitiveTypeLazyRuleTest-out.ecore");
		final Model refTrace = loadTestModel(refRs, "/test-data/PrimitiveTypeLazyRuleTest-trace.xmi");
		assertEquals(refOut.getResource(), env.getOutputModels().get("OUT").getResource());
		assertEquals(refTrace.getResource(), env.getInoutModels().get("trace").getResource());
	}

	/**
	 * Tests "LazyRuleInheritanceTest.atl".
	 */
	public void testLazyRuleInheritance() throws Exception {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.registerInputModel("IN", loadTestModel(rs, "/test-data/LazyRuleInheritanceTest.ecore"));
		env.registerOutputModel("OUT", createTestModel(rs, "/test-data/LazyRuleInheritanceTest-out.ecore"));
		env.registerInOutModel("trace", createTestModel(rs, "/test-data/LazyRuleInheritanceTest-trace.xmi"));
		env.loadModule(createTestModuleResolver(), "LazyRuleInheritanceTest");
		td.finishLoading();
		env.run(td);
		td.finish();
		ATLLogger.info("Finished LazyRuleInheritanceTest:\n" + td.toString());

		final ResourceSet refRs = new ResourceSetImpl();
		loadTestModel(refRs, "/test-data/LazyRuleInheritanceTest.ecore");
		final Model refOut = loadTestModel(refRs, "/test-data/LazyRuleInheritanceTest-out.ecore");
		final Model refTrace = loadTestModel(refRs, "/test-data/LazyRuleInheritanceTest-trace.xmi");
		assertEquals(refOut.getResource(), env.getOutputModels().get("OUT").getResource());
		assertEquals(refTrace.getResource(), env.getInoutModels().get("trace").getResource());
	}

	/**
	 * Tests "EntryEndPointRuleTest.atl".
	 */
	public void testEntryEndPointRule() throws Exception {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.registerInputModel("IN", loadTestModel(rs, "/test-data/EcoreCopy/My.ecore"));
		env.registerOutputModel("OUT", createTestModel(rs, "/test-data/EntryEndPointRuleTest-out.ecore"));
		final DefaultModuleResolver moduleResolver = new DefaultModuleResolver(PLUGIN_URI + "/test-data/", new ResourceSetImpl());
		moduleResolver.addUriPrefix(PLUGIN_URI + "/test-data/EcoreCopy/");
		env.loadModule(moduleResolver, "EntryEndPointRuleTest");
		td.finishLoading();
		env.run(td);
		td.finish();
		ATLLogger.info("Finished EntryEndPointRuleTest:\n" + td.toString());

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refOut = loadTestModel(refRs, "/test-data/EntryEndPointRuleTest-out.ecore");
		assertEquals(refOut.getResource(), env.getOutputModels().get("OUT").getResource());
	}

	/**
	 * Tests regression of
	 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=408391">Bug #
	 * 408391</a>.
	 */
	public void testBug408391() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Model model = EmftvmFactory.eINSTANCE.createModel(EmftvmPackage.eINSTANCE.eResource());
		env.registerInputModel("IN", model);
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
		expected = expected.append(-1).append(100000);
		expected = expected.append(false).append(true);
		expected = expected.append("Bogus").append(new LazyList<String>().append("firstsecond").append("firstsecond"));

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

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=411230">Bug # 411230</a>.
	 */
	public void testBug411230() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Metamodel metamodel = EmftvmFactory.eINSTANCE.createMetamodel(EcorePackage.eINSTANCE.eResource());
		final Model model = loadTestModel(rs, "/test-data/EcoreCopy/My.ecore");
		env.registerMetaModel("E", metamodel);
		env.registerInOutModel("IN", model);
		env.loadModule(createTestModuleResolver(), "Regression::Bug411230");
		td.finishLoading();
		env.run(td);
		td.finish();

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refOut = loadTestModel(refRs, "/test-data/Regression/Bug411230-out.ecore");
		assertEquals(refOut.getResource(), model.getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=413110">Bug # 413110</a>.
	 */
	public void testBug413110() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Metamodel metamodel = EmftvmFactory.eINSTANCE.createMetamodel(EcorePackage.eINSTANCE.eResource());
		final Model model = loadTestModel(rs, "/test-data/EcoreCopy/My.ecore");
		env.registerMetaModel("ECORE", metamodel);
		env.registerInOutModel("IN", model);
		env.loadModule(createTestModuleResolver(), "Regression::Bug413110");
		td.finishLoading();
		env.run(td);
		td.finish();

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refOut = loadTestModel(refRs, "/test-data/Regression/Bug413110-out.ecore");
		assertEquals(refOut.getResource(), model.getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=413110">Bug # 413110</a> for rule inheritance.
	 */
	public void testBug413110Inheritance() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Metamodel metamodel = EmftvmFactory.eINSTANCE.createMetamodel(EcorePackage.eINSTANCE.eResource());
		final Model model = loadTestModel(rs, "/test-data/EcoreCopy/My.ecore");
		env.registerMetaModel("ECORE", metamodel);
		env.registerInOutModel("IN", model);
		env.loadModule(createTestModuleResolver(), "Regression::Bug413110Inheritance");
		td.finishLoading();
		env.run(td);
		td.finish();

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refOut = loadTestModel(refRs, "/test-data/Regression/Bug413110Inheritance-out.ecore");
		assertEquals(refOut.getResource(), model.getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=421718">Bug # 421718</a>.
	 */
	public void testBug421718() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Metamodel metamodel = loadTestMetamodel(rs, "/test-data/Regression/Bug421718.ecore");
		final Model in = loadTestModel(rs, "/test-data/Regression/Bug421718-in.xmi");
		final Model out = createTestModel(rs, "/test-data/Regression/Bug421718-out.xmi");
		env.registerMetaModel("MM", metamodel);
		env.registerInputModel("IN", in);
		env.registerOutputModel("OUT", out);
		env.loadModule(createTestModuleResolver(), "Regression::Bug421718");
		td.finishLoading();
		env.run(td);
		td.finish();

		assertEquals(in.getResource(), out.getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=423281">Bug # 423281</a>.
	 */
	public void testBug423281TupleAccess() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.loadModule(createTestModuleResolver(), "Regression::Bug423281TupleAccess");
		td.finishLoading();
		final Object result = env.run(td);
		td.finish();

		assertEquals("one", result);
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=423597">Bug # 423597</a>.
	 */
	public void testBug423597() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Model in = loadTestModel(rs, "/test-data/Regression/Bug423597.emftvm");
		final Model out = createTestModel(rs, "/test-data/Regression/Bug423597-out.xmi");
		env.registerInputModel("IN", in);
		env.registerOutputModel("OUT", out);
		env.loadModule(createTestModuleResolver(), "Regression::Bug423597");
		td.finishLoading();
		env.run(td);
		td.finish();

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refOut = loadTestModel(refRs, "/test-data/Regression/Bug423597-out.xmi");
		assertEquals(refOut.getResource(), out.getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=424513">Bug # 424513</a>.
	 */
	public void testBug424513() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Metamodel mm = loadTestMetamodel(rs, "/test-data/Regression/Bug424513.ecore");
		env.registerMetaModel("MM", mm);
		env.loadModule(createTestModuleResolver(), "Regression::Bug424513");
		td.finishLoading();
		final Object result = env.run(td);
		td.finish();

		assertEquals(Boolean.FALSE, result);
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=425492">Bug # 425492</a>.
	 */
	public void testBug425492() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Model in = loadTestModel(rs, "/test-data/Regression/Bug425492.ecore");
		env.registerInOutModel("IN", in);
		env.loadModule(createTestModuleResolver(), "Regression::Bug425492");
		td.finishLoading();
		env.run(td);
		td.finish();

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refOut = loadTestModel(refRs, "/test-data/Regression/Bug425492-out.ecore");
		assertEquals(refOut.getResource(), in.getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=425904">Bug # 425904</a>.
	 */
	public void testBug425904() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.loadModule(createTestModuleResolver(), "Regression::Bug425904");
		td.finishLoading();
		final Object result = env.run(td);
		td.finish();

		assertEquals(Boolean.TRUE, result);
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=426154">Bug # 426154</a>.
	 */
	public void testBug426154() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Metamodel tr = EmftvmFactory.eINSTANCE.createMetamodel(TracePackage.eINSTANCE.eResource());
		final Model in = EmftvmFactory.eINSTANCE.createModel(EmftvmPackage.eINSTANCE.eResource());
		final Model trace = createTestModel(rs, "/test-data/Regression/Bug426154/Bug426154.trace");
		final Model out = createTestModel(rs, "/test-data/Regression/Bug426154/Bug426154-out.ecore");
		env.registerMetaModel("TR", tr);
		env.registerInOutModel("IN", in);
		env.registerOutputModel("trace", trace);
		env.registerOutputModel("OUT", out);
		env.loadModule(createTestModuleResolver(), "Regression::Bug426154::Importing");
		td.finishLoading();
		env.run(td);
		td.finish();

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refTrace = loadTestModel(refRs, "/test-data/Regression/Bug426154/Bug426154.trace");
		final Model refOut = loadTestModel(refRs, "/test-data/Regression/Bug426154/Bug426154-out.ecore");
		assertEquals(refTrace.getResource(), trace.getResource());
		assertEquals(refOut.getResource(), out.getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=427454">Bug # 427454</a>.
	 */
	public void testBug427454() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.loadModule(createTestModuleResolver(), "Regression::Bug427454");
		td.finishLoading();
		final Object result = env.run(td);
		td.finish();

		// Transformation should not crash

		assertNotNull(result);
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=441027">Bug # 441027</a>.
	 */
	public void testBug441027() {
		final ResourceSet rs = new ResourceSetImpl();
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		final Model in = loadTestModel(rs, "/test-data/Regression/Bug441027.emftvm");
		final Model out = createTestModel(rs, "/test-data/Regression/Bug441027-out.xmi");
		env.registerInputModel("IN", in);
		env.registerOutputModel("OUT", out);
		env.loadModule(createTestModuleResolver(), "Regression::Bug441027");
		td.finishLoading();
		env.run(td);
		td.finish();

		final ResourceSet refRs = new ResourceSetImpl();
		final Model refOut = loadTestModel(refRs, "/test-data/Regression/Bug441027-out.xmi");
		assertEquals(refOut.getResource(), out.getResource());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=454382">Bug # 454382</a>.
	 */
	public void testBug454382() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.loadModule(createTestModuleResolver(), "Regression::Bug454382");
		td.finishLoading();
		env.run(td);
		td.finish();

		// Test should finish in under a second (and print no "JIT miss" messages)
		assertTrue(
				String.format(
						"Expected Regression::Bug454382 to complete in < 1 sec. but was %f sec.",
						td.getFinished() / (1E9)),
				td.getFinished() < 1E9);
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=461445">Bug # 461445</a>.
	 */
	public void testBug461445() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.loadModule(createTestModuleResolver(), "Regression::Bug461445");
		td.finishLoading();
		final Object result = env.run(td);
		td.finish();

		assertEquals("value", result);
	}

	/**
	 * Tests the ATL metamodel API.
	 */
	public void testATLAPI() throws Exception {
		final ModelFactory mf = AtlParser.getDefault().getModelFactory();
		final IReferenceModel atlMM = AtlParser.getDefault().getAtlMetamodel();
		final IModel atlM = mf.newModel(atlMM);

		final EObject module = (EObject) atlM.newElement(atlMM.getMetaElementByName("Module"));
		module.eSet(module.eClass().getEStructuralFeature("name"), "testmodule");
		final EObject rule = (EObject) atlM.newElement(atlMM.getMetaElementByName("MatchedRule"));
		rule.eSet(rule.eClass().getEStructuralFeature("name"), "Test");
		@SuppressWarnings("unchecked")
		final
		EList<EObject> moduleElements = (EList<EObject>) module.eGet(module.eClass().getEStructuralFeature("elements"));
		moduleElements.add(rule);

		final FileOutputStream fos = new FileOutputStream("testmodule.atl");
		try {
			AtlParser.getDefault().extract(atlM, fos, Collections.emptyMap());
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

	/**
	 * Tests "ToStringTest.atl".
	 */
	public void testToString() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final TimingData td = new TimingData();
		env.loadModule(createTestModuleResolver(), "ToStringTest");
		td.finishLoading();
		final Object result = env.run(td);
		td.finish();

		assertEquals("Sequence{1, 2, 'three', 'OclUndefined'}", result);
	}

}
