/**
 * Copyright (c) 2008, 2012, 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 */
package org.eclipse.m2m.atl.common.ATL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.m2m.atl.common.OCL.OCLPackage;

import org.eclipse.m2m.atl.common.PrimitiveTypes.PrimitiveTypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.atl.common.ATL.ATLFactory
 * @model kind="package"
 * @generated
 */
public class ATLPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "ATL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.eclipse.org/gmt/2005/ATL";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "atl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ATLPackage eINSTANCE = org.eclipse.m2m.atl.common.ATL.ATLPackage.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.LocatedElement <em>Located Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.LocatedElement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getLocatedElement()
	 * @generated
	 */
	public static final int LOCATED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCATED_ELEMENT__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCATED_ELEMENT__COMMENTS_BEFORE = 1;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCATED_ELEMENT__COMMENTS_AFTER = 2;

	/**
	 * The number of structural features of the '<em>Located Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCATED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.Unit <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.Unit
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getUnit()
	 * @generated
	 */
	public static final int UNIT = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNIT__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNIT__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNIT__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNIT__LIBRARIES = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNIT__NAME = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNIT_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.Library <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.Library
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getLibrary()
	 * @generated
	 */
	public static final int LIBRARY = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__LOCATION = UNIT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__COMMENTS_BEFORE = UNIT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__COMMENTS_AFTER = UNIT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__LIBRARIES = UNIT__LIBRARIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__NAME = UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Helpers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY__HELPERS = UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY_FEATURE_COUNT = UNIT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.Query <em>Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.Query
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getQuery()
	 * @generated
	 */
	public static final int QUERY = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY__LOCATION = UNIT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY__COMMENTS_BEFORE = UNIT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY__COMMENTS_AFTER = UNIT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY__LIBRARIES = UNIT__LIBRARIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY__NAME = UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY__BODY = UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Helpers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY__HELPERS = UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY_FEATURE_COUNT = UNIT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.Module <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.Module
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModule()
	 * @generated
	 */
	public static final int MODULE = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__LOCATION = UNIT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__COMMENTS_BEFORE = UNIT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__COMMENTS_AFTER = UNIT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__LIBRARIES = UNIT__LIBRARIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__NAME = UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Is Refining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__IS_REFINING = UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__IN_MODELS = UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Out Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__OUT_MODELS = UNIT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE__ELEMENTS = UNIT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE_FEATURE_COUNT = UNIT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.ModuleElement <em>Module Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.ModuleElement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModuleElement()
	 * @generated
	 */
	public static final int MODULE_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE_ELEMENT__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE_ELEMENT__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE_ELEMENT__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE_ELEMENT__MODULE = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULE_ELEMENT_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.Helper <em>Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.Helper
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getHelper()
	 * @generated
	 */
	public static final int HELPER = 6;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HELPER__LOCATION = MODULE_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HELPER__COMMENTS_BEFORE = MODULE_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HELPER__COMMENTS_AFTER = MODULE_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HELPER__MODULE = MODULE_ELEMENT__MODULE;

	/**
	 * The feature id for the '<em><b>Query</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HELPER__QUERY = MODULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Library</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HELPER__LIBRARY = MODULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HELPER__DEFINITION = MODULE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HELPER_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.Rule <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.Rule
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRule()
	 * @generated
	 */
	public static final int RULE = 7;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__LOCATION = MODULE_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__COMMENTS_BEFORE = MODULE_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__COMMENTS_AFTER = MODULE_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__MODULE = MODULE_ELEMENT__MODULE;

	/**
	 * The feature id for the '<em><b>Out Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__OUT_PATTERN = MODULE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__ACTION_BLOCK = MODULE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__VARIABLES = MODULE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__NAME = MODULE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_FEATURE_COUNT = MODULE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule <em>Matched Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule()
	 * @generated
	 */
	public static final int MATCHED_RULE = 8;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__LOCATION = RULE__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__COMMENTS_BEFORE = RULE__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__COMMENTS_AFTER = RULE__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__MODULE = RULE__MODULE;

	/**
	 * The feature id for the '<em><b>Out Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__OUT_PATTERN = RULE__OUT_PATTERN;

	/**
	 * The feature id for the '<em><b>Action Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__ACTION_BLOCK = RULE__ACTION_BLOCK;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__VARIABLES = RULE__VARIABLES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__NAME = RULE__NAME;

	/**
	 * The feature id for the '<em><b>In Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__IN_PATTERN = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__CHILDREN = RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__SUPER_RULE = RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__IS_ABSTRACT = RULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Refining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__IS_REFINING = RULE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is No Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE__IS_NO_DEFAULT = RULE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Matched Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MATCHED_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.LazyMatchedRule <em>Lazy Matched Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.LazyMatchedRule
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getLazyMatchedRule()
	 * @generated
	 */
	public static final int LAZY_MATCHED_RULE = 9;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__LOCATION = MATCHED_RULE__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__COMMENTS_BEFORE = MATCHED_RULE__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__COMMENTS_AFTER = MATCHED_RULE__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__MODULE = MATCHED_RULE__MODULE;

	/**
	 * The feature id for the '<em><b>Out Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__OUT_PATTERN = MATCHED_RULE__OUT_PATTERN;

	/**
	 * The feature id for the '<em><b>Action Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__ACTION_BLOCK = MATCHED_RULE__ACTION_BLOCK;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__VARIABLES = MATCHED_RULE__VARIABLES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__NAME = MATCHED_RULE__NAME;

	/**
	 * The feature id for the '<em><b>In Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__IN_PATTERN = MATCHED_RULE__IN_PATTERN;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__CHILDREN = MATCHED_RULE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Super Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__SUPER_RULE = MATCHED_RULE__SUPER_RULE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__IS_ABSTRACT = MATCHED_RULE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Refining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__IS_REFINING = MATCHED_RULE__IS_REFINING;

	/**
	 * The feature id for the '<em><b>Is No Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__IS_NO_DEFAULT = MATCHED_RULE__IS_NO_DEFAULT;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE__IS_UNIQUE = MATCHED_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lazy Matched Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAZY_MATCHED_RULE_FEATURE_COUNT = MATCHED_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.CalledRule <em>Called Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.CalledRule
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getCalledRule()
	 * @generated
	 */
	public static final int CALLED_RULE = 10;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__LOCATION = RULE__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__COMMENTS_BEFORE = RULE__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__COMMENTS_AFTER = RULE__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__MODULE = RULE__MODULE;

	/**
	 * The feature id for the '<em><b>Out Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__OUT_PATTERN = RULE__OUT_PATTERN;

	/**
	 * The feature id for the '<em><b>Action Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__ACTION_BLOCK = RULE__ACTION_BLOCK;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__VARIABLES = RULE__VARIABLES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__NAME = RULE__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__PARAMETERS = RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Entrypoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__IS_ENTRYPOINT = RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE__IS_ENDPOINT = RULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Called Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CALLED_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.InPattern <em>In Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.InPattern
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getInPattern()
	 * @generated
	 */
	public static final int IN_PATTERN = 11;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN__ELEMENTS = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN__RULE = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN__FILTER = LOCATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>In Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.OutPattern <em>Out Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.OutPattern
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPattern()
	 * @generated
	 */
	public static final int OUT_PATTERN = 12;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN__RULE = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Drop Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN__DROP_PATTERN = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN__ELEMENTS = LOCATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Out Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.DropPattern <em>Drop Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.DropPattern
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getDropPattern()
	 * @generated
	 */
	public static final int DROP_PATTERN = 13;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DROP_PATTERN__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DROP_PATTERN__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DROP_PATTERN__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Out Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DROP_PATTERN__OUT_PATTERN = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Drop Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DROP_PATTERN_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.PatternElement <em>Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.PatternElement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getPatternElement()
	 * @generated
	 */
	public static final int PATTERN_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__LOCATION = OCLPackage.VARIABLE_DECLARATION__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__COMMENTS_BEFORE = OCLPackage.VARIABLE_DECLARATION__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__COMMENTS_AFTER = OCLPackage.VARIABLE_DECLARATION__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__ID = OCLPackage.VARIABLE_DECLARATION__ID;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__VAR_NAME = OCLPackage.VARIABLE_DECLARATION__VAR_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__TYPE = OCLPackage.VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__INIT_EXPRESSION = OCLPackage.VARIABLE_DECLARATION__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__LET_EXP = OCLPackage.VARIABLE_DECLARATION__LET_EXP;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__BASE_EXP = OCLPackage.VARIABLE_DECLARATION__BASE_EXP;

	/**
	 * The feature id for the '<em><b>Variable Exp</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT__VARIABLE_EXP = OCLPackage.VARIABLE_DECLARATION__VARIABLE_EXP;

	/**
	 * The number of structural features of the '<em>Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATTERN_ELEMENT_FEATURE_COUNT = OCLPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.InPatternElement <em>In Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.InPatternElement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getInPatternElement()
	 * @generated
	 */
	public static final int IN_PATTERN_ELEMENT = 15;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__LOCATION = PATTERN_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__COMMENTS_BEFORE = PATTERN_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__COMMENTS_AFTER = PATTERN_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__ID = PATTERN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__VAR_NAME = PATTERN_ELEMENT__VAR_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__TYPE = PATTERN_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__INIT_EXPRESSION = PATTERN_ELEMENT__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__LET_EXP = PATTERN_ELEMENT__LET_EXP;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__BASE_EXP = PATTERN_ELEMENT__BASE_EXP;

	/**
	 * The feature id for the '<em><b>Variable Exp</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__VARIABLE_EXP = PATTERN_ELEMENT__VARIABLE_EXP;

	/**
	 * The feature id for the '<em><b>Maps To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__MAPS_TO = PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__IN_PATTERN = PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT__MODELS = PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>In Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IN_PATTERN_ELEMENT_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement <em>Simple In Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getSimpleInPatternElement()
	 * @generated
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__LOCATION = IN_PATTERN_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__COMMENTS_BEFORE = IN_PATTERN_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__COMMENTS_AFTER = IN_PATTERN_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__ID = IN_PATTERN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__VAR_NAME = IN_PATTERN_ELEMENT__VAR_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__TYPE = IN_PATTERN_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__INIT_EXPRESSION = IN_PATTERN_ELEMENT__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__LET_EXP = IN_PATTERN_ELEMENT__LET_EXP;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__BASE_EXP = IN_PATTERN_ELEMENT__BASE_EXP;

	/**
	 * The feature id for the '<em><b>Variable Exp</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__VARIABLE_EXP = IN_PATTERN_ELEMENT__VARIABLE_EXP;

	/**
	 * The feature id for the '<em><b>Maps To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__MAPS_TO = IN_PATTERN_ELEMENT__MAPS_TO;

	/**
	 * The feature id for the '<em><b>In Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__IN_PATTERN = IN_PATTERN_ELEMENT__IN_PATTERN;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT__MODELS = IN_PATTERN_ELEMENT__MODELS;

	/**
	 * The number of structural features of the '<em>Simple In Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_IN_PATTERN_ELEMENT_FEATURE_COUNT = IN_PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement <em>Out Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.OutPatternElement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPatternElement()
	 * @generated
	 */
	public static final int OUT_PATTERN_ELEMENT = 17;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__LOCATION = PATTERN_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__COMMENTS_BEFORE = PATTERN_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__COMMENTS_AFTER = PATTERN_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__ID = PATTERN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__VAR_NAME = PATTERN_ELEMENT__VAR_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__TYPE = PATTERN_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__INIT_EXPRESSION = PATTERN_ELEMENT__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__LET_EXP = PATTERN_ELEMENT__LET_EXP;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__BASE_EXP = PATTERN_ELEMENT__BASE_EXP;

	/**
	 * The feature id for the '<em><b>Variable Exp</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__VARIABLE_EXP = PATTERN_ELEMENT__VARIABLE_EXP;

	/**
	 * The feature id for the '<em><b>Out Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__OUT_PATTERN = PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__SOURCE_ELEMENT = PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__BINDINGS = PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT__MODEL = PATTERN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Out Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PATTERN_ELEMENT_FEATURE_COUNT = PATTERN_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement <em>Simple Out Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getSimpleOutPatternElement()
	 * @generated
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT = 18;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__LOCATION = OUT_PATTERN_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__COMMENTS_BEFORE = OUT_PATTERN_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__COMMENTS_AFTER = OUT_PATTERN_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__ID = OUT_PATTERN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__VAR_NAME = OUT_PATTERN_ELEMENT__VAR_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__TYPE = OUT_PATTERN_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__INIT_EXPRESSION = OUT_PATTERN_ELEMENT__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__LET_EXP = OUT_PATTERN_ELEMENT__LET_EXP;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__BASE_EXP = OUT_PATTERN_ELEMENT__BASE_EXP;

	/**
	 * The feature id for the '<em><b>Variable Exp</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__VARIABLE_EXP = OUT_PATTERN_ELEMENT__VARIABLE_EXP;

	/**
	 * The feature id for the '<em><b>Out Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__OUT_PATTERN = OUT_PATTERN_ELEMENT__OUT_PATTERN;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__SOURCE_ELEMENT = OUT_PATTERN_ELEMENT__SOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__BINDINGS = OUT_PATTERN_ELEMENT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__MODEL = OUT_PATTERN_ELEMENT__MODEL;

	/**
	 * The feature id for the '<em><b>Reverse Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS = OUT_PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Out Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_OUT_PATTERN_ELEMENT_FEATURE_COUNT = OUT_PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement <em>For Each Out Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getForEachOutPatternElement()
	 * @generated
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT = 19;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__LOCATION = OUT_PATTERN_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__COMMENTS_BEFORE = OUT_PATTERN_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__COMMENTS_AFTER = OUT_PATTERN_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__ID = OUT_PATTERN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__VAR_NAME = OUT_PATTERN_ELEMENT__VAR_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__TYPE = OUT_PATTERN_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__INIT_EXPRESSION = OUT_PATTERN_ELEMENT__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__LET_EXP = OUT_PATTERN_ELEMENT__LET_EXP;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__BASE_EXP = OUT_PATTERN_ELEMENT__BASE_EXP;

	/**
	 * The feature id for the '<em><b>Variable Exp</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__VARIABLE_EXP = OUT_PATTERN_ELEMENT__VARIABLE_EXP;

	/**
	 * The feature id for the '<em><b>Out Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__OUT_PATTERN = OUT_PATTERN_ELEMENT__OUT_PATTERN;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__SOURCE_ELEMENT = OUT_PATTERN_ELEMENT__SOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__BINDINGS = OUT_PATTERN_ELEMENT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__MODEL = OUT_PATTERN_ELEMENT__MODEL;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__COLLECTION = OUT_PATTERN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT__ITERATOR = OUT_PATTERN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For Each Out Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_OUT_PATTERN_ELEMENT_FEATURE_COUNT = OUT_PATTERN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.Binding <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.Binding
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getBinding()
	 * @generated
	 */
	public static final int BINDING = 20;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING__VALUE = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out Pattern Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING__OUT_PATTERN_ELEMENT = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING__PROPERTY_NAME = LOCATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING__IS_ASSIGNMENT = LOCATED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration <em>Rule Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRuleVariableDeclaration()
	 * @generated
	 */
	public static final int RULE_VARIABLE_DECLARATION = 21;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__LOCATION = OCLPackage.VARIABLE_DECLARATION__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__COMMENTS_BEFORE = OCLPackage.VARIABLE_DECLARATION__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__COMMENTS_AFTER = OCLPackage.VARIABLE_DECLARATION__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__ID = OCLPackage.VARIABLE_DECLARATION__ID;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__VAR_NAME = OCLPackage.VARIABLE_DECLARATION__VAR_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__TYPE = OCLPackage.VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__INIT_EXPRESSION = OCLPackage.VARIABLE_DECLARATION__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__LET_EXP = OCLPackage.VARIABLE_DECLARATION__LET_EXP;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__BASE_EXP = OCLPackage.VARIABLE_DECLARATION__BASE_EXP;

	/**
	 * The feature id for the '<em><b>Variable Exp</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__VARIABLE_EXP = OCLPackage.VARIABLE_DECLARATION__VARIABLE_EXP;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION__RULE = OCLPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rule Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_VARIABLE_DECLARATION_FEATURE_COUNT = OCLPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.LibraryRef <em>Library Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.LibraryRef
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getLibraryRef()
	 * @generated
	 */
	public static final int LIBRARY_REF = 22;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY_REF__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY_REF__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY_REF__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY_REF__UNIT = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY_REF__NAME = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Library Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIBRARY_REF_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.ActionBlock <em>Action Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.ActionBlock
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getActionBlock()
	 * @generated
	 */
	public static final int ACTION_BLOCK = 23;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTION_BLOCK__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTION_BLOCK__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTION_BLOCK__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTION_BLOCK__RULE = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTION_BLOCK__STATEMENTS = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Action Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTION_BLOCK_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.Statement <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.Statement
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getStatement()
	 * @generated
	 */
	public static final int STATEMENT = 24;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STATEMENT__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STATEMENT__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STATEMENT__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STATEMENT_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.ExpressionStat <em>Expression Stat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.ExpressionStat
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getExpressionStat()
	 * @generated
	 */
	public static final int EXPRESSION_STAT = 25;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_STAT__LOCATION = STATEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_STAT__COMMENTS_BEFORE = STATEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_STAT__COMMENTS_AFTER = STATEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_STAT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Stat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_STAT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.BindingStat <em>Binding Stat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.BindingStat
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getBindingStat()
	 * @generated
	 */
	public static final int BINDING_STAT = 26;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_STAT__LOCATION = STATEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_STAT__COMMENTS_BEFORE = STATEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_STAT__COMMENTS_AFTER = STATEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_STAT__SOURCE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_STAT__PROPERTY_NAME = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_STAT__IS_ASSIGNMENT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_STAT__VALUE = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Binding Stat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINDING_STAT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.IfStat <em>If Stat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.IfStat
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getIfStat()
	 * @generated
	 */
	public static final int IF_STAT = 27;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IF_STAT__LOCATION = STATEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IF_STAT__COMMENTS_BEFORE = STATEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IF_STAT__COMMENTS_AFTER = STATEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IF_STAT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IF_STAT__THEN_STATEMENTS = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IF_STAT__ELSE_STATEMENTS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Stat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IF_STAT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.common.ATL.ForStat <em>For Stat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.common.ATL.ForStat
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getForStat()
	 * @generated
	 */
	public static final int FOR_STAT = 28;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_STAT__LOCATION = STATEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_STAT__COMMENTS_BEFORE = STATEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_STAT__COMMENTS_AFTER = STATEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_STAT__ITERATOR = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_STAT__COLLECTION = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_STAT__STATEMENTS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>For Stat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_STAT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locatedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass helperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchedRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lazyMatchedRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calledRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dropPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleInPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleOutPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachOutPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionStatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingStatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStatEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ATLPackage() {
		super(eNS_URI, ATLFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ATLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ATLPackage init() {
		if (isInited) return (ATLPackage)EPackage.Registry.INSTANCE.getEPackage(ATLPackage.eNS_URI);

		// Obtain or create and register package
		ATLPackage theATLPackage = (ATLPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ATLPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ATLPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		OCLPackage theOCLPackage = (OCLPackage)(EPackage.Registry.INSTANCE.getEPackage(OCLPackage.eNS_URI) instanceof OCLPackage ? EPackage.Registry.INSTANCE.getEPackage(OCLPackage.eNS_URI) : OCLPackage.eINSTANCE);
		PrimitiveTypesPackage thePrimitiveTypesPackage = (PrimitiveTypesPackage)(EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesPackage.eNS_URI) instanceof PrimitiveTypesPackage ? EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesPackage.eNS_URI) : PrimitiveTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theATLPackage.createPackageContents();
		theOCLPackage.createPackageContents();
		thePrimitiveTypesPackage.createPackageContents();

		// Initialize created meta-data
		theATLPackage.initializePackageContents();
		theOCLPackage.initializePackageContents();
		thePrimitiveTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theATLPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ATLPackage.eNS_URI, theATLPackage);
		return theATLPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.LocatedElement <em>Located Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Located Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LocatedElement
	 * @generated
	 */
	public EClass getLocatedElement() {
		return locatedElementEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.LocatedElement#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LocatedElement#getLocation()
	 * @see #getLocatedElement()
	 * @generated
	 */
	public EAttribute getLocatedElement_Location() {
		return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.common.ATL.LocatedElement#getCommentsBefore <em>Comments Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Comments Before</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LocatedElement#getCommentsBefore()
	 * @see #getLocatedElement()
	 * @generated
	 */
	public EAttribute getLocatedElement_CommentsBefore() {
		return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.m2m.atl.common.ATL.LocatedElement#getCommentsAfter <em>Comments After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Comments After</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LocatedElement#getCommentsAfter()
	 * @see #getLocatedElement()
	 * @generated
	 */
	public EAttribute getLocatedElement_CommentsAfter() {
		return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Unit
	 * @generated
	 */
	public EClass getUnit() {
		return unitEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.Unit#getLibraries <em>Libraries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Libraries</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Unit#getLibraries()
	 * @see #getUnit()
	 * @generated
	 */
	public EReference getUnit_Libraries() {
		return (EReference)unitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.Unit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Unit#getName()
	 * @see #getUnit()
	 * @generated
	 */
	public EAttribute getUnit_Name() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Library
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.Library#getHelpers <em>Helpers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Helpers</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Library#getHelpers()
	 * @see #getLibrary()
	 * @generated
	 */
	public EReference getLibrary_Helpers() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Query
	 * @generated
	 */
	public EClass getQuery() {
		return queryEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.Query#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Query#getBody()
	 * @see #getQuery()
	 * @generated
	 */
	public EReference getQuery_Body() {
		return (EReference)queryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.Query#getHelpers <em>Helpers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Helpers</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Query#getHelpers()
	 * @see #getQuery()
	 * @generated
	 */
	public EReference getQuery_Helpers() {
		return (EReference)queryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Module
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.Module#isIsRefining <em>Is Refining</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Refining</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Module#isIsRefining()
	 * @see #getModule()
	 * @generated
	 */
	public EAttribute getModule_IsRefining() {
		return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.Module#getInModels <em>In Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>In Models</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Module#getInModels()
	 * @see #getModule()
	 * @generated
	 */
	public EReference getModule_InModels() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.Module#getOutModels <em>Out Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Out Models</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Module#getOutModels()
	 * @see #getModule()
	 * @generated
	 */
	public EReference getModule_OutModels() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.Module#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Module#getElements()
	 * @see #getModule()
	 * @generated
	 */
	public EReference getModule_Elements() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.ModuleElement <em>Module Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ModuleElement
	 * @generated
	 */
	public EClass getModuleElement() {
		return moduleElementEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.ModuleElement#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Module</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ModuleElement#getModule()
	 * @see #getModuleElement()
	 * @generated
	 */
	public EReference getModuleElement_Module() {
		return (EReference)moduleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.Helper <em>Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Helper</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Helper
	 * @generated
	 */
	public EClass getHelper() {
		return helperEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.Helper#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Query</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Helper#getQuery()
	 * @see #getHelper()
	 * @generated
	 */
	public EReference getHelper_Query() {
		return (EReference)helperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.Helper#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Library</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Helper#getLibrary()
	 * @see #getHelper()
	 * @generated
	 */
	public EReference getHelper_Library() {
		return (EReference)helperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.Helper#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Helper#getDefinition()
	 * @see #getHelper()
	 * @generated
	 */
	public EReference getHelper_Definition() {
		return (EReference)helperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Rule
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.Rule#getOutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Rule#getOutPattern()
	 * @see #getRule()
	 * @generated
	 */
	public EReference getRule_OutPattern() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.Rule#getActionBlock <em>Action Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action Block</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Rule#getActionBlock()
	 * @see #getRule()
	 * @generated
	 */
	public EReference getRule_ActionBlock() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.Rule#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Rule#getVariables()
	 * @see #getRule()
	 * @generated
	 */
	public EReference getRule_Variables() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.Rule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Rule#getName()
	 * @see #getRule()
	 * @generated
	 */
	public EAttribute getRule_Name() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule <em>Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matched Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule
	 * @generated
	 */
	public EClass getMatchedRule() {
		return matchedRuleEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getInPattern <em>In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule#getInPattern()
	 * @see #getMatchedRule()
	 * @generated
	 */
	public EReference getMatchedRule_InPattern() {
		return (EReference)matchedRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule#getChildren()
	 * @see #getMatchedRule()
	 * @generated
	 */
	public EReference getMatchedRule_Children() {
		return (EReference)matchedRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#getSuperRule <em>Super Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule#getSuperRule()
	 * @see #getMatchedRule()
	 * @generated
	 */
	public EReference getMatchedRule_SuperRule() {
		return (EReference)matchedRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsAbstract()
	 * @see #getMatchedRule()
	 * @generated
	 */
	public EAttribute getMatchedRule_IsAbstract() {
		return (EAttribute)matchedRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsRefining <em>Is Refining</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Refining</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsRefining()
	 * @see #getMatchedRule()
	 * @generated
	 */
	public EAttribute getMatchedRule_IsRefining() {
		return (EAttribute)matchedRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsNoDefault <em>Is No Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is No Default</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule#isIsNoDefault()
	 * @see #getMatchedRule()
	 * @generated
	 */
	public EAttribute getMatchedRule_IsNoDefault() {
		return (EAttribute)matchedRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.LazyMatchedRule <em>Lazy Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lazy Matched Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LazyMatchedRule
	 * @generated
	 */
	public EClass getLazyMatchedRule() {
		return lazyMatchedRuleEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.LazyMatchedRule#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LazyMatchedRule#isIsUnique()
	 * @see #getLazyMatchedRule()
	 * @generated
	 */
	public EAttribute getLazyMatchedRule_IsUnique() {
		return (EAttribute)lazyMatchedRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.CalledRule <em>Called Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Called Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.CalledRule
	 * @generated
	 */
	public EClass getCalledRule() {
		return calledRuleEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.CalledRule#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.CalledRule#getParameters()
	 * @see #getCalledRule()
	 * @generated
	 */
	public EReference getCalledRule_Parameters() {
		return (EReference)calledRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.CalledRule#isIsEntrypoint <em>Is Entrypoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Entrypoint</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.CalledRule#isIsEntrypoint()
	 * @see #getCalledRule()
	 * @generated
	 */
	public EAttribute getCalledRule_IsEntrypoint() {
		return (EAttribute)calledRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.CalledRule#isIsEndpoint <em>Is Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Endpoint</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.CalledRule#isIsEndpoint()
	 * @see #getCalledRule()
	 * @generated
	 */
	public EAttribute getCalledRule_IsEndpoint() {
		return (EAttribute)calledRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.InPattern <em>In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.InPattern
	 * @generated
	 */
	public EClass getInPattern() {
		return inPatternEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.InPattern#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.InPattern#getElements()
	 * @see #getInPattern()
	 * @generated
	 */
	public EReference getInPattern_Elements() {
		return (EReference)inPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.InPattern#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.InPattern#getRule()
	 * @see #getInPattern()
	 * @generated
	 */
	public EReference getInPattern_Rule() {
		return (EReference)inPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.InPattern#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.InPattern#getFilter()
	 * @see #getInPattern()
	 * @generated
	 */
	public EReference getInPattern_Filter() {
		return (EReference)inPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.OutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPattern
	 * @generated
	 */
	public EClass getOutPattern() {
		return outPatternEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPattern#getRule()
	 * @see #getOutPattern()
	 * @generated
	 */
	public EReference getOutPattern_Rule() {
		return (EReference)outPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getDropPattern <em>Drop Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Drop Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPattern#getDropPattern()
	 * @see #getOutPattern()
	 * @generated
	 */
	public EReference getOutPattern_DropPattern() {
		return (EReference)outPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.OutPattern#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPattern#getElements()
	 * @see #getOutPattern()
	 * @generated
	 */
	public EReference getOutPattern_Elements() {
		return (EReference)outPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.DropPattern <em>Drop Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drop Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.DropPattern
	 * @generated
	 */
	public EClass getDropPattern() {
		return dropPatternEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.DropPattern#getOutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Out Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.DropPattern#getOutPattern()
	 * @see #getDropPattern()
	 * @generated
	 */
	public EReference getDropPattern_OutPattern() {
		return (EReference)dropPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.PatternElement <em>Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.PatternElement
	 * @generated
	 */
	public EClass getPatternElement() {
		return patternElementEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.InPatternElement <em>In Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Pattern Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.InPatternElement
	 * @generated
	 */
	public EClass getInPatternElement() {
		return inPatternElementEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.common.ATL.InPatternElement#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Maps To</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.InPatternElement#getMapsTo()
	 * @see #getInPatternElement()
	 * @generated
	 */
	public EReference getInPatternElement_MapsTo() {
		return (EReference)inPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.InPatternElement#getInPattern <em>In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>In Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.InPatternElement#getInPattern()
	 * @see #getInPatternElement()
	 * @generated
	 */
	public EReference getInPatternElement_InPattern() {
		return (EReference)inPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.common.ATL.InPatternElement#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Models</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.InPatternElement#getModels()
	 * @see #getInPatternElement()
	 * @generated
	 */
	public EReference getInPatternElement_Models() {
		return (EReference)inPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement <em>Simple In Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple In Pattern Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement
	 * @generated
	 */
	public EClass getSimpleInPatternElement() {
		return simpleInPatternElementEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement <em>Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Pattern Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPatternElement
	 * @generated
	 */
	public EClass getOutPatternElement() {
		return outPatternElementEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getOutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Out Pattern</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPatternElement#getOutPattern()
	 * @see #getOutPatternElement()
	 * @generated
	 */
	public EReference getOutPatternElement_OutPattern() {
		return (EReference)outPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getSourceElement <em>Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPatternElement#getSourceElement()
	 * @see #getOutPatternElement()
	 * @generated
	 */
	public EReference getOutPatternElement_SourceElement() {
		return (EReference)outPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPatternElement#getBindings()
	 * @see #getOutPatternElement()
	 * @generated
	 */
	public EReference getOutPatternElement_Bindings() {
		return (EReference)outPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.OutPatternElement#getModel()
	 * @see #getOutPatternElement()
	 * @generated
	 */
	public EReference getOutPatternElement_Model() {
		return (EReference)outPatternElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement <em>Simple Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Out Pattern Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement
	 * @generated
	 */
	public EClass getSimpleOutPatternElement() {
		return simpleOutPatternElementEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement#getReverseBindings <em>Reverse Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reverse Bindings</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement#getReverseBindings()
	 * @see #getSimpleOutPatternElement()
	 * @generated
	 */
	public EReference getSimpleOutPatternElement_ReverseBindings() {
		return (EReference)simpleOutPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement <em>For Each Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Each Out Pattern Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement
	 * @generated
	 */
	public EClass getForEachOutPatternElement() {
		return forEachOutPatternElementEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement#getCollection()
	 * @see #getForEachOutPatternElement()
	 * @generated
	 */
	public EReference getForEachOutPatternElement_Collection() {
		return (EReference)forEachOutPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement#getIterator()
	 * @see #getForEachOutPatternElement()
	 * @generated
	 */
	public EReference getForEachOutPatternElement_Iterator() {
		return (EReference)forEachOutPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Binding
	 * @generated
	 */
	public EClass getBinding() {
		return bindingEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.Binding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Binding#getValue()
	 * @see #getBinding()
	 * @generated
	 */
	public EReference getBinding_Value() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.Binding#getOutPatternElement <em>Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Out Pattern Element</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Binding#getOutPatternElement()
	 * @see #getBinding()
	 * @generated
	 */
	public EReference getBinding_OutPatternElement() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.Binding#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Binding#getPropertyName()
	 * @see #getBinding()
	 * @generated
	 */
	public EAttribute getBinding_PropertyName() {
		return (EAttribute)bindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.Binding#isIsAssignment <em>Is Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Assignment</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Binding#isIsAssignment()
	 * @see #getBinding()
	 * @generated
	 */
	public EAttribute getBinding_IsAssignment() {
		return (EAttribute)bindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration <em>Rule Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Variable Declaration</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration
	 * @generated
	 */
	public EClass getRuleVariableDeclaration() {
		return ruleVariableDeclarationEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration#getRule()
	 * @see #getRuleVariableDeclaration()
	 * @generated
	 */
	public EReference getRuleVariableDeclaration_Rule() {
		return (EReference)ruleVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.LibraryRef <em>Library Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Ref</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LibraryRef
	 * @generated
	 */
	public EClass getLibraryRef() {
		return libraryRefEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.LibraryRef#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Unit</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LibraryRef#getUnit()
	 * @see #getLibraryRef()
	 * @generated
	 */
	public EReference getLibraryRef_Unit() {
		return (EReference)libraryRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.LibraryRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.LibraryRef#getName()
	 * @see #getLibraryRef()
	 * @generated
	 */
	public EAttribute getLibraryRef_Name() {
		return (EAttribute)libraryRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.ActionBlock <em>Action Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Block</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ActionBlock
	 * @generated
	 */
	public EClass getActionBlock() {
		return actionBlockEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.common.ATL.ActionBlock#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ActionBlock#getRule()
	 * @see #getActionBlock()
	 * @generated
	 */
	public EReference getActionBlock_Rule() {
		return (EReference)actionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.ActionBlock#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ActionBlock#getStatements()
	 * @see #getActionBlock()
	 * @generated
	 */
	public EReference getActionBlock_Statements() {
		return (EReference)actionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.Statement
	 * @generated
	 */
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.ExpressionStat <em>Expression Stat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Stat</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ExpressionStat
	 * @generated
	 */
	public EClass getExpressionStat() {
		return expressionStatEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.ExpressionStat#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ExpressionStat#getExpression()
	 * @see #getExpressionStat()
	 * @generated
	 */
	public EReference getExpressionStat_Expression() {
		return (EReference)expressionStatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.BindingStat <em>Binding Stat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Stat</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.BindingStat
	 * @generated
	 */
	public EClass getBindingStat() {
		return bindingStatEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.BindingStat#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.BindingStat#getSource()
	 * @see #getBindingStat()
	 * @generated
	 */
	public EReference getBindingStat_Source() {
		return (EReference)bindingStatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.BindingStat#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.BindingStat#getPropertyName()
	 * @see #getBindingStat()
	 * @generated
	 */
	public EAttribute getBindingStat_PropertyName() {
		return (EAttribute)bindingStatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.common.ATL.BindingStat#isIsAssignment <em>Is Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Assignment</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.BindingStat#isIsAssignment()
	 * @see #getBindingStat()
	 * @generated
	 */
	public EAttribute getBindingStat_IsAssignment() {
		return (EAttribute)bindingStatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.BindingStat#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.BindingStat#getValue()
	 * @see #getBindingStat()
	 * @generated
	 */
	public EReference getBindingStat_Value() {
		return (EReference)bindingStatEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.IfStat <em>If Stat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Stat</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.IfStat
	 * @generated
	 */
	public EClass getIfStat() {
		return ifStatEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.IfStat#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.IfStat#getCondition()
	 * @see #getIfStat()
	 * @generated
	 */
	public EReference getIfStat_Condition() {
		return (EReference)ifStatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.IfStat#getThenStatements <em>Then Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Then Statements</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.IfStat#getThenStatements()
	 * @see #getIfStat()
	 * @generated
	 */
	public EReference getIfStat_ThenStatements() {
		return (EReference)ifStatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.IfStat#getElseStatements <em>Else Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Else Statements</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.IfStat#getElseStatements()
	 * @see #getIfStat()
	 * @generated
	 */
	public EReference getIfStat_ElseStatements() {
		return (EReference)ifStatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.common.ATL.ForStat <em>For Stat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Stat</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ForStat
	 * @generated
	 */
	public EClass getForStat() {
		return forStatEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.ForStat#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ForStat#getIterator()
	 * @see #getForStat()
	 * @generated
	 */
	public EReference getForStat_Iterator() {
		return (EReference)forStatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.m2m.atl.common.ATL.ForStat#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ForStat#getCollection()
	 * @see #getForStat()
	 * @generated
	 */
	public EReference getForStat_Collection() {
		return (EReference)forStatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.common.ATL.ForStat#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.m2m.atl.common.ATL.ForStat#getStatements()
	 * @see #getForStat()
	 * @generated
	 */
	public EReference getForStat_Statements() {
		return (EReference)forStatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public ATLFactory getATLFactory() {
		return (ATLFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		locatedElementEClass = createEClass(LOCATED_ELEMENT);
		createEAttribute(locatedElementEClass, LOCATED_ELEMENT__LOCATION);
		createEAttribute(locatedElementEClass, LOCATED_ELEMENT__COMMENTS_BEFORE);
		createEAttribute(locatedElementEClass, LOCATED_ELEMENT__COMMENTS_AFTER);

		unitEClass = createEClass(UNIT);
		createEReference(unitEClass, UNIT__LIBRARIES);
		createEAttribute(unitEClass, UNIT__NAME);

		libraryEClass = createEClass(LIBRARY);
		createEReference(libraryEClass, LIBRARY__HELPERS);

		queryEClass = createEClass(QUERY);
		createEReference(queryEClass, QUERY__BODY);
		createEReference(queryEClass, QUERY__HELPERS);

		moduleEClass = createEClass(MODULE);
		createEAttribute(moduleEClass, MODULE__IS_REFINING);
		createEReference(moduleEClass, MODULE__IN_MODELS);
		createEReference(moduleEClass, MODULE__OUT_MODELS);
		createEReference(moduleEClass, MODULE__ELEMENTS);

		moduleElementEClass = createEClass(MODULE_ELEMENT);
		createEReference(moduleElementEClass, MODULE_ELEMENT__MODULE);

		helperEClass = createEClass(HELPER);
		createEReference(helperEClass, HELPER__QUERY);
		createEReference(helperEClass, HELPER__LIBRARY);
		createEReference(helperEClass, HELPER__DEFINITION);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__OUT_PATTERN);
		createEReference(ruleEClass, RULE__ACTION_BLOCK);
		createEReference(ruleEClass, RULE__VARIABLES);
		createEAttribute(ruleEClass, RULE__NAME);

		matchedRuleEClass = createEClass(MATCHED_RULE);
		createEReference(matchedRuleEClass, MATCHED_RULE__IN_PATTERN);
		createEReference(matchedRuleEClass, MATCHED_RULE__CHILDREN);
		createEReference(matchedRuleEClass, MATCHED_RULE__SUPER_RULE);
		createEAttribute(matchedRuleEClass, MATCHED_RULE__IS_ABSTRACT);
		createEAttribute(matchedRuleEClass, MATCHED_RULE__IS_REFINING);
		createEAttribute(matchedRuleEClass, MATCHED_RULE__IS_NO_DEFAULT);

		lazyMatchedRuleEClass = createEClass(LAZY_MATCHED_RULE);
		createEAttribute(lazyMatchedRuleEClass, LAZY_MATCHED_RULE__IS_UNIQUE);

		calledRuleEClass = createEClass(CALLED_RULE);
		createEReference(calledRuleEClass, CALLED_RULE__PARAMETERS);
		createEAttribute(calledRuleEClass, CALLED_RULE__IS_ENTRYPOINT);
		createEAttribute(calledRuleEClass, CALLED_RULE__IS_ENDPOINT);

		inPatternEClass = createEClass(IN_PATTERN);
		createEReference(inPatternEClass, IN_PATTERN__ELEMENTS);
		createEReference(inPatternEClass, IN_PATTERN__RULE);
		createEReference(inPatternEClass, IN_PATTERN__FILTER);

		outPatternEClass = createEClass(OUT_PATTERN);
		createEReference(outPatternEClass, OUT_PATTERN__RULE);
		createEReference(outPatternEClass, OUT_PATTERN__DROP_PATTERN);
		createEReference(outPatternEClass, OUT_PATTERN__ELEMENTS);

		dropPatternEClass = createEClass(DROP_PATTERN);
		createEReference(dropPatternEClass, DROP_PATTERN__OUT_PATTERN);

		patternElementEClass = createEClass(PATTERN_ELEMENT);

		inPatternElementEClass = createEClass(IN_PATTERN_ELEMENT);
		createEReference(inPatternElementEClass, IN_PATTERN_ELEMENT__MAPS_TO);
		createEReference(inPatternElementEClass, IN_PATTERN_ELEMENT__IN_PATTERN);
		createEReference(inPatternElementEClass, IN_PATTERN_ELEMENT__MODELS);

		simpleInPatternElementEClass = createEClass(SIMPLE_IN_PATTERN_ELEMENT);

		outPatternElementEClass = createEClass(OUT_PATTERN_ELEMENT);
		createEReference(outPatternElementEClass, OUT_PATTERN_ELEMENT__OUT_PATTERN);
		createEReference(outPatternElementEClass, OUT_PATTERN_ELEMENT__SOURCE_ELEMENT);
		createEReference(outPatternElementEClass, OUT_PATTERN_ELEMENT__BINDINGS);
		createEReference(outPatternElementEClass, OUT_PATTERN_ELEMENT__MODEL);

		simpleOutPatternElementEClass = createEClass(SIMPLE_OUT_PATTERN_ELEMENT);
		createEReference(simpleOutPatternElementEClass, SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS);

		forEachOutPatternElementEClass = createEClass(FOR_EACH_OUT_PATTERN_ELEMENT);
		createEReference(forEachOutPatternElementEClass, FOR_EACH_OUT_PATTERN_ELEMENT__COLLECTION);
		createEReference(forEachOutPatternElementEClass, FOR_EACH_OUT_PATTERN_ELEMENT__ITERATOR);

		bindingEClass = createEClass(BINDING);
		createEReference(bindingEClass, BINDING__VALUE);
		createEReference(bindingEClass, BINDING__OUT_PATTERN_ELEMENT);
		createEAttribute(bindingEClass, BINDING__PROPERTY_NAME);
		createEAttribute(bindingEClass, BINDING__IS_ASSIGNMENT);

		ruleVariableDeclarationEClass = createEClass(RULE_VARIABLE_DECLARATION);
		createEReference(ruleVariableDeclarationEClass, RULE_VARIABLE_DECLARATION__RULE);

		libraryRefEClass = createEClass(LIBRARY_REF);
		createEReference(libraryRefEClass, LIBRARY_REF__UNIT);
		createEAttribute(libraryRefEClass, LIBRARY_REF__NAME);

		actionBlockEClass = createEClass(ACTION_BLOCK);
		createEReference(actionBlockEClass, ACTION_BLOCK__RULE);
		createEReference(actionBlockEClass, ACTION_BLOCK__STATEMENTS);

		statementEClass = createEClass(STATEMENT);

		expressionStatEClass = createEClass(EXPRESSION_STAT);
		createEReference(expressionStatEClass, EXPRESSION_STAT__EXPRESSION);

		bindingStatEClass = createEClass(BINDING_STAT);
		createEReference(bindingStatEClass, BINDING_STAT__SOURCE);
		createEAttribute(bindingStatEClass, BINDING_STAT__PROPERTY_NAME);
		createEAttribute(bindingStatEClass, BINDING_STAT__IS_ASSIGNMENT);
		createEReference(bindingStatEClass, BINDING_STAT__VALUE);

		ifStatEClass = createEClass(IF_STAT);
		createEReference(ifStatEClass, IF_STAT__CONDITION);
		createEReference(ifStatEClass, IF_STAT__THEN_STATEMENTS);
		createEReference(ifStatEClass, IF_STAT__ELSE_STATEMENTS);

		forStatEClass = createEClass(FOR_STAT);
		createEReference(forStatEClass, FOR_STAT__ITERATOR);
		createEReference(forStatEClass, FOR_STAT__COLLECTION);
		createEReference(forStatEClass, FOR_STAT__STATEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PrimitiveTypesPackage thePrimitiveTypesPackage = (PrimitiveTypesPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitiveTypesPackage.eNS_URI);
		OCLPackage theOCLPackage = (OCLPackage)EPackage.Registry.INSTANCE.getEPackage(OCLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		unitEClass.getESuperTypes().add(this.getLocatedElement());
		libraryEClass.getESuperTypes().add(this.getUnit());
		queryEClass.getESuperTypes().add(this.getUnit());
		moduleEClass.getESuperTypes().add(this.getUnit());
		moduleElementEClass.getESuperTypes().add(this.getLocatedElement());
		helperEClass.getESuperTypes().add(this.getModuleElement());
		ruleEClass.getESuperTypes().add(this.getModuleElement());
		matchedRuleEClass.getESuperTypes().add(this.getRule());
		lazyMatchedRuleEClass.getESuperTypes().add(this.getMatchedRule());
		calledRuleEClass.getESuperTypes().add(this.getRule());
		inPatternEClass.getESuperTypes().add(this.getLocatedElement());
		outPatternEClass.getESuperTypes().add(this.getLocatedElement());
		dropPatternEClass.getESuperTypes().add(this.getLocatedElement());
		patternElementEClass.getESuperTypes().add(theOCLPackage.getVariableDeclaration());
		inPatternElementEClass.getESuperTypes().add(this.getPatternElement());
		simpleInPatternElementEClass.getESuperTypes().add(this.getInPatternElement());
		outPatternElementEClass.getESuperTypes().add(this.getPatternElement());
		simpleOutPatternElementEClass.getESuperTypes().add(this.getOutPatternElement());
		forEachOutPatternElementEClass.getESuperTypes().add(this.getOutPatternElement());
		bindingEClass.getESuperTypes().add(this.getLocatedElement());
		ruleVariableDeclarationEClass.getESuperTypes().add(theOCLPackage.getVariableDeclaration());
		libraryRefEClass.getESuperTypes().add(this.getLocatedElement());
		actionBlockEClass.getESuperTypes().add(this.getLocatedElement());
		statementEClass.getESuperTypes().add(this.getLocatedElement());
		expressionStatEClass.getESuperTypes().add(this.getStatement());
		bindingStatEClass.getESuperTypes().add(this.getStatement());
		ifStatEClass.getESuperTypes().add(this.getStatement());
		forStatEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes and features; add operations and parameters
		initEClass(locatedElementEClass, LocatedElement.class, "LocatedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocatedElement_Location(), thePrimitiveTypesPackage.getString(), "location", null, 0, 1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLocatedElement_CommentsBefore(), thePrimitiveTypesPackage.getString(), "commentsBefore", null, 0, -1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocatedElement_CommentsAfter(), thePrimitiveTypesPackage.getString(), "commentsAfter", null, 0, -1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnit_Libraries(), this.getLibraryRef(), this.getLibraryRef_Unit(), "libraries", null, 0, -1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUnit_Name(), thePrimitiveTypesPackage.getString(), "name", null, 1, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibrary_Helpers(), this.getHelper(), this.getHelper_Library(), "helpers", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryEClass, Query.class, "Query", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuery_Body(), theOCLPackage.getOclExpression(), null, "body", null, 1, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQuery_Helpers(), this.getHelper(), this.getHelper_Query(), "helpers", null, 0, -1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModule_IsRefining(), thePrimitiveTypesPackage.getBoolean(), "isRefining", null, 1, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getModule_InModels(), theOCLPackage.getOclModel(), null, "inModels", null, 1, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_OutModels(), theOCLPackage.getOclModel(), null, "outModels", null, 1, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getModule_Elements(), this.getModuleElement(), this.getModuleElement_Module(), "elements", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleElementEClass, ModuleElement.class, "ModuleElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleElement_Module(), this.getModule(), this.getModule_Elements(), "module", null, 0, 1, ModuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(helperEClass, Helper.class, "Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHelper_Query(), this.getQuery(), this.getQuery_Helpers(), "query", null, 0, 1, Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHelper_Library(), this.getLibrary(), this.getLibrary_Helpers(), "library", null, 0, 1, Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHelper_Definition(), theOCLPackage.getOclFeatureDefinition(), null, "definition", null, 1, 1, Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_OutPattern(), this.getOutPattern(), this.getOutPattern_Rule(), "outPattern", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRule_ActionBlock(), this.getActionBlock(), this.getActionBlock_Rule(), "actionBlock", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRule_Variables(), this.getRuleVariableDeclaration(), this.getRuleVariableDeclaration_Rule(), "variables", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_Name(), thePrimitiveTypesPackage.getString(), "name", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(matchedRuleEClass, MatchedRule.class, "MatchedRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatchedRule_InPattern(), this.getInPattern(), this.getInPattern_Rule(), "inPattern", null, 0, 1, MatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMatchedRule_Children(), this.getMatchedRule(), this.getMatchedRule_SuperRule(), "children", null, 0, -1, MatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMatchedRule_SuperRule(), this.getMatchedRule(), this.getMatchedRule_Children(), "superRule", null, 0, 1, MatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMatchedRule_IsAbstract(), thePrimitiveTypesPackage.getBoolean(), "isAbstract", null, 1, 1, MatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMatchedRule_IsRefining(), thePrimitiveTypesPackage.getBoolean(), "isRefining", null, 1, 1, MatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMatchedRule_IsNoDefault(), thePrimitiveTypesPackage.getBoolean(), "isNoDefault", null, 1, 1, MatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(lazyMatchedRuleEClass, LazyMatchedRule.class, "LazyMatchedRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLazyMatchedRule_IsUnique(), thePrimitiveTypesPackage.getBoolean(), "isUnique", null, 1, 1, LazyMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(calledRuleEClass, CalledRule.class, "CalledRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCalledRule_Parameters(), theOCLPackage.getParameter(), null, "parameters", null, 0, -1, CalledRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCalledRule_IsEntrypoint(), thePrimitiveTypesPackage.getBoolean(), "isEntrypoint", null, 1, 1, CalledRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCalledRule_IsEndpoint(), thePrimitiveTypesPackage.getBoolean(), "isEndpoint", null, 1, 1, CalledRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inPatternEClass, InPattern.class, "InPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInPattern_Elements(), this.getInPatternElement(), this.getInPatternElement_InPattern(), "elements", null, 1, -1, InPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInPattern_Rule(), this.getMatchedRule(), this.getMatchedRule_InPattern(), "rule", null, 1, 1, InPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInPattern_Filter(), theOCLPackage.getOclExpression(), null, "filter", null, 0, 1, InPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outPatternEClass, OutPattern.class, "OutPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutPattern_Rule(), this.getRule(), this.getRule_OutPattern(), "rule", null, 1, 1, OutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutPattern_DropPattern(), this.getDropPattern(), this.getDropPattern_OutPattern(), "dropPattern", null, 0, 1, OutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutPattern_Elements(), this.getOutPatternElement(), this.getOutPatternElement_OutPattern(), "elements", null, 1, -1, OutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dropPatternEClass, DropPattern.class, "DropPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDropPattern_OutPattern(), this.getOutPattern(), this.getOutPattern_DropPattern(), "outPattern", null, 1, 1, DropPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(patternElementEClass, PatternElement.class, "PatternElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inPatternElementEClass, InPatternElement.class, "InPatternElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInPatternElement_MapsTo(), this.getOutPatternElement(), this.getOutPatternElement_SourceElement(), "mapsTo", null, 0, 1, InPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInPatternElement_InPattern(), this.getInPattern(), this.getInPattern_Elements(), "inPattern", null, 1, 1, InPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInPatternElement_Models(), theOCLPackage.getOclModel(), null, "models", null, 0, -1, InPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(simpleInPatternElementEClass, SimpleInPatternElement.class, "SimpleInPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outPatternElementEClass, OutPatternElement.class, "OutPatternElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutPatternElement_OutPattern(), this.getOutPattern(), this.getOutPattern_Elements(), "outPattern", null, 1, 1, OutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutPatternElement_SourceElement(), this.getInPatternElement(), this.getInPatternElement_MapsTo(), "sourceElement", null, 0, 1, OutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutPatternElement_Bindings(), this.getBinding(), this.getBinding_OutPatternElement(), "bindings", null, 0, -1, OutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutPatternElement_Model(), theOCLPackage.getOclModel(), null, "model", null, 0, 1, OutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(simpleOutPatternElementEClass, SimpleOutPatternElement.class, "SimpleOutPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleOutPatternElement_ReverseBindings(), theOCLPackage.getOclExpression(), null, "reverseBindings", null, 0, -1, SimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forEachOutPatternElementEClass, ForEachOutPatternElement.class, "ForEachOutPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForEachOutPatternElement_Collection(), theOCLPackage.getOclExpression(), null, "collection", null, 1, 1, ForEachOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getForEachOutPatternElement_Iterator(), theOCLPackage.getIterator(), null, "iterator", null, 1, 1, ForEachOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(bindingEClass, Binding.class, "Binding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinding_Value(), theOCLPackage.getOclExpression(), null, "value", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBinding_OutPatternElement(), this.getOutPatternElement(), this.getOutPatternElement_Bindings(), "outPatternElement", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBinding_PropertyName(), thePrimitiveTypesPackage.getString(), "propertyName", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBinding_IsAssignment(), thePrimitiveTypesPackage.getBoolean(), "isAssignment", null, 1, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ruleVariableDeclarationEClass, RuleVariableDeclaration.class, "RuleVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleVariableDeclaration_Rule(), this.getRule(), this.getRule_Variables(), "rule", null, 1, 1, RuleVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(libraryRefEClass, LibraryRef.class, "LibraryRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibraryRef_Unit(), this.getUnit(), this.getUnit_Libraries(), "unit", null, 1, 1, LibraryRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLibraryRef_Name(), thePrimitiveTypesPackage.getString(), "name", null, 1, 1, LibraryRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(actionBlockEClass, ActionBlock.class, "ActionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionBlock_Rule(), this.getRule(), this.getRule_ActionBlock(), "rule", null, 1, 1, ActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActionBlock_Statements(), this.getStatement(), null, "statements", null, 0, -1, ActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionStatEClass, ExpressionStat.class, "ExpressionStat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionStat_Expression(), theOCLPackage.getOclExpression(), null, "expression", null, 1, 1, ExpressionStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(bindingStatEClass, BindingStat.class, "BindingStat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingStat_Source(), theOCLPackage.getOclExpression(), null, "source", null, 1, 1, BindingStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBindingStat_PropertyName(), thePrimitiveTypesPackage.getString(), "propertyName", null, 1, 1, BindingStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBindingStat_IsAssignment(), thePrimitiveTypesPackage.getBoolean(), "isAssignment", null, 1, 1, BindingStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBindingStat_Value(), theOCLPackage.getOclExpression(), null, "value", null, 1, 1, BindingStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ifStatEClass, IfStat.class, "IfStat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfStat_Condition(), theOCLPackage.getOclExpression(), null, "condition", null, 1, 1, IfStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIfStat_ThenStatements(), this.getStatement(), null, "thenStatements", null, 0, -1, IfStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStat_ElseStatements(), this.getStatement(), null, "elseStatements", null, 0, -1, IfStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forStatEClass, ForStat.class, "ForStat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForStat_Iterator(), theOCLPackage.getIterator(), null, "iterator", null, 1, 1, ForStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getForStat_Collection(), theOCLPackage.getOclExpression(), null, "collection", null, 1, 1, ForStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getForStat_Statements(), this.getStatement(), null, "statements", null, 0, -1, ForStat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.LocatedElement <em>Located Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.LocatedElement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getLocatedElement()
		 * @generated
		 */
		public static final EClass LOCATED_ELEMENT = eINSTANCE.getLocatedElement();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOCATED_ELEMENT__LOCATION = eINSTANCE.getLocatedElement_Location();

		/**
		 * The meta object literal for the '<em><b>Comments Before</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOCATED_ELEMENT__COMMENTS_BEFORE = eINSTANCE.getLocatedElement_CommentsBefore();

		/**
		 * The meta object literal for the '<em><b>Comments After</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LOCATED_ELEMENT__COMMENTS_AFTER = eINSTANCE.getLocatedElement_CommentsAfter();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.Unit <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.Unit
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getUnit()
		 * @generated
		 */
		public static final EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Libraries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference UNIT__LIBRARIES = eINSTANCE.getUnit_Libraries();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute UNIT__NAME = eINSTANCE.getUnit_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.Library <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.Library
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getLibrary()
		 * @generated
		 */
		public static final EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Helpers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference LIBRARY__HELPERS = eINSTANCE.getLibrary_Helpers();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.Query <em>Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.Query
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getQuery()
		 * @generated
		 */
		public static final EClass QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference QUERY__BODY = eINSTANCE.getQuery_Body();

		/**
		 * The meta object literal for the '<em><b>Helpers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference QUERY__HELPERS = eINSTANCE.getQuery_Helpers();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.Module <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.Module
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModule()
		 * @generated
		 */
		public static final EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Is Refining</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute MODULE__IS_REFINING = eINSTANCE.getModule_IsRefining();

		/**
		 * The meta object literal for the '<em><b>In Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MODULE__IN_MODELS = eINSTANCE.getModule_InModels();

		/**
		 * The meta object literal for the '<em><b>Out Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MODULE__OUT_MODELS = eINSTANCE.getModule_OutModels();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MODULE__ELEMENTS = eINSTANCE.getModule_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.ModuleElement <em>Module Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.ModuleElement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getModuleElement()
		 * @generated
		 */
		public static final EClass MODULE_ELEMENT = eINSTANCE.getModuleElement();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MODULE_ELEMENT__MODULE = eINSTANCE.getModuleElement_Module();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.Helper <em>Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.Helper
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getHelper()
		 * @generated
		 */
		public static final EClass HELPER = eINSTANCE.getHelper();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference HELPER__QUERY = eINSTANCE.getHelper_Query();

		/**
		 * The meta object literal for the '<em><b>Library</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference HELPER__LIBRARY = eINSTANCE.getHelper_Library();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference HELPER__DEFINITION = eINSTANCE.getHelper_Definition();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.Rule <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.Rule
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRule()
		 * @generated
		 */
		public static final EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Out Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULE__OUT_PATTERN = eINSTANCE.getRule_OutPattern();

		/**
		 * The meta object literal for the '<em><b>Action Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULE__ACTION_BLOCK = eINSTANCE.getRule_ActionBlock();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULE__VARIABLES = eINSTANCE.getRule_Variables();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute RULE__NAME = eINSTANCE.getRule_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.MatchedRule <em>Matched Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.MatchedRule
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getMatchedRule()
		 * @generated
		 */
		public static final EClass MATCHED_RULE = eINSTANCE.getMatchedRule();

		/**
		 * The meta object literal for the '<em><b>In Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MATCHED_RULE__IN_PATTERN = eINSTANCE.getMatchedRule_InPattern();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MATCHED_RULE__CHILDREN = eINSTANCE.getMatchedRule_Children();

		/**
		 * The meta object literal for the '<em><b>Super Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MATCHED_RULE__SUPER_RULE = eINSTANCE.getMatchedRule_SuperRule();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute MATCHED_RULE__IS_ABSTRACT = eINSTANCE.getMatchedRule_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Refining</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute MATCHED_RULE__IS_REFINING = eINSTANCE.getMatchedRule_IsRefining();

		/**
		 * The meta object literal for the '<em><b>Is No Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute MATCHED_RULE__IS_NO_DEFAULT = eINSTANCE.getMatchedRule_IsNoDefault();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.LazyMatchedRule <em>Lazy Matched Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.LazyMatchedRule
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getLazyMatchedRule()
		 * @generated
		 */
		public static final EClass LAZY_MATCHED_RULE = eINSTANCE.getLazyMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LAZY_MATCHED_RULE__IS_UNIQUE = eINSTANCE.getLazyMatchedRule_IsUnique();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.CalledRule <em>Called Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.CalledRule
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getCalledRule()
		 * @generated
		 */
		public static final EClass CALLED_RULE = eINSTANCE.getCalledRule();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference CALLED_RULE__PARAMETERS = eINSTANCE.getCalledRule_Parameters();

		/**
		 * The meta object literal for the '<em><b>Is Entrypoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CALLED_RULE__IS_ENTRYPOINT = eINSTANCE.getCalledRule_IsEntrypoint();

		/**
		 * The meta object literal for the '<em><b>Is Endpoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CALLED_RULE__IS_ENDPOINT = eINSTANCE.getCalledRule_IsEndpoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.InPattern <em>In Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.InPattern
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getInPattern()
		 * @generated
		 */
		public static final EClass IN_PATTERN = eINSTANCE.getInPattern();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IN_PATTERN__ELEMENTS = eINSTANCE.getInPattern_Elements();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IN_PATTERN__RULE = eINSTANCE.getInPattern_Rule();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IN_PATTERN__FILTER = eINSTANCE.getInPattern_Filter();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.OutPattern <em>Out Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.OutPattern
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPattern()
		 * @generated
		 */
		public static final EClass OUT_PATTERN = eINSTANCE.getOutPattern();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OUT_PATTERN__RULE = eINSTANCE.getOutPattern_Rule();

		/**
		 * The meta object literal for the '<em><b>Drop Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OUT_PATTERN__DROP_PATTERN = eINSTANCE.getOutPattern_DropPattern();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OUT_PATTERN__ELEMENTS = eINSTANCE.getOutPattern_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.DropPattern <em>Drop Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.DropPattern
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getDropPattern()
		 * @generated
		 */
		public static final EClass DROP_PATTERN = eINSTANCE.getDropPattern();

		/**
		 * The meta object literal for the '<em><b>Out Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DROP_PATTERN__OUT_PATTERN = eINSTANCE.getDropPattern_OutPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.PatternElement <em>Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.PatternElement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getPatternElement()
		 * @generated
		 */
		public static final EClass PATTERN_ELEMENT = eINSTANCE.getPatternElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.InPatternElement <em>In Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.InPatternElement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getInPatternElement()
		 * @generated
		 */
		public static final EClass IN_PATTERN_ELEMENT = eINSTANCE.getInPatternElement();

		/**
		 * The meta object literal for the '<em><b>Maps To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IN_PATTERN_ELEMENT__MAPS_TO = eINSTANCE.getInPatternElement_MapsTo();

		/**
		 * The meta object literal for the '<em><b>In Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IN_PATTERN_ELEMENT__IN_PATTERN = eINSTANCE.getInPatternElement_InPattern();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IN_PATTERN_ELEMENT__MODELS = eINSTANCE.getInPatternElement_Models();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement <em>Simple In Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.SimpleInPatternElement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getSimpleInPatternElement()
		 * @generated
		 */
		public static final EClass SIMPLE_IN_PATTERN_ELEMENT = eINSTANCE.getSimpleInPatternElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.OutPatternElement <em>Out Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.OutPatternElement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getOutPatternElement()
		 * @generated
		 */
		public static final EClass OUT_PATTERN_ELEMENT = eINSTANCE.getOutPatternElement();

		/**
		 * The meta object literal for the '<em><b>Out Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OUT_PATTERN_ELEMENT__OUT_PATTERN = eINSTANCE.getOutPatternElement_OutPattern();

		/**
		 * The meta object literal for the '<em><b>Source Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OUT_PATTERN_ELEMENT__SOURCE_ELEMENT = eINSTANCE.getOutPatternElement_SourceElement();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OUT_PATTERN_ELEMENT__BINDINGS = eINSTANCE.getOutPatternElement_Bindings();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference OUT_PATTERN_ELEMENT__MODEL = eINSTANCE.getOutPatternElement_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement <em>Simple Out Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getSimpleOutPatternElement()
		 * @generated
		 */
		public static final EClass SIMPLE_OUT_PATTERN_ELEMENT = eINSTANCE.getSimpleOutPatternElement();

		/**
		 * The meta object literal for the '<em><b>Reverse Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SIMPLE_OUT_PATTERN_ELEMENT__REVERSE_BINDINGS = eINSTANCE.getSimpleOutPatternElement_ReverseBindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement <em>For Each Out Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.ForEachOutPatternElement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getForEachOutPatternElement()
		 * @generated
		 */
		public static final EClass FOR_EACH_OUT_PATTERN_ELEMENT = eINSTANCE.getForEachOutPatternElement();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FOR_EACH_OUT_PATTERN_ELEMENT__COLLECTION = eINSTANCE.getForEachOutPatternElement_Collection();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FOR_EACH_OUT_PATTERN_ELEMENT__ITERATOR = eINSTANCE.getForEachOutPatternElement_Iterator();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.Binding <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.Binding
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getBinding()
		 * @generated
		 */
		public static final EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference BINDING__VALUE = eINSTANCE.getBinding_Value();

		/**
		 * The meta object literal for the '<em><b>Out Pattern Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference BINDING__OUT_PATTERN_ELEMENT = eINSTANCE.getBinding_OutPatternElement();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BINDING__PROPERTY_NAME = eINSTANCE.getBinding_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Is Assignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BINDING__IS_ASSIGNMENT = eINSTANCE.getBinding_IsAssignment();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration <em>Rule Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.RuleVariableDeclaration
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getRuleVariableDeclaration()
		 * @generated
		 */
		public static final EClass RULE_VARIABLE_DECLARATION = eINSTANCE.getRuleVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULE_VARIABLE_DECLARATION__RULE = eINSTANCE.getRuleVariableDeclaration_Rule();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.LibraryRef <em>Library Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.LibraryRef
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getLibraryRef()
		 * @generated
		 */
		public static final EClass LIBRARY_REF = eINSTANCE.getLibraryRef();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference LIBRARY_REF__UNIT = eINSTANCE.getLibraryRef_Unit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute LIBRARY_REF__NAME = eINSTANCE.getLibraryRef_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.ActionBlock <em>Action Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.ActionBlock
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getActionBlock()
		 * @generated
		 */
		public static final EClass ACTION_BLOCK = eINSTANCE.getActionBlock();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference ACTION_BLOCK__RULE = eINSTANCE.getActionBlock_Rule();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference ACTION_BLOCK__STATEMENTS = eINSTANCE.getActionBlock_Statements();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.Statement <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.Statement
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getStatement()
		 * @generated
		 */
		public static final EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.ExpressionStat <em>Expression Stat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.ExpressionStat
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getExpressionStat()
		 * @generated
		 */
		public static final EClass EXPRESSION_STAT = eINSTANCE.getExpressionStat();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference EXPRESSION_STAT__EXPRESSION = eINSTANCE.getExpressionStat_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.BindingStat <em>Binding Stat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.BindingStat
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getBindingStat()
		 * @generated
		 */
		public static final EClass BINDING_STAT = eINSTANCE.getBindingStat();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference BINDING_STAT__SOURCE = eINSTANCE.getBindingStat_Source();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BINDING_STAT__PROPERTY_NAME = eINSTANCE.getBindingStat_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Is Assignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BINDING_STAT__IS_ASSIGNMENT = eINSTANCE.getBindingStat_IsAssignment();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference BINDING_STAT__VALUE = eINSTANCE.getBindingStat_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.IfStat <em>If Stat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.IfStat
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getIfStat()
		 * @generated
		 */
		public static final EClass IF_STAT = eINSTANCE.getIfStat();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IF_STAT__CONDITION = eINSTANCE.getIfStat_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IF_STAT__THEN_STATEMENTS = eINSTANCE.getIfStat_ThenStatements();

		/**
		 * The meta object literal for the '<em><b>Else Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference IF_STAT__ELSE_STATEMENTS = eINSTANCE.getIfStat_ElseStatements();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.common.ATL.ForStat <em>For Stat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.common.ATL.ForStat
		 * @see org.eclipse.m2m.atl.common.ATL.ATLPackage#getForStat()
		 * @generated
		 */
		public static final EClass FOR_STAT = eINSTANCE.getForStat();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FOR_STAT__ITERATOR = eINSTANCE.getForStat_Iterator();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FOR_STAT__COLLECTION = eINSTANCE.getForStat_Collection();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FOR_STAT__STATEMENTS = eINSTANCE.getForStat_Statements();

	}

} //ATLPackage
