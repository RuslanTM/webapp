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
public class ArrayStorageTest extends AbstractStorageTest {
    {
        storage = new ArrayStorage();
    }

}