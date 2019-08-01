/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - completion system
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.text.atl.types;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL Query type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class QueryType extends UnitType {

	/**
	 * Creates a new query from the given source manager.
	 * 
	 * @param file
	 *            the query file
	 * @param manager
	 *            the source manager
	 */
	public QueryType(IFile file, AtlSourceManager manager) {
		super(file, manager, new OclType("Query")); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.UnitType#getHelpersObjects()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Collection<EObject> getHelpersObjects() {
		return (Collection<EObject>)AtlTypesProcessor.eGet(sourceManager.getModel(), "helpers"); //$NON-NLS-1$;
	}
}
