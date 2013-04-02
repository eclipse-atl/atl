/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * POJO test class B.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class PojoB extends EObjectImpl {

	private Set<String> nameSet;
	private List<TestEnum> enumList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PojoB() {
		super();
	}

	/**
	 * @return the nameSet
	 */
	public Set<String> getNameSet() {
		if (nameSet == null) {
			nameSet = new HashSet<String>();
		}
		return nameSet;
	}

	/**
	 * @param nameSet
	 *            the nameSet to set
	 */
	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

	/**
	 * @return the enumList
	 */
	public List<TestEnum> getEnumList() {
		if (enumList == null) {
			enumList = new ArrayList<TestEnum>();
		}
		return enumList;
	}

	/**
	 * @param enumList
	 *            the enumList to set
	 */
	public void setEnumList(List<TestEnum> enumList) {
		this.enumList = enumList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PojoPackage.Literals.POJO_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PojoPackage.POJO_B__NAME_SET:
				return getNameSet();
			case PojoPackage.POJO_B__ENUM_LIST:
				return getEnumList();
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
			case PojoPackage.POJO_B__NAME_SET:
				getNameSet().clear();
				getNameSet().addAll((Collection<? extends String>)newValue);
				return;
			case PojoPackage.POJO_B__ENUM_LIST:
				getEnumList().clear();
				getEnumList().addAll((Collection<? extends TestEnum>)newValue);
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
			case PojoPackage.POJO_B__NAME_SET:
				getNameSet().clear();
				return;
			case PojoPackage.POJO_B__ENUM_LIST:
				getEnumList().clear();
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
			case PojoPackage.POJO_B__NAME_SET:
				return nameSet != null && !nameSet.isEmpty();
			case PojoPackage.POJO_B__ENUM_LIST:
				return enumList != null && !enumList.isEmpty();
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
		result.append(" (nameSet: ");
		result.append(nameSet);
		result.append(", enumList: ");
		result.append(enumList);
		result.append(')');
		return result.toString();
	}

}
