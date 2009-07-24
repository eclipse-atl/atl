/*******************************************************************************
 * Copyright (c) 2007, 2009 Obeo.
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
import java.net.URISyntaxException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.BundleContext;

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

	private static String baseDirectory;
	
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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
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
	public static String getBaseDirectory() {
		if (baseDirectory == null) {
			if (Platform.isRunning()) {
				try {
					baseDirectory = new File(FileLocator.toFileURL(
							AtlTestPlugin.getDefault().getBundle().getEntry("/")).getFile()) //$NON-NLS-1$
							.getParent();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			} else {
				try {
					baseDirectory = new File(AtlTestPlugin.class.getResource("/").toURI()).getParentFile().getParent();
				} catch (URISyntaxException e) {
					// TODO: improve handling of exception
					e.printStackTrace();
				}
			}
		}
		return baseDirectory;
	}

}
