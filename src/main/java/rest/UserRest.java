package main.java.rest;

import main.java.domain.User;
import main.java.service.UserService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by Kevin.
 */
@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class UserRest {
    @Inject
    UserService userService;

    @GET
    public ArrayList<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GET
    @Path("id/{id}")
    public User getUserById(@PathParam("id")long id){
        return userService.findById(id);
    }

    @GET
    @Path("{name}")
    public User getUserByName(@PathParam("name")String name){
        return userService.findByName(name);
    }

    @POST
    @Path("post/{username}/{newUsername}")
    public void changeUsername(@PathParam("username")String username, @PathParam("newUsername") String newUsername){
        User currentUser = userService.findByName(username);
        userService.changeUsername(currentUser, newUsername);
    }
    @POST
    @Path("post/createuser/{username}")
    public void createUser(@PathParam("username")String username){
        User newUser = new User(username);
        userService.addUser(newUser);
    }

}
