/*******************************************************************************
 * Copyright (c) 2013 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * {@link ModuleResolverFactory} for {@link DefaultModuleResolver}s.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class DefaultModuleResolverFactory implements ModuleResolverFactory {

	private final String uriPrefix;

	/**
	 * Creates a new {@link DefaultModuleResolverFactory}.
	 * 
	 * @param uriPrefix
	 *            the URI prefix for the {@link DefaultModuleResolver}s
	 */
	public DefaultModuleResolverFactory(String uriPrefix) {
		this.uriPrefix = uriPrefix;
	}

	/**
	 * {@inheritDoc}
	 */
	public ModuleResolver createModuleResolver() {
		return new DefaultModuleResolver(getUriPrefix(), new ResourceSetImpl());
	}

	/**
	 * Returns the URI prefix for the {@link DefaultModuleResolver}s.
	 * 
	 * @return the uriPrefix
	 */
	public String getUriPrefix() {
		return uriPrefix;
	}

}
