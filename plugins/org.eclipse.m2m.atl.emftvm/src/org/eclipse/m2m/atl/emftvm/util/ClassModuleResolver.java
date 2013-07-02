/*******************************************************************************
 * Copyright (c) 2013 HealthConnect CVBA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, HealthConnect - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl;

/**
 * {@link ModuleResolver} based on {@link Class#getResourceAsStream(String)}.
 * 
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class ClassModuleResolver implements ModuleResolver {

	private final Class<?> clazz;

	/**
	 * Creates a new {@link ClassModuleResolver}.
	 * 
	 * @param clazz
	 *            the {@link Class} to use for resource loading
	 */
	public ClassModuleResolver(final Class<?> clazz) {
		super();
		this.clazz = clazz;
	}

	/**
	 * {@inheritDoc}
	 */
	public Module resolveModule(final String module) throws ModuleNotFoundException {
		final Resource moduleRes = new EMFTVMResourceImpl();
		final String moduleFile = module.replaceAll("::", "/") + ".emftvm";
		final URL moduleUrl = clazz.getResource(moduleFile);
		if (moduleUrl == null) {
			throw new ModuleNotFoundException("Cannot find: [" + moduleFile + "]");
		}
		try {
			final InputStream inputStream = moduleUrl.openStream();
			if (inputStream == null) {
				throw new ModuleNotFoundException("Cannot load: [" + moduleFile + "]");
			}
			try {
				moduleRes.load(inputStream, Collections.emptyMap());
				moduleRes.setURI(URI.createURI(moduleUrl.toString()));
			} finally {
				inputStream.close();
			}
			return (Module) moduleRes.getContents().get(0);
		} catch (IOException e) {
			throw new ModuleNotFoundException(e);
		}
	}

}
