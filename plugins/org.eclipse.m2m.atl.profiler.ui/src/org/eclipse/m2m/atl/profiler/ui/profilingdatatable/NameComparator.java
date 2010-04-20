/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *    Obeo - tree sorting correction
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.ui.profilingdatatable;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

/**
 * A comparator for names.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class NameComparator extends ViewerComparator {

	private boolean asc;

	/**
	 * Default constructor, for ascendant sorting.
	 */
	public NameComparator() {
		super();
		this.asc = true;
	}

	/**
	 * Constructor for ascendant or descendant sorting.
	 * @param asc for ascendant or descendant sorting.
	 */
	public NameComparator(boolean asc) {
		super();
		this.asc = asc;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (asc)
			return super.compare(viewer, e1, e2);
		else
			return super.compare(viewer, e2, e1);
	}

}
