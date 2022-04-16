package languages;

import java.util.Arrays;
import java.util.Collection;

/**
 * A class for English sentences, at present tense, with a regular verb.
 */
public class EnglishSentence extends Sentence {

    /** All English third-person pronouns. */
    public static final Collection<String> THIRD_PERSON_PRONOUNS
        = Arrays.asList("He", "She", "It");

    /**
     * Builds a new instance.
     * @param pronoun The pronoun in the sentence
     * @param verb The verb in the sentence (infinitive)
     * @param object The object in the sentence
     */
    public EnglishSentence (String pronoun, String verb, String object) {
        super(pronoun, verb, object);
    }

    @Override
    public String conjugatedVerb () {
        if (EnglishSentence.THIRD_PERSON_PRONOUNS.contains(this.pronoun)) {
            return this.verb + "s";
        } else {
            return this.verb;
        }
    }

}
