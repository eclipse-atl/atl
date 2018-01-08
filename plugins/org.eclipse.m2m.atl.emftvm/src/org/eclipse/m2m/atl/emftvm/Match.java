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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Match#getRulename <em>Rulename</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getMatch()
 * @model
 * @generated
 */
public interface Match extends InvokeInstruction {

	/**
	 * Returns the value of the '<em><b>Rulename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rulename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rulename</em>' attribute.
	 * @see #setRulename(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getMatch_Rulename()
	 * @model required="true"
	 * @generated
	 */
	String getRulename();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Match#getRulename <em>Rulename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rulename</em>' attribute.
	 * @see #getRulename()
	 * @generated
	 */
	void setRulename(String value);

} // Match
