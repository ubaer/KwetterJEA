package domain;

import junit.framework.TestCase;
import main.java.domain.Kweet;
import main.java.domain.User;

import java.util.*;

/**
 * Created by Kevin on 13-3-2017.
 */
public class UserTest extends TestCase {

    User testUser;

    public void setUp() throws Exception {
        testUser = new User(0, "profilePicute.png", "Peter Appel", "biografie van deze persoon", "Wereldstad", "www.tvj.com");
    }

    public void tearDown() throws Exception {

    }

    public void testAddFollower() throws Exception {
        User newFollower = new User(1, "profilePic.jpg", "Pusedo meno", "Bio boyz", "Rdam", "website.com");

        assertEquals(0, testUser.getFollowers().size());

        testUser.addFollower(newFollower);

        List<User> followers = testUser.getFollowers();
        assertEquals(1, followers.size());
        assertEquals(newFollower, followers.get(0));
    }

    public void testRemoveFollower() throws Exception {
        User newFollower = new User(1, "profilePic.jpg", "Pusedo meno", "Bio boyz", "Rdam", "website.com");
        testUser.addFollower(newFollower);
        assertEquals(1, testUser.getFollowers().size());

        testUser.removeFollower(newFollower);
        assertEquals(0, testUser.getFollowers().size());
    }

    public void testAddFollows() throws Exception {
        User newFollows = new User(1, "profilePic.jpg", "Pusedo meno", "Bio boyz", "Rdam", "website.com");

        assertEquals(0, testUser.getFollows().size());

        testUser.addFollows(newFollows);

        List<User> follows = testUser.getFollows();
        assertEquals(1, follows.size());
        assertEquals(newFollows, follows.get(0));
    }

    public void testRemoveFollows() throws Exception {
        User newFollows = new User(1, "profilePic.jpg", "Pusedo meno", "Bio boyz", "Rdam", "website.com");
        testUser.addFollows(newFollows);
        assertEquals(1, testUser.getFollows().size());

        testUser.removeFollows(newFollows);
        assertEquals(0, testUser.getFollows().size());
    }

    public void testRemoveKweet() throws Exception {
        Kweet newKweet = new Kweet(0, "message", new Date(), testUser, null, null);

        assertEquals(newKweet, testUser.getAllKweets().get(0));

        testUser.removeKweet(newKweet);
        assertEquals(0, testUser.getAllKweets().size());
    }

    public void testGetRecentTweets() {
        Date date;
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 1);
        date = cal.getTime();
        Kweet kweet1 = new Kweet(0, "1", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 11);
        date = cal.getTime();
        Kweet kweet11 = new Kweet(10, "11", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 3);
        date = cal.getTime();
        Kweet kweet3 = new Kweet(2, "3", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 5);
        date = cal.getTime();
        Kweet kweet5 = new Kweet(4, "5", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 6);
        date = cal.getTime();
        Kweet kweet6 = new Kweet(5, "6", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 2);
        date = cal.getTime();
        Kweet kweet2 = new Kweet(1, "2", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 7);
        date = cal.getTime();
        Kweet kweet7 = new Kweet(6, "7", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 4);
        date = cal.getTime();
        Kweet kweet4 = new Kweet(3, "4", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 9);
        date = cal.getTime();
        Kweet kweet9 = new Kweet(8, "9", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 10);
        date = cal.getTime();
        Kweet kweet10 = new Kweet(9, "10", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 8);
        date = cal.getTime();
        Kweet kweet8 = new Kweet(7, "8", date, testUser, null, null);

        cal.set(Calendar.HOUR_OF_DAY, 12);
        date = cal.getTime();
        Kweet kweet12 = new Kweet(11, "12", date, testUser, null, null);

        ArrayList<Kweet> sortedList = new ArrayList();
        sortedList.addAll(Arrays.asList(kweet12, kweet11, kweet10, kweet9, kweet8, kweet7, kweet6, kweet5, kweet4, kweet3));

        assertEquals(sortedList, testUser.getRecentKweets(10));
    }

    public void testGetTimeLine() throws Exception {
        // Create Users
        User userOne = new User(1, "profilePic.jpg", "Pusedo meno", "Bio boyz", "Rdam", "website.com");
        User userTwo = new User(2, "profilePic.jpg", "Pieter peers", "Ik hou van wildwatervissen", "Gron", "vissen.com");
        User userThree = new User(3, "headShot.png", "Abba Swish", "Zingen is echt mijn ding", "Friez", "tralalila.com");

        //Create Kweets user 1
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 1);
        Date date = cal.getTime();
        Kweet kweet1 = new Kweet(0, "User 1 Kweet 1 Hour 1", date, userOne, null, null);
        cal.set(Calendar.HOUR_OF_DAY, 6);
        date = cal.getTime();
        Kweet kweet2 = new Kweet(1, "User 1 Kweet 2 Hour 6", date, userOne, null, null);
        cal.set(Calendar.HOUR_OF_DAY, 9);
        date = cal.getTime();
        Kweet kweet3 = new Kweet(2, "User 1 Kweet 3 Hour 9", date, userOne, null, null);
        //Create Kweets user 2
        cal.set(Calendar.HOUR_OF_DAY, 2);
        date = cal.getTime();
        Kweet kweet4 = new Kweet(3, "User 2 Kweet 1 Hour 2", date, userTwo, null, null);
        cal.set(Calendar.HOUR_OF_DAY, 3);
        date = cal.getTime();
        Kweet kweet5 = new Kweet(4, "User 2 Kweet 2 Hour 3", date, userTwo, null, null);
        cal.set(Calendar.HOUR_OF_DAY, 8);
        date = cal.getTime();
        Kweet kweet6 = new Kweet(5, "User 2 Kweet 3 Hour 8", date, userTwo, null, null);
        //Create Kweets user 3
        cal.set(Calendar.HOUR_OF_DAY, 4);
        date = cal.getTime();
        Kweet kweet7 = new Kweet(6, "User 3 Kweet 1 Hour 4", date, userThree, null, null);
        cal.set(Calendar.HOUR_OF_DAY, 5);
        date = cal.getTime();
        Kweet kweet8 = new Kweet(7, "User 3 Kweet 2 Hour 5", date, userThree, null, null);
        cal.set(Calendar.HOUR_OF_DAY, 13);
        date = cal.getTime();
        Kweet kweet9 = new Kweet(8, "User 3 Kweet 3 Hour 13", date, userThree, null, null);

        // Add users to follows
        testUser.addFollows(userOne);
        testUser.addFollows(userTwo);
        testUser.addFollows(userThree);

        // Sorted timeline
        List<Kweet> sortedTimeline  = new ArrayList<Kweet>();
        sortedTimeline.addAll(Arrays.asList(kweet9, kweet3, kweet6, kweet2, kweet8, kweet7,kweet5,kweet4,kweet1));

        List<Kweet> timeline =  testUser.getTimeLine(20);
        assertEquals(sortedTimeline, timeline);
    }
}