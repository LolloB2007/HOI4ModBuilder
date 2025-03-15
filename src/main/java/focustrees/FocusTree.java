package focustrees;

import appendix.LinkedList;

/**
 * Implementation of a focus tree
 * @author lorenzobarbagelata
 */
public class FocusTree {
    
    private String countryCode;
    private LinkedList<Focus> focuses = new LinkedList<Focus>();
    
    /**
     * Default constructor
    */
    public FocusTree()
    {
                
    }
    
    /**
     * Country-code constructor
     * @param countryCode 
     */
    public FocusTree(String countryCode)
    {
        this.countryCode = countryCode;
    }
    
    /**
     * Adds a focus to the Focus Tree
     * @param f 
     */
    public void addFocus(Focus f)
    {
        focuses.add(f);
    }

    /**
     * Returns the FocusTree's country code
     * @return String
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the FocusTree's country code
     * @param countryCode 
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Returns the FocusTree's focuses
     * @return LinkedList<Focus> focuses
     */
    public LinkedList<Focus> getFocuses() {
        return focuses;
    }

    /**
     * Sets the FocusTree's focuses
     * @param focuses 
     */
    public void setFocuses(LinkedList<Focus> focuses) {
        this.focuses = focuses;
    }
    
    
}
