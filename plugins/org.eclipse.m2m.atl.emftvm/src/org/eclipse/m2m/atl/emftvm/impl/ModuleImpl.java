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


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.ModelDeclaration;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl#getSourceName <em>Source Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl#getEImports <em>EImports</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl#getInputModels <em>Input Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl#getInoutModels <em>Inout Models</em>}</li>
 *   <li>{@link org.eclipse.m2m.atl.emftvm.impl.ModuleImpl#getOutputModels <em>Output Models</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends NamedElementImpl implements Module {
	/**
	 * The default value of the '{@link #getSourceName() <em>Source Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSourceName() <em>Source Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceName()
	 * @generated
	 * @ordered
	 */
	protected String sourceName = SOURCE_NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;
	/**
	 * The cached value of the '{@link #getEImports() <em>EImports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Module> eImports;
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<String> imports;
	/**
	 * The cached value of the '{@link #getInputModels() <em>Input Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclaration> inputModels;
	/**
	 * The cached value of the '{@link #getInoutModels() <em>Inout Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoutModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclaration> inoutModels;
	/**
	 * The cached value of the '{@link #getOutputModels() <em>Output Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclaration> outputModels;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new {@link ModuleImpl}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
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
		return EmftvmPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceName(String newSourceName) {
		String oldSourceName = sourceName;
		sourceName = newSourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmftvmPackage.MODULE__SOURCE_NAME, oldSourceName, sourceName));
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, EmftvmPackage.MODULE__FEATURES, EmftvmPackage.FEATURE__MODULE);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentWithInverseEList<Rule>(Rule.class, this, EmftvmPackage.MODULE__RULES, EmftvmPackage.RULE__MODULE);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Module> getEImports() {
		if (eImports == null) {
			eImports = new EObjectResolvingEList<Module>(Module.class, this, EmftvmPackage.MODULE__EIMPORTS);
		}
		return eImports;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getImports() {
		if (imports == null) {
			imports = new EDataTypeUniqueEList<String>(String.class, this, EmftvmPackage.MODULE__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclaration> getInputModels() {
		if (inputModels == null) {
			inputModels = new EObjectContainmentWithInverseEList<ModelDeclaration>(ModelDeclaration.class, this, EmftvmPackage.MODULE__INPUT_MODELS, EmftvmPackage.MODEL_DECLARATION__INPUT_MODEL_FOR);
		}
		return inputModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclaration> getInoutModels() {
		if (inoutModels == null) {
			inoutModels = new EObjectContainmentWithInverseEList<ModelDeclaration>(ModelDeclaration.class, this, EmftvmPackage.MODULE__INOUT_MODELS, EmftvmPackage.MODEL_DECLARATION__INOUT_MODEL_FOR);
		}
		return inoutModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclaration> getOutputModels() {
		if (outputModels == null) {
			outputModels = new EObjectContainmentWithInverseEList<ModelDeclaration>(ModelDeclaration.class, this, EmftvmPackage.MODULE__OUTPUT_MODELS, EmftvmPackage.MODEL_DECLARATION__OUTPUT_MODEL_FOR);
		}
		return outputModels;
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.MODULE__FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeatures()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.MODULE__RULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRules()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.MODULE__INPUT_MODELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputModels()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.MODULE__INOUT_MODELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInoutModels()).basicAdd(otherEnd, msgs);
			case EmftvmPackage.MODULE__OUTPUT_MODELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputModels()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmftvmPackage.MODULE__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.MODULE__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.MODULE__INPUT_MODELS:
				return ((InternalEList<?>)getInputModels()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.MODULE__INOUT_MODELS:
				return ((InternalEList<?>)getInoutModels()).basicRemove(otherEnd, msgs);
			case EmftvmPackage.MODULE__OUTPUT_MODELS:
				return ((InternalEList<?>)getOutputModels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case EmftvmPackage.MODULE__SOURCE_NAME:
				return getSourceName();
			case EmftvmPackage.MODULE__FEATURES:
				return getFeatures();
			case EmftvmPackage.MODULE__RULES:
				return getRules();
			case EmftvmPackage.MODULE__EIMPORTS:
				return getEImports();
			case EmftvmPackage.MODULE__IMPORTS:
				return getImports();
			case EmftvmPackage.MODULE__INPUT_MODELS:
				return getInputModels();
			case EmftvmPackage.MODULE__INOUT_MODELS:
				return getInoutModels();
			case EmftvmPackage.MODULE__OUTPUT_MODELS:
				return getOutputModels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmftvmPackage.MODULE__SOURCE_NAME:
				setSourceName((String)newValue);
				return;
			case EmftvmPackage.MODULE__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case EmftvmPackage.MODULE__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case EmftvmPackage.MODULE__EIMPORTS:
				getEImports().clear();
				getEImports().addAll((Collection<? extends Module>)newValue);
				return;
			case EmftvmPackage.MODULE__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends String>)newValue);
				return;
			case EmftvmPackage.MODULE__INPUT_MODELS:
				getInputModels().clear();
				getInputModels().addAll((Collection<? extends ModelDeclaration>)newValue);
				return;
			case EmftvmPackage.MODULE__INOUT_MODELS:
				getInoutModels().clear();
				getInoutModels().addAll((Collection<? extends ModelDeclaration>)newValue);
				return;
			case EmftvmPackage.MODULE__OUTPUT_MODELS:
				getOutputModels().clear();
				getOutputModels().addAll((Collection<? extends ModelDeclaration>)newValue);
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
			case EmftvmPackage.MODULE__SOURCE_NAME:
				setSourceName(SOURCE_NAME_EDEFAULT);
				return;
			case EmftvmPackage.MODULE__FEATURES:
				getFeatures().clear();
				return;
			case EmftvmPackage.MODULE__RULES:
				getRules().clear();
				return;
			case EmftvmPackage.MODULE__EIMPORTS:
				getEImports().clear();
				return;
			case EmftvmPackage.MODULE__IMPORTS:
				getImports().clear();
				return;
			case EmftvmPackage.MODULE__INPUT_MODELS:
				getInputModels().clear();
				return;
			case EmftvmPackage.MODULE__INOUT_MODELS:
				getInoutModels().clear();
				return;
			case EmftvmPackage.MODULE__OUTPUT_MODELS:
				getOutputModels().clear();
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
			case EmftvmPackage.MODULE__SOURCE_NAME:
				return SOURCE_NAME_EDEFAULT == null ? sourceName != null : !SOURCE_NAME_EDEFAULT.equals(sourceName);
			case EmftvmPackage.MODULE__FEATURES:
				return features != null && !features.isEmpty();
			case EmftvmPackage.MODULE__RULES:
				return rules != null && !rules.isEmpty();
			case EmftvmPackage.MODULE__EIMPORTS:
				return eImports != null && !eImports.isEmpty();
			case EmftvmPackage.MODULE__IMPORTS:
				return imports != null && !imports.isEmpty();
			case EmftvmPackage.MODULE__INPUT_MODELS:
				return inputModels != null && !inputModels.isEmpty();
			case EmftvmPackage.MODULE__INOUT_MODELS:
				return inoutModels != null && !inoutModels.isEmpty();
			case EmftvmPackage.MODULE__OUTPUT_MODELS:
				return outputModels != null && !outputModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc. -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		Resource r = eResource();
		if (r != null) {
			String path = r.getURI().toString();
			result.append(path.substring(0, path.lastIndexOf('/') + 1));
		}
		if (eIsSet(EmftvmPackage.MODULE__SOURCE_NAME)) {
			result.append(sourceName);
		} else {
			result.append(super.toString());
		}
		return result.toString();
	}

	/**
	 * Returns the ASM version (for debugger).
	 * @return the ASM version ("ETVM")
	 */
	public String getVersion() {
		return "ETVM";
	}

} //ModuleImpl
