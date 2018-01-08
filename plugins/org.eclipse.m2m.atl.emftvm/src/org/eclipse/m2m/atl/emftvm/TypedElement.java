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
package org.eclipse.m2m.atl.emftvm;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.TypedElement#getEType <em>EType</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.TypedElement#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.TypedElement#getTypeModel <em>Type Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface TypedElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EType</em>' reference.
	 * @see #setEType(EClassifier)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getTypedElement_EType()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	EClassifier getEType();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.TypedElement#getEType <em>EType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EType</em>' reference.
	 * @see #getEType()
	 * @generated
	 */
	void setEType(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getTypedElement_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.TypedElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Type Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Model</em>' attribute.
	 * @see #setTypeModel(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getTypedElement_TypeModel()
	 * @model
	 * @generated
	 */
	String getTypeModel();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.TypedElement#getTypeModel <em>Type Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Model</em>' attribute.
	 * @see #getTypeModel()
	 * @generated
	 */
	void setTypeModel(String value);

} // TypedElement
