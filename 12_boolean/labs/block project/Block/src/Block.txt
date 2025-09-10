// A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/28/24
//Class - Comp Sci 2K
//Lab  - Block

import java.awt.*;

/**
 * @author Parth Zanwar
 * @version 9/3/2024
 */
public class Block{
    //instance variables
    private int xPos;
    private int yPos;

    private int width;
    private int height;

    private Color color;

    //constructors

    /**
     * Constructor that creates a Block at position(100, 1500), a width of 10, a height of 10, and the color black
     */
    public Block() {
        xPos = 100;
        yPos = 1500;
        width = 10;
        height = 10;
        color = Color.black;
    }

    /**
     * Constructor that creates a Block set to the specified arguments and the color black
     * @param x x location of the Block
     * @param y y location of the Block
     * @param width width of the Block
     * @param height height of the Block
     */

    public Block(int x, int y, int width, int height) {
        xPos = x;
        yPos = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLACK;
    }

    /**
     * Constructor that creates a Block with the specified arguments
     * @param x x location of the Block
     * @param y y location of the Block
     * @param width width of the Block
     * @param height height of the Block
     * @param color Color of the Block
     */

    public Block(int x, int y, int width, int height, Color color) {
        xPos = x;
        yPos = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    //set methods

    public void setPos(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }


    public void setX(int x) {
        this.xPos = x;
    }


    public void setY(int y) {
        this.yPos = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public void setColor(Color c) {
        color = c;
    }

    /**
     * Draws the Block via the Graphics reference using its attributes
     * @param window - Makes a window where the Block is displayed
     */

    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(xPos, yPos, width, height);
    }

    //get methods

    public int getX() {
        return xPos;
    }


    public int getY() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    //toString

    /**
     * Returns a String representation of this object in the format "x y width height color". Invokes the toString() from the Color class
     * @return String
     */
    @Override
    public String toString() {
        return xPos + " " + yPos + " " + width + " " + height + " " + color.toString();
    }

    /**
     * Returns true if the xPos and yPos is within the boundary inclusive of this Block and false otherwise
     * @param xPos The x coordinate of the specified point
     * @param yPos The y coordinate of the specified point
     * @return boolean
     */
    public boolean contains(int xPos, int yPos) {
        int count = 0;
        if (this.xPos <= xPos && xPos <= width + this.xPos) count += 1;
        if (this.yPos <= yPos && yPos <= height + this.yPos) count += 1;
        return count == 2;

    }

    /**
     * Returns a new Block that is the tightest bounding region that encompasses both Blocks
     * @param other variable type block that is used to calculate union
     * @return Block
     */
    public Block union(Block other) {
        if (this.equals(other)) return this;
        int x1 = Math.min(this.xPos, other.xPos);
        int y1 = Math.min(this.yPos, other.yPos);
        int x2 = Math.max(this.xPos + this.width, other.xPos + other.width);
        int y2 = Math.max(this.yPos + this.height, other.yPos + other.height);

        // Calculate width and height of the union
        int width = x2 - x1;
        int height = y2 - y1;
        return new Block(x1, y1, width, height);
    }

    /**
     * Returns a new Block that's the intersection of the two Blocks or null if none exists
     * @param other variable type block that is used to calculate union
     * @return Block
     */
    public Block intersection(Block other) {
        int thisX1 = xPos;
        int thisX2 = thisX1 + width;
        int thisY1 = yPos;
        int thisY2 = thisY1 + height;

        int otherX1 = other.xPos;
        int otherX2 = otherX1 + other.width;
        int otherY1 = other.yPos;
        int otherY2 = otherY1 + other.height;

        if (thisX2 < otherX1) return null;
        if (thisY2 < otherY1) return null;
        if (otherX2 < thisX1) return null;
        if (otherY2 < thisY1) return null;

        int x = Math.max(this.xPos, other.xPos);
        int y = Math.max(this.yPos, other.yPos);
        int width = Math.min(this.xPos + this.width, other.xPos + other.width) - x;
        int height = Math.min(this.yPos + this.height, other.yPos + other.height) - y;
        return new Block(x, y, width, height);
    }


    /**
     *Converts the Block to a standard representation with positive width and height
     * Given a Block with x = 10, y = 10, w = 3, h = 4 then executing canonicalize results in
     * x = 10, y = 6, w = 3, h = 4
     */
    public void canonicalize() {
        if (width < 0) {
            width = -width;
            xPos = xPos - width;
        }

        if (height < 0) {
            height = -height;
            yPos = yPos - height;
        }
    }

    public boolean equals(Block other) {
        return this.xPos == other.xPos && this.yPos == other.yPos && this.width == other.width && this.height == other.height;
    }


}