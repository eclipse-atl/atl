/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.service.core;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * Loads a class form a jar.
 *
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class JarClassLoader extends URLClassLoader {

	HashMap fMap = new HashMap();

	/**
	 * Creates a new JarClassLoader.
	 * 
	 * @param urls
	 *            jar urls
	 * @param parent
	 *            parent class loader
	 */
	public JarClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
	}

	/**
	 * Loads a class.
	 * 
	 * @param name
	 *            the class name
	 * @param resolve
	 *            resolve the name if true
	 * @return the class
	 * @throws ClassNotFoundException
	 */
	public Class loadClass2(String name, boolean resolve) throws ClassNotFoundException {

		Class c = (Class)fMap.get(name);

		if (c == null) {
			c = findClass(name);

			if (c != null) {
				fMap.put(name, c);
			} else {
				c = loadClass(name);
			}
		}

		if (c != null && resolve) {
			resolveClass(c);
		}

		return c;
	}
}
