package org.atl.eclipse.engine;

/**
 * Decribes an error which has occured when compiling an ATL script.
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