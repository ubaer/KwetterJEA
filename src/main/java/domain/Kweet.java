package main.java.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kevin
 */
@Entity
public class Kweet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String message;

    Date date;

    public void setId(long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public void setMentions(List<User> mentions) {
        this.mentions = mentions;
    }

    public void setLovers(List<User> lovers) {
        this.lovers = lovers;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @ManyToOne
    User poster;

    public String getMessage() {
        return message;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public User getPoster() {
        return poster;
    }

    @ManyToMany
    List<User> mentions;
    @ManyToMany
    List<User> lovers;
    @ManyToMany
    List<Tag> tags;

    public Kweet(User poster, String message, ArrayList<Tag> tags, ArrayList<User> mentions) {
        this.message = message;
        this.poster = poster;
        this.date = new Date();
        this.tags = tags;
        this.mentions = mentions;
        this.lovers = new ArrayList<>();

        if (tags == null) {
            this.tags = new ArrayList<>();
        }

        if (mentions == null) {
            this.mentions = new ArrayList<>();
        }

        for (Tag tag : this.tags) {
            tag.addKweet(this);
        }

        poster.addKweet(this);
    }

    public Kweet(long id, String message, Date date, User poster, ArrayList<Tag> tags, ArrayList<User> mentions) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.poster = poster;
        this.tags = tags;
        this.mentions = mentions;
        this.lovers = new ArrayList<>();

        if (tags == null) {
            this.tags = new ArrayList<>();
        }

        if (mentions == null) {
            this.mentions = new ArrayList<>();
        }

        for (Tag tag : this.tags) {
            tag.addKweet(this);
        }

        poster.addKweet(this);
    }

    public Kweet() {
    }

    public void addLover(User user) {
        if (!lovers.contains(user)) {
            lovers.add(user);
        }
    }

    public void removeLover(User user) {
        if (lovers.contains(user)) {
            lovers.remove(user);
        }
    }

    public List<User> getLovers() {
        return lovers;
    }

    public void addMentions(ArrayList<User> users) {
        if (mentions == null) {
            mentions = new ArrayList<>();
        }
        mentions.addAll(users);
    }

    public List<User> getMentions() {
        return mentions;
    }

    public void addTags(ArrayList<Tag> tags) {
        this.tags.addAll(tags);

        for (Tag tag : tags) {
            tag.addKweet(this);
        }
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.addKweet(this);
    }

    public List<Tag> getTags() {
        return tags;
    }
}
