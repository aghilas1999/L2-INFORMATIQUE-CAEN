package stacks;

import java.util.ArrayList;

/**
 * A class for representing a stack of (stackable) objects.
 */
public class Stack {

    /** The stack itself. */
    protected ArrayList<Stackable> objects;
    
    /**
     * Builds a new instance containing no object (empty stack).
     */
    public Stack() {
        this.objects = new ArrayList<>();
    }
    
    /**
     * Adds an object to this stack. The object is added even if
     * already present in the stack.
     * @param object An object
     */
    public void addObject(Stackable object) {
        this.objects.add(object);
    }
    
    /**
     * Returns the number of objects in this stack.
     * @return The number of objects in this stack
     */
    public int nbObjects() {
        return this.objects.size();
    }
    
    /**
     * Returns the total height of this stack.
     * @return The total height of this stack
     */
    public float getTotalHeight() {
        float res = 0;
        for (Stackable object: this.objects) {
            res+= object.getHeight();
        }
        return res;
    }
    
}
