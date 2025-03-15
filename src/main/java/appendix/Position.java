package appendix;

import focustrees.Focus;

/**
 * Implementation of position of a focus within the focus tree
 * @author lorenzobarbagelata
 */
public class Position {
    
    private int x;
    private int y;
    private Position relativeTo;
    
    /**
     * Default constructor
     */
    public Position()
    {
        
    }
    
    /**
     * Constructor
     * @param x
     * @param y 
     */
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Constructor with point relative to
     * @param x
     * @param y
     * @param p 
     */
    public Position(int x, int y, Position p)
    {
        this.x = x;
        this.y = y;
        this.relativeTo = p;
    }
    
    /**
     * Alternative constructor with point relative to
     * @param x
     * @param y
     * @param p 
     */
    public Position(int x, int y, Focus p)
    {
        this.x = x;
        this.y = y;
        this.relativeTo = p.getPosition();
    }

    /**
     * Returns the position's value for x
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the position's value for x
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the position's value for y
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the position's value for y
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets to which position this position is relative to
     * If it returns null, then this position is absolute
     * @return Position
     */
    public Position getRelativeTo() {
        return relativeTo;
    }

    /**
     * Sets the position to which this one is relative to
     * @param relativeTo 
     */
    public void setRelativeTo(Position relativeTo) {
        this.relativeTo = relativeTo;
    }
    
}
