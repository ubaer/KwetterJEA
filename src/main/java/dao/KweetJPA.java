package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.User;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
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
        return null;
    }

    @Override
    public ArrayList<Kweet> getAllKweets() {
        Query query = em.createQuery("SELECT kweet FROM Kweet kweet", Kweet.class);
        return (ArrayList<Kweet>) query.getResultList();
    }

    @Override
    public ArrayList<Kweet> getAllKweetsByUser(User user) {
        final List<Kweet> results = em
                .createNativeQuery(
                        "SELECT k.Kweet FROM Kweet k where k.Poster = ?1")
                .setParameter(1, user).getResultList();
        ArrayList kweets = new ArrayList();
        kweets.addAll(results);
        return kweets;
    }
}
