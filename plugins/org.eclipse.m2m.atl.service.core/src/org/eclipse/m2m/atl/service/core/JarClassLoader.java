/*
 * Created on 7 juil. 2005
 */
package org.eclipse.m2m.atl.service.core;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * @author allilaire
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
