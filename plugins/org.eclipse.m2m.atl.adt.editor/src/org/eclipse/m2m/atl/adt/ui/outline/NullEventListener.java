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

import java.util.logging.Logger;

import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;

public class NullEventListener implements EventListener 
{
	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);
	private static NullEventListener instance;
	
	public static NullEventListener getInstance() 
	{
		if (instance == null)
			instance = new NullEventListener();
		return instance;
	}
	
	/*
	 * @see EventListener#add(Event)
	 */
	public void update(Event event) {
		logger.info("update");//$NON-NLS-1$
	}

}
