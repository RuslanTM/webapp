package lesson3;

import kz.javawebinar.webapp.model.Contact;
import kz.javawebinar.webapp.model.ContactType;

/**
 * Aser
 * 19.05.2015
 */
public class Main {
    public static void main(String[] args) {
        Contact c = new Contact(ContactType.PHONE,"+77072269777");
        ContactType c2 = ContactType.SKYPE;
        System.out.println(ContactType.SKYPE==c2);
    }
}
