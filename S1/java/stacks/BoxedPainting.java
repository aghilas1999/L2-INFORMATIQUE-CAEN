package stacks;

/**
 * A class for representing paintings in boxes.
 */
public class BoxedPainting implements Stackable{

    /** The painting for this instance. */
    protected Painting painting;
    
    /** The box for this instance. */
    protected Box box;

    /**
     * Builds a new instance.
     * @param painting The painting for this instance
     * @param box The box for this instance
     */
    public BoxedPainting(Painting painting, Box box) {
        this.painting = painting;
        this.box = box;
    }

    /**
     * Returns the painting for this instance.
     * @return The painting for this instance
     */
    public Painting getPainting() {
        return this.painting;
    }

    /**
     * Returns the box for this instance.
     * @return The box for this instance
     */
    public Box getBox() {
        return this.box;
    }

    @Override
    public float getHeight() {
        return this.box.getHeight();
    }
    
}
