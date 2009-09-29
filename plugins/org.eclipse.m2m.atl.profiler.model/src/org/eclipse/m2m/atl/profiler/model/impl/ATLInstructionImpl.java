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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.m2m.atl.profiler.model.ATLInstruction;
import org.eclipse.m2m.atl.profiler.model.ModelPackage;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ATL Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ATLInstructionImpl#getATLElementRef <em>ATL Element Ref</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ATLInstructionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.profiler.model.impl.ATLInstructionImpl#getProfilingInstructions <em>Profiling Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ATLInstructionImpl extends EObjectImpl implements ATLInstruction {
	/**
	 * The default value of the '{@link #getATLElementRef() <em>ATL Element Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getATLElementRef()
	 * @generated
	 * @ordered
	 */
	protected static final Object ATL_ELEMENT_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getATLElementRef() <em>ATL Element Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getATLElementRef()
	 * @generated
	 * @ordered
	 */
	protected Object atlElementRef = ATL_ELEMENT_REF_EDEFAULT;

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
	 * The cached value of the '{@link #getProfilingInstructions() <em>Profiling Instructions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfilingInstructions()
	 * @generated
	 * @ordered
	 */
	protected EList<ProfilingInstruction> profilingInstructions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ATLInstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ATL_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getATLElementRef() {
		return atlElementRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setATLElementRef(Object newATLElementRef) {
		Object oldATLElementRef = atlElementRef;
		atlElementRef = newATLElementRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATL_INSTRUCTION__ATL_ELEMENT_REF, oldATLElementRef, atlElementRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATL_INSTRUCTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProfilingInstruction> getProfilingInstructions() {
		if (profilingInstructions == null) {
			profilingInstructions = new EObjectResolvingEList<ProfilingInstruction>(ProfilingInstruction.class, this, ModelPackage.ATL_INSTRUCTION__PROFILING_INSTRUCTIONS);
		}
		return profilingInstructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ATL_INSTRUCTION__ATL_ELEMENT_REF:
				return getATLElementRef();
			case ModelPackage.ATL_INSTRUCTION__NAME:
				return getName();
			case ModelPackage.ATL_INSTRUCTION__PROFILING_INSTRUCTIONS:
				return getProfilingInstructions();
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
			case ModelPackage.ATL_INSTRUCTION__ATL_ELEMENT_REF:
				setATLElementRef(newValue);
				return;
			case ModelPackage.ATL_INSTRUCTION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.ATL_INSTRUCTION__PROFILING_INSTRUCTIONS:
				getProfilingInstructions().clear();
				getProfilingInstructions().addAll((Collection<? extends ProfilingInstruction>)newValue);
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
			case ModelPackage.ATL_INSTRUCTION__ATL_ELEMENT_REF:
				setATLElementRef(ATL_ELEMENT_REF_EDEFAULT);
				return;
			case ModelPackage.ATL_INSTRUCTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.ATL_INSTRUCTION__PROFILING_INSTRUCTIONS:
				getProfilingInstructions().clear();
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
			case ModelPackage.ATL_INSTRUCTION__ATL_ELEMENT_REF:
				return ATL_ELEMENT_REF_EDEFAULT == null ? atlElementRef != null : !ATL_ELEMENT_REF_EDEFAULT.equals(atlElementRef);
			case ModelPackage.ATL_INSTRUCTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.ATL_INSTRUCTION__PROFILING_INSTRUCTIONS:
				return profilingInstructions != null && !profilingInstructions.isEmpty();
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
		result.append(" (ATLElementRef: ");
		result.append(atlElementRef);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ATLInstructionImpl
