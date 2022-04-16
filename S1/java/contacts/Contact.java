package contacts;

/**
 * A class for representing a person with a name, birth date, and email address
 * (as a string).
 */
public class Contact extends Person {

    /** The person's email address. */
    private String email;

    /**
     * Builds a new instance.
     * {@inheritDoc}
     * @param email The person's email address
     * @see Person#Person
     */
    public Contact (String name, int birthYear, int birthMonth, int birthDay, String email) {
        super(name, birthYear, birthMonth, birthDay);
        this.email = email;
    }

    /**
     * Returns this contact's email.
     * @return This contact's email
     */
    public String getEmail () {
        return this.email;
    }
    
    /**
     * Returns this contact's email with his/her name, in the form
     * "Name &lt;email@domain.tld&gt;".
     * @return This contact's email with his/her name
     */
    public String getEmailWithName () {
        return super.name + " <" + this.email + ">";
    }

    @Override
    public String getPresentation () {
        return super.getPresentation() + " Email: " + this.email + ".";
    }

}
