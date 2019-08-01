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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.m2m.atl.profiler.model.Context;
import org.eclipse.m2m.atl.profiler.model.ExecutionError;
import org.eclipse.m2m.atl.profiler.model.ProfilingInstruction;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * A label provider for the execution view.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class ExecutionViewLabelProvider extends AdapterFactoryLabelProvider {

	/**
	 * Creates a label provider using the given factory.
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 */
	public ExecutionViewLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		String txt = " ? "; //$NON-NLS-1$
		if (object instanceof ProfilingInstruction || object instanceof ProfilingOperation) {
			ProfilingInstruction pi = (ProfilingInstruction)object;
			txt = "[" + pi.getInstructionID() + "] " + pi.getContent(); //$NON-NLS-1$ //$NON-NLS-2$
			if (pi.getContent().equals("__resolve__")) { //$NON-NLS-1$
				ProfilingOperation po = (ProfilingOperation)pi;
				if (ExecutionView.isShowResolvContextInlabel()) {
					txt += " => "; //$NON-NLS-1$
					for (Context c : po.getContext()) {
						txt += c.getContent() + " ;"; //$NON-NLS-1$
					}
				}
			}
		}
		if (object instanceof Context) {
			Context c = (Context)object;
			txt = "Context :: " + c.getContent(); //$NON-NLS-1$
		}
		if (object instanceof ExecutionError) {
			ExecutionError error = (ExecutionError)object;
			txt = "" + error.getMessage(); //$NON-NLS-1$
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
