/*******************************************************************************
 * Copyright (c) 2011-2012 Dennis Wagelaar, Vrije Universiteit Brussel.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.jit.CodeBlockJIT;
import org.eclipse.m2m.atl.emftvm.trace.TraceLink;
import org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet;
import org.eclipse.m2m.atl.emftvm.util.LazyList;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.StackFrame;
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
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getMatches <em>Matches</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getTraces <em>Traces</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getUniqueResults <em>Unique Results</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#isJitDisabled <em>Jit Disabled</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.ExecEnv#getCurrentPhase <em>Current Phase</em>}</li>
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
	 * @model required="true" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	Map<String, Module> getModules();

	/**
	 * Returns the value of the '<em><b>Matches</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matches</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matches</em>' reference.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_Matches()
	 * @model required="true" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	TraceLinkSet getMatches();

	/**
	 * Returns the value of the '<em><b>Traces</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' reference.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_Traces()
	 * @model required="true" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	TraceLinkSet getTraces();

	/**
	 * Returns the value of the '<em><b>Unique Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Results</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Results</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_UniqueResults()
	 * @model required="true" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	Map<TraceLink, Object> getUniqueResults();

	/**
	 * Returns the value of the '<em><b>Jit Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jit Disabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jit Disabled</em>' attribute.
	 * @see #setJitDisabled(boolean)
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_JitDisabled()
	 * @model required="true" transient="true"
	 * @generated
	 */
	boolean isJitDisabled();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.emftvm.ExecEnv#isJitDisabled <em>Jit Disabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jit Disabled</em>' attribute.
	 * @see #isJitDisabled()
	 * @generated
	 */
	void setJitDisabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Current Phase</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * The literals are from the enumeration {@link org.eclipse.m2m.atl.emftvm.RuleMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Phase</em>' attribute.
	 * @see org.eclipse.m2m.atl.emftvm.RuleMode
	 * @see org.eclipse.m2m.atl.emftvm.EmftvmPackage#getExecEnv_CurrentPhase()
	 * @model default="null" transient="true" changeable="false"
	 * @generated
	 */
	RuleMode getCurrentPhase();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model monitorDataType="org.eclipse.m2m.atl.emftvm.VMMonitor"
	 * @generated
	 */
	void setMonitor(VMMonitor monitor);

	/**
	 * <!-- begin-user-doc -->
	 * Registers <code>metamodel</code> under <code>name</code>.
	 * @param name the name under which to register
	 * @param metamodel the metamodel to register
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerMetaModel(String name, Metamodel metamodel);

	/**
	 * <!-- begin-user-doc -->
	 * Registers <code>model</code> as an input model under <code>name</code>.
	 * @param name the name under which to register
	 * @param model the model to register
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerInputModel(String name, Model model);

	/**
	 * <!-- begin-user-doc -->
	 * Registers <code>model</code> as an in/out model under <code>name</code>.
	 * @param name the name under which to register
	 * @param model the model to register
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerInOutModel(String name, Model model);

	/**
	 * <!-- begin-user-doc -->
	 * Registers <code>model</code> as an output model under <code>name</code>.
	 * @param name the name under which to register
	 * @param model the model to register
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerOutputModel(String name, Model model);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link Metamodel} for the given <code>resource</code>, or <code>null</code>.
	 * @param resource the EMF {@link Resource} of the {@link Metamodel}
	 * @return the {@link Metamodel}
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Metamodel getMetaModel(Resource resource);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for setting the given feature.
	 * @param feature the feature to set
	 * @param object the object for which to set the feature
	 * @param value the feature value to set
	 * @param frame the stack frame context in which to set the feature value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueForSet(EStructuralFeature feature, EObject object, Object value, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for setting the given field.
	 * @param field the field to set
	 * @param object the object for which to set the field
	 * @param value the field value to set
	 * @param frame the stack frame context in which to set the field value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueForSet(Field field, Object object, Object value, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for setting the XMI ID.
	 * @param object the object for which to set the field
	 * @param value the field value to set
	 * @param frame the stack frame context in which to set the field value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueXmiIDForSet(EObject object, Object value, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for adding a value to the given feature.
	 * @param feature the feature to add to
	 * @param object the object for which to add to the feature
	 * @param value the feature value to add
	 * @param index the index at which to add, or <code>-1</code>
	 * @param frame the stack frame context in which to add to the feature value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueForAdd(EStructuralFeature feature, EObject object, Object value, int index, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for adding a value to the given feature.
	 * @param field the field to add to
	 * @param object the object for which to add to the field
	 * @param value the field value to add
	 * @param index the index at which to add, or <code>-1</code>
	 * @param frame the stack frame context in which to add to the field value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueForAdd(Field field, Object object, Object value, int index, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for adding to the XMI ID.
	 * @param object the object for which to add to the field
	 * @param value the field value to add
	 * @param index the index at which to add, or <code>-1</code>
	 * @param frame the stack frame context in which to add to the field value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueXmiIDForAdd(EObject object, Object value, int index, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for removing a value from the given feature.
	 * @param feature the feature to remove from
	 * @param object the object for which to remove from the feature
	 * @param value the feature value to remove
	 * @param frame the stack frame context in which to remove from the feature value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueForRemove(EStructuralFeature feature, EObject object, Object value, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for removing a value from the given feature.
	 * @param field the field to remove from
	 * @param object the object for which to remove from the field
	 * @param value the field value to remove
	 * @param frame the stack frame context in which to remove from the field value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueForRemove(Field field, Object object, Object value, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given object and value for removing from the XMI ID.
	 * @param object the object for which to remove from the field
	 * @param value the field value to remove
	 * @param frame the stack frame context in which to remove from the field value
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueXmiIDForRemove(EObject object, Object value, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Processes all elements in the "set" queue. Sets all queued features and fields, and clears the queue.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setQueue();

	/**
	 * <!-- begin-user-doc -->
	 * Queues the given source and target value for remapping.
	 * @param source the source value to remap
	 * @param target the target value to map to
	 * @param frame the stack frame context in which to remap
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueForRemap(EObject source, EObject target, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Processes all element in the "remap" queue. Remaps all queued source/target value pairs, and clears the queue.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void remapQueue();

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
	 * @model default="" required="true" transient="true" changeable="false" derived="true"
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
	 * @model default="" required="true" transient="true" changeable="false" derived="true"
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
	 * @model default="" required="true" transient="true" changeable="false" derived="true"
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
	 * @model default="" required="true" transient="true" changeable="false" derived="true"
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
	 * Finds an {@link Operation} registered within this {@link ExecEnv}.
	 * @param context the context type of the operation
	 * @param name the operation name
	 * @return the {@link Operation} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Operation findOperation(Object context, String name);

	/**
	 * <!-- begin-user-doc -->
	 * Finds an {@link Operation} registered within this {@link ExecEnv}.
	 * @param context the context type of the operation
	 * @param name the operation name
	 * @param parameterType the parameter type of the operation
	 * @return the {@link Operation} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Operation findOperation(Object context, String name, Object parameterType);

	/**
	 * <!-- begin-user-doc -->
	 * Returns <code>true</code> iff this execution environment has any registered
	 * operations with the given <code>name</code> and <code>argcount</code>.
	 * @param name the operation name
	 * @param argcount the number of operation arguments (excluding <code>self</code>)
	 * @return <code>true</code> iff this execution environment has any registered
	 * operations with the given <code>name</code> and <code>argcount</code>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasOperation(String name, int argcount);

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
	 * Finds a static {@link Operation} registered within this {@link ExecEnv}.
	 * @param context the context type of the operation
	 * @param name the operation name
	 * @return the static {@link Operation} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Operation findStaticOperation(Object context, String name);

	/**
	 * <!-- begin-user-doc -->
	 * Finds a static {@link Operation} registered within this {@link ExecEnv}.
	 * @param context the context type of the operation
	 * @param name the operation name
	 * @param parameterType the parameter type of the operation
	 * @return the static {@link Operation} with the given properties, or <code>null</code> if none registered
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Operation findStaticOperation(Object context, String name, Object parameterType);

	/**
	 * <!-- begin-user-doc -->
	 * Returns <code>true</code> iff this execution environment has any registered
	 * static operations with the given <code>name</code> and <code>argcount</code>.
	 * @param name the operation name
	 * @param argcount the number of operation arguments
	 * @return <code>true</code> iff this execution environment has any registered
	 * static operations with the given <code>name</code> and <code>argcount</code>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasStaticOperation(String name, int argcount);

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
	 * Returns <code>true</code> iff this execution environment has any registered
	 * fields with the given <code>name</code>.
	 * @param name the field name
	 * @return <code>true</code> iff this execution environment has any registered
	 * fields with the given <code>name</code>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasField(String name);

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
	 * Returns <code>true</code> iff this execution environment has any registered
	 * static fields with the given <code>name</code>.
	 * @param name the field name
	 * @return <code>true</code> iff this execution environment has any registered
	 * static fields with the given <code>name</code>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasStaticField(String name);

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
	 * Executes the loaded modules and returns the execution result.
	 * @param timingData the timing data object, or <code>null</code>
	 * @return the execution result of the last loaded module's <code>main</code> operation
	 * <!-- end-user-doc -->
	 * @model timingDataDataType="org.eclipse.m2m.atl.emftvm.TimingData"
	 * @generated
	 */
	Object run(TimingData timingData);

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
	 * Returns the {@link Model} that is registered in this {@link ExecEnv}, and that contains <code>object</code>.
	 * @param object the object for which to look up the containing model
	 * @return the {@link Model} that contains <code>object</code>, or <code>null</code> if not found.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the ID under which <code>model</code> is registered within this {@link ExecEnv}.
	 * @param model the registered {@link Model} to retrieve the ID for
	 * @return the ID under which <code>model</code> is registered within this {@link ExecEnv}.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getModelID(Model model);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the ID under which <code>metamodel</code> is registered within this {@link ExecEnv}.
	 * @param metamodel the registered {@link Metamodel} to retrieve the ID for
	 * @return the ID under which <code>metamodel</code> is registered within this {@link ExecEnv}.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getMetaModelID(Metamodel metamodel);

	/**
	 * <!-- begin-user-doc -->
	 * Queues <code>element</code> for deletion.
	 * @param element the element to delete
	 * @param frame the stack frame context in which to perform the deletion
	 * <!-- end-user-doc -->
	 * @model frameDataType="org.eclipse.m2m.atl.emftvm.StackFrame"
	 * @generated
	 */
	void queueForDelete(EObject element, StackFrame frame);

	/**
	 * <!-- begin-user-doc -->
	 * Deletes all elements in the deletion queue.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteQueue();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the input {@link Model} that is registered in this {@link ExecEnv}, and that contains <code>object</code>.
	 * @param object the object for which to look up the containing model
	 * @return the input {@link Model} that contains <code>object</code>, or <code>null</code> if not found.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getInputModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the in/out {@link Model} that is registered in this {@link ExecEnv}, and that contains <code>object</code>.
	 * @param object the object for which to look up the containing model
	 * @return the in/out {@link Model} that contains <code>object</code>, or <code>null</code> if not found.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getInoutModelOf(EObject object);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the output {@link Model} that is registered in this {@link ExecEnv}, and that contains <code>object</code>.
	 * @param object the object for which to look up the containing model
	 * @return the output {@link Model} that contains <code>object</code>, or <code>null</code> if not found.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Model getOutputModelOf(EObject object);

	/**
	 * Returns the JIT compiler instance for this execution environment.
	 * @return the JIT compiler instance
	 */
	CodeBlockJIT getJITCompiler();

} // ExecEnv
