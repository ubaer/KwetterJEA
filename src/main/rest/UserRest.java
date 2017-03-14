package main.rest;

import main.domain.Kweet;
import main.domain.User;
import main.service.KweetService;
import main.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

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
}
