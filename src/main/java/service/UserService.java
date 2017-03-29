package main.java.service;

import main.java.dao.JPA;
import main.java.dao.UserDao;
import main.java.domain.User;
import main.java.domain.UserGroup;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by Kevin.
 */
@Stateless
public class UserService {

    public UserService(){
    }

    @Inject
    @JPA
    private UserDao userDao;

    /**
     * Adds a user
     * @param user
     */
    public void addUser(User user){
        userDao.addUser(user);
    }

    /**
     * Removes a user
     * @param user
     */
    public void removeUser(User user){
        userDao.removeUser(user);
    }

    /**
     * Changes the user username
     * @param user
     * @param newUsername new requested username
     * @return if the namechange is succesful
     */
    public boolean changeUsername(User user, String newUsername){
        return userDao.changeUsername(user, newUsername);
    }

    /**
     * Finds a user by its id
     * @param id
     * @return the found user, null if user not found.
     */
    public User findById(long id){
        return userDao.findById(id);
    }

    /**
     * Finds a user by name
     * @param name
     * @return the found user, null if user not found
     */
    public User findByName(String name){
        return userDao.findByName(name);
    }

    /**
     * Gets a list of all the users
     * @return List of all users
     */
    public ArrayList<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    /**
     * Adds a follows to the user
     * @param currentUser
     * @param toFollow
     */
    public void addFollows(User currentUser, User toFollow) {
        userDao.addFollows(currentUser, toFollow);
    }

    /**
     * Adds a Usergroup to the user
     * @param user
     * @param role
     */
    public void addUserToGroup(User user, UserGroup role) { userDao.addUserToGroup(user, role);
    }

    /**
     * Finds a UserGroup by name
     * @param userGroupName
     * @return
     */
    public UserGroup findUserGroup(String userGroupName){
       return userDao.findUserGroup(userGroupName);
    }

    /**
     * Creates a new Usergroup
     * @param role
     */
    public void createUserGroup(UserGroup role) {
        userDao.createUserGroup(role);
    }

    public void addFollower(User currentUser, User follower){
        userDao.addFollower(currentUser, follower);
    }
}
