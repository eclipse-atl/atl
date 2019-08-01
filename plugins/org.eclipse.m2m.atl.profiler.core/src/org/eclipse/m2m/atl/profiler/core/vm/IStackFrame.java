/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.core.vm;

import java.util.Map;

/**
 * An abstract definition of ATL VM stack frames.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public interface IStackFrame {

	/**
	 * Returns the frame operation.
	 * 
	 * @return the frame operation
	 */
	IOperation getIOperation();

	/**
	 * Returns the local variables map.
	 * 
	 * @return the local variables map
	 */
	Map<String, Object> getLocalVariables();

	/**
	 * Returns the current frame location.
	 * 
	 * @return the current frame location
	 */
	int getLocation();

}
