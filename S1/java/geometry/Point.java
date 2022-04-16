package geometry;

/**
 * A class for representing 2D points in a discrete space (with integer coordinates).
 */
public class Point {

    /** The x-coordinate of this point. */
    private int x;

    /** The y-coordinate of this point. */
    private int y;

    /**
     * Builds a new instance.
     * @param x The x-coordinate of this point
     * @param y The y-coordinate of this point
     */
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of this point.
     * @return The x-coordinate of this point
     */
    public int getX () {
        return this.x;
    }

    /**
     * Returns the y-coordinate of this point.
     * @return The y-coordinate of this point
     */
    public int getY () {
        return this.y;
    }

    /**
     * Returns the typical mathematical representation of this point as a string.
     * @return The typical mathematical representation of this point as a string
     */
    public String getRepresentation () {
        return "(" + this.x + "," + this.y + ")";
    }

    /**
     * Returns a new point, representing the symmetric of this one relative
     * to the x-axis.
     * @return The symmetric of this point relative to the x-axis
     */
    public Point symmetricX () {
        return new Point (this.x, - this.y);
    }

    /**
     * Translates this point (in place) by a given vector.
     * @param deltaX The x-coordinate of the translation vector
     * @param deltaY The y-coordinate of the translation vector
     */
    public void translate (int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
    
}
