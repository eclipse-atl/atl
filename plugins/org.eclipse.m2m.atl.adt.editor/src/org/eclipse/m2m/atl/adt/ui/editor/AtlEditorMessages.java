package org.eclipse.m2m.atl.adt.ui.editor;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author C. MONTI for ATL Team
 */
public class AtlEditorMessages {
    
	private static final String RESOURCE_BUNDLE = "org.eclipse.m2m.atl.adt.ui.editor.EditorMessages";
	private static ResourceBundle rb = ResourceBundle.getBundle(RESOURCE_BUNDLE);
	
	public static String getString(String key) {
		try {
			return getResourceBundle().getString(key);
		} catch (MissingResourceException e) {
			return "AtlEditorMessages says : !" + key + "!";
		}
	}
	
	public static ResourceBundle getResourceBundle() {
		return rb;
	}
	
}
