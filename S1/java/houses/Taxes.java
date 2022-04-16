package houses;

/**
 * A class for computing tax amounts for several properties or houses at once.
 */
public class Taxes {

    /** The amount of tax per unit of indoor surface. */
    protected float indoorCoefficient;
    
    /** The amount of tax per unit of outdoor surface. */
    protected float outdoorCoefficient;

    /**
     * Builds a new instance.
     * @param indoorCoefficient the amount of tax per unit of indoor surface
     * @param outdoorCoefficient the amount of tax per unit of outdoor surface
     */
    public Taxes (float indoorCoefficient, float outdoorCoefficient) {
        this.indoorCoefficient = indoorCoefficient;
        this.outdoorCoefficient = outdoorCoefficient;
    }

    /**
     * Returns the amount of tax for a house (or property).
     * @param house A house
     * @return The amount of tax for the given house
     */
    public float getTaxAmount (House house) {
        return house.getTaxAmount(this.indoorCoefficient, this.outdoorCoefficient);
    }

    /**
     * Returns the amount of tax for an array of houses (and properties). The amount for such an array is defined to be the sum of the individual amounts.
     * @param houses An array of houses
     * @return The amount of tax for the given array
     */
    public float getTaxAmount (House[] houses) {
        float res = 0;
        for (House house: houses) {
            res+= this.getTaxAmount(house);
        }
        return res;
    }
    
}
