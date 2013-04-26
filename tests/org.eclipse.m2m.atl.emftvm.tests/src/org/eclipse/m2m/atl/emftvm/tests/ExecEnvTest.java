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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
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
import org.eclipse.m2m.atl.emftvm.util.VMException;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;


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
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#clearModels() <em>Clear Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModel(org.eclipse.emf.ecore.resource.Resource) <em>Get Meta Model</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForSet(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Set</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForSet(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Set</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForSet(org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue Xmi ID For Set</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForAdd(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Add</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForAdd(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Add</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForAdd(org.eclipse.emf.ecore.EObject, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue Xmi ID For Add</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemove(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Remove</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemove(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Remove</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForRemove(org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue Xmi ID For Remove</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#setQueue() <em>Set Queue</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemap(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Remap</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#remapQueue() <em>Remap Queue</em>}</li>
 * </ul>
 * </p>
 * @generated NOT
 */
public class ExecEnvTest extends EMFTVMTest {
	
	private static final Logger LOG = Logger.getLogger(ExecEnvTest.class.getName());

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

		// Load and register input model
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestLib.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInputModel("IN", inModel);
		assertTrue(env.getInputModels().containsKey("IN"));
		assertEquals(inModel, env.getInputModels().get("IN"));
		// Load and register in/out model
		final Resource inOutRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestLib.emftvm", true), true);
		final Model inOutModel = EmftvmFactory.eINSTANCE.createModel();
		inOutModel.setResource(inOutRes);
		env.registerInOutModel("INOUT", inOutModel);
		assertTrue(env.getInoutModels().containsKey("INOUT"));
		assertEquals(inOutModel, env.getInoutModels().get("INOUT"));
		// Create and register output model
		final Resource outRes = rs.createResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/out.xmi", true));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		assertTrue(env.getOutputModels().containsKey("OUT"));
		assertEquals(outModel, env.getOutputModels().get("OUT"));
		
		env.clearModels();
		assertFalse(env.getInputModels().containsKey("IN"));
		assertFalse(env.getInoutModels().containsKey("INOUT"));
		assertFalse(env.getOutputModels().containsKey("OUT"));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#clearModels() <em>Clear Models</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#clearModels()
	 * @generated NOT
	 */
	public void testClearModels() {
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForSet(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForSet(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueForSet__EStructuralFeature_EObject_Object_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);
		
		final CodeBlock element = (CodeBlock) inModel.allInstancesOf(EmftvmPackage.eINSTANCE.getCodeBlock()).first();

		env.queueForSet(EmftvmPackage.eINSTANCE.getCodeBlock_MaxLocals(), element, 2, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		
		assertFalse(element.getMaxLocals() == 2);
		
		env.setQueue();
		
		assertEquals(2, element.getMaxLocals());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForSet(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForSet(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueForSet__Field_Object_Object_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);
		
		// Load module with some fields
		env.loadModule(new DefaultModuleResolver(PLUGIN_URI + "/test-data/", rs), "TestQuery");
		
		final Operation element = (Operation) inModel.allInstancesOf(EmftvmPackage.eINSTANCE.getOperation()).first();
		final Field field = env.findField(element.eClass(), "testProp");

		env.queueForSet(field, element, Boolean.FALSE, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		
		assertNull(field.getValue(element));
		
		env.setQueue();
		
		assertEquals(Boolean.FALSE, field.getValue(element));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForSet(org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue Xmi ID For Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForSet(org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueXmiIDForSet__EObject_Object_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Ports.ecore", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);
		
		final EObject element = inModel.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).first();
		final String xmiID = "_a01";

		env.queueXmiIDForSet(element, xmiID, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		
		assertNull(((XMIResource)inRes).getID(element));
		
		env.setQueue();
		
		assertEquals(xmiID, ((XMIResource)inRes).getID(element));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForAdd(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForAdd(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueForAdd__EStructuralFeature_EObject_Object_int_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.createResource(URI.createURI("local.xmi"));
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);

		final CodeBlock element = EmftvmFactory.eINSTANCE.createCodeBlock();
		inRes.getContents().add(element);

		final LocalVariable lv = EmftvmFactory.eINSTANCE.createLocalVariable();
		inRes.getContents().add(lv);

		env.queueForAdd(EmftvmPackage.eINSTANCE.getCodeBlock_LocalVariables(), element, lv, -1,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		assertFalse(element.getLocalVariables().contains(lv));
		env.setQueue();
		assertEquals(0, element.getLocalVariables().indexOf(lv));

		final LocalVariable lv2 = EmftvmFactory.eINSTANCE.createLocalVariable();
		inRes.getContents().add(lv2);

		env.queueForAdd(EmftvmPackage.eINSTANCE.getCodeBlock_LocalVariables(), element, lv2, -1,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		env.setQueue();
		assertEquals(1, element.getLocalVariables().indexOf(lv2));

		final LocalVariable lv3 = EmftvmFactory.eINSTANCE.createLocalVariable();
		inRes.getContents().add(lv3);

		env.queueForAdd(EmftvmPackage.eINSTANCE.getCodeBlock_LocalVariables(), element, lv3, 0,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		env.setQueue();
		assertEquals(0, element.getLocalVariables().indexOf(lv3));
		assertEquals(1, element.getLocalVariables().indexOf(lv));
		assertEquals(2, element.getLocalVariables().indexOf(lv2));

		final LocalVariable lv4 = EmftvmFactory.eINSTANCE.createLocalVariable();
		inRes.getContents().add(lv4);

		env.queueForAdd(EmftvmPackage.eINSTANCE.getCodeBlock_LocalVariables(), element, lv4, 3,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		env.setQueue();
		assertEquals(3, element.getLocalVariables().indexOf(lv4));

		final LocalVariable lv5 = EmftvmFactory.eINSTANCE.createLocalVariable();
		inRes.getContents().add(lv5);

		env.queueForAdd(EmftvmPackage.eINSTANCE.getCodeBlock_LocalVariables(), element, lv5,
				element.getLocalVariables().size() + 1, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		try {
			env.setQueue();
			fail("Expected VMException");
		} catch (VMException e) {
			// expected
			assertTrue(e.getCause() instanceof IndexOutOfBoundsException);
		}

		env.queueForAdd(EmftvmPackage.eINSTANCE.getCodeBlock_MaxLocals(), element, 2, 0,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		try {
			env.setQueue();
			fail("Expected VMException");
		} catch (VMException e) {
			// expected
			assertTrue(e.getCause() instanceof IllegalArgumentException);
		}
	}

	/**
	 * Tests the '
	 * {@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForAdd(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * <em>Queue For Add</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForAdd(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, int,
	 *      org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueForAdd__Field_Object_Object_int_StackFrame() {
		{
			final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
			final ResourceSet rs = new ResourceSetImpl();

			// Load models
			final Resource portsRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Ports.ecore", true),
					true);
			final Metamodel portsModel = EmftvmFactory.eINSTANCE.createMetamodel();
			portsModel.setResource(portsRes);
			env.registerMetaModel("Ports", portsModel);
			final Resource pinsRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Pins.ecore", true),
					true);
			final Metamodel pinsModel = EmftvmFactory.eINSTANCE.createMetamodel();
			pinsModel.setResource(pinsRes);
			env.registerMetaModel("Pins", pinsModel);
			final Resource inRes = rs.createResource(URI.createURI("local.xmi"));
			final Model inModel = EmftvmFactory.eINSTANCE.createModel();
			inModel.setResource(inRes);
			env.registerInOutModel("IN", inModel);
			final Resource outRes = rs.createResource(URI.createURI("local2.xmi"));
			final Model outModel = EmftvmFactory.eINSTANCE.createModel();
			outModel.setResource(outRes);
			env.registerInOutModel("OUT", outModel);

			// Load module with some fields
			env.loadModule(new DefaultModuleResolver(PLUGIN_URI + "/test-data/PortsToPins/", rs), "PortsToPins");

			final EObject element = inModel.newElement((EClass) portsModel.findType("Port"));
			final Field field = env.findField(element.eClass(), "pins");
			field.setValue(element, new ArrayList<Object>());

			final EObject pin = outModel.newElement((EClass) pinsModel.findType("Pin"));
			assertNotNull(pin);
			env.queueForAdd(field, element, pin, -1, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
			assertTrue(field.getValue(element) instanceof List<?>);
			assertFalse(((List<?>) field.getValue(element)).contains(pin));
			env.setQueue();
			assertTrue(field.getValue(element) instanceof List<?>);
			assertTrue(((List<?>) field.getValue(element)).contains(pin));
		}

		{
			final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
			final ResourceSet rs = new ResourceSetImpl();

			// Load models
			final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
			final Model inModel = EmftvmFactory.eINSTANCE.createModel();
			inModel.setResource(inRes);
			env.registerInOutModel("IN", inModel);

			// Load module with some fields
			env.loadModule(new DefaultModuleResolver(PLUGIN_URI + "/test-data/", rs), "TestQuery");

			final Operation element = (Operation) inModel.allInstancesOf(EmftvmPackage.eINSTANCE.getOperation()).first();
			final Field field = env.findField(element.eClass(), "testProp");

			env.queueForAdd(field, element, Boolean.FALSE, -1, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
			assertNull(field.getValue(element));
			try {
				env.setQueue();
				fail("Expected VMException");
			} catch (VMException e) {
				// expected
				assertTrue(e.getCause() instanceof IllegalArgumentException);
				// field has been lazily initialised
				assertNotNull(field.getValue(element));
			}

			// force field value to null - lazy initialisation should not happen again
			field.setValue(element, null);
			env.queueForAdd(field, element, Boolean.FALSE, -1, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
			assertNull(field.getValue(element));
			env.setQueue();
			assertEquals(Boolean.FALSE, field.getValue(element));
		}
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForAdd(org.eclipse.emf.ecore.EObject, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue Xmi ID For Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForAdd(org.eclipse.emf.ecore.EObject, java.lang.Object, int, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueXmiIDForAdd__EObject_Object_int_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Ports.ecore", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);

		final EObject element = inModel.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).first();
		final String xmiID = "_a01";

		env.queueXmiIDForAdd(element, xmiID, -1, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));

		assertNull(((XMIResource) inRes).getID(element));

		env.setQueue();

		assertEquals(xmiID, ((XMIResource) inRes).getID(element));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemove(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Remove</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemove(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueForRemove__EStructuralFeature_EObject_Object_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.createResource(URI.createURI("local.xmi"));
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);

		final CodeBlock element = EmftvmFactory.eINSTANCE.createCodeBlock();
		inRes.getContents().add(element);
		final LocalVariable lv = EmftvmFactory.eINSTANCE.createLocalVariable();
		final LocalVariable lv2 = EmftvmFactory.eINSTANCE.createLocalVariable();
		final LocalVariable lv3 = EmftvmFactory.eINSTANCE.createLocalVariable();
		final LocalVariable lv4 = EmftvmFactory.eINSTANCE.createLocalVariable();
		element.getLocalVariables().add(lv);
		element.getLocalVariables().add(lv2);
		element.getLocalVariables().add(lv3);
		element.getLocalVariables().add(lv4);

		env.queueForRemove(EmftvmPackage.eINSTANCE.getCodeBlock_LocalVariables(), element, lv4,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		assertTrue(element.getLocalVariables().contains(lv4));
		env.setQueue();
		assertFalse(element.getLocalVariables().contains(lv4));

		env.queueForRemove(EmftvmPackage.eINSTANCE.getCodeBlock_LocalVariables(), element, lv,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		assertTrue(element.getLocalVariables().contains(lv));
		env.setQueue();
		assertFalse(element.getLocalVariables().contains(lv));
		assertEquals(0, element.getLocalVariables().indexOf(lv2));
		assertEquals(1, element.getLocalVariables().indexOf(lv3));

		final LocalVariable lv5 = EmftvmFactory.eINSTANCE.createLocalVariable();
		inRes.getContents().add(lv5);

		env.queueForRemove(EmftvmPackage.eINSTANCE.getCodeBlock_LocalVariables(), element, lv4,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		final EList<LocalVariable> copy = new BasicEList<LocalVariable>(element.getLocalVariables());
		env.setQueue();
		// Nothing should have changed after removing a non-existent element
		assertEquals(copy, element.getLocalVariables());

		final int origMaxLocals = element.getMaxLocals();
		element.setMaxLocals(10);
		env.queueForRemove(EmftvmPackage.eINSTANCE.getCodeBlock_MaxLocals(), element, 10,
				new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
		assertEquals(10, element.getMaxLocals());
		env.setQueue();
		assertEquals(origMaxLocals, element.getMaxLocals());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemove(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Remove</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemove(org.eclipse.m2m.atl.emftvm.Field, java.lang.Object, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueForRemove__Field_Object_Object_StackFrame() {
		{
			final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
			final ResourceSet rs = new ResourceSetImpl();

			// Load models
			final Resource portsRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Ports.ecore", true),
					true);
			final Metamodel portsModel = EmftvmFactory.eINSTANCE.createMetamodel();
			portsModel.setResource(portsRes);
			env.registerMetaModel("Ports", portsModel);
			final Resource pinsRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Pins.ecore", true),
					true);
			final Metamodel pinsModel = EmftvmFactory.eINSTANCE.createMetamodel();
			pinsModel.setResource(pinsRes);
			env.registerMetaModel("Pins", pinsModel);
			final Resource inRes = rs.createResource(URI.createURI("local.xmi"));
			final Model inModel = EmftvmFactory.eINSTANCE.createModel();
			inModel.setResource(inRes);
			env.registerInOutModel("IN", inModel);
			final Resource outRes = rs.createResource(URI.createURI("local2.xmi"));
			final Model outModel = EmftvmFactory.eINSTANCE.createModel();
			outModel.setResource(outRes);
			env.registerInOutModel("OUT", outModel);

			// Load module with some fields
			env.loadModule(new DefaultModuleResolver(PLUGIN_URI + "/test-data/PortsToPins/", rs), "PortsToPins");

			final EObject element = inModel.newElement((EClass) portsModel.findType("Port"));
			final Field field = env.findField(element.eClass(), "pins");
			field.setValue(element, new ArrayList<Object>());

			final EObject pin = outModel.newElement((EClass) pinsModel.findType("Pin"));
			assertNotNull(pin);
			field.addValue(element, pin, -1, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));

			env.queueForRemove(field, element, pin, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
			assertTrue(field.getValue(element) instanceof List<?>);
			assertTrue(((List<?>) field.getValue(element)).contains(pin));
			env.setQueue();
			assertTrue(field.getValue(element) instanceof List<?>);
			assertFalse(((List<?>) field.getValue(element)).contains(pin));

			final List<Object> copy = new ArrayList<Object>((List<?>) field.getValue(element));
			env.queueForRemove(field, element, pin, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
			env.setQueue();
			assertEquals(copy, field.getValue(element));
		}

		{
			final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
			final ResourceSet rs = new ResourceSetImpl();

			// Load models
			final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
			final Model inModel = EmftvmFactory.eINSTANCE.createModel();
			inModel.setResource(inRes);
			env.registerInOutModel("IN", inModel);

			// Load module with some fields
			env.loadModule(new DefaultModuleResolver(PLUGIN_URI + "/test-data/", rs), "TestQuery");

			final Operation element = (Operation) inModel.allInstancesOf(EmftvmPackage.eINSTANCE.getOperation()).first();
			final Field field = env.findField(element.eClass(), "testProp");

			final Object origVal = field.getValue(element, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
			assertNotNull(origVal);
			env.queueForRemove(field, element, origVal, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
			assertEquals(origVal, field.getValue(element));
			env.setQueue();
			assertNull(field.getValue(element));

			// force field value to null - lazy initialisation should not happen again
			field.setValue(element, null);
			env.queueForRemove(field, element, Boolean.FALSE, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));
			assertNull(field.getValue(element));
			env.setQueue();
			assertNull(field.getValue(element));
		}
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForRemove(org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue Xmi ID For Remove</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueXmiIDForRemove(org.eclipse.emf.ecore.EObject, java.lang.Object, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueXmiIDForRemove__EObject_Object_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/PortsToPins/Ports.ecore", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);

		final EObject element = inModel.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).first();
		final String xmiID = "_a01";
		((XMIResource) inRes).setID(element, xmiID);

		env.queueXmiIDForRemove(element, xmiID, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));

		assertEquals(xmiID, ((XMIResource) inRes).getID(element));

		env.setQueue();

		assertNull(((XMIResource) inRes).getID(element));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#setQueue() <em>Set Queue</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#setQueue()
	 * @generated NOT
	 */
	public void testSetQueue() {
		// already tested in testQueueForSet__*
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemap(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Remap</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForRemap(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated NOT
	 */
	public void testQueueForRemap__EObject_EObject_StackFrame() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/TestQuery.emftvm", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInOutModel("IN", inModel);

		final CodeBlock element = (CodeBlock) inModel.allInstancesOf(EmftvmPackage.eINSTANCE.getCodeBlock()).first();
		final EList<Instruction> code = new BasicEList<Instruction>(element.getCode());
		final EObject container = element.eContainer();
		final CodeBlock target = EmftvmFactory.eINSTANCE.createCodeBlock();
		target.getCode().addAll(element.getCode());
		inRes.getContents().add(target);

		env.queueForRemap(element, target, new StackFrame(env, EmftvmFactory.eINSTANCE.createCodeBlock()));

		assertNull(target.eContainer());

		env.remapQueue();

		assertEquals(code, target.getCode());
		assertEquals(container, target.eContainer());
		assertTrue(element.getCode().isEmpty());
		assertNull(element.eContainer());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#remapQueue() <em>Remap Queue</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#remapQueue()
	 * @generated NOT
	 */
	public void testRemapQueue() {
		// Already tested in testQueueForRemap__EObject_EObject_StackFrame
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
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData)
	 * @generated NOT
	 */
	public void testRun__TimingData() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		{
		final Resource inRes = rs.getResource(
				URI.createURI("../../plugins/" + COMPILER_PLUGIN_ID + "/transformations/ATLtoEMFTVM.atl", true), true);
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
		pbmm.setResource(rs.getResource(URI.createPlatformPluginURI(COMMON_PLUGIN_ID + "/org/eclipse/m2m/atl/common/resources/Problem.ecore", true), true));
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
		LOG.info("ExecEnvText#testRun__TimingData " + td.toString());
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
		LOG.info("ExecEnvText#testRun__TimingData 2nd run " + td2.toString());
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
		LOG.info("ExecEnvText#testRun__TimingData 3rd run " + td2.toString());
		}
		
		// Compare results
		assertEquals(outRes, outRes2);
		assertEquals(pbsRes, pbsRes2);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData) <em>Run</em>}' operation. <!--
	 * begin-user-doc --> Refining mode test. <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData)
	 * @generated NOT
	 */
	public void testRun__RefiningMode() {
		final ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		final ResourceSet rs = new ResourceSetImpl();

		// Load models
		final Resource inRes = rs.getResource(
				URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/RefiningModeTest/EMFTVMCopy.trace", true), true);
		final Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(inRes);
		env.registerInputModel("IN", inModel);

		final Resource inoutRes = rs.getResource(
				URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/RefiningModeTest/RefiningModeTest.emftvm", true), true);
		final Model inoutModel = EmftvmFactory.eINSTANCE.createModel();
		inoutModel.setResource(inoutRes);
		env.registerInOutModel("INOUT", inoutModel);

		final Resource outRes = rs.createResource(URI.createFileURI("RefiningModeTest.ecore"));
		final Model outModel = EmftvmFactory.eINSTANCE.createModel();
		outModel.setResource(outRes);
		env.registerOutputModel("OUT", outModel);
		assertEquals(outModel, env.getOutputModels().get("OUT"));

		// Load and run module
		{
			final ModuleResolver mr = new DefaultModuleResolver(PLUGIN_URI + "/test-data/RefiningModeTest/", new ResourceSetImpl());
			final TimingData td = new TimingData();
			env.loadModule(mr, "RefiningModeTest");
			td.finishLoading();
			env.run(td);
			td.finish();
			LOG.info("ExecEnvText#testRun__RefiningMode " + td.toString());
		}

		// Load reference models
		final Resource refInoutRes = rs.getResource(
				URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/RefiningModeTest/RefiningModeTest-copy.emftvm", true), true);
		final Resource refOutRes = rs.getResource(
				URI.createPlatformPluginURI(PLUGIN_ID + "/test-data/RefiningModeTest/RefiningModeTest.ecore", true), true);

		// Compare results
		assertEquals(refOutRes, outRes);
		assertEquals(refInoutRes, inoutRes);
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getRules() <em>Get Rules</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
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
