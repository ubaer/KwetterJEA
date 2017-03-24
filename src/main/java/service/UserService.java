package main.java.service;

import main.java.dao.JPA;
import main.java.dao.UserDao;
import main.java.domain.User;

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

    public void addFollows(User currentUser, User toFollow) {
        userDao.addFollows(currentUser, toFollow);
    }
}
