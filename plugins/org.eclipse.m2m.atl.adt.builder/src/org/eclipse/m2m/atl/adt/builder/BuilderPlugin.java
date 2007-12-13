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
package org.eclipse.m2m.atl.adt.builder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;


/**
 * The main plugin class to be used in the desktop.
 */
public class BuilderPlugin extends AbstractUIPlugin {
	//The shared instance.
	private static BuilderPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;	
	
	/**
	 * The constructor.
	 */
	public BuilderPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle   = ResourceBundle.getBundle("org.eclipse.m2m.atl.adt.builder.BuilderPluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}	
	}
	
	/**
     * Returns the image descriptor with the given relative path.
     */
    static public ImageDescriptor getImageDescriptor(String name) {
        BuilderPlugin plugin = BuilderPlugin.getDefault();
        String pluginDir = plugin.getBundle().getEntry("/").toString();
        String iconPath = "icons/";
        try {
            return ImageDescriptor.createFromURL(
                    new URL(pluginDir + iconPath + name));
        }
        catch(MalformedURLException mfe) {
            return ImageDescriptor.getMissingImageDescriptor();
        }
    }
	
	/**
	 * Returns the shared instance.
	 */
	public static BuilderPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = BuilderPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}
