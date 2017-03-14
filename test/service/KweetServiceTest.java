package service;

import junit.framework.TestCase;
import main.domain.Kweet;
import main.domain.User;
import main.service.KweetService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
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

    }

    public void testFindKweetById() throws Exception {

    }

    public void testGetAllKweets() throws Exception {

    }

    public void testGetAllKweetsByUser() throws Exception {

    }

}