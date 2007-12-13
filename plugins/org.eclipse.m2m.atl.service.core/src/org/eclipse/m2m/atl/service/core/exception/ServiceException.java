/*******************************************************************************
 * Copyright (c) 2007 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Freddy Allilaire (INRIA) - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.service.core.exception;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * 
 * @author Freddy Allilaire
 *
 */
public class ServiceException extends CoreException {

	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new exception
	 * @param status the status
	 */
	public ServiceException(IStatus status) {
		super(status);
	}
	
	/**
	 * Creates a new exception
	 * @param status the status (IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR, IStatus.CANCEL)
	 */
	public ServiceException(int status, String message) {
		super(new Status(status, "org.eclipse.m2m.atl.service.core", IStatus.OK, message, null));
	}
	
	/**
	 * Creates a new exception
	 * @param status the status (IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR, IStatus.CANCEL)
	 */
	public ServiceException(int status, String message, Exception exception) {
		super(new Status(status, "org.eclipse.m2m.atl.service.core", IStatus.OK, message + "\n" + exception.getMessage(), exception));
	}		
	
	/**
	 * Creates a new exception
	 * @param status the status (IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR, IStatus.CANCEL)
	 */
	public ServiceException(int status, Exception exception) {
		super(new Status(status, "org.eclipse.m2m.atl.service.core", IStatus.OK, exception.getMessage(), exception));
	}
		
}
