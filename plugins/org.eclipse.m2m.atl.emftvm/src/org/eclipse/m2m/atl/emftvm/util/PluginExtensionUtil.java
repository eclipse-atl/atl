/*******************************************************************************
 * Copyright (c) 2021 Dennis Wagelaar.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.emftvm.ModelFactory;

/**
 * Eclipse plug-in extension utility for {@link ModelFactory}.
 *
 * @author <a href="mailto:dwagelaar@gmail.com">Dennis Wagelaar</a>
 */
public interface PluginExtensionUtil {

	/**
	 * Creates a {@link TypeMap} of {@link Resource} classes/interfaces to
	 * {@link ModelFactory} instances that can be used for those {@link Resource}s.
	 *
	 * @return a {@link TypeMap} of {@link Resource} classes/interfaces to
	 *         {@link ModelFactory} instances
	 */
	TypeMap<Class<?>, ModelFactory> createModelFactoryRegistry();

}
