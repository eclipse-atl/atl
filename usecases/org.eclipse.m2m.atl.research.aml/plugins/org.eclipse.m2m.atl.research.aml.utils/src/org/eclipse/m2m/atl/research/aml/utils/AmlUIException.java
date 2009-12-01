/*******************************************************************************
 * Copyright (c) 2009 Ecole des Mines de Nantes.

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kelly Garces - initial API and implementation and/or initial documentation
 *******************************************************************************/ 

package org.eclipse.m2m.atl.research.aml.utils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
/**
 * 
 * @author Kelly Garces <a href="mailto:kellygarce@gmail.com">Kelly Garces</a>
 *
 */
public class AmlUIException extends CoreException {
	
	/**
	 * Creates a new exception 
	 * @param status the status
	 */
	public AmlUIException(IStatus status) {
		super(status);
	}
	
	/**
	 * Creates a new exception 
	 * @param status the status (IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR, IStatus.CANCEL)
	 */
	public AmlUIException(int status,String message) {
		super(new Status(status, "org.eclipse.m2m.atl.research.aml.wizard", IStatus.OK, message, null));
	}	
	
	/**
	 * Creates a new exception for the weaver
	 * @param status the status (IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR, IStatus.CANCEL)
	 */
	public AmlUIException(int status,Exception exception) {
		super(new Status(status, "org.eclipse.m2m.atl.research.aml.wizard", IStatus.OK, exception.getMessage(), exception));
	}

}
