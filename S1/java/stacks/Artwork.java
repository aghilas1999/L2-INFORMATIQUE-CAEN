package stacks;

/**
 * A class for a generic artwork, with an author and a title.
 */
public class Artwork {

    /** The author of this artwork. */
    protected String author;
    
    /** The title of this artwork. */
    protected String title;

    /**
     * Builds a new instance.
     * @param author The author of this artwork
     * @param title The title of this artwork
     */
    public Artwork(String author, String title) {
        this.author = author;
        this.title = title;
    }

    /**
     * Returns the author of this artwork.
     * @return The author of this artwork
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the title of this artwork.
     * @return The title of this artwork
     */
    public String getTitle() {
        return this.title;
    }
    
}
