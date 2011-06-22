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

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.eclipse.m2m.atl.common.ATLLogger;


/**
 * Ant build change listener for EMFTVM tasks.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class EMFTVMBuildListener implements BuildListener {

	private final Project project;
	private final Handler logHandler;

	/**
	 * Creates a new {@link EMFTVMBuildListener}.
	 * @param project
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
		for (Object bl : project.getBuildListeners()) {
			if (bl instanceof EMFTVMBuildListener) {
				if (((EMFTVMBuildListener) bl).getProject() == project) {
					return; // already attached
				}
			}
		}
		project.addBuildListener(new EMFTVMBuildListener(project));
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.tools.ant.BuildListener#buildFinished(org.apache.tools.ant.BuildEvent)
	 */
	public void buildFinished(BuildEvent event) {
		ATLLogger.getLogger().removeHandler(getLogHandler());
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.tools.ant.BuildListener#buildStarted(org.apache.tools.ant.BuildEvent)
	 */
	public void buildStarted(BuildEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.tools.ant.BuildListener#messageLogged(org.apache.tools.ant.BuildEvent)
	 */
	public void messageLogged(BuildEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.tools.ant.BuildListener#targetFinished(org.apache.tools.ant.BuildEvent)
	 */
	public void targetFinished(BuildEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.tools.ant.BuildListener#targetStarted(org.apache.tools.ant.BuildEvent)
	 */
	public void targetStarted(BuildEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.tools.ant.BuildListener#taskFinished(org.apache.tools.ant.BuildEvent)
	 */
	public void taskFinished(BuildEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.tools.ant.BuildListener#taskStarted(org.apache.tools.ant.BuildEvent)
	 */
	public void taskStarted(BuildEvent event) {
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @return the logHandler
	 */
	public Handler getLogHandler() {
		return logHandler;
	}

}
