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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getSourceOf <em>Source Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getMapsTo <em>Maps To</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getDefaultFor <em>Default For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getUniqueFor <em>Unique For</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElement()
 * @model
 * @generated
 */
public interface SourceElement extends TraceElement {
	/**
	 * Returns the value of the '<em><b>Source Of</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Of</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Of</em>' container reference.
	 * @see #setSourceOf(TraceLink)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElement_SourceOf()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#getSourceElements
	 * @model opposite="sourceElements" transient="false"
	 * @generated
	 */
	TraceLink getSourceOf();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getSourceOf <em>Source Of</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Of</em>' container reference.
	 * @see #getSourceOf()
	 * @generated
	 */
	void setSourceOf(TraceLink value);

	/**
	 * Returns the value of the '<em><b>Maps To</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.TargetElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TargetElement#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maps To</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElement_MapsTo()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TargetElement#getMapsTo
	 * @model opposite="mapsTo"
	 * @generated
	 */
	EList<TargetElement> getMapsTo();

	/**
	 * Returns the value of the '<em><b>Default For</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElements <em>Default Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default For</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default For</em>' reference.
	 * @see #setDefaultFor(TraceLinkSet)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElement_DefaultFor()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElements
	 * @model opposite="defaultSourceElements"
	 * @generated
	 */
	TraceLinkSet getDefaultFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getDefaultFor <em>Default For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default For</em>' reference.
	 * @see #getDefaultFor()
	 * @generated
	 */
	void setDefaultFor(TraceLinkSet value);

	/**
	 * Returns the value of the '<em><b>Unique For</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElements <em>Unique Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique For</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique For</em>' reference.
	 * @see #setUniqueFor(TracedRule)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getSourceElement_UniqueFor()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElements
	 * @model opposite="uniqueSourceElements"
	 * @generated
	 */
	TracedRule getUniqueFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getUniqueFor <em>Unique For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique For</em>' reference.
	 * @see #getUniqueFor()
	 * @generated
	 */
	void setUniqueFor(TracedRule value);

} // SourceElement
