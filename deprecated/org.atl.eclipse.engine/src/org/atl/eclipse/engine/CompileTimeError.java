package org.atl.eclipse.engine;

/**
 * Decribes an error which has occured when compiling an ATL script.
 * @author Matthias Bohlen
 */
public class CompileTimeError {
    private String location;
    private String description;
    
    /**
     * Constructs an instance of CompileError.
     * @param location the location at which the error occured
     * @param description the description of the error
     */
    public CompileTimeError (String location, String description) {
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
}