package doa;

import junit.framework.TestCase;
import main.dao.KweetCollection;
import main.dao.KweetDao;
import main.domain.Kweet;
import main.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Kevin.
 */
public class KweetCollectionTest extends TestCase {
    KweetDao kweetDoa = new KweetCollection();

    //Users
    User user1;
    User user2;
    User user3;
    User user4;
    User user5;

    //Kweets
    Kweet kweet1;
    Kweet kweet2;
    Kweet kweet3;
    Kweet kweet4;
    Kweet kweet5;
    Kweet kweet6;

    public void setUp() throws Exception {
        super.setUp();

        user1 = new User(0, "profilePic.png","Peter Appel","biografie van deze persoon","Wereldstad","www.tvj.com");
        user2 = new User(1, "profilePic.jpg", "Pusedo meno", "Bio boyz", "Groningen", "website.com");
        user3 = new User(2, "profilePic.gif", "Anna Frenk", "Bio boyz", "Limburg", "meh.com");
        user4 = new User(3, "profilePic.pdf", "Boer Brugmans", "Bio boyz", "Utrecht", "poewpow.com");
        user5 = new User(4, "profilePic.heh", "Lolleke Kekkers", "Bio boyz", "Zeeland", "Wellzijn.com");

        kweet1 = new Kweet(0, "User 1 Kweet 1", new Date(), user1, null, null);
        kweet2 = new Kweet(0, "User 2 Kweet 1", new Date(), user2, null, null);
        kweet3 = new Kweet(0, "User 3 Kweet 1", new Date(), user3, null, null);
        kweet4 = new Kweet(0, "User 4 Kweet 1", new Date(), user4, null, null);
        kweet5 = new Kweet(0, "User 5 Kweet 1", new Date(), user5, null, null);
        kweet6 = new Kweet(0, "User 5 Kweet 2", new Date(), user5, null, null);
    }

    public void tearDown() throws Exception {

    }

    public void testAddKweet() throws Exception {
        assertEquals(0, kweetDoa.getAllKweets().size());
        kweetDoa.addKweet(kweet1);
        assertEquals(1, kweetDoa.getAllKweets().size());
    }

    public void testRemoveKweet() throws Exception {
        kweetDoa.addKweet(kweet1);
        kweetDoa.addKweet(kweet2);
        kweetDoa.addKweet(kweet3);
        assertEquals(3, kweetDoa.getAllKweets().size());
        assertTrue(kweetDoa.getAllKweets().contains(kweet1));

        kweetDoa.removeKweet(kweet1);
        assertEquals(2, kweetDoa.getAllKweets().size());
        assertFalse(kweetDoa.getAllKweets().contains(kweet1));
    }

    public void testFindById() throws Exception {
        kweetDoa.addKweet(kweet1);

        assertEquals(kweet1, kweetDoa.findById(kweet1.getId()));
    }

    public void testGetAllKweets() throws Exception {
        ArrayList<Kweet> allKweets = new ArrayList<>();
        allKweets.addAll(Arrays.asList(kweet1, kweet2, kweet3, kweet4, kweet5, kweet6));
        kweetDoa.addKweet(kweet1);
        kweetDoa.addKweet(kweet2);
        kweetDoa.addKweet(kweet3);
        kweetDoa.addKweet(kweet4);
        kweetDoa.addKweet(kweet5);
        kweetDoa.addKweet(kweet6);

        ArrayList<Kweet> getKweets = kweetDoa.getAllKweets();
        assertEquals(allKweets, getKweets);
    }

    public void testGetAllKweetsByUser() throws Exception {
        kweetDoa.addKweet(kweet1);
        kweetDoa.addKweet(kweet2);
        kweetDoa.addKweet(kweet3);
        kweetDoa.addKweet(kweet4);
        kweetDoa.addKweet(kweet5);
        kweetDoa.addKweet(kweet6);

        ArrayList<Kweet> user5Kweets = new ArrayList<>();
        user5Kweets.addAll(Arrays.asList(kweet5, kweet6));

        ArrayList<Kweet> getKweets = kweetDoa.getAllKweetsByUser(user5);

        assertEquals(user5Kweets, getKweets);
    }

}