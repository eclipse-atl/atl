/*
 * Created on 23 juin 2004
 * @author idrissi
 */
package org.atl.eclipse.adt.startup;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

/**
 * @author idrissi
 */
public class ResourceDeltaVisitor implements IResourceDeltaVisitor {
	
	/**
	 * <p>Finds the asm file associated to an atl file</p>
	 * <p> A file is considered to be the asm file associated to an atl file if it has the same name but the extesnsion "asm"
	 * and is located in the same folder
	 * @param res the atl file for which to find the associated asm file
	 * @return <code>null</code> if the atl file does not have an associated asm, the asm file otherwize.
	 */
	private IResource findAsmFile(IResource res) {
		String atlFileName = res.getName();
		String asmFileName = atlFileName.substring(0, atlFileName.lastIndexOf('.')) + ".asm";
		IFile asm = res.getParent().getFile(new Path(asmFileName));
		if (asm.exists()) {
			return asm;
		} else {
			return null;
		}
	}
	
	/**
	 * Deletes the asm file associated to an atl file
	 * @param res the atl file for which to delete the associated asm file
	 */
	private void delAsmFile(final IResource res) {
		Thread op = new Thread() {
			public void run() {
				IResource asm = findAsmFile(res);
				if (asm != null) {
					try {
						asm.delete(true, null);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		};		
		op.start();
	}
	
	/**
	 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
	 */
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource res = delta.getResource();
		switch(delta.getKind()) {
			case IResourceDelta.REMOVED : // when a file is removed or renamed.	
				if ("atl".equals(res.getFileExtension())) {					
					delAsmFile(res);
				}
				break;
		}
		return true;
	}
}
