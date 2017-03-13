package main.dao;

import main.domain.User;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Kevin on 13-3-2017.
 */
public class UserCollection implements UserDao {
    ArrayList<User> users = new ArrayList<User>();

    public void addUser(User user) {
        if(!users.contains(user)) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        if(users.contains(user)){
            users.remove(user);
        }
    }

    public boolean changeUsername(User user, String newName) {
        if(users.contains(user)){
            // First check if username is not taken yet.
            Optional<User> foundUser = users.stream().filter(x -> x.getName() == newName).findFirst();
            if(!foundUser.isPresent()){
                // Username is not taken, change the users username.
                users.stream()
                        .filter(x -> x.getId() == user.getId()).findFirst().get().setName(newName);
                return true;
            }
        }
        return false;
    }

    public User findById(long id) {
        Optional<User> foundUser = users.stream().filter(user -> user.getId() == id).findFirst();
        User returnUser = null;
        if(foundUser.isPresent()){
            returnUser = foundUser.get();
        }

        return returnUser;
    }

    public User findByName(String name) {
        Optional<User> foundUser = users.stream().filter(user -> user.getName().equals(name)).findFirst();
        User returnUser = null;
        if(foundUser.isPresent()){
            returnUser = foundUser.get();
        }

        return returnUser;
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }
}

