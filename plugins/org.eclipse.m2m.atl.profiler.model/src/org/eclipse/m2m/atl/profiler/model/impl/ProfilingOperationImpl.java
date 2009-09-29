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


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.profiler.model.Context;
import org.eclipse.m2m.atl.profiler.model.ExecutionError;
import org.eclipse.m2m.atl.profiler.model.ModelPackage;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profiling Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl#getTotalExecutedInstructions <em>Total Executed Instructions</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl#getExecutionInstructions <em>Execution Instructions</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl#getEndMemoryUsage <em>End Memory Usage</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl#getMaxMemoryUsage <em>Max Memory Usage</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl#isMatchingOperation <em>Matching Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingOperationImpl#getExecutionErrors <em>Execution Errors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfilingOperationImpl extends ProfilingInstructionImpl implements ProfilingOperation {
	/**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected static final long END_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected long endTime = END_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalExecutedInstructions() <em>Total Executed Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalExecutedInstructions()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_EXECUTED_INSTRUCTIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalExecutedInstructions() <em>Total Executed Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalExecutedInstructions()
	 * @generated
	 * @ordered
	 */
	protected int totalExecutedInstructions = TOTAL_EXECUTED_INSTRUCTIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExecutionInstructions() <em>Execution Instructions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionInstructions()
	 * @generated
	 * @ordered
	 */
	protected EList<ProfilingInstruction> executionInstructions;

	/**
	 * The default value of the '{@link #getEndMemoryUsage() <em>End Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndMemoryUsage()
	 * @generated
	 * @ordered
	 */
	protected static final long END_MEMORY_USAGE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEndMemoryUsage() <em>End Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndMemoryUsage()
	 * @generated
	 * @ordered
	 */
	protected long endMemoryUsage = END_MEMORY_USAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> context;

	/**
	 * The default value of the '{@link #getMaxMemoryUsage() <em>Max Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMemoryUsage()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_MEMORY_USAGE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxMemoryUsage() <em>Max Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMemoryUsage()
	 * @generated
	 * @ordered
	 */
	protected long maxMemoryUsage = MAX_MEMORY_USAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMatchingOperation() <em>Matching Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMatchingOperation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MATCHING_OPERATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMatchingOperation() <em>Matching Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMatchingOperation()
	 * @generated
	 * @ordered
	 */
	protected boolean matchingOperation = MATCHING_OPERATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExecutionErrors() <em>Execution Errors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionError> executionErrors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfilingOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROFILING_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(long newEndTime) {
		long oldEndTime = endTime;
		endTime = newEndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_OPERATION__END_TIME, oldEndTime, endTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalExecutedInstructions() {
		return totalExecutedInstructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalExecutedInstructions(int newTotalExecutedInstructions) {
		int oldTotalExecutedInstructions = totalExecutedInstructions;
		totalExecutedInstructions = newTotalExecutedInstructions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS, oldTotalExecutedInstructions, totalExecutedInstructions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProfilingInstruction> getExecutionInstructions() {
		if (executionInstructions == null) {
			executionInstructions = new EObjectContainmentEList<ProfilingInstruction>(ProfilingInstruction.class, this, ModelPackage.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS);
		}
		return executionInstructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEndMemoryUsage() {
		return endMemoryUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndMemoryUsage(long newEndMemoryUsage) {
		long oldEndMemoryUsage = endMemoryUsage;
		endMemoryUsage = newEndMemoryUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_OPERATION__END_MEMORY_USAGE, oldEndMemoryUsage, endMemoryUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Context> getContext() {
		if (context == null) {
			context = new EObjectContainmentEList<Context>(Context.class, this, ModelPackage.PROFILING_OPERATION__CONTEXT);
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaxMemoryUsage() {
		return maxMemoryUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxMemoryUsage(long newMaxMemoryUsage) {
		long oldMaxMemoryUsage = maxMemoryUsage;
		maxMemoryUsage = newMaxMemoryUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_OPERATION__MAX_MEMORY_USAGE, oldMaxMemoryUsage, maxMemoryUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMatchingOperation() {
		return matchingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatchingOperation(boolean newMatchingOperation) {
		boolean oldMatchingOperation = matchingOperation;
		matchingOperation = newMatchingOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_OPERATION__MATCHING_OPERATION, oldMatchingOperation, matchingOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionError> getExecutionErrors() {
		if (executionErrors == null) {
			executionErrors = new EObjectContainmentEList<ExecutionError>(ExecutionError.class, this, ModelPackage.PROFILING_OPERATION__EXECUTION_ERRORS);
		}
		return executionErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS:
				return ((InternalEList<?>)getExecutionInstructions()).basicRemove(otherEnd, msgs);
			case ModelPackage.PROFILING_OPERATION__CONTEXT:
				return ((InternalEList<?>)getContext()).basicRemove(otherEnd, msgs);
			case ModelPackage.PROFILING_OPERATION__EXECUTION_ERRORS:
				return ((InternalEList<?>)getExecutionErrors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PROFILING_OPERATION__END_TIME:
				return new Long(getEndTime());
			case ModelPackage.PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS:
				return new Integer(getTotalExecutedInstructions());
			case ModelPackage.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS:
				return getExecutionInstructions();
			case ModelPackage.PROFILING_OPERATION__END_MEMORY_USAGE:
				return new Long(getEndMemoryUsage());
			case ModelPackage.PROFILING_OPERATION__CONTEXT:
				return getContext();
			case ModelPackage.PROFILING_OPERATION__MAX_MEMORY_USAGE:
				return new Long(getMaxMemoryUsage());
			case ModelPackage.PROFILING_OPERATION__MATCHING_OPERATION:
				return isMatchingOperation() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.PROFILING_OPERATION__EXECUTION_ERRORS:
				return getExecutionErrors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.PROFILING_OPERATION__END_TIME:
				setEndTime(((Long)newValue).longValue());
				return;
			case ModelPackage.PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS:
				setTotalExecutedInstructions(((Integer)newValue).intValue());
				return;
			case ModelPackage.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS:
				getExecutionInstructions().clear();
				getExecutionInstructions().addAll((Collection<? extends ProfilingInstruction>)newValue);
				return;
			case ModelPackage.PROFILING_OPERATION__END_MEMORY_USAGE:
				setEndMemoryUsage(((Long)newValue).longValue());
				return;
			case ModelPackage.PROFILING_OPERATION__CONTEXT:
				getContext().clear();
				getContext().addAll((Collection<? extends Context>)newValue);
				return;
			case ModelPackage.PROFILING_OPERATION__MAX_MEMORY_USAGE:
				setMaxMemoryUsage(((Long)newValue).longValue());
				return;
			case ModelPackage.PROFILING_OPERATION__MATCHING_OPERATION:
				setMatchingOperation(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.PROFILING_OPERATION__EXECUTION_ERRORS:
				getExecutionErrors().clear();
				getExecutionErrors().addAll((Collection<? extends ExecutionError>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.PROFILING_OPERATION__END_TIME:
				setEndTime(END_TIME_EDEFAULT);
				return;
			case ModelPackage.PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS:
				setTotalExecutedInstructions(TOTAL_EXECUTED_INSTRUCTIONS_EDEFAULT);
				return;
			case ModelPackage.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS:
				getExecutionInstructions().clear();
				return;
			case ModelPackage.PROFILING_OPERATION__END_MEMORY_USAGE:
				setEndMemoryUsage(END_MEMORY_USAGE_EDEFAULT);
				return;
			case ModelPackage.PROFILING_OPERATION__CONTEXT:
				getContext().clear();
				return;
			case ModelPackage.PROFILING_OPERATION__MAX_MEMORY_USAGE:
				setMaxMemoryUsage(MAX_MEMORY_USAGE_EDEFAULT);
				return;
			case ModelPackage.PROFILING_OPERATION__MATCHING_OPERATION:
				setMatchingOperation(MATCHING_OPERATION_EDEFAULT);
				return;
			case ModelPackage.PROFILING_OPERATION__EXECUTION_ERRORS:
				getExecutionErrors().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.PROFILING_OPERATION__END_TIME:
				return endTime != END_TIME_EDEFAULT;
			case ModelPackage.PROFILING_OPERATION__TOTAL_EXECUTED_INSTRUCTIONS:
				return totalExecutedInstructions != TOTAL_EXECUTED_INSTRUCTIONS_EDEFAULT;
			case ModelPackage.PROFILING_OPERATION__EXECUTION_INSTRUCTIONS:
				return executionInstructions != null && !executionInstructions.isEmpty();
			case ModelPackage.PROFILING_OPERATION__END_MEMORY_USAGE:
				return endMemoryUsage != END_MEMORY_USAGE_EDEFAULT;
			case ModelPackage.PROFILING_OPERATION__CONTEXT:
				return context != null && !context.isEmpty();
			case ModelPackage.PROFILING_OPERATION__MAX_MEMORY_USAGE:
				return maxMemoryUsage != MAX_MEMORY_USAGE_EDEFAULT;
			case ModelPackage.PROFILING_OPERATION__MATCHING_OPERATION:
				return matchingOperation != MATCHING_OPERATION_EDEFAULT;
			case ModelPackage.PROFILING_OPERATION__EXECUTION_ERRORS:
				return executionErrors != null && !executionErrors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (endTime: ");
		result.append(endTime);
		result.append(", totalExecutedInstructions: ");
		result.append(totalExecutedInstructions);
		result.append(", endMemoryUsage: ");
		result.append(endMemoryUsage);
		result.append(", maxMemoryUsage: ");
		result.append(maxMemoryUsage);
		result.append(", matchingOperation: ");
		result.append(matchingOperation);
		result.append(')');
		return result.toString();
	}

} //ProfilingOperationImpl
