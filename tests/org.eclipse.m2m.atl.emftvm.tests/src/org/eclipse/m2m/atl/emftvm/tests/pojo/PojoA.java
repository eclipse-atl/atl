/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.tests.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * POJO test class A.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class PojoA extends EObjectImpl {

	private Set<PojoB> bSet;
	private List<PojoB> bList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PojoA() {
		super();
	}

	/**
	 * @return the bSet
	 */
	public Set<PojoB> getBSet() {
		if (bSet == null) {
			bSet = new HashSet<PojoB>();
		}
		return bSet;
	}

	/**
	 * @param bSet
	 *            the bSet to set
	 */
	public void setBSet(Set<PojoB> bSet) {
		this.bSet = bSet;
	}

	/**
	 * @return the bList
	 */
	public List<PojoB> getBList() {
		if (bList == null) {
			bList = new ArrayList<PojoB>();
		}
		return bList;
	}

	/**
	 * @param bList
	 *            the bList to set
	 */
	public void setBList(List<PojoB> bList) {
		this.bList = bList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PojoPackage.Literals.POJO_A;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PojoPackage.POJO_A__BSET:
				return getBSet();
			case PojoPackage.POJO_A__BLIST:
				return getBList();
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
			case PojoPackage.POJO_A__BSET:
				getBSet().clear();
				getBSet().addAll((Collection<? extends PojoB>)newValue);
				return;
			case PojoPackage.POJO_A__BLIST:
				getBList().clear();
				getBList().addAll((Collection<? extends PojoB>)newValue);
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
			case PojoPackage.POJO_A__BSET:
				getBSet().clear();
				return;
			case PojoPackage.POJO_A__BLIST:
				getBList().clear();
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
			case PojoPackage.POJO_A__BSET:
				return bSet != null && !bSet.isEmpty();
			case PojoPackage.POJO_A__BLIST:
				return bList != null && !bList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

}
