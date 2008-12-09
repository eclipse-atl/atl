/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *    Obeo - messages externalization
 *******************************************************************************/
package org.eclipse.m2m.atl.adt;

import java.util.Map;
import java.util.logging.Level;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.atl.ATLLogger;

/**
 * The ATL project builder.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlBuilder extends IncrementalProjectBuilder {

	/** The Atl builder id. This attribute is related to the 
	 *	WARNING: changing this attribute 
	 */
	public static final String ATL_BUILDER_ID = "org.eclipse.m2m.atl.adt.builder.atlBuilder"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IncrementalProjectBuilder#build(int, java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("unchecked")
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		IWorkspaceRunnable wr = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				fullBuild(monitor);
			}
		};
		run(wr, monitor);
		return null;
	}

	/**
	 * Process a full build.
	 * 
	 * @param monitor the progress monitor
	 */
	protected void fullBuild(IProgressMonitor monitor) {
		try {
			IProject p = getProject();
			monitor.beginTask(Messages.getString(
					"AtlBuilder.COMPILETASK", new Object[] {p.getName()}), IProgressMonitor.UNKNOWN); //$NON-NLS-1$
			p.accept(new AtlBuildVisitor(monitor));
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.resources.IncrementalProjectBuilder#clean(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void clean(IProgressMonitor monitor) throws CoreException {
		super.clean(monitor);
		IWorkspaceRunnable wr = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				try {
					IProject p = getProject();
					monitor.beginTask(Messages.getString(
							"AtlBuilder.CLEANTASK", new Object[] {p.getName()}), IProgressMonitor.UNKNOWN); //$NON-NLS-1$
					p.accept(new AtlCleanVisitor(monitor));
				} catch (CoreException e) {
					ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}
			}
		};
		run(wr, monitor);
	}

	/**
	 * Execute the given workspace runnable.
	 * 
	 * @param wr
	 *            the given workspace runnable
	 * @param monitor
	 *            the progress monitor
	 * @throws CoreException
	 */
	protected void run(IWorkspaceRunnable wr, IProgressMonitor monitor) throws CoreException {
		ResourcesPlugin.getWorkspace().run(wr, monitor);
	}
}
