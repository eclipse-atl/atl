/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/ 
package org.eclipse.m2m.atl.profiler.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profiling Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getLaunchedTime <em>Launched Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getStackFrames <em>Stack Frames</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getParentOperation <em>Parent Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getInstructionID <em>Instruction ID</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getAtlInstruction <em>Atl Instruction</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getLaunchedMemoryUsage <em>Launched Memory Usage</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#isHasError <em>Has Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction()
 * @model
 * @generated
 */
public interface ProfilingInstruction extends EObject {
	/**
	 * Returns the value of the '<em><b>Launched Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Launched Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Launched Time</em>' attribute.
	 * @see #setLaunchedTime(long)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction_LaunchedTime()
	 * @model
	 * @generated
	 */
	long getLaunchedTime();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getLaunchedTime <em>Launched Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Launched Time</em>' attribute.
	 * @see #getLaunchedTime()
	 * @generated
	 */
	void setLaunchedTime(long value);

	/**
	 * Returns the value of the '<em><b>Stack Frames</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack Frames</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack Frames</em>' attribute list.
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction_StackFrames()
	 * @model
	 * @generated
	 */
	EList<Object> getStackFrames();

	/**
	 * Returns the value of the '<em><b>Parent Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Operation</em>' reference.
	 * @see #setParentOperation(ProfilingOperation)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction_ParentOperation()
	 * @model
	 * @generated
	 */
	ProfilingOperation getParentOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getParentOperation <em>Parent Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Operation</em>' reference.
	 * @see #getParentOperation()
	 * @generated
	 */
	void setParentOperation(ProfilingOperation value);

	/**
	 * Returns the value of the '<em><b>Instruction ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instruction ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instruction ID</em>' attribute.
	 * @see #setInstructionID(int)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction_InstructionID()
	 * @model required="true"
	 * @generated
	 */
	int getInstructionID();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getInstructionID <em>Instruction ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instruction ID</em>' attribute.
	 * @see #getInstructionID()
	 * @generated
	 */
	void setInstructionID(int value);

	/**
	 * Returns the value of the '<em><b>Atl Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl Instruction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl Instruction</em>' reference.
	 * @see #setAtlInstruction(ATLInstruction)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction_AtlInstruction()
	 * @model required="true"
	 * @generated
	 */
	ATLInstruction getAtlInstruction();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getAtlInstruction <em>Atl Instruction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl Instruction</em>' reference.
	 * @see #getAtlInstruction()
	 * @generated
	 */
	void setAtlInstruction(ATLInstruction value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction_Content()
	 * @model
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Launched Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Launched Memory Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Launched Memory Usage</em>' attribute.
	 * @see #setLaunchedMemoryUsage(long)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction_LaunchedMemoryUsage()
	 * @model required="true"
	 * @generated
	 */
	long getLaunchedMemoryUsage();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getLaunchedMemoryUsage <em>Launched Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Launched Memory Usage</em>' attribute.
	 * @see #getLaunchedMemoryUsage()
	 * @generated
	 */
	void setLaunchedMemoryUsage(long value);

	/**
	 * Returns the value of the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Error</em>' attribute.
	 * @see #setHasError(boolean)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingInstruction_HasError()
	 * @model
	 * @generated
	 */
	boolean isHasError();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#isHasError <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Error</em>' attribute.
	 * @see #isHasError()
	 * @generated
	 */
	void setHasError(boolean value);

} // ProfilingInstruction
