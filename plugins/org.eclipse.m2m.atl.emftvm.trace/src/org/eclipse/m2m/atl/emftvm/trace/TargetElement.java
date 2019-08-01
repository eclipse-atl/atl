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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TargetElement#getTargetOf <em>Target Of</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.trace.TargetElement#getMapsTo <em>Maps To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTargetElement()
 * @model
 * @generated
 */
public interface TargetElement extends TraceElement {
	/**
	 * Returns the value of the '<em><b>Target Of</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getTargetElements <em>Target Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Of</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Of</em>' container reference.
	 * @see #setTargetOf(TraceLink)
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTargetElement_TargetOf()
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#getTargetElements
	 * @model opposite="targetElements" transient="false"
	 * @generated
	 */
	TraceLink getTargetOf();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.trace.TargetElement#getTargetOf <em>Target Of</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Of</em>' container reference.
	 * @see #getTargetOf()
	 * @generated
	 */
	void setTargetOf(TraceLink value);

	/**
	 * Returns the value of the '<em><b>Maps To</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.trace.SourceElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maps To</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracePackage#getTargetElement_MapsTo()
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement#getMapsTo
	 * @model opposite="mapsTo"
	 * @generated
	 */
	EList<SourceElement> getMapsTo();

} // TargetElement
