/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import java.util.regex.Matcher;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.Module;


/**
 * Resolves modules based on an EMF URI prefix.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class DefaultModuleResolver implements ModuleResolver {

	/**
	 * EMFTVM file extension to add when resolving modules.
	 */
	public static final String FILE_EXT = ".emftvm";

	private final String uriPrefix;
	private final ResourceSet resourceSet;

	/**
	 * Creates a new {@link DefaultModuleResolver}.
	 * @param uriPrefix
	 * @param resourceSet
	 */
	public DefaultModuleResolver(final String uriPrefix, final ResourceSet resourceSet) {
		super();
		this.uriPrefix = uriPrefix;
		this.resourceSet = resourceSet;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.m2m.atl.emftvm.util.ModuleResolver#resolveModule(java.lang.String)
	 */
	public Module resolveModule(String name) throws ModuleNotFoundException {
		final Matcher m = EMFTVMUtil.DELIM_PATTERN.matcher(name);
		final URI moduleURI = URI.createURI(uriPrefix + m.replaceAll("/") + FILE_EXT);
		final ResourceSet rs = getResourceSet();
		final Resource r = rs.getResource(moduleURI, true);
		if (r == null) {
			throw new ModuleNotFoundException(String.format("Module %s not found", name));
		}
		return findModule(r, name);
	}

	/**
	 * @return the uriPrefix
	 */
	public String getUriPrefix() {
		return uriPrefix;
	}

	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * @param r
	 * @param name
	 * @return the module with the given name inside r, if any
	 * @throws ModuleNotFoundException
	 */
	private Module findModule(final Resource r, final String name) throws ModuleNotFoundException {
		for (EObject o : r.getContents()) {
			if (o instanceof Module) {
				Module m = (Module) o;
				if (name.equals(m.getName())) {
					return m;
				}
			}
		}
		throw new ModuleNotFoundException(String.format("Resource %s does not contain a module %s", r, name));
	}

}
