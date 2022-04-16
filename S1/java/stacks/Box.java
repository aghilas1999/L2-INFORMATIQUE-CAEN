package stacks;

/**
 * A class for boxes.
 */
public class Box implements Stackable {

    /** The length of this box. */
    protected float length;
    
    /** The width of this box. */
    protected float width;
    
    /** The height of this box. */
    protected float height;

    /**
     * Builds a new instance.
     * @param length The length of this box
     * @param width The width of this box
     * @param height The height of this box
     */
    public Box(float length, float width, float height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the length of this box.
     * @return The length of this box
     */
    public float getLength() {
        return this.length;
    }

    /**
     * Returns the width of this box.
     * @return The width of this box
     */
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }
    
}
