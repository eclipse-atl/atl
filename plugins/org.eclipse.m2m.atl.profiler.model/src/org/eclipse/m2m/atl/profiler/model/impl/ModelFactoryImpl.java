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
package org.eclipse.m2m.atl.profiler.model.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.m2m.atl.profiler.model.ATLInstruction;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.Context;
import org.eclipse.m2m.atl.profiler.model.ExecutionError;
import org.eclipse.m2m.atl.profiler.model.ModelFactory;
import org.eclipse.m2m.atl.profiler.model.ModelPackage;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingModel;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://ATLProfiler"); 
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.PROFILING_INSTRUCTION: return createProfilingInstruction();
			case ModelPackage.PROFILING_OPERATION: return createProfilingOperation();
			case ModelPackage.PROFILING_MODEL: return createProfilingModel();
			case ModelPackage.ATL_OPERATION: return createATLOperation();
			case ModelPackage.ATL_INSTRUCTION: return createATLInstruction();
			case ModelPackage.CONTEXT: return createContext();
			case ModelPackage.EXECUTION_ERROR: return createExecutionError();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingInstruction createProfilingInstruction() {
		ProfilingInstructionImpl profilingInstruction = new ProfilingInstructionImpl();
		return profilingInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingOperation createProfilingOperation() {
		ProfilingOperationImpl profilingOperation = new ProfilingOperationImpl();
		return profilingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingModel createProfilingModel() {
		ProfilingModelImpl profilingModel = new ProfilingModelImpl();
		return profilingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ATLOperation createATLOperation() {
		ATLOperationImpl atlOperation = new ATLOperationImpl();
		return atlOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ATLInstruction createATLInstruction() {
		ATLInstructionImpl atlInstruction = new ATLInstructionImpl();
		return atlInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionError createExecutionError() {
		ExecutionErrorImpl executionError = new ExecutionErrorImpl();
		return executionError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
