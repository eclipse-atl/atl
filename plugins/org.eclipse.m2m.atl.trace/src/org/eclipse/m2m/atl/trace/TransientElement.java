/**
 * Copyright (C) 2009, Vrije Universiteit Brussel, Universidad de los Andes
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Andres Yie (Vrije Universiteit Brussel, Universidad de los Andes)
 * 	Dennis Wagelaar (Vrije Universiteit Brussel)
 *
 * $Id: TransientElement.java,v 1.1.2.1 2009/03/12 09:38:58 dwagelaar Exp $
 */
package org.eclipse.m2m.atl.trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transient Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.trace.TransientElement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.trace.TransientElement#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.trace.TransientElement#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.trace.TracePackage#getTransientElement()
 * @model
 * @generated
 */
public interface TransientElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.m2m.atl.trace.TracePackage#getTransientElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.trace.TransientElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Default</em>' attribute.
	 * @see #setIsDefault(boolean)
	 * @see org.eclipse.m2m.atl.trace.TracePackage#getTransientElement_IsDefault()
	 * @model
	 * @generated
	 */
	boolean isIsDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.trace.TransientElement#isIsDefault <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Default</em>' attribute.
	 * @see #isIsDefault()
	 * @generated
	 */
	void setIsDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EObject)
	 * @see org.eclipse.m2m.atl.trace.TracePackage#getTransientElement_Value()
	 * @model
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.trace.TransientElement#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

} // TransientElement
