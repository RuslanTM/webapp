package lesson2;
import com.sun.org.apache.xpath.internal.SourceTree;
import kz.javawebinar.webapp.model.*;
/**
 * Aser
 * 13.05.2015
 */
public class Main {
    public static void main(String[] args) {
        Link l1 = new Link("JavaWebinar","javawebinar.kz");
        Link l2 = new Link(l1);
        l2.getClass();
        System.out.println(l2.getClass());
        System.out.println(l1);
        System.out.println(Link.EMPTY);
    }
}
