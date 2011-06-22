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

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exec Env</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMetaModels <em>Meta Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInputModels <em>Input Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getInoutModels <em>Inout Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getOutputModels <em>Output Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getDeletionQueue <em>Deletion Queue</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv()
 * @model
 * @generated
 */
public interface ExecEnv extends EObject {

	/**
	 * Returns the value of the '<em><b>Modules</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modules</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_Modules()
	 * @model required="true" transient="true" changeable="false"
	 * @generated
	 */
	Map<String, Module> getModules();

	/**
	 * Returns the value of the '<em><b>Deletion Queue</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deletion Queue</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deletion Queue</em>' reference list.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_DeletionQueue()
	 * @model transient="true"
	 * @generated
	 */
	EList<EObject> getDeletionQueue();

	/**
	 * Returns the value of the '<em><b>Meta Models</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Models</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Models</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_MetaModels()
	 * @model default="" required="true" transient="true" changeable="false"
	 * @generated
	 */
	Map<String, Metamodel> getMetaModels();

	/**
	 * Returns the value of the '<em><b>Input Models</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Models</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Models</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_InputModels()
	 * @model default="" required="true" transient="true" changeable="false"
	 * @generated
	 */
	Map<String, Model> getInputModels();

	/**
	 * Returns the value of the '<em><b>Inout Models</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inout Models</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inout Models</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_InoutModels()
	 * @model default="" required="true" transient="true" changeable="false"
	 * @generated
	 */
	Map<String, Model> getInoutModels();

	/**
	 * Returns the value of the '<em><b>Output Models</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Models</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Models</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_OutputModels()
	 * @model default="" required="true" transient="true" changeable="false"
	 * @generated
	 */
	Map<String, Model> getOutputModels();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model resolverDataType="org.eclipse.m2m.atl.emftvm.ModuleResolver"
	 * @generated
	 */
	Module loadModule(ModuleResolver resolver, String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerFeature(Feature feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerRule(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parameterTypesMany="true"
	 * @generated
	 */
	Operation findOperation(Object context, String name, EList<Object> parameterTypes);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parameterTypesMany="true"
	 * @generated
	 */
	Operation findStaticOperation(Object context, String name, EList<Object> parameterTypes);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Field findField(Object context, String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Field findStaticField(Object context, String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Rule findRule(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.m2m.atl.emftvm.LazyList<org.eclipse.m2m.atl.emftvm.Rule>"
	 * @generated
	 */
	LazyList<Rule> getRules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getModelID(Model model);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteQueue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getInputModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getInoutModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getOutputModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EClassifier findType(String modelName, String typeName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model timingDataDataType="org.eclipse.m2m.atl.emftvm.TimingData"
	 * @generated
	 */
	Object run(TimingData timingData);

} // ExecEnv
