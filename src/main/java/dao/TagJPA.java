package main.java.dao;

import main.java.domain.Kweet;
import main.java.domain.Tag;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin
 */
@Stateless @JPA
public class TagJPA implements TagDao {
    @PersistenceContext(unitName = "KwetterPU")
    private EntityManager em;

    @Override
    public void addTag(Tag tag) {
        List<Tag> results = em.createQuery("SELECT t FROM Tag t where t.name = :value1")
                .setParameter("value1", tag.getName()).getResultList();
        if(results.size() == 0){
            em.persist(tag);
        }
        em.persist(tag);
    }

    @Override
    public void removeTag(Tag tag) {
        em.remove(tag);
    }

    @Override
    public Tag getTagByName(String name) {
        return em.find(Tag.class, name);
    }

    @Override
    public ArrayList<Tag> getAllTags() {
        ArrayList results = new ArrayList();
        results.addAll(em.createQuery("select t from Tag t").getResultList());
        return results;
    }

    @Override
    public List<Kweet> getAllKweetsByTag(Tag tag) {
        ArrayList<Kweet> results = new ArrayList();
        results.addAll(em.createQuery("select t.kweets from Tag t where t.name = :value1")
                .setParameter("value1", tag.getName()).getResultList());
        return results;
    }
}
