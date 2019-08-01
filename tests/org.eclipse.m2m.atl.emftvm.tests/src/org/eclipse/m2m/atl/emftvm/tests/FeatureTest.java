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

import org.eclipse.m2m.atl.emftvm.Feature;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Feature</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Feature#getEContext() <em>EContext</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class FeatureTest extends TypedElementTest {

	/**
	 * Constructs a new Feature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Feature getFixture() {
		return (Feature)fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Feature#getEContext() <em>EContext</em>}' feature getter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Feature#getEContext()
	 * @generated NOT
	 */
	public void testGetEContext() {
		final Feature feature = getFixture();
		assertNull(feature.getEContext());
	}

	/**
	 * Tests the '{@link org.eclipse.m2m.atl.emftvm.Feature#setEContext(org.eclipse.emf.ecore.EClassifier) <em>EContext</em>}' feature
	 * setter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.m2m.atl.emftvm.Feature#setEContext(org.eclipse.emf.ecore.EClassifier)
	 * @generated NOT
	 */
	public void testSetEContext() {
		final Feature feature = getFixture();
		feature.setEContext(feature.eClass());
		assertSame(feature.eClass(), feature.getEContext());
	}

} //FeatureTest
