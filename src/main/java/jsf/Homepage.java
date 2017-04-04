package main.java.jsf;

import main.java.domain.Kweet;
import main.java.domain.Tag;
import main.java.domain.User;
import main.java.service.KweetService;
import main.java.service.TagService;
import main.java.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kevin on 2-4-2017.
 */
@ManagedBean
@SessionScoped
public class Homepage implements Serializable {
    @Inject
    UserService userService;

    @Inject
    TagService tagService;

    @Inject
    KweetService kweetService;

    User loggedInUser;

    public String getKweetText() {
        return kweetText;
    }

    public void setKweetText(String kweetText) {
        this.kweetText = kweetText;
    }

    String kweetText;
    public Homepage(){}

    @PostConstruct
    public void getLoggedInUser(){
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        loggedInUser = userService.findByName(username);
        System.out.println("logged in user is: " + loggedInUser.getUserName());
    }

    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        System.out.println("logout pressed");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "logout.xhtml");
    }

    public List<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    public void postKweet(){
        Kweet newKweet = new Kweet(loggedInUser, kweetText);
        kweetService.addKweet(newKweet);
        try {
            logout(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "index.xhtml");
    }
}
