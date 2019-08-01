/*******************************************************************************
 * Copyright (c) 2007, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - ATL tester
 *     Dennis Wagelaar
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.unit.atlvm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.atl.common.ATLLaunchConstants;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Specifies TestNonRegressionTransfo for the EMFTVM.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class TestNonRegressionEMFTVM extends TestNonRegressionTransfo {

	public static final String COMPILER_PLUGIN_ID = "org.eclipse.m2m.atl.emftvm.compiler";
	public static final String COMPILER_PLUGIN_URI = "platform:/plugin/" + COMPILER_PLUGIN_ID;

	class CompilingModuleResolver implements ModuleResolver {

		public Module resolveModule(String name) throws ModuleNotFoundException {
			final URI uri = URI.createURI(name, true);
			final Model model = compile(uri);
			return (Module) model.getResource().getContents().get(0);
		}

	}

	protected final Metamodel pbmm = EmftvmFactory.eINSTANCE.createMetamodel();
	{
		pbmm.setResource(((EMFReferenceModel) AtlParser.getDefault().getProblemMetamodel()).getResource());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo#getVMName()
	 */
	@Override
	protected String getVMName() {
		return "EMFTVM"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.tests.unit.TestNonRegressionTransfo#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Properties properties = new Properties();	
		properties.load(TestNonRegressionEMFTVM.class.getResourceAsStream("TestNonRegressionEMFTVM.properties")); //$NON-NLS-1$
		setProperties(properties);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				new UMLResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(UMLResource.UML_METAMODEL_URI, UMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.0.0/UML", UMLPackage.eINSTANCE); //$NON-NLS-1$
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.1.0/UML", UMLPackage.eINSTANCE); //$NON-NLS-1$
	}
	
	/**
	 * Launch a transformation.
	 * 
	 * @return pureExecutionTime, i.e. the execution time without loading/saving models
	 */
	protected double launch() throws ATLCoreException, IOException {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ModuleResolver mr = new CompilingModuleResolver();
		final ResourceSet rs = new ResourceSetImpl();

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
		if (isRefiningTraceMode) {
			fail("Refining trace mode not supported on EMFTVM");
		}

		Map<String, String> modelHandlers = launchParser.getModelHandler();
		options.put("modelHandlers", modelHandlers); //$NON-NLS-1$

		// Metamodels
		final Set<String> metamodels = new LinkedHashSet<String>();
		metamodels.addAll(unsortedSourceModels.values());
		metamodels.addAll(unsortedTargetModels.values());
		for (String metamodel : metamodels) {
			loadMetaModel(env, rs, metamodel, modelPaths.get(metamodel));
		}

		EMFTVMUtil.registerEPackages(rs);

		// Libraries
		for (Entry<String, URL> entry : libs.entrySet()) {
			env.loadModule(mr, moduleName(entry.getValue()));
		}

		env.loadModule(mr, moduleName(asmURL));

		// API extensions management
		for (URL url : superimps) {
			env.loadModule(mr, moduleName(url));
		}

		long startTime = System.currentTimeMillis();

		// Input models
		for (String key : unsortedSourceModels.keySet()) {
			loadModel(env, rs, key, modelPaths.get(key), false);
		}

		// Output models
		for (String key : unsortedTargetModels.keySet()) {
			createModel(env, rs, key, modelPaths.get(key), false);
		}

		try {
			env.run(null);
		} catch (VMException e) {
			fail(asmURL.toString(), e);
		}

		// Output models
		final Map<String, String> saveOptions = new HashMap<String, String>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "ISO-8859-1");
		for (Model outModel : env.getOutputModels().values()) {
			outModel.getResource().save(saveOptions);
		}

		long endTime = System.currentTimeMillis();

		return (endTime - startTime) / 1000.;
	}

	private static void loadModel(final ExecEnv env, final ResourceSet rs, final String name, final String path, boolean inOut) {
		Model model = EmftvmFactory.eINSTANCE.createModel();
		model.setResource(rs.getResource(uri(path), true));
		if (inOut) {
			env.registerInOutModel(name, model);
		} else {
			env.registerInputModel(name, model);
		}
	}

	private static void loadMetaModel(final ExecEnv env, final ResourceSet rs, final String name, final String path) {
		Metamodel model = EmftvmFactory.eINSTANCE.createMetamodel();
		if ("#EMF".equals(path)) {
			model.setResource(EcorePackage.eINSTANCE.eResource());
		} else {
			model.setResource(rs.getResource(uri(path), true));
		}
		env.registerMetaModel(name, model);
	}

	private static void createModel(final ExecEnv env, final ResourceSet rs, final String name, final String path, boolean inOut) {
		Model model = EmftvmFactory.eINSTANCE.createModel();
		model.setResource(rs.createResource(uri(path)));
		if (inOut) {
			env.registerInOutModel(name, model);
		} else {
			env.registerOutputModel(name, model);
		}
	}

	private static String moduleName(final URL url) {
		String name = url.toString();
		name = name.replace(".asm", ".atl");
		return name;
	}

	private static URI uri(final String path) {
		return URI.createURI(path.replace("uri:", "").replace("ext:", "file:"), true);
	}

	/**
	 * Compiles the given ATL module.
	 * 
	 * @param moduleURI
	 *            the module URI
	 * @return the compiled module
	 */
	protected Model compile(final URI moduleURI) {
		final List<EObject> errors = new ArrayList<EObject>();
		assertEquals(0, getProblems(atlwfr(moduleURI), errors));

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
			assertEquals(0, getProblems(pbsModel, errors));
			assertEquals(1, outRes.getContents().size());
			assertTrue(outRes.getContents().get(0) instanceof Module);
		}

		final ExecEnv env2 = EmftvmFactory.eINSTANCE.createExecEnv();
		env2.registerInOutModel("IN", outModel);

		// Load and run module
		{
			final ModuleResolver mr = new DefaultModuleResolver(COMPILER_PLUGIN_URI + "/transformations/", new ResourceSetImpl());
			env2.loadModule(mr, "InlineCodeblocks");
			env2.run(null);
			assertEquals(1, outRes.getContents().size());
			assertTrue(outRes.getContents().get(0) instanceof Module);
		}

		// CodeBlocks passed into a native operation have their parentFrame property set - clear this property:
		for (EObject cb : outModel.allInstancesOf(EmftvmPackage.eINSTANCE.getCodeBlock())) {
			((CodeBlock) cb).setParentFrame(null);
		}

		return outModel;
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

	/**
	 * Retrieves problem elements from <code>problems</code>.
	 * 
	 * @param problems
	 *            the problems model
	 * @param pbElements
	 *            the collection of problem elements to augment
	 * @return the number of error problems
	 */
	protected int getProblems(Model problems, Collection<EObject> pbElements) {
		final Collection<EObject> pbs = (Collection<EObject>) problems.allInstancesOf((EClass) pbmm.findType("Problem")); //$NON-NLS-1$

		int nbErrors = 0;
		if (pbs != null) {
			for (EObject pb : pbs) {
				EStructuralFeature severityFeature = pb.eClass().getEStructuralFeature("severity"); //$NON-NLS-1$
				if (severityFeature != null && "error".equals(((Enumerator) pb.eGet(severityFeature)).getName())) { //$NON-NLS-1$
					nbErrors++;
				}
			}
			pbElements.addAll(pbs);
		}

		return nbErrors;
	}

}
