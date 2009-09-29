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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profiling Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getTotalExecutedInstructions <em>Total Executed Instructions</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getExecutionInstructions <em>Execution Instructions</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getEndMemoryUsage <em>End Memory Usage</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getMaxMemoryUsage <em>Max Memory Usage</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#isMatchingOperation <em>Matching Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getExecutionErrors <em>Execution Errors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation()
 * @model
 * @generated
 */
public interface ProfilingOperation extends ProfilingInstruction {
	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(long)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation_EndTime()
	 * @model required="true"
	 * @generated
	 */
	long getEndTime();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(long value);

	/**
	 * Returns the value of the '<em><b>Total Executed Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Executed Instructions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Executed Instructions</em>' attribute.
	 * @see #setTotalExecutedInstructions(int)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation_TotalExecutedInstructions()
	 * @model required="true"
	 * @generated
	 */
	int getTotalExecutedInstructions();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getTotalExecutedInstructions <em>Total Executed Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Executed Instructions</em>' attribute.
	 * @see #getTotalExecutedInstructions()
	 * @generated
	 */
	void setTotalExecutedInstructions(int value);

	/**
	 * Returns the value of the '<em><b>Execution Instructions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Instructions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Instructions</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation_ExecutionInstructions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProfilingInstruction> getExecutionInstructions();

	/**
	 * Returns the value of the '<em><b>End Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Memory Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Memory Usage</em>' attribute.
	 * @see #setEndMemoryUsage(long)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation_EndMemoryUsage()
	 * @model required="true"
	 * @generated
	 */
	long getEndMemoryUsage();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getEndMemoryUsage <em>End Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Memory Usage</em>' attribute.
	 * @see #getEndMemoryUsage()
	 * @generated
	 */
	void setEndMemoryUsage(long value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.profiler.model.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation_Context()
	 * @model containment="true"
	 * @generated
	 */
	EList<Context> getContext();

	/**
	 * Returns the value of the '<em><b>Max Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Memory Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Memory Usage</em>' attribute.
	 * @see #setMaxMemoryUsage(long)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation_MaxMemoryUsage()
	 * @model
	 * @generated
	 */
	long getMaxMemoryUsage();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getMaxMemoryUsage <em>Max Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Memory Usage</em>' attribute.
	 * @see #getMaxMemoryUsage()
	 * @generated
	 */
	void setMaxMemoryUsage(long value);

	/**
	 * Returns the value of the '<em><b>Matching Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matching Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matching Operation</em>' attribute.
	 * @see #setMatchingOperation(boolean)
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation_MatchingOperation()
	 * @model
	 * @generated
	 */
	boolean isMatchingOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#isMatchingOperation <em>Matching Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matching Operation</em>' attribute.
	 * @see #isMatchingOperation()
	 * @generated
	 */
	void setMatchingOperation(boolean value);

	/**
	 * Returns the value of the '<em><b>Execution Errors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.atl.profiler.model.ExecutionError}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Errors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Errors</em>' containment reference list.
	 * @see org.eclipse.m2m.atl.profiler.model.ModelPackage#getProfilingOperation_ExecutionErrors()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionError> getExecutionErrors();

} // ProfilingOperation
