/**
 * Copyright (C) 2009, Vrije Universiteit Brussel, Universidad de los Andes
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Andres Yie (Vrije Universiteit Brussel, Universidad de los Andes)
 * 	Dennis Wagelaar (Vrije Universiteit Brussel)
 *
 * $Id: TracePackage.java,v 1.1.2.2 2009/03/13 15:39:39 dwagelaar Exp $
 */
package org.eclipse.m2m.atl.trace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.m2m.atl.trace.TraceFactory
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
	String eNS_URI = "http://www.eclipse.org/gmt/2008/Trace";

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
	TracePackage eINSTANCE = org.eclipse.m2m.atl.trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.trace.impl.TransientLinkSetImpl <em>Transient Link Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.trace.impl.TransientLinkSetImpl
	 * @see org.eclipse.m2m.atl.trace.impl.TracePackageImpl#getTransientLinkSet()
	 * @generated
	 */
	int TRANSIENT_LINK_SET = 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_LINK_SET__LINKS = 0;

	/**
	 * The number of structural features of the '<em>Transient Link Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_LINK_SET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.trace.impl.TransientLinkImpl <em>Transient Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.trace.impl.TransientLinkImpl
	 * @see org.eclipse.m2m.atl.trace.impl.TracePackageImpl#getTransientLink()
	 * @generated
	 */
	int TRANSIENT_LINK = 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_LINK__RULE = 0;

	/**
	 * The feature id for the '<em><b>Source Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_LINK__SOURCE_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Target Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_LINK__TARGET_ELEMENTS = 2;

	/**
	 * The number of structural features of the '<em>Transient Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_LINK_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.atl.trace.impl.TransientElementImpl <em>Transient Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.atl.trace.impl.TransientElementImpl
	 * @see org.eclipse.m2m.atl.trace.impl.TracePackageImpl#getTransientElement()
	 * @generated
	 */
	int TRANSIENT_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_ELEMENT__IS_DEFAULT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_ELEMENT__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Transient Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSIENT_ELEMENT_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.trace.TransientLinkSet <em>Transient Link Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transient Link Set</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientLinkSet
	 * @generated
	 */
	EClass getTransientLinkSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.trace.TransientLinkSet#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientLinkSet#getLinks()
	 * @see #getTransientLinkSet()
	 * @generated
	 */
	EReference getTransientLinkSet_Links();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.trace.TransientLink <em>Transient Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transient Link</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientLink
	 * @generated
	 */
	EClass getTransientLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.trace.TransientLink#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientLink#getRule()
	 * @see #getTransientLink()
	 * @generated
	 */
	EAttribute getTransientLink_Rule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.trace.TransientLink#getSourceElements <em>Source Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Elements</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientLink#getSourceElements()
	 * @see #getTransientLink()
	 * @generated
	 */
	EReference getTransientLink_SourceElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.atl.trace.TransientLink#getTargetElements <em>Target Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Elements</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientLink#getTargetElements()
	 * @see #getTransientLink()
	 * @generated
	 */
	EReference getTransientLink_TargetElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.atl.trace.TransientElement <em>Transient Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transient Element</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientElement
	 * @generated
	 */
	EClass getTransientElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.trace.TransientElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientElement#getName()
	 * @see #getTransientElement()
	 * @generated
	 */
	EAttribute getTransientElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.atl.trace.TransientElement#isIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientElement#isIsDefault()
	 * @see #getTransientElement()
	 * @generated
	 */
	EAttribute getTransientElement_IsDefault();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.m2m.atl.trace.TransientElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.m2m.atl.trace.TransientElement#getValue()
	 * @see #getTransientElement()
	 * @generated
	 */
	EReference getTransientElement_Value();

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
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.trace.impl.TransientLinkSetImpl <em>Transient Link Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.trace.impl.TransientLinkSetImpl
		 * @see org.eclipse.m2m.atl.trace.impl.TracePackageImpl#getTransientLinkSet()
		 * @generated
		 */
		EClass TRANSIENT_LINK_SET = eINSTANCE.getTransientLinkSet();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_LINK_SET__LINKS = eINSTANCE.getTransientLinkSet_Links();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.trace.impl.TransientLinkImpl <em>Transient Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.trace.impl.TransientLinkImpl
		 * @see org.eclipse.m2m.atl.trace.impl.TracePackageImpl#getTransientLink()
		 * @generated
		 */
		EClass TRANSIENT_LINK = eINSTANCE.getTransientLink();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSIENT_LINK__RULE = eINSTANCE.getTransientLink_Rule();

		/**
		 * The meta object literal for the '<em><b>Source Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_LINK__SOURCE_ELEMENTS = eINSTANCE.getTransientLink_SourceElements();

		/**
		 * The meta object literal for the '<em><b>Target Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_LINK__TARGET_ELEMENTS = eINSTANCE.getTransientLink_TargetElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.atl.trace.impl.TransientElementImpl <em>Transient Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.atl.trace.impl.TransientElementImpl
		 * @see org.eclipse.m2m.atl.trace.impl.TracePackageImpl#getTransientElement()
		 * @generated
		 */
		EClass TRANSIENT_ELEMENT = eINSTANCE.getTransientElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSIENT_ELEMENT__NAME = eINSTANCE.getTransientElement_Name();

		/**
		 * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSIENT_ELEMENT__IS_DEFAULT = eINSTANCE.getTransientElement_IsDefault();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSIENT_ELEMENT__VALUE = eINSTANCE.getTransientElement_Value();

	}

} //TracePackage
