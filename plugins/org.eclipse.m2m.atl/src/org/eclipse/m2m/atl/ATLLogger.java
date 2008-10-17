/*******************************************************************************
 * Copyright (c) 2008 Obeo.
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

/**
 * The common ATL logger.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLLogger {

	/** The logger ID. */
	public static final String LOGGER_ID = "org.eclipse.m2m.atl"; //$NON-NLS-1$

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
			logger.setUseParentHandlers(false);			
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
