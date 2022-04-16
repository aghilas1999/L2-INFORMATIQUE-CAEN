package volumes;

/**
 * A class for representing regular 3D figures.
 */
public abstract class Figure {

    /** The height of this figure. */
    protected double height;

    /**
     * Builds a new instance.
     * @param height The height of this figure
     */
    public Figure(double height) {
        this.height = height;
    }

    /**
     * Returns the height of this figure.
     * @return The height of this figure
     */
    public double getHeight() {
        return this.height;
    }
    
    /**
     * Returns the volume of this figure.
     * @return The volume of this figure
     */
    public double volume() {
        return this.basisSurface() * this.height;
    }

    /**
     * Returns the surface of the basis of this figure.
     * @return The surface of the basis of this figure
     */
    public abstract double basisSurface();

}
