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
import java.util.HashMap;
import java.util.List;

/**
 * The ATL Set type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public class SetType extends CollectionType {

	/** The singleton instance. */
	private static SetType instance;

	private static List<Operation> operations;

	/**
	 * Constructor.
	 * 
	 * @param parameter
	 *            the Set parameter type
	 */
	public SetType(OclAnyType parameter) {
		super(parameter);
		oclType = new OclType(computeName("Set", parameter)); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.CollectionType#getCollectionType()
	 */
	@Override
	public String getCollectionType() {
		return "Set"; //$NON-NLS-1$
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
							return new SetType(type);
						}
					});

					add(new Operation("union", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("c", CollectionType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("intersection", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("c", CollectionType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("symetricDifference", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("s", SetType.getInstance()); //$NON-NLS-1$
								}
							}));
				}
			};
		}
		return operations;
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
	 * Returns the default Set type singleton.
	 * 
	 * @return the default Set type singleton
	 */
	public static SetType getInstance() {
		if (instance == null) {
			instance = new SetType(OclAnyType.getInstance());
		}
		return instance;
	}
}
