package main.java.service;

import main.java.dao.JPA;
import main.java.dao.KweetDao;
import main.java.domain.Kweet;
import main.java.domain.User;
import main.java.interceptor.KweetHashtag;
import main.java.interceptor.KweetHashtagInterceptor;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.ArrayList;

/**
 * Created by Kevin.
 */
@Interceptors(KweetHashtagInterceptor.class)
@Stateless
public class KweetService {
    @Inject
    @JPA
    private KweetDao kweetDao;

    public KweetService() {
    }

    /**
     * Adds a Kweet
     * @param kweet that has to be added
     */
    @KweetHashtag
    public void addKweet(Kweet kweet){
        kweetDao.addKweet(kweet);
    }

    /**
     * Removes a Kweet
     * @param kweet that needs to be removed
     */
    public void removeKweet(Kweet kweet){
        kweetDao.removeKweet(kweet);
    }

    /**
     * Finds a Kweet by its id
     * @param id of the Kweet
     * @return the correct Kweet, null if no corresponding kweet is found
     */
    public Kweet findKweetById(long id){
        return kweetDao.findById(id);
    }

    /**
     * Returns all known kweets
     * @return list of Kweets
     */
    public ArrayList<Kweet> getAllKweets(){
        return kweetDao.getAllKweets();
    }

    /**
     * Gets all kweets from the given user
     * @param user that you want all the kweets from
     * @return List of all the kweets of the user
     */
    public ArrayList<Kweet> getAllKweetsByUser(User user){
        return kweetDao.getAllKweetsByUser(user);
    }

    /**
     * Adds a mention to a kweet
     * @param kweet
     * @param mention user that needs to be mentioned in the kweet
     */
    public void addMention(Kweet kweet, User mention){kweetDao.addMention(kweet, mention);}
}
