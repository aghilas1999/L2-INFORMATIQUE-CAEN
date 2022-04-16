package stacks;

/**
 * An executable class for demonstrating the use of {@link Stackable} objects.
 */
public class StackExample {

    /**
     * Runs the demo.
     * @param args ignored
     */
    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.addObject(new Box(30, 20 ,20));
        stack.addObject(new Book("Frédéric Dard", "San Antonio - y'a de l'action", 220));
        Painting monaLisa = new Painting("Léonard de Vinci", "La Joconde");
        Box box = new Box(100, 70, 10);
        BoxedPainting boxedMonaLisa = new BoxedPainting(monaLisa, box);
        stack.addObject(boxedMonaLisa);
        stack.addObject(new Box(100, 100, 40));
    
        System.out.print("Verifying computation of total height of a stack... ");
        float expectedHeight = 20 + 220 * Book.PAGE_HEIGHT + 10 + 40;
        float computedHeight = stack.getTotalHeight();
        if (computedHeight == expectedHeight) {
            System.out.println("OK.");
        } else {
            System.out.println();
            System.out.println("Error: expected " + expectedHeight + ", found " + computedHeight);
        }
        
    }

}
