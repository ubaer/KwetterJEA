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

    public void addTag(Tag tag){
        tagDao.addTag(tag);
    }

    public void removeTag(Tag tag){
        tagDao.removeTag(tag);
    }

    public ArrayList<Tag> getAllTags(){
        return tagDao.getAllTags();
    }

    public List<Kweet> getAllKweetsByTag(Tag tag){
        return tagDao.getAllKweetsByTag(tag);
    }

    public Tag getTagByName(String tagName){ return tagDao.getTagByName(tagName);
    }
}
