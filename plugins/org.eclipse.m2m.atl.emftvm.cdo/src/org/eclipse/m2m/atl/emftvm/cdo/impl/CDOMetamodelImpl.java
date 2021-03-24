/*******************************************************************************
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.cdo.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.impl.MetamodelImpl;

/**
 * CDO implementation of {@link Metamodel}.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class CDOMetamodelImpl extends CDOModelImpl implements Metamodel {

	/**
	 * Lookup table of ((type name) -> (type)).
	 */
	protected Map<String, EClassifier> types;

	/**
	 * Set of ambiguous type names (more than one occurrence).
	 */
	protected Set<String> ambiguousTypes = new HashSet<String>();

	/**
	 * Returns the {@link EClass} that correspond to this metaclass.
	 *
	 * @return the {@link EClass} that correspond to this metaclass.
	 */
	@Override
	protected EClass eStaticClass() {
		return EmftvmPackage.Literals.METAMODEL;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized EClassifier findType(final String typeName) {
		if (types == null) {
			types = createTypeTable(ambiguousTypes);
		}
		final EClassifier type = types.get(typeName);
		if (type == null) {
			throw new IllegalArgumentException(String.format("Type %s not found in metamodel %s", typeName, this));
		}
		if (ambiguousTypes.contains(typeName)) {
			ATLLogger.warning(String.format("Metamodel %s contains more than one type with name %s", this, typeName));
		}
		return type;
	}

	/**
	 * Returns a new type lookup table.
	 *
	 * @param ambiguousTypes the set of ambiguous type names (more than one
	 *                       occurrence)
	 * @return A new type lookup table.
	 */
	private Map<String, EClassifier> createTypeTable(final Set<String> ambiguousTypes) {
		final Map<String, EClassifier> types = new HashMap<String, EClassifier>();
		final Resource res = getResource();
		assert res != null;
		MetamodelImpl.registerTypeChain(types, res, null, new HashSet<Object>(), ambiguousTypes);
		return types;
	}

}
