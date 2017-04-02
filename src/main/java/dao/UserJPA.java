package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.User;
import main.java.domain.UserGroup;

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
        List<User> results = em.createQuery("SELECT t FROM User t where t.userName = :value1")
                .setParameter("value1", user.getUserName()).getResultList();
        if(results.size() == 0){
            em.persist(user);
        }
    }

    @Override
    public void removeUser(User user) {
        em.remove(user);
    }

    @Override
    public boolean changeUsername(User user, String newName) {
        user.setUserName(newName);
        em.merge(user);
        return true;
    }

    @Override
    public User findById(long id) {
        return (User) em.createQuery("SELECT t FROM User t where t.id = :value1")
                .setParameter("value1", id).getSingleResult();
    }

    @Override
    public User findByName(String name) {
        return (User) em.createQuery("SELECT t FROM User t where t.userName = :value1")
                .setParameter("value1", name).getSingleResult();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.addAll(em.createQuery("select u from User u").getResultList());

        return users;
    }

    @Override
    public List<Kweet> getUserTimeline(User user, int amountOfPosts) {
        return findByName(user.getUserName()).getTimeLine(amountOfPosts);
    }

    @Override
    public List<Kweet> getUserRecentKweets(User user, int amountOfPosts) {
        return findByName(user.getUserName()).getRecentKweets(amountOfPosts);
    }

    @Override
    public void addFollows(User currentUser, User toFollow) {
        currentUser.addFollows(toFollow);
        em.merge(currentUser);
    }

    @Override
    public void createUserGroup(UserGroup role) {
        List<User> results = em.createQuery("SELECT t FROM UserGroup t where t.groupName = :value1")
                .setParameter("value1", role.getGroupName()).getResultList();
        if(results.size() == 0){
            em.persist(role);
        }
    }

    @Override
    public void addUserToGroup(User user, UserGroup role) {
        UserGroup userGroup = findUserGroup(role.getGroupName());
        userGroup.addUser(user);
        em.persist(userGroup);
    }

    @Override
    public UserGroup findUserGroup(String userGroupName) {
        return (UserGroup) em.createQuery("SELECT t FROM UserGroup t where t.groupName = :value1")
                .setParameter("value1", userGroupName).getSingleResult();
    }

    @Override
    public void addFollower(User currentUser, User follower) {
        currentUser.addFollower(follower);
        em.merge(currentUser);
    }
}
