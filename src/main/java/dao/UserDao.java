package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.User;
import main.java.domain.UserGroup;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Gets the users timeline
     * @return List of all the Kweets
     */
    List<Kweet> getUserTimeline(User user, int amountOfPosts);

    /**
     * Gets the users recent Kweets
     * @return List of all the Kweets
     */
    List<Kweet> getUserRecentKweets(User user, int amountOfPosts);

    /**
     * Adds a follow to the currentuser
     * @param currentUser
     * @param toFollow
     */
    void addFollows(User currentUser, User toFollow);

    /**
     * Creates a usergroup role
     * @param role
     */
    void createUserGroup(UserGroup role);

    /**
     * Adds user to a group
     * @param user
     * @param role
     */
    void addUserToGroup(User user, UserGroup role);

    /**
     * Finds a usergroup by its name
     * @param userGroupName
     * @return
     */
    UserGroup findUserGroup(String userGroupName);

    /**
     * Adds a follower to the currentuser
     * @param currentUser
     * @param follower
     */
    void addFollower(User currentUser, User follower);
}
