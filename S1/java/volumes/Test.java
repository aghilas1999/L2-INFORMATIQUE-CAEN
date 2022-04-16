package volumes;

/**
 * An executable class for testing the classes and methods of this package.
 */
public class Test {

    /**
     * Runs a series of tests, printing "OK" or "KO" for each one.
     * @param args ignored
     */
    public static void main (String[] args) {

        Figure figure;
        double expected;
        
        // Cubes
        System.out.println("Testing cubes...");
        double edgeSize = 12.34567;
        figure = new Cube(edgeSize);
        expected = edgeSize * edgeSize * edgeSize;
        Test.check(figure, expected);
        
        // Cylinders
        System.out.println("Testing cylinders...");
        double radius = 12.34567;
        double cylinderHeight = 235.6;
        figure = new Cylinder(radius, cylinderHeight);
        expected = Math.PI * radius * radius * cylinderHeight;
        Test.check(figure, expected);
        
        // Parallelepipeds
        System.out.println("Testing parallelepipeds...");
        double width = 0.1234;
        double length = 1234.5678;
        double parallelepipedHeight = 12345678.9;
        figure = new Parallelepiped(width, length, parallelepipedHeight);
        expected = width * length * parallelepipedHeight;
        Test.check(figure, expected);
        
        // Prisms
        System.out.println("Testing prisms...");
        double basisLength = 12.34567;
        double basisHeight = 123.456789;
        double prismHeight = 0.1;
        figure = new Prism(basisLength, basisHeight, prismHeight);
        expected = basisLength * basisHeight * prismHeight / 2;
        Test.check(figure, expected);
        
    }
    
    /**
     * Checks whether the volume computed by a given figure is the expected one.
     * Prints "OK" or "KO" (with information) depending on whether the test passes or fails.
     * @param figure A figure
     * @param expected The expected volume for the given figure
     */
    public static void check(Figure figure, double expected) {
        double volume = figure.volume();
        if (volume == expected) {
            System.out.println("OK");
        } else {
            System.out.println("KO (found " + volume + ", expected " + expected);
        }
    }
    
}
