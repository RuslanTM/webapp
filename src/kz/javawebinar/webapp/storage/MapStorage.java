package kz.javawebinar.webapp.storage;

import kz.javawebinar.webapp.WebAppException;
import kz.javawebinar.webapp.model.Resume;

import java.util.*;

/**
 * Aser
 * 29.05.2015
 */
public class MapStorage extends AbstractStorage {
    Map map = new HashMap<String, Resume>();


    @Override
    public void doClear() {
        map.clear();
    }

    @Override
    public boolean exist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    public void doSave(Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    public void doUpdate(Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    public Resume doLoad(String uuid) {
        return (Resume) map.get(uuid);
    }

    @Override
    public void doDelete(String uuid) {
        map.remove(uuid);
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
