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
package org.eclipse.m2m.atl.emftvm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getSourceName <em>Source Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getEImports <em>EImports</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getInputModels <em>Input Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getInoutModels <em>Inout Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.Module#getOutputModels <em>Output Models</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Name</em>' attribute.
	 * @see #setSourceName(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule_SourceName()
	 * @model required="true"
	 * @generated
	 */
	String getSourceName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.Module#getSourceName <em>Source Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Name</em>' attribute.
	 * @see #getSourceName()
	 * @generated
	 */
	void setSourceName(String value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Feature}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Feature#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule_Features()
	 * @see org.eclipse.m2m.atl.emftvm.Feature#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Rule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Rule#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule_Rules()
	 * @see org.eclipse.m2m.atl.emftvm.Rule#getModule
	 * @model opposite="module" containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>EImports</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.Module}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EImports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EImports</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule_EImports()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	EList<Module> getEImports();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' attribute list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule_Imports()
	 * @model
	 * @generated
	 */
	EList<String> getImports();

	/**
	 * Returns the value of the '<em><b>Input Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.ModelDeclaration}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInputModelFor <em>Input Model For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Models</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule_InputModels()
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInputModelFor
	 * @model opposite="inputModelFor" containment="true"
	 * @generated
	 */
	EList<ModelDeclaration> getInputModels();

	/**
	 * Returns the value of the '<em><b>Inout Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.ModelDeclaration}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInoutModelFor <em>Inout Model For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inout Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inout Models</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule_InoutModels()
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInoutModelFor
	 * @model opposite="inoutModelFor" containment="true"
	 * @generated
	 */
	EList<ModelDeclaration> getInoutModels();

	/**
	 * Returns the value of the '<em><b>Output Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.emftvm.ModelDeclaration}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getOutputModelFor <em>Output Model For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Models</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModule_OutputModels()
	 * @see org.eclipse.m2m.atl.emftvm.ModelDeclaration#getOutputModelFor
	 * @model opposite="outputModelFor" containment="true"
	 * @generated
	 */
	EList<ModelDeclaration> getOutputModels();

} // Module
