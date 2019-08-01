/*******************************************************************************
 * Copyright (c) 2008,2009 Communication & Systems.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Arnaud Giuliani - initial API and implementation
 *    Obeo - tree sorting correction
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.ui.profilingdatatable;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;

/**
 * A comparator for calls.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class CallsComparator extends ViewerComparator {

	private boolean asc;

	/**
	 * Default constructor, for ascendant sorting.
	 */
	public CallsComparator() {
		super();
		this.asc = true;
	}

	/**
	 * Constructor for ascendant or descendant sorting.
	 * @param asc for ascendant or descendant sorting.
	 */
	public CallsComparator(boolean asc) {
		super();
		this.asc = asc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof ATLOperation) {
			ATLOperation op1 = (ATLOperation)e1;
			ATLOperation op2 = (ATLOperation)e2;

			if (asc)
				return op1.getCalls() - op2.getCalls();
			else
				return op2.getCalls() - op1.getCalls();
		} else {
			return 0;
		}
	}
}
