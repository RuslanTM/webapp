package lesson5;

import kz.javawebinar.webapp.model.Resume;
import kz.javawebinar.webapp.storage.ArrayStorage;

/**
 * Aser
 * 10.06.2015
 */
public class Main {

    public static void main(String[] args) {
        Resume r = new Resume();
        System.out.println(String.valueOf(r));
    }

    private static class Resume2 {
        Resume2() {
            System.out.println("New Resume2");
        }
    }
}
