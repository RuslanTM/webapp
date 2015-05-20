package kz.javawebinar.webapp.storage;

import kz.javawebinar.webapp.model.Resume;

import java.util.Collection;

/**
 * Aser
 * 20.05.2015
 */
public interface IStorage {
    //Crud
    void clear();
    void save(Resume r);
    void update(Resume r);
    Resume load(String uuid);
    void delete(String uuid);
    Collection<Resume> getAllSorted();
    int size();

}
