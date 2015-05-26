package lesson3;

import kz.javawebinar.webapp.model.Contact;
import kz.javawebinar.webapp.model.ContactType;
import kz.javawebinar.webapp.model.Link;

import java.lang.reflect.Field;

/**
 * Aser
 * 19.05.2015
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Contact c = new Contact(ContactType.PHONE, "+77072269777");
        ContactType c2 = ContactType.SKYPE;
        System.out.println(ContactType.SKYPE == c2);
        Field f = Link.class.getDeclaredField("url");
        f.setAccessible(true);
        Link l = new Link("name", "url");
        System.out.println(l.getClass().isInstance(Link.class));
        System.out.println(l instanceof Link);
        System.out.println(f.get(l));
        System.out.println(l.getUrl());



    }
}
