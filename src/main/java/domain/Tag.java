package main.java.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin
 */
@Entity
public class Tag {

    public void setName(String name) {
        this.name = name;
    }

    public void setKweets(List<Kweet> kweets) {
        this.kweets = kweets;
    }

    @Id
    String name;
    @OneToMany
    List<Kweet> kweets;

    public String getName() {
        return name;
    }

    public Tag(){}

    public Tag(String name) {
        this.name = name;
        kweets = new ArrayList<>();
    }

    public void addKweet(Kweet kweet){
        kweets.add(kweet);
    }

    public void removeKweet(Kweet kweet){
        if(kweets.contains(kweet)){
            kweets.remove(kweet);
        }
    }

    public List<Kweet> getKweets(){
        return kweets;
    }
}
