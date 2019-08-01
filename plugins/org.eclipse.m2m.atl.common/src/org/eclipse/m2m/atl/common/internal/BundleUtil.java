/*******************************************************************************
 * Copyright (c) 2017 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.common.internal;

import java.net.URL;

/**
 * OSGi Bundle utility interface.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public interface BundleUtil {

	/**
	 * Returns the resource {@link URL} for the given name.
	 * 
	 * @param name
	 *            the resource name
	 * @return the resource {@link URL}, or <code>null</code>
	 */
	URL getResource(String name);

}
