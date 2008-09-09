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
package org.eclipse.m2m.atl.adt.ui.outline;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class HideRuleFilter extends ViewerFilter {
	/**
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object,
	 *      java.lang.Object)
	 */
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		/*
		 * return (parentElement instanceof Root || (AtlEMFConstants.clModule.isInstance(parentElement) &&
		 * !(AtlEMFConstants.clRule.isInstance(element))));
		 */
		return !(AtlEMFConstants.clRule.isInstance(element));

	}
}
