package appendix;

/**
 * Implementation of a 'command' (otherwise known as Paradox Code)
 * @author lorenzobarbagelata
 */
public class Command {
    
    private String name;
    private String description;
    private String code;
    //private char type; //prerequisite = p; effect = e; bypass = b

    /**
     * Constructor that takes all three parameters
     * @param name
     * @param description
     * @param code 
     */
    public Command(String name, String description, String code) { //problems with code
        
        if(name.contains("<td>")) {
            name = name.substring(4);
        } if(description.contains("<td>")) {
            description = description.substring(4);
        } if(code.contains("<td>")) {
            code = code.substring(10, code.length()-7);
        }
        
        this.name = name;
        this.description = description;
        this.code = code;
    }
    
    /**
     * Constructor that only takes name and description as parameters
     * @param name
     * @param description 
     */
    public Command(String name, String description)
    {
        if(name.contains("<td>")) {
            name = name.substring(4);
        } if(description.contains("<td>")) {
            description = description.substring(4);
        }
        
        this.name = name;
        this.description = description;
    }
    
    /**
     * Returns the command's name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the command's name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the command's description
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the command's description
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the command's code
     * @return String code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the command's code
     * @param code 
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * toString method that returns the name and the description (not the code!)
     * @return String
     */
    public String toString()
    {
        return name + ": " + description;
    }
    
}
