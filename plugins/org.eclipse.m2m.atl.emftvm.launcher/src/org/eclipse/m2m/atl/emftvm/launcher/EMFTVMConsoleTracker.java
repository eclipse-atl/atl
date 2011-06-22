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
package org.eclipse.m2m.atl.emftvm.launcher;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.debug.ui.console.FileLink;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.atl.common.AtlNbCharFile;
import org.eclipse.ui.console.IPatternMatchListenerDelegate;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;

/**
 * The console tracker for EMFTVM transformations.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public class EMFTVMConsoleTracker implements IPatternMatchListenerDelegate {

	protected TextConsole console;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.console.IPatternMatchListenerDelegate#connect(org.eclipse.ui.console.TextConsole)
	 */
	public void connect(TextConsole console) {
		this.console = console;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.console.IPatternMatchListenerDelegate#disconnect()
	 */
	public void disconnect() {
		console = null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.console.IPatternMatchListenerDelegate#matchFound(org.eclipse.ui.console.PatternMatchEvent)
	 */
	public void matchFound(PatternMatchEvent event) {
		try {
			int offset = event.getOffset() + 1;
			int length = event.getLength() - 2;
			final IDocument document = console.getDocument();
			final String info = document.get(offset, length);

			if (info.contains(":/")) { //$NON-NLS-1$
				final URI moduleURI = URI.createURI(info);
				final IFile file = getFileFromModuleURI(moduleURI);
				if (file != null) {
					if (file.isAccessible()) {
						int lineNumber = -1;
						int fileOffset = -1;
						int fileLength = -1;
						if (moduleURI.hasFragment()) {
							if (moduleURI.fragment().matches("\\[[0-9]*:[0-9]*-[0-9]*:[0-9]*\\]")) { //$NON-NLS-1$
								final String location = moduleURI.fragment().substring(1, moduleURI.fragment().length()-1);				
								lineNumber = Integer.valueOf(location.split(":")[0]); //$NON-NLS-1$
								final AtlNbCharFile help = new AtlNbCharFile(file.getContents());
								int[] index = help.getIndexChar(location);
								fileOffset = index[0];
								fileLength = index[1] - index[0];
							} else if  (moduleURI.fragment().matches("\\[[0-9]*:[0-9]*\\([0-9]*-[0-9]*\\)\\]")) { //$NON-NLS-1$
								final String location = moduleURI.fragment().substring(1, moduleURI.fragment().length()-1);				
								lineNumber = Integer.valueOf(location.split(":")[0]); //$NON-NLS-1$
								final String[] offsets = location.substring(
										location.indexOf('(')+1, location.lastIndexOf(')')).split("-"); //$NON-NLS-1$
								fileOffset = Integer.valueOf(offsets[0]);
								fileLength = Integer.valueOf(offsets[1]) + 1 - Integer.valueOf(offsets[0]);
							}
						}
						console.addHyperlink(new FileLink(file, null, fileOffset, fileLength,
								lineNumber), offset, length);
					}
				}
			}
		} catch (Throwable e) {
			// do nothing, do not display link
		}
	}

	/**
	 * @param moduleURI
	 * @return The {@link IFile} for <code>moduleURI</code>, or <code>null</code>.
	 */
	protected static IFile getFileFromModuleURI(final URI moduleURI) {
		if (moduleURI.isPlatformResource()) {
			String path = moduleURI.trimFragment().toPlatformString(true);
			IResource r = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
			if (r instanceof IFile) {
				return (IFile) r;
			}
		}
		return null;
	}
}
