package main.java.jsf;

import main.java.domain.User;
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

    User loggedInUser;

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
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/logout.xhtml");
    }
}
