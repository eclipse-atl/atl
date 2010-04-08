/*******************************************************************************
 * Copyright (c) 2009, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL Module type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public class ModuleType extends UnitType {

	private static List<Operation> operations;

	/**
	 * Creates a new module from the given source manager.
	 * 
	 * @param file
	 *            the file containing the declaration
	 * @param manager
	 *            the source manager
	 */
	public ModuleType(IFile file, AtlSourceManager manager) {
		super(file, manager, new OclType("Module")); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getTypeOperations()
	 */
	@Override
	protected List<Operation> getTypeOperations() {
		final ModuleType moduleType = this;
		List<Operation> res = new ArrayList<Operation>();
		if (operations == null) {
			operations = new ArrayList<Operation>() {
				{
					add(new Operation("resolveTemp", moduleType, null, new HashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("var", OclAnyType.getInstance()); //$NON-NLS-1$
									put("target_pattern_name", StringType.getInstance()); //$NON-NLS-1$
								}
							}) {
						/**
						 * {@inheritDoc}
						 * 
						 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.Operation#getType(org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType,
						 *      java.lang.Object[])
						 */
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							// TODO implement resolveTemp behavior
							return OclAnyType.getInstance();
						};
					});
				}
			};
		}
		res.addAll(operations);
		res.addAll(getRulesAsOperations());
		return res;
	}

	@SuppressWarnings("unchecked")
	private List<Operation> getRulesAsOperations() {
		List<Operation> res = new ArrayList<Operation>();
		if (sourceManager.getModel() != null) {
			EList<EObject> helpersAndRules = (EList<EObject>)AtlTypesProcessor.eGet(sourceManager.getModel(),
					"elements"); //$NON-NLS-1$
			for (Iterator<EObject> iterator = helpersAndRules.iterator(); iterator.hasNext();) {
				EObject element = iterator.next();
				if (AtlTypesProcessor.oclIsKindOf(element, "LazyMatchedRule")) { //$NON-NLS-1$
					Operation ruleOperation = Operation.createFromLazyRule(this, element, this);
					if (ruleOperation != null) {
						res.add(ruleOperation);
					}
				} else if (AtlTypesProcessor.oclIsKindOf(element, "CalledRule")) { //$NON-NLS-1$
					Operation ruleOperation = Operation.createFromCalledRule(this, element, this);
					if (ruleOperation != null) {
						res.add(ruleOperation);
					}
				}
			}
		}
		return res;
	}

	/**
	 * Returns the rule with the given name if present.
	 * 
	 * @param ruleName
	 *            the rule name
	 * @return the rule with the given name if present
	 */
	@SuppressWarnings("unchecked")
	public EObject getRule(String ruleName) {
		if (sourceManager.getModel() != null) {
			EList<EObject> helpersAndRules = (EList<EObject>)AtlTypesProcessor.eGet(sourceManager.getModel(),
					"elements"); //$NON-NLS-1$
			for (Iterator<EObject> iterator = helpersAndRules.iterator(); iterator.hasNext();) {
				EObject element = iterator.next();
				if (AtlTypesProcessor.oclIsKindOf(element, "Rule")) { //$NON-NLS-1$
					String name = (String)AtlTypesProcessor.eGet(element, "name"); //$NON-NLS-1$
					if (ruleName.equals(name)) {
						return element;
					}
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.UnitType#getHelpersObjects()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Collection<EObject> getHelpersObjects() {
		return (Collection<EObject>)AtlTypesProcessor.eGet(sourceManager.getModel(), "elements"); //$NON-NLS-1$;
	}
}
