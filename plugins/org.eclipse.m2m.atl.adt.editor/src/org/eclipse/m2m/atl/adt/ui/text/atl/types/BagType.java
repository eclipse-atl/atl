/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
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
import java.util.List;

/**
 * The ATL Bag type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public class BagType extends CollectionType {

	/** The singleton instance. */
	private static BagType instance;

	private static List<Operation> operations;

	/**
	 * Constructor.
	 * 
	 * @param parameter
	 *            the Bag parameter type
	 */
	public BagType(OclAnyType parameter) {
		super(parameter);
		oclType = new OclType(computeName("Bag", parameterType)); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getSupertypes()
	 */
	@Override
	public OclAnyType[] getSupertypes() {
		return new OclAnyType[] {new CollectionType(getParameterType())};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.CollectionType#getCollectionType()
	 */
	@Override
	public String getCollectionType() {
		return "Bag"; //$NON-NLS-1$
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
					add(new Operation("flatten", getInstance(), null) { //$NON-NLS-1$

						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							OclAnyType type = context;
							while (type instanceof CollectionType) {
								type = ((CollectionType)type).getParameterType();
							}
							return new BagType(type);
						}
					});
				}
			};
		}
		return operations;
	}

	/**
	 * Returns the default Bag type singleton.
	 * 
	 * @return the default Bag type singleton
	 */
	public static BagType getInstance() {
		if (instance == null) {
			instance = new BagType(OclAnyType.getInstance());
		}
		return instance;
	}
}
