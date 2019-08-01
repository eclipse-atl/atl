/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    INRIA - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.adt.ui.outline;

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
	}

}
