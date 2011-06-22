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
 * A representation of the model object '<em><b>Findtype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Findtype#getModelname <em>Modelname</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Findtype#getTypename <em>Typename</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getFindtype()
 * @model
 * @generated
 */
public interface Findtype extends Instruction {
	/**
	 * Returns the value of the '<em><b>Modelname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modelname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modelname</em>' attribute.
	 * @see #setModelname(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getFindtype_Modelname()
	 * @model required="true"
	 * @generated
	 */
	String getModelname();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Findtype#getModelname <em>Modelname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modelname</em>' attribute.
	 * @see #getModelname()
	 * @generated
	 */
	void setModelname(String value);

	/**
	 * Returns the value of the '<em><b>Typename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typename</em>' attribute.
	 * @see #setTypename(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getFindtype_Typename()
	 * @model required="true"
	 * @generated
	 */
	String getTypename();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Findtype#getTypename <em>Typename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typename</em>' attribute.
	 * @see #getTypename()
	 * @generated
	 */
	void setTypename(String value);

} // Findtype
