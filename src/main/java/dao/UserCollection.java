package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kevin
 */
@Stateless @Default
public class UserCollection implements UserDao {
    ArrayList<User> users = new ArrayList<User>();

    public UserCollection() {
    }

    @Override
    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    @Override
    public void removeUser(User user) {
        if(users.contains(user)){
            users.remove(user);
        }
    }

    @Override
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

    @Override
    public User findById(long id) {
        Optional<User> foundUser = users.stream().filter(user -> user.getId() == id).findFirst();
        User returnUser = null;
        if(foundUser.isPresent()){
            returnUser = foundUser.get();
        }

        return returnUser;
    }

    @Override
    public User findByName(String name) {
        Optional<User> foundUser = users.stream().filter(user -> user.getName().equals(name)).findFirst();
        User returnUser = null;
        if(foundUser.isPresent()){
            returnUser = foundUser.get();
        }

        return returnUser;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return users;
    }

    @Override
    public List<Kweet> getUserTimeline(User user, int amountOfPosts) {
        return user.getTimeLine(amountOfPosts);
    }

    @Override
    public List<Kweet> getUserRecentKweets(User user, int amountOfPosts){
        return user.getRecentKweets(amountOfPosts);
    }

    @Override
    public void addFollows(User currentUser, User toFollow) {
        //todo
    }
}

