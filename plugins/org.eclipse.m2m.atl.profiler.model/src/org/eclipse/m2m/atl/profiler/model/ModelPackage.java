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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.profiler.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ATLProfiler";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ATLProfiler";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl <em>Profiling Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getProfilingInstruction()
	 * @generated
	 */
	int PROFILING_INSTRUCTION = 0;

	/**
	 * The feature id for the '<em><b>Launched Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION__LAUNCHED_TIME = 0;

	/**
	 * The feature id for the '<em><b>Stack Frames</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION__STACK_FRAMES = 1;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION__PARENT_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Instruction ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION__INSTRUCTION_ID = 3;

	/**
	 * The feature id for the '<em><b>Atl Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION__ATL_INSTRUCTION = 4;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION__CONTENT = 5;

	/**
	 * The feature id for the '<em><b>Launched Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION__LAUNCHED_MEMORY_USAGE = 6;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION__HAS_ERROR = 7;

	/**
	 * The number of structural features of the '<em>Profiling Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_INSTRUCTION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl <em>Profiling Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getProfilingOperation()
	 * @generated
	 */
	int PROFILING_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Launched Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__LAUNCHED_TIME = PROFILING_INSTRUCTION__LAUNCHED_TIME;

	/**
	 * The feature id for the '<em><b>Stack Frames</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__STACK_FRAMES = PROFILING_INSTRUCTION__STACK_FRAMES;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__PARENT_OPERATION = PROFILING_INSTRUCTION__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Instruction ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__INSTRUCTION_ID = PROFILING_INSTRUCTION__INSTRUCTION_ID;

	/**
	 * The feature id for the '<em><b>Atl Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__ATL_INSTRUCTION = PROFILING_INSTRUCTION__ATL_INSTRUCTION;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__CONTENT = PROFILING_INSTRUCTION__CONTENT;

	/**
	 * The feature id for the '<em><b>Launched Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__LAUNCHED_MEMORY_USAGE = PROFILING_INSTRUCTION__LAUNCHED_MEMORY_USAGE;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__HAS_ERROR = PROFILING_INSTRUCTION__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__END_TIME = PROFILING_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Total Executed Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS = PROFILING_INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Execution Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__EXECUTION_INSTRUCTIONS = PROFILING_INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__END_MEMORY_USAGE = PROFILING_INSTRUCTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__CONTEXT = PROFILING_INSTRUCTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__MAX_MEMORY_USAGE = PROFILING_INSTRUCTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Matching Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__MATCHING_OPERATION = PROFILING_INSTRUCTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Execution Errors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION__EXECUTION_ERRORS = PROFILING_INSTRUCTION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Profiling Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_OPERATION_FEATURE_COUNT = PROFILING_INSTRUCTION_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingModelImpl <em>Profiling Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ProfilingModelImpl
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getProfilingModel()
	 * @generated
	 */
	int PROFILING_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Launched Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__LAUNCHED_TIME = PROFILING_OPERATION__LAUNCHED_TIME;

	/**
	 * The feature id for the '<em><b>Stack Frames</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__STACK_FRAMES = PROFILING_OPERATION__STACK_FRAMES;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__PARENT_OPERATION = PROFILING_OPERATION__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Instruction ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__INSTRUCTION_ID = PROFILING_OPERATION__INSTRUCTION_ID;

	/**
	 * The feature id for the '<em><b>Atl Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__ATL_INSTRUCTION = PROFILING_OPERATION__ATL_INSTRUCTION;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__CONTENT = PROFILING_OPERATION__CONTENT;

	/**
	 * The feature id for the '<em><b>Launched Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__LAUNCHED_MEMORY_USAGE = PROFILING_OPERATION__LAUNCHED_MEMORY_USAGE;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__HAS_ERROR = PROFILING_OPERATION__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__END_TIME = PROFILING_OPERATION__END_TIME;

	/**
	 * The feature id for the '<em><b>Total Executed Instructions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__TOTAL_EXECUTED_INSTRUCTIONS = PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS;

	/**
	 * The feature id for the '<em><b>Execution Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__EXECUTION_INSTRUCTIONS = PROFILING_OPERATION__EXECUTION_INSTRUCTIONS;

	/**
	 * The feature id for the '<em><b>End Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__END_MEMORY_USAGE = PROFILING_OPERATION__END_MEMORY_USAGE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__CONTEXT = PROFILING_OPERATION__CONTEXT;

	/**
	 * The feature id for the '<em><b>Max Memory Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__MAX_MEMORY_USAGE = PROFILING_OPERATION__MAX_MEMORY_USAGE;

	/**
	 * The feature id for the '<em><b>Matching Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__MATCHING_OPERATION = PROFILING_OPERATION__MATCHING_OPERATION;

	/**
	 * The feature id for the '<em><b>Execution Errors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__EXECUTION_ERRORS = PROFILING_OPERATION__EXECUTION_ERRORS;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL__MODEL_NAME = PROFILING_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Profiling Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_MODEL_FEATURE_COUNT = PROFILING_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ATLInstructionImpl <em>ATL Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ATLInstructionImpl
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getATLInstruction()
	 * @generated
	 */
	int ATL_INSTRUCTION = 4;

	/**
	 * The feature id for the '<em><b>ATL Element Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_INSTRUCTION__ATL_ELEMENT_REF = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_INSTRUCTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Profiling Instructions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_INSTRUCTION__PROFILING_INSTRUCTIONS = 2;

	/**
	 * The number of structural features of the '<em>ATL Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_INSTRUCTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ATLOperationImpl <em>ATL Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ATLOperationImpl
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getATLOperation()
	 * @generated
	 */
	int ATL_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>ATL Element Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION__ATL_ELEMENT_REF = ATL_INSTRUCTION__ATL_ELEMENT_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION__NAME = ATL_INSTRUCTION__NAME;

	/**
	 * The feature id for the '<em><b>Profiling Instructions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION__PROFILING_INSTRUCTIONS = ATL_INSTRUCTION__PROFILING_INSTRUCTIONS;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION__CALLS = ATL_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ATL Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATL_OPERATION_FEATURE_COUNT = ATL_INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ContextImpl
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 5;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ExecutionErrorImpl <em>Execution Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ExecutionErrorImpl
	 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getExecutionError()
	 * @generated
	 */
	int EXECUTION_ERROR = 6;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ERROR__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ERROR__ERROR = 1;

	/**
	 * The feature id for the '<em><b>Frames</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ERROR__FRAMES = 2;

	/**
	 * The number of structural features of the '<em>Execution Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_ERROR_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction <em>Profiling Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profiling Instruction</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction
	 * @generated
	 */
	EClass getProfilingInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getLaunchedTime <em>Launched Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Launched Time</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getLaunchedTime()
	 * @see #getProfilingInstruction()
	 * @generated
	 */
	EAttribute getProfilingInstruction_LaunchedTime();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getStackFrames <em>Stack Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stack Frames</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getStackFrames()
	 * @see #getProfilingInstruction()
	 * @generated
	 */
	EAttribute getProfilingInstruction_StackFrames();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getParentOperation <em>Parent Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Operation</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getParentOperation()
	 * @see #getProfilingInstruction()
	 * @generated
	 */
	EReference getProfilingInstruction_ParentOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getInstructionID <em>Instruction ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instruction ID</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getInstructionID()
	 * @see #getProfilingInstruction()
	 * @generated
	 */
	EAttribute getProfilingInstruction_InstructionID();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getAtlInstruction <em>Atl Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Atl Instruction</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getAtlInstruction()
	 * @see #getProfilingInstruction()
	 * @generated
	 */
	EReference getProfilingInstruction_AtlInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getContent()
	 * @see #getProfilingInstruction()
	 * @generated
	 */
	EAttribute getProfilingInstruction_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getLaunchedMemoryUsage <em>Launched Memory Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Launched Memory Usage</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#getLaunchedMemoryUsage()
	 * @see #getProfilingInstruction()
	 * @generated
	 */
	EAttribute getProfilingInstruction_LaunchedMemoryUsage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#isHasError <em>Has Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Error</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingInstruction#isHasError()
	 * @see #getProfilingInstruction()
	 * @generated
	 */
	EAttribute getProfilingInstruction_HasError();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation <em>Profiling Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profiling Operation</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation
	 * @generated
	 */
	EClass getProfilingOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getEndTime()
	 * @see #getProfilingOperation()
	 * @generated
	 */
	EAttribute getProfilingOperation_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getTotalExecutedInstructions <em>Total Executed Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Executed Instructions</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getTotalExecutedInstructions()
	 * @see #getProfilingOperation()
	 * @generated
	 */
	EAttribute getProfilingOperation_TotalExecutedInstructions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getExecutionInstructions <em>Execution Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Execution Instructions</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getExecutionInstructions()
	 * @see #getProfilingOperation()
	 * @generated
	 */
	EReference getProfilingOperation_ExecutionInstructions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getEndMemoryUsage <em>End Memory Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Memory Usage</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getEndMemoryUsage()
	 * @see #getProfilingOperation()
	 * @generated
	 */
	EAttribute getProfilingOperation_EndMemoryUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Context</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getContext()
	 * @see #getProfilingOperation()
	 * @generated
	 */
	EReference getProfilingOperation_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getMaxMemoryUsage <em>Max Memory Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Memory Usage</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getMaxMemoryUsage()
	 * @see #getProfilingOperation()
	 * @generated
	 */
	EAttribute getProfilingOperation_MaxMemoryUsage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#isMatchingOperation <em>Matching Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matching Operation</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation#isMatchingOperation()
	 * @see #getProfilingOperation()
	 * @generated
	 */
	EAttribute getProfilingOperation_MatchingOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getExecutionErrors <em>Execution Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Execution Errors</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingOperation#getExecutionErrors()
	 * @see #getProfilingOperation()
	 * @generated
	 */
	EReference getProfilingOperation_ExecutionErrors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.model.ProfilingModel <em>Profiling Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profiling Model</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingModel
	 * @generated
	 */
	EClass getProfilingModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ProfilingModel#getModelName <em>Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Name</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ProfilingModel#getModelName()
	 * @see #getProfilingModel()
	 * @generated
	 */
	EAttribute getProfilingModel_ModelName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.model.ATLOperation <em>ATL Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ATL Operation</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ATLOperation
	 * @generated
	 */
	EClass getATLOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ATLOperation#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calls</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ATLOperation#getCalls()
	 * @see #getATLOperation()
	 * @generated
	 */
	EAttribute getATLOperation_Calls();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction <em>ATL Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ATL Instruction</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ATLInstruction
	 * @generated
	 */
	EClass getATLInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction#getATLElementRef <em>ATL Element Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ATL Element Ref</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ATLInstruction#getATLElementRef()
	 * @see #getATLInstruction()
	 * @generated
	 */
	EAttribute getATLInstruction_ATLElementRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ATLInstruction#getName()
	 * @see #getATLInstruction()
	 * @generated
	 */
	EAttribute getATLInstruction_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.profiler.model.ATLInstruction#getProfilingInstructions <em>Profiling Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Profiling Instructions</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ATLInstruction#getProfilingInstructions()
	 * @see #getATLInstruction()
	 * @generated
	 */
	EReference getATLInstruction_ProfilingInstructions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.model.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.Context#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.Context#getContent()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_Content();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.profiler.model.ExecutionError <em>Execution Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Error</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ExecutionError
	 * @generated
	 */
	EClass getExecutionError();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ExecutionError#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ExecutionError#getMessage()
	 * @see #getExecutionError()
	 * @generated
	 */
	EAttribute getExecutionError_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ExecutionError#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ExecutionError#getError()
	 * @see #getExecutionError()
	 * @generated
	 */
	EAttribute getExecutionError_Error();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.profiler.model.ExecutionError#getFrames <em>Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frames</em>'.
	 * @see org.eclipse.m2m.atl.profiler.model.ExecutionError#getFrames()
	 * @see #getExecutionError()
	 * @generated
	 */
	EAttribute getExecutionError_Frames();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl <em>Profiling Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getProfilingInstruction()
		 * @generated
		 */
		EClass PROFILING_INSTRUCTION = eINSTANCE.getProfilingInstruction();

		/**
		 * The meta object literal for the '<em><b>Launched Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_INSTRUCTION__LAUNCHED_TIME = eINSTANCE.getProfilingInstruction_LaunchedTime();

		/**
		 * The meta object literal for the '<em><b>Stack Frames</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_INSTRUCTION__STACK_FRAMES = eINSTANCE.getProfilingInstruction_StackFrames();

		/**
		 * The meta object literal for the '<em><b>Parent Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILING_INSTRUCTION__PARENT_OPERATION = eINSTANCE.getProfilingInstruction_ParentOperation();

		/**
		 * The meta object literal for the '<em><b>Instruction ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_INSTRUCTION__INSTRUCTION_ID = eINSTANCE.getProfilingInstruction_InstructionID();

		/**
		 * The meta object literal for the '<em><b>Atl Instruction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILING_INSTRUCTION__ATL_INSTRUCTION = eINSTANCE.getProfilingInstruction_AtlInstruction();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_INSTRUCTION__CONTENT = eINSTANCE.getProfilingInstruction_Content();

		/**
		 * The meta object literal for the '<em><b>Launched Memory Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_INSTRUCTION__LAUNCHED_MEMORY_USAGE = eINSTANCE.getProfilingInstruction_LaunchedMemoryUsage();

		/**
		 * The meta object literal for the '<em><b>Has Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_INSTRUCTION__HAS_ERROR = eINSTANCE.getProfilingInstruction_HasError();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl <em>Profiling Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getProfilingOperation()
		 * @generated
		 */
		EClass PROFILING_OPERATION = eINSTANCE.getProfilingOperation();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_OPERATION__END_TIME = eINSTANCE.getProfilingOperation_EndTime();

		/**
		 * The meta object literal for the '<em><b>Total Executed Instructions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS = eINSTANCE.getProfilingOperation_TotalExecutedInstructions();

		/**
		 * The meta object literal for the '<em><b>Execution Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILING_OPERATION__EXECUTION_INSTRUCTIONS = eINSTANCE.getProfilingOperation_ExecutionInstructions();

		/**
		 * The meta object literal for the '<em><b>End Memory Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_OPERATION__END_MEMORY_USAGE = eINSTANCE.getProfilingOperation_EndMemoryUsage();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILING_OPERATION__CONTEXT = eINSTANCE.getProfilingOperation_Context();

		/**
		 * The meta object literal for the '<em><b>Max Memory Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_OPERATION__MAX_MEMORY_USAGE = eINSTANCE.getProfilingOperation_MaxMemoryUsage();

		/**
		 * The meta object literal for the '<em><b>Matching Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_OPERATION__MATCHING_OPERATION = eINSTANCE.getProfilingOperation_MatchingOperation();

		/**
		 * The meta object literal for the '<em><b>Execution Errors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILING_OPERATION__EXECUTION_ERRORS = eINSTANCE.getProfilingOperation_ExecutionErrors();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingModelImpl <em>Profiling Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ProfilingModelImpl
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getProfilingModel()
		 * @generated
		 */
		EClass PROFILING_MODEL = eINSTANCE.getProfilingModel();

		/**
		 * The meta object literal for the '<em><b>Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_MODEL__MODEL_NAME = eINSTANCE.getProfilingModel_ModelName();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ATLOperationImpl <em>ATL Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ATLOperationImpl
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getATLOperation()
		 * @generated
		 */
		EClass ATL_OPERATION = eINSTANCE.getATLOperation();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATL_OPERATION__CALLS = eINSTANCE.getATLOperation_Calls();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ATLInstructionImpl <em>ATL Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ATLInstructionImpl
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getATLInstruction()
		 * @generated
		 */
		EClass ATL_INSTRUCTION = eINSTANCE.getATLInstruction();

		/**
		 * The meta object literal for the '<em><b>ATL Element Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATL_INSTRUCTION__ATL_ELEMENT_REF = eINSTANCE.getATLInstruction_ATLElementRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATL_INSTRUCTION__NAME = eINSTANCE.getATLInstruction_Name();

		/**
		 * The meta object literal for the '<em><b>Profiling Instructions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATL_INSTRUCTION__PROFILING_INSTRUCTIONS = eINSTANCE.getATLInstruction_ProfilingInstructions();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ContextImpl
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT__CONTENT = eINSTANCE.getContext_Content();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.profiler.model.impl.ExecutionErrorImpl <em>Execution Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ExecutionErrorImpl
		 * @see org.eclipse.m2m.atl.profiler.model.impl.ModelPackageImpl#getExecutionError()
		 * @generated
		 */
		EClass EXECUTION_ERROR = eINSTANCE.getExecutionError();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_ERROR__MESSAGE = eINSTANCE.getExecutionError_Message();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_ERROR__ERROR = eINSTANCE.getExecutionError_Error();

		/**
		 * The meta object literal for the '<em><b>Frames</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_ERROR__FRAMES = eINSTANCE.getExecutionError_Frames();

	}

} //ModelPackage
