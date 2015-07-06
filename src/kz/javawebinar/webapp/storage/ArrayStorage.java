package kz.javawebinar.webapp.storage;

import java.util.Arrays;


import kz.javawebinar.webapp.model.Resume;


import java.util.List;

//import java.util.logging.Level;


/**
 * Aser
 * 20.05.2015
 */

public class ArrayStorage extends AbstractStorage<Integer> {
    private static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    // protected Logger logger = Logger.getLogger(getClass().getName());
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
    private int size;


    @Override
    protected Integer getContext(String uuid) {
        for (int i = 0; i<LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void doClear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    protected boolean exist(Integer idx) {
        return idx != -1;
    }


    @Override
    protected void doSave(Integer idx, Resume resume) {
        array[size++] = resume;
    }

    @Override
    protected void doUpdate(Integer idx, Resume r) {
        array[idx] = r;
    }

    @Override
    protected Resume doLoad(Integer idx, String uuid) {
        return array[idx];
    }

    @Override
    protected void doDelete(Integer idx, String uuid) {
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




}
