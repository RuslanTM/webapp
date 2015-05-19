package kz.javawebinar.webapp.model;

/**
 * Aser
 * 19.05.2015
 */
public enum SectionType {
    OBJECTIVE("Позиция"),
    ACHIEVMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("ОБразование");
    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
