/*******************************************************************************
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Frederic Jouault & Mikael Barbero (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.dsls.textsource.TextSource;
import org.eclipse.m2m.atl.dsls.textsource.URLTextSource;
import org.osgi.framework.Bundle;

/**
 * The DSL resource provider.
 *
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class DSLResourceProvider {

	private static DSLResourceProvider instance;

	private static String resourcesRoot = "resources/"; //$NON-NLS-1$

	private static Map<String, Resource> resourcesById = new HashMap<>();

	/**
	 * Returns the default DSL provider.
	 *
	 * @return the default DSL provider
	 */
	public static DSLResourceProvider getDefault() {
		if (instance == null) {
			instance = new DSLResourceProvider();
			instance.initResources();
			final IExtensionRegistry registry = Platform.getExtensionRegistry();
			if (registry == null) {
				ATLLogger.log(Level.SEVERE,Messages.getString("DSLResourceProvider.EXTENSIONREGISTRYNOTFOUND"),null); //$NON-NLS-1$
				return null;
			}

			final IExtensionPoint point = registry
					.getExtensionPoint("org.eclipse.m2m.atl.dsls.dslresourceprovider"); //$NON-NLS-1$

			final IExtension[] extensions = point.getExtensions();
			extensions: for (int i = 0; i < extensions.length; i++) {
				final IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for (int j = 0; j < elements.length; j++) {
					try {
						final DSLResourceProvider resourceProvider = (DSLResourceProvider)elements[j]
								.createExecutableExtension("class"); //$NON-NLS-1$
						resourceProvider.initResources();
						break extensions;
					} catch (final CoreException e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
			}

		}
		return instance;
	}

	/**
	 * Returns the resource by id.
	 *
	 * @param id the resource Id
	 * @return the resource by id
	 */
	public Resource getResource(final String id) {
		return resourcesById.get(id);
	}

	private void initResources() {
		try {
			final BufferedReader in = new URLTextSource(getURL("contents.list")).openBufferedReader(); //$NON-NLS-1$
			String line;
			while ((line = in.readLine()) != null) {
				if (!(line.trim().length() == 0)) {
					final URL url = getURL(line); // will throw an Exception if cannot load
					// Note: url could be recomputed, but we need to compute it
					// before creating the Resource to make sure the resource exists

					resourcesById.put(line.intern(), new Resource() {
						@Override
						public TextSource asTextSource() {
							return new URLTextSource(url);
						}

						@Override
						public URL asURL() {
							return url;
						}

						@Override
						public URI asEMFURI() {
							// The following line is not compatible with Eclipse 2.2.x
							// return URI.createPlatformPluginURI("/" + pluginId + "/" + resourcesRoot + path,
							// true);
							try {
								return URI.createURI(FileLocator.resolve(url).toString());
							} catch (final IOException e) {
								return null;
							}
						}
					});
				}
			}
		} catch (final IOException e) {
			ATLLogger.log(Level.SEVERE,Messages.getString("DSLResourceProvider.LOADINGERROR"), e); //$NON-NLS-1$
		}
	}

	private URL getURL(final String path) {
		final Bundle bundle = getBundle();
		final URL url = FileLocator.find(bundle, new Path(resourcesRoot + path), Collections.emptyMap());
		if (url != null) {
			return url;
		} else {
			ATLLogger.log(Level.SEVERE,Messages.getString("DSLResourceProvider.COULDNOTLOAD",new Object[]{path}),null); //$NON-NLS-1$
			return null;
		}
	}

	/**
	 * Returns the bundle.
	 * Must be redefined in sub-classes.
	 *
	 * @return the bundle
	 */
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	/**
	 * Returns the plugin Id.
	 * Must be redefined in sub-classes.
	 *
	 * @return the plugin Id
	 */
	protected String getPluginId() {
		return Activator.PLUGIN_ID;
	}
}
