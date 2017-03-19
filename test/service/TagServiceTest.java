package service;

import junit.framework.TestCase;
import main.java.domain.Tag;
import main.java.service.TagService;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin on 14-3-2017.
 */
public class TagServiceTest extends TestCase {

    @Inject
    TagService tagService;

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
        assertEquals(0, tagService.getAllTags().size());

        tagService.addTag(tag1);

        assertEquals(1, tagService.getAllTags().size());
    }

    public void testRemoveTag() throws Exception {
        tagService.addTag(tag1);
        tagService.addTag(tag2);
        tagService.addTag(tag3);
        assertEquals(3, tagService.getAllTags().size());
        assertTrue(tagService.getAllTags().contains(tag1));

        tagService.removeTag(tag1);

        assertEquals(2, tagService.getAllTags().size());
        assertFalse(tagService.getAllTags().contains(tag1));
    }

    public void testGetAllTags() throws Exception {
        tagService.addTag(tag1);
        tagService.addTag(tag2);
        tagService.addTag(tag3);
        tagService.addTag(tag4);
        tagService.addTag(tag5);
        ArrayList<Tag> allTags = new ArrayList<>();
        allTags.addAll(Arrays.asList(tag1, tag2, tag3, tag4, tag5));

        ArrayList foundTags = tagService.getAllTags();

        assertEquals(allTags, foundTags);
    }
}