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

import org.eclipse.m2m.atl.emftvm.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Typed Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.TypedElement#getEType() <em>EType</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class TypedElementTest extends NamedElementTest {

	/**
	 * Constructs a new Typed Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Typed Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TypedElement getFixture() {
		return (TypedElement)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.TypedElement#getEType() <em>EType</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.TypedElement#getEType()
	 * @generated NOT
	 */
	public void testGetEType() {
		final TypedElement typedElement = getFixture();
		assertNull(typedElement.getEType());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.TypedElement#setEType(org.eclipse.emf.ecore.EClassifier) <em>EType</em>}' feature
	 * setter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.TypedElement#setEType(org.eclipse.emf.ecore.EClassifier)
	 * @generated NOT
	 */
	public void testSetEType() {
		final TypedElement typedElement = getFixture();
		typedElement.setEType(typedElement.eClass());
		assertSame(typedElement.eClass(), typedElement.getEType());
	}

} //TypedElementTest
