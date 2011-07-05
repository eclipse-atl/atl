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
 * A representation of the model object '<em><b>Traced Rule</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinkSet <em>Link Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTracedRule()
 * @model
 * @generated
 */
public interface TracedRule extends EObject {
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
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTracedRule_Rule()
	 * @model required="true"
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getRule <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' attribute.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(String value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.TraceLink}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTracedRule_Links()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#getRule
	 * @model opposite="rule" containment="true"
	 * @generated
	 */
	EList<TraceLink> getLinks();

	/**
	 * Returns the value of the '<em><b>Link Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Set</em>' container reference.
	 * @see #setLinkSet(TraceLinkSet)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTracedRule_LinkSet()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getRules
	 * @model opposite="rules" transient="false"
	 * @generated
	 */
	TraceLinkSet getLinkSet();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinkSet <em>Link Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Set</em>' container reference.
	 * @see #getLinkSet()
	 * @generated
	 */
	void setLinkSet(TraceLinkSet value);

} // TracedRule
