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

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.m2m.atl.logging.ConsoleStreamHandler;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.osgi.framework.BundleContext;

/**
 * The activator class, controls the plug-in life cycle. Defines the common log utilities for all ATL plugins.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLPlugin extends Plugin {

	/** The plugin ID. */
	public static final String PLUGIN_ID = "org.eclipse.m2m.atl"; //$NON-NLS-1$

	private static Logger logger;

	private static MessageConsole console;

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
		logger = Logger.getLogger(PLUGIN_ID);
		logger.setUseParentHandlers(false);
		
		Handler handler = new ConsoleHandler();
		handler.setFormatter(ATLLogFormatter.INSTANCE);
		logger.addHandler(handler);	
		if (console == null) {
			initConsole();
		}
	}

	private void initConsole() {
		console = findConsole("ATL");
		Handler handler = new ConsoleStreamHandler(console.newMessageStream());		
		logger.addHandler(handler);
	}

	private MessageConsole findConsole(String name) {
		IConsoleManager consoleMgr = ConsolePlugin.getDefault().getConsoleManager();
		IConsole[] existing = consoleMgr.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				return (MessageConsole)existing[i];
			}
		}
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		consoleMgr.addConsoles(new IConsole[] {myConsole});
		return myConsole;
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
	 * Log a message, with associated Throwable information.
	 * 
	 * @param level
	 *            One of the message level identifiers, e.g. SEVERE
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 * @param thrown
	 *            Throwable associated with log message.
	 */
	public static void log(Level level, String msg, Throwable thrown) {
		logger.log(level, msg, thrown);
	}
	
	/**
	 * Log a message.
	 * 
	 * @param level
	 *            One of the message level identifiers, e.g. SEVERE
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 */
	public static void log(Level level, String msg) {
		logger.log(level, msg);
	}


	/**
	 * Log an INFO message.
	 * 
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 */
	public static void info(String msg) {
		logger.info(msg);
	}
	
    /**
     * Log a FINE message.
     * 
     * @param   msg	The string message (or a key in the message catalog)
     */
    public static void fine(String msg) {
    	logger.fine(msg);
    }
    
    /**
     * Log a SEVERE message.
     * 
     * @param   msg	The string message (or a key in the message catalog)
     */
    public static void severe(String msg) {
    	logger.severe(msg);
    }
    
    /**
     * Log a WARNING message.
     * 
     * @param   msg	The string message (or a key in the message catalog)
     */
    public static void warning(String msg) {
    	logger.warning(msg);
    }

}
