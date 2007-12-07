package org.eclipse.m2m.atl.adt.perspective;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The main plugin class to be used in the desktop.
 */
public class AtlPerspectivePlugin extends AbstractUIPlugin {
	//The shared instance.
	private static AtlPerspectivePlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	/**
	 * Gets the image at the given plug-in relative path.
	 */
	private static Map path2image = new HashMap();
	
	/**
	 * The constructor.
	 */
	public AtlPerspectivePlugin() {
		super();
		plugin = this;
		try {
			resourceBundle   = ResourceBundle.getBundle("atlPerspective.AtlPerspectivePluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * Returns the shared instance.
	 */
	public static AtlPerspectivePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = AtlPerspectivePlugin.getDefault().getResourceBundle();
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
	
	/**
	 * Looks for an image in the icons folder.
	 * 
	 * @param path
	 * @return the searched Image
	 */
	public static Image getImage(String path) {
		Image result = (Image) path2image.get(path);
		if (result == null && !path2image.containsKey(path)) {
			ImageDescriptor descriptor = getImageDescriptor(path);
			if (descriptor != null) {
				result = descriptor.createImage();
			} else {
				result = null;
			}
			path2image.put(path, result);
		}
		if (result.isDisposed()) {
			result = null;
		}
		return result;
	}
	
	/**
	 * Returns the image descriptor with the given relative path.
	 */
	static public ImageDescriptor getImageDescriptor(String name) {
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
}
