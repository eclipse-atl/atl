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
package org.eclipse.m2m.atl.adt.ui.preferences;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Use the ressource bundle to fetch externalized strings.
 */
public class AtlPreferencesMessages {
	
	private static final String RESOURCE_BUNDLE = "org.eclipse.m2m.atl.adt.ui.preferences.PreferenceMessages";//$NON-NLS-1$
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE);
	
	public static String getString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch(MissingResourceException e) {
			return "AtlPreferencesMessages says : !" + key + "!";//$NON-NLS-1$//$NON-NLS-2$
		}
	}
}
