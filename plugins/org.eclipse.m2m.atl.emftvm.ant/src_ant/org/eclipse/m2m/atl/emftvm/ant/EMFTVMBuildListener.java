/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.ant;

import java.util.logging.Handler;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * Ant build change listener for EMFTVM tasks.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFTVMBuildListener implements BuildListener {

	private final Project project;
	private final Handler logHandler;

	/**
	 * Creates a new {@link EMFTVMBuildListener}.
	 * @param project the Ant project
	 */
	public EMFTVMBuildListener(final Project project) {
		super();
		assert project != null;
		this.project = project;
		this.logHandler = new AntProjectHandler(project);
		ATLLogger.getLogger().addHandler(logHandler);
	}

	/**
	 * Attach the log to a given project if necessary.
	 * 
	 * @param project
	 *            the current project
	 */
	public static void attachBuildListener(final Project project) {
		assert project != null;
		for (Object bl : project.getBuildListeners()) {
			if (bl instanceof EMFTVMBuildListener) {
				if (((EMFTVMBuildListener)bl).getProject() == project) {
					return; // already attached
				}
			}
		}
		project.addBuildListener(new EMFTVMBuildListener(project));
	}

	/**
	 * Removes the log handler from the logger.
	 * @param event the build finished event
	 */
	public void buildFinished(BuildEvent event) {
		ATLLogger.getLogger().removeHandler(getLogHandler());
	}

	/**
	 * Does nothing.
	 * @param event the build started event
	 */
	public void buildStarted(BuildEvent event) {
	}

	/**
	 * Does nothing.
	 * @param event the message logged event
	 */
	public void messageLogged(BuildEvent event) {
	}

	/**
	 * Does nothing.
	 * @param event the target finished event
	 */
	public void targetFinished(BuildEvent event) {
	}

	/**
	 * Does nothing.
	 * @param event the target started event
	 */
	public void targetStarted(BuildEvent event) {
	}

	/**
	 * Does nothing.
	 * @param event the task finished event
	 */
	public void taskFinished(BuildEvent event) {
	}

	/**
	 * Does nothing.
	 * @param event the task started event
	 */
	public void taskStarted(BuildEvent event) {
	}

	/**
	 * Returns the Ant project.
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Returns the log handler.
	 * @return the logHandler
	 */
	public Handler getLogHandler() {
		return logHandler;
	}

}
