/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.ui.executionviewer.view;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingModel;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * A content provider for the calls view.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class CallsViewContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Creates the provider.
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 */
	public CallsViewContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object parent) {
		return getOperationsFromOccurences(parent).values().toArray();
	}

	/**
	 * Returns the map of operations by occurences.
	 * 
	 * @param parent
	 *            the parent object
	 * @return the map of operations by occurences
	 */
	public Map<String, ProfilingOperation> getOperationsFromOccurences(Object parent) {
		Map<String, ProfilingOperation> operations = new HashMap<String, ProfilingOperation>();
		if (parent instanceof ProfilingModel || parent instanceof ProfilingOperation) {
			ProfilingOperation po = (ProfilingOperation)parent;
			for (ProfilingInstruction pi : po.getExecutionInstructions()) {
				if (pi instanceof ProfilingOperation) {
					if (operations.get(pi.getContent()) == null) {
						operations.put(pi.getContent(), (ProfilingOperation)pi);
					}
				}
			}
			return operations;
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object child) {
		return super.getParent(child);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parent) {
		Map<String, ProfilingOperation> childOperations = getChildFromSameParents(parent);
		return childOperations.values().toArray();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object parent) {
		Map<String, ProfilingOperation> childOperations = getChildFromSameParents(parent);
		return childOperations.values().size() > 0;
	}

	private Map<String, ProfilingOperation> getChildFromSameParents(Object parent) {
		ProfilingOperation currentOp = (ProfilingOperation)parent;
		ProfilingOperation parentOp = currentOp.getParentOperation();
		Map<String, ProfilingOperation> childOperations = new HashMap<String, ProfilingOperation>();
		childOperations.putAll(getOperationsFromOccurences(currentOp));

		for (ProfilingInstruction pi : parentOp.getExecutionInstructions()) {
			if (pi instanceof ProfilingOperation && pi.getContent().equals(currentOp.getContent())) {
				Map<String, ProfilingOperation> opList = getOperationsFromOccurences(pi);
				childOperations.putAll(opList);
			}
		}
		return childOperations;
	}
}
