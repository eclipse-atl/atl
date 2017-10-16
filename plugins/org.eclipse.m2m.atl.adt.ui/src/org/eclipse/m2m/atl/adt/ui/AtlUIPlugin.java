/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;

import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The main plugin class to be used in the desktop.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlUIPlugin extends AbstractUIPlugin {
	/** The plugin id. */
	public static final String PLUGIN_ID = "org.eclipse.m2m.atl.adt.ui"; //$NON-NLS-1$

	/** The shared instance. */
	private static AtlUIPlugin plugin;

	/**
	 * Gets the image at the given plug-in relative path.
	 */
	private static Map<String, Image> path2image = new HashMap<String, Image>();

	/** Resource bundle. */
	private ResourceBundle resourceBundle;

	/**
	 * The constructor.
	 */
	public AtlUIPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("atlPerspective.AtlPerspectivePluginResources"); //$NON-NLS-1$
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
		addDebugEventListener();
	}

	/**
	 * Adds a debug event listener 
	 */
	private void addDebugEventListener() {
		DebugPlugin.getDefault().addDebugEventListener(new IDebugEventSetListener() {
			public void handleDebugEvents(final DebugEvent[] debugEvents) {
				for (DebugEvent debugEvent : debugEvents) {
					if (debugEvent.getKind() == DebugEvent.SUSPEND) {
						switchToDebugPerspective();
						break;
					}
				}
			}
		});
	}

	/**
	 * Switches to the debugging perspective.
	 */
	private void switchToDebugPerspective() {
		try {
			PlatformUI.getWorkbench().showPerspective("org.eclipse.debug.ui.DebugPerspective",
					PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		} catch (WorkbenchException e) {
			ATLLogger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static AtlUIPlugin getDefault() {
		return plugin;
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

	/**
	 * Returns the plugin's resource bundle.
	 * 
	 * @return the plugin's resource bundle
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/**
	 * Looks for an image in the icons folder.
	 * 
	 * @param path
	 *            the image path
	 * @return the searched Image
	 */
	public static Image getImage(String path) {
		Image result = path2image.get(path);
		if (result == null && !path2image.containsKey(path)) {
			ImageDescriptor descriptor = getImageDescriptor(path);
			if (descriptor != null) {
				result = descriptor.createImage();
				path2image.put(path, result);
			}
		}
		if (result != null) {
			if (result.isDisposed()) {
				result = null;
			}
		}
		return result;
	}

	/**
	 * Returns the image descriptor with the given relative path.
	 * 
	 * @param name
	 *            the image name
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String name) {
		if (Platform.isRunning()) {
			String pluginDir = plugin.getBundle().getEntry("/").toString(); //$NON-NLS-1$
			String iconPath = "icons/"; //$NON-NLS-1$
			try {
				return ImageDescriptor.createFromURL(new URL(pluginDir + iconPath + name));
			} catch (MalformedURLException mfe) {
				return ImageDescriptor.getMissingImageDescriptor();
			}
		}
		return null;
	}
}
