package kz.javawebinar.webapp.model;

/**
 * Aser
 * 13.05.2015
 */
public class Contact {
    private final ContactType type;
    private final String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public ContactType getType() {
        return type;
    }
}
