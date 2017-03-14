package main.service;

import main.dao.TagDao;
import main.domain.Kweet;
import main.domain.Tag;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by Kevin.
 */
@Stateless
public class TagService {
    @Inject
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

    public ArrayList<Kweet> getAllKweetsByTag(Tag tag){
        return tagDao.getAllKweetsByTag(tag);
    }

    public Tag getTagByName(String tagName){ return tagDao.getTagByName(tagName);
    }
}
