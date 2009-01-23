/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - Ant tooling
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ant;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 * Log handler for ATL messages during build.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ProjectLogHandler extends Handler {

	private Project project;

	/**
	 * Cosntructor.
	 * 
	 * @param project
	 *            the current project
	 */
	public ProjectLogHandler(Project project) {
		super();
		this.project = project;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.logging.Handler#close()
	 */
	@Override
	public void close() throws SecurityException {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.logging.Handler#flush()
	 */
	@Override
	public void flush() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.logging.Handler#publish(java.util.logging.LogRecord)
	 */
	@Override
	public void publish(LogRecord record) {
		if (record.getLevel().equals(Level.SEVERE)) {
			project.log(record.getMessage(), record.getThrown(), Project.MSG_ERR);
			throw new BuildException(record.getMessage(), record.getThrown());
		} else if (record.getLevel().equals(Level.WARNING)) {
			project.log(record.getMessage(), record.getThrown(), Project.MSG_WARN);
		} else if (record.getLevel().equals(Level.INFO)) {
			project.log(record.getMessage(), record.getThrown(), Project.MSG_INFO);
		} else {
			project.log(record.getMessage(), record.getThrown(), Project.MSG_VERBOSE);
		}
	}

}
