/*******************************************************************************
 * Copyright (c) 2006, 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class, controls the plug-in life cycle. Defines the common log utilities for all ATL plugins.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLPlugin extends Plugin {

	/** The plugin ID. */
	public static final String ID = "org.eclipse.m2m.atl"; //$NON-NLS-1$

	private static Logger logger;

	/** Plug-in's shared instance. */
	private static ATLPlugin plugin;

	/**
	 * Default constructor.
	 */
	public ATLPlugin() {
		plugin = this;
	}

	/**
	 * Returns the plugin's shared instance.
	 * 
	 * @return The plugin's shared instance.
	 */
	public static ATLPlugin getDefault() {
		return plugin;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Plugin#start(BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		logger = Logger.getLogger(ID);
		logger.setUseParentHandlers(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Plugin#stop(BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Log a message.
	 * 
	 * @param level
	 *            the message severity
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 * @param thrown
	 *            the throwable cause
	 */
	public static void log(Level level, String msg, Throwable thrown) {
		logger.log(level, msg, thrown);
	}

	/**
	 * Log an INFO message.
	 * 
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 */
	public static void info(String msg) {
		log(Level.INFO, msg, null);
	}

	/**
	 * Log a SEVERE message.
	 * 
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 */
	public static void severe(String msg) {
		log(Level.SEVERE, msg, null);
	}

	/**
	 * Log a WARNING message.
	 * 
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 */
	public static void warning(String msg) {
		log(Level.WARNING, msg, null);
	}

}
