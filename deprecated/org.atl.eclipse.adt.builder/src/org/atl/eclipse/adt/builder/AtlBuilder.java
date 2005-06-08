/*
 * Created on 9 juin 2004
 *
 */
package org.atl.eclipse.adt.builder;

import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author idrissi
 *
 */
public class AtlBuilder extends IncrementalProjectBuilder {
	
	/** The visitor used to visit an Atl project and builds all its file with "atl" extension */
	private IResourceVisitor buildVisitor = new AtlBuildVisitor();
	
	/** The Atl builder id */
	public static final String ATL_BUILDER_ID = "org.atl.eclipse.adt.builder.atlBuilder";
	
	/**
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int, java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {		
		//if (kind == IncrementalProjectBuilder.FULL_BUILD)
		IWorkspaceRunnable wr= new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {				
				fullBuild();
			}
		};
		run(wr, monitor);								
		return null;
	}
		
	protected void fullBuild() {
		try {
			getProject().accept(buildVisitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Execute the given workspace runnable
	 */
	protected void run(IWorkspaceRunnable wr, IProgressMonitor monitor) throws CoreException {
		ResourcesPlugin.getWorkspace().run(wr, monitor);
	}
}
