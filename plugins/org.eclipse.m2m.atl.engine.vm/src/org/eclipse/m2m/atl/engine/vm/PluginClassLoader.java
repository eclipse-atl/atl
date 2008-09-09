/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Frederic Jouault (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.vm;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A basic plugin facillity used in command-line. Eclipse plugins are used within Eclipse.
 * 
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class PluginClassLoader extends URLClassLoader {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private static URL[] toURLs(List locations) {
		URL[] ret = new URL[locations.size()];
		int k = 0;

		for (Iterator i = locations.iterator(); i.hasNext();) {
			ret[k++] = toURL((String)i.next());
		}

		return ret;
	}

	private static URL toURL(String location) {
		URL ret = null;

		try {
			ret = new URL("file:" + location);
		} catch (MalformedURLException mue) {
			logger.log(Level.SEVERE, mue.getLocalizedMessage(), mue);
			// mue.printStackTrace(System.out);
		}

		return ret;
	}

	public PluginClassLoader(List locations) {
		super(toURLs(locations));
	}

	public void addLocation(String location) {
		addURL(toURL(location));
	}
}
