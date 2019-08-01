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
package org.eclipse.m2m.atl.profiler.exportmodel.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.profiler.exportmodel.AtlOperationExport;
import org.eclipse.m2m.atl.profiler.exportmodel.ExportmodelPackage;
import org.eclipse.m2m.atl.profiler.exportmodel.ProfilingOperationExport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atl Operation Export</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.AtlOperationExportImpl#getCalls <em>Calls</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.exportmodel.impl.AtlOperationExportImpl#getProfilingOperation <em>Profiling Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtlOperationExportImpl extends ExportElementImpl implements AtlOperationExport {
	/**
	 * The default value of the '{@link #getCalls() <em>Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalls()
	 * @generated
	 * @ordered
	 */
	protected static final long CALLS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCalls() <em>Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalls()
	 * @generated
	 * @ordered
	 */
	protected long calls = CALLS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProfilingOperation() <em>Profiling Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfilingOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<ProfilingOperationExport> profilingOperation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtlOperationExportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExportmodelPackage.Literals.ATL_OPERATION_EXPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCalls() {
		return calls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalls(long newCalls) {
		long oldCalls = calls;
		calls = newCalls;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExportmodelPackage.ATL_OPERATION_EXPORT__CALLS, oldCalls, calls));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProfilingOperationExport> getProfilingOperation() {
		if (profilingOperation == null) {
			profilingOperation = new EObjectContainmentEList<ProfilingOperationExport>(ProfilingOperationExport.class, this, ExportmodelPackage.ATL_OPERATION_EXPORT__PROFILING_OPERATION);
		}
		return profilingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExportmodelPackage.ATL_OPERATION_EXPORT__PROFILING_OPERATION:
				return ((InternalEList<?>)getProfilingOperation()).basicRemove(otherEnd, msgs);
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
			case ExportmodelPackage.ATL_OPERATION_EXPORT__CALLS:
				return new Long(getCalls());
			case ExportmodelPackage.ATL_OPERATION_EXPORT__PROFILING_OPERATION:
				return getProfilingOperation();
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
			case ExportmodelPackage.ATL_OPERATION_EXPORT__CALLS:
				setCalls(((Long)newValue).longValue());
				return;
			case ExportmodelPackage.ATL_OPERATION_EXPORT__PROFILING_OPERATION:
				getProfilingOperation().clear();
				getProfilingOperation().addAll((Collection<? extends ProfilingOperationExport>)newValue);
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
			case ExportmodelPackage.ATL_OPERATION_EXPORT__CALLS:
				setCalls(CALLS_EDEFAULT);
				return;
			case ExportmodelPackage.ATL_OPERATION_EXPORT__PROFILING_OPERATION:
				getProfilingOperation().clear();
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
			case ExportmodelPackage.ATL_OPERATION_EXPORT__CALLS:
				return calls != CALLS_EDEFAULT;
			case ExportmodelPackage.ATL_OPERATION_EXPORT__PROFILING_OPERATION:
				return profilingOperation != null && !profilingOperation.isEmpty();
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
		result.append(" (calls: ");
		result.append(calls);
		result.append(')');
		return result.toString();
	}

} //AtlOperationExportImpl
