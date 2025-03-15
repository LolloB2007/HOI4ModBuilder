package focustrees;

import appendix.Command;
import appendix.LinkedList;
import appendix.Position;

/**
 * implementation of a Focus
 * @author lorenzobarbagelata
 */
public class Focus {
    
    private String name;
    private String description;
    private int duration; //in days
    private Position position;
    private LinkedList<Focus> required = new LinkedList<Focus>();
    private LinkedList<Command> commands = new LinkedList<Command>();
    
    /**
     * Constructor taking the Focus' name as a parameter
     * @param n 
     */
    public Focus(String n)
    {
        name = n;
    }
    
    /**
     * Constructor taking the Focus' name and the required Focus
     * @param n
     * @param f 
     */
    public Focus(String n, Focus f)
    {
        name = n;
        required.add(f);
    }
    
    /**
     * Constructor taking the Focus' name and the LinkedList<Focus> with required focuses
     * @param n
     * @param f 
     */
    public Focus(String n, LinkedList<Focus> f)
    {
        name = n;
        required = f;
    }
    
    /**
     * Returns the focus' name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the focus' name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the focus' description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the focus' description
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the focus' duration in days
     * @return int
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the focus' duration in days
     * @param duration 
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Returns the focus' position within the FocusTree's map
     * @return Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the focus' position within the FocusTree's map
     * @param position 
     */
    public void setPosition(Position position) {
        this.position = position;
    }
    
    /**
     * Sets the focus to which this one's position is relative to
     * @param f 
     */
    public void setPositionRelativeTo(Focus f) {
        position.setRelativeTo(f.getPosition());
    }

    /**
     * Returns the focus' Paradox code
     * @return LinkedList<String> commands
     */
    public LinkedList<Command> getCommands() {
        return commands;
    }

    /**
     * Sets the focus' Paradox code
     * @param commands 
     */
    public void setCommands(LinkedList<Command> commands) {
        this.commands = commands;
    }
    
    /**
     * Adds a command to commands LinkedList
     * @param c 
     */
    public void addCommand(Command c) {
        commands.add(c);
    }

    /**
     * Returns the LinkedList with all required focuses
     * @return LinkedList<Focus> required
     */
    public LinkedList<Focus> getRequired() {
        return required;
    }

    /**
     * Sets the required focuses
     * @param required 
     */
    public void setRequired(LinkedList<Focus> required) {
        this.required = required;
    }
    
    /**
     * Adds a focus to the list of required focuses
     * @param f 
     */
    public void addRequired(Focus f)
    {
        required.add(f);
    }
    
    /**
     * Removes from required all focuses that are not present in the LinkedList given as parameter
     * @param f 
     */
    public void keepFocuses(LinkedList<Focus> f)
    {
        for(int i = 0; i<required.size(); i++) {
            if(!f.contains(required.get(i))) {
                required.remove(i);
                i--;
            }
        }
    }
    
}
