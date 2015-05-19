package kz.javawebinar.webapp.model;

/**
 * Aser
 * 13.05.2015
 */
public class Link {
    public static Link EMPTY = new Link();
    private final String name;
    private final String url;

    public Link() {
        this("", null);
    }

    //����������� �����������
    public Link(Link link) {
        this(link.name, link.url);
    }

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }


    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return name.equals(link.name) && !(url != null ? !url.equals(link.url) : link.url != null);

    }
}
