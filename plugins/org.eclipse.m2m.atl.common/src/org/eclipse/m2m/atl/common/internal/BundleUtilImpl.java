/*******************************************************************************
 * Copyright (c) 2017 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.common.internal;

import java.net.URL;

import org.eclipse.core.runtime.Platform;

/**
 * OSGi BUndle utility implementation.
 * 
 * @author <a href="dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public class BundleUtilImpl implements BundleUtil {

	private static final String PLUGIN_ID = "org.eclipse.m2m.atl.common"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	public URL getResource(String name) {
		if (Platform.isRunning()) {
			return Platform.getBundle(PLUGIN_ID).getResource("model/" + name); //$NON-NLS-1$
		}
		return null;
	}

}
