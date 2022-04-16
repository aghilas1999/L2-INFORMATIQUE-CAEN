package houses;

/**
 * A class for representing houses without a garden.
 */
public class House {

    /** The address of this house. */
    protected String address;

    /** The surface of this house. */
    protected int surface;

    /**
     * Builds a new instance.
     * @param address The address of this house
     * @param surface The surface of this house
     */
    public House(String address, int surface) {
        this.address = address;
        this.surface = surface;
    }

    /**
     * Returns the address of this house.
     * @return The address of this house
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns the amount of tax for this house. 
     * @param indoorCoefficient The amount of tax per unit of indoor surface
     * @param outdoorCoefficient The amount of tax per unit of outdoor surface (ignored)
     * @return The amount of tax for this house
     */
    public float getTaxAmount(float indoorCoefficient, float outdoorCoefficient) {
        return this.surface * indoorCoefficient;
    }

}
