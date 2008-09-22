/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.launching;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.m2m.atl.ATLPlugin;
import org.eclipse.m2m.atl.adt.debug.AtlDebugMessages;

/**
 * The ATL VM launch abstract class.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public abstract class AtlVM implements ILaunchConfigurationDelegate {

	/** The ATL regular vm name. */
	public static final String ATLVM_REGULAR = "Regular VM (with debugger)"; //$NON-NLS-1$

	private static String[] atlVMs;

	/**
	 * Returns the vm matching the given name.
	 * 
	 * @param vm
	 *            the vm name
	 * @return the vm matching the given name
	 */
	public static AtlVM getVM(String vm) {
		AtlVM ret = null;
		String usedVm = vm;
		// TODO old ATL launch configuration does not have vm attribute, retro-compatibility may be dealed by
		// ATL launch configuration
		if (usedVm == null || usedVm.equals("")) { //$NON-NLS-1$
			usedVm = ATLVM_REGULAR;
		}

		if (ATLVM_REGULAR.equals(usedVm)) {
			ret = new AtlRegularVM();
		} else {
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			if (registry == null) {
				throw new RuntimeException(AtlDebugMessages.getString("AtlVM.EMFREGISTRYNOTFOUND")); //$NON-NLS-1$
			}

			IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.adt.debug.atlvm"); //$NON-NLS-1$

			IExtension[] extensions = point.getExtensions();
			extensions: for (int i = 0; i < extensions.length; i++) {
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for (int j = 0; j < elements.length; j++) {
					try {
						if (elements[j].getAttribute("name").equals(usedVm)) { //$NON-NLS-1$
							ret = (AtlVM)elements[j].createExecutableExtension("class"); //$NON-NLS-1$
							break extensions;
						}
					} catch (CoreException e) {
						ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
			}
		}

		if (ret == null) {
			throw new RuntimeException(AtlDebugMessages.getString("AtlVM.VMNOTFOUND", new Object[] {usedVm})); //$NON-NLS-1$
		}

		return ret;
	}

	/**
	 * Return all vm names.
	 * 
	 * @return all vm names
	 */
	public static String[] getVMs() {
		if (atlVMs == null) {
			List avms = new ArrayList();
			avms.add(ATLVM_REGULAR);

			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IExtensionPoint point = registry.getExtensionPoint("org.eclipse.m2m.atl.adt.debug.atlvm"); //$NON-NLS-1$

			IExtension[] extensions = point.getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				IConfigurationElement[] elements = extensions[i].getConfigurationElements();
				for (int j = 0; j < elements.length; j++) {
					avms.add(elements[j].getAttribute("name")); //$NON-NLS-1$
				}
			}
			atlVMs = (String[])avms.toArray(new String[] {});
		}
		return atlVMs;
	}

	/**
	 * Abstract VM launch method.
	 * 
	 * @param asmUrl
	 *            path of the ATL Transformation
	 * @param libs
	 *            libraries map
	 * @param models
	 *            models map
	 * @param params
	 *            parameters map
	 * @param superimps
	 *            list of module to superimpose
	 * @param options
	 *            transformation options
	 * @return unused (TODO)
	 */
	public abstract Object launch(URL asmUrl, Map libs, Map models, Map params, List superimps, Map options);
}
