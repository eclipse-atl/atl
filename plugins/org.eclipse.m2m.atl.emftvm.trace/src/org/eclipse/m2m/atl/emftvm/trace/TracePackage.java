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
package org.eclipse.m2m.atl.emftvm.trace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.m2m.atl.emftvm.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/m2m/atl/emftvm/2011/Trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkSetImpl <em>Link Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkSetImpl
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTraceLinkSet()
	 * @generated
	 */
	int TRACE_LINK_SET = 0;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_SET__RULES = 0;

	/**
	 * The feature id for the '<em><b>Default Source Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Default Source Element Lists</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS = 2;

	/**
	 * The number of structural features of the '<em>Link Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_SET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl <em>Traced Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTracedRule()
	 * @generated
	 */
	int TRACED_RULE = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_RULE__RULE = 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_RULE__LINKS = 1;

	/**
	 * The feature id for the '<em><b>Link Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_RULE__LINK_SET = 2;

	/**
	 * The feature id for the '<em><b>Unique Source Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_RULE__UNIQUE_SOURCE_ELEMENTS = 3;

	/**
	 * The feature id for the '<em><b>Unique Source Element Lists</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS = 4;

	/**
	 * The number of structural features of the '<em>Traced Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_RULE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkImpl
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTraceLink()
	 * @generated
	 */
	int TRACE_LINK = 2;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__SOURCE_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Target Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__TARGET_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__RULE = 2;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK__OVERRIDDEN = 3;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LINK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TraceElementImpl
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTraceElement()
	 * @generated
	 */
	int TRACE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Runtime Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__RUNTIME_OBJECT = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl <em>Source Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getSourceElement()
	 * @generated
	 */
	int SOURCE_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT__NAME = TRACE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT__OBJECT = TRACE_ELEMENT__OBJECT;

	/**
	 * The feature id for the '<em><b>Runtime Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT__RUNTIME_OBJECT = TRACE_ELEMENT__RUNTIME_OBJECT;

	/**
	 * The feature id for the '<em><b>Source Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT__SOURCE_OF = TRACE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maps To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT__MAPS_TO = TRACE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT__DEFAULT_FOR = TRACE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unique For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT__UNIQUE_FOR = TRACE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Maps To Self</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT__MAPS_TO_SELF = TRACE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Source Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT_FEATURE_COUNT = TRACE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TargetElementImpl <em>Target Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TargetElementImpl
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTargetElement()
	 * @generated
	 */
	int TARGET_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ELEMENT__NAME = TRACE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ELEMENT__OBJECT = TRACE_ELEMENT__OBJECT;

	/**
	 * The feature id for the '<em><b>Runtime Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ELEMENT__RUNTIME_OBJECT = TRACE_ELEMENT__RUNTIME_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ELEMENT__TARGET_OF = TRACE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maps To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ELEMENT__MAPS_TO = TRACE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Target Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ELEMENT_FEATURE_COUNT = TRACE_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementListImpl <em>Source Element List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementListImpl
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getSourceElementList()
	 * @generated
	 */
	int SOURCE_ELEMENT_LIST = 6;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT_LIST__SOURCE_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Default For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT_LIST__DEFAULT_FOR = 1;

	/**
	 * The feature id for the '<em><b>Unique For</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT_LIST__UNIQUE_FOR = 2;

	/**
	 * The number of structural features of the '<em>Source Element List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_ELEMENT_LIST_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '<em>Java List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getJavaList()
	 * @generated
	 */
	int JAVA_LIST = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet <em>Link Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Set</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet
	 * @generated
	 */
	EClass getTraceLinkSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getRules()
	 * @see #getTraceLinkSet()
	 * @generated
	 */
	EReference getTraceLinkSet_Rules();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElements <em>Default Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Default Source Elements</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElements()
	 * @see #getTraceLinkSet()
	 * @generated
	 */
	EReference getTraceLinkSet_DefaultSourceElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElementLists <em>Default Source Element Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Source Element Lists</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLinkSet#getDefaultSourceElementLists()
	 * @see #getTraceLinkSet()
	 * @generated
	 */
	EReference getTraceLinkSet_DefaultSourceElementLists();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule <em>Traced Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Rule</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule
	 * @generated
	 */
	EClass getTracedRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getRule()
	 * @see #getTracedRule()
	 * @generated
	 */
	EAttribute getTracedRule_Rule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinks()
	 * @see #getTracedRule()
	 * @generated
	 */
	EReference getTracedRule_Links();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinkSet <em>Link Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Link Set</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getLinkSet()
	 * @see #getTracedRule()
	 * @generated
	 */
	EReference getTracedRule_LinkSet();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElements <em>Unique Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unique Source Elements</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElements()
	 * @see #getTracedRule()
	 * @generated
	 */
	EReference getTracedRule_UniqueSourceElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElementLists <em>Unique Source Element Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unique Source Element Lists</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TracedRule#getUniqueSourceElementLists()
	 * @see #getTracedRule()
	 * @generated
	 */
	EReference getTracedRule_UniqueSourceElementLists();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink
	 * @generated
	 */
	EClass getTraceLink();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#getRule()
	 * @see #getTraceLink()
	 * @generated
	 */
	EReference getTraceLink_Rule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#isOverridden <em>Overridden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overridden</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#isOverridden()
	 * @see #getTraceLink()
	 * @generated
	 */
	EAttribute getTraceLink_Overridden();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#getSourceElements()
	 * @see #getTraceLink()
	 * @generated
	 */
	EReference getTraceLink_SourceElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TraceLink#getTargetElements <em>Target Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Elements</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceLink#getTargetElements()
	 * @see #getTraceLink()
	 * @generated
	 */
	EReference getTraceLink_TargetElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceElement
	 * @generated
	 */
	EClass getTraceElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceElement#getName()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceElement#getObject()
	 * @see #getTraceElement()
	 * @generated
	 */
	EReference getTraceElement_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.trace.TraceElement#getRuntimeObject <em>Runtime Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runtime Object</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TraceElement#getRuntimeObject()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_RuntimeObject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement <em>Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Element</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement
	 * @generated
	 */
	EClass getSourceElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getSourceOf <em>Source Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source Of</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement#getSourceOf()
	 * @see #getSourceElement()
	 * @generated
	 */
	EReference getSourceElement_SourceOf();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Maps To</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement#getMapsTo()
	 * @see #getSourceElement()
	 * @generated
	 */
	EReference getSourceElement_MapsTo();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getDefaultFor <em>Default For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement#getDefaultFor()
	 * @see #getSourceElement()
	 * @generated
	 */
	EReference getSourceElement_DefaultFor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#getUniqueFor <em>Unique For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unique For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement#getUniqueFor()
	 * @see #getSourceElement()
	 * @generated
	 */
	EReference getSourceElement_UniqueFor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElement#isMapsToSelf <em>Maps To Self</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maps To Self</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElement#isMapsToSelf()
	 * @see #getSourceElement()
	 * @generated
	 */
	EAttribute getSourceElement_MapsToSelf();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.trace.TargetElement <em>Target Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Element</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TargetElement
	 * @generated
	 */
	EClass getTargetElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.trace.TargetElement#getTargetOf <em>Target Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Target Of</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TargetElement#getTargetOf()
	 * @see #getTargetElement()
	 * @generated
	 */
	EReference getTargetElement_TargetOf();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.trace.TargetElement#getMapsTo <em>Maps To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Maps To</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.TargetElement#getMapsTo()
	 * @see #getTargetElement()
	 * @generated
	 */
	EReference getTargetElement_MapsTo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList <em>Source Element List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Element List</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElementList
	 * @generated
	 */
	EClass getSourceElementList();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Elements</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getSourceElements()
	 * @see #getSourceElementList()
	 * @generated
	 */
	EReference getSourceElementList_SourceElements();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getDefaultFor <em>Default For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Default For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getDefaultFor()
	 * @see #getSourceElementList()
	 * @generated
	 */
	EReference getSourceElementList_DefaultFor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getUniqueFor <em>Unique For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Unique For</em>'.
	 * @see org.eclipse.m2m.atl.emftvm.trace.SourceElementList#getUniqueFor()
	 * @see #getSourceElementList()
	 * @generated
	 */
	EReference getSourceElementList_UniqueFor();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Java List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List" typeParameters="E"
	 * @generated
	 */
	EDataType getJavaList();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkSetImpl <em>Link Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkSetImpl
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTraceLinkSet()
		 * @generated
		 */
		EClass TRACE_LINK_SET = eINSTANCE.getTraceLinkSet();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK_SET__RULES = eINSTANCE.getTraceLinkSet_Rules();

		/**
		 * The meta object literal for the '<em><b>Default Source Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENTS = eINSTANCE.getTraceLinkSet_DefaultSourceElements();

		/**
		 * The meta object literal for the '<em><b>Default Source Element Lists</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK_SET__DEFAULT_SOURCE_ELEMENT_LISTS = eINSTANCE.getTraceLinkSet_DefaultSourceElementLists();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl <em>Traced Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracedRuleImpl
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTracedRule()
		 * @generated
		 */
		EClass TRACED_RULE = eINSTANCE.getTracedRule();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACED_RULE__RULE = eINSTANCE.getTracedRule_Rule();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_RULE__LINKS = eINSTANCE.getTracedRule_Links();

		/**
		 * The meta object literal for the '<em><b>Link Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_RULE__LINK_SET = eINSTANCE.getTracedRule_LinkSet();

		/**
		 * The meta object literal for the '<em><b>Unique Source Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_RULE__UNIQUE_SOURCE_ELEMENTS = eINSTANCE.getTracedRule_UniqueSourceElements();

		/**
		 * The meta object literal for the '<em><b>Unique Source Element Lists</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_RULE__UNIQUE_SOURCE_ELEMENT_LISTS = eINSTANCE.getTracedRule_UniqueSourceElementLists();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TraceLinkImpl
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTraceLink()
		 * @generated
		 */
		EClass TRACE_LINK = eINSTANCE.getTraceLink();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK__RULE = eINSTANCE.getTraceLink_Rule();

		/**
		 * The meta object literal for the '<em><b>Overridden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_LINK__OVERRIDDEN = eINSTANCE.getTraceLink_Overridden();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK__SOURCE_ELEMENTS = eINSTANCE.getTraceLink_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Target Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_LINK__TARGET_ELEMENTS = eINSTANCE.getTraceLink_TargetElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TraceElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TraceElementImpl
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTraceElement()
		 * @generated
		 */
		EClass TRACE_ELEMENT = eINSTANCE.getTraceElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__NAME = eINSTANCE.getTraceElement_Name();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ELEMENT__OBJECT = eINSTANCE.getTraceElement_Object();

		/**
		 * The meta object literal for the '<em><b>Runtime Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ELEMENT__RUNTIME_OBJECT = eINSTANCE.getTraceElement_RuntimeObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl <em>Source Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementImpl
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getSourceElement()
		 * @generated
		 */
		EClass SOURCE_ELEMENT = eINSTANCE.getSourceElement();

		/**
		 * The meta object literal for the '<em><b>Source Of</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_ELEMENT__SOURCE_OF = eINSTANCE.getSourceElement_SourceOf();

		/**
		 * The meta object literal for the '<em><b>Maps To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_ELEMENT__MAPS_TO = eINSTANCE.getSourceElement_MapsTo();

		/**
		 * The meta object literal for the '<em><b>Default For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_ELEMENT__DEFAULT_FOR = eINSTANCE.getSourceElement_DefaultFor();

		/**
		 * The meta object literal for the '<em><b>Unique For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_ELEMENT__UNIQUE_FOR = eINSTANCE.getSourceElement_UniqueFor();

		/**
		 * The meta object literal for the '<em><b>Maps To Self</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_ELEMENT__MAPS_TO_SELF = eINSTANCE.getSourceElement_MapsToSelf();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.TargetElementImpl <em>Target Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TargetElementImpl
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getTargetElement()
		 * @generated
		 */
		EClass TARGET_ELEMENT = eINSTANCE.getTargetElement();

		/**
		 * The meta object literal for the '<em><b>Target Of</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_ELEMENT__TARGET_OF = eINSTANCE.getTargetElement_TargetOf();

		/**
		 * The meta object literal for the '<em><b>Maps To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_ELEMENT__MAPS_TO = eINSTANCE.getTargetElement_MapsTo();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementListImpl <em>Source Element List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.SourceElementListImpl
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getSourceElementList()
		 * @generated
		 */
		EClass SOURCE_ELEMENT_LIST = eINSTANCE.getSourceElementList();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_ELEMENT_LIST__SOURCE_ELEMENTS = eINSTANCE.getSourceElementList_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Default For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_ELEMENT_LIST__DEFAULT_FOR = eINSTANCE.getSourceElementList_DefaultFor();

		/**
		 * The meta object literal for the '<em><b>Unique For</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_ELEMENT_LIST__UNIQUE_FOR = eINSTANCE.getSourceElementList_UniqueFor();

		/**
		 * The meta object literal for the '<em>Java List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.eclipse.m2m.atl.emftvm.trace.impl.TracePackageImpl#getJavaList()
		 * @generated
		 */
		EDataType JAVA_LIST = eINSTANCE.getJavaList();

	}

} //TracePackage
