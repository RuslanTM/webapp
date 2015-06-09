package kz.javawebinar.webapp.model;

import java.util.*;

/**
 * Aser
 * 11.05.2015
 */
public class Resume implements Comparable<Resume>{
    private final String uuid;
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

    public Resume() {

    }

    public void addSection(Section section) {
        sections.add(section);
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }


    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Resume other = (Resume) obj;
        return uuid.equals(other.uuid);
    }

    @Override
    public int compareTo(Resume o) {
        return fullName.compareTo(o.fullName);
    }
}
