package org.eclipse.m2m.atl.adt.debug;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The main plugin class to be used in the desktop.
 */
public class AtlDebugPlugin extends AbstractUIPlugin {
	//The shared instance.
	private static AtlDebugPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	IDebugModelPresentation fUtilPresentation;
	/**
	 * The constructor.
	 */
	public AtlDebugPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.eclipse.m2m.atl.adt.debug.AtlDebugPluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * Returns the shared instance.
	 */
	public static AtlDebugPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = AtlDebugPlugin.getDefault().getResourceBundle();
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
	 * Return the unique identifier of the plugin
	 * @return
	 */
	public static String getUniqueIdentifier() {
		return AtlDebugPlugin.getDefault().getBundle().getSymbolicName();
	}
	
	/**
	 * Returns a shared utility Atl debug model presentation. Clients should not
	 * dispose the presentation.
	 * 
	 * @return an Atl debug model presentation
	 */
	public IDebugModelPresentation getModelPresentation() {
		if (fUtilPresentation == null) {
			fUtilPresentation = DebugUITools.newDebugModelPresentation(getUniqueIdentifier());
		}
		return fUtilPresentation;
	}
}
