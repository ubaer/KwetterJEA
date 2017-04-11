package main.java.rest;

import main.java.domain.User;
import main.java.domain.UserGroup;
import main.java.service.UserService;

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
    @Path("{username}")
    public User getUserByUsername(@PathParam("username")String name){
        System.out.println(userService.findByName(name).getBio() + "bio enzo");
        return userService.findByName(name);
    }

    @GET
    @Path("{username}/follows")
    public List<User> getUserFollows(@PathParam("username")String username) {
        return userService.findByName(username).getFollows();
    }

    @GET
    @Path("{username}/followers")
    public List<User> getUserFollowers(@PathParam("username")String username) {
        return userService.findByName(username).getFollowers();
    }

    @POST
    @Path("{username}/rename/{newUsername}")
    public void changeUsername(@PathParam("username")String username, @PathParam("newUsername") String newUsername){
        User currentUser = userService.findByName(username);
        userService.changeUsername(currentUser, newUsername);
    }
    @POST
    @Path("{username}")
    public void createUser(@PathParam("username")String username){
        User newUser = new User(username);
        userService.addUser(newUser);
        UserGroup group = userService.findUserGroup("regulars");
        userService.addUserToGroup(newUser, group);
    }
    @POST
    @Path("{username}/follow/{follow}")
    public void followUser(@PathParam("username")String username,@PathParam("follow") String followUsername){
        User currentUser = userService.findByName(username);
        User toFollow = userService.findByName(followUsername);
        userService.addFollows(currentUser, toFollow);
        userService.addFollower(toFollow, currentUser);
    }

    @POST
    @Path("{username}/usergroup/{usergroup}")
    public void addUsergroupToUser(@PathParam("username")String username,@PathParam("usergroup") String usergroup){
        User currentUser = userService.findByName(username);
        UserGroup userGroup = userService.findUserGroup(usergroup);
        userGroup.setGroupName(usergroup);

        userService.addUserToGroup(currentUser, userGroup);
    }

    @DELETE
    @Path("{username}")
    public void deleteUser(@PathParam("username")String username){
        userService.removeUser(userService.findByName(username));
    }
}
