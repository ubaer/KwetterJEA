package domain;

import junit.framework.TestCase;
import main.domain.Kweet;
import main.domain.Tag;
import main.domain.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kevin.
 */
public class TagTest extends TestCase {
    User newUser;
    public void setUp() throws Exception {
        newUser = new User(0, "profilePicute.png","Peter Appel","biografie van deze persoon","Wereldstad","www.tvj.com");
    }

    public void tearDown() throws Exception {

    }

    public void testAddKweet() throws Exception{
        Tag tag = new Tag("Nieuwe Tag");
        Kweet newKweet = new Kweet(5, "newKweet", new Date(), newUser, null, null);
        newKweet.addTag(tag);

        assertEquals(tag.getKweets().get(0), newKweet);
    }

    public void testRemoveKweet() throws Exception{
        Tag tag = new Tag("Nieuwe Tag");
        Kweet newKweet = new Kweet(5, "newKweet", new Date(), newUser, null, null);
        newKweet.addTag(tag);

        assertEquals(tag.getKweets().get(0), newKweet);

        tag.removeKweet(newKweet);

        assertEquals(tag.getKweets().size(), 0);
    }
}
