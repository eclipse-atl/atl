/**
 * (C) 2011 Dennis Wagelaar, Vrije Universiteit Brussel
 */
package org.eclipse.m2m.atl.emftvm.tests;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.GetSuper;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.Opcode;

import junit.textui.TestRunner;

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
	public static void main(final String[] args) {
		TestRunner.run(GetSuperTest.class);
	}

	/**
	 * Constructs a new Get Super test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetSuperTest(final String name) {
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

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Instruction#getOpcode()
	 * <em>Opcode</em>}' feature getter. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getOpcode()
	 * @generated NOT
	 */
	@Override
	public void testGetOpcode() {
		final Instruction fixture = this.getFixture();
		assertEquals(Opcode.GET_SUPER, fixture.getOpcode());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackProduction()
	 * <em>Stack Production</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getStackProduction()
	 * @generated NOT
	 */
	@Override
	public void testGetStackProduction() {
		final Instruction fixture = this.getFixture();
		assertEquals(1, fixture.getStackProduction());
	}

	/**
	 * Tests the
	 * '{@link org.eclipse.m2m.atl.emftvm.Instruction#getStackConsumption()
	 * <em>Stack Consumption</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see org.eclipse.m2m.atl.emftvm.Instruction#getStackConsumption()
	 * @generated NOT
	 */
	@Override
	public void testGetStackConsumption() {
		final Instruction fixture = this.getFixture();
		assertEquals(1, fixture.getStackConsumption());
	}

} //GetSuperTest
