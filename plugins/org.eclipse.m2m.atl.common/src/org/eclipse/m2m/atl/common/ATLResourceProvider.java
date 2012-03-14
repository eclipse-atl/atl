/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.common;

import java.net.URL;

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
		return ATLResourceProvider.class.getResource("resources/" + resourceName); //$NON-NLS-1$
	}

}
