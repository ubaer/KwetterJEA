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
import java.lang.reflect.Array;
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
    public List<Kweet> getAllKweets(){
        ArrayList<Kweet> allKweets = kweetService.getAllKweets();
        System.out.println("Alle kweets aantal:" + allKweets.size());
        return allKweets;
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
    @Path("{username}/{message}")
    public Kweet addKweet(@PathParam("username") String username, @PathParam("message") String message){
        User user = userService.findByName(username);
        Kweet newKweet = new Kweet(user, message);
        kweetService.addKweet(newKweet);
        return newKweet;
    }

    @DELETE
    @Path("{id}")
    public void deleteKweet( @PathParam("id") long id){
        Kweet deleteKweet = kweetService.findKweetById(id);
        kweetService.removeKweet(deleteKweet);
    }

    @POST
    @Path("{id}/mention/{username}")
    public void addMention(@PathParam("id") long id, @ PathParam("username") String username){
        Kweet foundKweet  = kweetService.findKweetById(id);
        User foundUser = userService.findByName(username);
        kweetService.addMention(foundKweet, foundUser);
    }
}
