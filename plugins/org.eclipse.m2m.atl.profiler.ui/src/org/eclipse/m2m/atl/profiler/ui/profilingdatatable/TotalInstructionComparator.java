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
 * A comparator for instructions.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class TotalInstructionComparator extends ViewerComparator {

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

			int iop1 = ProfilingModelUtils.getTotalInstruction(op1);
			int iop2 = ProfilingModelUtils.getTotalInstruction(op2);

			return iop1 - iop2;
		} else if (e1 instanceof ProfilingOperation) {
			ProfilingOperation pop1 = (ProfilingOperation)e1;
			ProfilingOperation pop2 = (ProfilingOperation)e2;

			int iop1 = pop1.getTotalExecutedInstructions();
			int iop2 = pop2.getTotalExecutedInstructions();

			return iop1 - iop2;
		} else {
			return 0;
		}
	}
}
