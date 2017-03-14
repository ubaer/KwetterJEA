package dao;

import junit.framework.TestCase;
import main.java.dao.TagCollection;
import main.java.dao.TagDao;
import main.java.domain.Tag;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin
 */
public class TagCollectionTest extends TestCase {

    TagDao tagDao = new TagCollection();

    Tag tag1;
    Tag tag2;
    Tag tag3;
    Tag tag4;
    Tag tag5;

    public void setUp() throws Exception {
        super.setUp();

        tag1 = new Tag("Tag1");
        tag2 = new Tag("Tag2");
        tag3 = new Tag("Tag3");
        tag4 = new Tag("Tag4");
        tag5 = new Tag("Tag5");
    }
    public void testAddTag() throws Exception {
        assertEquals(0, tagDao.getAllTags().size());

        tagDao.addTag(tag1);

        assertEquals(1, tagDao.getAllTags().size());
    }

    public void testRemoveTag() throws Exception {
        tagDao.addTag(tag1);
        tagDao.addTag(tag2);
        tagDao.addTag(tag3);
        assertEquals(3, tagDao.getAllTags().size());
        assertTrue(tagDao.getAllTags().contains(tag1));

        tagDao.removeTag(tag1);

        assertEquals(2, tagDao.getAllTags().size());
        assertFalse(tagDao.getAllTags().contains(tag1));

    }

    public void testGetAllTags() throws Exception {
        tagDao.addTag(tag1);
        tagDao.addTag(tag2);
        tagDao.addTag(tag3);
        tagDao.addTag(tag4);
        tagDao.addTag(tag5);
        ArrayList<Tag> allTags = new ArrayList<>();
        allTags.addAll(Arrays.asList(tag1, tag2, tag3, tag4, tag5));

        ArrayList foundTags = tagDao.getAllTags();

        assertEquals(allTags, foundTags);
    }
}