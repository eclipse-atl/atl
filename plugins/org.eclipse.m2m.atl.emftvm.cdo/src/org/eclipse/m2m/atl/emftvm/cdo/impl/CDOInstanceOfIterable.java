/*******************************************************************************
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.cdo.impl;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.net4j.util.collection.CloseableIterator;

/**
 * Makes the instances of the given {@link EClass} in a {@link CDOResource}
 * available as an {@link Iterable}.
 *
 * Inspired by Epsilon's
 * <a href="https://github.com/epsilonlabs/emc-cdo">emc-cdo</a>.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class CDOInstanceOfIterable implements Iterable<EObject> {

	private final CDOResource res;
	private final EClass type;

	/**
	 * Creates a new {@link CDOInstanceOfIterable} around <code>res</code> and
	 * <code>type</code>.
	 *
	 * @param res  the resource
	 * @param type the EClass
	 */
	public CDOInstanceOfIterable(final CDOResource res, final EClass type) {
		this.res = res;
		this.type = type;
	}

	/**
	 * {@inheritDoc}
	 */
	public CloseableIterator<EObject> iterator() {
		return res.cdoView().queryInstancesAsync(type);
	}

}
