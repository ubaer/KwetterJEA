package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.
 */
public interface TagDao {
    /**
     * Adds a tag to the dao
     * @param tag
     */
    void addTag(Tag tag);

    /**
     * Removes a tag from the dao
     * @param tag
     */
    void removeTag(Tag tag);

    /**
     * Gets a tag by its name
     * @param name
     * @return the requested tag
     */
    Tag getTagByName(String name);

    /**
     * Gets all the tags known to the dao layer
     * @return ArrayList of all the tags
     */
    ArrayList<Tag> getAllTags();

    /**
     * Gets all the Kweets linked to the tag
     * @param tag
     * @return
     */
    List<Kweet> getAllKweetsByTag(Tag tag);
}
