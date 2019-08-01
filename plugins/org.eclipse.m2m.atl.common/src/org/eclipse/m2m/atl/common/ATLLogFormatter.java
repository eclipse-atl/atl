/*******************************************************************************
 * Copyright (c) 2007 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 * 	   Dennis Wagelaar (Vrije Universiteit Brussel) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Log formatter that is less verbose than SimpleFormatter.
 * 
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class ATLLogFormatter extends Formatter {

	/** The log formatter. */
	public static final ATLLogFormatter INSTANCE = new ATLLogFormatter();

	/**
	 * Constructor.
	 */
	protected ATLLogFormatter() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
	 */
	public String format(LogRecord record) {
		StringBuffer line = new StringBuffer();
		if (record.getThrown() != null) {
			StringWriter writer = new StringWriter();
			record.getThrown().printStackTrace(new PrintWriter(writer, true));
			line.append(writer.toString());
		} else {
			line.append(record.getMessage() + '\n');			
		}
		return line.toString();
	}

}
