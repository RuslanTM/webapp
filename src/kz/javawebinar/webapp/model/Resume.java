package kz.javawebinar.webapp.model;

import java.util.*;

/**
 * Aser
 * 11.05.2015
 */
public class Resume implements Comparable<Resume>{
    private String uuid;
    private String fullName;
    private String location;
    private String homepage;
    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

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

    public void addSection(SectionType type, Section section) {

        sections.put(type, section);
    }
    public String getContact(ContactType type) {
        return contacts.get(type);
    }
    public void addContact(ContactType type, String value) {
        contacts.put(type, value);
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

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public Section getSection(SectionType type) {
        return sections.get(type);
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
    public String toString() {
        return  fullName + "(" + uuid + ")";
    }

    @Override
    public int compareTo(Resume o) {
        return fullName.compareTo(o.fullName);
    }
}
