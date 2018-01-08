/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Findtype;
import org.eclipse.m2m.atl.emftvm.Opcode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Findtype</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.FindtypeImpl#getModelname <em>Modelname</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.FindtypeImpl#getTypename <em>Typename</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FindtypeImpl extends InstructionImpl implements Findtype {
	/**
	 * The default value of the '{@link #getModelname() <em>Modelname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelname()
	 * @generated
	 * @ordered
	 */
	protected static final String MODELNAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getModelname() <em>Modelname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelname()
	 * @generated
	 * @ordered
	 */
	protected String modelname = MODELNAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getTypename() <em>Typename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypename()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPENAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTypename() <em>Typename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypename()
	 * @generated
	 * @ordered
	 */
	protected String typename = TYPENAME_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link FindtypeImpl}.
	 * <!-- end-user-doc -->
	 */
	protected FindtypeImpl() {
		super();
		opcode = Opcode.FINDTYPE;
		stackProduction = 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the {@link EClass} that correspond to this metaclass.
	 * @return the {@link EClass} that correspond to this metaclass.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.FINDTYPE;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelname() {
		return modelname;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelname(String newModelname) {
		String oldModelname = modelname;
		modelname = newModelname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.FINDTYPE__MODELNAME, oldModelname, modelname));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypename() {
		return typename;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypename(String newTypename) {
		String oldTypename = typename;
		typename = newTypename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.FINDTYPE__TYPENAME, oldTypename, typename));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmftvmPackage.FINDTYPE__MODELNAME:
				return getModelname();
			case EmftvmPackage.FINDTYPE__TYPENAME:
				return getTypename();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.FINDTYPE__MODELNAME:
				setModelname((String)newValue);
				return;
			case EmftvmPackage.FINDTYPE__TYPENAME:
				setTypename((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmftvmPackage.FINDTYPE__MODELNAME:
				setModelname(MODELNAME_EDEFAULT);
				return;
			case EmftvmPackage.FINDTYPE__TYPENAME:
				setTypename(TYPENAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmftvmPackage.FINDTYPE__MODELNAME:
				return MODELNAME_EDEFAULT == null ? modelname != null : !MODELNAME_EDEFAULT.equals(modelname);
			case EmftvmPackage.FINDTYPE__TYPENAME:
				return TYPENAME_EDEFAULT == null ? typename != null : !TYPENAME_EDEFAULT.equals(typename);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modelname: ");
		result.append(modelname);
		result.append(", typename: ");
		result.append(typename);
		result.append(')');
		return result.toString();
	}

} //FindtypeImpl
