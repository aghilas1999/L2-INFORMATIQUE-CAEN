package houses;

/**
 * An executable class for testing the classes and methods of this package.
 */
public class Test {

    /**
     * Runs a series of tests, printing "OK" or "KO" to standard output for each
     * of them.
     * @param args ignored
     */
    public static void main(String[] args) {

        // Tax amounts
        float indoorCoefficient = 100;
        float outdoorCoefficient = 10;

        // Tests for houses
        int houseSurface = 120;
        House house = new House("1 Main Street, London City", houseSurface);
        float houseTaxAmount = house.getTaxAmount(indoorCoefficient,
                outdoorCoefficient);
        float houseExpectedAMount = indoorCoefficient * houseSurface;
        if (houseTaxAmount == houseExpectedAMount) {
            System.out.println("Test for house: OK");
        } else {
            System.out.println("Test for house: KO (expected "
                    + houseExpectedAMount + ", found " + houseTaxAmount);
        }

        // Tests for properties
        int propertyIndoorSurface = 120;
        int propertyOutdoorSurface = 770;
        Property property = new Property("2 Main Street, London City",
                propertyIndoorSurface, propertyOutdoorSurface);
        float propertyTaxAmount = property.getTaxAmount(indoorCoefficient,
                outdoorCoefficient);
        float propertyExpectedAmount = propertyIndoorSurface
                * indoorCoefficient + propertyOutdoorSurface
                * outdoorCoefficient;
        if (propertyTaxAmount == propertyExpectedAmount) {
            System.out.println("Test for property: OK");
        } else {
            System.out.println("Test for property: KO (expected "
                    + propertyExpectedAmount + ", found " + propertyTaxAmount);
        }

        // Tests for class Taxes

        Taxes taxes = new Taxes(indoorCoefficient, outdoorCoefficient);
        float houseTaxes = taxes.getTaxAmount(house);
        if (houseTaxes == houseExpectedAMount) {
            System.out.println("Test for house with class Taxes: OK");
        } else {
            System.out.println("Test for house with class Taxes: KO (expected "
                    + houseExpectedAMount + ", found " + houseTaxes);
        }

        float propertyTaxes = taxes.getTaxAmount(property);
        if (propertyTaxes == propertyExpectedAmount) {
            System.out.println("Test for property with class Taxes: OK");
        } else {
            System.out
                    .println("Test for property with class Taxes: KO (expected "
                            + propertyExpectedAmount
                            + ", found "
                            + propertyTaxes);
        }

        House[] houses = {house, property};
        float totalExpectedAmount = houseExpectedAMount + propertyExpectedAmount;
        float totalTaxes = taxes.getTaxAmount(houses);
        if (totalTaxes == totalExpectedAmount) {
            System.out.println("Test for array with class Taxes: OK");
        } else {
            System.out
                    .println("Test for array with class Taxes: KO (expected "
                            + totalExpectedAmount
                            + ", found "
                            + totalTaxes);
        }
        
    }

}
