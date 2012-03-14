/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
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
import java.util.HashMap;
import java.util.List;

/**
 * The ATL Boolean type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public final class BooleanType extends OclAnyType {

	/** The singleton instance. */
	private static BooleanType instance;

	private static List<Operation> operations;

	private BooleanType() {
		super(new OclType("Boolean")); //$NON-NLS-1$
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getTypeOperations()
	 */
	@Override
	protected List<Operation> getTypeOperations() {
		if (operations == null) {
			operations = new ArrayList<Operation>() {
				{
					add(new Operation("implies", getInstance(), getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("b", getInstance()); //$NON-NLS-1$
								}
							}));
				}
			};
		}
		return operations;
	}

	/**
	 * Returns the Boolean type singleton.
	 * 
	 * @return the Boolean type singleton
	 */
	public static BooleanType getInstance() {
		if (instance == null) {
			instance = new BooleanType();
		}
		return instance;
	}
}
