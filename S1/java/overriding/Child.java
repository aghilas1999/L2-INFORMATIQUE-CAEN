package overriding;

/**
 * A subclass of class {@link Parent} for demonstrating overriding.
 */
public class Child extends Parent {

    /**
     * Builds a new instance.
     * @param name The name of this instance
     */
    public Child(String name) {
        super(name);
    }

    @Override
    public String getPresentation() {
        return super.getPresentation()
                + ", et plus spécifiquement de la classe fille";
    }
}
