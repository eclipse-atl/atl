/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
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

	private static ATLConsole console;

	private ATLConsole(ImageDescriptor imageDescriptor) {
		super(CONSOLE_NAME, CONSOLE_TYPE, imageDescriptor, true);
	}

	/**
	 * Find or create the ATLConsole.
	 *
	 * @return the ATLConsole
	 */
	public static synchronized ATLConsole findConsole() {
		if (console == null) {
			final IConsoleManager consoleMgr = ConsolePlugin.getDefault().getConsoleManager();
			final String pluginDir = ATLCoreUIPlugin.getDefault().getBundle().getEntry("/").toString(); //$NON-NLS-1$
			ImageDescriptor imageDescriptor = null;
			try {
				imageDescriptor = ImageDescriptor.createFromURL(new URL(pluginDir + "icons/atl_logo.gif")); //$NON-NLS-1$
			} catch (final MalformedURLException mfe) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			console = new ATLConsole(imageDescriptor);
			/*
			 * IConsoleManager.addConsoles() can trigger initialization of other plug-ins, which causes a
			 * re-entrant call to this method for EMFTVM startup. Therefore, the console field is assigned
			 * before registering the console.
			 */
			consoleMgr.addConsoles(new IConsole[] {console});
		}
		return console;
	}
}
