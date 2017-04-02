package main.java.jsf;

import main.java.domain.Kweet;
import main.java.domain.User;
import main.java.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.
 */
@ManagedBean
@SessionScoped
public class Profile implements Serializable {

    @Inject
    UserService userService;

    private User loggedInUser;

    public Profile(){

    }

    @PostConstruct
    public void getLoggedInUser(){
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        loggedInUser = userService.findByName(username);
        System.out.println("logged in user is: " + loggedInUser.getUserName());
    }

    public String getUserName(){
        return loggedInUser.getUserName();
    }

    public String getUserBio(){
        return loggedInUser.getBio();
    }

    public String getUserLocation(){
        return loggedInUser.getLocations();
    }

    public String getUserPicture(){
        return loggedInUser.getProfilePicture();
    }

    public List<Kweet> getUserKweets(){
        return loggedInUser.getKweets();
    }

    public List<User> getUserFollows(){
        return loggedInUser.getFollows();
    }

    public List<User> getUserFollowers(){
        return loggedInUser.getFollowers();
    }
    public List<Kweet> getUserTimeline(){
        return loggedInUser.getTimeLine(10);
    }
    public User getUserById(long id){
        return userService.findById(id);
    }
}
