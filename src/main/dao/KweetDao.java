package main.dao;

import main.domain.Kweet;
import main.domain.User;

import java.util.ArrayList;

/**
 * Created by Kevin.
 */
public interface KweetDao {
    /**
     * Adds a Kweet to the dao
     * @param kweet
     */
    void addKweet(Kweet kweet);

    /**
     * Removes a Kweet from the dao
     * @param kweet
     */
    void removeKweet(Kweet kweet);

    /**
     * Finds a Kweet by its id
     * @param id
     * @return The kweet object with the corresponding id
     */
    Kweet findById(long id);

    /**
     * Gets all Kweets known to the dao layer
     * @return ArrayList with all the Kweets
     */
    ArrayList<Kweet> getAllKweets();

    /**
     * Gets all the Kweets from a user
     * @param user
     * @return ArrayList of all the Kweets from a user
     */
    ArrayList<Kweet> getAllKweetsByUser(User user);
}
