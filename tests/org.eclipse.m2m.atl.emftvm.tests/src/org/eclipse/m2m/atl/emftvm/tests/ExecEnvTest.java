/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.NativeCodeBlock;
import org.eclipse.m2m.atl.emftvm.util.NativeTypes.NativeType;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.Types;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;
import org.osgi.framework.Bundle;


/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exec Env</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModels() <em>Meta Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModels() <em>Input Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModels() <em>Inout Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModels() <em>Output Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModules() <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMatches() <em>Matches</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getTraces() <em>Traces</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getUniqueResults() <em>Unique Results</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#loadModule(org.eclipse.m2m.atl.emftvm.util.ModuleResolver, java.lang.String) <em>Load Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object[]) <em>Find Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String) <em>Find Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object) <em>Find Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#hasOperation(java.lang.String, int) <em>Has Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object[]) <em>Find Static Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String) <em>Find Static Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object) <em>Find Static Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#hasStaticOperation(java.lang.String, int) <em>Has Static Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findField(java.lang.Object, java.lang.String) <em>Find Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#hasField(java.lang.String) <em>Has Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#hasStaticField(java.lang.String) <em>Has Static Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findRule(java.lang.String) <em>Find Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findType(java.lang.String, java.lang.String) <em>Find Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData) <em>Run</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getRules() <em>Get Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModelOf(org.eclipse.emf.ecore.EObject) <em>Get Model Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModelID(org.eclipse.m2m.atl.emftvm.Model) <em>Get Model ID</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModelID(org.eclipse.m2m.atl.emftvm.Metamodel) <em>Get Meta Model ID</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForDelete(org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Delete</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#deleteQueue() <em>Delete Queue</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModelOf(org.eclipse.emf.ecore.EObject) <em>Get Input Model Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModelOf(org.eclipse.emf.ecore.EObject) <em>Get Inout Model Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModelOf(org.eclipse.emf.ecore.EObject) <em>Get Output Model Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMonitor() <em>Get Monitor</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#setMonitor(org.eclipse.m2m.atl.emftvm.util.VMMonitor) <em>Set Monitor</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerMetaModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Metamodel) <em>Register Meta Model</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerInputModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model) <em>Register Input Model</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerInOutModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model) <em>Register In Out Model</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerOutputModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model) <em>Register Output Model</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModel(org.eclipse.emf.ecore.resource.Resource) <em>Get Meta Model</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ExecEnvTest extends TestCase {

	public static final String PLUGIN_ID = "org.eclipse.m2m.atl.emftvm.tests";
	public static final String PLUGIN_URI = "platform:/plugin/" + PLUGIN_ID;
	public static final String COMPILER_PLUGIN_ID = "org.eclipse.m2m.atl.emftvm.compiler";
	public static final String COMPILER_PLUGIN_URI = "platform:/plugin/" + COMPILER_PLUGIN_ID;

	public static final Bundle bundle = Platform.getBundle(PLUGIN_ID);

	/**
	 * The fixture for this Exec Env test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecEnv fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExecEnvTest.class);
	}

	/**
	 * Asserts that leftResource and rightResource are equal. Uses EMF Compare.
	 * @param leftObject
	 * @param rightObject
	 * @throws InterruptedException 
	 */
	public static void assertEquals(Resource leftResource, Resource rightResource)
	throws InterruptedException {
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		final MatchModel match = MatchService.doResourceMatch(leftResource, rightResource, options);
		assertTrue(match.getUnmatchedElements().isEmpty());
		if (!leftResource.getContents().isEmpty()) {
			assertFalse(match.getMatchedElements().isEmpty());
		}
		final DiffModel diff = DiffService.doDiff(match);
		assertTrue(diff.getOwnedElements().size() == 1);
		for (Iterator<EObject> allContents = diff.eAllContents(); allContents.hasNext();) {
			EObject de = allContents.next();
			//allow only certain kinds of diff elements
			assertTrue(de instanceof DiffGroup || de instanceof ReferenceOrderChange);
		}
	}

	/**
	 * Constructs a new Exec Env test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecEnvTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Exec Env test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ExecEnv fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Exec Env test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecEnv getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createExecEnv());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModels() <em>Meta Models</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModels()
	 * @generated NOT
	 */
	public void testGetMetaModels() {
		final Map<String, Metamodel> mms = getFixture().getMetaModels();
		assertNotNull(mms);
		final Metamodel emftvm = mms.get(EmftvmPackage.eNAME.toUpperCase());
		assertNotNull(emftvm);
		assertTrue(EmftvmPackage.eINSTANCE.eResource() == emftvm.getResource());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModels() <em>Input Models</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModels()
	 * @generated NOT
	 */
	public void testGetInputModels() {
		final Map<String, Model> ms = getFixture().getInputModels();
		assertNotNull(ms);
		assertTrue(ms.isEmpty());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModels() <em>Inout Models</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModels()
	 * @generated NOT
	 */
	public void testGetInoutModels() {
		final Map<String, Model> ms = getFixture().getInoutModels();
		assertNotNull(ms);
		assertTrue(ms.isEmpty());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModels() <em>Output Models</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModels()
	 * @generated NOT
	 */
	public void testGetOutputModels() {
		final Map<String, Model> ms = getFixture().getOutputModels();
		assertNotNull(ms);
		assertTrue(ms.isEmpty());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModules() <em>Modules</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getModules()
	 * @generated NOT
	 */
	public void testGetModules() {
		final Map<String, Module> ms = getFixture().getModules();
		assertNotNull(ms);
		assertTrue(ms.containsKey("OCL"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMatches() <em>Matches</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getMatches()
	 * @generated NOT
	 */
	public void testGetMatches() {
		final TraceLinkSet tls = getFixture().getMatches();
		assertNotNull(tls);
		assertTrue(tls.getRules().isEmpty());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getTraces() <em>Traces</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getTraces()
	 * @generated NOT
	 */
	public void testGetTraces() {
		final TraceLinkSet tls = getFixture().getTraces();
		assertNotNull(tls);
		assertTrue(tls.getRules().isEmpty());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getUniqueResults() <em>Unique Results</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getUniqueResults()
	 * @generated NOT
	 */
	public void testGetUniqueResults() {
		final Map<TraceLink, Object> urs = getFixture().getUniqueResults();
		assertNotNull(urs);
		assertTrue(urs.isEmpty());
	}

	/**
	 * Creates an empty dummy module with a 'main' operation.
	 * @return an empty dummy module with a 'main' operation.
	 */
	protected Module createDummyModule() {
		final Operation main = EmftvmFactory.eINSTANCE.createOperation();
		main.setName(EMFTVMUtil.MAIN_OP_NAME);
		main.setStatic(true);
		main.setContextModel("EMFTVM");
		main.setContext("ExecEnv");
		main.setTypeModel(EMFTVMUtil.NATIVE);
		main.setType("java::lang::Object");
		main.setBody(EmftvmFactory.eINSTANCE.createCodeBlock());

		final Module dummyModule = EmftvmFactory.eINSTANCE.createModule();
		dummyModule.setName("dummy");
		dummyModule.getFeatures().add(main);
		return dummyModule;
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMonitor() <em>Get Monitor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getMonitor()
	 * @generated NOT
	 */
	public void testGetMonitor() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		final VMMonitor mon = new VMMonitor() {
			private boolean terminated;
			public void terminated() {
				assertEquals(this, env.getMonitor());
				terminated = true;
			}
			public void step(StackFrame frame) {
			}
			public void leave(StackFrame frame) {
			}
			public boolean isTerminated() {
				return terminated;
			}
			public void error(StackFrame frame, String msg, Exception e) {
			}
			public void enter(StackFrame frame) {
			}
		};

		// Create dummy module
		final Module dummyModule = createDummyModule();
		// Load module
		final ModuleResolver mr = new ModuleResolver() {
			public Module resolveModule(String name) throws ModuleNotFoundException {
				return dummyModule;
			}
		};
		env.loadModule(mr, "dummy");
		// Run
		assertNull(env.getMonitor());
		env.setMonitor(mon);
		assertNotNull(env.getMonitor());
		env.run(null);
		assertNotNull(env.getMonitor());
		env.setMonitor(null);
		assertNull(env.getMonitor());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#setMonitor(org.eclipse.m2m.atl.emftvm.util.VMMonitor) <em>Set Monitor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#setMonitor(org.eclipse.m2m.atl.emftvm.util.VMMonitor)
	 * @generated NOT
	 */
	public void testSetMonitor__VMMonitor() {
		final VMMonitor monitor = new VMMonitor() {
			public void terminated() {
			}
			public void step(StackFrame frame) {
			}
			public void leave(StackFrame frame) {
			}
			public boolean isTerminated() {
				return false;
			}
			public void error(StackFrame frame, String msg, Exception e) {
			}
			public void enter(StackFrame frame) {
			}
		};
		getFixture().setMonitor(monitor);
		assertEquals(monitor, getFixture().getMonitor());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerMetaModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Metamodel) <em>Register Meta Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#registerMetaModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Metamodel)
	 * @generated NOT
	 */
	public void testRegisterMetaModel__String_Metamodel() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load metamodel
		final Resource portsRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Ports.ecore", true), true);
		final Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		metaModel.setResource(portsRes);
		env.registerMetaModel("PORTS", metaModel);

		assertTrue(env.getMetaModels().containsKey("PORTS"));
		assertEquals(metaModel, env.getMetaModels().get("PORTS"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerInputModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model) <em>Register Input Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#registerInputModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model)
	 * @generated NOT
	 */
	public void testRegisterInputModel__String_Model() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load and register model
		final Resource res = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestLib.emftvm", true), true);
		final Model model = EmftvmFactory.eINSTANCE.createModel();
		model.setResource(res);
		env.registerInputModel("M", model);

		assertTrue(env.getInputModels().containsKey("M"));
		assertEquals(model, env.getInputModels().get("M"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerInOutModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model) <em>Register In Out Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#registerInOutModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model)
	 * @generated NOT
	 */
	public void testRegisterInOutModel__String_Model() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		{
		// Load and register model
		final Resource res = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestLib.emftvm", true), true);
		final Model model = EmftvmFactory.eINSTANCE.createModel();
		model.setResource(res);
		env.registerInOutModel("M", model);

		assertTrue(env.getInoutModels().containsKey("M"));
		assertEquals(model, env.getInoutModels().get("M"));
		}

		{
		// Load and register model
		final Resource res = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestLib.emftvm", true), true);
		final Model model = EmftvmFactory.eINSTANCE.createModel();
		model.setResource(res);
		env.registerInOutModel("M", model);

		assertTrue(env.getInoutModels().containsKey("M"));
		assertEquals(model, env.getInoutModels().get("M"));
		}
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerOutputModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model) <em>Register Output Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#registerOutputModel(java.lang.String, org.eclipse.m2m.atl.emftvm.Model)
	 * @generated NOT
	 */
	public void testRegisterOutputModel__String_Model() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Create and register model
		final Resource res = rs.createResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/out.xmi", true));
		final Model model = EmftvmFactory.eINSTANCE.createModel();
		model.setResource(res);
		env.registerOutputModel("M", model);

		assertTrue(env.getOutputModels().containsKey("M"));
		assertEquals(model, env.getOutputModels().get("M"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModel(org.eclipse.emf.ecore.resource.Resource) <em>Get Meta Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModel(org.eclipse.emf.ecore.resource.Resource)
	 * @generated NOT
	 */
	public void testGetMetaModel__Resource() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load metamodel
		final Resource portsRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Ports.ecore", true), true);
		final Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		metaModel.setResource(portsRes);
		env.registerMetaModel("PORTS", metaModel);

		final Metamodel mm = env.getMetaModel(portsRes);

		assertNotNull(mm);
		assertEquals(metaModel, mm);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#loadModule(org.eclipse.m2m.atl.emftvm.util.ModuleResolver, java.lang.String) <em>Load Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#loadModule(org.eclipse.m2m.atl.emftvm.util.ModuleResolver, java.lang.String)
	 * @generated NOT
	 */
	public void testLoadModule__ModuleResolver_String() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		assertEquals(1, env.getModules().size());
		assertTrue(env.getModules().containsKey("OCL"));

		// Load module
		final ModuleResolver mr = new DefaultModuleResolver(PLUGIN_URI + "/test-data/", rs);
		final Module testLib = env.loadModule(mr, "TestLib");

		assertEquals(2, env.getModules().size());
		assertTrue(env.getModules().containsKey("TestLib"));
		assertEquals(testLib, env.getModules().get("TestLib"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object[]) <em>Find Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object[])
	 * @generated NOT
	 */
	public void testFindOperation__Object_String_Object() {
		final ExecEnv env = getFixture();

		// Find OclAny::oclAsType(ECORE!EClassifier)
		final Operation op = env.findOperation(
				NativeType.OBJECT.getType(), "oclAsType", new Object[]{EcorePackage.eINSTANCE.getEClass()});
		assertNotNull(op);
		assertEquals(Object.class, op.getEType().getInstanceClass());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String) <em>Find Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String)
	 * @generated NOT
	 */
	public void testFindOperation__Object_String() {
		final Operation op = getFixture().findOperation(NativeType.OBJECT.getType(), "oclType");
		assertNotNull(op);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object) <em>Find Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object)
	 * @generated NOT
	 */
	public void testFindOperation__Object_String_Object_1() {
		final Operation op = getFixture().findOperation(
				NativeType.OBJECT.getType(), "oclAsType", EcorePackage.eINSTANCE.getEClass());
		assertNotNull(op);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#hasOperation(java.lang.String, int) <em>Has Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#hasOperation(java.lang.String, int)
	 * @generated NOT
	 */
	public void testHasOperation__String_int() {
		assertTrue(getFixture().hasOperation("oclAsType", 1));
		assertFalse(getFixture().hasOperation("oclAsType", 2));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object[]) <em>Find Static Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object[])
	 * @generated NOT
	 */
	public void testFindStaticOperation__Object_String_Object() {
		final ExecEnv env = getFixture();

		// Find static EMFTVM!ExecEnv::resolveTemp(OclAny, String) : OclAny
		final Operation op = env.findStaticOperation(
				EmftvmPackage.eINSTANCE.getExecEnv(), "resolveTemp", new Object[]{Object.class, String.class});
		assertNotNull(op);
		assertEquals(Object.class, op.getEType().getInstanceClass());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String) <em>Find Static Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String)
	 * @generated NOT
	 */
	public void testFindStaticOperation__Object_String() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		// Create and register operation
		final Operation op = EMFTVMUtil.createOperation(true, "test", Types.EXEC_ENV_TYPE, Types.OCL_ANY_TYPE, 
				new String[][][]{}, new NativeCodeBlock());
		final Module module = EmftvmFactory.eINSTANCE.createModule();
		module.setName("testmodule");
		module.getFeatures().add(op);
		env.loadModule(new ModuleResolver() {
			public Module resolveModule(String name) throws ModuleNotFoundException {
				return module;
			}
		}, "testmodule");

		final Operation test = env.findStaticOperation(EmftvmPackage.eINSTANCE.getExecEnv(), "test");
		assertNotNull(test);
		assertEquals(op, test);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object) <em>Find Static Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object)
	 * @generated NOT
	 */
	public void testFindStaticOperation__Object_String_Object_1() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		// Create and register operation
		final Operation op = EMFTVMUtil.createOperation(true, "test", Types.EXEC_ENV_TYPE, Types.OCL_ANY_TYPE, 
				new String[][][]{{{"var"}, Types.OCL_ANY_TYPE}}, new NativeCodeBlock());
		final Module module = EmftvmFactory.eINSTANCE.createModule();
		module.setName("testmodule");
		module.getFeatures().add(op);
		env.loadModule(new ModuleResolver() {
			public Module resolveModule(String name) throws ModuleNotFoundException {
				return module;
			}
		}, "testmodule");

		final Operation test = env.findStaticOperation(EmftvmPackage.eINSTANCE.getExecEnv(), "test", NativeType.OBJECT.getType());
		assertNotNull(test);
		assertEquals(op, test);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#hasStaticOperation(java.lang.String, int) <em>Has Static Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#hasStaticOperation(java.lang.String, int)
	 * @generated NOT
	 */
	public void testHasStaticOperation__String_int() {
		assertTrue(getFixture().hasStaticOperation("resolveTemp", 2));
		assertFalse(getFixture().hasStaticOperation("resolveTemp", 1));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findField(java.lang.Object, java.lang.String) <em>Find Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findField(java.lang.Object, java.lang.String)
	 * @generated NOT
	 */
	public void testFindField__Object_String() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		final Field f = EmftvmFactory.eINSTANCE.createField();
		f.setName("field");
		f.setContextModel("EMFTVM");
		f.setContext("ExecEnv");
		f.setTypeModel(EMFTVMUtil.NATIVE);
		f.setType("Sequence");

		final Module m = EmftvmFactory.eINSTANCE.createModule();
		m.setName("test");
		m.getFeatures().add(f);

		assertNull(env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "field"));

		env.loadModule(new ModuleResolver() {
			public Module resolveModule(String name) throws ModuleNotFoundException {
				return m;
			}
		}, "test");

		assertEquals(f, env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "field"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#hasField(java.lang.String) <em>Has Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#hasField(java.lang.String)
	 * @generated NOT
	 */
	public void testHasField__String() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		final Field f = EmftvmFactory.eINSTANCE.createField();
		f.setName("field");
		f.setContextModel("EMFTVM");
		f.setContext("ExecEnv");
		f.setTypeModel(EMFTVMUtil.NATIVE);
		f.setType("Sequence");

		final Module m = EmftvmFactory.eINSTANCE.createModule();
		m.setName("test");
		m.getFeatures().add(f);

		assertNull(env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "field"));

		env.loadModule(new ModuleResolver() {
			public Module resolveModule(String name) throws ModuleNotFoundException {
				return m;
			}
		}, "test");

		assertTrue(env.hasField("field"));
		assertFalse(env.hasField("nonfield"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticField(java.lang.Object, java.lang.String)
	 * @generated NOT
	 */
	public void testFindStaticField__Object_String() {
		final ExecEnv env = getFixture();

		// Find static EMFTVM!ExecEnv::traces : TRACE!TraceLinkSet
		final Field f = env.findStaticField(EmftvmPackage.eINSTANCE.getExecEnv(), "traces");
		assertNotNull(f);
		assertEquals(TracePackage.eINSTANCE.getTraceLinkSet(), f.getEType());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#hasStaticField(java.lang.String) <em>Has Static Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#hasStaticField(java.lang.String)
	 * @generated NOT
	 */
	public void testHasStaticField__String() {
		final ExecEnv env = getFixture();

		// Find static EMFTVM!ExecEnv::traces : TRACE!TraceLinkSet
		assertTrue(env.hasStaticField("traces"));
		assertFalse(env.hasStaticField("nontraces"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findRule(java.lang.String) <em>Find Rule</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findRule(java.lang.String)
	 * @generated NOT
	 */
	public void testFindRule__String() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		final Rule r = EmftvmFactory.eINSTANCE.createRule();
		r.setName("rule");

		final Module m = EmftvmFactory.eINSTANCE.createModule();
		m.setName("test");
		m.getRules().add(r);

		assertNull(env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "rule"));

		env.loadModule(new ModuleResolver() {
			public Module resolveModule(String name) throws ModuleNotFoundException {
				return m;
			}
		}, "test");

		assertEquals(r, env.findRule("rule"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findType(java.lang.String, java.lang.String) <em>Find Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findType(java.lang.String, java.lang.String)
	 * @generated NOT
	 */
	public void testFindType__String_String() {
		final ExecEnv env = getFixture();

		// Find EMFTVM!ExecEnv
		try {
			final Object type = env.findType("EMFTVM", "ExecEnv");
			assertEquals(EmftvmPackage.eINSTANCE.getExecEnv(), type);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData) <em>Run</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws InterruptedException 
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData)
	 * @generated NOT
	 */
	public void testRun__TimingData() throws InterruptedException {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		{
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(COMPILER_PLUGIN_ID + "/transformations/ATLtoEMFTVM.atl", true), true);
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
		pbmm.setResource(rs.getResource(URI.createPlatformPluginURI(COMPILER_PLUGIN_ID + "/metamodels/Problem.ecore", true), true));
		env.registerMetaModel("Problem", pbmm);
		}

		// Load and run module
		{
		final ModuleResolver mr = new DefaultModuleResolver(COMPILER_PLUGIN_URI + "/transformations/", rs);
		final TimingData td = new TimingData();
		env.loadModule(mr, "ATLtoEMFTVM");
		td.finishLoading();
		env.run(td);
		td.finish();
		System.out.print(td.toString());
		}

		// Create another output model, and run the transformation again
		final Resource outRes2 = rs.createResource(URI.createFileURI("out2.xmi"));
		final Model outModel2 = EmftvmFactory.eINSTANCE.createModel();
		outModel2.setResource(outRes2);
		env.registerOutputModel("OUT", outModel2);
		assertEquals(outModel2, env.getOutputModels().get("OUT"));

		final Resource pbsRes2 = rs.createResource(URI.createFileURI("pbs2.xmi"));
		final Model pbsModel2 = EmftvmFactory.eINSTANCE.createModel();
		pbsModel2.setResource(pbsRes2);
		env.registerOutputModel("PBS", pbsModel2);
		assertEquals(pbsModel2, env.getOutputModels().get("PBS"));

		{
		final TimingData td2 = new TimingData();
		td2.finishLoading();
		env.run(td2);
		td2.finish();
		System.out.print(td2.toString());
		}
		
		// Compare results
		assertEquals(outRes, outRes2);
		assertEquals(pbsRes, pbsRes2);
		
		// Run once more
		outRes2.getContents().clear();
		pbsRes2.getContents().clear();

		{
		final TimingData td2 = new TimingData();
		td2.finishLoading();
		env.run(td2);
		td2.finish();
		System.out.print(td2.toString());
		}
		
		// Compare results
		assertEquals(outRes, outRes2);
		assertEquals(pbsRes, pbsRes2);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getRules() <em>Get Rules</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getRules()
	 * @generated NOT
	 */
	public void testGetRules() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		final Rule r = EmftvmFactory.eINSTANCE.createRule();
		r.setName("rule");

		final Module m = EmftvmFactory.eINSTANCE.createModule();
		m.setName("test");
		m.getRules().add(r);

		assertTrue(env.getRules().isEmpty());

		env.loadModule(new ModuleResolver() {
			public Module resolveModule(String name) throws ModuleNotFoundException {
				return m;
			}
		}, "test");

		assertFalse(env.getRules().isEmpty());
		assertEquals(r, env.getRules().get(0));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModelOf(org.eclipse.emf.ecore.EObject) <em>Get Model Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getModelOf(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public void testGetModelOf__EObject() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInputModel("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		
		// Get an object, and retrieve its model
		final EObject object = inRes.getContents().get(0);
		final Model model = env.getModelOf(object);

		assertNotNull(model);
		assertEquals(inModel, model);
		
		assertNull(env.getModelOf(env));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModelID(org.eclipse.m2m.atl.emftvm.Model) <em>Get Model ID</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getModelID(org.eclipse.m2m.atl.emftvm.Model)
	 * @generated NOT
	 */
	public void testGetModelID__Model() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInputModel("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		
		final String modelID = env.getModelID(inModel);

		assertNotNull(modelID);
		assertEquals("IN", modelID);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModelID(org.eclipse.m2m.atl.emftvm.Metamodel) <em>Get Meta Model ID</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModelID(org.eclipse.m2m.atl.emftvm.Metamodel)
	 * @generated NOT
	 */
	public void testGetMetaModelID__Metamodel() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load metamodel
		final Resource portsRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Ports.ecore", true), true);
		final Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		metaModel.setResource(portsRes);
		env.registerMetaModel("PORTS", metaModel);

		final String id = env.getMetaModelID(metaModel);

		assertNotNull(id);
		assertEquals("PORTS", id);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForDelete(org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Delete</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForDelete(org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueForDelete__EObject_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInputModel("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		
		// Create output element
		final EObject element = outModel.newElement(EmftvmPackage.eINSTANCE.getModule());
		
		assertFalse(outRes.getContents().isEmpty());
		assertEquals(element, outRes.getContents().get(0));
		
		env.queueForDelete(element, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		
		assertFalse(outRes.getContents().isEmpty());
		
		env.deleteQueue();
		
		assertTrue(outRes.getContents().isEmpty());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#deleteQueue() <em>Delete Queue</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#deleteQueue()
	 * @generated NOT
	 */
	public void testDeleteQueue() {
		// already tested in testQueueForDelete__EObject_StackFrame
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModelOf(org.eclipse.emf.ecore.EObject) <em>Get Input Model Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModelOf(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public void testGetInputModelOf__EObject() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInputModel("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		
		// Get an object, and retrieve its model
		final EObject object = inRes.getContents().get(0);
		final Model model = env.getInputModelOf(object);

		assertNotNull(model);
		assertEquals(inModel, model);
		
		assertNull(env.getInputModelOf(env));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModelOf(org.eclipse.emf.ecore.EObject) <em>Get Inout Model Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModelOf(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public void testGetInoutModelOf__EObject() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		
		// Get an object, and retrieve its model
		final EObject object = inRes.getContents().get(0);
		final Model model = env.getInoutModelOf(object);

		assertNotNull(model);
		assertEquals(inModel, model);
		
		assertNull(env.getInoutModelOf(env));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModelOf(org.eclipse.emf.ecore.EObject) <em>Get Output Model Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModelOf(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public void testGetOutputModelOf__EObject() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInputModel("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		
		// Create output element, and retrieve its model
		final EObject element = outModel.newElement(EmftvmPackage.eINSTANCE.getModule());
		final Model model = env.getOutputModelOf(element);

		assertNotNull(model);
		assertEquals(outModel, model);
		
		assertNull(env.getOutputModelOf(env));
	}

} //ExecEnvTest
