/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.apache.tools.ant.Project;

/**
 * Log handler for EMFTVM messages during Ant build.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class AntProjectHandler extends Handler {

	private final Project project;

	/**
	 * Creates a new {@link AntProjectHandler}.
	 * @param project
	 */
	public AntProjectHandler(final Project project) {
		super();
		assert project != null;
		this.project = project;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.logging.Handler#close()
	 */
	@Override
	public void close() throws SecurityException {
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.logging.Handler#flush()
	 */
	@Override
	public void flush() {
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.logging.Handler#publish(java.util.logging.LogRecord)
	 */
	@Override
	public void publish(final LogRecord record) {
		final Level level = record.getLevel();
		if (level.equals(Level.SEVERE)) {
			getProject().log(record.getMessage(), record.getThrown(), Project.MSG_ERR);
		} else if (level.equals(Level.WARNING)) {
			getProject().log(record.getMessage(), record.getThrown(), Project.MSG_WARN);
		} else if (level.equals(Level.INFO)) {
			getProject().log(record.getMessage(), record.getThrown(), Project.MSG_INFO);
		} else {
			getProject().log(record.getMessage(), record.getThrown(), Project.MSG_VERBOSE);
		}
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

}
