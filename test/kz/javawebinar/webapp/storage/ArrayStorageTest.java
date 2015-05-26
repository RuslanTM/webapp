package kz.javawebinar.webapp.storage;

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
    private static Resume R1, R2, R3;
    private ArrayStorage storage = new ArrayStorage();

    static {
        R1 = new Resume("Имя1","Место жительства1");
        R1.addContact(new Contact(ContactType.HOME_PHONE,"252-66-33"));
        R1.addContact(new Contact(ContactType.SKYPE, "Nalsur-92"));

        R2 = new Resume("Имя2","Место жительства2");
        R2.addContact(new Contact(ContactType.HOME_PHONE,"252-66-77"));
        R2.addContact(new Contact(ContactType.SKYPE, "KorolLev"));

        R3 = new Resume("Имя3",null);
    }
    @BeforeClass
    public static void beforeClass() {
        //the same as static
    }

    @Before
    public void before() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
        storage.update(R1);
    }

    @Test
    public void testSave() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();
        Assert.assertEquals(null, storage.load(R1.getUuid()));
    }

    @Test
    public void testUpdate() throws Exception {
        Assert.assertEquals("URL", R1.getHomepage());
    }

    @Test
    public void testLoad() throws Exception {
        Assert.assertEquals(R1,  storage.load(R1.getUuid()));
    }

    @Test
    public void testDelete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
//        Assert.assertEquals(null, storage.load(R1.getUuid()));
    }

    @Test
    public void testGetAllSorted() throws Exception {

    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(3, storage.size());
    }
}