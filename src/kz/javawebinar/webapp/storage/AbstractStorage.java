package kz.javawebinar.webapp.storage;

import kz.javawebinar.webapp.WebAppException;
import kz.javawebinar.webapp.model.Resume;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Aser
 * 28.05.2015
 */
abstract public class AbstractStorage implements IStorage{
    private Logger logger = Logger.getLogger(ArrayStorage.class.getName());

    @Override
    public void clear() {
        logger.info("Delete all resumes");
        doClear();
    }

    protected abstract void doClear();
    protected abstract boolean exist(String uuid);


    @Override
    public void save(Resume r) {
        logger.info("Save resume with uuid = " + r.getUuid());
        if(exist(r.getUuid()))   throw new WebAppException("Resume " + r.getUuid() + " already exist", r);
        doSave(r);
    }

    protected abstract void doSave(Resume resume);

    @Override
    public void update(Resume r) {
        logger.info("Update resume with uuid = " + r.getUuid());

        if (!exist(r.getUuid())) throw new WebAppException("Resume " + r.getUuid() + " not exist", r);
        doUpdate(r);
    }

    abstract protected void doUpdate(Resume r);


    @Override
    public Resume load(String uuid) {
        logger.info("Load resume with uuid = " + uuid);
        if (!exist(uuid)) throw new WebAppException("Resume " + uuid + " not exist");
        return doLoad(uuid);
    }

    protected abstract Resume doLoad(String uuid);

    @Override
    public void delete(String uuid) {
        logger.info("Delete resume with uuid=" + uuid);

        if (!exist(uuid)) throw new WebAppException("Resume " + uuid + " not exist");
        doDelete(uuid);
    }

    protected abstract void doDelete(String uuid);

    @Override
    public Collection<Resume> getAllSorted() {
        logger.info("Get All Sorted");
        List<Resume> list = doGetAll();
        Collections.sort(list, new Comparator<Resume>() {
            //anonimnyi class
            @Override
            public int compare(Resume o1, Resume o2) {
                int cmp = o1.getFullName().compareTo(o2.getFullName());
                if (cmp != 0) return cmp;
                return o1.getUuid().compareTo(o2.getUuid());
            }
        });
        //lyamda
       /* Collections.sort(list, (Resume o1, Resume o2) -> {
                int cmp = o1.getFullName().compareTo(o2.getFullName());
                if (cmp != 0) return cmp;
                return o1.getUuid().compareTo(o2.getUuid());
        });
        Collections.singletonList(new Resume());*/
        return list;
    }

    protected abstract List<Resume> doGetAll();

    public abstract int size();


}
