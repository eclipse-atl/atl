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
 * $Id: TransientLink.java,v 1.1.2.1 2009/03/12 09:38:58 dwagelaar Exp $
 */
package org.eclipse.m2m.atl.trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transient Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.trace.TransientLink#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.trace.TransientLink#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.trace.TransientLink#getTargetElements <em>Target Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.trace.TracePackage#getTransientLink()
 * @model
 * @generated
 */
public interface TransientLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' attribute.
	 * @see #setRule(String)
	 * @see org.eclipse.m2m.atl.trace.TracePackage#getTransientLink_Rule()
	 * @model
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.trace.TransientLink#getRule <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' attribute.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(String value);

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.trace.TransientElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.trace.TracePackage#getTransientLink_SourceElements()
	 * @model containment="true" derived="true"
	 * @generated
	 */
	EList<TransientElement> getSourceElements();

	/**
	 * Returns the value of the '<em><b>Target Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.trace.TransientElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Elements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.trace.TracePackage#getTransientLink_TargetElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransientElement> getTargetElements();

} // TransientLink
