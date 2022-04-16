package volumes;

/**
 * A class for representing prism, defined by the length and height of the base
 * triangle and by their height.
 */
public class Prism extends Figure {

    /** The length of the base triangle of this prism. */
    protected double basisLength;

    /** The height of the base triangle of this prism. */
    protected double basisHeight;

    /**
     * Builds a new instance.
     * @param basisLength The length of the base triangle of this prism
     * @param basisHeight The height of the base triangle of this prism
     * @param height The height of this prism
     */
    public Prism(double basisLength, double basisHeight, double height) {
        super(height);
        this.basisLength = basisLength;
        this.basisHeight = basisHeight;
    }

    /**
     * Returns the length of the base triangle of this prism.
     * @return The length of the base triangle of this prism
     */
    public double getBasisLength() {
        return this.basisLength;
    }
    
    /**
     * Returns the height of the base triangle of this prism.
     * @return The height of the base triangle of this prism
     */
    public double getBasisHeight() {
        return this.basisHeight;
    }
    
    @Override
    public double basisSurface() {
        return this.basisLength * this.basisHeight / 2;
    }

}
