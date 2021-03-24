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
package org.eclipse.m2m.atl.emftvm;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Interface for {@link Resource}-specific {@link Model} factory objects.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public interface ModelFactory {

	/**
	 * Creates a new {@link Model} for the given {@link Resource}.
	 *
	 * @param resource the {@link Resource} to wrap
	 * @return a new {@link Model}
	 */
	Model createModel(Resource resource);

	/**
	 * Creates a new {@link Metamodel} for the given {@link Resource}.
	 *
	 * @param resource the {@link Resource} to wrap
	 * @return a new {@link Metamodel}
	 */
	Metamodel createMetamodel(Resource resource);

}
