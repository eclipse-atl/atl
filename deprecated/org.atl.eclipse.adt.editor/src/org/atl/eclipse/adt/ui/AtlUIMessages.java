/*
 * Created on 23 juil. 2004
 */
package org.atl.eclipse.adt.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author C. MONTI for ATL team
 */
public class AtlUIMessages {
	
	private static final String RESOURCE_BUNDLE = "org.atl.eclipse.adt.ui.AtlUIMessages";
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE);
	
	public static String getString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch(MissingResourceException e) {
			return "AtlUIMessages says : !" + key + "!";
		}
	}

}
