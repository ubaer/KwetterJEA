package service;

import junit.framework.TestCase;
import main.java.domain.Tag;
import main.java.service.TagService;
import org.mockito.Mockito;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin on 14-3-2017.
 */
public class TagServiceTest extends TestCase {

    TagService tagService = Mockito.mock(TagService.class);

    public void setUp() throws Exception {

    }


    public void testGetTagByName() throws Exception{
        Tag testTag = new Tag("testTag");
        Mockito.when(tagService.getTagByName("testTag")).thenReturn(testTag);

        Tag foundTag = tagService.getTagByName("testTag");
        assertEquals(testTag, foundTag);
        assertEquals("testTag", foundTag.getName());
    }

    public void testGetAllTags() throws Exception {
        Tag testTag1 = new Tag("testTag1");
        Tag testTag2 = new Tag("testTag2");
        Tag testTag3 = new Tag("testTag3");
        Tag testTag4 = new Tag("testTag4");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.addAll(Arrays.asList(testTag1,testTag2,testTag3,testTag4));

        Mockito.when(tagService.getAllTags()).thenReturn(tags);

        ArrayList<Tag> foundTags =  tagService.getAllTags();

        assertEquals(tags, foundTags);

    }
}