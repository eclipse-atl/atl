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
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.ui.profilingdatatable;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;

/**
 * A comparator for calls.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class CallsComparator extends ViewerComparator {

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

			return op1.getCalls() - op2.getCalls();
		} else {
			return 0;
		}
	}
}
