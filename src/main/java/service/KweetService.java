package main.java.service;

import main.java.dao.JPA;
import main.java.dao.KweetDao;
import main.java.domain.Kweet;
import main.java.domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by Kevin.
 */
@Stateless
public class KweetService {

    @Inject
    @Default
    private KweetDao kweetDao;

    public KweetService() {
    }

    public void addKweet(Kweet kweet){
        kweetDao.addKweet(kweet);
    }
    public void removeKweet(Kweet kweet){
        kweetDao.removeKweet(kweet);
    }
    public Kweet findKweetById(long id){
        return kweetDao.findById(id);
    }
    public ArrayList<Kweet> getAllKweets(){
        return kweetDao.getAllKweets();
    }
    public ArrayList<Kweet> getAllKweetsByUser(User user){
        return kweetDao.getAllKweetsByUser(user);
    }
}
