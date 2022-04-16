package overriding;

/**
 * An executable class for demonstrating overriding of methods by subclasses.
 */
public class Main {

    /**
     * Runs the demo.
     * @param args ignored
     */
    public static void main(String[] args) {

        Parent p = new Parent("p");
        System.out.println("L'instance p dit :");
        System.out.println("- " + p.getPresentation());
        System.out.println("- " + p.getMetaPresentation());

        System.out.println("");

        Child c = new Child("c");
        System.out.println("L'instance c dit :");
        System.out.println("- " + c.getPresentation());
        System.out.println("- " + c.getMetaPresentation());
    }
}
