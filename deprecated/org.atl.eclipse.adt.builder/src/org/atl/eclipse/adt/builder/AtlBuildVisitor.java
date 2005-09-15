/*
 * Created on 9 juin 2004
 */
package org.atl.eclipse.adt.builder;

import java.io.IOException;
import java.io.InputStream;

import org.atl.eclipse.engine.AtlCompiler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;

/**
 * @author idrissi
 */
public class AtlBuildVisitor implements IResourceVisitor {
	
	/** Contains routines to manage problem markers when compiling */
	private MarkerMaker markerMaker = new MarkerMaker();
	
	/** Returns <code>true</code> if the file has chaned since its last build <code>false</code> otherwise*/
	private boolean hasChanged(IResource resource) {
		return (resource.getModificationStamp() > getAsmFile(resource).getModificationStamp());
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
		if ( ("atl".equals(extension) && (resource instanceof IFile))
			 && (!hasAsmFile(resource) || hasChanged(resource)) ) {
			String inName = resource.getName();
			String outName = inName.substring(0, inName.lastIndexOf('.')) + ".asm";
			IFile out = resource.getParent().getFile(new Path(outName));
			InputStream is = ((IFile)resource).getContents();
			EObject[] pbms = AtlCompiler.getDefault().compile(is, out);
			try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
			markerMaker.resetPbmMarkers(resource, pbms);
			return false;
		}
		// return true to continue visiting children.
		return true;
	}
	
}
