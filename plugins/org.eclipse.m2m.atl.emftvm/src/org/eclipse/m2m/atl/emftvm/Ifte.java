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
 * A representation of the model object '<em><b>Ifte</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCbIndex <em>Then Cb Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCbIndex <em>Else Cb Index</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCb <em>Then Cb</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCb <em>Else Cb</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getIfte()
 * @model
 * @generated
 */
public interface Ifte extends Instruction {
	/**
	 * Returns the value of the '<em><b>Then Cb Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Cb Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Cb Index</em>' attribute.
	 * @see #setThenCbIndex(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getIfte_ThenCbIndex()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getThenCbIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCbIndex <em>Then Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Cb Index</em>' attribute.
	 * @see #getThenCbIndex()
	 * @generated
	 */
	void setThenCbIndex(int value);

	/**
	 * Returns the value of the '<em><b>Else Cb Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Cb Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Cb Index</em>' attribute.
	 * @see #setElseCbIndex(int)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getIfte_ElseCbIndex()
	 * @model default="-1" required="true" volatile="true" derived="true"
	 * @generated
	 */
	int getElseCbIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCbIndex <em>Else Cb Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Cb Index</em>' attribute.
	 * @see #getElseCbIndex()
	 * @generated
	 */
	void setElseCbIndex(int value);

	/**
	 * Returns the value of the '<em><b>Then Cb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Cb</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Cb</em>' reference.
	 * @see #setThenCb(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getIfte_ThenCb()
	 * @model required="true" transient="true" volatile="true"
	 * @generated
	 */
	CodeBlock getThenCb();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Ifte#getThenCb <em>Then Cb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Cb</em>' reference.
	 * @see #getThenCb()
	 * @generated
	 */
	void setThenCb(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Else Cb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Cb</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Cb</em>' reference.
	 * @see #setElseCb(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getIfte_ElseCb()
	 * @model required="true" transient="true" volatile="true"
	 * @generated
	 */
	CodeBlock getElseCb();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Ifte#getElseCb <em>Else Cb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Cb</em>' reference.
	 * @see #getElseCb()
	 * @generated
	 */
	void setElseCb(CodeBlock value);

} // Ifte
