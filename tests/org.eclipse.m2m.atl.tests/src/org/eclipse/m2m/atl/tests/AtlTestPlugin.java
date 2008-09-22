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

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.ATLPlugin;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlTestPlugin extends Plugin {

	/** The plug-in ID. */
	public static final String PLUGIN_ID = "org.eclipse.m2m.atl.tests"; //$NON-NLS-1$

	/** The shared instance. */
	private static AtlTestPlugin plugin;

	/** the main resourceSet. */
	private static ResourceSet resourceSet = new ResourceSetImpl();

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
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Returns the base test data directory.
	 * 
	 * @return the base test data directory
	 */
	public String getBaseDirectory() {
		try {
			return new File(FileLocator.toFileURL(AtlTestPlugin.getDefault().getBundle().getEntry("/"))
					.getFile()).getParent();
		} catch (IOException e) {
			ATLPlugin.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return null;
	}
}
