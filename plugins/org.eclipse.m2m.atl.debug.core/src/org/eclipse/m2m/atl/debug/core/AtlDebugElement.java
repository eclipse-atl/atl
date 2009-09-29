/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.debug.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

/**
 * An abstract class to mark debugged elements.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public abstract class AtlDebugElement extends PlatformObject implements IDebugElement {

	/** containing target. */
	protected AtlDebugTarget fTarget;

	/**
	 * Constructs a new debug element contained in the given debug target.
	 * 
	 * @param target
	 *            debug target (PDA VM)
	 */
	public AtlDebugElement(AtlDebugTarget target) {
		fTarget = target;
	}

	public String getModelIdentifier() {
		return AtlDebugModelConstants.ATL_DEBUG_MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return fTarget;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return getDebugTarget().getLaunch();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.PlatformObject#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IDebugElement.class) {
			return this;
		}
		return super.getAdapter(adapter);
	}

	/**
	 * Aborts the current debug.
	 * 
	 * @param message
	 *            abort message
	 * @param e
	 *            exception
	 * @throws DebugException
	 */
	protected void abort(String message, Throwable e) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, AtlCoreDebugPlugin.getUniqueIdentifier(),
				DebugPlugin.INTERNAL_ERROR, message, e));
	}

}
