package main.dao;

import main.domain.Kweet;
import main.domain.Tag;

import java.util.ArrayList;

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
     * Gets all the tags known to the dao layer
     * @return ArrayList of all the tags
     */
    ArrayList<Tag> getAllTags();

    /**
     * Gets all the Kweets linked to the tag
     * @param tag
     * @return
     */
    ArrayList<Kweet> getAllKweetsByTag(Tag tag);
}
