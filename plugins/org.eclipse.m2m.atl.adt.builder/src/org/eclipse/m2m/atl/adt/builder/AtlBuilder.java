/*
 * Created on 9 juin 2004
 *
 */
package org.eclipse.m2m.atl.adt.builder;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

/**
 * @author idrissi
 *
 */
public class AtlBuilder extends IncrementalProjectBuilder {
	
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	/** The visitor used to visit an Atl project and builds all its file with "atl" extension */
//	private IResourceVisitor buildVisitor = new AtlBuildVisitor();
	
	/** The Atl builder id */
	public static final String ATL_BUILDER_ID = "org.atl.eclipse.adt.builder.atlBuilder";
	
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {		
		//if (kind == IncrementalProjectBuilder.FULL_BUILD)
		IWorkspaceRunnable wr= new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {				
				fullBuild(monitor);
			}
		};
		run(wr, monitor);								
		return null;
	}
		
	protected void fullBuild(IProgressMonitor monitor) {
		try {
			IProject p = getProject();
			monitor.beginTask("Compiling ATL files of project " + p.getName(), IProgressMonitor.UNKNOWN);
			p.accept(new AtlBuildVisitor(monitor));
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
//			e.printStackTrace();
		}		
	}
	
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		super.clean(monitor);
		IWorkspaceRunnable wr= new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {				
				try {
					IProject p = getProject();
					monitor.beginTask("Cleaning ATL files of project " + p.getName(), IProgressMonitor.UNKNOWN);
					p.accept(new AtlCleanVisitor(monitor));
				} catch (CoreException e) {
					logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
				}		
			}
		};
		run(wr, monitor);								
	}
	
	/**
	 * Execute the given workspace runnable
	 */
	protected void run(IWorkspaceRunnable wr, IProgressMonitor monitor) throws CoreException {
		ResourcesPlugin.getWorkspace().run(wr, monitor);
	}
}
