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
package org.eclipse.m2m.atl.adt.launching.sourcelookup;

import org.eclipse.debug.core.model.ISourceLocator;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.m2m.atl.adt.debug.core.AtlStackFrame;

/**
 * The ATL source locator.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlSourceLocator implements ISourceLocator {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.debug.core.model.ISourceLocator#getSourceElement(org.eclipse.debug.core.model.IStackFrame)
	 */
	public Object getSourceElement(IStackFrame stackFrame) {
		if (stackFrame instanceof AtlStackFrame) {
			AtlStackFrame asf = (AtlStackFrame)stackFrame;
			return asf;
		}
		return null;
	}
	
}
