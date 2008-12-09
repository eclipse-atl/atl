/*******************************************************************************
 * Copyright (c) 2007 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Dennis Wagelaar (Vrije Universiteit Brussel) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl;

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
		line.append(record.getLevel().getLocalizedName());
		line.append(": "); //$NON-NLS-1$
		line.append(record.getMessage());
		line.append('\n');
		if (record.getThrown() != null) {
			StringWriter writer = new StringWriter();
			record.getThrown().printStackTrace(new PrintWriter(writer, true));
			line.append(writer.toString());
		}
		return line.toString();
	}

}
