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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.trace.TracePackage;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;
import org.osgi.framework.Bundle;


/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exec Env</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#loadModule(org.eclipse.m2m.atl.emftvm.util.ModuleResolver, java.lang.String) <em>Load Module</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerFeature(org.eclipse.m2m.atl.emftvm.Feature) <em>Register Feature</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerRule(org.eclipse.m2m.atl.emftvm.Rule) <em>Register Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object[]) <em>Find Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object[]) <em>Find Static Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findField(java.lang.Object, java.lang.String) <em>Find Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findRule(java.lang.String) <em>Find Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findType(java.lang.String, java.lang.String) <em>Find Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData, org.eclipse.m2m.atl.emftvm.util.VMMonitor) <em>Run</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getRules() <em>Get Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModelOf(org.eclipse.emf.ecore.EObject) <em>Get Model Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModelID(org.eclipse.m2m.atl.emftvm.Model) <em>Get Model ID</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForDelete(org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Delete</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#deleteQueue() <em>Delete Queue</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModelOf(org.eclipse.emf.ecore.EObject) <em>Get Input Model Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModelOf(org.eclipse.emf.ecore.EObject) <em>Get Inout Model Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModelOf(org.eclipse.emf.ecore.EObject) <em>Get Output Model Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMonitor() <em>Get Monitor</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ExecEnvTest extends TestCase {

	public static final String PLUGIN_ID = "org.eclipse.m2m.atl.emftvm.tests";
	public static final String PLUGIN_URI = "platform:/plugin/" + PLUGIN_ID;

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
		env.run(null, mon);
		assertNull(env.getMonitor());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerFeature(org.eclipse.m2m.atl.emftvm.Feature) <em>Register Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#registerFeature(org.eclipse.m2m.atl.emftvm.Feature)
	 * @generated NOT
	 */
	public void testRegisterFeature__Feature() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		final Field f = EmftvmFactory.eINSTANCE.createField();
		f.setName("field");
		f.setContextModel("EMFTVM");
		f.setContext("ExecEnv");
		f.setTypeModel(EMFTVMUtil.NATIVE);
		f.setType("Sequence");

		assertNull(env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "field"));

		env.registerFeature(f);

		assertEquals(f, env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "field"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerRule(org.eclipse.m2m.atl.emftvm.Rule) <em>Register Rule</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#registerRule(org.eclipse.m2m.atl.emftvm.Rule)
	 * @generated NOT
	 */
	public void testRegisterRule__Rule() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();

		//TODO test for rule redefinition checks
		final Rule r = EmftvmFactory.eINSTANCE.createRule();
		r.setName("rule");

		assertNull(env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "rule"));

		env.registerRule(r);

		assertEquals(r, env.findRule("rule"));
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
				Object.class, "oclAsType", new Object[]{EcorePackage.eINSTANCE.getEClass()});
		assertNotNull(op);
		assertEquals(Object.class, op.getEType().getInstanceClass());
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

		assertNull(env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "field"));

		env.registerFeature(f);

		assertEquals(f, env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "field"));
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

		assertNull(env.findField(EmftvmPackage.eINSTANCE.getExecEnv(), "rule"));

		env.registerRule(r);

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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData, org.eclipse.m2m.atl.emftvm.util.VMMonitor) <em>Run</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData, org.eclipse.m2m.atl.emftvm.util.VMMonitor)
	 * @generated NOT
	 */
	public void testRun__TimingData_VMMonitor() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/ATLtoEMFTVM.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.getInputModels().put("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.getOutputModels().put("OUT", outModel);

		// Load and run module
		final ModuleResolver mr = new DefaultModuleResolver(PLUGIN_URI + "/test-data/", rs);
		final TimingData td = new TimingData();
		env.loadModule(mr, "EMFTVMCopy");
		td.finishLoading();
		env.run(td, null);
		td.finish();
		System.out.print(td.toString());
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

		assertTrue(env.getRules().isEmpty());

		env.registerRule(r);

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
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/ATLtoEMFTVM.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.getInputModels().put("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.getOutputModels().put("OUT", outModel);
		
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
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/ATLtoEMFTVM.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.getInputModels().put("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.getOutputModels().put("OUT", outModel);
		
		final String modelID = env.getModelID(inModel);

		assertNotNull(modelID);
		assertEquals("IN", modelID);
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
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/ATLtoEMFTVM.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.getInputModels().put("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.getOutputModels().put("OUT", outModel);
		
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
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/ATLtoEMFTVM.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.getInputModels().put("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.getOutputModels().put("OUT", outModel);
		
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
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/ATLtoEMFTVM.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.getInoutModels().put("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.getOutputModels().put("OUT", outModel);
		
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
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/ATLtoEMFTVM.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.getInputModels().put("IN", inModel);

		final Resource outRes = rs.createResource(URI.createFileURI("out.xmi"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.getOutputModels().put("OUT", outModel);
		
		// Create output element, and retrieve its model
		final EObject element = outModel.newElement(EmftvmPackage.eINSTANCE.getModule());
		final Model model = env.getOutputModelOf(element);

		assertNotNull(model);
		assertEquals(outModel, model);
		
		assertNull(env.getOutputModelOf(env));
	}

} //ExecEnvTest
