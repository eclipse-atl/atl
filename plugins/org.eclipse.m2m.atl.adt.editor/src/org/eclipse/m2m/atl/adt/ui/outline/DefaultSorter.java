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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.m2m.atl.common.AtlNbCharFile;

public class DefaultSorter extends ViewerSorter {

	/**
	 * Used to compute index of start character and end character from a location String the location String
	 * is structured as follows : <line_start>:<column_start>-<lined_End>:<column_end>
	 */
	private AtlNbCharFile help;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ViewerComparator#category(java.lang.Object)
	 */
	@Override
	public int category(Object element) {
		if (element instanceof Root) {
			return super.category(element);
		}

		EObject eo = (EObject)element;
		String location = (String)eo.eGet(AtlEMFConstants.sfLocation);
		if (location == null) {
			return super.category(element);
		}

		int[] pos = help.getIndexChar(location);
		return pos[0];
	}

	public void setHelp(AtlNbCharFile help) {
		this.help = help;
	}
}
