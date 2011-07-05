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
 * A representation of the model object '<em><b>Link</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getTargetElements <em>Target Elements</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#isOverridden <em>Overridden</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLink()
 * @model
 * @generated
 */
public interface TraceLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(TracedRule)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLink_Rule()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinks
	 * @model opposite="links" transient="false"
	 * @generated
	 */
	TracedRule getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(TracedRule value);

	/**
	 * Returns the value of the '<em><b>Overridden</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridden</em>' attribute.
	 * @see #setOverridden(boolean)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLink_Overridden()
	 * @model default="false" transient="true"
	 * @generated
	 */
	boolean isOverridden();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#isOverridden <em>Overridden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overridden</em>' attribute.
	 * @see #isOverridden()
	 * @generated
	 */
	void setOverridden(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SourceElement getSourceElement(String name, boolean create);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TargetElement getTargetElement(String name);

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.SourceElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getSourceOf <em>Source Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLink_SourceElements()
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement#getSourceOf
	 * @model opposite="sourceOf" containment="true"
	 * @generated
	 */
	EList<SourceElement> getSourceElements();

	/**
	 * Returns the value of the '<em><b>Target Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.TargetElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TargetElement#getTargetOf <em>Target Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Elements</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTraceLink_TargetElements()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TargetElement#getTargetOf
	 * @model opposite="targetOf" containment="true"
	 * @generated
	 */
	EList<TargetElement> getTargetElements();

} // TraceLink
