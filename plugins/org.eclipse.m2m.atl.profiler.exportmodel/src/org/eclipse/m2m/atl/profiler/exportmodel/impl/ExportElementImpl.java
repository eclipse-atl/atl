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
package org.eclipse.m2m.atl.profiler.exportmodel.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportElement;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Export Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl#getTimExecution <em>Tim Execution</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl#getInstructions <em>Instructions</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl#getBeginMemory <em>Begin Memory</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl#getMaxMemory <em>Max Memory</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl#getEndMemory <em>End Memory</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl#getTotalTimeExecutionPercent <em>Total Time Execution Percent</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportElementImpl#getTotalInstructionsPercent <em>Total Instructions Percent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExportElementImpl extends EObjectImpl implements ExportElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimExecution() <em>Tim Execution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimExecution()
	 * @generated
	 * @ordered
	 */
	protected static final double TIM_EXECUTION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTimExecution() <em>Tim Execution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimExecution()
	 * @generated
	 * @ordered
	 */
	protected double timExecution = TIM_EXECUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstructions() <em>Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructions()
	 * @generated
	 * @ordered
	 */
	protected static final long INSTRUCTIONS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getInstructions() <em>Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructions()
	 * @generated
	 * @ordered
	 */
	protected long instructions = INSTRUCTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBeginMemory() <em>Begin Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long BEGIN_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBeginMemory() <em>Begin Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginMemory()
	 * @generated
	 * @ordered
	 */
	protected long beginMemory = BEGIN_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxMemory() <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxMemory() <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMemory()
	 * @generated
	 * @ordered
	 */
	protected long maxMemory = MAX_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndMemory() <em>End Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long END_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEndMemory() <em>End Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndMemory()
	 * @generated
	 * @ordered
	 */
	protected long endMemory = END_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalTimeExecutionPercent() <em>Total Time Execution Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalTimeExecutionPercent()
	 * @generated
	 * @ordered
	 */
	protected static final String TOTAL_TIME_EXECUTION_PERCENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTotalTimeExecutionPercent() <em>Total Time Execution Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalTimeExecutionPercent()
	 * @generated
	 * @ordered
	 */
	protected String totalTimeExecutionPercent = TOTAL_TIME_EXECUTION_PERCENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalInstructionsPercent() <em>Total Instructions Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalInstructionsPercent()
	 * @generated
	 * @ordered
	 */
	protected static final String TOTAL_INSTRUCTIONS_PERCENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTotalInstructionsPercent() <em>Total Instructions Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalInstructionsPercent()
	 * @generated
	 * @ordered
	 */
	protected String totalInstructionsPercent = TOTAL_INSTRUCTIONS_PERCENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExportElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExportmodelPackage.Literals.EXPORT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTimExecution() {
		return timExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimExecution(double newTimExecution) {
		double oldTimExecution = timExecution;
		timExecution = newTimExecution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ELEMENT__TIM_EXECUTION, oldTimExecution, timExecution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getInstructions() {
		return instructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstructions(long newInstructions) {
		long oldInstructions = instructions;
		instructions = newInstructions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ELEMENT__INSTRUCTIONS, oldInstructions, instructions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getBeginMemory() {
		return beginMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeginMemory(long newBeginMemory) {
		long oldBeginMemory = beginMemory;
		beginMemory = newBeginMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ELEMENT__BEGIN_MEMORY, oldBeginMemory, beginMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaxMemory() {
		return maxMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxMemory(long newMaxMemory) {
		long oldMaxMemory = maxMemory;
		maxMemory = newMaxMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ELEMENT__MAX_MEMORY, oldMaxMemory, maxMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEndMemory() {
		return endMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndMemory(long newEndMemory) {
		long oldEndMemory = endMemory;
		endMemory = newEndMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ELEMENT__END_MEMORY, oldEndMemory, endMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTotalTimeExecutionPercent() {
		return totalTimeExecutionPercent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalTimeExecutionPercent(String newTotalTimeExecutionPercent) {
		String oldTotalTimeExecutionPercent = totalTimeExecutionPercent;
		totalTimeExecutionPercent = newTotalTimeExecutionPercent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT, oldTotalTimeExecutionPercent, totalTimeExecutionPercent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTotalInstructionsPercent() {
		return totalInstructionsPercent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalInstructionsPercent(String newTotalInstructionsPercent) {
		String oldTotalInstructionsPercent = totalInstructionsPercent;
		totalInstructionsPercent = newTotalInstructionsPercent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT, oldTotalInstructionsPercent, totalInstructionsPercent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExportmodelPackage.EXPORT_ELEMENT__NAME:
				return getName();
			case ExportmodelPackage.EXPORT_ELEMENT__TIM_EXECUTION:
				return new Double(getTimExecution());
			case ExportmodelPackage.EXPORT_ELEMENT__INSTRUCTIONS:
				return new Long(getInstructions());
			case ExportmodelPackage.EXPORT_ELEMENT__BEGIN_MEMORY:
				return new Long(getBeginMemory());
			case ExportmodelPackage.EXPORT_ELEMENT__MAX_MEMORY:
				return new Long(getMaxMemory());
			case ExportmodelPackage.EXPORT_ELEMENT__END_MEMORY:
				return new Long(getEndMemory());
			case ExportmodelPackage.EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT:
				return getTotalTimeExecutionPercent();
			case ExportmodelPackage.EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT:
				return getTotalInstructionsPercent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExportmodelPackage.EXPORT_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__TIM_EXECUTION:
				setTimExecution(((Double)newValue).doubleValue());
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__INSTRUCTIONS:
				setInstructions(((Long)newValue).longValue());
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__BEGIN_MEMORY:
				setBeginMemory(((Long)newValue).longValue());
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__MAX_MEMORY:
				setMaxMemory(((Long)newValue).longValue());
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__END_MEMORY:
				setEndMemory(((Long)newValue).longValue());
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT:
				setTotalTimeExecutionPercent((String)newValue);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT:
				setTotalInstructionsPercent((String)newValue);
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
			case ExportmodelPackage.EXPORT_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__TIM_EXECUTION:
				setTimExecution(TIM_EXECUTION_EDEFAULT);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__INSTRUCTIONS:
				setInstructions(INSTRUCTIONS_EDEFAULT);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__BEGIN_MEMORY:
				setBeginMemory(BEGIN_MEMORY_EDEFAULT);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__MAX_MEMORY:
				setMaxMemory(MAX_MEMORY_EDEFAULT);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__END_MEMORY:
				setEndMemory(END_MEMORY_EDEFAULT);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT:
				setTotalTimeExecutionPercent(TOTAL_TIME_EXECUTION_PERCENT_EDEFAULT);
				return;
			case ExportmodelPackage.EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT:
				setTotalInstructionsPercent(TOTAL_INSTRUCTIONS_PERCENT_EDEFAULT);
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
			case ExportmodelPackage.EXPORT_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExportmodelPackage.EXPORT_ELEMENT__TIM_EXECUTION:
				return timExecution != TIM_EXECUTION_EDEFAULT;
			case ExportmodelPackage.EXPORT_ELEMENT__INSTRUCTIONS:
				return instructions != INSTRUCTIONS_EDEFAULT;
			case ExportmodelPackage.EXPORT_ELEMENT__BEGIN_MEMORY:
				return beginMemory != BEGIN_MEMORY_EDEFAULT;
			case ExportmodelPackage.EXPORT_ELEMENT__MAX_MEMORY:
				return maxMemory != MAX_MEMORY_EDEFAULT;
			case ExportmodelPackage.EXPORT_ELEMENT__END_MEMORY:
				return endMemory != END_MEMORY_EDEFAULT;
			case ExportmodelPackage.EXPORT_ELEMENT__TOTAL_TIME_EXECUTION_PERCENT:
				return TOTAL_TIME_EXECUTION_PERCENT_EDEFAULT == null ? totalTimeExecutionPercent != null : !TOTAL_TIME_EXECUTION_PERCENT_EDEFAULT.equals(totalTimeExecutionPercent);
			case ExportmodelPackage.EXPORT_ELEMENT__TOTAL_INSTRUCTIONS_PERCENT:
				return TOTAL_INSTRUCTIONS_PERCENT_EDEFAULT == null ? totalInstructionsPercent != null : !TOTAL_INSTRUCTIONS_PERCENT_EDEFAULT.equals(totalInstructionsPercent);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", timExecution: ");
		result.append(timExecution);
		result.append(", instructions: ");
		result.append(instructions);
		result.append(", beginMemory: ");
		result.append(beginMemory);
		result.append(", maxMemory: ");
		result.append(maxMemory);
		result.append(", endMemory: ");
		result.append(endMemory);
		result.append(", totalTimeExecutionPercent: ");
		result.append(totalTimeExecutionPercent);
		result.append(", totalInstructionsPercent: ");
		result.append(totalInstructionsPercent);
		result.append(')');
		return result.toString();
	}

} //ExportElementImpl
