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
package org.eclipse.m2m.atl.adt.ui.editor;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class AtlEditorMessages {
    
	private static final String RESOURCE_BUNDLE = "org.eclipse.m2m.atl.adt.ui.editor.EditorMessages";//$NON-NLS-1$
	private static ResourceBundle rb = ResourceBundle.getBundle(RESOURCE_BUNDLE);
	
	public static String getString(String key) {
		try {
			return getResourceBundle().getString(key);
		} catch (MissingResourceException e) {
			return "AtlEditorMessages says : !" + key + "!";//$NON-NLS-1$//$NON-NLS-2$
		}
	}
	
	public static ResourceBundle getResourceBundle() {
		return rb;
	}
	
}
