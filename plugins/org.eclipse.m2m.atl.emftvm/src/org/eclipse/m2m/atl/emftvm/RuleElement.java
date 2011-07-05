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
 * A representation of the model object '<em><b>Rule Element</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.RuleElement#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.RuleElement#getEModels <em>EModels</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRuleElement()
 * @model abstract="true"
 * @generated
 */
public interface RuleElement extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Models</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' attribute list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRuleElement_Models()
	 * @model
	 * @generated
	 */
	EList<String> getModels();

	/**
	 * Returns the value of the '<em><b>EModels</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Model}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EModels</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EModels</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getRuleElement_EModels()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	EList<Model> getEModels();

} // RuleElement
