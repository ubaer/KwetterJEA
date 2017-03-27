package dao;

import junit.framework.TestCase;
import main.java.dao.KweetJPA;
import main.java.dao.UserJPA;
import main.java.domain.Kweet;
import main.java.domain.User;

/**
 * Created by Kevin
 */
public class KweetJPATest extends TestCase {
    KweetJPA kweetJPA = new KweetJPA();
    UserJPA userJPA = new UserJPA();
    User peterPan;
    public void setUp() throws Exception {
        super.setUp();
        peterPan = new User("PeterPan");
        userJPA.addUser(peterPan);
    }

    public void tearDown() throws Exception {

    }

    public void testAddKweet() throws Exception {

        kweetJPA.addKweet(new Kweet(peterPan, "aight"));
        int currentAmountOfKweets = kweetJPA.getAllKweets().size();
        kweetJPA.addKweet(new Kweet(peterPan, "Add kweet test"));
        int newAmountOfKweets = kweetJPA.getAllKweets().size();

        assertEquals(currentAmountOfKweets + 1, newAmountOfKweets);
    }

    public void testRemoveKweet() throws Exception {

    }

    public void testFindById() throws Exception {

    }

    public void testGetAllKweets() throws Exception {

    }

    public void testGetAllKweetsByUser() throws Exception {

    }

}