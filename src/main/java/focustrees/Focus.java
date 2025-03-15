package focustrees;

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
    private String code;

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
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the focus' Paradox code
     * @param code 
     */
    public void setCode(String code) {
        this.code = code;
    }
    
}
