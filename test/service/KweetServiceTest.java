package service;

import junit.framework.TestCase;
import main.java.domain.Kweet;
import main.java.domain.User;
import main.java.service.KweetService;
import org.junit.runner.RunWith;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 * Created by Kevin
 */
public class KweetServiceTest extends TestCase {

    @Inject
    public KweetService service;

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
        service = new KweetService();
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

    @PostConstruct
    public void init() {
    }

    public void tearDown() throws Exception {

    }

    public void testAddKweet() throws Exception {
        assertEquals(0, service.getAllKweets().size());
        service.addKweet(kweet1);
        assertEquals(1, service.getAllKweets().size());
    }

    public void testRemoveKweet() throws Exception {
        service.addKweet(kweet1);
        service.addKweet(kweet2);
        service.addKweet(kweet3);
        assertEquals(3, service.getAllKweets().size());
        assertTrue(service.getAllKweets().contains(kweet1));

        service.removeKweet(kweet1);
        assertEquals(2, service.getAllKweets().size());
        assertFalse(service.getAllKweets().contains(kweet1));
    }

    public void testFindKweetById() throws Exception {
        service.addKweet(kweet1);

        assertEquals(kweet1, service.findKweetById(kweet1.getId()));
    }

    public void testGetAllKweets() throws Exception {
        ArrayList<Kweet> allKweets = new ArrayList<>();
        allKweets.addAll(Arrays.asList(kweet1, kweet2, kweet3, kweet4, kweet5, kweet6));
        service.addKweet(kweet1);
        service.addKweet(kweet2);
        service.addKweet(kweet3);
        service.addKweet(kweet4);
        service.addKweet(kweet5);
        service.addKweet(kweet6);

        ArrayList<Kweet> getKweets = service.getAllKweets();
        assertEquals(allKweets, getKweets);
    }

    public void testGetAllKweetsByUser() throws Exception {
        service.addKweet(kweet1);
        service.addKweet(kweet2);
        service.addKweet(kweet3);
        service.addKweet(kweet4);
        service.addKweet(kweet5);
        service.addKweet(kweet6);

        ArrayList<Kweet> user5Kweets = new ArrayList<>();
        user5Kweets.addAll(Arrays.asList(kweet5, kweet6));

        ArrayList<Kweet> getKweets = service.getAllKweetsByUser(user5);

        assertEquals(user5Kweets, getKweets);
    }

}