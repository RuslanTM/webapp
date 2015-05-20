package kz.javawebinar.webapp.model;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Aser
 * 11.05.2015
 */
public class Resume {
    private String uuid;
    private String fullName;
    private String location;
    private String homepage;
    private List<Contact> contacts = new LinkedList<>();
    private List<Section> sections = new LinkedList<>( );

    public Resume(String fullName, String location) {
        this(UUID.randomUUID().toString(), fullName, location);
    }

    public Resume(String uuid, String fullName, String location) {
        this.uuid = uuid;
        this.location = location;
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    public void addSection(Section section) {
        sections.add(section);
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }


    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getHomepage() {
        return homepage;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Section> getSections() {
        return sections;
    }
}
