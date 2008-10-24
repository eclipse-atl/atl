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

import java.io.InputStream;
import java.io.OutputStream;
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
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;

/**
 * The abstract model handler definition.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public abstract class AtlModelHandler {

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
	 * Saves a model at the specified uri (as String).
	 * 
	 * @param model
	 *            the model to save
	 * @param uri
	 *            the uri
	 */
	public abstract void saveModel(final ASMModel model, String uri);

	/**
	 * Saves a model in an output stream.
	 * 
	 * @param model
	 *            the model to save
	 * @param out
	 *            the output stream
	 */
	public abstract void saveModel(final ASMModel model, OutputStream out);

	/**
	 * Returns the ATL metamodel.
	 * 
	 * @return the ATL metamodel
	 */
	public abstract ASMModel getAtl();

	/**
	 * Returns the MOF.
	 * 
	 * @return the MOF
	 */
	public abstract ASMModel getMof();

	/**
	 * Loads a model by an input stream.
	 * 
	 * @param name
	 *            the model name
	 * @param metamodel
	 *            the metamodel
	 * @param in
	 *            the input stream
	 * @return the loaded ASMModel
	 */
	public abstract ASMModel loadModel(String name, ASMModel metamodel, InputStream in);

	/**
	 * Creates a new ASMModel. Only use this method if the model URI is not known.
	 * 
	 * @param name
	 *            The model name.
	 * @param metamodel
	 *            the metamodel
	 * @deprecated Use {@link #newModel(String, String, ASMModel)} instead
	 * @return the new ASMModel
	 */
	public abstract ASMModel newModel(String name, ASMModel metamodel);

	/**
	 * Creates a new ASMModel. Use this method whenever the model URI is known.
	 * 
	 * @param name
	 *            The model name.
	 * @param uri
	 *            The model uri.
	 * @param metamodel
	 *            the metamodel
	 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
	 * @return the new ASMModel
	 */
	public abstract ASMModel newModel(String name, String uri, ASMModel metamodel);

	/**
	 * Performs necessary clean-up such as freeing memory. It should be redefined by any AtlModelHandler
	 * requiring specific clean-upon actions to be performed. This method should be called once the ASMModel
	 * is not needed any more.
	 * 
	 * @param model
	 *            the model to dispose
	 */
	public void disposeOfModel(ASMModel model) {

	}

	/**
	 * Returns the built in metamodel with the given name.
	 * 
	 * @param name
	 *            the given name
	 * @return the built in metamodel with the given name
	 */
	public abstract ASMModel getBuiltInMetaModel(String name);

	/**
	 * Returns true if the model is handled by the current model handler.
	 * 
	 * @param model
	 *            the model to test
	 * @return true if the model is handled by the current model handler.
	 */
	public abstract boolean isHandling(ASMModel model);
}
