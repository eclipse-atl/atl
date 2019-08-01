/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/ 
package org.eclipse.m2m.atl.profiler.model.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.m2m.atl.profiler.model.ATLInstruction;
import org.eclipse.m2m.atl.profiler.model.ModelPackage;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profiling Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl#getLaunchedTime <em>Launched Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl#getStackFrames <em>Stack Frames</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl#getParentOperation <em>Parent Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl#getInstructionID <em>Instruction ID</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl#getAtlInstruction <em>Atl Instruction</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl#getLaunchedMemoryUsage <em>Launched Memory Usage</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ProfilingInstructionImpl#isHasError <em>Has Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfilingInstructionImpl extends EObjectImpl implements ProfilingInstruction {
	/**
	 * The default value of the '{@link #getLaunchedTime() <em>Launched Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchedTime()
	 * @generated
	 * @ordered
	 */
	protected static final long LAUNCHED_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getLaunchedTime() <em>Launched Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchedTime()
	 * @generated
	 * @ordered
	 */
	protected long launchedTime = LAUNCHED_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStackFrames() <em>Stack Frames</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackFrames()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> stackFrames;

	/**
	 * The cached value of the '{@link #getParentOperation() <em>Parent Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentOperation()
	 * @generated
	 * @ordered
	 */
	protected ProfilingOperation parentOperation;

	/**
	 * The default value of the '{@link #getInstructionID() <em>Instruction ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructionID()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTRUCTION_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInstructionID() <em>Instruction ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructionID()
	 * @generated
	 * @ordered
	 */
	protected int instructionID = INSTRUCTION_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAtlInstruction() <em>Atl Instruction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtlInstruction()
	 * @generated
	 * @ordered
	 */
	protected ATLInstruction atlInstruction;

	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaunchedMemoryUsage() <em>Launched Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchedMemoryUsage()
	 * @generated
	 * @ordered
	 */
	protected static final long LAUNCHED_MEMORY_USAGE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getLaunchedMemoryUsage() <em>Launched Memory Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchedMemoryUsage()
	 * @generated
	 * @ordered
	 */
	protected long launchedMemoryUsage = LAUNCHED_MEMORY_USAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasError() <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasError()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_ERROR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasError() <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasError()
	 * @generated
	 * @ordered
	 */
	protected boolean hasError = HAS_ERROR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfilingInstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROFILING_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLaunchedTime() {
		return launchedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaunchedTime(long newLaunchedTime) {
		long oldLaunchedTime = launchedTime;
		launchedTime = newLaunchedTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_TIME, oldLaunchedTime, launchedTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getStackFrames() {
		if (stackFrames == null) {
			stackFrames = new EDataTypeUniqueEList<Object>(Object.class, this, ModelPackage.PROFILING_INSTRUCTION__STACK_FRAMES);
		}
		return stackFrames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingOperation getParentOperation() {
		if (parentOperation != null && parentOperation.eIsProxy()) {
			InternalEObject oldParentOperation = (InternalEObject)parentOperation;
			parentOperation = (ProfilingOperation)eResolveProxy(oldParentOperation);
			if (parentOperation != oldParentOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PROFILING_INSTRUCTION__PARENT_OPERATION, oldParentOperation, parentOperation));
			}
		}
		return parentOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingOperation basicGetParentOperation() {
		return parentOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentOperation(ProfilingOperation newParentOperation) {
		ProfilingOperation oldParentOperation = parentOperation;
		parentOperation = newParentOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_INSTRUCTION__PARENT_OPERATION, oldParentOperation, parentOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInstructionID() {
		return instructionID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstructionID(int newInstructionID) {
		int oldInstructionID = instructionID;
		instructionID = newInstructionID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_INSTRUCTION__INSTRUCTION_ID, oldInstructionID, instructionID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ATLInstruction getAtlInstruction() {
		if (atlInstruction != null && atlInstruction.eIsProxy()) {
			InternalEObject oldAtlInstruction = (InternalEObject)atlInstruction;
			atlInstruction = (ATLInstruction)eResolveProxy(oldAtlInstruction);
			if (atlInstruction != oldAtlInstruction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PROFILING_INSTRUCTION__ATL_INSTRUCTION, oldAtlInstruction, atlInstruction));
			}
		}
		return atlInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ATLInstruction basicGetAtlInstruction() {
		return atlInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtlInstruction(ATLInstruction newAtlInstruction) {
		ATLInstruction oldAtlInstruction = atlInstruction;
		atlInstruction = newAtlInstruction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_INSTRUCTION__ATL_INSTRUCTION, oldAtlInstruction, atlInstruction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_INSTRUCTION__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLaunchedMemoryUsage() {
		return launchedMemoryUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaunchedMemoryUsage(long newLaunchedMemoryUsage) {
		long oldLaunchedMemoryUsage = launchedMemoryUsage;
		launchedMemoryUsage = newLaunchedMemoryUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_MEMORY_USAGE, oldLaunchedMemoryUsage, launchedMemoryUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasError() {
		return hasError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasError(boolean newHasError) {
		boolean oldHasError = hasError;
		hasError = newHasError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROFILING_INSTRUCTION__HAS_ERROR, oldHasError, hasError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_TIME:
				return new Long(getLaunchedTime());
			case ModelPackage.PROFILING_INSTRUCTION__STACK_FRAMES:
				return getStackFrames();
			case ModelPackage.PROFILING_INSTRUCTION__PARENT_OPERATION:
				if (resolve) return getParentOperation();
				return basicGetParentOperation();
			case ModelPackage.PROFILING_INSTRUCTION__INSTRUCTION_ID:
				return new Integer(getInstructionID());
			case ModelPackage.PROFILING_INSTRUCTION__ATL_INSTRUCTION:
				if (resolve) return getAtlInstruction();
				return basicGetAtlInstruction();
			case ModelPackage.PROFILING_INSTRUCTION__CONTENT:
				return getContent();
			case ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_MEMORY_USAGE:
				return new Long(getLaunchedMemoryUsage());
			case ModelPackage.PROFILING_INSTRUCTION__HAS_ERROR:
				return isHasError() ? Boolean.TRUE : Boolean.FALSE;
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
			case ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_TIME:
				setLaunchedTime(((Long)newValue).longValue());
				return;
			case ModelPackage.PROFILING_INSTRUCTION__STACK_FRAMES:
				getStackFrames().clear();
				getStackFrames().addAll((Collection<? extends Object>)newValue);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__PARENT_OPERATION:
				setParentOperation((ProfilingOperation)newValue);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__INSTRUCTION_ID:
				setInstructionID(((Integer)newValue).intValue());
				return;
			case ModelPackage.PROFILING_INSTRUCTION__ATL_INSTRUCTION:
				setAtlInstruction((ATLInstruction)newValue);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__CONTENT:
				setContent((String)newValue);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_MEMORY_USAGE:
				setLaunchedMemoryUsage(((Long)newValue).longValue());
				return;
			case ModelPackage.PROFILING_INSTRUCTION__HAS_ERROR:
				setHasError(((Boolean)newValue).booleanValue());
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
			case ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_TIME:
				setLaunchedTime(LAUNCHED_TIME_EDEFAULT);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__STACK_FRAMES:
				getStackFrames().clear();
				return;
			case ModelPackage.PROFILING_INSTRUCTION__PARENT_OPERATION:
				setParentOperation((ProfilingOperation)null);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__INSTRUCTION_ID:
				setInstructionID(INSTRUCTION_ID_EDEFAULT);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__ATL_INSTRUCTION:
				setAtlInstruction((ATLInstruction)null);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_MEMORY_USAGE:
				setLaunchedMemoryUsage(LAUNCHED_MEMORY_USAGE_EDEFAULT);
				return;
			case ModelPackage.PROFILING_INSTRUCTION__HAS_ERROR:
				setHasError(HAS_ERROR_EDEFAULT);
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
			case ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_TIME:
				return launchedTime != LAUNCHED_TIME_EDEFAULT;
			case ModelPackage.PROFILING_INSTRUCTION__STACK_FRAMES:
				return stackFrames != null && !stackFrames.isEmpty();
			case ModelPackage.PROFILING_INSTRUCTION__PARENT_OPERATION:
				return parentOperation != null;
			case ModelPackage.PROFILING_INSTRUCTION__INSTRUCTION_ID:
				return instructionID != INSTRUCTION_ID_EDEFAULT;
			case ModelPackage.PROFILING_INSTRUCTION__ATL_INSTRUCTION:
				return atlInstruction != null;
			case ModelPackage.PROFILING_INSTRUCTION__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case ModelPackage.PROFILING_INSTRUCTION__LAUNCHED_MEMORY_USAGE:
				return launchedMemoryUsage != LAUNCHED_MEMORY_USAGE_EDEFAULT;
			case ModelPackage.PROFILING_INSTRUCTION__HAS_ERROR:
				return hasError != HAS_ERROR_EDEFAULT;
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
		result.append(" (launchedTime: ");
		result.append(launchedTime);
		result.append(", stackFrames: ");
		result.append(stackFrames);
		result.append(", instructionID: ");
		result.append(instructionID);
		result.append(", content: ");
		result.append(content);
		result.append(", launchedMemoryUsage: ");
		result.append(launchedMemoryUsage);
		result.append(", hasError: ");
		result.append(hasError);
		result.append(')');
		return result.toString();
	}

} //ProfilingInstructionImpl
