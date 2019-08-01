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
package org.eclipse.m2m.atl.profiler.ui.executionviewer.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.m2m.atl.profiler.core.ProfilerModelHandler;
import org.eclipse.m2m.atl.profiler.model.ExecutionError;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * A label provider for the calls view.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class CallsViewLabelProvider extends AdapterFactoryLabelProvider {

	private static final double TIME_CONSTANT = 1000.0;

	/**
	 * Creates a label provider using the given factory.
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 */
	public CallsViewLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		String txt = ""; //$NON-NLS-1$

		NumberFormat percentInstance = DecimalFormat.getPercentInstance();
		percentInstance.setMaximumFractionDigits(2);

		if (object instanceof ProfilingOperation) {
			ProfilingOperation po = (ProfilingOperation)object;
			// parent list
			ProfilingOperation parentOp = po.getParentOperation();
			// ancestor ?
			ProfilingOperation parentParentOp = parentOp.getParentOperation();
			List<ProfilingOperation> parentsList = new ArrayList<ProfilingOperation>();
			if (parentParentOp != null) {
				for (ProfilingInstruction tmpPi : parentParentOp.getExecutionInstructions()) {
					if (tmpPi.getContent().equals(parentOp.getContent())) {
						parentsList.add((ProfilingOperation)tmpPi);
					}
				}
			} else {
				parentsList.add(parentOp);
			}

			double avTime = 0.0;

			// for each parent
			for (ProfilingOperation parent : parentsList) {
				for (ProfilingInstruction pi : parent.getExecutionInstructions()) {
					if (pi instanceof ProfilingOperation && pi.getContent().equals(po.getContent())) {

						ProfilingOperation tmpOp = (ProfilingOperation)pi;
						double tmpTime = (tmpOp.getEndTime() - tmpOp.getLaunchedTime()) / TIME_CONSTANT;
						avTime += tmpTime;
					}
				}
			}
			double pTime = avTime / ProfilerModelHandler.getInstance().getModelTotalTime();

			txt = po.getContent() + " "; //$NON-NLS-1$

			if (pTime == 0.0) {
				txt += "0.01 %"; // fix display //$NON-NLS-1$
			} else {
				txt += percentInstance.format(pTime);
			}
		}
		return txt;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof ProfilingOperation) {
			ProfilingOperation pop = (ProfilingOperation)object;
			if (pop.isHasError()) {
				return getSystemErrorIcon();
			} else {
				return super.getImage(object);
			}
		} else if (object instanceof ExecutionError) {
			return getSystemErrorIcon();
		} else {
			return super.getImage(object);
		}
	}

	private Image getSystemErrorIcon() {
		Display display = PlatformUI.getWorkbench().getDisplay();
		return display.getSystemImage(SWT.ICON_ERROR);
	}
}
