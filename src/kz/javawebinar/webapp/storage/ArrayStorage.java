package kz.javawebinar.webapp.storage;

import java.util.Arrays;


import kz.javawebinar.webapp.model.Resume;


import java.util.List;

//import java.util.logging.Level;


/**
 * Aser
 * 20.05.2015
 */

public class ArrayStorage extends AbstractStorage {
    private static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    // protected Logger logger = Logger.getLogger(getClass().getName());

    private int size;

    @Override
    public void doClear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public boolean exist(String uuid) {
        return getIndex(uuid) != -1;
    }


    @Override
    public void doSave(Resume resume) {
        array[size++] = resume;
    }


    @Override
    public void doUpdate(Resume r) {
        int idx = getIndex(r.getUuid());
        array[idx] = r;
    }



    @Override
    public Resume doLoad(String uuid) {
        int idx = getIndex(uuid);
        return array[idx];
    }


    @Override
    public void doDelete(String uuid) {
        int idx = getIndex(uuid);
        int numMoved = size - idx - 1;
        if (numMoved > 0)
            System.arraycopy(array, idx+1, array, idx,
                    numMoved);
        array[--size] = null;
    }

    @Override
    public List<Resume> doGetAll() {
        return Arrays.asList(Arrays.copyOf(array, size()));
    }

    @Override
    public int size() {
      return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i<LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }


}
