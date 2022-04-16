package houses;

/**
 * A class for representing houses with a garden.
 */
public class Property extends House {

    /** The surface of the garden of this property. */
    protected int gardenSurface;

    /**
     * Builds a new instance.
     * @param address The address of this property
     * @param houseSurface The indoor surface of this property
     * @param gardenSurface The surface of the garden of this property
     */
    public Property(String address, int houseSurface, int gardenSurface) {
        super(address, houseSurface);
        this.gardenSurface = gardenSurface;
    }

    /**
     * {@inheritDoc}
     * @param outdoorCoefficient The amount of tax per unit of outdoor surface
     */
    @Override
    public float getTaxAmount(float indoorCoefficient, float outdoorCoefficient) {
        return super.getTaxAmount(indoorCoefficient, outdoorCoefficient)
                + this.gardenSurface * outdoorCoefficient;
    }

}
