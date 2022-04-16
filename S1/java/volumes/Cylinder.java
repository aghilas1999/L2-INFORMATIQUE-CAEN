package volumes;

/**
 * A class for representing cylinders, defined by their radius and height.
 */
public class Cylinder extends Figure {

    /** The radius of this cylinder. */
    protected double radius;

    /**
     * Builds a new instance.
     * @param radius The radius of this cylinder
     * @param height The height of this cylinder
     */
    public Cylinder(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    /**
     * Returns the radius of this cylinder.
     * @return The radius of this cylinder
     */
    public double getRadius() {
        return this.radius;
    }
    
    @Override
    public double basisSurface() {
        return Math.PI * this.radius * this.radius;
    }

}
