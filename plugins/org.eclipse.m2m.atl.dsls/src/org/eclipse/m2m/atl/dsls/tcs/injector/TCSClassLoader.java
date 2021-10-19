/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: TCSClassLoader.java,v 1.1 2009/04/21 14:12:26 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector;

import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 */
public class TCSClassLoader extends URLClassLoader {
	private final ClassLoader parent;

	public TCSClassLoader(final URL[] urls, final ClassLoader parent) {
		super(urls, null);//ClassLoader.getSystemClassLoader());
		this.parent = parent;
	}

	@Override
	public Class<?> loadClass(final String name) throws ClassNotFoundException {
		try {
			return super.loadClass(name);
		} catch(final ClassNotFoundException e) {
			return parent.loadClass(name);
		}
	}
}