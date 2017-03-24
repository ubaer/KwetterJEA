package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.User;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kevin.
 */


@Stateless @JPA
public class KweetJPA implements KweetDao {

    @PersistenceContext(unitName = "KwetterPU")
    private EntityManager em;

    @Override
    public void addKweet(Kweet kweet) {
        em.persist(kweet);
    }

    @Override
    public void removeKweet(Kweet kweet) {
        em.remove(em.merge(kweet));
    }

    @Override
    public Kweet findById(long id) {
        return (Kweet) em.createQuery("SELECT k FROM Kweet k where k.id = :value1")
                .setParameter("value1", id).getSingleResult();
    }

    @Override
    public ArrayList<Kweet> getAllKweets() {
        ArrayList<Kweet> kweets = new ArrayList<>();
        kweets.addAll(em.createQuery("SELECT k FROM Kweet k").getResultList());
        return kweets;
    }

    @Override
    public ArrayList<Kweet> getAllKweetsByUser(User user) {
        ArrayList<Kweet> kweets = new ArrayList<>();
        List<Kweet> result = (List<Kweet>) em.createQuery("SELECT k FROM Kweet k where k.posterId = :value1")
                .setParameter("value1", user.getId()).getResultList();
        kweets.addAll(result);
        return kweets;
    }

    @Override
    public void addMention(Kweet kweet, User mention) {
        Kweet foundKweet = findById(kweet.getId());
        foundKweet.addMention(mention);
        em.merge(foundKweet);
    }

}
