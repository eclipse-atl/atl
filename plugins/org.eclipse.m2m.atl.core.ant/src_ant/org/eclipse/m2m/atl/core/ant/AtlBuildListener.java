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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.service.CoreService;

/**
 * The build listener, used to handle log and to dispose models after processing.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlBuildListener implements BuildListener {

	private static final AtlBuildListener INSTANCE = new AtlBuildListener();

	private static Map<String, ModelFactory> modelFactories = new HashMap<String, ModelFactory>();

	private static Handler handler;

	/**
	 * Constructor.
	 */
	protected AtlBuildListener() {
		super();
	}

	/**
	 * Attach the log to a given project if necessary.
	 * 
	 * @param project
	 *            the current project
	 */
	public static void attachBuildListener(Project project) {
		if (!project.getBuildListeners().contains(INSTANCE)) {
			project.addBuildListener(INSTANCE);
			handler = new ProjectLogHandler(project);
			ATLLogger.getLogger().addHandler(handler);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.BuildListener#buildFinished(org.apache.tools.ant.BuildEvent)
	 */
	public void buildFinished(BuildEvent event) {
		// Collection<?> values = event.getProject().getReferences().values();
		modelFactories.clear();
		ATLLogger.getLogger().removeHandler(handler);
	}

	/**
	 * Manages model factories: singleton are stored (generally one) during the execution of a project, and
	 * finally garbage-collected.
	 * 
	 * @param factoryName
	 *            the factory name
	 * @return the factory instance
	 */
	public static ModelFactory getModelFactory(String factoryName) throws BuildException {
		ModelFactory res = modelFactories.get(factoryName);
		if (res == null) {
			try {
				res = CoreService.createModelFactory(factoryName);
			} catch (ATLCoreException e) {
				throw new BuildException(Messages.getString("AtlBuildListener.UNABLE_TO_LOAD_FACTORY"), e); //$NON-NLS-1$
			}
			modelFactories.put(factoryName, res);
		}
		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.BuildListener#buildStarted(org.apache.tools.ant.BuildEvent)
	 */
	public void buildStarted(BuildEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.BuildListener#messageLogged(org.apache.tools.ant.BuildEvent)
	 */
	public void messageLogged(BuildEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.BuildListener#targetFinished(org.apache.tools.ant.BuildEvent)
	 */
	public void targetFinished(BuildEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.BuildListener#targetStarted(org.apache.tools.ant.BuildEvent)
	 */
	public void targetStarted(BuildEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.BuildListener#taskFinished(org.apache.tools.ant.BuildEvent)
	 */
	public void taskFinished(BuildEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.BuildListener#taskStarted(org.apache.tools.ant.BuildEvent)
	 */
	public void taskStarted(BuildEvent event) {
	}

}
