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

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.dsls.Activator;
import org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.ParserWrapper;
import org.osgi.framework.Bundle;

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

	private static ClassLoader antlrClassLoader = null;

	/**
	 * Return the ANTLR3 ParserWrapper loading ANTLR3 classes from the local library and other classes from classLoader.
	 */
	public static ParserWrapper getParserWrapper(ClassLoader classLoader) throws Exception {
		if (antlrClassLoader == null) {
			String locationString;
			if (EMFPlugin.IS_ECLIPSE_RUNNING) {
				Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
				locationString = bundle.getLocation();
				URI locationURI = URI.createURI(locationString);
				if (locationURI.hasOpaquePart()) {					// Trim the leading reference: or initial@reference:
					locationString = locationURI.opaquePart() + "bin/";
				}
				else {
					locationString = locationString + "bin/";
				}
			}
			else {
				String resourceName = ANTLR3ClassLoader.class.getName().replace(".", "/") + ".class";
				URL url = ANTLR3ClassLoader.class.getClassLoader().getResource(resourceName);
				locationString = url.toString();
			}
			int binIndex = locationString.indexOf("/bin/");
			URL antlrURL = new URL(locationString.substring(0, binIndex) + "/lib/" + ORG_ANTLR_RUNTIME_3_0_0_JAR);
			InputStream inputStream = antlrURL.openStream();				// Throws an IOException if local ANTLR library missing avoiding confusing resolution elsewhere
			inputStream.close();
			URL localURL = new URL(locationString.substring(0, binIndex+5));
			antlrClassLoader = new ANTLR3ClassLoader(new URL[] {antlrURL, localURL}, classLoader);
		}
		Class parserWrapperClass = antlrClassLoader.loadClass(ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR_WRAPPERS_ANTLR3_PARSERWRAPPER);
		return (ParserWrapper)parserWrapperClass.newInstance();
	}

	private ClassLoader parent;

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
				Class loadClass = super.loadClass(name);
				// System.out.println("Hit: " + name);
				return loadClass;
			}
			if (name.startsWith(ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR_WRAPPERS_ANTLR3)) {
				Class loadClass = super.loadClass(name);
				// System.out.println("Hit: " + name);
				return loadClass;
			}
			if (name.startsWith(ORG_ECLIPSE_M2M_ATL_DSLS_TCS_INJECTOR) && name.contains("ANTLR3")) {
				Class loadClass = super.loadClass(name);
				// System.out.println("Hit: " + name);
				return loadClass;
			}
		} catch (ClassNotFoundException e) {
			// System.out.println("Miss: " + name);
			return parent.loadClass(name);
		}
		// System.out.println("Bypass: " + name);
		return parent.loadClass(name);
	}
}
