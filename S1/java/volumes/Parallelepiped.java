package volumes;

/**
 * A class for representing parallelepipeds, defined by their width, length, and
 * height. The basis of such parallelepiped is assumed to be the surface defined
 * by the width and length.
 */
public class Parallelepiped extends Figure {

    /** The width of this parallelepiped. */
    protected double width;

    /** The length of this parallelepiped. */
    protected double length;

    /**
     * Builds a new instance.
     * @param width The width of this parallelepiped
     * @param length The length of this parallelepiped
     * @param height The height of this parallelepiped
     */
    public Parallelepiped(double width, double length, double height) {
        super(height);
        this.width = width;
        this.length = length;
    }

    /**
     * Returns the width of this parallelepiped.
     * @return The width of this parallelepiped
     */
    public double getWidth() {
        return this.width;
    }
    
    /**
     * Returns the length of this parallelepiped.
     * @return The length of this parallelepiped
     */
    public double getLength() {
        return this.length;
    }
    
    @Override
    public double basisSurface() {
        return this.width * this.length;
    }

}
