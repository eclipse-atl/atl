/*******************************************************************************
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Frédéric Jouault & Mikaël Barbero (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.dsls.textsource.TextSource;
import org.eclipse.m2m.atl.dsls.textsource.URLTextSource;
import org.osgi.framework.Bundle;

public class DSLResourceProvider {
	
	private static DSLResourceProvider INSTANCE = null;

	private static String resourcesRoot = "resources/";
	private static Map resourcesById = new HashMap();

	public static DSLResourceProvider getDefault() {
		if(INSTANCE == null) {
			INSTANCE = new DSLResourceProvider();
			IExtensionRegistry registry = Platform.getExtensionRegistry();
	        if (registry == null) {
	            throw new RuntimeException("Extension registry not found");
	        }
	        
			IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.dsls.dslresourceprovider"); //$NON-NLS-1$
	
			IExtension[] extensions = point.getExtensions();		
			extensions: for(int i = 0 ; i < extensions.length ; i++){		
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for(int j = 0 ; j < elements.length ; j++){
					try {					
						elements[j].createExecutableExtension("class"); //$NON-NLS-1$
						break extensions;
					} catch (CoreException e){
	//					logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
						e.printStackTrace();
					}				
				}
			}

		}
		return INSTANCE;
	}

	public Resource getResource(String id) {
		return (Resource)resourcesById.get(id);
	}

	protected DSLResourceProvider() {
		initResources(resourcesById);
	}

	private void initResources(Map resourcesById) {
		try {
			BufferedReader in = new URLTextSource(getURL("contents.list")).openBufferedReader();
			String line;
			while((line = in.readLine()) != null) {
				if(!(line.trim().length() == 0)) {
					final URL url = getURL(line);	// will throw an Exception if cannot load
					// Note: url could be recomputed, but we need to compute it
					// before creating the Resource to make sure the resource exists

					final String path = line;
					final String pluginId = getPluginId();
					resourcesById.put(line.intern(), new Resource() {
						public TextSource asTextSource() {
							return new URLTextSource(url);
						}

						public URL asURL() {
							return url;
						}

						public URI asEMFURI() {
							// The following line is not compatible with Eclipse 2.2.x
							//return URI.createPlatformPluginURI("/" + pluginId + "/" + resourcesRoot + path, true);
							try {
								return URI.createURI(FileLocator.resolve(url).toString());
							} catch (IOException e) {
								return null;
							}
						}
					});
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("error loading resource", e);
		}
	}

	private URL getURL(String path) {
		Bundle bundle = getBundle();
		URL url = FileLocator.find(bundle, new Path(resourcesRoot + path), Collections.EMPTY_MAP);
		if(url != null) {
			return url;
		} else {
			throw new RuntimeException("could not load " + path);
		}
	}
	
	/**
	 * Must be redefined in sub-classes.
	 * @return
	 */
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	/**
	 * Must be redefined in sub-classes.
	 * @return
	 */
	protected String getPluginId() {
		return Activator.PLUGIN_ID;
	}
}
