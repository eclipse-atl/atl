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
package org.eclipse.m2m.atl.emftvm.trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getRuntimeObject <em>Runtime Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceElement()
 * @model abstract="true"
 * @generated
 */
public interface TraceElement extends EObject {
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
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceElement_Object()
	 * @model
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Also invokes {@link #setRuntimeObject(Object)}.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Runtime Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Contains the runtime value of this trace element, which may or may not be an {@link EObject}.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime Object</em>' attribute.
	 * @see #setRuntimeObject(Object)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceElement_RuntimeObject()
	 * @model transient="true"
	 * @generated
	 */
	Object getRuntimeObject();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getRuntimeObject <em>Runtime Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If <code>value</code> is an {@link EObject}, also invokes {@link #setObject(EObject)}.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime Object</em>' attribute.
	 * @see #getRuntimeObject()
	 * @generated
	 */
	void setRuntimeObject(Object value);

} // TraceElement
