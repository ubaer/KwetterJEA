package main.dao;

import main.domain.Kweet;
import main.domain.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Kevin
 */
public class KweetCollection implements KweetDao {

    ArrayList<Kweet> kweets = new ArrayList<>();

    @Override
    public void addKweet(Kweet kweet) {
        if(!kweets.contains(kweet)){
            kweets.add(kweet);
        }
    }

    @Override
    public void removeKweet(Kweet kweet) {
        if(kweets.contains(kweet)){
            kweets.remove(kweet);
        }
    }

    @Override
    public Kweet findById(long id) {
        Optional<Kweet> foundKweet = kweets.stream().filter(kweet -> kweet.getId() == id).findFirst();
        Kweet returnKweet = null;
        if(foundKweet.isPresent()){
            returnKweet = foundKweet.get();
        }

        return returnKweet;
    }

    @Override
    public ArrayList<Kweet> getAllKweets() {
        return kweets;
    }

    @Override
    public ArrayList<Kweet> getAllKweetsByUser(User user) {
        ArrayList returnKweets = new ArrayList();
        returnKweets.addAll(kweets.stream().filter(kweet -> kweet.getPoster() == user).collect(Collectors.toList()));

        return returnKweets;
    }
}