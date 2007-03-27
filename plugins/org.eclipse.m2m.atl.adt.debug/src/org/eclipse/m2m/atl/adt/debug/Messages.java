/*
 * Created on 2 juil. 2004
 */
package org.eclipse.m2m.atl.adt.debug;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author allilaire
 */
public class Messages {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.atl.adt.debug.messages_english";//$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}