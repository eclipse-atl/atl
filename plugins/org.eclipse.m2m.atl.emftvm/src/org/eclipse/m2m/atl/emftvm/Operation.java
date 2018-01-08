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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Operation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Operation#isQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Operation#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Feature {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Parameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getOperation_Parameters()
	 * @see org.eclipse.m2m.atl.emftvm.Parameter#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(boolean)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getOperation_Query()
	 * @model required="true"
	 * @generated
	 */
	boolean isQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Operation#isQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #isQuery()
	 * @generated
	 */
	void setQuery(boolean value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.CodeBlock#getBodyFor <em>Body For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(CodeBlock)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getOperation_Body()
	 * @see org.eclipse.m2m.atl.emftvm.CodeBlock#getBodyFor
	 * @model opposite="bodyFor" containment="true" required="true"
	 * @generated
	 */
	CodeBlock getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Operation#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(CodeBlock value);

} // Operation
