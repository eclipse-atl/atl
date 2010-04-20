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
import org.eclipse.m2m.atl.profiler.core.util.ProfilingModelUtils;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * A comparator for memory.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 * @author <a href="mailto:thierry.fortin@obeo.fr">Thierry Fortin</a>
 */
public class MemoryComparator extends ViewerComparator {

	private ColumnType col;
	private boolean asc;

	/**
	 * Creates a new memory comparator.
	 * 
	 * @param c
	 *            the column type
	 */
	public MemoryComparator(ColumnType c) {
		super();
		col = c;
		this.asc = true;
	}

	/**
	 * Creates a new memory comparator.
	 * 
	 * @param c
	 *            the column type
	 * @param asc for ascendant or descendant sorting
	 */
	public MemoryComparator(ColumnType c, boolean asc) {
		super();
		col = c;
		this.asc = asc;
	}

	/**
	 * The columns possible types.
	 */
	public static enum ColumnType {
		/** In memory. */
		InMem,
		/** Max memory. */
		MaxMem,
		/** Out memory. */
		OutMem
	};

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		long iop1 = 0;
		long iop2 = 0;
		if (col == ColumnType.InMem) {
			if (e1 instanceof ATLOperation) {
				ATLOperation op1 = (ATLOperation)e1;
				ATLOperation op2 = (ATLOperation)e2;

				// min in
				iop1 = ProfilingModelUtils.getMinInMemoryUsage(op1);
				iop2 = ProfilingModelUtils.getMinInMemoryUsage(op2);
			} else if (e1 instanceof ProfilingOperation) {
				ProfilingOperation pop1 = (ProfilingOperation)e1;
				ProfilingOperation pop2 = (ProfilingOperation)e2;

				iop1 = pop1.getLaunchedMemoryUsage();
				iop2 = pop2.getLaunchedMemoryUsage();
			}
		} else if (col == ColumnType.MaxMem) {
			if (e1 instanceof ATLOperation) {
				ATLOperation op1 = (ATLOperation)e1;
				ATLOperation op2 = (ATLOperation)e2;

				// max max
				iop1 = ProfilingModelUtils.getMaxMaxMemoryUsage(op1);
				iop2 = ProfilingModelUtils.getMaxMaxMemoryUsage(op2);
			} else if (e1 instanceof ProfilingOperation) {
				ProfilingOperation pop1 = (ProfilingOperation)e1;
				ProfilingOperation pop2 = (ProfilingOperation)e2;

				iop1 = pop1.getMaxMemoryUsage();
				iop2 = pop2.getMaxMemoryUsage();
			}
		} else if (col == ColumnType.OutMem) {
			if (e1 instanceof ATLOperation) {
				ATLOperation op1 = (ATLOperation)e1;
				ATLOperation op2 = (ATLOperation)e2;

				// max max
				iop1 = ProfilingModelUtils.getMaxOutMemoryUsage(op1);
				iop2 = ProfilingModelUtils.getMaxOutMemoryUsage(op2);
			} else if (e1 instanceof ProfilingOperation) {
				ProfilingOperation pop1 = (ProfilingOperation)e1;
				ProfilingOperation pop2 = (ProfilingOperation)e2;

				iop1 = pop1.getEndMemoryUsage();
				iop2 = pop2.getEndMemoryUsage();
			}
		}
		if (asc)
			return (int)(iop1 - iop2);
		else
			return (int)(iop2 - iop1);
	}

	public ColumnType getCol() {
		return col;
	}

	public void setCol(ColumnType col) {
		this.col = col;
	}
}
