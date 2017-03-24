package main.java.service;

import main.java.dao.JPA;
import main.java.dao.TagDao;
import main.java.domain.Kweet;
import main.java.domain.Tag;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.
 */
@Stateless
public class TagService {

    public TagService(){
    }

    @Inject
    @JPA
    private TagDao tagDao;

    /**
     * Add a tag
     * @param tag
     */
    public void addTag(Tag tag){
        tagDao.addTag(tag);
    }

    /**
     * Removes a tag
     * @param tag
     */
    public void removeTag(Tag tag){
        tagDao.removeTag(tag);
    }

    /**
     * Gets all known tags
     * @return list of all known tags
     */
    public ArrayList<Tag> getAllTags(){
        return tagDao.getAllTags();
    }

    /**
     * Gets all Kweets that are tagged with the specific tag
     * @param tag
     * @return list of all Kweets with the tag
     */
    public List<Kweet> getAllKweetsByTag(Tag tag){
        return tagDao.getAllKweetsByTag(tag);
    }

    /**
     * Gets a tag object by name
     * @param tagName
     * @return corresponding tag object.
     */
    public Tag getTagByName(String tagName){ return tagDao.getTagByName(tagName);
    }
}
