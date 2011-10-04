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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.emftvm.util.VMMonitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exec Env</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * Returns the {@link VMMonitor} for the currently running VM instance.
	 * @return the {@link VMMonitor} for the currently running VM instance.
	 * @see ExecEnv#run(TimingData, VMMonitor)
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.m2m.atl.emftvm.VMMonitor"
	 * @generated
	 */
	VMMonitor getMonitor();

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
	 * Loads the module with the given <code>name</code> and its imports
	 * closure into this {@link ExecEnv} using the <code>resolver</code>,
	 * and registers its contents for execution.
	 * @param resolver the module file resolver
	 * @param name the module name
	 * @return the loaded module
	 * <!-- end-user-doc -->
	 * @model resolverDataType="org.eclipse.m2m.atl.emftvm.ModuleResolver"
	 * @generated
	 */
	Module loadModule(ModuleResolver resolver, String name);

	/**
	 * <!-- begin-user-doc -->
	 * Registers a {@link Feature} into this {@link ExecEnv}.
	 * @param feature the {@link Feature} to register
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerFeature(Feature feature);

	/**
	 * <!-- begin-user-doc -->
	 * Registers a {@link Rule} into this {@link ExecEnv}.
	 * @param rule the {@link Rule} to register
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerRule(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * Finds an {@link Operation} registered within this {@link ExecEnv}.
	 * @param context the context type of the operation
	 * @param name the operation name
	 * @param parameterTypes the parameter types of the operation
	 * @return the {@link Operation} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model parameterTypesDataType="org.eclipse.m2m.atl.emftvm.EJavaObjectArray"
	 * @generated
	 */
	Operation findOperation(Object context, String name, Object[] parameterTypes);

	/**
	 * <!-- begin-user-doc -->
	 * Finds a static {@link Operation} registered within this {@link ExecEnv}.
	 * @param context the context type of the operation
	 * @param name the operation name
	 * @param parameterTypes the parameter types of the operation
	 * @return the static {@link Operation} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model parameterTypesDataType="org.eclipse.m2m.atl.emftvm.EJavaObjectArray"
	 * @generated
	 */
	Operation findStaticOperation(Object context, String name, Object[] parameterTypes);

	/**
	 * <!-- begin-user-doc -->
	 * Finds a {@link Field} registered within this {@link ExecEnv}.
	 * @param context the context type of the field
	 * @param name the operation name
	 * @return the {@link Field} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Field findField(Object context, String name);

	/**
	 * <!-- begin-user-doc -->
	 * Finds a static {@link Field} registered within this {@link ExecEnv}.
	 * @param context the context type of the field
	 * @param name the operation name
	 * @return the static {@link Field} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Field findStaticField(Object context, String name);

	/**
	 * <!-- begin-user-doc -->
	 * Finds a {@link Rule} registered within this {@link ExecEnv}.
	 * @param name the rule name
	 * @return the {@link Rule} with the given name, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Rule findRule(String name);

	/**
	 * <!-- begin-user-doc -->
	 * Finds the type for the given (meta-)<code>modelName</code> and <code>typeName</code>.
	 * @param modelName the name under which the metamodel that contains the type is registered
	 * @param typeName the type/metaclass name (may be fully qualified using '<code>::</code>')
	 * @return the type/metaclass
	 * @throws ClassNotFoundException if the type is not found
	 * <!-- end-user-doc -->
	 * @model exceptions="org.eclipse.m2m.atl.emftvm.ClassNotFoundException"
	 * @generated
	 */
	Object findType(String modelName, String typeName) throws ClassNotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * Returns all rules registered in this {@link ExecEnv}.
	 * @return all rules registered in this {@link ExecEnv}.
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.m2m.atl.emftvm.LazyList<org.eclipse.m2m.atl.emftvm.Rule>"
	 * @generated
	 */
	LazyList<Rule> getRules();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link Model} that is registered in this {@link ExecEnv}, and that contains <pre>object</pre>.
	 * @param object the object for which to look up the containing model
	 * @return the {@link Model} that contains <pre>object</pre>, or <code>null</code> if not found.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the ID under which <pre>model</pre> is registered within this {@link ExecEnv}.
	 * @param model the registered {@link Model} to retrieve the ID for
	 * @return the ID under which <pre>model</pre> is registered within this {@link ExecEnv}.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getModelID(Model model);

	/**
	 * <!-- begin-user-doc -->
	 * Deletes all elements in {@link #getDeletionQueue()}, and purges the queue.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteQueue();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the input {@link Model} that is registered in this {@link ExecEnv}, and that contains <pre>object</pre>.
	 * @param object the object for which to look up the containing model
	 * @return the input {@link Model} that contains <pre>object</pre>, or <code>null</code> if not found.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getInputModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the in/out {@link Model} that is registered in this {@link ExecEnv}, and that contains <pre>object</pre>.
	 * @param object the object for which to look up the containing model
	 * @return the in/out {@link Model} that contains <pre>object</pre>, or <code>null</code> if not found.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getInoutModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the output {@link Model} that is registered in this {@link ExecEnv}, and that contains <pre>object</pre>.
	 * @param object the object for which to look up the containing model
	 * @return the output {@link Model} that contains <pre>object</pre>, or <code>null</code> if not found.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getOutputModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model timingDataDataType="org.eclipse.m2m.atl.emftvm.TimingData" monitorDataType="org.eclipse.m2m.atl.emftvm.VMMonitor"
	 * @generated
	 */
	Object run(TimingData timingData, VMMonitor monitor);

} // ExecEnv
