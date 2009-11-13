/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.viewsupport;

import org.eclipse.core.resources.IResource;

/**
 * Can be added to a ProblemMarkerManager to get notified about problem marker changes. Used to update error
 * ticks.
 */
public interface IProblemChangedListener {

	/**
	 * Called when problems changed.
	 * 
	 * @param changedResources
	 *            A set with elements of type <code>IResource</code> that
	 * @param isMarkerChange
	 */
	void problemsChanged(IResource[] changedResources, boolean isMarkerChange);

}
