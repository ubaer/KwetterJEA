package main.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kevin
 */
public class Tag {
    String name;
    ArrayList<Kweet>kweets;

    public Tag(String name) {
        this.name = name;
        kweets = new ArrayList<Kweet>();
    }

    public void addKweet(Kweet kweet){
        kweets.add(kweet);
    }

    public void removeKweet(Kweet kweet){
        if(kweets.contains(kweet)){
            kweets.remove(kweet);
        }
    }

    public ArrayList<Kweet> getKweets(){
        return kweets;
    }
}
