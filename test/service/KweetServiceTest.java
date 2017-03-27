package service;

import junit.framework.TestCase;
import main.java.domain.Kweet;
import main.java.domain.User;
import main.java.service.KweetService;
import org.eclipse.persistence.jpa.jpql.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 * Created by Kevin
 */
public class KweetServiceTest extends TestCase {

    KweetService kweetService = Mockito.mock(KweetService.class);

    public void setUp() throws Exception {
        super.setUp();

    }


    public void tearDown() throws Exception {

    }

    public void testFindKweetById() throws Exception {
        User testUser = new User("testUser1");
        Kweet testFindKweetById = new Kweet(testUser, "kweetText");
        Mockito.when(kweetService.findKweetById(1)).thenReturn(testFindKweetById);

        Kweet foundKweet = kweetService.findKweetById(1);
        Kweet shouldNotFindKweet = kweetService.findKweetById(2);

        assertEquals(testFindKweetById, foundKweet);
        assertNull(shouldNotFindKweet);

    }

    public void testGetAllKweets() throws Exception {
        User testUser1 = new User("testUser1");
        User testUser2 = new User("testUser2");
        Kweet kweet11 = new Kweet(testUser1, "kweet 11");
        Kweet kweet12 = new Kweet(testUser1, "kweet 12");
        Kweet kweet21 = new Kweet(testUser2, "kweet 21");
        Kweet kweet22 = new Kweet(testUser2, "kweet 22");
        ArrayList<Kweet> testKweets = new ArrayList<>();
        testKweets.addAll(Arrays.asList(kweet11,kweet12,kweet21, kweet22));

        Mockito.when(kweetService.getAllKweets()).thenReturn(testKweets);

        ArrayList<Kweet> foundKweets = kweetService.getAllKweets();

        assertEquals(testKweets, foundKweets);
    }

    public void testGetAllKweetsByUser() throws Exception {
        User testUser1 = new User("testUser1");
        User testUser2 = new User("testUser2");
        Kweet kweet11 = new Kweet(testUser1, "kweet 11");
        Kweet kweet12 = new Kweet(testUser1, "kweet 12");
        ArrayList<Kweet> testKweets = new ArrayList<>();
        testKweets.addAll(Arrays.asList(kweet11,kweet12));

        Mockito.when(kweetService.getAllKweetsByUser(testUser1)).thenReturn(testKweets);

        ArrayList<Kweet> foundKweets = kweetService.getAllKweetsByUser(testUser1);
        ArrayList<Kweet> shouldNotFoundKweets= kweetService.getAllKweetsByUser(testUser2);

        assertEquals(testKweets, foundKweets);
        assertEquals(0,shouldNotFoundKweets.size());
    }
}