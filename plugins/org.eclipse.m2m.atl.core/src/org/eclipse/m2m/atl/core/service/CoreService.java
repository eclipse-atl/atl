/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;

/**
 * The CoreService utility class provides a way to use extension points in order to retrieve the needed
 * extensions:
 * <ul>
 * <li>{@link ILauncher}</li>
 * <li>{@link IInjector}</li>
 * <li>{@link IExtractor}</li>
 * <li>{@link ModelFactory}</li>
 * </ul>
 * For each extension class type, a method returns the list of all detected extensions names.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class CoreService {

	private static final String LAUNCHERS_EXTENSION_POINT = "org.eclipse.m2m.atl.core.launcher"; //$NON-NLS-1$

	private static final String INJECTORS_EXTENSION_POINT = "org.eclipse.m2m.atl.core.injector"; //$NON-NLS-1$

	private static final String EXTRACTORS_EXTENSION_POINT = "org.eclipse.m2m.atl.core.extractor"; //$NON-NLS-1$

	private static final String MODELS_EXTENSION_POINT = "org.eclipse.m2m.atl.core.model"; //$NON-NLS-1$

	private static Map<String, Object> launcherRegistry = new HashMap<String, Object>();

	private static Map<String, Object> injectorRegistry = new HashMap<String, Object>();

	private static Map<String, Object> extractorRegistry = new HashMap<String, Object>();

	private static Map<String, Class<?>> factoryRegistry = new HashMap<String, Class<?>>();

	private CoreService() {
		super();
	}

	private static void register(Map<String, Object> registry, String extensionName, Object value) {
		if (!registry.containsKey(extensionName)) {
			registry.put(extensionName, value);
		}
	}

	/**
	 * Registers a launcher in the launcherRegistry.
	 * 
	 * @param launcher
	 *            the launcher
	 */
	public static void registerLauncher(ILauncher launcher) {
		register(launcherRegistry, launcher.getName(), launcher);
	}

	/**
	 * Registers an injector in the injectorRegistry.
	 * 
	 * @param name
	 *            the injector name
	 * @param injector
	 *            the injector
	 */
	public static void registerInjector(String name, IInjector injector) {
		register(injectorRegistry, name, injector);
	}

	/**
	 * Registers an extractor in the extractorRegistry.
	 * 
	 * @param name
	 *            the extractor name
	 * @param extractor
	 *            the extractor
	 */
	public static void registerExtractor(String name, IExtractor extractor) {
		register(extractorRegistry, name, extractor);
	}

	/**
	 * Registers a factory in the factoryRegistry.
	 * 
	 * @param name
	 *            the factory name
	 * @param factoryClass
	 *            the factory class
	 */
	public static void registerFactory(String name, Class<?> factoryClass) {
		if (!factoryRegistry.containsKey(name)) {
			factoryRegistry.put(name, factoryClass);
		}
	}

	/**
	 * Creates a new {@link ModelFactory} with the given name.
	 * 
	 * @param name
	 *            the factory name
	 * @return the new ModelFactory
	 */
	public static ModelFactory createModelFactory(String name) throws ATLCoreException {
		if (factoryRegistry.containsKey(name)) {
			try {
				return (ModelFactory)factoryRegistry.get(name).newInstance();	
			} catch (IllegalAccessException e) {
				throw new ATLCoreException(e.getMessage(), e);
			} catch (InstantiationException e) {
				throw new ATLCoreException(e.getMessage(), e);
			}			
		} else {
			return (ModelFactory)getExtensionClass(MODELS_EXTENSION_POINT, "modelFactory", name); //$NON-NLS-1$
		}
	}

	private static Object getExtensionClass(String extensionId, String executableExtensionName,
			String extensionName, Map<String, Object> registry) throws ATLCoreException {
		if (registry.containsKey(extensionName)) {
			return registry.get(extensionName);
		} else {
			Object executable = getExtensionClass(extensionId, executableExtensionName, extensionName);
			if (executable != null) {
				registry.put(extensionName, executable);
				return executable;
			} else {
				throw new ATLCoreException(extensionId + " " + extensionName //$NON-NLS-1$
						+ " not found, check the spelling or register it manually"); //$NON-NLS-1$
			}
		}
	}

	private static Object getExtensionClass(String extensionId, String executableExtensionName,
			String extensionName) throws ATLCoreException {
		if (Platform.isRunning()) {
			final IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(extensionId)
					.getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				final IConfigurationElement[] configElements = extensions[i].getConfigurationElements();
				for (int j = 0; j < configElements.length; j++) {
					if (configElements[j].getAttribute("name").equals(extensionName)) { //$NON-NLS-1$
						Object executable;
						try {
							executable = configElements[j].createExecutableExtension(executableExtensionName);
						} catch (CoreException e) {
							throw new ATLCoreException(e.getMessage(), e);
						}
						return executable;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the launcher matching the given name.
	 * 
	 * @param name
	 *            the launcher name
	 * @return the launcher matching the given name
	 * @throws ATLCoreException
	 */
	public static ILauncher getLauncher(String name) throws ATLCoreException {
		return (ILauncher)getExtensionClass(LAUNCHERS_EXTENSION_POINT, "class", name, launcherRegistry); //$NON-NLS-1$
	}

	/**
	 * Returns the injector matching the given name.
	 * 
	 * @param name
	 *            the injector name
	 * @return the injector matching the given name
	 * @throws ATLCoreException
	 */
	public static IInjector getInjector(String name) throws ATLCoreException {
		return (IInjector)getExtensionClass(INJECTORS_EXTENSION_POINT, "class", name, injectorRegistry); //$NON-NLS-1$
	}

	/**
	 * Returns the extractors matching the given name.
	 * 
	 * @param name
	 *            the extractors name
	 * @return the extractors matching the given name
	 * @throws ATLCoreException
	 */
	public static IExtractor getExtractor(String name) throws ATLCoreException {
		return (IExtractor)getExtensionClass(EXTRACTORS_EXTENSION_POINT, "class", name, extractorRegistry); //$NON-NLS-1$
	}

	private static String[] getExtensionsNames(String extensionId) {
		List<String> launcherNames = new ArrayList<String>();
		if (Platform.isRunning()) {
			final IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(extensionId)
					.getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				final IConfigurationElement[] configElements = extensions[i].getConfigurationElements();
				for (int j = 0; j < configElements.length; j++) {
					launcherNames.add(configElements[j].getAttribute("name")); //$NON-NLS-1$
				}
			}
		}
		return launcherNames.toArray(new String[] {});
	}

	/**
	 * Returns the available launchers names.
	 * 
	 * @return the available launchers names
	 */
	public static String[] getLaunchersNames() {
		return getExtensionsNames(LAUNCHERS_EXTENSION_POINT);
	}

	/**
	 * Returns the available injectors names.
	 * 
	 * @return the available injectors names
	 */
	public static String[] getInjectorsNames() {
		return getExtensionsNames(INJECTORS_EXTENSION_POINT);
	}

	/**
	 * Returns the available extractors names.
	 * 
	 * @return the available extractors names
	 */
	public static String[] getExtractorsNames() {
		return getExtensionsNames(EXTRACTORS_EXTENSION_POINT);
	}

	/**
	 * Returns the available model factories names.
	 * 
	 * @return the available model factories names
	 */
	public static String[] getModelFactoriesNames() {
		return getExtensionsNames(MODELS_EXTENSION_POINT);
	}

	/**
	 * Returns the options Map (id, description) for the given launcher.
	 * 
	 * @param launcherName
	 *            the launcher name
	 * @return the options Map
	 */
	public static Map<String, String> getLauncherOptions(String launcherName) {
		if (Platform.isRunning()) {
			final IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(
					LAUNCHERS_EXTENSION_POINT).getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				final IConfigurationElement[] configElements = extensions[i].getConfigurationElements();
				for (int j = 0; j < configElements.length; j++) {
					if (launcherName.equals(configElements[j].getAttribute("name"))) { //$NON-NLS-1$
						Map<String, String> optionsMap = new HashMap<String, String>();
						IConfigurationElement[] options = configElements[j].getChildren("option"); //$NON-NLS-1$
						for (int k = 0; k < options.length; k++) {
							optionsMap.put(options[k].getAttribute("name"), options[k] //$NON-NLS-1$
									.getAttribute("description")); //$NON-NLS-1$
						}
						return optionsMap;
					}
				}
			}
		}
		return null;
	}

}