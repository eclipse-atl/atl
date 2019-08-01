/*******************************************************************************
 * Copyright (c) 2006 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Matthias Bohlen - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine.compiler;

/**
 * Describes an error which has occurred when compiling an ATL script.
 * 
 * @author <a href="mailto:mbohlen@mbohlen.de">Matthias Bohlen</a>
 */
public class CompileTimeError {
	
	/** The error severity. */
	private final String severity;

	/** The location at which the error occurred. */
	private final String location;

	/** The description of the error. */
	private final String description;

	/**
	 * Creates an instance of CompileError.
	 * 
	 * @param severity
	 *            the error severity
	 * @param location
	 *            the location at which the error occurred
	 * @param description
	 *            the description of the error
	 */
	public CompileTimeError(String severity, String location, String description) {
		this.severity = severity;
		this.location = location;
		this.description = description;
	}

	/**
	 * Returns the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the location.
	 * 
	 * @return the location (format = linenumber:columnnumber)
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Returns the severity.
	 * 
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

}
