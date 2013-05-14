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
package org.eclipse.m2m.atl.emftvm.trace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Element List</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getDefaultFor <em>Default For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getUniqueFor <em>Unique For</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElementList()
 * @model
 * @generated
 */
public interface SourceElementList extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.SourceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElementList_SourceElements()
	 * @model lower="2"
	 * @generated
	 */
	EList<SourceElement> getSourceElements();

	/**
	 * Returns the value of the '<em><b>Default For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElementLists <em>Default Source Element Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default For</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default For</em>' container reference.
	 * @see #setDefaultFor(TraceLinkSet)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElementList_DefaultFor()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElementLists
	 * @model opposite="defaultSourceElementLists" transient="false"
	 * @generated
	 */
	TraceLinkSet getDefaultFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getDefaultFor <em>Default For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default For</em>' container reference.
	 * @see #getDefaultFor()
	 * @generated
	 */
	void setDefaultFor(TraceLinkSet value);

	/**
	 * Returns the value of the '<em><b>Unique For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElementLists <em>Unique Source Element Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique For</em>' container reference.
	 * @see #setUniqueFor(TracedRule)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElementList_UniqueFor()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElementLists
	 * @model opposite="uniqueSourceElementLists" transient="false"
	 * @generated
	 */
	TracedRule getUniqueFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getUniqueFor <em>Unique For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique For</em>' container reference.
	 * @see #getUniqueFor()
	 * @generated
	 */
	void setUniqueFor(TracedRule value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" lower="2"
	 * @generated
	 */
	EList<Object> getSourceObjects();

} // SourceElementList
