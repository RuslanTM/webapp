package kz.javawebinar.webapp.model;

/**
 * Aser
 * 13.05.2015
 */
public class Section {
    private String name;
    private String Description;

    public Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
