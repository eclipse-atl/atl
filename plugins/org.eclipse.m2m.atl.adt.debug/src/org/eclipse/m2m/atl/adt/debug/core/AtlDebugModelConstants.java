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
package org.eclipse.m2m.atl.adt.debug.core;

import org.eclipse.m2m.atl.adt.debug.Messages;

/**
 * Common constants for debugging.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public final class AtlDebugModelConstants {

	/** Port number. */
	public static final String PORT = "6060"; //$NON-NLS-1$

	/** Host name. */
	public static final String HOST = "localhost"; //$NON-NLS-1$

	/** Debug target name. */
	public static final String DEBUGTARGETNAME = Messages
			.getString("AtlDebugModelConstants.DEBUGTARGETNAME"); //$NON-NLS-1$

	/** Run target name. */
	public static final String RUNTARGETNAME = Messages
			.getString("AtlDebugModelConstants.RUNTARGETNAME"); //$NON-NLS-1$

	/** Thread name. */
	public static final String THREADNAME = Messages.getString("AtlDebugModelConstants.THREADNAME"); //$NON-NLS-1$

	/** null debug notation. */
	public static final String NULL = "<null>"; //$NON-NLS-1$

	/** key debug notation. */
	public static final String KEY = "key"; //$NON-NLS-1$

	/** value debug notation. */
	public static final String VALUE = "value"; //$NON-NLS-1$

	/** map element debug notation. */
	public static final String MAPELEMENT = Messages.getString("AtlDebugModelConstants.MAPELEMENT"); //$NON-NLS-1$

	/**
	 * Utility class.
	 */
	private AtlDebugModelConstants() {
	}
	
	
}
