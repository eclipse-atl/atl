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

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Handler;

import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.m2m.atl.ATLLogger;
import org.eclipse.m2m.atl.adt.launching.logging.ConsoleStreamHandler;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The main plugin class to be used in the desktop.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class AtlDebugPlugin extends AbstractUIPlugin {

	/** The shared instance. */
	private static AtlDebugPlugin plugin;
	
	private static MessageConsole console;

	IDebugModelPresentation fUtilPresentation;

	/** Resource bundle. */
	private ResourceBundle resourceBundle;

	/**
	 * The constructor.
	 */
	public AtlDebugPlugin() {
		super();
		plugin = this;
		
		//Logger.getLogger(ATLLogger.ID).addHandler(new ErrorLogHandler());
		
		console = findConsole("ATL");
		Handler handler = new ConsoleStreamHandler(console.newMessageStream());	
        ATLLogger.getLogger().addHandler(handler);	
				
		try {
			resourceBundle = ResourceBundle
					.getBundle("org.eclipse.m2m.atl.adt.debug.AtlDebugPluginResources"); //$NON-NLS-1$
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
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
		MessageConsole myConsole = new MessageConsole(name, null);
		consoleMgr.addConsoles(new IConsole[] {myConsole});
		return myConsole;
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
	 * Returns the string from the plugin's resource bundle, or 'key' if not found.
	 * 
	 * @param key
	 *            the default value
	 * @return the string from the plugin's resource bundle, or 'key' if not found
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = AtlDebugPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle.
	 * 
	 * @return the plugin's resource bundle
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
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
}
