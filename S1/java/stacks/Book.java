package stacks;

public class Book extends Artwork implements Stackable{

    /** The height of a page. */
    public static final float PAGE_HEIGHT = 0.01f; 
    
    /** The number of pages of this book. */
    protected int nbPages;
    
    /**
     * Builds a new instance.
     * @param author The author of this book
     * @param title The title of this book
     * @param nbPages The number of pages of this book
     */
    public Book(String author, String title, int nbPages) {
        super(author, title);
        this.nbPages = nbPages;
    }

    /**
     * Returns the number of pages of this book.
     * @return The number of pages of this book
     */
    public int getNbPages() {
        return this.nbPages;
    }
    
    @Override
    public float getHeight() {
        return this.nbPages * Book.PAGE_HEIGHT;
    }

}
