package org.eclipse.m2m.atl.adt.builder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.engine.AtlCompiler;
import org.eclipse.m2m.atl.engine.CompilerNotFoundException;
import org.eclipse.m2m.atl.engine.MarkerMaker;
import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

public class AtlCleanVisitor implements IResourceVisitor {
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private IProgressMonitor monitor;
	
	public AtlCleanVisitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
	
	/** 
	 * @param resource the resource for which to test whether it has an associated asm file
	 * @return <code>true</code> if the given resource has an associated asm file <code>false</code> otherwise
	 */
	private boolean hasAsmFile(IResource resource) {
		return getAsmFile(resource).exists();
	}		
	
	/** 
	 * @param resource the resource for which to test whether it has an associated asm file
	 * @return <code>true</code> if the given resource has an associated asm file <code>false</code> otherwise
	 */
	private IFile getAsmFile(IResource resource) {
		String atlFileName = resource.getName();
		String asmFileName = atlFileName.substring(0, atlFileName.lastIndexOf('.')) + ".asm";
		IFile asm = resource.getParent().getFile(new Path(asmFileName));
		return asm;
	}		

	/**
	 * @see org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core.resources.IResource)
	 */
	public boolean visit(IResource resource) throws CoreException {
		String extension = resource.getFileExtension();
		if (("atl".equals(extension) && 
			(resource instanceof IFile)) && 
			((IFile)resource).getLocation().toFile().length() > 0 &&
			hasAsmFile(resource) ) {
			
			monitor.subTask("Cleaning " + resource.getName());
			IFile asmFile = getAsmFile(resource);
			try {
				asmFile.delete(true, monitor);
			} catch(CoreException ce) {
				logger.log(Level.SEVERE, ce.getLocalizedMessage(), ce);
				return false;
			}
		}
		// return true to continue visiting children.
		return true;
	}

}
