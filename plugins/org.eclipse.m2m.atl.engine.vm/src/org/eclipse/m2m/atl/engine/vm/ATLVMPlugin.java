/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.m2m.atl.logging.ATLLogFormatter;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class ATLVMPlugin extends Plugin {

	public static final String LOGGER = "org.eclipse.m2m.atl";
	
	//TODO change level to Level.INFO for production use
	public static final Level LOGLEVEL = Level.ALL;

	//The shared instance.
	private static ATLVMPlugin plugin;
	
	static {
		Logger logger = Logger.getLogger(LOGGER);
		logger.setLevel(LOGLEVEL);
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setFormatter(ATLLogFormatter.INSTANCE);
		handler.setLevel(LOGLEVEL);
		logger.addHandler(handler);
	}
	
	/**
	 * The constructor.
	 */
	public ATLVMPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static ATLVMPlugin getDefault() {
		return plugin;
	}
}
