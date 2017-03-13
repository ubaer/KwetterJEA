package main.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kevin
 */
public class Kweet {

    public long getId() {
        return id;
    }

    long id;

    public String getMessage() {
        return message;
    }

    String message;

    public Date getDate() {
        return date;
    }

    Date date;

    public User getPoster() {
        return poster;
    }

    User poster;
    ArrayList<User>mentions;
    ArrayList<User>lovers;
    ArrayList<Tag>tags;

    public Kweet(long id, String message, Date date, User poster, ArrayList<Tag> tags, ArrayList<User> mentions) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.poster = poster;
        this.tags = tags;
        this.mentions = mentions;
        this.lovers = new ArrayList<User>();

        if(tags == null){
            this.tags = new ArrayList<Tag>();
        }

        if(mentions == null){
            this.mentions = new ArrayList<User>();
        }

        for (Tag tag : this.tags) {
                tag.addKweet(this);
        }

        poster.addKweet(this);
    }

    public void addLover(User user){
        if(!lovers.contains(user)){
            lovers.add(user);
        }
    }

    public void removeLover(User user){
        if(lovers.contains(user)){
            lovers.remove(user);
        }
    }

    public ArrayList<User> getLovers(){
        return lovers;
    }

    public void addMentions(ArrayList<User> users){
        if(mentions == null){
            mentions = new ArrayList<User>();
        }
        mentions.addAll(users);
    }

    public ArrayList<User> getMentions(){
        return mentions;
    }

    public void addTags(ArrayList<Tag> tags){
        this.tags.addAll(tags);

        for (Tag tag : tags) {
            tag.addKweet(this);
        }
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
        tag.addKweet(this);
    }

    public ArrayList<Tag> getTags(){
        return tags;
    }
}
