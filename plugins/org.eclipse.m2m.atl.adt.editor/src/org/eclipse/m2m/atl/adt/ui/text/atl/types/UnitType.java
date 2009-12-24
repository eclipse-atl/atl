/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL Module type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public abstract class UnitType extends OclAnyType {

	protected AtlSourceManager manager;

	private Map<OclAnyType, Set<Operation>> helpers;

	private Map<OclAnyType, Set<Feature>> attributes;

	/**
	 * Creates a new Module from the given source manager.
	 * 
	 * @param manager
	 *            the source manager
	 * @param unitType
	 *            the unit type
	 */
	public UnitType(AtlSourceManager manager, OclType unitType) {
		super(unitType);
		this.manager = manager;
		init();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getSupertypes()
	 */
	@Override
	public OclAnyType[] getSupertypes() {
		return new OclAnyType[] {OclAnyType.getInstance()};
	}

	private void addHelper(OclAnyType context, final Operation helper) {
		if (helpers == null) {
			helpers = new HashMap<OclAnyType, Set<Operation>>();
		}
		if (helpers.get(context) == null) {
			Set<Operation> contextHelpers = new HashSet<Operation>() {
				{
					add(helper);
				}
			};
			helpers.put(context, contextHelpers);
		} else {
			helpers.get(context).add(helper);
		}
	}

	/**
	 * Returns the helpers atl objects.
	 * 
	 * @return the helpers atl objects
	 */
	protected abstract Collection<EObject> getHelpersObjects();

	/**
	 * Initializes the helpers and attributes.
	 */
	protected void init() {
		if (manager != null && manager.getModel() != null) {
			Collection<EObject> helpers = getHelpersObjects();
			if (helpers != null) {
				for (Iterator<EObject> iterator = helpers.iterator(); iterator.hasNext();) {
					EObject element = iterator.next();
					if (element.eClass().getName().equals("Helper")) { //$NON-NLS-1$
						EObject definition = (EObject)AtlTypesProcessor.eGet(element, "definition"); //$NON-NLS-1$
						if (definition != null) {
							EObject context = (EObject)AtlTypesProcessor.eGet(definition, "context_"); //$NON-NLS-1$
							OclAnyType type = OclAnyType.getInstance();
							if (context != null) {
								EObject contextType = (EObject)AtlTypesProcessor.eGet(context, "context_"); //$NON-NLS-1$
								type = OclAnyType.create(manager, contextType);
							} else {
								type = this;
							}
							EObject f = (EObject)AtlTypesProcessor.eGet(definition, "feature"); //$NON-NLS-1$
							if (f != null) {
								if (f.eClass().getName().equals("Attribute")) { //$NON-NLS-1$
									addAttribute(type, Feature.createFromAttribute(manager, f, type));
								} else if (f.eClass().getName().equals("Operation")) { //$NON-NLS-1$
									addHelper(type, Operation.createFromHelper(manager, f, type));
								}
							}
						}
					}
				}
			}
		}
	}

	private void addAttribute(OclAnyType context, final Feature attribute) {
		if (attributes == null) {
			attributes = new HashMap<OclAnyType, Set<Feature>>();
		}
		if (attributes.get(context) == null) {
			Set<Feature> contextAttributes = new HashSet<Feature>() {
				{
					add(attribute);
				}
			};
			attributes.put(context, contextAttributes);
		} else {
			attributes.get(context).add(attribute);
		}
	}

	/**
	 * Returns all the registered attributes for the given type.
	 * 
	 * @param type
	 *            the context type
	 * @return the registered attributes
	 */
	public Set<Feature> getAttributes(OclAnyType type) {
		Set<Feature> res = new LinkedHashSet<Feature>();
		if (attributes != null) {
			if (attributes.get(type) != null) {
				res.addAll(attributes.get(type));
			}
			for (OclAnyType supertype : type.getSupertypes()) {
				res.addAll(getAttributes(supertype));
			}
		}
		return res;
	}

	/**
	 * Returns all the registered helpers for the given type.
	 * 
	 * @param type
	 *            the context type
	 * @return the registered helpers
	 */
	public Set<Operation> getHelpers(OclAnyType type) {
		Set<Operation> res = new LinkedHashSet<Operation>();
		if (helpers != null) {
			if (helpers.get(type) != null) {
				res.addAll(helpers.get(type));
			}
			for (OclAnyType supertype : type.getSupertypes()) {
				res.addAll(getHelpers(supertype));
			}
		}
		return res;
	}

}
