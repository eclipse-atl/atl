/*******************************************************************************
 * Copyright (c) 2013 HealthConnect CVBA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, HealthConnect - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

/**
 * Returns a singleton {@link ModuleResolver} instance.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class SingletonModuleResolverFactory implements ModuleResolverFactory {

	private final ModuleResolver moduleResolver;

	/**
	 * Creates a new {@link SingletonModuleResolverFactory}.
	 * 
	 * @param moduleResolver
	 *            the {@link ModuleResolver} to return on
	 *            {@link #createModuleResolver()}
	 */
	public SingletonModuleResolverFactory(final ModuleResolver moduleResolver) {
		super();
		this.moduleResolver = moduleResolver;
	}

	/**
	 * {@inheritDoc}
	 */
	public ModuleResolver createModuleResolver() {
		return moduleResolver;
	}

}
