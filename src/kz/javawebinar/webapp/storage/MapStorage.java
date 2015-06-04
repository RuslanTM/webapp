package kz.javawebinar.webapp.storage;

import kz.javawebinar.webapp.WebAppException;
import kz.javawebinar.webapp.model.Resume;

import java.util.*;

/**
 * Aser
 * 29.05.2015
 */
public class MapStorage extends AbstractStorage {
    Map storage = new HashMap<String, Resume>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume r) throws WebAppException {
        storage.put(r.getUuid(), r);
    }

    @Override
    public void update(Resume r) {
        Resume resume = (Resume) storage.get(r.getUuid());
        if (resume == null) throw new WebAppException("Resume with uuid=" + r.getUuid() + " is not exist");
        storage.put(r.getUuid(), r);
    }

    @Override
    public Resume load(String uuid) {
        Resume resume = (Resume) storage.get(uuid);
        if (resume == null) {
            throw new WebAppException("Resume with uuid=" + uuid + " is not exist");
        }
        return resume;
    }

    @Override
    public void delete(String uuid) {
        storage.remove(uuid);
    }

    @Override
    public Collection<Resume> getAllSorted() {
        List mapValues = new ArrayList(storage.values());
        Collections.sort(mapValues);
        return mapValues;
    }

    @Override
    public int size() {
        return storage.size();
    }

    public LinkedHashMap sortHashMapByValues(HashMap passedMap) {
        List mapKeys = new ArrayList(passedMap.keySet());
        List mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap sortedMap = new LinkedHashMap();

        Iterator valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Object val = valueIt.next();
            Iterator keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Object key = keyIt.next();
                String comp1 = passedMap.get(key).toString();
                String comp2 = val.toString();

                if (comp1.equals(comp2)) {
                    passedMap.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put((String) key, (Resume) val);
                    break;
                }
            }
        }
        return  sortedMap;

    }

}
