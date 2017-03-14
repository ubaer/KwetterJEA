package main.java.rest;

import main.java.domain.Kweet;
import main.java.domain.User;
import main.java.service.KweetService;
import main.java.service.TagService;
import main.java.service.UserService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.
 */
@Path("kweet")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class KweetRest {

    @Inject
    KweetService kweetService;

    @Inject
    UserService userService;

    @Inject
    TagService tagService;

    public KweetRest() {
    }

    @GET
    public ArrayList<Kweet> getAllKweets(){
        return kweetService.getAllKweets();
    }

    @GET
    @Path("{username}/all")
    public ArrayList<Kweet> getAllKweetsByUser(@PathParam("username")String username){
        User user = userService.findByName(username);
        return kweetService.getAllKweetsByUser(user);
    }

    @GET
    @Path("{id}")
    public Kweet getKweet(@PathParam("id") long id){
        return kweetService.findKweetById(id);
    }

    @GET
    @Path("{username}/timeLine/{amountOfTweets}")
    public List<Kweet> getUserTimeline(@PathParam("username") String username, @PathParam("amountOfTweets") int amountOfTweets) {
        User currentUser = userService.findByName(username);
        return currentUser.getTimeLine(amountOfTweets);
    }

    @GET
    @Path("{username}/recent/{amountOfTweets}")
    public List<Kweet> getUserRecentKweets(@PathParam("username")String username, @PathParam("amountOfTweets") int amountOfTweets){
        User currentUser = userService.findByName(username);
        return currentUser.getRecentKweets(amountOfTweets);
    }

    @POST
    @Path("post/{username}/{message}")
    public void addKweet(@PathParam("username") String username, @PathParam("message") String message){
        User user = userService.findByName(username);
        Kweet newKweet = new Kweet(user, message, null, null);
        kweetService.addKweet(newKweet);
    }

    @POST
    @Path("delete/{id}")
    public void deleteKweet( @PathParam("id") long id){
        Kweet deleteKweet = kweetService.findKweetById(id);
        kweetService.removeKweet(deleteKweet);
    }
}
