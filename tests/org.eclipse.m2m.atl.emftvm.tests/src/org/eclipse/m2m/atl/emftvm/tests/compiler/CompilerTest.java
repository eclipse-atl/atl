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
package org.eclipse.m2m.atl.emftvm.tests.compiler;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.New;
import org.eclipse.m2m.atl.emftvm.constraints.StackUnderflowValidator;
import org.eclipse.m2m.atl.emftvm.constraints.ValidCodeBlockStackLevelValidator;
import org.eclipse.m2m.atl.emftvm.constraints.Validator;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

/**
 * Tests the ATL-to-EMFTVM compiler.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class CompilerTest extends EMFTVMTest {

	/**
	 * Code block stack level validator.
	 */
	protected final Validator<CodeBlock> cbStackValidator = new ValidCodeBlockStackLevelValidator();

	/**
	 * Instruction stack level validator.
	 */
	protected final Validator<Instruction> instrStackValidator = new StackUnderflowValidator();

	/**
	 * Tests compilation of 'BindingStatTest.atl'.
	 */
	public void testBindingStat() {
		final Model outModel = compile(URI.createURI("test-data/BindingStatTest.atl", true));
		assertEquals(null, validate(outModel));
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=405673">Bug # 405673</a>.
	 */
	public void testBug405673() {
		final Model outModel = compile(URI.createURI("test-data/Regression/Bug405673.atl", true));
		assertEquals(null, validate(outModel));
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=406100">Bug # 406100</a>.
	 */
	public void testBug406100() {
		final Model outModel = compile(URI.createURI("test-data/Regression/Bug406100.atl", true));
		assertEquals(null, validate(outModel));
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=406100">Bug # 406662</a>.
	 */
	public void testBug406662() {
		final Model outModel = compile(URI.createURI("test-data/Regression/Bug406662.atl", true));
		assertEquals(null, validate(outModel));
		final List<EObject> news = outModel.allInstancesOf(EmftvmPackage.eINSTANCE.getNew());
		assertFalse(news.isEmpty());
		for (EObject object : news) {
			New new_ = (New) object;
			assertEquals("EXISTING", new_.getModelname());
		}
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=419433">Bug # 419433</a>.
	 */
	public void testBug419433() {
		final Model outModel = compile(URI.createURI("test-data/Regression/Bug419433.atl", true));
		assertEquals(null, validate(outModel));
		final Model outModel2 = atlwfr(URI.createURI("test-data/Regression/Bug419433-2.atl", true));
		final Resource pbs = outModel2.getResource();
		assertEquals(4, pbs.getContents().size());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=422408">Bug # 422408</a>.
	 */
	public void testBug422408() {
		final Model outModel = atlwfr(URI.createURI("test-data/Regression/Bug422408.atl", true));
		final Resource pbs = outModel.getResource();
		assertEquals(3, pbs.getContents().size());
	}

	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=425492">Bug # 425492</a>.
	 */
	public void testBug425492() {
		final Model outModel = compile(URI.createURI("test-data/Regression/Bug425492.atl", true));
		assertEquals(null, validate(outModel));

		final Model refModel = loadTestModel(new ResourceSetImpl(), "/test-data/Regression/Bug425492.emftvm");
		assertEquals(refModel.getResource(), outModel.getResource());
	}
	
	/**
	 * Tests regression of <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=429745">Bug # 429745</a>: 
	 * EMFTVM compiler crashes on reference to target element in rule "from" clause.
	 */
	public void testBug429745() {
		final Model outModel = atlwfr(URI.createURI("test-data/Regression/Bug429745.atl", true));
		final Resource pbs = outModel.getResource();
		assertEquals(1, pbs.getContents().size());
	}

	/**
	 * Tests the compilation output for "ATLtoEMFTVM.atl".
	 */
	public void testATLtoEMFTVM() {
		runCompilerModuleTest("ATLtoEMFTVM");
	}

	/**
	 * Tests the compilation output for "OCLtoEMFTVM.atl".
	 */
	public void testOCLtoEMFTVM() {
		runCompilerModuleTest("OCLtoEMFTVM");
	}

	/**
	 * Tests the compilation output for "InlineCodeblocks.atl".
	 */
	public void testInlineCodeblocks() {
		runCompilerModuleTest("InlineCodeblocks");
	}

	/**
	 * Tests the compilation output for "ATLWFR.atl".
	 */
	public void testATLWFR() {
		runCompilerModuleTest("ATLWFR");
	}

	/**
	 * Tests the compilation output for "EMFTVMCopy.atl".
	 */
	public void testEMFTVMCopy() {
		runCompilerModuleTest("EMFTVMCopy");
	}

	/**
	 * Tests the compilation of a compiler module.
	 * 
	 * @param compilerModule
	 *            the compiler module name
	 */
	protected void runCompilerModuleTest(final String compilerModule) {
		final Model outModel = compile(URI
				.createPlatformPluginURI(COMPILER_PLUGIN_ID + "/transformations/" + compilerModule + ".atl", true));
		assertEquals(null, validate(outModel));
		final Resource refModel = new ResourceSetImpl().getResource(
				URI.createPlatformPluginURI(COMPILER_PLUGIN_ID + "/transformations/" + compilerModule + ".emftvm", true), true);
		assertEquals(refModel, outModel.getResource());
	}

	/**
	 * Compiles the given ATL module.
	 * 
	 * @param moduleURI
	 *            the module URI
	 * @return the compiled module
	 */
	protected Model compile(final URI moduleURI) {
		assertTrue(atlwfr(moduleURI).getResource().getContents().isEmpty());

		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		{
			final Resource inRes = rs.getResource(moduleURI, true);
			final Model inModel = EmftvmFactory.eINSTANCE.createModel();
			inModel.setResource(inRes);
			env.registerInputModel("IN", inModel);
		}

		final Resource outRes = rs.createResource(URI.createFileURI("out.emftvm"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		assertEquals(outModel, env.getOutputModels().get("OUT"));

		final Resource pbsRes = rs.createResource(URI.createFileURI("pbs.xmi"));
		final Model pbsModel = EmftvmFactory.eINSTANCE.createModel();
		pbsModel.setResource(pbsRes);
		env.registerOutputModel("PBS", pbsModel);
		assertEquals(pbsModel, env.getOutputModels().get("PBS"));

		{
			final Metamodel atlmm = EmftvmFactory.eINSTANCE.createMetamodel();
			atlmm.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/gmt/2005/ATL"), true));
			env.registerMetaModel("ATL", atlmm);
		}

		{
			final Metamodel pbmm = EmftvmFactory.eINSTANCE.createMetamodel();
			pbmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getProblemMetamodel()).getResource());
			env.registerMetaModel("Problem", pbmm);
		}

		EMFTVMUtil.registerEPackages(rs);

		// Load and run module
		{
			final ModuleResolver mr = new DefaultModuleResolver(COMPILER_PLUGIN_URI + "/transformations/", new ResourceSetImpl());
			env.loadModule(mr, "ATLtoEMFTVM");
			env.run(null);
			assertTrue(pbsRes.getContents().isEmpty());
			assertEquals(1, outRes.getContents().size());
			assertTrue(outRes.getContents().get(0) instanceof Module);
		}

		final ExecEnv env2 = EmftvmFactory.eINSTANCE.createExecEnv();
		env2.registerInputModel("IN", outModel);

		final Resource outRes2 = rs.createResource(URI.createFileURI("out.emftvm"));
		final Model outModel2 = EmftvmFactory.eINSTANCE.createModel();
		outModel2.setResource(outRes2);
		env2.registerOutputModel("OUT", outModel2);
		assertEquals(outModel2, env2.getOutputModels().get("OUT"));

		final Resource pbsRes2 = rs.createResource(URI.createFileURI("pbs.xmi"));
		final Model pbsModel2 = EmftvmFactory.eINSTANCE.createModel();
		pbsModel2.setResource(pbsRes2);
		env2.registerOutputModel("PBS", pbsModel2);
		assertEquals(pbsModel2, env2.getOutputModels().get("PBS"));

		// Load and run module
		{
			final ModuleResolver mr = new DefaultModuleResolver(COMPILER_PLUGIN_URI + "/transformations/", new ResourceSetImpl());
			env2.loadModule(mr, "InlineCodeblocks");
			env2.run(null);
			assertTrue(pbsRes2.getContents().isEmpty());
			assertEquals(1, outRes2.getContents().size());
			assertTrue(outRes2.getContents().get(0) instanceof Module);
		}

		// CodeBlocks passed into a native operation have their parentFrame property set - clear this property:
		for (EObject cb : outModel2.allInstancesOf(EmftvmPackage.eINSTANCE.getCodeBlock())) {
			((CodeBlock) cb).setParentFrame(null);
		}

		return outModel2;
	}

	/**
	 * Validates the bytecode of <code>module</code>.
	 * 
	 * @param mmodel
	 *            the module model to validate
	 * @return <code>null</code> if <code>module</code> is valid, otherwise the first invalid object
	 */
	protected Object validate(Model mmodel) {
		for (EObject eObject : mmodel.allInstancesOf(EmftvmPackage.eINSTANCE.getCodeBlock())) {
			CodeBlock cb = (CodeBlock) eObject;
			if (!cbStackValidator.validate(cb)) {
				return cb;
			}
			for (Instruction i : cb.getCode()) {
				if (!instrStackValidator.validate(i)) {
					return i;
				}
			}
		}
		for (EObject eObject : mmodel.getResource().getContents()) {
			Diagnostic diag = Diagnostician.INSTANCE.validate(eObject);
			if (diag.getSeverity() != Diagnostic.OK) {
				return diag;
			}
		}
		return null;
	}

	/**
	 * Checks the given ATL module against the ATL well-formedness rules.
	 * 
	 * @param moduleURI
	 *            the module URI
	 * @return the problems model
	 */
	protected Model atlwfr(final URI moduleURI) {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		{
			final Resource inRes = rs.getResource(moduleURI, true);
			final Model inModel = EmftvmFactory.eINSTANCE.createModel();
			inModel.setResource(inRes);
			env.registerInputModel("IN", inModel);
		}

		final Resource pbsRes = rs.createResource(URI.createFileURI("pbs.xmi"));
		final Model pbsModel = EmftvmFactory.eINSTANCE.createModel();
		pbsModel.setResource(pbsRes);
		env.registerOutputModel("OUT", pbsModel);
		assertEquals(pbsModel, env.getOutputModels().get("OUT"));

		{
			final Metamodel atlmm = EmftvmFactory.eINSTANCE.createMetamodel();
			atlmm.setResource(rs.getResource(URI.createURI("http://www.eclipse.org/gmt/2005/ATL"), true));
			env.registerMetaModel("ATL", atlmm);
		}

		{
			final Metamodel pbmm = EmftvmFactory.eINSTANCE.createMetamodel();
			pbmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getProblemMetamodel()).getResource());
			env.registerMetaModel("Problem", pbmm);
		}

		EMFTVMUtil.registerEPackages(rs);

		// Load and run module
		{
			final ModuleResolver mr = new DefaultModuleResolver(COMPILER_PLUGIN_URI + "/transformations/", new ResourceSetImpl());
			env.loadModule(mr, "ATLWFR");
			env.run(null);
		}

		return pbsModel;
	}

}
