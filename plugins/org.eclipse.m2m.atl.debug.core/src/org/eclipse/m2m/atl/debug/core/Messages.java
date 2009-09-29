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
package org.eclipse.m2m.atl.debug.core;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Utility class to access externalized Strings for ATLDebug.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class Messages {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.atl.debug.core.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	/**
	 * Returns a specified {@link String} from the resource bundle.
	 * 
	 * @param key
	 *            Key of the String we seek.
	 * @return The String from the resource bundle associated with <code>key</code>.
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Returns a String from the resource bundle binded with the given arguments.
	 * 
	 * @param key
	 *            Key of the String we seek.
	 * @param arguments
	 *            Arguments for the String formatting.
	 * @return formatted {@link String}.
	 * @see MessageFormat#format(String, Object[])
	 */
	public static String getString(String key, Object[] arguments) {
		if (arguments == null) {
			return getString(key);
		}
		return MessageFormat.format(getString(key), arguments);
	}
}
