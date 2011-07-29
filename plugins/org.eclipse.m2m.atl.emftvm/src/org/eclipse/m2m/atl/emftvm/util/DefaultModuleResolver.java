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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.Module;

/**
 * Resolves modules based on an EMF URI prefix.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class DefaultModuleResolver implements ModuleResolver {

	/**
	 * EMFTVM file extension to add when resolving modules.
	 */
	public static final String FILE_EXT = ".emftvm";

	private final List<String> uriPrefixes = new ArrayList<String>();
	private final ResourceSet resourceSet;

	/**
	 * Creates a new {@link DefaultModuleResolver}.
	 * @param uriPrefix the URI prefix to prepend to module names
	 * @param resourceSet the EMF {@link ResourceSet} to load modules into
	 */
	public DefaultModuleResolver(final String uriPrefix, final ResourceSet resourceSet) {
		super();
		if (uriPrefix == null) {
			throw new IllegalArgumentException("uriPrefix cannot be null");
		}
		if (resourceSet == null) {
			throw new IllegalArgumentException("resourceSet cannot be null");
		}
		this.uriPrefixes.add(uriPrefix);
		this.resourceSet = resourceSet;
	}

	/**
	 * {@inheritDoc}
	 */
	public Module resolveModule(final String name) throws ModuleNotFoundException {
		final Matcher m = EMFTVMUtil.DELIM_PATTERN.matcher(name);
		final String path = m.replaceAll("/");
		final ResourceSet rs = getResourceSet();
		for (String uriPrefix : getUriPrefixes()) {
			URI moduleURI = URI.createURI(uriPrefix + path + FILE_EXT);
			try {
				Resource r = rs.getResource(moduleURI, true);
				if (r != null) {
					return findModule(r, name);
				}
			} catch (WrappedException e) {
				//continue;
			} catch (ModuleNotFoundException e) {
				//continue;
			}
		}
		throw new ModuleNotFoundException(String.format("Module %s not found", name));
	}

	/**
	 * Returns the URI prefixes.
	 * @return the uriPrefixes
	 */
	public List<String> getUriPrefixes() {
		return Collections.unmodifiableList(uriPrefixes);
	}

	/**
	 * Adds <code>uriPrefix</code> to the URI prefixes list.
	 * @param uriPrefix the URI prefix to add
	 */
	public void addUriPrefix(final String uriPrefix) {
		if (uriPrefix == null) {
			throw new IllegalArgumentException("uriPrefix cannot be null");
		}
		uriPrefixes.add(uriPrefix);
	}

	/**
	 * Returns the EMF {@link ResourceSet}.
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Finds the module with <pre>name</pre> in {@link Resource} <pre>r</pre>.
	 * @param r
	 * @param name
	 * @return the module with the given name inside <pre>r</pre>, if any
	 * @throws ModuleNotFoundException
	 */
	private Module findModule(final Resource r, final String name) throws ModuleNotFoundException {
		for (EObject o : r.getContents()) {
			if (o instanceof Module) {
				Module m = (Module)o;
				if (name.equals(m.getName())) {
					return m;
				}
			}
		}
		throw new ModuleNotFoundException(String.format("Resource %s does not contain a module %s", r, name));
	}

}
