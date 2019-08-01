/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Tarik Idrissi (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.outline;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * This class should be extended.
 * 
 */
public abstract class AtlAction {
	protected ISelection theSelection;

	public AtlAction(ISelection its) {
		this.theSelection = its;
	}

	public abstract void run();

	/**
	 * Returns the element to rename.
	 * 
	 * @return the element to rename
	 */
	public Object getElement() {
		if (theSelection instanceof IStructuredSelection) {
			return ((IStructuredSelection)theSelection).getFirstElement();
		}
		return null;
	}
}
