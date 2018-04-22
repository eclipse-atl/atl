/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.dsls.tcs.injector;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.ParserWrapper;

/**
 * The ANTLR3ClassLoader ensures that all ANTLR classes are loaded from the internal ANTLR 3.0.0 library without
 * regard to any other versions of ANTLR that may be one the classpath.
 */
public class ANTLR3ClassLoader extends URLClassLoader
{
	private static final String ORG_ANTLR_RUNTIME = "org.antlr.runtime";
	private static final String ORG_ANTLR_RUNTIME_3_0_0_JAR = "org.antlr.runtime_3.0.0.v200803061811.jar";
	private static final String ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR = ANTLR3ClassLoader.class.getPackage().getName();
	private static final String ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR_WRAPPERS_ANTLR3 = ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR + ".wrappers.antlr3";
	private static final String ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR_WRAPPERS_ANTLR3_PARSERWRAPPER = ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR_WRAPPERS_ANTLR3 + ".ParserWrapper";

	private static ANTLR3ClassLoader antlrClassLoader = null;

	/**
	 * Return the ANTLR3 ParserWrapper loading ANTLR3 classes from the local library and other classes from
	 * classLoader.
	 * 
	 * @param classLoader
	 *            the parent {@link ClassLoader}
	 * @return the ANTLR3 {@link ParserWrapper}
	 */
	public static ParserWrapper getParserWrapper(ClassLoader classLoader) throws Exception {
		final Class parserWrapperClass = getAntlrClassLoader(classLoader)
				.loadClass(ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR_WRAPPERS_ANTLR3_PARSERWRAPPER);
		return (ParserWrapper)parserWrapperClass.newInstance();
	}

	private static synchronized ANTLR3ClassLoader getAntlrClassLoader(ClassLoader classLoader)
			throws MalformedURLException, IOException {
		if (antlrClassLoader == null) {
			final URL resourceUrl = ANTLR3ClassLoader.class.getClassLoader().getResource("/");
			final String resourcePath = resourceUrl.toString();
			final int binIndex = resourcePath.lastIndexOf("/bin");
			final String antlrPath = (binIndex < 0 ? resourcePath : resourcePath.substring(0, binIndex + 1))
					+ "lib/" + ORG_ANTLR_RUNTIME_3_0_0_JAR;
			final URL antlrURL = new URL(antlrPath);
			final InputStream inputStream = antlrURL.openStream();				// Throws an IOException if local ANTLR library missing avoiding confusing resolution elsewhere
			inputStream.close();
			final URL localURL = new URL(resourcePath);
			antlrClassLoader = new ANTLR3ClassLoader(new URL[] {antlrURL, localURL}, classLoader);
		}
		return antlrClassLoader;
	}

	private final ClassLoader parent;

	private ANTLR3ClassLoader(URL[] urls, ClassLoader parent) throws MalformedURLException {
		super(urls, null);
		this.parent = parent;
	}

	/**
	 * ANTLR and all classes that reference ANTLR must use this ClassLoader to avoid 'same' class loaded twice issues.
	 */
	public Class loadClass(String name) throws ClassNotFoundException {
		try {
			if (name.startsWith(ORG_ANTLR_RUNTIME)) {
				final Class loadClass = super.loadClass(name);
				return loadClass;
			}
			if (name.startsWith(ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR_WRAPPERS_ANTLR3)) {
				final Class loadClass = super.loadClass(name);
				return loadClass;
			}
			if (name.startsWith(ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR) && name.contains("ANTLR3")) {
				final Class loadClass = super.loadClass(name);
				return loadClass;
			}
		} catch (final ClassNotFoundException e) {
			return parent.loadClass(name);
		}
		return parent.loadClass(name);
	}
}
