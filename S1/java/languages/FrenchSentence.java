package languages;

/**
 * A class for French sentences, at present tense, with a verb from the first
 * conjugation group (and no specificity like "avancer/avançons").
 */
public class FrenchSentence extends Sentence {

    /**
     * Builds a new instance.
     * @param pronoun The pronoun in the sentence
     * @param verb The verb in the sentence (infinitive)
     * @param object The object in the sentence
     */
    public FrenchSentence (String pronoun, String verb, String object) {
        super(pronoun, verb, object);
    }

    @Override
    public String conjugatedVerb () {
        int size = this.verb.length();
        if (this.pronoun.equals("Tu")) {
            return this.verb.substring(0, size-1) + "s";
        } else if (this.pronoun.equals("Nous")) {
            return this.verb.substring(0, size-2) + "ons";
        } else if (this.pronoun.equals("Vous")) {
            return this.verb.substring(0, size-1) + "z";
        } else if (this.pronoun.equals("Ils") || this.pronoun.equals("Elles")) {
            return this.verb.substring(0, size-1) + "nt";
        } else {
            return this.verb.substring(0, size-1);
        }
    }
}
