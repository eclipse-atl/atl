/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.debug;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Handler;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.ConsoleStreamHandler;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlDebugPlugin extends Plugin {

	/** The shared instance. */
	private static AtlDebugPlugin plugin;

	private static MessageConsole console;

	IDebugModelPresentation fUtilPresentation;

	/**
	 * The constructor.
	 */
	public AtlDebugPlugin() {
		super();
		plugin = this;
	}
	
	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance.
	 */
	public static AtlDebugPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the unique identifier of the plugin.
	 * 
	 * @return the unique identifier of the plugin
	 */
	public static String getUniqueIdentifier() {
		return AtlDebugPlugin.getDefault().getBundle().getSymbolicName();
	}

	/**
	 * Returns a shared utility Atl debug model presentation. Clients should not dispose the presentation.
	 * 
	 * @return an Atl debug model presentation
	 */
	public IDebugModelPresentation getModelPresentation() {
		if (fUtilPresentation == null) {
			fUtilPresentation = DebugUITools.newDebugModelPresentation(getUniqueIdentifier());
		}
		return fUtilPresentation;
	}
		
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		//Logger.getLogger(ATLLogger.ID).addHandler(new ErrorLogHandler());	
		console = findConsole("ATL");
		Handler handler = new ConsoleStreamHandler(console.newMessageStream());	
        ATLLogger.getLogger().addHandler(handler);
	}

	private MessageConsole findConsole(String name) {
		IConsoleManager consoleMgr = ConsolePlugin.getDefault().getConsoleManager();
		IConsole[] existing = consoleMgr.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				return (MessageConsole)existing[i];
			}
		}
		// no console found, so create a new one
		String pluginDir = getBundle().getEntry("/").toString(); //$NON-NLS-1$
		ImageDescriptor imageDescriptor = null;
		try {
			imageDescriptor = ImageDescriptor.createFromURL(new URL(pluginDir + "icons/atl_logo.gif"));
		} catch (MalformedURLException mfe) {
			imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
		}
		MessageConsole myConsole = new MessageConsole(name, imageDescriptor);
		consoleMgr.addConsoles(new IConsole[] {myConsole});
		return myConsole;
	}

}
