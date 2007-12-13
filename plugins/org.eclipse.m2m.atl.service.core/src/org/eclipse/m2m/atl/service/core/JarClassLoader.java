/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.service.core;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * @author Freddy Allilaire
 */
public class JarClassLoader extends URLClassLoader {

	HashMap fMap = new HashMap();
	
	public JarClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
	}
	
	public Class loadClass2(String name, boolean resolve) throws ClassNotFoundException {

		Class c = (Class) fMap.get(name);
		
		if (c == null) {
			c = findClass(name);
		
			if (c != null)
				fMap.put(name, c);
			else {
				c = loadClass(name);
			}
		}
		
		if (c != null && resolve)
			resolveClass(c);
		
		return c;
	}
}
