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


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportRoot;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Export Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportRootImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportRootImpl#getTotalTime <em>Total Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.ExportRootImpl#getTotalInstructions <em>Total Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExportRootImpl extends EObjectImpl implements ExportRoot {
	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<AtlOperationExport> operation;

	/**
	 * The default value of the '{@link #getTotalTime() <em>Total Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalTime()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalTime() <em>Total Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalTime()
	 * @generated
	 * @ordered
	 */
	protected double totalTime = TOTAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalInstructions() <em>Total Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalInstructions()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_INSTRUCTIONS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalInstructions() <em>Total Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalInstructions()
	 * @generated
	 * @ordered
	 */
	protected long totalInstructions = TOTAL_INSTRUCTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExportRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExportmodelPackage.Literals.EXPORT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AtlOperationExport> getOperation() {
		if (operation == null) {
			operation = new EObjectContainmentEList<AtlOperationExport>(AtlOperationExport.class, this, ExportmodelPackage.EXPORT_ROOT__OPERATION);
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalTime() {
		return totalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalTime(double newTotalTime) {
		double oldTotalTime = totalTime;
		totalTime = newTotalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ROOT__TOTAL_TIME, oldTotalTime, totalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalInstructions() {
		return totalInstructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalInstructions(long newTotalInstructions) {
		long oldTotalInstructions = totalInstructions;
		totalInstructions = newTotalInstructions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.EXPORT_ROOT__TOTAL_INSTRUCTIONS, oldTotalInstructions, totalInstructions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExportmodelPackage.EXPORT_ROOT__OPERATION:
				return ((InternalEList<?>)getOperation()).basicRemove(otherEnd, msgs);
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
			case ExportmodelPackage.EXPORT_ROOT__OPERATION:
				return getOperation();
			case ExportmodelPackage.EXPORT_ROOT__TOTAL_TIME:
				return new Double(getTotalTime());
			case ExportmodelPackage.EXPORT_ROOT__TOTAL_INSTRUCTIONS:
				return new Long(getTotalInstructions());
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
			case ExportmodelPackage.EXPORT_ROOT__OPERATION:
				getOperation().clear();
				getOperation().addAll((Collection<? extends AtlOperationExport>)newValue);
				return;
			case ExportmodelPackage.EXPORT_ROOT__TOTAL_TIME:
				setTotalTime(((Double)newValue).doubleValue());
				return;
			case ExportmodelPackage.EXPORT_ROOT__TOTAL_INSTRUCTIONS:
				setTotalInstructions(((Long)newValue).longValue());
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
			case ExportmodelPackage.EXPORT_ROOT__OPERATION:
				getOperation().clear();
				return;
			case ExportmodelPackage.EXPORT_ROOT__TOTAL_TIME:
				setTotalTime(TOTAL_TIME_EDEFAULT);
				return;
			case ExportmodelPackage.EXPORT_ROOT__TOTAL_INSTRUCTIONS:
				setTotalInstructions(TOTAL_INSTRUCTIONS_EDEFAULT);
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
			case ExportmodelPackage.EXPORT_ROOT__OPERATION:
				return operation != null && !operation.isEmpty();
			case ExportmodelPackage.EXPORT_ROOT__TOTAL_TIME:
				return totalTime != TOTAL_TIME_EDEFAULT;
			case ExportmodelPackage.EXPORT_ROOT__TOTAL_INSTRUCTIONS:
				return totalInstructions != TOTAL_INSTRUCTIONS_EDEFAULT;
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
		result.append(" (totalTime: "); //$NON-NLS-1$
		result.append(totalTime);
		result.append(", totalInstructions: "); //$NON-NLS-1$
		result.append(totalInstructions);
		result.append(')');
		return result.toString();
	}

} //ExportRootImpl
