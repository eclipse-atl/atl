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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.m2m.atl.profiler.core.ProfilerModelHandler;
import org.eclipse.m2m.atl.profiler.model.ATLOperation;
import org.eclipse.m2m.atl.profiler.model.ProfilingModel;
import org.eclipse.m2m.atl.profiler.model.ProfilingOperation;

/**
 * A content provider for the data table.
 * 
 * @author <a href="mailto:arnaud.giuliani@c-s.fr">Arnaud Giuliani</a>
 */
public class ProfilingDataTableContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Creates a new {@link ProfilingDataTableContentProvider}.
	 * 
	 * @param adapterFactory
	 *            the adapter factory.
	 */
	public ProfilingDataTableContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object parent) {
		if (parent instanceof ProfilingModel) {
			Map<String, ATLOperation> registry = ProfilerModelHandler.getInstance().getOperationRegistry();
			return registry.values().toArray();
		} else if (parent instanceof ATLOperation || parent instanceof ProfilingOperation) {
			List<ATLOperation> opList = new ArrayList<ATLOperation>();
			return opList.toArray();
		} else {
			return super.getElements(parent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object child) {
		return super.getParent(child);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parent) {
		if (parent instanceof ATLOperation) {
			ATLOperation atlOp = (ATLOperation)parent;
			return atlOp.getProfilingInstructions().toArray();
		}
		return super.getChildren(parent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object parent) {
		if (parent instanceof ATLOperation) {
			ATLOperation atlOp = (ATLOperation)parent;
			return atlOp.getProfilingInstructions().size() > 0;
		} else {
			return false;
		}
	}
}
