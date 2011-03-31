/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.examples;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * ATL examples plugin.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLExamplesPlugin extends AbstractUIPlugin {

	/** The plugin id. */
	public static final String PLUGIN_ID = "org.eclipse.m2m.atl.examples"; //$NON-NLS-1$
	
	private static ATLExamplesPlugin instance;

	/**
	 * Constructor.
	 */
	public ATLExamplesPlugin() {
		instance = this;
	}

	/**
	 * Returns the default {@link ATLExamplesPlugin} instance.
	 * 
	 * @return the default {@link ATLExamplesPlugin} instance
	 */
	public static ATLExamplesPlugin getDefault() {
		if (instance == null) {
			return new ATLExamplesPlugin();
		}
		return instance;
	}

}
