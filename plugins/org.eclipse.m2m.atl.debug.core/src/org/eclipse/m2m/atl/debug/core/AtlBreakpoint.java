/*******************************************************************************
 * Copyright (c) 2004 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.debug.core;

import java.util.logging.Level;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;
import org.eclipse.m2m.atl.common.ATLLogger;

/**
 * ATL breakpoint redefinition.
 * 
 * @author <a href="mailto:freddy.allilaire@obeo.fr">Freddy Allilaire</a>
 */
public class AtlBreakpoint extends LineBreakpoint {

	private static final String ATL_BREAKPOINT_MARKER = "org.eclipse.m2m.atl.debug.core.atlBreakpointMarker"; //$NON-NLS-1$

	/**
	 * Create a new ATL Breakpoint.
	 */
	public AtlBreakpoint() {
		super();
	}

	/**
	 * Creates a breakpoint.
	 * 
	 * @param resource
	 *            the resource to mark
	 * @param location
	 *            the breakpoint location
	 * @param lineNumber
	 *            the line number
	 * @param charStart
	 *            the start index
	 * @param charEnd
	 *            the end index
	 * @throws DebugException
	 */
	public AtlBreakpoint(final IResource resource, final String location, final int lineNumber,
			final int charStart, final int charEnd) throws DebugException {
		IWorkspaceRunnable wr = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				// create the marker
				setMarker(resource.createMarker(ATL_BREAKPOINT_MARKER));
				// add attributes
				addBreakpointAttributes(getModelIdentifier(), location, true, lineNumber, charStart, charEnd);
				// add to breakpoint manager
				setRegistered(true);
			}
		};
		run(wr);
	}

	/**
	 * Adds the standard attributes of a line breakpoint. The standard attributes are:
	 * <ol>
	 * <li>IBreakpoint.ID</li>
	 * <li>IBreakpoint.ENABLED</li>
	 * <li>IMarker.LINE_NUMBER</li>
	 * <li>IMarker.CHAR_START</li>
	 * <li>IMarker.CHAR_END</li>
	 * </ol>
	 */
	private void addBreakpointAttributes(String modelIdentifier, String location, boolean enabled,
			int lineNumber, int charStart, int charEnd) {
		try {
			IMarker marker = ensureMarker();
			marker.setAttribute(IBreakpoint.ID, modelIdentifier);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(IBreakpoint.ENABLED, Boolean.valueOf(enabled));
			marker.setAttribute(IMarker.LINE_NUMBER, Integer.valueOf(lineNumber));
			marker.setAttribute(IMarker.CHAR_START, Integer.valueOf(charStart));
			marker.setAttribute(IMarker.CHAR_END, Integer.valueOf(charEnd));
			marker.setAttribute(IBreakpoint.REGISTERED, false); // breakpoint has not been registered yet
		} catch (CoreException e) {
			ATLLogger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IBreakpoint#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return AtlDebugModelConstants.ATL_DEBUG_MODEL_ID;
	}

	/**
	 * Execute the given workspace runnable.
	 * 
	 * @param wr
	 *            the workspace runnable
	 * @throws DebugException
	 */
	protected void run(IWorkspaceRunnable wr) throws DebugException {
		try {
			ResourcesPlugin.getWorkspace().run(wr, null);
		} catch (CoreException e) {
			throw new DebugException(e.getStatus());
		}
	}
}
