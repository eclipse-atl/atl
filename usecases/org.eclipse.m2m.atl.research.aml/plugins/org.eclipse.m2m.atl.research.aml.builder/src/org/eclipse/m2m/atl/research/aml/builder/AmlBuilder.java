/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.builder;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.atl.research.aml.engine.AmlEnginePlugin;

/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AmlBuilder extends IncrementalProjectBuilder {

	protected static Logger logger = Logger.getLogger(AmlEnginePlugin.LOGGER);
	
	public static final String BUILDER_ID = "org.eclipse.m2m.atl.research.aml.builder.AmlBuilder";

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		IWorkspaceRunnable wr= new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {				
				fullBuild(monitor);
			}
		};
		run(wr, monitor);								
		return null;
	}

	
	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			IProject p = getProject();
			monitor.beginTask(org.eclipse.m2m.atl.engine.Messages
					.getString("Compiling Aml file", new Object[] {p.getName()}), IProgressMonitor.UNKNOWN);//$NON-NLS-1$
			p.accept(new AmlBuildVisitor(monitor));
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}		
	}	
	
	/**
	 * Execute the given workspace runnable
	 */
	protected void run(IWorkspaceRunnable wr, IProgressMonitor monitor) throws CoreException {
		ResourcesPlugin.getWorkspace().run(wr, monitor);
	}
}
