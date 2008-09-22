/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.outline;

import org.eclipse.m2m.atl.ATLPlugin;

public class NullEventListener implements EventListener {

	private static NullEventListener instance;

	public static NullEventListener getInstance() {
		if (instance == null)
			instance = new NullEventListener();
		return instance;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2m.atl.adt.ui.outline.EventListener#update(org.eclipse.m2m.atl.adt.ui.outline.Event)
	 */
	public void update(Event event) {
		ATLPlugin.info("update"); //$NON-NLS-1$
	}

}
