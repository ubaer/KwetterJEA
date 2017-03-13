package main.dao;

import main.domain.User;

import java.util.ArrayList;

/**
 * Created by Kevin
 */
public interface UserDao {
    /**
     * Add a user to the dao
     * @param user
     */
    void addUser(User user);

    /**
     * Remove a user from the dao
     * @param user
     */
    void removeUser(User user);

    /**
     * Change the users Username
     * @param user
     * @param newName
     * @return true if name is changed, false if the username is already taken.
     */
    boolean changeUsername(User user, String newName);

    /**
     * Finds a user by its id
     * @param id
     * @return The user object with the corresponding id
     */
    User findById(long id);

    /**
     * Fiunds a user by its name
     * @param name
     * @return The user object with the corresponding name
     */
    User findByName(String name );

    /**
     * Gets all users known to the dao layer
     * @return ArrayList of all the users
     */
    ArrayList<User> getAllUsers();
}
