package geometry;

import java.util.Scanner;

/**
 * Executable class for demonstrating the use of class Point.
 */
public class Test {

    /**
     * Runs the demo.
     * @param args ignored
     */
    public static void main (String [] args) {

        // Points
        Point point = new Point (3, 4);
        System.out.println("Exemple de point : "
                           + point.getRepresentation() + ".");
        Point symmetric = point.symmetricX();
        System.out.println("Symétrique du point précédent "
                           + "par rapport à l'axe des abscisses : "
                           + symmetric.getRepresentation() + ".");
        int deltaX = 1;
        int deltaY = 2;
        point.translate(deltaX, deltaY);
        System.out.println("Le premier point après translation par "
                           + "(" + deltaX + ", " + deltaY + ") : "
                           + point.getRepresentation() + ".");

        // Segments
        Point point1 = new Point (3, 4);
        Point point2 = new Point (7, 7);
        Segment segment = new Segment (point1, point2);
        System.out.println("Exemple de segment : "
                           + segment.getRepresentation() + ".");
        System.out.println("Longueur du segment : " + segment.length());
        System.out.println("Saisir un vecteur [(x1,y1),(x2,y2)] :");
        Scanner scanner = new Scanner(System.in);
        System.out.print("x1: ");
        int x1 = scanner.nextInt();
        System.out.print("y1: ");
        int y1 = scanner.nextInt();
        System.out.print("x2: ");
        int x2 = scanner.nextInt();
        System.out.print("y2: ");
        int y2 = scanner.nextInt();
        scanner.close();
        Point otherPoint1 = new Point(x1, y1);
        Point otherPoint2 = new Point(x2, y2);
        Segment otherSegment = new Segment (otherPoint1, otherPoint2);
        System.out.println("Vous avez saisi le segment "
                           + otherSegment.getRepresentation() + ".");
        System.out.print("Les deux segments ont ");
        if (otherSegment.length() == segment.length()) {
            System.out.println("la même longueur.");
        } else {
            System.out.println("des longueurs différentes.");
        }

    }
    
}
