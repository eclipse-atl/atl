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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.ModelFactory;

/**
 * CDO implementation for {@link ModelFactory}.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class CDOModelFactoryImpl implements ModelFactory {

	/**
	 * {@inheritDoc}
	 */
	public Model createModel(final Resource resource) {
		final Model model = new CDOModelImpl();
		model.setResource(resource);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	public Metamodel createMetamodel(final Resource resource) {
		final Metamodel metaModel = new CDOMetamodelImpl();
		metaModel.setResource(resource);
		return metaModel;
	}

}
