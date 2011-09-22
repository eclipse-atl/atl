/*******************************************************************************
 * Copyright (c) 2004 INRIA and Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *    Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The abstract model handler definition.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public abstract class AtlModelHandler {

	/** EMF model handler name. */
	public static final String AMH_EMF = "EMF"; //$NON-NLS-1$

	private static String[] modelHandlers;

	private static Map defaultModelHandlers = new HashMap();

	/**
	 * Registers the given handler as the default model handler for the given repository.
	 * 
	 * @param repository
	 *            The repository ID (e.g. "EMF" or "MDR")
	 * @param handler
	 *            The default AtlModelHandler object to use.
	 */
	public static void registerDefaultHandler(String repository, AtlModelHandler handler) {
		defaultModelHandlers.put(repository, handler);
	}

	/**
	 * Returns the default model handler.
	 * 
	 * @param repository
	 *            The repository ID (e.g. "EMF" or "MDR")
	 * @return the default model handler.
	 */
	public static AtlModelHandler getDefault(String repository) {
		AtlModelHandler ret = (AtlModelHandler)defaultModelHandlers.get(repository);
		if (ret == null) {
				IExtensionRegistry registry = Platform.getExtensionRegistry();
				if (registry == null) {
				throw new RuntimeException(
						"Eclipse platform extension registry not found. Dynamic repository lookup does not work outside Eclipse."); //$NON-NLS-1$
				}

				IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.engine.vm.modelhandler"); //$NON-NLS-1$

				IExtension[] extensions = point.getExtensions();
				extensions: for (int i = 0; i < extensions.length; i++) {
					IConfigurationElement[] elements = extensions[i].getConfigurationElements();
					for (int j = 0; j < elements.length; j++) {
						try {
							if (elements[j].getAttribute("name").equals(repository)) { //$NON-NLS-1$
								ret = (AtlModelHandler)elements[j].createExecutableExtension("class"); //$NON-NLS-1$
								defaultModelHandlers.put(repository, ret);
								break extensions;
							}
						} catch (CoreException e) {
							ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
						}
					}
				}
		}

			if (ret == null) {
			throw new RuntimeException(
					"Model handler for " + repository + " not found. You may need to install a model handler plugin."); //$NON-NLS-1$
		}

		return ret;
	}

	/**
	 * Returns the model handlers ids.
	 * 
	 * @return the model handlers ids
	 */
	public static String[] getModelHandlers() {
		if (modelHandlers == null) {
			List mhs = new ArrayList();
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.engine.vm.modelhandler"); //$NON-NLS-1$

			IExtension[] extensions = point.getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for (int j = 0; j < elements.length; j++) {
					mhs.add(elements[j].getAttribute("name")); //$NON-NLS-1$
				}
			}
			modelHandlers = (String[])mhs.toArray(new String[] {});
		}
		return modelHandlers;
	}

	public static String getHandlerName(ASMModel model) {
		String ret = null;

		for (Iterator i = defaultModelHandlers.keySet().iterator(); i.hasNext() && (ret == null);) {
			String amhName = (String)i.next();
			AtlModelHandler amh = getDefault(amhName);
			if (amh.isHandling(model)) {
				ret = amhName;
			}
		}
		return ret;
	}

	/**
	 * Returns the handler of a given model.
	 * 
	 * @param model
	 *            the model
	 * @return the handler of a given model
	 */
	public static AtlModelHandler getHandler(ASMModel model) {
		return (AtlModelHandler)defaultModelHandlers.get(getHandlerName(model));
	}

	/**
	 * Returns true if the model is handled by the current model handler.
	 * 
	 * @param model
	 *            the model to test
	 * @return true if the model is handled by the current model handler.
	 */
	public abstract boolean isHandling(ASMModel model);
	
	/**
	 * @return A new ModelLoader instance corresponding to this kind of handler.
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 */
	public abstract ModelLoader createModelLoader();
}
