package domain;

import junit.framework.TestCase;
import main.java.domain.Kweet;
import main.java.domain.Tag;
import main.java.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Kevin
 */
public class KweetTest extends TestCase  {

    User testUser;

    public void setUp() throws Exception {
        testUser = new User(0, "profilePicute.png","Peter Appel","biografie van deze persoon","Wereldstad","www.tvj.com");
    }

    public void tearDown() throws Exception {

    }

    public void testAddLover() throws Exception {
        Kweet testKweet = new Kweet(0, "Kweet tekst", new Date(), testUser, new ArrayList<>(), null);
        User lover = new User(1, "picute.jpg","Mr Lover", "Loves everything","Adam","www.ashleymadison.com");

        List<User> lovers = testKweet.getLovers();
        assertEquals(lovers.size(), 0);

        testKweet.addLover(lover);

        assertEquals(testKweet.getLovers().get(0), lover);
    }

    public void testRemoveLover() throws Exception {
        Kweet testKweet = new Kweet(0, "Kweet tekst", new Date(), testUser, new ArrayList<>(), null);
        User lover = new User(1, "picute.jpg","Mr Lover", "Loves everything","Adam","www.ashleymadison.com");
        testKweet.addLover(lover);

        assertEquals(testKweet.getLovers().size(), 1);

        testKweet.removeLover(lover);
        assertEquals(testKweet.getLovers().size(), 0);
    }

    public void testAddMentions() throws Exception {
        Kweet testKweet = new Kweet(0, "Kweet tekst", new Date(), testUser, null, null);
        User mention = new User(1, "picture.mpg", "Mimention", "mention boy","Sittard", "www.twitter.nl");

        ArrayList<User> mentions = new ArrayList();
        mentions.add(mention);
        testKweet.addMentions(mentions);

        assertEquals(testKweet.getMentions().get(0), mention);
    }

    public void testAddTags() throws Exception {
        Kweet testKweet = new Kweet(0, "Kweet tekst", new Date(), testUser, new ArrayList<>(), null);

        ArrayList tags = new ArrayList();
        tags.addAll(Arrays.asList(new Tag("firstTag"),new Tag("secondTag")));
        testKweet.addTags(tags);

        assertEquals(tags, testKweet.getTags());
    }

    public void testAddTag() throws Exception {
        Kweet testKweet = new Kweet(0, "Kweet tekst", new Date(), testUser, new ArrayList<>(), null);

        Tag nieuwTag = new Tag("Single tag");
        testKweet.addTag(nieuwTag);

        assertEquals(1, testKweet.getTags().size());
        assertEquals(nieuwTag, testKweet.getTags().get(0));
    }
}