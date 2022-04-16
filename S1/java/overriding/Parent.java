package overriding;

/**
 * A class with simply a name as its only property.
 */
public class Parent {

    /** The name of this instance. */
    protected String name;

    /**
     * Builds a new instance.
     * @param name The name of this instance
     */
    public Parent(String name) {
        this.name = name;
    }

    /**
     * Returns a sentence describing this instance.
     * @return A sentence describing this instance
     */
    public String getPresentation() {
        return "Je suis l'instance \"" + this.name + "\" de la classe mère";
    }

    /**
     * Returns a sentence describing how this instance describes itself.
     * @return A sentence describing how this instance describes itself
     */
    public String getMetaPresentation() {
        return "Ma méthode de présentation retourne \""
                + this.getPresentation() + "\"";
    }

}
