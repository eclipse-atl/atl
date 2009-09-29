/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.ui.console.FileLink;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.atl.common.AtlNbCharFile;
import org.eclipse.m2m.atl.core.ui.launch.AtlLaunchConfigurationDelegate;
import org.eclipse.ui.console.IPatternMatchListenerDelegate;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;

/**
 * The ATL console tracker, which adds Hyperlinks.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLConsoleTracker implements IPatternMatchListenerDelegate {

	private static final String ATL_EDITOR_ID = "org.eclipse.m2m.atl.adt.editor.AtlEditor"; //$NON-NLS-1$

	TextConsole console;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.console.IPatternMatchListenerDelegate#connect(org.eclipse.ui.console.TextConsole)
	 */
	public void connect(TextConsole atlConsole) {
		this.console = atlConsole;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.console.IPatternMatchListenerDelegate#disconnect()
	 */
	public void disconnect() {
		console = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.console.IPatternMatchListenerDelegate#matchFound(org.eclipse.ui.console.PatternMatchEvent)
	 */
	public void matchFound(PatternMatchEvent event) {
		try {
			int offset = event.getOffset() + 1;
			int length = event.getLength() - 2;
			IDocument document = console.getDocument();
			String info = document.get(offset, length);

			String moduleName = ""; //$NON-NLS-1$
			if (info.contains(".atl")) { //$NON-NLS-1$
				moduleName = info.split(".atl")[0]; //$NON-NLS-1$
				IFile file = AtlLaunchConfigurationDelegate.getFileFromModuleName(moduleName);
				if (file != null) {
					if (file.isAccessible()) {
						int lineNumber = -1;
						int fileOffset = -1;
						int fileLength = -1;
						if (info.contains(".atl[")) { //$NON-NLS-1$
							String location = info.split(".atl")[1]; //$NON-NLS-1$				
							if (location.matches("\\[[0-9]*:[0-9]*-[0-9]*:[0-9]*\\]")) { //$NON-NLS-1$
								location = location.substring(1, location.length() - 1);
								lineNumber = Integer.valueOf(location.split(":")[0]); //$NON-NLS-1$
								AtlNbCharFile help = new AtlNbCharFile(file.getContents());
								int[] index = help.getIndexChar(location);
								fileOffset = index[0];
								fileLength = index[1] - index[0];
							}
						}
						console.addHyperlink(new FileLink(file, ATL_EDITOR_ID, fileOffset, fileLength,
								lineNumber), offset, length);
					}
				}
			}
		} catch (Throwable e) {
			// do nothing, do not display link
		}
	}

}
