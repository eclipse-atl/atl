/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.core.vm;

import java.util.List;

/**
 * An abstract definition of ATL VM operations.
 * 
 * @author <a href="mailto:william.piers@obeo.fr">William Piers</a>
 */
public interface IOperation {

	/**
	 * Returns the operation name.
	 * 
	 * @return the operation name
	 */
	String getName();

	/**
	 * Returns the operation instructions.
	 * 
	 * @return the operation instructions
	 */
	List<?> getInstructions();

}
