/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.startup;

import java.util.logging.Level;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.atl.ATLLogger;

/**
 * Resource visitor.
 * 
 * @author <a href="mailto:tarik.idrissi@laposte.net">Tarik Idrissi</a>
 */
public class ResourceDeltaVisitor implements IResourceDeltaVisitor {

	/**
	 * <p>
	 * Finds the asm file associated to an atl file.
	 * </p>
	 * <p>
	 * A file is considered to be the asm file associated to an atl file if it has the same name but the
	 * extesnsion "asm" and is located in the same folder
	 * 
	 * @param res
	 *            the atl file for which to find the associated asm file
	 * @return <code>null</code> if the atl file does not have an associated asm, the asm file otherwize.
	 */
	private IResource findAsmFile(IResource res) {
		String atlFileName = res.getName();
		String asmFileName = atlFileName.substring(0, atlFileName.lastIndexOf('.')) + ".asm"; //$NON-NLS-1$
		IFile asm = res.getParent().getFile(new Path(asmFileName));
		if (asm.exists()) {
			return asm;
		} else {
			return null;
		}
	}

	/**
	 * Deletes the asm file associated to an atl file.
	 * 
	 * @param res
	 *            the atl file for which to delete the associated asm file
	 */
	private void delAsmFile(final IResource res) {
		Thread op = new Thread() {
			@Override
			public void run() {
				IResource asm = findAsmFile(res);
				if (asm != null) {
					try {
						asm.delete(true, null);
					} catch (CoreException e) {
						ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
			}
		};
		op.start();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
	 */
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource res = delta.getResource();
		switch (delta.getKind()) {
			case IResourceDelta.REMOVED: // when a file is removed or renamed.
				if ("atl".equals(res.getFileExtension())) { //$NON-NLS-1$				
					delAsmFile(res);
				}
				break;
			default:
				break;
		}
		return true;
	}
}
