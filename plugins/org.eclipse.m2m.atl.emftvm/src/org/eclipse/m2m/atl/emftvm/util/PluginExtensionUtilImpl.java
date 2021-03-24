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
package org.eclipse.m2m.atl.emftvm.util;

import java.util.logging.Level;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.emftvm.ModelFactory;

/**
 * Implementation for {@link PluginExtensionUtil}.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class PluginExtensionUtilImpl implements PluginExtensionUtil {

	private static final String MODELFACTORY_EXTENSION_POINT = "org.eclipse.m2m.atl.emftvm.modelfactory";

	/**
	 * {@inheritDoc}
	 */
	public TypeMap<Class<?>, ModelFactory> createModelFactoryRegistry() {
		final TypeMap<Class<?>, ModelFactory> modelFactoryRegistry = new TypeHashMap<Class<?>, ModelFactory>();
		if (Platform.isRunning()) {
			final IExtension[] extensions = Platform.getExtensionRegistry()
					.getExtensionPoint(MODELFACTORY_EXTENSION_POINT).getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				final IConfigurationElement[] configElements = extensions[i].getConfigurationElements();
				for (int j = 0; j < configElements.length; j++) {
					final String resourceType = configElements[j].getAttribute("resourceType");
					if (resourceType != null && resourceType.length() > 0) {
						try {
							final Class<?> resourceClass = Class.forName(resourceType);
							final ModelFactory modelFactory = (ModelFactory) configElements[j]
									.createExecutableExtension("class");
							modelFactoryRegistry.put(resourceClass, modelFactory);
						} catch (final ClassNotFoundException e) {
							ATLLogger.log(Level.WARNING, "Cannot find specified resourceType", e);
						} catch (final CoreException e) {
							ATLLogger.log(Level.WARNING, "Cannot create instance of specified class", e);
						}
					}
				}
			}
		}
		return modelFactoryRegistry;
	}

}
