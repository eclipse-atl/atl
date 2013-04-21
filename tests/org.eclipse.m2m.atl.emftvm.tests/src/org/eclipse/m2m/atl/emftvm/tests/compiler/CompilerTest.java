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

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.constraints.StackUnderflowValidator;
import org.eclipse.m2m.atl.emftvm.constraints.ValidCodeBlockStackLevelValidator;
import org.eclipse.m2m.atl.emftvm.constraints.Validator;
import org.eclipse.m2m.atl.emftvm.tests.EMFTVMTest;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;

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
	 * Compiles the given ATL module.
	 * 
	 * @param moduleURI
	 *            the module URI
	 * @return the compiled module
	 */
	protected Model compile(final URI moduleURI) {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		{
			final Resource inRes = rs.getResource(moduleURI, true);
			final Model inModel = EmftvmFactory.eINSTANCE.createModel();
			inModel.setResource(inRes);
			env.registerInputModel("IN", inModel);
		}

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
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
			pbmm.setResource(rs.getResource(
					URI.createPlatformPluginURI(COMMON_PLUGIN_ID + "/org/eclipse/m2m/atl/common/resources/Problem.ecore", true), true));
			env.registerMetaModel("Problem", pbmm);
		}

		// Load and run module
		{
			final ModuleResolver mr = new DefaultModuleResolver(COMPILER_PLUGIN_URI + "/transformations/", rs);
			env.loadModule(mr, "ATLtoEMFTVM");
			env.run(null);
			assertTrue(pbsRes.getContents().isEmpty());
		}

		final ExecEnv env2 = EmftvmFactory.eINSTANCE.createExecEnv();
		env2.registerInputModel("IN", outModel);

		final Resource outRes2 = rs.createResource(URI.createFileURI("out.xmi"));
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
			final ModuleResolver mr = new DefaultModuleResolver(COMPILER_PLUGIN_URI + "/transformations/", rs);
			env2.loadModule(mr, "InlineCodeblocks");
			env2.run(null);
			assertTrue(pbsRes2.getContents().isEmpty());
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

}
