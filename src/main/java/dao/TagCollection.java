package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.Tag;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kevin
 */
@Stateless @Default
public class TagCollection implements TagDao {

    public TagCollection() {
    }

    ArrayList<Tag> tags = new ArrayList<>();

    @Override
    public void addTag(Tag tag) {
        Optional<Tag> foundTag = tags.stream().filter(x -> x.getName().equals(tag.getName())).findFirst();
        if(!foundTag.isPresent()){
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
    public Tag getTagByName(String name) {
        Optional<Tag> foundTag = tags.stream().filter(tag -> tag.getName().equals(name)).findFirst();
        Tag returnTag = null;
        if(foundTag.isPresent()){
            returnTag = foundTag.get();
        }

        return returnTag;
    }

    @Override
    public ArrayList<Tag> getAllTags() {
        return tags;
    }

    @Override
    public List<Kweet> getAllKweetsByTag(Tag tag) {
        List<Kweet> returnList = new ArrayList();
        if(tags.contains(tag)){
            returnList = tag.getKweets();
        }
        return returnList;
    }
}
