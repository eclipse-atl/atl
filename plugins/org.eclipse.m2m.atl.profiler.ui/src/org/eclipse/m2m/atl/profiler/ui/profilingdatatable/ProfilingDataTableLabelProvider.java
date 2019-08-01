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
 *******************************************************************************/
package org.eclipse.m2m.atl.profiler.ui.profilingdatatable;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.m2m.atl.profiler.core.util.ProfilingModelUtils;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;
import org.eclipse.swt.graphics.Image;

/**
 * A label provider for the data table.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class ProfilingDataTableLabelProvider extends AdapterFactoryLabelProvider implements ITableLabelProvider {

	/**
	 * Creates a label provider using the given factory.
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 */
	public ProfilingDataTableLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		String txt = ""; //$NON-NLS-1$
		NumberFormat percentInstance = DecimalFormat.getPercentInstance();
		percentInstance.setMaximumFractionDigits(2);
		// ATLOPeration
		if (element instanceof ATLOperation) {
			ATLOperation atlOp = (ATLOperation)element;
			if (columnIndex == ProfilingDataTableView.getOperationNameId()) {
				txt = "" + atlOp.getName(); //$NON-NLS-1$
			} else if (columnIndex == ProfilingDataTableView.getCallsId()) {
				txt = "" + atlOp.getCalls(); //$NON-NLS-1$
			} else if (columnIndex == ProfilingDataTableView.getTotalTimeExecutionId()) {
				if (ProfilingDataTableView.isShowPercentAction()) {
					double pTime = ProfilingModelUtils.getTotalTime(atlOp.getProfilingInstructions())
							/ ProfilingDataTableView.getTotalTime();
					txt = percentInstance.format(pTime);
				} else {
					txt = "" + ProfilingModelUtils.getTotalTime(atlOp.getProfilingInstructions()); //$NON-NLS-1$
				}
			} else if (columnIndex == ProfilingDataTableView.getTotalInstructionsId()) {
				if (ProfilingDataTableView.isShowPercentAction()) {
					double pInstr = (double)ProfilingModelUtils.getTotalInstruction(atlOp)
							/ (double)ProfilingDataTableView.getTotalInstructions();
					txt = percentInstance.format(pInstr);
				} else {
					txt = "" + ProfilingModelUtils.getTotalInstruction(atlOp); //$NON-NLS-1$
				}
			} else if (columnIndex == ProfilingDataTableView.getMaxMemoryColID()) {
				long maxMaxMem = ProfilingModelUtils.getMaxMaxMemoryUsage(atlOp);

				txt = convertMemToKb(maxMaxMem) + " Kb"; //$NON-NLS-1$
			} else if (columnIndex == ProfilingDataTableView.getOutMemoryColId()) {
				long maxEndMem = ProfilingModelUtils.getMaxOutMemoryUsage(atlOp);

				txt = convertMemToKb(maxEndMem) + " Kb"; //$NON-NLS-1$
			} else if (columnIndex == ProfilingDataTableView.getInMemoryColId()) {
				long minStartMem = ProfilingModelUtils.getMinInMemoryUsage(atlOp);

				txt = convertMemToKb(minStartMem) + " Kb"; //$NON-NLS-1$
			} else {
				txt = ""; //$NON-NLS-1$
			}
			// Profling Operation
		} else if (element instanceof ProfilingOperation) {
			ProfilingOperation pOp = (ProfilingOperation)element;
			Double time = new Double((pOp.getEndTime() - pOp.getLaunchedTime()) / 1000.0);
			if (columnIndex == ProfilingDataTableView.getOperationNameId()) {
				txt = "[" + pOp.getInstructionID() + "] " + pOp.getContent(); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else if (columnIndex == ProfilingDataTableView.getTotalTimeExecutionId()) {
				if (ProfilingDataTableView.isShowPercentAction()) {
					double pTime = time / ProfilingDataTableView.getTotalTime();
					txt = percentInstance.format(pTime);
				} else {
					txt = "" + time; //$NON-NLS-1$
				}
			} else if (columnIndex == ProfilingDataTableView.getTotalInstructionsId()) {
				if (ProfilingDataTableView.isShowPercentAction()) {
					double pInstr = (double)pOp.getTotalExecutedInstructions() / (double)ProfilingDataTableView
							.getTotalInstructions();
					txt = percentInstance.format(pInstr);
				} else {
					txt = "" + pOp.getTotalExecutedInstructions(); //$NON-NLS-1$
				}
			} else if (columnIndex == ProfilingDataTableView.getInMemoryColId()) {
				long startMem = pOp.getLaunchedMemoryUsage() / 1000;
				txt = startMem + " Kb"; //$NON-NLS-1$
			} else if (columnIndex == ProfilingDataTableView.getMaxMemoryColID()) {
				long avMem = pOp.getMaxMemoryUsage() / 1000;
				txt = avMem + " Kb"; //$NON-NLS-1$
			} else if (columnIndex == ProfilingDataTableView.getOutMemoryColId()) {
				long exitMem = pOp.getEndMemoryUsage() / 1000;
				txt = exitMem + " Kb"; //$NON-NLS-1$
			} else {
				txt = ""; //$NON-NLS-1$
			}
		}
		return txt;
	}

	private long convertMemToKb(long minStartMem) {
		return minStartMem / 1000;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		Image img = null;
		if ((element instanceof ATLOperation && columnIndex == 0)
				|| (element instanceof ProfilingOperation && columnIndex == 0)) {
			return super.getColumnImage(element, columnIndex);
		}
		return img;
	}

}
