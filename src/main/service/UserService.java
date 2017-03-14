package main.service;

import main.dao.UserDao;
import main.domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by Kevin.
 */
@Stateless
public class UserService {
    @Inject
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
