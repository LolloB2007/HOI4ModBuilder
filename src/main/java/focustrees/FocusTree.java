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
}
