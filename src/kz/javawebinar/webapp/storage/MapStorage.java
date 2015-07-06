package kz.javawebinar.webapp.storage;


import kz.javawebinar.webapp.model.Resume;

import java.util.*;

/**
 * Aser
 * 29.05.2015
 */
public class MapStorage extends AbstractStorage<String> {
    Map map = new HashMap<String, Resume>();


    @Override
    protected String getContext(String uuid) {
        if (map.containsKey(uuid)) {
            return uuid;
        }
        return null;
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    public boolean exist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    protected void doSave(String ctx, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(String ctx, Resume r) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doLoad(String ctx, String uuid) {
        return (Resume) map.get(uuid);
    }

    @Override
    protected void doDelete(String ctx, String uuid) {
        map.remove(uuid);
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }

}
