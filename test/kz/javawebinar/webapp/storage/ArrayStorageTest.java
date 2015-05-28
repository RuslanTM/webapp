package kz.javawebinar.webapp.storage;

import java.util.Arrays;

import kz.javawebinar.webapp.WebAppException;
import kz.javawebinar.webapp.model.Contact;
import kz.javawebinar.webapp.model.ContactType;
import kz.javawebinar.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Aser
 * 20.05.2015
 */
public class ArrayStorageTest {
    private Resume R1, R2, R3;
    private ArrayStorage storage = new ArrayStorage();

    static {
    }
    @BeforeClass
    public static void beforeClass() {
        //the same as static
    }

    @Before
    public void before() {
        R1 = new Resume("Имя1","Место жительства1");
        R1.addContact(new Contact(ContactType.HOME_PHONE,"252-66-33"));
        R1.addContact(new Contact(ContactType.SKYPE, "Nalsur-92"));

        R2 = new Resume("Имя2","Место жительства2");
        R2.addContact(new Contact(ContactType.HOME_PHONE,"252-66-77"));
        R2.addContact(new Contact(ContactType.SKYPE, "KorolLev"));

        R3 = new Resume("Имя3",null);
        storage.clear();
        storage.save(R3);
        storage.save(R1);
        storage.save(R2);

    }

    @Test
    public void testSave() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void testUpdate() throws Exception {
        R2.setFullName("Name2");
        storage.update(R2);
        Assert.assertEquals(R2, storage.load(R2.getUuid()));
    }

    @Test
    public void testLoad() throws Exception {
        Assert.assertEquals(R1, storage.load(R1.getUuid()));
        Assert.assertEquals(R2, storage.load(R2.getUuid()));
        Assert.assertEquals(R3,  storage.load(R3.getUuid()));
    }

    @Test(expected = WebAppException.class)
    public void testDeleteNotFound() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
        storage.load(R1.getUuid());
    }
    @Test
    public void testDelete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void testGetAllSorted() throws Exception {
        Resume[] src = new Resume[]{R1, R2, R3};
        Arrays.sort(src);
        assertArrayEquals(src, storage.getAllSorted().toArray());

    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(3, storage.size());
    }
}