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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * The ATL Sequence type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public class SequenceType extends CollectionType {

	/** The singleton instance. */
	private static SequenceType instance;

	private static List<Operation> operations;

	/**
	 * Constructor.
	 * 
	 * @param parameter
	 *            the Sequence parameter type
	 */
	public SequenceType(OclAnyType parameter) {
		super(parameter);
		oclType = new OclType(computeName("Sequence", parameter)); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.CollectionType#getCollectionType()
	 */
	@Override
	public String getCollectionType() {
		return "Sequence"; //$NON-NLS-1$
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
					add(new Operation("indexOf", getInstance(), IntegerType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("flatten", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							OclAnyType type = context;
							while (type instanceof CollectionType) {
								type = ((CollectionType)type).getParameterType();
							}
							return new SequenceType(type);
						}
					});

					add(new Operation("first", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof CollectionType) {
								return ((CollectionType)context).getParameterType();
							}
							return null;
						}
					});

					add(new Operation("last", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof CollectionType) {
								CollectionType collection = (CollectionType)context;
								return collection.getParameterType();
							}
							return null;
						}
					});

					add(new Operation("append", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("prepend", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("union", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("c", CollectionType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("insertAt", getInstance(), null, //$NON-NLS-1$
							new LinkedHashMap<String, OclAnyType>() {
								{
									put("n", IntegerType.getInstance()); //$NON-NLS-1$
									put("o", OclAnyType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("at", getInstance(), null, //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("n", IntegerType.getInstance()); //$NON-NLS-1$
								}
							}) {
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof CollectionType) {
								return ((CollectionType)context).getParameterType();
							}
							return OclAnyType.getInstance();
						};
					});

					add(new Operation("subSequence", getInstance(), null, //$NON-NLS-1$
							new LinkedHashMap<String, OclAnyType>() {
								{
									put("lower", IntegerType.getInstance()); //$NON-NLS-1$
									put("upper", IntegerType.getInstance()); //$NON-NLS-1$
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
	 * Returns the default Sequence type singleton.
	 * 
	 * @return the default Sequence type singleton
	 */
	public static SequenceType getInstance() {
		if (instance == null) {
			instance = new SequenceType(OclAnyType.getInstance());
		}
		return instance;
	}
}
