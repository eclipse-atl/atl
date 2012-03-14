/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.core.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;

/**
 * The ATL console plugin.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public final class ATLConsole extends IOConsole {

	private static final String CONSOLE_NAME = "ATL"; //$NON-NLS-1$

	private static final String CONSOLE_TYPE = "atlConsole"; //$NON-NLS-1$

	private ATLConsole(ImageDescriptor imageDescriptor) {
		super(CONSOLE_NAME, CONSOLE_TYPE, imageDescriptor, true);
	}

	/**
	 * Find or create the ATLConsole.
	 * 
	 * @return the ATLConsole
	 */
	public static ATLConsole findConsole() {
		IConsoleManager consoleMgr = ConsolePlugin.getDefault().getConsoleManager();
		IConsole[] existing = consoleMgr.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (CONSOLE_NAME.equals(existing[i].getName())) {
				return (ATLConsole)existing[i];
			}
		}
		// no console found, so create a new one
		String pluginDir = ATLCoreUIPlugin.getDefault().getBundle().getEntry("/").toString(); //$NON-NLS-1$
		ImageDescriptor imageDescriptor = null;
		try {
			imageDescriptor = ImageDescriptor.createFromURL(new URL(pluginDir + "icons/atl_logo.gif")); //$NON-NLS-1$
		} catch (MalformedURLException mfe) {
			imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
		}
		ATLConsole myConsole = new ATLConsole(imageDescriptor);
		consoleMgr.addConsoles(new IConsole[] {myConsole});
		return myConsole;
	}
}
