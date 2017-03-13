package main.dao;

import main.domain.Kweet;
import main.domain.Tag;

import java.util.ArrayList;

/**
 * Created by Kevin on
 */
public class TagCollection implements TagDao {

    ArrayList<Tag> tags = new ArrayList<>();

    @Override
    public void addTag(Tag tag) {
        if(!tags.contains(tag)){
            tags.add(tag);
        }
    }

    @Override
    public void removeTag(Tag tag) {
        if(tags.contains(tag)){
            tags.remove(tag);
        }
    }

    @Override
    public ArrayList<Tag> getAllTags() {
        return tags;
    }

    @Override
    public ArrayList<Kweet> getAllKweetsByTag(Tag tag) {
        ArrayList<Kweet> returnList = new ArrayList();
        if(tags.contains(tag)){
            returnList = tag.getKweets();
        }
        return returnList;
    }
}
