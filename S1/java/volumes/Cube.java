package volumes;

/**
 * A class for representing cubes, defined by the size of their edges.
 */
public class Cube extends Parallelepiped {

    /**
     * Builds a new instance.
     * @param edgeSize The size of the edges of this cube
     */
    public Cube(double edgeSize) {
        super(edgeSize, edgeSize, edgeSize);
    }

    /**
     * Returns the size of the edges of this cube.
     * @return The size of the edges of this cube
     */
    public double getEdgeSize() {
        return super.getHeight();
    }
    
}
