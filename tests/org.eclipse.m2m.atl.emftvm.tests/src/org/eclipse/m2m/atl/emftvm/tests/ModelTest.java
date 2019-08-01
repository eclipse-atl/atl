/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Model#getResource() <em>Resource</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Model#allInstancesOf(org.eclipse.emf.ecore.EClass) <em>All Instances Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Model#newElement(org.eclipse.emf.ecore.EClass) <em>New Element</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Model#deleteElement(org.eclipse.emf.ecore.EObject) <em>Delete Element</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ModelTest extends TestCase {

	/**
	 * The fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Model fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModelTest.class);
	}

	/**
	 * Constructs a new Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Model fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Model getFixture() {
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
		setFixture(EmftvmFactory.eINSTANCE.createModel());
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
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Model#getResource() <em>Resource</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Model#getResource()
	 * @generated NOT
	 */
	public void testGetResource() {
		final Model model = getFixture();
		assertNull(model.getResource());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Model#setResource(org.eclipse.emf.ecore.resource.Resource) <em>Resource</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Model#setResource(org.eclipse.emf.ecore.resource.Resource)
	 * @generated NOT
	 */
	public void testSetResource() {
		final Model model = getFixture();
		final Resource res = new ResourceImpl();
		model.setResource(res);
		assertSame(res, model.getResource());
		model.setResource(null);
		assertNull(model.getResource());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Model#allInstancesOf(org.eclipse.emf.ecore.EClass) <em>All Instances Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Model#allInstancesOf(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	public void testAllInstancesOf__EClass() {
		final Model model = getFixture();
		model.setResource(EmftvmPackage.eINSTANCE.eResource());
		assertEquals(1, model.allInstancesOf(EcorePackage.eINSTANCE.getEPackage()).size());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Model#newElement(org.eclipse.emf.ecore.EClass) <em>New Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Model#newElement(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	public void testNewElement__EClass() {
		final Model model = getFixture();
		final Resource res = new ResourceImpl();
		model.setResource(res);
		final EObject module = model.newElement(EmftvmPackage.eINSTANCE.getModule());

		assertTrue(module instanceof Module);
		assertEquals(1, model.allInstancesOf(EmftvmPackage.eINSTANCE.getModule()).size());
		assertEquals(module, model.allInstancesOf(EmftvmPackage.eINSTANCE.getModule()).first());
		assertEquals(1, model.allInstancesOf(EmftvmPackage.eINSTANCE.getNamedElement()).size());

		final EObject module2 = model.newElement(EmftvmPackage.eINSTANCE.getModule());

		assertTrue(module2 instanceof Module);
		assertEquals(2, model.allInstancesOf(EmftvmPackage.eINSTANCE.getModule()).size());
		assertEquals(2, model.allInstancesOf(EmftvmPackage.eINSTANCE.getNamedElement()).size());
		assertEquals(module2, model.allInstancesOf(EmftvmPackage.eINSTANCE.getModule()).get(1));
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Model#deleteElement(org.eclipse.emf.ecore.EObject) <em>Delete Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.Model#deleteElement(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	public void testDeleteElement__EObject() {
		final Model model = getFixture();
		final Resource res = new ResourceImpl();
		final EPackage container = EcoreFactory.eINSTANCE.createEPackage();
		final EClass object = EcoreFactory.eINSTANCE.createEClass();
		final EClass object2 = EcoreFactory.eINSTANCE.createEClass();
		container.getEClassifiers().add(object);
		container.getEClassifiers().add(object2);
		res.getContents().add(container);
		model.setResource(res);

		assertEquals(1, model.allInstancesOf(EcorePackage.eINSTANCE.getEPackage()).size());
		assertEquals(2, model.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).size());
		assertEquals(3, model.allInstancesOf(EcorePackage.eINSTANCE.getENamedElement()).size());
		assertEquals(container, model.allInstancesOf(EcorePackage.eINSTANCE.getEPackage()).first());
		assertEquals(object, model.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).first());
		assertEquals(object2, model.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).get(1));

		model.deleteElement(container);

		assertTrue(model.allInstancesOf(EcorePackage.eINSTANCE.getEPackage()).isEmpty());
		assertEquals(2, model.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).size());
		assertEquals(object, model.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).first());
		assertEquals(object2, model.allInstancesOf(EcorePackage.eINSTANCE.getEClass()).get(1));
		assertEquals(2, model.allInstancesOf(EcorePackage.eINSTANCE.getENamedElement()).size());
	}

} //ModelTest
