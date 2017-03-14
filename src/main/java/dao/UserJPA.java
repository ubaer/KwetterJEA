package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin
 */

@Stateless @JPA
public class UserJPA implements UserDao{

    @PersistenceContext(unitName = "KwetterPU")
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void removeUser(User user) {
        em.remove(user);
    }

    @Override
    public boolean changeUsername(User user, String newName) {
        user.setName(newName);
        em.merge(user);
        return true;
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByName(String name) {
        return em.find(User.class, name);
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.addAll(em.createQuery("select u from User u").getResultList());
        return users;
    }

    @Override
    public List<Kweet> getUserTimeline(User user, int amountOfPosts) {
        return null;
    }

    @Override
    public List<Kweet> getUserRecentKweets(User user, int amountOfPosts) {
        return null;
    }
}
