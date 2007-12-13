/*******************************************************************************
 * Copyright (c) 2006 INRIA and other.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Matthias Bohlen - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.engine;

/**
 * Describes an error which has occured when compiling an ATL script.
 * @author Matthias Bohlen
 */
public class CompileTimeError {
    private String severity;
    private String location;
    private String description;
    
    /**
     * Constructs an instance of CompileError.
     * @param location the location at which the error occured
     * @param description the description of the error
     */
    public CompileTimeError (String severity, String location, String description) {
        this.severity = severity;
        this.location = location;
        this.description = description;
    }
    
    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * @return the location (format = linenumber:columnnumber)
     */
    public String getLocation()
    {
        return location;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(String location)
    {
        this.location = location;
    }

    /**
     * @return the severity
     */
    public String getSeverity()
    {
        return severity;
    }

    /**
     * @param severity the severity to set
     */
    public void setSeverity(String severity)
    {
        this.severity = severity;
    }
}