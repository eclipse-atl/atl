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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL Library type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class LibraryType extends UnitType {

	/**
	 * Creates a new library from the given source manager.
	 * 
	 * @param manager
	 *            the source manager
	 */
	public LibraryType(AtlSourceManager manager) {
		super(manager, new OclType("Library")); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.UnitType#getHelpersObjects()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Collection<EObject> getHelpersObjects() {
		return (Collection<EObject>)AtlTypesProcessor.eGet(manager.getModel(), "helpers"); //$NON-NLS-1$;
	}
}
