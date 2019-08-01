/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.common;

import java.net.URL;

import org.eclipse.m2m.atl.common.internal.BundleUtil;

/**
 * Provides common .ecore files:
 * <ul>
 * <li>ATL.ecore: ATL metamodel.</li>
 * <li>Problem.ecore: Problem metamodel.</li>
 * <li>RefiningTrace.ecore: RefiningTrace metamodel.</li>
 * </ul>
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public final class ATLResourceProvider {

	private static final String BUNDLE_UTIL_IMPL = "org.eclipse.m2m.atl.common.internal.BundleUtilImpl"; //$NON-NLS-1$

	private ATLResourceProvider() {
		super();
	}

	/**
	 * Returns the URL of the resource matching the given name.
	 * 
	 * @param resourceName
	 *            the resource name
	 * @return the URL of the resource matching the given name.
	 */
	public static URL getURL(String resourceName) {
		try {
			final BundleUtil bundleUtil = (BundleUtil)Class.forName(BUNDLE_UTIL_IMPL).newInstance();
			return bundleUtil.getResource(resourceName);
		} catch (InstantiationException e) {
			ATLLogger.fine(e.getMessage());
		} catch (IllegalAccessException e) {
			ATLLogger.fine(e.getMessage());
		} catch (ClassNotFoundException e) {
			ATLLogger.fine(e.getMessage());
		}
		ATLLogger.info("Could not access OSGi bundle; falling back to native java resource resolution");
		return ATLResourceProvider.class.getResource("/../model/" + resourceName); //$NON-NLS-1$
	}

}
