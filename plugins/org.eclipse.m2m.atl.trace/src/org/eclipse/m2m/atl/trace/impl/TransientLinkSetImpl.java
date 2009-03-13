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
 * $Id: TransientLinkSetImpl.java,v 1.1.2.3 2009/03/13 15:39:39 dwagelaar Exp $
 */
package org.eclipse.m2m.atl.trace.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.atl.trace.TracePackage;
import org.eclipse.m2m.atl.trace.TransientElement;
import org.eclipse.m2m.atl.trace.TransientLink;
import org.eclipse.m2m.atl.trace.TransientLinkSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transient Link Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.atl.trace.impl.TransientLinkSetImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransientLinkSetImpl extends EObjectImpl implements TransientLinkSet {
	
	/**
	 * Cached Map to links by the name of the rule
	 */
	private Map<String, EList<TransientLink>> linksByRule;
	
	/**
	 * Cached Map to links by the Source Element
	 */
	private Map<Object, TransientLink> linksBySourceElement;	
	
	/**
	 * Cached Map to links by the TargetElement
	 */
	private Map<Object, TransientLink> linksByTargetElement;
	
	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<TransientLink> links;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a new TransientLinkSetImpl object.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected TransientLinkSetImpl() {
		super();
		linksByRule = new HashMap<String, EList<TransientLink>>();
		linksBySourceElement = new HashMap<Object, TransientLink>();	
		linksByTargetElement = new HashMap<Object, TransientLink>();
		links = new EObjectContainmentEList<TransientLink>(TransientLink.class, this, TracePackage.TRANSIENT_LINK_SET__LINKS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRANSIENT_LINK_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * returns a List with all the links
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransientLink> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<TransientLink>(TransientLink.class, this, TracePackage.TRANSIENT_LINK_SET__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * returns a List with all the links
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TransientLink> getAllLinks() {
		return this.getLinks();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns a the List of links from the Rule
	 * @param rule 
	 * 				the name of the rule
	 * @return
	 * 				the list of links from the rule 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TransientLink> getLinksByRule(String rule) {
		EList<TransientLink> ret = this.linksByRule.get(rule);
		if (ret == null) {
			ret = new EObjectContainmentEList<TransientLink>(TransientLink.class, this, TracePackage.TRANSIENT_LINK_SET__LINKS);
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the link from the given source element.
	 * 
	 * @param sourceElement
	 *            	the source element
	 * @return 
	 * 				the link
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TransientLink getLinkBySourceElement(Object sourceElement) {
		TransientLink ret = linksBySourceElement.get(sourceElement);
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the link from the given target element.
	 * 
	 * @param targetElement
	 *            	the source element
	 * @return 
	 * 				the link
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TransientLink getLinkByTargetElement(Object targetElement) {
		TransientLink ret = linksByTargetElement.get(targetElement);
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the link from the rule and the given source element.
	 * 
	 * @param rule the name of the rule
	 * 
	 * @param sourceElement
	 *            	the source element
	 * @return 
	 * 				the link
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TransientLink getLinkByRuleAndSourceElement(String rule, Object sourceElement) {
		TransientLink ret = linksBySourceElement.get(sourceElement);
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * adds a new link to the TransienLinkSet
	 * @param tl
	 * 			the link to add
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addLink(TransientLink tl) {
		this.addLink2(tl, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * @param tl
	 * 			the link to add
	 * @param isDefault
	 * 			true if the link is the default
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addLink2(TransientLink tl, boolean isDefault) {
		String rule = tl.getRule();

		this.links.add(tl);
	
		EList<TransientLink> linkList = linksByRule.get(rule);
		if (linkList == null) {
			linkList = new BasicEList<TransientLink>();
			linksByRule.put(rule, linkList);
		}
		linkList.add(tl);
		
		if (isDefault) {
			Object se = null;
			if (tl.getSourceElements().size() == 1) {
				se = tl.getSourceElements().iterator().next().getValue(); 
			} else {
				Map<String, Object> sem = new HashMap<String, Object>();
				for (Iterator<TransientElement> i = tl.getSourceElements().iterator(); i.hasNext();) {
					TransientElement te = i.next();
					sem.put(te.getName(), te.getValue());
				}
				se = sem;
			}
			TransientLink other = linksBySourceElement.get(se);
			if (other != null) {
				// TODO: pretty print
				throw new RuntimeException("trying to register several rules as default for element " + se
						+ ": " + other.getRule() + " and " + tl.getRule());
			}
			linksBySourceElement.put(se, tl);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Prints the every TransientLink
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer("TransientLinkSet {");

		for (Iterator<TransientLink> i = links.iterator(); i.hasNext();) {
			ret.append(i.next().toString());
			if (i.hasNext()) {
				ret.append(", ");
			}
		}

		ret.append("}");

		return ret.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRANSIENT_LINK_SET__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
			case TracePackage.TRANSIENT_LINK_SET__LINKS:
				return getLinks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.TRANSIENT_LINK_SET__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends TransientLink>)newValue);
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
			case TracePackage.TRANSIENT_LINK_SET__LINKS:
				getLinks().clear();
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
			case TracePackage.TRANSIENT_LINK_SET__LINKS:
				return links != null && !links.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransientLinkSetImpl
