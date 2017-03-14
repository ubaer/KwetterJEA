package main.service;

import main.dao.KweetDao;
import main.domain.Kweet;
import main.domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by Kevin.
 */
@Stateless
public class KweetService {
    @Inject
    private KweetDao kweetDao;

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
