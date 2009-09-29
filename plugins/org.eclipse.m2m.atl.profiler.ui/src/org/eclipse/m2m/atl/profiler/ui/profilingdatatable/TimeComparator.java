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
import org.eclipse.m2m.atl.profiler.core.util.ProfilingModelUtils;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * A comparator for times.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class TimeComparator extends ViewerComparator {
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

			double t1 = ProfilingModelUtils.getTotalTime(op1.getProfilingInstructions());
			double t2 = ProfilingModelUtils.getTotalTime(op2.getProfilingInstructions());
			double res = t1 - t2;

			if (res > 0.0) {
				return 1;
			}
			if (res == 0.0) {
				return 0;
			} else {
				return -1;
			}
		} else if (e1 instanceof ProfilingOperation) {
			ProfilingOperation pop1 = (ProfilingOperation)e1;
			ProfilingOperation pop2 = (ProfilingOperation)e2;

			double t1 = pop1.getEndTime() - pop1.getLaunchedTime();
			double t2 = pop2.getEndTime() - pop2.getLaunchedTime();
			double res = t1 - t2;

			if (res > 0.0) {
				return 1;
			}
			if (res == 0.0) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return 0;
		}
	}
}
