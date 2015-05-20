package kz.javawebinar.webapp.model;

import java.util.List;

/**
 * Aser
 * 11.05.2015
 */
public class Resume {
    private String uuid;
    private String fullName;
    private String location;
    private String homepage;
    private List<Contact> contacts;
    private List<Section> sections;

    public Resume(String location, String fullName) {
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
}
