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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

/**
 * The ATL OclAny type.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
@SuppressWarnings("serial")
public class OclAnyType {

	private static OclAnyType instance;

	private static List<Operation> operations;

	protected OclType oclType;

	private OclAnyType() {
	}

	/**
	 * Creates a new type using the given oclType.
	 * 
	 * @param oclType
	 *            the ocl type
	 */
	protected OclAnyType(OclType oclType) {
		this.oclType = oclType;
	}

	public OclType getOclType() {
		return oclType;
	}

	public OclAnyType[] getSupertypes() {
		return new OclAnyType[] {};
	}

	public List<Feature> getFeatures() {
		return Collections.emptyList();
	}

	/**
	 * Returns an aggregation of the current type operation and the supertype's ones.
	 * 
	 * @return an aggregation of the current type operation and the supertype's ones
	 */
	public Set<Operation> getOperations() {
		Set<Operation> res = new LinkedHashSet<Operation>();
		List<Operation> localOperations = getTypeOperations();
		Collections.sort(localOperations);
		res.addAll(localOperations);
		for (OclAnyType supertype : getSupertypes()) {
			res.addAll(supertype.getOperations());
		}
		return res;
	}

	/**
	 * Return the local type operations. Subclasses may override this method to add theyre own operation to
	 * the supertypes's ones.
	 * 
	 * @return the operations
	 */
	protected List<Operation> getTypeOperations() {
		if (operations == null) {
			operations = new ArrayList<Operation>() {
				{
					add(new Operation("oclIsKindOf", getInstance(), BooleanType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("t", OclType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("oclIsTypeOf", getInstance(), BooleanType.getInstance(), //$NON-NLS-1$
							new HashMap<String, OclAnyType>() {
								{
									put("t", OclType.getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("oclIsUndefined", getInstance(), BooleanType.getInstance())); //$NON-NLS-1$

					add(new Operation("toString", getInstance(), StringType.getInstance())); //$NON-NLS-1$

					add(new Operation("debug", getInstance(), null)); //$NON-NLS-1$

					// TODO check oclAsType implementation
					// add(new Operation("oclAsType", null) {
					// public OclAnyType getType(OclAnyType context, Object[] parameters) {
					// return OclAnyType.create(manager, parameters[0]);
					// }
					// });

					add(new Operation("oclType", getInstance(), OclType.getInstance())); //$NON-NLS-1$

					add(new Operation(
							"refSetValue", getInstance(), null, new LinkedHashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("name", StringType.getInstance()); //$NON-NLS-1$
									put("value", getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("refUnsetValue", getInstance(), null, //$NON-NLS-1$
							new LinkedHashMap<String, OclAnyType>() {
								{
									put("name", StringType.getInstance()); //$NON-NLS-1$
									put("value", getInstance()); //$NON-NLS-1$
								}
							}));

					add(new Operation("refGetValue", getInstance(), null, new HashMap<String, OclAnyType>() { //$NON-NLS-1$
								{
									put("name", StringType.getInstance()); //$NON-NLS-1$
								}
							}) {
						@Override
						public OclAnyType getType(OclAnyType context, Object... parameters) {
							return getInstance();
						};
					});

					add(new Operation("refImmediateComposite", getInstance(), getInstance())); //$NON-NLS-1$

				}
			};
		}
		return operations;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getOclType().toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OclAnyType) {
			return getOclType().equals(((OclAnyType)obj).getOclType());
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
		return getOclType().hashCode();
	}

	/**
	 * Returns the OclAny type singleton.
	 * 
	 * @return the OclAny type singleton
	 */
	public static OclAnyType getInstance() {
		if (instance == null) {
			instance = new OclAnyType();
			instance.oclType = new OclType("OclAny"); //$NON-NLS-1$
		}
		return instance;
	}

	/**
	 * Maps any object to the matching OclAnyType. Returns the {@link OclAnyType} instance if not resolved.
	 * 
	 * @param manager
	 *            the source manager
	 * @param atlType
	 *            the atl object
	 * @return the type
	 */
	public static OclAnyType create(AtlSourceManager manager, EObject atlType) {
		OclAnyType res = getInstance();
		if (atlType != null) {
			String atlTypeName = atlType.eClass().getName();
			if (atlTypeName.equals("OclModelElement")) { //$NON-NLS-1$
				EObject model = (EObject)AtlTypesProcessor.eGet(atlType, "model"); //$NON-NLS-1$
				if (model != null) {
					String metamodelName = AtlTypesProcessor.eGet(model, "name").toString(); //$NON-NLS-1$
					String elementName = AtlTypesProcessor.eGet(atlType, "name").toString(); //$NON-NLS-1$

					String classifierName = null;
					if (elementName.contains("::")) { //$NON-NLS-1$
						String[] fragments = elementName.split("::"); //$NON-NLS-1$
						// TODO manage packages
						classifierName = fragments[fragments.length - 1];
					} else {
						classifierName = elementName;
					}

					if (manager != null) {
						List<?> packages = manager.getMetamodelPackages(metamodelName);
						if (packages != null) {
							for (Iterator<?> iterator = packages.iterator(); iterator.hasNext();) {
								EPackage pack = (EPackage)iterator.next();
								EClassifier classifier = pack.getEClassifier(classifierName);
								if (classifier != null) {
									res = ModelElementType.create(classifier, metamodelName);
								}
							}
						}
					}
				}
			} else if (atlTypeName.equals("StringType")) { //$NON-NLS-1$ 
				res = StringType.getInstance();
			} else if (atlTypeName.equals("BooleanType")) { //$NON-NLS-1$ 
				res = BooleanType.getInstance();
			} else if (atlTypeName.equals("DoubleType")) { //$NON-NLS-1$ 
				res = RealType.getInstance();
			} else if (atlTypeName.equals("IntegerType")) { //$NON-NLS-1$ 
				res = IntegerType.getInstance();
			} else if (atlTypeName.equals("SequenceType")) { //$NON-NLS-1$
				EObject parameterType = (EObject)AtlTypesProcessor.eGet(atlType, "elementType"); //$NON-NLS-1$
				OclAnyType parameter = create(manager, parameterType);
				res = new SequenceType(parameter);
			} else if (atlTypeName.equals("BagType")) { //$NON-NLS-1$
				EObject parameterType = (EObject)AtlTypesProcessor.eGet(atlType, "elementType"); //$NON-NLS-1$
				OclAnyType parameter = create(manager, parameterType);
				res = new BagType(parameter);
			} else if (atlTypeName.equals("CollectionType")) { //$NON-NLS-1$
				EObject parameterType = (EObject)AtlTypesProcessor.eGet(atlType, "elementType"); //$NON-NLS-1$
				OclAnyType parameter = create(manager, parameterType);
				res = new CollectionType(parameter);
			} else if (atlTypeName.equals("SetType")) { //$NON-NLS-1$
				EObject parameterType = (EObject)AtlTypesProcessor.eGet(atlType, "elementType"); //$NON-NLS-1$
				OclAnyType parameter = create(manager, parameterType);
				res = new SetType(parameter);
			} else if (atlTypeName.equals("OrderedSetType")) { //$NON-NLS-1$
				EObject parameterType = (EObject)AtlTypesProcessor.eGet(atlType, "elementType"); //$NON-NLS-1$
				OclAnyType parameter = create(manager, parameterType);
				res = new OrderedSetType(parameter);
			} else if (atlTypeName.equals("MapType")) { //$NON-NLS-1$
				EObject keyType = (EObject)AtlTypesProcessor.eGet(atlType, "keyType"); //$NON-NLS-1$
				EObject valueType = (EObject)AtlTypesProcessor.eGet(atlType, "valueType"); //$NON-NLS-1$
				OclAnyType key = create(manager, keyType);
				OclAnyType value = create(manager, valueType);
				res = new MapType(key, value);
			} else if (atlTypeName.equals("TupleType")) { //$NON-NLS-1$
				// TODO tuple implementation
			}
		}
		return res;
	}
}
