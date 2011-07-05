/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.util;

import org.eclipse.m2m.atl.emftvm.Module;

/**
 * Resolves modules by name.
 * @author <a href="mailto:dennis.wagelaar@vub.ac.be">Dennis Wagelaar</a>
 */
public interface ModuleResolver {

	/**
	 * Resolves the module with the given <pre>name</pre>.
	 * @param name the module name
	 * @return the module with the given name
	 * @throws ModuleNotFoundException
	 */
	Module resolveModule(String name) throws ModuleNotFoundException;

}
