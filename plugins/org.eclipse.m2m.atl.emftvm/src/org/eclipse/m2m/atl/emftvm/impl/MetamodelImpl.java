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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.util.EMFTVMUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MetamodelImpl extends ModelImpl implements Metamodel {

	/**
	 * Lookup table of ((type name) -> (type)).
	 */
	protected Map<String, EClassifier> types = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetamodelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.METAMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @param typeName the name of the type to find
	 * @return The EMF type with the given typeName in the metamodel with modelName
	 * @throws IllegalArgumentException if the type was not found
	 * <!-- end-user-doc -->
	 */
	public EClassifier findType(String typeName) {
		if (types == null) {
			types = createTypeTable();
		}
		final EClassifier type = types.get(typeName);
		if (type == null) {
			throw new IllegalArgumentException(String.format("Type %s not found in metamodel %s", typeName, this));
		}
		return type;
	}

	/**
	 * @return A new type lookup table.
	 */
	private Map<String, EClassifier> createTypeTable() {
		final Map<String, EClassifier> types = new HashMap<String, EClassifier>();
		final Resource res = getResource();
		assert res != null;
		registerTypeChain(types, res, null, new HashSet<Object>());
		return types;
	}

	/**
	 * Registers all types reachable from objects in the types lookup table
	 * @param types the lookup table to register types in
	 * @param res the resource to search for type information (meta-model)
	 * @param ns the namespace
	 * @param ignore the set of objects to ignore
	 */
	private static void registerTypeChain(
			final Map<String, EClassifier> types, 
			final Resource res,
			final String ns, 
			final Set<Object> ignore) {
		if (res != null && !ignore.contains(res)) {
			ignore.add(res);
			registerTypeChain(types, res.getContents(), null, ignore);
		}
	}

	/**
	 * Registers all types reachable from objects in the types lookup table
	 * @param types the lookup table to register types in
	 * @param objects the objects to search for type information (meta-model contents)
	 * @param ns the namespace
	 * @param ignore the set of objects to ignore
	 */
	private static void registerTypeChain(
			final Map<String, EClassifier> types, 
			final EList<EObject> objects,
			final String ns, 
			final Set<Object> ignore) {
		for (EObject o : objects) {
			switch (o.eClass().getClassifierID()) {
			case EcorePackage.EPACKAGE:
				String pname = ((EPackage) o).getName();
				if (ns != null) {
					pname = ns + EMFTVMUtil.NS_DELIM + pname;
				}
				registerTypeChain(types, o.eContents(), pname, ignore);
				break;
			case EcorePackage.ECLASSIFIER: //TODO Report EMF BUG: only EClass instances are returned!
			case EcorePackage.ECLASS:
				registerTypeChain(types, (EClassifier) o, ns, ignore);
				break;
			default:
				// No meta-package or meta-class => just keep digging.
				// N.B. This situation occurs in UML2 profiles, where
				// EPackages containing EClasses are buried somewhere
				// underneath other elements.
				registerTypeChain(types, o.eContents(), ns, ignore);
			}
		}
	}

	/**
	 * Registers all types reachable from type in the types lookup table
	 * @param types the lookup table to register types in
	 * @param type the type to register, and search for other type references
	 * @param ns the namespace
	 * @param ignore the set of objects to ignore
	 */
	private static void registerTypeChain(
			final Map<String, EClassifier> types, 
			final EClassifier type,
			final String ns, 
			final Set<Object> ignore) {
		if (ignore.contains(type)) {
			return;
		}
		ignore.add(type);
		registerSingleType(types, ns + EMFTVMUtil.NS_DELIM + type.getName(), type);
		registerSingleType(types, type.getName(), type);
		if (type instanceof EClass) {
			final EClass cls = (EClass) type;
			for (EStructuralFeature sf : cls.getEStructuralFeatures()) {
				EClassifier eType = sf.getEType();
				if (eType != null) {
					registerTypeChain(types, eType.eResource(), null, ignore);
				}
			}
			for (EOperation op : cls.getEOperations()) {
				EClassifier eType = op.getEType();
				if (eType != null) {
					registerTypeChain(types, eType.eResource(), null, ignore);
				}
				for (EParameter p : op.getEParameters()) {
					eType = p.getEType();
					if (eType != null) {
						registerTypeChain(types, eType.eResource(), null, ignore);
					}
				}
			}
			for (EClass superCls : cls.getESuperTypes()) {
				registerTypeChain(types, superCls.eResource(), null, ignore);
			}
		}
	}

	private static void registerSingleType(final Map<String, EClassifier> types, final String typeName,
			final EClassifier type) {
		if (types.containsKey(typeName)) {
			ATLLogger.warning(String.format("Metamodel contains more than one type with name %s"));
		}
		types.put(typeName, type);
	}

} //MetamodelImpl
