package geometry;

/**
 * A class for representing line segments in a 2D space (with endpoints
 * having integer coordinates).
 */
public class Segment {

    /** One endpoint of this segment. */
    private Point endpoint1;

    /** The other endpoint of this segment. */
    private Point endpoint2;

    /**
     * Builds a new instance.
     * @param endpoint1 An endpoint of this segment
     * @param endpoint2 The other endpoint of this segment
     */
    public Segment (Point endpoint1, Point endpoint2) {
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
    }

    /**
     * Returns a representation of this segment as a string.
     * @return A representation of this segment as a string
     */
    public String getRepresentation () {
        return "[" + this.endpoint1.getRepresentation() + ","
               + this.endpoint2.getRepresentation() + "]";
    }

    /**
     * Returns the length of this segment.
     * @return The length of this segment
     */
    public double length () {
        int lengthX = this.endpoint2.getX() - this.endpoint1.getX();
        int lengthY = this.endpoint2.getY() - this.endpoint1.getY();
        return Math.sqrt(lengthX * lengthX + lengthY * lengthY);
    }
    
}
