package contacts;

/**
 * An executable class for demonstrating the use of class Contact, getters,
 * and setters.
 */
public class Demo {

    /**
     * Runs the demo.
     * @param args ignored
     */
    public static void main (String [] args) {

        Person jean = new Person ("Jean Martin", 2000, 1, 1);
        System.out.println(jean.getPresentation());

        Contact kevin = new Contact ("Kevin Durand", 2001, 2, 2, "kevin@mail.fr");
        System.out.println(kevin.getPresentation());
        System.out.println("Kevin's email: " + kevin.getEmail());
        System.out.println("Kevin's email with name: " + kevin.getEmailWithName());
        
        Person louise = new Contact ("Louise Lefevre", 2002, 3, 3, "louise@mail.fr");
        System.out.println(louise.getPresentation());

        System.out.println("");

        Person aPerson = null;
        aPerson = jean;
        System.out.println(aPerson.getPresentation());
        aPerson = kevin;
        System.out.println(aPerson.getPresentation());
        aPerson = louise;
        System.out.println(aPerson.getPresentation());

    }

}
