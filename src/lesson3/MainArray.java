package lesson3;

import kz.javawebinar.webapp.model.ContactType;
import kz.javawebinar.webapp.model.Resume;
import kz.javawebinar.webapp.model.Contact;
import kz.javawebinar.webapp.storage.ArrayStorage;

/**
 * Aser
 * 20.05.2015
 */
public class MainArray {
    public static void main(String[] args) {
        Resume r = new Resume("Name1","Location1");
        r.addContact(new Contact(ContactType.SKYPE, "RUS777"));
        r.addContact(new Contact(ContactType.MOBILE, "+77072269777"));
        ArrayStorage storage = new ArrayStorage();
       // storage.save(r);
    }


}
