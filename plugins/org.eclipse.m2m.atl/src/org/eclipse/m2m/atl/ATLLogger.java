/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Dennis Wagelaar (Vrije Universiteit Brussel)
 *******************************************************************************/
package org.eclipse.m2m.atl;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The common ATL logger.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ATLLogger {

	/** The logger ID. */
	public static final String LOGGER_ID = "org.eclipse.m2m.atl"; //$NON-NLS-1$

	//TODO change level to Level.INFO for production use
	/**	The lowest logging level to log. */
	public static final Level LOGLEVEL = Level.INFO;

	protected static Logger logger;
	
	/**
	 * Constructor.
	 */
	protected ATLLogger() {
		super();
	}

	/**
	 * Returns the ATL logger.
	 * 
	 * @return The ATL logger
	 */
	public static Logger getLogger() {
		if (logger == null) {
			logger = Logger.getLogger(LOGGER_ID);
			logger.setLevel(LOGLEVEL);
			logger.setUseParentHandlers(false);			
			Handler handler = new ConsoleHandler();
			handler.setFormatter(ATLLogFormatter.INSTANCE);
			handler.setLevel(LOGLEVEL);
			logger.addHandler(handler);
		}
		return logger;
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
		getLogger().log(level, msg, thrown);
	}

	/**
	 * Log a FINE message.
	 * 
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 */
	public static void fine(String msg) {
		log(Level.FINE, msg, null);
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
	 * Log a WARNING message.
	 * 
	 * @param msg
	 *            The string message (or a key in the message catalog)
	 */
	public static void warning(String msg) {
		log(Level.WARNING, msg, null);
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
	

}
