package languages;

/**
 * An abstract class for representing sentences made of a pronoun, a verb, and an object.
 * Makes sense only for transitive verbs and languages in which the sentence structure
 * is: pronoun conjugated-verb object. Concrete subclasses must define how a verb
 * is conjugated.
 */
public abstract class Sentence {

    /** The pronoun in this sentence. */
    protected String pronoun;
    
    /** The verb in this sentence (infinitive). */
    protected String verb;

    /** The object in this sentence. */
    protected String object;

    /**
     * Builds a new instance.
     * @param pronoun The pronoun in the sentence
     * @param verb The verb in the sentence (infinitive)
     * @param object The object in the sentence
     */
    public Sentence (String pronoun, String verb, String object) {
        this.pronoun = Sentence.capitalize(pronoun.toLowerCase());
        this.verb = verb;
        this.object = object;
    }

    /**
     * Returns a string representing this sentence with correct grammar (conjugated verb), at present tense.
     * @return this sentence with correct grammar, at present tense.
     */
    public String build () {
        return this.pronoun + " " + this.conjugatedVerb() + " " + this.object + ".";
    }

    /**
     * Returns the verb of this sentence, correctly conjugated at the present tense.
     * @return The verb of this sentence, correctly conjugated at the present tense
     */
    public abstract String conjugatedVerb ();

    // Helper method =================================================

    /**
     * Capitalizes a string, that is, changes its first letter to uppercase.
     * @param string A string, assumed to be in lowercase
     * @return A new string corresponding to the capitalization of the given one
     * (an empty string if the given string is empty)
     */
    protected static String capitalize (String string) {
        if (string.length() == 0) {
            return "";
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }

}
