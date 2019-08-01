/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.engine;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 * The activator class controls the plug-in life cycle
 */
public class AmlEnginePlugin extends Plugin {

	public static final String LOGGER = "org.eclipse.m2m.atl.research.aml";
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.m2m.atl.research.aml.engine";

	// The shared instance
	private static AmlEnginePlugin plugin;
	
	static {
		Logger logger = Logger.getLogger(LOGGER);
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();		
		logger.addHandler(handler);
	}
	
	/**
	 * The constructor
	 */
	public AmlEnginePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static AmlEnginePlugin getDefault() {
		return plugin;
	}

}
