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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMonitor() <em>Get Monitor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getMonitor()
	 * @generated
	 */
	public void testGetMonitor() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#loadModule(org.eclipse.m2m.atl.emftvm.util.ModuleResolver, java.lang.String) <em>Load Module</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#loadModule(org.eclipse.m2m.atl.emftvm.util.ModuleResolver, java.lang.String)
	 * @generated
	 */
	public void testLoadModule__ModuleResolver_String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerFeature(org.eclipse.m2m.atl.emftvm.Feature) <em>Register Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#registerFeature(org.eclipse.m2m.atl.emftvm.Feature)
	 * @generated
	 */
	public void testRegisterFeature__Feature() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#registerRule(org.eclipse.m2m.atl.emftvm.Rule) <em>Register Rule</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#registerRule(org.eclipse.m2m.atl.emftvm.Rule)
	 * @generated
	 */
	public void testRegisterRule__Rule() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object[]) <em>Find Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findOperation(java.lang.Object, java.lang.String, java.lang.Object[])
	 * @generated
	 */
	public void testFindOperation__Object_String_Object() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object[]) <em>Find Static Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticOperation(java.lang.Object, java.lang.String, java.lang.Object[])
	 * @generated
	 */
	public void testFindStaticOperation__Object_String_Object() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findField(java.lang.Object, java.lang.String) <em>Find Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findField(java.lang.Object, java.lang.String)
	 * @generated
	 */
	public void testFindField__Object_String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticField(java.lang.Object, java.lang.String) <em>Find Static Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findStaticField(java.lang.Object, java.lang.String)
	 * @generated
	 */
	public void testFindStaticField__Object_String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findRule(java.lang.String) <em>Find Rule</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findRule(java.lang.String)
	 * @generated
	 */
	public void testFindRule__String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#findType(java.lang.String, java.lang.String) <em>Find Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#findType(java.lang.String, java.lang.String)
	 * @generated
	 */
	public void testFindType__String_String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData, org.eclipse.m2m.atl.emftvm.util.VMMonitor) <em>Run</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#run(org.eclipse.m2m.atl.emftvm.util.TimingData, org.eclipse.m2m.atl.emftvm.util.VMMonitor)
	 * @generated NOT
	 */
	public void testRun__TimingData_VMMonitor() {
		final ExecEnv env = getFixture();
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
	 * @generated
	 */
	public void testGetRules() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModelOf(org.eclipse.emf.ecore.EObject) <em>Get Model Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getModelOf(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public void testGetModelOf__EObject() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModelID(org.eclipse.m2m.atl.emftvm.Model) <em>Get Model ID</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getModelID(org.eclipse.m2m.atl.emftvm.Model)
	 * @generated
	 */
	public void testGetModelID__Model() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#queueForDelete(org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame) <em>Queue For Delete</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#queueForDelete(org.eclipse.emf.ecore.EObject, org.eclipse.m2m.atl.emftvm.util.StackFrame)
	 * @generated
	 */
	public void testQueueForDelete__EObject_StackFrame() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#deleteQueue() <em>Delete Queue</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#deleteQueue()
	 * @generated
	 */
	public void testDeleteQueue() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModelOf(org.eclipse.emf.ecore.EObject) <em>Get Input Model Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModelOf(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public void testGetInputModelOf__EObject() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModelOf(org.eclipse.emf.ecore.EObject) <em>Get Inout Model Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModelOf(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public void testGetInoutModelOf__EObject() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModelOf(org.eclipse.emf.ecore.EObject) <em>Get Output Model Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModelOf(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public void testGetOutputModelOf__EObject() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //ExecEnvTest
