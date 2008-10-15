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
package org.eclipse.m2m.atl.adt.launching.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.eclipse.core.runtime.Status;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.adt.debug.AtlDebugPlugin;

/**
 * The error log handler, which displays ATL messages on the standard error log.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ErrorLogHandler extends Handler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.logging.Handler#close()
	 */
	public void close() throws SecurityException {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.logging.Handler#flush()
	 */
	public void flush() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.logging.Handler#publish(java.util.logging.LogRecord)
	 */
	public void publish(LogRecord record) {
		int severity = getSeverityFromLevel(record.getLevel());
		if (severity != Status.CANCEL) {
			Status status = new Status(severity, ATLLogger.ID, record.getMessage(), record.getThrown());
			AtlDebugPlugin.getDefault().getLog().log(status);
		}
	}

	private int getSeverityFromLevel(Level level) {
		if (level.equals(Level.SEVERE)) {
			return Status.ERROR;
		} else if (level.equals(Level.WARNING)) {
			return Status.WARNING;
		} else {
			return Status.CANCEL;
		}
	}

}
