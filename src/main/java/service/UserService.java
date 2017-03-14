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
    @Default
    private UserDao userDao;

    public void addUser(User user){
        userDao.addUser(user);
    }

    public void removeUser(User user){
        userDao.removeUser(user);
    }

    public boolean changeUsername(User user, String newUsername){
        return userDao.changeUsername(user, newUsername);
    }

    public User findById(long id){
        return userDao.findById(id);
    }

    public User findByName(String name){
        return userDao.findByName(name);
    }

    public ArrayList<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}
