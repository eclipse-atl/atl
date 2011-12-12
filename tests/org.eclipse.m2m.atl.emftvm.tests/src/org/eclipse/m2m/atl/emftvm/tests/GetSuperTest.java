/**
 * (C) 2011 Dennis Wagelaar, Vrije Universiteit Brussel
 */
package org.eclipse.m2m.atl.emftvm.tests;

import junit.textui.TestRunner;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.GetSuper;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Get Super</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GetSuperTest extends FieldInstructionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GetSuperTest.class);
	}

	/**
	 * Constructs a new Get Super test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetSuperTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Get Super test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GetSuper getFixture() {
		return (GetSuper)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EmftvmFactory.eINSTANCE.createGetSuper());
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

} //GetSuperTest
