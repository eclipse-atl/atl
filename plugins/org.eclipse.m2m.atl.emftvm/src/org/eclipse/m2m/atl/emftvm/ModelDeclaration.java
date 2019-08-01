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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Declaration</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getMetaModelName <em>Meta Model Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInputModelFor <em>Input Model For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInoutModelFor <em>Inout Model For</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getOutputModelFor <em>Output Model For</em>}</li>
 * </ul>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModelDeclaration()
 * @model
 * @generated
 */
public interface ModelDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Name</em>' attribute.
	 * @see #setModelName(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModelDeclaration_ModelName()
	 * @model required="true"
	 * @generated
	 */
	String getModelName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getModelName <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Name</em>' attribute.
	 * @see #getModelName()
	 * @generated
	 */
	void setModelName(String value);

	/**
	 * Returns the value of the '<em><b>Meta Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Name</em>' attribute.
	 * @see #setMetaModelName(String)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModelDeclaration_MetaModelName()
	 * @model required="true"
	 * @generated
	 */
	String getMetaModelName();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getMetaModelName <em>Meta Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model Name</em>' attribute.
	 * @see #getMetaModelName()
	 * @generated
	 */
	void setMetaModelName(String value);

	/**
	 * Returns the value of the '<em><b>Input Model For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Module#getInputModels <em>Input Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Model For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Model For</em>' container reference.
	 * @see #setInputModelFor(Module)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModelDeclaration_InputModelFor()
	 * @see org.eclipse.m2m.atl.emftvm.Module#getInputModels
	 * @model opposite="inputModels" transient="false"
	 * @generated
	 */
	Module getInputModelFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInputModelFor <em>Input Model For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Model For</em>' container reference.
	 * @see #getInputModelFor()
	 * @generated
	 */
	void setInputModelFor(Module value);

	/**
	 * Returns the value of the '<em><b>Inout Model For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Module#getInoutModels <em>Inout Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inout Model For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inout Model For</em>' container reference.
	 * @see #setInoutModelFor(Module)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModelDeclaration_InoutModelFor()
	 * @see org.eclipse.m2m.atl.emftvm.Module#getInoutModels
	 * @model opposite="inoutModels" transient="false"
	 * @generated
	 */
	Module getInoutModelFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getInoutModelFor <em>Inout Model For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inout Model For</em>' container reference.
	 * @see #getInoutModelFor()
	 * @generated
	 */
	void setInoutModelFor(Module value);

	/**
	 * Returns the value of the '<em><b>Output Model For</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.atl.emftvm.Module#getOutputModels <em>Output Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Model For</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Model For</em>' container reference.
	 * @see #setOutputModelFor(Module)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getModelDeclaration_OutputModelFor()
	 * @see org.eclipse.m2m.atl.emftvm.Module#getOutputModels
	 * @model opposite="outputModels" transient="false"
	 * @generated
	 */
	Module getOutputModelFor();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.ModelDeclaration#getOutputModelFor <em>Output Model For</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Model For</em>' container reference.
	 * @see #getOutputModelFor()
	 * @generated
	 */
	void setOutputModelFor(Module value);

} // ModelDeclaration
