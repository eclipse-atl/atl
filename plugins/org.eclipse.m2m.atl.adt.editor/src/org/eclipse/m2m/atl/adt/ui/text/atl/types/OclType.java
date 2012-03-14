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

import org.eclipse.emf.ecore.EClassifier;

/**
 * The ATL OclType type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public class OclType extends OclAnyType {

	private static OclType instance;

	private static List<Operation> operations;

	private String name;

	private String metamodelName;

	private EClassifier classifier;

	/**
	 * Creates a basic type with a name. Mainly used by primitive types.
	 * 
	 * @param name
	 *            the type name
	 */
	public OclType(String name) {
		super(null);
		this.name = name;
	}

	/**
	 * Create a type from an EMF classifier. Used by model element types.
	 * 
	 * @param metamodelName
	 *            the metamodel name
	 * @param classifier
	 *            the classifier
	 */
	public OclType(String metamodelName, EClassifier classifier) {
		super(null);
		this.name = classifier.getName();
		this.metamodelName = metamodelName;
		this.classifier = classifier;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#getOclType()
	 */
	@Override
	public OclType getOclType() {
		if (instance == null) {
			instance = new OclType("OclType"); //$NON-NLS-1$
		}
		return instance;
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

	public String getMetamodelName() {
		return metamodelName;
	}

	public EClassifier getClassifier() {
		return classifier;
	}

	public String getName() {
		return name;
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
					add(new Operation("newInstance", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof OclType) {
								return new ModelElementType((OclType)context);
							}
							return OclAnyType.getInstance();
						}
					});

					add(new Operation(
							"newInstanceIn", getInstance(), null, new HashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("model", StringType.getInstance()); //$NON-NLS-1$
								}
							}) {
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof OclType) {
								return new ModelElementType((OclType)context);
							}
							return OclAnyType.getInstance();
						}
					});

					add(new Operation("allInstances", getInstance(), null) { //$NON-NLS-1$
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof OclType) {
								return new SequenceType(new ModelElementType((OclType)context));
							}
							return OclAnyType.getInstance();
						}
					});

					add(new Operation(
							"allInstancesFrom", getInstance(), null, new HashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("model", StringType.getInstance()); //$NON-NLS-1$
								}
							}) {
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof OclType) {
								return new SequenceType(new ModelElementType((OclType)context));
							}
							return OclAnyType.getInstance();
						}
					});

					add(new Operation(
							"getInstanceById", getInstance(), null, new HashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("id", StringType.getInstance()); //$NON-NLS-1$
								}
							}) {
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							if (context instanceof OclType) {
								return new ModelElementType((OclType)context);
							}
							return OclAnyType.getInstance();
						}
					});

					add(new Operation(
							"conformsTo", getInstance(), BooleanType.getInstance(), new HashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("t", OclType.getInstance()); //$NON-NLS-1$
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
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OclType) {
			return toString().equals(((OclType)obj).toString());
		}
		return super.equals(obj);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.text.atl.types.OclAnyType#toString()
	 */
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		if (metamodelName != null) {
			res.append(metamodelName);
			res.append('!');
		}
		res.append(name);
		return res.toString();
	}

	/**
	 * Returns the default OclType type singleton.
	 * 
	 * @return the default OclType type singleton
	 */
	public static OclType getInstance() {
		if (instance == null) {
			instance = new OclType("OclType"); //$NON-NLS-1$
		}
		return instance;
	}
}
