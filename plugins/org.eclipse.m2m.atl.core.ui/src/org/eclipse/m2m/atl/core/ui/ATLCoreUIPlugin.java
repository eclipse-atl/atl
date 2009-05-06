/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Level;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.common.ConsoleStreamHandler;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The core ui plugin provides a way to launch transformations using the core api.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public class ATLCoreUIPlugin extends AbstractUIPlugin {
	/** The shared instance. */
	private static ATLCoreUIPlugin plugin;

	private static ATLConsole console;

	private static Handler[] handlers = new Handler[3];

	/**
	 * Gets the image at the given plug-in relative path.
	 */
	private static Map<String, Image> path2image = new HashMap<String, Image>();

	/**
	 * Creates a new {@link ATLCoreUIPlugin}.
	 */
	public ATLCoreUIPlugin() {
		super();
		plugin = this;
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance.
	 */
	public static ATLCoreUIPlugin getDefault() {
		return plugin;
	}

	/**
	 * Looks for an image in the icons folder.
	 * 
	 * @param path
	 *            the image path
	 * @return the searched Image
	 */
	public static Image getImage(String path) {
		Image result = path2image.get(path);
		if (result == null && !path2image.containsKey(path)) {
			ImageDescriptor descriptor = getImageDescriptor(path);
			if (descriptor != null) {
				result = descriptor.createImage();
				path2image.put(path, result);
			}
		}
		if (result != null) {
			if (result.isDisposed()) {
				result = null;
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		startConsole();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		stopConsole();
	}

	/**
	 * Starts the ATL Console.
	 */
	public static void startConsole() {
		console = ATLConsole.findConsole();
		IOConsoleOutputStream infoStream = console.newOutputStream();
		IOConsoleOutputStream warningStream = console.newOutputStream();
		IOConsoleOutputStream errorStream = console.newOutputStream();

		infoStream.setColor(new Color(Display.getCurrent(), new RGB(0, 0, 255)));
		warningStream.setColor(new Color(Display.getCurrent(), new RGB(250, 100, 0)));
		errorStream.setColor(new Color(Display.getCurrent(), new RGB(255, 0, 0)));

		handlers[0] = new ConsoleStreamHandler(infoStream);
		handlers[0].setFilter(new Filter() {
			public boolean isLoggable(java.util.logging.LogRecord record) {
				return record.getLevel().equals(Level.INFO);
			}
		});
		handlers[1] = new ConsoleStreamHandler(warningStream);
		handlers[1].setFilter(new Filter() {
			public boolean isLoggable(java.util.logging.LogRecord record) {
				return record.getLevel().equals(Level.WARNING);
			}
		});
		handlers[2] = new ConsoleStreamHandler(errorStream);
		handlers[2].setFilter(new Filter() {
			public boolean isLoggable(java.util.logging.LogRecord record) {
				return record.getLevel().equals(Level.SEVERE);
			}
		});
		for (int i = 0; i < handlers.length; i++) {
			ATLLogger.getLogger().addHandler(handlers[i]);
		}
	}

	/**
	 * Stops the ATL Console.
	 */
	public static void stopConsole() {
		for (int i = 0; i < handlers.length; i++) {
			ATLLogger.getLogger().removeHandler(handlers[i]);
		}
	}

	/**
	 * Clears the ATL Console.
	 */
	public static void clearConsole() {
		if (console != null) {
			console.clearConsole();
		}
	}

	/**
	 * Returns the image descriptor with the given relative path.
	 * 
	 * @param name
	 *            the image name
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String name) {
		String pluginDir = plugin.getBundle().getEntry("/").toString(); //$NON-NLS-1$
		String iconPath = "icons/"; //$NON-NLS-1$
		try {
			return ImageDescriptor.createFromURL(new URL(pluginDir + iconPath + name));
		} catch (MalformedURLException mfe) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
	
	public Shell getShell() {
		return getWorkbench().getActiveWorkbenchWindow().getShell();
	}
}
