/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.m2m.atl.adt.ui.text.AtlTextTools;
import org.eclipse.m2m.atl.adt.ui.viewsupport.ProblemMarkerManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop. This class is necessary for every plug-in because it used
 * by Eclipse to dialog with it and its extensions.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlUIPlugin extends AbstractUIPlugin {

	private static final String ID = "org.eclipse.m2m.atl.adt.editor"; //$NON-NLS-1$

	/**
	 * This class registers a shared (static) instance of the plug-in that can be accessible from everywhere.
	 */
	private static AtlUIPlugin plugin;

	/**
	 * Our plug-in uses a text tools to allow every part of the plug-in to have the same tools for configuring
	 * their variables.
	 */
	private AtlTextTools atlTextTools;

	// The problem marker manager
	private ProblemMarkerManager problemMarkerManager;

	/**
	 * The resource bundle exists for the internationalization of the plug-in. The informations are stored in
	 * a file .properties and Eclipse used these files to set the default values. It also uses it to
	 * fPreferenceeStore the client values.
	 */
	private ResourceBundle resourceBundle;

	/**
	 * Creates a new instance of the ATL plug-in. Use the AbstractUIPlugin constructor to define it, and try
	 * to get the resource bundle.
	 * 
	 * @deprecated
	 */
	public AtlUIPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.eclipse.m2m.atl.adt.ui.AtlUIPluginResources"); //$NON-NLS-1$
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * Returns the problem markers manager.
	 * 
	 * @return the problem markers manager
	 */
	public synchronized ProblemMarkerManager getProblemMarkerManager() {
		if (problemMarkerManager == null)
			problemMarkerManager = new ProblemMarkerManager();
		return problemMarkerManager;
	}

	/**
	 * Returns the plugin's resource bundle.
	 * 
	 * @return the plugin's resource bundle
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/**
	 * Gets the ATL text tools used by the plug-in. If it doesn't exists, create a new one with the default
	 * preference fPreferenceeStore.
	 * 
	 * @return the text tools.
	 */
	public synchronized AtlTextTools getTextTools() {
		if (atlTextTools == null)
			atlTextTools = new AtlTextTools(getPreferenceStore());
		return atlTextTools;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeDefaultPreferences(org.eclipse.jface.preference.IPreferenceStore)
	 */
	@Override
	protected void initializeDefaultPreferences(IPreferenceStore store) {
		MarkerAnnotationPreferences.initializeDefaultValues(store);
		AtlPreferenceConstants.initializeDefaultValues(store);
	}

	private IWorkbenchPage internalGetActivePage() {
		IWorkbenchWindow window = getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return null;
		}
		return getWorkbench().getActiveWorkbenchWindow().getActivePage();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		try {
			if (atlTextTools != null) {
				atlTextTools.dispose();
				atlTextTools = null;
			}
		} finally {
			super.stop(context);
		}
	}

	/**
	 * Returns the {@link Image} at the given path.
	 * 
	 * @param path
	 *            the image path
	 * @return the {@link Image}
	 */
	public Image getImage(String path) {
		ImageRegistry registry = AtlUIPlugin.getDefault().getImageRegistry();
		Image image = registry.get(path);
		if (image == null) {
			ImageDescriptor desc = AtlUIPlugin.imageDescriptorFromPlugin(AtlUIPlugin.getPluginId(), path);
			registry.put(path, desc);
			image = registry.get(path);
		}
		return image;
	}

	public static IWorkbenchPage getActivePage() {
		return getDefault().internalGetActivePage();
	}

	/**
	 * Returns the shared instance of the plug-in.
	 * 
	 * @return the shared instance of the plug-in
	 */
	public static AtlUIPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the image descriptor with the given relative path.
	 * 
	 * @param name
	 *            the image name
	 * @return the image descriptor with the given relative path
	 */
	public static ImageDescriptor getImageDescriptor(String name) {
		AtlUIPlugin uiPlugin = AtlUIPlugin.getDefault();
		String pluginDir = uiPlugin.getBundle().getEntry("/").toString(); //$NON-NLS-1$
		String iconPath = "icons/"; //$NON-NLS-1$
		try {
			return ImageDescriptor.createFromURL(new URL(pluginDir + iconPath + name));
		} catch (MalformedURLException mfe) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}

	public static String getPluginId() {
		return ID;
	}

	/**
	 * Returns the string from the plugin's resource bundle, or 'key' if not found.
	 * 
	 * @param key
	 *            the default value
	 * @return the string from the plugin's resource bundle, or 'key' if not found
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = AtlUIPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

}
