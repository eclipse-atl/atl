package org.eclipse.m2m.atl.adt.ui.preferences;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Use the ressource bundle to fetch externalized strings.
 * 
 * @author C. MONTI for ATL Team
 */
public class AtlPreferencesMessages {
	
	private static final String RESOURCE_BUNDLE = "org.eclipse.m2m.atl.adt.ui.preferences.PreferenceMessages";
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE);
	
	public static String getString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch(MissingResourceException e) {
			return "AtlPreferencesMessages says : !" + key + "!";
		}
	}
}
