/*******************************************************************************
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - ATL tester
 *******************************************************************************/
package org.eclipse.m2m.atl.tests;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author William Piers <a href="mailto:william.piers@obeo.fr">william.piers@obeo.fr</a>
 */
public class AtlTestPlugin extends Plugin {
	/** The plug-in ID. */
	public static final String PLUGIN_ID = "org.eclipse.m2m.atl.tests"; //$NON-NLS-1$

	/** The shared instance */
	private static AtlTestPlugin plugin;

	/** the main resourceSet */
	private final static ResourceSet resourceSet = new ResourceSetImpl();

	/**
	 * Default constructor for the plugin.
	 */
	public AtlTestPlugin() {
		super();
		plugin = this;
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static AtlTestPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the main ResourceSet.
	 * 
	 * @return the main ResourceSet
	 */
	public static ResourceSet getResourceSet() {
		return resourceSet;
	}
	
}
