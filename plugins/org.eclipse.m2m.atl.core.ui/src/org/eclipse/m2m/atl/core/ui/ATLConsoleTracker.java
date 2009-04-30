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

import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.ui.console.FileLink;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.ui.console.IPatternMatchListenerDelegate;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;

/**
 * The ATL console tracker, which adds Hyperlinks.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLConsoleTracker implements IPatternMatchListenerDelegate {

	private static Pattern pattern = Pattern.compile("[0-9]*:[0-9]*-[0-9]*:[0-9]*"); //$NON-NLS-1$

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
			String fileName = document.get(offset, length);
			String trace = document.get(offset, document.getLength() - offset);
			IPath path = Path.fromOSString(fileName);
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file.isAccessible()) {
				int lineNumber = -1;
				Matcher matcher = pattern.matcher(trace);
				if (matcher.find()) {
					String location = matcher.group();
					lineNumber = new Integer(location.split("-")[0].split(":")[0]).intValue(); //$NON-NLS-1$ //$NON-NLS-2$
				}
				console.addHyperlink(new FileLink(file, null, -1, -1, lineNumber), offset, length);
			}
		} catch (BadLocationException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

}
