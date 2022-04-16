package languages;

/**
 * An executable class for demonstrating the use of the Sentence hierarchy.
 */
public class Demo {

    /**
     * Runs the demo.
     * @param args ignored
     */
    public static void main (String [] args) {

        String [] frenchPronouns = {"je", "tu", "elle", "il", "on", "nous", "vous", "ils", "elles"};
        String [] englishPronouns = {"I", "you", "she", "he", "it", "we", "you", "they"};

        System.out.println("");

        for (String pronoun: frenchPronouns) {
            Sentence sentence = new FrenchSentence (pronoun, "détester", "les cours à 8 h du matin");
            System.out.println(sentence.build());
        }

        System.out.println("");

        for (String pronoun: englishPronouns) {
            Sentence sentence = new EnglishSentence (pronoun, "hate", "lectures at 8:00 AM");
            System.out.println(sentence.build());
        }

        System.out.println("");

    }

}
